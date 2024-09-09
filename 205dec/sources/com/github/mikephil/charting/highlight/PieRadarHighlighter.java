package com.github.mikephil.charting.highlight;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.charts.PieRadarChartBase;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public abstract class PieRadarHighlighter<T extends PieRadarChartBase> implements IHighlighter {
    protected T mChart;
    protected List<Highlight> mHighlightBuffer = new ArrayList();

    public PieRadarHighlighter(T t3) {
        this.mChart = t3;
    }

    protected abstract Highlight getClosestHighlight(int i4, float f4, float f5);

    @Override // com.github.mikephil.charting.highlight.IHighlighter
    public Highlight getHighlight(float f4, float f5) {
        if (this.mChart.distanceToCenter(f4, f5) > this.mChart.getRadius()) {
            return null;
        }
        float angleForPoint = this.mChart.getAngleForPoint(f4, f5);
        T t3 = this.mChart;
        if (t3 instanceof PieChart) {
            angleForPoint /= t3.getAnimator().getPhaseY();
        }
        int indexForAngle = this.mChart.getIndexForAngle(angleForPoint);
        if (indexForAngle < 0 || indexForAngle >= this.mChart.getData().getMaxEntryCountSet().getEntryCount()) {
            return null;
        }
        return getClosestHighlight(indexForAngle, f4, f5);
    }
}
