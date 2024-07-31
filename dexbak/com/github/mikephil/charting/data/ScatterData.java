package com.github.mikephil.charting.data;

import com.github.mikephil.charting.interfaces.datasets.IScatterDataSet;
import java.util.List;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class ScatterData extends BarLineScatterCandleBubbleData<IScatterDataSet> {
    public ScatterData() {
    }

    public float getGreatestShapeSize() {
        float f = 0.0f;
        for (T t : this.mDataSets) {
            float scatterShapeSize = t.getScatterShapeSize();
            if (scatterShapeSize > f) {
                f = scatterShapeSize;
            }
        }
        return f;
    }

    public ScatterData(List<IScatterDataSet> list) {
        super(list);
    }

    public ScatterData(IScatterDataSet... iScatterDataSetArr) {
        super(iScatterDataSetArr);
    }
}
