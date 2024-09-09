package com.amap.api.services.geocoder;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class StreetNumber implements Parcelable {
    public static final Parcelable.Creator<StreetNumber> CREATOR = new Parcelable.Creator<StreetNumber>() { // from class: com.amap.api.services.geocoder.StreetNumber.1
        private static StreetNumber a(Parcel parcel) {
            return new StreetNumber(parcel, (byte) 0);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ StreetNumber createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ StreetNumber[] newArray(int i4) {
            return null;
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private String f11095a;

    /* renamed from: b  reason: collision with root package name */
    private String f11096b;

    /* renamed from: c  reason: collision with root package name */
    private LatLonPoint f11097c;

    /* renamed from: d  reason: collision with root package name */
    private String f11098d;

    /* renamed from: e  reason: collision with root package name */
    private float f11099e;

    /* synthetic */ StreetNumber(Parcel parcel, byte b4) {
        this(parcel);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String getDirection() {
        return this.f11098d;
    }

    public final float getDistance() {
        return this.f11099e;
    }

    public final LatLonPoint getLatLonPoint() {
        return this.f11097c;
    }

    public final String getNumber() {
        return this.f11096b;
    }

    public final String getStreet() {
        return this.f11095a;
    }

    public final void setDirection(String str) {
        this.f11098d = str;
    }

    public final void setDistance(float f4) {
        this.f11099e = f4;
    }

    public final void setLatLonPoint(LatLonPoint latLonPoint) {
        this.f11097c = latLonPoint;
    }

    public final void setNumber(String str) {
        this.f11096b = str;
    }

    public final void setStreet(String str) {
        this.f11095a = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        parcel.writeString(this.f11095a);
        parcel.writeString(this.f11096b);
        parcel.writeValue(this.f11097c);
        parcel.writeString(this.f11098d);
        parcel.writeFloat(this.f11099e);
    }

    public StreetNumber() {
    }

    private StreetNumber(Parcel parcel) {
        this.f11095a = parcel.readString();
        this.f11096b = parcel.readString();
        this.f11097c = (LatLonPoint) parcel.readValue(LatLonPoint.class.getClassLoader());
        this.f11098d = parcel.readString();
        this.f11099e = parcel.readFloat();
    }
}
