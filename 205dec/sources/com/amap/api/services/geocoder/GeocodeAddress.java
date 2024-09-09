package com.amap.api.services.geocoder;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class GeocodeAddress implements Parcelable {
    public static final Parcelable.Creator<GeocodeAddress> CREATOR = new Parcelable.Creator<GeocodeAddress>() { // from class: com.amap.api.services.geocoder.GeocodeAddress.1
        private static GeocodeAddress a(Parcel parcel) {
            return new GeocodeAddress(parcel, (byte) 0);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ GeocodeAddress createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ GeocodeAddress[] newArray(int i4) {
            return null;
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private String f11046a;

    /* renamed from: b  reason: collision with root package name */
    private String f11047b;

    /* renamed from: c  reason: collision with root package name */
    private String f11048c;

    /* renamed from: d  reason: collision with root package name */
    private String f11049d;

    /* renamed from: e  reason: collision with root package name */
    private String f11050e;

    /* renamed from: f  reason: collision with root package name */
    private String f11051f;

    /* renamed from: g  reason: collision with root package name */
    private String f11052g;

    /* renamed from: h  reason: collision with root package name */
    private String f11053h;

    /* renamed from: i  reason: collision with root package name */
    private LatLonPoint f11054i;

    /* renamed from: j  reason: collision with root package name */
    private String f11055j;

    /* renamed from: k  reason: collision with root package name */
    private String f11056k;

    /* renamed from: l  reason: collision with root package name */
    private String f11057l;

    /* synthetic */ GeocodeAddress(Parcel parcel, byte b4) {
        this(parcel);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String getAdcode() {
        return this.f11053h;
    }

    public final String getBuilding() {
        return this.f11052g;
    }

    public final String getCity() {
        return this.f11048c;
    }

    public final String getCountry() {
        return this.f11056k;
    }

    public final String getDistrict() {
        return this.f11049d;
    }

    public final String getFormatAddress() {
        return this.f11046a;
    }

    public final LatLonPoint getLatLonPoint() {
        return this.f11054i;
    }

    public final String getLevel() {
        return this.f11055j;
    }

    public final String getNeighborhood() {
        return this.f11051f;
    }

    public final String getPostcode() {
        return this.f11057l;
    }

    public final String getProvince() {
        return this.f11047b;
    }

    public final String getTownship() {
        return this.f11050e;
    }

    public final void setAdcode(String str) {
        this.f11053h = str;
    }

    public final void setBuilding(String str) {
        this.f11052g = str;
    }

    public final void setCity(String str) {
        this.f11048c = str;
    }

    public final void setCountry(String str) {
        this.f11056k = str;
    }

    public final void setDistrict(String str) {
        this.f11049d = str;
    }

    public final void setFormatAddress(String str) {
        this.f11046a = str;
    }

    public final void setLatLonPoint(LatLonPoint latLonPoint) {
        this.f11054i = latLonPoint;
    }

    public final void setLevel(String str) {
        this.f11055j = str;
    }

    public final void setNeighborhood(String str) {
        this.f11051f = str;
    }

    public final void setPostcode(String str) {
        this.f11057l = str;
    }

    public final void setProvince(String str) {
        this.f11047b = str;
    }

    public final void setTownship(String str) {
        this.f11050e = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        parcel.writeString(this.f11046a);
        parcel.writeString(this.f11047b);
        parcel.writeString(this.f11048c);
        parcel.writeString(this.f11049d);
        parcel.writeString(this.f11050e);
        parcel.writeString(this.f11051f);
        parcel.writeString(this.f11052g);
        parcel.writeString(this.f11053h);
        parcel.writeValue(this.f11054i);
        parcel.writeString(this.f11055j);
        parcel.writeString(this.f11056k);
        parcel.writeString(this.f11057l);
    }

    public GeocodeAddress() {
    }

    private GeocodeAddress(Parcel parcel) {
        this.f11046a = parcel.readString();
        this.f11047b = parcel.readString();
        this.f11048c = parcel.readString();
        this.f11049d = parcel.readString();
        this.f11050e = parcel.readString();
        this.f11051f = parcel.readString();
        this.f11052g = parcel.readString();
        this.f11053h = parcel.readString();
        this.f11054i = (LatLonPoint) parcel.readValue(LatLonPoint.class.getClassLoader());
        this.f11055j = parcel.readString();
        this.f11056k = parcel.readString();
        this.f11057l = parcel.readString();
    }
}
