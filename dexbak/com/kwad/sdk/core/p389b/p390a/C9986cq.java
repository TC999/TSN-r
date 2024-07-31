package com.kwad.sdk.core.p389b.p390a;

import com.kwad.components.core.webview.jshandler.C9075al;
import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.core.webview.p423d.p425b.C10642c;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.cq */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9986cq implements InterfaceC10273d<C9075al.C9079a> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(C9075al.C9079a c9079a, JSONObject jSONObject) {
        m27110a(c9079a, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(C9075al.C9079a c9079a, JSONObject jSONObject) {
        return m27109b(c9079a, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m27110a(C9075al.C9079a c9079a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c9079a.f29168XA = jSONObject.optBoolean("clickActionButton");
        c9079a.f29169XB = jSONObject.optString("adTemplate");
        if (JSONObject.NULL.toString().equals(c9079a.f29169XB)) {
            c9079a.f29169XB = "";
        }
        c9079a.f29170XC = jSONObject.optInt("area");
        C10642c c10642c = new C10642c();
        c9079a.f29171XD = c10642c;
        c10642c.parseJson(jSONObject.optJSONObject("logParam"));
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m27109b(C9075al.C9079a c9079a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z = c9079a.f29168XA;
        if (z) {
            C11126t.putValue(jSONObject, "clickActionButton", z);
        }
        String str = c9079a.f29169XB;
        if (str != null && !str.equals("")) {
            C11126t.putValue(jSONObject, "adTemplate", c9079a.f29169XB);
        }
        int i = c9079a.f29170XC;
        if (i != 0) {
            C11126t.putValue(jSONObject, "area", i);
        }
        C11126t.m23678a(jSONObject, "logParam", c9079a.f29171XD);
        return jSONObject;
    }
}
