package com.kwad.sdk.core.p389b.p390a;

import com.kwad.components.core.webview.tachikoma.p334b.C9249j;
import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.fr */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10068fr implements InterfaceC10273d<C9249j> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(C9249j c9249j, JSONObject jSONObject) {
        m26952a(c9249j, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(C9249j c9249j, JSONObject jSONObject) {
        return m26951b(c9249j, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26952a(C9249j c9249j, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c9249j.data = jSONObject.optString("data");
        if (JSONObject.NULL.toString().equals(c9249j.data)) {
            c9249j.data = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m26951b(C9249j c9249j, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = c9249j.data;
        if (str != null && !str.equals("")) {
            C11126t.putValue(jSONObject, "data", c9249j.data);
        }
        return jSONObject;
    }
}
