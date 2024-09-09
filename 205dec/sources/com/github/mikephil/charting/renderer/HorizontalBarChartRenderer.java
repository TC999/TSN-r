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
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class HorizontalBarChartRenderer extends BarChartRenderer {
    private RectF mBarShadowRectBuffer;

    public HorizontalBarChartRenderer(BarDataProvider barDataProvider, ChartAnimator chartAnimator, ViewPortHandler viewPortHandler) {
        super(barDataProvider, chartAnimator, viewPortHandler);
        this.mBarShadowRectBuffer = new RectF();
        this.mValuePaint.setTextAlign(Paint.Align.LEFT);
    }

    @Override // com.github.mikephil.charting.renderer.BarChartRenderer
    protected void drawDataSet(Canvas canvas, IBarDataSet iBarDataSet, int i4) {
        Transformer transformer = this.mChart.getTransformer(iBarDataSet.getAxisDependency());
        this.mBarBorderPaint.setColor(iBarDataSet.getBarBorderColor());
        this.mBarBorderPaint.setStrokeWidth(Utils.convertDpToPixel(iBarDataSet.getBarBorderWidth()));
        boolean z3 = iBarDataSet.getBarBorderWidth() > 0.0f;
        float phaseX = this.mAnimator.getPhaseX();
        float phaseY = this.mAnimator.getPhaseY();
        if (this.mChart.isDrawBarShadowEnabled()) {
            this.mShadowPaint.setColor(iBarDataSet.getBarShadowColor());
            float barWidth = this.mChart.getBarData().getBarWidth() / 2.0f;
            int min = Math.min((int) Math.ceil(iBarDataSet.getEntryCount() * phaseX), iBarDataSet.getEntryCount());
            for (int i5 = 0; i5 < min; i5++) {
                float x3 = ((BarEntry) iBarDataSet.getEntryForIndex(i5)).getX();
                RectF rectF = this.mBarShadowRectBuffer;
                rectF.top = x3 - barWidth;
                rectF.bottom = x3 + barWidth;
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
        BarBuffer barBuffer = this.mBarBuffers[i4];
        barBuffer.setPhases(phaseX, phaseY);
        barBuffer.setDataSet(i4);
        barBuffer.setInverted(this.mChart.isInverted(iBarDataSet.getAxisDependency()));
        barBuffer.setBarWidth(this.mChart.getBarData().getBarWidth());
        barBuffer.feed(iBarDataSet);
        transformer.pointValuesToPixel(barBuffer.buffer);
        boolean z4 = iBarDataSet.getColors().size() == 1;
        if (z4) {
            this.mRenderPaint.setColor(iBarDataSet.getColor());
        }
        for (int i6 = 0; i6 < barBuffer.size(); i6 += 4) {
            int i7 = i6 + 3;
            if (!this.mViewPortHandler.isInBoundsTop(barBuffer.buffer[i7])) {
                return;
            }
            int i8 = i6 + 1;
            if (this.mViewPortHandler.isInBoundsBottom(barBuffer.buffer[i8])) {
                if (!z4) {
                    this.mRenderPaint.setColor(iBarDataSet.getColor(i6 / 4));
                }
                float[] fArr = barBuffer.buffer;
                int i9 = i6 + 2;
                canvas.drawRect(fArr[i6], fArr[i8], fArr[i9], fArr[i7], this.mRenderPaint);
                if (z3) {
                    float[] fArr2 = barBuffer.buffer;
                    canvas.drawRect(fArr2[i6], fArr2[i8], fArr2[i9], fArr2[i7], this.mBarBorderPaint);
                }
            }
        }
    }

    @Override // com.github.mikephil.charting.renderer.BarChartRenderer, com.github.mikephil.charting.renderer.DataRenderer
    public void drawValue(Canvas canvas, String str, float f4, float f5, int i4) {
        this.mValuePaint.setColor(i4);
        canvas.drawText(str, f4, f5, this.mValuePaint);
    }

    @Override // com.github.mikephil.charting.renderer.BarChartRenderer, com.github.mikephil.charting.renderer.DataRenderer
    public void drawValues(Canvas canvas) {
        List list;
        int i4;
        MPPointF mPPointF;
        int i5;
        float[] fArr;
        float f4;
        int i6;
        float[] fArr2;
        float f5;
        float f6;
        BarEntry barEntry;
        int i7;
        List list2;
        float f7;
        MPPointF mPPointF2;
        ValueFormatter valueFormatter;
        int i8;
        BarBuffer barBuffer;
        if (isDrawingValuesAllowed(this.mChart)) {
            List dataSets = this.mChart.getBarData().getDataSets();
            float convertDpToPixel = Utils.convertDpToPixel(5.0f);
            boolean isDrawValueAboveBarEnabled = this.mChart.isDrawValueAboveBarEnabled();
            int i9 = 0;
            while (i9 < this.mChart.getBarData().getDataSetCount()) {
                IBarDataSet iBarDataSet = (IBarDataSet) dataSets.get(i9);
                if (shouldDrawValues(iBarDataSet)) {
                    boolean isInverted = this.mChart.isInverted(iBarDataSet.getAxisDependency());
                    applyValueTextStyle(iBarDataSet);
                    float f8 = 2.0f;
                    float calcTextHeight = Utils.calcTextHeight(this.mValuePaint, "10") / 2.0f;
                    ValueFormatter valueFormatter2 = iBarDataSet.getValueFormatter();
                    BarBuffer barBuffer2 = this.mBarBuffers[i9];
                    float phaseY = this.mAnimator.getPhaseY();
                    MPPointF mPPointF3 = MPPointF.getInstance(iBarDataSet.getIconsOffset());
                    mPPointF3.f37332x = Utils.convertDpToPixel(mPPointF3.f37332x);
                    mPPointF3.f37333y = Utils.convertDpToPixel(mPPointF3.f37333y);
                    if (!iBarDataSet.isStacked()) {
                        int i10 = 0;
                        while (i10 < barBuffer2.buffer.length * this.mAnimator.getPhaseX()) {
                            float[] fArr3 = barBuffer2.buffer;
                            int i11 = i10 + 1;
                            float f9 = (fArr3[i11] + fArr3[i10 + 3]) / f8;
                            if (!this.mViewPortHandler.isInBoundsTop(fArr3[i11])) {
                                break;
                            }
                            if (this.mViewPortHandler.isInBoundsX(barBuffer2.buffer[i10]) && this.mViewPortHandler.isInBoundsBottom(barBuffer2.buffer[i11])) {
                                BarEntry barEntry2 = (BarEntry) iBarDataSet.getEntryForIndex(i10 / 4);
                                float y3 = barEntry2.getY();
                                String barLabel = valueFormatter2.getBarLabel(barEntry2);
                                float calcTextWidth = Utils.calcTextWidth(this.mValuePaint, barLabel);
                                float f10 = isDrawValueAboveBarEnabled ? convertDpToPixel : -(calcTextWidth + convertDpToPixel);
                                MPPointF mPPointF4 = mPPointF3;
                                float f11 = isDrawValueAboveBarEnabled ? -(calcTextWidth + convertDpToPixel) : convertDpToPixel;
                                if (isInverted) {
                                    f10 = (-f10) - calcTextWidth;
                                    f11 = (-f11) - calcTextWidth;
                                }
                                float f12 = f10;
                                float f13 = f11;
                                if (iBarDataSet.isDrawValuesEnabled()) {
                                    i7 = i10;
                                    list2 = dataSets;
                                    mPPointF2 = mPPointF4;
                                    i8 = i9;
                                    barBuffer = barBuffer2;
                                    f7 = calcTextHeight;
                                    valueFormatter = valueFormatter2;
                                    drawValue(canvas, barLabel, barBuffer2.buffer[i10 + 2] + (y3 >= 0.0f ? f12 : f13), f9 + calcTextHeight, iBarDataSet.getValueTextColor(i10 / 2));
                                } else {
                                    i7 = i10;
                                    list2 = dataSets;
                                    f7 = calcTextHeight;
                                    mPPointF2 = mPPointF4;
                                    valueFormatter = valueFormatter2;
                                    i8 = i9;
                                    barBuffer = barBuffer2;
                                }
                                if (barEntry2.getIcon() != null && iBarDataSet.isDrawIconsEnabled()) {
                                    Drawable icon = barEntry2.getIcon();
                                    float f14 = barBuffer.buffer[i7 + 2];
                                    if (y3 < 0.0f) {
                                        f12 = f13;
                                    }
                                    Utils.drawImage(canvas, icon, (int) (f14 + f12 + mPPointF2.f37332x), (int) (f9 + mPPointF2.f37333y), icon.getIntrinsicWidth(), icon.getIntrinsicHeight());
                                }
                            } else {
                                i7 = i10;
                                list2 = dataSets;
                                i8 = i9;
                                f7 = calcTextHeight;
                                mPPointF2 = mPPointF3;
                                barBuffer = barBuffer2;
                                valueFormatter = valueFormatter2;
                            }
                            i10 = i7 + 4;
                            mPPointF3 = mPPointF2;
                            barBuffer2 = barBuffer;
                            valueFormatter2 = valueFormatter;
                            dataSets = list2;
                            i9 = i8;
                            calcTextHeight = f7;
                            f8 = 2.0f;
                        }
                        list = dataSets;
                        i4 = i9;
                        mPPointF = mPPointF3;
                    } else {
                        list = dataSets;
                        i4 = i9;
                        mPPointF = mPPointF3;
                        Transformer transformer = this.mChart.getTransformer(iBarDataSet.getAxisDependency());
                        int i12 = 0;
                        int i13 = 0;
                        while (i12 < iBarDataSet.getEntryCount() * this.mAnimator.getPhaseX()) {
                            BarEntry barEntry3 = (BarEntry) iBarDataSet.getEntryForIndex(i12);
                            int valueTextColor = iBarDataSet.getValueTextColor(i12);
                            float[] yVals = barEntry3.getYVals();
                            if (yVals == null) {
                                int i14 = i13 + 1;
                                if (!this.mViewPortHandler.isInBoundsTop(barBuffer2.buffer[i14])) {
                                    break;
                                } else if (this.mViewPortHandler.isInBoundsX(barBuffer2.buffer[i13]) && this.mViewPortHandler.isInBoundsBottom(barBuffer2.buffer[i14])) {
                                    String barLabel2 = valueFormatter2.getBarLabel(barEntry3);
                                    float calcTextWidth2 = Utils.calcTextWidth(this.mValuePaint, barLabel2);
                                    float f15 = isDrawValueAboveBarEnabled ? convertDpToPixel : -(calcTextWidth2 + convertDpToPixel);
                                    float f16 = isDrawValueAboveBarEnabled ? -(calcTextWidth2 + convertDpToPixel) : convertDpToPixel;
                                    if (isInverted) {
                                        f15 = (-f15) - calcTextWidth2;
                                        f16 = (-f16) - calcTextWidth2;
                                    }
                                    float f17 = f15;
                                    float f18 = f16;
                                    if (iBarDataSet.isDrawValuesEnabled()) {
                                        i5 = i12;
                                        fArr = yVals;
                                        barEntry = barEntry3;
                                        drawValue(canvas, barLabel2, barBuffer2.buffer[i13 + 2] + (barEntry3.getY() >= 0.0f ? f17 : f18), barBuffer2.buffer[i14] + calcTextHeight, valueTextColor);
                                    } else {
                                        barEntry = barEntry3;
                                        i5 = i12;
                                        fArr = yVals;
                                    }
                                    if (barEntry.getIcon() != null && iBarDataSet.isDrawIconsEnabled()) {
                                        Drawable icon2 = barEntry.getIcon();
                                        float f19 = barBuffer2.buffer[i13 + 2];
                                        if (barEntry.getY() < 0.0f) {
                                            f17 = f18;
                                        }
                                        Utils.drawImage(canvas, icon2, (int) (f19 + f17 + mPPointF.f37332x), (int) (barBuffer2.buffer[i14] + mPPointF.f37333y), icon2.getIntrinsicWidth(), icon2.getIntrinsicHeight());
                                    }
                                }
                            } else {
                                i5 = i12;
                                fArr = yVals;
                                int length = fArr.length * 2;
                                float[] fArr4 = new float[length];
                                float f20 = -barEntry3.getNegativeSum();
                                int i15 = 0;
                                int i16 = 0;
                                float f21 = 0.0f;
                                while (i15 < length) {
                                    float f22 = fArr[i16];
                                    if (f22 == 0.0f && (f21 == 0.0f || f20 == 0.0f)) {
                                        float f23 = f20;
                                        f20 = f22;
                                        f6 = f23;
                                    } else if (f22 >= 0.0f) {
                                        f21 += f22;
                                        f6 = f20;
                                        f20 = f21;
                                    } else {
                                        f6 = f20 - f22;
                                    }
                                    fArr4[i15] = f20 * phaseY;
                                    i15 += 2;
                                    i16++;
                                    f20 = f6;
                                }
                                transformer.pointValuesToPixel(fArr4);
                                int i17 = 0;
                                while (i17 < length) {
                                    float f24 = fArr[i17 / 2];
                                    String barStackedLabel = valueFormatter2.getBarStackedLabel(f24, barEntry3);
                                    float calcTextWidth3 = Utils.calcTextWidth(this.mValuePaint, barStackedLabel);
                                    float f25 = isDrawValueAboveBarEnabled ? convertDpToPixel : -(calcTextWidth3 + convertDpToPixel);
                                    int i18 = length;
                                    float f26 = isDrawValueAboveBarEnabled ? -(calcTextWidth3 + convertDpToPixel) : convertDpToPixel;
                                    if (isInverted) {
                                        f25 = (-f25) - calcTextWidth3;
                                        f26 = (-f26) - calcTextWidth3;
                                    }
                                    boolean z3 = (f24 == 0.0f && f20 == 0.0f && f21 > 0.0f) || f24 < 0.0f;
                                    float f27 = fArr4[i17];
                                    if (z3) {
                                        f25 = f26;
                                    }
                                    float f28 = f27 + f25;
                                    float[] fArr5 = barBuffer2.buffer;
                                    float f29 = (fArr5[i13 + 1] + fArr5[i13 + 3]) / 2.0f;
                                    if (!this.mViewPortHandler.isInBoundsTop(f29)) {
                                        break;
                                    }
                                    if (this.mViewPortHandler.isInBoundsX(f28) && this.mViewPortHandler.isInBoundsBottom(f29)) {
                                        if (iBarDataSet.isDrawValuesEnabled()) {
                                            f4 = f29;
                                            i6 = i17;
                                            fArr2 = fArr4;
                                            f5 = f28;
                                            drawValue(canvas, barStackedLabel, f28, f29 + calcTextHeight, valueTextColor);
                                        } else {
                                            f4 = f29;
                                            i6 = i17;
                                            fArr2 = fArr4;
                                            f5 = f28;
                                        }
                                        if (barEntry3.getIcon() != null && iBarDataSet.isDrawIconsEnabled()) {
                                            Drawable icon3 = barEntry3.getIcon();
                                            Utils.drawImage(canvas, icon3, (int) (f5 + mPPointF.f37332x), (int) (f4 + mPPointF.f37333y), icon3.getIntrinsicWidth(), icon3.getIntrinsicHeight());
                                        }
                                    } else {
                                        i6 = i17;
                                        fArr2 = fArr4;
                                    }
                                    i17 = i6 + 2;
                                    length = i18;
                                    fArr4 = fArr2;
                                }
                            }
                            i13 = fArr == null ? i13 + 4 : i13 + (fArr.length * 4);
                            i12 = i5 + 1;
                        }
                    }
                    MPPointF.recycleInstance(mPPointF);
                } else {
                    list = dataSets;
                    i4 = i9;
                }
                i9 = i4 + 1;
                dataSets = list;
            }
        }
    }

    @Override // com.github.mikephil.charting.renderer.BarChartRenderer, com.github.mikephil.charting.renderer.DataRenderer
    public void initBuffers() {
        BarData barData = this.mChart.getBarData();
        this.mBarBuffers = new HorizontalBarBuffer[barData.getDataSetCount()];
        for (int i4 = 0; i4 < this.mBarBuffers.length; i4++) {
            IBarDataSet iBarDataSet = (IBarDataSet) barData.getDataSetByIndex(i4);
            this.mBarBuffers[i4] = new HorizontalBarBuffer(iBarDataSet.getEntryCount() * 4 * (iBarDataSet.isStacked() ? iBarDataSet.getStackSize() : 1), barData.getDataSetCount(), iBarDataSet.isStacked());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public boolean isDrawingValuesAllowed(ChartInterface chartInterface) {
        return ((float) chartInterface.getData().getEntryCount()) < ((float) chartInterface.getMaxVisibleCount()) * this.mViewPortHandler.getScaleY();
    }

    @Override // com.github.mikephil.charting.renderer.BarChartRenderer
    protected void prepareBarHighlight(float f4, float f5, float f6, float f7, Transformer transformer) {
        this.mBarRect.set(f5, f4 - f7, f6, f4 + f7);
        transformer.rectToPixelPhaseHorizontal(this.mBarRect, this.mAnimator.getPhaseY());
    }

    @Override // com.github.mikephil.charting.renderer.BarChartRenderer
    protected void setHighlightDrawPos(Highlight highlight, RectF rectF) {
        highlight.setDraw(rectF.centerY(), rectF.right);
    }
}
