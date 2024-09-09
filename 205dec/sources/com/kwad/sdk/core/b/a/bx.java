package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class bx implements com.kwad.sdk.core.d<com.kwad.sdk.core.webview.d.b.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.webview.d.b.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.webview.d.b.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.core.webview.d.b.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.f38656x = jSONObject.optDouble("x");
        bVar.f38657y = jSONObject.optDouble("y");
        bVar.width = jSONObject.optInt("width");
        bVar.height = jSONObject.optInt("height");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.core.webview.d.b.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        double d4 = bVar.f38656x;
        if (d4 != 0.0d) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "x", d4);
        }
        double d5 = bVar.f38657y;
        if (d5 != 0.0d) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "y", d5);
        }
        int i4 = bVar.width;
        if (i4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "width", i4);
        }
        int i5 = bVar.height;
        if (i5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "height", i5);
        }
        return jSONObject;
    }
}
