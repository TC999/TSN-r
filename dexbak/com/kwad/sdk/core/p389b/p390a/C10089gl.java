package com.kwad.sdk.core.p389b.p390a;

import com.kwad.components.core.webview.jshandler.C9166o;
import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.gl */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10089gl implements InterfaceC10273d<C9166o.C9168a> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(C9166o.C9168a c9168a, JSONObject jSONObject) {
        m26910a(c9168a, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(C9166o.C9168a c9168a, JSONObject jSONObject) {
        return m26909b(c9168a, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26910a(C9166o.C9168a c9168a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c9168a.message = jSONObject.optString("message");
        if (JSONObject.NULL.toString().equals(c9168a.message)) {
            c9168a.message = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m26909b(C9166o.C9168a c9168a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = c9168a.message;
        if (str != null && !str.equals("")) {
            C11126t.putValue(jSONObject, "message", c9168a.message);
        }
        return jSONObject;
    }
}
