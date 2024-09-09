package com.github.mikephil.charting.highlight;

import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarLineScatterCandleBubbleData;
import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.interfaces.dataprovider.BarDataProvider;
import com.github.mikephil.charting.interfaces.dataprovider.CombinedDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class CombinedHighlighter extends ChartHighlighter<CombinedDataProvider> implements IHighlighter {
    protected BarHighlighter barHighlighter;

    public CombinedHighlighter(CombinedDataProvider combinedDataProvider, BarDataProvider barDataProvider) {
        super(combinedDataProvider);
        this.barHighlighter = barDataProvider.getBarData() == null ? null : new BarHighlighter(barDataProvider);
    }

    @Override // com.github.mikephil.charting.highlight.ChartHighlighter
    protected List<Highlight> getHighlightsAtXValue(float f4, float f5, float f6) {
        this.mHighlightBuffer.clear();
        List<BarLineScatterCandleBubbleData> allData = ((CombinedDataProvider) this.mChart).getCombinedData().getAllData();
        for (int i4 = 0; i4 < allData.size(); i4++) {
            BarLineScatterCandleBubbleData barLineScatterCandleBubbleData = allData.get(i4);
            BarHighlighter barHighlighter = this.barHighlighter;
            if (barHighlighter != null && (barLineScatterCandleBubbleData instanceof BarData)) {
                Highlight highlight = barHighlighter.getHighlight(f5, f6);
                if (highlight != null) {
                    highlight.setDataIndex(i4);
                    this.mHighlightBuffer.add(highlight);
                }
            } else {
                int dataSetCount = barLineScatterCandleBubbleData.getDataSetCount();
                for (int i5 = 0; i5 < dataSetCount; i5++) {
                    IDataSet dataSetByIndex = allData.get(i4).getDataSetByIndex(i5);
                    if (dataSetByIndex.isHighlightEnabled()) {
                        for (Highlight highlight2 : buildHighlights(dataSetByIndex, i5, f4, DataSet.Rounding.CLOSEST)) {
                            highlight2.setDataIndex(i4);
                            this.mHighlightBuffer.add(highlight2);
                        }
                    }
                }
            }
        }
        return this.mHighlightBuffer;
    }
}
