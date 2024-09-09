package com.kwad.components.ad.f.b;

import android.widget.ProgressBar;
import com.kwad.components.core.video.l;
import com.kwad.sdk.R;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class k extends com.kwad.components.ad.f.a.a {
    private ProgressBar nm;

    /* JADX INFO: Access modifiers changed from: private */
    public void H(int i4) {
        this.nm.setProgress(i4);
        if (this.nm.getVisibility() == 0) {
            return;
        }
        this.nm.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eB() {
        if (this.nm.getVisibility() != 0) {
            return;
        }
        this.nm.setVisibility(8);
    }

    @Override // com.kwad.components.ad.f.a.a, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        this.nm.setProgress(0);
        this.nm.setVisibility(8);
        l lVar = new l() { // from class: com.kwad.components.ad.f.b.k.1
            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlayCompleted() {
                k.this.eB();
            }

            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlayError(int i4, int i5) {
                k.this.eB();
            }

            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlayProgress(long j4, long j5) {
                k.this.H(j4 != 0 ? (int) ((((float) j5) * 100.0f) / ((float) j4)) : 0);
            }
        };
        this.mVideoPlayStateListener = lVar;
        this.mN.mO.b((com.kwad.components.core.video.k) lVar);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.nm = (ProgressBar) findViewById(R.id.ksad_video_progress);
    }
}
