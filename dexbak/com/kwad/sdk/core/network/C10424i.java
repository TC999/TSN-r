package com.kwad.sdk.core.network;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.commercial.p374c.AbstractC9822a;

@KsJson
/* renamed from: com.kwad.sdk.core.network.i */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C10424i extends AbstractC9822a {
    public String avO;
    public int avP = 0;
    public String host;
    public int httpCode;
    public String url;

    @Override // com.kwad.sdk.core.response.p408a.C10482a
    public String toString() {
        return toJson().toString();
    }
}
