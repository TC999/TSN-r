package com.kwad.sdk.core.p389b.p390a;

import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.core.config.item.C10263j;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.fc */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10053fc implements InterfaceC10273d<C10263j.C10264a> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(C10263j.C10264a c10264a, JSONObject jSONObject) {
        m26982a(c10264a, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(C10263j.C10264a c10264a, JSONObject jSONObject) {
        return m26981b(c10264a, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26982a(C10263j.C10264a c10264a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c10264a.ato = jSONObject.optInt("horizontalShowDuration", new Integer("180000").intValue());
        c10264a.atp = jSONObject.optInt("verticalShowDuration", new Integer("90000").intValue());
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m26981b(C10263j.C10264a c10264a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        C11126t.putValue(jSONObject, "horizontalShowDuration", c10264a.ato);
        C11126t.putValue(jSONObject, "verticalShowDuration", c10264a.atp);
        return jSONObject;
    }
}
