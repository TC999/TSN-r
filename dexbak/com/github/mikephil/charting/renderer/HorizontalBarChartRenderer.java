package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.buffer.BarBuffer;
import com.github.mikephil.charting.buffer.HorizontalBarBuffer;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.dataprovider.BarDataProvider;
import com.github.mikephil.charting.interfaces.dataprovider.ChartInterface;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import com.tencent.connect.common.Constants;
import java.util.List;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class HorizontalBarChartRenderer extends BarChartRenderer {
    private RectF mBarShadowRectBuffer;

    public HorizontalBarChartRenderer(BarDataProvider barDataProvider, ChartAnimator chartAnimator, ViewPortHandler viewPortHandler) {
        super(barDataProvider, chartAnimator, viewPortHandler);
        this.mBarShadowRectBuffer = new RectF();
        this.mValuePaint.setTextAlign(Paint.Align.LEFT);
    }

    @Override // com.github.mikephil.charting.renderer.BarChartRenderer
    protected void drawDataSet(Canvas canvas, IBarDataSet iBarDataSet, int i) {
        Transformer transformer = this.mChart.getTransformer(iBarDataSet.getAxisDependency());
        this.mBarBorderPaint.setColor(iBarDataSet.getBarBorderColor());
        this.mBarBorderPaint.setStrokeWidth(Utils.convertDpToPixel(iBarDataSet.getBarBorderWidth()));
        boolean z = iBarDataSet.getBarBorderWidth() > 0.0f;
        float phaseX = this.mAnimator.getPhaseX();
        float phaseY = this.mAnimator.getPhaseY();
        if (this.mChart.isDrawBarShadowEnabled()) {
            this.mShadowPaint.setColor(iBarDataSet.getBarShadowColor());
            float barWidth = this.mChart.getBarData().getBarWidth() / 2.0f;
            int min = Math.min((int) Math.ceil(iBarDataSet.getEntryCount() * phaseX), iBarDataSet.getEntryCount());
            for (int i2 = 0; i2 < min; i2++) {
                float x = ((BarEntry) iBarDataSet.getEntryForIndex(i2)).getX();
                RectF rectF = this.mBarShadowRectBuffer;
                rectF.top = x - barWidth;
                rectF.bottom = x + barWidth;
                transformer.rectValueToPixel(rectF);
                if (this.mViewPortHandler.isInBoundsTop(this.mBarShadowRectBuffer.bottom)) {
                    if (!this.mViewPortHandler.isInBoundsBottom(this.mBarShadowRectBuffer.top)) {
                        break;
                    }
                    this.mBarShadowRectBuffer.left = this.mViewPortHandler.contentLeft();
                    this.mBarShadowRectBuffer.right = this.mViewPortHandler.contentRight();
                    canvas.drawRect(this.mBarShadowRectBuffer, this.mShadowPaint);
                }
            }
        }
        BarBuffer barBuffer = this.mBarBuffers[i];
        barBuffer.setPhases(phaseX, phaseY);
        barBuffer.setDataSet(i);
        barBuffer.setInverted(this.mChart.isInverted(iBarDataSet.getAxisDependency()));
        barBuffer.setBarWidth(this.mChart.getBarData().getBarWidth());
        barBuffer.feed(iBarDataSet);
        transformer.pointValuesToPixel(barBuffer.buffer);
        boolean z2 = iBarDataSet.getColors().size() == 1;
        if (z2) {
            this.mRenderPaint.setColor(iBarDataSet.getColor());
        }
        for (int i3 = 0; i3 < barBuffer.size(); i3 += 4) {
            int i4 = i3 + 3;
            if (!this.mViewPortHandler.isInBoundsTop(barBuffer.buffer[i4])) {
                return;
            }
            int i5 = i3 + 1;
            if (this.mViewPortHandler.isInBoundsBottom(barBuffer.buffer[i5])) {
                if (!z2) {
                    this.mRenderPaint.setColor(iBarDataSet.getColor(i3 / 4));
                }
                float[] fArr = barBuffer.buffer;
                int i6 = i3 + 2;
                canvas.drawRect(fArr[i3], fArr[i5], fArr[i6], fArr[i4], this.mRenderPaint);
                if (z) {
                    float[] fArr2 = barBuffer.buffer;
                    canvas.drawRect(fArr2[i3], fArr2[i5], fArr2[i6], fArr2[i4], this.mBarBorderPaint);
                }
            }
        }
    }

    @Override // com.github.mikephil.charting.renderer.BarChartRenderer, com.github.mikephil.charting.renderer.DataRenderer
    public void drawValue(Canvas canvas, String str, float f, float f2, int i) {
        this.mValuePaint.setColor(i);
        canvas.drawText(str, f, f2, this.mValuePaint);
    }

    @Override // com.github.mikephil.charting.renderer.BarChartRenderer, com.github.mikephil.charting.renderer.DataRenderer
    public void drawValues(Canvas canvas) {
        List list;
        int i;
        MPPointF mPPointF;
        int i2;
        float[] fArr;
        float f;
        int i3;
        float[] fArr2;
        float f2;
        float f3;
        BarEntry barEntry;
        int i4;
        List list2;
        float f4;
        MPPointF mPPointF2;
        ValueFormatter valueFormatter;
        int i5;
        BarBuffer barBuffer;
        if (isDrawingValuesAllowed(this.mChart)) {
            List dataSets = this.mChart.getBarData().getDataSets();
            float convertDpToPixel = Utils.convertDpToPixel(5.0f);
            boolean isDrawValueAboveBarEnabled = this.mChart.isDrawValueAboveBarEnabled();
            int i6 = 0;
            while (i6 < this.mChart.getBarData().getDataSetCount()) {
                IBarDataSet iBarDataSet = (IBarDataSet) dataSets.get(i6);
                if (shouldDrawValues(iBarDataSet)) {
                    boolean isInverted = this.mChart.isInverted(iBarDataSet.getAxisDependency());
                    applyValueTextStyle(iBarDataSet);
                    float f5 = 2.0f;
                    float calcTextHeight = Utils.calcTextHeight(this.mValuePaint, Constants.VIA_REPORT_TYPE_SHARE_TO_QQ) / 2.0f;
                    ValueFormatter valueFormatter2 = iBarDataSet.getValueFormatter();
                    BarBuffer barBuffer2 = this.mBarBuffers[i6];
                    float phaseY = this.mAnimator.getPhaseY();
                    MPPointF mPPointF3 = MPPointF.getInstance(iBarDataSet.getIconsOffset());
                    mPPointF3.f23783x = Utils.convertDpToPixel(mPPointF3.f23783x);
                    mPPointF3.f23784y = Utils.convertDpToPixel(mPPointF3.f23784y);
                    if (!iBarDataSet.isStacked()) {
                        int i7 = 0;
                        while (i7 < barBuffer2.buffer.length * this.mAnimator.getPhaseX()) {
                            float[] fArr3 = barBuffer2.buffer;
                            int i8 = i7 + 1;
                            float f6 = (fArr3[i8] + fArr3[i7 + 3]) / f5;
                            if (!this.mViewPortHandler.isInBoundsTop(fArr3[i8])) {
                                break;
                            }
                            if (this.mViewPortHandler.isInBoundsX(barBuffer2.buffer[i7]) && this.mViewPortHandler.isInBoundsBottom(barBuffer2.buffer[i8])) {
                                BarEntry barEntry2 = (BarEntry) iBarDataSet.getEntryForIndex(i7 / 4);
                                float y = barEntry2.getY();
                                String barLabel = valueFormatter2.getBarLabel(barEntry2);
                                float calcTextWidth = Utils.calcTextWidth(this.mValuePaint, barLabel);
                                float f7 = isDrawValueAboveBarEnabled ? convertDpToPixel : -(calcTextWidth + convertDpToPixel);
                                MPPointF mPPointF4 = mPPointF3;
                                float f8 = isDrawValueAboveBarEnabled ? -(calcTextWidth + convertDpToPixel) : convertDpToPixel;
                                if (isInverted) {
                                    f7 = (-f7) - calcTextWidth;
                                    f8 = (-f8) - calcTextWidth;
                                }
                                float f9 = f7;
                                float f10 = f8;
                                if (iBarDataSet.isDrawValuesEnabled()) {
                                    i4 = i7;
                                    list2 = dataSets;
                                    mPPointF2 = mPPointF4;
                                    i5 = i6;
                                    barBuffer = barBuffer2;
                                    f4 = calcTextHeight;
                                    valueFormatter = valueFormatter2;
                                    drawValue(canvas, barLabel, barBuffer2.buffer[i7 + 2] + (y >= 0.0f ? f9 : f10), f6 + calcTextHeight, iBarDataSet.getValueTextColor(i7 / 2));
                                } else {
                                    i4 = i7;
                                    list2 = dataSets;
                                    f4 = calcTextHeight;
                                    mPPointF2 = mPPointF4;
                                    valueFormatter = valueFormatter2;
                                    i5 = i6;
                                    barBuffer = barBuffer2;
                                }
                                if (barEntry2.getIcon() != null && iBarDataSet.isDrawIconsEnabled()) {
                                    Drawable icon = barEntry2.getIcon();
                                    float f11 = barBuffer.buffer[i4 + 2];
                                    if (y < 0.0f) {
                                        f9 = f10;
                                    }
                                    Utils.drawImage(canvas, icon, (int) (f11 + f9 + mPPointF2.f23783x), (int) (f6 + mPPointF2.f23784y), icon.getIntrinsicWidth(), icon.getIntrinsicHeight());
                                }
                            } else {
                                i4 = i7;
                                list2 = dataSets;
                                i5 = i6;
                                f4 = calcTextHeight;
                                mPPointF2 = mPPointF3;
                                barBuffer = barBuffer2;
                                valueFormatter = valueFormatter2;
                            }
                            i7 = i4 + 4;
                            mPPointF3 = mPPointF2;
                            barBuffer2 = barBuffer;
                            valueFormatter2 = valueFormatter;
                            dataSets = list2;
                            i6 = i5;
                            calcTextHeight = f4;
                            f5 = 2.0f;
                        }
                        list = dataSets;
                        i = i6;
                        mPPointF = mPPointF3;
                    } else {
                        list = dataSets;
                        i = i6;
                        mPPointF = mPPointF3;
                        Transformer transformer = this.mChart.getTransformer(iBarDataSet.getAxisDependency());
                        int i9 = 0;
                        int i10 = 0;
                        while (i9 < iBarDataSet.getEntryCount() * this.mAnimator.getPhaseX()) {
                            BarEntry barEntry3 = (BarEntry) iBarDataSet.getEntryForIndex(i9);
                            int valueTextColor = iBarDataSet.getValueTextColor(i9);
                            float[] yVals = barEntry3.getYVals();
                            if (yVals == null) {
                                int i11 = i10 + 1;
                                if (!this.mViewPortHandler.isInBoundsTop(barBuffer2.buffer[i11])) {
                                    break;
                                } else if (this.mViewPortHandler.isInBoundsX(barBuffer2.buffer[i10]) && this.mViewPortHandler.isInBoundsBottom(barBuffer2.buffer[i11])) {
                                    String barLabel2 = valueFormatter2.getBarLabel(barEntry3);
                                    float calcTextWidth2 = Utils.calcTextWidth(this.mValuePaint, barLabel2);
                                    float f12 = isDrawValueAboveBarEnabled ? convertDpToPixel : -(calcTextWidth2 + convertDpToPixel);
                                    float f13 = isDrawValueAboveBarEnabled ? -(calcTextWidth2 + convertDpToPixel) : convertDpToPixel;
                                    if (isInverted) {
                                        f12 = (-f12) - calcTextWidth2;
                                        f13 = (-f13) - calcTextWidth2;
                                    }
                                    float f14 = f12;
                                    float f15 = f13;
                                    if (iBarDataSet.isDrawValuesEnabled()) {
                                        i2 = i9;
                                        fArr = yVals;
                                        barEntry = barEntry3;
                                        drawValue(canvas, barLabel2, barBuffer2.buffer[i10 + 2] + (barEntry3.getY() >= 0.0f ? f14 : f15), barBuffer2.buffer[i11] + calcTextHeight, valueTextColor);
                                    } else {
                                        barEntry = barEntry3;
                                        i2 = i9;
                                        fArr = yVals;
                                    }
                                    if (barEntry.getIcon() != null && iBarDataSet.isDrawIconsEnabled()) {
                                        Drawable icon2 = barEntry.getIcon();
                                        float f16 = barBuffer2.buffer[i10 + 2];
                                        if (barEntry.getY() < 0.0f) {
                                            f14 = f15;
                                        }
                                        Utils.drawImage(canvas, icon2, (int) (f16 + f14 + mPPointF.f23783x), (int) (barBuffer2.buffer[i11] + mPPointF.f23784y), icon2.getIntrinsicWidth(), icon2.getIntrinsicHeight());
                                    }
                                }
                            } else {
                                i2 = i9;
                                fArr = yVals;
                                int length = fArr.length * 2;
                                float[] fArr4 = new float[length];
                                float f17 = -barEntry3.getNegativeSum();
                                int i12 = 0;
                                int i13 = 0;
                                float f18 = 0.0f;
                                while (i12 < length) {
                                    float f19 = fArr[i13];
                                    if (f19 == 0.0f && (f18 == 0.0f || f17 == 0.0f)) {
                                        float f20 = f17;
                                        f17 = f19;
                                        f3 = f20;
                                    } else if (f19 >= 0.0f) {
                                        f18 += f19;
                                        f3 = f17;
                                        f17 = f18;
                                    } else {
                                        f3 = f17 - f19;
                                    }
                                    fArr4[i12] = f17 * phaseY;
                                    i12 += 2;
                                    i13++;
                                    f17 = f3;
                                }
                                transformer.pointValuesToPixel(fArr4);
                                int i14 = 0;
                                while (i14 < length) {
                                    float f21 = fArr[i14 / 2];
                                    String barStackedLabel = valueFormatter2.getBarStackedLabel(f21, barEntry3);
                                    float calcTextWidth3 = Utils.calcTextWidth(this.mValuePaint, barStackedLabel);
                                    float f22 = isDrawValueAboveBarEnabled ? convertDpToPixel : -(calcTextWidth3 + convertDpToPixel);
                                    int i15 = length;
                                    float f23 = isDrawValueAboveBarEnabled ? -(calcTextWidth3 + convertDpToPixel) : convertDpToPixel;
                                    if (isInverted) {
                                        f22 = (-f22) - calcTextWidth3;
                                        f23 = (-f23) - calcTextWidth3;
                                    }
                                    boolean z = (f21 == 0.0f && f17 == 0.0f && f18 > 0.0f) || f21 < 0.0f;
                                    float f24 = fArr4[i14];
                                    if (z) {
                                        f22 = f23;
                                    }
                                    float f25 = f24 + f22;
                                    float[] fArr5 = barBuffer2.buffer;
                                    float f26 = (fArr5[i10 + 1] + fArr5[i10 + 3]) / 2.0f;
                                    if (!this.mViewPortHandler.isInBoundsTop(f26)) {
                                        break;
                                    }
                                    if (this.mViewPortHandler.isInBoundsX(f25) && this.mViewPortHandler.isInBoundsBottom(f26)) {
                                        if (iBarDataSet.isDrawValuesEnabled()) {
                                            f = f26;
                                            i3 = i14;
                                            fArr2 = fArr4;
                                            f2 = f25;
                                            drawValue(canvas, barStackedLabel, f25, f26 + calcTextHeight, valueTextColor);
                                        } else {
                                            f = f26;
                                            i3 = i14;
                                            fArr2 = fArr4;
                                            f2 = f25;
                                        }
                                        if (barEntry3.getIcon() != null && iBarDataSet.isDrawIconsEnabled()) {
                                            Drawable icon3 = barEntry3.getIcon();
                                            Utils.drawImage(canvas, icon3, (int) (f2 + mPPointF.f23783x), (int) (f + mPPointF.f23784y), icon3.getIntrinsicWidth(), icon3.getIntrinsicHeight());
                                        }
                                    } else {
                                        i3 = i14;
                                        fArr2 = fArr4;
                                    }
                                    i14 = i3 + 2;
                                    length = i15;
                                    fArr4 = fArr2;
                                }
                            }
                            i10 = fArr == null ? i10 + 4 : i10 + (fArr.length * 4);
                            i9 = i2 + 1;
                        }
                    }
                    MPPointF.recycleInstance(mPPointF);
                } else {
                    list = dataSets;
                    i = i6;
                }
                i6 = i + 1;
                dataSets = list;
            }
        }
    }

    @Override // com.github.mikephil.charting.renderer.BarChartRenderer, com.github.mikephil.charting.renderer.DataRenderer
    public void initBuffers() {
        BarData barData = this.mChart.getBarData();
        this.mBarBuffers = new HorizontalBarBuffer[barData.getDataSetCount()];
        for (int i = 0; i < this.mBarBuffers.length; i++) {
            IBarDataSet iBarDataSet = (IBarDataSet) barData.getDataSetByIndex(i);
            this.mBarBuffers[i] = new HorizontalBarBuffer(iBarDataSet.getEntryCount() * 4 * (iBarDataSet.isStacked() ? iBarDataSet.getStackSize() : 1), barData.getDataSetCount(), iBarDataSet.isStacked());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public boolean isDrawingValuesAllowed(ChartInterface chartInterface) {
        return ((float) chartInterface.getData().getEntryCount()) < ((float) chartInterface.getMaxVisibleCount()) * this.mViewPortHandler.getScaleY();
    }

    @Override // com.github.mikephil.charting.renderer.BarChartRenderer
    protected void prepareBarHighlight(float f, float f2, float f3, float f4, Transformer transformer) {
        this.mBarRect.set(f2, f - f4, f3, f + f4);
        transformer.rectToPixelPhaseHorizontal(this.mBarRect, this.mAnimator.getPhaseY());
    }

    @Override // com.github.mikephil.charting.renderer.BarChartRenderer
    protected void setHighlightDrawPos(Highlight highlight, RectF rectF) {
        highlight.setDraw(rectF.centerY(), rectF.right);
    }
}
