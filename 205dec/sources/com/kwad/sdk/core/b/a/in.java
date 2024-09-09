package com.kwad.sdk.core.b.a;

import com.kwad.sdk.j.b;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class in implements com.kwad.sdk.core.d<b.C0715b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(b.C0715b c0715b, JSONObject jSONObject) {
        a2(c0715b, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(b.C0715b c0715b, JSONObject jSONObject) {
        return b2(c0715b, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(b.C0715b c0715b, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c0715b.aJG = jSONObject.optInt("enable_monitor");
        c0715b.aJH = jSONObject.optString("c_sc_name");
        if (JSONObject.NULL.toString().equals(c0715b.aJH)) {
            c0715b.aJH = "";
        }
        c0715b.aJI = jSONObject.optString("c_pcl_name");
        if (JSONObject.NULL.toString().equals(c0715b.aJI)) {
            c0715b.aJI = "";
        }
        c0715b.aJJ = jSONObject.optString("m_gam_name");
        if (JSONObject.NULL.toString().equals(c0715b.aJJ)) {
            c0715b.aJJ = "";
        }
        c0715b.aJK = jSONObject.optString("m_gsv_name");
        if (JSONObject.NULL.toString().equals(c0715b.aJK)) {
            c0715b.aJK = "";
        }
        c0715b.aJL = jSONObject.optString("m_gpv_name");
        if (JSONObject.NULL.toString().equals(c0715b.aJL)) {
            c0715b.aJL = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(b.C0715b c0715b, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i4 = c0715b.aJG;
        if (i4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "enable_monitor", i4);
        }
        String str = c0715b.aJH;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "c_sc_name", c0715b.aJH);
        }
        String str2 = c0715b.aJI;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "c_pcl_name", c0715b.aJI);
        }
        String str3 = c0715b.aJJ;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "m_gam_name", c0715b.aJJ);
        }
        String str4 = c0715b.aJK;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "m_gsv_name", c0715b.aJK);
        }
        String str5 = c0715b.aJL;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "m_gpv_name", c0715b.aJL);
        }
        return jSONObject;
    }
}
