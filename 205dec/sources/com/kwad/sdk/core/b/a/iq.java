package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class iq implements com.kwad.sdk.core.d<com.kwad.components.core.webview.tachikoma.b.q> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.core.webview.tachikoma.b.q qVar, JSONObject jSONObject) {
        a2(qVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.core.webview.tachikoma.b.q qVar, JSONObject jSONObject) {
        return b2(qVar, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.components.core.webview.tachikoma.b.q qVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        qVar.aar = jSONObject.optBoolean("userForce");
        qVar.type = jSONObject.optInt("type");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.components.core.webview.tachikoma.b.q qVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z3 = qVar.aar;
        if (z3) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "userForce", z3);
        }
        int i4 = qVar.type;
        if (i4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "type", i4);
        }
        return jSONObject;
    }
}
