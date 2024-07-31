package com.kwad.sdk.core.p389b.p390a;

import com.kwad.sdk.commercial.p380i.C9843b;
import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.iw */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10154iw implements InterfaceC10273d<C9843b> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(C9843b c9843b, JSONObject jSONObject) {
        m26780a(c9843b, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(C9843b c9843b, JSONObject jSONObject) {
        return m26779b(c9843b, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26780a(C9843b c9843b, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c9843b.status = jSONObject.optInt("status");
        c9843b.url = jSONObject.optString("url");
        if (JSONObject.NULL.toString().equals(c9843b.url)) {
            c9843b.url = "";
        }
        c9843b.aog = jSONObject.optString("url_host");
        if (JSONObject.NULL.toString().equals(c9843b.aog)) {
            c9843b.aog = "";
        }
        c9843b.aon = jSONObject.optString("url_path");
        if (JSONObject.NULL.toString().equals(c9843b.aon)) {
            c9843b.aon = "";
        }
        c9843b.aoI = jSONObject.optString("small_origin_id");
        if (JSONObject.NULL.toString().equals(c9843b.aoI)) {
            c9843b.aoI = "";
        }
        c9843b.aoJ = jSONObject.optString("small_app_id");
        if (JSONObject.NULL.toString().equals(c9843b.aoJ)) {
            c9843b.aoJ = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m26779b(C9843b c9843b, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = c9843b.status;
        if (i != 0) {
            C11126t.putValue(jSONObject, "status", i);
        }
        String str = c9843b.url;
        if (str != null && !str.equals("")) {
            C11126t.putValue(jSONObject, "url", c9843b.url);
        }
        String str2 = c9843b.aog;
        if (str2 != null && !str2.equals("")) {
            C11126t.putValue(jSONObject, "url_host", c9843b.aog);
        }
        String str3 = c9843b.aon;
        if (str3 != null && !str3.equals("")) {
            C11126t.putValue(jSONObject, "url_path", c9843b.aon);
        }
        String str4 = c9843b.aoI;
        if (str4 != null && !str4.equals("")) {
            C11126t.putValue(jSONObject, "small_origin_id", c9843b.aoI);
        }
        String str5 = c9843b.aoJ;
        if (str5 != null && !str5.equals("")) {
            C11126t.putValue(jSONObject, "small_app_id", c9843b.aoJ);
        }
        return jSONObject;
    }
}
