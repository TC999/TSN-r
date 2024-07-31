package com.kwad.components.p208ad.p209a;

import com.kwad.components.core.request.C8910a;
import com.kwad.components.core.request.model.C8927a;
import com.kwad.sdk.C10760g;

/* renamed from: com.kwad.components.ad.a.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C7330a extends C8910a {
    public C7330a(C8927a c8927a) {
        super(c8927a);
        putBody("requestTime", System.currentTimeMillis());
    }

    @Override // com.kwad.components.core.request.C8910a, com.kwad.sdk.core.network.AbstractC10410b, com.kwad.sdk.core.network.InterfaceC10420f
    public final String getUrl() {
        return C10760g.m24892xY();
    }
}
