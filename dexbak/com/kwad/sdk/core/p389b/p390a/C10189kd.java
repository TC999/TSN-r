package com.kwad.sdk.core.p389b.p390a;

import com.kwad.components.p208ad.p233g.p234a.p235a.C7662b;
import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.utils.C11126t;
import io.netty.handler.codec.rtsp.RtspHeaders;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.kd */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10189kd implements InterfaceC10273d<C7662b.C7664a> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(C7662b.C7664a c7664a, JSONObject jSONObject) {
        m26710a(c7664a, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(C7662b.C7664a c7664a, JSONObject jSONObject) {
        return m26709b(c7664a, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26710a(C7662b.C7664a c7664a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c7664a.f25974nB = jSONObject.optInt("timerName");
        c7664a.f25975nC = jSONObject.optInt(RtspHeaders.Values.TIME);
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m26709b(C7662b.C7664a c7664a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = c7664a.f25974nB;
        if (i != 0) {
            C11126t.putValue(jSONObject, "timerName", i);
        }
        int i2 = c7664a.f25975nC;
        if (i2 != 0) {
            C11126t.putValue(jSONObject, RtspHeaders.Values.TIME, i2);
        }
        return jSONObject;
    }
}
