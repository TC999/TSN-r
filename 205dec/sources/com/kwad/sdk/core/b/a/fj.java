package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class fj implements com.kwad.sdk.core.d<com.kwad.components.ad.interstitial.d.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.ad.interstitial.d.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.ad.interstitial.d.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.components.ad.interstitial.d.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.jD = jSONObject.optLong("lastShowCardTimeStamp");
        aVar.jE = jSONObject.optInt("cardShowCount");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.components.ad.interstitial.d.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j4 = aVar.jD;
        if (j4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "lastShowCardTimeStamp", j4);
        }
        int i4 = aVar.jE;
        if (i4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "cardShowCount", i4);
        }
        return jSONObject;
    }
}
