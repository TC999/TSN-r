package com.beizi.ad.internal.animation;

import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Interpolator;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class Fade implements Transition {
    private Animation inAnimation;
    private Animation outAnimation;

    public Fade(long j4) {
        AccelerateInterpolator accelerateInterpolator = new AccelerateInterpolator();
        setInAnimation(accelerateInterpolator, j4);
        setOutAnimation(accelerateInterpolator, j4);
    }

    private void setInAnimation(Interpolator interpolator, long j4) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        this.inAnimation = alphaAnimation;
        alphaAnimation.setDuration(j4);
        this.inAnimation.setInterpolator(interpolator);
    }

    private void setOutAnimation(Interpolator interpolator, long j4) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        this.outAnimation = alphaAnimation;
        alphaAnimation.setDuration(j4);
        this.outAnimation.setInterpolator(interpolator);
    }

    @Override // com.beizi.ad.internal.animation.Transition
    public Animation getInAnimation() {
        return this.inAnimation;
    }

    @Override // com.beizi.ad.internal.animation.Transition
    public Animation getOutAnimation() {
        return this.outAnimation;
    }
}
