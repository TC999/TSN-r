package com.kwad.components.p208ad.draw.p215b.p218c;

import androidx.annotation.Nullable;
import com.kwad.components.core.video.C9002l;
import com.kwad.components.core.video.InterfaceC9001k;
import com.kwad.components.p208ad.draw.p214a.C7357a;
import com.kwad.components.p208ad.draw.p214a.C7358b;
import com.kwad.components.p208ad.draw.view.playend.DrawVideoTailFrame;
import com.kwad.components.p208ad.p247k.C7824b;
import com.kwad.sdk.C9659R;

/* renamed from: com.kwad.components.ad.draw.b.c.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C7390a extends C7357a {

    /* renamed from: cY */
    private DrawVideoTailFrame f25347cY;
    @Nullable

    /* renamed from: ci */
    private C7824b f25348ci;
    private InterfaceC9001k mVideoPlayStateListener = new C9002l() { // from class: com.kwad.components.ad.draw.b.c.a.1
        @Override // com.kwad.components.core.video.C9002l, com.kwad.components.core.video.InterfaceC8997h
        public final void onMediaPlayCompleted() {
            super.onMediaPlayCompleted();
            if (C7390a.this.f25348ci != null && C7390a.this.f25348ci.m32217ar()) {
                C7390a.this.f25347cY.setVisibility(8);
            } else {
                C7390a.this.m33357aI();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: aI */
    public void m33357aI() {
        this.f25347cY.m33313aR();
        this.f25347cY.setVisibility(0);
    }

    @Override // com.kwad.components.p208ad.draw.p214a.C7357a, com.kwad.sdk.mvp.Presenter
    /* renamed from: aj */
    public final void mo24610aj() {
        super.mo24610aj();
        C7358b c7358b = this.f25273bO;
        this.f25348ci = c7358b.f25277ci;
        this.f25347cY.m33311b(c7358b.mAdTemplate);
        this.f25347cY.setAdBaseFrameLayout(this.f25273bO.mRootContainer);
        this.f25347cY.setApkDownloadHelper(this.f25273bO.mApkDownloadHelper);
        this.f25347cY.setVisibility(8);
        this.f25347cY.setAdInteractionListener(this.f25273bO.f25274bN);
        this.f25273bO.f25275bP.mo31843b(this.mVideoPlayStateListener);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.f25347cY = (DrawVideoTailFrame) findViewById(C9659R.C9662id.ksad_video_tail_frame);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.f25273bO.f25275bP.mo31844a(this.mVideoPlayStateListener);
        this.f25347cY.release();
    }
}
