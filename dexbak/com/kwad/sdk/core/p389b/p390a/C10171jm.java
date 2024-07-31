package com.kwad.sdk.core.p389b.p390a;

import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.p445n.C10882k;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.jm */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10171jm implements InterfaceC10273d<C10882k.C10885a.C10886a> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(C10882k.C10885a.C10886a c10886a, JSONObject jSONObject) {
        m26746a(c10886a, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(C10882k.C10885a.C10886a c10886a, JSONObject jSONObject) {
        return m26745b(c10886a, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26746a(C10882k.C10885a.C10886a c10886a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c10886a.aTs = jSONObject.optString("s_cn");
        if (JSONObject.NULL.toString().equals(c10886a.aTs)) {
            c10886a.aTs = "";
        }
        c10886a.aTt = jSONObject.optString("s_mn");
        if (JSONObject.NULL.toString().equals(c10886a.aTt)) {
            c10886a.aTt = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m26745b(C10882k.C10885a.C10886a c10886a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = c10886a.aTs;
        if (str != null && !str.equals("")) {
            C11126t.putValue(jSONObject, "s_cn", c10886a.aTs);
        }
        String str2 = c10886a.aTt;
        if (str2 != null && !str2.equals("")) {
            C11126t.putValue(jSONObject, "s_mn", c10886a.aTt);
        }
        return jSONObject;
    }
}
