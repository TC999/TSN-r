package com.autonavi.base.p048ae.gmap.glanimation;

import android.os.SystemClock;
import com.github.mikephil.charting.utils.Utils;

/* renamed from: com.autonavi.base.ae.gmap.glanimation.AdglAnimation2V */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class AdglAnimation2V extends AbstractAdglAnimation {
    private double curValue1;
    private double curValue2;
    private AbstractAdglAnimationParam2V v2Param = null;

    public AdglAnimation2V(int i) {
        reset();
        this.duration = i;
        this.curValue1 = Utils.DOUBLE_EPSILON;
        this.curValue2 = Utils.DOUBLE_EPSILON;
    }

    @Override // com.autonavi.base.p048ae.gmap.glanimation.AbstractAdglAnimation
    public void doAnimation(Object obj) {
        if (this.isOver) {
            return;
        }
        long uptimeMillis = SystemClock.uptimeMillis() - this.startTime;
        this.offsetTime = uptimeMillis;
        float f = ((float) uptimeMillis) / this.duration;
        if (f > 1.0f) {
            this.isOver = true;
            f = 1.0f;
        } else if (f < 0.0f) {
            this.isOver = true;
            return;
        }
        AbstractAdglAnimationParam2V abstractAdglAnimationParam2V = this.v2Param;
        if (abstractAdglAnimationParam2V != null) {
            abstractAdglAnimationParam2V.setNormalizedTime(f);
            this.curValue1 = this.v2Param.getCurXValue();
            this.curValue2 = this.v2Param.getCurYValue();
        }
    }

    public double getCurValue(int i) {
        if (i == 0) {
            return this.curValue1;
        }
        return this.curValue2;
    }

    public double getEndValue(int i) {
        if (i == 0) {
            AbstractAdglAnimationParam2V abstractAdglAnimationParam2V = this.v2Param;
            return abstractAdglAnimationParam2V != null ? abstractAdglAnimationParam2V.getToXValue() : Utils.DOUBLE_EPSILON;
        }
        AbstractAdglAnimationParam2V abstractAdglAnimationParam2V2 = this.v2Param;
        return abstractAdglAnimationParam2V2 != null ? abstractAdglAnimationParam2V2.getToYValue() : Utils.DOUBLE_EPSILON;
    }

    public double getStartValue(int i) {
        if (i == 0) {
            AbstractAdglAnimationParam2V abstractAdglAnimationParam2V = this.v2Param;
            return abstractAdglAnimationParam2V != null ? abstractAdglAnimationParam2V.getFromXValue() : Utils.DOUBLE_EPSILON;
        }
        AbstractAdglAnimationParam2V abstractAdglAnimationParam2V2 = this.v2Param;
        return abstractAdglAnimationParam2V2 != null ? abstractAdglAnimationParam2V2.getFromYValue() : Utils.DOUBLE_EPSILON;
    }

    public void reset() {
        this.isOver = false;
        this.duration = 0;
        this.curValue1 = Utils.DOUBLE_EPSILON;
        this.curValue2 = Utils.DOUBLE_EPSILON;
        AbstractAdglAnimationParam2V abstractAdglAnimationParam2V = this.v2Param;
        if (abstractAdglAnimationParam2V != null) {
            abstractAdglAnimationParam2V.reset();
        }
    }
}
