package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class ac implements com.kwad.sdk.core.d<com.kwad.sdk.core.adlog.b.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.adlog.b.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.adlog.b.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.core.adlog.b.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.status = jSONObject.optInt("status");
        bVar.aoM = jSONObject.optInt("ad_action_type");
        bVar.retryCount = jSONObject.optInt("retry_count");
        bVar.apt = jSONObject.optInt("retry_error_code");
        bVar.apu = jSONObject.optString("retry_error_msg");
        if (JSONObject.NULL.toString().equals(bVar.apu)) {
            bVar.apu = "";
        }
        bVar.apD = jSONObject.optInt("cache_total_num");
        bVar.apE = jSONObject.optInt("cache_num");
        bVar.apF = jSONObject.optLong("cacheTimeMs");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.core.adlog.b.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i4 = bVar.status;
        if (i4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "status", i4);
        }
        int i5 = bVar.aoM;
        if (i5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "ad_action_type", i5);
        }
        int i6 = bVar.retryCount;
        if (i6 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "retry_count", i6);
        }
        int i7 = bVar.apt;
        if (i7 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "retry_error_code", i7);
        }
        String str = bVar.apu;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "retry_error_msg", bVar.apu);
        }
        int i8 = bVar.apD;
        if (i8 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "cache_total_num", i8);
        }
        int i9 = bVar.apE;
        if (i9 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "cache_num", i9);
        }
        long j4 = bVar.apF;
        if (j4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "cacheTimeMs", j4);
        }
        return jSONObject;
    }
}
