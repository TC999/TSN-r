package com.bytedance.sdk.openadsdk.ux.xv;

import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public abstract class c implements sr {

    /* renamed from: c  reason: collision with root package name */
    private com.bykv.vk.openvk.component.video.api.xv.sr f36316c;

    public void c(com.bykv.vk.openvk.component.video.api.xv.sr srVar) {
        this.f36316c = srVar;
    }

    public com.bykv.vk.openvk.component.video.api.xv.sr c() {
        return this.f36316c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(JSONObject jSONObject) {
        try {
            com.bykv.vk.openvk.component.video.api.xv.sr srVar = this.f36316c;
            if (srVar == null || jSONObject == null) {
                return;
            }
            JSONObject c4 = srVar.c();
            jSONObject.put("pitaya_cache_size", this.f36316c.w());
            jSONObject.put("pitaya_code", this.f36316c.xv());
            jSONObject.put("pitaya_msg", this.f36316c.sr());
            jSONObject.put("ext_plugin_code", c4.optInt("ext_plugin_code"));
            jSONObject.put("package", c4.optJSONObject("package"));
        } catch (Exception unused) {
        }
    }
}
