package com.kwad.sdk.core.p389b.p390a;

import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.p364a.p365a.p366a.C9672a;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.fg */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10057fg implements InterfaceC10273d<C9672a> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(C9672a c9672a, JSONObject jSONObject) {
        m26974a(c9672a, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(C9672a c9672a, JSONObject jSONObject) {
        return m26973b(c9672a, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26974a(C9672a c9672a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c9672a.f29492gM = jSONObject.optLong("lastShowTimestamp");
        c9672a.aag = jSONObject.optInt("showCount");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m26973b(C9672a c9672a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j = c9672a.f29492gM;
        if (j != 0) {
            C11126t.putValue(jSONObject, "lastShowTimestamp", j);
        }
        int i = c9672a.aag;
        if (i != 0) {
            C11126t.putValue(jSONObject, "showCount", i);
        }
        return jSONObject;
    }
}
