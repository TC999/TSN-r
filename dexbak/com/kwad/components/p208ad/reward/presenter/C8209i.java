package com.kwad.components.p208ad.reward.presenter;

import com.kwad.components.core.playable.C8874a;
import com.kwad.components.p208ad.reward.C7907g;
import com.kwad.components.p208ad.reward.p248a.C7844b;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10487e;

/* renamed from: com.kwad.components.ad.reward.presenter.i */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8209i {
    /* renamed from: x */
    public static boolean m31264x(C7907g c7907g) {
        C8874a c8874a;
        AdTemplate adTemplate = c7907g.mAdTemplate;
        AdInfo m25641dQ = C10487e.m25641dQ(adTemplate);
        if ((C10483a.m25900bH(m25641dQ) && (c8874a = c7907g.f26531oL) != null && c8874a.m29681qf()) || C7844b.m32176k(m25641dQ) || adTemplate.mXiaomiAppStoreDetailViewOpen) {
            return false;
        }
        if (C7844b.m32193gB()) {
            return true;
        }
        return C10483a.m25956aF(m25641dQ) && C10483a.m25916at(m25641dQ);
    }
}
