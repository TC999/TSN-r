package com.kwad.sdk.core.p389b.p390a;

import com.github.mikephil.charting.utils.Utils;
import com.kwad.sdk.commercial.model.WebViewCommercialMsg;
import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.ky */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10210ky implements InterfaceC10273d<WebViewCommercialMsg> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(WebViewCommercialMsg webViewCommercialMsg, JSONObject jSONObject) {
        m26668a(webViewCommercialMsg, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(WebViewCommercialMsg webViewCommercialMsg, JSONObject jSONObject) {
        return m26667b(webViewCommercialMsg, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26668a(WebViewCommercialMsg webViewCommercialMsg, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        webViewCommercialMsg.category = jSONObject.optString("category");
        if (JSONObject.NULL.toString().equals(webViewCommercialMsg.category)) {
            webViewCommercialMsg.category = "";
        }
        webViewCommercialMsg.tag = jSONObject.optString("tag");
        if (JSONObject.NULL.toString().equals(webViewCommercialMsg.tag)) {
            webViewCommercialMsg.tag = "";
        }
        webViewCommercialMsg.primaryKey = jSONObject.optString("primaryKey");
        if (JSONObject.NULL.toString().equals(webViewCommercialMsg.primaryKey)) {
            webViewCommercialMsg.primaryKey = "";
        }
        webViewCommercialMsg.msg = jSONObject.optJSONObject("msg");
        webViewCommercialMsg.extraParam = jSONObject.optJSONObject("extraParam");
        webViewCommercialMsg.eventId = jSONObject.optString("event_id");
        if (JSONObject.NULL.toString().equals(webViewCommercialMsg.eventId)) {
            webViewCommercialMsg.eventId = "";
        }
        webViewCommercialMsg.rate = jSONObject.optDouble("rate");
        webViewCommercialMsg.suffixRatio = jSONObject.optString("suffixRatio");
        if (JSONObject.NULL.toString().equals(webViewCommercialMsg.suffixRatio)) {
            webViewCommercialMsg.suffixRatio = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m26667b(WebViewCommercialMsg webViewCommercialMsg, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = webViewCommercialMsg.category;
        if (str != null && !str.equals("")) {
            C11126t.putValue(jSONObject, "category", webViewCommercialMsg.category);
        }
        String str2 = webViewCommercialMsg.tag;
        if (str2 != null && !str2.equals("")) {
            C11126t.putValue(jSONObject, "tag", webViewCommercialMsg.tag);
        }
        String str3 = webViewCommercialMsg.primaryKey;
        if (str3 != null && !str3.equals("")) {
            C11126t.putValue(jSONObject, "primaryKey", webViewCommercialMsg.primaryKey);
        }
        C11126t.putValue(jSONObject, "msg", webViewCommercialMsg.msg);
        C11126t.putValue(jSONObject, "extraParam", webViewCommercialMsg.extraParam);
        String str4 = webViewCommercialMsg.eventId;
        if (str4 != null && !str4.equals("")) {
            C11126t.putValue(jSONObject, "event_id", webViewCommercialMsg.eventId);
        }
        double d = webViewCommercialMsg.rate;
        if (d != Utils.DOUBLE_EPSILON) {
            C11126t.putValue(jSONObject, "rate", d);
        }
        String str5 = webViewCommercialMsg.suffixRatio;
        if (str5 != null && !str5.equals("")) {
            C11126t.putValue(jSONObject, "suffixRatio", webViewCommercialMsg.suffixRatio);
        }
        return jSONObject;
    }
}
