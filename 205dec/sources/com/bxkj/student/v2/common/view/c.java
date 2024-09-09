package com.bxkj.student.v2.common.view;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.buffer.BarBuffer;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.highlight.Range;
import com.github.mikephil.charting.interfaces.dataprovider.BarDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.renderer.HorizontalBarChartRenderer;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;

/* compiled from: CustomHorizontalBarChartRenderer.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class c extends HorizontalBarChartRenderer {

    /* renamed from: a  reason: collision with root package name */
    private RectF f23542a;

    public c(BarDataProvider chart, ChartAnimator animator, ViewPortHandler viewPortHandler) {
        super(chart, animator, viewPortHandler);
        this.f23542a = new RectF();
    }

    @Override // com.github.mikephil.charting.renderer.HorizontalBarChartRenderer, com.github.mikephil.charting.renderer.BarChartRenderer
    protected void drawDataSet(Canvas c4, IBarDataSet dataSet, int index) {
        float f4;
        Transformer transformer = this.mChart.getTransformer(dataSet.getAxisDependency());
        this.mBarBorderPaint.setColor(dataSet.getBarBorderColor());
        this.mBarBorderPaint.setStrokeWidth(Utils.convertDpToPixel(dataSet.getBarBorderWidth()));
        boolean z3 = dataSet.getBarBorderWidth() > 0.0f;
        float phaseX = this.mAnimator.getPhaseX();
        float phaseY = this.mAnimator.getPhaseY();
        float f5 = 2.0f;
        if (this.mChart.isDrawBarShadowEnabled()) {
            this.mShadowPaint.setColor(dataSet.getBarShadowColor());
            float barWidth = this.mChart.getBarData().getBarWidth() / 2.0f;
            int min = Math.min((int) Math.ceil(dataSet.getEntryCount() * phaseX), dataSet.getEntryCount());
            int i4 = 0;
            while (i4 < min) {
                float x3 = ((BarEntry) dataSet.getEntryForIndex(i4)).getX();
                RectF rectF = this.f23542a;
                rectF.top = x3 - barWidth;
                rectF.bottom = x3 + barWidth;
                transformer.rectValueToPixel(rectF);
                if (!this.mViewPortHandler.isInBoundsTop(this.f23542a.bottom)) {
                    f4 = barWidth;
                } else if (!this.mViewPortHandler.isInBoundsBottom(this.f23542a.top)) {
                    break;
                } else {
                    this.f23542a.left = this.mViewPortHandler.contentLeft();
                    this.f23542a.right = this.mViewPortHandler.contentRight();
                    RectF rectF2 = this.f23542a;
                    float f6 = (rectF2.bottom - rectF2.top) / f5;
                    RectF rectF3 = this.f23542a;
                    float f7 = rectF3.right;
                    f4 = barWidth;
                    RectF rectF4 = new RectF(f7 - (f6 * f5), rectF3.top, f7, rectF3.bottom);
                    Path path = new Path();
                    path.arcTo(rectF4, -90.0f, 180.0f, true);
                    RectF rectF5 = this.f23542a;
                    if (rectF5.right - rectF5.left < f6) {
                        path.lineTo(rectF4.centerX(), rectF4.bottom);
                        Path path2 = new Path();
                        RectF rectF6 = this.f23542a;
                        path2.addRect(rectF6.left, rectF6.top, rectF6.right, rectF6.bottom, Path.Direction.CW);
                        path.op(path2, Path.Op.INTERSECT);
                    } else {
                        path.moveTo(rectF4.centerX(), rectF4.bottom);
                        RectF rectF7 = this.f23542a;
                        path.lineTo(rectF7.left, rectF7.bottom);
                        RectF rectF8 = this.f23542a;
                        path.lineTo(rectF8.left, rectF8.top);
                        path.lineTo(rectF4.centerX(), this.f23542a.top);
                    }
                    c4.drawPath(path, this.mShadowPaint);
                }
                i4++;
                barWidth = f4;
                f5 = 2.0f;
            }
        }
        BarBuffer barBuffer = this.mBarBuffers[index];
        barBuffer.setPhases(phaseX, phaseY);
        barBuffer.setDataSet(index);
        barBuffer.setInverted(this.mChart.isInverted(dataSet.getAxisDependency()));
        barBuffer.setBarWidth(this.mChart.getBarData().getBarWidth());
        barBuffer.feed(dataSet);
        transformer.pointValuesToPixel(barBuffer.buffer);
        boolean z4 = dataSet.getColors().size() == 1;
        if (z4) {
            this.mRenderPaint.setColor(dataSet.getColor());
        }
        for (int i5 = 0; i5 < barBuffer.size(); i5 += 4) {
            int i6 = i5 + 3;
            if (!this.mViewPortHandler.isInBoundsTop(barBuffer.buffer[i6])) {
                return;
            }
            int i7 = i5 + 1;
            if (this.mViewPortHandler.isInBoundsBottom(barBuffer.buffer[i7])) {
                if (!z4) {
                    this.mRenderPaint.setColor(dataSet.getColor(i5 / 4));
                }
                float[] fArr = barBuffer.buffer;
                float f8 = (fArr[i6] - fArr[i7]) / 2.0f;
                float[] fArr2 = barBuffer.buffer;
                int i8 = i5 + 2;
                RectF rectF9 = new RectF(fArr2[i8] - (f8 * 2.0f), fArr2[i7], fArr2[i8], fArr2[i6]);
                Path path3 = new Path();
                path3.arcTo(rectF9, -90.0f, 180.0f, true);
                float[] fArr3 = barBuffer.buffer;
                if (fArr3[i8] - fArr3[i5] < f8) {
                    path3.lineTo(rectF9.centerX(), rectF9.bottom);
                    Path path4 = new Path();
                    float[] fArr4 = barBuffer.buffer;
                    path4.addRect(fArr4[i5], fArr4[i7], fArr4[i8], fArr4[i6], Path.Direction.CW);
                    path3.op(path4, Path.Op.INTERSECT);
                } else {
                    path3.moveTo(rectF9.centerX(), rectF9.bottom);
                    float[] fArr5 = barBuffer.buffer;
                    path3.lineTo(fArr5[i5], fArr5[i6]);
                    float[] fArr6 = barBuffer.buffer;
                    path3.lineTo(fArr6[i5], fArr6[i7]);
                    path3.lineTo(rectF9.centerX(), barBuffer.buffer[i7]);
                }
                c4.drawPath(path3, this.mRenderPaint);
                if (z3) {
                    c4.drawPath(path3, this.mBarBorderPaint);
                }
            }
        }
    }

    @Override // com.github.mikephil.charting.renderer.BarChartRenderer, com.github.mikephil.charting.renderer.DataRenderer
    public void drawHighlighted(Canvas c4, Highlight[] indices) {
        float y3;
        float f4;
        Highlight[] highlightArr = indices;
        BarData barData = this.mChart.getBarData();
        float barWidth = barData.getBarWidth();
        float f5 = 2.0f;
        float f6 = barWidth / 2.0f;
        int length = highlightArr.length;
        int i4 = 0;
        while (i4 < length) {
            Highlight highlight = highlightArr[i4];
            IBarDataSet iBarDataSet = (IBarDataSet) barData.getDataSetByIndex(highlight.getDataSetIndex());
            if (iBarDataSet != null && iBarDataSet.isHighlightEnabled()) {
                BarEntry barEntry = (BarEntry) iBarDataSet.getEntryForXValue(highlight.getX(), highlight.getY());
                if (isInBoundsX(barEntry, iBarDataSet)) {
                    Transformer transformer = this.mChart.getTransformer(iBarDataSet.getAxisDependency());
                    this.mHighlightPaint.setColor(iBarDataSet.getHighLightColor());
                    this.mHighlightPaint.setAlpha(iBarDataSet.getHighLightAlpha());
                    if (highlight.getStackIndex() >= 0 && barEntry.isStacked()) {
                        if (this.mChart.isHighlightFullBarEnabled()) {
                            y3 = barEntry.getPositiveSum();
                            f4 = -barEntry.getNegativeSum();
                        } else {
                            Range range = barEntry.getRanges()[highlight.getStackIndex()];
                            float f7 = range.from;
                            f4 = range.to;
                            y3 = f7;
                        }
                    } else {
                        y3 = barEntry.getY();
                        f4 = 0.0f;
                    }
                    float x3 = barEntry.getX() - f6;
                    float x4 = barEntry.getX() + f6;
                    RectF rectF = new RectF(y3 - (barWidth * f5), x3, y3, x4);
                    transformer.rectToPixelPhase(rectF, this.mAnimator.getPhaseY());
                    Path path = new Path();
                    path.arcTo(rectF, -90.0f, 180.0f, true);
                    RectF rectF2 = new RectF(f4, x3, y3, x4);
                    transformer.rectToPixelPhase(rectF2, this.mAnimator.getPhaseY());
                    if (y3 - barWidth < 0.0f) {
                        path.lineTo(rectF.centerX(), rectF.bottom);
                        Path path2 = new Path();
                        path2.addRect(rectF2.left, rectF2.top, rectF2.right, rectF2.bottom, Path.Direction.CW);
                        path.op(path2, Path.Op.INTERSECT);
                    } else {
                        path.moveTo(rectF.centerX(), rectF.bottom);
                        path.lineTo(rectF2.left, rectF.bottom);
                        path.lineTo(rectF2.left, rectF.top);
                        path.lineTo(rectF.centerX(), rectF.top);
                    }
                    c4.drawPath(path, this.mHighlightPaint);
                    i4++;
                    highlightArr = indices;
                    f5 = 2.0f;
                }
            }
            i4++;
            highlightArr = indices;
            f5 = 2.0f;
        }
    }
}
