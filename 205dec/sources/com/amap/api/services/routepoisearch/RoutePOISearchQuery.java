package com.amap.api.services.routepoisearch;

import com.amap.api.col.s.j4;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.routepoisearch.RoutePOISearch;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class RoutePOISearchQuery implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    private LatLonPoint f11604a;

    /* renamed from: b  reason: collision with root package name */
    private LatLonPoint f11605b;

    /* renamed from: c  reason: collision with root package name */
    private int f11606c;

    /* renamed from: d  reason: collision with root package name */
    private RoutePOISearch.RoutePOISearchType f11607d;

    /* renamed from: e  reason: collision with root package name */
    private int f11608e;

    /* renamed from: f  reason: collision with root package name */
    private List<LatLonPoint> f11609f;

    /* renamed from: g  reason: collision with root package name */
    private String f11610g;

    public RoutePOISearchQuery(LatLonPoint latLonPoint, LatLonPoint latLonPoint2, int i4, RoutePOISearch.RoutePOISearchType routePOISearchType, int i5) {
        this.f11604a = latLonPoint;
        this.f11605b = latLonPoint2;
        this.f11606c = i4;
        this.f11607d = routePOISearchType;
        this.f11608e = i5;
    }

    public String getChannel() {
        return this.f11610g;
    }

    public LatLonPoint getFrom() {
        return this.f11604a;
    }

    public int getMode() {
        return this.f11606c;
    }

    public List<LatLonPoint> getPolylines() {
        return this.f11609f;
    }

    public int getRange() {
        return this.f11608e;
    }

    public RoutePOISearch.RoutePOISearchType getSearchType() {
        return this.f11607d;
    }

    public LatLonPoint getTo() {
        return this.f11605b;
    }

    public void setChannel(String str) {
        this.f11610g = str;
    }

    /* renamed from: clone */
    public RoutePOISearchQuery m53clone() {
        try {
            super.clone();
        } catch (CloneNotSupportedException e4) {
            j4.i(e4, "RoutePOISearchQuery", "RoutePOISearchQueryclone");
        }
        List<LatLonPoint> list = this.f11609f;
        if (list != null && list.size() > 0) {
            RoutePOISearchQuery routePOISearchQuery = new RoutePOISearchQuery(this.f11609f, this.f11607d, this.f11608e);
            routePOISearchQuery.setChannel(this.f11610g);
            return routePOISearchQuery;
        }
        RoutePOISearchQuery routePOISearchQuery2 = new RoutePOISearchQuery(this.f11604a, this.f11605b, this.f11606c, this.f11607d, this.f11608e);
        routePOISearchQuery2.setChannel(this.f11610g);
        return routePOISearchQuery2;
    }

    public RoutePOISearchQuery(List<LatLonPoint> list, RoutePOISearch.RoutePOISearchType routePOISearchType, int i4) {
        this.f11609f = list;
        this.f11607d = routePOISearchType;
        this.f11608e = i4;
    }
}
