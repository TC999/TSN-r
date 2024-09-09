package com.scwang.smartrefresh.layout.header.bezierradar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import androidx.annotation.ColorInt;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class RippleView extends View {

    /* renamed from: a  reason: collision with root package name */
    private int f47997a;

    /* renamed from: b  reason: collision with root package name */
    private Paint f47998b;

    /* renamed from: c  reason: collision with root package name */
    private ValueAnimator f47999c;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            RippleView.this.f47997a = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            RippleView.this.invalidate();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
        }
    }

    public RippleView(Context context) {
        super(context);
        Paint paint = new Paint();
        this.f47998b = paint;
        paint.setAntiAlias(true);
        this.f47998b.setColor(-1);
        this.f47998b.setStyle(Paint.Style.FILL);
    }

    public void b() {
        if (this.f47999c == null) {
            ValueAnimator ofInt = ValueAnimator.ofInt(0, (int) Math.sqrt(Math.pow(getHeight(), 2.0d) + Math.pow(getWidth(), 2.0d)));
            this.f47999c = ofInt;
            ofInt.setDuration(400L);
            this.f47999c.addUpdateListener(new a());
            this.f47999c.addListener(new b());
        }
        this.f47999c.start();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, this.f47997a, this.f47998b);
    }

    @Override // android.view.View
    protected void onMeasure(int i4, int i5) {
        setMeasuredDimension(View.resolveSize(getSuggestedMinimumWidth(), i4), View.resolveSize(getSuggestedMinimumHeight(), i5));
    }

    public void setFrontColor(@ColorInt int i4) {
        this.f47998b.setColor(i4);
    }
}
