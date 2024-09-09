package com.kwad.components.core.s;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class h {
    private long Bm;
    private a Te;
    private long Tc = 100;
    private long Td = 0;
    private boolean LB = false;
    @Nullable
    private Handler Tf = new Handler(Looper.getMainLooper());
    private Runnable Tg = new Runnable() { // from class: com.kwad.components.core.s.h.1
        @Override // java.lang.Runnable
        public final void run() {
            if (h.this.Tf == null) {
                return;
            }
            if (h.this.LB) {
                h.this.Tf.postDelayed(this, h.this.Tc / 2);
                return;
            }
            h.this.rd();
            if (h.this.Tf != null) {
                h.this.Tf.postDelayed(this, h.this.Tc);
            }
        }
    };

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public interface a {
        void onProgress(long j4, long j5);
    }

    public h(long j4) {
        this.Bm = j4;
    }

    public final void pause() {
        this.LB = true;
    }

    protected final void rd() {
        a aVar = this.Te;
        if (aVar != null) {
            long j4 = this.Bm;
            long j5 = j4 - this.Td;
            aVar.onProgress(j5, j4);
            if (j5 <= 0) {
                stop();
            }
        }
        this.Td += this.Tc;
    }

    public final void resume() {
        this.LB = false;
    }

    public final void start() {
        Handler handler = this.Tf;
        if (handler == null) {
            return;
        }
        handler.post(this.Tg);
    }

    public final void stop() {
        Handler handler = this.Tf;
        if (handler != null) {
            handler.removeCallbacks(this.Tg);
            this.Tf = null;
        }
    }

    public final void a(a aVar) {
        this.Te = aVar;
    }
}
