package com.kwad.components.core.p304n.p311b.p312a;

import com.kwad.components.offline.api.core.network.IIdc;
import com.kwad.sdk.C10760g;
import com.kwad.sdk.core.network.idc.C10425a;

/* renamed from: com.kwad.components.core.n.b.a.m */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8731m implements IIdc {
    @Override // com.kwad.components.offline.api.core.network.IIdc
    public final String hostForAPI(String str) {
        if (str.equals("api")) {
            return C10760g.m24895xV();
        }
        return "https://" + C10425a.m26107DU().m26103W(str, null);
    }
}
