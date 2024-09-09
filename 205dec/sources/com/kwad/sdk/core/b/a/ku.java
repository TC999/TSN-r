package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class ku implements com.kwad.sdk.core.d<com.kwad.components.core.webview.tachikoma.b.y> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.core.webview.tachikoma.b.y yVar, JSONObject jSONObject) {
        a2(yVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.core.webview.tachikoma.b.y yVar, JSONObject jSONObject) {
        return b2(yVar, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.components.core.webview.tachikoma.b.y yVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        yVar.nE = jSONObject.optInt("currentTime");
        yVar.aax = jSONObject.optBoolean("failed");
        yVar.aat = jSONObject.optBoolean("finished");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.components.core.webview.tachikoma.b.y yVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i4 = yVar.nE;
        if (i4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "currentTime", i4);
        }
        boolean z3 = yVar.aax;
        if (z3) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "failed", z3);
        }
        boolean z4 = yVar.aat;
        if (z4) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "finished", z4);
        }
        return jSONObject;
    }
}
