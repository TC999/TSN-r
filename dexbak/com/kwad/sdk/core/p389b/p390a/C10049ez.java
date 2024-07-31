package com.kwad.sdk.core.p389b.p390a;

import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.core.config.item.C10260h;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.ez */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10049ez implements InterfaceC10273d<C10260h.C10261a> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(C10260h.C10261a c10261a, JSONObject jSONObject) {
        m26990a(c10261a, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(C10260h.C10261a c10261a, JSONObject jSONObject) {
        return m26989b(c10261a, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26990a(C10260h.C10261a c10261a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c10261a.atm = jSONObject.optString("imei");
        if (JSONObject.NULL.toString().equals(c10261a.atm)) {
            c10261a.atm = "";
        }
        c10261a.atn = jSONObject.optString("oaid");
        if (JSONObject.NULL.toString().equals(c10261a.atn)) {
            c10261a.atn = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m26989b(C10260h.C10261a c10261a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = c10261a.atm;
        if (str != null && !str.equals("")) {
            C11126t.putValue(jSONObject, "imei", c10261a.atm);
        }
        String str2 = c10261a.atn;
        if (str2 != null && !str2.equals("")) {
            C11126t.putValue(jSONObject, "oaid", c10261a.atn);
        }
        return jSONObject;
    }
}
