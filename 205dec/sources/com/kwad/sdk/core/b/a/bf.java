package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class bf implements com.kwad.sdk.core.d<com.kwad.components.core.webview.tachikoma.b.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.core.webview.tachikoma.b.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.core.webview.tachikoma.b.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.components.core.webview.tachikoma.b.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.aaf = jSONObject.optInt("hasInstalled");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.components.core.webview.tachikoma.b.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i4 = bVar.aaf;
        if (i4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "hasInstalled", i4);
        }
        return jSONObject;
    }
}
