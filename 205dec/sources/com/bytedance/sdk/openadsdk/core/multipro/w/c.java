package com.bytedance.sdk.openadsdk.core.multipro.w;

import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c {

    /* renamed from: c  reason: collision with root package name */
    public boolean f33977c;
    public boolean ev;

    /* renamed from: f  reason: collision with root package name */
    public long f33978f;

    /* renamed from: r  reason: collision with root package name */
    public long f33979r;
    public boolean sr;
    public long ux;

    /* renamed from: w  reason: collision with root package name */
    public boolean f33980w;
    public boolean xv;

    /* renamed from: com.bytedance.sdk.openadsdk.core.multipro.w.c$c  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface InterfaceC0499c {
        boolean ba();

        c eq();
    }

    public void c(boolean z3) {
        this.ev = z3;
    }

    public c sr(boolean z3) {
        this.f33980w = z3;
        return this;
    }

    public c ux(boolean z3) {
        this.xv = z3;
        return this;
    }

    public c w(boolean z3) {
        this.sr = z3;
        return this;
    }

    public c xv(boolean z3) {
        this.f33977c = z3;
        return this;
    }

    public c c(long j4) {
        this.ux = j4;
        return this;
    }

    public c w(long j4) {
        this.f33978f = j4;
        return this;
    }

    public c xv(long j4) {
        this.f33979r = j4;
        return this;
    }

    public JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("isCompleted", this.f33977c);
            jSONObject.put("isFromVideoDetailPage", this.f33980w);
            jSONObject.put("isFromDetailPage", this.xv);
            jSONObject.put("duration", this.ux);
            jSONObject.put("totalPlayDuration", this.f33978f);
            jSONObject.put("currentPlayPosition", this.f33979r);
            jSONObject.put("isAutoPlay", this.sr);
            jSONObject.put("isMute", this.ev);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public static c c(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        c cVar = new c();
        cVar.xv(jSONObject.optBoolean("isCompleted"));
        cVar.sr(jSONObject.optBoolean("isFromVideoDetailPage"));
        cVar.ux(jSONObject.optBoolean("isFromDetailPage"));
        cVar.c(jSONObject.optLong("duration"));
        cVar.w(jSONObject.optLong("totalPlayDuration"));
        cVar.xv(jSONObject.optLong("currentPlayPosition"));
        cVar.w(jSONObject.optBoolean("isAutoPlay"));
        cVar.c(jSONObject.optBoolean("isMute"));
        return cVar;
    }
}
