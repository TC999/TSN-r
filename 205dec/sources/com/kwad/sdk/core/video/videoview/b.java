package com.kwad.sdk.core.video.videoview;

import android.content.Context;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public abstract class b extends RelativeLayout {
    private Runnable TR;
    @NonNull
    protected final c aBE;

    public b(Context context, @NonNull c cVar) {
        super(context);
        this.aBE = cVar;
    }

    public void n(int i4, int i5) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void onPlayStateChanged(int i4);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void reset();

    protected abstract void rq();

    /* JADX INFO: Access modifiers changed from: protected */
    public final void rw() {
        rx();
        if (this.TR == null) {
            this.TR = new Runnable() { // from class: com.kwad.sdk.core.video.videoview.b.1
                @Override // java.lang.Runnable
                public final void run() {
                    b.this.rq();
                    if (b.this.TR != null) {
                        b bVar = b.this;
                        bVar.postDelayed(bVar.TR, 1000L);
                    }
                }
            };
        }
        post(this.TR);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void rx() {
        Runnable runnable = this.TR;
        if (runnable != null) {
            removeCallbacks(runnable);
            this.TR = null;
        }
    }
}
