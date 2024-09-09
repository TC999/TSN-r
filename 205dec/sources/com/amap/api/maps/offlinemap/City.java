package com.amap.api.maps.offlinemap;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class City implements Parcelable {
    public static final Parcelable.Creator<City> CREATOR = new Parcelable.Creator<City>() { // from class: com.amap.api.maps.offlinemap.City.1
        private static City a(Parcel parcel) {
            return new City(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ City createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ City[] newArray(int i4) {
            return a(i4);
        }

        private static City[] a(int i4) {
            return new City[i4];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private String f10787a;

    /* renamed from: b  reason: collision with root package name */
    private String f10788b;

    /* renamed from: c  reason: collision with root package name */
    private String f10789c;

    /* renamed from: d  reason: collision with root package name */
    private String f10790d;

    /* renamed from: e  reason: collision with root package name */
    private String f10791e;

    public City() {
        this.f10787a = "";
        this.f10788b = "";
        this.f10791e = "";
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAdcode() {
        return this.f10791e;
    }

    public String getCity() {
        return this.f10787a;
    }

    public String getCode() {
        return this.f10788b;
    }

    public String getJianpin() {
        return this.f10789c;
    }

    public String getPinyin() {
        return this.f10790d;
    }

    public void setAdcode(String str) {
        this.f10791e = str;
    }

    public void setCity(String str) {
        this.f10787a = str;
    }

    public void setCode(String str) {
        if (str == null || "[]".equals(str)) {
            return;
        }
        this.f10788b = str;
    }

    public void setJianpin(String str) {
        this.f10789c = str;
    }

    public void setPinyin(String str) {
        this.f10790d = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeString(this.f10787a);
        parcel.writeString(this.f10788b);
        parcel.writeString(this.f10789c);
        parcel.writeString(this.f10790d);
        parcel.writeString(this.f10791e);
    }

    public City(Parcel parcel) {
        this.f10787a = "";
        this.f10788b = "";
        this.f10791e = "";
        this.f10787a = parcel.readString();
        this.f10788b = parcel.readString();
        this.f10789c = parcel.readString();
        this.f10790d = parcel.readString();
        this.f10791e = parcel.readString();
    }
}
