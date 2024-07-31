package com.amap.api.services.geocoder;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class StreetNumber implements Parcelable {
    public static final Parcelable.Creator<StreetNumber> CREATOR = new Parcelable.Creator<StreetNumber>() { // from class: com.amap.api.services.geocoder.StreetNumber.1
        /* renamed from: a */
        private static StreetNumber m51869a(Parcel parcel) {
            return new StreetNumber(parcel, (byte) 0);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ StreetNumber createFromParcel(Parcel parcel) {
            return m51869a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ StreetNumber[] newArray(int i) {
            return null;
        }
    };

    /* renamed from: a */
    private String f7401a;

    /* renamed from: b */
    private String f7402b;

    /* renamed from: c */
    private LatLonPoint f7403c;

    /* renamed from: d */
    private String f7404d;

    /* renamed from: e */
    private float f7405e;

    /* synthetic */ StreetNumber(Parcel parcel, byte b) {
        this(parcel);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String getDirection() {
        return this.f7404d;
    }

    public final float getDistance() {
        return this.f7405e;
    }

    public final LatLonPoint getLatLonPoint() {
        return this.f7403c;
    }

    public final String getNumber() {
        return this.f7402b;
    }

    public final String getStreet() {
        return this.f7401a;
    }

    public final void setDirection(String str) {
        this.f7404d = str;
    }

    public final void setDistance(float f) {
        this.f7405e = f;
    }

    public final void setLatLonPoint(LatLonPoint latLonPoint) {
        this.f7403c = latLonPoint;
    }

    public final void setNumber(String str) {
        this.f7402b = str;
    }

    public final void setStreet(String str) {
        this.f7401a = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f7401a);
        parcel.writeString(this.f7402b);
        parcel.writeValue(this.f7403c);
        parcel.writeString(this.f7404d);
        parcel.writeFloat(this.f7405e);
    }

    public StreetNumber() {
    }

    private StreetNumber(Parcel parcel) {
        this.f7401a = parcel.readString();
        this.f7402b = parcel.readString();
        this.f7403c = (LatLonPoint) parcel.readValue(LatLonPoint.class.getClassLoader());
        this.f7404d = parcel.readString();
        this.f7405e = parcel.readFloat();
    }
}
