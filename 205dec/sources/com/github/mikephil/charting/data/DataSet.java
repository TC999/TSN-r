package com.github.mikephil.charting.data;

import com.github.mikephil.charting.data.Entry;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public abstract class DataSet<T extends Entry> extends BaseDataSet<T> {
    protected List<T> mValues;
    protected float mXMax;
    protected float mXMin;
    protected float mYMax;
    protected float mYMin;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    public enum Rounding {
        UP,
        DOWN,
        CLOSEST
    }

    public DataSet(List<T> list, String str) {
        super(str);
        this.mYMax = -3.4028235E38f;
        this.mYMin = Float.MAX_VALUE;
        this.mXMax = -3.4028235E38f;
        this.mXMin = Float.MAX_VALUE;
        this.mValues = list;
        if (list == null) {
            this.mValues = new ArrayList();
        }
        calcMinMax();
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public boolean addEntry(T t3) {
        if (t3 == null) {
            return false;
        }
        List<T> values = getValues();
        if (values == null) {
            values = new ArrayList<>();
        }
        calcMinMax(t3);
        return values.add(t3);
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public void addEntryOrdered(T t3) {
        if (t3 == null) {
            return;
        }
        if (this.mValues == null) {
            this.mValues = new ArrayList();
        }
        calcMinMax(t3);
        if (this.mValues.size() > 0) {
            List<T> list = this.mValues;
            if (list.get(list.size() - 1).getX() > t3.getX()) {
                this.mValues.add(getEntryIndex(t3.getX(), t3.getY(), Rounding.UP), t3);
                return;
            }
        }
        this.mValues.add(t3);
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public void calcMinMax() {
        List<T> list = this.mValues;
        if (list == null || list.isEmpty()) {
            return;
        }
        this.mYMax = -3.4028235E38f;
        this.mYMin = Float.MAX_VALUE;
        this.mXMax = -3.4028235E38f;
        this.mXMin = Float.MAX_VALUE;
        for (T t3 : this.mValues) {
            calcMinMax(t3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void calcMinMaxX(T t3) {
        if (t3.getX() < this.mXMin) {
            this.mXMin = t3.getX();
        }
        if (t3.getX() > this.mXMax) {
            this.mXMax = t3.getX();
        }
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public void calcMinMaxY(float f4, float f5) {
        List<T> list = this.mValues;
        if (list == null || list.isEmpty()) {
            return;
        }
        this.mYMax = -3.4028235E38f;
        this.mYMin = Float.MAX_VALUE;
        int entryIndex = getEntryIndex(f5, Float.NaN, Rounding.UP);
        for (int entryIndex2 = getEntryIndex(f4, Float.NaN, Rounding.DOWN); entryIndex2 <= entryIndex; entryIndex2++) {
            calcMinMaxY(this.mValues.get(entryIndex2));
        }
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public void clear() {
        this.mValues.clear();
        notifyDataSetChanged();
    }

    public abstract DataSet<T> copy();

    /* JADX INFO: Access modifiers changed from: protected */
    public void copy(DataSet dataSet) {
        super.copy((BaseDataSet) dataSet);
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public List<T> getEntriesForXValue(float f4) {
        ArrayList arrayList = new ArrayList();
        int size = this.mValues.size() - 1;
        int i4 = 0;
        while (true) {
            if (i4 > size) {
                break;
            }
            int i5 = (size + i4) / 2;
            T t3 = this.mValues.get(i5);
            if (f4 == t3.getX()) {
                while (i5 > 0 && this.mValues.get(i5 - 1).getX() == f4) {
                    i5--;
                }
                int size2 = this.mValues.size();
                while (i5 < size2) {
                    T t4 = this.mValues.get(i5);
                    if (t4.getX() != f4) {
                        break;
                    }
                    arrayList.add(t4);
                    i5++;
                }
            } else if (f4 > t3.getX()) {
                i4 = i5 + 1;
            } else {
                size = i5 - 1;
            }
        }
        return arrayList;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public int getEntryCount() {
        return this.mValues.size();
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public T getEntryForIndex(int i4) {
        return this.mValues.get(i4);
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public T getEntryForXValue(float f4, float f5, Rounding rounding) {
        int entryIndex = getEntryIndex(f4, f5, rounding);
        if (entryIndex > -1) {
            return this.mValues.get(entryIndex);
        }
        return null;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public int getEntryIndex(Entry entry) {
        return this.mValues.indexOf(entry);
    }

    public List<T> getValues() {
        return this.mValues;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public float getXMax() {
        return this.mXMax;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public float getXMin() {
        return this.mXMin;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public float getYMax() {
        return this.mYMax;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public float getYMin() {
        return this.mYMin;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public boolean removeEntry(T t3) {
        List<T> list;
        if (t3 == null || (list = this.mValues) == null) {
            return false;
        }
        boolean remove = list.remove(t3);
        if (remove) {
            calcMinMax();
        }
        return remove;
    }

    public void setValues(List<T> list) {
        this.mValues = list;
        notifyDataSetChanged();
    }

    public String toSimpleString() {
        StringBuffer stringBuffer = new StringBuffer();
        StringBuilder sb = new StringBuilder();
        sb.append("DataSet, label: ");
        sb.append(getLabel() == null ? "" : getLabel());
        sb.append(", entries: ");
        sb.append(this.mValues.size());
        sb.append("\n");
        stringBuffer.append(sb.toString());
        return stringBuffer.toString();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(toSimpleString());
        for (int i4 = 0; i4 < this.mValues.size(); i4++) {
            stringBuffer.append(this.mValues.get(i4).toString() + " ");
        }
        return stringBuffer.toString();
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public int getEntryIndex(float f4, float f5, Rounding rounding) {
        int i4;
        T t3;
        List<T> list = this.mValues;
        if (list == null || list.isEmpty()) {
            return -1;
        }
        int i5 = 0;
        int size = this.mValues.size() - 1;
        while (i5 < size) {
            int i6 = (i5 + size) / 2;
            float x3 = this.mValues.get(i6).getX() - f4;
            int i7 = i6 + 1;
            float abs = Math.abs(x3);
            float abs2 = Math.abs(this.mValues.get(i7).getX() - f4);
            if (abs2 >= abs) {
                if (abs >= abs2) {
                    double d4 = x3;
                    if (d4 < 0.0d) {
                        if (d4 < 0.0d) {
                        }
                    }
                }
                size = i6;
            }
            i5 = i7;
        }
        if (size != -1) {
            float x4 = this.mValues.get(size).getX();
            if (rounding == Rounding.UP) {
                if (x4 < f4 && size < this.mValues.size() - 1) {
                    size++;
                }
            } else if (rounding == Rounding.DOWN && x4 > f4 && size > 0) {
                size--;
            }
            if (Float.isNaN(f5)) {
                return size;
            }
            while (size > 0 && this.mValues.get(size - 1).getX() == x4) {
                size--;
            }
            float y3 = this.mValues.get(size).getY();
            loop2: while (true) {
                i4 = size;
                do {
                    size++;
                    if (size >= this.mValues.size()) {
                        break loop2;
                    }
                    t3 = this.mValues.get(size);
                    if (t3.getX() != x4) {
                        break loop2;
                    }
                } while (Math.abs(t3.getY() - f5) >= Math.abs(y3 - f5));
                y3 = f5;
            }
            return i4;
        }
        return size;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public T getEntryForXValue(float f4, float f5) {
        return getEntryForXValue(f4, f5, Rounding.CLOSEST);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void calcMinMaxY(T t3) {
        if (t3.getY() < this.mYMin) {
            this.mYMin = t3.getY();
        }
        if (t3.getY() > this.mYMax) {
            this.mYMax = t3.getY();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void calcMinMax(T t3) {
        if (t3 == null) {
            return;
        }
        calcMinMaxX(t3);
        calcMinMaxY(t3);
    }
}
