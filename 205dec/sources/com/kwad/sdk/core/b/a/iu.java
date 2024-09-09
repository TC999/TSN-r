package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class iu implements com.kwad.sdk.core.d<com.kwad.components.core.webview.tachikoma.b.t> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.core.webview.tachikoma.b.t tVar, JSONObject jSONObject) {
        a2(tVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.core.webview.tachikoma.b.t tVar, JSONObject jSONObject) {
        return b2(tVar, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.components.core.webview.tachikoma.b.t tVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        tVar.aas = jSONObject.optBoolean("needPromopt");
        tVar.KE = jSONObject.optBoolean("needReport");
        tVar.showTime = jSONObject.optInt("showTime");
        tVar.VU = jSONObject.optLong("playDuration");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.components.core.webview.tachikoma.b.t tVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z3 = tVar.aas;
        if (z3) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "needPromopt", z3);
        }
        boolean z4 = tVar.KE;
        if (z4) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "needReport", z4);
        }
        int i4 = tVar.showTime;
        if (i4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "showTime", i4);
        }
        long j4 = tVar.VU;
        if (j4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "playDuration", j4);
        }
        return jSONObject;
    }
}
