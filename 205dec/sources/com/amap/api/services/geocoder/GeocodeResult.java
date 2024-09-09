package com.amap.api.services.geocoder;

import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class GeocodeResult {

    /* renamed from: a  reason: collision with root package name */
    private GeocodeQuery f11061a;

    /* renamed from: b  reason: collision with root package name */
    private List<GeocodeAddress> f11062b;

    public GeocodeResult(GeocodeQuery geocodeQuery, List<GeocodeAddress> list) {
        new ArrayList();
        this.f11061a = geocodeQuery;
        this.f11062b = list;
    }

    public List<GeocodeAddress> getGeocodeAddressList() {
        return this.f11062b;
    }

    public GeocodeQuery getGeocodeQuery() {
        return this.f11061a;
    }

    public void setGeocodeAddressList(List<GeocodeAddress> list) {
        this.f11062b = list;
    }

    public void setGeocodeQuery(GeocodeQuery geocodeQuery) {
        this.f11061a = geocodeQuery;
    }
}
