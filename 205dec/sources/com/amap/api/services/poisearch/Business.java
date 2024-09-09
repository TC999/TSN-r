package com.amap.api.services.poisearch;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class Business implements Parcelable {
    public static final Parcelable.Creator<Business> CREATOR = new Parcelable.Creator<Business>() { // from class: com.amap.api.services.poisearch.Business.1
        private static Business a(Parcel parcel) {
            return new Business(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ Business createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ Business[] newArray(int i4) {
            return a(i4);
        }

        private static Business[] a(int i4) {
            return new Business[i4];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private String f11133a;

    /* renamed from: b  reason: collision with root package name */
    private String f11134b;

    /* renamed from: c  reason: collision with root package name */
    private String f11135c;

    /* renamed from: d  reason: collision with root package name */
    private String f11136d;

    /* renamed from: e  reason: collision with root package name */
    private String f11137e;

    /* renamed from: f  reason: collision with root package name */
    private String f11138f;

    /* renamed from: g  reason: collision with root package name */
    private String f11139g;

    /* renamed from: h  reason: collision with root package name */
    private String f11140h;

    /* renamed from: i  reason: collision with root package name */
    private String f11141i;

    /* renamed from: j  reason: collision with root package name */
    private String f11142j;

    public Business(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        this.f11133a = str;
        this.f11134b = str2;
        this.f11135c = str3;
        this.f11136d = str4;
        this.f11137e = str5;
        this.f11138f = str6;
        this.f11139g = str7;
        this.f11140h = str8;
        this.f11141i = str9;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAlias() {
        return this.f11141i;
    }

    public String getBusinessArea() {
        return this.f11133a;
    }

    public String getCPID() {
        return this.f11142j;
    }

    public String getCost() {
        return this.f11139g;
    }

    public String getOpentimeToday() {
        return this.f11134b;
    }

    public String getOpentimeWeek() {
        return this.f11135c;
    }

    public String getParkingType() {
        return this.f11140h;
    }

    public String getTag() {
        return this.f11137e;
    }

    public String getTel() {
        return this.f11136d;
    }

    public String getmRating() {
        return this.f11138f;
    }

    public void setCPID(String str) {
        this.f11142j = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeString(this.f11133a);
        parcel.writeString(this.f11134b);
        parcel.writeString(this.f11135c);
        parcel.writeString(this.f11136d);
        parcel.writeString(this.f11137e);
        parcel.writeString(this.f11138f);
        parcel.writeString(this.f11139g);
        parcel.writeString(this.f11140h);
        parcel.writeString(this.f11141i);
        parcel.writeString(this.f11142j);
    }

    protected Business(Parcel parcel) {
        this.f11133a = parcel.readString();
        this.f11134b = parcel.readString();
        this.f11135c = parcel.readString();
        this.f11136d = parcel.readString();
        this.f11137e = parcel.readString();
        this.f11138f = parcel.readString();
        this.f11139g = parcel.readString();
        this.f11140h = parcel.readString();
        this.f11141i = parcel.readString();
        this.f11142j = parcel.readString();
    }
}
