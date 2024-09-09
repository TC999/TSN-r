package com.github.mikephil.charting.animation;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import androidx.annotation.RequiresApi;
import com.github.mikephil.charting.animation.Easing;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class ChartAnimator {
    private ValueAnimator.AnimatorUpdateListener mListener;
    protected float mPhaseY = 1.0f;
    protected float mPhaseX = 1.0f;

    public ChartAnimator() {
    }

    @RequiresApi(11)
    private ObjectAnimator xAnimator(int i4, Easing.EasingFunction easingFunction) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "phaseX", 0.0f, 1.0f);
        ofFloat.setInterpolator(easingFunction);
        ofFloat.setDuration(i4);
        return ofFloat;
    }

    @RequiresApi(11)
    private ObjectAnimator yAnimator(int i4, Easing.EasingFunction easingFunction) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "phaseY", 0.0f, 1.0f);
        ofFloat.setInterpolator(easingFunction);
        ofFloat.setDuration(i4);
        return ofFloat;
    }

    @RequiresApi(11)
    public void animateX(int i4) {
        animateX(i4, Easing.Linear);
    }

    @RequiresApi(11)
    public void animateXY(int i4, int i5) {
        Easing.EasingFunction easingFunction = Easing.Linear;
        animateXY(i4, i5, easingFunction, easingFunction);
    }

    @RequiresApi(11)
    public void animateY(int i4) {
        animateY(i4, Easing.Linear);
    }

    public float getPhaseX() {
        return this.mPhaseX;
    }

    public float getPhaseY() {
        return this.mPhaseY;
    }

    public void setPhaseX(float f4) {
        if (f4 > 1.0f) {
            f4 = 1.0f;
        } else if (f4 < 0.0f) {
            f4 = 0.0f;
        }
        this.mPhaseX = f4;
    }

    public void setPhaseY(float f4) {
        if (f4 > 1.0f) {
            f4 = 1.0f;
        } else if (f4 < 0.0f) {
            f4 = 0.0f;
        }
        this.mPhaseY = f4;
    }

    @RequiresApi(11)
    public void animateX(int i4, Easing.EasingFunction easingFunction) {
        ObjectAnimator xAnimator = xAnimator(i4, easingFunction);
        xAnimator.addUpdateListener(this.mListener);
        xAnimator.start();
    }

    @RequiresApi(11)
    public void animateXY(int i4, int i5, Easing.EasingFunction easingFunction) {
        ObjectAnimator xAnimator = xAnimator(i4, easingFunction);
        ObjectAnimator yAnimator = yAnimator(i5, easingFunction);
        if (i4 > i5) {
            xAnimator.addUpdateListener(this.mListener);
        } else {
            yAnimator.addUpdateListener(this.mListener);
        }
        xAnimator.start();
        yAnimator.start();
    }

    @RequiresApi(11)
    public void animateY(int i4, Easing.EasingFunction easingFunction) {
        ObjectAnimator yAnimator = yAnimator(i4, easingFunction);
        yAnimator.addUpdateListener(this.mListener);
        yAnimator.start();
    }

    @RequiresApi(11)
    public ChartAnimator(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.mListener = animatorUpdateListener;
    }

    @RequiresApi(11)
    public void animateXY(int i4, int i5, Easing.EasingFunction easingFunction, Easing.EasingFunction easingFunction2) {
        ObjectAnimator xAnimator = xAnimator(i4, easingFunction);
        ObjectAnimator yAnimator = yAnimator(i5, easingFunction2);
        if (i4 > i5) {
            xAnimator.addUpdateListener(this.mListener);
        } else {
            yAnimator.addUpdateListener(this.mListener);
        }
        xAnimator.start();
        yAnimator.start();
    }
}
