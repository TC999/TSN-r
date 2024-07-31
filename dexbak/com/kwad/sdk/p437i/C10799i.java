package com.kwad.sdk.p437i;

import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.kwad.sdk.i.i */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10799i implements InterfaceC10788b {
    public String aJn;
    public String aJo;
    public String aJp;
    public long aJq = System.currentTimeMillis();
    public double aor;

    /* renamed from: Jl */
    public static C10799i m24819Jl() {
        return new C10799i();
    }

    /* renamed from: fV */
    public final C10799i m24818fV(String str) {
        this.aJn = str;
        return this;
    }

    /* renamed from: fW */
    public final C10799i m24817fW(String str) {
        this.aJo = str;
        return this;
    }

    /* renamed from: fX */
    public final C10799i m24816fX(String str) {
        this.aJp = str;
        return this;
    }

    /* renamed from: n */
    public final C10799i m24815n(double d) {
        this.aor = d;
        return this;
    }

    @Override // com.kwad.sdk.p437i.InterfaceC10788b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        C10789c.m24866a(jSONObject, "ratio", Double.valueOf(this.aor));
        C10789c.m24866a(jSONObject, "ratio_count", Double.valueOf(C10800j.m24806o(this.aor)));
        C10789c.putValue(jSONObject, "log_build_time_ms", this.aJq);
        C10789c.putValue(jSONObject, "log_level", this.aJn);
        C10789c.putValue(jSONObject, "log_tag", this.aJo);
        C10789c.putValue(jSONObject, "log_content", this.aJp);
        return jSONObject;
    }
}
