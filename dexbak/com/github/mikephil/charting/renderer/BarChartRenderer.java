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
import com.tencent.connect.common.Constants;
import java.util.List;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
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
        for (int i = 0; i < barData.getDataSetCount(); i++) {
            IBarDataSet iBarDataSet = (IBarDataSet) barData.getDataSetByIndex(i);
            if (iBarDataSet.isVisible()) {
                drawDataSet(canvas, iBarDataSet, i);
            }
        }
    }

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
                rectF.left = x - barWidth;
                rectF.right = x + barWidth;
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
            int i4 = i3 + 2;
            if (this.mViewPortHandler.isInBoundsLeft(barBuffer.buffer[i4])) {
                if (!this.mViewPortHandler.isInBoundsRight(barBuffer.buffer[i3])) {
                    return;
                }
                if (!z2) {
                    this.mRenderPaint.setColor(iBarDataSet.getColor(i3 / 4));
                }
                if (iBarDataSet.getGradientColor() != null) {
                    GradientColor gradientColor = iBarDataSet.getGradientColor();
                    Paint paint = this.mRenderPaint;
                    float[] fArr = barBuffer.buffer;
                    paint.setShader(new LinearGradient(fArr[i3], fArr[i3 + 3], fArr[i3], fArr[i3 + 1], gradientColor.getStartColor(), gradientColor.getEndColor(), Shader.TileMode.MIRROR));
                }
                if (iBarDataSet.getGradientColors() != null) {
                    Paint paint2 = this.mRenderPaint;
                    float[] fArr2 = barBuffer.buffer;
                    float f = fArr2[i3];
                    float f2 = fArr2[i3 + 3];
                    float f3 = fArr2[i3];
                    float f4 = fArr2[i3 + 1];
                    int i5 = i3 / 4;
                    paint2.setShader(new LinearGradient(f, f2, f3, f4, iBarDataSet.getGradientColor(i5).getStartColor(), iBarDataSet.getGradientColor(i5).getEndColor(), Shader.TileMode.MIRROR));
                }
                float[] fArr3 = barBuffer.buffer;
                int i6 = i3 + 1;
                int i7 = i3 + 3;
                canvas.drawRect(fArr3[i3], fArr3[i6], fArr3[i4], fArr3[i7], this.mRenderPaint);
                if (z) {
                    float[] fArr4 = barBuffer.buffer;
                    canvas.drawRect(fArr4[i3], fArr4[i6], fArr4[i4], fArr4[i7], this.mBarBorderPaint);
                }
            }
        }
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawExtras(Canvas canvas) {
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawHighlighted(Canvas canvas, Highlight[] highlightArr) {
        float y;
        float f;
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
                            f = -barEntry.getNegativeSum();
                            y = positiveSum;
                        } else {
                            Range range = barEntry.getRanges()[highlight.getStackIndex()];
                            y = range.from;
                            f = range.f23772to;
                        }
                    } else {
                        y = barEntry.getY();
                        f = 0.0f;
                    }
                    prepareBarHighlight(barEntry.getX(), y, f, barData.getBarWidth() / 2.0f, transformer);
                    setHighlightDrawPos(highlight, this.mBarRect);
                    canvas.drawRect(this.mBarRect, this.mHighlightPaint);
                }
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
        List list;
        MPPointF mPPointF;
        int i;
        float f;
        boolean z;
        float[] fArr;
        Transformer transformer;
        int i2;
        float f2;
        int i3;
        BarEntry barEntry;
        float[] fArr2;
        float f3;
        float f4;
        float f5;
        BarEntry barEntry2;
        float f6;
        boolean z2;
        int i4;
        ValueFormatter valueFormatter;
        List list2;
        MPPointF mPPointF2;
        BarEntry barEntry3;
        float f7;
        if (isDrawingValuesAllowed(this.mChart)) {
            List dataSets = this.mChart.getBarData().getDataSets();
            float convertDpToPixel = Utils.convertDpToPixel(4.5f);
            boolean isDrawValueAboveBarEnabled = this.mChart.isDrawValueAboveBarEnabled();
            int i5 = 0;
            while (i5 < this.mChart.getBarData().getDataSetCount()) {
                IBarDataSet iBarDataSet = (IBarDataSet) dataSets.get(i5);
                if (shouldDrawValues(iBarDataSet)) {
                    applyValueTextStyle(iBarDataSet);
                    boolean isInverted = this.mChart.isInverted(iBarDataSet.getAxisDependency());
                    float calcTextHeight = Utils.calcTextHeight(this.mValuePaint, Constants.VIA_SHARE_TYPE_PUBLISHVIDEO);
                    float f8 = isDrawValueAboveBarEnabled ? -convertDpToPixel : calcTextHeight + convertDpToPixel;
                    float f9 = isDrawValueAboveBarEnabled ? calcTextHeight + convertDpToPixel : -convertDpToPixel;
                    if (isInverted) {
                        f8 = (-f8) - calcTextHeight;
                        f9 = (-f9) - calcTextHeight;
                    }
                    float f10 = f8;
                    float f11 = f9;
                    BarBuffer barBuffer = this.mBarBuffers[i5];
                    float phaseY = this.mAnimator.getPhaseY();
                    ValueFormatter valueFormatter2 = iBarDataSet.getValueFormatter();
                    MPPointF mPPointF3 = MPPointF.getInstance(iBarDataSet.getIconsOffset());
                    mPPointF3.f23783x = Utils.convertDpToPixel(mPPointF3.f23783x);
                    mPPointF3.f23784y = Utils.convertDpToPixel(mPPointF3.f23784y);
                    if (!iBarDataSet.isStacked()) {
                        int i6 = 0;
                        while (i6 < barBuffer.buffer.length * this.mAnimator.getPhaseX()) {
                            float[] fArr3 = barBuffer.buffer;
                            float f12 = (fArr3[i6] + fArr3[i6 + 2]) / 2.0f;
                            if (!this.mViewPortHandler.isInBoundsRight(f12)) {
                                break;
                            }
                            int i7 = i6 + 1;
                            if (this.mViewPortHandler.isInBoundsY(barBuffer.buffer[i7]) && this.mViewPortHandler.isInBoundsLeft(f12)) {
                                int i8 = i6 / 4;
                                BarEntry barEntry4 = (BarEntry) iBarDataSet.getEntryForIndex(i8);
                                float y = barEntry4.getY();
                                if (iBarDataSet.isDrawValuesEnabled()) {
                                    String barLabel = valueFormatter2.getBarLabel(barEntry4);
                                    int i9 = (y > 0.0f ? 1 : (y == 0.0f ? 0 : -1));
                                    float[] fArr4 = barBuffer.buffer;
                                    barEntry3 = barEntry4;
                                    f7 = f12;
                                    i4 = i6;
                                    list2 = dataSets;
                                    mPPointF2 = mPPointF3;
                                    float f13 = i9 >= 0 ? fArr4[i7] + f10 : fArr4[i6 + 3] + f11;
                                    valueFormatter = valueFormatter2;
                                    drawValue(canvas, barLabel, f7, f13, iBarDataSet.getValueTextColor(i8));
                                } else {
                                    barEntry3 = barEntry4;
                                    f7 = f12;
                                    i4 = i6;
                                    valueFormatter = valueFormatter2;
                                    list2 = dataSets;
                                    mPPointF2 = mPPointF3;
                                }
                                if (barEntry3.getIcon() != null && iBarDataSet.isDrawIconsEnabled()) {
                                    Drawable icon = barEntry3.getIcon();
                                    Utils.drawImage(canvas, icon, (int) (f7 + mPPointF2.f23783x), (int) ((y >= 0.0f ? barBuffer.buffer[i7] + f10 : barBuffer.buffer[i4 + 3] + f11) + mPPointF2.f23784y), icon.getIntrinsicWidth(), icon.getIntrinsicHeight());
                                }
                            } else {
                                i4 = i6;
                                valueFormatter = valueFormatter2;
                                list2 = dataSets;
                                mPPointF2 = mPPointF3;
                            }
                            i6 = i4 + 4;
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
                        int i10 = 0;
                        int i11 = 0;
                        while (i10 < iBarDataSet.getEntryCount() * this.mAnimator.getPhaseX()) {
                            BarEntry barEntry5 = (BarEntry) iBarDataSet.getEntryForIndex(i10);
                            float[] yVals = barEntry5.getYVals();
                            float[] fArr5 = barBuffer.buffer;
                            float f14 = (fArr5[i11] + fArr5[i11 + 2]) / 2.0f;
                            int valueTextColor = iBarDataSet.getValueTextColor(i10);
                            if (yVals == null) {
                                if (!this.mViewPortHandler.isInBoundsRight(f14)) {
                                    break;
                                }
                                int i12 = i11 + 1;
                                if (this.mViewPortHandler.isInBoundsY(barBuffer.buffer[i12]) && this.mViewPortHandler.isInBoundsLeft(f14)) {
                                    if (iBarDataSet.isDrawValuesEnabled()) {
                                        f5 = f14;
                                        f = convertDpToPixel;
                                        fArr = yVals;
                                        barEntry2 = barEntry5;
                                        i = i10;
                                        z = isDrawValueAboveBarEnabled;
                                        transformer = transformer2;
                                        drawValue(canvas, valueFormatter2.getBarLabel(barEntry5), f5, barBuffer.buffer[i12] + (barEntry5.getY() >= 0.0f ? f10 : f11), valueTextColor);
                                    } else {
                                        f5 = f14;
                                        i = i10;
                                        f = convertDpToPixel;
                                        z = isDrawValueAboveBarEnabled;
                                        fArr = yVals;
                                        barEntry2 = barEntry5;
                                        transformer = transformer2;
                                    }
                                    if (barEntry2.getIcon() != null && iBarDataSet.isDrawIconsEnabled()) {
                                        Drawable icon2 = barEntry2.getIcon();
                                        Utils.drawImage(canvas, icon2, (int) (mPPointF.f23783x + f5), (int) (barBuffer.buffer[i12] + (barEntry2.getY() >= 0.0f ? f10 : f11) + mPPointF.f23784y), icon2.getIntrinsicWidth(), icon2.getIntrinsicHeight());
                                    }
                                } else {
                                    transformer2 = transformer2;
                                    isDrawValueAboveBarEnabled = isDrawValueAboveBarEnabled;
                                    convertDpToPixel = convertDpToPixel;
                                    i10 = i10;
                                }
                            } else {
                                BarEntry barEntry6 = barEntry5;
                                i = i10;
                                f = convertDpToPixel;
                                z = isDrawValueAboveBarEnabled;
                                fArr = yVals;
                                transformer = transformer2;
                                float f15 = f14;
                                int length = fArr.length * 2;
                                float[] fArr6 = new float[length];
                                float f16 = -barEntry6.getNegativeSum();
                                int i13 = 0;
                                int i14 = 0;
                                float f17 = 0.0f;
                                while (i13 < length) {
                                    float f18 = fArr[i14];
                                    if (f18 == 0.0f && (f17 == 0.0f || f16 == 0.0f)) {
                                        float f19 = f16;
                                        f16 = f18;
                                        f4 = f19;
                                    } else if (f18 >= 0.0f) {
                                        f17 += f18;
                                        f4 = f16;
                                        f16 = f17;
                                    } else {
                                        f4 = f16 - f18;
                                    }
                                    fArr6[i13 + 1] = f16 * phaseY;
                                    i13 += 2;
                                    i14++;
                                    f16 = f4;
                                }
                                transformer.pointValuesToPixel(fArr6);
                                int i15 = 0;
                                while (i15 < length) {
                                    float f20 = fArr[i15 / 2];
                                    float f21 = fArr6[i15 + 1] + (((f20 > 0.0f ? 1 : (f20 == 0.0f ? 0 : -1)) == 0 && (f16 > 0.0f ? 1 : (f16 == 0.0f ? 0 : -1)) == 0 && (f17 > 0.0f ? 1 : (f17 == 0.0f ? 0 : -1)) > 0) || (f20 > 0.0f ? 1 : (f20 == 0.0f ? 0 : -1)) < 0 ? f11 : f10);
                                    int i16 = i15;
                                    if (!this.mViewPortHandler.isInBoundsRight(f15)) {
                                        break;
                                    }
                                    if (this.mViewPortHandler.isInBoundsY(f21) && this.mViewPortHandler.isInBoundsLeft(f15)) {
                                        if (iBarDataSet.isDrawValuesEnabled()) {
                                            BarEntry barEntry7 = barEntry6;
                                            f3 = f21;
                                            i3 = i16;
                                            barEntry = barEntry7;
                                            fArr2 = fArr6;
                                            i2 = length;
                                            f2 = f15;
                                            drawValue(canvas, valueFormatter2.getBarStackedLabel(f20, barEntry7), f15, f3, valueTextColor);
                                        } else {
                                            f3 = f21;
                                            i2 = length;
                                            f2 = f15;
                                            i3 = i16;
                                            barEntry = barEntry6;
                                            fArr2 = fArr6;
                                        }
                                        if (barEntry.getIcon() != null && iBarDataSet.isDrawIconsEnabled()) {
                                            Drawable icon3 = barEntry.getIcon();
                                            Utils.drawImage(canvas, icon3, (int) (f2 + mPPointF.f23783x), (int) (f3 + mPPointF.f23784y), icon3.getIntrinsicWidth(), icon3.getIntrinsicHeight());
                                        }
                                    } else {
                                        i2 = length;
                                        f2 = f15;
                                        i3 = i16;
                                        barEntry = barEntry6;
                                        fArr2 = fArr6;
                                    }
                                    i15 = i3 + 2;
                                    fArr6 = fArr2;
                                    barEntry6 = barEntry;
                                    length = i2;
                                    f15 = f2;
                                }
                            }
                            i11 = fArr == null ? i11 + 4 : i11 + (fArr.length * 4);
                            i10 = i + 1;
                            transformer2 = transformer;
                            isDrawValueAboveBarEnabled = z;
                            convertDpToPixel = f;
                        }
                    }
                    f6 = convertDpToPixel;
                    z2 = isDrawValueAboveBarEnabled;
                    MPPointF.recycleInstance(mPPointF);
                } else {
                    list = dataSets;
                    f6 = convertDpToPixel;
                    z2 = isDrawValueAboveBarEnabled;
                }
                i5++;
                isDrawValueAboveBarEnabled = z2;
                dataSets = list;
                convertDpToPixel = f6;
            }
        }
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void initBuffers() {
        BarData barData = this.mChart.getBarData();
        this.mBarBuffers = new BarBuffer[barData.getDataSetCount()];
        for (int i = 0; i < this.mBarBuffers.length; i++) {
            IBarDataSet iBarDataSet = (IBarDataSet) barData.getDataSetByIndex(i);
            this.mBarBuffers[i] = new BarBuffer(iBarDataSet.getEntryCount() * 4 * (iBarDataSet.isStacked() ? iBarDataSet.getStackSize() : 1), barData.getDataSetCount(), iBarDataSet.isStacked());
        }
    }

    protected void prepareBarHighlight(float f, float f2, float f3, float f4, Transformer transformer) {
        this.mBarRect.set(f - f4, f2, f + f4, f3);
        transformer.rectToPixelPhase(this.mBarRect, this.mAnimator.getPhaseY());
    }

    protected void setHighlightDrawPos(Highlight highlight, RectF rectF) {
        highlight.setDraw(rectF.centerX(), rectF.top);
    }
}
