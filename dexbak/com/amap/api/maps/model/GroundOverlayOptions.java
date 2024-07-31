package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.autonavi.base.amap.mapcore.jbinding.JBindingExclude;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;

@JBindingInclude
/* loaded from: E:\fuckcool\tsn\7241516.dex */
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

    /* renamed from: R */
    private final double f7036R;
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
    public GroundOverlayOptions(int i, LatLng latLng, float f, float f2, LatLngBounds latLngBounds, float f3, float f4, boolean z, float f5, float f6, float f7) {
        this.zIndex = 0.0f;
        this.isVisible = true;
        this.transparency = 0.0f;
        this.anchorU = 0.5f;
        this.anchorV = 0.5f;
        this.NF_PI = 0.01745329251994329d;
        this.f7036R = 6371000.79d;
        this.mVersionCode = i;
        this.bitmapDescriptor = BitmapDescriptorFactory.fromBitmap(null);
        this.latLng = latLng;
        this.width = f;
        this.height = f2;
        this.latlngBounds = latLngBounds;
        this.bearing = f3;
        this.zIndex = f4;
        this.isVisible = z;
        this.transparency = f5;
        this.anchorU = f6;
        this.anchorV = f7;
        this.southwest = latLngBounds.southwest;
        this.northeast = latLngBounds.northeast;
        this.type = CLASSNAME;
    }

    /* renamed from: a */
    private GroundOverlayOptions m52076a(LatLng latLng, float f, float f2) {
        this.latLng = latLng;
        this.width = f;
        this.height = f2;
        m52075b();
        return this;
    }

    /* renamed from: b */
    private void m52075b() {
        LatLng latLng = this.latLng;
        if (latLng == null) {
            return;
        }
        double d = this.width;
        Double.isNaN(d);
        double cos = d / ((Math.cos(latLng.latitude * 0.01745329251994329d) * 6371000.79d) * 0.01745329251994329d);
        double d2 = this.height;
        Double.isNaN(d2);
        double d3 = d2 / 111194.94043265979d;
        try {
            LatLng latLng2 = this.latLng;
            double d4 = latLng2.latitude;
            double d5 = 1.0f - this.anchorV;
            Double.isNaN(d5);
            double d6 = d4 - (d5 * d3);
            double d7 = latLng2.longitude;
            double d8 = this.anchorU;
            Double.isNaN(d8);
            LatLng latLng3 = new LatLng(d6, d7 - (d8 * cos));
            LatLng latLng4 = this.latLng;
            double d9 = latLng4.latitude;
            double d10 = this.anchorV;
            Double.isNaN(d10);
            double d11 = d9 + (d10 * d3);
            double d12 = latLng4.longitude;
            double d13 = 1.0f - this.anchorU;
            Double.isNaN(d13);
            LatLngBounds latLngBounds = new LatLngBounds(latLng3, new LatLng(d11, d12 + (d13 * cos)));
            this.latlngBounds = latLngBounds;
            this.southwest = latLngBounds.southwest;
            this.northeast = latLngBounds.northeast;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final GroundOverlayOptions anchor(float f, float f2) {
        this.anchorU = f;
        this.anchorV = f2;
        if (this.latlngBounds != null) {
            m52077a();
        } else if (this.latLng != null) {
            m52075b();
        }
        return this;
    }

    public final GroundOverlayOptions bearing(float f) {
        this.bearing = f;
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

    public final GroundOverlayOptions position(LatLng latLng, float f) {
        if (this.latlngBounds != null) {
            Log.w(CLASSNAME, "Position has already been set using positionFromBounds");
        }
        if (latLng == null) {
            Log.w(CLASSNAME, "Location must be specified");
        }
        if (f <= 0.0f) {
            Log.w(CLASSNAME, "Width must be non-negative");
        }
        return m52076a(latLng, f, f);
    }

    public final GroundOverlayOptions positionFromBounds(LatLngBounds latLngBounds) {
        this.latlngBounds = latLngBounds;
        this.southwest = latLngBounds.southwest;
        this.northeast = latLngBounds.northeast;
        m52077a();
        return this;
    }

    public final GroundOverlayOptions transparency(float f) {
        if (f < 0.0f) {
            Log.w(CLASSNAME, "Transparency must be in the range [0..1]");
            f = 0.0f;
        }
        this.transparency = f;
        return this;
    }

    public final GroundOverlayOptions visible(boolean z) {
        this.isVisible = z;
        return this;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mVersionCode);
        parcel.writeParcelable(this.bitmapDescriptor, i);
        parcel.writeParcelable(this.latLng, i);
        parcel.writeFloat(this.width);
        parcel.writeFloat(this.height);
        parcel.writeParcelable(this.latlngBounds, i);
        parcel.writeFloat(this.bearing);
        parcel.writeFloat(this.zIndex);
        parcel.writeByte(this.isVisible ? (byte) 1 : (byte) 0);
        parcel.writeFloat(this.transparency);
        parcel.writeFloat(this.anchorU);
        parcel.writeFloat(this.anchorV);
    }

    public final GroundOverlayOptions zIndex(float f) {
        this.zIndex = f;
        return this;
    }

    /* renamed from: clone */
    public final GroundOverlayOptions m60101clone() {
        try {
            super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
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

    /* renamed from: a */
    private void m52077a() {
        if (this.southwest == null || this.northeast == null) {
            return;
        }
        LatLng latLng = this.southwest;
        double d = latLng.latitude;
        double d2 = 1.0f - this.anchorV;
        LatLng latLng2 = this.northeast;
        Double.isNaN(d2);
        double d3 = d + (d2 * (latLng2.latitude - d));
        double d4 = latLng.longitude;
        double d5 = this.anchorU;
        Double.isNaN(d5);
        LatLng latLng3 = new LatLng(d3, d4 + (d5 * (latLng2.longitude - d4)));
        this.latLng = latLng3;
        LatLng latLng4 = this.northeast;
        double d6 = latLng4.longitude;
        LatLng latLng5 = this.southwest;
        this.width = (float) (Math.cos(latLng3.latitude * 0.01745329251994329d) * 6371000.79d * (d6 - latLng5.longitude) * 0.01745329251994329d);
        this.height = (float) ((latLng4.latitude - latLng5.latitude) * 6371000.79d * 0.01745329251994329d);
    }

    public final GroundOverlayOptions position(LatLng latLng, float f, float f2) {
        if (this.latlngBounds != null) {
            Log.w(CLASSNAME, "Position has already been set using positionFromBounds");
        }
        if (latLng == null) {
            Log.w(CLASSNAME, "Location must be specified");
        }
        if (f <= 0.0f || f2 <= 0.0f) {
            Log.w(CLASSNAME, "Width and Height must be non-negative");
        }
        return m52076a(latLng, f, f2);
    }

    public GroundOverlayOptions() {
        this.zIndex = 0.0f;
        this.isVisible = true;
        this.transparency = 0.0f;
        this.anchorU = 0.5f;
        this.anchorV = 0.5f;
        this.NF_PI = 0.01745329251994329d;
        this.f7036R = 6371000.79d;
        this.mVersionCode = 1;
        this.type = CLASSNAME;
    }
}
