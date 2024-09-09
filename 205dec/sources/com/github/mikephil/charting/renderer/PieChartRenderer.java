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

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
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
        textPaint.setColor(-16777216);
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

    protected float calculateMinimumRadiusForSpacedSlice(MPPointF mPPointF, float f4, float f5, float f6, float f7, float f8, float f9) {
        double d4 = (f8 + f9) * 0.017453292f;
        float cos = mPPointF.f37332x + (((float) Math.cos(d4)) * f4);
        float sin = mPPointF.f37333y + (((float) Math.sin(d4)) * f4);
        double d5 = (f8 + (f9 / 2.0f)) * 0.017453292f;
        float cos2 = mPPointF.f37332x + (((float) Math.cos(d5)) * f4);
        float sin2 = mPPointF.f37333y + (((float) Math.sin(d5)) * f4);
        double d6 = f5;
        Double.isNaN(d6);
        double sqrt = f4 - ((float) ((Math.sqrt(Math.pow(cos - f6, 2.0d) + Math.pow(sin - f7, 2.0d)) / 2.0d) * Math.tan(((180.0d - d6) / 2.0d) * 0.017453292519943295d)));
        double sqrt2 = Math.sqrt(Math.pow(cos2 - ((cos + f6) / 2.0f), 2.0d) + Math.pow(sin2 - ((sin + f7) / 2.0f), 2.0d));
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
        float f4 = centerCircleBox.f37332x + centerTextOffset.f37332x;
        float f5 = centerCircleBox.f37333y + centerTextOffset.f37333y;
        if (this.mChart.isDrawHoleEnabled() && !this.mChart.isDrawSlicesUnderHoleEnabled()) {
            radius = this.mChart.getRadius() * (this.mChart.getHoleRadius() / 100.0f);
        } else {
            radius = this.mChart.getRadius();
        }
        RectF[] rectFArr = this.mRectBuffer;
        RectF rectF = rectFArr[0];
        rectF.left = f4 - radius;
        rectF.top = f5 - radius;
        rectF.right = f4 + radius;
        rectF.bottom = f5 + radius;
        RectF rectF2 = rectFArr[1];
        rectF2.set(rectF);
        float centerTextRadiusPercent = this.mChart.getCenterTextRadiusPercent() / 100.0f;
        if (centerTextRadiusPercent > 0.0d) {
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
        int i4;
        int i5;
        int i6;
        float[] fArr;
        float f4;
        float f5;
        float f6;
        float f7;
        float f8;
        int i7;
        RectF rectF;
        MPPointF mPPointF;
        RectF rectF2;
        float f9;
        RectF rectF3;
        float f10;
        RectF rectF4;
        MPPointF mPPointF2;
        int i8;
        IPieDataSet iPieDataSet2 = iPieDataSet;
        float rotationAngle = this.mChart.getRotationAngle();
        float phaseX = this.mAnimator.getPhaseX();
        float phaseY = this.mAnimator.getPhaseY();
        RectF circleBox = this.mChart.getCircleBox();
        int entryCount = iPieDataSet.getEntryCount();
        float[] drawAngles = this.mChart.getDrawAngles();
        MPPointF centerCircleBox = this.mChart.getCenterCircleBox();
        float radius = this.mChart.getRadius();
        boolean z3 = this.mChart.isDrawHoleEnabled() && !this.mChart.isDrawSlicesUnderHoleEnabled();
        float holeRadius = z3 ? (this.mChart.getHoleRadius() / 100.0f) * radius : 0.0f;
        float holeRadius2 = (radius - ((this.mChart.getHoleRadius() * radius) / 100.0f)) / 2.0f;
        RectF rectF5 = new RectF();
        boolean z4 = z3 && this.mChart.isDrawRoundedSlicesEnabled();
        int i9 = 0;
        for (int i10 = 0; i10 < entryCount; i10++) {
            if (Math.abs(iPieDataSet2.getEntryForIndex(i10).getY()) > Utils.FLOAT_EPSILON) {
                i9++;
            }
        }
        float sliceSpace = i9 <= 1 ? 0.0f : getSliceSpace(iPieDataSet2);
        int i11 = 0;
        float f11 = 0.0f;
        while (i11 < entryCount) {
            float f12 = drawAngles[i11];
            float abs = Math.abs(iPieDataSet2.getEntryForIndex(i11).getY());
            float f13 = Utils.FLOAT_EPSILON;
            if (abs > f13 && (!this.mChart.needsHighlight(i11) || z4)) {
                boolean z5 = sliceSpace > 0.0f && f12 <= 180.0f;
                this.mRenderPaint.setColor(iPieDataSet2.getColor(i11));
                float f14 = i9 == 1 ? 0.0f : sliceSpace / (radius * 0.017453292f);
                float f15 = rotationAngle + ((f11 + (f14 / 2.0f)) * phaseY);
                float f16 = (f12 - f14) * phaseY;
                if (f16 < 0.0f) {
                    f16 = 0.0f;
                }
                this.mPathBuffer.reset();
                if (z4) {
                    float f17 = radius - holeRadius2;
                    i4 = i11;
                    i5 = i9;
                    double d4 = f15 * 0.017453292f;
                    i6 = entryCount;
                    fArr = drawAngles;
                    float cos = centerCircleBox.f37332x + (((float) Math.cos(d4)) * f17);
                    float sin = centerCircleBox.f37333y + (f17 * ((float) Math.sin(d4)));
                    rectF5.set(cos - holeRadius2, sin - holeRadius2, cos + holeRadius2, sin + holeRadius2);
                } else {
                    i4 = i11;
                    i5 = i9;
                    i6 = entryCount;
                    fArr = drawAngles;
                }
                double d5 = f15 * 0.017453292f;
                f4 = rotationAngle;
                f5 = phaseX;
                float cos2 = centerCircleBox.f37332x + (((float) Math.cos(d5)) * radius);
                float sin2 = centerCircleBox.f37333y + (((float) Math.sin(d5)) * radius);
                if (f16 >= 360.0f && f16 % 360.0f <= f13) {
                    this.mPathBuffer.addCircle(centerCircleBox.f37332x, centerCircleBox.f37333y, radius, Path.Direction.CW);
                } else {
                    if (z4) {
                        this.mPathBuffer.arcTo(rectF5, f15 + 180.0f, -180.0f);
                    }
                    this.mPathBuffer.arcTo(circleBox, f15, f16);
                }
                RectF rectF6 = this.mInnerRectBuffer;
                float f18 = centerCircleBox.f37332x;
                float f19 = centerCircleBox.f37333y;
                rectF6.set(f18 - holeRadius, f19 - holeRadius, f18 + holeRadius, f19 + holeRadius);
                if (!z3) {
                    f6 = f16;
                    f7 = holeRadius;
                    f8 = radius;
                    i7 = i5;
                    rectF = circleBox;
                    mPPointF = centerCircleBox;
                    rectF2 = rectF5;
                    f9 = 360.0f;
                } else if (holeRadius > 0.0f || z5) {
                    if (z5) {
                        f10 = f16;
                        i7 = i5;
                        rectF = circleBox;
                        f7 = holeRadius;
                        rectF4 = rectF5;
                        i8 = 1;
                        f8 = radius;
                        mPPointF2 = centerCircleBox;
                        float calculateMinimumRadiusForSpacedSlice = calculateMinimumRadiusForSpacedSlice(centerCircleBox, radius, f12 * phaseY, cos2, sin2, f15, f10);
                        if (calculateMinimumRadiusForSpacedSlice < 0.0f) {
                            calculateMinimumRadiusForSpacedSlice = -calculateMinimumRadiusForSpacedSlice;
                        }
                        holeRadius = Math.max(f7, calculateMinimumRadiusForSpacedSlice);
                    } else {
                        f10 = f16;
                        rectF4 = rectF5;
                        f7 = holeRadius;
                        f8 = radius;
                        mPPointF2 = centerCircleBox;
                        i7 = i5;
                        rectF = circleBox;
                        i8 = 1;
                    }
                    float f20 = (i7 == i8 || holeRadius == 0.0f) ? 0.0f : sliceSpace / (holeRadius * 0.017453292f);
                    float f21 = f4 + ((f11 + (f20 / 2.0f)) * phaseY);
                    float f22 = (f12 - f20) * phaseY;
                    if (f22 < 0.0f) {
                        f22 = 0.0f;
                    }
                    float f23 = f21 + f22;
                    if (f10 >= 360.0f && f10 % 360.0f <= f13) {
                        this.mPathBuffer.addCircle(mPPointF2.f37332x, mPPointF2.f37333y, holeRadius, Path.Direction.CCW);
                        rectF2 = rectF4;
                    } else {
                        if (z4) {
                            float f24 = f8 - holeRadius2;
                            double d6 = f23 * 0.017453292f;
                            float cos3 = mPPointF2.f37332x + (((float) Math.cos(d6)) * f24);
                            float sin3 = mPPointF2.f37333y + (f24 * ((float) Math.sin(d6)));
                            rectF2 = rectF4;
                            rectF2.set(cos3 - holeRadius2, sin3 - holeRadius2, cos3 + holeRadius2, sin3 + holeRadius2);
                            this.mPathBuffer.arcTo(rectF2, f23, 180.0f);
                        } else {
                            rectF2 = rectF4;
                            double d7 = f23 * 0.017453292f;
                            this.mPathBuffer.lineTo(mPPointF2.f37332x + (((float) Math.cos(d7)) * holeRadius), mPPointF2.f37333y + (holeRadius * ((float) Math.sin(d7))));
                        }
                        this.mPathBuffer.arcTo(this.mInnerRectBuffer, f23, -f22);
                    }
                    mPPointF = mPPointF2;
                    rectF3 = rectF2;
                    this.mPathBuffer.close();
                    this.mBitmapCanvas.drawPath(this.mPathBuffer, this.mRenderPaint);
                    f11 += f12 * f5;
                } else {
                    f6 = f16;
                    f7 = holeRadius;
                    f8 = radius;
                    i7 = i5;
                    f9 = 360.0f;
                    rectF = circleBox;
                    mPPointF = centerCircleBox;
                    rectF2 = rectF5;
                }
                if (f6 % f9 > f13) {
                    if (z5) {
                        float f25 = f15 + (f6 / 2.0f);
                        rectF3 = rectF2;
                        float calculateMinimumRadiusForSpacedSlice2 = calculateMinimumRadiusForSpacedSlice(mPPointF, f8, f12 * phaseY, cos2, sin2, f15, f6);
                        double d8 = f25 * 0.017453292f;
                        this.mPathBuffer.lineTo(mPPointF.f37332x + (((float) Math.cos(d8)) * calculateMinimumRadiusForSpacedSlice2), mPPointF.f37333y + (calculateMinimumRadiusForSpacedSlice2 * ((float) Math.sin(d8))));
                    } else {
                        rectF3 = rectF2;
                        this.mPathBuffer.lineTo(mPPointF.f37332x, mPPointF.f37333y);
                    }
                    this.mPathBuffer.close();
                    this.mBitmapCanvas.drawPath(this.mPathBuffer, this.mRenderPaint);
                    f11 += f12 * f5;
                }
                rectF3 = rectF2;
                this.mPathBuffer.close();
                this.mBitmapCanvas.drawPath(this.mPathBuffer, this.mRenderPaint);
                f11 += f12 * f5;
            } else {
                f11 += f12 * phaseX;
                i4 = i11;
                rectF3 = rectF5;
                f8 = radius;
                f4 = rotationAngle;
                f5 = phaseX;
                rectF = circleBox;
                i6 = entryCount;
                fArr = drawAngles;
                i7 = i9;
                f7 = holeRadius;
                mPPointF = centerCircleBox;
            }
            i11 = i4 + 1;
            rectF5 = rectF3;
            holeRadius = f7;
            centerCircleBox = mPPointF;
            i9 = i7;
            radius = f8;
            rotationAngle = f4;
            circleBox = rectF;
            entryCount = i6;
            drawAngles = fArr;
            phaseX = f5;
            iPieDataSet2 = iPieDataSet;
        }
        MPPointF.recycleInstance(centerCircleBox);
    }

    protected void drawEntryLabel(Canvas canvas, String str, float f4, float f5) {
        canvas.drawText(str, f4, f5, this.mEntryLabelsPaint);
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawExtras(Canvas canvas) {
        drawHole(canvas);
        canvas.drawBitmap(this.mDrawBitmap.get(), 0.0f, 0.0f, (Paint) null);
        drawCenterText(canvas);
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawHighlighted(Canvas canvas, Highlight[] highlightArr) {
        int i4;
        RectF rectF;
        float f4;
        float[] fArr;
        boolean z3;
        float f5;
        float f6;
        MPPointF mPPointF;
        IPieDataSet dataSetByIndex;
        float f7;
        int i5;
        float[] fArr2;
        float f8;
        int i6;
        float f9;
        float f10;
        Highlight[] highlightArr2 = highlightArr;
        boolean z4 = this.mChart.isDrawHoleEnabled() && !this.mChart.isDrawSlicesUnderHoleEnabled();
        if (z4 && this.mChart.isDrawRoundedSlicesEnabled()) {
            return;
        }
        float phaseX = this.mAnimator.getPhaseX();
        float phaseY = this.mAnimator.getPhaseY();
        float rotationAngle = this.mChart.getRotationAngle();
        float[] drawAngles = this.mChart.getDrawAngles();
        float[] absoluteAngles = this.mChart.getAbsoluteAngles();
        MPPointF centerCircleBox = this.mChart.getCenterCircleBox();
        float radius = this.mChart.getRadius();
        float holeRadius = z4 ? (this.mChart.getHoleRadius() / 100.0f) * radius : 0.0f;
        RectF rectF2 = this.mDrawHighlightedRectF;
        rectF2.set(0.0f, 0.0f, 0.0f, 0.0f);
        int i7 = 0;
        while (i7 < highlightArr2.length) {
            int x3 = (int) highlightArr2[i7].getX();
            if (x3 < drawAngles.length && (dataSetByIndex = ((PieData) this.mChart.getData()).getDataSetByIndex(highlightArr2[i7].getDataSetIndex())) != null && dataSetByIndex.isHighlightEnabled()) {
                int entryCount = dataSetByIndex.getEntryCount();
                int i8 = 0;
                for (int i9 = 0; i9 < entryCount; i9++) {
                    if (Math.abs(dataSetByIndex.getEntryForIndex(i9).getY()) > Utils.FLOAT_EPSILON) {
                        i8++;
                    }
                }
                if (x3 == 0) {
                    i5 = 1;
                    f7 = 0.0f;
                } else {
                    f7 = absoluteAngles[x3 - 1] * phaseX;
                    i5 = 1;
                }
                float sliceSpace = i8 <= i5 ? 0.0f : dataSetByIndex.getSliceSpace();
                float f11 = drawAngles[x3];
                float selectionShift = dataSetByIndex.getSelectionShift();
                int i10 = i7;
                float f12 = radius + selectionShift;
                float f13 = holeRadius;
                rectF2.set(this.mChart.getCircleBox());
                float f14 = -selectionShift;
                rectF2.inset(f14, f14);
                boolean z5 = sliceSpace > 0.0f && f11 <= 180.0f;
                this.mRenderPaint.setColor(dataSetByIndex.getColor(x3));
                float f15 = i8 == 1 ? 0.0f : sliceSpace / (radius * 0.017453292f);
                float f16 = i8 == 1 ? 0.0f : sliceSpace / (f12 * 0.017453292f);
                float f17 = rotationAngle + (((f15 / 2.0f) + f7) * phaseY);
                float f18 = (f11 - f15) * phaseY;
                float f19 = f18 < 0.0f ? 0.0f : f18;
                float f20 = (((f16 / 2.0f) + f7) * phaseY) + rotationAngle;
                float f21 = (f11 - f16) * phaseY;
                if (f21 < 0.0f) {
                    f21 = 0.0f;
                }
                this.mPathBuffer.reset();
                if (f19 >= 360.0f && f19 % 360.0f <= Utils.FLOAT_EPSILON) {
                    this.mPathBuffer.addCircle(centerCircleBox.f37332x, centerCircleBox.f37333y, f12, Path.Direction.CW);
                    fArr2 = drawAngles;
                    f8 = f7;
                    i6 = i8;
                    z3 = z4;
                } else {
                    fArr2 = drawAngles;
                    f8 = f7;
                    double d4 = f20 * 0.017453292f;
                    i6 = i8;
                    z3 = z4;
                    this.mPathBuffer.moveTo(centerCircleBox.f37332x + (((float) Math.cos(d4)) * f12), centerCircleBox.f37333y + (f12 * ((float) Math.sin(d4))));
                    this.mPathBuffer.arcTo(rectF2, f20, f21);
                }
                if (z5) {
                    double d5 = f17 * 0.017453292f;
                    i4 = i10;
                    rectF = rectF2;
                    f4 = f13;
                    mPPointF = centerCircleBox;
                    fArr = fArr2;
                    f9 = calculateMinimumRadiusForSpacedSlice(centerCircleBox, radius, f11 * phaseY, (((float) Math.cos(d5)) * radius) + centerCircleBox.f37332x, centerCircleBox.f37333y + (((float) Math.sin(d5)) * radius), f17, f19);
                } else {
                    rectF = rectF2;
                    mPPointF = centerCircleBox;
                    i4 = i10;
                    f4 = f13;
                    fArr = fArr2;
                    f9 = 0.0f;
                }
                RectF rectF3 = this.mInnerRectBuffer;
                float f22 = mPPointF.f37332x;
                float f23 = mPPointF.f37333y;
                rectF3.set(f22 - f4, f23 - f4, f22 + f4, f23 + f4);
                if (z3 && (f4 > 0.0f || z5)) {
                    if (z5) {
                        if (f9 < 0.0f) {
                            f9 = -f9;
                        }
                        f10 = Math.max(f4, f9);
                    } else {
                        f10 = f4;
                    }
                    float f24 = (i6 == 1 || f10 == 0.0f) ? 0.0f : sliceSpace / (f10 * 0.017453292f);
                    float f25 = ((f8 + (f24 / 2.0f)) * phaseY) + rotationAngle;
                    float f26 = (f11 - f24) * phaseY;
                    if (f26 < 0.0f) {
                        f26 = 0.0f;
                    }
                    float f27 = f25 + f26;
                    if (f19 >= 360.0f && f19 % 360.0f <= Utils.FLOAT_EPSILON) {
                        this.mPathBuffer.addCircle(mPPointF.f37332x, mPPointF.f37333y, f10, Path.Direction.CCW);
                        f5 = phaseX;
                        f6 = phaseY;
                    } else {
                        double d6 = f27 * 0.017453292f;
                        f5 = phaseX;
                        f6 = phaseY;
                        this.mPathBuffer.lineTo(mPPointF.f37332x + (((float) Math.cos(d6)) * f10), mPPointF.f37333y + (f10 * ((float) Math.sin(d6))));
                        this.mPathBuffer.arcTo(this.mInnerRectBuffer, f27, -f26);
                    }
                } else {
                    f5 = phaseX;
                    f6 = phaseY;
                    if (f19 % 360.0f > Utils.FLOAT_EPSILON) {
                        if (z5) {
                            double d7 = (f17 + (f19 / 2.0f)) * 0.017453292f;
                            this.mPathBuffer.lineTo(mPPointF.f37332x + (((float) Math.cos(d7)) * f9), mPPointF.f37333y + (f9 * ((float) Math.sin(d7))));
                        } else {
                            this.mPathBuffer.lineTo(mPPointF.f37332x, mPPointF.f37333y);
                        }
                    }
                }
                this.mPathBuffer.close();
                this.mBitmapCanvas.drawPath(this.mPathBuffer, this.mRenderPaint);
            } else {
                i4 = i7;
                rectF = rectF2;
                f4 = holeRadius;
                fArr = drawAngles;
                z3 = z4;
                f5 = phaseX;
                f6 = phaseY;
                mPPointF = centerCircleBox;
            }
            i7 = i4 + 1;
            phaseX = f5;
            rectF2 = rectF;
            holeRadius = f4;
            centerCircleBox = mPPointF;
            phaseY = f6;
            drawAngles = fArr;
            z4 = z3;
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
            this.mBitmapCanvas.drawCircle(centerCircleBox.f37332x, centerCircleBox.f37333y, holeRadius, this.mHolePaint);
        }
        if (Color.alpha(this.mTransparentCirclePaint.getColor()) > 0 && this.mChart.getTransparentCircleRadius() > this.mChart.getHoleRadius()) {
            int alpha = this.mTransparentCirclePaint.getAlpha();
            float transparentCircleRadius = radius * (this.mChart.getTransparentCircleRadius() / 100.0f);
            this.mTransparentCirclePaint.setAlpha((int) (alpha * this.mAnimator.getPhaseX() * this.mAnimator.getPhaseY()));
            this.mHoleCirclePath.reset();
            this.mHoleCirclePath.addCircle(centerCircleBox.f37332x, centerCircleBox.f37333y, transparentCircleRadius, Path.Direction.CW);
            this.mHoleCirclePath.addCircle(centerCircleBox.f37332x, centerCircleBox.f37333y, holeRadius, Path.Direction.CCW);
            this.mBitmapCanvas.drawPath(this.mHoleCirclePath, this.mTransparentCirclePaint);
            this.mTransparentCirclePaint.setAlpha(alpha);
        }
        MPPointF.recycleInstance(centerCircleBox);
    }

    protected void drawRoundedSlices(Canvas canvas) {
        float f4;
        float[] fArr;
        float f5;
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
                int i4 = 0;
                while (i4 < dataSet.getEntryCount()) {
                    float f6 = drawAngles[i4];
                    if (Math.abs(dataSet.getEntryForIndex(i4).getY()) > Utils.FLOAT_EPSILON) {
                        double d4 = radius - holeRadius;
                        double d5 = (rotationAngle + f6) * phaseY;
                        double cos = Math.cos(Math.toRadians(d5));
                        Double.isNaN(d4);
                        f4 = phaseY;
                        fArr = drawAngles;
                        f5 = rotationAngle;
                        double d6 = centerCircleBox.f37332x;
                        Double.isNaN(d6);
                        float f7 = (float) (d6 + (cos * d4));
                        double sin = Math.sin(Math.toRadians(d5));
                        Double.isNaN(d4);
                        double d7 = d4 * sin;
                        double d8 = centerCircleBox.f37333y;
                        Double.isNaN(d8);
                        this.mRenderPaint.setColor(dataSet.getColor(i4));
                        this.mBitmapCanvas.drawCircle(f7, (float) (d7 + d8), holeRadius, this.mRenderPaint);
                    } else {
                        f4 = phaseY;
                        fArr = drawAngles;
                        f5 = rotationAngle;
                    }
                    rotationAngle = f5 + (f6 * phaseX);
                    i4++;
                    phaseY = f4;
                    drawAngles = fArr;
                }
                MPPointF.recycleInstance(centerCircleBox);
            }
        }
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawValue(Canvas canvas, String str, float f4, float f5, int i4) {
        this.mValuePaint.setColor(i4);
        canvas.drawText(str, f4, f5, this.mValuePaint);
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawValues(Canvas canvas) {
        int i4;
        float[] fArr;
        float[] fArr2;
        float f4;
        float f5;
        float f6;
        List<IPieDataSet> list;
        MPPointF mPPointF;
        float f7;
        Canvas canvas2;
        PieDataSet.ValuePosition valuePosition;
        float f8;
        float f9;
        float f10;
        float f11;
        float f12;
        MPPointF mPPointF2;
        ValueFormatter valueFormatter;
        MPPointF mPPointF3;
        IPieDataSet iPieDataSet;
        float f13;
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
        float f14 = (radius / 10.0f) * 3.6f;
        if (this.mChart.isDrawHoleEnabled()) {
            f14 = (radius - (radius * holeRadius2)) / 2.0f;
            if (!this.mChart.isDrawSlicesUnderHoleEnabled() && this.mChart.isDrawRoundedSlicesEnabled()) {
                double d4 = rotationAngle;
                double d5 = holeRadius * 360.0f;
                double d6 = radius;
                Double.isNaN(d6);
                Double.isNaN(d5);
                Double.isNaN(d4);
                rotationAngle = (float) (d4 + (d5 / (d6 * 6.283185307179586d)));
            }
        }
        float f15 = rotationAngle;
        float f16 = radius - f14;
        PieData pieData = (PieData) this.mChart.getData();
        List<IPieDataSet> dataSets = pieData.getDataSets();
        float yValueSum = pieData.getYValueSum();
        boolean isDrawEntryLabelsEnabled = this.mChart.isDrawEntryLabelsEnabled();
        canvas.save();
        float convertDpToPixel = Utils.convertDpToPixel(5.0f);
        int i5 = 0;
        int i6 = 0;
        while (i6 < dataSets.size()) {
            IPieDataSet iPieDataSet2 = dataSets.get(i6);
            boolean isDrawValuesEnabled = iPieDataSet2.isDrawValuesEnabled();
            if (isDrawValuesEnabled || isDrawEntryLabelsEnabled) {
                PieDataSet.ValuePosition xValuePosition = iPieDataSet2.getXValuePosition();
                PieDataSet.ValuePosition yValuePosition = iPieDataSet2.getYValuePosition();
                applyValueTextStyle(iPieDataSet2);
                int i7 = i5;
                i4 = i6;
                float calcTextHeight = Utils.calcTextHeight(this.mValuePaint, "Q") + Utils.convertDpToPixel(4.0f);
                ValueFormatter valueFormatter2 = iPieDataSet2.getValueFormatter();
                int entryCount = iPieDataSet2.getEntryCount();
                List<IPieDataSet> list3 = dataSets;
                this.mValueLinePaint.setColor(iPieDataSet2.getValueLineColor());
                this.mValueLinePaint.setStrokeWidth(Utils.convertDpToPixel(iPieDataSet2.getValueLineWidth()));
                float sliceSpace = getSliceSpace(iPieDataSet2);
                MPPointF mPPointF6 = MPPointF.getInstance(iPieDataSet2.getIconsOffset());
                MPPointF mPPointF7 = centerCircleBox;
                mPPointF6.f37332x = Utils.convertDpToPixel(mPPointF6.f37332x);
                mPPointF6.f37333y = Utils.convertDpToPixel(mPPointF6.f37333y);
                int i8 = 0;
                while (i8 < entryCount) {
                    MPPointF mPPointF8 = mPPointF6;
                    PieEntry entryForIndex = iPieDataSet2.getEntryForIndex(i8);
                    int i9 = entryCount;
                    float f17 = f15 + (((i7 == 0 ? 0.0f : absoluteAngles[i7 - 1] * phaseX) + ((drawAngles[i7] - ((sliceSpace / (f16 * 0.017453292f)) / 2.0f)) / 2.0f)) * phaseY);
                    float f18 = sliceSpace;
                    String pieLabel = valueFormatter2.getPieLabel(this.mChart.isUsePercentValuesEnabled() ? (entryForIndex.getY() / yValueSum) * 100.0f : entryForIndex.getY(), entryForIndex);
                    float[] fArr3 = drawAngles;
                    String label = entryForIndex.getLabel();
                    ValueFormatter valueFormatter3 = valueFormatter2;
                    double d7 = f17 * 0.017453292f;
                    float[] fArr4 = absoluteAngles;
                    float f19 = phaseX;
                    float cos = (float) Math.cos(d7);
                    float f20 = phaseY;
                    float sin = (float) Math.sin(d7);
                    boolean z3 = isDrawEntryLabelsEnabled && xValuePosition == PieDataSet.ValuePosition.OUTSIDE_SLICE;
                    float f21 = f15;
                    boolean z4 = isDrawValuesEnabled && yValuePosition == PieDataSet.ValuePosition.OUTSIDE_SLICE;
                    boolean z5 = isDrawEntryLabelsEnabled && xValuePosition == PieDataSet.ValuePosition.INSIDE_SLICE;
                    PieDataSet.ValuePosition valuePosition2 = xValuePosition;
                    boolean z6 = isDrawValuesEnabled && yValuePosition == PieDataSet.ValuePosition.INSIDE_SLICE;
                    if (z3 || z4) {
                        float valueLinePart1Length = iPieDataSet2.getValueLinePart1Length();
                        float valueLinePart2Length = iPieDataSet2.getValueLinePart2Length();
                        float valueLinePart1OffsetPercentage = iPieDataSet2.getValueLinePart1OffsetPercentage() / 100.0f;
                        valuePosition = yValuePosition;
                        if (this.mChart.isDrawHoleEnabled()) {
                            float f22 = radius * holeRadius2;
                            f8 = ((radius - f22) * valueLinePart1OffsetPercentage) + f22;
                        } else {
                            f8 = radius * valueLinePart1OffsetPercentage;
                        }
                        float abs = iPieDataSet2.isValueLineVariableLength() ? valueLinePart2Length * f16 * ((float) Math.abs(Math.sin(d7))) : valueLinePart2Length * f16;
                        MPPointF mPPointF9 = mPPointF7;
                        float f23 = mPPointF9.f37332x;
                        float f24 = (f8 * cos) + f23;
                        f9 = radius;
                        float f25 = mPPointF9.f37333y;
                        float f26 = (f8 * sin) + f25;
                        float f27 = (valueLinePart1Length + 1.0f) * f16;
                        float f28 = (f27 * cos) + f23;
                        float f29 = f25 + (f27 * sin);
                        double d8 = f17;
                        Double.isNaN(d8);
                        double d9 = d8 % 360.0d;
                        if (d9 >= 90.0d && d9 <= 270.0d) {
                            float f30 = f28 - abs;
                            this.mValuePaint.setTextAlign(Paint.Align.RIGHT);
                            if (z3) {
                                this.mEntryLabelsPaint.setTextAlign(Paint.Align.RIGHT);
                            }
                            f10 = f30;
                            f11 = f30 - convertDpToPixel;
                        } else {
                            f10 = f28 + abs;
                            this.mValuePaint.setTextAlign(Paint.Align.LEFT);
                            if (z3) {
                                this.mEntryLabelsPaint.setTextAlign(Paint.Align.LEFT);
                            }
                            f11 = f10 + convertDpToPixel;
                        }
                        if (iPieDataSet2.getValueLineColor() != 1122867) {
                            if (iPieDataSet2.isUsingSliceColorAsValueLineColor()) {
                                this.mValueLinePaint.setColor(iPieDataSet2.getColor(i8));
                            }
                            f12 = sin;
                            iPieDataSet = iPieDataSet2;
                            valueFormatter = valueFormatter3;
                            mPPointF2 = mPPointF8;
                            mPPointF3 = mPPointF9;
                            f13 = f11;
                            list2 = list3;
                            pieEntry = entryForIndex;
                            canvas.drawLine(f24, f26, f28, f29, this.mValueLinePaint);
                            canvas.drawLine(f28, f29, f10, f29, this.mValueLinePaint);
                        } else {
                            f12 = sin;
                            mPPointF2 = mPPointF8;
                            valueFormatter = valueFormatter3;
                            mPPointF3 = mPPointF9;
                            iPieDataSet = iPieDataSet2;
                            f13 = f11;
                            list2 = list3;
                            pieEntry = entryForIndex;
                        }
                        if (z3 && z4) {
                            drawValue(canvas, pieLabel, f13, f29, iPieDataSet.getValueTextColor(i8));
                            if (i8 >= pieData.getEntryCount() || label == null) {
                                canvas4 = canvas;
                                str2 = label;
                            } else {
                                canvas3 = canvas;
                                str = label;
                                drawEntryLabel(canvas3, str, f13, f29 + calcTextHeight);
                                str2 = str;
                                canvas4 = canvas3;
                            }
                        } else {
                            canvas3 = canvas;
                            float f31 = f13;
                            str = label;
                            if (z3) {
                                if (i8 < pieData.getEntryCount() && str != null) {
                                    drawEntryLabel(canvas3, str, f31, f29 + (calcTextHeight / 2.0f));
                                }
                            } else if (z4) {
                                str2 = str;
                                canvas4 = canvas3;
                                drawValue(canvas, pieLabel, f31, f29 + (calcTextHeight / 2.0f), iPieDataSet.getValueTextColor(i8));
                            }
                            str2 = str;
                            canvas4 = canvas3;
                        }
                    } else {
                        valuePosition = yValuePosition;
                        f12 = sin;
                        mPPointF3 = mPPointF7;
                        mPPointF2 = mPPointF8;
                        valueFormatter = valueFormatter3;
                        str2 = label;
                        iPieDataSet = iPieDataSet2;
                        f9 = radius;
                        canvas4 = canvas;
                        list2 = list3;
                        pieEntry = entryForIndex;
                    }
                    if (z5 || z6) {
                        mPPointF4 = mPPointF3;
                        float f32 = (f16 * cos) + mPPointF4.f37332x;
                        float f33 = (f16 * f12) + mPPointF4.f37333y;
                        this.mValuePaint.setTextAlign(Paint.Align.CENTER);
                        if (z5 && z6) {
                            drawValue(canvas, pieLabel, f32, f33, iPieDataSet.getValueTextColor(i8));
                            if (i8 < pieData.getEntryCount() && str2 != null) {
                                drawEntryLabel(canvas4, str2, f32, f33 + calcTextHeight);
                            }
                        } else {
                            if (z5) {
                                if (i8 < pieData.getEntryCount() && str2 != null) {
                                    drawEntryLabel(canvas4, str2, f32, f33 + (calcTextHeight / 2.0f));
                                }
                            } else if (z6) {
                                drawValue(canvas, pieLabel, f32, f33 + (calcTextHeight / 2.0f), iPieDataSet.getValueTextColor(i8));
                            }
                            if (pieEntry.getIcon() == null && iPieDataSet.isDrawIconsEnabled()) {
                                Drawable icon = pieEntry.getIcon();
                                mPPointF5 = mPPointF2;
                                float f34 = mPPointF5.f37333y;
                                Utils.drawImage(canvas, icon, (int) (((f16 + f34) * cos) + mPPointF4.f37332x), (int) (((f34 + f16) * f12) + mPPointF4.f37333y + mPPointF5.f37332x), icon.getIntrinsicWidth(), icon.getIntrinsicHeight());
                            } else {
                                mPPointF5 = mPPointF2;
                            }
                            i7++;
                            i8++;
                            mPPointF6 = mPPointF5;
                            iPieDataSet2 = iPieDataSet;
                            radius = f9;
                            sliceSpace = f18;
                            entryCount = i9;
                            list3 = list2;
                            drawAngles = fArr3;
                            absoluteAngles = fArr4;
                            phaseX = f19;
                            f15 = f21;
                            xValuePosition = valuePosition2;
                            yValuePosition = valuePosition;
                            valueFormatter2 = valueFormatter;
                            mPPointF7 = mPPointF4;
                            phaseY = f20;
                        }
                    } else {
                        mPPointF4 = mPPointF3;
                    }
                    if (pieEntry.getIcon() == null) {
                    }
                    mPPointF5 = mPPointF2;
                    i7++;
                    i8++;
                    mPPointF6 = mPPointF5;
                    iPieDataSet2 = iPieDataSet;
                    radius = f9;
                    sliceSpace = f18;
                    entryCount = i9;
                    list3 = list2;
                    drawAngles = fArr3;
                    absoluteAngles = fArr4;
                    phaseX = f19;
                    f15 = f21;
                    xValuePosition = valuePosition2;
                    yValuePosition = valuePosition;
                    valueFormatter2 = valueFormatter;
                    mPPointF7 = mPPointF4;
                    phaseY = f20;
                }
                fArr = drawAngles;
                fArr2 = absoluteAngles;
                f4 = phaseX;
                f5 = phaseY;
                f6 = f15;
                list = list3;
                mPPointF = mPPointF7;
                f7 = radius;
                canvas2 = canvas;
                MPPointF.recycleInstance(mPPointF6);
                i5 = i7;
            } else {
                i4 = i6;
                list = dataSets;
                f7 = radius;
                fArr = drawAngles;
                fArr2 = absoluteAngles;
                f4 = phaseX;
                f5 = phaseY;
                f6 = f15;
                canvas2 = canvas5;
                mPPointF = centerCircleBox;
            }
            i6 = i4 + 1;
            canvas5 = canvas2;
            centerCircleBox = mPPointF;
            radius = f7;
            dataSets = list;
            drawAngles = fArr;
            absoluteAngles = fArr2;
            phaseX = f4;
            phaseY = f5;
            f15 = f6;
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
