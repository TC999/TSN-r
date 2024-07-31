package com.amap.api.maps.offlinemap;

import android.os.Parcel;
import android.os.Parcelable;
import okhttp3.HttpUrl;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class City implements Parcelable {
    public static final Parcelable.Creator<City> CREATOR = new Parcelable.Creator<City>() { // from class: com.amap.api.maps.offlinemap.City.1
        /* renamed from: a */
        private static City m52001a(Parcel parcel) {
            return new City(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ City createFromParcel(Parcel parcel) {
            return m52001a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ City[] newArray(int i) {
            return m52002a(i);
        }

        /* renamed from: a */
        private static City[] m52002a(int i) {
            return new City[i];
        }
    };

    /* renamed from: a */
    private String f7089a;

    /* renamed from: b */
    private String f7090b;

    /* renamed from: c */
    private String f7091c;

    /* renamed from: d */
    private String f7092d;

    /* renamed from: e */
    private String f7093e;

    public City() {
        this.f7089a = "";
        this.f7090b = "";
        this.f7093e = "";
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAdcode() {
        return this.f7093e;
    }

    public String getCity() {
        return this.f7089a;
    }

    public String getCode() {
        return this.f7090b;
    }

    public String getJianpin() {
        return this.f7091c;
    }

    public String getPinyin() {
        return this.f7092d;
    }

    public void setAdcode(String str) {
        this.f7093e = str;
    }

    public void setCity(String str) {
        this.f7089a = str;
    }

    public void setCode(String str) {
        if (str == null || HttpUrl.PATH_SEGMENT_ENCODE_SET_URI.equals(str)) {
            return;
        }
        this.f7090b = str;
    }

    public void setJianpin(String str) {
        this.f7091c = str;
    }

    public void setPinyin(String str) {
        this.f7092d = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f7089a);
        parcel.writeString(this.f7090b);
        parcel.writeString(this.f7091c);
        parcel.writeString(this.f7092d);
        parcel.writeString(this.f7093e);
    }

    public City(Parcel parcel) {
        this.f7089a = "";
        this.f7090b = "";
        this.f7093e = "";
        this.f7089a = parcel.readString();
        this.f7090b = parcel.readString();
        this.f7091c = parcel.readString();
        this.f7092d = parcel.readString();
        this.f7093e = parcel.readString();
    }
}
