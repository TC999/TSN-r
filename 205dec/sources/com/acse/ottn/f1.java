package com.acse.ottn;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.RequiresApi;
import java.lang.ref.WeakReference;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class f1 {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: e  reason: collision with root package name */
    public static volatile f1 f5644e = null;

    /* renamed from: f  reason: collision with root package name */
    public static String f5645f = "HelpShopActivityManager";

    /* renamed from: a  reason: collision with root package name */
    public Activity f5646a;

    /* renamed from: b  reason: collision with root package name */
    public c f5647b;

    /* renamed from: c  reason: collision with root package name */
    public final BroadcastReceiver f5648c = new a();

    /* renamed from: d  reason: collision with root package name */
    public final BroadcastReceiver f5649d = new b();

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class a extends BroadcastReceiver {

        /* renamed from: a  reason: collision with root package name */
        public final String f5650a = "reason";

        /* renamed from: b  reason: collision with root package name */
        public final String f5651b = "homekey";

        /* renamed from: c  reason: collision with root package name */
        public final String f5652c = "recentapps";

        public a() {
        }

        @Override // android.content.BroadcastReceiver
        @RequiresApi(api = 21)
        public void onReceive(Context context, Intent intent) {
            String stringExtra;
            String action = intent.getAction();
            Log.d(f1.f5645f, "\u6536\u5230\u6ce8\u518c\u5e7f\u64ad");
            if (!action.equals("android.intent.action.CLOSE_SYSTEM_DIALOGS") || (stringExtra = intent.getStringExtra("reason")) == null) {
                return;
            }
            if (f1.this.f5646a == null) {
                Log.d(f1.f5645f, "\u7ed3\u675f\u5f53\u524dactivity1 ==null");
            } else {
                f1 f1Var = f1.this;
                if (f1Var.a(f1Var.f5646a, true)) {
                    Log.d(f1.f5645f, "\u7ed3\u675f\u5f53\u524dactivity1");
                    f1.this.f5646a.finishAndRemoveTask();
                }
            }
            if (stringExtra.equals("homekey")) {
                return;
            }
            stringExtra.equals("recentapps");
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class b extends BroadcastReceiver {
        public b() {
        }

        @Override // android.content.BroadcastReceiver
        @RequiresApi(api = 21)
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            Log.d(f1.f5645f, "\u6536\u5230\u6ce8\u518c\u5e7f\u64ad2");
            if ("android.intent.action.SCREEN_OFF".equals(action)) {
                if (f1.this.f5646a != null) {
                    Log.d(f1.f5645f, "\u7ed3\u675f\u5f53\u524dactivity2");
                    f1.this.f5646a.finishAndRemoveTask();
                    return;
                }
                Log.d(f1.f5645f, "\u7ed3\u675f\u5f53\u524dactivity2 ==null");
            }
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class c implements Application.ActivityLifecycleCallbacks {
        public c() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            o.f6075m.add(new WeakReference<>(activity));
            String str = f1.f5645f;
            z1.a(str, "onActivityCreated=" + activity.getLocalClassName());
            f1.this.f5646a = activity;
            if (f1.this.a(activity, true)) {
                f1.this.e();
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            for (int size = o.f6075m.size() - 1; size >= 0; size--) {
                if (o.f6075m.get(size).get() == activity) {
                    o.f6075m.remove(size);
                }
            }
            try {
                activity.unregisterReceiver(f1.this.f5648c);
                activity.unregisterReceiver(f1.this.f5649d);
            } catch (Exception e4) {
                Log.d(f1.f5645f, e4.getMessage());
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            f1.this.f5646a = null;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            f1.this.f5646a = activity;
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
            if (f1.this.a(activity, false)) {
                z1.a(f1.f5645f, " current activity stop=\u5f00\u59cb\u7ed3\u675f");
                activity.finishAndRemoveTask();
            }
        }

        public /* synthetic */ c(f1 f1Var, a aVar) {
            this();
        }
    }

    public f1(Application application) {
        c cVar = new c(this, null);
        this.f5647b = cVar;
        application.registerActivityLifecycleCallbacks(cVar);
    }

    public final void e() {
        this.f5646a.registerReceiver(this.f5648c, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
        this.f5646a.registerReceiver(this.f5649d, new IntentFilter("android.intent.action.SCREEN_OFF"));
        Log.d(f5645f, "\u6ce8\u518c");
    }

    public static f1 c() {
        if (f5644e != null) {
            return f5644e;
        }
        throw new Error("PGYER Analytic SDK init PgyerActivityManager is error.");
    }

    public static boolean d() {
        return f5644e != null;
    }

    public Activity b() {
        return this.f5646a;
    }

    public static void a(Application application) {
        if (f5644e == null) {
            synchronized (f1.class) {
                if (f5644e == null) {
                    for (int size = o.f6075m.size() - 1; size >= 0; size--) {
                        o.f6075m.remove(size);
                    }
                    f5644e = new f1(application);
                }
            }
        }
    }

    public final boolean a(Activity activity, boolean z3) {
        try {
            if (!"com.acse.ottn.activity.ExcessActivity".contains(activity.getLocalClassName()) && !"com.acse.ottn.activity.SeedingLoadingActivity".contains(activity.getLocalClassName())) {
                if (!"com.acse.ottn.activity.WhiteActivity".contains(activity.getLocalClassName())) {
                    return false;
                }
            }
            return true;
        } catch (Exception e4) {
            Log.d(f5645f, e4.getMessage());
            return false;
        }
    }
}
