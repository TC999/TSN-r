package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class eo implements com.kwad.sdk.core.d<com.kwad.components.core.webview.tachikoma.b.i> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.core.webview.tachikoma.b.i iVar, JSONObject jSONObject) {
        a2(iVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.core.webview.tachikoma.b.i iVar, JSONObject jSONObject) {
        return b2(iVar, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.components.core.webview.tachikoma.b.i iVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        iVar.rewardTime = jSONObject.optInt("rewardTime");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.components.core.webview.tachikoma.b.i iVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i4 = iVar.rewardTime;
        if (i4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "rewardTime", i4);
        }
        return jSONObject;
    }
}
