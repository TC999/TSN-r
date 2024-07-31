package com.kwad.components.p208ad.p221f.p223b;

import com.kwad.components.core.video.C9002l;
import com.kwad.components.core.video.InterfaceC9001k;
import com.kwad.components.p208ad.p221f.p222a.C7416a;
import com.kwad.sdk.api.KsNativeAd;
import com.kwad.sdk.core.p397e.C10331c;

/* renamed from: com.kwad.components.ad.f.b.e */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C7433e extends C7416a {

    /* renamed from: bR */
    private boolean f25444bR = false;

    /* renamed from: mr */
    private KsNativeAd.VideoPlayListener f25445mr;

    @Override // com.kwad.components.p208ad.p221f.p222a.C7416a, com.kwad.sdk.mvp.Presenter
    /* renamed from: aj */
    public final void mo24610aj() {
        super.mo24610aj();
        this.f25445mr = this.f25416mN.f25419mr;
        C9002l c9002l = new C9002l() { // from class: com.kwad.components.ad.f.b.e.1
            @Override // com.kwad.components.core.video.C9002l, com.kwad.components.core.video.InterfaceC8997h
            public final void onMediaPlayCompleted() {
                if (C7433e.this.f25445mr != null) {
                    C7433e.this.f25445mr.onVideoPlayComplete();
                }
            }

            @Override // com.kwad.components.core.video.C9002l, com.kwad.components.core.video.InterfaceC8997h
            public final void onMediaPlayError(int i, int i2) {
                if (C7433e.this.f25445mr != null) {
                    C7433e.this.f25445mr.onVideoPlayError(i, i2);
                }
            }

            @Override // com.kwad.components.core.video.C9002l, com.kwad.components.core.video.InterfaceC8997h
            public final void onMediaPlayPaused() {
                super.onMediaPlayPaused();
                if (C7433e.this.f25445mr != null) {
                    try {
                        C7433e.this.f25445mr.onVideoPlayPause();
                    } catch (Throwable th) {
                        C10331c.printStackTraceOnly(th);
                    }
                }
                C7433e.this.f25444bR = true;
            }

            @Override // com.kwad.components.core.video.C9002l, com.kwad.components.core.video.InterfaceC8997h
            public final void onMediaPlayStart() {
                if (C7433e.this.f25445mr != null) {
                    C7433e.this.f25445mr.onVideoPlayStart();
                }
            }

            @Override // com.kwad.components.core.video.C9002l, com.kwad.components.core.video.InterfaceC8997h
            public final void onMediaPlaying() {
                super.onMediaPlaying();
                if (C7433e.this.f25444bR) {
                    C7433e.this.f25444bR = false;
                    if (C7433e.this.f25445mr != null) {
                        try {
                            C7433e.this.f25445mr.onVideoPlayResume();
                        } catch (Throwable th) {
                            C10331c.printStackTraceOnly(th);
                        }
                    }
                }
            }

            @Override // com.kwad.components.core.video.C9002l, com.kwad.components.core.video.InterfaceC8997h
            public final void onMediaPrepared() {
                super.onMediaPrepared();
                if (C7433e.this.f25445mr != null) {
                    try {
                        C7433e.this.f25445mr.onVideoPlayReady();
                    } catch (Throwable th) {
                        C10331c.printStackTraceOnly(th);
                    }
                }
            }
        };
        this.mVideoPlayStateListener = c9002l;
        this.f25416mN.f25418mO.mo31843b((InterfaceC9001k) c9002l);
    }

    @Override // com.kwad.components.p208ad.p221f.p222a.C7416a, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
    }
}
