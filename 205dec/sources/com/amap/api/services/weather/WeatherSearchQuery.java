package com.amap.api.services.weather;

import com.amap.api.col.s.j4;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class WeatherSearchQuery implements Cloneable {
    public static final int WEATHER_TYPE_FORECAST = 2;
    public static final int WEATHER_TYPE_LIVE = 1;

    /* renamed from: a  reason: collision with root package name */
    private String f11655a;

    /* renamed from: b  reason: collision with root package name */
    private int f11656b;

    public WeatherSearchQuery(String str, int i4) {
        this.f11655a = str;
        this.f11656b = i4;
    }

    public String getCity() {
        return this.f11655a;
    }

    public int getType() {
        return this.f11656b;
    }

    /* renamed from: clone */
    public WeatherSearchQuery m54clone() {
        try {
            super.clone();
        } catch (CloneNotSupportedException e4) {
            j4.i(e4, "WeatherSearchQuery", "clone");
        }
        return new WeatherSearchQuery(this.f11655a, this.f11656b);
    }

    public WeatherSearchQuery() {
        this.f11656b = 1;
    }
}
