package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class hu implements com.kwad.sdk.core.d<com.kwad.sdk.core.response.model.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.response.model.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.response.model.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.core.response.model.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.posId = jSONObject.optLong("posId");
        aVar.azV = jSONObject.optInt("adPhotoCountForMedia");
        aVar.azW = jSONObject.optBoolean("enablePreload");
        aVar.azX = jSONObject.optLong("increaseAdLoadTime", new Long("10000").longValue());
        aVar.azY = jSONObject.optInt("adLoadStrategy");
        aVar.azZ = jSONObject.optInt("drawAdForcedWatchTimes", new Integer("3").intValue());
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.core.response.model.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j4 = aVar.posId;
        if (j4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "posId", j4);
        }
        int i4 = aVar.azV;
        if (i4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "adPhotoCountForMedia", i4);
        }
        boolean z3 = aVar.azW;
        if (z3) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "enablePreload", z3);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "increaseAdLoadTime", aVar.azX);
        int i5 = aVar.azY;
        if (i5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "adLoadStrategy", i5);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "drawAdForcedWatchTimes", aVar.azZ);
        return jSONObject;
    }
}
