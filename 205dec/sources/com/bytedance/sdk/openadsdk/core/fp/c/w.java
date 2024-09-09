package com.bytedance.sdk.openadsdk.core.fp.c;

import com.bytedance.sdk.component.widget.SSWebView;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w extends com.bytedance.sdk.component.c.ux<JSONObject, JSONObject> {

    /* renamed from: c  reason: collision with root package name */
    private SSWebView f33587c;

    /* renamed from: w  reason: collision with root package name */
    private String f33588w;

    public w(SSWebView sSWebView, String str) {
        this.f33587c = sSWebView;
        this.f33588w = str;
    }

    public JSONObject xv() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (com.bytedance.sdk.openadsdk.core.k.sr().c(com.bytedance.sdk.openadsdk.core.ls.getContext()) && this.f33587c != null) {
                jSONObject.put("code", 0);
                jSONObject.put("codeMsg", "success");
                this.f33587c.c_(1);
                return jSONObject;
            }
            jSONObject.put("code", -1);
            jSONObject.put("codeMsg", "unavailable");
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    public static void c(com.bytedance.sdk.component.c.s sVar, SSWebView sSWebView, String str) {
        sVar.c("start_wobble_observer", (com.bytedance.sdk.component.c.ux<?, ?>) new w(sSWebView, str));
    }

    @Override // com.bytedance.sdk.component.c.ux
    public JSONObject c(JSONObject jSONObject, com.bytedance.sdk.component.c.f fVar) throws Exception {
        com.bytedance.sdk.component.utils.a.w("AddWobbleMethod", "AddWobbleMethod invoke");
        return xv();
    }
}
