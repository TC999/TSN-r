package com.github.mikephil.charting.interfaces.datasets;

import android.graphics.DashPathEffect;
import com.github.mikephil.charting.data.Entry;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public interface ILineScatterCandleRadarDataSet<T extends Entry> extends IBarLineScatterCandleBubbleDataSet<T> {
    DashPathEffect getDashPathEffectHighlight();

    float getHighlightLineWidth();

    boolean isHorizontalHighlightIndicatorEnabled();

    boolean isVerticalHighlightIndicatorEnabled();
}
