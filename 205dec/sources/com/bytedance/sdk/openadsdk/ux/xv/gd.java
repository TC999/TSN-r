package com.bytedance.sdk.openadsdk.ux.xv;

import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class gd implements sr {

    /* renamed from: c  reason: collision with root package name */
    private long f36322c;

    /* renamed from: w  reason: collision with root package name */
    private long f36323w;
    private int xv;

    @Override // com.bytedance.sdk.openadsdk.ux.xv.sr
    public void a_(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("video_start_duration", this.f36322c);
            jSONObject.put("video_cache_size", this.f36323w);
            jSONObject.put("is_auto_play", this.xv);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void c(long j4) {
        this.f36322c = j4;
    }

    public void w(long j4) {
        this.f36323w = j4;
    }

    public void c(int i4) {
        this.xv = i4;
    }
}
