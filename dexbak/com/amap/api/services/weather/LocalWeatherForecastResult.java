package com.amap.api.services.weather;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class LocalWeatherForecastResult {

    /* renamed from: a */
    private WeatherSearchQuery f7947a;

    /* renamed from: b */
    private LocalWeatherForecast f7948b;

    private LocalWeatherForecastResult(WeatherSearchQuery weatherSearchQuery, LocalWeatherForecast localWeatherForecast) {
        this.f7947a = weatherSearchQuery;
        this.f7948b = localWeatherForecast;
    }

    public static LocalWeatherForecastResult createPagedResult(WeatherSearchQuery weatherSearchQuery, LocalWeatherForecast localWeatherForecast) {
        return new LocalWeatherForecastResult(weatherSearchQuery, localWeatherForecast);
    }

    public LocalWeatherForecast getForecastResult() {
        return this.f7948b;
    }

    public WeatherSearchQuery getWeatherForecastQuery() {
        return this.f7947a;
    }
}
