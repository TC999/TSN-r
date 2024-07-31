package com.bxkj.student.p094v2.common.view;

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
import com.bxkj.student.C4215R;

/* renamed from: com.bxkj.student.v2.common.view.CircleProgressView */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class CircleProgressView extends View {

    /* renamed from: a */
    private float f20163a;

    /* renamed from: b */
    private float f20164b;

    /* renamed from: c */
    private String f20165c;

    /* renamed from: d */
    private float f20166d;

    /* renamed from: e */
    private float f20167e;

    /* renamed from: f */
    private float f20168f;

    /* renamed from: g */
    private int f20169g;

    /* renamed from: h */
    private int f20170h;

    /* renamed from: i */
    private float f20171i;

    /* renamed from: j */
    private float f20172j;

    /* renamed from: k */
    private float f20173k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.v2.common.view.CircleProgressView$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C5554a implements ValueAnimator.AnimatorUpdateListener {
        C5554a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator animation) {
            CircleProgressView.this.f20168f = ((Float) animation.getAnimatedValue()).floatValue();
            CircleProgressView.this.invalidate();
        }
    }

    public CircleProgressView(Context context) {
        super(context);
        this.f20163a = m39042b(12.0f);
        this.f20164b = 0.0f;
        this.f20165c = "0";
        this.f20166d = 180.0f;
        this.f20167e = 360.0f;
        this.f20168f = 0.0f;
        this.f20169g = 500;
        this.f20170h = -16776961;
        this.f20171i = -1.0f;
        this.f20172j = 0.0f;
        this.f20173k = 0.0f;
    }

    /* renamed from: b */
    private int m39042b(float dip) {
        return (int) ((getContext().getResources().getDisplayMetrics().density * dip) + ((dip >= 0.0f ? 1 : -1) * 0.5f));
    }

    /* renamed from: c */
    private void m39041c(Canvas canvas, RectF rectF) {
        Paint paint = new Paint();
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(this.f20163a);
        paint.setColor(this.f20170h);
        canvas.drawArc(rectF, this.f20166d, this.f20168f, false, paint);
    }

    /* renamed from: d */
    private void m39040d(Canvas canvas, RectF rectF) {
        Paint paint = new Paint();
        paint.setColor(Color.parseColor("#e2e2e2"));
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(this.f20163a);
        canvas.drawArc(rectF, this.f20166d, this.f20167e, false, paint);
    }

    /* renamed from: e */
    private void m39039e(Canvas canvas, float centerX) {
        Paint paint = new Paint();
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setAntiAlias(true);
        paint.setTextSize(this.f20164b);
        paint.setTypeface(Typeface.create(Typeface.SANS_SERIF, 0));
        paint.setColor(getResources().getColor(2131034176));
        Rect rect = new Rect();
        String str = this.f20165c;
        paint.getTextBounds(str, 0, str.length(), rect);
        canvas.drawText(this.f20165c, centerX, (getHeight() / 2) + (rect.height() / 2), paint);
    }

    /* renamed from: f */
    private void m39038f(Canvas canvas, float centerX) {
        Paint paint = new Paint();
        paint.setTextSize(m39042b(16.0f));
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setAntiAlias(true);
        paint.setColor(getResources().getColor(2131034264));
        Rect rect = new Rect();
        paint.getTextBounds("", 0, 0, rect);
        canvas.drawText("", centerX, (getHeight() / 2) + rect.height() + m39037g(this.f20164b), paint);
    }

    /* renamed from: h */
    private void m39036h(AttributeSet attrs) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attrs, C4215R.styleable.StepArcView);
        this.f20170h = obtainStyledAttributes.getColor(0, getResources().getColor(C4215R.C4217color.v3_tab_color2));
        this.f20172j = obtainStyledAttributes.getInt(7, 0);
        this.f20171i = obtainStyledAttributes.getInt(5, -1);
        this.f20173k = obtainStyledAttributes.getInt(1, 0);
        this.f20166d = obtainStyledAttributes.getInt(6, 180);
    }

    /* renamed from: i */
    private void m39035i(float start, float current, int length) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(start, current);
        ofFloat.setDuration(length);
        ofFloat.setTarget(Float.valueOf(this.f20168f));
        ofFloat.addUpdateListener(new C5554a());
        ofFloat.start();
    }

    /* renamed from: g */
    public int m39037g(float fontSize) {
        Paint paint = new Paint();
        paint.setTextSize(fontSize);
        Rect rect = new Rect();
        String str = this.f20165c;
        paint.getTextBounds(str, 0, str.length(), rect);
        return rect.height();
    }

    /* renamed from: j */
    public CircleProgressView m39034j(float count) {
        this.f20172j = count;
        return this;
    }

    /* renamed from: k */
    public CircleProgressView m39033k(float current) {
        this.f20173k = current;
        return this;
    }

    /* renamed from: l */
    public CircleProgressView m39032l(float maxRange) {
        this.f20171i = maxRange;
        return this;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float width = getWidth() / 2;
        float f = this.f20163a;
        float f2 = 2.0f * width;
        RectF rectF = new RectF(0.0f + f, f, f2 - f, f2 - f);
        m39040d(canvas, rectF);
        m39041c(canvas, rectF);
        m39039e(canvas, width);
        m39038f(canvas, width);
        setCurrentCount(this.f20173k);
    }

    public void setCurrentCount(float currentCounts) {
        float f = this.f20172j;
        if (currentCounts > f) {
            float f2 = this.f20171i;
            currentCounts = (f2 == -1.0f || currentCounts <= f2) ? f : -1.0f;
        }
        float f3 = 1.0f;
        float f4 = this.f20167e;
        float f5 = 0.0f;
        if (f != 0.0f) {
            float floatValue = Float.valueOf(this.f20165c).floatValue();
            float f6 = this.f20172j;
            f4 = this.f20167e * (floatValue / f6);
            f3 = currentCounts / f6;
        }
        if (this.f20171i == -1.0f || currentCounts != -1.0f) {
            f5 = f3;
        } else {
            f4 = 0.0f;
        }
        m39035i(f4, f5 * this.f20167e, this.f20169g);
        this.f20165c = String.valueOf(currentCounts);
    }

    public void setTextSize(int num) {
        int length = String.valueOf(num).length();
        if (length <= 4) {
            this.f20164b = m39042b(50.0f);
        } else if (length > 4 && length <= 6) {
            this.f20164b = m39042b(40.0f);
        } else if (length > 6 && length <= 8) {
            this.f20164b = m39042b(30.0f);
        } else if (length > 8) {
            this.f20164b = m39042b(25.0f);
        }
    }

    public CircleProgressView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.f20163a = m39042b(12.0f);
        this.f20164b = 0.0f;
        this.f20165c = "0";
        this.f20166d = 180.0f;
        this.f20167e = 360.0f;
        this.f20168f = 0.0f;
        this.f20169g = 500;
        this.f20170h = -16776961;
        this.f20171i = -1.0f;
        this.f20172j = 0.0f;
        this.f20173k = 0.0f;
        m39036h(attrs);
    }

    public CircleProgressView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.f20163a = m39042b(12.0f);
        this.f20164b = 0.0f;
        this.f20165c = "0";
        this.f20166d = 180.0f;
        this.f20167e = 360.0f;
        this.f20168f = 0.0f;
        this.f20169g = 500;
        this.f20170h = -16776961;
        this.f20171i = -1.0f;
        this.f20172j = 0.0f;
        this.f20173k = 0.0f;
        m39036h(attrs);
    }
}
