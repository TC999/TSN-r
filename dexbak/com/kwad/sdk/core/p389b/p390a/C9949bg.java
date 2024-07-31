package com.kwad.sdk.core.p389b.p390a;

import com.kwad.sdk.commercial.p373b.C9820b;
import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.bg */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9949bg implements InterfaceC10273d<C9820b> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(C9820b c9820b, JSONObject jSONObject) {
        m27176a(c9820b, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(C9820b c9820b, JSONObject jSONObject) {
        return m27175b(c9820b, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m27176a(C9820b c9820b, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c9820b.status = jSONObject.optInt("status");
        c9820b.url = jSONObject.optString("url");
        if (JSONObject.NULL.toString().equals(c9820b.url)) {
            c9820b.url = "";
        }
        c9820b.aog = jSONObject.optString("url_host");
        if (JSONObject.NULL.toString().equals(c9820b.aog)) {
            c9820b.aog = "";
        }
        c9820b.aon = jSONObject.optString("url_path");
        if (JSONObject.NULL.toString().equals(c9820b.aon)) {
            c9820b.aon = "";
        }
        c9820b.aoo = jSONObject.optString("market_pkg_name");
        if (JSONObject.NULL.toString().equals(c9820b.aoo)) {
            c9820b.aoo = "";
        }
        c9820b.aop = jSONObject.optInt("store_type");
        c9820b.aoq = jSONObject.optInt("launch_type");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m27175b(C9820b c9820b, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = c9820b.status;
        if (i != 0) {
            C11126t.putValue(jSONObject, "status", i);
        }
        String str = c9820b.url;
        if (str != null && !str.equals("")) {
            C11126t.putValue(jSONObject, "url", c9820b.url);
        }
        String str2 = c9820b.aog;
        if (str2 != null && !str2.equals("")) {
            C11126t.putValue(jSONObject, "url_host", c9820b.aog);
        }
        String str3 = c9820b.aon;
        if (str3 != null && !str3.equals("")) {
            C11126t.putValue(jSONObject, "url_path", c9820b.aon);
        }
        String str4 = c9820b.aoo;
        if (str4 != null && !str4.equals("")) {
            C11126t.putValue(jSONObject, "market_pkg_name", c9820b.aoo);
        }
        int i2 = c9820b.aop;
        if (i2 != 0) {
            C11126t.putValue(jSONObject, "store_type", i2);
        }
        int i3 = c9820b.aoq;
        if (i3 != 0) {
            C11126t.putValue(jSONObject, "launch_type", i3);
        }
        return jSONObject;
    }
}
