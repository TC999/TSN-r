package com.bytedance.msdk.adapter;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.lang.ref.WeakReference;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class SplashDismissController {

    /* renamed from: a */
    private WeakReference<Activity> f21294a;

    /* renamed from: d */
    private CallBack f21297d;

    /* renamed from: b */
    private boolean f21295b = false;

    /* renamed from: c */
    private boolean f21296c = false;

    /* renamed from: e */
    private boolean f21298e = false;

    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public interface CallBack {
        void onResume();
    }

    public SplashDismissController(Activity activity) {
        this.f21294a = new WeakReference<>(activity);
        m37886c();
    }

    /* renamed from: c */
    private void m37886c() {
        Activity activity = this.f21294a.get();
        if (activity != null) {
            activity.getApplication().registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() { // from class: com.bytedance.msdk.adapter.SplashDismissController.1
                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityCreated(Activity activity2, Bundle bundle) {
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityDestroyed(Activity activity2) {
                    SplashDismissController.this.f21297d = null;
                    if (SplashDismissController.this.f21294a == null || SplashDismissController.this.f21294a.get() != activity2) {
                        return;
                    }
                    activity2.getApplication().unregisterActivityLifecycleCallbacks(this);
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityPaused(Activity activity2) {
                    if (SplashDismissController.this.f21294a == null || SplashDismissController.this.f21294a.get() != activity2) {
                        return;
                    }
                    SplashDismissController.this.f21296c = true;
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityResumed(Activity activity2) {
                    if (SplashDismissController.this.f21294a == null || SplashDismissController.this.f21294a.get() != activity2 || SplashDismissController.this.f21297d == null) {
                        return;
                    }
                    SplashDismissController.this.f21297d.onResume();
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivitySaveInstanceState(Activity activity2, Bundle bundle) {
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityStarted(Activity activity2) {
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityStopped(Activity activity2) {
                }
            });
        }
    }

    public boolean isCallDismiss() {
        return this.f21298e;
    }

    public boolean jumpToAdPage() {
        return this.f21295b && this.f21296c;
    }

    public void setCallBack(CallBack callBack) {
        this.f21297d = callBack;
    }

    public void setCallDismiss(boolean z) {
        this.f21298e = z;
    }

    public void setClick(boolean z) {
        this.f21295b = z;
    }
}
