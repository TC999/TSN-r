package com.amap.api.services.geocoder;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class RegeocodeResult {

    /* renamed from: a */
    private RegeocodeQuery f7394a;

    /* renamed from: b */
    private RegeocodeAddress f7395b;

    public RegeocodeResult(RegeocodeQuery regeocodeQuery, RegeocodeAddress regeocodeAddress) {
        this.f7394a = regeocodeQuery;
        this.f7395b = regeocodeAddress;
    }

    public RegeocodeAddress getRegeocodeAddress() {
        return this.f7395b;
    }

    public RegeocodeQuery getRegeocodeQuery() {
        return this.f7394a;
    }

    public void setRegeocodeAddress(RegeocodeAddress regeocodeAddress) {
        this.f7395b = regeocodeAddress;
    }

    public void setRegeocodeQuery(RegeocodeQuery regeocodeQuery) {
        this.f7394a = regeocodeQuery;
    }
}
