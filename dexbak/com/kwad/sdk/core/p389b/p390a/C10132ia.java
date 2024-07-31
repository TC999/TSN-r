package com.kwad.sdk.core.p389b.p390a;

import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.core.webview.p423d.C10637b;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.ia */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10132ia implements InterfaceC10273d<C10637b.C10639a> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(C10637b.C10639a c10639a, JSONObject jSONObject) {
        m26824a(c10639a, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(C10637b.C10639a c10639a, JSONObject jSONObject) {
        return m26823b(c10639a, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26824a(C10637b.C10639a c10639a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c10639a.url = jSONObject.optString("url");
        if (JSONObject.NULL.toString().equals(c10639a.url)) {
            c10639a.url = "";
        }
        c10639a.method = jSONObject.optString("method");
        if (JSONObject.NULL.toString().equals(c10639a.method)) {
            c10639a.method = "";
        }
        c10639a.params = jSONObject.optString("params");
        if (JSONObject.NULL.toString().equals(c10639a.params)) {
            c10639a.params = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m26823b(C10637b.C10639a c10639a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = c10639a.url;
        if (str != null && !str.equals("")) {
            C11126t.putValue(jSONObject, "url", c10639a.url);
        }
        String str2 = c10639a.method;
        if (str2 != null && !str2.equals("")) {
            C11126t.putValue(jSONObject, "method", c10639a.method);
        }
        String str3 = c10639a.params;
        if (str3 != null && !str3.equals("")) {
            C11126t.putValue(jSONObject, "params", c10639a.params);
        }
        return jSONObject;
    }
}
