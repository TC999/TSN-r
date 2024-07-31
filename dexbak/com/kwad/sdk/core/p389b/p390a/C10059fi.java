package com.kwad.sdk.core.p389b.p390a;

import com.kwad.components.p208ad.interstitial.p240c.C7723a;
import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.fi */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10059fi implements InterfaceC10273d<C7723a> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(C7723a c7723a, JSONObject jSONObject) {
        m26970a(c7723a, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(C7723a c7723a, JSONObject jSONObject) {
        return m26969b(c7723a, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26970a(C7723a c7723a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c7723a.f26127gM = jSONObject.optLong("lastShowTimestamp");
        c7723a.f26128jA = jSONObject.optInt("aggregateAdShowCount");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m26969b(C7723a c7723a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j = c7723a.f26127gM;
        if (j != 0) {
            C11126t.putValue(jSONObject, "lastShowTimestamp", j);
        }
        int i = c7723a.f26128jA;
        if (i != 0) {
            C11126t.putValue(jSONObject, "aggregateAdShowCount", i);
        }
        return jSONObject;
    }
}
