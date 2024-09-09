package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class gn implements com.kwad.sdk.core.d<com.kwad.components.core.webview.tachikoma.b.m> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.core.webview.tachikoma.b.m mVar, JSONObject jSONObject) {
        a2(mVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.core.webview.tachikoma.b.m mVar, JSONObject jSONObject) {
        return b2(mVar, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.components.core.webview.tachikoma.b.m mVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        mVar.aao = jSONObject.optBoolean("muted");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.components.core.webview.tachikoma.b.m mVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z3 = mVar.aao;
        if (z3) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "muted", z3);
        }
        return jSONObject;
    }
}
