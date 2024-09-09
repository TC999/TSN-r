package com.kwad.components.ad.reward.presenter;

import android.view.View;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.n.g;
import com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class l extends b implements com.kwad.components.ad.reward.presenter.platdetail.actionbar.a {
    private RewardActionBarControl oM;
    @Nullable
    private com.kwad.components.ad.reward.n.g sp;
    private KsLogoView sr;
    @Nullable
    private com.kwad.components.ad.reward.n.l ss;
    private boolean sq = false;
    private com.kwad.components.core.video.l gO = new com.kwad.components.core.video.l() { // from class: com.kwad.components.ad.reward.presenter.l.1
        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayProgress(long j4, long j5) {
            super.onMediaPlayProgress(j4, j5);
            l.this.hu();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void hu() {
        if (this.sq) {
            return;
        }
        com.kwad.components.ad.reward.n.g gVar = this.sp;
        if (gVar == null) {
            this.oM.O(false);
        } else {
            gVar.a(new g.a() { // from class: com.kwad.components.ad.reward.presenter.l.2
                @Override // com.kwad.components.ad.reward.n.g.a
                public final void hv() {
                    l.this.oM.O(true);
                }
            }, 500L);
        }
        this.sq = true;
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        com.kwad.components.ad.reward.g gVar = this.qo;
        this.oM = gVar.oM;
        gVar.oJ.a(this.gO);
        AdTemplate adTemplate = this.qo.mAdTemplate;
        boolean z3 = com.kwad.sdk.core.response.b.b.db(adTemplate).displayWeakCard;
        this.qo.A(z3);
        if (z3) {
            if (this.sp == null) {
                this.sp = new com.kwad.components.ad.reward.n.g(this.qo);
            }
            this.sp.f((AdBaseFrameLayout) findViewById(R.id.ksad_root_container));
            this.sp.b(com.kwad.components.ad.reward.n.r.R(adTemplate));
        }
        AdInfo dQ = com.kwad.sdk.core.response.b.e.dQ(adTemplate);
        if (com.kwad.sdk.core.response.b.a.cb(adTemplate)) {
            if (this.ss == null) {
                this.ss = new com.kwad.components.ad.reward.n.l(this.qo);
            }
            this.ss.h(this.qo.mRootContainer);
            this.ss.b(com.kwad.components.ad.reward.n.r.R(adTemplate));
            com.kwad.components.ad.reward.presenter.platdetail.actionbar.d.a(getContext(), dQ, this.sr, R.dimen.ksad_live_subscribe_card_logo_margin_bottom, false);
        }
        this.qo.oM.a(this);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.sr = (KsLogoView) findViewById(R.id.ksad_ad_label_play_bar);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.qo.oJ.b(this.gO);
        this.qo.oM.b(this);
        com.kwad.components.ad.reward.n.l lVar = this.ss;
        if (lVar != null) {
            lVar.onUnbind();
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.platdetail.actionbar.a
    public final void a(RewardActionBarControl.ShowActionBarResult showActionBarResult, View view) {
        com.kwad.components.ad.reward.n.l lVar = this.ss;
        if (lVar != null) {
            lVar.jZ();
        }
    }
}
