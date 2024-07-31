package com.kwad.sdk.core.p389b.p390a;

import com.kwad.sdk.commercial.p381j.C9847b;
import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.au */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9936au implements InterfaceC10273d<C9847b> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(C9847b c9847b, JSONObject jSONObject) {
        m27202a(c9847b, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(C9847b c9847b, JSONObject jSONObject) {
        return m27201b(c9847b, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m27202a(C9847b c9847b, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c9847b.status = jSONObject.optInt("status");
        c9847b.aoM = jSONObject.optInt("ad_action_type");
        c9847b.aoN = jSONObject.optString("origin_url");
        if (JSONObject.NULL.toString().equals(c9847b.aoN)) {
            c9847b.aoN = "";
        }
        c9847b.aoO = jSONObject.optString("final_url");
        if (JSONObject.NULL.toString().equals(c9847b.aoO)) {
            c9847b.aoO = "";
        }
        c9847b.aoP = jSONObject.optInt("request_type");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m27201b(C9847b c9847b, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = c9847b.status;
        if (i != 0) {
            C11126t.putValue(jSONObject, "status", i);
        }
        int i2 = c9847b.aoM;
        if (i2 != 0) {
            C11126t.putValue(jSONObject, "ad_action_type", i2);
        }
        String str = c9847b.aoN;
        if (str != null && !str.equals("")) {
            C11126t.putValue(jSONObject, "origin_url", c9847b.aoN);
        }
        String str2 = c9847b.aoO;
        if (str2 != null && !str2.equals("")) {
            C11126t.putValue(jSONObject, "final_url", c9847b.aoO);
        }
        int i3 = c9847b.aoP;
        if (i3 != 0) {
            C11126t.putValue(jSONObject, "request_type", i3);
        }
        return jSONObject;
    }
}
