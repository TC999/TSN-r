package com.amap.api.services.routepoisearch;

import com.amap.api.col.p047s.C2082j4;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.routepoisearch.RoutePOISearch;
import java.util.List;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class RoutePOISearchQuery implements Cloneable {

    /* renamed from: a */
    private LatLonPoint f7910a;

    /* renamed from: b */
    private LatLonPoint f7911b;

    /* renamed from: c */
    private int f7912c;

    /* renamed from: d */
    private RoutePOISearch.RoutePOISearchType f7913d;

    /* renamed from: e */
    private int f7914e;

    /* renamed from: f */
    private List<LatLonPoint> f7915f;

    /* renamed from: g */
    private String f7916g;

    public RoutePOISearchQuery(LatLonPoint latLonPoint, LatLonPoint latLonPoint2, int i, RoutePOISearch.RoutePOISearchType routePOISearchType, int i2) {
        this.f7910a = latLonPoint;
        this.f7911b = latLonPoint2;
        this.f7912c = i;
        this.f7913d = routePOISearchType;
        this.f7914e = i2;
    }

    public String getChannel() {
        return this.f7916g;
    }

    public LatLonPoint getFrom() {
        return this.f7910a;
    }

    public int getMode() {
        return this.f7912c;
    }

    public List<LatLonPoint> getPolylines() {
        return this.f7915f;
    }

    public int getRange() {
        return this.f7914e;
    }

    public RoutePOISearch.RoutePOISearchType getSearchType() {
        return this.f7913d;
    }

    public LatLonPoint getTo() {
        return this.f7911b;
    }

    public void setChannel(String str) {
        this.f7916g = str;
    }

    /* renamed from: clone */
    public RoutePOISearchQuery m60132clone() {
        try {
            super.clone();
        } catch (CloneNotSupportedException e) {
            C2082j4.m52825i(e, "RoutePOISearchQuery", "RoutePOISearchQueryclone");
        }
        List<LatLonPoint> list = this.f7915f;
        if (list != null && list.size() > 0) {
            RoutePOISearchQuery routePOISearchQuery = new RoutePOISearchQuery(this.f7915f, this.f7913d, this.f7914e);
            routePOISearchQuery.setChannel(this.f7916g);
            return routePOISearchQuery;
        }
        RoutePOISearchQuery routePOISearchQuery2 = new RoutePOISearchQuery(this.f7910a, this.f7911b, this.f7912c, this.f7913d, this.f7914e);
        routePOISearchQuery2.setChannel(this.f7916g);
        return routePOISearchQuery2;
    }

    public RoutePOISearchQuery(List<LatLonPoint> list, RoutePOISearch.RoutePOISearchType routePOISearchType, int i) {
        this.f7915f = list;
        this.f7913d = routePOISearchType;
        this.f7914e = i;
    }
}
