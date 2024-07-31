package com.amap.api.services.geocoder;

import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class GeocodeResult {

    /* renamed from: a */
    private GeocodeQuery f7367a;

    /* renamed from: b */
    private List<GeocodeAddress> f7368b;

    public GeocodeResult(GeocodeQuery geocodeQuery, List<GeocodeAddress> list) {
        new ArrayList();
        this.f7367a = geocodeQuery;
        this.f7368b = list;
    }

    public List<GeocodeAddress> getGeocodeAddressList() {
        return this.f7368b;
    }

    public GeocodeQuery getGeocodeQuery() {
        return this.f7367a;
    }

    public void setGeocodeAddressList(List<GeocodeAddress> list) {
        this.f7368b = list;
    }

    public void setGeocodeQuery(GeocodeQuery geocodeQuery) {
        this.f7367a = geocodeQuery;
    }
}
