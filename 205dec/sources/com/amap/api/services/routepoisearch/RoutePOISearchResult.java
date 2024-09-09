package com.amap.api.services.routepoisearch;

import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class RoutePOISearchResult {

    /* renamed from: a  reason: collision with root package name */
    private List<RoutePOIItem> f11611a;

    /* renamed from: b  reason: collision with root package name */
    private RoutePOISearchQuery f11612b;

    public RoutePOISearchResult(ArrayList<RoutePOIItem> arrayList, RoutePOISearchQuery routePOISearchQuery) {
        new ArrayList();
        this.f11611a = arrayList;
        this.f11612b = routePOISearchQuery;
    }

    public RoutePOISearchQuery getQuery() {
        return this.f11612b;
    }

    public List<RoutePOIItem> getRoutePois() {
        return this.f11611a;
    }
}
