package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class bj implements com.kwad.sdk.core.d<com.kwad.components.core.webview.tachikoma.b.c> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.core.webview.tachikoma.b.c cVar, JSONObject jSONObject) {
        a2(cVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.core.webview.tachikoma.b.c cVar, JSONObject jSONObject) {
        return b2(cVar, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.components.core.webview.tachikoma.b.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        cVar.aag = jSONObject.optInt("showCount", new Integer("0").intValue());
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.components.core.webview.tachikoma.b.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "showCount", cVar.aag);
        return jSONObject;
    }
}
