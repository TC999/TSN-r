package com.kwad.sdk.core.p389b.p390a;

import com.kwad.components.core.webview.jshandler.C9149g;
import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.ek */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10034ek implements InterfaceC10273d<C9149g.C9150a> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(C9149g.C9150a c9150a, JSONObject jSONObject) {
        m27020a(c9150a, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(C9149g.C9150a c9150a, JSONObject jSONObject) {
        return m27019b(c9150a, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m27020a(C9149g.C9150a c9150a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c9150a.data = jSONObject.optString("data");
        if (JSONObject.NULL.toString().equals(c9150a.data)) {
            c9150a.data = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m27019b(C9149g.C9150a c9150a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = c9150a.data;
        if (str != null && !str.equals("")) {
            C11126t.putValue(jSONObject, "data", c9150a.data);
        }
        return jSONObject;
    }
}
