package com.kwad.sdk.core.b.a;

import com.kwad.components.core.webview.jshandler.al;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class cq implements com.kwad.sdk.core.d<al.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(al.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(al.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(al.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.XA = jSONObject.optBoolean("clickActionButton");
        aVar.XB = jSONObject.optString("adTemplate");
        if (JSONObject.NULL.toString().equals(aVar.XB)) {
            aVar.XB = "";
        }
        aVar.XC = jSONObject.optInt("area");
        com.kwad.sdk.core.webview.d.b.c cVar = new com.kwad.sdk.core.webview.d.b.c();
        aVar.XD = cVar;
        cVar.parseJson(jSONObject.optJSONObject("logParam"));
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(al.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z3 = aVar.XA;
        if (z3) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "clickActionButton", z3);
        }
        String str = aVar.XB;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "adTemplate", aVar.XB);
        }
        int i4 = aVar.XC;
        if (i4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "area", i4);
        }
        com.kwad.sdk.utils.t.a(jSONObject, "logParam", aVar.XD);
        return jSONObject;
    }
}
