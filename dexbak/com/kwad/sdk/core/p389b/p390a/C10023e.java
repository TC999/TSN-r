package com.kwad.sdk.core.p389b.p390a;

import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.core.webview.p423d.p425b.C10640a;
import com.kwad.sdk.core.webview.p423d.p425b.C10642c;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.e */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10023e implements InterfaceC10273d<C10640a> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(C10640a c10640a, JSONObject jSONObject) {
        m27038a(c10640a, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(C10640a c10640a, JSONObject jSONObject) {
        return m27037b(c10640a, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m27038a(C10640a c10640a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c10640a.f29643XA = jSONObject.optBoolean("clickActionButton");
        c10640a.f29644XC = jSONObject.optInt("area");
        c10640a.f29646kl = jSONObject.optInt("itemClickType");
        c10640a.aEL = jSONObject.optInt("convertPageType", new Integer("-1").intValue());
        C10642c c10642c = new C10642c();
        c10640a.f29645XD = c10642c;
        c10642c.parseJson(jSONObject.optJSONObject("logParam"));
        c10640a.f29640KE = jSONObject.optBoolean("needReport", new Boolean("true").booleanValue());
        c10640a.creativeId = jSONObject.optLong("creativeId", new Long("-1").longValue());
        c10640a.f29641KS = jSONObject.optString("liveItemId");
        if (JSONObject.NULL.toString().equals(c10640a.f29641KS)) {
            c10640a.f29641KS = "";
        }
        c10640a.aEM = jSONObject.optInt("sceneType");
        c10640a.adStyle = jSONObject.optInt("adStyle", new Integer("-1").intValue());
        c10640a.aEN = jSONObject.optBoolean("isCallbackOnly");
        c10640a.aEO = jSONObject.optBoolean("disableCallback");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m27037b(C10640a c10640a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z = c10640a.f29643XA;
        if (z) {
            C11126t.putValue(jSONObject, "clickActionButton", z);
        }
        int i = c10640a.f29644XC;
        if (i != 0) {
            C11126t.putValue(jSONObject, "area", i);
        }
        int i2 = c10640a.f29646kl;
        if (i2 != 0) {
            C11126t.putValue(jSONObject, "itemClickType", i2);
        }
        C11126t.putValue(jSONObject, "convertPageType", c10640a.aEL);
        C11126t.m23678a(jSONObject, "logParam", c10640a.f29645XD);
        C11126t.putValue(jSONObject, "needReport", c10640a.f29640KE);
        C11126t.putValue(jSONObject, "creativeId", c10640a.creativeId);
        String str = c10640a.f29641KS;
        if (str != null && !str.equals("")) {
            C11126t.putValue(jSONObject, "liveItemId", c10640a.f29641KS);
        }
        int i3 = c10640a.aEM;
        if (i3 != 0) {
            C11126t.putValue(jSONObject, "sceneType", i3);
        }
        C11126t.putValue(jSONObject, "adStyle", c10640a.adStyle);
        boolean z2 = c10640a.aEN;
        if (z2) {
            C11126t.putValue(jSONObject, "isCallbackOnly", z2);
        }
        boolean z3 = c10640a.aEO;
        if (z3) {
            C11126t.putValue(jSONObject, "disableCallback", z3);
        }
        return jSONObject;
    }
}
