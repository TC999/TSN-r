package com.kwad.sdk.core.b.a;

import com.kwad.components.core.webview.jshandler.a;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class ai implements com.kwad.sdk.core.d<a.C0652a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(a.C0652a c0652a, JSONObject jSONObject) {
        a2(c0652a, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(a.C0652a c0652a, JSONObject jSONObject) {
        return b2(c0652a, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(a.C0652a c0652a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c0652a.Jj = jSONObject.optString("creativeId");
        if (JSONObject.NULL.toString().equals(c0652a.Jj)) {
            c0652a.Jj = "";
        }
        c0652a.VR = jSONObject.optString("targetMethod");
        if (JSONObject.NULL.toString().equals(c0652a.VR)) {
            c0652a.VR = "";
        }
        c0652a.VS = jSONObject.optString("methodParams");
        if (JSONObject.NULL.toString().equals(c0652a.VS)) {
            c0652a.VS = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(a.C0652a c0652a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = c0652a.Jj;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "creativeId", c0652a.Jj);
        }
        String str2 = c0652a.VR;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "targetMethod", c0652a.VR);
        }
        String str3 = c0652a.VS;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "methodParams", c0652a.VS);
        }
        return jSONObject;
    }
}
