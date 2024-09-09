package com.amap.api.maps.model;

import android.graphics.Color;
import android.os.Parcel;
import android.os.Parcelable;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class MyLocationStyle implements Parcelable {
    public static final MyLocationStyleCreator CREATOR = new MyLocationStyleCreator();
    public static final String ERROR_CODE = "errorCode";
    public static final String ERROR_INFO = "errorInfo";
    public static final String LOCATION_TYPE = "locationType";
    public static final int LOCATION_TYPE_FOLLOW = 2;
    public static final int LOCATION_TYPE_FOLLOW_NO_CENTER = 6;
    public static final int LOCATION_TYPE_LOCATE = 1;
    public static final int LOCATION_TYPE_LOCATION_ROTATE = 4;
    public static final int LOCATION_TYPE_LOCATION_ROTATE_NO_CENTER = 5;
    public static final int LOCATION_TYPE_MAP_ROTATE = 3;
    public static final int LOCATION_TYPE_MAP_ROTATE_NO_CENTER = 7;
    public static final int LOCATION_TYPE_SHOW = 0;
    private BitmapDescriptor mMyLocationIcon;
    private float mAnchorU = 0.5f;
    private float mAnchorV = 0.5f;
    private int mRadiusFillColor = Color.argb(100, 0, 0, 180);
    private int mStrokeColor = Color.argb(255, 0, 0, (int) MediaPlayer.MEDIA_PLAYER_OPTION_FASTOPEN_LIVE_STREAM);
    private float mStrokeWidth = 1.0f;
    private int mLocationType = 4;
    private long interval = 2000;
    private boolean myLocationVisible = true;

    public MyLocationStyle anchor(float f4, float f5) {
        this.mAnchorU = f4;
        this.mAnchorV = f5;
        return this;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public float getAnchorU() {
        return this.mAnchorU;
    }

    public float getAnchorV() {
        return this.mAnchorV;
    }

    public long getInterval() {
        return this.interval;
    }

    public BitmapDescriptor getMyLocationIcon() {
        return this.mMyLocationIcon;
    }

    public int getMyLocationType() {
        return this.mLocationType;
    }

    public int getRadiusFillColor() {
        return this.mRadiusFillColor;
    }

    public int getStrokeColor() {
        return this.mStrokeColor;
    }

    public float getStrokeWidth() {
        return this.mStrokeWidth;
    }

    public MyLocationStyle interval(long j4) {
        this.interval = j4;
        return this;
    }

    public boolean isMyLocationShowing() {
        return this.myLocationVisible;
    }

    public MyLocationStyle myLocationIcon(BitmapDescriptor bitmapDescriptor) {
        this.mMyLocationIcon = bitmapDescriptor;
        return this;
    }

    public MyLocationStyle myLocationType(int i4) {
        this.mLocationType = i4;
        return this;
    }

    public MyLocationStyle radiusFillColor(int i4) {
        this.mRadiusFillColor = i4;
        return this;
    }

    public MyLocationStyle showMyLocation(boolean z3) {
        this.myLocationVisible = z3;
        return this;
    }

    public MyLocationStyle strokeColor(int i4) {
        this.mStrokeColor = i4;
        return this;
    }

    public MyLocationStyle strokeWidth(float f4) {
        this.mStrokeWidth = f4;
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeParcelable(this.mMyLocationIcon, i4);
        parcel.writeFloat(this.mAnchorU);
        parcel.writeFloat(this.mAnchorV);
        parcel.writeInt(this.mRadiusFillColor);
        parcel.writeInt(this.mStrokeColor);
        parcel.writeFloat(this.mStrokeWidth);
        parcel.writeInt(this.mLocationType);
        parcel.writeLong(this.interval);
        parcel.writeBooleanArray(new boolean[]{this.myLocationVisible});
    }
}
