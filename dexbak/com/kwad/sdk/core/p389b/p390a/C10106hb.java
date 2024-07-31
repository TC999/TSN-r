package com.kwad.sdk.core.p389b.p390a;

import com.kwad.components.core.webview.p332a.C9011b;
import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.hb */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10106hb implements InterfaceC10273d<C9011b> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(C9011b c9011b, JSONObject jSONObject) {
        m26876a(c9011b, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(C9011b c9011b, JSONObject jSONObject) {
        return m26875b(c9011b, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26876a(C9011b c9011b, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c9011b.url = jSONObject.optString("url");
        if (JSONObject.NULL.toString().equals(c9011b.url)) {
            c9011b.url = "";
        }
        c9011b.title = jSONObject.optString("title");
        if (JSONObject.NULL.toString().equals(c9011b.title)) {
            c9011b.title = "";
        }
        c9011b.params = jSONObject.optString("params");
        if (JSONObject.NULL.toString().equals(c9011b.params)) {
            c9011b.params = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m26875b(C9011b c9011b, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = c9011b.url;
        if (str != null && !str.equals("")) {
            C11126t.putValue(jSONObject, "url", c9011b.url);
        }
        String str2 = c9011b.title;
        if (str2 != null && !str2.equals("")) {
            C11126t.putValue(jSONObject, "title", c9011b.title);
        }
        String str3 = c9011b.params;
        if (str3 != null && !str3.equals("")) {
            C11126t.putValue(jSONObject, "params", c9011b.params);
        }
        return jSONObject;
    }
}
