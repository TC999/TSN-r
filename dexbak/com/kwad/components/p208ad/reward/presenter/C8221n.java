package com.kwad.components.p208ad.reward.presenter;

import com.kwad.components.core.p330s.C8947j;
import com.kwad.components.core.video.C9002l;
import com.kwad.components.core.webview.tachikoma.p334b.C9256q;
import com.kwad.components.p208ad.reward.C7860c;
import com.kwad.components.p208ad.reward.C7907g;
import com.kwad.components.p208ad.reward.p252e.InterfaceC7893m;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.C11064bn;

/* renamed from: com.kwad.components.ad.reward.presenter.n */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8221n extends C8094b {

    /* renamed from: gO */
    private C9002l f27188gO = new C9002l() { // from class: com.kwad.components.ad.reward.presenter.n.2
        @Override // com.kwad.components.core.video.C9002l, com.kwad.components.core.video.InterfaceC8997h
        public final void onMediaPlayCompleted() {
            try {
                super.onMediaPlayCompleted();
                C8221n.this.m31255hw();
            } catch (Throwable th) {
                ServiceProvider.reportSdkCaughtException(th);
            }
        }
    };

    /* renamed from: gP */
    private final InterfaceC7893m f27189gP = new InterfaceC7893m() { // from class: com.kwad.components.ad.reward.presenter.n.3
        @Override // com.kwad.components.p208ad.reward.p252e.InterfaceC7893m
        /* renamed from: a */
        public final void mo31254a(C9256q c9256q) {
            if (c9256q == null || c9256q.type != 1) {
                return;
            }
            C8221n.this.f26957qo.f26529oJ.release();
            C8221n.this.f26957qo.m32013fB();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: hw */
    public void m31255hw() {
        C7907g c7907g = this.f26957qo;
        if (C8947j.m29549d(c7907g.mAdTemplate, c7907g.f26555pd)) {
            C7907g c7907g2 = this.f26957qo;
            C8947j.m29548e(c7907g2.mContext, c7907g2.mAdTemplate);
        }
        if (!C8209i.m31264x(this.f26957qo)) {
            C7907g c7907g3 = this.f26957qo;
            if (!C8947j.m29549d(c7907g3.mAdTemplate, c7907g3.f26555pd)) {
                this.f26957qo.m32013fB();
                return;
            }
        }
        C11064bn.runOnUiThreadDelay(new Runnable() { // from class: com.kwad.components.ad.reward.presenter.n.1
            @Override // java.lang.Runnable
            public final void run() {
                C8221n.this.f26957qo.m32013fB();
            }
        }, 200L);
    }

    @Override // com.kwad.components.p208ad.reward.presenter.C8094b, com.kwad.sdk.mvp.Presenter
    /* renamed from: aj */
    public final void mo24610aj() {
        super.mo24610aj();
        this.f26957qo.f26529oJ.m31828a(this.f27188gO);
        C7860c.m32139fe().m32143a(this.f27189gP);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.f26957qo.f26529oJ.m31826b(this.f27188gO);
        C7860c.m32139fe().m32142b(this.f27189gP);
    }
}
