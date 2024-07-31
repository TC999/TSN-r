package com.kwad.components.p208ad.reward.presenter;

import androidx.annotation.Nullable;
import com.kwad.components.core.page.DownloadLandPageActivity;
import com.kwad.components.core.playable.C8874a;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.webview.jshandler.C9092aq;
import com.kwad.components.p208ad.reward.C7838a;
import com.kwad.components.p208ad.reward.C7907g;
import com.kwad.components.p208ad.reward.monitor.C8032c;
import com.kwad.components.p208ad.reward.p252e.C7891k;
import com.kwad.components.p208ad.reward.p252e.InterfaceC7890j;
import com.kwad.components.p208ad.reward.p252e.InterfaceC7894n;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.core.webview.KsAdWebView;

/* renamed from: com.kwad.components.ad.reward.presenter.p */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8229p extends C8094b {

    /* renamed from: oL */
    private C8874a f27206oL;

    /* renamed from: sI */
    private PlayableSource f27207sI;

    /* renamed from: sJ */
    private final InterfaceC7890j f27208sJ = new C7891k() { // from class: com.kwad.components.ad.reward.presenter.p.1
        @Override // com.kwad.components.p208ad.reward.p252e.C7891k, com.kwad.components.p208ad.reward.p252e.InterfaceC7890j
        /* renamed from: a */
        public final void mo31050a(PlayableSource playableSource, @Nullable InterfaceC7894n interfaceC7894n) {
            C8229p.this.f27207sI = playableSource;
            if (C8229p.this.f27206oL != null && C8229p.this.f27206oL.m29681qf()) {
                C8229p.this.f27206oL.m29687e(playableSource);
                C7907g c7907g = C8229p.this.f26957qo;
                if (c7907g != null) {
                    c7907g.m32019d(playableSource);
                    C8229p.this.f26957qo.m32068B(true);
                    if (C8229p.this.f26957qo.f26529oJ.m31821jM()) {
                        C8229p.this.f26957qo.f26529oJ.m31820jN().pause();
                    }
                }
                C7838a.m32198eX().m32202b(playableSource);
                return;
            }
            if (C8229p.this.f27206oL != null) {
                C8229p.this.f27206oL.m29686hz();
            }
            if (interfaceC7894n != null) {
                interfaceC7894n.mo31940gT();
                C10331c.m26254d("RewardPlayablePresenter", "onEnterPlayable outer handled");
            } else if (C10483a.m25956aF(C10487e.m25641dQ(C8229p.this.f26957qo.mAdTemplate))) {
                DownloadLandPageActivity.launch(C8229p.this.getActivity(), C8229p.this.f26957qo.mAdTemplate, true);
            }
        }

        @Override // com.kwad.components.p208ad.reward.p252e.C7891k, com.kwad.components.p208ad.reward.p252e.InterfaceC7890j
        /* renamed from: bY */
        public final void mo31048bY() {
            C8229p.this.f27206oL.m29686hz();
            C7907g c7907g = C8229p.this.f26957qo;
            if (c7907g != null) {
                c7907g.m32019d((PlayableSource) null);
                if (C8229p.this.f26957qo.f26529oJ.m31821jM()) {
                    C8229p.this.f26957qo.f26529oJ.m31820jN().resume();
                }
            }
        }
    };

    @Override // com.kwad.components.p208ad.reward.presenter.C8094b, com.kwad.sdk.mvp.Presenter
    /* renamed from: aj */
    public final void mo24610aj() {
        super.mo24610aj();
        C7907g c7907g = this.f26957qo;
        C8874a c8874a = c7907g.f26531oL;
        this.f27206oL = c8874a;
        if (c8874a == null) {
            return;
        }
        c8874a.m29698a(c7907g.mAdTemplate, c7907g.mRootContainer, c7907g.mApkDownloadHelper);
        C8032c.m31762a(this.f26957qo.f26544oY, "playable");
        AdInfo m25641dQ = C10487e.m25641dQ(this.f26957qo.mAdTemplate);
        C7907g c7907g2 = this.f26957qo;
        C8032c.m31774a(c7907g2.mAdTemplate, c7907g2.f26544oY, "playable", C10483a.m25894bN(m25641dQ));
        this.f27206oL.m29682qe();
        this.f27206oL.m29699a(new C9092aq.InterfaceC9095b() { // from class: com.kwad.components.ad.reward.presenter.p.2
            @Override // com.kwad.components.core.webview.jshandler.C9092aq.InterfaceC9095b
            /* renamed from: a */
            public final void mo28994a(C9092aq.C9094a c9094a) {
                if (c9094a.isSuccess()) {
                    return;
                }
                AdInfo m25641dQ2 = C10487e.m25641dQ(C8229p.this.f26957qo.mAdTemplate);
                long loadTime = C8229p.this.f26957qo.f26531oL.getLoadTime();
                if (loadTime == -1) {
                    return;
                }
                C7907g c7907g3 = C8229p.this.f26957qo;
                C8032c.m31773a(c7907g3.mAdTemplate, c7907g3.f26544oY, "playable", C10483a.m25894bN(m25641dQ2), System.currentTimeMillis() - loadTime, 3);
            }
        });
        this.f27206oL.m29697a(new KsAdWebView.InterfaceC10599d() { // from class: com.kwad.components.ad.reward.presenter.p.3
            @Override // com.kwad.sdk.core.webview.KsAdWebView.InterfaceC10599d
            public final void onPageFinished() {
                AdInfo m25641dQ2 = C10487e.m25641dQ(C8229p.this.f26957qo.mAdTemplate);
                long loadTime = C8229p.this.f26957qo.f26531oL.getLoadTime();
                if (loadTime == -1) {
                    return;
                }
                C8032c.m31761a(C8229p.this.f26957qo.f26544oY, "playable", C10483a.m25894bN(m25641dQ2), System.currentTimeMillis() - loadTime);
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.InterfaceC10599d
            public final void onPageStart() {
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.InterfaceC10599d
            public final void onReceivedHttpError(int i, String str, String str2) {
                C7907g c7907g3 = C8229p.this.f26957qo;
                AdTemplate adTemplate = c7907g3.mAdTemplate;
                C8032c.m31773a(adTemplate, c7907g3.f26544oY, "playable", C10483a.m25894bN(C10487e.m25641dQ(adTemplate)), System.currentTimeMillis() - C8229p.this.f26957qo.f26531oL.getLoadTime(), 2);
            }
        });
        C7838a.m32198eX().m32205a(this.f27208sJ);
    }

    /* renamed from: e */
    public final void m31246e(@Nullable PlayableSource playableSource) {
        C8874a c8874a = this.f27206oL;
        if (c8874a != null) {
            if (playableSource != null) {
                c8874a.m29687e(playableSource);
            } else {
                c8874a.m29687e(this.f27207sI);
            }
        }
    }

    /* renamed from: hz */
    public final void m31245hz() {
        C8874a c8874a = this.f27206oL;
        if (c8874a != null) {
            c8874a.m29686hz();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        ((KsAdWebView) findViewById(C9659R.C9662id.ksad_playable_webview)).setVisibility(4);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        C8874a c8874a = this.f27206oL;
        if (c8874a == null) {
            return;
        }
        c8874a.m29683qd();
        this.f27206oL.m29686hz();
        C7838a.m32198eX().m32203b(this.f27208sJ);
    }
}
