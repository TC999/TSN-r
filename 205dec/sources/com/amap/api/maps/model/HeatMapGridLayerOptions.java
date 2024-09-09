package com.amap.api.maps.model;

import com.autonavi.base.amap.mapcore.jbinding.JBindingExclude;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
@JBindingInclude
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class HeatMapGridLayerOptions extends BaseOptions {
    @JBindingExclude
    public static final int TYPE_GRID = 1;
    @JBindingExclude
    public static final int TYPE_HEXAGON = 2;
    @JBindingExclude
    public static final int TYPE_NORMAL = 0;
    private List<ColorLatLng> mData;
    private float maxZoom = 20.0f;
    private float minZoom = 3.0f;
    private float zIndex = 0.0f;
    private boolean isVisible = true;
    private int mType = 2;
    private boolean isPointsUpdated = false;

    public HeatMapGridLayerOptions() {
        this.type = "HeatMapGridLayerOptions";
    }

    public HeatMapGridLayerOptions data(List<ColorLatLng> list) {
        this.mData = list;
        this.isPointsUpdated = true;
        return this;
    }

    public List<ColorLatLng> getData() {
        return this.mData;
    }

    public float getMaxZoom() {
        return this.maxZoom;
    }

    public float getMinZoom() {
        return this.minZoom;
    }

    public int getType() {
        return this.mType;
    }

    public float getZIndex() {
        return this.zIndex;
    }

    public boolean isVisible() {
        return this.isVisible;
    }

    public HeatMapGridLayerOptions maxZoom(float f4) {
        this.maxZoom = f4;
        return this;
    }

    public HeatMapGridLayerOptions minZoom(float f4) {
        this.minZoom = f4;
        return this;
    }

    public HeatMapGridLayerOptions type(int i4) {
        this.mType = i4;
        return this;
    }

    public HeatMapGridLayerOptions visible(boolean z3) {
        this.isVisible = z3;
        return this;
    }

    public HeatMapGridLayerOptions zIndex(float f4) {
        this.zIndex = f4;
        return this;
    }
}
