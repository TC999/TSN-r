package com.bytedance.sdk.openadsdk;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6465380.dex
 */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class TTLocation implements LocationProvider {

    /* renamed from: a  reason: collision with root package name */
    private double f31360a;
    private double ok;

    public TTLocation(double d4, double d5) {
        this.ok = d4;
        this.f31360a = d5;
    }

    @Override // com.bytedance.sdk.openadsdk.LocationProvider
    public double getLatitude() {
        return this.ok;
    }

    @Override // com.bytedance.sdk.openadsdk.LocationProvider
    public double getLongitude() {
        return this.f31360a;
    }

    public void setLatitude(double d4) {
        this.ok = d4;
    }

    public void setLongitude(double d4) {
        this.f31360a = d4;
    }
}
