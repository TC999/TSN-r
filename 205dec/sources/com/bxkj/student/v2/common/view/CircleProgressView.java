package com.bxkj.student.v2.common.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import com.bxkj.student.R;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class CircleProgressView extends View {

    /* renamed from: a  reason: collision with root package name */
    private float f23430a;

    /* renamed from: b  reason: collision with root package name */
    private float f23431b;

    /* renamed from: c  reason: collision with root package name */
    private String f23432c;

    /* renamed from: d  reason: collision with root package name */
    private float f23433d;

    /* renamed from: e  reason: collision with root package name */
    private float f23434e;

    /* renamed from: f  reason: collision with root package name */
    private float f23435f;

    /* renamed from: g  reason: collision with root package name */
    private int f23436g;

    /* renamed from: h  reason: collision with root package name */
    private int f23437h;

    /* renamed from: i  reason: collision with root package name */
    private float f23438i;

    /* renamed from: j  reason: collision with root package name */
    private float f23439j;

    /* renamed from: k  reason: collision with root package name */
    private float f23440k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator animation) {
            CircleProgressView.this.f23435f = ((Float) animation.getAnimatedValue()).floatValue();
            CircleProgressView.this.invalidate();
        }
    }

    public CircleProgressView(Context context) {
        super(context);
        this.f23430a = b(12.0f);
        this.f23431b = 0.0f;
        this.f23432c = "0";
        this.f23433d = 180.0f;
        this.f23434e = 360.0f;
        this.f23435f = 0.0f;
        this.f23436g = 500;
        this.f23437h = -16776961;
        this.f23438i = -1.0f;
        this.f23439j = 0.0f;
        this.f23440k = 0.0f;
    }

    private int b(float dip) {
        return (int) ((getContext().getResources().getDisplayMetrics().density * dip) + ((dip >= 0.0f ? 1 : -1) * 0.5f));
    }

    private void c(Canvas canvas, RectF rectF) {
        Paint paint = new Paint();
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(this.f23430a);
        paint.setColor(this.f23437h);
        canvas.drawArc(rectF, this.f23433d, this.f23435f, false, paint);
    }

    private void d(Canvas canvas, RectF rectF) {
        Paint paint = new Paint();
        paint.setColor(Color.parseColor("#e2e2e2"));
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(this.f23430a);
        canvas.drawArc(rectF, this.f23433d, this.f23434e, false, paint);
    }

    private void e(Canvas canvas, float centerX) {
        Paint paint = new Paint();
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setAntiAlias(true);
        paint.setTextSize(this.f23431b);
        paint.setTypeface(Typeface.create(Typeface.SANS_SERIF, 0));
        paint.setColor(getResources().getColor(2131034180));
        Rect rect = new Rect();
        String str = this.f23432c;
        paint.getTextBounds(str, 0, str.length(), rect);
        canvas.drawText(this.f23432c, centerX, (getHeight() / 2) + (rect.height() / 2), paint);
    }

    private void f(Canvas canvas, float centerX) {
        Paint paint = new Paint();
        paint.setTextSize(b(16.0f));
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setAntiAlias(true);
        paint.setColor(getResources().getColor(2131034268));
        Rect rect = new Rect();
        paint.getTextBounds("", 0, 0, rect);
        canvas.drawText("", centerX, (getHeight() / 2) + rect.height() + g(this.f23431b), paint);
    }

    private void h(AttributeSet attrs) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attrs, R.styleable.StepArcView);
        this.f23437h = obtainStyledAttributes.getColor(0, getResources().getColor(R.color.v3_tab_color2));
        this.f23439j = obtainStyledAttributes.getInt(7, 0);
        this.f23438i = obtainStyledAttributes.getInt(5, -1);
        this.f23440k = obtainStyledAttributes.getInt(1, 0);
        this.f23433d = obtainStyledAttributes.getInt(6, 180);
    }

    private void i(float start, float current, int length) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(start, current);
        ofFloat.setDuration(length);
        ofFloat.setTarget(Float.valueOf(this.f23435f));
        ofFloat.addUpdateListener(new a());
        ofFloat.start();
    }

    public int g(float fontSize) {
        Paint paint = new Paint();
        paint.setTextSize(fontSize);
        Rect rect = new Rect();
        String str = this.f23432c;
        paint.getTextBounds(str, 0, str.length(), rect);
        return rect.height();
    }

    public CircleProgressView j(float count) {
        this.f23439j = count;
        return this;
    }

    public CircleProgressView k(float current) {
        this.f23440k = current;
        return this;
    }

    public CircleProgressView l(float maxRange) {
        this.f23438i = maxRange;
        return this;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float width = getWidth() / 2;
        float f4 = this.f23430a;
        float f5 = 2.0f * width;
        RectF rectF = new RectF(0.0f + f4, f4, f5 - f4, f5 - f4);
        d(canvas, rectF);
        c(canvas, rectF);
        e(canvas, width);
        f(canvas, width);
        setCurrentCount(this.f23440k);
    }

    public void setCurrentCount(float currentCounts) {
        float f4 = this.f23439j;
        if (currentCounts > f4) {
            float f5 = this.f23438i;
            currentCounts = (f5 == -1.0f || currentCounts <= f5) ? f4 : -1.0f;
        }
        float f6 = 1.0f;
        float f7 = this.f23434e;
        float f8 = 0.0f;
        if (f4 != 0.0f) {
            float floatValue = Float.valueOf(this.f23432c).floatValue();
            float f9 = this.f23439j;
            f7 = this.f23434e * (floatValue / f9);
            f6 = currentCounts / f9;
        }
        if (this.f23438i == -1.0f || currentCounts != -1.0f) {
            f8 = f6;
        } else {
            f7 = 0.0f;
        }
        i(f7, f8 * this.f23434e, this.f23436g);
        this.f23432c = String.valueOf(currentCounts);
    }

    public void setTextSize(int num) {
        int length = String.valueOf(num).length();
        if (length <= 4) {
            this.f23431b = b(50.0f);
        } else if (length > 4 && length <= 6) {
            this.f23431b = b(40.0f);
        } else if (length > 6 && length <= 8) {
            this.f23431b = b(30.0f);
        } else if (length > 8) {
            this.f23431b = b(25.0f);
        }
    }

    public CircleProgressView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.f23430a = b(12.0f);
        this.f23431b = 0.0f;
        this.f23432c = "0";
        this.f23433d = 180.0f;
        this.f23434e = 360.0f;
        this.f23435f = 0.0f;
        this.f23436g = 500;
        this.f23437h = -16776961;
        this.f23438i = -1.0f;
        this.f23439j = 0.0f;
        this.f23440k = 0.0f;
        h(attrs);
    }

    public CircleProgressView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.f23430a = b(12.0f);
        this.f23431b = 0.0f;
        this.f23432c = "0";
        this.f23433d = 180.0f;
        this.f23434e = 360.0f;
        this.f23435f = 0.0f;
        this.f23436g = 500;
        this.f23437h = -16776961;
        this.f23438i = -1.0f;
        this.f23439j = 0.0f;
        this.f23440k = 0.0f;
        h(attrs);
    }
}
