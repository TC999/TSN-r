package com.bytedance.sdk.openadsdk.core.fp.c;

import com.bytedance.sdk.component.widget.SSWebView;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class i extends com.bytedance.sdk.component.c.ux<JSONObject, JSONObject> {

    /* renamed from: c  reason: collision with root package name */
    private SSWebView f33554c;

    /* renamed from: w  reason: collision with root package name */
    private String f33555w;

    public i(SSWebView sSWebView, String str) {
        this.f33554c = sSWebView;
        this.f33555w = str;
    }

    public JSONObject xv() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (com.bytedance.sdk.openadsdk.core.k.sr().c(com.bytedance.sdk.openadsdk.core.ls.getContext()) && this.f33554c != null) {
                jSONObject.put("code", 0);
                jSONObject.put("codeMsg", "success");
                this.f33554c.a();
                return jSONObject;
            }
            jSONObject.put("code", -1);
            jSONObject.put("codeMsg", "unavailable");
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    public static void c(com.bytedance.sdk.component.c.s sVar, SSWebView sSWebView, String str) {
        sVar.c("close_wobble_observer", (com.bytedance.sdk.component.c.ux<?, ?>) new i(sSWebView, str));
    }

    @Override // com.bytedance.sdk.component.c.ux
    public JSONObject c(JSONObject jSONObject, com.bytedance.sdk.component.c.f fVar) throws Exception {
        com.bytedance.sdk.component.utils.a.w("RemoveWobbleMethod", "RemoveWobbleMethod invoke");
        return xv();
    }
}
