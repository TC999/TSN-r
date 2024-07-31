package com.kwad.sdk.core.p389b.p390a;

import com.kwad.components.core.webview.jshandler.C9123ba;
import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.kv */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10207kv implements InterfaceC10273d<C9123ba.C9124a> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(C9123ba.C9124a c9124a, JSONObject jSONObject) {
        m26674a(c9124a, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(C9123ba.C9124a c9124a, JSONObject jSONObject) {
        return m26673b(c9124a, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26674a(C9123ba.C9124a c9124a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c9124a.status = jSONObject.optInt("status");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m26673b(C9123ba.C9124a c9124a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = c9124a.status;
        if (i != 0) {
            C11126t.putValue(jSONObject, "status", i);
        }
        return jSONObject;
    }
}
