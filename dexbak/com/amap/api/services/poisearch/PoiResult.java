package com.amap.api.services.poisearch;

import com.amap.api.services.core.PoiItem;
import com.amap.api.services.core.SuggestionCity;
import com.amap.api.services.poisearch.PoiSearch;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class PoiResult {

    /* renamed from: a */
    private int f7464a;

    /* renamed from: b */
    private ArrayList<PoiItem> f7465b;

    /* renamed from: c */
    private PoiSearch.Query f7466c;

    /* renamed from: d */
    private PoiSearch.SearchBound f7467d;

    /* renamed from: e */
    private List<String> f7468e;

    /* renamed from: f */
    private List<SuggestionCity> f7469f;

    /* renamed from: g */
    private int f7470g;

    private PoiResult(PoiSearch.Query query, PoiSearch.SearchBound searchBound, List<String> list, List<SuggestionCity> list2, int i, int i2, ArrayList<PoiItem> arrayList) {
        this.f7465b = new ArrayList<>();
        this.f7466c = query;
        this.f7467d = searchBound;
        this.f7468e = list;
        this.f7469f = list2;
        this.f7470g = i;
        this.f7464a = m51856a(i2);
        this.f7465b = arrayList;
    }

    /* renamed from: a */
    private int m51856a(int i) {
        int i2 = this.f7470g;
        return ((i + i2) - 1) / i2;
    }

    public static PoiResult createPagedResult(PoiSearch.Query query, PoiSearch.SearchBound searchBound, List<String> list, List<SuggestionCity> list2, int i, int i2, ArrayList<PoiItem> arrayList) {
        return new PoiResult(query, searchBound, list, list2, i, i2, arrayList);
    }

    public final PoiSearch.SearchBound getBound() {
        return this.f7467d;
    }

    public final int getPageCount() {
        return this.f7464a;
    }

    public final ArrayList<PoiItem> getPois() {
        return this.f7465b;
    }

    public final PoiSearch.Query getQuery() {
        return this.f7466c;
    }

    public final List<SuggestionCity> getSearchSuggestionCitys() {
        return this.f7469f;
    }

    public final List<String> getSearchSuggestionKeywords() {
        return this.f7468e;
    }
}
