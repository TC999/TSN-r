package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class e implements com.kwad.sdk.core.d<com.kwad.sdk.core.webview.d.b.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.webview.d.b.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.webview.d.b.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.core.webview.d.b.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.XA = jSONObject.optBoolean("clickActionButton");
        aVar.XC = jSONObject.optInt("area");
        aVar.kl = jSONObject.optInt("itemClickType");
        aVar.aEL = jSONObject.optInt("convertPageType", new Integer("-1").intValue());
        com.kwad.sdk.core.webview.d.b.c cVar = new com.kwad.sdk.core.webview.d.b.c();
        aVar.XD = cVar;
        cVar.parseJson(jSONObject.optJSONObject("logParam"));
        aVar.KE = jSONObject.optBoolean("needReport", new Boolean("true").booleanValue());
        aVar.creativeId = jSONObject.optLong("creativeId", new Long("-1").longValue());
        aVar.KS = jSONObject.optString("liveItemId");
        if (JSONObject.NULL.toString().equals(aVar.KS)) {
            aVar.KS = "";
        }
        aVar.aEM = jSONObject.optInt("sceneType");
        aVar.adStyle = jSONObject.optInt("adStyle", new Integer("-1").intValue());
        aVar.aEN = jSONObject.optBoolean("isCallbackOnly");
        aVar.aEO = jSONObject.optBoolean("disableCallback");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.core.webview.d.b.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z3 = aVar.XA;
        if (z3) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "clickActionButton", z3);
        }
        int i4 = aVar.XC;
        if (i4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "area", i4);
        }
        int i5 = aVar.kl;
        if (i5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "itemClickType", i5);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "convertPageType", aVar.aEL);
        com.kwad.sdk.utils.t.a(jSONObject, "logParam", aVar.XD);
        com.kwad.sdk.utils.t.putValue(jSONObject, "needReport", aVar.KE);
        com.kwad.sdk.utils.t.putValue(jSONObject, "creativeId", aVar.creativeId);
        String str = aVar.KS;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "liveItemId", aVar.KS);
        }
        int i6 = aVar.aEM;
        if (i6 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "sceneType", i6);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "adStyle", aVar.adStyle);
        boolean z4 = aVar.aEN;
        if (z4) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "isCallbackOnly", z4);
        }
        boolean z5 = aVar.aEO;
        if (z5) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "disableCallback", z5);
        }
        return jSONObject;
    }
}
