package com.beizi.p051ad.internal.animation;

import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Interpolator;

/* renamed from: com.beizi.ad.internal.animation.Fade */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class Fade implements Transition {
    private Animation inAnimation;
    private Animation outAnimation;

    public Fade(long j) {
        AccelerateInterpolator accelerateInterpolator = new AccelerateInterpolator();
        setInAnimation(accelerateInterpolator, j);
        setOutAnimation(accelerateInterpolator, j);
    }

    private void setInAnimation(Interpolator interpolator, long j) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        this.inAnimation = alphaAnimation;
        alphaAnimation.setDuration(j);
        this.inAnimation.setInterpolator(interpolator);
    }

    private void setOutAnimation(Interpolator interpolator, long j) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        this.outAnimation = alphaAnimation;
        alphaAnimation.setDuration(j);
        this.outAnimation.setInterpolator(interpolator);
    }

    @Override // com.beizi.p051ad.internal.animation.Transition
    public Animation getInAnimation() {
        return this.inAnimation;
    }

    @Override // com.beizi.p051ad.internal.animation.Transition
    public Animation getOutAnimation() {
        return this.outAnimation;
    }
}
