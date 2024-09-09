package com.github.mikephil.charting.formatter;

import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.BubbleEntry;
import com.github.mikephil.charting.data.CandleEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.data.RadarEntry;
import com.github.mikephil.charting.utils.ViewPortHandler;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public abstract class ValueFormatter implements IAxisValueFormatter, IValueFormatter {
    public String getAxisLabel(float f4, AxisBase axisBase) {
        return getFormattedValue(f4);
    }

    public String getBarLabel(BarEntry barEntry) {
        return getFormattedValue(barEntry.getY());
    }

    public String getBarStackedLabel(float f4, BarEntry barEntry) {
        return getFormattedValue(f4);
    }

    public String getBubbleLabel(BubbleEntry bubbleEntry) {
        return getFormattedValue(bubbleEntry.getSize());
    }

    public String getCandleLabel(CandleEntry candleEntry) {
        return getFormattedValue(candleEntry.getHigh());
    }

    @Override // com.github.mikephil.charting.formatter.IAxisValueFormatter
    @Deprecated
    public String getFormattedValue(float f4, AxisBase axisBase) {
        return getFormattedValue(f4);
    }

    public String getPieLabel(float f4, PieEntry pieEntry) {
        return getFormattedValue(f4);
    }

    public String getPointLabel(Entry entry) {
        return getFormattedValue(entry.getY());
    }

    public String getRadarLabel(RadarEntry radarEntry) {
        return getFormattedValue(radarEntry.getY());
    }

    @Override // com.github.mikephil.charting.formatter.IValueFormatter
    @Deprecated
    public String getFormattedValue(float f4, Entry entry, int i4, ViewPortHandler viewPortHandler) {
        return getFormattedValue(f4);
    }

    public String getFormattedValue(float f4) {
        return String.valueOf(f4);
    }
}
