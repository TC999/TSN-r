package com.acse.ottn;

import android.accessibilityservice.AccessibilityService;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AppOpsManager;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Binder;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.util.Log;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.RequiresApi;
import com.acse.ottn.l0;
import com.acse.ottn.util.HelpShopAppUtil;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import java.util.TimerTask;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class l1 {

    /* renamed from: a  reason: collision with root package name */
    public static final String f5876a = "acse_HuaweiUtils";

    /* renamed from: b  reason: collision with root package name */
    public static boolean f5877b = true;

    /* renamed from: d  reason: collision with root package name */
    public static TimerTask f5879d;

    /* renamed from: c  reason: collision with root package name */
    public static Long f5878c = 0L;

    /* renamed from: e  reason: collision with root package name */
    public static AccessibilityNodeInfo f5880e = null;

    /* renamed from: f  reason: collision with root package name */
    public static AccessibilityNodeInfo f5881f = null;

    @RequiresApi(api = 16)
    public static void c(AccessibilityService accessibilityService) {
        TimerTask timerTask = f5879d;
        if (timerTask != null) {
            timerTask.cancel();
            f5879d = null;
        }
        f5879d = l0.a().b(q0.a().b(AVMDLDataLoader.KeyIsLiveSetLoaderType), q0.a().b(100), new b(accessibilityService, g1.a().d("OpenPermissionName")));
    }

    @SuppressLint({"NewApi"})
    public static void d(AccessibilityService accessibilityService, boolean z3) {
        f5881f = null;
        f(accessibilityService, z3);
    }

    @SuppressLint({"NewApi"})
    public static void e(AccessibilityService accessibilityService) {
        f(accessibilityService.getRootInActiveWindow());
    }

    @SuppressLint({"NewApi"})
    public static void f(AccessibilityService accessibilityService) {
        h(accessibilityService.getRootInActiveWindow());
    }

    @SuppressLint({"NewApi"})
    public static AccessibilityNodeInfo g(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo != null) {
            for (int i4 = 0; i4 < accessibilityNodeInfo.getChildCount(); i4++) {
                if (accessibilityNodeInfo.getChild(i4) != null && "android.widget.ListView".equals(accessibilityNodeInfo.getChild(i4).getClassName()) && accessibilityNodeInfo.getChild(i4).isScrollable()) {
                    return accessibilityNodeInfo.getChild(i4);
                }
                if (accessibilityNodeInfo.getChild(i4) != null) {
                    g(accessibilityNodeInfo.getChild(i4));
                }
            }
            return null;
        }
        return null;
    }

    @SuppressLint({"NewApi"})
    public static void h(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo == null || accessibilityNodeInfo.getChildCount() != 0) {
            if (accessibilityNodeInfo != null) {
                for (int i4 = 0; i4 < accessibilityNodeInfo.getChildCount(); i4++) {
                    if (accessibilityNodeInfo.getChild(i4) != null) {
                        h(accessibilityNodeInfo.getChild(i4));
                    }
                }
                return;
            }
            return;
        }
        String charSequence = accessibilityNodeInfo.getClassName().toString();
        Rect rect = new Rect();
        accessibilityNodeInfo.getBoundsInScreen(rect);
        int c4 = c4.c(HelpShopAppUtil.getContext());
        if (accessibilityNodeInfo.getText() != null) {
            String charSequence2 = accessibilityNodeInfo.getText().toString();
            Log.d(f5876a, charSequence2 + "      info.getBoundsInScreen=" + rect.toString());
        } else if (accessibilityNodeInfo.getClassName() != null) {
            Log.d(f5876a, "--------------------");
            Log.d(f5876a, "width=" + c4);
            Log.d(f5876a, charSequence + "info.getBoundsInScreen=" + rect.toString());
        }
    }

    public static void d(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo == null) {
            return;
        }
        for (int i4 = 0; i4 < accessibilityNodeInfo.getChildCount(); i4++) {
            if (accessibilityNodeInfo.getChild(i4) != null && "android.widget.ListView".equals(accessibilityNodeInfo.getChild(i4).getClassName())) {
                z1.a(f5876a, "android.widget.ListView = " + accessibilityNodeInfo.getChild(i4).getChildCount());
                if (accessibilityNodeInfo.getChild(i4).getChildCount() > 0) {
                    f5881f = accessibilityNodeInfo.getChild(i4);
                }
            }
            if (accessibilityNodeInfo.getChild(i4) != null) {
                d(accessibilityNodeInfo.getChild(i4));
            }
        }
    }

    @RequiresApi(api = 16)
    public static void e(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo == null || accessibilityNodeInfo.getParent() == null) {
            return;
        }
        for (int i4 = 0; i4 < accessibilityNodeInfo.getParent().getChildCount(); i4++) {
            if (accessibilityNodeInfo.getParent().getChild(i4) != null && "android.widget.Switch".equals(accessibilityNodeInfo.getParent().getChild(i4).getClassName())) {
                if (accessibilityNodeInfo.getParent().getChild(i4).isChecked()) {
                    com.acse.ottn.b.d().g(accessibilityNodeInfo.getParent().getChild(i4));
                    return;
                }
                return;
            }
        }
    }

    @SuppressLint({"NewApi"})
    public static void f(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo != null) {
            for (int i4 = 0; i4 < accessibilityNodeInfo.getChildCount(); i4++) {
                if (accessibilityNodeInfo.getChild(i4) != null && "android.widget.ListView".equals(accessibilityNodeInfo.getChild(i4).getClassName())) {
                    f5880e = accessibilityNodeInfo.getChild(i4);
                    return;
                }
                if (accessibilityNodeInfo.getChild(i4) != null) {
                    f(accessibilityNodeInfo.getChild(i4));
                }
            }
        }
    }

    @RequiresApi(api = 16)
    public static void b(AccessibilityService accessibilityService, boolean z3) {
        Log.d("samon-->", "clickOpenBatteryManage");
        com.acse.ottn.b.d().a(q0.a().b(200));
        if (com.acse.ottn.b.d().h(accessibilityService, "\u5e94\u7528\u542f\u52a8\u7ba1\u7406") == null) {
            z1.a(f5876a, "clickOpenBatteryManage");
            return;
        }
        z1.a(f5876a, "\u627e\u5230");
        try {
            d(accessibilityService, z3);
        } catch (Throwable unused) {
        }
    }

    public static boolean a(Context context) {
        if (Build.VERSION.SDK_INT >= 19) {
            return a(context, 24);
        }
        return true;
    }

    public static void c(AccessibilityService accessibilityService, boolean z3) {
        e(accessibilityService, z3);
    }

    @SuppressLint({"NewApi"})
    public static void g(AccessibilityService accessibilityService) {
        c(accessibilityService.getRootInActiveWindow());
    }

    public static void a(Activity activity, int i4) {
        try {
            Intent intent = new Intent();
            intent.setFlags(268435456);
            intent.setComponent(new ComponentName("com.huawei.systemmanager", "com.huawei.systemmanager.addviewmonitor.AddViewMonitorActivity"));
            if (h3.f() == 3.1d) {
                activity.startActivityForResult(intent, i4);
            } else {
                intent.setComponent(new ComponentName("com.huawei.systemmanager", "com.huawei.notificationmanager.ui.NotificationManagmentActivity"));
                activity.startActivity(intent);
            }
        } catch (ActivityNotFoundException e4) {
            Intent intent2 = new Intent();
            intent2.setFlags(268435456);
            intent2.setComponent(new ComponentName("com.Android.settings", "com.android.settings.permission.TabItem"));
            activity.startActivityForResult(intent2, i4);
            e4.printStackTrace();
            z1.b(f5876a, Log.getStackTraceString(e4));
        } catch (SecurityException e5) {
            Intent intent3 = new Intent();
            intent3.setFlags(268435456);
            intent3.setComponent(new ComponentName("com.huawei.systemmanager", "com.huawei.permissionmanager.ui.MainActivity"));
            activity.startActivityForResult(intent3, i4);
            z1.b(f5876a, Log.getStackTraceString(e5));
        } catch (Exception e6) {
            z1.b(f5876a, Log.getStackTraceString(e6));
        }
    }

    @SuppressLint({"NewApi"})
    public static void c(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo != null && accessibilityNodeInfo.getChildCount() == 0) {
            z1.a("samon-->", accessibilityNodeInfo.toString());
        } else if (accessibilityNodeInfo != null) {
            for (int i4 = 0; i4 < accessibilityNodeInfo.getChildCount(); i4++) {
                z1.a("samon-->", accessibilityNodeInfo.getChildCount() + "");
                c(accessibilityNodeInfo);
            }
        }
    }

    @SuppressLint({"NewApi"})
    public static void e(AccessibilityService accessibilityService, boolean z3) {
        AccessibilityNodeInfo rootInActiveWindow = accessibilityService.getRootInActiveWindow();
        com.acse.ottn.b.d().a(q0.a().b(1000));
        if (z3) {
            a(accessibilityService, rootInActiveWindow);
        } else {
            d(accessibilityService);
        }
    }

    @SuppressLint({"NewApi"})
    public static void f(AccessibilityService accessibilityService, boolean z3) {
        z1.a(f5876a, "recycle \u5f00\u59cb");
        f5879d = l0.a().b(q0.a().b(6000), q0.a().b(100), new d(accessibilityService, h1.c().b(), z3));
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class f implements l0.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AccessibilityService f5893a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ AccessibilityNodeInfo f5894b;

        public f(AccessibilityService accessibilityService, AccessibilityNodeInfo accessibilityNodeInfo) {
            this.f5893a = accessibilityService;
            this.f5894b = accessibilityNodeInfo;
        }

        @Override // com.acse.ottn.l0.d
        public void a(long j4) {
            z1.a("samon-->", "bbbb  \u5012\u8ba1\u65f6");
            AccessibilityNodeInfo g4 = com.acse.ottn.b.d().g(this.f5893a, "\u540e\u53f0\u5f39\u7a97");
            if (g4 != null) {
                TimerTask timerTask = l1.f5879d;
                if (timerTask != null) {
                    timerTask.cancel();
                    l1.f5879d = null;
                }
                com.acse.ottn.b.d().g(g4);
                if (g1.a() != null) {
                    g1.a().a("battery_white", true);
                    return;
                }
                return;
            }
            com.acse.ottn.b.d().b(this.f5894b);
        }

        @Override // com.acse.ottn.l0.d
        public void a() {
            z1.a(l1.f5876a, "\u7ed3\u675f\u4e86");
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class b implements l0.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AccessibilityService f5885a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f5886b;

        public b(AccessibilityService accessibilityService, String str) {
            this.f5885a = accessibilityService;
            this.f5886b = str;
        }

        @Override // com.acse.ottn.l0.d
        public void a(long j4) {
            try {
                z1.a("samon-->", "clickSoftList  \u5012\u8ba1\u65f6");
                AccessibilityNodeInfo g4 = com.acse.ottn.b.d().g(this.f5885a, this.f5886b);
                if (g4 != null) {
                    TimerTask timerTask = l1.f5879d;
                    if (timerTask != null) {
                        timerTask.cancel();
                        l1.f5879d = null;
                    }
                    com.acse.ottn.b.d().g(g4);
                    if (g1.a() != null) {
                        z1.a(l1.f5876a, "set battery_white is true");
                        g1.a().a("battery_white", true);
                    }
                }
            } catch (Throwable th) {
                z1.a(l1.f5876a, "e =" + th.getMessage());
            }
        }

        @Override // com.acse.ottn.l0.d
        public void a() {
            l1.f5879d = null;
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class d implements l0.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AccessibilityService f5889a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f5890b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f5891c;

        public d(AccessibilityService accessibilityService, String str, boolean z3) {
            this.f5889a = accessibilityService;
            this.f5890b = str;
            this.f5891c = z3;
        }

        @Override // com.acse.ottn.l0.d
        public void a(long j4) {
            l1.d(this.f5889a.getRootInActiveWindow());
            if (l1.f5881f != null) {
                AccessibilityNodeInfo g4 = com.acse.ottn.b.d().g(this.f5889a, this.f5890b);
                if (g4 == null) {
                    com.acse.ottn.b.d().b(l1.f5881f);
                    return;
                }
                TimerTask timerTask = l1.f5879d;
                if (timerTask != null) {
                    timerTask.cancel();
                    l1.f5879d = null;
                }
                l1.e(g4);
                l1.a(this.f5889a, this.f5891c);
            }
        }

        @Override // com.acse.ottn.l0.d
        public void a() {
            z1.a(l1.f5876a, "\u7ed3\u675f\u4e86");
        }
    }

    @RequiresApi(api = 16)
    public static void b(String str, AccessibilityService accessibilityService) {
        AccessibilityNodeInfo g4 = com.acse.ottn.b.d().g(accessibilityService, str);
        if (g4 == null || g4.getParent() == null) {
            return;
        }
        for (int i4 = 0; i4 < g4.getParent().getChildCount(); i4++) {
            if (g4.getParent().getChild(i4) != null && "android.widget.Switch".equals(g4.getParent().getChild(i4).getClassName())) {
                if (g4.getParent().getChild(i4).isChecked()) {
                    return;
                }
                com.acse.ottn.b.d().g(g4.getParent().getChild(i4));
                return;
            }
        }
    }

    public static void d(AccessibilityService accessibilityService) {
        f5879d = l0.a().b(q0.a().b(15000), q0.a().b(100), new g(accessibilityService, h1.c().b()));
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class c implements l0.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AccessibilityService f5887a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f5888b;

        public c(AccessibilityService accessibilityService, String str) {
            this.f5887a = accessibilityService;
            this.f5888b = str;
        }

        @Override // com.acse.ottn.l0.d
        public void a(long j4) {
            l1.e(this.f5887a);
            try {
                AccessibilityNodeInfo g4 = com.acse.ottn.b.d().g(this.f5887a, this.f5888b);
                if (g4 == null) {
                    if (l1.f5880e != null) {
                        com.acse.ottn.b.d().b(l1.f5880e);
                        return;
                    }
                    return;
                }
                TimerTask timerTask = l1.f5879d;
                if (timerTask != null) {
                    timerTask.cancel();
                    l1.f5879d = null;
                }
                com.acse.ottn.b.d().g(g4);
                com.acse.ottn.b.d().a(500L);
                l1.a(this.f5887a, System.currentTimeMillis(), true);
            } catch (Throwable th) {
                z1.a(l1.f5876a, "e =" + th.getMessage());
            }
        }

        @Override // com.acse.ottn.l0.d
        public void a() {
            l1.f5879d = null;
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class g implements l0.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AccessibilityService f5895a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f5896b;

        public g(AccessibilityService accessibilityService, String str) {
            this.f5895a = accessibilityService;
            this.f5896b = str;
        }

        @Override // com.acse.ottn.l0.d
        public void a(long j4) {
            z1.a("samon-->", "clickView  \u5012\u8ba1\u65f6");
            AccessibilityNodeInfo g4 = l1.g(this.f5895a.getRootInActiveWindow());
            if (com.acse.ottn.b.d().g(this.f5895a, this.f5896b) == null) {
                if (g4 != null) {
                    com.acse.ottn.b.d().b(g4);
                    return;
                }
                return;
            }
            TimerTask timerTask = l1.f5879d;
            if (timerTask != null) {
                timerTask.cancel();
                l1.f5879d = null;
            }
            l1.b(this.f5896b, this.f5895a);
            j0.c(true);
            com.acse.ottn.b.d().e(this.f5895a);
            com.acse.ottn.b.d().e(this.f5895a);
            com.acse.ottn.b.d().e(this.f5895a);
        }

        @Override // com.acse.ottn.l0.d
        public void a() {
            z1.a(l1.f5876a, "\u7ed3\u675f\u4e86");
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class e implements l0.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AccessibilityService f5892a;

        public e(AccessibilityService accessibilityService) {
            this.f5892a = accessibilityService;
        }

        @Override // com.acse.ottn.l0.d
        public void a(long j4) {
            z1.a("samon-->", "clickOpenBatteryDetails  \u5012\u8ba1\u65f6");
            if (com.acse.ottn.b.d().g(this.f5892a, "\u624b\u52a8\u7ba1\u7406") != null) {
                TimerTask timerTask = l1.f5879d;
                if (timerTask != null) {
                    timerTask.cancel();
                    l1.f5879d = null;
                }
                l1.b("\u5141\u8bb8\u81ea\u542f\u52a8", this.f5892a);
                l1.b("\u5141\u8bb8\u540e\u53f0\u6d3b\u52a8", this.f5892a);
                j0.b(true);
                com.acse.ottn.b.d().e(this.f5892a);
                com.acse.ottn.b.d().e(this.f5892a);
                com.acse.ottn.b.d().e(this.f5892a);
                if (g1.a() != null) {
                    g1.a().a("battery_white", false);
                }
            }
        }

        @Override // com.acse.ottn.l0.d
        public void a() {
            z1.a(l1.f5876a, "\u7ed3\u675f\u4e86");
            l1.f5879d = null;
        }
    }

    @RequiresApi(api = 16)
    public static void h(AccessibilityService accessibilityService) {
        String b4 = h1.c().b();
        z1.b(f5876a, b4);
        f5879d = l0.a().b(q0.a().b(10000), q0.a().b(100), new c(accessibilityService, b4));
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class a implements l0.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AccessibilityService f5882a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f5883b;

        /* renamed from: com.acse.ottn.l1$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\6329136.dex */
        public class RunnableC0091a implements Runnable {
            public RunnableC0091a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (Settings.canDrawOverlays(a.this.f5882a)) {
                    com.acse.ottn.b.d().e(a.this.f5882a);
                    if (a.this.f5883b) {
                        com.acse.ottn.b.d().e(a.this.f5882a);
                    }
                }
            }
        }

        public a(AccessibilityService accessibilityService, boolean z3) {
            this.f5882a = accessibilityService;
            this.f5883b = z3;
        }

        @Override // com.acse.ottn.l0.d
        public void a(long j4) {
            try {
                AccessibilityNodeInfo g4 = com.acse.ottn.b.d().g(this.f5882a, "\u5728\u5176\u4ed6\u5e94\u7528\u4e0a\u5c42\u663e\u793a");
                if (g4 == null && !c4.s()) {
                    if (g4 == null) {
                        g4 = com.acse.ottn.b.d().f(this.f5882a, "android:id/summary");
                    }
                    if (g4 == null || g4.getParent().getParent() == null) {
                        return;
                    }
                    TimerTask timerTask = l1.f5879d;
                    if (timerTask != null) {
                        timerTask.cancel();
                        l1.f5879d = null;
                    }
                    Rect rect = new Rect();
                    g4.getBoundsInScreen(rect);
                    Rect rect2 = new Rect();
                    g4.getBoundsInParent(rect2);
                    l1.f(this.f5882a);
                    int c4 = c4.c(HelpShopAppUtil.getContext());
                    int i4 = (rect.top - (rect2.bottom / 2)) - 30;
                    int i5 = c4 - 80;
                    if (Build.VERSION.SDK_INT >= 24) {
                        com.acse.ottn.b.d().a(this.f5882a, i5, i4);
                        new Handler(Looper.getMainLooper()).postDelayed(new RunnableC0091a(), 300L);
                    }
                } else if (g4 != null && g4.getParent() != null) {
                    TimerTask timerTask2 = l1.f5879d;
                    if (timerTask2 != null) {
                        timerTask2.cancel();
                        l1.f5879d = null;
                    }
                    for (int i6 = 0; i6 < g4.getParent().getChildCount(); i6++) {
                        if (g4.getParent().getChild(i6) != null && "android.widget.Switch".equals(g4.getParent().getChild(i6).getClassName())) {
                            com.acse.ottn.b.d().g(g4.getParent().getChild(i6));
                            com.acse.ottn.b.d().e(this.f5882a);
                            if (this.f5883b) {
                                com.acse.ottn.b.d().e(this.f5882a);
                                return;
                            }
                            return;
                        }
                    }
                }
            } catch (Throwable th) {
                z1.a(l1.f5876a, "e =" + th.getMessage());
            }
        }

        @Override // com.acse.ottn.l0.d
        public void a() {
            l1.f5879d = null;
        }
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
                z1.b(f5876a, Log.getStackTraceString(e4));
            }
        } else {
            z1.b(f5876a, "Below API 19 cannot invoke!");
        }
        return false;
    }

    @RequiresApi(api = 16)
    public static void a(AccessibilityService accessibilityService, long j4, boolean z3) {
        if (j4 - f5878c.longValue() < 1000) {
            z1.a(f5876a, "\u95f4\u9694 t=" + j4 + "   System.currentTimeMillis() =" + System.currentTimeMillis());
            z1.a(f5876a, "\u95f4\u9694 time=" + f5878c + "   System.currentTimeMillis()-time =" + (System.currentTimeMillis() - f5878c.longValue()));
            return;
        }
        z1.a(f5876a, "\u65e0\u95f4\u9694 t=" + j4 + "   System.currentTimeMillis() =" + System.currentTimeMillis());
        z1.a(f5876a, "\u65e0\u95f4\u9694 time=" + f5878c + "   System.currentTimeMillis()-time =" + (System.currentTimeMillis() - f5878c.longValue()));
        f5878c = Long.valueOf(j4);
        f5879d = l0.a().b(q0.a().b(5000), q0.a().b(200), new a(accessibilityService, z3));
    }

    @RequiresApi(api = 16)
    public static void a(AccessibilityService accessibilityService, boolean z3) {
        f5879d = l0.a().b(q0.a().b(6000), q0.a().b(100), new e(accessibilityService));
    }

    public static void a(Activity activity) {
        if (g1.a().d("OpenPermissionName").equals("\u6743\u9650\u7ba1\u7406")) {
            g1.a().a("background_battery_hignt", true);
        }
        ComponentName componentName = null;
        int i4 = Build.VERSION.SDK_INT;
        Intent intent = new Intent();
        try {
            if (i4 >= 28) {
                componentName = ComponentName.unflattenFromString("com.huawei.systemmanager/.startupmgr.ui.StartupNormalAppListActivity");
            } else if (i4 >= 26) {
                componentName = ComponentName.unflattenFromString("com.huawei.systemmanager/.appcontrol.activity.StartupAppControlActivity");
            } else if (i4 >= 23) {
                componentName = ComponentName.unflattenFromString("com.huawei.systemmanager/.startupmgr.ui.StartupNormalAppListActivity");
            } else if (i4 >= 21) {
                componentName = ComponentName.unflattenFromString("com.huawei.systemmanager/com.huawei.permissionmanager.ui.MainActivity");
            }
            intent.setComponent(componentName);
            activity.startActivity(intent);
        } catch (Exception e4) {
            try {
                intent.setComponent(ComponentName.unflattenFromString("com.android.settings/.Settings$AppAndNotificationDashboardActivity"));
                activity.startActivity(intent);
            } catch (Exception unused) {
                z1.b(f5876a, e4.getMessage().toString());
            }
        }
    }

    @SuppressLint({"NewApi"})
    public static void a(AccessibilityService accessibilityService, AccessibilityNodeInfo accessibilityNodeInfo) {
        AccessibilityNodeInfo accessibilityNodeInfo2;
        if (accessibilityNodeInfo != null) {
            int i4 = 0;
            while (true) {
                if (i4 >= accessibilityNodeInfo.getChildCount()) {
                    accessibilityNodeInfo2 = null;
                    break;
                } else if (accessibilityNodeInfo.getChild(i4) != null && "android.widget.ListView".equals(accessibilityNodeInfo.getChild(i4).getClassName()) && accessibilityNodeInfo.getChild(i4).getChildCount() > 0) {
                    accessibilityNodeInfo2 = accessibilityNodeInfo.getChild(i4);
                    break;
                } else {
                    if (accessibilityNodeInfo.getChild(i4) != null) {
                        a(accessibilityService, accessibilityNodeInfo.getChild(i4));
                    }
                    i4++;
                }
            }
            if (accessibilityNodeInfo2 == null) {
                return;
            }
            f5879d = l0.a().b(q0.a().b(3000), q0.a().b(100), new f(accessibilityService, accessibilityNodeInfo2));
        }
    }
}
