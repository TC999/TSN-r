package com.bytedance.sdk.openadsdk.ux.xv;

import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class xv implements sr {

    /* renamed from: c  reason: collision with root package name */
    private long f36346c;
    private int sr;

    /* renamed from: w  reason: collision with root package name */
    private long f36347w;
    private int xv;

    @Override // com.bytedance.sdk.openadsdk.ux.xv.sr
    public void a_(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("buffers_time", this.f36346c);
            jSONObject.put("total_duration", this.f36347w);
            jSONObject.put("vbtt_skip_type", this.xv);
            jSONObject.put("skip_reason", this.sr);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void c(long j4) {
        this.f36346c = j4;
    }

    public void w(long j4) {
        this.f36347w = j4;
    }

    public void c(int i4) {
        this.xv = i4;
    }

    public void w(int i4) {
        this.sr = i4;
    }
}
