package com.github.mikephil.charting.data;

import android.graphics.Typeface;
import android.util.Log;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public abstract class ChartData<T extends IDataSet<? extends Entry>> {
    protected List<T> mDataSets;
    protected float mLeftAxisMax;
    protected float mLeftAxisMin;
    protected float mRightAxisMax;
    protected float mRightAxisMin;
    protected float mXMax;
    protected float mXMin;
    protected float mYMax;
    protected float mYMin;

    public ChartData() {
        this.mYMax = -3.4028235E38f;
        this.mYMin = Float.MAX_VALUE;
        this.mXMax = -3.4028235E38f;
        this.mXMin = Float.MAX_VALUE;
        this.mLeftAxisMax = -3.4028235E38f;
        this.mLeftAxisMin = Float.MAX_VALUE;
        this.mRightAxisMax = -3.4028235E38f;
        this.mRightAxisMin = Float.MAX_VALUE;
        this.mDataSets = new ArrayList();
    }

    private List<T> arrayToList(T[] tArr) {
        ArrayList arrayList = new ArrayList();
        for (T t3 : tArr) {
            arrayList.add(t3);
        }
        return arrayList;
    }

    public void addDataSet(T t3) {
        if (t3 == null) {
            return;
        }
        calcMinMax(t3);
        this.mDataSets.add(t3);
    }

    public void addEntry(Entry entry, int i4) {
        if (this.mDataSets.size() > i4 && i4 >= 0) {
            T t3 = this.mDataSets.get(i4);
            if (t3.addEntry(entry)) {
                calcMinMax(entry, t3.getAxisDependency());
                return;
            }
            return;
        }
        Log.e("addEntry", "Cannot add Entry because dataSetIndex too high or too low.");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void calcMinMax() {
        List<T> list = this.mDataSets;
        if (list == null) {
            return;
        }
        this.mYMax = -3.4028235E38f;
        this.mYMin = Float.MAX_VALUE;
        this.mXMax = -3.4028235E38f;
        this.mXMin = Float.MAX_VALUE;
        for (T t3 : list) {
            calcMinMax(t3);
        }
        this.mLeftAxisMax = -3.4028235E38f;
        this.mLeftAxisMin = Float.MAX_VALUE;
        this.mRightAxisMax = -3.4028235E38f;
        this.mRightAxisMin = Float.MAX_VALUE;
        T firstLeft = getFirstLeft(this.mDataSets);
        if (firstLeft != null) {
            this.mLeftAxisMax = firstLeft.getYMax();
            this.mLeftAxisMin = firstLeft.getYMin();
            for (T t4 : this.mDataSets) {
                if (t4.getAxisDependency() == YAxis.AxisDependency.LEFT) {
                    if (t4.getYMin() < this.mLeftAxisMin) {
                        this.mLeftAxisMin = t4.getYMin();
                    }
                    if (t4.getYMax() > this.mLeftAxisMax) {
                        this.mLeftAxisMax = t4.getYMax();
                    }
                }
            }
        }
        T firstRight = getFirstRight(this.mDataSets);
        if (firstRight != null) {
            this.mRightAxisMax = firstRight.getYMax();
            this.mRightAxisMin = firstRight.getYMin();
            for (T t5 : this.mDataSets) {
                if (t5.getAxisDependency() == YAxis.AxisDependency.RIGHT) {
                    if (t5.getYMin() < this.mRightAxisMin) {
                        this.mRightAxisMin = t5.getYMin();
                    }
                    if (t5.getYMax() > this.mRightAxisMax) {
                        this.mRightAxisMax = t5.getYMax();
                    }
                }
            }
        }
    }

    public void calcMinMaxY(float f4, float f5) {
        for (T t3 : this.mDataSets) {
            t3.calcMinMaxY(f4, f5);
        }
        calcMinMax();
    }

    public void clearValues() {
        List<T> list = this.mDataSets;
        if (list != null) {
            list.clear();
        }
        notifyDataChanged();
    }

    public boolean contains(T t3) {
        for (T t4 : this.mDataSets) {
            if (t4.equals(t3)) {
                return true;
            }
        }
        return false;
    }

    public int[] getColors() {
        if (this.mDataSets == null) {
            return null;
        }
        int i4 = 0;
        for (int i5 = 0; i5 < this.mDataSets.size(); i5++) {
            i4 += this.mDataSets.get(i5).getColors().size();
        }
        int[] iArr = new int[i4];
        int i6 = 0;
        for (int i7 = 0; i7 < this.mDataSets.size(); i7++) {
            for (Integer num : this.mDataSets.get(i7).getColors()) {
                iArr[i6] = num.intValue();
                i6++;
            }
        }
        return iArr;
    }

    public T getDataSetByIndex(int i4) {
        List<T> list = this.mDataSets;
        if (list == null || i4 < 0 || i4 >= list.size()) {
            return null;
        }
        return this.mDataSets.get(i4);
    }

    public T getDataSetByLabel(String str, boolean z3) {
        int dataSetIndexByLabel = getDataSetIndexByLabel(this.mDataSets, str, z3);
        if (dataSetIndexByLabel < 0 || dataSetIndexByLabel >= this.mDataSets.size()) {
            return null;
        }
        return this.mDataSets.get(dataSetIndexByLabel);
    }

    public int getDataSetCount() {
        List<T> list = this.mDataSets;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public T getDataSetForEntry(Entry entry) {
        if (entry == null) {
            return null;
        }
        for (int i4 = 0; i4 < this.mDataSets.size(); i4++) {
            T t3 = this.mDataSets.get(i4);
            for (int i5 = 0; i5 < t3.getEntryCount(); i5++) {
                if (entry.equalTo(t3.getEntryForXValue(entry.getX(), entry.getY()))) {
                    return t3;
                }
            }
        }
        return null;
    }

    protected int getDataSetIndexByLabel(List<T> list, String str, boolean z3) {
        int i4 = 0;
        if (z3) {
            while (i4 < list.size()) {
                if (str.equalsIgnoreCase(list.get(i4).getLabel())) {
                    return i4;
                }
                i4++;
            }
            return -1;
        }
        while (i4 < list.size()) {
            if (str.equals(list.get(i4).getLabel())) {
                return i4;
            }
            i4++;
        }
        return -1;
    }

    public String[] getDataSetLabels() {
        String[] strArr = new String[this.mDataSets.size()];
        for (int i4 = 0; i4 < this.mDataSets.size(); i4++) {
            strArr[i4] = this.mDataSets.get(i4).getLabel();
        }
        return strArr;
    }

    public List<T> getDataSets() {
        return this.mDataSets;
    }

    public int getEntryCount() {
        int i4 = 0;
        for (T t3 : this.mDataSets) {
            i4 += t3.getEntryCount();
        }
        return i4;
    }

    public Entry getEntryForHighlight(Highlight highlight) {
        if (highlight.getDataSetIndex() >= this.mDataSets.size()) {
            return null;
        }
        return this.mDataSets.get(highlight.getDataSetIndex()).getEntryForXValue(highlight.getX(), highlight.getY());
    }

    protected T getFirstLeft(List<T> list) {
        for (T t3 : list) {
            if (t3.getAxisDependency() == YAxis.AxisDependency.LEFT) {
                return t3;
            }
        }
        return null;
    }

    public T getFirstRight(List<T> list) {
        for (T t3 : list) {
            if (t3.getAxisDependency() == YAxis.AxisDependency.RIGHT) {
                return t3;
            }
        }
        return null;
    }

    public int getIndexOfDataSet(T t3) {
        return this.mDataSets.indexOf(t3);
    }

    public T getMaxEntryCountSet() {
        List<T> list = this.mDataSets;
        if (list == null || list.isEmpty()) {
            return null;
        }
        T t3 = this.mDataSets.get(0);
        for (T t4 : this.mDataSets) {
            if (t4.getEntryCount() > t3.getEntryCount()) {
                t3 = t4;
            }
        }
        return t3;
    }

    public float getXMax() {
        return this.mXMax;
    }

    public float getXMin() {
        return this.mXMin;
    }

    public float getYMax() {
        return this.mYMax;
    }

    public float getYMin() {
        return this.mYMin;
    }

    public boolean isHighlightEnabled() {
        for (T t3 : this.mDataSets) {
            if (!t3.isHighlightEnabled()) {
                return false;
            }
        }
        return true;
    }

    public void notifyDataChanged() {
        calcMinMax();
    }

    public boolean removeDataSet(T t3) {
        if (t3 == null) {
            return false;
        }
        boolean remove = this.mDataSets.remove(t3);
        if (remove) {
            calcMinMax();
        }
        return remove;
    }

    public boolean removeEntry(Entry entry, int i4) {
        T t3;
        if (entry == null || i4 >= this.mDataSets.size() || (t3 = this.mDataSets.get(i4)) == null) {
            return false;
        }
        boolean removeEntry = t3.removeEntry(entry);
        if (removeEntry) {
            calcMinMax();
        }
        return removeEntry;
    }

    public void setDrawValues(boolean z3) {
        for (T t3 : this.mDataSets) {
            t3.setDrawValues(z3);
        }
    }

    public void setHighlightEnabled(boolean z3) {
        for (T t3 : this.mDataSets) {
            t3.setHighlightEnabled(z3);
        }
    }

    public void setValueFormatter(ValueFormatter valueFormatter) {
        if (valueFormatter == null) {
            return;
        }
        for (T t3 : this.mDataSets) {
            t3.setValueFormatter(valueFormatter);
        }
    }

    public void setValueTextColor(int i4) {
        for (T t3 : this.mDataSets) {
            t3.setValueTextColor(i4);
        }
    }

    public void setValueTextColors(List<Integer> list) {
        for (T t3 : this.mDataSets) {
            t3.setValueTextColors(list);
        }
    }

    public void setValueTextSize(float f4) {
        for (T t3 : this.mDataSets) {
            t3.setValueTextSize(f4);
        }
    }

    public void setValueTypeface(Typeface typeface) {
        for (T t3 : this.mDataSets) {
            t3.setValueTypeface(typeface);
        }
    }

    public float getYMax(YAxis.AxisDependency axisDependency) {
        if (axisDependency == YAxis.AxisDependency.LEFT) {
            float f4 = this.mLeftAxisMax;
            return f4 == -3.4028235E38f ? this.mRightAxisMax : f4;
        }
        float f5 = this.mRightAxisMax;
        return f5 == -3.4028235E38f ? this.mLeftAxisMax : f5;
    }

    public float getYMin(YAxis.AxisDependency axisDependency) {
        if (axisDependency == YAxis.AxisDependency.LEFT) {
            float f4 = this.mLeftAxisMin;
            return f4 == Float.MAX_VALUE ? this.mRightAxisMin : f4;
        }
        float f5 = this.mRightAxisMin;
        return f5 == Float.MAX_VALUE ? this.mLeftAxisMin : f5;
    }

    public boolean removeDataSet(int i4) {
        if (i4 >= this.mDataSets.size() || i4 < 0) {
            return false;
        }
        return removeDataSet((ChartData<T>) this.mDataSets.get(i4));
    }

    public boolean removeEntry(float f4, int i4) {
        Entry entryForXValue;
        if (i4 < this.mDataSets.size() && (entryForXValue = this.mDataSets.get(i4).getEntryForXValue(f4, Float.NaN)) != null) {
            return removeEntry(entryForXValue, i4);
        }
        return false;
    }

    public ChartData(T... tArr) {
        this.mYMax = -3.4028235E38f;
        this.mYMin = Float.MAX_VALUE;
        this.mXMax = -3.4028235E38f;
        this.mXMin = Float.MAX_VALUE;
        this.mLeftAxisMax = -3.4028235E38f;
        this.mLeftAxisMin = Float.MAX_VALUE;
        this.mRightAxisMax = -3.4028235E38f;
        this.mRightAxisMin = Float.MAX_VALUE;
        this.mDataSets = arrayToList(tArr);
        notifyDataChanged();
    }

    public ChartData(List<T> list) {
        this.mYMax = -3.4028235E38f;
        this.mYMin = Float.MAX_VALUE;
        this.mXMax = -3.4028235E38f;
        this.mXMin = Float.MAX_VALUE;
        this.mLeftAxisMax = -3.4028235E38f;
        this.mLeftAxisMin = Float.MAX_VALUE;
        this.mRightAxisMax = -3.4028235E38f;
        this.mRightAxisMin = Float.MAX_VALUE;
        this.mDataSets = list;
        notifyDataChanged();
    }

    protected void calcMinMax(Entry entry, YAxis.AxisDependency axisDependency) {
        if (this.mYMax < entry.getY()) {
            this.mYMax = entry.getY();
        }
        if (this.mYMin > entry.getY()) {
            this.mYMin = entry.getY();
        }
        if (this.mXMax < entry.getX()) {
            this.mXMax = entry.getX();
        }
        if (this.mXMin > entry.getX()) {
            this.mXMin = entry.getX();
        }
        if (axisDependency == YAxis.AxisDependency.LEFT) {
            if (this.mLeftAxisMax < entry.getY()) {
                this.mLeftAxisMax = entry.getY();
            }
            if (this.mLeftAxisMin > entry.getY()) {
                this.mLeftAxisMin = entry.getY();
                return;
            }
            return;
        }
        if (this.mRightAxisMax < entry.getY()) {
            this.mRightAxisMax = entry.getY();
        }
        if (this.mRightAxisMin > entry.getY()) {
            this.mRightAxisMin = entry.getY();
        }
    }

    protected void calcMinMax(T t3) {
        if (this.mYMax < t3.getYMax()) {
            this.mYMax = t3.getYMax();
        }
        if (this.mYMin > t3.getYMin()) {
            this.mYMin = t3.getYMin();
        }
        if (this.mXMax < t3.getXMax()) {
            this.mXMax = t3.getXMax();
        }
        if (this.mXMin > t3.getXMin()) {
            this.mXMin = t3.getXMin();
        }
        if (t3.getAxisDependency() == YAxis.AxisDependency.LEFT) {
            if (this.mLeftAxisMax < t3.getYMax()) {
                this.mLeftAxisMax = t3.getYMax();
            }
            if (this.mLeftAxisMin > t3.getYMin()) {
                this.mLeftAxisMin = t3.getYMin();
                return;
            }
            return;
        }
        if (this.mRightAxisMax < t3.getYMax()) {
            this.mRightAxisMax = t3.getYMax();
        }
        if (this.mRightAxisMin > t3.getYMin()) {
            this.mRightAxisMin = t3.getYMin();
        }
    }
}
