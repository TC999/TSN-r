package com.bytedance.sdk.openadsdk.core.fp.c;

import com.bytedance.sdk.openadsdk.core.xk;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class fp extends com.bytedance.sdk.component.c.ux<JSONObject, JSONObject> {

    /* renamed from: c  reason: collision with root package name */
    private String f33548c;

    /* renamed from: w  reason: collision with root package name */
    private xk f33549w;

    public fp(String str, xk xkVar) {
        this.f33549w = xkVar;
        this.f33548c = str;
    }

    public static void c(com.bytedance.sdk.component.c.s sVar, xk xkVar) {
        sVar.c("appInfo", (com.bytedance.sdk.component.c.ux<?, ?>) new fp("appInfo", xkVar));
        sVar.c("adInfo", (com.bytedance.sdk.component.c.ux<?, ?>) new fp("adInfo", xkVar));
        sVar.c("playable_style", (com.bytedance.sdk.component.c.ux<?, ?>) new fp("playable_style", xkVar));
        sVar.c("getTemplateInfo", (com.bytedance.sdk.component.c.ux<?, ?>) new fp("getTemplateInfo", xkVar));
        sVar.c("getTeMaiAds", (com.bytedance.sdk.component.c.ux<?, ?>) new fp("getTeMaiAds", xkVar));
        sVar.c("isViewable", (com.bytedance.sdk.component.c.ux<?, ?>) new fp("isViewable", xkVar));
        sVar.c("getScreenSize", (com.bytedance.sdk.component.c.ux<?, ?>) new fp("getScreenSize", xkVar));
        sVar.c("getCloseButtonInfo", (com.bytedance.sdk.component.c.ux<?, ?>) new fp("getCloseButtonInfo", xkVar));
        sVar.c("getVolume", (com.bytedance.sdk.component.c.ux<?, ?>) new fp("getVolume", xkVar));
        sVar.c("removeLoading", (com.bytedance.sdk.component.c.ux<?, ?>) new fp("removeLoading", xkVar));
        sVar.c("sendReward", (com.bytedance.sdk.component.c.ux<?, ?>) new fp("sendReward", xkVar));
        sVar.c("subscribe_app_ad", (com.bytedance.sdk.component.c.ux<?, ?>) new fp("subscribe_app_ad", xkVar));
        sVar.c("download_app_ad", (com.bytedance.sdk.component.c.ux<?, ?>) new fp("download_app_ad", xkVar));
        sVar.c("cancel_download_app_ad", (com.bytedance.sdk.component.c.ux<?, ?>) new fp("cancel_download_app_ad", xkVar));
        sVar.c("unsubscribe_app_ad", (com.bytedance.sdk.component.c.ux<?, ?>) new fp("unsubscribe_app_ad", xkVar));
        sVar.c("landscape_click", (com.bytedance.sdk.component.c.ux<?, ?>) new fp("landscape_click", xkVar));
        sVar.c("clickEvent", (com.bytedance.sdk.component.c.ux<?, ?>) new fp("clickEvent", xkVar));
        sVar.c("renderDidFinish", (com.bytedance.sdk.component.c.ux<?, ?>) new fp("renderDidFinish", xkVar));
        sVar.c("dynamicTrack", (com.bytedance.sdk.component.c.ux<?, ?>) new fp("dynamicTrack", xkVar));
        sVar.c("skipVideo", (com.bytedance.sdk.component.c.ux<?, ?>) new fp("skipVideo", xkVar));
        sVar.c("muteVideo", (com.bytedance.sdk.component.c.ux<?, ?>) new fp("muteVideo", xkVar));
        sVar.c("changeVideoState", (com.bytedance.sdk.component.c.ux<?, ?>) new fp("changeVideoState", xkVar));
        sVar.c("getCurrentVideoState", (com.bytedance.sdk.component.c.ux<?, ?>) new fp("getCurrentVideoState", xkVar));
        sVar.c("send_temai_product_ids", (com.bytedance.sdk.component.c.ux<?, ?>) new fp("send_temai_product_ids", xkVar));
        sVar.c("getMaterialMeta", (com.bytedance.sdk.component.c.ux<?, ?>) new fp("getMaterialMeta", xkVar));
        sVar.c("endcard_load", (com.bytedance.sdk.component.c.ux<?, ?>) new fp("endcard_load", xkVar));
        sVar.c("pauseWebView", (com.bytedance.sdk.component.c.ux<?, ?>) new fp("pauseWebView", xkVar));
        sVar.c("pauseWebViewTimers", (com.bytedance.sdk.component.c.ux<?, ?>) new fp("pauseWebViewTimers", xkVar));
        sVar.c("webview_time_track", (com.bytedance.sdk.component.c.ux<?, ?>) new fp("webview_time_track", xkVar));
        sVar.c("adInfoStash", (com.bytedance.sdk.component.c.ux<?, ?>) new fp("adInfoStash", xkVar));
    }

    @Override // com.bytedance.sdk.component.c.ux
    public JSONObject c(JSONObject jSONObject, com.bytedance.sdk.component.c.f fVar) throws Exception {
        xk.c cVar = new xk.c();
        cVar.f35598c = "call";
        cVar.xv = this.f33548c;
        cVar.sr = jSONObject;
        return this.f33549w.c(cVar, 3);
    }
}
