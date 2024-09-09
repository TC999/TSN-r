package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.Log;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.ScatterData;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.dataprovider.ScatterDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IScatterDataSet;
import com.github.mikephil.charting.renderer.BarLineScatterCandleBubbleRenderer;
import com.github.mikephil.charting.renderer.scatter.IShapeRenderer;
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
public class ScatterChartRenderer extends LineScatterCandleRadarRenderer {
    protected ScatterDataProvider mChart;
    float[] mPixelBuffer;

    public ScatterChartRenderer(ScatterDataProvider scatterDataProvider, ChartAnimator chartAnimator, ViewPortHandler viewPortHandler) {
        super(chartAnimator, viewPortHandler);
        this.mPixelBuffer = new float[2];
        this.mChart = scatterDataProvider;
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawData(Canvas canvas) {
        for (T t3 : this.mChart.getScatterData().getDataSets()) {
            if (t3.isVisible()) {
                drawDataSet(canvas, t3);
            }
        }
    }

    /* JADX WARN: Type inference failed for: r1v9, types: [com.github.mikephil.charting.data.Entry, com.github.mikephil.charting.data.BaseEntry] */
    protected void drawDataSet(Canvas canvas, IScatterDataSet iScatterDataSet) {
        int i4;
        if (iScatterDataSet.getEntryCount() < 1) {
            return;
        }
        ViewPortHandler viewPortHandler = this.mViewPortHandler;
        Transformer transformer = this.mChart.getTransformer(iScatterDataSet.getAxisDependency());
        float phaseY = this.mAnimator.getPhaseY();
        IShapeRenderer shapeRenderer = iScatterDataSet.getShapeRenderer();
        if (shapeRenderer == null) {
            Log.i("MISSING", "There's no IShapeRenderer specified for ScatterDataSet");
            return;
        }
        int min = (int) Math.min(Math.ceil(iScatterDataSet.getEntryCount() * this.mAnimator.getPhaseX()), iScatterDataSet.getEntryCount());
        int i5 = 0;
        while (i5 < min) {
            ?? entryForIndex = iScatterDataSet.getEntryForIndex(i5);
            this.mPixelBuffer[0] = entryForIndex.getX();
            this.mPixelBuffer[1] = entryForIndex.getY() * phaseY;
            transformer.pointValuesToPixel(this.mPixelBuffer);
            if (!viewPortHandler.isInBoundsRight(this.mPixelBuffer[0])) {
                return;
            }
            if (viewPortHandler.isInBoundsLeft(this.mPixelBuffer[0]) && viewPortHandler.isInBoundsY(this.mPixelBuffer[1])) {
                this.mRenderPaint.setColor(iScatterDataSet.getColor(i5 / 2));
                ViewPortHandler viewPortHandler2 = this.mViewPortHandler;
                float[] fArr = this.mPixelBuffer;
                i4 = i5;
                shapeRenderer.renderShape(canvas, iScatterDataSet, viewPortHandler2, fArr[0], fArr[1], this.mRenderPaint);
            } else {
                i4 = i5;
            }
            i5 = i4 + 1;
        }
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawExtras(Canvas canvas) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v2, types: [com.github.mikephil.charting.data.Entry, com.github.mikephil.charting.data.BaseEntry] */
    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawHighlighted(Canvas canvas, Highlight[] highlightArr) {
        ScatterData scatterData = this.mChart.getScatterData();
        for (Highlight highlight : highlightArr) {
            IScatterDataSet iScatterDataSet = (IScatterDataSet) scatterData.getDataSetByIndex(highlight.getDataSetIndex());
            if (iScatterDataSet != null && iScatterDataSet.isHighlightEnabled()) {
                ?? entryForXValue = iScatterDataSet.getEntryForXValue(highlight.getX(), highlight.getY());
                if (isInBoundsX(entryForXValue, iScatterDataSet)) {
                    MPPointD pixelForValues = this.mChart.getTransformer(iScatterDataSet.getAxisDependency()).getPixelForValues(entryForXValue.getX(), entryForXValue.getY() * this.mAnimator.getPhaseY());
                    highlight.setDraw((float) pixelForValues.f37330x, (float) pixelForValues.f37331y);
                    drawHighlightLines(canvas, (float) pixelForValues.f37330x, (float) pixelForValues.f37331y, iScatterDataSet);
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
        IScatterDataSet iScatterDataSet;
        Entry entry;
        if (isDrawingValuesAllowed(this.mChart)) {
            List<T> dataSets = this.mChart.getScatterData().getDataSets();
            for (int i4 = 0; i4 < this.mChart.getScatterData().getDataSetCount(); i4++) {
                IScatterDataSet iScatterDataSet2 = (IScatterDataSet) dataSets.get(i4);
                if (shouldDrawValues(iScatterDataSet2) && iScatterDataSet2.getEntryCount() >= 1) {
                    applyValueTextStyle(iScatterDataSet2);
                    this.mXBounds.set(this.mChart, iScatterDataSet2);
                    Transformer transformer = this.mChart.getTransformer(iScatterDataSet2.getAxisDependency());
                    float phaseX = this.mAnimator.getPhaseX();
                    float phaseY = this.mAnimator.getPhaseY();
                    BarLineScatterCandleBubbleRenderer.XBounds xBounds = this.mXBounds;
                    float[] generateTransformedValuesScatter = transformer.generateTransformedValuesScatter(iScatterDataSet2, phaseX, phaseY, xBounds.min, xBounds.max);
                    float convertDpToPixel = Utils.convertDpToPixel(iScatterDataSet2.getScatterShapeSize());
                    ValueFormatter valueFormatter = iScatterDataSet2.getValueFormatter();
                    MPPointF mPPointF = MPPointF.getInstance(iScatterDataSet2.getIconsOffset());
                    mPPointF.f37332x = Utils.convertDpToPixel(mPPointF.f37332x);
                    mPPointF.f37333y = Utils.convertDpToPixel(mPPointF.f37333y);
                    int i5 = 0;
                    while (i5 < generateTransformedValuesScatter.length && this.mViewPortHandler.isInBoundsRight(generateTransformedValuesScatter[i5])) {
                        if (this.mViewPortHandler.isInBoundsLeft(generateTransformedValuesScatter[i5])) {
                            int i6 = i5 + 1;
                            if (this.mViewPortHandler.isInBoundsY(generateTransformedValuesScatter[i6])) {
                                int i7 = i5 / 2;
                                Entry entryForIndex = iScatterDataSet2.getEntryForIndex(this.mXBounds.min + i7);
                                if (iScatterDataSet2.isDrawValuesEnabled()) {
                                    entry = entryForIndex;
                                    iScatterDataSet = iScatterDataSet2;
                                    drawValue(canvas, valueFormatter.getPointLabel(entryForIndex), generateTransformedValuesScatter[i5], generateTransformedValuesScatter[i6] - convertDpToPixel, iScatterDataSet2.getValueTextColor(i7 + this.mXBounds.min));
                                } else {
                                    entry = entryForIndex;
                                    iScatterDataSet = iScatterDataSet2;
                                }
                                if (entry.getIcon() != null && iScatterDataSet.isDrawIconsEnabled()) {
                                    Drawable icon = entry.getIcon();
                                    Utils.drawImage(canvas, icon, (int) (generateTransformedValuesScatter[i5] + mPPointF.f37332x), (int) (generateTransformedValuesScatter[i6] + mPPointF.f37333y), icon.getIntrinsicWidth(), icon.getIntrinsicHeight());
                                }
                                i5 += 2;
                                iScatterDataSet2 = iScatterDataSet;
                            }
                        }
                        iScatterDataSet = iScatterDataSet2;
                        i5 += 2;
                        iScatterDataSet2 = iScatterDataSet;
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
