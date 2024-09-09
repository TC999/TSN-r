package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class s implements com.kwad.sdk.core.d<com.kwad.components.core.k.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.core.k.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.core.k.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.components.core.k.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.Mq = jSONObject.optInt("currentActiveCount");
        aVar.Mr = jSONObject.optLong("lastForceActiveTimestamp");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.components.core.k.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i4 = aVar.Mq;
        if (i4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "currentActiveCount", i4);
        }
        long j4 = aVar.Mr;
        if (j4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "lastForceActiveTimestamp", j4);
        }
        return jSONObject;
    }
}
