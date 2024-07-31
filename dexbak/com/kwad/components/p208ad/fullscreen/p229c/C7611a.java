package com.kwad.components.p208ad.fullscreen.p229c;

import com.kwad.components.core.video.C9002l;
import com.kwad.components.core.webview.tachikoma.p334b.C9256q;
import com.kwad.components.p208ad.reward.C7860c;
import com.kwad.components.p208ad.reward.p252e.InterfaceC7893m;
import com.kwad.components.p208ad.reward.presenter.C8094b;

/* renamed from: com.kwad.components.ad.fullscreen.c.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C7611a extends C8094b {

    /* renamed from: gO */
    private C9002l f25861gO = new C9002l() { // from class: com.kwad.components.ad.fullscreen.c.a.1
        @Override // com.kwad.components.core.video.C9002l, com.kwad.components.core.video.InterfaceC8997h
        public final void onMediaPlayCompleted() {
            super.onMediaPlayCompleted();
            C7611a.this.f26957qo.m32013fB();
        }
    };

    /* renamed from: gP */
    private final InterfaceC7893m f25862gP = new InterfaceC7893m() { // from class: com.kwad.components.ad.fullscreen.c.a.2
        @Override // com.kwad.components.p208ad.reward.p252e.InterfaceC7893m
        /* renamed from: a */
        public final void mo31254a(C9256q c9256q) {
            if (c9256q == null || c9256q.type != 1) {
                return;
            }
            C7611a.this.f26957qo.f26529oJ.release();
            C7611a.this.f26957qo.m32013fB();
        }
    };

    @Override // com.kwad.components.p208ad.reward.presenter.C8094b, com.kwad.sdk.mvp.Presenter
    /* renamed from: aj */
    public final void mo24610aj() {
        super.mo24610aj();
        this.f26957qo.f26529oJ.m31828a(this.f25861gO);
        C7860c.m32139fe().m32143a(this.f25862gP);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.f26957qo.f26529oJ.m31826b(this.f25861gO);
        C7860c.m32139fe().m32142b(this.f25862gP);
    }
}
