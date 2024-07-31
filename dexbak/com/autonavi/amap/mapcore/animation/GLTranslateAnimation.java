package com.autonavi.amap.mapcore.animation;

import com.amap.api.maps.model.LatLng;
import com.github.mikephil.charting.utils.Utils;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class GLTranslateAnimation extends GLAnimation {
    public double mToXDelta;
    public double mToYDelta;
    public double mFromXDelta = Utils.DOUBLE_EPSILON;
    public double mFromYDelta = Utils.DOUBLE_EPSILON;
    public double mCurXDelta = Utils.DOUBLE_EPSILON;
    public double mCurYDelta = Utils.DOUBLE_EPSILON;

    public GLTranslateAnimation(LatLng latLng) {
        this.mToXDelta = Utils.DOUBLE_EPSILON;
        this.mToYDelta = Utils.DOUBLE_EPSILON;
        this.mToXDelta = latLng.longitude;
        this.mToYDelta = latLng.latitude;
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    protected void applyTransformation(float f, GLTransformation gLTransformation) {
        double d = this.mFromXDelta;
        this.mCurXDelta = d;
        double d2 = this.mFromYDelta;
        this.mCurYDelta = d2;
        double d3 = this.mToXDelta;
        if (d != d3) {
            double d4 = f;
            Double.isNaN(d4);
            this.mCurXDelta = d + ((d3 - d) * d4);
        }
        double d5 = this.mToYDelta;
        if (d2 != d5) {
            double d6 = f;
            Double.isNaN(d6);
            this.mCurYDelta = d2 + ((d5 - d2) * d6);
        }
        gLTransformation.f7979x = this.mCurXDelta;
        gLTransformation.f7980y = this.mCurYDelta;
    }

    public void setFromPoint(LatLng latLng) {
        this.mFromXDelta = latLng.longitude;
        this.mFromYDelta = latLng.latitude;
    }
}
