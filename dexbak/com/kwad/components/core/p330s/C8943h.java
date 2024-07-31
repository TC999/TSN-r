package com.kwad.components.core.p330s;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;

/* renamed from: com.kwad.components.core.s.h */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8943h {

    /* renamed from: Bm */
    private long f28855Bm;

    /* renamed from: Te */
    private InterfaceC8945a f28859Te;

    /* renamed from: Tc */
    private long f28857Tc = 100;

    /* renamed from: Td */
    private long f28858Td = 0;

    /* renamed from: LB */
    private boolean f28856LB = false;
    @Nullable

    /* renamed from: Tf */
    private Handler f28860Tf = new Handler(Looper.getMainLooper());

    /* renamed from: Tg */
    private Runnable f28861Tg = new Runnable() { // from class: com.kwad.components.core.s.h.1
        @Override // java.lang.Runnable
        public final void run() {
            if (C8943h.this.f28860Tf == null) {
                return;
            }
            if (C8943h.this.f28856LB) {
                C8943h.this.f28860Tf.postDelayed(this, C8943h.this.f28857Tc / 2);
                return;
            }
            C8943h.this.m29552rd();
            if (C8943h.this.f28860Tf != null) {
                C8943h.this.f28860Tf.postDelayed(this, C8943h.this.f28857Tc);
            }
        }
    };

    /* renamed from: com.kwad.components.core.s.h$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC8945a {
        void onProgress(long j, long j2);
    }

    public C8943h(long j) {
        this.f28855Bm = j;
    }

    public final void pause() {
        this.f28856LB = true;
    }

    /* renamed from: rd */
    protected final void m29552rd() {
        InterfaceC8945a interfaceC8945a = this.f28859Te;
        if (interfaceC8945a != null) {
            long j = this.f28855Bm;
            long j2 = j - this.f28858Td;
            interfaceC8945a.onProgress(j2, j);
            if (j2 <= 0) {
                stop();
            }
        }
        this.f28858Td += this.f28857Tc;
    }

    public final void resume() {
        this.f28856LB = false;
    }

    public final void start() {
        Handler handler = this.f28860Tf;
        if (handler == null) {
            return;
        }
        handler.post(this.f28861Tg);
    }

    public final void stop() {
        Handler handler = this.f28860Tf;
        if (handler != null) {
            handler.removeCallbacks(this.f28861Tg);
            this.f28860Tf = null;
        }
    }

    /* renamed from: a */
    public final void m29556a(InterfaceC8945a interfaceC8945a) {
        this.f28859Te = interfaceC8945a;
    }
}
