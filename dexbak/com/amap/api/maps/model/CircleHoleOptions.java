package com.amap.api.maps.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.autonavi.base.amap.mapcore.jbinding.JBindingExclude;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;
import com.github.mikephil.charting.utils.Utils;
import com.umeng.analytics.pro.UContent;

@JBindingInclude
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class CircleHoleOptions extends BaseHoleOptions implements Parcelable {
    @JBindingExclude
    public static final Parcelable.Creator<CircleHoleOptions> CREATOR = new Parcelable.Creator<CircleHoleOptions>() { // from class: com.amap.api.maps.model.CircleHoleOptions.1
        /* renamed from: a */
        private static CircleHoleOptions m52089a(Parcel parcel) {
            return new CircleHoleOptions(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ CircleHoleOptions createFromParcel(Parcel parcel) {
            return m52089a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ CircleHoleOptions[] newArray(int i) {
            return m52090a(i);
        }

        /* renamed from: a */
        private static CircleHoleOptions[] m52090a(int i) {
            return new CircleHoleOptions[i];
        }
    };
    private LatLng point;
    private double radius;

    public CircleHoleOptions() {
        this.point = null;
        this.radius = Utils.DOUBLE_EPSILON;
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

    public CircleHoleOptions radius(double d) {
        this.radius = d;
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Bundle bundle = new Bundle();
        LatLng latLng = this.point;
        if (latLng != null) {
            bundle.putDouble(UContent.f38072C, latLng.latitude);
            bundle.putDouble(UContent.f38073D, this.point.longitude);
        }
        parcel.writeBundle(bundle);
        parcel.writeDouble(this.radius);
    }

    @JBindingExclude
    protected CircleHoleOptions(Parcel parcel) {
        this.point = null;
        this.radius = Utils.DOUBLE_EPSILON;
        Bundle readBundle = parcel.readBundle();
        this.point = new LatLng(readBundle.getDouble(UContent.f38072C), readBundle.getDouble(UContent.f38073D));
        this.radius = parcel.readDouble();
    }
}
