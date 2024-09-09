package com.kwad.sdk.core.b.a;

import com.kwad.sdk.ranger.a.a;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class hj implements com.kwad.sdk.core.d<a.C0719a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(a.C0719a c0719a, JSONObject jSONObject) {
        a2(c0719a, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(a.C0719a c0719a, JSONObject jSONObject) {
        return b2(c0719a, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(a.C0719a c0719a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c0719a.aND = jSONObject.optString("typeStr");
        if (JSONObject.NULL.toString().equals(c0719a.aND)) {
            c0719a.aND = "";
        }
        c0719a.aNE = jSONObject.optString("valueStr");
        if (JSONObject.NULL.toString().equals(c0719a.aNE)) {
            c0719a.aNE = "";
        }
        c0719a.aNF = jSONObject.optString("listValueType");
        if (JSONObject.NULL.toString().equals(c0719a.aNF)) {
            c0719a.aNF = "";
        }
        c0719a.aNG = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("valueStrList");
        if (optJSONArray != null) {
            for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                c0719a.aNG.add((String) optJSONArray.opt(i4));
            }
        }
        c0719a.fieldName = jSONObject.optString("fieldName");
        if (JSONObject.NULL.toString().equals(c0719a.fieldName)) {
            c0719a.fieldName = "";
        }
        c0719a.className = jSONObject.optString("className");
        if (JSONObject.NULL.toString().equals(c0719a.className)) {
            c0719a.className = "";
        }
        c0719a.aNH = new ArrayList();
        JSONArray optJSONArray2 = jSONObject.optJSONArray("childParamList");
        if (optJSONArray2 != null) {
            for (int i5 = 0; i5 < optJSONArray2.length(); i5++) {
                a.C0719a c0719a2 = new a.C0719a();
                c0719a2.parseJson(optJSONArray2.optJSONObject(i5));
                c0719a.aNH.add(c0719a2);
            }
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(a.C0719a c0719a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = c0719a.aND;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "typeStr", c0719a.aND);
        }
        String str2 = c0719a.aNE;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "valueStr", c0719a.aNE);
        }
        String str3 = c0719a.aNF;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "listValueType", c0719a.aNF);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "valueStrList", c0719a.aNG);
        String str4 = c0719a.fieldName;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "fieldName", c0719a.fieldName);
        }
        String str5 = c0719a.className;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "className", c0719a.className);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "childParamList", c0719a.aNH);
        return jSONObject;
    }
}
