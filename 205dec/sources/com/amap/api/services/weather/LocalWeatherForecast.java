package com.amap.api.services.weather;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class LocalWeatherForecast implements Parcelable {
    public static final Parcelable.Creator<LocalWeatherForecast> CREATOR = new Parcelable.Creator<LocalWeatherForecast>() { // from class: com.amap.api.services.weather.LocalWeatherForecast.1
        private static LocalWeatherForecast a(Parcel parcel) {
            return new LocalWeatherForecast(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ LocalWeatherForecast createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ LocalWeatherForecast[] newArray(int i4) {
            return null;
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private String f11636a;

    /* renamed from: b  reason: collision with root package name */
    private String f11637b;

    /* renamed from: c  reason: collision with root package name */
    private String f11638c;

    /* renamed from: d  reason: collision with root package name */
    private String f11639d;

    /* renamed from: e  reason: collision with root package name */
    private List<LocalDayWeatherForecast> f11640e;

    public LocalWeatherForecast() {
        this.f11640e = new ArrayList();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAdCode() {
        return this.f11638c;
    }

    public String getCity() {
        return this.f11637b;
    }

    public String getProvince() {
        return this.f11636a;
    }

    public String getReportTime() {
        return this.f11639d;
    }

    public List<LocalDayWeatherForecast> getWeatherForecast() {
        return this.f11640e;
    }

    public void setAdCode(String str) {
        this.f11638c = str;
    }

    public void setCity(String str) {
        this.f11637b = str;
    }

    public void setProvince(String str) {
        this.f11636a = str;
    }

    public void setReportTime(String str) {
        this.f11639d = str;
    }

    public void setWeatherForecast(List<LocalDayWeatherForecast> list) {
        this.f11640e = list;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeString(this.f11636a);
        parcel.writeString(this.f11637b);
        parcel.writeString(this.f11638c);
        parcel.writeString(this.f11639d);
        parcel.writeList(this.f11640e);
    }

    public LocalWeatherForecast(Parcel parcel) {
        this.f11640e = new ArrayList();
        this.f11636a = parcel.readString();
        this.f11637b = parcel.readString();
        this.f11638c = parcel.readString();
        this.f11639d = parcel.readString();
        this.f11640e = parcel.readArrayList(LocalWeatherForecast.class.getClassLoader());
    }
}
