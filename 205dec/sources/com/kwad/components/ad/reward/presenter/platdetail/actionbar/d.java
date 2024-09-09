package com.kwad.components.ad.reward.presenter.platdetail.actionbar;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.kwad.components.ad.reward.n.i;
import com.kwad.components.ad.reward.n.r;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.ai;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class d extends com.kwad.components.ad.reward.presenter.b implements com.kwad.components.ad.reward.n.b {
    private ViewGroup gS;
    private KsLogoView sr;
    private i uU;

    public d(ViewGroup viewGroup) {
        this.gS = viewGroup;
    }

    public static FrameLayout.LayoutParams a(Context context, AdInfo adInfo, KsLogoView ksLogoView, int i4, boolean z3) {
        FrameLayout.LayoutParams layoutParams = null;
        if (ksLogoView != null && context != null) {
            ViewGroup.LayoutParams layoutParams2 = ksLogoView.getLayoutParams();
            if (!(layoutParams2 instanceof FrameLayout.LayoutParams)) {
                return null;
            }
            FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) layoutParams2;
            layoutParams = a(layoutParams3);
            boolean z4 = false;
            if (z3) {
                ksLogoView.setVisibility(0);
            }
            z4 = ((!ai.LZ() && (com.kwad.components.ad.reward.a.b.i(adInfo) || com.kwad.sdk.core.response.b.a.cF(adInfo))) || (ai.LZ() && com.kwad.sdk.core.response.b.a.cE(adInfo))) ? true : true;
            layoutParams3.gravity = 85;
            if (z4) {
                i4 = R.dimen.ksad_reward_follow_card_margin;
            }
            layoutParams3.bottomMargin = context.getResources().getDimensionPixelOffset(i4);
            layoutParams3.rightMargin = context.getResources().getDimensionPixelOffset(R.dimen.ksad_reward_follow_card_margin);
            ksLogoView.setLayoutParams(layoutParams3);
        }
        return layoutParams;
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        i iVar = new i(this.qo, this.gS, this.sr);
        this.uU = iVar;
        iVar.b(r.R(this.qo.mAdTemplate));
        a(getContext(), com.kwad.sdk.core.response.b.e.dQ(this.qo.mAdTemplate), this.sr, R.dimen.ksad_reward_jinniu_logo_margin_bottom, false);
    }

    @Override // com.kwad.components.ad.reward.n.b
    public final void gJ() {
    }

    @Override // com.kwad.components.ad.reward.n.b
    public final void ih() {
    }

    @Override // com.kwad.components.ad.reward.n.b
    public final void ii() {
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.sr = (KsLogoView) findViewById(R.id.ksad_ad_label_play_bar);
    }

    private static FrameLayout.LayoutParams a(FrameLayout.LayoutParams layoutParams) {
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        layoutParams2.gravity = layoutParams.gravity;
        return layoutParams2;
    }
}
