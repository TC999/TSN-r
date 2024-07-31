package com.kwad.sdk.core.p389b.p390a;

import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.p439j.C10824b;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.in */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10145in implements InterfaceC10273d<C10824b.C10828b> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(C10824b.C10828b c10828b, JSONObject jSONObject) {
        m26798a(c10828b, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(C10824b.C10828b c10828b, JSONObject jSONObject) {
        return m26797b(c10828b, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26798a(C10824b.C10828b c10828b, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c10828b.aJG = jSONObject.optInt("enable_monitor");
        c10828b.aJH = jSONObject.optString("c_sc_name");
        if (JSONObject.NULL.toString().equals(c10828b.aJH)) {
            c10828b.aJH = "";
        }
        c10828b.aJI = jSONObject.optString("c_pcl_name");
        if (JSONObject.NULL.toString().equals(c10828b.aJI)) {
            c10828b.aJI = "";
        }
        c10828b.aJJ = jSONObject.optString("m_gam_name");
        if (JSONObject.NULL.toString().equals(c10828b.aJJ)) {
            c10828b.aJJ = "";
        }
        c10828b.aJK = jSONObject.optString("m_gsv_name");
        if (JSONObject.NULL.toString().equals(c10828b.aJK)) {
            c10828b.aJK = "";
        }
        c10828b.aJL = jSONObject.optString("m_gpv_name");
        if (JSONObject.NULL.toString().equals(c10828b.aJL)) {
            c10828b.aJL = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m26797b(C10824b.C10828b c10828b, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = c10828b.aJG;
        if (i != 0) {
            C11126t.putValue(jSONObject, "enable_monitor", i);
        }
        String str = c10828b.aJH;
        if (str != null && !str.equals("")) {
            C11126t.putValue(jSONObject, "c_sc_name", c10828b.aJH);
        }
        String str2 = c10828b.aJI;
        if (str2 != null && !str2.equals("")) {
            C11126t.putValue(jSONObject, "c_pcl_name", c10828b.aJI);
        }
        String str3 = c10828b.aJJ;
        if (str3 != null && !str3.equals("")) {
            C11126t.putValue(jSONObject, "m_gam_name", c10828b.aJJ);
        }
        String str4 = c10828b.aJK;
        if (str4 != null && !str4.equals("")) {
            C11126t.putValue(jSONObject, "m_gsv_name", c10828b.aJK);
        }
        String str5 = c10828b.aJL;
        if (str5 != null && !str5.equals("")) {
            C11126t.putValue(jSONObject, "m_gpv_name", c10828b.aJL);
        }
        return jSONObject;
    }
}
