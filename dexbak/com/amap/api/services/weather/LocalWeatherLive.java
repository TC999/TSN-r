package com.amap.api.services.weather;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class LocalWeatherLive implements Parcelable {
    public static final Parcelable.Creator<LocalWeatherLive> CREATOR = new Parcelable.Creator<LocalWeatherLive>() { // from class: com.amap.api.services.weather.LocalWeatherLive.1
        /* renamed from: a */
        private static LocalWeatherLive m51742a(Parcel parcel) {
            return new LocalWeatherLive(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ LocalWeatherLive createFromParcel(Parcel parcel) {
            return m51742a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ LocalWeatherLive[] newArray(int i) {
            return null;
        }
    };

    /* renamed from: a */
    private String f7949a;

    /* renamed from: b */
    private String f7950b;

    /* renamed from: c */
    private String f7951c;

    /* renamed from: d */
    private String f7952d;

    /* renamed from: e */
    private String f7953e;

    /* renamed from: f */
    private String f7954f;

    /* renamed from: g */
    private String f7955g;

    /* renamed from: h */
    private String f7956h;

    /* renamed from: i */
    private String f7957i;

    public LocalWeatherLive() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAdCode() {
        return this.f7951c;
    }

    public String getCity() {
        return this.f7950b;
    }

    public String getHumidity() {
        return this.f7956h;
    }

    public String getProvince() {
        return this.f7949a;
    }

    public String getReportTime() {
        return this.f7957i;
    }

    public String getTemperature() {
        return this.f7953e;
    }

    public String getWeather() {
        return this.f7952d;
    }

    public String getWindDirection() {
        return this.f7954f;
    }

    public String getWindPower() {
        return this.f7955g;
    }

    public void setAdCode(String str) {
        this.f7951c = str;
    }

    public void setCity(String str) {
        this.f7950b = str;
    }

    public void setHumidity(String str) {
        this.f7956h = str;
    }

    public void setProvince(String str) {
        this.f7949a = str;
    }

    public void setReportTime(String str) {
        this.f7957i = str;
    }

    public void setTemperature(String str) {
        this.f7953e = str;
    }

    public void setWeather(String str) {
        this.f7952d = str;
    }

    public void setWindDirection(String str) {
        this.f7954f = str;
    }

    public void setWindPower(String str) {
        this.f7955g = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f7949a);
        parcel.writeString(this.f7950b);
        parcel.writeString(this.f7951c);
        parcel.writeString(this.f7952d);
        parcel.writeString(this.f7953e);
        parcel.writeString(this.f7954f);
        parcel.writeString(this.f7955g);
        parcel.writeString(this.f7956h);
        parcel.writeString(this.f7957i);
    }

    public LocalWeatherLive(Parcel parcel) {
        this.f7949a = parcel.readString();
        this.f7950b = parcel.readString();
        this.f7951c = parcel.readString();
        this.f7952d = parcel.readString();
        this.f7953e = parcel.readString();
        this.f7954f = parcel.readString();
        this.f7955g = parcel.readString();
        this.f7956h = parcel.readString();
        this.f7957i = parcel.readString();
    }
}
