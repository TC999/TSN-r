package com.kwad.components.p208ad.p221f.p223b;

import android.view.View;
import com.kwad.components.core.video.C9002l;
import com.kwad.components.core.video.InterfaceC9001k;
import com.kwad.components.p208ad.p221f.p222a.C7416a;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.utils.C11013ag;

/* renamed from: com.kwad.components.ad.f.b.d */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C7431d extends C7416a {

    /* renamed from: mX */
    private View f25442mX;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ew */
    public void m33278ew() {
        if (this.f25442mX.getVisibility() != 0) {
            return;
        }
        this.f25442mX.setVisibility(8);
    }

    @Override // com.kwad.components.p208ad.p221f.p222a.C7416a, com.kwad.sdk.mvp.Presenter
    /* renamed from: aj */
    public final void mo24610aj() {
        super.mo24610aj();
        if (C11013ag.isNetworkConnected(this.f25442mX.getContext())) {
            this.f25442mX.setVisibility(8);
            return;
        }
        this.f25442mX.setVisibility(0);
        C9002l c9002l = new C9002l() { // from class: com.kwad.components.ad.f.b.d.1
            @Override // com.kwad.components.core.video.C9002l, com.kwad.components.core.video.InterfaceC8997h
            public final void onMediaPlayStart() {
                super.onMediaPlayStart();
                C7431d.this.m33278ew();
            }

            @Override // com.kwad.components.core.video.C9002l, com.kwad.components.core.video.InterfaceC8997h
            public final void onMediaPlaying() {
                super.onMediaPlaying();
                C7431d.this.m33278ew();
            }
        };
        this.mVideoPlayStateListener = c9002l;
        this.f25416mN.f25418mO.mo31843b((InterfaceC9001k) c9002l);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.f25442mX = findViewById(C9659R.C9662id.ksad_video_network_unavailable);
    }
}
