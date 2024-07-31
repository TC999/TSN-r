package com.kwad.sdk.core.p389b.p390a;

import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.ranger.p446a.C10946a;
import com.kwad.sdk.utils.C11126t;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.jv */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10180jv implements InterfaceC10273d<C10946a.C10948b> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(C10946a.C10948b c10948b, JSONObject jSONObject) {
        m26728a(c10948b, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(C10946a.C10948b c10948b, JSONObject jSONObject) {
        return m26727b(c10948b, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26728a(C10946a.C10948b c10948b, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c10948b.name = jSONObject.optString("name");
        if (JSONObject.NULL.toString().equals(c10948b.name)) {
            c10948b.name = "";
        }
        c10948b.aNK = jSONObject.optBoolean("isStatic");
        c10948b.aNL = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("paramList");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                C10946a.C10947a c10947a = new C10946a.C10947a();
                c10947a.parseJson(optJSONArray.optJSONObject(i));
                c10948b.aNL.add(c10947a);
            }
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m26727b(C10946a.C10948b c10948b, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = c10948b.name;
        if (str != null && !str.equals("")) {
            C11126t.putValue(jSONObject, "name", c10948b.name);
        }
        boolean z = c10948b.aNK;
        if (z) {
            C11126t.putValue(jSONObject, "isStatic", z);
        }
        C11126t.putValue(jSONObject, "paramList", c10948b.aNL);
        return jSONObject;
    }
}
