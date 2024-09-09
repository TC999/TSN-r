package com.kwad.components.core.g;

import android.os.Handler;
import androidx.annotation.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class a implements Runnable {
    private long LA = 1000;
    private boolean LB = true;
    private long LC = 0;
    private InterfaceC0632a LD;
    @Nullable
    private volatile Handler fS;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* renamed from: com.kwad.components.core.g.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public interface InterfaceC0632a {
        void y(long j4);
    }

    public a(Handler handler) {
        this.fS = handler;
    }

    public final void a(InterfaceC0632a interfaceC0632a) {
        this.LD = interfaceC0632a;
    }

    public final void destroy() {
        stop();
        this.fS = null;
    }

    public final void pause() {
        this.LB = true;
    }

    public final void resume() {
        this.LB = false;
    }

    @Override // java.lang.Runnable
    public final synchronized void run() {
        InterfaceC0632a interfaceC0632a;
        if (this.fS != null) {
            if (!this.LB && (interfaceC0632a = this.LD) != null) {
                interfaceC0632a.y(this.LC);
                this.LC += this.LA;
            }
            if (this.fS != null) {
                this.fS.postDelayed(this, this.LA);
            }
        }
    }

    public final void start() {
        this.LB = false;
        if (this.fS != null) {
            this.fS.post(this);
        }
    }

    public final void stop() {
        if (this.fS != null) {
            this.fS.removeCallbacks(this);
        }
    }
}
