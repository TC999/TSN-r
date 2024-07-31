package com.kwad.sdk.core.p389b.p390a;

import com.kwad.components.p208ad.reward.p258k.C7994s;
import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.ir */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10149ir implements InterfaceC10273d<C7994s.C7995a> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(C7994s.C7995a c7995a, JSONObject jSONObject) {
        m26790a(c7995a, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(C7994s.C7995a c7995a, JSONObject jSONObject) {
        return m26789b(c7995a, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26790a(C7994s.C7995a c7995a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c7995a.f26701xr = jSONObject.optBoolean("needCloseNeo");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m26789b(C7994s.C7995a c7995a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z = c7995a.f26701xr;
        if (z) {
            C11126t.putValue(jSONObject, "needCloseNeo", z);
        }
        return jSONObject;
    }
}
