package com.bxkj.student.p094v2.common.view;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
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
import com.github.mikephil.charting.renderer.BarLineScatterCandleBubbleRenderer;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import com.tencent.connect.common.Constants;
import java.util.List;

/* renamed from: com.bxkj.student.v2.common.view.a */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class CustomBarChartRenderer extends BarLineScatterCandleBubbleRenderer {

    /* renamed from: a */
    protected BarDataProvider f20219a;

    /* renamed from: b */
    protected RectF f20220b;

    /* renamed from: c */
    protected BarBuffer[] f20221c;

    /* renamed from: d */
    protected Paint f20222d;

    /* renamed from: e */
    protected Paint f20223e;

    /* renamed from: f */
    private RectF f20224f;

    public CustomBarChartRenderer(BarDataProvider chart, ChartAnimator animator, ViewPortHandler viewPortHandler) {
        super(animator, viewPortHandler);
        this.f20220b = new RectF();
        this.f20224f = new RectF();
        this.f20219a = chart;
        Paint paint = new Paint(1);
        this.mHighlightPaint = paint;
        paint.setStyle(Paint.Style.FILL);
        this.mHighlightPaint.setColor(Color.rgb(0, 0, 0));
        this.mHighlightPaint.setAlpha(120);
        Paint paint2 = new Paint(1);
        this.f20222d = paint2;
        paint2.setStyle(Paint.Style.FILL);
        Paint paint3 = new Paint(1);
        this.f20223e = paint3;
        paint3.setStyle(Paint.Style.STROKE);
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawData(Canvas c) {
        BarData barData = this.f20219a.getBarData();
        for (int i = 0; i < barData.getDataSetCount(); i++) {
            IBarDataSet iBarDataSet = (IBarDataSet) barData.getDataSetByIndex(i);
            if (iBarDataSet.isVisible()) {
                drawDataSet(c, iBarDataSet, i);
            }
        }
    }

    protected void drawDataSet(Canvas c, IBarDataSet dataSet, int index) {
        Transformer transformer = this.f20219a.getTransformer(dataSet.getAxisDependency());
        this.f20223e.setColor(dataSet.getBarBorderColor());
        this.f20223e.setStrokeWidth(Utils.convertDpToPixel(dataSet.getBarBorderWidth()));
        boolean z = dataSet.getBarBorderWidth() > 0.0f;
        float phaseX = this.mAnimator.getPhaseX();
        float phaseY = this.mAnimator.getPhaseY();
        if (this.f20219a.isDrawBarShadowEnabled()) {
            this.f20222d.setColor(dataSet.getBarShadowColor());
            float barWidth = this.f20219a.getBarData().getBarWidth() / 2.0f;
            int min = Math.min((int) Math.ceil(dataSet.getEntryCount() * phaseX), dataSet.getEntryCount());
            for (int i = 0; i < min; i++) {
                float x = ((BarEntry) dataSet.getEntryForIndex(i)).getX();
                RectF rectF = this.f20224f;
                rectF.left = x - barWidth;
                rectF.right = x + barWidth;
                transformer.rectValueToPixel(rectF);
                if (this.mViewPortHandler.isInBoundsLeft(this.f20224f.right)) {
                    if (!this.mViewPortHandler.isInBoundsRight(this.f20224f.left)) {
                        break;
                    }
                    this.f20224f.top = this.mViewPortHandler.contentTop();
                    this.f20224f.bottom = this.mViewPortHandler.contentBottom();
                    c.drawRect(this.f20224f, this.f20222d);
                }
            }
        }
        BarBuffer barBuffer = this.f20221c[index];
        barBuffer.setPhases(phaseX, phaseY);
        barBuffer.setDataSet(index);
        barBuffer.setInverted(this.f20219a.isInverted(dataSet.getAxisDependency()));
        barBuffer.setBarWidth(this.f20219a.getBarData().getBarWidth());
        barBuffer.feed(dataSet);
        transformer.pointValuesToPixel(barBuffer.buffer);
        boolean z2 = dataSet.getColors().size() == 1;
        if (z2) {
            this.mRenderPaint.setColor(dataSet.getColor());
        }
        for (int i2 = 0; i2 < barBuffer.size(); i2 += 4) {
            int i3 = i2 + 2;
            if (this.mViewPortHandler.isInBoundsLeft(barBuffer.buffer[i3])) {
                if (!this.mViewPortHandler.isInBoundsRight(barBuffer.buffer[i2])) {
                    return;
                }
                if (!z2) {
                    this.mRenderPaint.setColor(dataSet.getColor(i2 / 4));
                }
                if (dataSet.getGradientColor() != null) {
                    GradientColor gradientColor = dataSet.getGradientColor();
                    Paint paint = this.mRenderPaint;
                    float[] fArr = barBuffer.buffer;
                    paint.setShader(new LinearGradient(fArr[i2], fArr[i2 + 3], fArr[i2], fArr[i2 + 1], gradientColor.getStartColor(), gradientColor.getEndColor(), Shader.TileMode.MIRROR));
                }
                if (dataSet.getGradientColors() != null) {
                    Paint paint2 = this.mRenderPaint;
                    float[] fArr2 = barBuffer.buffer;
                    float f = fArr2[i2];
                    float f2 = fArr2[i2 + 3];
                    float f3 = fArr2[i2];
                    float f4 = fArr2[i2 + 1];
                    int i4 = i2 / 4;
                    paint2.setShader(new LinearGradient(f, f2, f3, f4, dataSet.getGradientColor(i4).getStartColor(), dataSet.getGradientColor(i4).getEndColor(), Shader.TileMode.MIRROR));
                }
                float[] fArr3 = barBuffer.buffer;
                int i5 = i2 + 1;
                int i6 = i2 + 3;
                RectF rectF2 = new RectF(fArr3[i2], fArr3[i5], fArr3[i3], fArr3[i6]);
                new Path();
                c.drawRoundRect(rectF2, 20.0f, 20.0f, this.mRenderPaint);
                if (z) {
                    float[] fArr4 = barBuffer.buffer;
                    c.drawRect(fArr4[i2], fArr4[i5], fArr4[i3], fArr4[i6], this.f20223e);
                }
            }
        }
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawExtras(Canvas c) {
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawHighlighted(Canvas c, Highlight[] indices) {
        float y;
        float f;
        BarData barData = this.f20219a.getBarData();
        for (Highlight highlight : indices) {
            IBarDataSet iBarDataSet = (IBarDataSet) barData.getDataSetByIndex(highlight.getDataSetIndex());
            if (iBarDataSet != null && iBarDataSet.isHighlightEnabled()) {
                BarEntry barEntry = (BarEntry) iBarDataSet.getEntryForXValue(highlight.getX(), highlight.getY());
                if (isInBoundsX(barEntry, iBarDataSet)) {
                    Transformer transformer = this.f20219a.getTransformer(iBarDataSet.getAxisDependency());
                    this.mHighlightPaint.setColor(iBarDataSet.getHighLightColor());
                    this.mHighlightPaint.setAlpha(iBarDataSet.getHighLightAlpha());
                    if (highlight.getStackIndex() >= 0 && barEntry.isStacked()) {
                        if (this.f20219a.isHighlightFullBarEnabled()) {
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
                    setHighlightDrawPos(highlight, this.f20220b);
                    c.drawRect(this.f20220b, this.mHighlightPaint);
                }
            }
        }
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawValue(Canvas c, String valueText, float x, float y, int color) {
        this.mValuePaint.setColor(color);
        c.drawText(valueText, x, y, this.mValuePaint);
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawValues(Canvas c) {
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
        float f8;
        float f9;
        if (isDrawingValuesAllowed(this.f20219a)) {
            List dataSets = this.f20219a.getBarData().getDataSets();
            float convertDpToPixel = Utils.convertDpToPixel(4.5f);
            boolean isDrawValueAboveBarEnabled = this.f20219a.isDrawValueAboveBarEnabled();
            int i5 = 0;
            while (i5 < this.f20219a.getBarData().getDataSetCount()) {
                IBarDataSet iBarDataSet = (IBarDataSet) dataSets.get(i5);
                if (shouldDrawValues(iBarDataSet)) {
                    applyValueTextStyle(iBarDataSet);
                    boolean isInverted = this.f20219a.isInverted(iBarDataSet.getAxisDependency());
                    float calcTextHeight = Utils.calcTextHeight(this.mValuePaint, Constants.VIA_SHARE_TYPE_PUBLISHVIDEO);
                    float f10 = isDrawValueAboveBarEnabled ? -convertDpToPixel : calcTextHeight + convertDpToPixel;
                    float f11 = isDrawValueAboveBarEnabled ? calcTextHeight + convertDpToPixel : -convertDpToPixel;
                    if (isInverted) {
                        f10 = (-f10) - calcTextHeight;
                        f11 = (-f11) - calcTextHeight;
                    }
                    float f12 = f10;
                    float f13 = f11;
                    BarBuffer barBuffer = this.f20221c[i5];
                    float phaseY = this.mAnimator.getPhaseY();
                    ValueFormatter valueFormatter2 = iBarDataSet.getValueFormatter();
                    MPPointF mPPointF3 = MPPointF.getInstance(iBarDataSet.getIconsOffset());
                    mPPointF3.f23783x = Utils.convertDpToPixel(mPPointF3.f23783x);
                    mPPointF3.f23784y = Utils.convertDpToPixel(mPPointF3.f23784y);
                    if (!iBarDataSet.isStacked()) {
                        int i6 = 0;
                        while (i6 < barBuffer.buffer.length * this.mAnimator.getPhaseX()) {
                            float[] fArr3 = barBuffer.buffer;
                            float f14 = (fArr3[i6] + fArr3[i6 + 2]) / 2.0f;
                            if (!this.mViewPortHandler.isInBoundsRight(f14)) {
                                break;
                            }
                            int i7 = i6 + 1;
                            if (this.mViewPortHandler.isInBoundsY(barBuffer.buffer[i7]) && this.mViewPortHandler.isInBoundsLeft(f14)) {
                                int i8 = i6 / 4;
                                BarEntry barEntry4 = (BarEntry) iBarDataSet.getEntryForIndex(i8);
                                float y = barEntry4.getY();
                                if (iBarDataSet.isDrawValuesEnabled()) {
                                    String barLabel = valueFormatter2.getBarLabel(barEntry4);
                                    if (y >= 0.0f) {
                                        f9 = barBuffer.buffer[i7] + f12;
                                    } else {
                                        f9 = barBuffer.buffer[i6 + 3] + f13;
                                    }
                                    barEntry3 = barEntry4;
                                    f7 = f14;
                                    i4 = i6;
                                    list2 = dataSets;
                                    mPPointF2 = mPPointF3;
                                    float f15 = f9;
                                    valueFormatter = valueFormatter2;
                                    drawValue(c, barLabel, f7, f15, iBarDataSet.getValueTextColor(i8));
                                } else {
                                    barEntry3 = barEntry4;
                                    f7 = f14;
                                    i4 = i6;
                                    valueFormatter = valueFormatter2;
                                    list2 = dataSets;
                                    mPPointF2 = mPPointF3;
                                }
                                if (barEntry3.getIcon() != null && iBarDataSet.isDrawIconsEnabled()) {
                                    Drawable icon = barEntry3.getIcon();
                                    if (y >= 0.0f) {
                                        f8 = barBuffer.buffer[i7] + f12;
                                    } else {
                                        f8 = barBuffer.buffer[i4 + 3] + f13;
                                    }
                                    Utils.drawImage(c, icon, (int) (f7 + mPPointF2.f23783x), (int) (f8 + mPPointF2.f23784y), icon.getIntrinsicWidth(), icon.getIntrinsicHeight());
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
                        Transformer transformer2 = this.f20219a.getTransformer(iBarDataSet.getAxisDependency());
                        int i9 = 0;
                        int i10 = 0;
                        while (i9 < iBarDataSet.getEntryCount() * this.mAnimator.getPhaseX()) {
                            BarEntry barEntry5 = (BarEntry) iBarDataSet.getEntryForIndex(i9);
                            float[] yVals = barEntry5.getYVals();
                            float[] fArr4 = barBuffer.buffer;
                            float f16 = (fArr4[i10] + fArr4[i10 + 2]) / 2.0f;
                            int valueTextColor = iBarDataSet.getValueTextColor(i9);
                            if (yVals == null) {
                                if (!this.mViewPortHandler.isInBoundsRight(f16)) {
                                    break;
                                }
                                int i11 = i10 + 1;
                                if (this.mViewPortHandler.isInBoundsY(barBuffer.buffer[i11]) && this.mViewPortHandler.isInBoundsLeft(f16)) {
                                    if (iBarDataSet.isDrawValuesEnabled()) {
                                        f5 = f16;
                                        f = convertDpToPixel;
                                        fArr = yVals;
                                        barEntry2 = barEntry5;
                                        i = i9;
                                        z = isDrawValueAboveBarEnabled;
                                        transformer = transformer2;
                                        drawValue(c, valueFormatter2.getBarLabel(barEntry5), f5, barBuffer.buffer[i11] + (barEntry5.getY() >= 0.0f ? f12 : f13), valueTextColor);
                                    } else {
                                        f5 = f16;
                                        i = i9;
                                        f = convertDpToPixel;
                                        z = isDrawValueAboveBarEnabled;
                                        fArr = yVals;
                                        barEntry2 = barEntry5;
                                        transformer = transformer2;
                                    }
                                    if (barEntry2.getIcon() != null && iBarDataSet.isDrawIconsEnabled()) {
                                        Drawable icon2 = barEntry2.getIcon();
                                        Utils.drawImage(c, icon2, (int) (mPPointF.f23783x + f5), (int) (barBuffer.buffer[i11] + (barEntry2.getY() >= 0.0f ? f12 : f13) + mPPointF.f23784y), icon2.getIntrinsicWidth(), icon2.getIntrinsicHeight());
                                    }
                                } else {
                                    transformer2 = transformer2;
                                    isDrawValueAboveBarEnabled = isDrawValueAboveBarEnabled;
                                    convertDpToPixel = convertDpToPixel;
                                    i9 = i9;
                                }
                            } else {
                                BarEntry barEntry6 = barEntry5;
                                i = i9;
                                f = convertDpToPixel;
                                z = isDrawValueAboveBarEnabled;
                                fArr = yVals;
                                transformer = transformer2;
                                float f17 = f16;
                                int length = fArr.length * 2;
                                float[] fArr5 = new float[length];
                                float f18 = -barEntry6.getNegativeSum();
                                int i12 = 0;
                                int i13 = 0;
                                float f19 = 0.0f;
                                while (i12 < length) {
                                    float f20 = fArr[i13];
                                    if (f20 == 0.0f && (f19 == 0.0f || f18 == 0.0f)) {
                                        float f21 = f18;
                                        f18 = f20;
                                        f4 = f21;
                                    } else if (f20 >= 0.0f) {
                                        f19 += f20;
                                        f4 = f18;
                                        f18 = f19;
                                    } else {
                                        f4 = f18 - f20;
                                    }
                                    fArr5[i12 + 1] = f18 * phaseY;
                                    i12 += 2;
                                    i13++;
                                    f18 = f4;
                                }
                                transformer.pointValuesToPixel(fArr5);
                                int i14 = 0;
                                while (i14 < length) {
                                    float f22 = fArr[i14 / 2];
                                    float f23 = fArr5[i14 + 1] + (((f22 > 0.0f ? 1 : (f22 == 0.0f ? 0 : -1)) == 0 && (f18 > 0.0f ? 1 : (f18 == 0.0f ? 0 : -1)) == 0 && (f19 > 0.0f ? 1 : (f19 == 0.0f ? 0 : -1)) > 0) || (f22 > 0.0f ? 1 : (f22 == 0.0f ? 0 : -1)) < 0 ? f13 : f12);
                                    int i15 = i14;
                                    if (!this.mViewPortHandler.isInBoundsRight(f17)) {
                                        break;
                                    }
                                    if (this.mViewPortHandler.isInBoundsY(f23) && this.mViewPortHandler.isInBoundsLeft(f17)) {
                                        if (iBarDataSet.isDrawValuesEnabled()) {
                                            BarEntry barEntry7 = barEntry6;
                                            f3 = f23;
                                            i3 = i15;
                                            barEntry = barEntry7;
                                            fArr2 = fArr5;
                                            i2 = length;
                                            f2 = f17;
                                            drawValue(c, valueFormatter2.getBarStackedLabel(f22, barEntry7), f17, f3, valueTextColor);
                                        } else {
                                            f3 = f23;
                                            i2 = length;
                                            f2 = f17;
                                            i3 = i15;
                                            barEntry = barEntry6;
                                            fArr2 = fArr5;
                                        }
                                        if (barEntry.getIcon() != null && iBarDataSet.isDrawIconsEnabled()) {
                                            Drawable icon3 = barEntry.getIcon();
                                            Utils.drawImage(c, icon3, (int) (f2 + mPPointF.f23783x), (int) (f3 + mPPointF.f23784y), icon3.getIntrinsicWidth(), icon3.getIntrinsicHeight());
                                        }
                                    } else {
                                        i2 = length;
                                        f2 = f17;
                                        i3 = i15;
                                        barEntry = barEntry6;
                                        fArr2 = fArr5;
                                    }
                                    i14 = i3 + 2;
                                    fArr5 = fArr2;
                                    barEntry6 = barEntry;
                                    length = i2;
                                    f17 = f2;
                                }
                            }
                            i10 = fArr == null ? i10 + 4 : i10 + (fArr.length * 4);
                            i9 = i + 1;
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
        BarData barData = this.f20219a.getBarData();
        this.f20221c = new BarBuffer[barData.getDataSetCount()];
        for (int i = 0; i < this.f20221c.length; i++) {
            IBarDataSet iBarDataSet = (IBarDataSet) barData.getDataSetByIndex(i);
            this.f20221c[i] = new BarBuffer(iBarDataSet.getEntryCount() * 4 * (iBarDataSet.isStacked() ? iBarDataSet.getStackSize() : 1), barData.getDataSetCount(), iBarDataSet.isStacked());
        }
    }

    protected void prepareBarHighlight(float x, float y1, float y2, float barWidthHalf, Transformer trans) {
        this.f20220b.set(x - barWidthHalf, y1, x + barWidthHalf, y2);
        trans.rectToPixelPhase(this.f20220b, this.mAnimator.getPhaseY());
    }

    protected void setHighlightDrawPos(Highlight high, RectF bar) {
        high.setDraw(bar.centerX(), bar.top);
    }
}
