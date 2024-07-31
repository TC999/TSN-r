package com.amap.api.maps.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.view.ViewCompat;
import com.autonavi.base.amap.mapcore.jbinding.JBinding2cFieldOrMethod;
import com.autonavi.base.amap.mapcore.jbinding.JBindingExclude;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;

@JBindingInclude
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class ArcOptions extends BaseOptions implements Parcelable, Cloneable {
    @JBindingExclude
    public static final ArcOptionsCreator CREATOR = new ArcOptionsCreator();
    @JBindingExclude

    /* renamed from: a */
    String f7025a;
    private LatLng endpoint;
    private LatLng passedpoint;
    private LatLng startpoint;
    private float strokeWidth = 10.0f;
    private int strokeColor = ViewCompat.MEASURED_STATE_MASK;
    private float zIndex = 0.0f;
    private boolean isVisible = true;

    public ArcOptions() {
        this.type = "ArcOptions";
    }

    @Override // android.os.Parcelable
    @JBinding2cFieldOrMethod
    public final int describeContents() {
        return 0;
    }

    public final LatLng getEnd() {
        return this.endpoint;
    }

    public final LatLng getPassed() {
        return this.passedpoint;
    }

    public final LatLng getStart() {
        return this.startpoint;
    }

    public final int getStrokeColor() {
        return this.strokeColor;
    }

    public final float getStrokeWidth() {
        return this.strokeWidth;
    }

    public final float getZIndex() {
        return this.zIndex;
    }

    public final boolean isVisible() {
        return this.isVisible;
    }

    public final ArcOptions point(LatLng latLng, LatLng latLng2, LatLng latLng3) {
        this.startpoint = latLng;
        this.passedpoint = latLng2;
        this.endpoint = latLng3;
        return this;
    }

    public final ArcOptions strokeColor(int i) {
        this.strokeColor = i;
        return this;
    }

    public final ArcOptions strokeWidth(float f) {
        this.strokeWidth = f;
        return this;
    }

    public final ArcOptions visible(boolean z) {
        this.isVisible = z;
        return this;
    }

    @Override // android.os.Parcelable
    @JBindingExclude
    public final void writeToParcel(Parcel parcel, int i) {
        Bundle bundle = new Bundle();
        LatLng latLng = this.startpoint;
        if (latLng != null) {
            bundle.putDouble("startlat", latLng.latitude);
            bundle.putDouble("startlng", this.startpoint.longitude);
        }
        LatLng latLng2 = this.passedpoint;
        if (latLng2 != null) {
            bundle.putDouble("passedlat", latLng2.latitude);
            bundle.putDouble("passedlng", this.passedpoint.longitude);
        }
        LatLng latLng3 = this.endpoint;
        if (latLng3 != null) {
            bundle.putDouble("endlat", latLng3.latitude);
            bundle.putDouble("endlng", this.endpoint.longitude);
        }
        parcel.writeBundle(bundle);
        parcel.writeFloat(this.strokeWidth);
        parcel.writeInt(this.strokeColor);
        parcel.writeFloat(this.zIndex);
        parcel.writeByte(this.isVisible ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f7025a);
    }

    public final ArcOptions zIndex(float f) {
        this.zIndex = f;
        return this;
    }

    /* renamed from: clone */
    public final ArcOptions m60097clone() {
        try {
            super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        ArcOptions arcOptions = new ArcOptions();
        arcOptions.f7025a = this.f7025a;
        arcOptions.startpoint = this.startpoint;
        arcOptions.passedpoint = this.passedpoint;
        arcOptions.endpoint = this.endpoint;
        arcOptions.strokeWidth = this.strokeWidth;
        arcOptions.strokeColor = this.strokeColor;
        arcOptions.zIndex = this.zIndex;
        arcOptions.isVisible = this.isVisible;
        return arcOptions;
    }
}
