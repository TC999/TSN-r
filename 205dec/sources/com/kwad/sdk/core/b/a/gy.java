package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class gy implements com.kwad.sdk.core.d<com.kwad.sdk.core.network.i> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.network.i iVar, JSONObject jSONObject) {
        a2(iVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.network.i iVar, JSONObject jSONObject) {
        return b2(iVar, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.core.network.i iVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        iVar.url = jSONObject.optString("url");
        if (JSONObject.NULL.toString().equals(iVar.url)) {
            iVar.url = "";
        }
        iVar.host = jSONObject.optString("host");
        if (JSONObject.NULL.toString().equals(iVar.host)) {
            iVar.host = "";
        }
        iVar.httpCode = jSONObject.optInt("http_code");
        iVar.avO = jSONObject.optString("req_type");
        if (JSONObject.NULL.toString().equals(iVar.avO)) {
            iVar.avO = "";
        }
        iVar.avP = jSONObject.optInt("use_ip");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.core.network.i iVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = iVar.url;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "url", iVar.url);
        }
        String str2 = iVar.host;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "host", iVar.host);
        }
        int i4 = iVar.httpCode;
        if (i4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "http_code", i4);
        }
        String str3 = iVar.avO;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "req_type", iVar.avO);
        }
        int i5 = iVar.avP;
        if (i5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "use_ip", i5);
        }
        return jSONObject;
    }
}
