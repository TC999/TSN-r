package com.amap.api.maps.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.view.ViewCompat;
import com.amap.api.col.p0463l.C1732a3;
import com.amap.api.maps.model.BaseOptions;
import com.autonavi.base.amap.mapcore.jbinding.JBindingExclude;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;
import com.github.mikephil.charting.utils.Utils;
import com.umeng.analytics.pro.UContent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@JBindingInclude
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class CircleOptions extends BaseOptions implements Parcelable, Cloneable {
    @JBindingExclude
    public static final CircleOptionsCreator CREATOR = new CircleOptionsCreator();
    @JBindingExclude

    /* renamed from: a */
    String f7030a;
    private LatLng point = null;
    private double radius = Utils.DOUBLE_EPSILON;
    private float strokeWidth = 10.0f;
    private int strokeColor = ViewCompat.MEASURED_STATE_MASK;
    private int fillColor = 0;
    private float zIndex = 0.0f;
    private boolean isVisible = true;
    private int dottedLineType = -1;
    private boolean isUsePolylineStroke = true;
    private CircleUpdateFlags updateFlags = new CircleUpdateFlags();
    private List<BaseHoleOptions> holeOptions = new ArrayList();

    /* JADX INFO: Access modifiers changed from: protected */
    @JBindingInclude
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
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

    /* renamed from: a */
    private void m52088a() {
        if (this.holeOptions != null) {
            ArrayList arrayList = new ArrayList();
            List<BaseHoleOptions> list = this.holeOptions;
            for (int i = 0; i < list.size(); i++) {
                BaseHoleOptions baseHoleOptions = list.get(i);
                if (baseHoleOptions instanceof PolygonHoleOptions) {
                    PolygonHoleOptions polygonHoleOptions = (PolygonHoleOptions) baseHoleOptions;
                    if (C1732a3.m55737H(getRadius(), getCenter(), arrayList, polygonHoleOptions) && !C1732a3.m55730O(arrayList, polygonHoleOptions)) {
                        arrayList.add(polygonHoleOptions);
                    }
                } else if (baseHoleOptions instanceof CircleHoleOptions) {
                    CircleHoleOptions circleHoleOptions = (CircleHoleOptions) baseHoleOptions;
                    if (C1732a3.m55739F(getRadius(), getCenter(), circleHoleOptions) && !C1732a3.m55731N(arrayList, circleHoleOptions)) {
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
                m52088a();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return this;
    }

    public final CircleOptions center(LatLng latLng) {
        this.point = latLng;
        this.updateFlags.isCenterUpdated = true;
        m52088a();
        return this;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final CircleOptions fillColor(int i) {
        this.fillColor = i;
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

    public final CircleOptions radius(double d) {
        this.radius = d;
        this.updateFlags.isRadiusUpdated = true;
        m52088a();
        return this;
    }

    @Override // com.amap.api.maps.model.BaseOptions
    public final void resetUpdateFlags() {
        this.updateFlags.reset();
    }

    public final CircleOptions setStrokeDottedLineType(int i) {
        this.dottedLineType = i;
        return this;
    }

    public final CircleOptions strokeColor(int i) {
        this.strokeColor = i;
        return this;
    }

    public final CircleOptions strokeWidth(float f) {
        this.strokeWidth = f;
        return this;
    }

    public final CircleOptions usePolylineStroke(boolean z) {
        this.isUsePolylineStroke = z;
        return this;
    }

    public final CircleOptions visible(boolean z) {
        this.isVisible = z;
        return this;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        Bundle bundle = new Bundle();
        LatLng latLng = this.point;
        if (latLng != null) {
            bundle.putDouble(UContent.f38072C, latLng.latitude);
            bundle.putDouble(UContent.f38073D, this.point.longitude);
        }
        parcel.writeBundle(bundle);
        parcel.writeDouble(this.radius);
        parcel.writeFloat(this.strokeWidth);
        parcel.writeInt(this.strokeColor);
        parcel.writeInt(this.fillColor);
        parcel.writeFloat(this.zIndex);
        parcel.writeByte(this.isVisible ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f7030a);
        parcel.writeList(this.holeOptions);
        parcel.writeInt(this.dottedLineType);
        parcel.writeByte(this.isUsePolylineStroke ? (byte) 1 : (byte) 0);
    }

    public final CircleOptions zIndex(float f) {
        if (this.zIndex != f) {
            this.updateFlags.zIndexUpdate = true;
        }
        this.zIndex = f;
        return this;
    }

    /* renamed from: clone */
    public final CircleOptions m60099clone() {
        try {
            super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        CircleOptions circleOptions = new CircleOptions();
        circleOptions.f7030a = this.f7030a;
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
                m52088a();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return this;
    }
}
