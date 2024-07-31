package com.kwad.sdk.core.p389b.p390a;

import com.kwad.components.p208ad.interstitial.p240c.C7724b;
import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.fl */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10062fl implements InterfaceC10273d<C7724b> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(C7724b c7724b, JSONObject jSONObject) {
        m26964a(c7724b, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(C7724b c7724b, JSONObject jSONObject) {
        return m26963b(c7724b, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26964a(C7724b c7724b, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c7724b.f26130gM = jSONObject.optLong("lastShowTimestamp");
        c7724b.f26131jB = jSONObject.optInt("currentDailyAdShowCount");
        c7724b.f26132jC = jSONObject.optInt("currentDailyRetainShowCount");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m26963b(C7724b c7724b, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j = c7724b.f26130gM;
        if (j != 0) {
            C11126t.putValue(jSONObject, "lastShowTimestamp", j);
        }
        int i = c7724b.f26131jB;
        if (i != 0) {
            C11126t.putValue(jSONObject, "currentDailyAdShowCount", i);
        }
        int i2 = c7724b.f26132jC;
        if (i2 != 0) {
            C11126t.putValue(jSONObject, "currentDailyRetainShowCount", i2);
        }
        return jSONObject;
    }
}
