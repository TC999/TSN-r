package com.amap.api.services.core;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class LatLonPoint implements Parcelable {
    public static final Parcelable.Creator<LatLonPoint> CREATOR = new Parcelable.Creator<LatLonPoint>() { // from class: com.amap.api.services.core.LatLonPoint.1
        private static LatLonPoint a(Parcel parcel) {
            return new LatLonPoint(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ LatLonPoint createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ LatLonPoint[] newArray(int i4) {
            return a(i4);
        }

        private static LatLonPoint[] a(int i4) {
            return new LatLonPoint[i4];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private double f10963a;

    /* renamed from: b  reason: collision with root package name */
    private double f10964b;

    public LatLonPoint(double d4, double d5) {
        this.f10963a = d4;
        this.f10964b = d5;
    }

    public LatLonPoint copy() {
        return new LatLonPoint(this.f10963a, this.f10964b);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            LatLonPoint latLonPoint = (LatLonPoint) obj;
            return Double.doubleToLongBits(this.f10963a) == Double.doubleToLongBits(latLonPoint.f10963a) && Double.doubleToLongBits(this.f10964b) == Double.doubleToLongBits(latLonPoint.f10964b);
        }
        return false;
    }

    public double getLatitude() {
        return this.f10963a;
    }

    public double getLongitude() {
        return this.f10964b;
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.f10963a);
        long doubleToLongBits2 = Double.doubleToLongBits(this.f10964b);
        return ((((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) + 31) * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)));
    }

    public void setLatitude(double d4) {
        this.f10963a = d4;
    }

    public void setLongitude(double d4) {
        this.f10964b = d4;
    }

    public String toString() {
        return this.f10963a + "," + this.f10964b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeDouble(this.f10963a);
        parcel.writeDouble(this.f10964b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public LatLonPoint(Parcel parcel) {
        this.f10963a = parcel.readDouble();
        this.f10964b = parcel.readDouble();
    }
}
