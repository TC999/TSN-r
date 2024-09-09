package com.acse.ottn.util;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.RequiresApi;
import java.lang.ref.WeakReference;

/* renamed from: com.acse.ottn.util.aa  reason: case insensitive filesystem */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class C1417aa {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: a  reason: collision with root package name */
    private static volatile C1417aa f6800a = null;

    /* renamed from: b  reason: collision with root package name */
    private static String f6801b = "HelpShopActivityManager";

    /* renamed from: c  reason: collision with root package name */
    private Activity f6802c;

    /* renamed from: d  reason: collision with root package name */
    private a f6803d;

    /* renamed from: e  reason: collision with root package name */
    private final BroadcastReceiver f6804e = new Y(this);

    /* renamed from: f  reason: collision with root package name */
    private final BroadcastReceiver f6805f = new Z(this);

    /* renamed from: com.acse.ottn.util.aa$a */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    private class a implements Application.ActivityLifecycleCallbacks {
        private a() {
        }

        /* synthetic */ a(C1417aa c1417aa, Y y3) {
            this();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            com.acse.ottn.e.a.f5625m.add(new WeakReference<>(activity));
            String str = C1417aa.f6801b;
            ra.a(str, "onActivityCreated=" + activity.getLocalClassName());
            C1417aa.this.f6802c = activity;
            if (C1417aa.this.a(activity, true)) {
                C1417aa.this.e();
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            for (int size = com.acse.ottn.e.a.f5625m.size() - 1; size >= 0; size--) {
                if (com.acse.ottn.e.a.f5625m.get(size).get() == activity) {
                    com.acse.ottn.e.a.f5625m.remove(size);
                }
            }
            try {
                activity.unregisterReceiver(C1417aa.this.f6804e);
                activity.unregisterReceiver(C1417aa.this.f6805f);
            } catch (Exception unused) {
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            C1417aa.this.f6802c = null;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            C1417aa.this.f6802c = activity;
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
            if (C1417aa.this.a(activity, false)) {
                ra.a(C1417aa.f6801b, " current activity stop=\u5f00\u59cb\u7ed3\u675f");
                activity.finishAndRemoveTask();
            }
        }
    }

    private C1417aa(Application application) {
        a aVar = new a(this, null);
        this.f6803d = aVar;
        application.registerActivityLifecycleCallbacks(aVar);
    }

    public static void a(Application application) {
        if (f6800a == null) {
            synchronized (C1417aa.class) {
                if (f6800a == null) {
                    for (int size = com.acse.ottn.e.a.f5625m.size() - 1; size >= 0; size--) {
                        com.acse.ottn.e.a.f5625m.remove(size);
                    }
                    f6800a = new C1417aa(application);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(Activity activity, boolean z3) {
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

    public static C1417aa c() {
        if (f6800a != null) {
            return f6800a;
        }
        throw new Error("PGYER Analytic SDK init PgyerActivityManager is error.");
    }

    public static boolean d() {
        return f6800a != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.f6802c.registerReceiver(this.f6804e, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
        this.f6802c.registerReceiver(this.f6805f, new IntentFilter("android.intent.action.SCREEN_OFF"));
        Log.d(f6801b, "\u6ce8\u518c");
    }

    public Activity b() {
        return this.f6802c;
    }
}
