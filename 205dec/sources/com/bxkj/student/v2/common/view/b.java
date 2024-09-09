package com.bxkj.student.v2.common.view;

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
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* compiled from: CustomBarChartRenderer.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class b extends BarLineScatterCandleBubbleRenderer {

    /* renamed from: a  reason: collision with root package name */
    protected BarDataProvider f23536a;

    /* renamed from: b  reason: collision with root package name */
    protected RectF f23537b;

    /* renamed from: c  reason: collision with root package name */
    protected BarBuffer[] f23538c;

    /* renamed from: d  reason: collision with root package name */
    protected Paint f23539d;

    /* renamed from: e  reason: collision with root package name */
    protected Paint f23540e;

    /* renamed from: f  reason: collision with root package name */
    private RectF f23541f;

    public b(BarDataProvider chart, ChartAnimator animator, ViewPortHandler viewPortHandler) {
        super(animator, viewPortHandler);
        this.f23537b = new RectF();
        this.f23541f = new RectF();
        this.f23536a = chart;
        Paint paint = new Paint(1);
        this.mHighlightPaint = paint;
        paint.setStyle(Paint.Style.FILL);
        this.mHighlightPaint.setColor(Color.rgb(0, 0, 0));
        this.mHighlightPaint.setAlpha(120);
        Paint paint2 = new Paint(1);
        this.f23539d = paint2;
        paint2.setStyle(Paint.Style.FILL);
        Paint paint3 = new Paint(1);
        this.f23540e = paint3;
        paint3.setStyle(Paint.Style.STROKE);
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawData(Canvas c4) {
        BarData barData = this.f23536a.getBarData();
        for (int i4 = 0; i4 < barData.getDataSetCount(); i4++) {
            IBarDataSet iBarDataSet = (IBarDataSet) barData.getDataSetByIndex(i4);
            if (iBarDataSet.isVisible()) {
                drawDataSet(c4, iBarDataSet, i4);
            }
        }
    }

    protected void drawDataSet(Canvas c4, IBarDataSet dataSet, int index) {
        Transformer transformer = this.f23536a.getTransformer(dataSet.getAxisDependency());
        this.f23540e.setColor(dataSet.getBarBorderColor());
        this.f23540e.setStrokeWidth(Utils.convertDpToPixel(dataSet.getBarBorderWidth()));
        boolean z3 = dataSet.getBarBorderWidth() > 0.0f;
        float phaseX = this.mAnimator.getPhaseX();
        float phaseY = this.mAnimator.getPhaseY();
        if (this.f23536a.isDrawBarShadowEnabled()) {
            this.f23539d.setColor(dataSet.getBarShadowColor());
            float barWidth = this.f23536a.getBarData().getBarWidth() / 2.0f;
            int min = Math.min((int) Math.ceil(dataSet.getEntryCount() * phaseX), dataSet.getEntryCount());
            for (int i4 = 0; i4 < min; i4++) {
                float x3 = ((BarEntry) dataSet.getEntryForIndex(i4)).getX();
                RectF rectF = this.f23541f;
                rectF.left = x3 - barWidth;
                rectF.right = x3 + barWidth;
                transformer.rectValueToPixel(rectF);
                if (this.mViewPortHandler.isInBoundsLeft(this.f23541f.right)) {
                    if (!this.mViewPortHandler.isInBoundsRight(this.f23541f.left)) {
                        break;
                    }
                    this.f23541f.top = this.mViewPortHandler.contentTop();
                    this.f23541f.bottom = this.mViewPortHandler.contentBottom();
                    c4.drawRect(this.f23541f, this.f23539d);
                }
            }
        }
        BarBuffer barBuffer = this.f23538c[index];
        barBuffer.setPhases(phaseX, phaseY);
        barBuffer.setDataSet(index);
        barBuffer.setInverted(this.f23536a.isInverted(dataSet.getAxisDependency()));
        barBuffer.setBarWidth(this.f23536a.getBarData().getBarWidth());
        barBuffer.feed(dataSet);
        transformer.pointValuesToPixel(barBuffer.buffer);
        boolean z4 = dataSet.getColors().size() == 1;
        if (z4) {
            this.mRenderPaint.setColor(dataSet.getColor());
        }
        for (int i5 = 0; i5 < barBuffer.size(); i5 += 4) {
            int i6 = i5 + 2;
            if (this.mViewPortHandler.isInBoundsLeft(barBuffer.buffer[i6])) {
                if (!this.mViewPortHandler.isInBoundsRight(barBuffer.buffer[i5])) {
                    return;
                }
                if (!z4) {
                    this.mRenderPaint.setColor(dataSet.getColor(i5 / 4));
                }
                if (dataSet.getGradientColor() != null) {
                    GradientColor gradientColor = dataSet.getGradientColor();
                    Paint paint = this.mRenderPaint;
                    float[] fArr = barBuffer.buffer;
                    paint.setShader(new LinearGradient(fArr[i5], fArr[i5 + 3], fArr[i5], fArr[i5 + 1], gradientColor.getStartColor(), gradientColor.getEndColor(), Shader.TileMode.MIRROR));
                }
                if (dataSet.getGradientColors() != null) {
                    Paint paint2 = this.mRenderPaint;
                    float[] fArr2 = barBuffer.buffer;
                    float f4 = fArr2[i5];
                    float f5 = fArr2[i5 + 3];
                    float f6 = fArr2[i5];
                    float f7 = fArr2[i5 + 1];
                    int i7 = i5 / 4;
                    paint2.setShader(new LinearGradient(f4, f5, f6, f7, dataSet.getGradientColor(i7).getStartColor(), dataSet.getGradientColor(i7).getEndColor(), Shader.TileMode.MIRROR));
                }
                float[] fArr3 = barBuffer.buffer;
                int i8 = i5 + 1;
                int i9 = i5 + 3;
                RectF rectF2 = new RectF(fArr3[i5], fArr3[i8], fArr3[i6], fArr3[i9]);
                new Path();
                c4.drawRoundRect(rectF2, 20.0f, 20.0f, this.mRenderPaint);
                if (z3) {
                    float[] fArr4 = barBuffer.buffer;
                    c4.drawRect(fArr4[i5], fArr4[i8], fArr4[i6], fArr4[i9], this.f23540e);
                }
            }
        }
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawExtras(Canvas c4) {
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawHighlighted(Canvas c4, Highlight[] indices) {
        float y3;
        float f4;
        BarData barData = this.f23536a.getBarData();
        for (Highlight highlight : indices) {
            IBarDataSet iBarDataSet = (IBarDataSet) barData.getDataSetByIndex(highlight.getDataSetIndex());
            if (iBarDataSet != null && iBarDataSet.isHighlightEnabled()) {
                BarEntry barEntry = (BarEntry) iBarDataSet.getEntryForXValue(highlight.getX(), highlight.getY());
                if (isInBoundsX(barEntry, iBarDataSet)) {
                    Transformer transformer = this.f23536a.getTransformer(iBarDataSet.getAxisDependency());
                    this.mHighlightPaint.setColor(iBarDataSet.getHighLightColor());
                    this.mHighlightPaint.setAlpha(iBarDataSet.getHighLightAlpha());
                    if (highlight.getStackIndex() >= 0 && barEntry.isStacked()) {
                        if (this.f23536a.isHighlightFullBarEnabled()) {
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
                    setHighlightDrawPos(highlight, this.f23537b);
                    c4.drawRect(this.f23537b, this.mHighlightPaint);
                }
            }
        }
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawValue(Canvas c4, String valueText, float x3, float y3, int color) {
        this.mValuePaint.setColor(color);
        c4.drawText(valueText, x3, y3, this.mValuePaint);
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawValues(Canvas c4) {
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
        float f11;
        float f12;
        if (isDrawingValuesAllowed(this.f23536a)) {
            List dataSets = this.f23536a.getBarData().getDataSets();
            float convertDpToPixel = Utils.convertDpToPixel(4.5f);
            boolean isDrawValueAboveBarEnabled = this.f23536a.isDrawValueAboveBarEnabled();
            int i8 = 0;
            while (i8 < this.f23536a.getBarData().getDataSetCount()) {
                IBarDataSet iBarDataSet = (IBarDataSet) dataSets.get(i8);
                if (shouldDrawValues(iBarDataSet)) {
                    applyValueTextStyle(iBarDataSet);
                    boolean isInverted = this.f23536a.isInverted(iBarDataSet.getAxisDependency());
                    float calcTextHeight = Utils.calcTextHeight(this.mValuePaint, "8");
                    float f13 = isDrawValueAboveBarEnabled ? -convertDpToPixel : calcTextHeight + convertDpToPixel;
                    float f14 = isDrawValueAboveBarEnabled ? calcTextHeight + convertDpToPixel : -convertDpToPixel;
                    if (isInverted) {
                        f13 = (-f13) - calcTextHeight;
                        f14 = (-f14) - calcTextHeight;
                    }
                    float f15 = f13;
                    float f16 = f14;
                    BarBuffer barBuffer = this.f23538c[i8];
                    float phaseY = this.mAnimator.getPhaseY();
                    ValueFormatter valueFormatter2 = iBarDataSet.getValueFormatter();
                    MPPointF mPPointF3 = MPPointF.getInstance(iBarDataSet.getIconsOffset());
                    mPPointF3.f37332x = Utils.convertDpToPixel(mPPointF3.f37332x);
                    mPPointF3.f37333y = Utils.convertDpToPixel(mPPointF3.f37333y);
                    if (!iBarDataSet.isStacked()) {
                        int i9 = 0;
                        while (i9 < barBuffer.buffer.length * this.mAnimator.getPhaseX()) {
                            float[] fArr3 = barBuffer.buffer;
                            float f17 = (fArr3[i9] + fArr3[i9 + 2]) / 2.0f;
                            if (!this.mViewPortHandler.isInBoundsRight(f17)) {
                                break;
                            }
                            int i10 = i9 + 1;
                            if (this.mViewPortHandler.isInBoundsY(barBuffer.buffer[i10]) && this.mViewPortHandler.isInBoundsLeft(f17)) {
                                int i11 = i9 / 4;
                                BarEntry barEntry4 = (BarEntry) iBarDataSet.getEntryForIndex(i11);
                                float y3 = barEntry4.getY();
                                if (iBarDataSet.isDrawValuesEnabled()) {
                                    String barLabel = valueFormatter2.getBarLabel(barEntry4);
                                    if (y3 >= 0.0f) {
                                        f12 = barBuffer.buffer[i10] + f15;
                                    } else {
                                        f12 = barBuffer.buffer[i9 + 3] + f16;
                                    }
                                    barEntry3 = barEntry4;
                                    f10 = f17;
                                    i7 = i9;
                                    list2 = dataSets;
                                    mPPointF2 = mPPointF3;
                                    float f18 = f12;
                                    valueFormatter = valueFormatter2;
                                    drawValue(c4, barLabel, f10, f18, iBarDataSet.getValueTextColor(i11));
                                } else {
                                    barEntry3 = barEntry4;
                                    f10 = f17;
                                    i7 = i9;
                                    valueFormatter = valueFormatter2;
                                    list2 = dataSets;
                                    mPPointF2 = mPPointF3;
                                }
                                if (barEntry3.getIcon() != null && iBarDataSet.isDrawIconsEnabled()) {
                                    Drawable icon = barEntry3.getIcon();
                                    if (y3 >= 0.0f) {
                                        f11 = barBuffer.buffer[i10] + f15;
                                    } else {
                                        f11 = barBuffer.buffer[i7 + 3] + f16;
                                    }
                                    Utils.drawImage(c4, icon, (int) (f10 + mPPointF2.f37332x), (int) (f11 + mPPointF2.f37333y), icon.getIntrinsicWidth(), icon.getIntrinsicHeight());
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
                        Transformer transformer2 = this.f23536a.getTransformer(iBarDataSet.getAxisDependency());
                        int i12 = 0;
                        int i13 = 0;
                        while (i12 < iBarDataSet.getEntryCount() * this.mAnimator.getPhaseX()) {
                            BarEntry barEntry5 = (BarEntry) iBarDataSet.getEntryForIndex(i12);
                            float[] yVals = barEntry5.getYVals();
                            float[] fArr4 = barBuffer.buffer;
                            float f19 = (fArr4[i13] + fArr4[i13 + 2]) / 2.0f;
                            int valueTextColor = iBarDataSet.getValueTextColor(i12);
                            if (yVals == null) {
                                if (!this.mViewPortHandler.isInBoundsRight(f19)) {
                                    break;
                                }
                                int i14 = i13 + 1;
                                if (this.mViewPortHandler.isInBoundsY(barBuffer.buffer[i14]) && this.mViewPortHandler.isInBoundsLeft(f19)) {
                                    if (iBarDataSet.isDrawValuesEnabled()) {
                                        f8 = f19;
                                        f4 = convertDpToPixel;
                                        fArr = yVals;
                                        barEntry2 = barEntry5;
                                        i4 = i12;
                                        z3 = isDrawValueAboveBarEnabled;
                                        transformer = transformer2;
                                        drawValue(c4, valueFormatter2.getBarLabel(barEntry5), f8, barBuffer.buffer[i14] + (barEntry5.getY() >= 0.0f ? f15 : f16), valueTextColor);
                                    } else {
                                        f8 = f19;
                                        i4 = i12;
                                        f4 = convertDpToPixel;
                                        z3 = isDrawValueAboveBarEnabled;
                                        fArr = yVals;
                                        barEntry2 = barEntry5;
                                        transformer = transformer2;
                                    }
                                    if (barEntry2.getIcon() != null && iBarDataSet.isDrawIconsEnabled()) {
                                        Drawable icon2 = barEntry2.getIcon();
                                        Utils.drawImage(c4, icon2, (int) (mPPointF.f37332x + f8), (int) (barBuffer.buffer[i14] + (barEntry2.getY() >= 0.0f ? f15 : f16) + mPPointF.f37333y), icon2.getIntrinsicWidth(), icon2.getIntrinsicHeight());
                                    }
                                } else {
                                    transformer2 = transformer2;
                                    isDrawValueAboveBarEnabled = isDrawValueAboveBarEnabled;
                                    convertDpToPixel = convertDpToPixel;
                                    i12 = i12;
                                }
                            } else {
                                BarEntry barEntry6 = barEntry5;
                                i4 = i12;
                                f4 = convertDpToPixel;
                                z3 = isDrawValueAboveBarEnabled;
                                fArr = yVals;
                                transformer = transformer2;
                                float f20 = f19;
                                int length = fArr.length * 2;
                                float[] fArr5 = new float[length];
                                float f21 = -barEntry6.getNegativeSum();
                                int i15 = 0;
                                int i16 = 0;
                                float f22 = 0.0f;
                                while (i15 < length) {
                                    float f23 = fArr[i16];
                                    if (f23 == 0.0f && (f22 == 0.0f || f21 == 0.0f)) {
                                        float f24 = f21;
                                        f21 = f23;
                                        f7 = f24;
                                    } else if (f23 >= 0.0f) {
                                        f22 += f23;
                                        f7 = f21;
                                        f21 = f22;
                                    } else {
                                        f7 = f21 - f23;
                                    }
                                    fArr5[i15 + 1] = f21 * phaseY;
                                    i15 += 2;
                                    i16++;
                                    f21 = f7;
                                }
                                transformer.pointValuesToPixel(fArr5);
                                int i17 = 0;
                                while (i17 < length) {
                                    float f25 = fArr[i17 / 2];
                                    float f26 = fArr5[i17 + 1] + (((f25 > 0.0f ? 1 : (f25 == 0.0f ? 0 : -1)) == 0 && (f21 > 0.0f ? 1 : (f21 == 0.0f ? 0 : -1)) == 0 && (f22 > 0.0f ? 1 : (f22 == 0.0f ? 0 : -1)) > 0) || (f25 > 0.0f ? 1 : (f25 == 0.0f ? 0 : -1)) < 0 ? f16 : f15);
                                    int i18 = i17;
                                    if (!this.mViewPortHandler.isInBoundsRight(f20)) {
                                        break;
                                    }
                                    if (this.mViewPortHandler.isInBoundsY(f26) && this.mViewPortHandler.isInBoundsLeft(f20)) {
                                        if (iBarDataSet.isDrawValuesEnabled()) {
                                            BarEntry barEntry7 = barEntry6;
                                            f6 = f26;
                                            i6 = i18;
                                            barEntry = barEntry7;
                                            fArr2 = fArr5;
                                            i5 = length;
                                            f5 = f20;
                                            drawValue(c4, valueFormatter2.getBarStackedLabel(f25, barEntry7), f20, f6, valueTextColor);
                                        } else {
                                            f6 = f26;
                                            i5 = length;
                                            f5 = f20;
                                            i6 = i18;
                                            barEntry = barEntry6;
                                            fArr2 = fArr5;
                                        }
                                        if (barEntry.getIcon() != null && iBarDataSet.isDrawIconsEnabled()) {
                                            Drawable icon3 = barEntry.getIcon();
                                            Utils.drawImage(c4, icon3, (int) (f5 + mPPointF.f37332x), (int) (f6 + mPPointF.f37333y), icon3.getIntrinsicWidth(), icon3.getIntrinsicHeight());
                                        }
                                    } else {
                                        i5 = length;
                                        f5 = f20;
                                        i6 = i18;
                                        barEntry = barEntry6;
                                        fArr2 = fArr5;
                                    }
                                    i17 = i6 + 2;
                                    fArr5 = fArr2;
                                    barEntry6 = barEntry;
                                    length = i5;
                                    f20 = f5;
                                }
                            }
                            i13 = fArr == null ? i13 + 4 : i13 + (fArr.length * 4);
                            i12 = i4 + 1;
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
        BarData barData = this.f23536a.getBarData();
        this.f23538c = new BarBuffer[barData.getDataSetCount()];
        for (int i4 = 0; i4 < this.f23538c.length; i4++) {
            IBarDataSet iBarDataSet = (IBarDataSet) barData.getDataSetByIndex(i4);
            this.f23538c[i4] = new BarBuffer(iBarDataSet.getEntryCount() * 4 * (iBarDataSet.isStacked() ? iBarDataSet.getStackSize() : 1), barData.getDataSetCount(), iBarDataSet.isStacked());
        }
    }

    protected void prepareBarHighlight(float x3, float y12, float y22, float barWidthHalf, Transformer trans) {
        this.f23537b.set(x3 - barWidthHalf, y12, x3 + barWidthHalf, y22);
        trans.rectToPixelPhase(this.f23537b, this.mAnimator.getPhaseY());
    }

    protected void setHighlightDrawPos(Highlight high, RectF bar) {
        high.setDraw(bar.centerX(), bar.top);
    }
}
