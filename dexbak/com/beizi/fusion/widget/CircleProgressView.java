package com.beizi.fusion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import com.beizi.fusion.C3025R;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class CircleProgressView extends View {

    /* renamed from: a */
    private Paint f11564a;

    /* renamed from: b */
    private Paint f11565b;

    /* renamed from: c */
    private Paint f11566c;

    /* renamed from: d */
    private Paint f11567d;

    /* renamed from: e */
    private int f11568e;

    /* renamed from: f */
    private int f11569f;

    /* renamed from: g */
    private int f11570g;

    /* renamed from: h */
    private int f11571h;

    /* renamed from: i */
    private float f11572i;

    /* renamed from: j */
    private float f11573j;

    /* renamed from: k */
    private float f11574k;

    /* renamed from: l */
    private int f11575l;

    /* renamed from: m */
    private int f11576m;

    /* renamed from: n */
    private float f11577n;

    /* renamed from: o */
    private float f11578o;

    /* renamed from: p */
    private int f11579p;

    /* renamed from: q */
    private int f11580q;

    /* renamed from: r */
    private float f11581r;

    public CircleProgressView(Context context) {
        this(context, null);
    }

    /* renamed from: a */
    private void m48081a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, C3025R.styleable.CircleProgressViewStyle, 0, 0);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        float applyDimension = TypedValue.applyDimension(1, 18.0f, displayMetrics);
        float applyDimension2 = TypedValue.applyDimension(1, 4.0f, displayMetrics);
        this.f11581r = TypedValue.applyDimension(1, 50.0f, displayMetrics);
        this.f11572i = obtainStyledAttributes.getDimension(C3025R.styleable.CircleProgressViewStyle_adScopeRadius, applyDimension);
        this.f11574k = obtainStyledAttributes.getDimension(C3025R.styleable.CircleProgressViewStyle_adScopeStrokeWidth, applyDimension2);
        this.f11568e = obtainStyledAttributes.getColor(C3025R.styleable.CircleProgressViewStyle_adScopeCircleColor, 0);
        this.f11569f = obtainStyledAttributes.getColor(C3025R.styleable.CircleProgressViewStyle_adScopeRingColor, -41216);
        this.f11570g = obtainStyledAttributes.getColor(C3025R.styleable.CircleProgressViewStyle_adScopeTextColor, -1);
        this.f11571h = obtainStyledAttributes.getColor(C3025R.styleable.CircleProgressViewStyle_adScopeRingBgColor, 1589427388);
        this.f11573j = this.f11572i + (this.f11574k / 2.0f);
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        this.f11575l = getWidth() / 2;
        int height = getHeight() / 2;
        this.f11576m = height;
        canvas.drawCircle(this.f11575l, height, this.f11572i, this.f11564a);
        RectF rectF = new RectF();
        int i = this.f11575l;
        float f = this.f11573j;
        rectF.left = i - f;
        int i2 = this.f11576m;
        rectF.top = i2 - f;
        rectF.right = (f * 2.0f) + (i - f);
        rectF.bottom = (f * 2.0f) + (i2 - f);
        canvas.drawArc(rectF, 0.0f, 360.0f, false, this.f11566c);
        if (this.f11580q > 0) {
            RectF rectF2 = new RectF();
            int i3 = this.f11575l;
            float f2 = this.f11573j;
            rectF2.left = i3 - f2;
            int i4 = this.f11576m;
            rectF2.top = i4 - f2;
            rectF2.right = (f2 * 2.0f) + (i3 - f2);
            rectF2.bottom = (f2 * 2.0f) + (i4 - f2);
            canvas.drawArc(rectF2, -90.0f, (this.f11580q / this.f11579p) * 360.0f, false, this.f11565b);
            float measureText = this.f11567d.measureText("跳过", 0, 2);
            this.f11577n = measureText;
            canvas.drawText("跳过", this.f11575l - (measureText / 2.0f), this.f11576m + (this.f11578o / 4.0f), this.f11567d);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode != 1073741824) {
            size = (int) (getPaddingLeft() + this.f11581r + getPaddingRight());
        }
        if (mode2 != 1073741824) {
            size2 = (int) (getPaddingTop() + this.f11581r + getPaddingBottom());
        }
        setMeasuredDimension(size, size2);
    }

    public void setProgress(int i) {
        this.f11580q = i;
        postInvalidate();
    }

    public CircleProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11579p = 100;
        m48081a(context, attributeSet);
        m48082a();
    }

    /* renamed from: a */
    private void m48082a() {
        Paint paint = new Paint();
        this.f11564a = paint;
        paint.setAntiAlias(true);
        this.f11564a.setColor(this.f11568e);
        this.f11564a.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint();
        this.f11566c = paint2;
        paint2.setAntiAlias(true);
        this.f11566c.setColor(this.f11571h);
        this.f11566c.setStyle(Paint.Style.STROKE);
        this.f11566c.setStrokeWidth(this.f11574k);
        Paint paint3 = new Paint();
        this.f11565b = paint3;
        paint3.setAntiAlias(true);
        this.f11565b.setColor(this.f11569f);
        this.f11565b.setStyle(Paint.Style.STROKE);
        this.f11565b.setStrokeWidth(this.f11574k);
        this.f11565b.setStrokeCap(Paint.Cap.ROUND);
        Paint paint4 = new Paint();
        this.f11567d = paint4;
        paint4.setAntiAlias(true);
        this.f11567d.setStyle(Paint.Style.FILL);
        this.f11567d.setColor(this.f11570g);
        this.f11567d.setTextSize((this.f11572i * 3.0f) / 5.0f);
        this.f11567d.setShadowLayer(2.0f, 1.0f, 1.0f, Color.parseColor("#000000"));
        Paint.FontMetrics fontMetrics = this.f11567d.getFontMetrics();
        this.f11578o = (int) Math.ceil(fontMetrics.descent - fontMetrics.ascent);
    }
}
