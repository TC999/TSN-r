package com.kwad.sdk.core.p389b.p390a;

import com.kwad.components.p208ad.reward.p258k.C7985m;
import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.bn */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9956bn implements InterfaceC10273d<C7985m.C7986a> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(C7985m.C7986a c7986a, JSONObject jSONObject) {
        m27162a(c7986a, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(C7985m.C7986a c7986a, JSONObject jSONObject) {
        return m27161b(c7986a, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m27162a(C7985m.C7986a c7986a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c7986a.name = jSONObject.optString("name");
        if (JSONObject.NULL.toString().equals(c7986a.name)) {
            c7986a.name = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m27161b(C7985m.C7986a c7986a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = c7986a.name;
        if (str != null && !str.equals("")) {
            C11126t.putValue(jSONObject, "name", c7986a.name);
        }
        return jSONObject;
    }
}
