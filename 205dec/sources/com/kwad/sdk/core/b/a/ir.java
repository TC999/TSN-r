package com.kwad.sdk.core.b.a;

import com.kwad.components.ad.reward.k.s;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class ir implements com.kwad.sdk.core.d<s.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(s.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(s.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(s.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.xr = jSONObject.optBoolean("needCloseNeo");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(s.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z3 = aVar.xr;
        if (z3) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "needCloseNeo", z3);
        }
        return jSONObject;
    }
}
