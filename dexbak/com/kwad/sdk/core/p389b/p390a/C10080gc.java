package com.kwad.sdk.core.p389b.p390a;

import com.kwad.components.p208ad.fullscreen.p228b.C7609b;
import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.gc */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10080gc implements InterfaceC10273d<C7609b> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(C7609b c7609b, JSONObject jSONObject) {
        m26928a(c7609b, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(C7609b c7609b, JSONObject jSONObject) {
        return m26927b(c7609b, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26928a(C7609b c7609b, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c7609b.f25858gM = jSONObject.optLong("lastShowTimestamp");
        c7609b.f25859gN = jSONObject.optInt("currentDailyCount");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m26927b(C7609b c7609b, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j = c7609b.f25858gM;
        if (j != 0) {
            C11126t.putValue(jSONObject, "lastShowTimestamp", j);
        }
        int i = c7609b.f25859gN;
        if (i != 0) {
            C11126t.putValue(jSONObject, "currentDailyCount", i);
        }
        return jSONObject;
    }
}
