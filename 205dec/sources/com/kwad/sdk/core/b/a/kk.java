package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class kk implements com.kwad.sdk.core.d<com.kwad.components.core.webview.tachikoma.b.v> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.core.webview.tachikoma.b.v vVar, JSONObject jSONObject) {
        a2(vVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.core.webview.tachikoma.b.v vVar, JSONObject jSONObject) {
        return b2(vVar, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.components.core.webview.tachikoma.b.v vVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        vVar.aau = jSONObject.optInt("rewardTaskState");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.components.core.webview.tachikoma.b.v vVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i4 = vVar.aau;
        if (i4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "rewardTaskState", i4);
        }
        return jSONObject;
    }
}
