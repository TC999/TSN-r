package com.kwad.sdk.core.p389b.p390a;

import com.kwad.components.p208ad.reward.p250c.C7867e;
import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.dp */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10012dp implements InterfaceC10273d<C7867e.C7868a> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(C7867e.C7868a c7868a, JSONObject jSONObject) {
        m27058a(c7868a, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(C7867e.C7868a c7868a, JSONObject jSONObject) {
        return m27057b(c7868a, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m27058a(C7867e.C7868a c7868a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c7868a.f26487rq = jSONObject.optString("dialogEvent");
        if (JSONObject.NULL.toString().equals(c7868a.f26487rq)) {
            c7868a.f26487rq = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m27057b(C7867e.C7868a c7868a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = c7868a.f26487rq;
        if (str != null && !str.equals("")) {
            C11126t.putValue(jSONObject, "dialogEvent", c7868a.f26487rq);
        }
        return jSONObject;
    }
}
