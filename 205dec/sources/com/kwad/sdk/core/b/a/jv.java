package com.kwad.sdk.core.b.a;

import com.kwad.sdk.ranger.a.a;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class jv implements com.kwad.sdk.core.d<a.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(a.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(a.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(a.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.name = jSONObject.optString("name");
        if (JSONObject.NULL.toString().equals(bVar.name)) {
            bVar.name = "";
        }
        bVar.aNK = jSONObject.optBoolean("isStatic");
        bVar.aNL = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("paramList");
        if (optJSONArray != null) {
            for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                a.C0719a c0719a = new a.C0719a();
                c0719a.parseJson(optJSONArray.optJSONObject(i4));
                bVar.aNL.add(c0719a);
            }
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(a.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = bVar.name;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "name", bVar.name);
        }
        boolean z3 = bVar.aNK;
        if (z3) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "isStatic", z3);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "paramList", bVar.aNL);
        return jSONObject;
    }
}
