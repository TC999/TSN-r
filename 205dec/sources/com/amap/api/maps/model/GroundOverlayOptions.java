package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.autonavi.base.amap.mapcore.jbinding.JBindingExclude;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
@JBindingInclude
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class GroundOverlayOptions extends BaseOptions implements Parcelable, Cloneable {
    @JBindingExclude
    private static final String CLASSNAME = "GroundOverlayOptions";
    @JBindingExclude
    public static final GroundOverlayOptionsCreator CREATOR = new GroundOverlayOptionsCreator();
    @JBindingExclude
    public static final float NO_DIMENSION = -1.0f;
    @JBindingExclude
    private final double NF_PI;
    @JBindingExclude
    private final double R;
    private float anchorU;
    private float anchorV;
    private float bearing;
    private BitmapDescriptor bitmapDescriptor;
    private float height;
    private boolean isVisible;
    private LatLng latLng;
    @JBindingExclude
    private LatLngBounds latlngBounds;
    @JBindingExclude
    private final int mVersionCode;
    private LatLng northeast;
    private LatLng southwest;
    private float transparency;
    private float width;
    private float zIndex;

    /* JADX INFO: Access modifiers changed from: package-private */
    @JBindingExclude
    public GroundOverlayOptions(int i4, LatLng latLng, float f4, float f5, LatLngBounds latLngBounds, float f6, float f7, boolean z3, float f8, float f9, float f10) {
        this.zIndex = 0.0f;
        this.isVisible = true;
        this.transparency = 0.0f;
        this.anchorU = 0.5f;
        this.anchorV = 0.5f;
        this.NF_PI = 0.01745329251994329d;
        this.R = 6371000.79d;
        this.mVersionCode = i4;
        this.bitmapDescriptor = BitmapDescriptorFactory.fromBitmap(null);
        this.latLng = latLng;
        this.width = f4;
        this.height = f5;
        this.latlngBounds = latLngBounds;
        this.bearing = f6;
        this.zIndex = f7;
        this.isVisible = z3;
        this.transparency = f8;
        this.anchorU = f9;
        this.anchorV = f10;
        this.southwest = latLngBounds.southwest;
        this.northeast = latLngBounds.northeast;
        this.type = "GroundOverlayOptions";
    }

    private GroundOverlayOptions a(LatLng latLng, float f4, float f5) {
        this.latLng = latLng;
        this.width = f4;
        this.height = f5;
        b();
        return this;
    }

    private void b() {
        LatLng latLng = this.latLng;
        if (latLng == null) {
            return;
        }
        double d4 = this.width;
        Double.isNaN(d4);
        double cos = d4 / ((Math.cos(latLng.latitude * 0.01745329251994329d) * 6371000.79d) * 0.01745329251994329d);
        double d5 = this.height;
        Double.isNaN(d5);
        double d6 = d5 / 111194.94043265979d;
        try {
            LatLng latLng2 = this.latLng;
            double d7 = latLng2.latitude;
            double d8 = 1.0f - this.anchorV;
            Double.isNaN(d8);
            double d9 = d7 - (d8 * d6);
            double d10 = latLng2.longitude;
            double d11 = this.anchorU;
            Double.isNaN(d11);
            LatLng latLng3 = new LatLng(d9, d10 - (d11 * cos));
            LatLng latLng4 = this.latLng;
            double d12 = latLng4.latitude;
            double d13 = this.anchorV;
            Double.isNaN(d13);
            double d14 = d12 + (d13 * d6);
            double d15 = latLng4.longitude;
            double d16 = 1.0f - this.anchorU;
            Double.isNaN(d16);
            LatLngBounds latLngBounds = new LatLngBounds(latLng3, new LatLng(d14, d15 + (d16 * cos)));
            this.latlngBounds = latLngBounds;
            this.southwest = latLngBounds.southwest;
            this.northeast = latLngBounds.northeast;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final GroundOverlayOptions anchor(float f4, float f5) {
        this.anchorU = f4;
        this.anchorV = f5;
        if (this.latlngBounds != null) {
            a();
        } else if (this.latLng != null) {
            b();
        }
        return this;
    }

    public final GroundOverlayOptions bearing(float f4) {
        this.bearing = f4;
        return this;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final float getAnchorU() {
        return this.anchorU;
    }

    public final float getAnchorV() {
        return this.anchorV;
    }

    public final float getBearing() {
        return this.bearing;
    }

    public final LatLngBounds getBounds() {
        return this.latlngBounds;
    }

    public final float getHeight() {
        return this.height;
    }

    public final BitmapDescriptor getImage() {
        return this.bitmapDescriptor;
    }

    public final LatLng getLocation() {
        return this.latLng;
    }

    public final float getTransparency() {
        return this.transparency;
    }

    public final float getWidth() {
        return this.width;
    }

    public final float getZIndex() {
        return this.zIndex;
    }

    public final GroundOverlayOptions image(BitmapDescriptor bitmapDescriptor) {
        this.bitmapDescriptor = bitmapDescriptor;
        return this;
    }

    public final boolean isVisible() {
        return this.isVisible;
    }

    public final GroundOverlayOptions position(LatLng latLng, float f4) {
        if (this.latlngBounds != null) {
            Log.w("GroundOverlayOptions", "Position has already been set using positionFromBounds");
        }
        if (latLng == null) {
            Log.w("GroundOverlayOptions", "Location must be specified");
        }
        if (f4 <= 0.0f) {
            Log.w("GroundOverlayOptions", "Width must be non-negative");
        }
        return a(latLng, f4, f4);
    }

    public final GroundOverlayOptions positionFromBounds(LatLngBounds latLngBounds) {
        this.latlngBounds = latLngBounds;
        this.southwest = latLngBounds.southwest;
        this.northeast = latLngBounds.northeast;
        a();
        return this;
    }

    public final GroundOverlayOptions transparency(float f4) {
        if (f4 < 0.0f) {
            Log.w("GroundOverlayOptions", "Transparency must be in the range [0..1]");
            f4 = 0.0f;
        }
        this.transparency = f4;
        return this;
    }

    public final GroundOverlayOptions visible(boolean z3) {
        this.isVisible = z3;
        return this;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        parcel.writeInt(this.mVersionCode);
        parcel.writeParcelable(this.bitmapDescriptor, i4);
        parcel.writeParcelable(this.latLng, i4);
        parcel.writeFloat(this.width);
        parcel.writeFloat(this.height);
        parcel.writeParcelable(this.latlngBounds, i4);
        parcel.writeFloat(this.bearing);
        parcel.writeFloat(this.zIndex);
        parcel.writeByte(this.isVisible ? (byte) 1 : (byte) 0);
        parcel.writeFloat(this.transparency);
        parcel.writeFloat(this.anchorU);
        parcel.writeFloat(this.anchorV);
    }

    public final GroundOverlayOptions zIndex(float f4) {
        this.zIndex = f4;
        return this;
    }

    /* renamed from: clone */
    public final GroundOverlayOptions m22clone() {
        try {
            super.clone();
        } catch (CloneNotSupportedException e4) {
            e4.printStackTrace();
        }
        GroundOverlayOptions groundOverlayOptions = new GroundOverlayOptions();
        groundOverlayOptions.bitmapDescriptor = this.bitmapDescriptor;
        groundOverlayOptions.latLng = this.latLng;
        groundOverlayOptions.width = this.width;
        groundOverlayOptions.height = this.height;
        groundOverlayOptions.latlngBounds = this.latlngBounds;
        groundOverlayOptions.bearing = this.bearing;
        groundOverlayOptions.zIndex = this.zIndex;
        groundOverlayOptions.isVisible = this.isVisible;
        groundOverlayOptions.transparency = this.transparency;
        groundOverlayOptions.anchorU = this.anchorU;
        groundOverlayOptions.anchorV = this.anchorV;
        groundOverlayOptions.southwest = this.southwest;
        groundOverlayOptions.northeast = this.northeast;
        return groundOverlayOptions;
    }

    private void a() {
        if (this.southwest == null || this.northeast == null) {
            return;
        }
        LatLng latLng = this.southwest;
        double d4 = latLng.latitude;
        double d5 = 1.0f - this.anchorV;
        LatLng latLng2 = this.northeast;
        Double.isNaN(d5);
        double d6 = d4 + (d5 * (latLng2.latitude - d4));
        double d7 = latLng.longitude;
        double d8 = this.anchorU;
        Double.isNaN(d8);
        LatLng latLng3 = new LatLng(d6, d7 + (d8 * (latLng2.longitude - d7)));
        this.latLng = latLng3;
        LatLng latLng4 = this.northeast;
        double d9 = latLng4.longitude;
        LatLng latLng5 = this.southwest;
        this.width = (float) (Math.cos(latLng3.latitude * 0.01745329251994329d) * 6371000.79d * (d9 - latLng5.longitude) * 0.01745329251994329d);
        this.height = (float) ((latLng4.latitude - latLng5.latitude) * 6371000.79d * 0.01745329251994329d);
    }

    public final GroundOverlayOptions position(LatLng latLng, float f4, float f5) {
        if (this.latlngBounds != null) {
            Log.w("GroundOverlayOptions", "Position has already been set using positionFromBounds");
        }
        if (latLng == null) {
            Log.w("GroundOverlayOptions", "Location must be specified");
        }
        if (f4 <= 0.0f || f5 <= 0.0f) {
            Log.w("GroundOverlayOptions", "Width and Height must be non-negative");
        }
        return a(latLng, f4, f5);
    }

    public GroundOverlayOptions() {
        this.zIndex = 0.0f;
        this.isVisible = true;
        this.transparency = 0.0f;
        this.anchorU = 0.5f;
        this.anchorV = 0.5f;
        this.NF_PI = 0.01745329251994329d;
        this.R = 6371000.79d;
        this.mVersionCode = 1;
        this.type = "GroundOverlayOptions";
    }
}
