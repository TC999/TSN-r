package com.kwad.sdk.core.p389b.p390a;

import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.utils.C11126t;
import com.kwad.sdk.utils.p451b.C11038a;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.fx */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10074fx implements InterfaceC10273d<C11038a> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(C11038a c11038a, JSONObject jSONObject) {
        m26940a(c11038a, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(C11038a c11038a, JSONObject jSONObject) {
        return m26939b(c11038a, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26940a(C11038a c11038a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c11038a.aSj = jSONObject.optInt("put_count");
        c11038a.aSk = jSONObject.optInt("get_failed_count");
        c11038a.aSl = jSONObject.optInt("get_success_count");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m26939b(C11038a c11038a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = c11038a.aSj;
        if (i != 0) {
            C11126t.putValue(jSONObject, "put_count", i);
        }
        int i2 = c11038a.aSk;
        if (i2 != 0) {
            C11126t.putValue(jSONObject, "get_failed_count", i2);
        }
        int i3 = c11038a.aSl;
        if (i3 != 0) {
            C11126t.putValue(jSONObject, "get_success_count", i3);
        }
        return jSONObject;
    }
}
