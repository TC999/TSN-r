package com.github.mikephil.charting.data;

import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class BarData extends BarLineScatterCandleBubbleData<IBarDataSet> {
    private float mBarWidth;

    public BarData() {
        this.mBarWidth = 0.85f;
    }

    public float getBarWidth() {
        return this.mBarWidth;
    }

    public float getGroupWidth(float f4, float f5) {
        return (this.mDataSets.size() * (this.mBarWidth + f5)) + f4;
    }

    public void groupBars(float f4, float f5, float f6) {
        BarEntry barEntry;
        if (this.mDataSets.size() > 1) {
            int entryCount = ((IBarDataSet) getMaxEntryCountSet()).getEntryCount();
            float f7 = f5 / 2.0f;
            float f8 = f6 / 2.0f;
            float f9 = this.mBarWidth / 2.0f;
            float groupWidth = getGroupWidth(f5, f6);
            for (int i4 = 0; i4 < entryCount; i4++) {
                float f10 = f4 + f7;
                for (T t3 : this.mDataSets) {
                    float f11 = f10 + f8 + f9;
                    if (i4 < t3.getEntryCount() && (barEntry = (BarEntry) t3.getEntryForIndex(i4)) != null) {
                        barEntry.setX(f11);
                    }
                    f10 = f11 + f9 + f8;
                }
                float f12 = f10 + f7;
                float f13 = groupWidth - (f12 - f4);
                if (f13 > 0.0f || f13 < 0.0f) {
                    f12 += f13;
                }
                f4 = f12;
            }
            notifyDataChanged();
            return;
        }
        throw new RuntimeException("BarData needs to hold at least 2 BarDataSets to allow grouping.");
    }

    public void setBarWidth(float f4) {
        this.mBarWidth = f4;
    }

    public BarData(IBarDataSet... iBarDataSetArr) {
        super(iBarDataSetArr);
        this.mBarWidth = 0.85f;
    }

    public BarData(List<IBarDataSet> list) {
        super(list);
        this.mBarWidth = 0.85f;
    }
}
