package com.github.mikephil.charting.highlight;

import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.interfaces.datasets.IRadarDataSet;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class RadarHighlighter extends PieRadarHighlighter<RadarChart> {
    public RadarHighlighter(RadarChart radarChart) {
        super(radarChart);
    }

    @Override // com.github.mikephil.charting.highlight.PieRadarHighlighter
    protected Highlight getClosestHighlight(int i4, float f4, float f5) {
        List<Highlight> highlightsAtIndex = getHighlightsAtIndex(i4);
        float distanceToCenter = ((RadarChart) this.mChart).distanceToCenter(f4, f5) / ((RadarChart) this.mChart).getFactor();
        Highlight highlight = null;
        float f6 = Float.MAX_VALUE;
        for (int i5 = 0; i5 < highlightsAtIndex.size(); i5++) {
            Highlight highlight2 = highlightsAtIndex.get(i5);
            float abs = Math.abs(highlight2.getY() - distanceToCenter);
            if (abs < f6) {
                highlight = highlight2;
                f6 = abs;
            }
        }
        return highlight;
    }

    /* JADX WARN: Type inference failed for: r9v0, types: [com.github.mikephil.charting.data.Entry, com.github.mikephil.charting.data.BaseEntry] */
    protected List<Highlight> getHighlightsAtIndex(int i4) {
        int i5 = i4;
        this.mHighlightBuffer.clear();
        float phaseX = ((RadarChart) this.mChart).getAnimator().getPhaseX();
        float phaseY = ((RadarChart) this.mChart).getAnimator().getPhaseY();
        float sliceAngle = ((RadarChart) this.mChart).getSliceAngle();
        float factor = ((RadarChart) this.mChart).getFactor();
        MPPointF mPPointF = MPPointF.getInstance(0.0f, 0.0f);
        int i6 = 0;
        while (i6 < ((RadarData) ((RadarChart) this.mChart).getData()).getDataSetCount()) {
            IRadarDataSet dataSetByIndex = ((RadarData) ((RadarChart) this.mChart).getData()).getDataSetByIndex(i6);
            ?? entryForIndex = dataSetByIndex.getEntryForIndex(i5);
            float f4 = i5;
            Utils.getPosition(((RadarChart) this.mChart).getCenterOffsets(), (entryForIndex.getY() - ((RadarChart) this.mChart).getYChartMin()) * factor * phaseY, (sliceAngle * f4 * phaseX) + ((RadarChart) this.mChart).getRotationAngle(), mPPointF);
            this.mHighlightBuffer.add(new Highlight(f4, entryForIndex.getY(), mPPointF.f37332x, mPPointF.f37333y, i6, dataSetByIndex.getAxisDependency()));
            i6++;
            i5 = i4;
        }
        return this.mHighlightBuffer;
    }
}
