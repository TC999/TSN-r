package com.github.mikephil.charting.highlight;

import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarLineScatterCandleBubbleData;
import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.interfaces.dataprovider.BarLineScatterCandleBubbleDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.utils.MPPointD;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class ChartHighlighter<T extends BarLineScatterCandleBubbleDataProvider> implements IHighlighter {
    protected T mChart;
    protected List<Highlight> mHighlightBuffer = new ArrayList();

    public ChartHighlighter(T t3) {
        this.mChart = t3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public List<Highlight> buildHighlights(IDataSet iDataSet, int i4, float f4, DataSet.Rounding rounding) {
        Entry entryForXValue;
        ArrayList arrayList = new ArrayList();
        List<Entry> entriesForXValue = iDataSet.getEntriesForXValue(f4);
        if (entriesForXValue.size() == 0 && (entryForXValue = iDataSet.getEntryForXValue(f4, Float.NaN, rounding)) != null) {
            entriesForXValue = iDataSet.getEntriesForXValue(entryForXValue.getX());
        }
        if (entriesForXValue.size() == 0) {
            return arrayList;
        }
        for (Entry entry : entriesForXValue) {
            MPPointD pixelForValues = this.mChart.getTransformer(iDataSet.getAxisDependency()).getPixelForValues(entry.getX(), entry.getY());
            arrayList.add(new Highlight(entry.getX(), entry.getY(), (float) pixelForValues.f37330x, (float) pixelForValues.f37331y, i4, iDataSet.getAxisDependency()));
        }
        return arrayList;
    }

    public Highlight getClosestHighlightByPixel(List<Highlight> list, float f4, float f5, YAxis.AxisDependency axisDependency, float f6) {
        Highlight highlight = null;
        for (int i4 = 0; i4 < list.size(); i4++) {
            Highlight highlight2 = list.get(i4);
            if (axisDependency == null || highlight2.getAxis() == axisDependency) {
                float distance = getDistance(f4, f5, highlight2.getXPx(), highlight2.getYPx());
                if (distance < f6) {
                    highlight = highlight2;
                    f6 = distance;
                }
            }
        }
        return highlight;
    }

    protected BarLineScatterCandleBubbleData getData() {
        return this.mChart.getData();
    }

    protected float getDistance(float f4, float f5, float f6, float f7) {
        return (float) Math.hypot(f4 - f6, f5 - f7);
    }

    @Override // com.github.mikephil.charting.highlight.IHighlighter
    public Highlight getHighlight(float f4, float f5) {
        MPPointD valsForTouch = getValsForTouch(f4, f5);
        MPPointD.recycleInstance(valsForTouch);
        return getHighlightForX((float) valsForTouch.f37330x, f4, f5);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Highlight getHighlightForX(float f4, float f5, float f6) {
        List<Highlight> highlightsAtXValue = getHighlightsAtXValue(f4, f5, f6);
        if (highlightsAtXValue.isEmpty()) {
            return null;
        }
        YAxis.AxisDependency axisDependency = YAxis.AxisDependency.LEFT;
        float minimumDistance = getMinimumDistance(highlightsAtXValue, f6, axisDependency);
        YAxis.AxisDependency axisDependency2 = YAxis.AxisDependency.RIGHT;
        return getClosestHighlightByPixel(highlightsAtXValue, f5, f6, minimumDistance < getMinimumDistance(highlightsAtXValue, f6, axisDependency2) ? axisDependency : axisDependency2, this.mChart.getMaxHighlightDistance());
    }

    protected float getHighlightPos(Highlight highlight) {
        return highlight.getYPx();
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [com.github.mikephil.charting.interfaces.datasets.IDataSet] */
    protected List<Highlight> getHighlightsAtXValue(float f4, float f5, float f6) {
        this.mHighlightBuffer.clear();
        BarLineScatterCandleBubbleData data = getData();
        if (data == null) {
            return this.mHighlightBuffer;
        }
        int dataSetCount = data.getDataSetCount();
        for (int i4 = 0; i4 < dataSetCount; i4++) {
            ?? dataSetByIndex = data.getDataSetByIndex(i4);
            if (dataSetByIndex.isHighlightEnabled()) {
                this.mHighlightBuffer.addAll(buildHighlights(dataSetByIndex, i4, f4, DataSet.Rounding.CLOSEST));
            }
        }
        return this.mHighlightBuffer;
    }

    protected float getMinimumDistance(List<Highlight> list, float f4, YAxis.AxisDependency axisDependency) {
        float f5 = Float.MAX_VALUE;
        for (int i4 = 0; i4 < list.size(); i4++) {
            Highlight highlight = list.get(i4);
            if (highlight.getAxis() == axisDependency) {
                float abs = Math.abs(getHighlightPos(highlight) - f4);
                if (abs < f5) {
                    f5 = abs;
                }
            }
        }
        return f5;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public MPPointD getValsForTouch(float f4, float f5) {
        return this.mChart.getTransformer(YAxis.AxisDependency.LEFT).getValuesByTouchPoint(f4, f5);
    }
}
