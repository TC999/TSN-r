package com.amap.api.services.busline;

import com.amap.api.services.core.SuggestionCity;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class BusStationResult {

    /* renamed from: a */
    private int f7223a;

    /* renamed from: b */
    private ArrayList<BusStationItem> f7224b;

    /* renamed from: c */
    private BusStationQuery f7225c;

    /* renamed from: d */
    private List<String> f7226d;

    /* renamed from: e */
    private List<SuggestionCity> f7227e;

    private BusStationResult(BusStationQuery busStationQuery, int i, List<SuggestionCity> list, List<String> list2, ArrayList<BusStationItem> arrayList) {
        this.f7224b = new ArrayList<>();
        this.f7226d = new ArrayList();
        this.f7227e = new ArrayList();
        this.f7225c = busStationQuery;
        this.f7223a = m51908a(i);
        this.f7227e = list;
        this.f7226d = list2;
        this.f7224b = arrayList;
    }

    /* renamed from: a */
    private int m51908a(int i) {
        int pageSize = this.f7225c.getPageSize();
        int i2 = ((i + pageSize) - 1) / pageSize;
        if (i2 > 30) {
            return 30;
        }
        return i2;
    }

    public static BusStationResult createPagedResult(BusStationQuery busStationQuery, int i, List<SuggestionCity> list, List<String> list2, ArrayList<BusStationItem> arrayList) {
        return new BusStationResult(busStationQuery, i, list, list2, arrayList);
    }

    public final List<BusStationItem> getBusStations() {
        return this.f7224b;
    }

    public final int getPageCount() {
        return this.f7223a;
    }

    public final BusStationQuery getQuery() {
        return this.f7225c;
    }

    public final List<SuggestionCity> getSearchSuggestionCities() {
        return this.f7227e;
    }

    public final List<String> getSearchSuggestionKeywords() {
        return this.f7226d;
    }
}
