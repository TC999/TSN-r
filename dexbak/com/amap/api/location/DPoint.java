package com.amap.api.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.github.mikephil.charting.utils.Utils;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class DPoint implements Parcelable {
    public static final Parcelable.Creator<DPoint> CREATOR = new Parcelable.Creator<DPoint>() { // from class: com.amap.api.location.DPoint.1
        /* renamed from: a */
        private static DPoint m52127a(Parcel parcel) {
            return new DPoint(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ DPoint createFromParcel(Parcel parcel) {
            return m52127a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ DPoint[] newArray(int i) {
            return m52128a(i);
        }

        /* renamed from: a */
        private static DPoint[] m52128a(int i) {
            return new DPoint[i];
        }
    };

    /* renamed from: a */
    private double f6969a;

    /* renamed from: b */
    private double f6970b;

    public DPoint() {
        this.f6969a = Utils.DOUBLE_EPSILON;
        this.f6970b = Utils.DOUBLE_EPSILON;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj instanceof DPoint) {
            DPoint dPoint = (DPoint) obj;
            return this.f6970b == dPoint.f6970b && this.f6969a == dPoint.f6969a;
        }
        return false;
    }

    public double getLatitude() {
        return this.f6970b;
    }

    public double getLongitude() {
        return this.f6969a;
    }

    public int hashCode() {
        return Double.valueOf((this.f6970b + this.f6969a) * 1000000.0d).intValue();
    }

    public void setLatitude(double d) {
        if (d > 90.0d) {
            d = 90.0d;
        }
        if (d < -90.0d) {
            d = -90.0d;
        }
        this.f6970b = d;
    }

    public void setLongitude(double d) {
        if (d > 180.0d) {
            d = 180.0d;
        }
        if (d < -180.0d) {
            d = -180.0d;
        }
        this.f6969a = d;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeDouble(this.f6969a);
        parcel.writeDouble(this.f6970b);
    }

    public DPoint(double d, double d2) {
        this.f6969a = Utils.DOUBLE_EPSILON;
        this.f6970b = Utils.DOUBLE_EPSILON;
        d2 = d2 > 180.0d ? 180.0d : d2;
        d2 = d2 < -180.0d ? -180.0d : d2;
        d = d > 90.0d ? 90.0d : d;
        d = d < -90.0d ? -90.0d : d;
        this.f6969a = d2;
        this.f6970b = d;
    }

    protected DPoint(Parcel parcel) {
        this.f6969a = Utils.DOUBLE_EPSILON;
        this.f6970b = Utils.DOUBLE_EPSILON;
        this.f6969a = parcel.readDouble();
        this.f6970b = parcel.readDouble();
    }
}
