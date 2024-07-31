package com.kwad.components.p208ad.reward.presenter;

import android.view.ViewStub;
import android.widget.FrameLayout;
import com.kwad.components.core.video.C9002l;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.p208ad.reward.C7907g;
import com.kwad.components.p208ad.reward.RewardRenderResult;
import com.kwad.components.p208ad.reward.p248a.C7844b;
import com.kwad.components.p208ad.reward.p263m.C8019b;
import com.kwad.components.p208ad.reward.p263m.C8021d;
import com.kwad.components.p208ad.reward.p263m.C8025e;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.core.config.C10251d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.utils.C11015ai;

/* renamed from: com.kwad.components.ad.reward.presenter.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8088a extends C8094b {

    /* renamed from: gO */
    private C9002l f26945gO = new C9002l() { // from class: com.kwad.components.ad.reward.presenter.a.1
        @Override // com.kwad.components.core.video.C9002l, com.kwad.components.core.video.InterfaceC8997h
        public final void onMediaPlayProgress(long j, long j2) {
            C8088a.this.f26957qo.f26564pm = j2;
        }
    };
    private DetailVideoView mDetailVideoView;

    public C8088a(C7907g c7907g) {
        this.f26957qo = c7907g;
        this.mAdTemplate = c7907g.mAdTemplate;
    }

    /* renamed from: hi */
    private boolean m31629hi() {
        return C10487e.m25624i(this.mAdTemplate, C7844b.m32176k(C10487e.m25641dQ(this.mAdTemplate)));
    }

    /* renamed from: hj */
    private boolean m31628hj() {
        return C10487e.m25654F(this.mAdTemplate);
    }

    /* renamed from: l */
    private void m31627l(C7907g c7907g) {
        AdInfo m25641dQ = C10487e.m25641dQ(this.mAdTemplate);
        C8025e c8025e = c7907g.f26529oJ;
        if (C10483a.m25876bd(m25641dQ)) {
            C8019b c8019b = new C8019b(this.mAdTemplate);
            c8025e.m31829a(3, c8019b);
            c7907g.m32049a(c8019b);
        } else {
            C8021d c8021d = new C8021d(c7907g, this.mDetailVideoView);
            c8025e.m31829a(1, c8021d);
            c7907g.m32049a(c8021d);
        }
        c8025e.m31828a(this.f26945gO);
    }

    @Override // com.kwad.components.p208ad.reward.presenter.C8094b, com.kwad.sdk.mvp.Presenter
    /* renamed from: aj */
    public final void mo24610aj() {
        super.mo24610aj();
        getContext();
        boolean z = !C11015ai.m24123LZ();
        if ((m31629hi() || m31628hj()) && z) {
            this.mDetailVideoView.setForce(true);
        }
        this.mDetailVideoView.m29516g(true, C10251d.m26559CC());
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        ViewStub viewStub = (ViewStub) findViewById(C9659R.C9662id.ksad_native_container_stub);
        if (viewStub != null) {
            viewStub.inflate();
        }
        this.mDetailVideoView = (DetailVideoView) findViewById(C9659R.C9662id.ksad_video_player);
        m31627l(this.f26957qo);
        if (RewardRenderResult.DEFAULT.equals(this.f26957qo.m32005fJ())) {
            C7907g.m32053a(getContext(), this.f26957qo, (FrameLayout) findViewById(C9659R.C9662id.ksad_reward_play_layout));
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onDestroy() {
        super.onDestroy();
        C8025e c8025e = this.f26957qo.f26529oJ;
        if (c8025e != null) {
            c8025e.m31826b(this.f26945gO);
        }
    }
}
