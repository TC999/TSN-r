package com.kwad.sdk.core.p389b.p390a;

import com.kwad.components.core.webview.jshandler.C9151h;
import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.el */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10035el implements InterfaceC10273d<C9151h.C9152a> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(C9151h.C9152a c9152a, JSONObject jSONObject) {
        m27018a(c9152a, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(C9151h.C9152a c9152a, JSONObject jSONObject) {
        return m27017b(c9152a, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m27018a(C9151h.C9152a c9152a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c9152a.f29243Wa = jSONObject.optString("target");
        if (JSONObject.NULL.toString().equals(c9152a.f29243Wa)) {
            c9152a.f29243Wa = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m27017b(C9151h.C9152a c9152a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = c9152a.f29243Wa;
        if (str != null && !str.equals("")) {
            C11126t.putValue(jSONObject, "target", c9152a.f29243Wa);
        }
        return jSONObject;
    }
}
