package com.bytedance.msdk.f;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class k {

    /* renamed from: c  reason: collision with root package name */
    private c f28330c;

    /* renamed from: w  reason: collision with root package name */
    private final Application.ActivityLifecycleCallbacks f28331w = new Application.ActivityLifecycleCallbacks() { // from class: com.bytedance.msdk.f.k.1

        /* renamed from: w  reason: collision with root package name */
        private int f28333w = 0;

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
            int i4 = this.f28333w + 1;
            this.f28333w = i4;
            if (i4 != 1 || k.this.f28330c == null) {
                return;
            }
            k.this.f28330c.c();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            int i4 = this.f28333w - 1;
            this.f28333w = i4;
            if (i4 != 0 || k.this.f28330c == null) {
                return;
            }
            k.this.f28330c.w();
        }
    };

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface c {
        void c();

        void w();
    }

    public void c(Application application, c cVar) {
        if (application != null) {
            this.f28330c = cVar;
            application.registerActivityLifecycleCallbacks(this.f28331w);
        }
    }

    public void c(Application application) {
        if (application != null) {
            application.unregisterActivityLifecycleCallbacks(this.f28331w);
        }
    }
}
