package com.amap.api.services.poisearch;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class Business implements Parcelable {
    public static final Parcelable.Creator<Business> CREATOR = new Parcelable.Creator<Business>() { // from class: com.amap.api.services.poisearch.Business.1
        /* renamed from: a */
        private static Business m51865a(Parcel parcel) {
            return new Business(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ Business createFromParcel(Parcel parcel) {
            return m51865a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ Business[] newArray(int i) {
            return m51866a(i);
        }

        /* renamed from: a */
        private static Business[] m51866a(int i) {
            return new Business[i];
        }
    };

    /* renamed from: a */
    private String f7439a;

    /* renamed from: b */
    private String f7440b;

    /* renamed from: c */
    private String f7441c;

    /* renamed from: d */
    private String f7442d;

    /* renamed from: e */
    private String f7443e;

    /* renamed from: f */
    private String f7444f;

    /* renamed from: g */
    private String f7445g;

    /* renamed from: h */
    private String f7446h;

    /* renamed from: i */
    private String f7447i;

    /* renamed from: j */
    private String f7448j;

    public Business(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        this.f7439a = str;
        this.f7440b = str2;
        this.f7441c = str3;
        this.f7442d = str4;
        this.f7443e = str5;
        this.f7444f = str6;
        this.f7445g = str7;
        this.f7446h = str8;
        this.f7447i = str9;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAlias() {
        return this.f7447i;
    }

    public String getBusinessArea() {
        return this.f7439a;
    }

    public String getCPID() {
        return this.f7448j;
    }

    public String getCost() {
        return this.f7445g;
    }

    public String getOpentimeToday() {
        return this.f7440b;
    }

    public String getOpentimeWeek() {
        return this.f7441c;
    }

    public String getParkingType() {
        return this.f7446h;
    }

    public String getTag() {
        return this.f7443e;
    }

    public String getTel() {
        return this.f7442d;
    }

    public String getmRating() {
        return this.f7444f;
    }

    public void setCPID(String str) {
        this.f7448j = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f7439a);
        parcel.writeString(this.f7440b);
        parcel.writeString(this.f7441c);
        parcel.writeString(this.f7442d);
        parcel.writeString(this.f7443e);
        parcel.writeString(this.f7444f);
        parcel.writeString(this.f7445g);
        parcel.writeString(this.f7446h);
        parcel.writeString(this.f7447i);
        parcel.writeString(this.f7448j);
    }

    protected Business(Parcel parcel) {
        this.f7439a = parcel.readString();
        this.f7440b = parcel.readString();
        this.f7441c = parcel.readString();
        this.f7442d = parcel.readString();
        this.f7443e = parcel.readString();
        this.f7444f = parcel.readString();
        this.f7445g = parcel.readString();
        this.f7446h = parcel.readString();
        this.f7447i = parcel.readString();
        this.f7448j = parcel.readString();
    }
}
