package com.github.mikephil.charting.interfaces.dataprovider;

import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.LineData;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public interface LineDataProvider extends BarLineScatterCandleBubbleDataProvider {
    YAxis getAxis(YAxis.AxisDependency axisDependency);

    LineData getLineData();
}
