package com.kwad.sdk.core.p389b.p390a;

import com.kwad.components.core.webview.jshandler.C9127bc;
import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.et */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10043et implements InterfaceC10273d<C9127bc.C9129a> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(C9127bc.C9129a c9129a, JSONObject jSONObject) {
        m27002a(c9129a, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(C9127bc.C9129a c9129a, JSONObject jSONObject) {
        return m27001b(c9129a, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m27002a(C9127bc.C9129a c9129a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c9129a.visibility = jSONObject.optInt("visibility");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m27001b(C9127bc.C9129a c9129a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = c9129a.visibility;
        if (i != 0) {
            C11126t.putValue(jSONObject, "visibility", i);
        }
        return jSONObject;
    }
}
