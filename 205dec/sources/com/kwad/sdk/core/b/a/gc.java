package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class gc implements com.kwad.sdk.core.d<com.kwad.components.ad.fullscreen.b.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.ad.fullscreen.b.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.ad.fullscreen.b.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.components.ad.fullscreen.b.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.gM = jSONObject.optLong("lastShowTimestamp");
        bVar.gN = jSONObject.optInt("currentDailyCount");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.components.ad.fullscreen.b.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j4 = bVar.gM;
        if (j4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "lastShowTimestamp", j4);
        }
        int i4 = bVar.gN;
        if (i4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "currentDailyCount", i4);
        }
        return jSONObject;
    }
}
