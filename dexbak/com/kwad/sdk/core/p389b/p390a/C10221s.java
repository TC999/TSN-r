package com.kwad.sdk.core.p389b.p390a;

import com.kwad.components.core.p300k.C8686a;
import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.s */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10221s implements InterfaceC10273d<C8686a> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(C8686a c8686a, JSONObject jSONObject) {
        m26646a(c8686a, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(C8686a c8686a, JSONObject jSONObject) {
        return m26645b(c8686a, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26646a(C8686a c8686a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c8686a.f28356Mq = jSONObject.optInt("currentActiveCount");
        c8686a.f28357Mr = jSONObject.optLong("lastForceActiveTimestamp");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m26645b(C8686a c8686a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = c8686a.f28356Mq;
        if (i != 0) {
            C11126t.putValue(jSONObject, "currentActiveCount", i);
        }
        long j = c8686a.f28357Mr;
        if (j != 0) {
            C11126t.putValue(jSONObject, "lastForceActiveTimestamp", j);
        }
        return jSONObject;
    }
}
