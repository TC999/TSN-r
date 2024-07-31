package com.kwad.components.p208ad.reward;

import android.content.Context;
import com.kwad.components.core.page.DownloadLandPageActivity;
import com.kwad.components.core.playable.C8874a;
import com.kwad.components.p208ad.reward.p248a.C7844b;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10487e;

/* renamed from: com.kwad.components.ad.reward.k */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C7957k {
    /* renamed from: h */
    public static void m31924h(C7907g c7907g) {
        C8874a c8874a;
        AdTemplate adTemplate = c7907g.mAdTemplate;
        Context context = c7907g.mContext;
        AdInfo m25641dQ = C10487e.m25641dQ(adTemplate);
        if ((C10483a.m25900bH(m25641dQ) && (c8874a = c7907g.f26531oL) != null && c8874a.m29681qf()) || C7844b.m32176k(m25641dQ) || adTemplate.mXiaomiAppStoreDetailViewOpen || !C10483a.m25956aF(m25641dQ) || !C10483a.m25916at(m25641dQ) || adTemplate.hasEnterAdWebViewLandPageActivity) {
            return;
        }
        c7907g.mAdTemplate.hasEnterAdWebViewLandPageActivity = true;
        DownloadLandPageActivity.launch(context, adTemplate, true);
    }
}
