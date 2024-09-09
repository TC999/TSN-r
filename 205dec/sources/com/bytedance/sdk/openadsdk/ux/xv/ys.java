package com.bytedance.sdk.openadsdk.ux.xv;

import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class ys implements sr {

    /* renamed from: c  reason: collision with root package name */
    private long f36348c;
    private int sr;
    private String ux;

    /* renamed from: w  reason: collision with root package name */
    private long f36349w;
    private int xv;

    @Override // com.bytedance.sdk.openadsdk.ux.xv.sr
    public void a_(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("buffers_time", this.f36348c);
            jSONObject.put("total_duration", this.f36349w);
            jSONObject.put("error_code", this.xv);
            jSONObject.put("extra_error_code", this.sr);
            jSONObject.put("error_message", this.ux);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void c(long j4) {
        this.f36348c = j4;
    }

    public void w(long j4) {
        this.f36349w = j4;
    }

    public void c(int i4) {
        this.xv = i4;
    }

    public void w(int i4) {
        this.sr = i4;
    }
}
