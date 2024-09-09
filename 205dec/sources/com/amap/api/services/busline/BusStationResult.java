package com.amap.api.services.busline;

import com.amap.api.services.core.SuggestionCity;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class BusStationResult {

    /* renamed from: a  reason: collision with root package name */
    private int f10919a;

    /* renamed from: b  reason: collision with root package name */
    private ArrayList<BusStationItem> f10920b;

    /* renamed from: c  reason: collision with root package name */
    private BusStationQuery f10921c;

    /* renamed from: d  reason: collision with root package name */
    private List<String> f10922d;

    /* renamed from: e  reason: collision with root package name */
    private List<SuggestionCity> f10923e;

    private BusStationResult(BusStationQuery busStationQuery, int i4, List<SuggestionCity> list, List<String> list2, ArrayList<BusStationItem> arrayList) {
        this.f10920b = new ArrayList<>();
        this.f10922d = new ArrayList();
        this.f10923e = new ArrayList();
        this.f10921c = busStationQuery;
        this.f10919a = a(i4);
        this.f10923e = list;
        this.f10922d = list2;
        this.f10920b = arrayList;
    }

    private int a(int i4) {
        int pageSize = this.f10921c.getPageSize();
        int i5 = ((i4 + pageSize) - 1) / pageSize;
        if (i5 > 30) {
            return 30;
        }
        return i5;
    }

    public static BusStationResult createPagedResult(BusStationQuery busStationQuery, int i4, List<SuggestionCity> list, List<String> list2, ArrayList<BusStationItem> arrayList) {
        return new BusStationResult(busStationQuery, i4, list, list2, arrayList);
    }

    public final List<BusStationItem> getBusStations() {
        return this.f10920b;
    }

    public final int getPageCount() {
        return this.f10919a;
    }

    public final BusStationQuery getQuery() {
        return this.f10921c;
    }

    public final List<SuggestionCity> getSearchSuggestionCities() {
        return this.f10923e;
    }

    public final List<String> getSearchSuggestionKeywords() {
        return this.f10922d;
    }
}
