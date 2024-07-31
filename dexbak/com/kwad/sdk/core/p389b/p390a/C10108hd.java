package com.kwad.sdk.core.p389b.p390a;

import com.kwad.components.core.webview.p332a.C9012c;
import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.hd */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10108hd implements InterfaceC10273d<C9012c> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(C9012c c9012c, JSONObject jSONObject) {
        m26872a(c9012c, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(C9012c c9012c, JSONObject jSONObject) {
        return m26871b(c9012c, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26872a(C9012c c9012c, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c9012c.f29032VL = jSONObject.optString("originalID");
        if (JSONObject.NULL.toString().equals(c9012c.f29032VL)) {
            c9012c.f29032VL = "";
        }
        c9012c.f29033VM = jSONObject.optString("path");
        if (JSONObject.NULL.toString().equals(c9012c.f29033VM)) {
            c9012c.f29033VM = "";
        }
        c9012c.f29034VN = jSONObject.optInt("adCacheId");
        c9012c.f29031Jj = jSONObject.optString("creativeId");
        if (JSONObject.NULL.toString().equals(c9012c.f29031Jj)) {
            c9012c.f29031Jj = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m26871b(C9012c c9012c, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = c9012c.f29032VL;
        if (str != null && !str.equals("")) {
            C11126t.putValue(jSONObject, "originalID", c9012c.f29032VL);
        }
        String str2 = c9012c.f29033VM;
        if (str2 != null && !str2.equals("")) {
            C11126t.putValue(jSONObject, "path", c9012c.f29033VM);
        }
        int i = c9012c.f29034VN;
        if (i != 0) {
            C11126t.putValue(jSONObject, "adCacheId", i);
        }
        String str3 = c9012c.f29031Jj;
        if (str3 != null && !str3.equals("")) {
            C11126t.putValue(jSONObject, "creativeId", c9012c.f29031Jj);
        }
        return jSONObject;
    }
}
