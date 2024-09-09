package com.acse.ottn;

import android.accessibilityservice.AccessibilityService;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AppOpsManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Binder;
import android.os.Build;
import android.util.Log;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.RequiresApi;
import com.acse.ottn.l0;
import java.util.TimerTask;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class x2 {

    /* renamed from: a  reason: collision with root package name */
    public static final String f6988a = "OppoUtils";

    /* renamed from: c  reason: collision with root package name */
    public static TimerTask f6990c;

    /* renamed from: b  reason: collision with root package name */
    public static Long f6989b = 0L;

    /* renamed from: d  reason: collision with root package name */
    public static AccessibilityNodeInfo f6991d = null;

    public static void c(AccessibilityService accessibilityService) {
        f6990c = l0.a().b(q0.a().b(1000), q0.a().b(100), new e(accessibilityService));
    }

    @RequiresApi(api = 16)
    public static void d(AccessibilityService accessibilityService) {
        AccessibilityNodeInfo g4 = com.acse.ottn.b.d().g(accessibilityService, "\u8017\u7535\u7ba1\u7406");
        AccessibilityNodeInfo g5 = com.acse.ottn.b.d().g(accessibilityService, "\u8017\u7535\u4fdd\u62a4");
        if (g4 == null && g5 == null) {
            u2.a(accessibilityService);
            return;
        }
        if (g4 != null) {
            z1.a(f6988a, "nodeInfo is null");
            com.acse.ottn.b.d().g(g4);
        } else {
            com.acse.ottn.b.d().g(g5);
        }
        g1.a().a("battery_white", true);
        a(accessibilityService, System.currentTimeMillis());
    }

    public static void e(AccessibilityService accessibilityService) {
        com.acse.ottn.b.d().a(q0.a().b(50));
        if (com.acse.ottn.b.d().h(accessibilityService, h1.c().b()) != null) {
            AccessibilityNodeInfo j4 = com.acse.ottn.b.d().j(accessibilityService, "\u59cb\u7ec8\u5141\u8bb8\u6253\u5f00");
            if (j4 != null) {
                com.acse.ottn.b.d().g(j4);
            }
            AccessibilityNodeInfo j5 = com.acse.ottn.b.d().j(accessibilityService, "\u6253\u5f00");
            if (j5 != null) {
                com.acse.ottn.b.d().g(j5);
            }
        }
    }

    @SuppressLint({"NewApi"})
    public static void f(AccessibilityService accessibilityService) {
        a(accessibilityService.getRootInActiveWindow());
    }

    public static void g(AccessibilityService accessibilityService) {
        f6990c = l0.a().b(q0.a().b(20000), q0.a().b(100), new c(accessibilityService, h1.c().b()));
    }

    public static void h(AccessibilityService accessibilityService) {
        f6990c = l0.a().b(q0.a().b(20000), q0.a().b(100), new b(accessibilityService, h1.c().b()));
    }

    @RequiresApi(api = 16)
    public static void i(AccessibilityService accessibilityService) {
        f6990c = l0.a().b(q0.a().b(20000), q0.a().b(100), new a(accessibilityService, h1.c().b()));
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
            return false;
        }
        if (i5 >= 19) {
            AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService("appops");
            try {
                Class cls = Integer.TYPE;
                return ((Integer) AppOpsManager.class.getDeclaredMethod("checkOp", cls, cls, String.class).invoke(appOpsManager, Integer.valueOf(i4), Integer.valueOf(Binder.getCallingUid()), j0.f5781w)).intValue() == 0;
            } catch (Throwable th) {
                z1.b(f6988a, Log.getStackTraceString(th));
            }
        } else {
            z1.b(f6988a, "Below API 19 cannot invoke!");
        }
        return false;
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class e implements l0.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AccessibilityService f6999a;

        public e(AccessibilityService accessibilityService) {
            this.f6999a = accessibilityService;
        }

        @Override // com.acse.ottn.l0.d
        @RequiresApi(api = 16)
        public void a(long j4) {
            z1.a("samon-->", "backClick  \u5012\u8ba1\u65f6");
            AccessibilityNodeInfo a4 = com.acse.ottn.b.d().a(this.f6999a, "\u5141\u8bb8", true);
            AccessibilityNodeInfo a5 = com.acse.ottn.b.d().a(this.f6999a, "\u901a\u77e5\u7ba1\u7406", true);
            if (a4 == null || a5 != null) {
                return;
            }
            TimerTask timerTask = x2.f6990c;
            if (timerTask != null) {
                timerTask.cancel();
                x2.f6990c = null;
            }
            com.acse.ottn.b.d().g(a4);
            j0.b(true);
            com.acse.ottn.b.d().e(this.f6999a);
        }

        @Override // com.acse.ottn.l0.d
        public void a() {
            TimerTask timerTask = x2.f6990c;
            if (timerTask != null) {
                timerTask.cancel();
                x2.f6990c = null;
            }
            j0.b(true);
            com.acse.ottn.b.d().e(this.f6999a);
            com.acse.ottn.b.d().e(this.f6999a);
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class a implements l0.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AccessibilityService f6992a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f6993b;

        public a(AccessibilityService accessibilityService, String str) {
            this.f6992a = accessibilityService;
            this.f6993b = str;
        }

        @Override // com.acse.ottn.l0.d
        public void a(long j4) {
            z1.a("samon-->", "openOppoFlowWindowPermission  \u5012\u8ba1\u65f6");
            try {
                AccessibilityNodeInfo g4 = com.acse.ottn.b.d().g(this.f6992a, this.f6993b);
                if (g4 == null) {
                    x2.f(this.f6992a);
                    if (x2.f6991d != null) {
                        com.acse.ottn.b.d().b(x2.f6991d);
                        return;
                    }
                    return;
                }
                TimerTask timerTask = x2.f6990c;
                if (timerTask != null) {
                    timerTask.cancel();
                    x2.f6990c = null;
                }
                z1.a(x2.f6988a, "\u627e\u5230\u4e86");
                com.acse.ottn.b.d().g(g4);
                com.acse.ottn.b.d().e(this.f6992a);
            } catch (Throwable th) {
                z1.a(x2.f6988a, "e =" + th.getMessage());
            }
        }

        @Override // com.acse.ottn.l0.d
        public void a() {
            x2.f6990c = null;
            z1.a(x2.f6988a, "\u7ed3\u675f\u4e86");
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class b implements l0.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AccessibilityService f6994a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f6995b;

        public b(AccessibilityService accessibilityService, String str) {
            this.f6994a = accessibilityService;
            this.f6995b = str;
        }

        @Override // com.acse.ottn.l0.d
        public void a(long j4) {
            z1.a("samon-->", "openAndroidElevenOppoFlowWindowPermission  \u5012\u8ba1\u65f6");
            try {
                AccessibilityNodeInfo g4 = com.acse.ottn.b.d().g(this.f6994a, this.f6995b);
                if (g4 == null) {
                    x2.f(this.f6994a);
                    if (x2.f6991d != null) {
                        com.acse.ottn.b.d().b(x2.f6991d);
                        return;
                    }
                    return;
                }
                TimerTask timerTask = x2.f6990c;
                if (timerTask != null) {
                    timerTask.cancel();
                    x2.f6990c = null;
                }
                z1.a(x2.f6988a, "\u627e\u5230\u4e86");
                com.acse.ottn.b.d().g(g4);
                com.acse.ottn.b.d().e(this.f6994a);
            } catch (Throwable th) {
                z1.a(x2.f6988a, "e =" + th.getMessage());
            }
        }

        @Override // com.acse.ottn.l0.d
        public void a() {
            x2.f6990c = null;
            z1.a(x2.f6988a, "\u7ed3\u675f\u4e86");
        }
    }

    public static void a(Activity activity, int i4) {
        try {
            Intent intent = new Intent();
            intent.setFlags(268435456);
            intent.setComponent(new ComponentName("com.coloros.safecenter", "com.coloros.safecenter.sysfloatwindow.FloatWindowListActivity"));
            activity.startActivityForResult(intent, i4);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class c implements l0.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AccessibilityService f6996a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f6997b;

        public c(AccessibilityService accessibilityService, String str) {
            this.f6996a = accessibilityService;
            this.f6997b = str;
        }

        @Override // com.acse.ottn.l0.d
        public void a(long j4) {
            z1.a("samon-->", "openAndroid12OppoFlowWindowPermission  \u5012\u8ba1\u65f6");
            try {
                AccessibilityNodeInfo g4 = com.acse.ottn.b.d().g(this.f6996a, this.f6997b);
                if (g4 == null) {
                    x2.f(this.f6996a);
                    if (x2.f6991d != null) {
                        com.acse.ottn.b.d().b(x2.f6991d);
                        return;
                    }
                    return;
                }
                TimerTask timerTask = x2.f6990c;
                if (timerTask != null) {
                    timerTask.cancel();
                    x2.f6990c = null;
                    z1.a(x2.f6988a, "\u53d6\u6d88\u5012\u8ba1\u65f6");
                }
                z1.a(x2.f6988a, "\u627e\u5230\u4e86");
                com.acse.ottn.b.d().g(g4);
                com.acse.ottn.b.d().a(q0.a().b(500));
                z1.a(x2.f6988a, "\u70b9\u51fb1=" + System.currentTimeMillis());
                AccessibilityNodeInfo g5 = com.acse.ottn.b.d().g(this.f6996a, "\u5141\u8bb8");
                if (g5 != null) {
                    z1.a(x2.f6988a, "\u70b9\u51fb2=" + System.currentTimeMillis());
                    com.acse.ottn.b.d().g(g5);
                    com.acse.ottn.b.d().e(this.f6996a);
                    com.acse.ottn.b.d().e(this.f6996a);
                }
            } catch (Throwable th) {
                z1.a(x2.f6988a, "e =" + th.getMessage());
            }
        }

        @Override // com.acse.ottn.l0.d
        public void a() {
            x2.f6990c = null;
            z1.a(x2.f6988a, "\u7ed3\u675f\u4e86");
        }
    }

    public static void a(AccessibilityService accessibilityService, long j4) {
        if (j4 - f6989b.longValue() < 1000) {
            z1.a(f6988a, "\u95f4\u9694 t=" + j4 + "   System.currentTimeMillis() =" + System.currentTimeMillis());
            z1.a(f6988a, "\u95f4\u9694 time=" + f6989b + "   System.currentTimeMillis()-time =" + (System.currentTimeMillis() - f6989b.longValue()));
            return;
        }
        z1.a(f6988a, "\u65e0\u95f4\u9694 t=" + j4 + "   System.currentTimeMillis() =" + System.currentTimeMillis());
        z1.a(f6988a, "\u65e0\u95f4\u9694 time=" + f6989b + "   System.currentTimeMillis()-time =" + (System.currentTimeMillis() - f6989b.longValue()));
        f6989b = Long.valueOf(j4);
        f6990c = l0.a().b(q0.a().b(1500), q0.a().b(500), new d(accessibilityService));
    }

    public static void a(Activity activity) {
        if ("".equals(j0.f5781w)) {
            return;
        }
        g1.a().a("open_battery_white", true);
        Intent intent = new Intent();
        try {
            try {
                intent.setFlags(268435456);
                intent.putExtra("packageName", j0.f5781w);
                intent.setComponent(new ComponentName("com.color.safecenter", "com.color.safecenter.permission.PermissionManagerActivity"));
                activity.startActivity(intent);
            } catch (Exception unused) {
                Intent intent2 = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent2.setData(Uri.fromParts("package", j0.f5781w, null));
                activity.startActivity(intent2);
            }
        } catch (Exception unused2) {
            intent.setFlags(268435456);
            intent.putExtra("pkg_name", j0.f5781w);
            intent.putExtra("app_name", h1.c().b());
            intent.putExtra("class_name", "com.welab.notificationdemo.MainActivity");
            intent.setComponent(new ComponentName("com.coloros.notificationmanager", "com.coloros.notificationmanager.AppDetailPreferenceActivity"));
            activity.startActivity(intent);
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class d implements l0.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AccessibilityService f6998a;

        public d(AccessibilityService accessibilityService) {
            this.f6998a = accessibilityService;
        }

        @Override // com.acse.ottn.l0.d
        public void a(long j4) {
            z1.a("samon-->", "clickOpenBatteryManage  \u5012\u8ba1\u65f6");
            AccessibilityNodeInfo g4 = com.acse.ottn.b.d().g(this.f6998a, "\u5141\u8bb8\u5e94\u7528\u81ea\u542f\u52a8");
            AccessibilityNodeInfo g5 = com.acse.ottn.b.d().g(this.f6998a, "\u5141\u8bb8\u5b8c\u5168\u540e\u53f0\u884c\u4e3a");
            AccessibilityNodeInfo g6 = com.acse.ottn.b.d().g(this.f6998a, "\u5141\u8bb8\u540e\u53f0\u8fd0\u884c");
            int i4 = 0;
            if (g4 != null && g4.getParent() != null) {
                z1.a(x2.f6988a, "infochild is not null");
                com.acse.ottn.b.d().a(200L);
                for (int i5 = 0; i5 < g4.getParent().getChildCount(); i5++) {
                    if (g4.getParent().getChild(i5) != null && "android.widget.Switch".equals(g4.getParent().getChild(i5).getClassName())) {
                        z1.a(x2.f6988a, "infochild android.widget.Switch");
                        if (!g4.getParent().getChild(i5).isChecked()) {
                            z1.a(x2.f6988a, "\u70b9\u51fbinfochild");
                            com.acse.ottn.b.d().g(g4);
                        }
                    }
                }
            }
            if (g5 != null && g5.getParent() != null) {
                z1.a(x2.f6988a, "nodeInfochild is not null");
                com.acse.ottn.b.d().a(100L);
                while (i4 < g5.getParent().getChildCount()) {
                    if (g5.getParent().getChild(i4) != null && "android.widget.Switch".equals(g5.getParent().getChild(i4).getClassName())) {
                        z1.a(x2.f6988a, "nodeInfochild android.widget.Switch");
                        if (!g5.getParent().getChild(i4).isChecked()) {
                            z1.a(x2.f6988a, "\u70b9\u51fbnodeInfochild = ");
                            com.acse.ottn.b.d().g(g5);
                        }
                    }
                    i4++;
                }
                TimerTask timerTask = x2.f6990c;
                if (timerTask != null) {
                    timerTask.cancel();
                    x2.f6990c = null;
                }
                x2.c(this.f6998a);
            } else if (g6 != null && g6.getParent() != null) {
                z1.a(x2.f6988a, "nodeInfochild1 is not null");
                com.acse.ottn.b.d().a(100L);
                TimerTask timerTask2 = x2.f6990c;
                if (timerTask2 != null) {
                    timerTask2.cancel();
                    x2.f6990c = null;
                }
                while (i4 < g6.getParent().getChildCount()) {
                    if (g6.getParent().getChild(i4) != null && "android.widget.Switch".equals(g6.getParent().getChild(i4).getClassName())) {
                        z1.a(x2.f6988a, "nodeInfochild1 android.widget.Switch");
                        if (!g6.getParent().getChild(i4).isChecked()) {
                            z1.a(x2.f6988a, "\u70b9\u51fbnodeInfochild1");
                            com.acse.ottn.b.d().g(g6);
                        }
                    }
                    i4++;
                }
                x2.c(this.f6998a);
            }
        }

        @Override // com.acse.ottn.l0.d
        public void a() {
            TimerTask timerTask = x2.f6990c;
            if (timerTask != null) {
                timerTask.cancel();
                x2.f6990c = null;
            }
        }
    }

    @SuppressLint({"NewApi"})
    public static void a(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo != null) {
            for (int i4 = 0; i4 < accessibilityNodeInfo.getChildCount(); i4++) {
                if (accessibilityNodeInfo.getChild(i4) != null && "androidx.recyclerview.widget.RecyclerView".equals(accessibilityNodeInfo.getChild(i4).getClassName())) {
                    f6991d = accessibilityNodeInfo.getChild(i4);
                    return;
                }
                if (accessibilityNodeInfo.getChild(i4) != null) {
                    a(accessibilityNodeInfo.getChild(i4));
                }
            }
        }
    }
}
