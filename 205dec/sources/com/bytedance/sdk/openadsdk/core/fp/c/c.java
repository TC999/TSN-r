package com.bytedance.sdk.openadsdk.core.fp.c;

import com.bytedance.sdk.component.widget.SSWebView;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c extends com.bytedance.sdk.component.c.ux<JSONObject, JSONObject> {

    /* renamed from: c  reason: collision with root package name */
    private SSWebView f33537c;

    /* renamed from: w  reason: collision with root package name */
    private String f33538w;

    public c(SSWebView sSWebView, String str) {
        this.f33537c = sSWebView;
        this.f33538w = str;
    }

    public JSONObject xv() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (com.bytedance.sdk.openadsdk.core.k.sr().w(com.bytedance.sdk.openadsdk.core.ls.getContext()) && this.f33537c != null) {
                jSONObject.put("code", 0);
                jSONObject.put("codeMsg", "success");
                this.f33537c.c_(2);
                return jSONObject;
            }
            jSONObject.put("code", -1);
            jSONObject.put("codeMsg", "unavailable");
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    public static void c(com.bytedance.sdk.component.c.s sVar, SSWebView sSWebView, String str) {
        sVar.c("start_twist_observer", (com.bytedance.sdk.component.c.ux<?, ?>) new c(sSWebView, str));
    }

    @Override // com.bytedance.sdk.component.c.ux
    public JSONObject c(JSONObject jSONObject, com.bytedance.sdk.component.c.f fVar) throws Exception {
        com.bytedance.sdk.component.utils.a.w("AddTwistMethod", "AddWobbleMethod invoke");
        return xv();
    }
}
