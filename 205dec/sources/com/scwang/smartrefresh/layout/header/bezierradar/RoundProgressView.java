package com.scwang.smartrefresh.layout.header.bezierradar;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import androidx.annotation.ColorInt;
import com.scwang.smartrefresh.layout.util.c;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class RoundProgressView extends View {

    /* renamed from: a  reason: collision with root package name */
    private Paint f48006a;

    /* renamed from: b  reason: collision with root package name */
    private Paint f48007b;

    /* renamed from: c  reason: collision with root package name */
    private ValueAnimator f48008c;

    /* renamed from: d  reason: collision with root package name */
    private int f48009d;

    /* renamed from: e  reason: collision with root package name */
    private int f48010e;

    /* renamed from: f  reason: collision with root package name */
    private int f48011f;

    /* renamed from: g  reason: collision with root package name */
    private int f48012g;

    /* renamed from: h  reason: collision with root package name */
    private RectF f48013h;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            RoundProgressView.this.f48009d = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            RoundProgressView.this.postInvalidate();
        }
    }

    public RoundProgressView(Context context) {
        super(context);
        this.f48009d = 0;
        this.f48010e = 270;
        this.f48011f = 0;
        this.f48012g = 0;
        this.f48013h = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        b();
    }

    private void b() {
        this.f48006a = new Paint();
        this.f48007b = new Paint();
        this.f48006a.setAntiAlias(true);
        this.f48007b.setAntiAlias(true);
        this.f48006a.setColor(-1);
        this.f48007b.setColor(1426063360);
        c cVar = new c();
        this.f48011f = cVar.a(20.0f);
        this.f48012g = cVar.a(7.0f);
        this.f48006a.setStrokeWidth(cVar.a(3.0f));
        this.f48007b.setStrokeWidth(cVar.a(3.0f));
        ValueAnimator ofInt = ValueAnimator.ofInt(0, 360);
        this.f48008c = ofInt;
        ofInt.setDuration(720L);
        this.f48008c.setRepeatCount(-1);
        this.f48008c.setInterpolator(new AccelerateDecelerateInterpolator());
    }

    public void c() {
        ValueAnimator valueAnimator = this.f48008c;
        if (valueAnimator != null) {
            valueAnimator.start();
        }
    }

    public void d() {
        ValueAnimator valueAnimator = this.f48008c;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            return;
        }
        this.f48008c.cancel();
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f48008c.addUpdateListener(new a());
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f48008c.removeAllUpdateListeners();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int i4;
        int i5;
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();
        if (isInEditMode()) {
            this.f48010e = 0;
            this.f48009d = 270;
        }
        this.f48006a.setStyle(Paint.Style.FILL);
        float f4 = width / 2;
        float f5 = height / 2;
        canvas.drawCircle(f4, f5, this.f48011f, this.f48006a);
        this.f48006a.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(f4, f5, this.f48011f + this.f48012g, this.f48006a);
        this.f48007b.setStyle(Paint.Style.FILL);
        RectF rectF = this.f48013h;
        int i6 = this.f48011f;
        rectF.set(i4 - i6, i5 - i6, i4 + i6, i6 + i5);
        canvas.drawArc(this.f48013h, this.f48010e, this.f48009d, true, this.f48007b);
        this.f48011f += this.f48012g;
        this.f48007b.setStyle(Paint.Style.STROKE);
        RectF rectF2 = this.f48013h;
        int i7 = this.f48011f;
        rectF2.set(i4 - i7, i5 - i7, i4 + i7, i5 + i7);
        canvas.drawArc(this.f48013h, this.f48010e, this.f48009d, false, this.f48007b);
        this.f48011f -= this.f48012g;
    }

    @Override // android.view.View
    protected void onMeasure(int i4, int i5) {
        setMeasuredDimension(View.resolveSize(getSuggestedMinimumWidth(), i4), View.resolveSize(getSuggestedMinimumHeight(), i5));
    }

    public void setBackColor(@ColorInt int i4) {
        this.f48007b.setColor((i4 & 16777215) | 1426063360);
    }

    public void setFrontColor(@ColorInt int i4) {
        this.f48006a.setColor(i4);
    }
}
