package com.kwad.sdk.core.p389b.p390a;

import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.core.webview.p423d.p425b.C10641b;
import com.kwad.sdk.core.webview.p423d.p425b.C10642c;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.gd */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10081gd implements InterfaceC10273d<C10642c> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(C10642c c10642c, JSONObject jSONObject) {
        m26926a(c10642c, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(C10642c c10642c, JSONObject jSONObject) {
        return m26925b(c10642c, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26926a(C10642c c10642c, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c10642c.aEP = jSONObject.optInt("convertType");
        c10642c.f29649KG = jSONObject.optString("payload");
        if (JSONObject.NULL.toString().equals(c10642c.f29649KG)) {
            c10642c.f29649KG = "";
        }
        C10641b c10641b = new C10641b();
        c10642c.aEQ = c10641b;
        c10641b.parseJson(jSONObject.optJSONObject("clickInfo"));
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m26925b(C10642c c10642c, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = c10642c.aEP;
        if (i != 0) {
            C11126t.putValue(jSONObject, "convertType", i);
        }
        String str = c10642c.f29649KG;
        if (str != null && !str.equals("")) {
            C11126t.putValue(jSONObject, "payload", c10642c.f29649KG);
        }
        C11126t.m23678a(jSONObject, "clickInfo", c10642c.aEQ);
        return jSONObject;
    }
}
