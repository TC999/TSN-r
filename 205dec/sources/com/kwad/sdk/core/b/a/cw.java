package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class cw implements com.kwad.sdk.core.d<com.kwad.sdk.commercial.f.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.commercial.f.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.commercial.f.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.commercial.f.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.status = jSONObject.optInt("status");
        bVar.url = jSONObject.optString("url");
        if (JSONObject.NULL.toString().equals(bVar.url)) {
            bVar.url = "";
        }
        bVar.aog = jSONObject.optString("url_host");
        if (JSONObject.NULL.toString().equals(bVar.aog)) {
            bVar.aog = "";
        }
        bVar.aon = jSONObject.optString("url_path");
        if (JSONObject.NULL.toString().equals(bVar.aon)) {
            bVar.aon = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.commercial.f.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i4 = bVar.status;
        if (i4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "status", i4);
        }
        String str = bVar.url;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "url", bVar.url);
        }
        String str2 = bVar.aog;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "url_host", bVar.aog);
        }
        String str3 = bVar.aon;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "url_path", bVar.aon);
        }
        return jSONObject;
    }
}
