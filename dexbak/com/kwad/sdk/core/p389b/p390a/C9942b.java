package com.kwad.sdk.core.p389b.p390a;

import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.ranger.C10957c;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9942b implements InterfaceC10273d<C10957c.C10958a> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(C10957c.C10958a c10958a, JSONObject jSONObject) {
        m27190a(c10958a, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(C10957c.C10958a c10958a, JSONObject jSONObject) {
        return m27189b(c10958a, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m27190a(C10957c.C10958a c10958a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c10958a.aNn = jSONObject.optString("originalActStr");
        if (JSONObject.NULL.toString().equals(c10958a.aNn)) {
            c10958a.aNn = "";
        }
        c10958a.aNo = jSONObject.optString("targetField");
        if (JSONObject.NULL.toString().equals(c10958a.aNo)) {
            c10958a.aNo = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m27189b(C10957c.C10958a c10958a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = c10958a.aNn;
        if (str != null && !str.equals("")) {
            C11126t.putValue(jSONObject, "originalActStr", c10958a.aNn);
        }
        String str2 = c10958a.aNo;
        if (str2 != null && !str2.equals("")) {
            C11126t.putValue(jSONObject, "targetField", c10958a.aNo);
        }
        return jSONObject;
    }
}
