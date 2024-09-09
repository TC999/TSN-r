package com.bytedance.sdk.openadsdk.ux.xv;

import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class t implements sr {

    /* renamed from: c  reason: collision with root package name */
    public long f36340c;

    /* renamed from: w  reason: collision with root package name */
    public int f36341w;
    public long xv;

    @Override // com.bytedance.sdk.openadsdk.ux.xv.sr
    public void a_(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("buffers_time", this.f36340c);
            jSONObject.put("buffers_count", this.f36341w);
            jSONObject.put("total_duration", this.xv);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void c(long j4) {
        this.f36340c = j4;
    }

    public void w(long j4) {
        this.xv = j4;
    }

    public void c(int i4) {
        this.f36341w = i4;
    }
}
