package com.bytedance.sdk.openadsdk.core.fp.c;

import com.bytedance.sdk.openadsdk.core.xk;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class gd extends com.bytedance.sdk.component.c.ux<JSONObject, JSONObject> {

    /* renamed from: c  reason: collision with root package name */
    private WeakReference<xk> f33553c;

    public gd(xk xkVar) {
        this.f33553c = new WeakReference<>(xkVar);
    }

    public JSONObject xv() {
        xk xkVar;
        JSONObject jSONObject = new JSONObject();
        try {
            WeakReference<xk> weakReference = this.f33553c;
            if (weakReference == null || (xkVar = weakReference.get()) == null) {
                return jSONObject;
            }
            jSONObject = xkVar.n();
            com.bytedance.sdk.component.utils.a.w("GetAppManageModelMethod", "GetAppManageModelMethod analysisJson resultJsonObject " + jSONObject.toString());
            return jSONObject;
        } catch (Throwable unused) {
            return jSONObject;
        }
    }

    public static void c(com.bytedance.sdk.component.c.s sVar, xk xkVar) {
        sVar.c("getAppManage", (com.bytedance.sdk.component.c.ux<?, ?>) new gd(xkVar));
    }

    @Override // com.bytedance.sdk.component.c.ux
    public JSONObject c(JSONObject jSONObject, com.bytedance.sdk.component.c.f fVar) throws Exception {
        return xv();
    }
}
