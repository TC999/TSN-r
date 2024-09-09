package com.bxkj.student.run.app.utils;

import android.graphics.Color;
import android.graphics.Matrix;
import androidx.annotation.ColorInt;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.BarLineChartBase;
import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.charts.CombinedChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.CombinedData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.ValueFormatter;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: MPChartUtils.java */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class m {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: MPChartUtils.java */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class a extends ValueFormatter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ List f22881a;

        a(final List val$labels) {
            this.f22881a = val$labels;
        }

        @Override // com.github.mikephil.charting.formatter.ValueFormatter, com.github.mikephil.charting.formatter.IAxisValueFormatter
        public String getFormattedValue(float value, AxisBase axis) {
            int i4 = (int) value;
            return (i4 < 0 || i4 >= this.f22881a.size()) ? "" : (String) this.f22881a.get(i4);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: MPChartUtils.java */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class b extends ValueFormatter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ List f22882a;

        b(final List val$xLabels) {
            this.f22882a = val$xLabels;
        }

        @Override // com.github.mikephil.charting.formatter.ValueFormatter, com.github.mikephil.charting.formatter.IAxisValueFormatter
        public String getFormattedValue(float value, AxisBase axis) {
            return (String) this.f22882a.get(Math.min(Math.max((int) value, 0), this.f22882a.size() - 1));
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: MPChartUtils.java */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class c extends ValueFormatter {
        c() {
        }

        @Override // com.github.mikephil.charting.formatter.ValueFormatter, com.github.mikephil.charting.formatter.IAxisValueFormatter
        public String getFormattedValue(float value, AxisBase axis) {
            return (value * 100.0f) + "%";
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: MPChartUtils.java */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class d extends ValueFormatter {
        d() {
        }

        @Override // com.github.mikephil.charting.formatter.ValueFormatter, com.github.mikephil.charting.formatter.IAxisValueFormatter
        public String getFormattedValue(float value, AxisBase axis) {
            return (value * 100.0f) + "%";
        }
    }

    public static void a(Chart mChart) {
        mChart.clear();
        mChart.notifyDataSetChanged();
        mChart.setNoDataText("\u4f60\u8fd8\u6ca1\u6709\u8bb0\u5f55\u6570\u636e");
        mChart.setNoDataTextColor(-1);
        mChart.invalidate();
    }

    public static void b(BarChart barChart, final List<String> xLabels) {
        barChart.getDescription().setEnabled(false);
        barChart.setPinchZoom(false);
        barChart.setScaleEnabled(false);
        barChart.setDragEnabled(true);
        barChart.setNoDataText("");
        XAxis xAxis = barChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(false);
        xAxis.setGranularity(1.0f);
        xAxis.setValueFormatter(new b(xLabels));
        xAxis.setTextSize(10.0f);
        xAxis.setTextColor(barChart.getResources().getColor(2131034159));
        xAxis.setAxisLineColor(Color.parseColor("#4cffffff"));
        xAxis.setLabelCount(xLabels.size());
        YAxis axisLeft = barChart.getAxisLeft();
        axisLeft.setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART);
        axisLeft.setAxisMinimum(0.0f);
        axisLeft.setDrawGridLines(false);
        axisLeft.setDrawLabels(true);
        axisLeft.setDrawAxisLine(false);
        axisLeft.setAxisLineColor(Color.parseColor("#4cffffff"));
        axisLeft.setTextColor(barChart.getResources().getColor(2131034159));
        axisLeft.setValueFormatter(new c());
        barChart.getAxisRight().setEnabled(false);
        barChart.getLegend().setEnabled(false);
        Matrix matrix = new Matrix();
        if (xLabels.size() <= 10) {
            matrix.postScale(1.0f, 1.0f);
        } else if (xLabels.size() <= 15) {
            matrix.postScale(1.5f, 1.0f);
        } else if (xLabels.size() <= 20) {
            matrix.postScale(2.0f, 1.0f);
        } else {
            matrix.postScale(3.0f, 1.0f);
        }
        barChart.getViewPortHandler().refresh(matrix, barChart, false);
        barChart.setExtraBottomOffset(10.0f);
        barChart.setExtraTopOffset(30.0f);
        barChart.setFitBars(true);
        barChart.animateX(1500);
    }

    public static void c(BarLineChartBase mChart, List<String> mLabels, float yMax, float yMin, boolean isShowLegend) {
        mChart.setDrawGridBackground(false);
        mChart.setDrawBorders(false);
        mChart.setScaleEnabled(false);
        mChart.setDragEnabled(true);
        mChart.setNoDataText("");
        mChart.getDescription().setEnabled(false);
        mChart.getAxisRight().setEnabled(false);
        Legend legend = mChart.getLegend();
        if (isShowLegend) {
            legend.setEnabled(true);
            legend.setTextColor(-1);
            legend.setForm(Legend.LegendForm.CIRCLE);
            legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.LEFT);
            legend.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM);
            legend.setOrientation(Legend.LegendOrientation.HORIZONTAL);
            legend.setYEntrySpace(20.0f);
            legend.setFormSize(7.0f);
            legend.setTextSize(10.0f);
            legend.setXEntrySpace(20.0f);
        } else {
            legend.setEnabled(false);
        }
        XAxis xAxis = mChart.getXAxis();
        xAxis.setDrawAxisLine(true);
        xAxis.setAxisLineColor(Color.parseColor("#4cffffff"));
        xAxis.setDrawGridLines(false);
        xAxis.setGridColor(Color.parseColor("#30FFFFFF"));
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setTextSize(12.0f);
        xAxis.setYOffset(5.0f);
        xAxis.setValueFormatter(new a(mLabels));
        xAxis.setTextColor(mChart.getResources().getColor(2131034159));
        xAxis.setGranularity(1.0f);
        YAxis axisLeft = mChart.getAxisLeft();
        axisLeft.setDrawAxisLine(false);
        axisLeft.setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART);
        axisLeft.setDrawGridLines(false);
        axisLeft.setDrawZeroLine(true);
        axisLeft.setTextColor(mChart.getResources().getColor(2131034159));
        axisLeft.setTextSize(12.0f);
        axisLeft.setXOffset(15.0f);
        axisLeft.setLabelCount(5, false);
        Matrix matrix = new Matrix();
        if (mLabels.size() <= 10) {
            matrix.postScale(1.0f, 1.0f);
        } else if (mLabels.size() <= 15) {
            matrix.postScale(1.5f, 1.0f);
        } else if (mLabels.size() <= 20) {
            matrix.postScale(2.0f, 1.0f);
        } else {
            matrix.postScale(3.0f, 1.0f);
        }
        mChart.getViewPortHandler().refresh(matrix, mChart, false);
        mChart.animateX(500);
    }

    public static BarDataSet d(List<BarEntry> entries, String label, @ColorInt int textColor, @ColorInt int lineColor) {
        BarDataSet barDataSet = new BarDataSet(entries, label);
        barDataSet.setBarBorderWidth(5.0f);
        barDataSet.setBarShadowColor(lineColor);
        barDataSet.setValueTextColor(textColor);
        barDataSet.setDrawValues(false);
        return barDataSet;
    }

    public static LineDataSet e(List<Entry> entries, String label, @ColorInt int textColor, @ColorInt int lineColor, boolean isFill) {
        LineDataSet lineDataSet = new LineDataSet(entries, label);
        lineDataSet.setColor(lineColor);
        lineDataSet.setValueTextColor(textColor);
        lineDataSet.setMode(LineDataSet.Mode.HORIZONTAL_BEZIER);
        lineDataSet.setDrawValues(false);
        lineDataSet.setDrawCircles(true);
        lineDataSet.setDrawCircleHole(false);
        lineDataSet.setHighlightEnabled(true);
        lineDataSet.setHighLightColor(0);
        if (isFill) {
            lineDataSet.setDrawFilled(true);
            lineDataSet.setFillColor(lineColor);
        }
        lineDataSet.setCircleColor(lineColor);
        lineDataSet.setCircleRadius(3.5f);
        lineDataSet.setLineWidth(1.0f);
        return lineDataSet;
    }

    public static void f(BarChart chart, List<BarEntry> entries, String title, @ColorInt int barColor) {
        BarDataSet barDataSet = new BarDataSet(entries, title);
        barDataSet.setValueTextColor(-1);
        barDataSet.setColor(barColor);
        ArrayList arrayList = new ArrayList();
        arrayList.add(barDataSet);
        BarData barData = new BarData(arrayList);
        barData.setValueTextSize(10.0f);
        barData.setBarWidth(0.1f);
        barData.setValueTextColor(-1);
        barData.setValueFormatter(new d());
        chart.setData(barData);
        chart.invalidate();
    }

    public static void g(CombinedChart chart, LineData... lineDatas) {
        CombinedData combinedData = new CombinedData();
        for (LineData lineData : lineDatas) {
            combinedData.setData(lineData);
        }
        chart.setData(combinedData);
        chart.invalidate();
    }
}
