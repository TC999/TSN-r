package com.kwad.components.p208ad.reward.p249b;

import android.view.View;
import android.view.ViewGroup;
import com.kwad.components.p208ad.reward.p248a.C7844b;
import com.kwad.components.p208ad.reward.p249b.DialogFragmentC7855b;
import com.kwad.components.p208ad.reward.presenter.C8094b;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdProductInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.p430d.p431a.C10751a;
import com.kwad.sdk.utils.AbstractRunnableC11033ay;

/* renamed from: com.kwad.components.ad.reward.b.c */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C7858c extends C8094b implements DialogFragmentC7855b.InterfaceC7857a {
    private AdTemplate mAdTemplate;

    /* renamed from: re */
    private boolean f26469re = false;

    /* renamed from: l */
    private static boolean m32145l(AdInfo adInfo) {
        AdProductInfo m25838cP = C10483a.m25838cP(adInfo);
        return (!C7844b.m32178i(adInfo) || m25838cP == null || m25838cP.isCouponListEmpty()) ? false : true;
    }

    @Override // com.kwad.components.p208ad.reward.presenter.C8094b, com.kwad.sdk.mvp.Presenter
    /* renamed from: aj */
    public final void mo24610aj() {
        super.mo24610aj();
        this.mAdTemplate = this.f26957qo.mAdTemplate;
    }

    @Override // com.kwad.components.p208ad.reward.p249b.DialogFragmentC7855b.InterfaceC7857a
    /* renamed from: gJ */
    public final void mo32146gJ() {
        this.f26957qo.m32060a(1, getContext(), 29, 1);
    }

    public final void showDialog() {
        C10331c.m26254d("RewardCouponDialogPresenter", "onBind hasShown : " + this.f26469re);
        if (this.f26469re) {
            return;
        }
        AdInfo m25641dQ = C10487e.m25641dQ(this.mAdTemplate);
        ViewGroup viewGroup = (ViewGroup) this.f26957qo.mRootContainer.findViewById(C9659R.C9662id.ksad_reward_order_coupon_list);
        if (viewGroup == null) {
            return;
        }
        int childCount = viewGroup.getChildCount();
        View view = viewGroup;
        if (childCount > 0) {
            view = viewGroup.getChildAt(0);
        }
        final int[] m24926E = C10751a.m24926E(view);
        if (!m32145l(m25641dQ) || m24926E == null) {
            return;
        }
        view.post(new AbstractRunnableC11033ay() { // from class: com.kwad.components.ad.reward.b.c.1
            @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
            public final void doTask() {
                C10331c.m26254d("RewardCouponDialogPresenter", "targetView x: " + m24926E[0] + ", y: " + m24926E[1]);
                DialogFragmentC7855b.m32152a(C7858c.this.getActivity(), C7858c.this.mAdTemplate, C7858c.this, m24926E);
                C7858c.m32147a(C7858c.this, true);
            }
        });
    }

    /* renamed from: a */
    static /* synthetic */ boolean m32147a(C7858c c7858c, boolean z) {
        c7858c.f26469re = true;
        return true;
    }
}
