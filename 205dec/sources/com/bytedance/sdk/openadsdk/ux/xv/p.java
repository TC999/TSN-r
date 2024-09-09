package com.bytedance.sdk.openadsdk.ux.xv;

import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class p extends c {

    /* renamed from: c  reason: collision with root package name */
    private String f36336c;

    /* renamed from: w  reason: collision with root package name */
    private long f36337w;

    public p(String str, long j4) {
        this.f36336c = str;
        this.f36337w = j4;
    }

    @Override // com.bytedance.sdk.openadsdk.ux.xv.sr
    public void a_(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("preload_url", this.f36336c);
            jSONObject.put("preload_size", this.f36337w);
            c(jSONObject);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
