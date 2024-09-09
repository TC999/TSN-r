package com.acse.ottn;

import android.accessibilityservice.AccessibilityService;
import android.annotation.SuppressLint;
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
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.RequiresApi;
import com.acse.ottn.l0;
import java.util.TimerTask;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class o4 {

    /* renamed from: a  reason: collision with root package name */
    public static final String f6114a = "acse_VivoUtils";

    /* renamed from: c  reason: collision with root package name */
    public static TimerTask f6116c;

    /* renamed from: b  reason: collision with root package name */
    public static Long f6115b = 0L;

    /* renamed from: d  reason: collision with root package name */
    public static AccessibilityNodeInfo f6117d = null;

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AccessibilityService f6123a;

        public c(AccessibilityService accessibilityService) {
            this.f6123a = accessibilityService;
        }

        @Override // java.lang.Runnable
        public void run() {
            o4.a(this.f6123a, Long.valueOf(System.currentTimeMillis()).longValue());
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AccessibilityService f6124a;

        public d(AccessibilityService accessibilityService) {
            this.f6124a = accessibilityService;
        }

        @Override // java.lang.Runnable
        public void run() {
            o4.a(this.f6124a, Long.valueOf(System.currentTimeMillis()).longValue());
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class f implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AccessibilityService f6127a;

        public f(AccessibilityService accessibilityService) {
            this.f6127a = accessibilityService;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i4;
            AccessibilityNodeInfo g4 = com.acse.ottn.b.d().g(this.f6127a, "\u81ea\u542f\u52a8");
            if (g4 != null && g4.getParent() != null) {
                z1.a(o4.f6114a, "find auto start");
                for (int i5 = 0; i5 < g4.getParent().getChildCount(); i5++) {
                    if (g4.getParent().getChild(i5) != null && "android.widget.Switch".equals(g4.getParent().getChild(i5).getClassName())) {
                        z1.a(o4.f6114a, "find auto Switch");
                        if (!g4.getParent().getChild(i5).isChecked()) {
                            Rect rect = new Rect();
                            g4.getParent().getChild(i5).getBoundsInScreen(rect);
                            int c4 = c4.c(this.f6127a);
                            int i6 = rect.right;
                            if (i6 > c4) {
                                int i7 = rect.left;
                                i4 = (((i6 - i7) / 2) + i7) - c4;
                            } else {
                                int i8 = rect.left;
                                i4 = ((i6 - i8) / 2) + i8;
                            }
                            int i9 = rect.bottom;
                            int i10 = rect.top;
                            int i11 = ((i9 - i10) / 2) + i10;
                            if (Build.VERSION.SDK_INT >= 24) {
                                z1.a(o4.f6114a, "start  click Switch x=" + i4 + "  y=" + i11);
                                com.acse.ottn.b.d().a(this.f6127a, i4, i11);
                            }
                        } else {
                            z1.a(o4.f6114a, "start is open");
                        }
                    }
                }
                j0.b(true);
                return;
            }
            z1.a(o4.f6114a, "not find auto start");
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class g implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AccessibilityService f6128a;

        public g(AccessibilityService accessibilityService) {
            this.f6128a = accessibilityService;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i4;
            AccessibilityNodeInfo g4 = com.acse.ottn.b.d().g(this.f6128a, "\u60ac\u6d6e\u7a97");
            if (g4 != null && g4.getParent() != null) {
                z1.a(o4.f6114a, "find flow window");
                for (int i5 = 0; i5 < g4.getParent().getChildCount(); i5++) {
                    if (g4.getParent().getChild(i5) != null && "android.widget.Switch".equals(g4.getParent().getChild(i5).getClassName()) && !g4.getParent().getChild(i5).isChecked()) {
                        Rect rect = new Rect();
                        g4.getParent().getChild(i5).getBoundsInScreen(rect);
                        int c4 = c4.c(this.f6128a);
                        int i6 = rect.right;
                        if (i6 > c4) {
                            int i7 = rect.left;
                            i4 = (((i6 - i7) / 2) + i7) - c4;
                        } else {
                            int i8 = rect.left;
                            i4 = ((i6 - i8) / 2) + i8;
                        }
                        int i9 = rect.bottom;
                        int i10 = rect.top;
                        int i11 = ((i9 - i10) / 2) + i10;
                        if (Build.VERSION.SDK_INT >= 24) {
                            com.acse.ottn.b.d().a(this.f6128a, i4, i11);
                        }
                    }
                }
            }
            com.acse.ottn.b.d().a(q0.a().b(200));
            com.acse.ottn.b.d().e(this.f6128a);
        }
    }

    public static void b(Activity activity) {
        if (g1.a() != null) {
            g1.a().a("battery_white", true);
        }
        if ("".equals(j0.f5781w)) {
            return;
        }
        try {
            String a4 = g1.a().a("flow_window_state", "1");
            if (c4.b().equals("vivo") && !a4.equals("2")) {
                g1.a().b("flow_window_state", "2");
                Intent intent = new Intent();
                intent.setClassName("com.vivo.permissionmanager", "com.vivo.permissionmanager.activity.SoftPermissionDetailActivity");
                intent.putExtra("packagename", j0.f5781w);
                intent.putExtra("tabId", "1");
                activity.startActivityForResult(intent, 10013);
            } else {
                Intent intent2 = new Intent();
                intent2.setClassName("com.vivo.permissionmanager", "com.vivo.permissionmanager.activity.BgStartUpManagerActivity");
                intent2.putExtra("packagename", j0.f5781w);
                intent2.putExtra("tabId", "1");
                activity.startActivityForResult(intent2, 10013);
            }
        } catch (Exception unused) {
            Intent intent3 = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent3.setData(Uri.fromParts("package", j0.f5781w, null));
            activity.startActivityForResult(intent3, 10013);
        }
    }

    @RequiresApi(api = 16)
    public static void c(AccessibilityService accessibilityService) {
        AccessibilityNodeInfo g4 = com.acse.ottn.b.d().g(accessibilityService, "\u5141\u8bb8\u663e\u793a\u5728\u5176\u4ed6\u5e94\u7528\u7684\u4e0a\u5c42");
        if (g4 != null || g4.getParent() == null) {
            for (int i4 = 0; i4 < g4.getParent().getChildCount(); i4++) {
                if (g4.getParent().getChild(i4) != null && "android.widget.Switch".equals(g4.getParent().getChild(i4).getClassName())) {
                    com.acse.ottn.b.d().g(g4.getParent().getChild(i4));
                    com.acse.ottn.b.d().e(accessibilityService);
                    return;
                }
            }
        }
    }

    public static void d(AccessibilityService accessibilityService) {
        com.acse.ottn.b.d().a(q0.a().b(200));
        AccessibilityNodeInfo j4 = com.acse.ottn.b.d().j(accessibilityService, "\u540e\u53f0\u8017\u7535\u7ba1\u7406");
        AccessibilityNodeInfo j5 = com.acse.ottn.b.d().j(accessibilityService, "\u540e\u53f0\u9ad8\u8017\u7535");
        if (j4 != null) {
            z1.a(f6114a, "clickServiceBackgroundHight info is not null");
            if (g1.a() != null) {
                g1.a().a("battery_white", true);
            }
            com.acse.ottn.b.d().g(j4);
            new Handler(Looper.getMainLooper()).postDelayed(new c(accessibilityService), 1000L);
        } else if (j5 != null) {
            z1.a(f6114a, "clickServiceBackgroundHight info2 is not null");
            if (g1.a() != null) {
                z1.a(f6114a, "clickServiceBackgroundHight HelpShopSharedPreferencesUtils is not null");
                g1.a().a("battery_white", true);
            }
            com.acse.ottn.b.d().g(j5);
            new Handler(Looper.getMainLooper()).postDelayed(new d(accessibilityService), 1000L);
        }
    }

    public static void e(AccessibilityService accessibilityService) {
        com.acse.ottn.b.d().a(q0.a().b(50));
        if (com.acse.ottn.b.d().h(accessibilityService, h1.c().b()) != null) {
            AccessibilityNodeInfo j4 = com.acse.ottn.b.d().j(accessibilityService, "\u59cb\u7ec8\u6253\u5f00");
            if (j4 != null) {
                com.acse.ottn.b.d().g(j4);
            } else {
                com.acse.ottn.b.d().i(accessibilityService, "\u5141\u8bb8");
            }
        }
    }

    @SuppressLint({"NewApi"})
    public static void f(AccessibilityService accessibilityService) {
        AccessibilityNodeInfo rootInActiveWindow = accessibilityService.getRootInActiveWindow();
        if (rootInActiveWindow == null) {
            rootInActiveWindow = accessibilityService.getRootInActiveWindow();
        }
        a(rootInActiveWindow);
    }

    public static void g(AccessibilityService accessibilityService) {
        com.acse.ottn.b.d().g(com.acse.ottn.b.d().a(accessibilityService, "\u6743\u9650", true));
        com.acse.ottn.b.d().a(q0.a().b(500));
        AccessibilityNodeInfo a4 = com.acse.ottn.b.d().a(accessibilityService, "\u81ea\u542f\u52a8", true);
        if (a4 != null) {
            com.acse.ottn.b.d().g(a4);
        }
    }

    @RequiresApi(api = 16)
    public static void h(AccessibilityService accessibilityService) {
        String b4 = h1.c().b();
        z1.a(f6114a, b4);
        f6116c = l0.a().b(q0.a().b(20000), q0.a().b(100), new a(accessibilityService, b4));
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
            } catch (Exception e4) {
                z1.b(f6114a, Log.getStackTraceString(e4));
            }
        } else {
            z1.b(f6114a, "Below API 19 cannot invoke!");
        }
        return false;
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class a implements l0.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AccessibilityService f6118a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f6119b;

        public a(AccessibilityService accessibilityService, String str) {
            this.f6118a = accessibilityService;
            this.f6119b = str;
        }

        @Override // com.acse.ottn.l0.d
        public void a(long j4) {
            o4.f(this.f6118a);
            try {
                if (com.acse.ottn.b.d().g(this.f6118a, this.f6119b) == null) {
                    if (o4.f6117d != null) {
                        com.acse.ottn.b.d().b(o4.f6117d);
                    }
                } else {
                    TimerTask timerTask = o4.f6116c;
                    if (timerTask != null) {
                        timerTask.cancel();
                        o4.f6116c = null;
                    }
                }
            } catch (Exception e4) {
                z1.a(o4.f6114a, "e =" + e4.getMessage());
            }
        }

        @Override // com.acse.ottn.l0.d
        public void a() {
            o4.f6116c = null;
        }
    }

    public static void a(Activity activity, int i4) {
        try {
            Intent intent = new Intent();
            intent.setFlags(268435456);
            intent.setComponent(new ComponentName("com.coloros.safecenter", "com.coloros.safecenter.sysfloatwindow.FloatWindowListActivity"));
            activity.startActivityForResult(intent, i4);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public static void a(Activity activity) {
        try {
            if (g1.a() != null) {
                g1.a().a("background_battery_hignt", true);
                g1.a().a("battery_white", true);
            }
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.iqoo.powersaving", "com.iqoo.powersaving.PowerSavingManagerActivity"));
            activity.startActivityForResult(intent, 10014);
        } catch (Exception e4) {
            z1.a(f6114a, e4.getMessage());
            j0.c(true);
        }
    }

    public static void b(AccessibilityService accessibilityService) {
        new Handler(Looper.getMainLooper()).postDelayed(new f(accessibilityService), 200L);
        new Handler(Looper.getMainLooper()).postDelayed(new g(accessibilityService), 500L);
    }

    @SuppressLint({"NewApi"})
    public static void a(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo != null) {
            for (int i4 = 0; i4 < accessibilityNodeInfo.getChildCount(); i4++) {
                if (accessibilityNodeInfo.getChild(i4) != null && "android.widget.ListView".equals(accessibilityNodeInfo.getChild(i4).getClassName())) {
                    f6117d = accessibilityNodeInfo.getChild(i4);
                    return;
                }
                if (accessibilityNodeInfo.getChild(i4) != null) {
                    a(accessibilityNodeInfo.getChild(i4));
                }
            }
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class b implements l0.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AccessibilityService f6120a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f6121b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f6122c;

        public b(AccessibilityService accessibilityService, String str, boolean z3) {
            this.f6120a = accessibilityService;
            this.f6121b = str;
            this.f6122c = z3;
        }

        @Override // com.acse.ottn.l0.d
        public void a(long j4) {
            o4.f(this.f6120a);
            try {
                AccessibilityNodeInfo g4 = com.acse.ottn.b.d().g(this.f6120a, this.f6121b);
                if (g4 == null) {
                    if (o4.f6117d != null) {
                        com.acse.ottn.b.d().b(o4.f6117d);
                        return;
                    }
                    return;
                }
                TimerTask timerTask = o4.f6116c;
                if (timerTask != null) {
                    timerTask.cancel();
                    o4.f6116c = null;
                }
                z1.a(o4.f6114a, "\u627e\u5230\u4e86 =" + this.f6121b);
                if (g4.getParent() != null) {
                    com.acse.ottn.b.d().a(q0.a().b(500));
                    for (int i4 = 0; i4 < g4.getParent().getChildCount(); i4++) {
                        if (g4.getParent().getChild(i4) != null && "android.widget.Switch".equals(g4.getParent().getChild(i4).getClassName()) && !g4.getParent().getChild(i4).isChecked()) {
                            z1.a(o4.f6114a, "find flow window1");
                            Rect rect = new Rect();
                            g4.getParent().getChild(i4).getBoundsInScreen(rect);
                            int i5 = rect.right;
                            int i6 = rect.left;
                            int i7 = i5 - i6;
                            int i8 = (i7 / 2) + i6;
                            if (i8 > 2000) {
                                i8 = (i6 / 2) - (i7 / 2);
                            }
                            int i9 = rect.bottom;
                            int i10 = rect.top;
                            int i11 = ((i9 - i10) / 2) + i10;
                            if (Build.VERSION.SDK_INT >= 24) {
                                z1.a(o4.f6114a, " flow window click");
                                com.acse.ottn.b.d().a(this.f6120a, i8, i11);
                            }
                        }
                    }
                    if (this.f6122c) {
                        z1.a(o4.f6114a, "\u7535\u6c60");
                        j0.b(true);
                    }
                    com.acse.ottn.b.d().a(q0.a().b(500));
                    com.acse.ottn.b.d().e(this.f6120a);
                }
            } catch (Exception e4) {
                z1.a(o4.f6114a, "clickSoftList e =" + e4.getMessage());
            }
        }

        @Override // com.acse.ottn.l0.d
        public void a() {
            o4.f6116c = null;
        }
    }

    @RequiresApi(api = 16)
    public static void a(AccessibilityService accessibilityService, boolean z3) {
        f6116c = l0.a().b(q0.a().b(15000), q0.a().b(150), new b(accessibilityService, h1.c().b(), z3));
    }

    @RequiresApi(api = 16)
    public static void a(AccessibilityService accessibilityService, long j4) {
        g1.a().a("battery_white", false);
        if (j4 - f6115b.longValue() < 5000) {
            z1.a(f6114a, "\u95f4\u9694 t=" + j4 + "   System.currentTimeMillis() =" + System.currentTimeMillis());
            z1.a(f6114a, "\u95f4\u9694 time=" + f6115b + "   System.currentTimeMillis()-time =" + (System.currentTimeMillis() - f6115b.longValue()));
            return;
        }
        z1.a(f6114a, "\u65e0\u95f4\u9694 t=" + j4 + "   System.currentTimeMillis() =" + System.currentTimeMillis());
        z1.a(f6114a, "\u65e0\u95f4\u9694 time=" + f6115b + "   System.currentTimeMillis()-time =" + (System.currentTimeMillis() - f6115b.longValue()));
        f6115b = Long.valueOf(j4);
        z1.a(f6114a, "buttery backgroundHightBattery");
        f6116c = l0.a().b(q0.a().b(5000), q0.a().b(150), new e(accessibilityService, h1.c().b()));
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class e implements l0.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AccessibilityService f6125a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f6126b;

        public e(AccessibilityService accessibilityService, String str) {
            this.f6125a = accessibilityService;
            this.f6126b = str;
        }

        @Override // com.acse.ottn.l0.d
        public void a(long j4) {
            z1.a("samon-->", "\u5012\u8ba1\u65f6");
            o4.f(this.f6125a);
            try {
                AccessibilityNodeInfo g4 = com.acse.ottn.b.d().g(this.f6125a, this.f6126b);
                if (g4 == null) {
                    if (o4.f6117d != null) {
                        com.acse.ottn.b.d().b(o4.f6117d);
                        return;
                    }
                    return;
                }
                TimerTask timerTask = o4.f6116c;
                if (timerTask != null) {
                    timerTask.cancel();
                    z1.a("samon-->", "\u7ed3\u675f\u5012\u8ba1\u65f6");
                    o4.f6116c = null;
                }
                z1.a(o4.f6114a, "buttery find");
                com.acse.ottn.b.d().g(g4);
                com.acse.ottn.b.d().a(q0.a().b(200));
                AccessibilityNodeInfo g5 = com.acse.ottn.b.d().g(this.f6125a, "\u5141\u8bb8\u540e\u53f0\u9ad8\u8017\u7535");
                if (g5 != null) {
                    z1.a(o4.f6114a, "buttery info is not null");
                    com.acse.ottn.b.d().g(g5);
                    j0.c(true);
                } else {
                    z1.a(o4.f6114a, "buttery info is null");
                    if (g4.getParent() != null) {
                        z1.a(o4.f6114a, "buttery start");
                        for (int i4 = 0; i4 < g4.getParent().getChildCount(); i4++) {
                            if (g4.getParent().getChild(i4) != null && "android.widget.Switch".equals(g4.getParent().getChild(i4).getClassName())) {
                                z1.a(o4.f6114a, "find buttery Switch");
                                if (!g4.getParent().getChild(i4).isChecked()) {
                                    Rect rect = new Rect();
                                    g4.getParent().getChild(i4).getBoundsInScreen(rect);
                                    int i5 = rect.right;
                                    int i6 = rect.left;
                                    int i7 = ((i5 - i6) / 2) + i6;
                                    int i8 = rect.bottom;
                                    int i9 = rect.top;
                                    int i10 = ((i8 - i9) / 2) + i9;
                                    if (Build.VERSION.SDK_INT >= 24) {
                                        com.acse.ottn.b.d().a(this.f6125a, i7, i10);
                                    }
                                }
                            }
                        }
                    }
                }
                z1.a(o4.f6114a, "backgroundHightBattery comeBack");
                com.acse.ottn.b.d().a(q0.a().b(100));
                com.acse.ottn.b.d().e(this.f6125a);
                com.acse.ottn.b.d().a(q0.a().b(100));
                com.acse.ottn.b.d().e(this.f6125a);
                com.acse.ottn.b.d().a(q0.a().b(100));
                com.acse.ottn.b.d().e(this.f6125a);
            } catch (Exception e4) {
                z1.a(o4.f6114a, "backgroundHightBattery e =" + e4.getMessage());
            }
        }

        @Override // com.acse.ottn.l0.d
        public void a() {
            o4.f6116c = null;
        }
    }
}
