package com.github.mikephil.charting.highlight;

import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.BarLineScatterCandleBubbleData;
import com.github.mikephil.charting.interfaces.dataprovider.BarDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.MPPointD;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class BarHighlighter extends ChartHighlighter<BarDataProvider> {
    public BarHighlighter(BarDataProvider barDataProvider) {
        super(barDataProvider);
    }

    protected int getClosestStackIndex(Range[] rangeArr, float f4) {
        if (rangeArr == null || rangeArr.length == 0) {
            return 0;
        }
        int i4 = 0;
        for (Range range : rangeArr) {
            if (range.contains(f4)) {
                return i4;
            }
            i4++;
        }
        int max = Math.max(rangeArr.length - 1, 0);
        if (f4 > rangeArr[max].to) {
            return max;
        }
        return 0;
    }

    @Override // com.github.mikephil.charting.highlight.ChartHighlighter
    protected BarLineScatterCandleBubbleData getData() {
        return ((BarDataProvider) this.mChart).getBarData();
    }

    @Override // com.github.mikephil.charting.highlight.ChartHighlighter
    protected float getDistance(float f4, float f5, float f6, float f7) {
        return Math.abs(f4 - f6);
    }

    @Override // com.github.mikephil.charting.highlight.ChartHighlighter, com.github.mikephil.charting.highlight.IHighlighter
    public Highlight getHighlight(float f4, float f5) {
        Highlight highlight = super.getHighlight(f4, f5);
        if (highlight == null) {
            return null;
        }
        MPPointD valsForTouch = getValsForTouch(f4, f5);
        IBarDataSet iBarDataSet = (IBarDataSet) ((BarDataProvider) this.mChart).getBarData().getDataSetByIndex(highlight.getDataSetIndex());
        if (iBarDataSet.isStacked()) {
            return getStackedHighlight(highlight, iBarDataSet, (float) valsForTouch.f37330x, (float) valsForTouch.f37331y);
        }
        MPPointD.recycleInstance(valsForTouch);
        return highlight;
    }

    public Highlight getStackedHighlight(Highlight highlight, IBarDataSet iBarDataSet, float f4, float f5) {
        BarEntry barEntry = (BarEntry) iBarDataSet.getEntryForXValue(f4, f5);
        if (barEntry == null) {
            return null;
        }
        if (barEntry.getYVals() == null) {
            return highlight;
        }
        Range[] ranges = barEntry.getRanges();
        if (ranges.length > 0) {
            int closestStackIndex = getClosestStackIndex(ranges, f5);
            MPPointD pixelForValues = ((BarDataProvider) this.mChart).getTransformer(iBarDataSet.getAxisDependency()).getPixelForValues(highlight.getX(), ranges[closestStackIndex].to);
            Highlight highlight2 = new Highlight(barEntry.getX(), barEntry.getY(), (float) pixelForValues.f37330x, (float) pixelForValues.f37331y, highlight.getDataSetIndex(), closestStackIndex, highlight.getAxis());
            MPPointD.recycleInstance(pixelForValues);
            return highlight2;
        }
        return null;
    }
}
