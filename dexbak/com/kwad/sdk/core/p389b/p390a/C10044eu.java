package com.kwad.sdk.core.p389b.p390a;

import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.core.webview.p418b.p419a.C10613a;
import com.kwad.sdk.utils.C11126t;
import io.netty.handler.codec.http.HttpHeaders;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.eu */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10044eu implements InterfaceC10273d<C10613a> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(C10613a c10613a, JSONObject jSONObject) {
        m27000a(c10613a, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(C10613a c10613a, JSONObject jSONObject) {
        return m26999b(c10613a, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m27000a(C10613a c10613a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c10613a.aEq = jSONObject.optString(HttpHeaders.Names.ACCESS_CONTROL_ALLOW_ORIGIN);
        if (JSONObject.NULL.toString().equals(c10613a.aEq)) {
            c10613a.aEq = "";
        }
        c10613a.aEr = jSONObject.optString("Timing-Allow-Origin");
        if (JSONObject.NULL.toString().equals(c10613a.aEr)) {
            c10613a.aEr = "";
        }
        c10613a.aEs = jSONObject.optString("content-type");
        if (JSONObject.NULL.toString().equals(c10613a.aEs)) {
            c10613a.aEs = "";
        }
        c10613a.aEt = jSONObject.optString("Date");
        if (JSONObject.NULL.toString().equals(c10613a.aEt)) {
            c10613a.aEt = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m26999b(C10613a c10613a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = c10613a.aEq;
        if (str != null && !str.equals("")) {
            C11126t.putValue(jSONObject, HttpHeaders.Names.ACCESS_CONTROL_ALLOW_ORIGIN, c10613a.aEq);
        }
        String str2 = c10613a.aEr;
        if (str2 != null && !str2.equals("")) {
            C11126t.putValue(jSONObject, "Timing-Allow-Origin", c10613a.aEr);
        }
        String str3 = c10613a.aEs;
        if (str3 != null && !str3.equals("")) {
            C11126t.putValue(jSONObject, "content-type", c10613a.aEs);
        }
        String str4 = c10613a.aEt;
        if (str4 != null && !str4.equals("")) {
            C11126t.putValue(jSONObject, "Date", c10613a.aEt);
        }
        return jSONObject;
    }
}
