package com.kwad.components.p208ad.reward.presenter.p266b;

import android.view.View;
import androidx.annotation.Nullable;
import com.kwad.components.core.video.C9002l;
import com.kwad.components.p208ad.reward.C7907g;
import com.kwad.components.p208ad.reward.p264n.C8074r;
import com.kwad.components.p208ad.reward.p264n.View$OnClickListenerC8069o;
import com.kwad.components.p208ad.reward.presenter.C8094b;
import com.kwad.components.p208ad.reward.presenter.platdetail.actionbar.InterfaceC8259a;
import com.kwad.components.p208ad.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10487e;

/* renamed from: com.kwad.components.ad.reward.presenter.b.c */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8102c extends C8094b implements InterfaceC8259a {

    /* renamed from: oM */
    private RewardActionBarControl f26970oM;

    /* renamed from: sv */
    private C9002l f26971sv = new C9002l() { // from class: com.kwad.components.ad.reward.presenter.b.c.1
        @Override // com.kwad.components.core.video.C9002l, com.kwad.components.core.video.InterfaceC8997h
        public final void onMediaPlayProgress(long j, long j2) {
            super.onMediaPlayProgress(j, j2);
            C8102c.this.m31581hu();
        }
    };
    @Nullable

    /* renamed from: tT */
    private View$OnClickListenerC8069o f26972tT;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: hu */
    public void m31581hu() {
        this.f26970oM.m31205O(false);
    }

    @Override // com.kwad.components.p208ad.reward.presenter.platdetail.actionbar.InterfaceC8259a
    /* renamed from: a */
    public final void mo31183a(RewardActionBarControl.ShowActionBarResult showActionBarResult, View view) {
    }

    @Override // com.kwad.components.p208ad.reward.presenter.C8094b, com.kwad.sdk.mvp.Presenter
    /* renamed from: aj */
    public final void mo24610aj() {
        super.mo24610aj();
        C7907g c7907g = this.f26957qo;
        this.f26970oM = c7907g.f26532oM;
        c7907g.f26529oJ.m31828a(this.f26971sv);
        AdTemplate adTemplate = this.f26957qo.mAdTemplate;
        AdInfo m25641dQ = C10487e.m25641dQ(adTemplate);
        if (C10483a.m25842cL(m25641dQ)) {
            if (this.f26972tT == null) {
                this.f26972tT = new View$OnClickListenerC8069o(this.f26957qo);
            }
            this.f26972tT.m31661a(this.f26957qo.mRootContainer, C10483a.m25874bf(m25641dQ));
            this.f26972tT.m31726b(C8074r.m31647R(adTemplate));
            findViewById(C9659R.C9662id.ksad_reward_origin_live_root).setVisibility(8);
        }
        this.f26957qo.f26532oM.m31197a(this);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.f26957qo.f26529oJ.m31826b(this.f26971sv);
        this.f26957qo.f26532oM.m31193b(this);
        View$OnClickListenerC8069o view$OnClickListenerC8069o = this.f26972tT;
        if (view$OnClickListenerC8069o != null) {
            view$OnClickListenerC8069o.onUnbind();
        }
    }
}
