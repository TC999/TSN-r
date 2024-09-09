package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class bv implements com.kwad.sdk.core.d<com.kwad.components.core.webview.tachikoma.b.e> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.core.webview.tachikoma.b.e eVar, JSONObject jSONObject) {
        a2(eVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.core.webview.tachikoma.b.e eVar, JSONObject jSONObject) {
        return b2(eVar, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.components.core.webview.tachikoma.b.e eVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        eVar.height = jSONObject.optInt("height");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.components.core.webview.tachikoma.b.e eVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i4 = eVar.height;
        if (i4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "height", i4);
        }
        return jSONObject;
    }
}
