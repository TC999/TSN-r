package com.amap.api.services.busline;

import android.content.Context;
import com.amap.api.col.s.j0;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.interfaces.IBusStationSearch;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class BusStationSearch {

    /* renamed from: a  reason: collision with root package name */
    private IBusStationSearch f10924a;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public interface OnBusStationSearchListener {
        void onBusStationSearched(BusStationResult busStationResult, int i4);
    }

    public BusStationSearch(Context context, BusStationQuery busStationQuery) throws AMapException {
        if (this.f10924a == null) {
            try {
                this.f10924a = new j0(context, busStationQuery);
            } catch (Exception e4) {
                e4.printStackTrace();
                if (e4 instanceof AMapException) {
                    throw ((AMapException) e4);
                }
            }
        }
    }

    public BusStationQuery getQuery() {
        IBusStationSearch iBusStationSearch = this.f10924a;
        if (iBusStationSearch != null) {
            return iBusStationSearch.getQuery();
        }
        return null;
    }

    public BusStationResult searchBusStation() throws AMapException {
        IBusStationSearch iBusStationSearch = this.f10924a;
        if (iBusStationSearch != null) {
            return iBusStationSearch.searchBusStation();
        }
        return null;
    }

    public void searchBusStationAsyn() {
        IBusStationSearch iBusStationSearch = this.f10924a;
        if (iBusStationSearch != null) {
            iBusStationSearch.searchBusStationAsyn();
        }
    }

    public void setOnBusStationSearchListener(OnBusStationSearchListener onBusStationSearchListener) {
        IBusStationSearch iBusStationSearch = this.f10924a;
        if (iBusStationSearch != null) {
            iBusStationSearch.setOnBusStationSearchListener(onBusStationSearchListener);
        }
    }

    public void setQuery(BusStationQuery busStationQuery) {
        IBusStationSearch iBusStationSearch = this.f10924a;
        if (iBusStationSearch != null) {
            iBusStationSearch.setQuery(busStationQuery);
        }
    }
}
