package com.autonavi.amap.mapcore.animation;

import com.amap.api.maps.model.LatLng;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class GLTranslateAnimation extends GLAnimation {
    public double mToXDelta;
    public double mToYDelta;
    public double mFromXDelta = 0.0d;
    public double mFromYDelta = 0.0d;
    public double mCurXDelta = 0.0d;
    public double mCurYDelta = 0.0d;

    public GLTranslateAnimation(LatLng latLng) {
        this.mToXDelta = 0.0d;
        this.mToYDelta = 0.0d;
        this.mToXDelta = latLng.longitude;
        this.mToYDelta = latLng.latitude;
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    protected void applyTransformation(float f4, GLTransformation gLTransformation) {
        double d4 = this.mFromXDelta;
        this.mCurXDelta = d4;
        double d5 = this.mFromYDelta;
        this.mCurYDelta = d5;
        double d6 = this.mToXDelta;
        if (d4 != d6) {
            double d7 = f4;
            Double.isNaN(d7);
            this.mCurXDelta = d4 + ((d6 - d4) * d7);
        }
        double d8 = this.mToYDelta;
        if (d5 != d8) {
            double d9 = f4;
            Double.isNaN(d9);
            this.mCurYDelta = d5 + ((d8 - d5) * d9);
        }
        gLTransformation.f11673x = this.mCurXDelta;
        gLTransformation.f11674y = this.mCurYDelta;
    }

    public void setFromPoint(LatLng latLng) {
        this.mFromXDelta = latLng.longitude;
        this.mFromYDelta = latLng.latitude;
    }
}
