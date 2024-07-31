package com.kwad.sdk.core.p389b.p390a;

import com.kwad.components.p208ad.reward.p250c.C7864b;
import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.fw */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10073fw implements InterfaceC10273d<C7864b> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(C7864b c7864b, JSONObject jSONObject) {
        m26942a(c7864b, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(C7864b c7864b, JSONObject jSONObject) {
        return m26941b(c7864b, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26942a(C7864b c7864b, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c7864b.f26484ro = jSONObject.optInt("extraRewardType", new Integer("2").intValue());
        c7864b.f26485rp = jSONObject.optInt("extraRewardStatus");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m26941b(C7864b c7864b, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        C11126t.putValue(jSONObject, "extraRewardType", c7864b.f26484ro);
        int i = c7864b.f26485rp;
        if (i != 0) {
            C11126t.putValue(jSONObject, "extraRewardStatus", i);
        }
        return jSONObject;
    }
}
