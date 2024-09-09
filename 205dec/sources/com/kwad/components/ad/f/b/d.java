package com.kwad.components.ad.f.b;

import android.view.View;
import com.kwad.components.core.video.l;
import com.kwad.sdk.R;
import com.kwad.sdk.utils.ag;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class d extends com.kwad.components.ad.f.a.a {
    private View mX;

    /* JADX INFO: Access modifiers changed from: private */
    public void ew() {
        if (this.mX.getVisibility() != 0) {
            return;
        }
        this.mX.setVisibility(8);
    }

    @Override // com.kwad.components.ad.f.a.a, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        if (ag.isNetworkConnected(this.mX.getContext())) {
            this.mX.setVisibility(8);
            return;
        }
        this.mX.setVisibility(0);
        l lVar = new l() { // from class: com.kwad.components.ad.f.b.d.1
            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlayStart() {
                super.onMediaPlayStart();
                d.this.ew();
            }

            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlaying() {
                super.onMediaPlaying();
                d.this.ew();
            }
        };
        this.mVideoPlayStateListener = lVar;
        this.mN.mO.b((com.kwad.components.core.video.k) lVar);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.mX = findViewById(R.id.ksad_video_network_unavailable);
    }
}
