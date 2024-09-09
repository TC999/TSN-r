package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class ad implements com.kwad.sdk.core.d<com.kwad.sdk.core.adlog.b.d> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.adlog.b.d dVar, JSONObject jSONObject) {
        a2(dVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.adlog.b.d dVar, JSONObject jSONObject) {
        return b2(dVar, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.core.adlog.b.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        dVar.status = jSONObject.optInt("status");
        dVar.aoO = jSONObject.optString("final_url");
        if (JSONObject.NULL.toString().equals(dVar.aoO)) {
            dVar.aoO = "";
        }
        dVar.aoM = jSONObject.optInt("ad_action_type");
        dVar.apG = jSONObject.optInt("cache_type", new Integer("0").intValue());
        dVar.retryCount = jSONObject.optInt("retry_count", new Integer("0").intValue());
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.core.adlog.b.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i4 = dVar.status;
        if (i4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "status", i4);
        }
        String str = dVar.aoO;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "final_url", dVar.aoO);
        }
        int i5 = dVar.aoM;
        if (i5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "ad_action_type", i5);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "cache_type", dVar.apG);
        com.kwad.sdk.utils.t.putValue(jSONObject, "retry_count", dVar.retryCount);
        return jSONObject;
    }
}
