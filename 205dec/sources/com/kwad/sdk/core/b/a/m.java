package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class m implements com.kwad.sdk.core.d<com.kwad.sdk.commercial.d.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.commercial.d.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.commercial.d.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.commercial.d.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.aow = jSONObject.optString("method_name");
        if (JSONObject.NULL.toString().equals(bVar.aow)) {
            bVar.aow = "";
        }
        bVar.aox = jSONObject.optBoolean("is_convert");
        bVar.adNum = jSONObject.optInt("ad_num");
        bVar.aoy = jSONObject.optBoolean("is_api_native");
        bVar.aoz = jSONObject.optString("ad_request_type");
        if (JSONObject.NULL.toString().equals(bVar.aoz)) {
            bVar.aoz = "";
        }
        bVar.adSource = jSONObject.optString("ad_require_source");
        if (JSONObject.NULL.toString().equals(bVar.adSource)) {
            bVar.adSource = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.commercial.d.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = bVar.aow;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "method_name", bVar.aow);
        }
        boolean z3 = bVar.aox;
        if (z3) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "is_convert", z3);
        }
        int i4 = bVar.adNum;
        if (i4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "ad_num", i4);
        }
        boolean z4 = bVar.aoy;
        if (z4) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "is_api_native", z4);
        }
        String str2 = bVar.aoz;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "ad_request_type", bVar.aoz);
        }
        String str3 = bVar.adSource;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "ad_require_source", bVar.adSource);
        }
        return jSONObject;
    }
}
