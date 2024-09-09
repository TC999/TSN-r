package defpackage;

import android.app.ActivityThread;
import android.app.LoadedApk;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.IBinder;
import android.os.Process;
import android.os.RemoteException;
import android.webkit.WebViewFactory;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import ulL.WeEFDVoZmmWVmW.yXd.XposedBridge;
import ulL.WeEFDVoZmmWVmW.yXd.XposedHelpers;

/* renamed from: E0  reason: default package */
/* loaded from: E:\TSN-r\205dec\155424.dex */
public abstract class E0 {

    /* renamed from: a  reason: collision with root package name */
    public static PackageInfo f14a = null;

    /* renamed from: b  reason: collision with root package name */
    public static int f15b = -1;

    /* renamed from: c  reason: collision with root package name */
    public static final ConcurrentHashMap f16c = new ConcurrentHashMap();

    /* renamed from: d  reason: collision with root package name */
    public static final ConcurrentHashMap f17d = new ConcurrentHashMap();

    public static void a(B b4, Intent intent) {
        if (b4 != null && Process.myUid() == 2000) {
            if (intent.getCategories() == null || !intent.getCategories().contains("org.lsposed.manager.LAUNCH_MANAGER")) {
                AbstractC1457e.d("Launching the original app, restarting");
                try {
                    try {
                        ((C1488z) b4).f(intent);
                    } catch (RemoteException e4) {
                        AbstractC1457e.e("restart failed", e4);
                    }
                } finally {
                    Process.killProcess(Process.myPid());
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00b3 A[Catch: all -> 0x0082, TryCatch #4 {all -> 0x00c6, blocks: (B:4:0x0005, B:46:0x00c8, B:7:0x000b, B:9:0x0027, B:35:0x007c, B:38:0x0084, B:40:0x00b3, B:41:0x00b7), top: B:51:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static synchronized android.content.pm.PackageInfo b(android.content.pm.ApplicationInfo r13) {
        /*
            Method dump skipped, instructions count: 206
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.E0.b(android.content.pm.ApplicationInfo):android.content.pm.PackageInfo");
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [ulL.WeEFDVoZmmWVmW.yXd.XC_MethodHook$Unhook[], java.io.Serializable] */
    public static void c(B b4) {
        XposedHelpers.findAndHookMethod(ActivityThread.class, "handleBindApplication", "android.app.ActivityThread$AppBindData", new C1460f0(1));
        ?? r02 = {0};
        r02[0] = XposedHelpers.findAndHookMethod(LoadedApk.class, "getClassLoader", new z0(b4, r02, 0));
        Class findClass = XposedHelpers.findClass("android.app.ActivityThread$ActivityClientRecord", ActivityThread.class.getClassLoader());
        z0 z0Var = new z0(b4, findClass, 1);
        XposedBridge.hookAllConstructors(findClass, z0Var);
        int i4 = Build.VERSION.SDK_INT;
        if (i4 <= 27) {
            XposedBridge.hookAllMethods(XposedHelpers.findClass("android.app.ActivityThread$ApplicationThread", ActivityThread.class.getClassLoader()), "scheduleLaunchActivity", z0Var);
        }
        XposedBridge.hookAllMethods(ActivityThread.class, "handleReceiver", new C0(0));
        XposedBridge.hookAllMethods(ActivityThread.class, "installProvider", new C1456d0());
        XposedHelpers.findAndHookMethod(ActivityThread.class, "deliverNewIntents", findClass, List.class, new C1456d0(2, b4));
        XposedHelpers.findAndHookMethod(WebViewFactory.class, "getProvider", new C0(1));
        C1460f0 c1460f0 = new C1460f0(2);
        XposedBridge.hookAllMethods(ActivityThread.class, "performStopActivityInner", c1460f0);
        if (i4 <= 27) {
            Class cls = Boolean.TYPE;
            XposedHelpers.findAndHookMethod(ActivityThread.class, "performDestroyActivity", IBinder.class, cls, Integer.TYPE, cls, c1460f0);
        }
    }
}
