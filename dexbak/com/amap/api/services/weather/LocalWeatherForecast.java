package com.amap.api.services.weather;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class LocalWeatherForecast implements Parcelable {
    public static final Parcelable.Creator<LocalWeatherForecast> CREATOR = new Parcelable.Creator<LocalWeatherForecast>() { // from class: com.amap.api.services.weather.LocalWeatherForecast.1
        /* renamed from: a */
        private static LocalWeatherForecast m51743a(Parcel parcel) {
            return new LocalWeatherForecast(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ LocalWeatherForecast createFromParcel(Parcel parcel) {
            return m51743a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ LocalWeatherForecast[] newArray(int i) {
            return null;
        }
    };

    /* renamed from: a */
    private String f7942a;

    /* renamed from: b */
    private String f7943b;

    /* renamed from: c */
    private String f7944c;

    /* renamed from: d */
    private String f7945d;

    /* renamed from: e */
    private List<LocalDayWeatherForecast> f7946e;

    public LocalWeatherForecast() {
        this.f7946e = new ArrayList();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAdCode() {
        return this.f7944c;
    }

    public String getCity() {
        return this.f7943b;
    }

    public String getProvince() {
        return this.f7942a;
    }

    public String getReportTime() {
        return this.f7945d;
    }

    public List<LocalDayWeatherForecast> getWeatherForecast() {
        return this.f7946e;
    }

    public void setAdCode(String str) {
        this.f7944c = str;
    }

    public void setCity(String str) {
        this.f7943b = str;
    }

    public void setProvince(String str) {
        this.f7942a = str;
    }

    public void setReportTime(String str) {
        this.f7945d = str;
    }

    public void setWeatherForecast(List<LocalDayWeatherForecast> list) {
        this.f7946e = list;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f7942a);
        parcel.writeString(this.f7943b);
        parcel.writeString(this.f7944c);
        parcel.writeString(this.f7945d);
        parcel.writeList(this.f7946e);
    }

    public LocalWeatherForecast(Parcel parcel) {
        this.f7946e = new ArrayList();
        this.f7942a = parcel.readString();
        this.f7943b = parcel.readString();
        this.f7944c = parcel.readString();
        this.f7945d = parcel.readString();
        this.f7946e = parcel.readArrayList(LocalWeatherForecast.class.getClassLoader());
    }
}
