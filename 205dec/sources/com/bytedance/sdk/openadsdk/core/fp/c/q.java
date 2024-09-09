package com.bytedance.sdk.openadsdk.core.fp.c;

import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class q extends com.bytedance.sdk.component.c.ux<JSONObject, JSONObject> {

    /* renamed from: c  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.ugeno.w f33571c;

    public q(com.bytedance.sdk.openadsdk.core.ugeno.w wVar) {
        this.f33571c = wVar;
    }

    public JSONObject xv() {
        return new JSONObject();
    }

    public static void c(com.bytedance.sdk.component.c.s sVar, com.bytedance.sdk.openadsdk.core.ugeno.w wVar) {
        sVar.c("RendUgenDownloadDialogState", (com.bytedance.sdk.component.c.ux<?, ?>) new q(wVar));
    }

    @Override // com.bytedance.sdk.component.c.ux
    public JSONObject c(JSONObject jSONObject, com.bytedance.sdk.component.c.f fVar) throws Exception {
        c(jSONObject);
        return xv();
    }

    private void c(JSONObject jSONObject) {
        if (jSONObject == null || this.f33571c == null) {
            return;
        }
        int optInt = jSONObject.optInt("code");
        if (optInt == 200) {
            this.f33571c.c();
            return;
        }
        this.f33571c.c(optInt, jSONObject.optString("errorMsg"));
    }
}
