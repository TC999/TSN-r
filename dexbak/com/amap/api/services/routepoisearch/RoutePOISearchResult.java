package com.amap.api.services.routepoisearch;

import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class RoutePOISearchResult {

    /* renamed from: a */
    private List<RoutePOIItem> f7917a;

    /* renamed from: b */
    private RoutePOISearchQuery f7918b;

    public RoutePOISearchResult(ArrayList<RoutePOIItem> arrayList, RoutePOISearchQuery routePOISearchQuery) {
        new ArrayList();
        this.f7917a = arrayList;
        this.f7918b = routePOISearchQuery;
    }

    public RoutePOISearchQuery getQuery() {
        return this.f7918b;
    }

    public List<RoutePOIItem> getRoutePois() {
        return this.f7917a;
    }
}
