package com.kwad.sdk.core.b.a;

import com.kwad.components.core.webview.jshandler.a;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class gt implements com.kwad.sdk.core.d<a.c> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(a.c cVar, JSONObject jSONObject) {
        a2(cVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(a.c cVar, JSONObject jSONObject) {
        return b2(cVar, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(a.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        cVar.errorCode = jSONObject.optInt("errorCode");
        cVar.VT = jSONObject.optInt("extra");
        cVar.VU = jSONObject.optLong("playDuration");
        cVar.VV = jSONObject.optBoolean("clickRewardDialog");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(a.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i4 = cVar.errorCode;
        if (i4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "errorCode", i4);
        }
        int i5 = cVar.VT;
        if (i5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "extra", i5);
        }
        long j4 = cVar.VU;
        if (j4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "playDuration", j4);
        }
        boolean z3 = cVar.VV;
        if (z3) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "clickRewardDialog", z3);
        }
        return jSONObject;
    }
}
