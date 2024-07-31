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
import com.beizi.fusion.p072g.C3116af;
import com.github.mikephil.charting.utils.Utils;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class ShakeArcView extends View {

    /* renamed from: a */
    private int f11524a;

    /* renamed from: b */
    private int f11525b;

    /* renamed from: c */
    private int f11526c;

    /* renamed from: d */
    private Paint f11527d;

    /* renamed from: e */
    private Paint f11528e;

    /* renamed from: f */
    private double f11529f;

    /* renamed from: g */
    private double f11530g;

    /* renamed from: h */
    private int f11531h;

    /* renamed from: i */
    private int f11532i;

    public ShakeArcView(Context context) {
        this(context, null);
    }

    /* renamed from: a */
    private void m48111a() {
        Paint paint = new Paint();
        this.f11527d = paint;
        paint.setAntiAlias(true);
        this.f11527d.setDither(true);
        this.f11527d.setStrokeWidth(this.f11526c);
        this.f11527d.setColor(this.f11524a);
        this.f11527d.setStyle(Paint.Style.STROKE);
        this.f11527d.setStrokeCap(Paint.Cap.ROUND);
    }

    /* renamed from: b */
    private void m48109b() {
        Paint paint = new Paint();
        this.f11528e = paint;
        paint.setAntiAlias(true);
        this.f11528e.setDither(true);
        this.f11528e.setStrokeWidth(this.f11526c);
        this.f11528e.setColor(this.f11525b);
        this.f11528e.setStyle(Paint.Style.STROKE);
        this.f11528e.setStrokeCap(Paint.Cap.ROUND);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        try {
            int i = this.f11526c;
            RectF rectF = new RectF(i / 2, i / 2, getWidth() - (this.f11526c / 2), getHeight() - (this.f11526c / 2));
            canvas.drawArc(rectF, 215.0f, 110.0f, false, this.f11527d);
            double d = this.f11530g;
            if (d >= Utils.DOUBLE_EPSILON) {
                double d2 = this.f11529f;
                if (d2 > Utils.DOUBLE_EPSILON) {
                    if (d >= d2) {
                        this.f11530g = d2;
                    }
                    double d3 = (float) this.f11530g;
                    Double.isNaN(d3);
                    float f = (float) (d3 / d2);
                    C3116af.m48494c("sweepAngle", "sweepAngle:" + f + ",mMaxProgress:" + this.f11529f + ",mCurrentProgress:" + this.f11530g);
                    int i2 = this.f11531h;
                    if (i2 == 1) {
                        canvas.drawArc(rectF, 215.0f, f * 110.0f, false, this.f11528e);
                    } else if (i2 == 2) {
                        canvas.drawArc(rectF, 325.0f, (-f) * 110.0f, false, this.f11528e);
                    } else {
                        canvas.drawArc(rectF, 270.0f, (-f) * 55.0f, false, this.f11528e);
                        canvas.drawArc(rectF, 270.0f, f * 55.0f, false, this.f11528e);
                    }
                }
            }
            int parseColor = Color.parseColor("#CACCCA");
            if (this.f11530g == this.f11529f) {
                parseColor = Color.parseColor("#FFFFFF");
            }
            int width = getWidth();
            int height = getHeight();
            int min = (Math.min(width, height) / 2) + (this.f11526c * this.f11532i);
            int i3 = width / 2;
            int i4 = height / 2;
            float cos = (float) Math.cos(Math.toRadians(45.0d));
            int i5 = this.f11531h;
            if (i5 == 1) {
                double d4 = i3;
                Double.isNaN(d4);
                double d5 = d4 * 1.5d;
                double d6 = cos * min;
                Double.isNaN(d6);
                float f2 = (float) ((0.4d * d6) + d5);
                double d7 = i4 / 2;
                Double.isNaN(d6);
                double d8 = d6 * 0.2d;
                Double.isNaN(d7);
                float f3 = (float) (d7 - d8);
                float f4 = i4 / 2;
                m48110a(canvas, true, f2, f3, (float) (d5 + d8), f4, f2, f4, parseColor);
            } else if (i5 == 2) {
                double d9 = i3 / 2;
                double d10 = cos * min;
                Double.isNaN(d10);
                Double.isNaN(d9);
                float f5 = (float) (d9 - (0.4d * d10));
                double d11 = i4 / 2;
                Double.isNaN(d10);
                double d12 = d10 * 0.2d;
                Double.isNaN(d11);
                float f6 = (float) (d11 - d12);
                double d13 = i3 / 2;
                Double.isNaN(d13);
                float f7 = i4 / 2;
                m48110a(canvas, true, f5, f6, (float) (d13 - d12), f7, f5, f7, parseColor);
            } else {
                double d14 = i3 / 2;
                double d15 = cos * min;
                Double.isNaN(d15);
                double d16 = d15 * 0.4d;
                Double.isNaN(d14);
                float f8 = (float) (d14 - d16);
                double d17 = i4 / 2;
                Double.isNaN(d15);
                double d18 = d15 * 0.2d;
                Double.isNaN(d17);
                float f9 = (float) (d17 - d18);
                double d19 = i3 / 2;
                Double.isNaN(d19);
                float f10 = i4 / 2;
                m48110a(canvas, true, f8, f9, (float) (d19 - d18), f10, f8, f10, parseColor);
                double d20 = i3;
                Double.isNaN(d20);
                double d21 = d20 * 1.5d;
                float f11 = (float) (d21 + d16);
                double d22 = i4 / 2;
                Double.isNaN(d22);
                float f12 = i4 / 2;
                m48110a(canvas, true, f11, (float) (d22 - d18), (float) (d21 + d18), f12, f11, f12, parseColor);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i) + (this.f11526c * 2);
        int size2 = View.MeasureSpec.getSize(i2) + (this.f11526c * 2);
        setMeasuredDimension(Math.min(size, size2), Math.min(size, size2));
    }

    public ShakeArcView setArrowDirection(int i) {
        this.f11531h = i;
        return this;
    }

    public ShakeArcView setCurrentProgress(double d) {
        this.f11530g = d * 100.0d;
        invalidate();
        return this;
    }

    public void setLineRadius(int i) {
        this.f11532i = i;
    }

    public void setLineWidth(int i) {
        try {
            this.f11526c = i;
            Paint paint = this.f11527d;
            if (paint != null) {
                paint.setStrokeWidth(i);
            }
            Paint paint2 = this.f11528e;
            if (paint2 != null) {
                paint2.setStrokeWidth(this.f11526c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ShakeArcView setMaxProgress(double d) {
        this.f11529f = d * 100.0d;
        return this;
    }

    public ShakeArcView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ShakeArcView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f11524a = Color.parseColor("#CACCCA");
        this.f11525b = Color.parseColor("#FFFFFF");
        this.f11526c = 6;
        this.f11529f = -1.0d;
        this.f11530g = -1.0d;
        this.f11531h = 0;
        this.f11532i = 2;
        m48111a();
        m48109b();
    }

    /* renamed from: a */
    private void m48110a(Canvas canvas, boolean z, float f, float f2, float f3, float f4, float f5, float f6, int i) {
        try {
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setColor(i);
            if (z) {
                paint.setStyle(Paint.Style.FILL);
            } else {
                paint.setStyle(Paint.Style.STROKE);
            }
            Path path = new Path();
            path.moveTo(f, f2);
            path.lineTo(f3, f4);
            path.lineTo(f5, f6);
            path.lineTo(f, f2);
            path.close();
            canvas.drawPath(path, paint);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
