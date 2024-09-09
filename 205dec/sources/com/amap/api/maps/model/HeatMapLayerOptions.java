package com.amap.api.maps.model;

import android.graphics.Color;
import android.util.Log;
import com.autonavi.base.amap.mapcore.jbinding.JBindingExclude;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;
import java.util.ArrayList;
import java.util.Collection;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
@JBindingInclude
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class HeatMapLayerOptions extends BaseOptions {
    @JBindingExclude
    public static final Gradient DEFAULT_GRADIENT;
    @JBindingExclude
    private static final int[] DEFAULT_GRADIENT_COLORS;
    @JBindingExclude
    private static final float[] DEFAULT_GRADIENT_START_POINTS;
    @JBindingExclude
    public static final double DEFAULT_OPACITY = 0.6d;
    @JBindingExclude
    public static final int DEFAULT_RADIUS = 12;
    @JBindingExclude
    public static final int TYPE_GRID = 1;
    @JBindingExclude
    public static final int TYPE_HEXAGON = 2;
    @JBindingExclude
    public static final int TYPE_NORMAL = 0;
    private int[] mColors;
    @JBindingExclude
    private Collection<WeightedLatLng> mData;
    private double mLatitude;
    private float[] mStartPoints;
    private double[] pointList;
    @JBindingExclude
    private Gradient mGradient = DEFAULT_GRADIENT;
    private float mSize = 2000.0f;
    private float mOpacity = 1.0f;
    private double maxIntensity = 0.0d;
    private float maxZoom = 20.0f;
    private float minZoom = 3.0f;
    private float mGap = 0.0f;
    private int mType = 2;
    private float zIndex = 0.0f;
    private boolean isVisible = true;
    private boolean isPointsUpdated = false;

    static {
        int[] iArr = {Color.rgb(102, 225, 0), Color.rgb(255, 0, 0)};
        DEFAULT_GRADIENT_COLORS = iArr;
        float[] fArr = {0.2f, 1.0f};
        DEFAULT_GRADIENT_START_POINTS = fArr;
        DEFAULT_GRADIENT = new Gradient(iArr, fArr);
    }

    public HeatMapLayerOptions() {
        this.type = "HeatMapLayerOptions";
    }

    private static Collection<WeightedLatLng> a(Collection<LatLng> collection) {
        ArrayList arrayList = new ArrayList();
        for (LatLng latLng : collection) {
            arrayList.add(new WeightedLatLng(latLng));
        }
        return arrayList;
    }

    public HeatMapLayerOptions data(Collection<LatLng> collection) {
        return weightedData(a(collection));
    }

    public HeatMapLayerOptions gap(float f4) {
        this.mGap = f4;
        return this;
    }

    public Collection<WeightedLatLng> getData() {
        return this.mData;
    }

    public float getGap() {
        return this.mGap;
    }

    public Gradient getGradient() {
        return this.mGradient;
    }

    public double getMaxIntensity() {
        return this.maxIntensity;
    }

    public float getMaxZoom() {
        return this.maxZoom;
    }

    public float getMinZoom() {
        return this.minZoom;
    }

    public float getOpacity() {
        return this.mOpacity;
    }

    public float getSize() {
        return this.mSize;
    }

    public int getType() {
        return this.mType;
    }

    public float getZIndex() {
        return this.zIndex;
    }

    public HeatMapLayerOptions gradient(Gradient gradient) {
        this.mGradient = gradient;
        if (gradient != null) {
            this.mColors = gradient.getColors();
            this.mStartPoints = this.mGradient.getStartPoints();
        }
        return this;
    }

    public boolean isVisible() {
        return this.isVisible;
    }

    public HeatMapLayerOptions maxIntensity(double d4) {
        this.maxIntensity = d4;
        return this;
    }

    public HeatMapLayerOptions maxZoom(float f4) {
        this.maxZoom = f4;
        return this;
    }

    public HeatMapLayerOptions minZoom(float f4) {
        this.minZoom = f4;
        return this;
    }

    public HeatMapLayerOptions opacity(float f4) {
        this.mOpacity = Math.max(0.0f, Math.min(f4, 1.0f));
        return this;
    }

    public HeatMapLayerOptions size(float f4) {
        this.mSize = f4;
        return this;
    }

    public HeatMapLayerOptions type(int i4) {
        this.mType = i4;
        return this;
    }

    public HeatMapLayerOptions visible(boolean z3) {
        this.isVisible = z3;
        return this;
    }

    public HeatMapLayerOptions weightedData(Collection<WeightedLatLng> collection) {
        this.mData = collection;
        this.isPointsUpdated = true;
        a();
        return this;
    }

    public HeatMapLayerOptions zIndex(float f4) {
        this.zIndex = f4;
        return this;
    }

    private void a() {
        Collection<WeightedLatLng> data;
        LatLng latLng;
        if (!this.isPointsUpdated || (data = getData()) == null) {
            return;
        }
        this.pointList = new double[data.size() * 3];
        int i4 = 0;
        double d4 = Double.NaN;
        double d5 = Double.NaN;
        for (WeightedLatLng weightedLatLng : data) {
            if (weightedLatLng != null && (latLng = weightedLatLng.latLng) != null) {
                double[] dArr = this.pointList;
                int i5 = i4 * 3;
                double d6 = latLng.latitude;
                dArr[i5] = d6;
                dArr[i5 + 1] = latLng.longitude;
                dArr[i5 + 2] = weightedLatLng.intensity;
                i4++;
                if (Double.isNaN(d4)) {
                    d4 = d6;
                }
                if (Double.isNaN(d5)) {
                    d5 = d6;
                }
                if (d6 > d5) {
                    d5 = d6;
                }
                if (d6 < d4) {
                    d4 = d6;
                }
            } else {
                Log.e("mapcore", "read file failed");
            }
        }
        this.mLatitude = (Double.isNaN(d4) || Double.isNaN(d5)) ? 0.0d : (d4 + d5) / 2.0d;
    }
}
