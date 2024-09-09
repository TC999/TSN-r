package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.data.CandleData;
import com.github.mikephil.charting.data.CandleEntry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.dataprovider.CandleDataProvider;
import com.github.mikephil.charting.interfaces.datasets.ICandleDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineScatterCandleRadarDataSet;
import com.github.mikephil.charting.renderer.BarLineScatterCandleBubbleRenderer;
import com.github.mikephil.charting.utils.MPPointD;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class CandleStickChartRenderer extends LineScatterCandleRadarRenderer {
    private float[] mBodyBuffers;
    protected CandleDataProvider mChart;
    private float[] mCloseBuffers;
    private float[] mOpenBuffers;
    private float[] mRangeBuffers;
    private float[] mShadowBuffers;

    public CandleStickChartRenderer(CandleDataProvider candleDataProvider, ChartAnimator chartAnimator, ViewPortHandler viewPortHandler) {
        super(chartAnimator, viewPortHandler);
        this.mShadowBuffers = new float[8];
        this.mBodyBuffers = new float[4];
        this.mRangeBuffers = new float[4];
        this.mOpenBuffers = new float[4];
        this.mCloseBuffers = new float[4];
        this.mChart = candleDataProvider;
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawData(Canvas canvas) {
        for (T t3 : this.mChart.getCandleData().getDataSets()) {
            if (t3.isVisible()) {
                drawDataSet(canvas, t3);
            }
        }
    }

    protected void drawDataSet(Canvas canvas, ICandleDataSet iCandleDataSet) {
        int neutralColor;
        int shadowColor;
        int neutralColor2;
        int increasingColor;
        int decreasingColor;
        Transformer transformer = this.mChart.getTransformer(iCandleDataSet.getAxisDependency());
        float phaseY = this.mAnimator.getPhaseY();
        float barSpace = iCandleDataSet.getBarSpace();
        boolean showCandleBar = iCandleDataSet.getShowCandleBar();
        this.mXBounds.set(this.mChart, iCandleDataSet);
        this.mRenderPaint.setStrokeWidth(iCandleDataSet.getShadowWidth());
        int i4 = this.mXBounds.min;
        while (true) {
            BarLineScatterCandleBubbleRenderer.XBounds xBounds = this.mXBounds;
            if (i4 > xBounds.range + xBounds.min) {
                return;
            }
            CandleEntry candleEntry = (CandleEntry) iCandleDataSet.getEntryForIndex(i4);
            if (candleEntry != null) {
                float x3 = candleEntry.getX();
                float open = candleEntry.getOpen();
                float close = candleEntry.getClose();
                float high = candleEntry.getHigh();
                float low = candleEntry.getLow();
                if (showCandleBar) {
                    float[] fArr = this.mShadowBuffers;
                    fArr[0] = x3;
                    fArr[2] = x3;
                    fArr[4] = x3;
                    fArr[6] = x3;
                    if (open > close) {
                        fArr[1] = high * phaseY;
                        fArr[3] = open * phaseY;
                        fArr[5] = low * phaseY;
                        fArr[7] = close * phaseY;
                    } else if (open < close) {
                        fArr[1] = high * phaseY;
                        fArr[3] = close * phaseY;
                        fArr[5] = low * phaseY;
                        fArr[7] = open * phaseY;
                    } else {
                        fArr[1] = high * phaseY;
                        fArr[3] = open * phaseY;
                        fArr[5] = low * phaseY;
                        fArr[7] = fArr[3];
                    }
                    transformer.pointValuesToPixel(fArr);
                    if (!iCandleDataSet.getShadowColorSameAsCandle()) {
                        Paint paint = this.mRenderPaint;
                        if (iCandleDataSet.getShadowColor() == 1122867) {
                            shadowColor = iCandleDataSet.getColor(i4);
                        } else {
                            shadowColor = iCandleDataSet.getShadowColor();
                        }
                        paint.setColor(shadowColor);
                    } else if (open > close) {
                        Paint paint2 = this.mRenderPaint;
                        if (iCandleDataSet.getDecreasingColor() == 1122867) {
                            decreasingColor = iCandleDataSet.getColor(i4);
                        } else {
                            decreasingColor = iCandleDataSet.getDecreasingColor();
                        }
                        paint2.setColor(decreasingColor);
                    } else if (open < close) {
                        Paint paint3 = this.mRenderPaint;
                        if (iCandleDataSet.getIncreasingColor() == 1122867) {
                            increasingColor = iCandleDataSet.getColor(i4);
                        } else {
                            increasingColor = iCandleDataSet.getIncreasingColor();
                        }
                        paint3.setColor(increasingColor);
                    } else {
                        Paint paint4 = this.mRenderPaint;
                        if (iCandleDataSet.getNeutralColor() == 1122867) {
                            neutralColor2 = iCandleDataSet.getColor(i4);
                        } else {
                            neutralColor2 = iCandleDataSet.getNeutralColor();
                        }
                        paint4.setColor(neutralColor2);
                    }
                    this.mRenderPaint.setStyle(Paint.Style.STROKE);
                    canvas.drawLines(this.mShadowBuffers, this.mRenderPaint);
                    float[] fArr2 = this.mBodyBuffers;
                    fArr2[0] = (x3 - 0.5f) + barSpace;
                    fArr2[1] = close * phaseY;
                    fArr2[2] = (x3 + 0.5f) - barSpace;
                    fArr2[3] = open * phaseY;
                    transformer.pointValuesToPixel(fArr2);
                    if (open > close) {
                        if (iCandleDataSet.getDecreasingColor() == 1122867) {
                            this.mRenderPaint.setColor(iCandleDataSet.getColor(i4));
                        } else {
                            this.mRenderPaint.setColor(iCandleDataSet.getDecreasingColor());
                        }
                        this.mRenderPaint.setStyle(iCandleDataSet.getDecreasingPaintStyle());
                        float[] fArr3 = this.mBodyBuffers;
                        canvas.drawRect(fArr3[0], fArr3[3], fArr3[2], fArr3[1], this.mRenderPaint);
                    } else if (open < close) {
                        if (iCandleDataSet.getIncreasingColor() == 1122867) {
                            this.mRenderPaint.setColor(iCandleDataSet.getColor(i4));
                        } else {
                            this.mRenderPaint.setColor(iCandleDataSet.getIncreasingColor());
                        }
                        this.mRenderPaint.setStyle(iCandleDataSet.getIncreasingPaintStyle());
                        float[] fArr4 = this.mBodyBuffers;
                        canvas.drawRect(fArr4[0], fArr4[1], fArr4[2], fArr4[3], this.mRenderPaint);
                    } else {
                        if (iCandleDataSet.getNeutralColor() == 1122867) {
                            this.mRenderPaint.setColor(iCandleDataSet.getColor(i4));
                        } else {
                            this.mRenderPaint.setColor(iCandleDataSet.getNeutralColor());
                        }
                        float[] fArr5 = this.mBodyBuffers;
                        canvas.drawLine(fArr5[0], fArr5[1], fArr5[2], fArr5[3], this.mRenderPaint);
                    }
                } else {
                    float[] fArr6 = this.mRangeBuffers;
                    fArr6[0] = x3;
                    fArr6[1] = high * phaseY;
                    fArr6[2] = x3;
                    fArr6[3] = low * phaseY;
                    float[] fArr7 = this.mOpenBuffers;
                    fArr7[0] = (x3 - 0.5f) + barSpace;
                    float f4 = open * phaseY;
                    fArr7[1] = f4;
                    fArr7[2] = x3;
                    fArr7[3] = f4;
                    float[] fArr8 = this.mCloseBuffers;
                    fArr8[0] = (0.5f + x3) - barSpace;
                    float f5 = close * phaseY;
                    fArr8[1] = f5;
                    fArr8[2] = x3;
                    fArr8[3] = f5;
                    transformer.pointValuesToPixel(fArr6);
                    transformer.pointValuesToPixel(this.mOpenBuffers);
                    transformer.pointValuesToPixel(this.mCloseBuffers);
                    if (open > close) {
                        if (iCandleDataSet.getDecreasingColor() == 1122867) {
                            neutralColor = iCandleDataSet.getColor(i4);
                        } else {
                            neutralColor = iCandleDataSet.getDecreasingColor();
                        }
                    } else if (open < close) {
                        if (iCandleDataSet.getIncreasingColor() == 1122867) {
                            neutralColor = iCandleDataSet.getColor(i4);
                        } else {
                            neutralColor = iCandleDataSet.getIncreasingColor();
                        }
                    } else if (iCandleDataSet.getNeutralColor() == 1122867) {
                        neutralColor = iCandleDataSet.getColor(i4);
                    } else {
                        neutralColor = iCandleDataSet.getNeutralColor();
                    }
                    this.mRenderPaint.setColor(neutralColor);
                    float[] fArr9 = this.mRangeBuffers;
                    canvas.drawLine(fArr9[0], fArr9[1], fArr9[2], fArr9[3], this.mRenderPaint);
                    float[] fArr10 = this.mOpenBuffers;
                    canvas.drawLine(fArr10[0], fArr10[1], fArr10[2], fArr10[3], this.mRenderPaint);
                    float[] fArr11 = this.mCloseBuffers;
                    canvas.drawLine(fArr11[0], fArr11[1], fArr11[2], fArr11[3], this.mRenderPaint);
                }
            }
            i4++;
        }
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawExtras(Canvas canvas) {
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawHighlighted(Canvas canvas, Highlight[] highlightArr) {
        CandleData candleData = this.mChart.getCandleData();
        for (Highlight highlight : highlightArr) {
            ILineScatterCandleRadarDataSet iLineScatterCandleRadarDataSet = (ICandleDataSet) candleData.getDataSetByIndex(highlight.getDataSetIndex());
            if (iLineScatterCandleRadarDataSet != null && iLineScatterCandleRadarDataSet.isHighlightEnabled()) {
                CandleEntry candleEntry = (CandleEntry) iLineScatterCandleRadarDataSet.getEntryForXValue(highlight.getX(), highlight.getY());
                if (isInBoundsX(candleEntry, iLineScatterCandleRadarDataSet)) {
                    MPPointD pixelForValues = this.mChart.getTransformer(iLineScatterCandleRadarDataSet.getAxisDependency()).getPixelForValues(candleEntry.getX(), ((candleEntry.getLow() * this.mAnimator.getPhaseY()) + (candleEntry.getHigh() * this.mAnimator.getPhaseY())) / 2.0f);
                    highlight.setDraw((float) pixelForValues.f37330x, (float) pixelForValues.f37331y);
                    drawHighlightLines(canvas, (float) pixelForValues.f37330x, (float) pixelForValues.f37331y, iLineScatterCandleRadarDataSet);
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
        ICandleDataSet iCandleDataSet;
        CandleEntry candleEntry;
        float f4;
        if (isDrawingValuesAllowed(this.mChart)) {
            List<T> dataSets = this.mChart.getCandleData().getDataSets();
            for (int i4 = 0; i4 < dataSets.size(); i4++) {
                ICandleDataSet iCandleDataSet2 = (ICandleDataSet) dataSets.get(i4);
                if (shouldDrawValues(iCandleDataSet2) && iCandleDataSet2.getEntryCount() >= 1) {
                    applyValueTextStyle(iCandleDataSet2);
                    Transformer transformer = this.mChart.getTransformer(iCandleDataSet2.getAxisDependency());
                    this.mXBounds.set(this.mChart, iCandleDataSet2);
                    float phaseX = this.mAnimator.getPhaseX();
                    float phaseY = this.mAnimator.getPhaseY();
                    BarLineScatterCandleBubbleRenderer.XBounds xBounds = this.mXBounds;
                    float[] generateTransformedValuesCandle = transformer.generateTransformedValuesCandle(iCandleDataSet2, phaseX, phaseY, xBounds.min, xBounds.max);
                    float convertDpToPixel = Utils.convertDpToPixel(5.0f);
                    ValueFormatter valueFormatter = iCandleDataSet2.getValueFormatter();
                    MPPointF mPPointF = MPPointF.getInstance(iCandleDataSet2.getIconsOffset());
                    mPPointF.f37332x = Utils.convertDpToPixel(mPPointF.f37332x);
                    mPPointF.f37333y = Utils.convertDpToPixel(mPPointF.f37333y);
                    int i5 = 0;
                    while (i5 < generateTransformedValuesCandle.length) {
                        float f5 = generateTransformedValuesCandle[i5];
                        float f6 = generateTransformedValuesCandle[i5 + 1];
                        if (!this.mViewPortHandler.isInBoundsRight(f5)) {
                            break;
                        }
                        if (this.mViewPortHandler.isInBoundsLeft(f5) && this.mViewPortHandler.isInBoundsY(f6)) {
                            int i6 = i5 / 2;
                            CandleEntry candleEntry2 = (CandleEntry) iCandleDataSet2.getEntryForIndex(this.mXBounds.min + i6);
                            if (iCandleDataSet2.isDrawValuesEnabled()) {
                                candleEntry = candleEntry2;
                                f4 = f6;
                                iCandleDataSet = iCandleDataSet2;
                                drawValue(canvas, valueFormatter.getCandleLabel(candleEntry2), f5, f6 - convertDpToPixel, iCandleDataSet2.getValueTextColor(i6));
                            } else {
                                candleEntry = candleEntry2;
                                f4 = f6;
                                iCandleDataSet = iCandleDataSet2;
                            }
                            if (candleEntry.getIcon() != null && iCandleDataSet.isDrawIconsEnabled()) {
                                Drawable icon = candleEntry.getIcon();
                                Utils.drawImage(canvas, icon, (int) (f5 + mPPointF.f37332x), (int) (f4 + mPPointF.f37333y), icon.getIntrinsicWidth(), icon.getIntrinsicHeight());
                            }
                        } else {
                            iCandleDataSet = iCandleDataSet2;
                        }
                        i5 += 2;
                        iCandleDataSet2 = iCandleDataSet;
                    }
                    MPPointF.recycleInstance(mPPointF);
                }
            }
        }
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void initBuffers() {
    }
}
