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
public class CountDownTimeView extends View {

    /* renamed from: a */
    private float f15230a;

    /* renamed from: b */
    private float f15231b;

    /* renamed from: c */
    private String f15232c;

    /* renamed from: d */
    private float f15233d;

    /* renamed from: e */
    private float f15234e;

    /* renamed from: f */
    private float f15235f;

    /* renamed from: g */
    private int f15236g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.base.view.CountDownTimeView$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C3996a implements ValueAnimator.AnimatorUpdateListener {
        C3996a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            CountDownTimeView.this.f15235f = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            CountDownTimeView.this.invalidate();
        }
    }

    public CountDownTimeView(Context context) {
        super(context);
        this.f15230a = 10.0f;
        this.f15231b = 0.0f;
        this.f15232c = "0";
        this.f15233d = 270.0f;
        this.f15234e = 360.0f;
        this.f15235f = 0.0f;
        this.f15236g = 0;
    }

    /* renamed from: b */
    private int m43536b(float f) {
        return (int) ((getContext().getResources().getDisplayMetrics().density * f) + ((f >= 0.0f ? 1 : -1) * 0.5f));
    }

    /* renamed from: c */
    private void m43535c(Canvas canvas, RectF rectF) {
        Paint paint = new Paint();
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(this.f15230a);
        paint.setColor(getResources().getColor(C3801R.C3803color.color_red));
        canvas.drawArc(rectF, this.f15233d, this.f15235f, false, paint);
    }

    /* renamed from: d */
    private void m43534d(Canvas canvas, RectF rectF) {
        Paint paint = new Paint();
        paint.setColor(getResources().getColor(C3801R.C3803color.yellow));
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(this.f15230a);
        canvas.drawArc(rectF, this.f15233d, this.f15234e, false, paint);
    }

    /* renamed from: e */
    private void m43533e(Canvas canvas, float f) {
        Paint paint = new Paint();
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setAntiAlias(true);
        paint.setTextSize(this.f15231b);
        paint.setTypeface(Typeface.create(Typeface.SANS_SERIF, 0));
        paint.setColor(getResources().getColor(C3801R.C3803color.color_red));
        Rect rect = new Rect();
        String str = this.f15232c;
        paint.getTextBounds(str, 0, str.length(), rect);
        canvas.drawText(this.f15232c, f, (getHeight() / 2) + (rect.height() / 2), paint);
    }

    /* renamed from: f */
    private void m43532f(Canvas canvas, float f) {
        Paint paint = new Paint();
        paint.setTextSize(m43536b(16.0f));
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setAntiAlias(true);
        paint.setColor(getResources().getColor(C3801R.C3803color.color_red));
        Rect rect = new Rect();
        paint.getTextBounds("步数", 0, 2, rect);
        canvas.drawText("步数", f, (getHeight() / 2) + rect.height() + m43531g(this.f15231b), paint);
    }

    /* renamed from: h */
    private void m43530h(float f, float f2, int i) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(f, f2);
        ofFloat.setDuration(i);
        ofFloat.setTarget(Float.valueOf(this.f15235f));
        ofFloat.addUpdateListener(new C3996a());
        ofFloat.start();
    }

    /* renamed from: g */
    public int m43531g(float f) {
        Paint paint = new Paint();
        paint.setTextSize(f);
        Rect rect = new Rect();
        String str = this.f15232c;
        paint.getTextBounds(str, 0, str.length(), rect);
        return rect.height();
    }

    /* renamed from: i */
    public void m43529i(int i, int i2) {
        this.f15232c = i2 + "";
        if (i2 > i) {
            i2 = i;
        }
        m43530h(0.0f, (i2 / i) * this.f15234e, this.f15236g);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float width = getWidth() / 2;
        float f = this.f15230a;
        float f2 = 2.0f * width;
        RectF rectF = new RectF(0.0f + f, f, f2 - f, f2 - f);
        m43534d(canvas, rectF);
        m43535c(canvas, rectF);
        m43533e(canvas, width);
    }

    public void setText(String str) {
        this.f15232c = str;
    }

    public void setTextSize(int i) {
        this.f15231b = i;
    }

    public CountDownTimeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f15230a = 10.0f;
        this.f15231b = 0.0f;
        this.f15232c = "0";
        this.f15233d = 270.0f;
        this.f15234e = 360.0f;
        this.f15235f = 0.0f;
        this.f15236g = 0;
    }

    public CountDownTimeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f15230a = 10.0f;
        this.f15231b = 0.0f;
        this.f15232c = "0";
        this.f15233d = 270.0f;
        this.f15234e = 360.0f;
        this.f15235f = 0.0f;
        this.f15236g = 0;
    }
}
