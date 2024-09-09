package com.bytedance.sdk.openadsdk.ux.xv;

import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class k extends c {

    /* renamed from: c  reason: collision with root package name */
    private String f36333c;

    /* renamed from: f  reason: collision with root package name */
    private String f36334f;
    private int sr;
    private String ux;

    /* renamed from: w  reason: collision with root package name */
    private long f36335w;
    private long xv;

    @Override // com.bytedance.sdk.openadsdk.ux.xv.sr
    public void a_(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("preload_url", this.f36333c);
            jSONObject.put("preload_size", this.f36335w);
            jSONObject.put("load_time", this.xv);
            jSONObject.put("error_code", this.sr);
            jSONObject.put("error_message", this.ux);
            jSONObject.put("error_message_server", this.f36334f);
            c(jSONObject);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void c(String str) {
        this.f36333c = str;
    }

    public void w(long j4) {
        this.xv = j4;
    }

    public void xv(String str) {
        this.f36334f = str;
    }

    public void c(long j4) {
        this.f36335w = j4;
    }

    public void w(String str) {
        this.ux = str;
    }

    public void c(int i4) {
        this.sr = i4;
    }
}
