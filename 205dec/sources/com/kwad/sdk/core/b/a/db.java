package com.kwad.sdk.core.b.a;

import com.kwad.components.core.webview.a.a;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class db implements com.kwad.sdk.core.d<a.C0651a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(a.C0651a c0651a, JSONObject jSONObject) {
        a2(c0651a, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(a.C0651a c0651a, JSONObject jSONObject) {
        return b2(c0651a, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(a.C0651a c0651a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c0651a.url = jSONObject.optString("url");
        if (JSONObject.NULL.toString().equals(c0651a.url)) {
            c0651a.url = "";
        }
        c0651a.packageName = jSONObject.optString("packageName");
        if (JSONObject.NULL.toString().equals(c0651a.packageName)) {
            c0651a.packageName = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(a.C0651a c0651a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = c0651a.url;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "url", c0651a.url);
        }
        String str2 = c0651a.packageName;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "packageName", c0651a.packageName);
        }
        return jSONObject;
    }
}
