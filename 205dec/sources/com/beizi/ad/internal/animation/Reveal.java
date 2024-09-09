package com.beizi.ad.internal.animation;

import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.Interpolator;
import android.view.animation.TranslateAnimation;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class Reveal implements Transition {
    private Animation inAnimation;
    private Animation outAnimation;
    private static final float[] up_coordinates = {0.0f, 0.0f, 0.0f, -1.0f};
    private static final float[] down_coordinates = {0.0f, 0.0f, 0.0f, 1.0f};
    private static final float[] right_coordinates = {0.0f, 1.0f, 0.0f, 0.0f};
    private static final float[] left_coordinates = {0.0f, -1.0f, 0.0f, 0.0f};

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* renamed from: com.beizi.ad.internal.animation.Reveal$1  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$beizi$ad$internal$animation$TransitionDirection;

        static {
            int[] iArr = new int[TransitionDirection.values().length];
            $SwitchMap$com$beizi$ad$internal$animation$TransitionDirection = iArr;
            try {
                iArr[TransitionDirection.UP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$beizi$ad$internal$animation$TransitionDirection[TransitionDirection.DOWN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$beizi$ad$internal$animation$TransitionDirection[TransitionDirection.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$beizi$ad$internal$animation$TransitionDirection[TransitionDirection.LEFT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public Reveal(long j4, TransitionDirection transitionDirection) {
        AccelerateInterpolator accelerateInterpolator = new AccelerateInterpolator();
        setInAnimation(accelerateInterpolator, j4);
        setOutAnimation(getDirection(transitionDirection), accelerateInterpolator, j4);
    }

    private float[] getDirection(TransitionDirection transitionDirection) {
        int i4 = AnonymousClass1.$SwitchMap$com$beizi$ad$internal$animation$TransitionDirection[transitionDirection.ordinal()];
        if (i4 != 1) {
            if (i4 != 2) {
                if (i4 != 3) {
                    if (i4 != 4) {
                        return up_coordinates;
                    }
                    return left_coordinates;
                }
                return right_coordinates;
            }
            return down_coordinates;
        }
        return up_coordinates;
    }

    private void setInAnimation(Interpolator interpolator, long j4) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        this.inAnimation = alphaAnimation;
        alphaAnimation.setDuration(j4);
        this.inAnimation.setInterpolator(interpolator);
    }

    private void setOutAnimation(float[] fArr, Interpolator interpolator, long j4) {
        TranslateAnimation translateAnimation = new TranslateAnimation(2, fArr[0], 2, fArr[1], 2, fArr[2], 2, fArr[3]);
        translateAnimation.setInterpolator(interpolator);
        translateAnimation.setDuration(j4);
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(j4);
        alphaAnimation.setInterpolator(interpolator);
        AnimationSet animationSet = new AnimationSet(false);
        animationSet.addAnimation(translateAnimation);
        animationSet.addAnimation(alphaAnimation);
        this.outAnimation = animationSet;
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