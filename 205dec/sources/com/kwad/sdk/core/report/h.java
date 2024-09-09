package com.kwad.sdk.core.report;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.response.model.AdTemplate;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
@KsJson
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class h extends com.kwad.sdk.core.response.a.a {
    public int axF;
    public long creativeId;
    public long llsid;
    public int score;
    public String source = "union";

    public static h bW(AdTemplate adTemplate) {
        h hVar = new h();
        hVar.creativeId = com.kwad.sdk.core.response.b.e.ea(adTemplate);
        hVar.llsid = com.kwad.sdk.core.response.b.e.dN(adTemplate);
        int ee = com.kwad.sdk.core.response.b.e.ee(adTemplate);
        hVar.score = ee;
        hVar.axF = ee > 0 ? 1 : 0;
        return hVar;
    }

    public final String EL() {
        return toJson().toString();
    }
}
