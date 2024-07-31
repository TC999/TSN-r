package com.kwad.sdk.core.p389b.p390a;

import com.kwad.components.core.webview.jshandler.C9107av;
import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.kw */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10208kw implements InterfaceC10273d<C9107av.C9108a> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(C9107av.C9108a c9108a, JSONObject jSONObject) {
        m26672a(c9108a, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(C9107av.C9108a c9108a, JSONObject jSONObject) {
        return m26671b(c9108a, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26672a(C9107av.C9108a c9108a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c9108a.f29201XR = jSONObject.optString("windowFocusEvent");
        if (JSONObject.NULL.toString().equals(c9108a.f29201XR)) {
            c9108a.f29201XR = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m26671b(C9107av.C9108a c9108a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = c9108a.f29201XR;
        if (str != null && !str.equals("")) {
            C11126t.putValue(jSONObject, "windowFocusEvent", c9108a.f29201XR);
        }
        return jSONObject;
    }
}
