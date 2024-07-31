package com.acse.ottn.util;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.RequiresApi;
import com.acse.ottn.p045e.C1551a;
import java.lang.ref.WeakReference;

/* renamed from: com.acse.ottn.util.aa */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1658aa {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: a */
    private static volatile C1658aa f3290a = null;

    /* renamed from: b */
    private static String f3291b = "HelpShopActivityManager";

    /* renamed from: c */
    private Activity f3292c;

    /* renamed from: d */
    private C1659a f3293d;

    /* renamed from: e */
    private final BroadcastReceiver f3294e = new C1655Y(this);

    /* renamed from: f */
    private final BroadcastReceiver f3295f = new C1656Z(this);

    /* renamed from: com.acse.ottn.util.aa$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    private class C1659a implements Application.ActivityLifecycleCallbacks {
        private C1659a() {
        }

        /* synthetic */ C1659a(C1658aa c1658aa, C1655Y c1655y) {
            this();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            C1551a.f2896m.add(new WeakReference<>(activity));
            String str = C1658aa.f3291b;
            C1694ra.m55917a(str, "onActivityCreated=" + activity.getLocalClassName());
            C1658aa.this.f3292c = activity;
            if (C1658aa.this.m56109a(activity, true)) {
                C1658aa.this.m56098e();
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            for (int size = C1551a.f2896m.size() - 1; size >= 0; size--) {
                if (C1551a.f2896m.get(size).get() == activity) {
                    C1551a.f2896m.remove(size);
                }
            }
            try {
                activity.unregisterReceiver(C1658aa.this.f3294e);
                activity.unregisterReceiver(C1658aa.this.f3295f);
            } catch (Exception unused) {
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            C1658aa.this.f3292c = null;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            C1658aa.this.f3292c = activity;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        @RequiresApi(api = 21)
        public void onActivityStopped(Activity activity) {
            if (C1658aa.this.m56109a(activity, false)) {
                C1694ra.m55917a(C1658aa.f3291b, " current activity stop=开始结束");
                activity.finishAndRemoveTask();
            }
        }
    }

    private C1658aa(Application application) {
        C1659a c1659a = new C1659a(this, null);
        this.f3293d = c1659a;
        application.registerActivityLifecycleCallbacks(c1659a);
    }

    /* renamed from: a */
    public static void m56108a(Application application) {
        if (f3290a == null) {
            synchronized (C1658aa.class) {
                if (f3290a == null) {
                    for (int size = C1551a.f2896m.size() - 1; size >= 0; size--) {
                        C1551a.f2896m.remove(size);
                    }
                    f3290a = new C1658aa(application);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public boolean m56109a(Activity activity, boolean z) {
        try {
            if (!"com.acse.ottn.activity.ExcessActivity".contains(activity.getLocalClassName()) && !"com.acse.ottn.activity.SeedingLoadingActivity".contains(activity.getLocalClassName())) {
                if (!"com.acse.ottn.activity.WhiteActivity".contains(activity.getLocalClassName())) {
                    return false;
                }
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    /* renamed from: c */
    public static C1658aa m56102c() {
        if (f3290a != null) {
            return f3290a;
        }
        throw new Error("PGYER Analytic SDK init PgyerActivityManager is error.");
    }

    /* renamed from: d */
    public static boolean m56100d() {
        return f3290a != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m56098e() {
        this.f3292c.registerReceiver(this.f3294e, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
        this.f3292c.registerReceiver(this.f3295f, new IntentFilter("android.intent.action.SCREEN_OFF"));
        Log.d(f3291b, "注册");
    }

    /* renamed from: b */
    public Activity m56104b() {
        return this.f3292c;
    }
}
