package com.amap.api.maps.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.col.p0003l.a3;
import com.amap.api.maps.model.BaseOptions;
import com.autonavi.base.amap.mapcore.jbinding.JBindingExclude;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
@JBindingInclude
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class CircleOptions extends BaseOptions implements Parcelable, Cloneable {
    @JBindingExclude
    public static final CircleOptionsCreator CREATOR = new CircleOptionsCreator();
    @JBindingExclude

    /* renamed from: a  reason: collision with root package name */
    String f10732a;
    private LatLng point = null;
    private double radius = 0.0d;
    private float strokeWidth = 10.0f;
    private int strokeColor = -16777216;
    private int fillColor = 0;
    private float zIndex = 0.0f;
    private boolean isVisible = true;
    private int dottedLineType = -1;
    private boolean isUsePolylineStroke = true;
    private CircleUpdateFlags updateFlags = new CircleUpdateFlags();
    private List<BaseHoleOptions> holeOptions = new ArrayList();

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    @JBindingInclude
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class CircleUpdateFlags extends BaseOptions.BaseUpdateFlags {
        protected boolean isCenterUpdated = false;
        protected boolean isRadiusUpdated = false;
        protected boolean isHoleOptionsUpdated = false;

        protected CircleUpdateFlags() {
        }

        @Override // com.amap.api.maps.model.BaseOptions.BaseUpdateFlags
        public void reset() {
            super.reset();
            this.isCenterUpdated = false;
            this.isRadiusUpdated = false;
            this.isHoleOptionsUpdated = false;
        }
    }

    public CircleOptions() {
        this.type = "CircleOptions";
    }

    private void a() {
        if (this.holeOptions != null) {
            ArrayList arrayList = new ArrayList();
            List<BaseHoleOptions> list = this.holeOptions;
            for (int i4 = 0; i4 < list.size(); i4++) {
                BaseHoleOptions baseHoleOptions = list.get(i4);
                if (baseHoleOptions instanceof PolygonHoleOptions) {
                    PolygonHoleOptions polygonHoleOptions = (PolygonHoleOptions) baseHoleOptions;
                    if (a3.H(getRadius(), getCenter(), arrayList, polygonHoleOptions) && !a3.O(arrayList, polygonHoleOptions)) {
                        arrayList.add(polygonHoleOptions);
                    }
                } else if (baseHoleOptions instanceof CircleHoleOptions) {
                    CircleHoleOptions circleHoleOptions = (CircleHoleOptions) baseHoleOptions;
                    if (a3.F(getRadius(), getCenter(), circleHoleOptions) && !a3.N(arrayList, circleHoleOptions)) {
                        arrayList.add(circleHoleOptions);
                    }
                }
            }
            this.holeOptions.clear();
            this.holeOptions.addAll(arrayList);
            this.updateFlags.isHoleOptionsUpdated = true;
        }
    }

    public final CircleOptions addHoles(BaseHoleOptions... baseHoleOptionsArr) {
        if (baseHoleOptionsArr != null) {
            try {
                this.holeOptions.addAll(Arrays.asList(baseHoleOptionsArr));
                a();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return this;
    }

    public final CircleOptions center(LatLng latLng) {
        this.point = latLng;
        this.updateFlags.isCenterUpdated = true;
        a();
        return this;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final CircleOptions fillColor(int i4) {
        this.fillColor = i4;
        return this;
    }

    public final LatLng getCenter() {
        return this.point;
    }

    public final int getFillColor() {
        return this.fillColor;
    }

    public final List<BaseHoleOptions> getHoleOptions() {
        return this.holeOptions;
    }

    public final double getRadius() {
        return this.radius;
    }

    public final int getStrokeColor() {
        return this.strokeColor;
    }

    public final int getStrokeDottedLineType() {
        return this.dottedLineType;
    }

    public final float getStrokeWidth() {
        return this.strokeWidth;
    }

    public final float getZIndex() {
        return this.zIndex;
    }

    public final boolean isUsePolylineStroke() {
        return this.isUsePolylineStroke;
    }

    public final boolean isVisible() {
        return this.isVisible;
    }

    public final CircleOptions radius(double d4) {
        this.radius = d4;
        this.updateFlags.isRadiusUpdated = true;
        a();
        return this;
    }

    @Override // com.amap.api.maps.model.BaseOptions
    public final void resetUpdateFlags() {
        this.updateFlags.reset();
    }

    public final CircleOptions setStrokeDottedLineType(int i4) {
        this.dottedLineType = i4;
        return this;
    }

    public final CircleOptions strokeColor(int i4) {
        this.strokeColor = i4;
        return this;
    }

    public final CircleOptions strokeWidth(float f4) {
        this.strokeWidth = f4;
        return this;
    }

    public final CircleOptions usePolylineStroke(boolean z3) {
        this.isUsePolylineStroke = z3;
        return this;
    }

    public final CircleOptions visible(boolean z3) {
        this.isVisible = z3;
        return this;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        Bundle bundle = new Bundle();
        LatLng latLng = this.point;
        if (latLng != null) {
            bundle.putDouble("lat", latLng.latitude);
            bundle.putDouble("lng", this.point.longitude);
        }
        parcel.writeBundle(bundle);
        parcel.writeDouble(this.radius);
        parcel.writeFloat(this.strokeWidth);
        parcel.writeInt(this.strokeColor);
        parcel.writeInt(this.fillColor);
        parcel.writeFloat(this.zIndex);
        parcel.writeByte(this.isVisible ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f10732a);
        parcel.writeList(this.holeOptions);
        parcel.writeInt(this.dottedLineType);
        parcel.writeByte(this.isUsePolylineStroke ? (byte) 1 : (byte) 0);
    }

    public final CircleOptions zIndex(float f4) {
        if (this.zIndex != f4) {
            this.updateFlags.zIndexUpdate = true;
        }
        this.zIndex = f4;
        return this;
    }

    /* renamed from: clone */
    public final CircleOptions m20clone() {
        try {
            super.clone();
        } catch (CloneNotSupportedException e4) {
            e4.printStackTrace();
        }
        CircleOptions circleOptions = new CircleOptions();
        circleOptions.f10732a = this.f10732a;
        circleOptions.point = this.point;
        circleOptions.radius = this.radius;
        circleOptions.strokeWidth = this.strokeWidth;
        circleOptions.strokeColor = this.strokeColor;
        circleOptions.fillColor = this.fillColor;
        circleOptions.zIndex = this.zIndex;
        circleOptions.isVisible = this.isVisible;
        circleOptions.holeOptions = this.holeOptions;
        circleOptions.dottedLineType = this.dottedLineType;
        circleOptions.isUsePolylineStroke = this.isUsePolylineStroke;
        circleOptions.updateFlags = this.updateFlags;
        return circleOptions;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.amap.api.maps.model.BaseOptions
    public final CircleUpdateFlags getUpdateFlags() {
        return this.updateFlags;
    }

    public final CircleOptions addHoles(Iterable<BaseHoleOptions> iterable) {
        if (iterable != null) {
            try {
                for (BaseHoleOptions baseHoleOptions : iterable) {
                    this.holeOptions.add(baseHoleOptions);
                }
                a();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return this;
    }
}
