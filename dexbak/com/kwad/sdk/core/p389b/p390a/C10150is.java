package com.kwad.sdk.core.p389b.p390a;

import com.kwad.components.core.webview.tachikoma.p334b.C9257r;
import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.is */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10150is implements InterfaceC10273d<C9257r> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(C9257r c9257r, JSONObject jSONObject) {
        m26788a(c9257r, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(C9257r c9257r, JSONObject jSONObject) {
        return m26787b(c9257r, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26788a(C9257r c9257r, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c9257r.templateId = jSONObject.optString("templateId");
        if (JSONObject.NULL.toString().equals(c9257r.templateId)) {
            c9257r.templateId = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m26787b(C9257r c9257r, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = c9257r.templateId;
        if (str != null && !str.equals("")) {
            C11126t.putValue(jSONObject, "templateId", c9257r.templateId);
        }
        return jSONObject;
    }
}
