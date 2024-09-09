package com.amap.api.services.busline;

import com.amap.api.services.core.SuggestionCity;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class BusLineResult {

    /* renamed from: a  reason: collision with root package name */
    private int f10903a;

    /* renamed from: b  reason: collision with root package name */
    private ArrayList<BusLineItem> f10904b;

    /* renamed from: c  reason: collision with root package name */
    private BusLineQuery f10905c;

    /* renamed from: d  reason: collision with root package name */
    private List<String> f10906d;

    /* renamed from: e  reason: collision with root package name */
    private List<SuggestionCity> f10907e;

    private BusLineResult(BusLineQuery busLineQuery, int i4, List<SuggestionCity> list, List<String> list2, ArrayList<BusLineItem> arrayList) {
        this.f10904b = new ArrayList<>();
        this.f10906d = new ArrayList();
        this.f10907e = new ArrayList();
        this.f10905c = busLineQuery;
        this.f10903a = a(i4);
        this.f10907e = list;
        this.f10906d = list2;
        this.f10904b = arrayList;
    }

    private int a(int i4) {
        int pageSize = this.f10905c.getPageSize();
        int i5 = ((i4 + pageSize) - 1) / pageSize;
        if (i5 > 30) {
            return 30;
        }
        return i5;
    }

    public static BusLineResult createPagedResult(BusLineQuery busLineQuery, int i4, List<SuggestionCity> list, List<String> list2, ArrayList<BusLineItem> arrayList) {
        return new BusLineResult(busLineQuery, i4, list, list2, arrayList);
    }

    public final List<BusLineItem> getBusLines() {
        return this.f10904b;
    }

    public final int getPageCount() {
        return this.f10903a;
    }

    public final BusLineQuery getQuery() {
        return this.f10905c;
    }

    public final List<SuggestionCity> getSearchSuggestionCities() {
        return this.f10907e;
    }

    public final List<String> getSearchSuggestionKeywords() {
        return this.f10906d;
    }
}
