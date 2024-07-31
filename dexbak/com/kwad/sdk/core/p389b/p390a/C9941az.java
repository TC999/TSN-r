package com.kwad.sdk.core.p389b.p390a;

import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.ranger.p446a.C10946a;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.az */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9941az implements InterfaceC10273d<C10946a> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(C10946a c10946a, JSONObject jSONObject) {
        m27192a(c10946a, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(C10946a c10946a, JSONObject jSONObject) {
        return m27191b(c10946a, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m27192a(C10946a c10946a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c10946a.aNx = jSONObject.optString("nodeClassName");
        if (JSONObject.NULL.toString().equals(c10946a.aNx)) {
            c10946a.aNx = "";
        }
        c10946a.aNy = jSONObject.optString("childFieldName");
        if (JSONObject.NULL.toString().equals(c10946a.aNy)) {
            c10946a.aNy = "";
        }
        c10946a.aNz = jSONObject.optBoolean("childFieldIsStatic");
        c10946a.aNA = jSONObject.optString("reportKey");
        if (JSONObject.NULL.toString().equals(c10946a.aNA)) {
            c10946a.aNA = "";
        }
        C10946a.C10948b c10948b = new C10946a.C10948b();
        c10946a.aNB = c10948b;
        c10948b.parseJson(jSONObject.optJSONObject("childMethod"));
        C10946a c10946a2 = new C10946a();
        c10946a.aNC = c10946a2;
        c10946a2.parseJson(jSONObject.optJSONObject("deepNode"));
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m27191b(C10946a c10946a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = c10946a.aNx;
        if (str != null && !str.equals("")) {
            C11126t.putValue(jSONObject, "nodeClassName", c10946a.aNx);
        }
        String str2 = c10946a.aNy;
        if (str2 != null && !str2.equals("")) {
            C11126t.putValue(jSONObject, "childFieldName", c10946a.aNy);
        }
        boolean z = c10946a.aNz;
        if (z) {
            C11126t.putValue(jSONObject, "childFieldIsStatic", z);
        }
        String str3 = c10946a.aNA;
        if (str3 != null && !str3.equals("")) {
            C11126t.putValue(jSONObject, "reportKey", c10946a.aNA);
        }
        C11126t.m23678a(jSONObject, "childMethod", c10946a.aNB);
        C11126t.m23678a(jSONObject, "deepNode", c10946a.aNC);
        return jSONObject;
    }
}
