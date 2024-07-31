package com.bxkj.student.p094v2.common.view;

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
import com.bxkj.student.C4215R;

/* renamed from: com.bxkj.student.v2.common.view.StepArcView */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class StepArcView extends View {

    /* renamed from: a */
    private float f20175a;

    /* renamed from: b */
    private float f20176b;

    /* renamed from: c */
    private String f20177c;

    /* renamed from: d */
    private float f20178d;

    /* renamed from: e */
    private float f20179e;

    /* renamed from: f */
    private float f20180f;

    /* renamed from: g */
    private int f20181g;

    /* renamed from: h */
    private String f20182h;

    /* renamed from: i */
    private String f20183i;

    /* renamed from: j */
    private String f20184j;

    /* renamed from: k */
    private int f20185k;

    /* renamed from: l */
    private float f20186l;

    /* renamed from: m */
    private float f20187m;

    /* renamed from: n */
    private float f20188n;

    /* renamed from: o */
    private float f20189o;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.v2.common.view.StepArcView$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C5555a implements ValueAnimator.AnimatorUpdateListener {
        C5555a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator animation) {
            StepArcView.this.f20180f = ((Float) animation.getAnimatedValue()).floatValue();
            StepArcView.this.invalidate();
        }
    }

    public StepArcView(Context context) {
        super(context);
        this.f20175a = m39030b(10.0f);
        this.f20176b = 0.0f;
        this.f20177c = "0";
        this.f20178d = 135.0f;
        this.f20179e = 270.0f;
        this.f20180f = 0.0f;
        this.f20181g = 500;
        this.f20182h = "达标里程：3.0KM";
        this.f20183i = "0.01KM";
        this.f20184j = "里程(KM)";
        this.f20185k = -16776961;
        this.f20186l = 0.0f;
        this.f20187m = -1.0f;
        this.f20188n = 0.0f;
        this.f20189o = m39030b(16.0f);
    }

    /* renamed from: b */
    private float m39030b(float dip) {
        return (getContext().getResources().getDisplayMetrics().density * dip) + ((dip >= 0.0f ? 1 : -1) * 0.5f);
    }

    /* renamed from: c */
    private void m39029c(Canvas canvas, RectF rectF) {
        Paint paint = new Paint();
        int i = this.f20185k;
        if (this.f20180f == this.f20179e) {
            i = ContextCompat.getColor(getContext(), C4215R.C4217color.v3_tab_color2);
        }
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(this.f20175a);
        paint.setColor(i);
        canvas.drawArc(rectF, this.f20178d, this.f20180f, false, paint);
    }

    /* renamed from: d */
    private void m39028d(Canvas canvas, RectF rectF) {
        Paint paint = new Paint();
        paint.setColor(getResources().getColor(C4215R.C4217color.v3_sport_circle_color));
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(this.f20175a);
        canvas.drawArc(rectF, this.f20178d, this.f20179e, false, paint);
    }

    /* renamed from: e */
    private void m39027e(Canvas canvas, float centerX) {
        Paint paint = new Paint();
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setAntiAlias(true);
        paint.setTextSize(this.f20176b);
        paint.setTypeface(Typeface.create(Typeface.SANS_SERIF, 0));
        paint.setColor(getResources().getColor(2131034196));
        Rect rect = new Rect();
        String str = this.f20183i;
        paint.getTextBounds(str, 0, str.length(), rect);
        canvas.drawText(str, centerX, (getHeight() / 2) + (rect.height() / 2), paint);
    }

    /* renamed from: f */
    private void m39026f(Canvas canvas, float centerX) {
        Paint paint = new Paint();
        paint.setTextSize(this.f20189o);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setAntiAlias(true);
        paint.setColor(getResources().getColor(2131034196));
        String str = this.f20184j;
        paint.getTextBounds(str, 0, str.length(), new Rect());
        float f = this.f20189o;
        canvas.drawText(str, centerX, ((getHeight() - f) - f) - m39030b(10.0f), paint);
    }

    /* renamed from: g */
    private void m39025g(Canvas canvas, float centerX) {
        Paint paint = new Paint();
        paint.setTextSize(this.f20189o);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setAntiAlias(true);
        paint.setColor(this.f20185k);
        String str = this.f20182h;
        paint.getTextBounds(str, 0, str.length(), new Rect());
        canvas.drawText(str, centerX, getHeight() - (m39024h(m39030b(16.0f)) / 2), paint);
    }

    /* renamed from: i */
    private void m39023i(AttributeSet attrs) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attrs, C4215R.styleable.StepArcView);
        this.f20182h = obtainStyledAttributes.getString(8);
        this.f20184j = obtainStyledAttributes.getString(3);
        this.f20183i = obtainStyledAttributes.getString(2);
        this.f20185k = obtainStyledAttributes.getColor(0, getResources().getColor(C4215R.C4217color.v3_tab_color2));
        this.f20186l = obtainStyledAttributes.getInt(7, 0);
        this.f20187m = obtainStyledAttributes.getInt(5, -1);
        this.f20188n = obtainStyledAttributes.getInt(1, 0);
        this.f20189o = obtainStyledAttributes.getDimensionPixelSize(4, (int) m39030b(16.0f));
    }

    /* renamed from: j */
    private void m39022j(float start, float current, int length) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(start, current);
        ofFloat.setDuration(length);
        ofFloat.setTarget(Float.valueOf(this.f20180f));
        ofFloat.addUpdateListener(new C5555a());
        ofFloat.start();
    }

    /* renamed from: h */
    public int m39024h(float fontSize) {
        Paint paint = new Paint();
        paint.setTextSize(fontSize);
        Rect rect = new Rect();
        String str = this.f20177c;
        paint.getTextBounds(str, 0, str.length(), rect);
        return rect.height();
    }

    /* renamed from: k */
    public StepArcView m39021k(float count) {
        this.f20186l = count;
        return this;
    }

    /* renamed from: l */
    public StepArcView m39020l(float current) {
        this.f20188n = current;
        return this;
    }

    /* renamed from: m */
    public StepArcView m39019m(int currentColor) {
        this.f20185k = currentColor;
        return this;
    }

    /* renamed from: n */
    public StepArcView m39018n(String currentText) {
        this.f20183i = currentText;
        return this;
    }

    /* renamed from: o */
    public StepArcView m39017o(float maxRange) {
        this.f20187m = maxRange;
        return this;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float width = getWidth() / 2;
        float f = this.f20175a;
        float f2 = 2.0f * width;
        RectF rectF = new RectF(0.0f + f, f, f2 - f, f2 - f);
        m39028d(canvas, rectF);
        m39029c(canvas, rectF);
        m39027e(canvas, width);
        m39026f(canvas, width);
        m39025g(canvas, width);
        setCurrentCount(this.f20188n);
    }

    /* renamed from: p */
    public StepArcView m39016p(String targetText) {
        this.f20182h = targetText;
        return this;
    }

    public void setCurrentCount(float currentCounts) {
        float f = this.f20186l;
        if (currentCounts > f) {
            float f2 = this.f20187m;
            currentCounts = (f2 == -1.0f || currentCounts <= f2) ? f : -1.0f;
        }
        float f3 = 1.0f;
        float f4 = this.f20179e;
        float f5 = 0.0f;
        if (f != 0.0f) {
            float floatValue = Float.valueOf(this.f20177c).floatValue();
            float f6 = this.f20186l;
            f4 = this.f20179e * (floatValue / f6);
            f3 = currentCounts / f6;
        }
        if (this.f20187m == -1.0f || currentCounts != -1.0f) {
            f5 = f3;
        } else {
            f4 = 0.0f;
        }
        m39022j(f4, f5 * this.f20179e, this.f20181g);
        this.f20177c = String.valueOf(currentCounts);
        setTextSize(this.f20183i.length());
    }

    public void setTextSize(int length) {
        if (length <= 4) {
            this.f20176b = m39030b((this.f20189o / m39030b(16.0f)) * 50.0f);
        } else if (length > 4 && length <= 6) {
            this.f20176b = m39030b((this.f20189o / m39030b(16.0f)) * 40.0f);
        } else if (length > 6 && length <= 8) {
            this.f20176b = m39030b((this.f20189o / m39030b(16.0f)) * 30.0f);
        } else if (length >= 8) {
            this.f20176b = m39030b(25.0f) * (this.f20189o / m39030b(16.0f));
        }
    }

    public StepArcView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.f20175a = m39030b(10.0f);
        this.f20176b = 0.0f;
        this.f20177c = "0";
        this.f20178d = 135.0f;
        this.f20179e = 270.0f;
        this.f20180f = 0.0f;
        this.f20181g = 500;
        this.f20182h = "达标里程：3.0KM";
        this.f20183i = "0.01KM";
        this.f20184j = "里程(KM)";
        this.f20185k = -16776961;
        this.f20186l = 0.0f;
        this.f20187m = -1.0f;
        this.f20188n = 0.0f;
        this.f20189o = m39030b(16.0f);
        m39023i(attrs);
    }

    public StepArcView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.f20175a = m39030b(10.0f);
        this.f20176b = 0.0f;
        this.f20177c = "0";
        this.f20178d = 135.0f;
        this.f20179e = 270.0f;
        this.f20180f = 0.0f;
        this.f20181g = 500;
        this.f20182h = "达标里程：3.0KM";
        this.f20183i = "0.01KM";
        this.f20184j = "里程(KM)";
        this.f20185k = -16776961;
        this.f20186l = 0.0f;
        this.f20187m = -1.0f;
        this.f20188n = 0.0f;
        this.f20189o = m39030b(16.0f);
        m39023i(attrs);
    }
}
