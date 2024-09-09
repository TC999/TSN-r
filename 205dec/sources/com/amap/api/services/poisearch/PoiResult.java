package com.amap.api.services.poisearch;

import com.amap.api.services.core.PoiItem;
import com.amap.api.services.core.SuggestionCity;
import com.amap.api.services.poisearch.PoiSearch;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class PoiResult {

    /* renamed from: a  reason: collision with root package name */
    private int f11158a;

    /* renamed from: b  reason: collision with root package name */
    private ArrayList<PoiItem> f11159b;

    /* renamed from: c  reason: collision with root package name */
    private PoiSearch.Query f11160c;

    /* renamed from: d  reason: collision with root package name */
    private PoiSearch.SearchBound f11161d;

    /* renamed from: e  reason: collision with root package name */
    private List<String> f11162e;

    /* renamed from: f  reason: collision with root package name */
    private List<SuggestionCity> f11163f;

    /* renamed from: g  reason: collision with root package name */
    private int f11164g;

    private PoiResult(PoiSearch.Query query, PoiSearch.SearchBound searchBound, List<String> list, List<SuggestionCity> list2, int i4, int i5, ArrayList<PoiItem> arrayList) {
        this.f11159b = new ArrayList<>();
        this.f11160c = query;
        this.f11161d = searchBound;
        this.f11162e = list;
        this.f11163f = list2;
        this.f11164g = i4;
        this.f11158a = a(i5);
        this.f11159b = arrayList;
    }

    private int a(int i4) {
        int i5 = this.f11164g;
        return ((i4 + i5) - 1) / i5;
    }

    public static PoiResult createPagedResult(PoiSearch.Query query, PoiSearch.SearchBound searchBound, List<String> list, List<SuggestionCity> list2, int i4, int i5, ArrayList<PoiItem> arrayList) {
        return new PoiResult(query, searchBound, list, list2, i4, i5, arrayList);
    }

    public final PoiSearch.SearchBound getBound() {
        return this.f11161d;
    }

    public final int getPageCount() {
        return this.f11158a;
    }

    public final ArrayList<PoiItem> getPois() {
        return this.f11159b;
    }

    public final PoiSearch.Query getQuery() {
        return this.f11160c;
    }

    public final List<SuggestionCity> getSearchSuggestionCitys() {
        return this.f11163f;
    }

    public final List<String> getSearchSuggestionKeywords() {
        return this.f11162e;
    }
}
