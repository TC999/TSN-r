package com.autonavi.base.ae.gmap.glanimation;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class AbstractAdglAnimationParam1V extends AbstractAdglAnimationParam {
    private float fromValue;
    private float toValue;

    public AbstractAdglAnimationParam1V() {
        reset();
    }

    @Override // com.autonavi.base.ae.gmap.glanimation.AbstractAdglAnimationParam
    public void checkParam() {
        this.needToCaculate = false;
        if (this.hasFromValue && this.hasToValue && Math.abs(this.toValue - this.fromValue) > 1.0E-4d) {
            this.needToCaculate = true;
        }
        this.hasCheckedParam = true;
    }

    public float getCurValue() {
        float f4 = this.fromValue;
        return f4 + ((this.toValue - f4) * this.mult);
    }

    public float getFromValue() {
        return this.fromValue;
    }

    public float getToValue() {
        return this.toValue;
    }

    @Override // com.autonavi.base.ae.gmap.glanimation.AbstractAdglAnimationParam
    public void reset() {
        super.reset();
        this.fromValue = 0.0f;
        this.toValue = 0.0f;
    }

    public void setFromValue(float f4) {
        this.fromValue = f4;
        this.hasFromValue = true;
        this.hasCheckedParam = false;
    }

    public void setToValue(float f4) {
        this.toValue = f4;
        this.hasToValue = true;
        this.hasCheckedParam = false;
    }
}
