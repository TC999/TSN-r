package com.bytedance.msdk.adapter;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.lang.ref.WeakReference;

/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class SplashDismissController {

    /* renamed from: a  reason: collision with root package name */
    private WeakReference<Activity> f26878a;

    /* renamed from: d  reason: collision with root package name */
    private CallBack f26881d;

    /* renamed from: b  reason: collision with root package name */
    private boolean f26879b = false;

    /* renamed from: c  reason: collision with root package name */
    private boolean f26880c = false;

    /* renamed from: e  reason: collision with root package name */
    private boolean f26882e = false;

    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public interface CallBack {
        void onResume();
    }

    public SplashDismissController(Activity activity) {
        this.f26878a = new WeakReference<>(activity);
        c();
    }

    private void c() {
        Activity activity = this.f26878a.get();
        if (activity != null) {
            activity.getApplication().registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() { // from class: com.bytedance.msdk.adapter.SplashDismissController.1
                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityCreated(Activity activity2, Bundle bundle) {
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityDestroyed(Activity activity2) {
                    SplashDismissController.this.f26881d = null;
                    if (SplashDismissController.this.f26878a == null || SplashDismissController.this.f26878a.get() != activity2) {
                        return;
                    }
                    activity2.getApplication().unregisterActivityLifecycleCallbacks(this);
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityPaused(Activity activity2) {
                    if (SplashDismissController.this.f26878a == null || SplashDismissController.this.f26878a.get() != activity2) {
                        return;
                    }
                    SplashDismissController.this.f26880c = true;
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityResumed(Activity activity2) {
                    if (SplashDismissController.this.f26878a == null || SplashDismissController.this.f26878a.get() != activity2 || SplashDismissController.this.f26881d == null) {
                        return;
                    }
                    SplashDismissController.this.f26881d.onResume();
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
        return this.f26882e;
    }

    public boolean jumpToAdPage() {
        return this.f26879b && this.f26880c;
    }

    public void setCallBack(CallBack callBack) {
        this.f26881d = callBack;
    }

    public void setCallDismiss(boolean z3) {
        this.f26882e = z3;
    }

    public void setClick(boolean z3) {
        this.f26879b = z3;
    }
}
