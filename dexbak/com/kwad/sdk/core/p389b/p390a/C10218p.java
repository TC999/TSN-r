package com.kwad.sdk.core.p389b.p390a;

import com.kwad.sdk.commercial.p376e.C9832c;
import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.p */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10218p implements InterfaceC10273d<C9832c> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(C9832c c9832c, JSONObject jSONObject) {
        m26652a(c9832c, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(C9832c c9832c, JSONObject jSONObject) {
        return m26651b(c9832c, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26652a(C9832c c9832c, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c9832c.aoC = jSONObject.optString("imp_ad_info");
        if (JSONObject.NULL.toString().equals(c9832c.aoC)) {
            c9832c.aoC = "";
        }
        c9832c.aoD = jSONObject.optString("final_imp_ad_info");
        if (JSONObject.NULL.toString().equals(c9832c.aoD)) {
            c9832c.aoD = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m26651b(C9832c c9832c, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = c9832c.aoC;
        if (str != null && !str.equals("")) {
            C11126t.putValue(jSONObject, "imp_ad_info", c9832c.aoC);
        }
        String str2 = c9832c.aoD;
        if (str2 != null && !str2.equals("")) {
            C11126t.putValue(jSONObject, "final_imp_ad_info", c9832c.aoD);
        }
        return jSONObject;
    }
}
