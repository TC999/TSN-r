package com.kwad.sdk.h;

import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\6206960.dex */
public final class i implements b {
    public String aKC;
    public String aKD;
    public String aKE;
    public long aKF = System.currentTimeMillis();
    public double apu;

    public static i JW() {
        return new i();
    }

    public final i gi(String str) {
        this.aKC = str;
        return this;
    }

    public final i gj(String str) {
        this.aKD = str;
        return this;
    }

    public final i gk(String str) {
        this.aKE = str;
        return this;
    }

    public final i n(double d4) {
        this.apu = d4;
        return this;
    }

    @Override // com.kwad.sdk.h.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        c.a(jSONObject, "ratio", Double.valueOf(this.apu));
        c.a(jSONObject, "ratio_count", Double.valueOf(j.o(this.apu)));
        c.putValue(jSONObject, "log_build_time_ms", this.aKF);
        c.putValue(jSONObject, "log_level", this.aKC);
        c.putValue(jSONObject, "log_tag", this.aKD);
        c.putValue(jSONObject, "log_content", this.aKE);
        return jSONObject;
    }
}
