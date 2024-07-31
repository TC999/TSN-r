package com.amap.api.services.weather;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class LocalWeatherLiveResult {

    /* renamed from: a */
    private WeatherSearchQuery f7958a;

    /* renamed from: b */
    private LocalWeatherLive f7959b;

    private LocalWeatherLiveResult(WeatherSearchQuery weatherSearchQuery, LocalWeatherLive localWeatherLive) {
        this.f7958a = weatherSearchQuery;
        this.f7959b = localWeatherLive;
    }

    public static LocalWeatherLiveResult createPagedResult(WeatherSearchQuery weatherSearchQuery, LocalWeatherLive localWeatherLive) {
        return new LocalWeatherLiveResult(weatherSearchQuery, localWeatherLive);
    }

    public LocalWeatherLive getLiveResult() {
        return this.f7959b;
    }

    public WeatherSearchQuery getWeatherLiveQuery() {
        return this.f7958a;
    }
}
