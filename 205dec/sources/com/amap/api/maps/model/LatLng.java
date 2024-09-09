package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.maps.AMapException;
import com.autonavi.base.amap.mapcore.jbinding.JBindingExclude;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
@JBindingInclude
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class LatLng implements Parcelable, Cloneable {
    @JBindingExclude
    public static final LatLngCreator CREATOR = new LatLngCreator();
    public final double latitude;
    public final double longitude;

    public LatLng(double d4, double d5) {
        this(d4, d5, true);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LatLng) {
            LatLng latLng = (LatLng) obj;
            return Double.doubleToLongBits(this.latitude) == Double.doubleToLongBits(latLng.latitude) && Double.doubleToLongBits(this.longitude) == Double.doubleToLongBits(latLng.longitude);
        }
        return false;
    }

    public final int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.latitude);
        long doubleToLongBits2 = Double.doubleToLongBits(this.longitude);
        return ((((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) + 31) * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)));
    }

    public final String toString() {
        return "lat/lng: (" + this.latitude + "," + this.longitude + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        parcel.writeDouble(this.longitude);
        parcel.writeDouble(this.latitude);
    }

    @JBindingExclude
    public LatLng(double d4, double d5, boolean z3) {
        if (z3) {
            if (-180.0d <= d5 && d5 < 180.0d) {
                this.longitude = d5;
            } else {
                this.longitude = ((((d5 - 180.0d) % 360.0d) + 360.0d) % 360.0d) - 180.0d;
            }
            if (d4 < -90.0d || d4 > 90.0d) {
                try {
                    throw new AMapException("\u975e\u6cd5\u5750\u6807\u503c");
                } catch (AMapException e4) {
                    e4.printStackTrace();
                }
            }
            this.latitude = Math.max(-90.0d, Math.min(90.0d, d4));
            return;
        }
        this.latitude = d4;
        this.longitude = d5;
    }

    /* renamed from: clone */
    public final LatLng m23clone() {
        return new LatLng(this.latitude, this.longitude);
    }
}
