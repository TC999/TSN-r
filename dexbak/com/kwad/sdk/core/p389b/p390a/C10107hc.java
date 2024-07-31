package com.kwad.sdk.core.p389b.p390a;

import com.kwad.components.core.webview.tachikoma.p334b.C9253n;
import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.hc */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10107hc implements InterfaceC10273d<C9253n> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(C9253n c9253n, JSONObject jSONObject) {
        m26874a(c9253n, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(C9253n c9253n, JSONObject jSONObject) {
        return m26873b(c9253n, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26874a(C9253n c9253n, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c9253n.url = jSONObject.optString("url");
        if (JSONObject.NULL.toString().equals(c9253n.url)) {
            c9253n.url = "";
        }
        c9253n.title = jSONObject.optString("title");
        if (JSONObject.NULL.toString().equals(c9253n.title)) {
            c9253n.title = "";
        }
        c9253n.aap = jSONObject.optBoolean("showConfirmDialog");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m26873b(C9253n c9253n, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = c9253n.url;
        if (str != null && !str.equals("")) {
            C11126t.putValue(jSONObject, "url", c9253n.url);
        }
        String str2 = c9253n.title;
        if (str2 != null && !str2.equals("")) {
            C11126t.putValue(jSONObject, "title", c9253n.title);
        }
        boolean z = c9253n.aap;
        if (z) {
            C11126t.putValue(jSONObject, "showConfirmDialog", z);
        }
        return jSONObject;
    }
}
