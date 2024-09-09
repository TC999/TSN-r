package com.amap.api.services.poisearch;

import com.amap.api.services.core.PoiItemV2;
import com.amap.api.services.poisearch.PoiSearchV2;
import java.util.ArrayList;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class PoiResultV2 {

    /* renamed from: a  reason: collision with root package name */
    private int f11165a;

    /* renamed from: b  reason: collision with root package name */
    private ArrayList<PoiItemV2> f11166b;

    /* renamed from: c  reason: collision with root package name */
    private PoiSearchV2.Query f11167c;

    /* renamed from: d  reason: collision with root package name */
    private PoiSearchV2.SearchBound f11168d;

    private PoiResultV2(PoiSearchV2.Query query, PoiSearchV2.SearchBound searchBound, int i4, ArrayList<PoiItemV2> arrayList) {
        new ArrayList();
        this.f11167c = query;
        this.f11168d = searchBound;
        this.f11165a = i4;
        this.f11166b = arrayList;
    }

    public static PoiResultV2 createPagedResult(PoiSearchV2.Query query, PoiSearchV2.SearchBound searchBound, int i4, ArrayList<PoiItemV2> arrayList) {
        return new PoiResultV2(query, searchBound, i4, arrayList);
    }

    public PoiSearchV2.SearchBound getBound() {
        return this.f11168d;
    }

    public int getCount() {
        return this.f11165a;
    }

    public ArrayList<PoiItemV2> getPois() {
        return this.f11166b;
    }

    public PoiSearchV2.Query getQuery() {
        return this.f11167c;
    }
}
