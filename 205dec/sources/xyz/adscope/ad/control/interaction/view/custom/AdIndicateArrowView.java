package xyz.adscope.ad.control.interaction.view.custom;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import xyz.adscope.common.tool.LogUtil;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class AdIndicateArrowView extends View {
    private int arrowDirection;
    private double mCurrentProgress;
    private int mInnerColor;
    private Paint mInnerPaint;
    private double mMaxProgress;
    private int mOutColor;
    private Paint mOutPaint;
    private int mWidth;
    private int multiple;

    public AdIndicateArrowView(Context context) {
        this(context, null);
    }

    private void drawTriangle(Canvas canvas, boolean z3, float f4, float f5, float f6, float f7, float f8, float f9, int i4) {
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

    private void initAttr(Context context, AttributeSet attributeSet) {
    }

    private void initInnerPaint() {
        Paint paint = new Paint();
        this.mInnerPaint = paint;
        paint.setAntiAlias(true);
        this.mInnerPaint.setDither(true);
        this.mInnerPaint.setStrokeWidth(this.mWidth);
        this.mInnerPaint.setColor(this.mInnerColor);
        this.mInnerPaint.setStyle(Paint.Style.STROKE);
        this.mInnerPaint.setStrokeCap(Paint.Cap.ROUND);
    }

    private void initOutPaint() {
        Paint paint = new Paint();
        this.mOutPaint = paint;
        paint.setAntiAlias(true);
        this.mOutPaint.setDither(true);
        this.mOutPaint.setStrokeWidth(this.mWidth);
        this.mOutPaint.setColor(this.mOutColor);
        this.mOutPaint.setStyle(Paint.Style.STROKE);
        this.mOutPaint.setStrokeCap(Paint.Cap.ROUND);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        try {
            int i4 = this.mWidth;
            RectF rectF = new RectF(i4 / 2, i4 / 2, getWidth() - (this.mWidth / 2), getHeight() - (this.mWidth / 2));
            canvas.drawArc(rectF, 215.0f, 110.0f, false, this.mInnerPaint);
            double d4 = this.mCurrentProgress;
            if (d4 >= 0.0d) {
                double d5 = this.mMaxProgress;
                if (d5 > 0.0d) {
                    if (d4 >= d5) {
                        this.mCurrentProgress = d5;
                    }
                    double d6 = (float) this.mCurrentProgress;
                    Double.isNaN(d6);
                    float f4 = (float) (d6 / d5);
                    LogUtil.e("sweepAngle", "sweepAngle:" + f4 + ",mMaxProgress:" + this.mMaxProgress + ",mCurrentProgress:" + this.mCurrentProgress + ";arrowDirection:" + this.arrowDirection);
                    int i5 = this.arrowDirection;
                    if (i5 == 1) {
                        canvas.drawArc(rectF, 215.0f, f4 * 110.0f, false, this.mOutPaint);
                    } else if (i5 == 2) {
                        canvas.drawArc(rectF, 325.0f, (-f4) * 110.0f, false, this.mOutPaint);
                    } else {
                        canvas.drawArc(rectF, 270.0f, (-f4) * 55.0f, false, this.mOutPaint);
                        canvas.drawArc(rectF, 270.0f, f4 * 55.0f, false, this.mOutPaint);
                    }
                }
            }
            int parseColor = Color.parseColor("#CACCCA");
            if (this.mCurrentProgress == this.mMaxProgress) {
                parseColor = Color.parseColor("#FFFFFF");
            }
            int width = getWidth();
            int height = getHeight();
            int min = (Math.min(width, height) / 2) + (this.mWidth * this.multiple);
            int i6 = width / 2;
            int i7 = height / 2;
            float cos = (float) Math.cos(Math.toRadians(45.0d));
            int i8 = this.arrowDirection;
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
                drawTriangle(canvas, true, f5, f6, (float) (d8 + d11), f7, f5, f7, parseColor);
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
                drawTriangle(canvas, true, f8, f9, (float) (d16 - d15), f10, f8, f10, parseColor);
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
                drawTriangle(canvas, true, f11, f12, (float) (d22 - d21), f13, f11, f13, parseColor);
                double d23 = i6;
                Double.isNaN(d23);
                double d24 = d23 * 1.5d;
                float f14 = (float) (d24 + d19);
                double d25 = i7 / 2;
                Double.isNaN(d25);
                float f15 = i7 / 2;
                drawTriangle(canvas, true, f14, (float) (d25 - d21), (float) (d24 + d21), f15, f14, f15, parseColor);
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    @Override // android.view.View
    public void onMeasure(int i4, int i5) {
        super.onMeasure(i4, i5);
        int size = View.MeasureSpec.getSize(i4) + (this.mWidth * 2);
        int size2 = View.MeasureSpec.getSize(i5) + (this.mWidth * 2);
        setMeasuredDimension(Math.min(size, size2), Math.min(size, size2));
    }

    public AdIndicateArrowView setArrowDirection(int i4) {
        this.arrowDirection = i4;
        return this;
    }

    public AdIndicateArrowView setCurrentProgress(double d4) {
        this.mCurrentProgress = d4 * 100.0d;
        invalidate();
        return this;
    }

    public void setLineRadius(int i4) {
        this.multiple = i4;
    }

    public void setLineWidth(int i4) {
        try {
            this.mWidth = i4;
            Paint paint = this.mInnerPaint;
            if (paint != null) {
                paint.setStrokeWidth(i4);
            }
            Paint paint2 = this.mOutPaint;
            if (paint2 != null) {
                paint2.setStrokeWidth(this.mWidth);
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public AdIndicateArrowView setMaxProgress(double d4) {
        this.mMaxProgress = d4 * 100.0d;
        return this;
    }

    public AdIndicateArrowView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AdIndicateArrowView(Context context, @Nullable AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.mInnerColor = Color.parseColor("#CACCCA");
        this.mOutColor = Color.parseColor("#FFFFFF");
        this.mWidth = 8;
        this.mMaxProgress = -1.0d;
        this.mCurrentProgress = -1.0d;
        this.arrowDirection = 0;
        this.multiple = 2;
        initInnerPaint();
        initOutPaint();
    }
}
