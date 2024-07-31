package com.kwad.sdk.core.p389b.p390a;

import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.p439j.C10824b;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.im */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10144im implements InterfaceC10273d<C10824b.C10827a> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(C10824b.C10827a c10827a, JSONObject jSONObject) {
        m26800a(c10827a, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(C10824b.C10827a c10827a, JSONObject jSONObject) {
        return m26799b(c10827a, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26800a(C10824b.C10827a c10827a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c10827a.aJF = jSONObject.optInt("ds");
        c10827a.sdkVersion = jSONObject.optString("sv");
        if (JSONObject.NULL.toString().equals(c10827a.sdkVersion)) {
            c10827a.sdkVersion = "";
        }
        c10827a.aFq = jSONObject.optString("spv");
        if (JSONObject.NULL.toString().equals(c10827a.aFq)) {
            c10827a.aFq = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m26799b(C10824b.C10827a c10827a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = c10827a.aJF;
        if (i != 0) {
            C11126t.putValue(jSONObject, "ds", i);
        }
        String str = c10827a.sdkVersion;
        if (str != null && !str.equals("")) {
            C11126t.putValue(jSONObject, "sv", c10827a.sdkVersion);
        }
        String str2 = c10827a.aFq;
        if (str2 != null && !str2.equals("")) {
            C11126t.putValue(jSONObject, "spv", c10827a.aFq);
        }
        return jSONObject;
    }
}
