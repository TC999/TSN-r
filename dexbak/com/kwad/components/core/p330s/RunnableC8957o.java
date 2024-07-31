package com.kwad.components.core.p330s;

import java.lang.ref.WeakReference;

/* renamed from: com.kwad.components.core.s.o */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class RunnableC8957o implements Runnable {
    private WeakReference<Runnable> weakReference;

    public RunnableC8957o(Runnable runnable) {
        this.weakReference = new WeakReference<>(runnable);
    }

    @Override // java.lang.Runnable
    public final void run() {
        Runnable runnable = this.weakReference.get();
        if (runnable != null) {
            runnable.run();
        }
    }
}
