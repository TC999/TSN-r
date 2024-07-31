package com.amap.api.services.weather;

import com.amap.api.col.p047s.C2082j4;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class WeatherSearchQuery implements Cloneable {
    public static final int WEATHER_TYPE_FORECAST = 2;
    public static final int WEATHER_TYPE_LIVE = 1;

    /* renamed from: a */
    private String f7961a;

    /* renamed from: b */
    private int f7962b;

    public WeatherSearchQuery(String str, int i) {
        this.f7961a = str;
        this.f7962b = i;
    }

    public String getCity() {
        return this.f7961a;
    }

    public int getType() {
        return this.f7962b;
    }

    /* renamed from: clone */
    public WeatherSearchQuery m60133clone() {
        try {
            super.clone();
        } catch (CloneNotSupportedException e) {
            C2082j4.m52825i(e, "WeatherSearchQuery", "clone");
        }
        return new WeatherSearchQuery(this.f7961a, this.f7962b);
    }

    public WeatherSearchQuery() {
        this.f7962b = 1;
    }
}
