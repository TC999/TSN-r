package com.kwad.sdk.core.p389b.p390a;

import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.p445n.C10882k;
import com.kwad.sdk.utils.C11126t;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.lb */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10214lb implements InterfaceC10273d<C10882k.C10885a> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(C10882k.C10885a c10885a, JSONObject jSONObject) {
        m26660a(c10885a, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(C10882k.C10885a c10885a, JSONObject jSONObject) {
        return m26659b(c10885a, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26660a(C10882k.C10885a c10885a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c10885a.aTq = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("c_cns");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                c10885a.aTq.add((String) optJSONArray.opt(i));
            }
        }
        c10885a.aTr = new ArrayList();
        JSONArray optJSONArray2 = jSONObject.optJSONArray("s_cns");
        if (optJSONArray2 != null) {
            for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                C10882k.C10885a.C10886a c10886a = new C10882k.C10885a.C10886a();
                c10886a.parseJson(optJSONArray2.optJSONObject(i2));
                c10885a.aTr.add(c10886a);
            }
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m26659b(C10882k.C10885a c10885a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        C11126t.putValue(jSONObject, "c_cns", c10885a.aTq);
        C11126t.putValue(jSONObject, "s_cns", c10885a.aTr);
        return jSONObject;
    }
}
