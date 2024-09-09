package com.bytedance.sdk.openadsdk.ux.xv;

import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class bk extends c {

    /* renamed from: c  reason: collision with root package name */
    private String f36314c;
    private long sr;

    /* renamed from: w  reason: collision with root package name */
    private long f36315w;
    private long xv;

    @Override // com.bytedance.sdk.openadsdk.ux.xv.sr
    public void a_(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("preload_url", this.f36314c);
            jSONObject.put("preload_size", this.f36315w);
            jSONObject.put("load_time", this.xv);
            jSONObject.put("local_cache", this.sr);
            c(jSONObject);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void c(String str) {
        this.f36314c = str;
    }

    public void w(long j4) {
        this.xv = j4;
    }

    public void xv(long j4) {
        this.sr = j4;
    }

    public void c(long j4) {
        this.f36315w = j4;
    }

    public long w() {
        return this.sr;
    }
}
