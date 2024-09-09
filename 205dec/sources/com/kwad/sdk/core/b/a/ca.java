package com.kwad.sdk.core.b.a;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class ca implements com.kwad.sdk.core.d<com.kwad.sdk.core.report.h> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.report.h hVar, JSONObject jSONObject) {
        a2(hVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.report.h hVar, JSONObject jSONObject) {
        return b2(hVar, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.core.report.h hVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        hVar.llsid = jSONObject.optLong("llsid");
        hVar.creativeId = jSONObject.optLong(CampaignEx.JSON_KEY_CREATIVE_ID);
        hVar.score = jSONObject.optInt("score");
        hVar.axF = jSONObject.optInt("is_bidding");
        hVar.source = jSONObject.optString("source");
        if (JSONObject.NULL.toString().equals(hVar.source)) {
            hVar.source = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.core.report.h hVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j4 = hVar.llsid;
        if (j4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "llsid", j4);
        }
        long j5 = hVar.creativeId;
        if (j5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, CampaignEx.JSON_KEY_CREATIVE_ID, j5);
        }
        int i4 = hVar.score;
        if (i4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "score", i4);
        }
        int i5 = hVar.axF;
        if (i5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "is_bidding", i5);
        }
        String str = hVar.source;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "source", hVar.source);
        }
        return jSONObject;
    }
}
