package com.kwad.components.ad.reward;

import android.content.Context;
import com.kwad.components.core.page.DownloadLandPageActivity;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class k {
    public static void h(g gVar) {
        com.kwad.components.core.playable.a aVar;
        AdTemplate adTemplate = gVar.mAdTemplate;
        Context context = gVar.mContext;
        AdInfo dQ = com.kwad.sdk.core.response.b.e.dQ(adTemplate);
        if ((com.kwad.sdk.core.response.b.a.bH(dQ) && (aVar = gVar.oL) != null && aVar.qf()) || com.kwad.components.ad.reward.a.b.k(dQ) || adTemplate.mXiaomiAppStoreDetailViewOpen || !com.kwad.sdk.core.response.b.a.aF(dQ) || !com.kwad.sdk.core.response.b.a.at(dQ) || adTemplate.hasEnterAdWebViewLandPageActivity) {
            return;
        }
        gVar.mAdTemplate.hasEnterAdWebViewLandPageActivity = true;
        DownloadLandPageActivity.launch(context, adTemplate, true);
    }
}
