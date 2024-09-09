package com.bytedance.sdk.openadsdk.xv;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
class c implements Application.ActivityLifecycleCallbacks {

    /* renamed from: c  reason: collision with root package name */
    private static volatile boolean f36393c;

    /* renamed from: w  reason: collision with root package name */
    private int f36394w = 0;
    private InterfaceC0534c xv;

    /* renamed from: com.bytedance.sdk.openadsdk.xv.c$c  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    public interface InterfaceC0534c {
        void c();

        void w();
    }

    public Boolean c() {
        return Boolean.valueOf(f36393c);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        this.f36394w++;
        f36393c = false;
        InterfaceC0534c interfaceC0534c = this.xv;
        if (interfaceC0534c != null) {
            interfaceC0534c.w();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        int i4 = this.f36394w - 1;
        this.f36394w = i4;
        if (i4 == 0) {
            f36393c = true;
            InterfaceC0534c interfaceC0534c = this.xv;
            if (interfaceC0534c != null) {
                interfaceC0534c.c();
            }
        }
    }

    public void c(InterfaceC0534c interfaceC0534c) {
        this.xv = interfaceC0534c;
    }
}
