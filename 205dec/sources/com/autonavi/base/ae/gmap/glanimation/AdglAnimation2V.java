package com.autonavi.base.ae.gmap.glanimation;

import android.os.SystemClock;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class AdglAnimation2V extends AbstractAdglAnimation {
    private double curValue1;
    private double curValue2;
    private AbstractAdglAnimationParam2V v2Param = null;

    public AdglAnimation2V(int i4) {
        reset();
        this.duration = i4;
        this.curValue1 = 0.0d;
        this.curValue2 = 0.0d;
    }

    @Override // com.autonavi.base.ae.gmap.glanimation.AbstractAdglAnimation
    public void doAnimation(Object obj) {
        if (this.isOver) {
            return;
        }
        long uptimeMillis = SystemClock.uptimeMillis() - this.startTime;
        this.offsetTime = uptimeMillis;
        float f4 = ((float) uptimeMillis) / this.duration;
        if (f4 > 1.0f) {
            this.isOver = true;
            f4 = 1.0f;
        } else if (f4 < 0.0f) {
            this.isOver = true;
            return;
        }
        AbstractAdglAnimationParam2V abstractAdglAnimationParam2V = this.v2Param;
        if (abstractAdglAnimationParam2V != null) {
            abstractAdglAnimationParam2V.setNormalizedTime(f4);
            this.curValue1 = this.v2Param.getCurXValue();
            this.curValue2 = this.v2Param.getCurYValue();
        }
    }

    public double getCurValue(int i4) {
        if (i4 == 0) {
            return this.curValue1;
        }
        return this.curValue2;
    }

    public double getEndValue(int i4) {
        if (i4 == 0) {
            AbstractAdglAnimationParam2V abstractAdglAnimationParam2V = this.v2Param;
            if (abstractAdglAnimationParam2V != null) {
                return abstractAdglAnimationParam2V.getToXValue();
            }
            return 0.0d;
        }
        AbstractAdglAnimationParam2V abstractAdglAnimationParam2V2 = this.v2Param;
        if (abstractAdglAnimationParam2V2 != null) {
            return abstractAdglAnimationParam2V2.getToYValue();
        }
        return 0.0d;
    }

    public double getStartValue(int i4) {
        if (i4 == 0) {
            AbstractAdglAnimationParam2V abstractAdglAnimationParam2V = this.v2Param;
            if (abstractAdglAnimationParam2V != null) {
                return abstractAdglAnimationParam2V.getFromXValue();
            }
            return 0.0d;
        }
        AbstractAdglAnimationParam2V abstractAdglAnimationParam2V2 = this.v2Param;
        if (abstractAdglAnimationParam2V2 != null) {
            return abstractAdglAnimationParam2V2.getFromYValue();
        }
        return 0.0d;
    }

    public void reset() {
        this.isOver = false;
        this.duration = 0;
        this.curValue1 = 0.0d;
        this.curValue2 = 0.0d;
        AbstractAdglAnimationParam2V abstractAdglAnimationParam2V = this.v2Param;
        if (abstractAdglAnimationParam2V != null) {
            abstractAdglAnimationParam2V.reset();
        }
    }
}
