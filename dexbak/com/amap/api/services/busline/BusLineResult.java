package com.amap.api.services.busline;

import com.amap.api.services.core.SuggestionCity;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class BusLineResult {

    /* renamed from: a */
    private int f7207a;

    /* renamed from: b */
    private ArrayList<BusLineItem> f7208b;

    /* renamed from: c */
    private BusLineQuery f7209c;

    /* renamed from: d */
    private List<String> f7210d;

    /* renamed from: e */
    private List<SuggestionCity> f7211e;

    private BusLineResult(BusLineQuery busLineQuery, int i, List<SuggestionCity> list, List<String> list2, ArrayList<BusLineItem> arrayList) {
        this.f7208b = new ArrayList<>();
        this.f7210d = new ArrayList();
        this.f7211e = new ArrayList();
        this.f7209c = busLineQuery;
        this.f7207a = m51912a(i);
        this.f7211e = list;
        this.f7210d = list2;
        this.f7208b = arrayList;
    }

    /* renamed from: a */
    private int m51912a(int i) {
        int pageSize = this.f7209c.getPageSize();
        int i2 = ((i + pageSize) - 1) / pageSize;
        if (i2 > 30) {
            return 30;
        }
        return i2;
    }

    public static BusLineResult createPagedResult(BusLineQuery busLineQuery, int i, List<SuggestionCity> list, List<String> list2, ArrayList<BusLineItem> arrayList) {
        return new BusLineResult(busLineQuery, i, list, list2, arrayList);
    }

    public final List<BusLineItem> getBusLines() {
        return this.f7208b;
    }

    public final int getPageCount() {
        return this.f7207a;
    }

    public final BusLineQuery getQuery() {
        return this.f7209c;
    }

    public final List<SuggestionCity> getSearchSuggestionCities() {
        return this.f7211e;
    }

    public final List<String> getSearchSuggestionKeywords() {
        return this.f7210d;
    }
}
