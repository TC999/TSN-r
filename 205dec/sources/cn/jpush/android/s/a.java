package cn.jpush.android.s;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.local.JPushConstants;
import com.stub.StubApp;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static int f4316a = 0;

    /* renamed from: b  reason: collision with root package name */
    private static WeakReference<Activity> f4317b = null;

    /* renamed from: c  reason: collision with root package name */
    private static String f4318c = "";

    /* renamed from: e  reason: collision with root package name */
    private static AtomicLong f4319e = new AtomicLong(System.currentTimeMillis());

    /* renamed from: d  reason: collision with root package name */
    private String f4320d;

    public static long a() {
        return f4319e.get();
    }

    public static Activity a(Context context) {
        return b(context);
    }

    private static Activity b(Context context) {
        try {
            if (f4317b != null) {
                Logger.d("InAppLifeListener", "mActivity is null, try to user weakActivity: " + f4317b);
                Activity activity = f4317b.get();
                if (activity != null && !activity.isFinishing()) {
                    Logger.dd("InAppLifeListener", "use weak activity, " + f4317b.get().getLocalClassName());
                    return activity;
                }
            }
            Activity j4 = cn.jpush.android.ad.a.j(context);
            if (j4 == null || j4.isFinishing()) {
                return null;
            }
            Logger.dd("InAppLifeListener", "use current stack activity, " + j4.getLocalClassName());
            f4317b = new WeakReference<>(j4);
            return null;
        } catch (Throwable th) {
            Logger.w("InAppLifeListener", "getActivityInternal error, " + th.getMessage());
            return null;
        }
    }

    public void a(Activity activity) {
        f4317b = new WeakReference<>(activity);
    }

    public void b(Activity activity) {
        cn.jpush.android.o.a a4;
        if (activity == null) {
            Logger.w("InAppLifeListener", "onActivityStarted activity is null");
            return;
        }
        try {
            String canonicalName = activity.getClass().getCanonicalName();
            Logger.d("InAppLifeListener", "[onActivityStarted], gLatestActivityName: " + f4318c + ", activityTaskCount: " + f4316a + " currentActivity: " + canonicalName);
            a(activity);
            Context appContext = JPushConstants.getAppContext(activity);
            String packageName = appContext.getPackageName();
            Logger.d("InAppLifeListener", "mLastPkg=" + this.f4320d + " currentPkg=" + packageName);
            if (f4316a != 0) {
                if (!TextUtils.equals(canonicalName, f4318c) && TextUtils.equals(packageName, this.f4320d)) {
                    Logger.d("InAppLifeListener", "use enter new activity,show inapp message");
                    a4 = cn.jpush.android.o.a.a();
                }
                f4318c = canonicalName;
                this.f4320d = packageName;
                f4316a++;
            }
            Logger.d("InAppLifeListener", "is foreground, change foreground state");
            f4319e.set(System.currentTimeMillis());
            a4 = cn.jpush.android.o.a.a();
            a4.a(appContext, true, canonicalName);
            f4318c = canonicalName;
            this.f4320d = packageName;
            f4316a++;
        } catch (Throwable th) {
            Logger.w("InAppLifeListener", "onActivityStarted error, " + th.getMessage());
        }
    }

    public void c(Activity activity) {
        a(activity);
    }

    public void d(Activity activity) {
        if (activity == null || f4317b.get() == null) {
            Logger.w("InAppLifeListener", "onActivityPaused activity is null");
            return;
        }
        try {
            if (f4317b.get() == activity) {
                f4317b = new WeakReference<>(null);
            }
        } catch (Throwable th) {
            Logger.w("InAppLifeListener", " onActivityDestroyed error, " + th.getMessage());
        }
    }

    public void e(Activity activity) {
        if (activity == null) {
            Logger.w("InAppLifeListener", "onActivityStopped activity is null");
            return;
        }
        try {
            String canonicalName = activity.getClass().getCanonicalName();
            Logger.d("InAppLifeListener", "[onActivityStopped], curClzName: " + canonicalName + ", latestCurClzName: " + f4318c + ", activityTaskCount: " + f4316a);
            cn.jpush.android.o.a.a().a(activity, canonicalName);
            JPushConstants.getAppContext(activity);
            int i4 = f4316a;
            if (i4 > 0) {
                f4316a = i4 - 1;
            }
            if (f4316a == 0 && !f4318c.equals(canonicalName)) {
                f4316a++;
            }
        } catch (Throwable th) {
            Logger.w("InAppLifeListener", "onActivityStopped error, " + th.getMessage());
        }
    }

    public void f(Activity activity) {
        Logger.d("InAppLifeListener", "[onActivityDestroyed]");
        if (activity == null) {
            Logger.w("InAppLifeListener", "onActivityDestroyed activity is null");
            return;
        }
        try {
            cn.jpush.android.o.a.a().a(StubApp.getOrigApplicationContext(activity.getApplicationContext()), activity.getClass().getCanonicalName());
        } catch (Throwable th) {
            Logger.w("InAppLifeListener", "onActivityDestroyed error, " + th.getMessage());
        }
    }
}
