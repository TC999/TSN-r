package com.bytedance.sdk.openadsdk.ux.xv;

import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class r implements sr {

    /* renamed from: c  reason: collision with root package name */
    private long f36338c;

    /* renamed from: w  reason: collision with root package name */
    private long f36339w;
    private int xv = 0;

    @Override // com.bytedance.sdk.openadsdk.ux.xv.sr
    public void a_(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("total_duration", this.f36338c);
            jSONObject.put("buffers_time", this.f36339w);
            jSONObject.put("video_backup", this.xv);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void c(long j4) {
        this.f36338c = j4;
    }

    public void w(long j4) {
        this.f36339w = j4;
    }

    public void c(int i4) {
        this.xv = i4;
    }
}