package com.amap.api.maps.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.autonavi.base.amap.mapcore.jbinding.JBindingExclude;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
@JBindingInclude
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class CircleHoleOptions extends BaseHoleOptions implements Parcelable {
    @JBindingExclude
    public static final Parcelable.Creator<CircleHoleOptions> CREATOR = new Parcelable.Creator<CircleHoleOptions>() { // from class: com.amap.api.maps.model.CircleHoleOptions.1
        private static CircleHoleOptions a(Parcel parcel) {
            return new CircleHoleOptions(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ CircleHoleOptions createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ CircleHoleOptions[] newArray(int i4) {
            return a(i4);
        }

        private static CircleHoleOptions[] a(int i4) {
            return new CircleHoleOptions[i4];
        }
    };
    private LatLng point;
    private double radius;

    public CircleHoleOptions() {
        this.point = null;
        this.radius = 0.0d;
        this.isPolygonHoleOptions = false;
    }

    public CircleHoleOptions center(LatLng latLng) {
        this.point = latLng;
        return this;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public LatLng getCenter() {
        return this.point;
    }

    public double getRadius() {
        return this.radius;
    }

    public CircleHoleOptions radius(double d4) {
        this.radius = d4;
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        Bundle bundle = new Bundle();
        LatLng latLng = this.point;
        if (latLng != null) {
            bundle.putDouble("lat", latLng.latitude);
            bundle.putDouble("lng", this.point.longitude);
        }
        parcel.writeBundle(bundle);
        parcel.writeDouble(this.radius);
    }

    @JBindingExclude
    protected CircleHoleOptions(Parcel parcel) {
        this.point = null;
        this.radius = 0.0d;
        Bundle readBundle = parcel.readBundle();
        this.point = new LatLng(readBundle.getDouble("lat"), readBundle.getDouble("lng"));
        this.radius = parcel.readDouble();
    }
}
