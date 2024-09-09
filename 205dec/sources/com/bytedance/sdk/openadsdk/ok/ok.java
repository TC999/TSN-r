package com.bytedance.sdk.openadsdk.ok;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/* loaded from: E:\TSN-r\205dec\5141176.dex */
class ok implements Application.ActivityLifecycleCallbacks {
    private static volatile boolean ok;

    /* renamed from: a  reason: collision with root package name */
    private int f36254a = 0;
    private InterfaceC0531ok bl;

    /* renamed from: com.bytedance.sdk.openadsdk.ok.ok$ok  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public interface InterfaceC0531ok {
        void a();

        void ok();
    }

    public Boolean ok() {
        return Boolean.valueOf(ok);
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
        this.f36254a++;
        ok = false;
        InterfaceC0531ok interfaceC0531ok = this.bl;
        if (interfaceC0531ok != null) {
            interfaceC0531ok.a();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        int i4 = this.f36254a - 1;
        this.f36254a = i4;
        if (i4 == 0) {
            ok = true;
            InterfaceC0531ok interfaceC0531ok = this.bl;
            if (interfaceC0531ok != null) {
                interfaceC0531ok.ok();
            }
        }
    }

    public void ok(InterfaceC0531ok interfaceC0531ok) {
        this.bl = interfaceC0531ok;
    }
}
