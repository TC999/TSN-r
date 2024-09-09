package com.bytedance.sdk.component.adexpress.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import android.view.animation.LinearInterpolator;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class RippleView extends View {

    /* renamed from: c  reason: collision with root package name */
    private float f29588c;
    private float ev;

    /* renamed from: f  reason: collision with root package name */
    private long f29589f;
    private Animator.AnimatorListener gd;

    /* renamed from: p  reason: collision with root package name */
    private int f29590p;

    /* renamed from: r  reason: collision with root package name */
    private float f29591r;
    private ValueAnimator sr;
    private Paint ux;

    /* renamed from: w  reason: collision with root package name */
    private float f29592w;
    private ValueAnimator xv;

    public RippleView(Context context, int i4) {
        super(context);
        this.f29589f = 300L;
        this.f29591r = 0.0f;
        this.f29590p = i4;
        c();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(this.f29588c, this.f29592w, this.f29591r, this.ux);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i4, int i5, int i6, int i7) {
        super.onSizeChanged(i4, i5, i6, i7);
        this.f29588c = i4 / 2.0f;
        this.f29592w = i5 / 2.0f;
        this.ev = (float) (Math.hypot(i4, i5) / 2.0d);
    }

    public void setAnimationListener(Animator.AnimatorListener animatorListener) {
        this.gd = animatorListener;
    }

    public void w() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, this.ev);
        this.xv = ofFloat;
        ofFloat.setDuration(this.f29589f);
        this.xv.setInterpolator(new LinearInterpolator());
        this.xv.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.component.adexpress.widget.RippleView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                RippleView.this.f29591r = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                RippleView.this.invalidate();
            }
        });
        this.xv.start();
    }

    public void xv() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(this.ev, 0.0f);
        this.sr = ofFloat;
        ofFloat.setDuration(this.f29589f);
        this.sr.setInterpolator(new LinearInterpolator());
        this.sr.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.component.adexpress.widget.RippleView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                RippleView.this.f29591r = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                RippleView.this.invalidate();
            }
        });
        Animator.AnimatorListener animatorListener = this.gd;
        if (animatorListener != null) {
            this.sr.addListener(animatorListener);
        }
        this.sr.start();
    }

    public void c() {
        Paint paint = new Paint(1);
        this.ux = paint;
        paint.setStyle(Paint.Style.FILL);
        this.ux.setColor(this.f29590p);
    }
}
