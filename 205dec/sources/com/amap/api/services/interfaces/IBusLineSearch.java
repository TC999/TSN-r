package com.amap.api.services.interfaces;

import com.amap.api.services.busline.BusLineQuery;
import com.amap.api.services.busline.BusLineResult;
import com.amap.api.services.busline.BusLineSearch;
import com.amap.api.services.core.AMapException;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public interface IBusLineSearch {
    BusLineQuery getQuery();

    BusLineResult searchBusLine() throws AMapException;

    void searchBusLineAsyn();

    void setOnBusLineSearchListener(BusLineSearch.OnBusLineSearchListener onBusLineSearchListener);

    void setQuery(BusLineQuery busLineQuery);
}
