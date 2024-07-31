package com.kwad.components.p208ad.p221f.p223b;

import android.widget.ProgressBar;
import com.kwad.components.core.video.C9002l;
import com.kwad.components.core.video.InterfaceC9001k;
import com.kwad.components.p208ad.p221f.p222a.C7416a;
import com.kwad.sdk.C9659R;

/* renamed from: com.kwad.components.ad.f.b.k */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C7449k extends C7416a {

    /* renamed from: nm */
    private ProgressBar f25465nm;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: H */
    public void m33254H(int i) {
        this.f25465nm.setProgress(i);
        if (this.f25465nm.getVisibility() == 0) {
            return;
        }
        this.f25465nm.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: eB */
    public void m33251eB() {
        if (this.f25465nm.getVisibility() != 0) {
            return;
        }
        this.f25465nm.setVisibility(8);
    }

    @Override // com.kwad.components.p208ad.p221f.p222a.C7416a, com.kwad.sdk.mvp.Presenter
    /* renamed from: aj */
    public final void mo24610aj() {
        super.mo24610aj();
        this.f25465nm.setProgress(0);
        this.f25465nm.setVisibility(8);
        C9002l c9002l = new C9002l() { // from class: com.kwad.components.ad.f.b.k.1
            @Override // com.kwad.components.core.video.C9002l, com.kwad.components.core.video.InterfaceC8997h
            public final void onMediaPlayCompleted() {
                C7449k.this.m33251eB();
            }

            @Override // com.kwad.components.core.video.C9002l, com.kwad.components.core.video.InterfaceC8997h
            public final void onMediaPlayError(int i, int i2) {
                C7449k.this.m33251eB();
            }

            @Override // com.kwad.components.core.video.C9002l, com.kwad.components.core.video.InterfaceC8997h
            public final void onMediaPlayProgress(long j, long j2) {
                C7449k.this.m33254H(j != 0 ? (int) ((((float) j2) * 100.0f) / ((float) j)) : 0);
            }
        };
        this.mVideoPlayStateListener = c9002l;
        this.f25416mN.f25418mO.mo31843b((InterfaceC9001k) c9002l);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.f25465nm = (ProgressBar) findViewById(C9659R.C9662id.ksad_video_progress);
    }
}
