package com.kwad.sdk.core.p389b.p390a;

import com.kwad.sdk.commercial.p378g.C9836b;
import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.es */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10042es implements InterfaceC10273d<C9836b> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(C9836b c9836b, JSONObject jSONObject) {
        m27004a(c9836b, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(C9836b c9836b, JSONObject jSONObject) {
        return m27003b(c9836b, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m27004a(C9836b c9836b, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c9836b.status = jSONObject.optInt("status");
        c9836b.f29517Om = jSONObject.optInt("landing_page_type");
        c9836b.url = jSONObject.optString("url");
        if (JSONObject.NULL.toString().equals(c9836b.url)) {
            c9836b.url = "";
        }
        c9836b.aog = jSONObject.optString("url_host");
        if (JSONObject.NULL.toString().equals(c9836b.aog)) {
            c9836b.aog = "";
        }
        c9836b.aon = jSONObject.optString("url_path");
        if (JSONObject.NULL.toString().equals(c9836b.aon)) {
            c9836b.aon = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m27003b(C9836b c9836b, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = c9836b.status;
        if (i != 0) {
            C11126t.putValue(jSONObject, "status", i);
        }
        int i2 = c9836b.f29517Om;
        if (i2 != 0) {
            C11126t.putValue(jSONObject, "landing_page_type", i2);
        }
        String str = c9836b.url;
        if (str != null && !str.equals("")) {
            C11126t.putValue(jSONObject, "url", c9836b.url);
        }
        String str2 = c9836b.aog;
        if (str2 != null && !str2.equals("")) {
            C11126t.putValue(jSONObject, "url_host", c9836b.aog);
        }
        String str3 = c9836b.aon;
        if (str3 != null && !str3.equals("")) {
            C11126t.putValue(jSONObject, "url_path", c9836b.aon);
        }
        return jSONObject;
    }
}
