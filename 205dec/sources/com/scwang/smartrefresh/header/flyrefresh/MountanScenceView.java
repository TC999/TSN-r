package com.scwang.smartrefresh.header.flyrefresh;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Interpolator;
import androidx.annotation.ColorInt;
import androidx.annotation.RequiresApi;
import com.scwang.smartrefresh.header.R;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class MountanScenceView extends View {
    private static final int A = 240;
    private static final int B = 180;
    private static final int C = 100;
    private static final int D = 200;

    /* renamed from: a  reason: collision with root package name */
    private int f47670a;

    /* renamed from: b  reason: collision with root package name */
    private int f47671b;

    /* renamed from: c  reason: collision with root package name */
    private int f47672c;

    /* renamed from: d  reason: collision with root package name */
    private int f47673d;

    /* renamed from: e  reason: collision with root package name */
    private int f47674e;

    /* renamed from: f  reason: collision with root package name */
    private int f47675f;

    /* renamed from: g  reason: collision with root package name */
    private int f47676g;

    /* renamed from: h  reason: collision with root package name */
    private int f47677h;

    /* renamed from: i  reason: collision with root package name */
    private int f47678i;

    /* renamed from: j  reason: collision with root package name */
    private int f47679j;

    /* renamed from: k  reason: collision with root package name */
    private Paint f47680k;

    /* renamed from: l  reason: collision with root package name */
    private Paint f47681l;

    /* renamed from: m  reason: collision with root package name */
    private Paint f47682m;

    /* renamed from: n  reason: collision with root package name */
    private Paint f47683n;

    /* renamed from: o  reason: collision with root package name */
    private Path f47684o;

    /* renamed from: p  reason: collision with root package name */
    private Path f47685p;

    /* renamed from: q  reason: collision with root package name */
    private Path f47686q;

    /* renamed from: r  reason: collision with root package name */
    private Path f47687r;

    /* renamed from: s  reason: collision with root package name */
    private Path f47688s;

    /* renamed from: t  reason: collision with root package name */
    private Matrix f47689t;

    /* renamed from: u  reason: collision with root package name */
    private float f47690u;

    /* renamed from: v  reason: collision with root package name */
    private float f47691v;

    /* renamed from: w  reason: collision with root package name */
    private float f47692w;

    /* renamed from: x  reason: collision with root package name */
    private float f47693x;

    /* renamed from: y  reason: collision with root package name */
    private float f47694y;

    /* renamed from: z  reason: collision with root package name */
    private int f47695z;

    public MountanScenceView(Context context) {
        super(context);
        this.f47670a = Color.parseColor("#7ECEC9");
        this.f47671b = Color.parseColor("#86DAD7");
        this.f47672c = Color.parseColor("#3C929C");
        this.f47673d = Color.parseColor("#3E5F73");
        this.f47674e = Color.parseColor("#1F7177");
        this.f47675f = Color.parseColor("#0C3E48");
        this.f47676g = Color.parseColor("#34888F");
        this.f47677h = Color.parseColor("#1B6169");
        this.f47678i = Color.parseColor("#57B1AE");
        this.f47679j = Color.parseColor("#62A4AD");
        this.f47680k = new Paint();
        this.f47681l = new Paint();
        this.f47682m = new Paint();
        this.f47683n = new Paint();
        this.f47684o = new Path();
        this.f47685p = new Path();
        this.f47686q = new Path();
        this.f47687r = new Path();
        this.f47688s = new Path();
        this.f47689t = new Matrix();
        this.f47690u = 5.0f;
        this.f47691v = 5.0f;
        this.f47692w = 0.0f;
        this.f47693x = 1.0f;
        this.f47694y = Float.MAX_VALUE;
        this.f47695z = 0;
        b(context, null, 0);
    }

    private void a(Canvas canvas, float f4, float f5, float f6, int i4, int i5) {
        canvas.save();
        canvas.translate(f5 - ((100.0f * f4) / 2.0f), f6 - (200.0f * f4));
        canvas.scale(f4, f4);
        this.f47682m.setColor(i5);
        canvas.drawPath(this.f47688s, this.f47682m);
        this.f47681l.setColor(i4);
        canvas.drawPath(this.f47687r, this.f47681l);
        this.f47683n.setColor(i4);
        canvas.drawPath(this.f47688s, this.f47683n);
        canvas.restore();
    }

    private void b(Context context, AttributeSet attributeSet, int i4) {
        this.f47680k.setAntiAlias(true);
        this.f47680k.setStyle(Paint.Style.FILL);
        this.f47681l.setAntiAlias(true);
        this.f47682m.setAntiAlias(true);
        this.f47683n.setAntiAlias(true);
        this.f47683n.setStyle(Paint.Style.STROKE);
        this.f47683n.setStrokeWidth(2.0f);
        this.f47683n.setStrokeJoin(Paint.Join.ROUND);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MountanScenceView);
        int i5 = R.styleable.MountanScenceView_msvPrimaryColor;
        if (obtainStyledAttributes.hasValue(i5)) {
            setPrimaryColor(obtainStyledAttributes.getColor(i5, -16777216));
        }
        this.f47695z = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.MountanScenceView_msvViewportHeight, 0);
        obtainStyledAttributes.recycle();
        c(this.f47692w, 180);
        e(this.f47692w, true);
    }

    private void c(float f4, int i4) {
        this.f47689t.reset();
        this.f47689t.setScale(this.f47690u, this.f47691v);
        int i5 = (int) (10.0f * f4);
        this.f47684o.reset();
        this.f47684o.moveTo(0.0f, i5 + 95);
        this.f47684o.lineTo(55.0f, i5 + 74);
        this.f47684o.lineTo(146.0f, i5 + 104);
        this.f47684o.lineTo(227.0f, i5 + 72);
        this.f47684o.lineTo(240.0f, i5 + 80);
        this.f47684o.lineTo(240.0f, 180.0f);
        this.f47684o.lineTo(0.0f, 180.0f);
        this.f47684o.close();
        this.f47684o.transform(this.f47689t);
        int i6 = (int) (20.0f * f4);
        this.f47685p.reset();
        this.f47685p.moveTo(0.0f, i6 + 103);
        this.f47685p.lineTo(67.0f, i6 + 90);
        this.f47685p.lineTo(165.0f, i6 + 115);
        this.f47685p.lineTo(221.0f, i6 + 87);
        this.f47685p.lineTo(240.0f, i6 + 100);
        this.f47685p.lineTo(240.0f, 180.0f);
        this.f47685p.lineTo(0.0f, 180.0f);
        this.f47685p.close();
        this.f47685p.transform(this.f47689t);
        int i7 = (int) (f4 * 30.0f);
        this.f47686q.reset();
        this.f47686q.moveTo(0.0f, i7 + 114);
        this.f47686q.cubicTo(30.0f, i7 + 106, 196.0f, i7 + 97, 240.0f, i7 + 104);
        float f5 = i4;
        this.f47686q.lineTo(240.0f, f5 / this.f47691v);
        this.f47686q.lineTo(0.0f, f5 / this.f47691v);
        this.f47686q.close();
        this.f47686q.transform(this.f47689t);
    }

    private void e(float f4, boolean z3) {
        int i4;
        if (f4 != this.f47694y || z3) {
            Interpolator a4 = a.a(0.8f, (-0.5f) * f4);
            float f5 = f4 * 30.000002f;
            float[] fArr = new float[26];
            float[] fArr2 = new float[26];
            int i5 = 0;
            float f6 = 0.0f;
            float f7 = 200.0f;
            while (true) {
                if (i5 > 25) {
                    break;
                }
                fArr[i5] = (a4.getInterpolation(f6) * f5) + 50.0f;
                fArr2[i5] = f7;
                f7 -= 8.0f;
                f6 += 0.04f;
                i5++;
            }
            this.f47687r.reset();
            this.f47687r.moveTo(45.0f, 200.0f);
            int i6 = (int) (17 * 0.5f);
            float f8 = 17 - i6;
            for (int i7 = 0; i7 < 17; i7++) {
                if (i7 < i6) {
                    this.f47687r.lineTo(fArr[i7] - 5.0f, fArr2[i7]);
                } else {
                    this.f47687r.lineTo(fArr[i7] - (((17 - i7) * 5.0f) / f8), fArr2[i7]);
                }
            }
            for (int i8 = 16; i8 >= 0; i8--) {
                if (i8 < i6) {
                    this.f47687r.lineTo(fArr[i8] + 5.0f, fArr2[i8]);
                } else {
                    this.f47687r.lineTo(fArr[i8] + (((17 - i8) * 5.0f) / f8), fArr2[i8]);
                }
            }
            this.f47687r.close();
            this.f47688s.reset();
            float f9 = 15;
            this.f47688s.moveTo(fArr[10] - 20.0f, fArr2[10]);
            this.f47688s.addArc(new RectF(fArr[10] - 20.0f, fArr2[10] - 20.0f, fArr[10] + 20.0f, fArr2[10] + 20.0f), 0.0f, 180.0f);
            for (int i9 = 10; i9 <= 25; i9++) {
                float f10 = (i9 - 10) / f9;
                this.f47688s.lineTo((fArr[i9] - 20.0f) + (f10 * f10 * 20.0f), fArr2[i9]);
            }
            for (i4 = 25; i4 >= 10; i4--) {
                float f11 = (i4 - 10) / f9;
                this.f47688s.lineTo((fArr[i4] + 20.0f) - ((f11 * f11) * 20.0f), fArr2[i4]);
            }
        }
    }

    public void d(float f4) {
        this.f47693x = f4;
        float max = Math.max(0.0f, f4);
        this.f47692w = Math.max(0.0f, this.f47693x);
        int measuredHeight = getMeasuredHeight();
        float f5 = this.f47692w;
        if (measuredHeight <= 0) {
            measuredHeight = 180;
        }
        c(f5, measuredHeight);
        e(max, false);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(this.f47670a);
        this.f47680k.setColor(this.f47671b);
        canvas.drawPath(this.f47684o, this.f47680k);
        canvas.save();
        canvas.scale(-1.0f, 1.0f, getWidth() / 2, 0.0f);
        float f4 = this.f47690u;
        a(canvas, f4 * 0.12f, f4 * 180.0f, ((this.f47692w * 20.0f) + 93.0f) * this.f47691v, this.f47679j, this.f47678i);
        float f5 = this.f47690u;
        a(canvas, f5 * 0.1f, f5 * 200.0f, ((this.f47692w * 20.0f) + 96.0f) * this.f47691v, this.f47679j, this.f47678i);
        canvas.restore();
        this.f47680k.setColor(this.f47672c);
        canvas.drawPath(this.f47685p, this.f47680k);
        float f6 = this.f47690u;
        a(canvas, f6 * 0.2f, f6 * 160.0f, ((this.f47692w * 30.0f) + 105.0f) * this.f47691v, this.f47675f, this.f47674e);
        float f7 = this.f47690u;
        a(canvas, f7 * 0.14f, f7 * 180.0f, ((this.f47692w * 30.0f) + 105.0f) * this.f47691v, this.f47677h, this.f47676g);
        float f8 = this.f47690u;
        a(canvas, f8 * 0.16f, f8 * 140.0f, ((this.f47692w * 30.0f) + 105.0f) * this.f47691v, this.f47677h, this.f47676g);
        this.f47680k.setColor(this.f47673d);
        canvas.drawPath(this.f47686q, this.f47680k);
    }

    @Override // android.view.View
    protected void onMeasure(int i4, int i5) {
        super.onMeasure(i4, i5);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        this.f47690u = (measuredWidth * 1.0f) / 240.0f;
        int i6 = this.f47695z;
        if (i6 <= 0) {
            i6 = measuredHeight;
        }
        this.f47691v = (i6 * 1.0f) / 180.0f;
        c(this.f47692w, measuredHeight);
        e(this.f47692w, true);
    }

    public void setPrimaryColor(@ColorInt int i4) {
        this.f47670a = i4;
        this.f47671b = com.scwang.smartrefresh.layout.util.a.t(-1711276033, i4);
        this.f47672c = com.scwang.smartrefresh.layout.util.a.t(-1724083556, i4);
        this.f47673d = com.scwang.smartrefresh.layout.util.a.t(-868327565, i4);
        this.f47674e = com.scwang.smartrefresh.layout.util.a.t(1428124023, i4);
        this.f47675f = com.scwang.smartrefresh.layout.util.a.t(-871612856, i4);
        this.f47676g = com.scwang.smartrefresh.layout.util.a.t(1429506191, i4);
        this.f47677h = com.scwang.smartrefresh.layout.util.a.t(-870620823, i4);
        this.f47678i = com.scwang.smartrefresh.layout.util.a.t(1431810478, i4);
        this.f47679j = com.scwang.smartrefresh.layout.util.a.t(-865950547, i4);
    }

    public MountanScenceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f47670a = Color.parseColor("#7ECEC9");
        this.f47671b = Color.parseColor("#86DAD7");
        this.f47672c = Color.parseColor("#3C929C");
        this.f47673d = Color.parseColor("#3E5F73");
        this.f47674e = Color.parseColor("#1F7177");
        this.f47675f = Color.parseColor("#0C3E48");
        this.f47676g = Color.parseColor("#34888F");
        this.f47677h = Color.parseColor("#1B6169");
        this.f47678i = Color.parseColor("#57B1AE");
        this.f47679j = Color.parseColor("#62A4AD");
        this.f47680k = new Paint();
        this.f47681l = new Paint();
        this.f47682m = new Paint();
        this.f47683n = new Paint();
        this.f47684o = new Path();
        this.f47685p = new Path();
        this.f47686q = new Path();
        this.f47687r = new Path();
        this.f47688s = new Path();
        this.f47689t = new Matrix();
        this.f47690u = 5.0f;
        this.f47691v = 5.0f;
        this.f47692w = 0.0f;
        this.f47693x = 1.0f;
        this.f47694y = Float.MAX_VALUE;
        this.f47695z = 0;
        b(context, attributeSet, 0);
    }

    public MountanScenceView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f47670a = Color.parseColor("#7ECEC9");
        this.f47671b = Color.parseColor("#86DAD7");
        this.f47672c = Color.parseColor("#3C929C");
        this.f47673d = Color.parseColor("#3E5F73");
        this.f47674e = Color.parseColor("#1F7177");
        this.f47675f = Color.parseColor("#0C3E48");
        this.f47676g = Color.parseColor("#34888F");
        this.f47677h = Color.parseColor("#1B6169");
        this.f47678i = Color.parseColor("#57B1AE");
        this.f47679j = Color.parseColor("#62A4AD");
        this.f47680k = new Paint();
        this.f47681l = new Paint();
        this.f47682m = new Paint();
        this.f47683n = new Paint();
        this.f47684o = new Path();
        this.f47685p = new Path();
        this.f47686q = new Path();
        this.f47687r = new Path();
        this.f47688s = new Path();
        this.f47689t = new Matrix();
        this.f47690u = 5.0f;
        this.f47691v = 5.0f;
        this.f47692w = 0.0f;
        this.f47693x = 1.0f;
        this.f47694y = Float.MAX_VALUE;
        this.f47695z = 0;
        b(context, attributeSet, i4);
    }

    @RequiresApi(21)
    public MountanScenceView(Context context, AttributeSet attributeSet, int i4, int i5) {
        super(context, attributeSet, i4, i5);
        this.f47670a = Color.parseColor("#7ECEC9");
        this.f47671b = Color.parseColor("#86DAD7");
        this.f47672c = Color.parseColor("#3C929C");
        this.f47673d = Color.parseColor("#3E5F73");
        this.f47674e = Color.parseColor("#1F7177");
        this.f47675f = Color.parseColor("#0C3E48");
        this.f47676g = Color.parseColor("#34888F");
        this.f47677h = Color.parseColor("#1B6169");
        this.f47678i = Color.parseColor("#57B1AE");
        this.f47679j = Color.parseColor("#62A4AD");
        this.f47680k = new Paint();
        this.f47681l = new Paint();
        this.f47682m = new Paint();
        this.f47683n = new Paint();
        this.f47684o = new Path();
        this.f47685p = new Path();
        this.f47686q = new Path();
        this.f47687r = new Path();
        this.f47688s = new Path();
        this.f47689t = new Matrix();
        this.f47690u = 5.0f;
        this.f47691v = 5.0f;
        this.f47692w = 0.0f;
        this.f47693x = 1.0f;
        this.f47694y = Float.MAX_VALUE;
        this.f47695z = 0;
        b(context, attributeSet, i4);
    }
}
