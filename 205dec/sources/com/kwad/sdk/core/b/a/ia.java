package com.kwad.sdk.core.b.a;

import com.bytedance.pangle.sdk.component.log.impl.core.monitor.EventMonitor;
import com.kwad.sdk.core.webview.d.b;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class ia implements com.kwad.sdk.core.d<b.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(b.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(b.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(b.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.url = jSONObject.optString("url");
        if (JSONObject.NULL.toString().equals(aVar.url)) {
            aVar.url = "";
        }
        aVar.method = jSONObject.optString("method");
        if (JSONObject.NULL.toString().equals(aVar.method)) {
            aVar.method = "";
        }
        aVar.params = jSONObject.optString(EventMonitor.V3_PARAMS);
        if (JSONObject.NULL.toString().equals(aVar.params)) {
            aVar.params = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(b.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = aVar.url;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "url", aVar.url);
        }
        String str2 = aVar.method;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "method", aVar.method);
        }
        String str3 = aVar.params;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, EventMonitor.V3_PARAMS, aVar.params);
        }
        return jSONObject;
    }
}
