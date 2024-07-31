package com.kwad.components.p208ad.draw.p215b;

import android.widget.TextView;
import com.kwad.components.core.video.C9002l;
import com.kwad.components.core.video.InterfaceC9001k;
import com.kwad.components.p208ad.draw.p214a.C7357a;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.utils.C11013ag;

/* renamed from: com.kwad.components.ad.draw.b.d */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C7394d extends C7357a {

    /* renamed from: cz */
    private TextView f25354cz;
    private InterfaceC9001k mVideoPlayStateListener = new C9002l() { // from class: com.kwad.components.ad.draw.b.d.1
        @Override // com.kwad.components.core.video.C9002l, com.kwad.components.core.video.InterfaceC8997h
        public final void onMediaPlayError(int i, int i2) {
            C7394d.this.f25354cz.setVisibility(0);
        }

        @Override // com.kwad.components.core.video.C9002l, com.kwad.components.core.video.InterfaceC8997h
        public final void onMediaPlayStart() {
            C7394d.this.f25354cz.setVisibility(8);
        }

        @Override // com.kwad.components.core.video.C9002l, com.kwad.components.core.video.InterfaceC8997h
        public final void onMediaPlaying() {
            C7394d.this.f25354cz.setVisibility(8);
        }
    };

    @Override // com.kwad.components.p208ad.draw.p214a.C7357a, com.kwad.sdk.mvp.Presenter
    /* renamed from: aj */
    public final void mo24610aj() {
        super.mo24610aj();
        if (!C11013ag.isNetworkConnected(getContext())) {
            this.f25354cz.setVisibility(0);
        } else {
            this.f25354cz.setVisibility(8);
        }
        this.f25273bO.f25275bP.mo31843b(this.mVideoPlayStateListener);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.f25354cz = (TextView) findViewById(C9659R.C9662id.ksad_video_fail_tip);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.f25273bO.f25275bP.mo31844a(this.mVideoPlayStateListener);
    }
}
