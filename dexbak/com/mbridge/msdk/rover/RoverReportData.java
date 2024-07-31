package com.mbridge.msdk.rover;

import io.netty.handler.codec.rtsp.RtspHeaders;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.mbridge.msdk.rover.e */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class RoverReportData {

    /* renamed from: a */
    private String f31680a;

    /* renamed from: b */
    private int f31681b;

    /* renamed from: c */
    private int f31682c;

    /* renamed from: d */
    private int f31683d;

    /* renamed from: e */
    private String f31684e;

    /* renamed from: f */
    private String f31685f;

    /* renamed from: a */
    public final void m21310a(String str) {
        this.f31680a = str;
    }

    /* renamed from: b */
    public final void m21309b(int i) {
        this.f31682c = i;
    }

    /* renamed from: c */
    public final void m21307c(int i) {
        this.f31683d = i;
    }

    public final String toString() {
        return "url=" + this.f31680a + ", type=" + this.f31681b + ", time=" + this.f31682c + ", code=" + this.f31683d + ", header=" + this.f31684e + ", exception=" + this.f31685f;
    }

    /* renamed from: a */
    public final void m21311a(int i) {
        this.f31681b = i;
    }

    /* renamed from: b */
    public final void m21308b(String str) {
        this.f31684e = str;
    }

    /* renamed from: c */
    public final void m21306c(String str) {
        this.f31685f = str;
    }

    /* renamed from: a */
    public final JSONObject m21312a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("url", this.f31680a);
            jSONObject.put("type", this.f31681b);
            jSONObject.put(RtspHeaders.Values.TIME, this.f31682c);
            jSONObject.put("code", this.f31683d);
            jSONObject.put("header", this.f31684e);
            jSONObject.put("exception", this.f31685f);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
