package com.amap.api.services.help;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class Tip implements Parcelable {
    public static final Parcelable.Creator<Tip> CREATOR = new Parcelable.Creator<Tip>() { // from class: com.amap.api.services.help.Tip.1
        private static Tip a(Parcel parcel) {
            return new Tip(parcel, (byte) 0);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ Tip createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ Tip[] newArray(int i4) {
            return null;
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private String f11106a;

    /* renamed from: b  reason: collision with root package name */
    private LatLonPoint f11107b;

    /* renamed from: c  reason: collision with root package name */
    private String f11108c;

    /* renamed from: d  reason: collision with root package name */
    private String f11109d;

    /* renamed from: e  reason: collision with root package name */
    private String f11110e;

    /* renamed from: f  reason: collision with root package name */
    private String f11111f;

    /* renamed from: g  reason: collision with root package name */
    private String f11112g;

    /* renamed from: h  reason: collision with root package name */
    private String f11113h;

    /* synthetic */ Tip(Parcel parcel, byte b4) {
        this(parcel);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAdcode() {
        return this.f11110e;
    }

    public String getAddress() {
        return this.f11111f;
    }

    public String getDistrict() {
        return this.f11109d;
    }

    public String getName() {
        return this.f11108c;
    }

    public String getPoiID() {
        return this.f11106a;
    }

    public LatLonPoint getPoint() {
        return this.f11107b;
    }

    public String getTypeCode() {
        return this.f11112g;
    }

    public void setAdcode(String str) {
        this.f11110e = str;
    }

    public void setAddress(String str) {
        this.f11111f = str;
    }

    public void setDistrict(String str) {
        this.f11109d = str;
    }

    public void setID(String str) {
        this.f11106a = str;
    }

    public void setName(String str) {
        this.f11108c = str;
    }

    public void setPostion(LatLonPoint latLonPoint) {
        this.f11107b = latLonPoint;
    }

    public void setTypeCode(String str) {
        this.f11112g = str;
    }

    public String toString() {
        return "name:" + this.f11108c + " district:" + this.f11109d + " adcode:" + this.f11110e;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeString(this.f11108c);
        parcel.writeString(this.f11110e);
        parcel.writeString(this.f11109d);
        parcel.writeString(this.f11106a);
        parcel.writeValue(this.f11107b);
        parcel.writeString(this.f11111f);
        parcel.writeString(this.f11112g);
        parcel.writeString(this.f11113h);
    }

    public Tip() {
        this.f11113h = "";
    }

    private Tip(Parcel parcel) {
        this.f11113h = "";
        this.f11108c = parcel.readString();
        this.f11110e = parcel.readString();
        this.f11109d = parcel.readString();
        this.f11106a = parcel.readString();
        this.f11107b = (LatLonPoint) parcel.readValue(LatLonPoint.class.getClassLoader());
        this.f11111f = parcel.readString();
        this.f11112g = parcel.readString();
        this.f11113h = parcel.readString();
    }
}
