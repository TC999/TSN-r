package com.kwad.sdk.core.p389b.p390a;

import com.kwad.sdk.commercial.model.WebViewLoadMsg;
import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.utils.C11126t;
import com.umeng.analytics.pro.UMCommonContent;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.kz */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10211kz implements InterfaceC10273d<WebViewLoadMsg> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(WebViewLoadMsg webViewLoadMsg, JSONObject jSONObject) {
        m26666a(webViewLoadMsg, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(WebViewLoadMsg webViewLoadMsg, JSONObject jSONObject) {
        return m26665b(webViewLoadMsg, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26666a(WebViewLoadMsg webViewLoadMsg, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        webViewLoadMsg.url = jSONObject.optString("url");
        if (JSONObject.NULL.toString().equals(webViewLoadMsg.url)) {
            webViewLoadMsg.url = "";
        }
        webViewLoadMsg.state = jSONObject.optInt("state");
        webViewLoadMsg.interval = jSONObject.optString(UMCommonContent.f37794aX);
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
    private static JSONObject m26665b(WebViewLoadMsg webViewLoadMsg, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = webViewLoadMsg.url;
        if (str != null && !str.equals("")) {
            C11126t.putValue(jSONObject, "url", webViewLoadMsg.url);
        }
        int i = webViewLoadMsg.state;
        if (i != 0) {
            C11126t.putValue(jSONObject, "state", i);
        }
        String str2 = webViewLoadMsg.interval;
        if (str2 != null && !str2.equals("")) {
            C11126t.putValue(jSONObject, UMCommonContent.f37794aX, webViewLoadMsg.interval);
        }
        String str3 = webViewLoadMsg.failReason;
        if (str3 != null && !str3.equals("")) {
            C11126t.putValue(jSONObject, "fail_reason", webViewLoadMsg.failReason);
        }
        String str4 = webViewLoadMsg.costTime;
        if (str4 != null && !str4.equals("")) {
            C11126t.putValue(jSONObject, "cost_time", webViewLoadMsg.costTime);
        }
        return jSONObject;
    }
}
