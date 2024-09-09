package com.github.mikephil.charting.data;

import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class LineData extends BarLineScatterCandleBubbleData<ILineDataSet> {
    public LineData() {
    }

    public LineData(ILineDataSet... iLineDataSetArr) {
        super(iLineDataSetArr);
    }

    public LineData(List<ILineDataSet> list) {
        super(list);
    }
}
