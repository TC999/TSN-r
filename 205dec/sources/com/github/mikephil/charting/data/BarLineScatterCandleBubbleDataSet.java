package com.github.mikephil.charting.data;

import android.graphics.Color;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.interfaces.datasets.IBarLineScatterCandleBubbleDataSet;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public abstract class BarLineScatterCandleBubbleDataSet<T extends Entry> extends DataSet<T> implements IBarLineScatterCandleBubbleDataSet<T> {
    protected int mHighLightColor;

    public BarLineScatterCandleBubbleDataSet(List<T> list, String str) {
        super(list, str);
        this.mHighLightColor = Color.rgb(255, 187, 115);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void copy(BarLineScatterCandleBubbleDataSet barLineScatterCandleBubbleDataSet) {
        super.copy((DataSet) barLineScatterCandleBubbleDataSet);
        barLineScatterCandleBubbleDataSet.mHighLightColor = this.mHighLightColor;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IBarLineScatterCandleBubbleDataSet
    public int getHighLightColor() {
        return this.mHighLightColor;
    }

    public void setHighLightColor(int i4) {
        this.mHighLightColor = i4;
    }
}
