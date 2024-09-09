package com.bytedance.sdk.openadsdk.ux.xv;

import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class a extends c {

    /* renamed from: c  reason: collision with root package name */
    private String f36312c;

    /* renamed from: w  reason: collision with root package name */
    private long f36313w;

    public a(String str, long j4) {
        this.f36312c = str;
        this.f36313w = j4;
    }

    @Override // com.bytedance.sdk.openadsdk.ux.xv.sr
    public void a_(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("preload_url", this.f36312c);
            jSONObject.put("preload_size", this.f36313w);
            com.bykv.vk.openvk.component.video.api.xv.sr c4 = c();
            if (c4 != null) {
                jSONObject.put("run_task_mills", c4.c().optLong("run_task_mills"));
            }
            c(jSONObject);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
