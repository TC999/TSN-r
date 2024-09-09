package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class dl implements com.kwad.sdk.core.d<com.kwad.sdk.core.report.j> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.report.j jVar, JSONObject jSONObject) {
        a2(jVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.report.j jVar, JSONObject jSONObject) {
        return b2(jVar, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.core.report.j jVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        jVar.axG = jSONObject.optString("log");
        if (JSONObject.NULL.toString().equals(jVar.axG)) {
            jVar.axG = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.core.report.j jVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = jVar.axG;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "log", jVar.axG);
        }
        return jSONObject;
    }
}
