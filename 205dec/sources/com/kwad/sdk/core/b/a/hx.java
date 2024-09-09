package com.kwad.sdk.core.b.a;

import com.kwad.sdk.ranger.c;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class hx implements com.kwad.sdk.core.d<com.kwad.sdk.ranger.c> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.ranger.c cVar, JSONObject jSONObject) {
        a2(cVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.ranger.c cVar, JSONObject jSONObject) {
        return b2(cVar, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.ranger.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        cVar.funcSwitch = jSONObject.optLong("funcSwitch");
        cVar.aNk = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("urlList");
        if (optJSONArray != null) {
            for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                cVar.aNk.add((String) optJSONArray.opt(i4));
            }
        }
        cVar.aNl = new ArrayList();
        JSONArray optJSONArray2 = jSONObject.optJSONArray("actConfigList");
        if (optJSONArray2 != null) {
            for (int i5 = 0; i5 < optJSONArray2.length(); i5++) {
                c.a aVar = new c.a();
                aVar.parseJson(optJSONArray2.optJSONObject(i5));
                cVar.aNl.add(aVar);
            }
        }
        cVar.byteCount = jSONObject.optLong("byteCount");
        cVar.sampleRate = jSONObject.optDouble("sampleRate");
        cVar.aNm = new ArrayList();
        JSONArray optJSONArray3 = jSONObject.optJSONArray("anchorNodeList");
        if (optJSONArray3 != null) {
            for (int i6 = 0; i6 < optJSONArray3.length(); i6++) {
                com.kwad.sdk.ranger.a.a aVar2 = new com.kwad.sdk.ranger.a.a();
                aVar2.parseJson(optJSONArray3.optJSONObject(i6));
                cVar.aNm.add(aVar2);
            }
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.ranger.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j4 = cVar.funcSwitch;
        if (j4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "funcSwitch", j4);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "urlList", cVar.aNk);
        com.kwad.sdk.utils.t.putValue(jSONObject, "actConfigList", cVar.aNl);
        long j5 = cVar.byteCount;
        if (j5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "byteCount", j5);
        }
        double d4 = cVar.sampleRate;
        if (d4 != 0.0d) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "sampleRate", d4);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "anchorNodeList", cVar.aNm);
        return jSONObject;
    }
}
