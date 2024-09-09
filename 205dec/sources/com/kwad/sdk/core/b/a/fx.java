package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class fx implements com.kwad.sdk.core.d<com.kwad.sdk.utils.b.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.utils.b.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.utils.b.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.utils.b.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.aSj = jSONObject.optInt("put_count");
        aVar.aSk = jSONObject.optInt("get_failed_count");
        aVar.aSl = jSONObject.optInt("get_success_count");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.utils.b.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i4 = aVar.aSj;
        if (i4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "put_count", i4);
        }
        int i5 = aVar.aSk;
        if (i5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "get_failed_count", i5);
        }
        int i6 = aVar.aSl;
        if (i6 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "get_success_count", i6);
        }
        return jSONObject;
    }
}
