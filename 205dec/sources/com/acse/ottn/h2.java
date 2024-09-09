package com.acse.ottn;

import android.accessibilityservice.AccessibilityService;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AppOpsManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Binder;
import android.os.Build;
import android.util.Log;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.RequiresApi;
import com.acse.ottn.activity.AcseHelpManager;
import com.acse.ottn.l0;
import com.acse.ottn.service.ShopHelperService;
import java.util.TimerTask;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class h2 {

    /* renamed from: a  reason: collision with root package name */
    public static final String f5715a = "acse_MiuiUtils";

    /* renamed from: b  reason: collision with root package name */
    public static boolean f5716b;

    /* renamed from: c  reason: collision with root package name */
    public static TimerTask f5717c;

    public static int a() {
        String a4 = h3.a("ro.miui.ui.version.name");
        if (a4 != null) {
            try {
                return Integer.parseInt(a4.substring(1));
            } catch (Exception e4) {
                z1.b(f5715a, "get miui version code error, version : " + a4);
                z1.b(f5715a, Log.getStackTraceString(e4));
                return -1;
            }
        }
        return -1;
    }

    public static void b(Activity activity, int i4) {
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
            z1.b(f5715a, "intent is not available!");
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
            z1.b(f5715a, "Intent is not available!");
        }
    }

    public static void d(Activity activity, int i4) {
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
            z1.b(f5715a, "Intent is not available!");
        }
    }

    public static void e(Activity activity, int i4) {
        if ("".equals(j0.f5781w)) {
            return;
        }
        g1.a().a("battery_white", true);
        Intent intent = new Intent("miui.intent.action.APP_PERM_EDITOR");
        intent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.PermissionsEditorActivity");
        intent.putExtra("extra_pkgname", j0.f5781w);
        intent.setFlags(268435456);
        if (a(intent, activity)) {
            try {
                activity.startActivityForResult(intent, i4);
                return;
            } catch (Exception unused) {
                j0.b(true);
                return;
            }
        }
        Intent intent2 = new Intent("miui.intent.action.APP_PERM_EDITOR");
        intent2.setPackage("com.miui.securitycenter");
        intent2.putExtra("extra_pkgname", j0.f5781w);
        intent2.setFlags(268435456);
        if (a(intent2, activity)) {
            try {
                activity.startActivityForResult(intent2, i4);
                return;
            } catch (Exception unused2) {
                j0.b(true);
                return;
            }
        }
        z1.b(f5715a, "Intent is not available!");
    }

    public static boolean a(Context context) {
        if (Build.VERSION.SDK_INT >= 19) {
            return a(context, 24);
        }
        return true;
    }

    @TargetApi(19)
    public static boolean a(Context context, int i4) {
        if ("".equals(j0.f5781w)) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService("appops");
            try {
                Class cls = Integer.TYPE;
                return ((Integer) AppOpsManager.class.getDeclaredMethod("checkOp", cls, cls, String.class).invoke(appOpsManager, Integer.valueOf(i4), Integer.valueOf(Binder.getCallingUid()), j0.f5781w)).intValue() == 0;
            } catch (Exception e4) {
                z1.b(f5715a, Log.getStackTraceString(e4));
            }
        } else {
            z1.b(f5715a, "Below API 19 cannot invoke!");
        }
        return false;
    }

    @RequiresApi(api = 16)
    public static void c(AccessibilityService accessibilityService) {
        com.acse.ottn.b.d().a(200L);
        AccessibilityNodeInfo g4 = com.acse.ottn.b.d().g(accessibilityService, "\u5141\u8bb8\u663e\u793a\u5728\u5176\u4ed6\u5e94\u7528\u7684\u4e0a\u5c42");
        if (g4 == null) {
            AccessibilityNodeInfo g5 = com.acse.ottn.b.d().g(accessibilityService, "\u663e\u793a\u5728\u5176\u4ed6\u5e94\u7528\u7684\u4e0a\u5c42");
            AccessibilityNodeInfo g6 = com.acse.ottn.b.d().g(accessibilityService, "\u5141\u8bb8\u6b64\u5e94\u7528\u663e\u793a\u5728\u60a8\u5f53\u524d\u4f7f\u7528\u7684\u5176\u4ed6\u5e94\u7528\u7684\u4e0a\u5c42\u3002\u6b64\u5e94\u7528\u5c06\u80fd\u5f97\u77e5\u60a8\u70b9\u6309\u7684\u4f4d\u7f6e\u6216\u66f4\u6539\u5c4f\u5e55\u4e0a\u663e\u793a\u7684\u5185\u5bb9\u3002");
            Rect rect = new Rect();
            g5.getBoundsInScreen(rect);
            Rect rect2 = new Rect();
            g6.getBoundsInScreen(rect2);
            int i4 = rect.right / 2;
            int i5 = rect2.top;
            int i6 = rect.bottom;
            int i7 = ((i5 - i6) / 2) + i6;
            if (Build.VERSION.SDK_INT >= 24) {
                com.acse.ottn.b.d().a(accessibilityService, i4, i7);
                z1.a(f5715a, "\u70b9\u51fb\u4e86");
            }
        } else {
            com.acse.ottn.b.d().g(g4);
        }
        com.acse.ottn.b.d().a(300L);
        com.acse.ottn.b.d().e(accessibilityService);
        if (Build.VERSION.SDK_INT >= 30) {
            com.acse.ottn.b.d().e(accessibilityService);
        }
    }

    @RequiresApi(api = 16)
    public static void d(AccessibilityService accessibilityService) {
        AccessibilityNodeInfo g4 = com.acse.ottn.b.d().g(accessibilityService, "\u5141\u8bb8\u7cfb\u7edf\u5524\u9192");
        AccessibilityNodeInfo g5 = com.acse.ottn.b.d().g(accessibilityService, "\u5141\u8bb8\u88ab\u5176\u4ed6\u5e94\u7528\u5524\u9192");
        int i4 = 0;
        if (g4 != null && g4.getParent() != null) {
            int i5 = 0;
            while (true) {
                if (i5 >= g4.getParent().getChildCount()) {
                    break;
                } else if (g4.getParent().getChild(i5) == null || !"android.widget.CheckBox".equals(g4.getParent().getChild(i5).getClassName())) {
                    i5++;
                } else if (!g4.getParent().getChild(i5).isChecked()) {
                    com.acse.ottn.b.d().g(g4);
                }
            }
        }
        if (g5 != null && g5.getParent() != null) {
            while (true) {
                if (i4 >= g5.getParent().getChildCount()) {
                    break;
                } else if (g5.getParent().getChild(i4) == null || !"android.widget.CheckBox".equals(g5.getParent().getChild(i4).getClassName())) {
                    i4++;
                } else if (!g5.getParent().getChild(i4).isChecked()) {
                    com.acse.ottn.b.d().g(g5);
                }
            }
        }
        com.acse.ottn.b.d().e(accessibilityService);
        com.acse.ottn.b.d().a(q0.a().b(200));
        com.acse.ottn.b.d().e(accessibilityService);
        j0.c(true);
    }

    public static void b(Activity activity) {
        if ("".equals(j0.f5781w)) {
            return;
        }
        try {
            Intent intent = new Intent();
            ComponentName componentName = new ComponentName("com.miui.securitycenter", "com.miui.permcenter.permissions.PermissionsEditorActivity");
            intent.putExtra("extra_pkgname", j0.f5781w);
            intent.setComponent(componentName);
            intent.addFlags(268435456);
            g1.a().a("battery_white", true);
            activity.startActivityForResult(intent, 10013);
        } catch (Exception unused) {
            j0.b(true);
        }
    }

    public static void a(Activity activity, int i4) {
        int a4 = a();
        if (a4 == 5) {
            b(activity, i4);
        } else if (a4 == 6) {
            c(activity, i4);
        } else if (a4 == 7) {
            d(activity, i4);
        } else if (a4 == 8) {
            e(activity, i4);
        } else {
            z1.b(f5715a, "this is a special MIUI rom version, its version code " + a4);
        }
    }

    @RequiresApi(api = 16)
    public static void e(AccessibilityService accessibilityService) {
        String b4 = h1.c().b();
        z1.a(f5715a, b4);
        com.acse.ottn.b.d().a(q0.a().b(200));
        f5717c = l0.a().b(q0.a().b(30000), q0.a().b(600), new a(accessibilityService, b4));
    }

    @RequiresApi(api = 16)
    public static void b(AccessibilityService accessibilityService) {
        com.acse.ottn.b.d().a(500L);
        AccessibilityNodeInfo g4 = com.acse.ottn.b.d().g(accessibilityService, "\u5176\u4ed6\u6743\u9650");
        if (g4 != null) {
            z1.a("samonp-->", "appNodeInfo is not null=");
            com.acse.ottn.b.d().g(g4);
            g1.a().a("battery_white", true);
            g1.a().a("is_pengpai", true);
            return;
        }
        TimerTask timerTask = f5717c;
        if (timerTask != null) {
            timerTask.cancel();
            f5717c = null;
        }
        String d4 = g1.a().d("OpenPermissionName");
        z1.a("samonp-->", "\u627e\u5230\u4e86\u60ac\u6d6e\u7a97=" + d4);
        if (d4.equals("\u5b9a\u4f4d")) {
            return;
        }
        f5717c = l0.a().b(q0.a().b(6000), q0.a().b(600), new b(d4, accessibilityService));
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class a implements l0.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AccessibilityService f5718a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f5719b;

        public a(AccessibilityService accessibilityService, String str) {
            this.f5718a = accessibilityService;
            this.f5719b = str;
        }

        @Override // com.acse.ottn.l0.d
        public void a(long j4) {
            z1.a("samon-->", "openMiuiFlowWindowPermission\u5012\u8ba1\u65f6");
            try {
                AccessibilityNodeInfo g4 = com.acse.ottn.b.d().g(this.f5718a, this.f5719b);
                if (g4 == null) {
                    if (AcseHelpManager.mContext != null && Build.VERSION.SDK_INT >= 24) {
                        com.acse.ottn.b.a(this.f5718a, c4.c(AcseHelpManager.mContext) / 3, ((c4.b(AcseHelpManager.mContext) * 2) / 3) + 300, (c4.c(AcseHelpManager.mContext) / 3) + 100, c4.b(AcseHelpManager.mContext) / 3, 500);
                        return;
                    }
                    return;
                }
                TimerTask timerTask = h2.f5717c;
                if (timerTask != null) {
                    timerTask.cancel();
                    h2.f5717c = null;
                }
                z1.a(h2.f5715a, "\u627e\u5230\u4e86");
                g1.a().a("battery_white", true);
                com.acse.ottn.b.d().g(g4);
                if ("samsung".equals(c4.b())) {
                    com.acse.ottn.b.d().a(q0.a().b(200));
                    com.acse.ottn.b.d().e(this.f5718a);
                }
            } catch (Exception e4) {
                z1.a(h2.f5715a, "e =" + e4.getMessage());
            }
        }

        @Override // com.acse.ottn.l0.d
        public void a() {
            h2.f5717c = null;
        }
    }

    public static boolean a(Intent intent, Activity activity) {
        return (intent == null || activity == null || activity.getPackageManager().queryIntentActivities(intent, 65536).size() <= 0) ? false : true;
    }

    @RequiresApi(api = 16)
    public static void a(AccessibilityService accessibilityService) {
        AccessibilityNodeInfo g4 = com.acse.ottn.b.d().g(accessibilityService, "\u81ea\u542f\u52a8");
        if (g4 == null) {
            return;
        }
        com.acse.ottn.b.d().g(g4);
        com.acse.ottn.b.d().a(q0.a().b(300));
        a("\u5141\u8bb8\u7cfb\u7edf\u5524\u9192", accessibilityService);
        com.acse.ottn.b.d().e(accessibilityService);
        g1.a().a("battery_white", false);
        com.acse.ottn.b.d().e(accessibilityService);
    }

    public static void c(Activity activity) {
        a(activity);
    }

    @RequiresApi(api = 16)
    public static void a(String str, AccessibilityService accessibilityService) {
        AccessibilityNodeInfo g4 = com.acse.ottn.b.d().g(accessibilityService, str);
        if (g4 == null || g4.getParent() == null) {
            return;
        }
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

    @RequiresApi(api = 16)
    public static void b(String str, AccessibilityService accessibilityService) {
        AccessibilityNodeInfo g4 = com.acse.ottn.b.d().g(accessibilityService, str);
        if (g4 == null || g4.getParent() == null) {
            return;
        }
        for (int i4 = 0; i4 < g4.getParent().getChildCount(); i4++) {
            if (g4.getParent().getChild(i4) != null && "android.widget.CheckBox".equals(g4.getParent().getChild(i4).getClassName())) {
                z1.a("samon-->", "android.widget.CheckBox=" + g4.getParent().getChild(i4).toString());
                if (!g4.getParent().getChild(i4).isChecked()) {
                    com.acse.ottn.b.d().g(g4.getParent().getChild(i4));
                    com.acse.ottn.b.d().a(q0.a().b(100));
                    AccessibilityNodeInfo j4 = com.acse.ottn.b.d().j(ShopHelperService.mService, "\u786e\u5b9a");
                    AccessibilityNodeInfo j5 = com.acse.ottn.b.d().j(ShopHelperService.mService, "\u77e5\u9053\u4e86");
                    if (j4 != null) {
                        z1.a("samon-->", "commitInfo is not null");
                        com.acse.ottn.b.d().g(j4);
                    } else if (j5 != null) {
                        z1.a("samon-->", "commitInfo1 is not null");
                        com.acse.ottn.b.d().g(j5);
                    }
                    j0.c(true);
                }
                com.acse.ottn.b.d().a(q0.a().b(100));
                com.acse.ottn.b.d().e(accessibilityService);
                return;
            }
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class b implements l0.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f5720a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ AccessibilityService f5721b;

        public b(String str, AccessibilityService accessibilityService) {
            this.f5720a = str;
            this.f5721b = accessibilityService;
        }

        @Override // com.acse.ottn.l0.d
        public void a(long j4) {
            z1.a("samon-->", "clickHouTaiShowPage\u5012\u8ba1\u65f6 =" + this.f5720a);
            try {
                if (this.f5720a == null) {
                    return;
                }
                AccessibilityNodeInfo g4 = com.acse.ottn.b.d().g(this.f5721b, this.f5720a);
                if (g4 == null) {
                    z1.a("samonp-->", "appNodeInfo is null");
                    if (AcseHelpManager.mContext != null && Build.VERSION.SDK_INT >= 24) {
                        com.acse.ottn.b.a(this.f5721b, c4.c(AcseHelpManager.mContext) / 3, ((c4.b(AcseHelpManager.mContext) * 2) / 3) + 300, (c4.c(AcseHelpManager.mContext) / 3) + 100, c4.b(AcseHelpManager.mContext) / 3, 500);
                        return;
                    }
                    return;
                }
                z1.a("samonp-->", "appNodeInfo is not null");
                TimerTask timerTask = h2.f5717c;
                if (timerTask != null) {
                    timerTask.cancel();
                    h2.f5717c = null;
                }
                z1.a(h2.f5715a, "\u627e\u5230\u4e86");
                com.acse.ottn.b.d().g(g4);
                g1.a().a("battery_white", false);
                com.acse.ottn.b.d().a(q0.a().b(500));
                AccessibilityNodeInfo j5 = com.acse.ottn.b.d().j(this.f5721b, "\u59cb\u7ec8\u5141\u8bb8");
                AccessibilityNodeInfo j6 = com.acse.ottn.b.d().j(this.f5721b, "\u5141\u8bb8");
                if (j5 != null) {
                    z1.a("samonp-->", "appinfo is not null");
                    com.acse.ottn.b.d().g(j5);
                    com.acse.ottn.b.d().a(q0.a().b(200));
                    com.acse.ottn.b.d().e(this.f5721b);
                } else if (j6 != null) {
                    com.acse.ottn.b.d().g(j6);
                    com.acse.ottn.b.d().a(q0.a().b(200));
                    com.acse.ottn.b.d().e(this.f5721b);
                    z1.a("samonp-->", "appinfo1 is not null");
                }
                if (g1.a().a("is_pengpai")) {
                    com.acse.ottn.b.d().e(this.f5721b);
                    com.acse.ottn.b.d().a(q0.a().b(100));
                    com.acse.ottn.b.d().e(this.f5721b);
                }
            } catch (Exception e4) {
                z1.a(h2.f5715a, "e =" + e4.getMessage());
            }
        }

        @Override // com.acse.ottn.l0.d
        public void a() {
            h2.f5717c = null;
        }
    }

    public static void a(Activity activity) {
        if ("".equals(j0.f5781w)) {
            return;
        }
        g1.a().a("battery_white", true);
        g1.a().a("background_battery_hignt", true);
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", j0.f5781w, null));
        try {
            activity.startActivityForResult(intent, 10015);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }
}
