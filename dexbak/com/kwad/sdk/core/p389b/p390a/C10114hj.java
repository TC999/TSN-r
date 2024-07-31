package com.kwad.sdk.core.p389b.p390a;

import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.ranger.p446a.C10946a;
import com.kwad.sdk.utils.C11126t;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.hj */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10114hj implements InterfaceC10273d<C10946a.C10947a> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(C10946a.C10947a c10947a, JSONObject jSONObject) {
        m26860a(c10947a, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(C10946a.C10947a c10947a, JSONObject jSONObject) {
        return m26859b(c10947a, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26860a(C10946a.C10947a c10947a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c10947a.aND = jSONObject.optString("typeStr");
        if (JSONObject.NULL.toString().equals(c10947a.aND)) {
            c10947a.aND = "";
        }
        c10947a.aNE = jSONObject.optString("valueStr");
        if (JSONObject.NULL.toString().equals(c10947a.aNE)) {
            c10947a.aNE = "";
        }
        c10947a.aNF = jSONObject.optString("listValueType");
        if (JSONObject.NULL.toString().equals(c10947a.aNF)) {
            c10947a.aNF = "";
        }
        c10947a.aNG = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("valueStrList");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                c10947a.aNG.add((String) optJSONArray.opt(i));
            }
        }
        c10947a.fieldName = jSONObject.optString("fieldName");
        if (JSONObject.NULL.toString().equals(c10947a.fieldName)) {
            c10947a.fieldName = "";
        }
        c10947a.className = jSONObject.optString("className");
        if (JSONObject.NULL.toString().equals(c10947a.className)) {
            c10947a.className = "";
        }
        c10947a.aNH = new ArrayList();
        JSONArray optJSONArray2 = jSONObject.optJSONArray("childParamList");
        if (optJSONArray2 != null) {
            for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                C10946a.C10947a c10947a2 = new C10946a.C10947a();
                c10947a2.parseJson(optJSONArray2.optJSONObject(i2));
                c10947a.aNH.add(c10947a2);
            }
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m26859b(C10946a.C10947a c10947a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = c10947a.aND;
        if (str != null && !str.equals("")) {
            C11126t.putValue(jSONObject, "typeStr", c10947a.aND);
        }
        String str2 = c10947a.aNE;
        if (str2 != null && !str2.equals("")) {
            C11126t.putValue(jSONObject, "valueStr", c10947a.aNE);
        }
        String str3 = c10947a.aNF;
        if (str3 != null && !str3.equals("")) {
            C11126t.putValue(jSONObject, "listValueType", c10947a.aNF);
        }
        C11126t.putValue(jSONObject, "valueStrList", c10947a.aNG);
        String str4 = c10947a.fieldName;
        if (str4 != null && !str4.equals("")) {
            C11126t.putValue(jSONObject, "fieldName", c10947a.fieldName);
        }
        String str5 = c10947a.className;
        if (str5 != null && !str5.equals("")) {
            C11126t.putValue(jSONObject, "className", c10947a.className);
        }
        C11126t.putValue(jSONObject, "childParamList", c10947a.aNH);
        return jSONObject;
    }
}
