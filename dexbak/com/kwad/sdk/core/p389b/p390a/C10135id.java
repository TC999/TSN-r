package com.kwad.sdk.core.p389b.p390a;

import com.kwad.components.p208ad.reward.p251d.C7875b;
import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.id */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10135id implements InterfaceC10273d<C7875b> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(C7875b c7875b, JSONObject jSONObject) {
        m26818a(c7875b, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(C7875b c7875b, JSONObject jSONObject) {
        return m26817b(c7875b, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26818a(C7875b c7875b, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c7875b.f26496gM = jSONObject.optLong("lastShowTimestamp");
        c7875b.f26497rt = jSONObject.optInt("showInteractCount");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m26817b(C7875b c7875b, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j = c7875b.f26496gM;
        if (j != 0) {
            C11126t.putValue(jSONObject, "lastShowTimestamp", j);
        }
        int i = c7875b.f26497rt;
        if (i != 0) {
            C11126t.putValue(jSONObject, "showInteractCount", i);
        }
        return jSONObject;
    }
}
