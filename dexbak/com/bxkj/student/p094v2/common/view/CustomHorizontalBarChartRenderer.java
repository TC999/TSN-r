package com.bxkj.student.p094v2.common.view;

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

/* renamed from: com.bxkj.student.v2.common.view.b */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class CustomHorizontalBarChartRenderer extends HorizontalBarChartRenderer {

    /* renamed from: a */
    private RectF f20225a;

    public CustomHorizontalBarChartRenderer(BarDataProvider chart, ChartAnimator animator, ViewPortHandler viewPortHandler) {
        super(chart, animator, viewPortHandler);
        this.f20225a = new RectF();
    }

    @Override // com.github.mikephil.charting.renderer.HorizontalBarChartRenderer, com.github.mikephil.charting.renderer.BarChartRenderer
    protected void drawDataSet(Canvas c, IBarDataSet dataSet, int index) {
        float f;
        Transformer transformer = this.mChart.getTransformer(dataSet.getAxisDependency());
        this.mBarBorderPaint.setColor(dataSet.getBarBorderColor());
        this.mBarBorderPaint.setStrokeWidth(Utils.convertDpToPixel(dataSet.getBarBorderWidth()));
        boolean z = dataSet.getBarBorderWidth() > 0.0f;
        float phaseX = this.mAnimator.getPhaseX();
        float phaseY = this.mAnimator.getPhaseY();
        float f2 = 2.0f;
        if (this.mChart.isDrawBarShadowEnabled()) {
            this.mShadowPaint.setColor(dataSet.getBarShadowColor());
            float barWidth = this.mChart.getBarData().getBarWidth() / 2.0f;
            int min = Math.min((int) Math.ceil(dataSet.getEntryCount() * phaseX), dataSet.getEntryCount());
            int i = 0;
            while (i < min) {
                float x = ((BarEntry) dataSet.getEntryForIndex(i)).getX();
                RectF rectF = this.f20225a;
                rectF.top = x - barWidth;
                rectF.bottom = x + barWidth;
                transformer.rectValueToPixel(rectF);
                if (!this.mViewPortHandler.isInBoundsTop(this.f20225a.bottom)) {
                    f = barWidth;
                } else if (!this.mViewPortHandler.isInBoundsBottom(this.f20225a.top)) {
                    break;
                } else {
                    this.f20225a.left = this.mViewPortHandler.contentLeft();
                    this.f20225a.right = this.mViewPortHandler.contentRight();
                    RectF rectF2 = this.f20225a;
                    float f3 = (rectF2.bottom - rectF2.top) / f2;
                    RectF rectF3 = this.f20225a;
                    float f4 = rectF3.right;
                    f = barWidth;
                    RectF rectF4 = new RectF(f4 - (f3 * f2), rectF3.top, f4, rectF3.bottom);
                    Path path = new Path();
                    path.arcTo(rectF4, -90.0f, 180.0f, true);
                    RectF rectF5 = this.f20225a;
                    if (rectF5.right - rectF5.left < f3) {
                        path.lineTo(rectF4.centerX(), rectF4.bottom);
                        Path path2 = new Path();
                        RectF rectF6 = this.f20225a;
                        path2.addRect(rectF6.left, rectF6.top, rectF6.right, rectF6.bottom, Path.Direction.CW);
                        path.op(path2, Path.Op.INTERSECT);
                    } else {
                        path.moveTo(rectF4.centerX(), rectF4.bottom);
                        RectF rectF7 = this.f20225a;
                        path.lineTo(rectF7.left, rectF7.bottom);
                        RectF rectF8 = this.f20225a;
                        path.lineTo(rectF8.left, rectF8.top);
                        path.lineTo(rectF4.centerX(), this.f20225a.top);
                    }
                    c.drawPath(path, this.mShadowPaint);
                }
                i++;
                barWidth = f;
                f2 = 2.0f;
            }
        }
        BarBuffer barBuffer = this.mBarBuffers[index];
        barBuffer.setPhases(phaseX, phaseY);
        barBuffer.setDataSet(index);
        barBuffer.setInverted(this.mChart.isInverted(dataSet.getAxisDependency()));
        barBuffer.setBarWidth(this.mChart.getBarData().getBarWidth());
        barBuffer.feed(dataSet);
        transformer.pointValuesToPixel(barBuffer.buffer);
        boolean z2 = dataSet.getColors().size() == 1;
        if (z2) {
            this.mRenderPaint.setColor(dataSet.getColor());
        }
        for (int i2 = 0; i2 < barBuffer.size(); i2 += 4) {
            int i3 = i2 + 3;
            if (!this.mViewPortHandler.isInBoundsTop(barBuffer.buffer[i3])) {
                return;
            }
            int i4 = i2 + 1;
            if (this.mViewPortHandler.isInBoundsBottom(barBuffer.buffer[i4])) {
                if (!z2) {
                    this.mRenderPaint.setColor(dataSet.getColor(i2 / 4));
                }
                float[] fArr = barBuffer.buffer;
                float f5 = (fArr[i3] - fArr[i4]) / 2.0f;
                float[] fArr2 = barBuffer.buffer;
                int i5 = i2 + 2;
                RectF rectF9 = new RectF(fArr2[i5] - (f5 * 2.0f), fArr2[i4], fArr2[i5], fArr2[i3]);
                Path path3 = new Path();
                path3.arcTo(rectF9, -90.0f, 180.0f, true);
                float[] fArr3 = barBuffer.buffer;
                if (fArr3[i5] - fArr3[i2] < f5) {
                    path3.lineTo(rectF9.centerX(), rectF9.bottom);
                    Path path4 = new Path();
                    float[] fArr4 = barBuffer.buffer;
                    path4.addRect(fArr4[i2], fArr4[i4], fArr4[i5], fArr4[i3], Path.Direction.CW);
                    path3.op(path4, Path.Op.INTERSECT);
                } else {
                    path3.moveTo(rectF9.centerX(), rectF9.bottom);
                    float[] fArr5 = barBuffer.buffer;
                    path3.lineTo(fArr5[i2], fArr5[i3]);
                    float[] fArr6 = barBuffer.buffer;
                    path3.lineTo(fArr6[i2], fArr6[i4]);
                    path3.lineTo(rectF9.centerX(), barBuffer.buffer[i4]);
                }
                c.drawPath(path3, this.mRenderPaint);
                if (z) {
                    c.drawPath(path3, this.mBarBorderPaint);
                }
            }
        }
    }

    @Override // com.github.mikephil.charting.renderer.BarChartRenderer, com.github.mikephil.charting.renderer.DataRenderer
    public void drawHighlighted(Canvas c, Highlight[] indices) {
        float y;
        float f;
        Highlight[] highlightArr = indices;
        BarData barData = this.mChart.getBarData();
        float barWidth = barData.getBarWidth();
        float f2 = 2.0f;
        float f3 = barWidth / 2.0f;
        int length = highlightArr.length;
        int i = 0;
        while (i < length) {
            Highlight highlight = highlightArr[i];
            IBarDataSet iBarDataSet = (IBarDataSet) barData.getDataSetByIndex(highlight.getDataSetIndex());
            if (iBarDataSet != null && iBarDataSet.isHighlightEnabled()) {
                BarEntry barEntry = (BarEntry) iBarDataSet.getEntryForXValue(highlight.getX(), highlight.getY());
                if (isInBoundsX(barEntry, iBarDataSet)) {
                    Transformer transformer = this.mChart.getTransformer(iBarDataSet.getAxisDependency());
                    this.mHighlightPaint.setColor(iBarDataSet.getHighLightColor());
                    this.mHighlightPaint.setAlpha(iBarDataSet.getHighLightAlpha());
                    if (highlight.getStackIndex() >= 0 && barEntry.isStacked()) {
                        if (this.mChart.isHighlightFullBarEnabled()) {
                            y = barEntry.getPositiveSum();
                            f = -barEntry.getNegativeSum();
                        } else {
                            Range range = barEntry.getRanges()[highlight.getStackIndex()];
                            float f4 = range.from;
                            f = range.f23772to;
                            y = f4;
                        }
                    } else {
                        y = barEntry.getY();
                        f = 0.0f;
                    }
                    float x = barEntry.getX() - f3;
                    float x2 = barEntry.getX() + f3;
                    RectF rectF = new RectF(y - (barWidth * f2), x, y, x2);
                    transformer.rectToPixelPhase(rectF, this.mAnimator.getPhaseY());
                    Path path = new Path();
                    path.arcTo(rectF, -90.0f, 180.0f, true);
                    RectF rectF2 = new RectF(f, x, y, x2);
                    transformer.rectToPixelPhase(rectF2, this.mAnimator.getPhaseY());
                    if (y - barWidth < 0.0f) {
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
                    c.drawPath(path, this.mHighlightPaint);
                    i++;
                    highlightArr = indices;
                    f2 = 2.0f;
                }
            }
            i++;
            highlightArr = indices;
            f2 = 2.0f;
        }
    }
}
