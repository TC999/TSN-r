package com.amap.api.maps;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.maps.model.CameraPosition;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class AMapOptions implements Parcelable {
    public static final AMapOptionsCreator CREATOR = new AMapOptionsCreator();
    public static final int LOGO_MARGIN_BOTTOM = 2;
    public static final int LOGO_MARGIN_LEFT = 0;
    public static final int LOGO_MARGIN_RIGHT = 1;
    public static final int LOGO_POSITION_BOTTOM_CENTER = 1;
    public static final int LOGO_POSITION_BOTTOM_LEFT = 0;
    public static final int LOGO_POSITION_BOTTOM_RIGHT = 2;
    public static final int ZOOM_POSITION_RIGHT_BUTTOM = 2;
    public static final int ZOOM_POSITION_RIGHT_CENTER = 1;
    private CameraPosition cameraPosition;
    private int mapType = 1;
    private boolean isRotateGesturesEnabled = true;
    private boolean isScrollGesturesEnabled = true;
    private boolean isTiltGesturesEnabled = true;
    private boolean isZoomGesturesEnabled = true;
    private boolean isZoomEnabled = true;
    private boolean isZOrderOnTop = false;
    private boolean isCompassEnabled = false;
    private boolean isScaleControlsEnabled = false;
    private int logoPosition = 0;

    public AMapOptions camera(CameraPosition cameraPosition) {
        this.cameraPosition = cameraPosition;
        return this;
    }

    public AMapOptions compassEnabled(boolean z3) {
        this.isCompassEnabled = z3;
        return this;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public CameraPosition getCamera() {
        return this.cameraPosition;
    }

    public boolean getCompassEnabled() {
        return this.isCompassEnabled;
    }

    public int getLogoPosition() {
        return this.logoPosition;
    }

    public int getMapType() {
        return this.mapType;
    }

    public boolean getRotateGesturesEnabled() {
        return this.isRotateGesturesEnabled;
    }

    public boolean getScaleControlsEnabled() {
        return this.isScaleControlsEnabled;
    }

    public boolean getScrollGesturesEnabled() {
        return this.isScrollGesturesEnabled;
    }

    public boolean getTiltGesturesEnabled() {
        return this.isTiltGesturesEnabled;
    }

    public boolean getZOrderOnTop() {
        return this.isZOrderOnTop;
    }

    public boolean getZoomControlsEnabled() {
        return this.isZoomEnabled;
    }

    public boolean getZoomGesturesEnabled() {
        return this.isZoomGesturesEnabled;
    }

    public AMapOptions logoPosition(int i4) {
        this.logoPosition = i4;
        return this;
    }

    public AMapOptions mapType(int i4) {
        this.mapType = i4;
        return this;
    }

    public AMapOptions rotateGesturesEnabled(boolean z3) {
        this.isRotateGesturesEnabled = z3;
        return this;
    }

    public AMapOptions scaleControlsEnabled(boolean z3) {
        this.isScaleControlsEnabled = z3;
        return this;
    }

    public AMapOptions scrollGesturesEnabled(boolean z3) {
        this.isScrollGesturesEnabled = z3;
        return this;
    }

    public AMapOptions tiltGesturesEnabled(boolean z3) {
        this.isTiltGesturesEnabled = z3;
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeParcelable(this.cameraPosition, i4);
        parcel.writeInt(this.mapType);
        parcel.writeInt(this.logoPosition);
        parcel.writeBooleanArray(new boolean[]{this.isRotateGesturesEnabled, this.isScrollGesturesEnabled, this.isTiltGesturesEnabled, this.isZoomGesturesEnabled, this.isZoomEnabled, this.isZOrderOnTop, this.isCompassEnabled, this.isScaleControlsEnabled});
    }

    public AMapOptions zOrderOnTop(boolean z3) {
        this.isZOrderOnTop = z3;
        return this;
    }

    public AMapOptions zoomControlsEnabled(boolean z3) {
        this.isZoomEnabled = z3;
        return this;
    }

    public AMapOptions zoomGesturesEnabled(boolean z3) {
        this.isZoomGesturesEnabled = z3;
        return this;
    }
}
