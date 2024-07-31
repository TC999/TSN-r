package com.github.mikephil.charting.formatter;

import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.interfaces.dataprovider.LineDataProvider;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class DefaultFillFormatter implements IFillFormatter {
    @Override // com.github.mikephil.charting.formatter.IFillFormatter
    public float getFillLinePosition(ILineDataSet iLineDataSet, LineDataProvider lineDataProvider) {
        float yChartMax = lineDataProvider.getYChartMax();
        float yChartMin = lineDataProvider.getYChartMin();
        LineData lineData = lineDataProvider.getLineData();
        if (iLineDataSet.getYMax() <= 0.0f || iLineDataSet.getYMin() >= 0.0f) {
            if (lineData.getYMax() > 0.0f) {
                yChartMax = 0.0f;
            }
            if (lineData.getYMin() < 0.0f) {
                yChartMin = 0.0f;
            }
            return iLineDataSet.getYMin() >= 0.0f ? yChartMin : yChartMax;
        }
        return 0.0f;
    }
}
