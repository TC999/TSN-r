package com.amap.api.location;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class DPoint implements Parcelable {
    public static final Parcelable.Creator<DPoint> CREATOR = new Parcelable.Creator<DPoint>() { // from class: com.amap.api.location.DPoint.1
        private static DPoint a(Parcel parcel) {
            return new DPoint(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ DPoint createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ DPoint[] newArray(int i4) {
            return a(i4);
        }

        private static DPoint[] a(int i4) {
            return new DPoint[i4];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private double f10673a;

    /* renamed from: b  reason: collision with root package name */
    private double f10674b;

    public DPoint() {
        this.f10673a = 0.0d;
        this.f10674b = 0.0d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj instanceof DPoint) {
            DPoint dPoint = (DPoint) obj;
            return this.f10674b == dPoint.f10674b && this.f10673a == dPoint.f10673a;
        }
        return false;
    }

    public double getLatitude() {
        return this.f10674b;
    }

    public double getLongitude() {
        return this.f10673a;
    }

    public int hashCode() {
        return Double.valueOf((this.f10674b + this.f10673a) * 1000000.0d).intValue();
    }

    public void setLatitude(double d4) {
        if (d4 > 90.0d) {
            d4 = 90.0d;
        }
        if (d4 < -90.0d) {
            d4 = -90.0d;
        }
        this.f10674b = d4;
    }

    public void setLongitude(double d4) {
        if (d4 > 180.0d) {
            d4 = 180.0d;
        }
        if (d4 < -180.0d) {
            d4 = -180.0d;
        }
        this.f10673a = d4;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeDouble(this.f10673a);
        parcel.writeDouble(this.f10674b);
    }

    public DPoint(double d4, double d5) {
        this.f10673a = 0.0d;
        this.f10674b = 0.0d;
        d5 = d5 > 180.0d ? 180.0d : d5;
        d5 = d5 < -180.0d ? -180.0d : d5;
        d4 = d4 > 90.0d ? 90.0d : d4;
        d4 = d4 < -90.0d ? -90.0d : d4;
        this.f10673a = d5;
        this.f10674b = d4;
    }

    protected DPoint(Parcel parcel) {
        this.f10673a = 0.0d;
        this.f10674b = 0.0d;
        this.f10673a = parcel.readDouble();
        this.f10674b = parcel.readDouble();
    }
}
