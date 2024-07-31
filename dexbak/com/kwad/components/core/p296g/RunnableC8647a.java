package com.kwad.components.core.p296g;

import android.os.Handler;
import androidx.annotation.Nullable;

/* renamed from: com.kwad.components.core.g.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class RunnableC8647a implements Runnable {

    /* renamed from: LA */
    private long f28291LA = 1000;

    /* renamed from: LB */
    private boolean f28292LB = true;

    /* renamed from: LC */
    private long f28293LC = 0;

    /* renamed from: LD */
    private InterfaceC8648a f28294LD;
    @Nullable

    /* renamed from: fS */
    private volatile Handler f28295fS;

    /* renamed from: com.kwad.components.core.g.a$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC8648a {
        /* renamed from: y */
        void mo30062y(long j);
    }

    public RunnableC8647a(Handler handler) {
        this.f28295fS = handler;
    }

    /* renamed from: a */
    public final void m30078a(InterfaceC8648a interfaceC8648a) {
        this.f28294LD = interfaceC8648a;
    }

    public final void destroy() {
        stop();
        this.f28295fS = null;
    }

    public final void pause() {
        this.f28292LB = true;
    }

    public final void resume() {
        this.f28292LB = false;
    }

    @Override // java.lang.Runnable
    public final synchronized void run() {
        InterfaceC8648a interfaceC8648a;
        if (this.f28295fS != null) {
            if (!this.f28292LB && (interfaceC8648a = this.f28294LD) != null) {
                interfaceC8648a.mo30062y(this.f28293LC);
                this.f28293LC += this.f28291LA;
            }
            if (this.f28295fS != null) {
                this.f28295fS.postDelayed(this, this.f28291LA);
            }
        }
    }

    public final void start() {
        this.f28292LB = false;
        if (this.f28295fS != null) {
            this.f28295fS.post(this);
        }
    }

    public final void stop() {
        if (this.f28295fS != null) {
            this.f28295fS.removeCallbacks(this);
        }
    }
}
