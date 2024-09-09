package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.data.RadarEntry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.IRadarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class RadarChartRenderer extends LineRadarRenderer {
    protected RadarChart mChart;
    protected Path mDrawDataSetSurfacePathBuffer;
    protected Path mDrawHighlightCirclePathBuffer;
    protected Paint mHighlightCirclePaint;
    protected Paint mWebPaint;

    public RadarChartRenderer(RadarChart radarChart, ChartAnimator chartAnimator, ViewPortHandler viewPortHandler) {
        super(chartAnimator, viewPortHandler);
        this.mDrawDataSetSurfacePathBuffer = new Path();
        this.mDrawHighlightCirclePathBuffer = new Path();
        this.mChart = radarChart;
        Paint paint = new Paint(1);
        this.mHighlightPaint = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.mHighlightPaint.setStrokeWidth(2.0f);
        this.mHighlightPaint.setColor(Color.rgb(255, 187, 115));
        Paint paint2 = new Paint(1);
        this.mWebPaint = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        this.mHighlightCirclePaint = new Paint(1);
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawData(Canvas canvas) {
        RadarData radarData = (RadarData) this.mChart.getData();
        int entryCount = radarData.getMaxEntryCountSet().getEntryCount();
        for (IRadarDataSet iRadarDataSet : radarData.getDataSets()) {
            if (iRadarDataSet.isVisible()) {
                drawDataSet(canvas, iRadarDataSet, entryCount);
            }
        }
    }

    protected void drawDataSet(Canvas canvas, IRadarDataSet iRadarDataSet, int i4) {
        float phaseX = this.mAnimator.getPhaseX();
        float phaseY = this.mAnimator.getPhaseY();
        float sliceAngle = this.mChart.getSliceAngle();
        float factor = this.mChart.getFactor();
        MPPointF centerOffsets = this.mChart.getCenterOffsets();
        MPPointF mPPointF = MPPointF.getInstance(0.0f, 0.0f);
        Path path = this.mDrawDataSetSurfacePathBuffer;
        path.reset();
        boolean z3 = false;
        for (int i5 = 0; i5 < iRadarDataSet.getEntryCount(); i5++) {
            this.mRenderPaint.setColor(iRadarDataSet.getColor(i5));
            Utils.getPosition(centerOffsets, (((RadarEntry) iRadarDataSet.getEntryForIndex(i5)).getY() - this.mChart.getYChartMin()) * factor * phaseY, (i5 * sliceAngle * phaseX) + this.mChart.getRotationAngle(), mPPointF);
            if (!Float.isNaN(mPPointF.f37332x)) {
                if (!z3) {
                    path.moveTo(mPPointF.f37332x, mPPointF.f37333y);
                    z3 = true;
                } else {
                    path.lineTo(mPPointF.f37332x, mPPointF.f37333y);
                }
            }
        }
        if (iRadarDataSet.getEntryCount() > i4) {
            path.lineTo(centerOffsets.f37332x, centerOffsets.f37333y);
        }
        path.close();
        if (iRadarDataSet.isDrawFilledEnabled()) {
            Drawable fillDrawable = iRadarDataSet.getFillDrawable();
            if (fillDrawable != null) {
                drawFilledPath(canvas, path, fillDrawable);
            } else {
                drawFilledPath(canvas, path, iRadarDataSet.getFillColor(), iRadarDataSet.getFillAlpha());
            }
        }
        this.mRenderPaint.setStrokeWidth(iRadarDataSet.getLineWidth());
        this.mRenderPaint.setStyle(Paint.Style.STROKE);
        if (!iRadarDataSet.isDrawFilledEnabled() || iRadarDataSet.getFillAlpha() < 255) {
            canvas.drawPath(path, this.mRenderPaint);
        }
        MPPointF.recycleInstance(centerOffsets);
        MPPointF.recycleInstance(mPPointF);
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawExtras(Canvas canvas) {
        drawWeb(canvas);
    }

    public void drawHighlightCircle(Canvas canvas, MPPointF mPPointF, float f4, float f5, int i4, int i5, float f6) {
        canvas.save();
        float convertDpToPixel = Utils.convertDpToPixel(f5);
        float convertDpToPixel2 = Utils.convertDpToPixel(f4);
        if (i4 != 1122867) {
            Path path = this.mDrawHighlightCirclePathBuffer;
            path.reset();
            path.addCircle(mPPointF.f37332x, mPPointF.f37333y, convertDpToPixel, Path.Direction.CW);
            if (convertDpToPixel2 > 0.0f) {
                path.addCircle(mPPointF.f37332x, mPPointF.f37333y, convertDpToPixel2, Path.Direction.CCW);
            }
            this.mHighlightCirclePaint.setColor(i4);
            this.mHighlightCirclePaint.setStyle(Paint.Style.FILL);
            canvas.drawPath(path, this.mHighlightCirclePaint);
        }
        if (i5 != 1122867) {
            this.mHighlightCirclePaint.setColor(i5);
            this.mHighlightCirclePaint.setStyle(Paint.Style.STROKE);
            this.mHighlightCirclePaint.setStrokeWidth(Utils.convertDpToPixel(f6));
            canvas.drawCircle(mPPointF.f37332x, mPPointF.f37333y, convertDpToPixel, this.mHighlightCirclePaint);
        }
        canvas.restore();
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawHighlighted(Canvas canvas, Highlight[] highlightArr) {
        int i4;
        float sliceAngle = this.mChart.getSliceAngle();
        float factor = this.mChart.getFactor();
        MPPointF centerOffsets = this.mChart.getCenterOffsets();
        MPPointF mPPointF = MPPointF.getInstance(0.0f, 0.0f);
        RadarData radarData = (RadarData) this.mChart.getData();
        int length = highlightArr.length;
        int i5 = 0;
        int i6 = 0;
        while (i6 < length) {
            Highlight highlight = highlightArr[i6];
            IRadarDataSet dataSetByIndex = radarData.getDataSetByIndex(highlight.getDataSetIndex());
            if (dataSetByIndex != null && dataSetByIndex.isHighlightEnabled()) {
                Entry entry = (RadarEntry) dataSetByIndex.getEntryForIndex((int) highlight.getX());
                if (isInBoundsX(entry, dataSetByIndex)) {
                    Utils.getPosition(centerOffsets, (entry.getY() - this.mChart.getYChartMin()) * factor * this.mAnimator.getPhaseY(), (highlight.getX() * sliceAngle * this.mAnimator.getPhaseX()) + this.mChart.getRotationAngle(), mPPointF);
                    highlight.setDraw(mPPointF.f37332x, mPPointF.f37333y);
                    drawHighlightLines(canvas, mPPointF.f37332x, mPPointF.f37333y, dataSetByIndex);
                    if (dataSetByIndex.isDrawHighlightCircleEnabled() && !Float.isNaN(mPPointF.f37332x) && !Float.isNaN(mPPointF.f37333y)) {
                        int highlightCircleStrokeColor = dataSetByIndex.getHighlightCircleStrokeColor();
                        if (highlightCircleStrokeColor == 1122867) {
                            highlightCircleStrokeColor = dataSetByIndex.getColor(i5);
                        }
                        if (dataSetByIndex.getHighlightCircleStrokeAlpha() < 255) {
                            highlightCircleStrokeColor = ColorTemplate.colorWithAlpha(highlightCircleStrokeColor, dataSetByIndex.getHighlightCircleStrokeAlpha());
                        }
                        i4 = i6;
                        drawHighlightCircle(canvas, mPPointF, dataSetByIndex.getHighlightCircleInnerRadius(), dataSetByIndex.getHighlightCircleOuterRadius(), dataSetByIndex.getHighlightCircleFillColor(), highlightCircleStrokeColor, dataSetByIndex.getHighlightCircleStrokeWidth());
                        i6 = i4 + 1;
                        i5 = 0;
                    }
                }
            }
            i4 = i6;
            i6 = i4 + 1;
            i5 = 0;
        }
        MPPointF.recycleInstance(centerOffsets);
        MPPointF.recycleInstance(mPPointF);
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawValue(Canvas canvas, String str, float f4, float f5, int i4) {
        this.mValuePaint.setColor(i4);
        canvas.drawText(str, f4, f5, this.mValuePaint);
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawValues(Canvas canvas) {
        int i4;
        float f4;
        RadarEntry radarEntry;
        int i5;
        IRadarDataSet iRadarDataSet;
        int i6;
        float f5;
        MPPointF mPPointF;
        ValueFormatter valueFormatter;
        float phaseX = this.mAnimator.getPhaseX();
        float phaseY = this.mAnimator.getPhaseY();
        float sliceAngle = this.mChart.getSliceAngle();
        float factor = this.mChart.getFactor();
        MPPointF centerOffsets = this.mChart.getCenterOffsets();
        MPPointF mPPointF2 = MPPointF.getInstance(0.0f, 0.0f);
        MPPointF mPPointF3 = MPPointF.getInstance(0.0f, 0.0f);
        float convertDpToPixel = Utils.convertDpToPixel(5.0f);
        int i7 = 0;
        while (i7 < ((RadarData) this.mChart.getData()).getDataSetCount()) {
            IRadarDataSet dataSetByIndex = ((RadarData) this.mChart.getData()).getDataSetByIndex(i7);
            if (shouldDrawValues(dataSetByIndex)) {
                applyValueTextStyle(dataSetByIndex);
                ValueFormatter valueFormatter2 = dataSetByIndex.getValueFormatter();
                MPPointF mPPointF4 = MPPointF.getInstance(dataSetByIndex.getIconsOffset());
                mPPointF4.f37332x = Utils.convertDpToPixel(mPPointF4.f37332x);
                mPPointF4.f37333y = Utils.convertDpToPixel(mPPointF4.f37333y);
                int i8 = 0;
                while (i8 < dataSetByIndex.getEntryCount()) {
                    RadarEntry radarEntry2 = (RadarEntry) dataSetByIndex.getEntryForIndex(i8);
                    MPPointF mPPointF5 = mPPointF4;
                    float f6 = i8 * sliceAngle * phaseX;
                    Utils.getPosition(centerOffsets, (radarEntry2.getY() - this.mChart.getYChartMin()) * factor * phaseY, f6 + this.mChart.getRotationAngle(), mPPointF2);
                    if (dataSetByIndex.isDrawValuesEnabled()) {
                        radarEntry = radarEntry2;
                        i5 = i8;
                        f5 = phaseX;
                        mPPointF = mPPointF5;
                        valueFormatter = valueFormatter2;
                        iRadarDataSet = dataSetByIndex;
                        i6 = i7;
                        drawValue(canvas, valueFormatter2.getRadarLabel(radarEntry2), mPPointF2.f37332x, mPPointF2.f37333y - convertDpToPixel, dataSetByIndex.getValueTextColor(i8));
                    } else {
                        radarEntry = radarEntry2;
                        i5 = i8;
                        iRadarDataSet = dataSetByIndex;
                        i6 = i7;
                        f5 = phaseX;
                        mPPointF = mPPointF5;
                        valueFormatter = valueFormatter2;
                    }
                    if (radarEntry.getIcon() != null && iRadarDataSet.isDrawIconsEnabled()) {
                        Drawable icon = radarEntry.getIcon();
                        Utils.getPosition(centerOffsets, (radarEntry.getY() * factor * phaseY) + mPPointF.f37333y, f6 + this.mChart.getRotationAngle(), mPPointF3);
                        float f7 = mPPointF3.f37333y + mPPointF.f37332x;
                        mPPointF3.f37333y = f7;
                        Utils.drawImage(canvas, icon, (int) mPPointF3.f37332x, (int) f7, icon.getIntrinsicWidth(), icon.getIntrinsicHeight());
                    }
                    i8 = i5 + 1;
                    mPPointF4 = mPPointF;
                    dataSetByIndex = iRadarDataSet;
                    valueFormatter2 = valueFormatter;
                    i7 = i6;
                    phaseX = f5;
                }
                i4 = i7;
                f4 = phaseX;
                MPPointF.recycleInstance(mPPointF4);
            } else {
                i4 = i7;
                f4 = phaseX;
            }
            i7 = i4 + 1;
            phaseX = f4;
        }
        MPPointF.recycleInstance(centerOffsets);
        MPPointF.recycleInstance(mPPointF2);
        MPPointF.recycleInstance(mPPointF3);
    }

    protected void drawWeb(Canvas canvas) {
        float sliceAngle = this.mChart.getSliceAngle();
        float factor = this.mChart.getFactor();
        float rotationAngle = this.mChart.getRotationAngle();
        MPPointF centerOffsets = this.mChart.getCenterOffsets();
        this.mWebPaint.setStrokeWidth(this.mChart.getWebLineWidth());
        this.mWebPaint.setColor(this.mChart.getWebColor());
        this.mWebPaint.setAlpha(this.mChart.getWebAlpha());
        int skipWebLineCount = this.mChart.getSkipWebLineCount() + 1;
        int entryCount = ((RadarData) this.mChart.getData()).getMaxEntryCountSet().getEntryCount();
        MPPointF mPPointF = MPPointF.getInstance(0.0f, 0.0f);
        for (int i4 = 0; i4 < entryCount; i4 += skipWebLineCount) {
            Utils.getPosition(centerOffsets, this.mChart.getYRange() * factor, (i4 * sliceAngle) + rotationAngle, mPPointF);
            canvas.drawLine(centerOffsets.f37332x, centerOffsets.f37333y, mPPointF.f37332x, mPPointF.f37333y, this.mWebPaint);
        }
        MPPointF.recycleInstance(mPPointF);
        this.mWebPaint.setStrokeWidth(this.mChart.getWebLineWidthInner());
        this.mWebPaint.setColor(this.mChart.getWebColorInner());
        this.mWebPaint.setAlpha(this.mChart.getWebAlpha());
        int i5 = this.mChart.getYAxis().mEntryCount;
        MPPointF mPPointF2 = MPPointF.getInstance(0.0f, 0.0f);
        MPPointF mPPointF3 = MPPointF.getInstance(0.0f, 0.0f);
        for (int i6 = 0; i6 < i5; i6++) {
            int i7 = 0;
            while (i7 < ((RadarData) this.mChart.getData()).getEntryCount()) {
                float yChartMin = (this.mChart.getYAxis().mEntries[i6] - this.mChart.getYChartMin()) * factor;
                Utils.getPosition(centerOffsets, yChartMin, (i7 * sliceAngle) + rotationAngle, mPPointF2);
                i7++;
                Utils.getPosition(centerOffsets, yChartMin, (i7 * sliceAngle) + rotationAngle, mPPointF3);
                canvas.drawLine(mPPointF2.f37332x, mPPointF2.f37333y, mPPointF3.f37332x, mPPointF3.f37333y, this.mWebPaint);
            }
        }
        MPPointF.recycleInstance(mPPointF2);
        MPPointF.recycleInstance(mPPointF3);
    }

    public Paint getWebPaint() {
        return this.mWebPaint;
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void initBuffers() {
    }
}
