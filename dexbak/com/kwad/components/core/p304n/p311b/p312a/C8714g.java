package com.kwad.components.core.p304n.p311b.p312a;

import android.app.Activity;
import android.os.Bundle;
import com.kwad.components.offline.api.core.api.ILifeCycle;
import com.kwad.components.offline.api.core.api.ILifeCycleListener;
import com.kwad.sdk.api.core.KSLifecycleListener;
import com.kwad.sdk.api.core.KSLifecycleObserver;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.kwad.components.core.n.b.a.g */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8714g implements ILifeCycle {

    /* renamed from: MI */
    private AtomicInteger f28382MI = new AtomicInteger(1);

    /* renamed from: MJ */
    private Map<Integer, KSLifecycleListener> f28383MJ = new HashMap();

    @Override // com.kwad.components.offline.api.core.api.ILifeCycle
    public final Activity getCurrentActivity() {
        return KSLifecycleObserver.getInstance().getCurrentActivity();
    }

    @Override // com.kwad.components.offline.api.core.api.ILifeCycle
    public final boolean isAppOnForeground() {
        return KSLifecycleObserver.getInstance().isAppOnForeground();
    }

    @Override // com.kwad.components.offline.api.core.api.ILifeCycle
    public final int registerLifeCycleListener(final ILifeCycleListener iLifeCycleListener) {
        KSLifecycleListener kSLifecycleListener = new KSLifecycleListener() { // from class: com.kwad.components.core.n.b.a.g.1
            @Override // com.kwad.sdk.api.core.KSLifecycleListener
            public final void onActivityCreated(Activity activity, Bundle bundle) {
                ILifeCycleListener iLifeCycleListener2 = iLifeCycleListener;
                if (iLifeCycleListener2 != null) {
                    iLifeCycleListener2.onActivityCreated(activity, bundle);
                }
            }

            @Override // com.kwad.sdk.api.core.KSLifecycleListener
            public final void onActivityDestroyed(Activity activity) {
                ILifeCycleListener iLifeCycleListener2 = iLifeCycleListener;
                if (iLifeCycleListener2 != null) {
                    iLifeCycleListener2.onActivityDestroyed(activity);
                }
            }

            @Override // com.kwad.sdk.api.core.KSLifecycleListener
            public final void onActivityPaused(Activity activity) {
                ILifeCycleListener iLifeCycleListener2 = iLifeCycleListener;
                if (iLifeCycleListener2 != null) {
                    iLifeCycleListener2.onActivityPaused(activity);
                }
            }

            @Override // com.kwad.sdk.api.core.KSLifecycleListener
            public final void onActivityResumed(Activity activity) {
                ILifeCycleListener iLifeCycleListener2 = iLifeCycleListener;
                if (iLifeCycleListener2 != null) {
                    iLifeCycleListener2.onActivityResumed(activity);
                }
            }

            @Override // com.kwad.sdk.api.core.KSLifecycleListener
            public final void onBackToBackground() {
                ILifeCycleListener iLifeCycleListener2 = iLifeCycleListener;
                if (iLifeCycleListener2 != null) {
                    iLifeCycleListener2.onBackToBackground();
                }
            }

            @Override // com.kwad.sdk.api.core.KSLifecycleListener
            public final void onBackToForeground() {
                ILifeCycleListener iLifeCycleListener2 = iLifeCycleListener;
                if (iLifeCycleListener2 != null) {
                    iLifeCycleListener2.onBackToForeground();
                }
            }
        };
        KSLifecycleObserver.getInstance().registerLifecycleListener(kSLifecycleListener);
        int incrementAndGet = this.f28382MI.incrementAndGet();
        this.f28383MJ.put(Integer.valueOf(incrementAndGet), kSLifecycleListener);
        return incrementAndGet;
    }

    @Override // com.kwad.components.offline.api.core.api.ILifeCycle
    public final void unregisterLifeCycleListener(int i) {
        KSLifecycleListener kSLifecycleListener = this.f28383MJ.get(Integer.valueOf(i));
        if (kSLifecycleListener != null) {
            KSLifecycleObserver.getInstance().unRegisterLifecycleListener(kSLifecycleListener);
        }
        this.f28383MJ.remove(Integer.valueOf(i));
    }
}
