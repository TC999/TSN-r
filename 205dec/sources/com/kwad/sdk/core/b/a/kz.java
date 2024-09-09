package com.kwad.sdk.core.b.a;

import com.kwad.sdk.commercial.model.WebViewLoadMsg;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class kz implements com.kwad.sdk.core.d<WebViewLoadMsg> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(WebViewLoadMsg webViewLoadMsg, JSONObject jSONObject) {
        a2(webViewLoadMsg, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(WebViewLoadMsg webViewLoadMsg, JSONObject jSONObject) {
        return b2(webViewLoadMsg, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(WebViewLoadMsg webViewLoadMsg, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        webViewLoadMsg.url = jSONObject.optString("url");
        if (JSONObject.NULL.toString().equals(webViewLoadMsg.url)) {
            webViewLoadMsg.url = "";
        }
        webViewLoadMsg.state = jSONObject.optInt("state");
        webViewLoadMsg.interval = jSONObject.optString("interval");
        if (JSONObject.NULL.toString().equals(webViewLoadMsg.interval)) {
            webViewLoadMsg.interval = "";
        }
        webViewLoadMsg.failReason = jSONObject.optString("fail_reason");
        if (JSONObject.NULL.toString().equals(webViewLoadMsg.failReason)) {
            webViewLoadMsg.failReason = "";
        }
        webViewLoadMsg.costTime = jSONObject.optString("cost_time");
        if (JSONObject.NULL.toString().equals(webViewLoadMsg.costTime)) {
            webViewLoadMsg.costTime = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(WebViewLoadMsg webViewLoadMsg, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = webViewLoadMsg.url;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "url", webViewLoadMsg.url);
        }
        int i4 = webViewLoadMsg.state;
        if (i4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "state", i4);
        }
        String str2 = webViewLoadMsg.interval;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "interval", webViewLoadMsg.interval);
        }
        String str3 = webViewLoadMsg.failReason;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "fail_reason", webViewLoadMsg.failReason);
        }
        String str4 = webViewLoadMsg.costTime;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "cost_time", webViewLoadMsg.costTime);
        }
        return jSONObject;
    }
}
