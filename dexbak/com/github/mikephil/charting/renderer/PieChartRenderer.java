package com.github.mikephil.charting.renderer;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import androidx.core.view.ViewCompat;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.IPieDataSet;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.lang.ref.WeakReference;
import java.util.List;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class PieChartRenderer extends DataRenderer {
    protected Canvas mBitmapCanvas;
    private RectF mCenterTextLastBounds;
    private CharSequence mCenterTextLastValue;
    private StaticLayout mCenterTextLayout;
    private TextPaint mCenterTextPaint;
    protected PieChart mChart;
    protected WeakReference<Bitmap> mDrawBitmap;
    protected Path mDrawCenterTextPathBuffer;
    protected RectF mDrawHighlightedRectF;
    private Paint mEntryLabelsPaint;
    private Path mHoleCirclePath;
    protected Paint mHolePaint;
    private RectF mInnerRectBuffer;
    private Path mPathBuffer;
    private RectF[] mRectBuffer;
    protected Paint mTransparentCirclePaint;
    protected Paint mValueLinePaint;

    public PieChartRenderer(PieChart pieChart, ChartAnimator chartAnimator, ViewPortHandler viewPortHandler) {
        super(chartAnimator, viewPortHandler);
        this.mCenterTextLastBounds = new RectF();
        this.mRectBuffer = new RectF[]{new RectF(), new RectF(), new RectF()};
        this.mPathBuffer = new Path();
        this.mInnerRectBuffer = new RectF();
        this.mHoleCirclePath = new Path();
        this.mDrawCenterTextPathBuffer = new Path();
        this.mDrawHighlightedRectF = new RectF();
        this.mChart = pieChart;
        Paint paint = new Paint(1);
        this.mHolePaint = paint;
        paint.setColor(-1);
        this.mHolePaint.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint(1);
        this.mTransparentCirclePaint = paint2;
        paint2.setColor(-1);
        this.mTransparentCirclePaint.setStyle(Paint.Style.FILL);
        this.mTransparentCirclePaint.setAlpha(105);
        TextPaint textPaint = new TextPaint(1);
        this.mCenterTextPaint = textPaint;
        textPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.mCenterTextPaint.setTextSize(Utils.convertDpToPixel(12.0f));
        this.mValuePaint.setTextSize(Utils.convertDpToPixel(13.0f));
        this.mValuePaint.setColor(-1);
        this.mValuePaint.setTextAlign(Paint.Align.CENTER);
        Paint paint3 = new Paint(1);
        this.mEntryLabelsPaint = paint3;
        paint3.setColor(-1);
        this.mEntryLabelsPaint.setTextAlign(Paint.Align.CENTER);
        this.mEntryLabelsPaint.setTextSize(Utils.convertDpToPixel(13.0f));
        Paint paint4 = new Paint(1);
        this.mValueLinePaint = paint4;
        paint4.setStyle(Paint.Style.STROKE);
    }

    protected float calculateMinimumRadiusForSpacedSlice(MPPointF mPPointF, float f, float f2, float f3, float f4, float f5, float f6) {
        double d = (f5 + f6) * 0.017453292f;
        float cos = mPPointF.f23783x + (((float) Math.cos(d)) * f);
        float sin = mPPointF.f23784y + (((float) Math.sin(d)) * f);
        double d2 = (f5 + (f6 / 2.0f)) * 0.017453292f;
        float cos2 = mPPointF.f23783x + (((float) Math.cos(d2)) * f);
        float sin2 = mPPointF.f23784y + (((float) Math.sin(d2)) * f);
        double d3 = f2;
        Double.isNaN(d3);
        double sqrt = f - ((float) ((Math.sqrt(Math.pow(cos - f3, 2.0d) + Math.pow(sin - f4, 2.0d)) / 2.0d) * Math.tan(((180.0d - d3) / 2.0d) * 0.017453292519943295d)));
        double sqrt2 = Math.sqrt(Math.pow(cos2 - ((cos + f3) / 2.0f), 2.0d) + Math.pow(sin2 - ((sin + f4) / 2.0f), 2.0d));
        Double.isNaN(sqrt);
        return (float) (sqrt - sqrt2);
    }

    protected void drawCenterText(Canvas canvas) {
        float radius;
        MPPointF mPPointF;
        CharSequence centerText = this.mChart.getCenterText();
        if (!this.mChart.isDrawCenterTextEnabled() || centerText == null) {
            return;
        }
        MPPointF centerCircleBox = this.mChart.getCenterCircleBox();
        MPPointF centerTextOffset = this.mChart.getCenterTextOffset();
        float f = centerCircleBox.f23783x + centerTextOffset.f23783x;
        float f2 = centerCircleBox.f23784y + centerTextOffset.f23784y;
        if (this.mChart.isDrawHoleEnabled() && !this.mChart.isDrawSlicesUnderHoleEnabled()) {
            radius = this.mChart.getRadius() * (this.mChart.getHoleRadius() / 100.0f);
        } else {
            radius = this.mChart.getRadius();
        }
        RectF[] rectFArr = this.mRectBuffer;
        RectF rectF = rectFArr[0];
        rectF.left = f - radius;
        rectF.top = f2 - radius;
        rectF.right = f + radius;
        rectF.bottom = f2 + radius;
        RectF rectF2 = rectFArr[1];
        rectF2.set(rectF);
        float centerTextRadiusPercent = this.mChart.getCenterTextRadiusPercent() / 100.0f;
        if (centerTextRadiusPercent > Utils.DOUBLE_EPSILON) {
            rectF2.inset((rectF2.width() - (rectF2.width() * centerTextRadiusPercent)) / 2.0f, (rectF2.height() - (rectF2.height() * centerTextRadiusPercent)) / 2.0f);
        }
        if (centerText.equals(this.mCenterTextLastValue) && rectF2.equals(this.mCenterTextLastBounds)) {
            mPPointF = centerTextOffset;
        } else {
            this.mCenterTextLastBounds.set(rectF2);
            this.mCenterTextLastValue = centerText;
            mPPointF = centerTextOffset;
            this.mCenterTextLayout = new StaticLayout(centerText, 0, centerText.length(), this.mCenterTextPaint, (int) Math.max(Math.ceil(this.mCenterTextLastBounds.width()), 1.0d), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, false);
        }
        float height = this.mCenterTextLayout.getHeight();
        canvas.save();
        if (Build.VERSION.SDK_INT >= 18) {
            Path path = this.mDrawCenterTextPathBuffer;
            path.reset();
            path.addOval(rectF, Path.Direction.CW);
            canvas.clipPath(path);
        }
        canvas.translate(rectF2.left, rectF2.top + ((rectF2.height() - height) / 2.0f));
        this.mCenterTextLayout.draw(canvas);
        canvas.restore();
        MPPointF.recycleInstance(centerCircleBox);
        MPPointF.recycleInstance(mPPointF);
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawData(Canvas canvas) {
        int chartWidth = (int) this.mViewPortHandler.getChartWidth();
        int chartHeight = (int) this.mViewPortHandler.getChartHeight();
        WeakReference<Bitmap> weakReference = this.mDrawBitmap;
        Bitmap bitmap = weakReference == null ? null : weakReference.get();
        if (bitmap == null || bitmap.getWidth() != chartWidth || bitmap.getHeight() != chartHeight) {
            if (chartWidth <= 0 || chartHeight <= 0) {
                return;
            }
            bitmap = Bitmap.createBitmap(chartWidth, chartHeight, Bitmap.Config.ARGB_4444);
            this.mDrawBitmap = new WeakReference<>(bitmap);
            this.mBitmapCanvas = new Canvas(bitmap);
        }
        bitmap.eraseColor(0);
        for (IPieDataSet iPieDataSet : ((PieData) this.mChart.getData()).getDataSets()) {
            if (iPieDataSet.isVisible() && iPieDataSet.getEntryCount() > 0) {
                drawDataSet(canvas, iPieDataSet);
            }
        }
    }

    protected void drawDataSet(Canvas canvas, IPieDataSet iPieDataSet) {
        int i;
        int i2;
        int i3;
        float[] fArr;
        float f;
        float f2;
        float f3;
        float f4;
        float f5;
        int i4;
        RectF rectF;
        MPPointF mPPointF;
        RectF rectF2;
        float f6;
        RectF rectF3;
        float f7;
        RectF rectF4;
        MPPointF mPPointF2;
        int i5;
        IPieDataSet iPieDataSet2 = iPieDataSet;
        float rotationAngle = this.mChart.getRotationAngle();
        float phaseX = this.mAnimator.getPhaseX();
        float phaseY = this.mAnimator.getPhaseY();
        RectF circleBox = this.mChart.getCircleBox();
        int entryCount = iPieDataSet.getEntryCount();
        float[] drawAngles = this.mChart.getDrawAngles();
        MPPointF centerCircleBox = this.mChart.getCenterCircleBox();
        float radius = this.mChart.getRadius();
        boolean z = this.mChart.isDrawHoleEnabled() && !this.mChart.isDrawSlicesUnderHoleEnabled();
        float holeRadius = z ? (this.mChart.getHoleRadius() / 100.0f) * radius : 0.0f;
        float holeRadius2 = (radius - ((this.mChart.getHoleRadius() * radius) / 100.0f)) / 2.0f;
        RectF rectF5 = new RectF();
        boolean z2 = z && this.mChart.isDrawRoundedSlicesEnabled();
        int i6 = 0;
        for (int i7 = 0; i7 < entryCount; i7++) {
            if (Math.abs(iPieDataSet2.getEntryForIndex(i7).getY()) > Utils.FLOAT_EPSILON) {
                i6++;
            }
        }
        float sliceSpace = i6 <= 1 ? 0.0f : getSliceSpace(iPieDataSet2);
        int i8 = 0;
        float f8 = 0.0f;
        while (i8 < entryCount) {
            float f9 = drawAngles[i8];
            float abs = Math.abs(iPieDataSet2.getEntryForIndex(i8).getY());
            float f10 = Utils.FLOAT_EPSILON;
            if (abs > f10 && (!this.mChart.needsHighlight(i8) || z2)) {
                boolean z3 = sliceSpace > 0.0f && f9 <= 180.0f;
                this.mRenderPaint.setColor(iPieDataSet2.getColor(i8));
                float f11 = i6 == 1 ? 0.0f : sliceSpace / (radius * 0.017453292f);
                float f12 = rotationAngle + ((f8 + (f11 / 2.0f)) * phaseY);
                float f13 = (f9 - f11) * phaseY;
                if (f13 < 0.0f) {
                    f13 = 0.0f;
                }
                this.mPathBuffer.reset();
                if (z2) {
                    float f14 = radius - holeRadius2;
                    i = i8;
                    i2 = i6;
                    double d = f12 * 0.017453292f;
                    i3 = entryCount;
                    fArr = drawAngles;
                    float cos = centerCircleBox.f23783x + (((float) Math.cos(d)) * f14);
                    float sin = centerCircleBox.f23784y + (f14 * ((float) Math.sin(d)));
                    rectF5.set(cos - holeRadius2, sin - holeRadius2, cos + holeRadius2, sin + holeRadius2);
                } else {
                    i = i8;
                    i2 = i6;
                    i3 = entryCount;
                    fArr = drawAngles;
                }
                double d2 = f12 * 0.017453292f;
                f = rotationAngle;
                f2 = phaseX;
                float cos2 = centerCircleBox.f23783x + (((float) Math.cos(d2)) * radius);
                float sin2 = centerCircleBox.f23784y + (((float) Math.sin(d2)) * radius);
                if (f13 >= 360.0f && f13 % 360.0f <= f10) {
                    this.mPathBuffer.addCircle(centerCircleBox.f23783x, centerCircleBox.f23784y, radius, Path.Direction.CW);
                } else {
                    if (z2) {
                        this.mPathBuffer.arcTo(rectF5, f12 + 180.0f, -180.0f);
                    }
                    this.mPathBuffer.arcTo(circleBox, f12, f13);
                }
                RectF rectF6 = this.mInnerRectBuffer;
                float f15 = centerCircleBox.f23783x;
                float f16 = centerCircleBox.f23784y;
                rectF6.set(f15 - holeRadius, f16 - holeRadius, f15 + holeRadius, f16 + holeRadius);
                if (!z) {
                    f3 = f13;
                    f4 = holeRadius;
                    f5 = radius;
                    i4 = i2;
                    rectF = circleBox;
                    mPPointF = centerCircleBox;
                    rectF2 = rectF5;
                    f6 = 360.0f;
                } else if (holeRadius > 0.0f || z3) {
                    if (z3) {
                        f7 = f13;
                        i4 = i2;
                        rectF = circleBox;
                        f4 = holeRadius;
                        rectF4 = rectF5;
                        i5 = 1;
                        f5 = radius;
                        mPPointF2 = centerCircleBox;
                        float calculateMinimumRadiusForSpacedSlice = calculateMinimumRadiusForSpacedSlice(centerCircleBox, radius, f9 * phaseY, cos2, sin2, f12, f7);
                        if (calculateMinimumRadiusForSpacedSlice < 0.0f) {
                            calculateMinimumRadiusForSpacedSlice = -calculateMinimumRadiusForSpacedSlice;
                        }
                        holeRadius = Math.max(f4, calculateMinimumRadiusForSpacedSlice);
                    } else {
                        f7 = f13;
                        rectF4 = rectF5;
                        f4 = holeRadius;
                        f5 = radius;
                        mPPointF2 = centerCircleBox;
                        i4 = i2;
                        rectF = circleBox;
                        i5 = 1;
                    }
                    float f17 = (i4 == i5 || holeRadius == 0.0f) ? 0.0f : sliceSpace / (holeRadius * 0.017453292f);
                    float f18 = f + ((f8 + (f17 / 2.0f)) * phaseY);
                    float f19 = (f9 - f17) * phaseY;
                    if (f19 < 0.0f) {
                        f19 = 0.0f;
                    }
                    float f20 = f18 + f19;
                    if (f7 >= 360.0f && f7 % 360.0f <= f10) {
                        this.mPathBuffer.addCircle(mPPointF2.f23783x, mPPointF2.f23784y, holeRadius, Path.Direction.CCW);
                        rectF2 = rectF4;
                    } else {
                        if (z2) {
                            float f21 = f5 - holeRadius2;
                            double d3 = f20 * 0.017453292f;
                            float cos3 = mPPointF2.f23783x + (((float) Math.cos(d3)) * f21);
                            float sin3 = mPPointF2.f23784y + (f21 * ((float) Math.sin(d3)));
                            rectF2 = rectF4;
                            rectF2.set(cos3 - holeRadius2, sin3 - holeRadius2, cos3 + holeRadius2, sin3 + holeRadius2);
                            this.mPathBuffer.arcTo(rectF2, f20, 180.0f);
                        } else {
                            rectF2 = rectF4;
                            double d4 = f20 * 0.017453292f;
                            this.mPathBuffer.lineTo(mPPointF2.f23783x + (((float) Math.cos(d4)) * holeRadius), mPPointF2.f23784y + (holeRadius * ((float) Math.sin(d4))));
                        }
                        this.mPathBuffer.arcTo(this.mInnerRectBuffer, f20, -f19);
                    }
                    mPPointF = mPPointF2;
                    rectF3 = rectF2;
                    this.mPathBuffer.close();
                    this.mBitmapCanvas.drawPath(this.mPathBuffer, this.mRenderPaint);
                    f8 += f9 * f2;
                } else {
                    f3 = f13;
                    f4 = holeRadius;
                    f5 = radius;
                    i4 = i2;
                    f6 = 360.0f;
                    rectF = circleBox;
                    mPPointF = centerCircleBox;
                    rectF2 = rectF5;
                }
                if (f3 % f6 > f10) {
                    if (z3) {
                        float f22 = f12 + (f3 / 2.0f);
                        rectF3 = rectF2;
                        float calculateMinimumRadiusForSpacedSlice2 = calculateMinimumRadiusForSpacedSlice(mPPointF, f5, f9 * phaseY, cos2, sin2, f12, f3);
                        double d5 = f22 * 0.017453292f;
                        this.mPathBuffer.lineTo(mPPointF.f23783x + (((float) Math.cos(d5)) * calculateMinimumRadiusForSpacedSlice2), mPPointF.f23784y + (calculateMinimumRadiusForSpacedSlice2 * ((float) Math.sin(d5))));
                    } else {
                        rectF3 = rectF2;
                        this.mPathBuffer.lineTo(mPPointF.f23783x, mPPointF.f23784y);
                    }
                    this.mPathBuffer.close();
                    this.mBitmapCanvas.drawPath(this.mPathBuffer, this.mRenderPaint);
                    f8 += f9 * f2;
                }
                rectF3 = rectF2;
                this.mPathBuffer.close();
                this.mBitmapCanvas.drawPath(this.mPathBuffer, this.mRenderPaint);
                f8 += f9 * f2;
            } else {
                f8 += f9 * phaseX;
                i = i8;
                rectF3 = rectF5;
                f5 = radius;
                f = rotationAngle;
                f2 = phaseX;
                rectF = circleBox;
                i3 = entryCount;
                fArr = drawAngles;
                i4 = i6;
                f4 = holeRadius;
                mPPointF = centerCircleBox;
            }
            i8 = i + 1;
            rectF5 = rectF3;
            holeRadius = f4;
            centerCircleBox = mPPointF;
            i6 = i4;
            radius = f5;
            rotationAngle = f;
            circleBox = rectF;
            entryCount = i3;
            drawAngles = fArr;
            phaseX = f2;
            iPieDataSet2 = iPieDataSet;
        }
        MPPointF.recycleInstance(centerCircleBox);
    }

    protected void drawEntryLabel(Canvas canvas, String str, float f, float f2) {
        canvas.drawText(str, f, f2, this.mEntryLabelsPaint);
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawExtras(Canvas canvas) {
        drawHole(canvas);
        canvas.drawBitmap(this.mDrawBitmap.get(), 0.0f, 0.0f, (Paint) null);
        drawCenterText(canvas);
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawHighlighted(Canvas canvas, Highlight[] highlightArr) {
        int i;
        RectF rectF;
        float f;
        float[] fArr;
        boolean z;
        float f2;
        float f3;
        MPPointF mPPointF;
        IPieDataSet dataSetByIndex;
        float f4;
        int i2;
        float[] fArr2;
        float f5;
        int i3;
        float f6;
        float f7;
        Highlight[] highlightArr2 = highlightArr;
        boolean z2 = this.mChart.isDrawHoleEnabled() && !this.mChart.isDrawSlicesUnderHoleEnabled();
        if (z2 && this.mChart.isDrawRoundedSlicesEnabled()) {
            return;
        }
        float phaseX = this.mAnimator.getPhaseX();
        float phaseY = this.mAnimator.getPhaseY();
        float rotationAngle = this.mChart.getRotationAngle();
        float[] drawAngles = this.mChart.getDrawAngles();
        float[] absoluteAngles = this.mChart.getAbsoluteAngles();
        MPPointF centerCircleBox = this.mChart.getCenterCircleBox();
        float radius = this.mChart.getRadius();
        float holeRadius = z2 ? (this.mChart.getHoleRadius() / 100.0f) * radius : 0.0f;
        RectF rectF2 = this.mDrawHighlightedRectF;
        rectF2.set(0.0f, 0.0f, 0.0f, 0.0f);
        int i4 = 0;
        while (i4 < highlightArr2.length) {
            int x = (int) highlightArr2[i4].getX();
            if (x < drawAngles.length && (dataSetByIndex = ((PieData) this.mChart.getData()).getDataSetByIndex(highlightArr2[i4].getDataSetIndex())) != null && dataSetByIndex.isHighlightEnabled()) {
                int entryCount = dataSetByIndex.getEntryCount();
                int i5 = 0;
                for (int i6 = 0; i6 < entryCount; i6++) {
                    if (Math.abs(dataSetByIndex.getEntryForIndex(i6).getY()) > Utils.FLOAT_EPSILON) {
                        i5++;
                    }
                }
                if (x == 0) {
                    i2 = 1;
                    f4 = 0.0f;
                } else {
                    f4 = absoluteAngles[x - 1] * phaseX;
                    i2 = 1;
                }
                float sliceSpace = i5 <= i2 ? 0.0f : dataSetByIndex.getSliceSpace();
                float f8 = drawAngles[x];
                float selectionShift = dataSetByIndex.getSelectionShift();
                int i7 = i4;
                float f9 = radius + selectionShift;
                float f10 = holeRadius;
                rectF2.set(this.mChart.getCircleBox());
                float f11 = -selectionShift;
                rectF2.inset(f11, f11);
                boolean z3 = sliceSpace > 0.0f && f8 <= 180.0f;
                this.mRenderPaint.setColor(dataSetByIndex.getColor(x));
                float f12 = i5 == 1 ? 0.0f : sliceSpace / (radius * 0.017453292f);
                float f13 = i5 == 1 ? 0.0f : sliceSpace / (f9 * 0.017453292f);
                float f14 = rotationAngle + (((f12 / 2.0f) + f4) * phaseY);
                float f15 = (f8 - f12) * phaseY;
                float f16 = f15 < 0.0f ? 0.0f : f15;
                float f17 = (((f13 / 2.0f) + f4) * phaseY) + rotationAngle;
                float f18 = (f8 - f13) * phaseY;
                if (f18 < 0.0f) {
                    f18 = 0.0f;
                }
                this.mPathBuffer.reset();
                if (f16 >= 360.0f && f16 % 360.0f <= Utils.FLOAT_EPSILON) {
                    this.mPathBuffer.addCircle(centerCircleBox.f23783x, centerCircleBox.f23784y, f9, Path.Direction.CW);
                    fArr2 = drawAngles;
                    f5 = f4;
                    i3 = i5;
                    z = z2;
                } else {
                    fArr2 = drawAngles;
                    f5 = f4;
                    double d = f17 * 0.017453292f;
                    i3 = i5;
                    z = z2;
                    this.mPathBuffer.moveTo(centerCircleBox.f23783x + (((float) Math.cos(d)) * f9), centerCircleBox.f23784y + (f9 * ((float) Math.sin(d))));
                    this.mPathBuffer.arcTo(rectF2, f17, f18);
                }
                if (z3) {
                    double d2 = f14 * 0.017453292f;
                    i = i7;
                    rectF = rectF2;
                    f = f10;
                    mPPointF = centerCircleBox;
                    fArr = fArr2;
                    f6 = calculateMinimumRadiusForSpacedSlice(centerCircleBox, radius, f8 * phaseY, (((float) Math.cos(d2)) * radius) + centerCircleBox.f23783x, centerCircleBox.f23784y + (((float) Math.sin(d2)) * radius), f14, f16);
                } else {
                    rectF = rectF2;
                    mPPointF = centerCircleBox;
                    i = i7;
                    f = f10;
                    fArr = fArr2;
                    f6 = 0.0f;
                }
                RectF rectF3 = this.mInnerRectBuffer;
                float f19 = mPPointF.f23783x;
                float f20 = mPPointF.f23784y;
                rectF3.set(f19 - f, f20 - f, f19 + f, f20 + f);
                if (z && (f > 0.0f || z3)) {
                    if (z3) {
                        if (f6 < 0.0f) {
                            f6 = -f6;
                        }
                        f7 = Math.max(f, f6);
                    } else {
                        f7 = f;
                    }
                    float f21 = (i3 == 1 || f7 == 0.0f) ? 0.0f : sliceSpace / (f7 * 0.017453292f);
                    float f22 = ((f5 + (f21 / 2.0f)) * phaseY) + rotationAngle;
                    float f23 = (f8 - f21) * phaseY;
                    if (f23 < 0.0f) {
                        f23 = 0.0f;
                    }
                    float f24 = f22 + f23;
                    if (f16 >= 360.0f && f16 % 360.0f <= Utils.FLOAT_EPSILON) {
                        this.mPathBuffer.addCircle(mPPointF.f23783x, mPPointF.f23784y, f7, Path.Direction.CCW);
                        f2 = phaseX;
                        f3 = phaseY;
                    } else {
                        double d3 = f24 * 0.017453292f;
                        f2 = phaseX;
                        f3 = phaseY;
                        this.mPathBuffer.lineTo(mPPointF.f23783x + (((float) Math.cos(d3)) * f7), mPPointF.f23784y + (f7 * ((float) Math.sin(d3))));
                        this.mPathBuffer.arcTo(this.mInnerRectBuffer, f24, -f23);
                    }
                } else {
                    f2 = phaseX;
                    f3 = phaseY;
                    if (f16 % 360.0f > Utils.FLOAT_EPSILON) {
                        if (z3) {
                            double d4 = (f14 + (f16 / 2.0f)) * 0.017453292f;
                            this.mPathBuffer.lineTo(mPPointF.f23783x + (((float) Math.cos(d4)) * f6), mPPointF.f23784y + (f6 * ((float) Math.sin(d4))));
                        } else {
                            this.mPathBuffer.lineTo(mPPointF.f23783x, mPPointF.f23784y);
                        }
                    }
                }
                this.mPathBuffer.close();
                this.mBitmapCanvas.drawPath(this.mPathBuffer, this.mRenderPaint);
            } else {
                i = i4;
                rectF = rectF2;
                f = holeRadius;
                fArr = drawAngles;
                z = z2;
                f2 = phaseX;
                f3 = phaseY;
                mPPointF = centerCircleBox;
            }
            i4 = i + 1;
            phaseX = f2;
            rectF2 = rectF;
            holeRadius = f;
            centerCircleBox = mPPointF;
            phaseY = f3;
            drawAngles = fArr;
            z2 = z;
            highlightArr2 = highlightArr;
        }
        MPPointF.recycleInstance(centerCircleBox);
    }

    protected void drawHole(Canvas canvas) {
        if (!this.mChart.isDrawHoleEnabled() || this.mBitmapCanvas == null) {
            return;
        }
        float radius = this.mChart.getRadius();
        float holeRadius = (this.mChart.getHoleRadius() / 100.0f) * radius;
        MPPointF centerCircleBox = this.mChart.getCenterCircleBox();
        if (Color.alpha(this.mHolePaint.getColor()) > 0) {
            this.mBitmapCanvas.drawCircle(centerCircleBox.f23783x, centerCircleBox.f23784y, holeRadius, this.mHolePaint);
        }
        if (Color.alpha(this.mTransparentCirclePaint.getColor()) > 0 && this.mChart.getTransparentCircleRadius() > this.mChart.getHoleRadius()) {
            int alpha = this.mTransparentCirclePaint.getAlpha();
            float transparentCircleRadius = radius * (this.mChart.getTransparentCircleRadius() / 100.0f);
            this.mTransparentCirclePaint.setAlpha((int) (alpha * this.mAnimator.getPhaseX() * this.mAnimator.getPhaseY()));
            this.mHoleCirclePath.reset();
            this.mHoleCirclePath.addCircle(centerCircleBox.f23783x, centerCircleBox.f23784y, transparentCircleRadius, Path.Direction.CW);
            this.mHoleCirclePath.addCircle(centerCircleBox.f23783x, centerCircleBox.f23784y, holeRadius, Path.Direction.CCW);
            this.mBitmapCanvas.drawPath(this.mHoleCirclePath, this.mTransparentCirclePaint);
            this.mTransparentCirclePaint.setAlpha(alpha);
        }
        MPPointF.recycleInstance(centerCircleBox);
    }

    protected void drawRoundedSlices(Canvas canvas) {
        float f;
        float[] fArr;
        float f2;
        if (this.mChart.isDrawRoundedSlicesEnabled()) {
            IPieDataSet dataSet = ((PieData) this.mChart.getData()).getDataSet();
            if (dataSet.isVisible()) {
                float phaseX = this.mAnimator.getPhaseX();
                float phaseY = this.mAnimator.getPhaseY();
                MPPointF centerCircleBox = this.mChart.getCenterCircleBox();
                float radius = this.mChart.getRadius();
                float holeRadius = (radius - ((this.mChart.getHoleRadius() * radius) / 100.0f)) / 2.0f;
                float[] drawAngles = this.mChart.getDrawAngles();
                float rotationAngle = this.mChart.getRotationAngle();
                int i = 0;
                while (i < dataSet.getEntryCount()) {
                    float f3 = drawAngles[i];
                    if (Math.abs(dataSet.getEntryForIndex(i).getY()) > Utils.FLOAT_EPSILON) {
                        double d = radius - holeRadius;
                        double d2 = (rotationAngle + f3) * phaseY;
                        double cos = Math.cos(Math.toRadians(d2));
                        Double.isNaN(d);
                        f = phaseY;
                        fArr = drawAngles;
                        f2 = rotationAngle;
                        double d3 = centerCircleBox.f23783x;
                        Double.isNaN(d3);
                        float f4 = (float) (d3 + (cos * d));
                        double sin = Math.sin(Math.toRadians(d2));
                        Double.isNaN(d);
                        double d4 = d * sin;
                        double d5 = centerCircleBox.f23784y;
                        Double.isNaN(d5);
                        this.mRenderPaint.setColor(dataSet.getColor(i));
                        this.mBitmapCanvas.drawCircle(f4, (float) (d4 + d5), holeRadius, this.mRenderPaint);
                    } else {
                        f = phaseY;
                        fArr = drawAngles;
                        f2 = rotationAngle;
                    }
                    rotationAngle = f2 + (f3 * phaseX);
                    i++;
                    phaseY = f;
                    drawAngles = fArr;
                }
                MPPointF.recycleInstance(centerCircleBox);
            }
        }
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawValue(Canvas canvas, String str, float f, float f2, int i) {
        this.mValuePaint.setColor(i);
        canvas.drawText(str, f, f2, this.mValuePaint);
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawValues(Canvas canvas) {
        int i;
        float[] fArr;
        float[] fArr2;
        float f;
        float f2;
        float f3;
        List<IPieDataSet> list;
        MPPointF mPPointF;
        float f4;
        Canvas canvas2;
        PieDataSet.ValuePosition valuePosition;
        float f5;
        float f6;
        float f7;
        float f8;
        float f9;
        MPPointF mPPointF2;
        ValueFormatter valueFormatter;
        MPPointF mPPointF3;
        IPieDataSet iPieDataSet;
        float f10;
        List<IPieDataSet> list2;
        PieEntry pieEntry;
        Canvas canvas3;
        String str;
        String str2;
        Canvas canvas4;
        MPPointF mPPointF4;
        MPPointF mPPointF5;
        Canvas canvas5 = canvas;
        MPPointF centerCircleBox = this.mChart.getCenterCircleBox();
        float radius = this.mChart.getRadius();
        float rotationAngle = this.mChart.getRotationAngle();
        float[] drawAngles = this.mChart.getDrawAngles();
        float[] absoluteAngles = this.mChart.getAbsoluteAngles();
        float phaseX = this.mAnimator.getPhaseX();
        float phaseY = this.mAnimator.getPhaseY();
        float holeRadius = (radius - ((this.mChart.getHoleRadius() * radius) / 100.0f)) / 2.0f;
        float holeRadius2 = this.mChart.getHoleRadius() / 100.0f;
        float f11 = (radius / 10.0f) * 3.6f;
        if (this.mChart.isDrawHoleEnabled()) {
            f11 = (radius - (radius * holeRadius2)) / 2.0f;
            if (!this.mChart.isDrawSlicesUnderHoleEnabled() && this.mChart.isDrawRoundedSlicesEnabled()) {
                double d = rotationAngle;
                double d2 = holeRadius * 360.0f;
                double d3 = radius;
                Double.isNaN(d3);
                Double.isNaN(d2);
                Double.isNaN(d);
                rotationAngle = (float) (d + (d2 / (d3 * 6.283185307179586d)));
            }
        }
        float f12 = rotationAngle;
        float f13 = radius - f11;
        PieData pieData = (PieData) this.mChart.getData();
        List<IPieDataSet> dataSets = pieData.getDataSets();
        float yValueSum = pieData.getYValueSum();
        boolean isDrawEntryLabelsEnabled = this.mChart.isDrawEntryLabelsEnabled();
        canvas.save();
        float convertDpToPixel = Utils.convertDpToPixel(5.0f);
        int i2 = 0;
        int i3 = 0;
        while (i3 < dataSets.size()) {
            IPieDataSet iPieDataSet2 = dataSets.get(i3);
            boolean isDrawValuesEnabled = iPieDataSet2.isDrawValuesEnabled();
            if (isDrawValuesEnabled || isDrawEntryLabelsEnabled) {
                PieDataSet.ValuePosition xValuePosition = iPieDataSet2.getXValuePosition();
                PieDataSet.ValuePosition yValuePosition = iPieDataSet2.getYValuePosition();
                applyValueTextStyle(iPieDataSet2);
                int i4 = i2;
                i = i3;
                float calcTextHeight = Utils.calcTextHeight(this.mValuePaint, "Q") + Utils.convertDpToPixel(4.0f);
                ValueFormatter valueFormatter2 = iPieDataSet2.getValueFormatter();
                int entryCount = iPieDataSet2.getEntryCount();
                List<IPieDataSet> list3 = dataSets;
                this.mValueLinePaint.setColor(iPieDataSet2.getValueLineColor());
                this.mValueLinePaint.setStrokeWidth(Utils.convertDpToPixel(iPieDataSet2.getValueLineWidth()));
                float sliceSpace = getSliceSpace(iPieDataSet2);
                MPPointF mPPointF6 = MPPointF.getInstance(iPieDataSet2.getIconsOffset());
                MPPointF mPPointF7 = centerCircleBox;
                mPPointF6.f23783x = Utils.convertDpToPixel(mPPointF6.f23783x);
                mPPointF6.f23784y = Utils.convertDpToPixel(mPPointF6.f23784y);
                int i5 = 0;
                while (i5 < entryCount) {
                    MPPointF mPPointF8 = mPPointF6;
                    PieEntry entryForIndex = iPieDataSet2.getEntryForIndex(i5);
                    int i6 = entryCount;
                    float f14 = f12 + (((i4 == 0 ? 0.0f : absoluteAngles[i4 - 1] * phaseX) + ((drawAngles[i4] - ((sliceSpace / (f13 * 0.017453292f)) / 2.0f)) / 2.0f)) * phaseY);
                    float f15 = sliceSpace;
                    String pieLabel = valueFormatter2.getPieLabel(this.mChart.isUsePercentValuesEnabled() ? (entryForIndex.getY() / yValueSum) * 100.0f : entryForIndex.getY(), entryForIndex);
                    float[] fArr3 = drawAngles;
                    String label = entryForIndex.getLabel();
                    ValueFormatter valueFormatter3 = valueFormatter2;
                    double d4 = f14 * 0.017453292f;
                    float[] fArr4 = absoluteAngles;
                    float f16 = phaseX;
                    float cos = (float) Math.cos(d4);
                    float f17 = phaseY;
                    float sin = (float) Math.sin(d4);
                    boolean z = isDrawEntryLabelsEnabled && xValuePosition == PieDataSet.ValuePosition.OUTSIDE_SLICE;
                    float f18 = f12;
                    boolean z2 = isDrawValuesEnabled && yValuePosition == PieDataSet.ValuePosition.OUTSIDE_SLICE;
                    boolean z3 = isDrawEntryLabelsEnabled && xValuePosition == PieDataSet.ValuePosition.INSIDE_SLICE;
                    PieDataSet.ValuePosition valuePosition2 = xValuePosition;
                    boolean z4 = isDrawValuesEnabled && yValuePosition == PieDataSet.ValuePosition.INSIDE_SLICE;
                    if (z || z2) {
                        float valueLinePart1Length = iPieDataSet2.getValueLinePart1Length();
                        float valueLinePart2Length = iPieDataSet2.getValueLinePart2Length();
                        float valueLinePart1OffsetPercentage = iPieDataSet2.getValueLinePart1OffsetPercentage() / 100.0f;
                        valuePosition = yValuePosition;
                        if (this.mChart.isDrawHoleEnabled()) {
                            float f19 = radius * holeRadius2;
                            f5 = ((radius - f19) * valueLinePart1OffsetPercentage) + f19;
                        } else {
                            f5 = radius * valueLinePart1OffsetPercentage;
                        }
                        float abs = iPieDataSet2.isValueLineVariableLength() ? valueLinePart2Length * f13 * ((float) Math.abs(Math.sin(d4))) : valueLinePart2Length * f13;
                        MPPointF mPPointF9 = mPPointF7;
                        float f20 = mPPointF9.f23783x;
                        float f21 = (f5 * cos) + f20;
                        f6 = radius;
                        float f22 = mPPointF9.f23784y;
                        float f23 = (f5 * sin) + f22;
                        float f24 = (valueLinePart1Length + 1.0f) * f13;
                        float f25 = (f24 * cos) + f20;
                        float f26 = f22 + (f24 * sin);
                        double d5 = f14;
                        Double.isNaN(d5);
                        double d6 = d5 % 360.0d;
                        if (d6 >= 90.0d && d6 <= 270.0d) {
                            float f27 = f25 - abs;
                            this.mValuePaint.setTextAlign(Paint.Align.RIGHT);
                            if (z) {
                                this.mEntryLabelsPaint.setTextAlign(Paint.Align.RIGHT);
                            }
                            f7 = f27;
                            f8 = f27 - convertDpToPixel;
                        } else {
                            f7 = f25 + abs;
                            this.mValuePaint.setTextAlign(Paint.Align.LEFT);
                            if (z) {
                                this.mEntryLabelsPaint.setTextAlign(Paint.Align.LEFT);
                            }
                            f8 = f7 + convertDpToPixel;
                        }
                        if (iPieDataSet2.getValueLineColor() != 1122867) {
                            if (iPieDataSet2.isUsingSliceColorAsValueLineColor()) {
                                this.mValueLinePaint.setColor(iPieDataSet2.getColor(i5));
                            }
                            f9 = sin;
                            iPieDataSet = iPieDataSet2;
                            valueFormatter = valueFormatter3;
                            mPPointF2 = mPPointF8;
                            mPPointF3 = mPPointF9;
                            f10 = f8;
                            list2 = list3;
                            pieEntry = entryForIndex;
                            canvas.drawLine(f21, f23, f25, f26, this.mValueLinePaint);
                            canvas.drawLine(f25, f26, f7, f26, this.mValueLinePaint);
                        } else {
                            f9 = sin;
                            mPPointF2 = mPPointF8;
                            valueFormatter = valueFormatter3;
                            mPPointF3 = mPPointF9;
                            iPieDataSet = iPieDataSet2;
                            f10 = f8;
                            list2 = list3;
                            pieEntry = entryForIndex;
                        }
                        if (z && z2) {
                            drawValue(canvas, pieLabel, f10, f26, iPieDataSet.getValueTextColor(i5));
                            if (i5 >= pieData.getEntryCount() || label == null) {
                                canvas4 = canvas;
                                str2 = label;
                            } else {
                                canvas3 = canvas;
                                str = label;
                                drawEntryLabel(canvas3, str, f10, f26 + calcTextHeight);
                                str2 = str;
                                canvas4 = canvas3;
                            }
                        } else {
                            canvas3 = canvas;
                            float f28 = f10;
                            str = label;
                            if (z) {
                                if (i5 < pieData.getEntryCount() && str != null) {
                                    drawEntryLabel(canvas3, str, f28, f26 + (calcTextHeight / 2.0f));
                                }
                            } else if (z2) {
                                str2 = str;
                                canvas4 = canvas3;
                                drawValue(canvas, pieLabel, f28, f26 + (calcTextHeight / 2.0f), iPieDataSet.getValueTextColor(i5));
                            }
                            str2 = str;
                            canvas4 = canvas3;
                        }
                    } else {
                        valuePosition = yValuePosition;
                        f9 = sin;
                        mPPointF3 = mPPointF7;
                        mPPointF2 = mPPointF8;
                        valueFormatter = valueFormatter3;
                        str2 = label;
                        iPieDataSet = iPieDataSet2;
                        f6 = radius;
                        canvas4 = canvas;
                        list2 = list3;
                        pieEntry = entryForIndex;
                    }
                    if (z3 || z4) {
                        mPPointF4 = mPPointF3;
                        float f29 = (f13 * cos) + mPPointF4.f23783x;
                        float f30 = (f13 * f9) + mPPointF4.f23784y;
                        this.mValuePaint.setTextAlign(Paint.Align.CENTER);
                        if (z3 && z4) {
                            drawValue(canvas, pieLabel, f29, f30, iPieDataSet.getValueTextColor(i5));
                            if (i5 < pieData.getEntryCount() && str2 != null) {
                                drawEntryLabel(canvas4, str2, f29, f30 + calcTextHeight);
                            }
                        } else {
                            if (z3) {
                                if (i5 < pieData.getEntryCount() && str2 != null) {
                                    drawEntryLabel(canvas4, str2, f29, f30 + (calcTextHeight / 2.0f));
                                }
                            } else if (z4) {
                                drawValue(canvas, pieLabel, f29, f30 + (calcTextHeight / 2.0f), iPieDataSet.getValueTextColor(i5));
                            }
                            if (pieEntry.getIcon() == null && iPieDataSet.isDrawIconsEnabled()) {
                                Drawable icon = pieEntry.getIcon();
                                mPPointF5 = mPPointF2;
                                float f31 = mPPointF5.f23784y;
                                Utils.drawImage(canvas, icon, (int) (((f13 + f31) * cos) + mPPointF4.f23783x), (int) (((f31 + f13) * f9) + mPPointF4.f23784y + mPPointF5.f23783x), icon.getIntrinsicWidth(), icon.getIntrinsicHeight());
                            } else {
                                mPPointF5 = mPPointF2;
                            }
                            i4++;
                            i5++;
                            mPPointF6 = mPPointF5;
                            iPieDataSet2 = iPieDataSet;
                            radius = f6;
                            sliceSpace = f15;
                            entryCount = i6;
                            list3 = list2;
                            drawAngles = fArr3;
                            absoluteAngles = fArr4;
                            phaseX = f16;
                            f12 = f18;
                            xValuePosition = valuePosition2;
                            yValuePosition = valuePosition;
                            valueFormatter2 = valueFormatter;
                            mPPointF7 = mPPointF4;
                            phaseY = f17;
                        }
                    } else {
                        mPPointF4 = mPPointF3;
                    }
                    if (pieEntry.getIcon() == null) {
                    }
                    mPPointF5 = mPPointF2;
                    i4++;
                    i5++;
                    mPPointF6 = mPPointF5;
                    iPieDataSet2 = iPieDataSet;
                    radius = f6;
                    sliceSpace = f15;
                    entryCount = i6;
                    list3 = list2;
                    drawAngles = fArr3;
                    absoluteAngles = fArr4;
                    phaseX = f16;
                    f12 = f18;
                    xValuePosition = valuePosition2;
                    yValuePosition = valuePosition;
                    valueFormatter2 = valueFormatter;
                    mPPointF7 = mPPointF4;
                    phaseY = f17;
                }
                fArr = drawAngles;
                fArr2 = absoluteAngles;
                f = phaseX;
                f2 = phaseY;
                f3 = f12;
                list = list3;
                mPPointF = mPPointF7;
                f4 = radius;
                canvas2 = canvas;
                MPPointF.recycleInstance(mPPointF6);
                i2 = i4;
            } else {
                i = i3;
                list = dataSets;
                f4 = radius;
                fArr = drawAngles;
                fArr2 = absoluteAngles;
                f = phaseX;
                f2 = phaseY;
                f3 = f12;
                canvas2 = canvas5;
                mPPointF = centerCircleBox;
            }
            i3 = i + 1;
            canvas5 = canvas2;
            centerCircleBox = mPPointF;
            radius = f4;
            dataSets = list;
            drawAngles = fArr;
            absoluteAngles = fArr2;
            phaseX = f;
            phaseY = f2;
            f12 = f3;
        }
        MPPointF.recycleInstance(centerCircleBox);
        canvas.restore();
    }

    public TextPaint getPaintCenterText() {
        return this.mCenterTextPaint;
    }

    public Paint getPaintEntryLabels() {
        return this.mEntryLabelsPaint;
    }

    public Paint getPaintHole() {
        return this.mHolePaint;
    }

    public Paint getPaintTransparentCircle() {
        return this.mTransparentCirclePaint;
    }

    protected float getSliceSpace(IPieDataSet iPieDataSet) {
        if (!iPieDataSet.isAutomaticallyDisableSliceSpacingEnabled()) {
            return iPieDataSet.getSliceSpace();
        }
        if (iPieDataSet.getSliceSpace() / this.mViewPortHandler.getSmallestContentExtension() > (iPieDataSet.getYMin() / ((PieData) this.mChart.getData()).getYValueSum()) * 2.0f) {
            return 0.0f;
        }
        return iPieDataSet.getSliceSpace();
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void initBuffers() {
    }

    public void releaseBitmap() {
        Canvas canvas = this.mBitmapCanvas;
        if (canvas != null) {
            canvas.setBitmap(null);
            this.mBitmapCanvas = null;
        }
        WeakReference<Bitmap> weakReference = this.mDrawBitmap;
        if (weakReference != null) {
            Bitmap bitmap = weakReference.get();
            if (bitmap != null) {
                bitmap.recycle();
            }
            this.mDrawBitmap.clear();
            this.mDrawBitmap = null;
        }
    }
}
