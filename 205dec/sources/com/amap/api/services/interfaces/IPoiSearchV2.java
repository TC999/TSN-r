package com.amap.api.services.interfaces;

import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.PoiItemV2;
import com.amap.api.services.poisearch.PoiResultV2;
import com.amap.api.services.poisearch.PoiSearchV2;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public interface IPoiSearchV2 {
    PoiSearchV2.SearchBound getBound();

    String getLanguage();

    PoiSearchV2.Query getQuery();

    PoiResultV2 searchPOI() throws AMapException;

    void searchPOIAsyn();

    PoiItemV2 searchPOIId(String str) throws AMapException;

    void searchPOIIdAsyn(String str);

    void setBound(PoiSearchV2.SearchBound searchBound);

    void setLanguage(String str);

    void setOnPoiSearchListener(PoiSearchV2.OnPoiSearchListener onPoiSearchListener);

    void setQuery(PoiSearchV2.Query query);
}
