package com.kwad.sdk.core.b.a;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class hy implements com.kwad.sdk.core.d<com.kwad.sdk.ranger.b.a.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.ranger.b.a.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.ranger.b.a.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.ranger.b.a.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.aAL = jSONObject.optInt("func_ratio_count");
        bVar.aNN = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("func_values");
        if (optJSONArray != null) {
            for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                com.kwad.sdk.ranger.b.a.a aVar = new com.kwad.sdk.ranger.b.a.a();
                aVar.parseJson(optJSONArray.optJSONObject(i4));
                bVar.aNN.add(aVar);
            }
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.ranger.b.a.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i4 = bVar.aAL;
        if (i4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "func_ratio_count", i4);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "func_values", bVar.aNN);
        return jSONObject;
    }
}
