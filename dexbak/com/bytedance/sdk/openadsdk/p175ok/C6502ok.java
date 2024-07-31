package com.bytedance.sdk.openadsdk.p175ok;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/* renamed from: com.bytedance.sdk.openadsdk.ok.ok */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
class C6502ok implements Application.ActivityLifecycleCallbacks {

    /* renamed from: ok */
    private static volatile boolean f22877ok;

    /* renamed from: a */
    private int f22878a = 0;

    /* renamed from: bl */
    private InterfaceC6503ok f22879bl;

    /* renamed from: com.bytedance.sdk.openadsdk.ok.ok$ok */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public interface InterfaceC6503ok {
        /* renamed from: a */
        void mo36193a();

        /* renamed from: ok */
        void mo36192ok();
    }

    /* renamed from: ok */
    public Boolean m36195ok() {
        return Boolean.valueOf(f22877ok);
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
        this.f22878a++;
        f22877ok = false;
        InterfaceC6503ok interfaceC6503ok = this.f22879bl;
        if (interfaceC6503ok != null) {
            interfaceC6503ok.mo36193a();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        int i = this.f22878a - 1;
        this.f22878a = i;
        if (i == 0) {
            f22877ok = true;
            InterfaceC6503ok interfaceC6503ok = this.f22879bl;
            if (interfaceC6503ok != null) {
                interfaceC6503ok.mo36192ok();
            }
        }
    }

    /* renamed from: ok */
    public void m36194ok(InterfaceC6503ok interfaceC6503ok) {
        this.f22879bl = interfaceC6503ok;
    }
}
