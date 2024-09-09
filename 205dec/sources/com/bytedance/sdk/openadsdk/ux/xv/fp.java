package com.bytedance.sdk.openadsdk.ux.xv;

import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class fp implements sr {

    /* renamed from: c  reason: collision with root package name */
    private long f36321c;

    @Override // com.bytedance.sdk.openadsdk.ux.xv.sr
    public void a_(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("video_cache_size", this.f36321c);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void c(long j4) {
        this.f36321c = j4;
    }
}
