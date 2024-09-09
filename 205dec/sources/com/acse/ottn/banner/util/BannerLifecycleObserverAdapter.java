package com.acse.ottn.banner.util;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.acse.ottn.a2;
import com.acse.ottn.x;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class BannerLifecycleObserverAdapter implements LifecycleObserver {

    /* renamed from: a  reason: collision with root package name */
    public final x f5297a;

    /* renamed from: b  reason: collision with root package name */
    public final LifecycleOwner f5298b;

    public BannerLifecycleObserverAdapter(LifecycleOwner lifecycleOwner, x xVar) {
        this.f5298b = lifecycleOwner;
        this.f5297a = xVar;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {
        a2.c("onDestroy");
        this.f5297a.a(this.f5298b);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onStart() {
        a2.c("onStart");
        this.f5297a.b(this.f5298b);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onStop() {
        a2.c("onStop");
        this.f5297a.c(this.f5298b);
    }
}
