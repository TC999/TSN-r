package com.bytedance.sdk.openadsdk;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class TTLocation implements LocationProvider {

    /* renamed from: a */
    private double f22351a;

    /* renamed from: ok */
    private double f22352ok;

    public TTLocation(double d, double d2) {
        this.f22352ok = d;
        this.f22351a = d2;
    }

    @Override // com.bytedance.sdk.openadsdk.LocationProvider
    public double getLatitude() {
        return this.f22352ok;
    }

    @Override // com.bytedance.sdk.openadsdk.LocationProvider
    public double getLongitude() {
        return this.f22351a;
    }

    public void setLatitude(double d) {
        this.f22352ok = d;
    }

    public void setLongitude(double d) {
        this.f22351a = d;
    }
}
