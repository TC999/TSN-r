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
import com.bxkj.base.C3801R;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class TimeView extends View {

    /* renamed from: a */
    private float f15257a;

    /* renamed from: b */
    private float f15258b;

    /* renamed from: c */
    private String f15259c;

    /* renamed from: d */
    private float f15260d;

    /* renamed from: e */
    private float f15261e;

    /* renamed from: f */
    private float f15262f;

    /* renamed from: g */
    private int f15263g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.base.view.TimeView$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4000a implements ValueAnimator.AnimatorUpdateListener {
        C4000a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            TimeView.this.f15262f = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            TimeView.this.invalidate();
        }
    }

    public TimeView(Context context) {
        super(context);
        this.f15257a = 10.0f;
        this.f15258b = 0.0f;
        this.f15259c = "0";
        this.f15260d = -90.0f;
        this.f15261e = 360.0f;
        this.f15262f = 0.0f;
        this.f15263g = 0;
    }

    /* renamed from: b */
    private int m43520b(float f) {
        return (int) ((getContext().getResources().getDisplayMetrics().density * f) + ((f >= 0.0f ? 1 : -1) * 0.5f));
    }

    /* renamed from: c */
    private void m43519c(Canvas canvas, RectF rectF) {
        Paint paint = new Paint();
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(this.f15257a);
        paint.setColor(getResources().getColor(C3801R.C3803color.color_red));
        canvas.drawArc(rectF, this.f15260d, this.f15262f, false, paint);
    }

    /* renamed from: d */
    private void m43518d(Canvas canvas, RectF rectF) {
        Paint paint = new Paint();
        paint.setColor(getResources().getColor(C3801R.C3803color.yellow));
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(this.f15257a);
        canvas.drawArc(rectF, this.f15260d, this.f15261e, false, paint);
    }

    /* renamed from: e */
    private void m43517e(Canvas canvas, float f) {
        Paint paint = new Paint();
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setAntiAlias(true);
        paint.setTextSize(this.f15258b);
        paint.setTypeface(Typeface.create(Typeface.SANS_SERIF, 0));
        paint.setColor(getResources().getColor(C3801R.C3803color.color_red));
        Rect rect = new Rect();
        String str = this.f15259c;
        paint.getTextBounds(str, 0, str.length(), rect);
        canvas.drawText(this.f15259c, f, (getHeight() / 2) + (rect.height() / 2), paint);
    }

    /* renamed from: f */
    private void m43516f(Canvas canvas, float f) {
        Paint paint = new Paint();
        paint.setTextSize(m43520b(16.0f));
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setAntiAlias(true);
        paint.setColor(getResources().getColor(C3801R.C3803color.color_red));
        Rect rect = new Rect();
        paint.getTextBounds("步数", 0, 2, rect);
        canvas.drawText("步数", f, (getHeight() / 2) + rect.height() + m43515g(this.f15258b), paint);
    }

    /* renamed from: h */
    private void m43514h(float f, float f2, int i) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(f, f2);
        ofFloat.setDuration(i);
        ofFloat.setTarget(Float.valueOf(this.f15262f));
        ofFloat.addUpdateListener(new C4000a());
        ofFloat.start();
    }

    /* renamed from: g */
    public int m43515g(float f) {
        Paint paint = new Paint();
        paint.setTextSize(f);
        Rect rect = new Rect();
        String str = this.f15259c;
        paint.getTextBounds(str, 0, str.length(), rect);
        return rect.height();
    }

    /* renamed from: i */
    public void m43513i(int i, int i2) {
        this.f15259c = i2 + "";
        setTextSize(i2);
        if (i2 > i) {
            i2 = i;
        }
        m43514h(0.0f, (i2 / i) * this.f15261e, this.f15263g);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float width = getWidth() / 2;
        float f = this.f15257a;
        float f2 = 2.0f * width;
        RectF rectF = new RectF(0.0f + f, f, f2 - f, f2 - f);
        m43518d(canvas, rectF);
        m43519c(canvas, rectF);
        m43517e(canvas, width);
    }

    public void setText(String str) {
        this.f15259c = str;
    }

    public void setTextSize(int i) {
        this.f15258b = i;
        int length = String.valueOf(i).length();
        if (length <= 4) {
            this.f15258b = m43520b(16.0f);
        } else if (length > 4 && length <= 6) {
            this.f15258b = m43520b(12.0f);
        } else if (length > 6 && length <= 8) {
            this.f15258b = m43520b(8.0f);
        } else if (length > 8) {
            this.f15258b = m43520b(6.0f);
        }
    }

    public TimeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f15257a = 10.0f;
        this.f15258b = 0.0f;
        this.f15259c = "0";
        this.f15260d = -90.0f;
        this.f15261e = 360.0f;
        this.f15262f = 0.0f;
        this.f15263g = 0;
    }

    public TimeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f15257a = 10.0f;
        this.f15258b = 0.0f;
        this.f15259c = "0";
        this.f15260d = -90.0f;
        this.f15261e = 360.0f;
        this.f15262f = 0.0f;
        this.f15263g = 0;
    }
}
