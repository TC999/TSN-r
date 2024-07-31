package com.kwad.sdk.core.p389b.p390a;

import com.kwad.components.core.webview.jshandler.C9031a;
import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.ai */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9924ai implements InterfaceC10273d<C9031a.C9033a> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(C9031a.C9033a c9033a, JSONObject jSONObject) {
        m27226a(c9033a, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(C9031a.C9033a c9033a, JSONObject jSONObject) {
        return m27225b(c9033a, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m27226a(C9031a.C9033a c9033a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c9033a.f29074Jj = jSONObject.optString("creativeId");
        if (JSONObject.NULL.toString().equals(c9033a.f29074Jj)) {
            c9033a.f29074Jj = "";
        }
        c9033a.f29075VR = jSONObject.optString("targetMethod");
        if (JSONObject.NULL.toString().equals(c9033a.f29075VR)) {
            c9033a.f29075VR = "";
        }
        c9033a.f29076VS = jSONObject.optString("methodParams");
        if (JSONObject.NULL.toString().equals(c9033a.f29076VS)) {
            c9033a.f29076VS = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m27225b(C9031a.C9033a c9033a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = c9033a.f29074Jj;
        if (str != null && !str.equals("")) {
            C11126t.putValue(jSONObject, "creativeId", c9033a.f29074Jj);
        }
        String str2 = c9033a.f29075VR;
        if (str2 != null && !str2.equals("")) {
            C11126t.putValue(jSONObject, "targetMethod", c9033a.f29075VR);
        }
        String str3 = c9033a.f29076VS;
        if (str3 != null && !str3.equals("")) {
            C11126t.putValue(jSONObject, "methodParams", c9033a.f29076VS);
        }
        return jSONObject;
    }
}
