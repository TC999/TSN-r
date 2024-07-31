package com.scwang.smartrefresh.layout.header.bezierradar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import androidx.annotation.ColorInt;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class RippleView extends View {

    /* renamed from: a */
    private int f33663a;

    /* renamed from: b */
    private Paint f33664b;

    /* renamed from: c */
    private ValueAnimator f33665c;

    /* renamed from: com.scwang.smartrefresh.layout.header.bezierradar.RippleView$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    class C11917a implements ValueAnimator.AnimatorUpdateListener {
        C11917a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            RippleView.this.f33663a = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            RippleView.this.invalidate();
        }
    }

    /* renamed from: com.scwang.smartrefresh.layout.header.bezierradar.RippleView$b */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    class C11918b extends AnimatorListenerAdapter {
        C11918b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
        }
    }

    public RippleView(Context context) {
        super(context);
        Paint paint = new Paint();
        this.f33664b = paint;
        paint.setAntiAlias(true);
        this.f33664b.setColor(-1);
        this.f33664b.setStyle(Paint.Style.FILL);
    }

    /* renamed from: b */
    public void m19850b() {
        if (this.f33665c == null) {
            ValueAnimator ofInt = ValueAnimator.ofInt(0, (int) Math.sqrt(Math.pow(getHeight(), 2.0d) + Math.pow(getWidth(), 2.0d)));
            this.f33665c = ofInt;
            ofInt.setDuration(400L);
            this.f33665c.addUpdateListener(new C11917a());
            this.f33665c.addListener(new C11918b());
        }
        this.f33665c.start();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, this.f33663a, this.f33664b);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(View.resolveSize(getSuggestedMinimumWidth(), i), View.resolveSize(getSuggestedMinimumHeight(), i2));
    }

    public void setFrontColor(@ColorInt int i) {
        this.f33664b.setColor(i);
    }
}
