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

/* loaded from: E:\fuckcool\tsn\5141176.dex */
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
    public void computeAxisValues(float f, float f2) {
        double ceil;
        double nextUp;
        int i;
        float f3 = f;
        int labelCount = this.mAxis.getLabelCount();
        double abs = Math.abs(f2 - f3);
        if (labelCount != 0 && abs > Utils.DOUBLE_EPSILON && !Double.isInfinite(abs)) {
            double d = labelCount;
            Double.isNaN(abs);
            Double.isNaN(d);
            double roundToNextSignificant = Utils.roundToNextSignificant(abs / d);
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
                float f4 = ((float) abs) / (labelCount - 1);
                AxisBase axisBase = this.mAxis;
                axisBase.mEntryCount = labelCount;
                if (axisBase.mEntries.length < labelCount) {
                    axisBase.mEntries = new float[labelCount];
                }
                for (int i2 = 0; i2 < labelCount; i2++) {
                    this.mAxis.mEntries[i2] = f3;
                    f3 += f4;
                }
            } else {
                if (roundToNextSignificant == Utils.DOUBLE_EPSILON) {
                    ceil = Utils.DOUBLE_EPSILON;
                } else {
                    double d2 = f3;
                    Double.isNaN(d2);
                    ceil = Math.ceil(d2 / roundToNextSignificant) * roundToNextSignificant;
                }
                if (isCenterAxisLabelsEnabled) {
                    ceil -= roundToNextSignificant;
                }
                if (roundToNextSignificant == Utils.DOUBLE_EPSILON) {
                    nextUp = 0.0d;
                } else {
                    double d3 = f2;
                    Double.isNaN(d3);
                    nextUp = Utils.nextUp(Math.floor(d3 / roundToNextSignificant) * roundToNextSignificant);
                }
                if (roundToNextSignificant != Utils.DOUBLE_EPSILON) {
                    i = isCenterAxisLabelsEnabled;
                    for (double d4 = ceil; d4 <= nextUp; d4 += roundToNextSignificant) {
                        i++;
                    }
                } else {
                    i = isCenterAxisLabelsEnabled;
                }
                int i3 = i + 1;
                AxisBase axisBase2 = this.mAxis;
                axisBase2.mEntryCount = i3;
                if (axisBase2.mEntries.length < i3) {
                    axisBase2.mEntries = new float[i3];
                }
                for (int i4 = 0; i4 < i3; i4++) {
                    if (ceil == Utils.DOUBLE_EPSILON) {
                        ceil = 0.0d;
                    }
                    this.mAxis.mEntries[i4] = (float) ceil;
                    ceil += roundToNextSignificant;
                }
                labelCount = i3;
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
                float f5 = (fArr[1] - fArr[0]) / 2.0f;
                for (int i5 = 0; i5 < labelCount; i5++) {
                    AxisBase axisBase4 = this.mAxis;
                    axisBase4.mCenteredEntries[i5] = axisBase4.mEntries[i5] + f5;
                }
            }
            AxisBase axisBase5 = this.mAxis;
            float[] fArr2 = axisBase5.mEntries;
            float f6 = fArr2[0];
            axisBase5.mAxisMinimum = f6;
            float f7 = fArr2[labelCount - 1];
            axisBase5.mAxisMaximum = f7;
            axisBase5.mAxisRange = Math.abs(f7 - f6);
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
            int i = this.mYAxis.isDrawTopYLabelEntryEnabled() ? this.mYAxis.mEntryCount : this.mYAxis.mEntryCount - 1;
            for (int i2 = !this.mYAxis.isDrawBottomYLabelEntryEnabled(); i2 < i; i2++) {
                YAxis yAxis = this.mYAxis;
                Utils.getPosition(centerOffsets, (yAxis.mEntries[i2] - yAxis.mAxisMinimum) * factor, this.mChart.getRotationAngle(), mPPointF);
                canvas.drawText(this.mYAxis.getFormattedLabel(i2), mPPointF.f23783x + 10.0f, mPPointF.f23784y, this.mAxisLabelPaint);
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
        for (int i = 0; i < limitLines.size(); i++) {
            LimitLine limitLine = limitLines.get(i);
            if (limitLine.isEnabled()) {
                this.mLimitLinePaint.setColor(limitLine.getLineColor());
                this.mLimitLinePaint.setPathEffect(limitLine.getDashPathEffect());
                this.mLimitLinePaint.setStrokeWidth(limitLine.getLineWidth());
                float limit = (limitLine.getLimit() - this.mChart.getYChartMin()) * factor;
                Path path = this.mRenderLimitLinesPathBuffer;
                path.reset();
                for (int i2 = 0; i2 < ((RadarData) this.mChart.getData()).getMaxEntryCountSet().getEntryCount(); i2++) {
                    Utils.getPosition(centerOffsets, limit, (i2 * sliceAngle) + this.mChart.getRotationAngle(), mPPointF);
                    if (i2 == 0) {
                        path.moveTo(mPPointF.f23783x, mPPointF.f23784y);
                    } else {
                        path.lineTo(mPPointF.f23783x, mPPointF.f23784y);
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
