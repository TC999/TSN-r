package com.beizi.fusion.update;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import com.beizi.fusion.g.af;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class ShakeArcView extends View {

    /* renamed from: a  reason: collision with root package name */
    private int f15108a;

    /* renamed from: b  reason: collision with root package name */
    private int f15109b;

    /* renamed from: c  reason: collision with root package name */
    private int f15110c;

    /* renamed from: d  reason: collision with root package name */
    private Paint f15111d;

    /* renamed from: e  reason: collision with root package name */
    private Paint f15112e;

    /* renamed from: f  reason: collision with root package name */
    private double f15113f;

    /* renamed from: g  reason: collision with root package name */
    private double f15114g;

    /* renamed from: h  reason: collision with root package name */
    private int f15115h;

    /* renamed from: i  reason: collision with root package name */
    private int f15116i;

    public ShakeArcView(Context context) {
        this(context, null);
    }

    private void a() {
        Paint paint = new Paint();
        this.f15111d = paint;
        paint.setAntiAlias(true);
        this.f15111d.setDither(true);
        this.f15111d.setStrokeWidth(this.f15110c);
        this.f15111d.setColor(this.f15108a);
        this.f15111d.setStyle(Paint.Style.STROKE);
        this.f15111d.setStrokeCap(Paint.Cap.ROUND);
    }

    private void b() {
        Paint paint = new Paint();
        this.f15112e = paint;
        paint.setAntiAlias(true);
        this.f15112e.setDither(true);
        this.f15112e.setStrokeWidth(this.f15110c);
        this.f15112e.setColor(this.f15109b);
        this.f15112e.setStyle(Paint.Style.STROKE);
        this.f15112e.setStrokeCap(Paint.Cap.ROUND);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        try {
            int i4 = this.f15110c;
            RectF rectF = new RectF(i4 / 2, i4 / 2, getWidth() - (this.f15110c / 2), getHeight() - (this.f15110c / 2));
            canvas.drawArc(rectF, 215.0f, 110.0f, false, this.f15111d);
            double d4 = this.f15114g;
            if (d4 >= 0.0d) {
                double d5 = this.f15113f;
                if (d5 > 0.0d) {
                    if (d4 >= d5) {
                        this.f15114g = d5;
                    }
                    double d6 = (float) this.f15114g;
                    Double.isNaN(d6);
                    float f4 = (float) (d6 / d5);
                    af.c("sweepAngle", "sweepAngle:" + f4 + ",mMaxProgress:" + this.f15113f + ",mCurrentProgress:" + this.f15114g);
                    int i5 = this.f15115h;
                    if (i5 == 1) {
                        canvas.drawArc(rectF, 215.0f, f4 * 110.0f, false, this.f15112e);
                    } else if (i5 == 2) {
                        canvas.drawArc(rectF, 325.0f, (-f4) * 110.0f, false, this.f15112e);
                    } else {
                        canvas.drawArc(rectF, 270.0f, (-f4) * 55.0f, false, this.f15112e);
                        canvas.drawArc(rectF, 270.0f, f4 * 55.0f, false, this.f15112e);
                    }
                }
            }
            int parseColor = Color.parseColor("#CACCCA");
            if (this.f15114g == this.f15113f) {
                parseColor = Color.parseColor("#FFFFFF");
            }
            int width = getWidth();
            int height = getHeight();
            int min = (Math.min(width, height) / 2) + (this.f15110c * this.f15116i);
            int i6 = width / 2;
            int i7 = height / 2;
            float cos = (float) Math.cos(Math.toRadians(45.0d));
            int i8 = this.f15115h;
            if (i8 == 1) {
                double d7 = i6;
                Double.isNaN(d7);
                double d8 = d7 * 1.5d;
                double d9 = cos * min;
                Double.isNaN(d9);
                float f5 = (float) ((0.4d * d9) + d8);
                double d10 = i7 / 2;
                Double.isNaN(d9);
                double d11 = d9 * 0.2d;
                Double.isNaN(d10);
                float f6 = (float) (d10 - d11);
                float f7 = i7 / 2;
                a(canvas, true, f5, f6, (float) (d8 + d11), f7, f5, f7, parseColor);
            } else if (i8 == 2) {
                double d12 = i6 / 2;
                double d13 = cos * min;
                Double.isNaN(d13);
                Double.isNaN(d12);
                float f8 = (float) (d12 - (0.4d * d13));
                double d14 = i7 / 2;
                Double.isNaN(d13);
                double d15 = d13 * 0.2d;
                Double.isNaN(d14);
                float f9 = (float) (d14 - d15);
                double d16 = i6 / 2;
                Double.isNaN(d16);
                float f10 = i7 / 2;
                a(canvas, true, f8, f9, (float) (d16 - d15), f10, f8, f10, parseColor);
            } else {
                double d17 = i6 / 2;
                double d18 = cos * min;
                Double.isNaN(d18);
                double d19 = d18 * 0.4d;
                Double.isNaN(d17);
                float f11 = (float) (d17 - d19);
                double d20 = i7 / 2;
                Double.isNaN(d18);
                double d21 = d18 * 0.2d;
                Double.isNaN(d20);
                float f12 = (float) (d20 - d21);
                double d22 = i6 / 2;
                Double.isNaN(d22);
                float f13 = i7 / 2;
                a(canvas, true, f11, f12, (float) (d22 - d21), f13, f11, f13, parseColor);
                double d23 = i6;
                Double.isNaN(d23);
                double d24 = d23 * 1.5d;
                float f14 = (float) (d24 + d19);
                double d25 = i7 / 2;
                Double.isNaN(d25);
                float f15 = i7 / 2;
                a(canvas, true, f14, (float) (d25 - d21), (float) (d24 + d21), f15, f14, f15, parseColor);
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i4, int i5) {
        super.onMeasure(i4, i5);
        int size = View.MeasureSpec.getSize(i4) + (this.f15110c * 2);
        int size2 = View.MeasureSpec.getSize(i5) + (this.f15110c * 2);
        setMeasuredDimension(Math.min(size, size2), Math.min(size, size2));
    }

    public ShakeArcView setArrowDirection(int i4) {
        this.f15115h = i4;
        return this;
    }

    public ShakeArcView setCurrentProgress(double d4) {
        this.f15114g = d4 * 100.0d;
        invalidate();
        return this;
    }

    public void setLineRadius(int i4) {
        this.f15116i = i4;
    }

    public void setLineWidth(int i4) {
        try {
            this.f15110c = i4;
            Paint paint = this.f15111d;
            if (paint != null) {
                paint.setStrokeWidth(i4);
            }
            Paint paint2 = this.f15112e;
            if (paint2 != null) {
                paint2.setStrokeWidth(this.f15110c);
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public ShakeArcView setMaxProgress(double d4) {
        this.f15113f = d4 * 100.0d;
        return this;
    }

    public ShakeArcView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ShakeArcView(Context context, @Nullable AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f15108a = Color.parseColor("#CACCCA");
        this.f15109b = Color.parseColor("#FFFFFF");
        this.f15110c = 6;
        this.f15113f = -1.0d;
        this.f15114g = -1.0d;
        this.f15115h = 0;
        this.f15116i = 2;
        a();
        b();
    }

    private void a(Canvas canvas, boolean z3, float f4, float f5, float f6, float f7, float f8, float f9, int i4) {
        try {
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setColor(i4);
            if (z3) {
                paint.setStyle(Paint.Style.FILL);
            } else {
                paint.setStyle(Paint.Style.STROKE);
            }
            Path path = new Path();
            path.moveTo(f4, f5);
            path.lineTo(f6, f7);
            path.lineTo(f8, f9);
            path.lineTo(f4, f5);
            path.close();
            canvas.drawPath(path, paint);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }
}
