package com.github.mikephil.charting.data;

import com.github.mikephil.charting.interfaces.datasets.IScatterDataSet;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class ScatterData extends BarLineScatterCandleBubbleData<IScatterDataSet> {
    public ScatterData() {
    }

    public float getGreatestShapeSize() {
        float f4 = 0.0f;
        for (T t3 : this.mDataSets) {
            float scatterShapeSize = t3.getScatterShapeSize();
            if (scatterShapeSize > f4) {
                f4 = scatterShapeSize;
            }
        }
        return f4;
    }

    public ScatterData(List<IScatterDataSet> list) {
        super(list);
    }

    public ScatterData(IScatterDataSet... iScatterDataSetArr) {
        super(iScatterDataSetArr);
    }
}
