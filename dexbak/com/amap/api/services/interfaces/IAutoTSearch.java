package com.amap.api.services.interfaces;

import com.amap.api.services.auto.AutoTChargeStationResult;
import com.amap.api.services.auto.AutoTSearch;
import com.amap.api.services.core.AMapException;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public interface IAutoTSearch {
    AutoTChargeStationResult searchChargeStation() throws AMapException;

    void searchChargeStationAsync() throws AMapException;

    void setChargeStationListener(AutoTSearch.OnChargeStationListener onChargeStationListener);

    void setQuery(AutoTSearch.Query query);
}
