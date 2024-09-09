package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.buffer.BarBuffer;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.highlight.Range;
import com.github.mikephil.charting.interfaces.dataprovider.BarDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.model.GradientColor;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class BarChartRenderer extends BarLineScatterCandleBubbleRenderer {
    protected Paint mBarBorderPaint;
    protected BarBuffer[] mBarBuffers;
    protected RectF mBarRect;
    private RectF mBarShadowRectBuffer;
    protected BarDataProvider mChart;
    protected Paint mShadowPaint;

    public BarChartRenderer(BarDataProvider barDataProvider, ChartAnimator chartAnimator, ViewPortHandler viewPortHandler) {
        super(chartAnimator, viewPortHandler);
        this.mBarRect = new RectF();
        this.mBarShadowRectBuffer = new RectF();
        this.mChart = barDataProvider;
        Paint paint = new Paint(1);
        this.mHighlightPaint = paint;
        paint.setStyle(Paint.Style.FILL);
        this.mHighlightPaint.setColor(Color.rgb(0, 0, 0));
        this.mHighlightPaint.setAlpha(120);
        Paint paint2 = new Paint(1);
        this.mShadowPaint = paint2;
        paint2.setStyle(Paint.Style.FILL);
        Paint paint3 = new Paint(1);
        this.mBarBorderPaint = paint3;
        paint3.setStyle(Paint.Style.STROKE);
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawData(Canvas canvas) {
        BarData barData = this.mChart.getBarData();
        for (int i4 = 0; i4 < barData.getDataSetCount(); i4++) {
            IBarDataSet iBarDataSet = (IBarDataSet) barData.getDataSetByIndex(i4);
            if (iBarDataSet.isVisible()) {
                drawDataSet(canvas, iBarDataSet, i4);
            }
        }
    }

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
                rectF.left = x3 - barWidth;
                rectF.right = x3 + barWidth;
                transformer.rectValueToPixel(rectF);
                if (this.mViewPortHandler.isInBoundsLeft(this.mBarShadowRectBuffer.right)) {
                    if (!this.mViewPortHandler.isInBoundsRight(this.mBarShadowRectBuffer.left)) {
                        break;
                    }
                    this.mBarShadowRectBuffer.top = this.mViewPortHandler.contentTop();
                    this.mBarShadowRectBuffer.bottom = this.mViewPortHandler.contentBottom();
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
            int i7 = i6 + 2;
            if (this.mViewPortHandler.isInBoundsLeft(barBuffer.buffer[i7])) {
                if (!this.mViewPortHandler.isInBoundsRight(barBuffer.buffer[i6])) {
                    return;
                }
                if (!z4) {
                    this.mRenderPaint.setColor(iBarDataSet.getColor(i6 / 4));
                }
                if (iBarDataSet.getGradientColor() != null) {
                    GradientColor gradientColor = iBarDataSet.getGradientColor();
                    Paint paint = this.mRenderPaint;
                    float[] fArr = barBuffer.buffer;
                    paint.setShader(new LinearGradient(fArr[i6], fArr[i6 + 3], fArr[i6], fArr[i6 + 1], gradientColor.getStartColor(), gradientColor.getEndColor(), Shader.TileMode.MIRROR));
                }
                if (iBarDataSet.getGradientColors() != null) {
                    Paint paint2 = this.mRenderPaint;
                    float[] fArr2 = barBuffer.buffer;
                    float f4 = fArr2[i6];
                    float f5 = fArr2[i6 + 3];
                    float f6 = fArr2[i6];
                    float f7 = fArr2[i6 + 1];
                    int i8 = i6 / 4;
                    paint2.setShader(new LinearGradient(f4, f5, f6, f7, iBarDataSet.getGradientColor(i8).getStartColor(), iBarDataSet.getGradientColor(i8).getEndColor(), Shader.TileMode.MIRROR));
                }
                float[] fArr3 = barBuffer.buffer;
                int i9 = i6 + 1;
                int i10 = i6 + 3;
                canvas.drawRect(fArr3[i6], fArr3[i9], fArr3[i7], fArr3[i10], this.mRenderPaint);
                if (z3) {
                    float[] fArr4 = barBuffer.buffer;
                    canvas.drawRect(fArr4[i6], fArr4[i9], fArr4[i7], fArr4[i10], this.mBarBorderPaint);
                }
            }
        }
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawExtras(Canvas canvas) {
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawHighlighted(Canvas canvas, Highlight[] highlightArr) {
        float y3;
        float f4;
        BarData barData = this.mChart.getBarData();
        for (Highlight highlight : highlightArr) {
            IBarDataSet iBarDataSet = (IBarDataSet) barData.getDataSetByIndex(highlight.getDataSetIndex());
            if (iBarDataSet != null && iBarDataSet.isHighlightEnabled()) {
                BarEntry barEntry = (BarEntry) iBarDataSet.getEntryForXValue(highlight.getX(), highlight.getY());
                if (isInBoundsX(barEntry, iBarDataSet)) {
                    Transformer transformer = this.mChart.getTransformer(iBarDataSet.getAxisDependency());
                    this.mHighlightPaint.setColor(iBarDataSet.getHighLightColor());
                    this.mHighlightPaint.setAlpha(iBarDataSet.getHighLightAlpha());
                    if (highlight.getStackIndex() >= 0 && barEntry.isStacked()) {
                        if (this.mChart.isHighlightFullBarEnabled()) {
                            float positiveSum = barEntry.getPositiveSum();
                            f4 = -barEntry.getNegativeSum();
                            y3 = positiveSum;
                        } else {
                            Range range = barEntry.getRanges()[highlight.getStackIndex()];
                            y3 = range.from;
                            f4 = range.to;
                        }
                    } else {
                        y3 = barEntry.getY();
                        f4 = 0.0f;
                    }
                    prepareBarHighlight(barEntry.getX(), y3, f4, barData.getBarWidth() / 2.0f, transformer);
                    setHighlightDrawPos(highlight, this.mBarRect);
                    canvas.drawRect(this.mBarRect, this.mHighlightPaint);
                }
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
        List list;
        MPPointF mPPointF;
        int i4;
        float f4;
        boolean z3;
        float[] fArr;
        Transformer transformer;
        int i5;
        float f5;
        int i6;
        BarEntry barEntry;
        float[] fArr2;
        float f6;
        float f7;
        float f8;
        BarEntry barEntry2;
        float f9;
        boolean z4;
        int i7;
        ValueFormatter valueFormatter;
        List list2;
        MPPointF mPPointF2;
        BarEntry barEntry3;
        float f10;
        if (isDrawingValuesAllowed(this.mChart)) {
            List dataSets = this.mChart.getBarData().getDataSets();
            float convertDpToPixel = Utils.convertDpToPixel(4.5f);
            boolean isDrawValueAboveBarEnabled = this.mChart.isDrawValueAboveBarEnabled();
            int i8 = 0;
            while (i8 < this.mChart.getBarData().getDataSetCount()) {
                IBarDataSet iBarDataSet = (IBarDataSet) dataSets.get(i8);
                if (shouldDrawValues(iBarDataSet)) {
                    applyValueTextStyle(iBarDataSet);
                    boolean isInverted = this.mChart.isInverted(iBarDataSet.getAxisDependency());
                    float calcTextHeight = Utils.calcTextHeight(this.mValuePaint, "8");
                    float f11 = isDrawValueAboveBarEnabled ? -convertDpToPixel : calcTextHeight + convertDpToPixel;
                    float f12 = isDrawValueAboveBarEnabled ? calcTextHeight + convertDpToPixel : -convertDpToPixel;
                    if (isInverted) {
                        f11 = (-f11) - calcTextHeight;
                        f12 = (-f12) - calcTextHeight;
                    }
                    float f13 = f11;
                    float f14 = f12;
                    BarBuffer barBuffer = this.mBarBuffers[i8];
                    float phaseY = this.mAnimator.getPhaseY();
                    ValueFormatter valueFormatter2 = iBarDataSet.getValueFormatter();
                    MPPointF mPPointF3 = MPPointF.getInstance(iBarDataSet.getIconsOffset());
                    mPPointF3.f37332x = Utils.convertDpToPixel(mPPointF3.f37332x);
                    mPPointF3.f37333y = Utils.convertDpToPixel(mPPointF3.f37333y);
                    if (!iBarDataSet.isStacked()) {
                        int i9 = 0;
                        while (i9 < barBuffer.buffer.length * this.mAnimator.getPhaseX()) {
                            float[] fArr3 = barBuffer.buffer;
                            float f15 = (fArr3[i9] + fArr3[i9 + 2]) / 2.0f;
                            if (!this.mViewPortHandler.isInBoundsRight(f15)) {
                                break;
                            }
                            int i10 = i9 + 1;
                            if (this.mViewPortHandler.isInBoundsY(barBuffer.buffer[i10]) && this.mViewPortHandler.isInBoundsLeft(f15)) {
                                int i11 = i9 / 4;
                                BarEntry barEntry4 = (BarEntry) iBarDataSet.getEntryForIndex(i11);
                                float y3 = barEntry4.getY();
                                if (iBarDataSet.isDrawValuesEnabled()) {
                                    String barLabel = valueFormatter2.getBarLabel(barEntry4);
                                    int i12 = (y3 > 0.0f ? 1 : (y3 == 0.0f ? 0 : -1));
                                    float[] fArr4 = barBuffer.buffer;
                                    barEntry3 = barEntry4;
                                    f10 = f15;
                                    i7 = i9;
                                    list2 = dataSets;
                                    mPPointF2 = mPPointF3;
                                    float f16 = i12 >= 0 ? fArr4[i10] + f13 : fArr4[i9 + 3] + f14;
                                    valueFormatter = valueFormatter2;
                                    drawValue(canvas, barLabel, f10, f16, iBarDataSet.getValueTextColor(i11));
                                } else {
                                    barEntry3 = barEntry4;
                                    f10 = f15;
                                    i7 = i9;
                                    valueFormatter = valueFormatter2;
                                    list2 = dataSets;
                                    mPPointF2 = mPPointF3;
                                }
                                if (barEntry3.getIcon() != null && iBarDataSet.isDrawIconsEnabled()) {
                                    Drawable icon = barEntry3.getIcon();
                                    Utils.drawImage(canvas, icon, (int) (f10 + mPPointF2.f37332x), (int) ((y3 >= 0.0f ? barBuffer.buffer[i10] + f13 : barBuffer.buffer[i7 + 3] + f14) + mPPointF2.f37333y), icon.getIntrinsicWidth(), icon.getIntrinsicHeight());
                                }
                            } else {
                                i7 = i9;
                                valueFormatter = valueFormatter2;
                                list2 = dataSets;
                                mPPointF2 = mPPointF3;
                            }
                            i9 = i7 + 4;
                            mPPointF3 = mPPointF2;
                            valueFormatter2 = valueFormatter;
                            dataSets = list2;
                        }
                        list = dataSets;
                        mPPointF = mPPointF3;
                    } else {
                        list = dataSets;
                        mPPointF = mPPointF3;
                        Transformer transformer2 = this.mChart.getTransformer(iBarDataSet.getAxisDependency());
                        int i13 = 0;
                        int i14 = 0;
                        while (i13 < iBarDataSet.getEntryCount() * this.mAnimator.getPhaseX()) {
                            BarEntry barEntry5 = (BarEntry) iBarDataSet.getEntryForIndex(i13);
                            float[] yVals = barEntry5.getYVals();
                            float[] fArr5 = barBuffer.buffer;
                            float f17 = (fArr5[i14] + fArr5[i14 + 2]) / 2.0f;
                            int valueTextColor = iBarDataSet.getValueTextColor(i13);
                            if (yVals == null) {
                                if (!this.mViewPortHandler.isInBoundsRight(f17)) {
                                    break;
                                }
                                int i15 = i14 + 1;
                                if (this.mViewPortHandler.isInBoundsY(barBuffer.buffer[i15]) && this.mViewPortHandler.isInBoundsLeft(f17)) {
                                    if (iBarDataSet.isDrawValuesEnabled()) {
                                        f8 = f17;
                                        f4 = convertDpToPixel;
                                        fArr = yVals;
                                        barEntry2 = barEntry5;
                                        i4 = i13;
                                        z3 = isDrawValueAboveBarEnabled;
                                        transformer = transformer2;
                                        drawValue(canvas, valueFormatter2.getBarLabel(barEntry5), f8, barBuffer.buffer[i15] + (barEntry5.getY() >= 0.0f ? f13 : f14), valueTextColor);
                                    } else {
                                        f8 = f17;
                                        i4 = i13;
                                        f4 = convertDpToPixel;
                                        z3 = isDrawValueAboveBarEnabled;
                                        fArr = yVals;
                                        barEntry2 = barEntry5;
                                        transformer = transformer2;
                                    }
                                    if (barEntry2.getIcon() != null && iBarDataSet.isDrawIconsEnabled()) {
                                        Drawable icon2 = barEntry2.getIcon();
                                        Utils.drawImage(canvas, icon2, (int) (mPPointF.f37332x + f8), (int) (barBuffer.buffer[i15] + (barEntry2.getY() >= 0.0f ? f13 : f14) + mPPointF.f37333y), icon2.getIntrinsicWidth(), icon2.getIntrinsicHeight());
                                    }
                                } else {
                                    transformer2 = transformer2;
                                    isDrawValueAboveBarEnabled = isDrawValueAboveBarEnabled;
                                    convertDpToPixel = convertDpToPixel;
                                    i13 = i13;
                                }
                            } else {
                                BarEntry barEntry6 = barEntry5;
                                i4 = i13;
                                f4 = convertDpToPixel;
                                z3 = isDrawValueAboveBarEnabled;
                                fArr = yVals;
                                transformer = transformer2;
                                float f18 = f17;
                                int length = fArr.length * 2;
                                float[] fArr6 = new float[length];
                                float f19 = -barEntry6.getNegativeSum();
                                int i16 = 0;
                                int i17 = 0;
                                float f20 = 0.0f;
                                while (i16 < length) {
                                    float f21 = fArr[i17];
                                    if (f21 == 0.0f && (f20 == 0.0f || f19 == 0.0f)) {
                                        float f22 = f19;
                                        f19 = f21;
                                        f7 = f22;
                                    } else if (f21 >= 0.0f) {
                                        f20 += f21;
                                        f7 = f19;
                                        f19 = f20;
                                    } else {
                                        f7 = f19 - f21;
                                    }
                                    fArr6[i16 + 1] = f19 * phaseY;
                                    i16 += 2;
                                    i17++;
                                    f19 = f7;
                                }
                                transformer.pointValuesToPixel(fArr6);
                                int i18 = 0;
                                while (i18 < length) {
                                    float f23 = fArr[i18 / 2];
                                    float f24 = fArr6[i18 + 1] + (((f23 > 0.0f ? 1 : (f23 == 0.0f ? 0 : -1)) == 0 && (f19 > 0.0f ? 1 : (f19 == 0.0f ? 0 : -1)) == 0 && (f20 > 0.0f ? 1 : (f20 == 0.0f ? 0 : -1)) > 0) || (f23 > 0.0f ? 1 : (f23 == 0.0f ? 0 : -1)) < 0 ? f14 : f13);
                                    int i19 = i18;
                                    if (!this.mViewPortHandler.isInBoundsRight(f18)) {
                                        break;
                                    }
                                    if (this.mViewPortHandler.isInBoundsY(f24) && this.mViewPortHandler.isInBoundsLeft(f18)) {
                                        if (iBarDataSet.isDrawValuesEnabled()) {
                                            BarEntry barEntry7 = barEntry6;
                                            f6 = f24;
                                            i6 = i19;
                                            barEntry = barEntry7;
                                            fArr2 = fArr6;
                                            i5 = length;
                                            f5 = f18;
                                            drawValue(canvas, valueFormatter2.getBarStackedLabel(f23, barEntry7), f18, f6, valueTextColor);
                                        } else {
                                            f6 = f24;
                                            i5 = length;
                                            f5 = f18;
                                            i6 = i19;
                                            barEntry = barEntry6;
                                            fArr2 = fArr6;
                                        }
                                        if (barEntry.getIcon() != null && iBarDataSet.isDrawIconsEnabled()) {
                                            Drawable icon3 = barEntry.getIcon();
                                            Utils.drawImage(canvas, icon3, (int) (f5 + mPPointF.f37332x), (int) (f6 + mPPointF.f37333y), icon3.getIntrinsicWidth(), icon3.getIntrinsicHeight());
                                        }
                                    } else {
                                        i5 = length;
                                        f5 = f18;
                                        i6 = i19;
                                        barEntry = barEntry6;
                                        fArr2 = fArr6;
                                    }
                                    i18 = i6 + 2;
                                    fArr6 = fArr2;
                                    barEntry6 = barEntry;
                                    length = i5;
                                    f18 = f5;
                                }
                            }
                            i14 = fArr == null ? i14 + 4 : i14 + (fArr.length * 4);
                            i13 = i4 + 1;
                            transformer2 = transformer;
                            isDrawValueAboveBarEnabled = z3;
                            convertDpToPixel = f4;
                        }
                    }
                    f9 = convertDpToPixel;
                    z4 = isDrawValueAboveBarEnabled;
                    MPPointF.recycleInstance(mPPointF);
                } else {
                    list = dataSets;
                    f9 = convertDpToPixel;
                    z4 = isDrawValueAboveBarEnabled;
                }
                i8++;
                isDrawValueAboveBarEnabled = z4;
                dataSets = list;
                convertDpToPixel = f9;
            }
        }
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void initBuffers() {
        BarData barData = this.mChart.getBarData();
        this.mBarBuffers = new BarBuffer[barData.getDataSetCount()];
        for (int i4 = 0; i4 < this.mBarBuffers.length; i4++) {
            IBarDataSet iBarDataSet = (IBarDataSet) barData.getDataSetByIndex(i4);
            this.mBarBuffers[i4] = new BarBuffer(iBarDataSet.getEntryCount() * 4 * (iBarDataSet.isStacked() ? iBarDataSet.getStackSize() : 1), barData.getDataSetCount(), iBarDataSet.isStacked());
        }
    }

    protected void prepareBarHighlight(float f4, float f5, float f6, float f7, Transformer transformer) {
        this.mBarRect.set(f4 - f7, f5, f4 + f7, f6);
        transformer.rectToPixelPhase(this.mBarRect, this.mAnimator.getPhaseY());
    }

    protected void setHighlightDrawPos(Highlight highlight, RectF rectF) {
        highlight.setDraw(rectF.centerX(), rectF.top);
    }
}
