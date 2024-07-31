package com.kwad.sdk.core.p389b.p390a;

import com.kwad.sdk.commercial.p375d.C9827b;
import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.m */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10215m implements InterfaceC10273d<C9827b> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(C9827b c9827b, JSONObject jSONObject) {
        m26658a(c9827b, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(C9827b c9827b, JSONObject jSONObject) {
        return m26657b(c9827b, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26658a(C9827b c9827b, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c9827b.aow = jSONObject.optString("method_name");
        if (JSONObject.NULL.toString().equals(c9827b.aow)) {
            c9827b.aow = "";
        }
        c9827b.aox = jSONObject.optBoolean("is_convert");
        c9827b.adNum = jSONObject.optInt("ad_num");
        c9827b.aoy = jSONObject.optBoolean("is_api_native");
        c9827b.aoz = jSONObject.optString("ad_request_type");
        if (JSONObject.NULL.toString().equals(c9827b.aoz)) {
            c9827b.aoz = "";
        }
        c9827b.adSource = jSONObject.optString("ad_require_source");
        if (JSONObject.NULL.toString().equals(c9827b.adSource)) {
            c9827b.adSource = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m26657b(C9827b c9827b, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = c9827b.aow;
        if (str != null && !str.equals("")) {
            C11126t.putValue(jSONObject, "method_name", c9827b.aow);
        }
        boolean z = c9827b.aox;
        if (z) {
            C11126t.putValue(jSONObject, "is_convert", z);
        }
        int i = c9827b.adNum;
        if (i != 0) {
            C11126t.putValue(jSONObject, "ad_num", i);
        }
        boolean z2 = c9827b.aoy;
        if (z2) {
            C11126t.putValue(jSONObject, "is_api_native", z2);
        }
        String str2 = c9827b.aoz;
        if (str2 != null && !str2.equals("")) {
            C11126t.putValue(jSONObject, "ad_request_type", c9827b.aoz);
        }
        String str3 = c9827b.adSource;
        if (str3 != null && !str3.equals("")) {
            C11126t.putValue(jSONObject, "ad_require_source", c9827b.adSource);
        }
        return jSONObject;
    }
}
