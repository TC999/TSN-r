package com.kwad.sdk.core.video.videoview;

import android.content.Context;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;

/* renamed from: com.kwad.sdk.core.video.videoview.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public abstract class AbstractC10545b extends RelativeLayout {

    /* renamed from: TR */
    private Runnable f29612TR;
    @NonNull
    protected final InterfaceC10547c aBE;

    public AbstractC10545b(Context context, @NonNull InterfaceC10547c interfaceC10547c) {
        super(context);
        this.aBE = interfaceC10547c;
    }

    /* renamed from: n */
    public void mo25494n(int i, int i2) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void onPlayStateChanged(int i);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void reset();

    /* renamed from: rq */
    protected abstract void mo25493rq();

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: rw */
    public final void m25492rw() {
        m25491rx();
        if (this.f29612TR == null) {
            this.f29612TR = new Runnable() { // from class: com.kwad.sdk.core.video.videoview.b.1
                @Override // java.lang.Runnable
                public final void run() {
                    AbstractC10545b.this.mo25493rq();
                    if (AbstractC10545b.this.f29612TR != null) {
                        AbstractC10545b abstractC10545b = AbstractC10545b.this;
                        abstractC10545b.postDelayed(abstractC10545b.f29612TR, 1000L);
                    }
                }
            };
        }
        post(this.f29612TR);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: rx */
    public final void m25491rx() {
        Runnable runnable = this.f29612TR;
        if (runnable != null) {
            removeCallbacks(runnable);
            this.f29612TR = null;
        }
    }
}
