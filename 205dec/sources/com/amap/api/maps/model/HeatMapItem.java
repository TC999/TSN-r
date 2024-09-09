package com.amap.api.maps.model;

import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
@JBindingInclude
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class HeatMapItem {
    private LatLng center;
    private int[] indexes;
    private double intensity;

    public LatLng getCenter() {
        return this.center;
    }

    public int[] getIndexes() {
        return this.indexes;
    }

    public double getIntensity() {
        return this.intensity;
    }

    public void setCenter(double d4, double d5) {
        this.center = new LatLng(d4, d5);
    }

    public void setIndexes(int[] iArr) {
        this.indexes = iArr;
    }

    public void setIntensity(double d4) {
        this.intensity = d4;
    }
}
