package com.bytedance.sdk.openadsdk.ux.xv;

import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class f implements sr {

    /* renamed from: c  reason: collision with root package name */
    private long f36319c;

    /* renamed from: w  reason: collision with root package name */
    private long f36320w;

    @Override // com.bytedance.sdk.openadsdk.ux.xv.sr
    public void a_(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("buffers_time", this.f36319c);
            jSONObject.put("total_duration", this.f36320w);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void c(long j4) {
        this.f36319c = j4;
    }

    public void w(long j4) {
        this.f36320w = j4;
    }
}
