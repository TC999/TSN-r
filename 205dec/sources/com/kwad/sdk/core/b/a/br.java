package com.kwad.sdk.core.b.a;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class br implements com.kwad.sdk.core.d<com.kwad.sdk.crash.online.monitor.a.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.crash.online.monitor.a.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.crash.online.monitor.a.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.crash.online.monitor.a.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.aGO = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("systemFilterList");
        if (optJSONArray != null) {
            for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                aVar.aGO.add((String) optJSONArray.opt(i4));
            }
        }
        aVar.aGP = new ArrayList();
        JSONArray optJSONArray2 = jSONObject.optJSONArray("sdkFilterList");
        if (optJSONArray2 != null) {
            for (int i5 = 0; i5 < optJSONArray2.length(); i5++) {
                aVar.aGP.add((String) optJSONArray2.opt(i5));
            }
        }
        aVar.aGQ = new ArrayList();
        JSONArray optJSONArray3 = jSONObject.optJSONArray("matrixPrinterNameList");
        if (optJSONArray3 != null) {
            for (int i6 = 0; i6 < optJSONArray3.length(); i6++) {
                aVar.aGQ.add((String) optJSONArray3.opt(i6));
            }
        }
        aVar.aGR = new ArrayList();
        JSONArray optJSONArray4 = jSONObject.optJSONArray("commonPrinterNameList");
        if (optJSONArray4 != null) {
            for (int i7 = 0; i7 < optJSONArray4.length(); i7++) {
                aVar.aGR.add((String) optJSONArray4.opt(i7));
            }
        }
        aVar.aGS = new ArrayList();
        JSONArray optJSONArray5 = jSONObject.optJSONArray("featureConfigList");
        if (optJSONArray5 != null) {
            for (int i8 = 0; i8 < optJSONArray5.length(); i8++) {
                com.kwad.sdk.crash.online.monitor.a.b bVar = new com.kwad.sdk.crash.online.monitor.a.b();
                bVar.parseJson(optJSONArray5.optJSONObject(i8));
                aVar.aGS.add(bVar);
            }
        }
        aVar.aGU = jSONObject.optInt("afterFilterSystemCheckNum", new Integer("5").intValue());
        aVar.aGV = jSONObject.optInt("batchNum", new Integer("10").intValue());
        aVar.aor = jSONObject.optDouble("ratio", new Double("0.01").doubleValue());
        aVar.aGW = jSONObject.optInt("monitorSwitch");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.crash.online.monitor.a.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "systemFilterList", aVar.aGO);
        com.kwad.sdk.utils.t.putValue(jSONObject, "sdkFilterList", aVar.aGP);
        com.kwad.sdk.utils.t.putValue(jSONObject, "matrixPrinterNameList", aVar.aGQ);
        com.kwad.sdk.utils.t.putValue(jSONObject, "commonPrinterNameList", aVar.aGR);
        com.kwad.sdk.utils.t.putValue(jSONObject, "featureConfigList", aVar.aGS);
        com.kwad.sdk.utils.t.putValue(jSONObject, "afterFilterSystemCheckNum", aVar.aGU);
        com.kwad.sdk.utils.t.putValue(jSONObject, "batchNum", aVar.aGV);
        com.kwad.sdk.utils.t.putValue(jSONObject, "ratio", aVar.aor);
        int i4 = aVar.aGW;
        if (i4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "monitorSwitch", i4);
        }
        return jSONObject;
    }
}
