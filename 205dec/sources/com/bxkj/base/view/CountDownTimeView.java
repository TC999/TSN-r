package com.bxkj.base.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import com.bxkj.base.R;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class CountDownTimeView extends View {

    /* renamed from: a  reason: collision with root package name */
    private float f18800a;

    /* renamed from: b  reason: collision with root package name */
    private float f18801b;

    /* renamed from: c  reason: collision with root package name */
    private String f18802c;

    /* renamed from: d  reason: collision with root package name */
    private float f18803d;

    /* renamed from: e  reason: collision with root package name */
    private float f18804e;

    /* renamed from: f  reason: collision with root package name */
    private float f18805f;

    /* renamed from: g  reason: collision with root package name */
    private int f18806g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            CountDownTimeView.this.f18805f = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            CountDownTimeView.this.invalidate();
        }
    }

    public CountDownTimeView(Context context) {
        super(context);
        this.f18800a = 10.0f;
        this.f18801b = 0.0f;
        this.f18802c = "0";
        this.f18803d = 270.0f;
        this.f18804e = 360.0f;
        this.f18805f = 0.0f;
        this.f18806g = 0;
    }

    private int b(float f4) {
        return (int) ((getContext().getResources().getDisplayMetrics().density * f4) + ((f4 >= 0.0f ? 1 : -1) * 0.5f));
    }

    private void c(Canvas canvas, RectF rectF) {
        Paint paint = new Paint();
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(this.f18800a);
        paint.setColor(getResources().getColor(R.color.color_red));
        canvas.drawArc(rectF, this.f18803d, this.f18805f, false, paint);
    }

    private void d(Canvas canvas, RectF rectF) {
        Paint paint = new Paint();
        paint.setColor(getResources().getColor(R.color.yellow));
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(this.f18800a);
        canvas.drawArc(rectF, this.f18803d, this.f18804e, false, paint);
    }

    private void e(Canvas canvas, float f4) {
        Paint paint = new Paint();
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setAntiAlias(true);
        paint.setTextSize(this.f18801b);
        paint.setTypeface(Typeface.create(Typeface.SANS_SERIF, 0));
        paint.setColor(getResources().getColor(R.color.color_red));
        Rect rect = new Rect();
        String str = this.f18802c;
        paint.getTextBounds(str, 0, str.length(), rect);
        canvas.drawText(this.f18802c, f4, (getHeight() / 2) + (rect.height() / 2), paint);
    }

    private void f(Canvas canvas, float f4) {
        Paint paint = new Paint();
        paint.setTextSize(b(16.0f));
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setAntiAlias(true);
        paint.setColor(getResources().getColor(R.color.color_red));
        Rect rect = new Rect();
        paint.getTextBounds("\u6b65\u6570", 0, 2, rect);
        canvas.drawText("\u6b65\u6570", f4, (getHeight() / 2) + rect.height() + g(this.f18801b), paint);
    }

    private void h(float f4, float f5, int i4) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(f4, f5);
        ofFloat.setDuration(i4);
        ofFloat.setTarget(Float.valueOf(this.f18805f));
        ofFloat.addUpdateListener(new a());
        ofFloat.start();
    }

    public int g(float f4) {
        Paint paint = new Paint();
        paint.setTextSize(f4);
        Rect rect = new Rect();
        String str = this.f18802c;
        paint.getTextBounds(str, 0, str.length(), rect);
        return rect.height();
    }

    public void i(int i4, int i5) {
        this.f18802c = i5 + "";
        if (i5 > i4) {
            i5 = i4;
        }
        h(0.0f, (i5 / i4) * this.f18804e, this.f18806g);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float width = getWidth() / 2;
        float f4 = this.f18800a;
        float f5 = 2.0f * width;
        RectF rectF = new RectF(0.0f + f4, f4, f5 - f4, f5 - f4);
        d(canvas, rectF);
        c(canvas, rectF);
        e(canvas, width);
    }

    public void setText(String str) {
        this.f18802c = str;
    }

    public void setTextSize(int i4) {
        this.f18801b = i4;
    }

    public CountDownTimeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f18800a = 10.0f;
        this.f18801b = 0.0f;
        this.f18802c = "0";
        this.f18803d = 270.0f;
        this.f18804e = 360.0f;
        this.f18805f = 0.0f;
        this.f18806g = 0;
    }

    public CountDownTimeView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f18800a = 10.0f;
        this.f18801b = 0.0f;
        this.f18802c = "0";
        this.f18803d = 270.0f;
        this.f18804e = 360.0f;
        this.f18805f = 0.0f;
        this.f18806g = 0;
    }
}
