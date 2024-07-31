package com.kwad.sdk.core.p389b.p390a;

import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.crash.online.monitor.p428a.C10696a;
import com.kwad.sdk.crash.online.monitor.p428a.C10697b;
import com.kwad.sdk.utils.C11126t;
import com.tencent.connect.common.Constants;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.br */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9960br implements InterfaceC10273d<C10696a> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(C10696a c10696a, JSONObject jSONObject) {
        m27154a(c10696a, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(C10696a c10696a, JSONObject jSONObject) {
        return m27153b(c10696a, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m27154a(C10696a c10696a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c10696a.aGO = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("systemFilterList");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                c10696a.aGO.add((String) optJSONArray.opt(i));
            }
        }
        c10696a.aGP = new ArrayList();
        JSONArray optJSONArray2 = jSONObject.optJSONArray("sdkFilterList");
        if (optJSONArray2 != null) {
            for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                c10696a.aGP.add((String) optJSONArray2.opt(i2));
            }
        }
        c10696a.aGQ = new ArrayList();
        JSONArray optJSONArray3 = jSONObject.optJSONArray("matrixPrinterNameList");
        if (optJSONArray3 != null) {
            for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                c10696a.aGQ.add((String) optJSONArray3.opt(i3));
            }
        }
        c10696a.aGR = new ArrayList();
        JSONArray optJSONArray4 = jSONObject.optJSONArray("commonPrinterNameList");
        if (optJSONArray4 != null) {
            for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                c10696a.aGR.add((String) optJSONArray4.opt(i4));
            }
        }
        c10696a.aGS = new ArrayList();
        JSONArray optJSONArray5 = jSONObject.optJSONArray("featureConfigList");
        if (optJSONArray5 != null) {
            for (int i5 = 0; i5 < optJSONArray5.length(); i5++) {
                C10697b c10697b = new C10697b();
                c10697b.parseJson(optJSONArray5.optJSONObject(i5));
                c10696a.aGS.add(c10697b);
            }
        }
        c10696a.aGU = jSONObject.optInt("afterFilterSystemCheckNum", new Integer("5").intValue());
        c10696a.aGV = jSONObject.optInt("batchNum", new Integer(Constants.VIA_REPORT_TYPE_SHARE_TO_QQ).intValue());
        c10696a.aor = jSONObject.optDouble("ratio", new Double("0.01").doubleValue());
        c10696a.aGW = jSONObject.optInt("monitorSwitch");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m27153b(C10696a c10696a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        C11126t.putValue(jSONObject, "systemFilterList", c10696a.aGO);
        C11126t.putValue(jSONObject, "sdkFilterList", c10696a.aGP);
        C11126t.putValue(jSONObject, "matrixPrinterNameList", c10696a.aGQ);
        C11126t.putValue(jSONObject, "commonPrinterNameList", c10696a.aGR);
        C11126t.putValue(jSONObject, "featureConfigList", c10696a.aGS);
        C11126t.putValue(jSONObject, "afterFilterSystemCheckNum", c10696a.aGU);
        C11126t.putValue(jSONObject, "batchNum", c10696a.aGV);
        C11126t.putValue(jSONObject, "ratio", c10696a.aor);
        int i = c10696a.aGW;
        if (i != 0) {
            C11126t.putValue(jSONObject, "monitorSwitch", i);
        }
        return jSONObject;
    }
}
