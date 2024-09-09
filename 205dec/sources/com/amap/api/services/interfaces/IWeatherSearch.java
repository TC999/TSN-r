package com.amap.api.services.interfaces;

import com.amap.api.services.weather.WeatherSearch;
import com.amap.api.services.weather.WeatherSearchQuery;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public interface IWeatherSearch {
    WeatherSearchQuery getQuery();

    void searchWeatherAsyn();

    void setOnWeatherSearchListener(WeatherSearch.OnWeatherSearchListener onWeatherSearchListener);

    void setQuery(WeatherSearchQuery weatherSearchQuery);
}
