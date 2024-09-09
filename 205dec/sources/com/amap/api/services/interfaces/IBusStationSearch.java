package com.amap.api.services.interfaces;

import com.amap.api.services.busline.BusStationQuery;
import com.amap.api.services.busline.BusStationResult;
import com.amap.api.services.busline.BusStationSearch;
import com.amap.api.services.core.AMapException;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public interface IBusStationSearch {
    BusStationQuery getQuery();

    BusStationResult searchBusStation() throws AMapException;

    void searchBusStationAsyn();

    void setOnBusStationSearchListener(BusStationSearch.OnBusStationSearchListener onBusStationSearchListener);

    void setQuery(BusStationQuery busStationQuery);
}
