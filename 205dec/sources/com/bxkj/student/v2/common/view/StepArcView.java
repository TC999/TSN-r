package com.bxkj.student.v2.common.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.bxkj.student.R;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class StepArcView extends View {

    /* renamed from: a  reason: collision with root package name */
    private float f23479a;

    /* renamed from: b  reason: collision with root package name */
    private float f23480b;

    /* renamed from: c  reason: collision with root package name */
    private String f23481c;

    /* renamed from: d  reason: collision with root package name */
    private float f23482d;

    /* renamed from: e  reason: collision with root package name */
    private float f23483e;

    /* renamed from: f  reason: collision with root package name */
    private float f23484f;

    /* renamed from: g  reason: collision with root package name */
    private int f23485g;

    /* renamed from: h  reason: collision with root package name */
    private String f23486h;

    /* renamed from: i  reason: collision with root package name */
    private String f23487i;

    /* renamed from: j  reason: collision with root package name */
    private String f23488j;

    /* renamed from: k  reason: collision with root package name */
    private int f23489k;

    /* renamed from: l  reason: collision with root package name */
    private float f23490l;

    /* renamed from: m  reason: collision with root package name */
    private float f23491m;

    /* renamed from: n  reason: collision with root package name */
    private float f23492n;

    /* renamed from: o  reason: collision with root package name */
    private float f23493o;

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
            StepArcView.this.f23484f = ((Float) animation.getAnimatedValue()).floatValue();
            StepArcView.this.invalidate();
        }
    }

    public StepArcView(Context context) {
        super(context);
        this.f23479a = b(10.0f);
        this.f23480b = 0.0f;
        this.f23481c = "0";
        this.f23482d = 135.0f;
        this.f23483e = 270.0f;
        this.f23484f = 0.0f;
        this.f23485g = 500;
        this.f23486h = "\u8fbe\u6807\u91cc\u7a0b\uff1a3.0KM";
        this.f23487i = "0.01KM";
        this.f23488j = "\u91cc\u7a0b(KM)";
        this.f23489k = -16776961;
        this.f23490l = 0.0f;
        this.f23491m = -1.0f;
        this.f23492n = 0.0f;
        this.f23493o = b(16.0f);
    }

    private float b(float dip) {
        return (getContext().getResources().getDisplayMetrics().density * dip) + ((dip >= 0.0f ? 1 : -1) * 0.5f);
    }

    private void c(Canvas canvas, RectF rectF) {
        Paint paint = new Paint();
        int i4 = this.f23489k;
        if (this.f23484f == this.f23483e) {
            i4 = ContextCompat.getColor(getContext(), R.color.v3_tab_color2);
        }
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(this.f23479a);
        paint.setColor(i4);
        canvas.drawArc(rectF, this.f23482d, this.f23484f, false, paint);
    }

    private void d(Canvas canvas, RectF rectF) {
        Paint paint = new Paint();
        paint.setColor(getResources().getColor(R.color.v3_sport_circle_color));
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(this.f23479a);
        canvas.drawArc(rectF, this.f23482d, this.f23483e, false, paint);
    }

    private void e(Canvas canvas, float centerX) {
        Paint paint = new Paint();
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setAntiAlias(true);
        paint.setTextSize(this.f23480b);
        paint.setTypeface(Typeface.create(Typeface.SANS_SERIF, 0));
        paint.setColor(getResources().getColor(2131034200));
        Rect rect = new Rect();
        String str = this.f23487i;
        paint.getTextBounds(str, 0, str.length(), rect);
        canvas.drawText(str, centerX, (getHeight() / 2) + (rect.height() / 2), paint);
    }

    private void f(Canvas canvas, float centerX) {
        Paint paint = new Paint();
        paint.setTextSize(this.f23493o);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setAntiAlias(true);
        paint.setColor(getResources().getColor(2131034200));
        String str = this.f23488j;
        paint.getTextBounds(str, 0, str.length(), new Rect());
        float f4 = this.f23493o;
        canvas.drawText(str, centerX, ((getHeight() - f4) - f4) - b(10.0f), paint);
    }

    private void g(Canvas canvas, float centerX) {
        Paint paint = new Paint();
        paint.setTextSize(this.f23493o);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setAntiAlias(true);
        paint.setColor(this.f23489k);
        String str = this.f23486h;
        paint.getTextBounds(str, 0, str.length(), new Rect());
        canvas.drawText(str, centerX, getHeight() - (h(b(16.0f)) / 2), paint);
    }

    private void i(AttributeSet attrs) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attrs, R.styleable.StepArcView);
        this.f23486h = obtainStyledAttributes.getString(8);
        this.f23488j = obtainStyledAttributes.getString(3);
        this.f23487i = obtainStyledAttributes.getString(2);
        this.f23489k = obtainStyledAttributes.getColor(0, getResources().getColor(R.color.v3_tab_color2));
        this.f23490l = obtainStyledAttributes.getInt(7, 0);
        this.f23491m = obtainStyledAttributes.getInt(5, -1);
        this.f23492n = obtainStyledAttributes.getInt(1, 0);
        this.f23493o = obtainStyledAttributes.getDimensionPixelSize(4, (int) b(16.0f));
    }

    private void j(float start, float current, int length) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(start, current);
        ofFloat.setDuration(length);
        ofFloat.setTarget(Float.valueOf(this.f23484f));
        ofFloat.addUpdateListener(new a());
        ofFloat.start();
    }

    public int h(float fontSize) {
        Paint paint = new Paint();
        paint.setTextSize(fontSize);
        Rect rect = new Rect();
        String str = this.f23481c;
        paint.getTextBounds(str, 0, str.length(), rect);
        return rect.height();
    }

    public StepArcView k(float count) {
        this.f23490l = count;
        return this;
    }

    public StepArcView l(float current) {
        this.f23492n = current;
        return this;
    }

    public StepArcView m(int currentColor) {
        this.f23489k = currentColor;
        return this;
    }

    public StepArcView n(String currentText) {
        this.f23487i = currentText;
        return this;
    }

    public StepArcView o(float maxRange) {
        this.f23491m = maxRange;
        return this;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float width = getWidth() / 2;
        float f4 = this.f23479a;
        float f5 = 2.0f * width;
        RectF rectF = new RectF(0.0f + f4, f4, f5 - f4, f5 - f4);
        d(canvas, rectF);
        c(canvas, rectF);
        e(canvas, width);
        f(canvas, width);
        g(canvas, width);
        setCurrentCount(this.f23492n);
    }

    public StepArcView p(String targetText) {
        this.f23486h = targetText;
        return this;
    }

    public void setCurrentCount(float currentCounts) {
        float f4 = this.f23490l;
        if (currentCounts > f4) {
            float f5 = this.f23491m;
            currentCounts = (f5 == -1.0f || currentCounts <= f5) ? f4 : -1.0f;
        }
        float f6 = 1.0f;
        float f7 = this.f23483e;
        float f8 = 0.0f;
        if (f4 != 0.0f) {
            float floatValue = Float.valueOf(this.f23481c).floatValue();
            float f9 = this.f23490l;
            f7 = this.f23483e * (floatValue / f9);
            f6 = currentCounts / f9;
        }
        if (this.f23491m == -1.0f || currentCounts != -1.0f) {
            f8 = f6;
        } else {
            f7 = 0.0f;
        }
        j(f7, f8 * this.f23483e, this.f23485g);
        this.f23481c = String.valueOf(currentCounts);
        setTextSize(this.f23487i.length());
    }

    public void setTextSize(int length) {
        if (length <= 4) {
            this.f23480b = b((this.f23493o / b(16.0f)) * 50.0f);
        } else if (length > 4 && length <= 6) {
            this.f23480b = b((this.f23493o / b(16.0f)) * 40.0f);
        } else if (length > 6 && length <= 8) {
            this.f23480b = b((this.f23493o / b(16.0f)) * 30.0f);
        } else if (length >= 8) {
            this.f23480b = b(25.0f) * (this.f23493o / b(16.0f));
        }
    }

    public StepArcView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.f23479a = b(10.0f);
        this.f23480b = 0.0f;
        this.f23481c = "0";
        this.f23482d = 135.0f;
        this.f23483e = 270.0f;
        this.f23484f = 0.0f;
        this.f23485g = 500;
        this.f23486h = "\u8fbe\u6807\u91cc\u7a0b\uff1a3.0KM";
        this.f23487i = "0.01KM";
        this.f23488j = "\u91cc\u7a0b(KM)";
        this.f23489k = -16776961;
        this.f23490l = 0.0f;
        this.f23491m = -1.0f;
        this.f23492n = 0.0f;
        this.f23493o = b(16.0f);
        i(attrs);
    }

    public StepArcView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.f23479a = b(10.0f);
        this.f23480b = 0.0f;
        this.f23481c = "0";
        this.f23482d = 135.0f;
        this.f23483e = 270.0f;
        this.f23484f = 0.0f;
        this.f23485g = 500;
        this.f23486h = "\u8fbe\u6807\u91cc\u7a0b\uff1a3.0KM";
        this.f23487i = "0.01KM";
        this.f23488j = "\u91cc\u7a0b(KM)";
        this.f23489k = -16776961;
        this.f23490l = 0.0f;
        this.f23491m = -1.0f;
        this.f23492n = 0.0f;
        this.f23493o = b(16.0f);
        i(attrs);
    }
}
