package com.kwad.components.p208ad.reward.presenter;

import android.view.ViewGroup;
import android.view.ViewStub;
import com.kwad.components.p208ad.reward.p248a.C7844b;
import com.kwad.components.p208ad.reward.p249b.C7858c;
import com.kwad.components.p208ad.reward.p264n.View$OnClickListenerC8065n;
import com.kwad.components.p208ad.reward.presenter.platdetail.actionbar.C8273d;
import com.kwad.components.p208ad.reward.presenter.platdetail.actionbar.C8274e;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.p409b.C10483a;

/* renamed from: com.kwad.components.ad.reward.presenter.e */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8136e extends C8094b {
    private AdInfo mAdInfo;

    public C8136e(AdInfo adInfo, ViewGroup viewGroup) {
        ViewGroup viewGroup2;
        ViewGroup viewGroup3;
        this.mAdInfo = adInfo;
        if (C7844b.m32178i(adInfo)) {
            final C7858c c7858c = new C7858c();
            m24612a(c7858c);
            ViewStub viewStub = (ViewStub) viewGroup.findViewById(C9659R.C9662id.ksad_reward_order_card);
            if (viewStub != null) {
                viewGroup3 = (ViewGroup) viewStub.inflate();
            } else {
                viewGroup3 = (ViewGroup) viewGroup.findViewById(C9659R.C9662id.ksad_reward_order_root);
            }
            m24612a(new C8274e(viewGroup3, new View$OnClickListenerC8065n.InterfaceC8068a() { // from class: com.kwad.components.ad.reward.presenter.e.1
                @Override // com.kwad.components.p208ad.reward.p264n.View$OnClickListenerC8065n.InterfaceC8068a
                /* renamed from: ht */
                public final void mo31488ht() {
                    c7858c.showDialog();
                }
            }));
        } else if (C10483a.m25827ca(adInfo) == 1) {
            ViewStub viewStub2 = (ViewStub) viewGroup.findViewById(C9659R.C9662id.ksad_reward_jinniu_card);
            if (viewStub2 != null) {
                viewGroup2 = (ViewGroup) viewStub2.inflate();
            } else {
                viewGroup2 = (ViewGroup) viewGroup.findViewById(C9659R.C9662id.ksad_reward_jinniu_root);
            }
            m24612a(new C8273d(viewGroup2));
        }
    }
}
