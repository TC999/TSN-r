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
import com.beizi.fusion.R;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class CircleProgressView extends View {

    /* renamed from: a  reason: collision with root package name */
    private Paint f15149a;

    /* renamed from: b  reason: collision with root package name */
    private Paint f15150b;

    /* renamed from: c  reason: collision with root package name */
    private Paint f15151c;

    /* renamed from: d  reason: collision with root package name */
    private Paint f15152d;

    /* renamed from: e  reason: collision with root package name */
    private int f15153e;

    /* renamed from: f  reason: collision with root package name */
    private int f15154f;

    /* renamed from: g  reason: collision with root package name */
    private int f15155g;

    /* renamed from: h  reason: collision with root package name */
    private int f15156h;

    /* renamed from: i  reason: collision with root package name */
    private float f15157i;

    /* renamed from: j  reason: collision with root package name */
    private float f15158j;

    /* renamed from: k  reason: collision with root package name */
    private float f15159k;

    /* renamed from: l  reason: collision with root package name */
    private int f15160l;

    /* renamed from: m  reason: collision with root package name */
    private int f15161m;

    /* renamed from: n  reason: collision with root package name */
    private float f15162n;

    /* renamed from: o  reason: collision with root package name */
    private float f15163o;

    /* renamed from: p  reason: collision with root package name */
    private int f15164p;

    /* renamed from: q  reason: collision with root package name */
    private int f15165q;

    /* renamed from: r  reason: collision with root package name */
    private float f15166r;

    public CircleProgressView(Context context) {
        this(context, null);
    }

    private void a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.CircleProgressViewStyle, 0, 0);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        float applyDimension = TypedValue.applyDimension(1, 18.0f, displayMetrics);
        float applyDimension2 = TypedValue.applyDimension(1, 4.0f, displayMetrics);
        this.f15166r = TypedValue.applyDimension(1, 50.0f, displayMetrics);
        this.f15157i = obtainStyledAttributes.getDimension(R.styleable.CircleProgressViewStyle_adScopeRadius, applyDimension);
        this.f15159k = obtainStyledAttributes.getDimension(R.styleable.CircleProgressViewStyle_adScopeStrokeWidth, applyDimension2);
        this.f15153e = obtainStyledAttributes.getColor(R.styleable.CircleProgressViewStyle_adScopeCircleColor, 0);
        this.f15154f = obtainStyledAttributes.getColor(R.styleable.CircleProgressViewStyle_adScopeRingColor, -41216);
        this.f15155g = obtainStyledAttributes.getColor(R.styleable.CircleProgressViewStyle_adScopeTextColor, -1);
        this.f15156h = obtainStyledAttributes.getColor(R.styleable.CircleProgressViewStyle_adScopeRingBgColor, 1589427388);
        this.f15158j = this.f15157i + (this.f15159k / 2.0f);
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        this.f15160l = getWidth() / 2;
        int height = getHeight() / 2;
        this.f15161m = height;
        canvas.drawCircle(this.f15160l, height, this.f15157i, this.f15149a);
        RectF rectF = new RectF();
        int i4 = this.f15160l;
        float f4 = this.f15158j;
        rectF.left = i4 - f4;
        int i5 = this.f15161m;
        rectF.top = i5 - f4;
        rectF.right = (f4 * 2.0f) + (i4 - f4);
        rectF.bottom = (f4 * 2.0f) + (i5 - f4);
        canvas.drawArc(rectF, 0.0f, 360.0f, false, this.f15151c);
        if (this.f15165q > 0) {
            RectF rectF2 = new RectF();
            int i6 = this.f15160l;
            float f5 = this.f15158j;
            rectF2.left = i6 - f5;
            int i7 = this.f15161m;
            rectF2.top = i7 - f5;
            rectF2.right = (f5 * 2.0f) + (i6 - f5);
            rectF2.bottom = (f5 * 2.0f) + (i7 - f5);
            canvas.drawArc(rectF2, -90.0f, (this.f15165q / this.f15164p) * 360.0f, false, this.f15150b);
            float measureText = this.f15152d.measureText("\u8df3\u8fc7", 0, 2);
            this.f15162n = measureText;
            canvas.drawText("\u8df3\u8fc7", this.f15160l - (measureText / 2.0f), this.f15161m + (this.f15163o / 4.0f), this.f15152d);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i4, int i5) {
        super.onMeasure(i4, i5);
        int mode = View.MeasureSpec.getMode(i4);
        int mode2 = View.MeasureSpec.getMode(i5);
        int size = View.MeasureSpec.getSize(i4);
        int size2 = View.MeasureSpec.getSize(i5);
        if (mode != 1073741824) {
            size = (int) (getPaddingLeft() + this.f15166r + getPaddingRight());
        }
        if (mode2 != 1073741824) {
            size2 = (int) (getPaddingTop() + this.f15166r + getPaddingBottom());
        }
        setMeasuredDimension(size, size2);
    }

    public void setProgress(int i4) {
        this.f15165q = i4;
        postInvalidate();
    }

    public CircleProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f15164p = 100;
        a(context, attributeSet);
        a();
    }

    private void a() {
        Paint paint = new Paint();
        this.f15149a = paint;
        paint.setAntiAlias(true);
        this.f15149a.setColor(this.f15153e);
        this.f15149a.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint();
        this.f15151c = paint2;
        paint2.setAntiAlias(true);
        this.f15151c.setColor(this.f15156h);
        this.f15151c.setStyle(Paint.Style.STROKE);
        this.f15151c.setStrokeWidth(this.f15159k);
        Paint paint3 = new Paint();
        this.f15150b = paint3;
        paint3.setAntiAlias(true);
        this.f15150b.setColor(this.f15154f);
        this.f15150b.setStyle(Paint.Style.STROKE);
        this.f15150b.setStrokeWidth(this.f15159k);
        this.f15150b.setStrokeCap(Paint.Cap.ROUND);
        Paint paint4 = new Paint();
        this.f15152d = paint4;
        paint4.setAntiAlias(true);
        this.f15152d.setStyle(Paint.Style.FILL);
        this.f15152d.setColor(this.f15155g);
        this.f15152d.setTextSize((this.f15157i * 3.0f) / 5.0f);
        this.f15152d.setShadowLayer(2.0f, 1.0f, 1.0f, Color.parseColor("#000000"));
        Paint.FontMetrics fontMetrics = this.f15152d.getFontMetrics();
        this.f15163o = (int) Math.ceil(fontMetrics.descent - fontMetrics.ascent);
    }
}
