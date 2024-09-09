package com.amap.api.services.weather;

import android.content.Context;
import com.amap.api.col.s.w0;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.interfaces.IWeatherSearch;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class WeatherSearch {

    /* renamed from: a  reason: collision with root package name */
    private IWeatherSearch f11654a;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public interface OnWeatherSearchListener {
        void onWeatherForecastSearched(LocalWeatherForecastResult localWeatherForecastResult, int i4);

        void onWeatherLiveSearched(LocalWeatherLiveResult localWeatherLiveResult, int i4);
    }

    public WeatherSearch(Context context) throws AMapException {
        this.f11654a = null;
        try {
            this.f11654a = new w0(context);
        } catch (Exception e4) {
            e4.printStackTrace();
            if (e4 instanceof AMapException) {
                throw ((AMapException) e4);
            }
        }
    }

    public WeatherSearchQuery getQuery() {
        IWeatherSearch iWeatherSearch = this.f11654a;
        if (iWeatherSearch != null) {
            return iWeatherSearch.getQuery();
        }
        return null;
    }

    public void searchWeatherAsyn() {
        IWeatherSearch iWeatherSearch = this.f11654a;
        if (iWeatherSearch != null) {
            iWeatherSearch.searchWeatherAsyn();
        }
    }

    public void setOnWeatherSearchListener(OnWeatherSearchListener onWeatherSearchListener) {
        IWeatherSearch iWeatherSearch = this.f11654a;
        if (iWeatherSearch != null) {
            iWeatherSearch.setOnWeatherSearchListener(onWeatherSearchListener);
        }
    }

    public void setQuery(WeatherSearchQuery weatherSearchQuery) {
        IWeatherSearch iWeatherSearch = this.f11654a;
        if (iWeatherSearch != null) {
            iWeatherSearch.setQuery(weatherSearchQuery);
        }
    }
}
