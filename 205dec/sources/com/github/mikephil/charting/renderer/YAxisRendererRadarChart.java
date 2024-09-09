package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Path;
import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class YAxisRendererRadarChart extends YAxisRenderer {
    private RadarChart mChart;
    private Path mRenderLimitLinesPathBuffer;

    public YAxisRendererRadarChart(ViewPortHandler viewPortHandler, YAxis yAxis, RadarChart radarChart) {
        super(viewPortHandler, yAxis, null);
        this.mRenderLimitLinesPathBuffer = new Path();
        this.mChart = radarChart;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.github.mikephil.charting.renderer.AxisRenderer
    public void computeAxisValues(float f4, float f5) {
        double ceil;
        double nextUp;
        int i4;
        float f6 = f4;
        int labelCount = this.mAxis.getLabelCount();
        double abs = Math.abs(f5 - f6);
        if (labelCount != 0 && abs > 0.0d && !Double.isInfinite(abs)) {
            double d4 = labelCount;
            Double.isNaN(abs);
            Double.isNaN(d4);
            double roundToNextSignificant = Utils.roundToNextSignificant(abs / d4);
            if (this.mAxis.isGranularityEnabled() && roundToNextSignificant < this.mAxis.getGranularity()) {
                roundToNextSignificant = this.mAxis.getGranularity();
            }
            double roundToNextSignificant2 = Utils.roundToNextSignificant(Math.pow(10.0d, (int) Math.log10(roundToNextSignificant)));
            Double.isNaN(roundToNextSignificant2);
            if (((int) (roundToNextSignificant / roundToNextSignificant2)) > 5) {
                Double.isNaN(roundToNextSignificant2);
                roundToNextSignificant = Math.floor(roundToNextSignificant2 * 10.0d);
            }
            boolean isCenterAxisLabelsEnabled = this.mAxis.isCenterAxisLabelsEnabled();
            if (this.mAxis.isForceLabelsEnabled()) {
                float f7 = ((float) abs) / (labelCount - 1);
                AxisBase axisBase = this.mAxis;
                axisBase.mEntryCount = labelCount;
                if (axisBase.mEntries.length < labelCount) {
                    axisBase.mEntries = new float[labelCount];
                }
                for (int i5 = 0; i5 < labelCount; i5++) {
                    this.mAxis.mEntries[i5] = f6;
                    f6 += f7;
                }
            } else {
                if (roundToNextSignificant == 0.0d) {
                    ceil = 0.0d;
                } else {
                    double d5 = f6;
                    Double.isNaN(d5);
                    ceil = Math.ceil(d5 / roundToNextSignificant) * roundToNextSignificant;
                }
                if (isCenterAxisLabelsEnabled) {
                    ceil -= roundToNextSignificant;
                }
                if (roundToNextSignificant == 0.0d) {
                    nextUp = 0.0d;
                } else {
                    double d6 = f5;
                    Double.isNaN(d6);
                    nextUp = Utils.nextUp(Math.floor(d6 / roundToNextSignificant) * roundToNextSignificant);
                }
                if (roundToNextSignificant != 0.0d) {
                    i4 = isCenterAxisLabelsEnabled;
                    for (double d7 = ceil; d7 <= nextUp; d7 += roundToNextSignificant) {
                        i4++;
                    }
                } else {
                    i4 = isCenterAxisLabelsEnabled;
                }
                int i6 = i4 + 1;
                AxisBase axisBase2 = this.mAxis;
                axisBase2.mEntryCount = i6;
                if (axisBase2.mEntries.length < i6) {
                    axisBase2.mEntries = new float[i6];
                }
                for (int i7 = 0; i7 < i6; i7++) {
                    if (ceil == 0.0d) {
                        ceil = 0.0d;
                    }
                    this.mAxis.mEntries[i7] = (float) ceil;
                    ceil += roundToNextSignificant;
                }
                labelCount = i6;
            }
            if (roundToNextSignificant < 1.0d) {
                this.mAxis.mDecimals = (int) Math.ceil(-Math.log10(roundToNextSignificant));
            } else {
                this.mAxis.mDecimals = 0;
            }
            if (isCenterAxisLabelsEnabled != 0) {
                AxisBase axisBase3 = this.mAxis;
                if (axisBase3.mCenteredEntries.length < labelCount) {
                    axisBase3.mCenteredEntries = new float[labelCount];
                }
                float[] fArr = axisBase3.mEntries;
                float f8 = (fArr[1] - fArr[0]) / 2.0f;
                for (int i8 = 0; i8 < labelCount; i8++) {
                    AxisBase axisBase4 = this.mAxis;
                    axisBase4.mCenteredEntries[i8] = axisBase4.mEntries[i8] + f8;
                }
            }
            AxisBase axisBase5 = this.mAxis;
            float[] fArr2 = axisBase5.mEntries;
            float f9 = fArr2[0];
            axisBase5.mAxisMinimum = f9;
            float f10 = fArr2[labelCount - 1];
            axisBase5.mAxisMaximum = f10;
            axisBase5.mAxisRange = Math.abs(f10 - f9);
            return;
        }
        AxisBase axisBase6 = this.mAxis;
        axisBase6.mEntries = new float[0];
        axisBase6.mCenteredEntries = new float[0];
        axisBase6.mEntryCount = 0;
    }

    @Override // com.github.mikephil.charting.renderer.YAxisRenderer, com.github.mikephil.charting.renderer.AxisRenderer
    public void renderAxisLabels(Canvas canvas) {
        if (this.mYAxis.isEnabled() && this.mYAxis.isDrawLabelsEnabled()) {
            this.mAxisLabelPaint.setTypeface(this.mYAxis.getTypeface());
            this.mAxisLabelPaint.setTextSize(this.mYAxis.getTextSize());
            this.mAxisLabelPaint.setColor(this.mYAxis.getTextColor());
            MPPointF centerOffsets = this.mChart.getCenterOffsets();
            MPPointF mPPointF = MPPointF.getInstance(0.0f, 0.0f);
            float factor = this.mChart.getFactor();
            int i4 = this.mYAxis.isDrawTopYLabelEntryEnabled() ? this.mYAxis.mEntryCount : this.mYAxis.mEntryCount - 1;
            for (int i5 = !this.mYAxis.isDrawBottomYLabelEntryEnabled(); i5 < i4; i5++) {
                YAxis yAxis = this.mYAxis;
                Utils.getPosition(centerOffsets, (yAxis.mEntries[i5] - yAxis.mAxisMinimum) * factor, this.mChart.getRotationAngle(), mPPointF);
                canvas.drawText(this.mYAxis.getFormattedLabel(i5), mPPointF.f37332x + 10.0f, mPPointF.f37333y, this.mAxisLabelPaint);
            }
            MPPointF.recycleInstance(centerOffsets);
            MPPointF.recycleInstance(mPPointF);
        }
    }

    @Override // com.github.mikephil.charting.renderer.YAxisRenderer, com.github.mikephil.charting.renderer.AxisRenderer
    public void renderLimitLines(Canvas canvas) {
        List<LimitLine> limitLines = this.mYAxis.getLimitLines();
        if (limitLines == null) {
            return;
        }
        float sliceAngle = this.mChart.getSliceAngle();
        float factor = this.mChart.getFactor();
        MPPointF centerOffsets = this.mChart.getCenterOffsets();
        MPPointF mPPointF = MPPointF.getInstance(0.0f, 0.0f);
        for (int i4 = 0; i4 < limitLines.size(); i4++) {
            LimitLine limitLine = limitLines.get(i4);
            if (limitLine.isEnabled()) {
                this.mLimitLinePaint.setColor(limitLine.getLineColor());
                this.mLimitLinePaint.setPathEffect(limitLine.getDashPathEffect());
                this.mLimitLinePaint.setStrokeWidth(limitLine.getLineWidth());
                float limit = (limitLine.getLimit() - this.mChart.getYChartMin()) * factor;
                Path path = this.mRenderLimitLinesPathBuffer;
                path.reset();
                for (int i5 = 0; i5 < ((RadarData) this.mChart.getData()).getMaxEntryCountSet().getEntryCount(); i5++) {
                    Utils.getPosition(centerOffsets, limit, (i5 * sliceAngle) + this.mChart.getRotationAngle(), mPPointF);
                    if (i5 == 0) {
                        path.moveTo(mPPointF.f37332x, mPPointF.f37333y);
                    } else {
                        path.lineTo(mPPointF.f37332x, mPPointF.f37333y);
                    }
                }
                path.close();
                canvas.drawPath(path, this.mLimitLinePaint);
            }
        }
        MPPointF.recycleInstance(centerOffsets);
        MPPointF.recycleInstance(mPPointF);
    }
}
