package com.beizi.p051ad.internal.animation;

import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.TranslateAnimation;

/* renamed from: com.beizi.ad.internal.animation.Push */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class Push implements Transition {
    private Animation inAnimation;
    private Animation outAnimation;
    private static final float[] in_up_coordinates = {0.0f, 0.0f, 1.0f, 0.0f};
    private static final float[] in_down_coordinates = {0.0f, 0.0f, -1.0f, 0.0f};
    private static final float[] in_right_coordinates = {-1.0f, 0.0f, 0.0f, 0.0f};
    private static final float[] in_left_coordinates = {1.0f, 0.0f, 0.0f, 0.0f};
    private static final float[] out_up_coordinates = {0.0f, 0.0f, 0.0f, -1.0f};
    private static final float[] out_down_coordinates = {0.0f, 0.0f, 0.0f, 1.0f};
    private static final float[] out_right_coordinates = {0.0f, 1.0f, 0.0f, 0.0f};
    private static final float[] out_left_coordinates = {0.0f, -1.0f, 0.0f, 0.0f};

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.beizi.ad.internal.animation.Push$1 */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static /* synthetic */ class C28601 {
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

    public Push(long j, TransitionDirection transitionDirection) {
        AccelerateInterpolator accelerateInterpolator = new AccelerateInterpolator();
        this.inAnimation = getAnimation(getInDirection(transitionDirection), accelerateInterpolator, j);
        this.outAnimation = getAnimation(getOutDirection(transitionDirection), accelerateInterpolator, j);
    }

    private Animation getAnimation(float[] fArr, Interpolator interpolator, long j) {
        TranslateAnimation translateAnimation = new TranslateAnimation(2, fArr[0], 2, fArr[1], 2, fArr[2], 2, fArr[3]);
        translateAnimation.setInterpolator(interpolator);
        translateAnimation.setDuration(j);
        return translateAnimation;
    }

    private float[] getInDirection(TransitionDirection transitionDirection) {
        int i = C28601.$SwitchMap$com$beizi$ad$internal$animation$TransitionDirection[transitionDirection.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        return in_up_coordinates;
                    }
                    return in_left_coordinates;
                }
                return in_right_coordinates;
            }
            return in_down_coordinates;
        }
        return in_up_coordinates;
    }

    private float[] getOutDirection(TransitionDirection transitionDirection) {
        int i = C28601.$SwitchMap$com$beizi$ad$internal$animation$TransitionDirection[transitionDirection.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        return out_up_coordinates;
                    }
                    return out_left_coordinates;
                }
                return out_right_coordinates;
            }
            return out_down_coordinates;
        }
        return out_up_coordinates;
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
