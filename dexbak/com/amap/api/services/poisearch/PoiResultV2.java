package com.amap.api.services.poisearch;

import com.amap.api.services.core.PoiItemV2;
import com.amap.api.services.poisearch.PoiSearchV2;
import java.util.ArrayList;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class PoiResultV2 {

    /* renamed from: a */
    private int f7471a;

    /* renamed from: b */
    private ArrayList<PoiItemV2> f7472b;

    /* renamed from: c */
    private PoiSearchV2.Query f7473c;

    /* renamed from: d */
    private PoiSearchV2.SearchBound f7474d;

    private PoiResultV2(PoiSearchV2.Query query, PoiSearchV2.SearchBound searchBound, int i, ArrayList<PoiItemV2> arrayList) {
        new ArrayList();
        this.f7473c = query;
        this.f7474d = searchBound;
        this.f7471a = i;
        this.f7472b = arrayList;
    }

    public static PoiResultV2 createPagedResult(PoiSearchV2.Query query, PoiSearchV2.SearchBound searchBound, int i, ArrayList<PoiItemV2> arrayList) {
        return new PoiResultV2(query, searchBound, i, arrayList);
    }

    public PoiSearchV2.SearchBound getBound() {
        return this.f7474d;
    }

    public int getCount() {
        return this.f7471a;
    }

    public ArrayList<PoiItemV2> getPois() {
        return this.f7472b;
    }

    public PoiSearchV2.Query getQuery() {
        return this.f7473c;
    }
}
