package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class kc implements com.kwad.sdk.core.d<com.kwad.sdk.core.threads.d> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.threads.d dVar, JSONObject jSONObject) {
        a2(dVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.threads.d dVar, JSONObject jSONObject) {
        return b2(dVar, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.core.threads.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        dVar.aAN = jSONObject.optInt("rate_reciprocal");
        dVar.aAT = jSONObject.optInt("threshold");
        dVar.interval = jSONObject.optLong("interval");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.core.threads.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i4 = dVar.aAN;
        if (i4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "rate_reciprocal", i4);
        }
        int i5 = dVar.aAT;
        if (i5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "threshold", i5);
        }
        long j4 = dVar.interval;
        if (j4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "interval", j4);
        }
        return jSONObject;
    }
}
