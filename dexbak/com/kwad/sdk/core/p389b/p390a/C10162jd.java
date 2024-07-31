package com.kwad.sdk.core.p389b.p390a;

import com.kwad.components.p208ad.splashscreen.local.C8493a;
import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.jd */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10162jd implements InterfaceC10273d<C8493a> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(C8493a c8493a, JSONObject jSONObject) {
        m26764a(c8493a, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(C8493a c8493a, JSONObject jSONObject) {
        return m26763b(c8493a, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26764a(C8493a c8493a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c8493a.f27894gM = jSONObject.optLong("lastShowTimestamp");
        c8493a.f27895gN = jSONObject.optInt("currentDailyCount");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m26763b(C8493a c8493a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j = c8493a.f27894gM;
        if (j != 0) {
            C11126t.putValue(jSONObject, "lastShowTimestamp", j);
        }
        int i = c8493a.f27895gN;
        if (i != 0) {
            C11126t.putValue(jSONObject, "currentDailyCount", i);
        }
        return jSONObject;
    }
}
