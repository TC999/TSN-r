package com.mbridge.msdk.widget.custom.baseview;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.drawable.GradientDrawable;
import android.widget.TextView;

/* renamed from: com.mbridge.msdk.widget.custom.baseview.c */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
final class MorphingAnimation {

    /* renamed from: a */
    private OnAnimationEndListener f32584a;

    /* renamed from: b */
    private int f32585b;

    /* renamed from: c */
    private int f32586c;

    /* renamed from: d */
    private int f32587d;

    /* renamed from: e */
    private int f32588e;

    /* renamed from: f */
    private int f32589f;

    /* renamed from: g */
    private int f32590g;

    /* renamed from: h */
    private int f32591h;

    /* renamed from: i */
    private float f32592i;

    /* renamed from: j */
    private float f32593j;

    /* renamed from: k */
    private float f32594k;

    /* renamed from: l */
    private TextView f32595l;

    /* renamed from: m */
    private StrokeGradientDrawable f32596m;

    public MorphingAnimation(TextView textView, StrokeGradientDrawable strokeGradientDrawable) {
        this.f32595l = textView;
        this.f32596m = strokeGradientDrawable;
    }

    /* renamed from: f */
    public final void m20519f(int i) {
        this.f32590g = i;
    }

    /* renamed from: g */
    public final void m20518g(int i) {
        this.f32591h = i;
    }

    /* renamed from: a */
    public final void m20532a(int i) {
        this.f32585b = i;
    }

    /* renamed from: b */
    public final void m20528b(int i) {
        this.f32586c = i;
    }

    /* renamed from: c */
    public final void m20525c(int i) {
        this.f32587d = i;
    }

    /* renamed from: d */
    public final void m20523d(int i) {
        this.f32588e = i;
    }

    /* renamed from: e */
    public final void m20521e(int i) {
        this.f32589f = i;
    }

    /* renamed from: a */
    public final void m20530a(OnAnimationEndListener onAnimationEndListener) {
        this.f32584a = onAnimationEndListener;
    }

    /* renamed from: b */
    public final void m20529b(float f) {
        this.f32593j = f;
    }

    /* renamed from: c */
    public final void m20526c(float f) {
        this.f32594k = f;
    }

    /* renamed from: a */
    public final void m20533a(float f) {
        this.f32592i = f;
    }

    /* renamed from: a */
    public final void m20534a() {
        ValueAnimator ofInt = ValueAnimator.ofInt(this.f32586c, this.f32587d);
        final GradientDrawable m20514a = this.f32596m.m20514a();
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.mbridge.msdk.widget.custom.baseview.c.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                int intValue;
                int i;
                float animatedFraction;
                Integer num = (Integer) valueAnimator.getAnimatedValue();
                if (MorphingAnimation.this.f32586c > MorphingAnimation.this.f32587d) {
                    intValue = (MorphingAnimation.this.f32586c - num.intValue()) / 2;
                    i = MorphingAnimation.this.f32586c - intValue;
                    animatedFraction = MorphingAnimation.this.f32594k * valueAnimator.getAnimatedFraction();
                } else {
                    intValue = (MorphingAnimation.this.f32587d - num.intValue()) / 2;
                    i = MorphingAnimation.this.f32587d - intValue;
                    animatedFraction = MorphingAnimation.this.f32594k - (MorphingAnimation.this.f32594k * valueAnimator.getAnimatedFraction());
                }
                int i2 = (int) animatedFraction;
                m20514a.setBounds(intValue + i2, i2, i - i2, MorphingAnimation.this.f32595l.getHeight() - i2);
            }
        });
        ObjectAnimator ofInt2 = ObjectAnimator.ofInt(m20514a, "color", this.f32588e, this.f32589f);
        ofInt2.setEvaluator(new ArgbEvaluator());
        ObjectAnimator ofInt3 = ObjectAnimator.ofInt(this.f32596m, "strokeColor", this.f32590g, this.f32591h);
        ofInt3.setEvaluator(new ArgbEvaluator());
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(m20514a, "cornerRadius", this.f32592i, this.f32593j);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(this.f32585b);
        animatorSet.playTogether(ofInt, ofInt2, ofInt3, ofFloat);
        animatorSet.addListener(new Animator.AnimatorListener() { // from class: com.mbridge.msdk.widget.custom.baseview.c.2
            @Override // android.animation.Animator.AnimatorListener
            public final void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                if (MorphingAnimation.this.f32584a != null) {
                    MorphingAnimation.this.f32584a.mo20517a();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public final void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator) {
            }
        });
        animatorSet.start();
    }
}
