package com.kwad.sdk.core.p389b.p390a;

import com.kwad.components.p208ad.interstitial.p241d.C7728a;
import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.fj */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10060fj implements InterfaceC10273d<C7728a> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(C7728a c7728a, JSONObject jSONObject) {
        m26968a(c7728a, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(C7728a c7728a, JSONObject jSONObject) {
        return m26967b(c7728a, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26968a(C7728a c7728a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c7728a.f26142jD = jSONObject.optLong("lastShowCardTimeStamp");
        c7728a.f26143jE = jSONObject.optInt("cardShowCount");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m26967b(C7728a c7728a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j = c7728a.f26142jD;
        if (j != 0) {
            C11126t.putValue(jSONObject, "lastShowCardTimeStamp", j);
        }
        int i = c7728a.f26143jE;
        if (i != 0) {
            C11126t.putValue(jSONObject, "cardShowCount", i);
        }
        return jSONObject;
    }
}
