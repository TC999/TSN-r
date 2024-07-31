package com.amap.api.services.core;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class LatLonPoint implements Parcelable {
    public static final Parcelable.Creator<LatLonPoint> CREATOR = new Parcelable.Creator<LatLonPoint>() { // from class: com.amap.api.services.core.LatLonPoint.1
        /* renamed from: a */
        private static LatLonPoint m51889a(Parcel parcel) {
            return new LatLonPoint(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ LatLonPoint createFromParcel(Parcel parcel) {
            return m51889a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ LatLonPoint[] newArray(int i) {
            return m51890a(i);
        }

        /* renamed from: a */
        private static LatLonPoint[] m51890a(int i) {
            return new LatLonPoint[i];
        }
    };

    /* renamed from: a */
    private double f7267a;

    /* renamed from: b */
    private double f7268b;

    public LatLonPoint(double d, double d2) {
        this.f7267a = d;
        this.f7268b = d2;
    }

    public LatLonPoint copy() {
        return new LatLonPoint(this.f7267a, this.f7268b);
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
            return Double.doubleToLongBits(this.f7267a) == Double.doubleToLongBits(latLonPoint.f7267a) && Double.doubleToLongBits(this.f7268b) == Double.doubleToLongBits(latLonPoint.f7268b);
        }
        return false;
    }

    public double getLatitude() {
        return this.f7267a;
    }

    public double getLongitude() {
        return this.f7268b;
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.f7267a);
        long doubleToLongBits2 = Double.doubleToLongBits(this.f7268b);
        return ((((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) + 31) * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)));
    }

    public void setLatitude(double d) {
        this.f7267a = d;
    }

    public void setLongitude(double d) {
        this.f7268b = d;
    }

    public String toString() {
        return this.f7267a + "," + this.f7268b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeDouble(this.f7267a);
        parcel.writeDouble(this.f7268b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public LatLonPoint(Parcel parcel) {
        this.f7267a = parcel.readDouble();
        this.f7268b = parcel.readDouble();
    }
}
