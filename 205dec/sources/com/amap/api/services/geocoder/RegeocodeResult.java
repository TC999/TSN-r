package com.amap.api.services.geocoder;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class RegeocodeResult {

    /* renamed from: a  reason: collision with root package name */
    private RegeocodeQuery f11088a;

    /* renamed from: b  reason: collision with root package name */
    private RegeocodeAddress f11089b;

    public RegeocodeResult(RegeocodeQuery regeocodeQuery, RegeocodeAddress regeocodeAddress) {
        this.f11088a = regeocodeQuery;
        this.f11089b = regeocodeAddress;
    }

    public RegeocodeAddress getRegeocodeAddress() {
        return this.f11089b;
    }

    public RegeocodeQuery getRegeocodeQuery() {
        return this.f11088a;
    }

    public void setRegeocodeAddress(RegeocodeAddress regeocodeAddress) {
        this.f11089b = regeocodeAddress;
    }

    public void setRegeocodeQuery(RegeocodeQuery regeocodeQuery) {
        this.f11088a = regeocodeQuery;
    }
}
