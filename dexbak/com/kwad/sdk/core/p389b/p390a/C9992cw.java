package com.kwad.sdk.core.p389b.p390a;

import com.kwad.sdk.commercial.p377f.C9834b;
import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.cw */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9992cw implements InterfaceC10273d<C9834b> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(C9834b c9834b, JSONObject jSONObject) {
        m27098a(c9834b, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(C9834b c9834b, JSONObject jSONObject) {
        return m27097b(c9834b, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m27098a(C9834b c9834b, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c9834b.status = jSONObject.optInt("status");
        c9834b.url = jSONObject.optString("url");
        if (JSONObject.NULL.toString().equals(c9834b.url)) {
            c9834b.url = "";
        }
        c9834b.aog = jSONObject.optString("url_host");
        if (JSONObject.NULL.toString().equals(c9834b.aog)) {
            c9834b.aog = "";
        }
        c9834b.aon = jSONObject.optString("url_path");
        if (JSONObject.NULL.toString().equals(c9834b.aon)) {
            c9834b.aon = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m27097b(C9834b c9834b, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = c9834b.status;
        if (i != 0) {
            C11126t.putValue(jSONObject, "status", i);
        }
        String str = c9834b.url;
        if (str != null && !str.equals("")) {
            C11126t.putValue(jSONObject, "url", c9834b.url);
        }
        String str2 = c9834b.aog;
        if (str2 != null && !str2.equals("")) {
            C11126t.putValue(jSONObject, "url_host", c9834b.aog);
        }
        String str3 = c9834b.aon;
        if (str3 != null && !str3.equals("")) {
            C11126t.putValue(jSONObject, "url_path", c9834b.aon);
        }
        return jSONObject;
    }
}
