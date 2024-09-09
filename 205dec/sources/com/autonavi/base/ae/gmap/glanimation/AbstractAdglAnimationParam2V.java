package com.autonavi.base.ae.gmap.glanimation;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class AbstractAdglAnimationParam2V extends AbstractAdglAnimationParam {
    public double fromXValue;
    public double fromYValue;
    public double toXValue;
    public double toYValue;

    public AbstractAdglAnimationParam2V() {
        reset();
    }

    @Override // com.autonavi.base.ae.gmap.glanimation.AbstractAdglAnimationParam
    public void checkParam() {
        this.needToCaculate = false;
        if (this.hasFromValue && this.hasToValue) {
            double d4 = this.toXValue - this.fromXValue;
            double d5 = this.toYValue - this.fromYValue;
            if (Math.abs(d4) > 1.0E-4d || Math.abs(d5) > 1.0E-4d) {
                this.needToCaculate = true;
            }
        }
        this.hasCheckedParam = true;
    }

    public double getCurXValue() {
        double d4 = this.fromXValue;
        double d5 = this.mult;
        Double.isNaN(d5);
        return d4 + ((this.toXValue - d4) * d5);
    }

    public double getCurYValue() {
        double d4 = this.fromYValue;
        double d5 = this.mult;
        Double.isNaN(d5);
        return d4 + ((this.toYValue - d4) * d5);
    }

    public double getFromXValue() {
        return this.fromXValue;
    }

    public double getFromYValue() {
        return this.fromYValue;
    }

    public double getToXValue() {
        return this.toXValue;
    }

    public double getToYValue() {
        return this.toYValue;
    }

    @Override // com.autonavi.base.ae.gmap.glanimation.AbstractAdglAnimationParam
    public void reset() {
        super.reset();
        this.fromXValue = 0.0d;
        this.toXValue = 0.0d;
        this.fromYValue = 0.0d;
        this.toYValue = 0.0d;
    }

    public void setFromValue(double d4, double d5) {
        this.fromXValue = d4;
        this.fromYValue = d5;
        this.hasFromValue = true;
        this.hasCheckedParam = false;
    }

    public void setToValue(double d4, double d5) {
        this.toXValue = d4;
        this.toYValue = d5;
        this.hasToValue = true;
        this.hasCheckedParam = false;
    }
}
