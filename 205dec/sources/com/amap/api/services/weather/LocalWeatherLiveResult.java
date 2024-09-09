package com.amap.api.services.weather;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class LocalWeatherLiveResult {

    /* renamed from: a  reason: collision with root package name */
    private WeatherSearchQuery f11652a;

    /* renamed from: b  reason: collision with root package name */
    private LocalWeatherLive f11653b;

    private LocalWeatherLiveResult(WeatherSearchQuery weatherSearchQuery, LocalWeatherLive localWeatherLive) {
        this.f11652a = weatherSearchQuery;
        this.f11653b = localWeatherLive;
    }

    public static LocalWeatherLiveResult createPagedResult(WeatherSearchQuery weatherSearchQuery, LocalWeatherLive localWeatherLive) {
        return new LocalWeatherLiveResult(weatherSearchQuery, localWeatherLive);
    }

    public LocalWeatherLive getLiveResult() {
        return this.f11653b;
    }

    public WeatherSearchQuery getWeatherLiveQuery() {
        return this.f11652a;
    }
}
