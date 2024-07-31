package com.kwad.components.core.p287c;

import androidx.annotation.NonNull;
import com.kwad.components.core.p303m.C8694a;
import com.kwad.components.core.request.C8910a;
import com.kwad.components.core.request.model.C8927a;
import com.kwad.components.p208ad.p210b.InterfaceC7350h;
import com.kwad.sdk.components.C9861c;
import com.kwad.sdk.core.response.model.AdResultData;

/* renamed from: com.kwad.components.core.c.n */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8569n implements InterfaceC8547c {
    /* renamed from: a */
    public static void m30346a(final C8927a c8927a, @NonNull C8557j c8557j) {
        new C8694a(c8927a.f28803Mv) { // from class: com.kwad.components.core.c.n.1
            @Override // com.kwad.components.core.p303m.C8694a, com.kwad.sdk.core.network.AbstractC10436l
            @NonNull
            /* renamed from: Z */
            public final AdResultData parseData(String str) {
                AdResultData createFromResponseJson = AdResultData.createFromResponseJson(str, c8927a.f28803Mv.adScene);
                createFromResponseJson.setAdSource("network");
                return createFromResponseJson;
            }

            @Override // com.kwad.components.core.p303m.C8694a, com.kwad.sdk.core.network.AbstractC10402a
            @NonNull
            /* renamed from: mO */
            public final C8910a createRequest() {
                if (c8927a.getAdStyle() == 4) {
                    c8927a.f28807Rw = ((InterfaceC7350h) C9861c.m27501f(InterfaceC7350h.class)).mo30903R();
                }
                return new C8910a(c8927a);
            }
        }.request(c8557j);
    }

    @Override // com.kwad.components.core.p287c.InterfaceC8547c
    /* renamed from: c */
    public final void mo30345c(C8927a c8927a) {
        m30346a(c8927a, new C8557j(c8927a));
    }

    @Override // com.kwad.components.core.p287c.InterfaceC8547c
    public final String getName() {
        return "StrategyNetworkOnlyFetcher";
    }
}
