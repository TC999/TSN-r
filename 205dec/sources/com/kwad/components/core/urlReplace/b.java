package com.kwad.components.core.urlReplace;

import com.kwad.sdk.core.network.d;
import com.kwad.sdk.h;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public final class b extends d {
    public b(String str) {
        putBody("originalMiMarketUrl", str);
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public final String getUrl() {
        return h.yN();
    }
}
