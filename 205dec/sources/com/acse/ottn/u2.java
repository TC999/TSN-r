package com.acse.ottn;

import android.accessibilityservice.AccessibilityService;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AppOpsManager;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Binder;
import android.os.Build;
import android.util.Log;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.RequiresApi;
import com.acse.ottn.activity.AcseHelpManager;
import com.acse.ottn.l0;
import java.util.TimerTask;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class u2 {

    /* renamed from: a  reason: collision with root package name */
    public static final String f6655a = "OnePlusUtils";

    /* renamed from: b  reason: collision with root package name */
    public static boolean f6656b;

    /* renamed from: c  reason: collision with root package name */
    public static TimerTask f6657c;

    /* renamed from: d  reason: collision with root package name */
    public static AccessibilityNodeInfo f6658d;

    public static int a() {
        String a4 = h3.a("ro.miui.ui.version.name");
        if (a4 != null) {
            try {
                return Integer.parseInt(a4.substring(1));
            } catch (Exception e4) {
                z1.b(f6655a, "get miui version code error, version : " + a4);
                z1.b(f6655a, Log.getStackTraceString(e4));
                return -1;
            }
        }
        return -1;
    }

    public static void b(Activity activity, int i4) {
        if ("".equals(j0.f5781w)) {
            return;
        }
        Intent intent = new Intent("miui.intent.action.APP_PERM_EDITOR");
        intent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.AppPermissionsEditorActivity");
        intent.putExtra("extra_pkgname", j0.f5781w);
        intent.setFlags(268435456);
        if (a(intent, activity)) {
            activity.startActivityForResult(intent, i4);
        } else {
            z1.b(f6655a, "Intent is not available!");
        }
    }

    public static void c(Activity activity, int i4) {
        if ("".equals(j0.f5781w)) {
            return;
        }
        Intent intent = new Intent("miui.intent.action.APP_PERM_EDITOR");
        intent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.AppPermissionsEditorActivity");
        intent.putExtra("extra_pkgname", j0.f5781w);
        intent.setFlags(268435456);
        if (a(intent, activity)) {
            activity.startActivityForResult(intent, i4);
        } else {
            z1.b(f6655a, "Intent is not available!");
        }
    }

    @SuppressLint({"NewApi"})
    public static void d(AccessibilityService accessibilityService) {
        a(accessibilityService.getRootInActiveWindow());
    }

    @RequiresApi(api = 16)
    public static void e(AccessibilityService accessibilityService) {
        String b4 = h1.c().b();
        z1.a(f6655a, b4);
        f6657c = l0.a().b(q0.a().b(20000), q0.a().b(500), new a(accessibilityService, b4));
    }

    public static boolean a(Context context) {
        if (Build.VERSION.SDK_INT >= 19) {
            return a(context, 24);
        }
        return true;
    }

    @TargetApi(19)
    public static boolean a(Context context, int i4) {
        int i5 = Build.VERSION.SDK_INT;
        if ("".equals(j0.f5781w)) {
            return true;
        }
        if (i5 >= 19) {
            AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService("appops");
            try {
                Class cls = Integer.TYPE;
                return ((Integer) AppOpsManager.class.getDeclaredMethod("checkOp", cls, cls, String.class).invoke(appOpsManager, Integer.valueOf(i4), Integer.valueOf(Binder.getCallingUid()), j0.f5781w)).intValue() == 0;
            } catch (Exception e4) {
                z1.b(f6655a, Log.getStackTraceString(e4));
            }
        } else {
            z1.b(f6655a, "Below API 19 cannot invoke!");
        }
        return false;
    }

    @RequiresApi(api = 16)
    public static void b(AccessibilityService accessibilityService) {
        f6657c = l0.a().b(q0.a().b(10000), q0.a().b(100), new b(accessibilityService, h1.c().b()));
    }

    @RequiresApi(api = 16)
    public static void c(AccessibilityService accessibilityService) {
        AccessibilityNodeInfo g4 = com.acse.ottn.b.d().g(accessibilityService, "\u5141\u8bb8\u663e\u793a\u5728\u5176\u4ed6\u5e94\u7528\u7684\u4e0a\u5c42");
        AccessibilityNodeInfo g5 = com.acse.ottn.b.d().g(accessibilityService, "\u6388\u4e88\u60ac\u6d6e\u7a97\u6743\u9650");
        if (g4 != null) {
            com.acse.ottn.b.d().g(g4);
            com.acse.ottn.b.d().e(accessibilityService);
            if (Build.VERSION.SDK_INT >= 30) {
                com.acse.ottn.b.d().e(accessibilityService);
            }
        } else if (g5 != null) {
            com.acse.ottn.b.d().g(g5);
            com.acse.ottn.b.d().e(accessibilityService);
            if (Build.VERSION.SDK_INT >= 30) {
                com.acse.ottn.b.d().e(accessibilityService);
            }
        }
    }

    public static boolean a(Intent intent, Activity activity) {
        return (intent == null || activity == null || activity.getPackageManager().queryIntentActivities(intent, 65536).size() <= 0) ? false : true;
    }

    public static void a(Activity activity, int i4) {
        if ("".equals(j0.f5781w)) {
            return;
        }
        String str = j0.f5781w;
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", str, null));
        intent.setFlags(268435456);
        if (a(intent, activity)) {
            activity.startActivityForResult(intent, i4);
        } else {
            z1.b(f6655a, "intent is not available!");
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class a implements l0.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AccessibilityService f6659a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f6660b;

        public a(AccessibilityService accessibilityService, String str) {
            this.f6659a = accessibilityService;
            this.f6660b = str;
        }

        @Override // com.acse.ottn.l0.d
        public void a(long j4) {
            Application application;
            try {
                AccessibilityNodeInfo g4 = com.acse.ottn.b.d().g(this.f6659a, this.f6660b);
                if (g4 == null) {
                    if (Build.VERSION.SDK_INT < 24 || (application = AcseHelpManager.mContext) == null) {
                        return;
                    }
                    com.acse.ottn.b.a(this.f6659a, c4.c(application) / 3, ((c4.b(AcseHelpManager.mContext) * 2) / 3) + 300, (c4.c(AcseHelpManager.mContext) / 3) + 100, c4.b(AcseHelpManager.mContext) / 3, 300);
                    return;
                }
                TimerTask timerTask = u2.f6657c;
                if (timerTask != null) {
                    timerTask.cancel();
                    u2.f6657c = null;
                }
                z1.a(u2.f6655a, "\u627e\u5230\u4e86");
                if (g1.a() != null) {
                    g1.a().a("battery_white", true);
                }
                com.acse.ottn.b.d().g(g4);
            } catch (Exception e4) {
                z1.a(u2.f6655a, "e =" + e4.getMessage());
            }
        }

        @Override // com.acse.ottn.l0.d
        public void a() {
            u2.f6657c = null;
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class b implements l0.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AccessibilityService f6661a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f6662b;

        public b(AccessibilityService accessibilityService, String str) {
            this.f6661a = accessibilityService;
            this.f6662b = str;
        }

        @Override // com.acse.ottn.l0.d
        public void a(long j4) {
            try {
                AccessibilityNodeInfo g4 = com.acse.ottn.b.d().g(this.f6661a, "\u540e\u53f0\u5f39\u51fa\u754c\u9762");
                AccessibilityNodeInfo accessibilityNodeInfo = null;
                if (g4 == null) {
                    AccessibilityNodeInfo g5 = com.acse.ottn.b.d().g(this.f6661a, this.f6662b);
                    if (g5 == null || g5.getParent() == null || g5.getParent().getParent() == null || g5.getParent().getParent().getParent() == null) {
                        return;
                    }
                    for (int i4 = 0; i4 < g5.getParent().getParent().getParent().getChildCount(); i4++) {
                        if (g5.getParent().getParent().getParent().getChild(i4) != null && "androidx.recyclerview.widget.RecyclerView".equals(g5.getParent().getParent().getParent().getChild(i4).getClassName())) {
                            accessibilityNodeInfo = g5.getParent().getParent().getParent().getChild(i4);
                        }
                    }
                    com.acse.ottn.b.d().b(accessibilityNodeInfo);
                    return;
                }
                TimerTask timerTask = u2.f6657c;
                if (timerTask != null) {
                    timerTask.cancel();
                    u2.f6657c = null;
                }
                com.acse.ottn.b.d().g(g4);
                com.acse.ottn.b.d().a(q0.a().b(500));
                AccessibilityNodeInfo g6 = com.acse.ottn.b.d().g(this.f6661a, "\u59cb\u7ec8\u5141\u8bb8");
                AccessibilityNodeInfo a4 = com.acse.ottn.b.d().a(this.f6661a, "\u5141\u8bb8", true);
                if (g6 != null) {
                    com.acse.ottn.b.d().g(g6);
                    com.acse.ottn.b.d().a(q0.a().b(100));
                    com.acse.ottn.b.d().e(this.f6661a);
                } else if (a4 != null) {
                    com.acse.ottn.b.d().g(a4);
                    com.acse.ottn.b.d().a(q0.a().b(100));
                    com.acse.ottn.b.d().e(this.f6661a);
                }
            } catch (Exception e4) {
                z1.a(u2.f6655a, "e =" + e4.getMessage());
            }
        }

        @Override // com.acse.ottn.l0.d
        public void a() {
            u2.f6657c = null;
        }
    }

    @SuppressLint({"NewApi"})
    public static void a(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo != null) {
            for (int i4 = 0; i4 < accessibilityNodeInfo.getChildCount(); i4++) {
                Log.d("samon-->", accessibilityNodeInfo.getChild(i4).getClassName().toString());
                if (accessibilityNodeInfo.getChild(i4) != null && "androidx.recyclerview.widget.RecyclerView".equals(accessibilityNodeInfo.getChild(i4).getClassName())) {
                    f6658d = accessibilityNodeInfo.getChild(i4);
                    return;
                }
                if (accessibilityNodeInfo.getChild(i4) != null) {
                    a(accessibilityNodeInfo.getChild(i4));
                }
            }
        }
    }

    @RequiresApi(api = 16)
    public static void a(AccessibilityService accessibilityService) {
        AccessibilityNodeInfo g4 = com.acse.ottn.b.d().g(accessibilityService, "\u9ad8\u7ea7");
        if (g4 == null) {
            return;
        }
        com.acse.ottn.b.d().g(g4);
        com.acse.ottn.b.d().a(q0.a().b(200));
        AccessibilityNodeInfo g5 = com.acse.ottn.b.d().g(accessibilityService, "\u7535\u6c60");
        if (g5 == null) {
            return;
        }
        j0.b(true);
        com.acse.ottn.b.d().g(g5);
        com.acse.ottn.b.d().a(q0.a().b(500));
        AccessibilityNodeInfo g6 = com.acse.ottn.b.d().g(accessibilityService, "\u4e0d\u4f18\u5316");
        if (g6 == null) {
            return;
        }
        com.acse.ottn.b.d().g(g6);
        com.acse.ottn.b.d().e(accessibilityService);
        com.acse.ottn.b.d().a(q0.a().b(100));
        com.acse.ottn.b.d().e(accessibilityService);
    }

    @RequiresApi(api = 16)
    public static void a(String str, AccessibilityService accessibilityService) {
        AccessibilityNodeInfo g4 = com.acse.ottn.b.d().g(accessibilityService, str);
        if (g4 != null) {
            for (int i4 = 0; i4 < g4.getParent().getChildCount(); i4++) {
                if (g4.getParent().getChild(i4) != null && "android.widget.CheckBox".equals(g4.getParent().getChild(i4).getClassName())) {
                    if (!g4.getParent().getChild(i4).isChecked()) {
                        com.acse.ottn.b.d().g(g4.getParent().getChild(i4));
                    }
                    j0.b(true);
                    return;
                }
            }
        }
    }
}
