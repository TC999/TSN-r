package com.kwad.sdk.core.p389b.p390a;

import com.kwad.components.core.webview.jshandler.C9085an;
import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.fp */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10066fp implements InterfaceC10273d<C9085an.C9087a> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(C9085an.C9087a c9087a, JSONObject jSONObject) {
        m26956a(c9087a, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(C9085an.C9087a c9087a, JSONObject jSONObject) {
        return m26955b(c9087a, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26956a(C9085an.C9087a c9087a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c9087a.f29178XB = jSONObject.optString("adTemplate");
        if (JSONObject.NULL.toString().equals(c9087a.f29178XB)) {
            c9087a.f29178XB = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m26955b(C9085an.C9087a c9087a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = c9087a.f29178XB;
        if (str != null && !str.equals("")) {
            C11126t.putValue(jSONObject, "adTemplate", c9087a.f29178XB);
        }
        return jSONObject;
    }
}
