package com.acse.ottn.banner.util;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;

/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class BannerLifecycleObserverAdapter implements LifecycleObserver {

    /* renamed from: a */
    private final InterfaceC1467a f2696a;

    /* renamed from: b */
    private final LifecycleOwner f2697b;

    public BannerLifecycleObserverAdapter(LifecycleOwner lifecycleOwner, InterfaceC1467a interfaceC1467a) {
        this.f2697b = lifecycleOwner;
        this.f2696a = interfaceC1467a;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {
        C1469c.m56697c("onDestroy");
        this.f2696a.onDestroy(this.f2697b);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onStart() {
        C1469c.m56697c("onStart");
        this.f2696a.onStart(this.f2697b);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onStop() {
        C1469c.m56697c("onStop");
        this.f2696a.onStop(this.f2697b);
    }
}
