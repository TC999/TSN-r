package com.bytedance.sdk.component.panglearmor.c;

import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ux {

    /* renamed from: c  reason: collision with root package name */
    private static ux f29998c;

    /* renamed from: w  reason: collision with root package name */
    private boolean f30001w = false;
    private long xv = 180000;
    private long sr = 43200000;
    private long ux = 3;

    /* renamed from: f  reason: collision with root package name */
    private long f29999f = 30;

    /* renamed from: r  reason: collision with root package name */
    private long f30000r = 15;

    private ux() {
    }

    public static ux c() {
        if (f29998c == null) {
            synchronized (ux.class) {
                if (f29998c == null) {
                    f29998c = new ux();
                }
            }
        }
        return f29998c;
    }

    public long f() {
        return this.f29999f;
    }

    public long r() {
        return this.f30000r;
    }

    public long sr() {
        return this.xv;
    }

    public long ux() {
        return this.ux;
    }

    public boolean w() {
        return this.f30001w;
    }

    public long xv() {
        return this.sr;
    }

    public synchronized void c(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (!jSONObject.toString().isEmpty()) {
                this.f30001w = jSONObject.optBoolean("sensorenable", false);
                this.xv = jSONObject.optLong("interval", 180000L);
                this.sr = jSONObject.optLong("expireduation", 43200000L);
                this.ux = jSONObject.optLong("showinterval", 3L);
                this.f29999f = jSONObject.optLong("azimuth_unit", 30L);
                this.f30000r = jSONObject.optLong("angle_unit", 15L);
            }
        }
    }
}
