package com.bytedance.sdk.openadsdk.core.fp.c;

import com.bytedance.sdk.component.widget.SSWebView;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class fz extends com.bytedance.sdk.component.c.ux<JSONObject, JSONObject> {

    /* renamed from: c  reason: collision with root package name */
    private WeakReference<SSWebView> f33550c;

    public fz(SSWebView sSWebView) {
        this.f33550c = new WeakReference<>(sSWebView);
    }

    public static void c(com.bytedance.sdk.component.c.s sVar, SSWebView sSWebView) {
        sVar.c("preventTouchEvent", (com.bytedance.sdk.component.c.ux<?, ?>) new fz(sSWebView));
    }

    @Override // com.bytedance.sdk.component.c.ux
    public JSONObject c(JSONObject jSONObject, com.bytedance.sdk.component.c.f fVar) throws Exception {
        JSONObject jSONObject2 = new JSONObject();
        try {
            boolean optBoolean = jSONObject.optBoolean("isPrevent", false);
            SSWebView sSWebView = this.f33550c.get();
            if (sSWebView != null) {
                sSWebView.setIsPreventTouchEvent(optBoolean);
                jSONObject2.put("success", true);
            } else {
                jSONObject2.put("success", false);
            }
        } catch (Throwable unused) {
            jSONObject2.put("success", false);
        }
        return jSONObject2;
    }
}
