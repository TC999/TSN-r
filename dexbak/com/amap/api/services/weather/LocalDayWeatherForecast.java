package com.amap.api.services.weather;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class LocalDayWeatherForecast implements Parcelable {
    public static final Parcelable.Creator<LocalDayWeatherForecast> CREATOR = new Parcelable.Creator<LocalDayWeatherForecast>() { // from class: com.amap.api.services.weather.LocalDayWeatherForecast.1
        /* renamed from: a */
        private static LocalDayWeatherForecast m51744a(Parcel parcel) {
            return new LocalDayWeatherForecast(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ LocalDayWeatherForecast createFromParcel(Parcel parcel) {
            return m51744a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ LocalDayWeatherForecast[] newArray(int i) {
            return null;
        }
    };

    /* renamed from: a */
    private String f7932a;

    /* renamed from: b */
    private String f7933b;

    /* renamed from: c */
    private String f7934c;

    /* renamed from: d */
    private String f7935d;

    /* renamed from: e */
    private String f7936e;

    /* renamed from: f */
    private String f7937f;

    /* renamed from: g */
    private String f7938g;

    /* renamed from: h */
    private String f7939h;

    /* renamed from: i */
    private String f7940i;

    /* renamed from: j */
    private String f7941j;

    public LocalDayWeatherForecast() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getDate() {
        return this.f7932a;
    }

    public String getDayTemp() {
        return this.f7936e;
    }

    public String getDayWeather() {
        return this.f7934c;
    }

    public String getDayWindDirection() {
        return this.f7938g;
    }

    public String getDayWindPower() {
        return this.f7940i;
    }

    public String getNightTemp() {
        return this.f7937f;
    }

    public String getNightWeather() {
        return this.f7935d;
    }

    public String getNightWindDirection() {
        return this.f7939h;
    }

    public String getNightWindPower() {
        return this.f7941j;
    }

    public String getWeek() {
        return this.f7933b;
    }

    public void setDate(String str) {
        this.f7932a = str;
    }

    public void setDayTemp(String str) {
        this.f7936e = str;
    }

    public void setDayWeather(String str) {
        this.f7934c = str;
    }

    public void setDayWindDirection(String str) {
        this.f7938g = str;
    }

    public void setDayWindPower(String str) {
        this.f7940i = str;
    }

    public void setNightTemp(String str) {
        this.f7937f = str;
    }

    public void setNightWeather(String str) {
        this.f7935d = str;
    }

    public void setNightWindDirection(String str) {
        this.f7939h = str;
    }

    public void setNightWindPower(String str) {
        this.f7941j = str;
    }

    public void setWeek(String str) {
        this.f7933b = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f7932a);
        parcel.writeString(this.f7933b);
        parcel.writeString(this.f7934c);
        parcel.writeString(this.f7935d);
        parcel.writeString(this.f7936e);
        parcel.writeString(this.f7937f);
        parcel.writeString(this.f7938g);
        parcel.writeString(this.f7939h);
        parcel.writeString(this.f7940i);
        parcel.writeString(this.f7941j);
    }

    public LocalDayWeatherForecast(Parcel parcel) {
        this.f7932a = parcel.readString();
        this.f7933b = parcel.readString();
        this.f7934c = parcel.readString();
        this.f7935d = parcel.readString();
        this.f7936e = parcel.readString();
        this.f7937f = parcel.readString();
        this.f7938g = parcel.readString();
        this.f7939h = parcel.readString();
        this.f7940i = parcel.readString();
        this.f7941j = parcel.readString();
    }
}
