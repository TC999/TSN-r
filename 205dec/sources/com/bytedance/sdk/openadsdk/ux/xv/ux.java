package com.bytedance.sdk.openadsdk.ux.xv;

import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class ux implements sr {

    /* renamed from: c  reason: collision with root package name */
    public long f36342c;
    public int sr = 0;

    /* renamed from: w  reason: collision with root package name */
    public long f36343w;
    public int xv;

    @Override // com.bytedance.sdk.openadsdk.ux.xv.sr
    public void a_(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("total_duration", this.f36342c);
            jSONObject.put("buffers_time", this.f36343w);
            jSONObject.put("break_reason", this.xv);
            jSONObject.put("video_backup", this.sr);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void c(long j4) {
        this.f36342c = j4;
    }

    public void w(long j4) {
        this.f36343w = j4;
    }

    public void c(int i4) {
        this.xv = i4;
    }

    public void w(int i4) {
        this.sr = i4;
    }
}
