package com.kwad.components.p208ad.reward.presenter.platdetail.actionbar;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.components.p208ad.reward.p248a.C7844b;
import com.kwad.components.p208ad.reward.p264n.C8074r;
import com.kwad.components.p208ad.reward.p264n.InterfaceC8036b;
import com.kwad.components.p208ad.reward.p264n.View$OnClickListenerC8052i;
import com.kwad.components.p208ad.reward.presenter.C8094b;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.utils.C11015ai;

/* renamed from: com.kwad.components.ad.reward.presenter.platdetail.actionbar.d */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8273d extends C8094b implements InterfaceC8036b {

    /* renamed from: gS */
    private ViewGroup f27300gS;

    /* renamed from: sr */
    private KsLogoView f27301sr;

    /* renamed from: uU */
    private View$OnClickListenerC8052i f27302uU;

    public C8273d(ViewGroup viewGroup) {
        this.f27300gS = viewGroup;
    }

    /* renamed from: a */
    public static FrameLayout.LayoutParams m31141a(Context context, AdInfo adInfo, KsLogoView ksLogoView, int i, boolean z) {
        FrameLayout.LayoutParams layoutParams = null;
        if (ksLogoView != null && context != null) {
            ViewGroup.LayoutParams layoutParams2 = ksLogoView.getLayoutParams();
            if (!(layoutParams2 instanceof FrameLayout.LayoutParams)) {
                return null;
            }
            FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) layoutParams2;
            layoutParams = m31140a(layoutParams3);
            boolean z2 = false;
            if (z) {
                ksLogoView.setVisibility(0);
            }
            z2 = ((!C11015ai.m24123LZ() && (C7844b.m32178i(adInfo) || C10483a.m25848cF(adInfo))) || (C11015ai.m24123LZ() && C10483a.m25849cE(adInfo))) ? true : true;
            layoutParams3.gravity = 85;
            if (z2) {
                i = C9659R.dimen.ksad_reward_follow_card_margin;
            }
            layoutParams3.bottomMargin = context.getResources().getDimensionPixelOffset(i);
            layoutParams3.rightMargin = context.getResources().getDimensionPixelOffset(C9659R.dimen.ksad_reward_follow_card_margin);
            ksLogoView.setLayoutParams(layoutParams3);
        }
        return layoutParams;
    }

    @Override // com.kwad.components.p208ad.reward.presenter.C8094b, com.kwad.sdk.mvp.Presenter
    /* renamed from: aj */
    public final void mo24610aj() {
        super.mo24610aj();
        View$OnClickListenerC8052i view$OnClickListenerC8052i = new View$OnClickListenerC8052i(this.f26957qo, this.f27300gS, this.f27301sr);
        this.f27302uU = view$OnClickListenerC8052i;
        view$OnClickListenerC8052i.m31726b(C8074r.m31647R(this.f26957qo.mAdTemplate));
        m31141a(getContext(), C10487e.m25641dQ(this.f26957qo.mAdTemplate), this.f27301sr, C9659R.dimen.ksad_reward_jinniu_logo_margin_bottom, false);
    }

    @Override // com.kwad.components.p208ad.reward.p264n.InterfaceC8036b
    /* renamed from: gJ */
    public final void mo31139gJ() {
    }

    @Override // com.kwad.components.p208ad.reward.p264n.InterfaceC8036b
    /* renamed from: ih */
    public final void mo31133ih() {
    }

    @Override // com.kwad.components.p208ad.reward.p264n.InterfaceC8036b
    /* renamed from: ii */
    public final void mo31132ii() {
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.f27301sr = (KsLogoView) findViewById(C9659R.C9662id.ksad_ad_label_play_bar);
    }

    /* renamed from: a */
    private static FrameLayout.LayoutParams m31140a(FrameLayout.LayoutParams layoutParams) {
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        layoutParams2.gravity = layoutParams.gravity;
        return layoutParams2;
    }
}
