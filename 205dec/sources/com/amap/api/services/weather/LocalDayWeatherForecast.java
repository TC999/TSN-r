package com.amap.api.services.weather;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class LocalDayWeatherForecast implements Parcelable {
    public static final Parcelable.Creator<LocalDayWeatherForecast> CREATOR = new Parcelable.Creator<LocalDayWeatherForecast>() { // from class: com.amap.api.services.weather.LocalDayWeatherForecast.1
        private static LocalDayWeatherForecast a(Parcel parcel) {
            return new LocalDayWeatherForecast(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ LocalDayWeatherForecast createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ LocalDayWeatherForecast[] newArray(int i4) {
            return null;
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private String f11626a;

    /* renamed from: b  reason: collision with root package name */
    private String f11627b;

    /* renamed from: c  reason: collision with root package name */
    private String f11628c;

    /* renamed from: d  reason: collision with root package name */
    private String f11629d;

    /* renamed from: e  reason: collision with root package name */
    private String f11630e;

    /* renamed from: f  reason: collision with root package name */
    private String f11631f;

    /* renamed from: g  reason: collision with root package name */
    private String f11632g;

    /* renamed from: h  reason: collision with root package name */
    private String f11633h;

    /* renamed from: i  reason: collision with root package name */
    private String f11634i;

    /* renamed from: j  reason: collision with root package name */
    private String f11635j;

    public LocalDayWeatherForecast() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getDate() {
        return this.f11626a;
    }

    public String getDayTemp() {
        return this.f11630e;
    }

    public String getDayWeather() {
        return this.f11628c;
    }

    public String getDayWindDirection() {
        return this.f11632g;
    }

    public String getDayWindPower() {
        return this.f11634i;
    }

    public String getNightTemp() {
        return this.f11631f;
    }

    public String getNightWeather() {
        return this.f11629d;
    }

    public String getNightWindDirection() {
        return this.f11633h;
    }

    public String getNightWindPower() {
        return this.f11635j;
    }

    public String getWeek() {
        return this.f11627b;
    }

    public void setDate(String str) {
        this.f11626a = str;
    }

    public void setDayTemp(String str) {
        this.f11630e = str;
    }

    public void setDayWeather(String str) {
        this.f11628c = str;
    }

    public void setDayWindDirection(String str) {
        this.f11632g = str;
    }

    public void setDayWindPower(String str) {
        this.f11634i = str;
    }

    public void setNightTemp(String str) {
        this.f11631f = str;
    }

    public void setNightWeather(String str) {
        this.f11629d = str;
    }

    public void setNightWindDirection(String str) {
        this.f11633h = str;
    }

    public void setNightWindPower(String str) {
        this.f11635j = str;
    }

    public void setWeek(String str) {
        this.f11627b = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeString(this.f11626a);
        parcel.writeString(this.f11627b);
        parcel.writeString(this.f11628c);
        parcel.writeString(this.f11629d);
        parcel.writeString(this.f11630e);
        parcel.writeString(this.f11631f);
        parcel.writeString(this.f11632g);
        parcel.writeString(this.f11633h);
        parcel.writeString(this.f11634i);
        parcel.writeString(this.f11635j);
    }

    public LocalDayWeatherForecast(Parcel parcel) {
        this.f11626a = parcel.readString();
        this.f11627b = parcel.readString();
        this.f11628c = parcel.readString();
        this.f11629d = parcel.readString();
        this.f11630e = parcel.readString();
        this.f11631f = parcel.readString();
        this.f11632g = parcel.readString();
        this.f11633h = parcel.readString();
        this.f11634i = parcel.readString();
        this.f11635j = parcel.readString();
    }
}
