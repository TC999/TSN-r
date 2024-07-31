package com.kwad.components.p208ad.reward.presenter;

import android.view.View;
import androidx.annotation.Nullable;
import com.kwad.components.core.video.C9002l;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.components.p208ad.reward.C7907g;
import com.kwad.components.p208ad.reward.p264n.C8074r;
import com.kwad.components.p208ad.reward.p264n.View$OnClickListenerC8046g;
import com.kwad.components.p208ad.reward.p264n.View$OnClickListenerC8060l;
import com.kwad.components.p208ad.reward.presenter.platdetail.actionbar.C8273d;
import com.kwad.components.p208ad.reward.presenter.platdetail.actionbar.InterfaceC8259a;
import com.kwad.components.p208ad.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10484b;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.core.view.AdBaseFrameLayout;

/* renamed from: com.kwad.components.ad.reward.presenter.l */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8215l extends C8094b implements InterfaceC8259a {

    /* renamed from: oM */
    private RewardActionBarControl f27174oM;
    @Nullable

    /* renamed from: sp */
    private View$OnClickListenerC8046g f27175sp;

    /* renamed from: sr */
    private KsLogoView f27177sr;
    @Nullable

    /* renamed from: ss */
    private View$OnClickListenerC8060l f27178ss;

    /* renamed from: sq */
    private boolean f27176sq = false;

    /* renamed from: gO */
    private C9002l f27173gO = new C9002l() { // from class: com.kwad.components.ad.reward.presenter.l.1
        @Override // com.kwad.components.core.video.C9002l, com.kwad.components.core.video.InterfaceC8997h
        public final void onMediaPlayProgress(long j, long j2) {
            super.onMediaPlayProgress(j, j2);
            C8215l.this.m31261hu();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: hu */
    public void m31261hu() {
        if (this.f27176sq) {
            return;
        }
        View$OnClickListenerC8046g view$OnClickListenerC8046g = this.f27175sp;
        if (view$OnClickListenerC8046g == null) {
            this.f27174oM.m31205O(false);
        } else {
            view$OnClickListenerC8046g.m31713a(new View$OnClickListenerC8046g.InterfaceC8049a() { // from class: com.kwad.components.ad.reward.presenter.l.2
                @Override // com.kwad.components.p208ad.reward.p264n.View$OnClickListenerC8046g.InterfaceC8049a
                /* renamed from: hv */
                public final void mo31260hv() {
                    C8215l.this.f27174oM.m31205O(true);
                }
            }, 500L);
        }
        this.f27176sq = true;
    }

    @Override // com.kwad.components.p208ad.reward.presenter.C8094b, com.kwad.sdk.mvp.Presenter
    /* renamed from: aj */
    public final void mo24610aj() {
        super.mo24610aj();
        C7907g c7907g = this.f26957qo;
        this.f27174oM = c7907g.f26532oM;
        c7907g.f26529oJ.m31828a(this.f27173gO);
        AdTemplate adTemplate = this.f26957qo.mAdTemplate;
        boolean z = C10484b.m25717db(adTemplate).displayWeakCard;
        this.f26957qo.m32069A(z);
        if (z) {
            if (this.f27175sp == null) {
                this.f27175sp = new View$OnClickListenerC8046g(this.f26957qo);
            }
            this.f27175sp.m31712f((AdBaseFrameLayout) findViewById(C9659R.C9662id.ksad_root_container));
            this.f27175sp.m31726b(C8074r.m31647R(adTemplate));
        }
        AdInfo m25641dQ = C10487e.m25641dQ(adTemplate);
        if (C10483a.m25824cb(adTemplate)) {
            if (this.f27178ss == null) {
                this.f27178ss = new View$OnClickListenerC8060l(this.f26957qo);
            }
            this.f27178ss.m31674h(this.f26957qo.mRootContainer);
            this.f27178ss.m31726b(C8074r.m31647R(adTemplate));
            C8273d.m31141a(getContext(), m25641dQ, this.f27177sr, C9659R.dimen.ksad_live_subscribe_card_logo_margin_bottom, false);
        }
        this.f26957qo.f26532oM.m31197a(this);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.f27177sr = (KsLogoView) findViewById(C9659R.C9662id.ksad_ad_label_play_bar);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.f26957qo.f26529oJ.m31826b(this.f27173gO);
        this.f26957qo.f26532oM.m31193b(this);
        View$OnClickListenerC8060l view$OnClickListenerC8060l = this.f27178ss;
        if (view$OnClickListenerC8060l != null) {
            view$OnClickListenerC8060l.onUnbind();
        }
    }

    @Override // com.kwad.components.p208ad.reward.presenter.platdetail.actionbar.InterfaceC8259a
    /* renamed from: a */
    public final void mo31183a(RewardActionBarControl.ShowActionBarResult showActionBarResult, View view) {
        View$OnClickListenerC8060l view$OnClickListenerC8060l = this.f27178ss;
        if (view$OnClickListenerC8060l != null) {
            view$OnClickListenerC8060l.m31673jZ();
        }
    }
}
