package com.kwad.components.core.c;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.AdResultData;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class n implements c {
    public static void a(final com.kwad.components.core.request.model.a aVar, @NonNull j jVar) {
        new com.kwad.components.core.m.a(aVar.Mv) { // from class: com.kwad.components.core.c.n.1
            @Override // com.kwad.components.core.m.a, com.kwad.sdk.core.network.l
            @NonNull
            /* renamed from: Z */
            public final AdResultData parseData(String str) {
                AdResultData createFromResponseJson = AdResultData.createFromResponseJson(str, aVar.Mv.adScene);
                createFromResponseJson.setAdSource("network");
                return createFromResponseJson;
            }

            @Override // com.kwad.components.core.m.a, com.kwad.sdk.core.network.a
            @NonNull
            /* renamed from: mO */
            public final com.kwad.components.core.request.a createRequest() {
                if (aVar.getAdStyle() == 4) {
                    aVar.Rw = ((com.kwad.components.ad.b.h) com.kwad.sdk.components.c.f(com.kwad.components.ad.b.h.class)).R();
                }
                return new com.kwad.components.core.request.a(aVar);
            }
        }.request(jVar);
    }

    @Override // com.kwad.components.core.c.c
    public final void c(com.kwad.components.core.request.model.a aVar) {
        a(aVar, new j(aVar));
    }

    @Override // com.kwad.components.core.c.c
    public final String getName() {
        return "StrategyNetworkOnlyFetcher";
    }
}
