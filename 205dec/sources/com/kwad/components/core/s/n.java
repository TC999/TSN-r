package com.kwad.components.core.s;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import androidx.annotation.Nullable;
import androidx.core.view.animation.PathInterpolatorCompat;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class n {
    public static Animator a(View view, @Nullable Interpolator interpolator, long j4, float f4) {
        AnimatorSet animatorSet = new AnimatorSet();
        Interpolator create = interpolator == null ? PathInterpolatorCompat.create(0.22f, 0.59f, 0.36f, 1.0f) : interpolator;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 1.0f);
        ofFloat.setDuration(300L);
        ObjectAnimator duration = ObjectAnimator.ofFloat(view, "rotation", 0.0f, f4).setDuration(j4);
        float f5 = -f4;
        long j5 = j4 * 2;
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(view, "rotation", f4, f5).setDuration(j5);
        duration2.setInterpolator(create);
        ObjectAnimator duration3 = ObjectAnimator.ofFloat(view, "rotation", f5, f4).setDuration(j5);
        ObjectAnimator duration4 = ObjectAnimator.ofFloat(view, "rotation", f4, f5).setDuration(j5);
        duration4.setInterpolator(create);
        animatorSet.playSequentially(ofFloat, duration, duration2, duration3, duration4, ObjectAnimator.ofFloat(view, "rotation", f5, 0.0f).setDuration(j4));
        return animatorSet;
    }

    public static ValueAnimator b(final View view, int i4, final int i5) {
        k(view, i4);
        ValueAnimator ofInt = ValueAnimator.ofInt(i4, i5);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.core.s.n.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                n.k(view, ((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        });
        ofInt.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.core.s.n.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationCancel(Animator animator) {
                n.k(view, i5);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                n.k(view, i5);
            }
        });
        return ofInt;
    }

    public static ValueAnimator c(final View view, int i4, int i5) {
        ValueAnimator ofInt = ObjectAnimator.ofInt(i4, i5);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.core.s.n.5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                view.setTranslationY(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        });
        return ofInt;
    }

    public static ValueAnimator h(final View view, final boolean z3) {
        float[] fArr = new float[2];
        fArr[0] = z3 ? 0.0f : 1.0f;
        fArr[1] = z3 ? 1.0f : 0.0f;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(fArr);
        ofFloat.setInterpolator(PathInterpolatorCompat.create(0.45f, 0.0f, 0.6f, 1.0f));
        ofFloat.setDuration(300L);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.core.s.n.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                view.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.core.s.n.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (z3) {
                    return;
                }
                view.setAlpha(0.0f);
                view.setVisibility(8);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                if (z3) {
                    view.setAlpha(0.0f);
                    view.setVisibility(0);
                }
            }
        });
        return ofFloat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void k(View view, int i4) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = i4;
        view.setLayoutParams(layoutParams);
    }

    public static Animator a(View view, @Nullable Interpolator interpolator, float f4, float f5) {
        if (view == null) {
            return null;
        }
        Interpolator create = PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationY", f4, f5);
        ofFloat.setDuration(300L);
        ofFloat.setInterpolator(create);
        return ofFloat;
    }
}
