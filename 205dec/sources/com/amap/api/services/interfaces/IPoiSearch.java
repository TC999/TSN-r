package com.amap.api.services.interfaces;

import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.poisearch.PoiResult;
import com.amap.api.services.poisearch.PoiSearch;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public interface IPoiSearch {
    PoiSearch.SearchBound getBound();

    String getLanguage();

    PoiSearch.Query getQuery();

    PoiResult searchPOI() throws AMapException;

    void searchPOIAsyn();

    PoiItem searchPOIId(String str) throws AMapException;

    void searchPOIIdAsyn(String str);

    void setBound(PoiSearch.SearchBound searchBound);

    void setLanguage(String str);

    void setOnPoiSearchListener(PoiSearch.OnPoiSearchListener onPoiSearchListener);

    void setQuery(PoiSearch.Query query);
}
