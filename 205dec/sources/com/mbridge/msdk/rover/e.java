package com.mbridge.msdk.rover;

import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: RoverReportData.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    private String f40451a;

    /* renamed from: b  reason: collision with root package name */
    private int f40452b;

    /* renamed from: c  reason: collision with root package name */
    private int f40453c;

    /* renamed from: d  reason: collision with root package name */
    private int f40454d;

    /* renamed from: e  reason: collision with root package name */
    private String f40455e;

    /* renamed from: f  reason: collision with root package name */
    private String f40456f;

    public final void a(String str) {
        this.f40451a = str;
    }

    public final void b(int i4) {
        this.f40453c = i4;
    }

    public final void c(int i4) {
        this.f40454d = i4;
    }

    public final String toString() {
        return "url=" + this.f40451a + ", type=" + this.f40452b + ", time=" + this.f40453c + ", code=" + this.f40454d + ", header=" + this.f40455e + ", exception=" + this.f40456f;
    }

    public final void a(int i4) {
        this.f40452b = i4;
    }

    public final void b(String str) {
        this.f40455e = str;
    }

    public final void c(String str) {
        this.f40456f = str;
    }

    public final JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("url", this.f40451a);
            jSONObject.put("type", this.f40452b);
            jSONObject.put("time", this.f40453c);
            jSONObject.put("code", this.f40454d);
            jSONObject.put("header", this.f40455e);
            jSONObject.put("exception", this.f40456f);
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        return jSONObject;
    }
}
