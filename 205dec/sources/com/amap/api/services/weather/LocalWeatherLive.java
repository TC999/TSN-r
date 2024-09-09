package com.amap.api.services.weather;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class LocalWeatherLive implements Parcelable {
    public static final Parcelable.Creator<LocalWeatherLive> CREATOR = new Parcelable.Creator<LocalWeatherLive>() { // from class: com.amap.api.services.weather.LocalWeatherLive.1
        private static LocalWeatherLive a(Parcel parcel) {
            return new LocalWeatherLive(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ LocalWeatherLive createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ LocalWeatherLive[] newArray(int i4) {
            return null;
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private String f11643a;

    /* renamed from: b  reason: collision with root package name */
    private String f11644b;

    /* renamed from: c  reason: collision with root package name */
    private String f11645c;

    /* renamed from: d  reason: collision with root package name */
    private String f11646d;

    /* renamed from: e  reason: collision with root package name */
    private String f11647e;

    /* renamed from: f  reason: collision with root package name */
    private String f11648f;

    /* renamed from: g  reason: collision with root package name */
    private String f11649g;

    /* renamed from: h  reason: collision with root package name */
    private String f11650h;

    /* renamed from: i  reason: collision with root package name */
    private String f11651i;

    public LocalWeatherLive() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAdCode() {
        return this.f11645c;
    }

    public String getCity() {
        return this.f11644b;
    }

    public String getHumidity() {
        return this.f11650h;
    }

    public String getProvince() {
        return this.f11643a;
    }

    public String getReportTime() {
        return this.f11651i;
    }

    public String getTemperature() {
        return this.f11647e;
    }

    public String getWeather() {
        return this.f11646d;
    }

    public String getWindDirection() {
        return this.f11648f;
    }

    public String getWindPower() {
        return this.f11649g;
    }

    public void setAdCode(String str) {
        this.f11645c = str;
    }

    public void setCity(String str) {
        this.f11644b = str;
    }

    public void setHumidity(String str) {
        this.f11650h = str;
    }

    public void setProvince(String str) {
        this.f11643a = str;
    }

    public void setReportTime(String str) {
        this.f11651i = str;
    }

    public void setTemperature(String str) {
        this.f11647e = str;
    }

    public void setWeather(String str) {
        this.f11646d = str;
    }

    public void setWindDirection(String str) {
        this.f11648f = str;
    }

    public void setWindPower(String str) {
        this.f11649g = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeString(this.f11643a);
        parcel.writeString(this.f11644b);
        parcel.writeString(this.f11645c);
        parcel.writeString(this.f11646d);
        parcel.writeString(this.f11647e);
        parcel.writeString(this.f11648f);
        parcel.writeString(this.f11649g);
        parcel.writeString(this.f11650h);
        parcel.writeString(this.f11651i);
    }

    public LocalWeatherLive(Parcel parcel) {
        this.f11643a = parcel.readString();
        this.f11644b = parcel.readString();
        this.f11645c = parcel.readString();
        this.f11646d = parcel.readString();
        this.f11647e = parcel.readString();
        this.f11648f = parcel.readString();
        this.f11649g = parcel.readString();
        this.f11650h = parcel.readString();
        this.f11651i = parcel.readString();
    }
}
