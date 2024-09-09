package com.amap.api.services.weather;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class LocalWeatherForecastResult {

    /* renamed from: a  reason: collision with root package name */
    private WeatherSearchQuery f11641a;

    /* renamed from: b  reason: collision with root package name */
    private LocalWeatherForecast f11642b;

    private LocalWeatherForecastResult(WeatherSearchQuery weatherSearchQuery, LocalWeatherForecast localWeatherForecast) {
        this.f11641a = weatherSearchQuery;
        this.f11642b = localWeatherForecast;
    }

    public static LocalWeatherForecastResult createPagedResult(WeatherSearchQuery weatherSearchQuery, LocalWeatherForecast localWeatherForecast) {
        return new LocalWeatherForecastResult(weatherSearchQuery, localWeatherForecast);
    }

    public LocalWeatherForecast getForecastResult() {
        return this.f11642b;
    }

    public WeatherSearchQuery getWeatherForecastQuery() {
        return this.f11641a;
    }
}
