package com.kwad.sdk.core.p389b.p390a;

import com.kwad.components.p208ad.reward.p255h.C7946b;
import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.ic */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10134ic implements InterfaceC10273d<C7946b> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(C7946b c7946b, JSONObject jSONObject) {
        m26820a(c7946b, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(C7946b c7946b, JSONObject jSONObject) {
        return m26819b(c7946b, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26820a(C7946b c7946b, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c7946b.f26657gM = jSONObject.optLong("lastShowTimestamp");
        c7946b.f26658rO = jSONObject.optInt("jumpDirectCount");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m26819b(C7946b c7946b, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j = c7946b.f26657gM;
        if (j != 0) {
            C11126t.putValue(jSONObject, "lastShowTimestamp", j);
        }
        int i = c7946b.f26658rO;
        if (i != 0) {
            C11126t.putValue(jSONObject, "jumpDirectCount", i);
        }
        return jSONObject;
    }
}
