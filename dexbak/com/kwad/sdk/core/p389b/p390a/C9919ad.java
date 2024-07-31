package com.kwad.sdk.core.p389b.p390a;

import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.core.adlog.p387b.C9907d;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.ad */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9919ad implements InterfaceC10273d<C9907d> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(C9907d c9907d, JSONObject jSONObject) {
        m27236a(c9907d, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(C9907d c9907d, JSONObject jSONObject) {
        return m27235b(c9907d, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m27236a(C9907d c9907d, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c9907d.status = jSONObject.optInt("status");
        c9907d.aoO = jSONObject.optString("final_url");
        if (JSONObject.NULL.toString().equals(c9907d.aoO)) {
            c9907d.aoO = "";
        }
        c9907d.aoM = jSONObject.optInt("ad_action_type");
        c9907d.apG = jSONObject.optInt("cache_type", new Integer("0").intValue());
        c9907d.retryCount = jSONObject.optInt("retry_count", new Integer("0").intValue());
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m27235b(C9907d c9907d, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = c9907d.status;
        if (i != 0) {
            C11126t.putValue(jSONObject, "status", i);
        }
        String str = c9907d.aoO;
        if (str != null && !str.equals("")) {
            C11126t.putValue(jSONObject, "final_url", c9907d.aoO);
        }
        int i2 = c9907d.aoM;
        if (i2 != 0) {
            C11126t.putValue(jSONObject, "ad_action_type", i2);
        }
        C11126t.putValue(jSONObject, "cache_type", c9907d.apG);
        C11126t.putValue(jSONObject, "retry_count", c9907d.retryCount);
        return jSONObject;
    }
}
