package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class ce implements com.kwad.sdk.core.d<com.kwad.components.core.webview.tachikoma.b.g> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.core.webview.tachikoma.b.g gVar, JSONObject jSONObject) {
        a2(gVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.core.webview.tachikoma.b.g gVar, JSONObject jSONObject) {
        return b2(gVar, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.components.core.webview.tachikoma.b.g gVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        gVar.KG = jSONObject.optString("payload");
        if (JSONObject.NULL.toString().equals(gVar.KG)) {
            gVar.KG = "";
        }
        gVar.actionType = jSONObject.optInt("actionType");
        gVar.VN = jSONObject.optInt("adCacheId");
        gVar.Jj = jSONObject.optString("creativeId");
        if (JSONObject.NULL.toString().equals(gVar.Jj)) {
            gVar.Jj = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.components.core.webview.tachikoma.b.g gVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = gVar.KG;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "payload", gVar.KG);
        }
        int i4 = gVar.actionType;
        if (i4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "actionType", i4);
        }
        int i5 = gVar.VN;
        if (i5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "adCacheId", i5);
        }
        String str2 = gVar.Jj;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "creativeId", gVar.Jj);
        }
        return jSONObject;
    }
}
