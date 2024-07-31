package com.amap.api.maps.model;

import com.amap.api.col.p0463l.C1732a3;
import com.autonavi.amap.mapcore.DPoint;
import com.github.mikephil.charting.utils.Utils;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class WeightedLatLng {
    public static final double DEFAULT_INTENSITY = 1.0d;
    public final double intensity;
    public final LatLng latLng;
    private DPoint mPoint;

    public WeightedLatLng(LatLng latLng, double d) {
        if (latLng != null) {
            this.latLng = latLng;
            this.mPoint = C1732a3.m55690t(latLng);
            if (d >= Utils.DOUBLE_EPSILON) {
                this.intensity = d;
                return;
            } else {
                this.intensity = 1.0d;
                return;
            }
        }
        throw new IllegalArgumentException("latLng can not null");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public DPoint getPoint() {
        return this.mPoint;
    }

    public WeightedLatLng(LatLng latLng) {
        this(latLng, 1.0d);
    }
}
