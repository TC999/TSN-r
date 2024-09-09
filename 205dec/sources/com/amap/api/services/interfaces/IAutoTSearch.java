package com.amap.api.services.interfaces;

import com.amap.api.services.auto.AutoTChargeStationResult;
import com.amap.api.services.auto.AutoTSearch;
import com.amap.api.services.core.AMapException;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public interface IAutoTSearch {
    AutoTChargeStationResult searchChargeStation() throws AMapException;

    void searchChargeStationAsync() throws AMapException;

    void setChargeStationListener(AutoTSearch.OnChargeStationListener onChargeStationListener);

    void setQuery(AutoTSearch.Query query);
}
