package com.kwad.sdk.core.b.a;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class cr implements com.kwad.sdk.core.d<com.kwad.sdk.crash.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.crash.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.crash.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.crash.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.aEY = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("appIdList");
        if (optJSONArray != null) {
            for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                aVar.aEY.add((String) optJSONArray.opt(i4));
            }
        }
        aVar.aEZ = new ArrayList();
        JSONArray optJSONArray2 = jSONObject.optJSONArray("sdkVersionList");
        if (optJSONArray2 != null) {
            for (int i5 = 0; i5 < optJSONArray2.length(); i5++) {
                aVar.aEZ.add((String) optJSONArray2.opt(i5));
            }
        }
        aVar.aFa = new ArrayList();
        JSONArray optJSONArray3 = jSONObject.optJSONArray("stacktraceList");
        if (optJSONArray3 != null) {
            for (int i6 = 0; i6 < optJSONArray3.length(); i6++) {
                aVar.aFa.add((String) optJSONArray3.opt(i6));
            }
        }
        aVar.aFb = jSONObject.optDouble("crashUploadRate", new Double("1.0").doubleValue());
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.crash.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "appIdList", aVar.aEY);
        com.kwad.sdk.utils.t.putValue(jSONObject, "sdkVersionList", aVar.aEZ);
        com.kwad.sdk.utils.t.putValue(jSONObject, "stacktraceList", aVar.aFa);
        com.kwad.sdk.utils.t.putValue(jSONObject, "crashUploadRate", aVar.aFb);
        return jSONObject;
    }
}
