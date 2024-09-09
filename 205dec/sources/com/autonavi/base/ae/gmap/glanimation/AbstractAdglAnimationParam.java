package com.autonavi.base.ae.gmap.glanimation;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public abstract class AbstractAdglAnimationParam {
    protected float mult;
    protected float normalizedTime;
    protected int interpolationType = 0;
    protected float factor = 1.0f;
    protected boolean hasCheckedParam = false;
    protected boolean needToCaculate = false;
    protected boolean hasFromValue = false;
    protected boolean hasToValue = false;

    static float bounce(float f4) {
        return f4 * f4 * 8.0f;
    }

    public abstract void checkParam();

    public float getCurMult() {
        return this.mult;
    }

    public int getInterpolatorType() {
        return this.interpolationType;
    }

    public boolean needToCaculate() {
        if (!this.hasCheckedParam) {
            checkParam();
        }
        return this.hasCheckedParam && this.needToCaculate;
    }

    public void reset() {
        this.interpolationType = 0;
        this.factor = 1.0f;
        this.hasCheckedParam = false;
        this.needToCaculate = false;
        this.hasFromValue = false;
        this.hasToValue = false;
    }

    public void setInterpolatorType(int i4, float f4) {
        this.interpolationType = i4;
        this.factor = f4;
    }

    public void setNormalizedTime(float f4) {
        double pow;
        float f5;
        float bounce;
        float f6;
        this.normalizedTime = f4;
        switch (this.interpolationType) {
            case 0:
                break;
            case 1:
                pow = Math.pow(f4, this.factor * 2.0f);
                f4 = (float) pow;
                break;
            case 2:
                if (this.factor != 1.0f) {
                    f4 = (float) (1.0d - Math.pow(1.0f - f4, f5 * 2.0f));
                    break;
                } else {
                    float f7 = 1.0f - f4;
                    f4 = 1.0f - (f7 * f7);
                    break;
                }
            case 3:
                double d4 = f4 + 1.0f;
                Double.isNaN(d4);
                pow = (Math.cos(d4 * 3.141592653589793d) / 2.0d) + 0.5d;
                f4 = (float) pow;
                break;
            case 4:
                float f8 = f4 * 1.1226f;
                if (f8 >= 0.3535f) {
                    if (f8 < 0.7408f) {
                        bounce = bounce(f8 - 0.54719f);
                        f6 = 0.7f;
                    } else if (f8 < 0.9644f) {
                        bounce = bounce(f8 - 0.8526f);
                        f6 = 0.9f;
                    } else {
                        bounce = bounce(f8 - 1.0435f);
                        f6 = 0.95f;
                    }
                    f4 = bounce + f6;
                    break;
                } else {
                    f4 = bounce(f8);
                    break;
                }
            case 5:
                float f9 = f4 - 1.0f;
                f4 = (f9 * f9 * ((f9 * 3.0f) + 2.0f)) + 1.0f;
                break;
            case 6:
                if (f4 >= 0.0f) {
                    if (f4 >= 0.25f) {
                        if (f4 >= 0.5f) {
                            if (f4 >= 0.75f) {
                                if (f4 <= 1.0f) {
                                    f4 = 4.0f - (f4 * 4.0f);
                                    break;
                                }
                            } else {
                                f4 = (f4 * 4.0f) - 2.0f;
                                break;
                            }
                        } else {
                            f4 = 2.0f - (f4 * 4.0f);
                            break;
                        }
                    } else {
                        f4 *= 4.0f;
                        break;
                    }
                }
            default:
                f4 = 0.0f;
                break;
        }
        this.mult = f4;
    }
}
