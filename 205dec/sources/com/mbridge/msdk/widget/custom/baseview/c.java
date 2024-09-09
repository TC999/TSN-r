package com.mbridge.msdk.widget.custom.baseview;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.drawable.GradientDrawable;
import android.widget.TextView;

/* compiled from: MorphingAnimation.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
final class c {

    /* renamed from: a  reason: collision with root package name */
    private d f41271a;

    /* renamed from: b  reason: collision with root package name */
    private int f41272b;

    /* renamed from: c  reason: collision with root package name */
    private int f41273c;

    /* renamed from: d  reason: collision with root package name */
    private int f41274d;

    /* renamed from: e  reason: collision with root package name */
    private int f41275e;

    /* renamed from: f  reason: collision with root package name */
    private int f41276f;

    /* renamed from: g  reason: collision with root package name */
    private int f41277g;

    /* renamed from: h  reason: collision with root package name */
    private int f41278h;

    /* renamed from: i  reason: collision with root package name */
    private float f41279i;

    /* renamed from: j  reason: collision with root package name */
    private float f41280j;

    /* renamed from: k  reason: collision with root package name */
    private float f41281k;

    /* renamed from: l  reason: collision with root package name */
    private TextView f41282l;

    /* renamed from: m  reason: collision with root package name */
    private f f41283m;

    public c(TextView textView, f fVar) {
        this.f41282l = textView;
        this.f41283m = fVar;
    }

    public final void f(int i4) {
        this.f41277g = i4;
    }

    public final void g(int i4) {
        this.f41278h = i4;
    }

    public final void a(int i4) {
        this.f41272b = i4;
    }

    public final void b(int i4) {
        this.f41273c = i4;
    }

    public final void c(int i4) {
        this.f41274d = i4;
    }

    public final void d(int i4) {
        this.f41275e = i4;
    }

    public final void e(int i4) {
        this.f41276f = i4;
    }

    public final void a(d dVar) {
        this.f41271a = dVar;
    }

    public final void b(float f4) {
        this.f41280j = f4;
    }

    public final void c(float f4) {
        this.f41281k = f4;
    }

    public final void a(float f4) {
        this.f41279i = f4;
    }

    public final void a() {
        ValueAnimator ofInt = ValueAnimator.ofInt(this.f41273c, this.f41274d);
        final GradientDrawable a4 = this.f41283m.a();
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.mbridge.msdk.widget.custom.baseview.c.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                int intValue;
                int i4;
                float animatedFraction;
                Integer num = (Integer) valueAnimator.getAnimatedValue();
                if (c.this.f41273c > c.this.f41274d) {
                    intValue = (c.this.f41273c - num.intValue()) / 2;
                    i4 = c.this.f41273c - intValue;
                    animatedFraction = c.this.f41281k * valueAnimator.getAnimatedFraction();
                } else {
                    intValue = (c.this.f41274d - num.intValue()) / 2;
                    i4 = c.this.f41274d - intValue;
                    animatedFraction = c.this.f41281k - (c.this.f41281k * valueAnimator.getAnimatedFraction());
                }
                int i5 = (int) animatedFraction;
                a4.setBounds(intValue + i5, i5, i4 - i5, c.this.f41282l.getHeight() - i5);
            }
        });
        ObjectAnimator ofInt2 = ObjectAnimator.ofInt(a4, "color", this.f41275e, this.f41276f);
        ofInt2.setEvaluator(new ArgbEvaluator());
        ObjectAnimator ofInt3 = ObjectAnimator.ofInt(this.f41283m, "strokeColor", this.f41277g, this.f41278h);
        ofInt3.setEvaluator(new ArgbEvaluator());
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(a4, "cornerRadius", this.f41279i, this.f41280j);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(this.f41272b);
        animatorSet.playTogether(ofInt, ofInt2, ofInt3, ofFloat);
        animatorSet.addListener(new Animator.AnimatorListener() { // from class: com.mbridge.msdk.widget.custom.baseview.c.2
            @Override // android.animation.Animator.AnimatorListener
            public final void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                if (c.this.f41271a != null) {
                    c.this.f41271a.a();
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
