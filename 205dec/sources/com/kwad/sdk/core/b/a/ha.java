package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class ha implements com.kwad.sdk.core.d<com.kwad.components.core.n.c.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.core.n.c.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.core.n.c.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.components.core.n.c.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.NR = jSONObject.optString("load_module");
        if (JSONObject.NULL.toString().equals(bVar.NR)) {
            bVar.NR = "";
        }
        bVar.NS = jSONObject.optLong("load_status");
        bVar.NT = jSONObject.optLong("load_duration_ms");
        bVar.NU = jSONObject.optLong("thread_core_size", new Long("0").longValue());
        bVar.NV = jSONObject.optString("load_source");
        if (JSONObject.NULL.toString().equals(bVar.NV)) {
            bVar.NV = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.components.core.n.c.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = bVar.NR;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "load_module", bVar.NR);
        }
        long j4 = bVar.NS;
        if (j4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "load_status", j4);
        }
        long j5 = bVar.NT;
        if (j5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "load_duration_ms", j5);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "thread_core_size", bVar.NU);
        String str2 = bVar.NV;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "load_source", bVar.NV);
        }
        return jSONObject;
    }
}
