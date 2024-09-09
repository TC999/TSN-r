package com.amap.api.maps.model;

import com.amap.api.col.p0003l.a3;
import com.autonavi.amap.mapcore.DPoint;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class WeightedLatLng {
    public static final double DEFAULT_INTENSITY = 1.0d;
    public final double intensity;
    public final LatLng latLng;
    private DPoint mPoint;

    public WeightedLatLng(LatLng latLng, double d4) {
        if (latLng != null) {
            this.latLng = latLng;
            this.mPoint = a3.t(latLng);
            if (d4 >= 0.0d) {
                this.intensity = d4;
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
