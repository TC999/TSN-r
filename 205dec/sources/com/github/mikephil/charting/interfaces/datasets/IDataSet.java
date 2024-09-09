package com.github.mikephil.charting.interfaces.datasets;

import android.graphics.DashPathEffect;
import android.graphics.Typeface;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.model.GradientColor;
import com.github.mikephil.charting.utils.MPPointF;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public interface IDataSet<T extends Entry> {
    boolean addEntry(T t3);

    void addEntryOrdered(T t3);

    void calcMinMax();

    void calcMinMaxY(float f4, float f5);

    void clear();

    boolean contains(T t3);

    YAxis.AxisDependency getAxisDependency();

    int getColor();

    int getColor(int i4);

    List<Integer> getColors();

    List<T> getEntriesForXValue(float f4);

    int getEntryCount();

    T getEntryForIndex(int i4);

    T getEntryForXValue(float f4, float f5);

    T getEntryForXValue(float f4, float f5, DataSet.Rounding rounding);

    int getEntryIndex(float f4, float f5, DataSet.Rounding rounding);

    int getEntryIndex(T t3);

    Legend.LegendForm getForm();

    DashPathEffect getFormLineDashEffect();

    float getFormLineWidth();

    float getFormSize();

    GradientColor getGradientColor();

    GradientColor getGradientColor(int i4);

    List<GradientColor> getGradientColors();

    MPPointF getIconsOffset();

    int getIndexInEntries(int i4);

    String getLabel();

    ValueFormatter getValueFormatter();

    int getValueTextColor();

    int getValueTextColor(int i4);

    float getValueTextSize();

    Typeface getValueTypeface();

    float getXMax();

    float getXMin();

    float getYMax();

    float getYMin();

    boolean isDrawIconsEnabled();

    boolean isDrawValuesEnabled();

    boolean isHighlightEnabled();

    boolean isVisible();

    boolean needsFormatter();

    boolean removeEntry(int i4);

    boolean removeEntry(T t3);

    boolean removeEntryByXValue(float f4);

    boolean removeFirst();

    boolean removeLast();

    void setAxisDependency(YAxis.AxisDependency axisDependency);

    void setDrawIcons(boolean z3);

    void setDrawValues(boolean z3);

    void setHighlightEnabled(boolean z3);

    void setIconsOffset(MPPointF mPPointF);

    void setLabel(String str);

    void setValueFormatter(ValueFormatter valueFormatter);

    void setValueTextColor(int i4);

    void setValueTextColors(List<Integer> list);

    void setValueTextSize(float f4);

    void setValueTypeface(Typeface typeface);

    void setVisible(boolean z3);
}
