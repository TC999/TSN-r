package com.kwad.sdk.core.p389b.p390a;

import com.kwad.components.p208ad.reward.p258k.C7974f;
import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.cd */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9973cd implements InterfaceC10273d<C7974f.C7976a> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(C7974f.C7976a c7976a, JSONObject jSONObject) {
        m27128a(c7976a, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(C7974f.C7976a c7976a, JSONObject jSONObject) {
        return m27127b(c7976a, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m27128a(C7974f.C7976a c7976a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c7976a.f26688xi = jSONObject.optBoolean("forceClose");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m27127b(C7974f.C7976a c7976a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z = c7976a.f26688xi;
        if (z) {
            C11126t.putValue(jSONObject, "forceClose", z);
        }
        return jSONObject;
    }
}
