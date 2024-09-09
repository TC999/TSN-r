package com.github.mikephil.charting.data;

import android.util.Log;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.IBarLineScatterCandleBubbleDataSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class CombinedData extends BarLineScatterCandleBubbleData<IBarLineScatterCandleBubbleDataSet<? extends Entry>> {
    private BarData mBarData;
    private BubbleData mBubbleData;
    private CandleData mCandleData;
    private LineData mLineData;
    private ScatterData mScatterData;

    @Override // com.github.mikephil.charting.data.ChartData
    public void calcMinMax() {
        if (this.mDataSets == null) {
            this.mDataSets = new ArrayList();
        }
        this.mDataSets.clear();
        this.mYMax = -3.4028235E38f;
        this.mYMin = Float.MAX_VALUE;
        this.mXMax = -3.4028235E38f;
        this.mXMin = Float.MAX_VALUE;
        this.mLeftAxisMax = -3.4028235E38f;
        this.mLeftAxisMin = Float.MAX_VALUE;
        this.mRightAxisMax = -3.4028235E38f;
        this.mRightAxisMin = Float.MAX_VALUE;
        for (BarLineScatterCandleBubbleData barLineScatterCandleBubbleData : getAllData()) {
            barLineScatterCandleBubbleData.calcMinMax();
            this.mDataSets.addAll(barLineScatterCandleBubbleData.getDataSets());
            if (barLineScatterCandleBubbleData.getYMax() > this.mYMax) {
                this.mYMax = barLineScatterCandleBubbleData.getYMax();
            }
            if (barLineScatterCandleBubbleData.getYMin() < this.mYMin) {
                this.mYMin = barLineScatterCandleBubbleData.getYMin();
            }
            if (barLineScatterCandleBubbleData.getXMax() > this.mXMax) {
                this.mXMax = barLineScatterCandleBubbleData.getXMax();
            }
            if (barLineScatterCandleBubbleData.getXMin() < this.mXMin) {
                this.mXMin = barLineScatterCandleBubbleData.getXMin();
            }
            float f4 = barLineScatterCandleBubbleData.mLeftAxisMax;
            if (f4 > this.mLeftAxisMax) {
                this.mLeftAxisMax = f4;
            }
            float f5 = barLineScatterCandleBubbleData.mLeftAxisMin;
            if (f5 < this.mLeftAxisMin) {
                this.mLeftAxisMin = f5;
            }
            float f6 = barLineScatterCandleBubbleData.mRightAxisMax;
            if (f6 > this.mRightAxisMax) {
                this.mRightAxisMax = f6;
            }
            float f7 = barLineScatterCandleBubbleData.mRightAxisMin;
            if (f7 < this.mRightAxisMin) {
                this.mRightAxisMin = f7;
            }
        }
    }

    public List<BarLineScatterCandleBubbleData> getAllData() {
        ArrayList arrayList = new ArrayList();
        LineData lineData = this.mLineData;
        if (lineData != null) {
            arrayList.add(lineData);
        }
        BarData barData = this.mBarData;
        if (barData != null) {
            arrayList.add(barData);
        }
        ScatterData scatterData = this.mScatterData;
        if (scatterData != null) {
            arrayList.add(scatterData);
        }
        CandleData candleData = this.mCandleData;
        if (candleData != null) {
            arrayList.add(candleData);
        }
        BubbleData bubbleData = this.mBubbleData;
        if (bubbleData != null) {
            arrayList.add(bubbleData);
        }
        return arrayList;
    }

    public BarData getBarData() {
        return this.mBarData;
    }

    public BubbleData getBubbleData() {
        return this.mBubbleData;
    }

    public CandleData getCandleData() {
        return this.mCandleData;
    }

    public BarLineScatterCandleBubbleData getDataByIndex(int i4) {
        return getAllData().get(i4);
    }

    public int getDataIndex(ChartData chartData) {
        return getAllData().indexOf(chartData);
    }

    public IBarLineScatterCandleBubbleDataSet<? extends Entry> getDataSetByHighlight(Highlight highlight) {
        if (highlight.getDataIndex() >= getAllData().size()) {
            return null;
        }
        BarLineScatterCandleBubbleData dataByIndex = getDataByIndex(highlight.getDataIndex());
        if (highlight.getDataSetIndex() >= dataByIndex.getDataSetCount()) {
            return null;
        }
        return (IBarLineScatterCandleBubbleDataSet) dataByIndex.getDataSets().get(highlight.getDataSetIndex());
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x003d  */
    /* JADX WARN: Type inference failed for: r0v3, types: [com.github.mikephil.charting.interfaces.datasets.IDataSet] */
    @Override // com.github.mikephil.charting.data.ChartData
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.github.mikephil.charting.data.Entry getEntryForHighlight(com.github.mikephil.charting.highlight.Highlight r6) {
        /*
            r5 = this;
            int r0 = r6.getDataIndex()
            java.util.List r1 = r5.getAllData()
            int r1 = r1.size()
            r2 = 0
            if (r0 < r1) goto L10
            return r2
        L10:
            int r0 = r6.getDataIndex()
            com.github.mikephil.charting.data.BarLineScatterCandleBubbleData r0 = r5.getDataByIndex(r0)
            int r1 = r6.getDataSetIndex()
            int r3 = r0.getDataSetCount()
            if (r1 < r3) goto L23
            return r2
        L23:
            int r1 = r6.getDataSetIndex()
            com.github.mikephil.charting.interfaces.datasets.IDataSet r0 = r0.getDataSetByIndex(r1)
            float r1 = r6.getX()
            java.util.List r0 = r0.getEntriesForXValue(r1)
            java.util.Iterator r0 = r0.iterator()
        L37:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L5a
            java.lang.Object r1 = r0.next()
            com.github.mikephil.charting.data.Entry r1 = (com.github.mikephil.charting.data.Entry) r1
            float r3 = r1.getY()
            float r4 = r6.getY()
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 == 0) goto L59
            float r3 = r6.getY()
            boolean r3 = java.lang.Float.isNaN(r3)
            if (r3 == 0) goto L37
        L59:
            return r1
        L5a:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.mikephil.charting.data.CombinedData.getEntryForHighlight(com.github.mikephil.charting.highlight.Highlight):com.github.mikephil.charting.data.Entry");
    }

    public LineData getLineData() {
        return this.mLineData;
    }

    public ScatterData getScatterData() {
        return this.mScatterData;
    }

    @Override // com.github.mikephil.charting.data.ChartData
    public void notifyDataChanged() {
        LineData lineData = this.mLineData;
        if (lineData != null) {
            lineData.notifyDataChanged();
        }
        BarData barData = this.mBarData;
        if (barData != null) {
            barData.notifyDataChanged();
        }
        CandleData candleData = this.mCandleData;
        if (candleData != null) {
            candleData.notifyDataChanged();
        }
        ScatterData scatterData = this.mScatterData;
        if (scatterData != null) {
            scatterData.notifyDataChanged();
        }
        BubbleData bubbleData = this.mBubbleData;
        if (bubbleData != null) {
            bubbleData.notifyDataChanged();
        }
        calcMinMax();
    }

    @Override // com.github.mikephil.charting.data.ChartData
    @Deprecated
    public boolean removeEntry(Entry entry, int i4) {
        Log.e("MPAndroidChart", "removeEntry(...) not supported for CombinedData");
        return false;
    }

    public void setData(LineData lineData) {
        this.mLineData = lineData;
        notifyDataChanged();
    }

    @Override // com.github.mikephil.charting.data.ChartData
    public boolean removeDataSet(IBarLineScatterCandleBubbleDataSet<? extends Entry> iBarLineScatterCandleBubbleDataSet) {
        Iterator<BarLineScatterCandleBubbleData> it = getAllData().iterator();
        boolean z3 = false;
        while (it.hasNext() && !(z3 = it.next().removeDataSet((BarLineScatterCandleBubbleData) iBarLineScatterCandleBubbleDataSet))) {
        }
        return z3;
    }

    @Override // com.github.mikephil.charting.data.ChartData
    @Deprecated
    public boolean removeEntry(float f4, int i4) {
        Log.e("MPAndroidChart", "removeEntry(...) not supported for CombinedData");
        return false;
    }

    public void setData(BarData barData) {
        this.mBarData = barData;
        notifyDataChanged();
    }

    @Override // com.github.mikephil.charting.data.ChartData
    @Deprecated
    public boolean removeDataSet(int i4) {
        Log.e("MPAndroidChart", "removeDataSet(int index) not supported for CombinedData");
        return false;
    }

    public void setData(ScatterData scatterData) {
        this.mScatterData = scatterData;
        notifyDataChanged();
    }

    public void setData(CandleData candleData) {
        this.mCandleData = candleData;
        notifyDataChanged();
    }

    public void setData(BubbleData bubbleData) {
        this.mBubbleData = bubbleData;
        notifyDataChanged();
    }
}
