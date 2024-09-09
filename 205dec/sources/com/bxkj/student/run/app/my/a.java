package com.bxkj.student.run.app.my;

import android.util.Log;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: BarChartUtils.java */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class a {

    /* renamed from: c  reason: collision with root package name */
    private static final String f22475c = "BarChartUtils";

    /* renamed from: a  reason: collision with root package name */
    private BarChart f22476a;

    /* renamed from: b  reason: collision with root package name */
    private XAxis f22477b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: BarChartUtils.java */
    /* renamed from: com.bxkj.student.run.app.my.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class C0280a implements OnChartValueSelectedListener {
        C0280a() {
        }

        @Override // com.github.mikephil.charting.listener.OnChartValueSelectedListener
        public void onNothingSelected() {
        }

        @Override // com.github.mikephil.charting.listener.OnChartValueSelectedListener
        public void onValueSelected(Entry e4, Highlight h4) {
            Log.i("BarChartUtils", "---" + e4.getX());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: BarChartUtils.java */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class b extends ValueFormatter {
        b() {
        }

        @Override // com.github.mikephil.charting.formatter.ValueFormatter, com.github.mikephil.charting.formatter.IAxisValueFormatter
        public String getFormattedValue(float value, AxisBase axis) {
            int i4 = (int) value;
            if (i4 == 0) {
                return "";
            }
            return i4 + "%";
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: BarChartUtils.java */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class c extends ValueFormatter {
        c() {
        }

        @Override // com.github.mikephil.charting.formatter.ValueFormatter, com.github.mikephil.charting.formatter.IAxisValueFormatter
        public String getFormattedValue(float value, AxisBase axis) {
            int i4 = (int) value;
            if (i4 == 0) {
                return "";
            }
            return i4 + "%";
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: BarChartUtils.java */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class d extends ValueFormatter {

        /* renamed from: a  reason: collision with root package name */
        private ArrayList<String> f22481a;

        public d(ArrayList<String> list) {
            this.f22481a = list;
        }

        @Override // com.github.mikephil.charting.formatter.ValueFormatter, com.github.mikephil.charting.formatter.IAxisValueFormatter
        public String getFormattedValue(float value, AxisBase axis) {
            int i4 = (int) value;
            return i4 < this.f22481a.size() ? this.f22481a.get(i4) : "";
        }
    }

    public a(BarChart chart) {
        this.f22476a = chart;
        a();
        b();
    }

    private void a() {
        this.f22476a.setDrawGridBackground(false);
        this.f22476a.setTouchEnabled(true);
        this.f22476a.setDragEnabled(true);
        this.f22476a.setScaleEnabled(true);
        this.f22476a.getDescription().setText("");
        this.f22476a.setDrawBorders(false);
        this.f22476a.setExtraBottomOffset(10.0f);
        this.f22476a.setDrawValueAboveBar(true);
        this.f22476a.setDrawBarShadow(false);
        Legend legend = this.f22476a.getLegend();
        legend.setEnabled(true);
        legend.setForm(Legend.LegendForm.CIRCLE);
        legend.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
        legend.setOrientation(Legend.LegendOrientation.HORIZONTAL);
        legend.setDrawInside(false);
        this.f22476a.setPinchZoom(true);
        this.f22476a.setOnChartValueSelectedListener(new C0280a());
        XAxis xAxis = this.f22476a.getXAxis();
        this.f22477b = xAxis;
        xAxis.setDrawAxisLine(true);
        this.f22477b.setDrawGridLines(false);
        this.f22477b.setGranularity(1.0f);
        this.f22477b.setCenterAxisLabels(true);
        this.f22477b.setPosition(XAxis.XAxisPosition.BOTTOM);
        this.f22477b.setTextColor(-65536);
    }

    private void b() {
        YAxis axisLeft = this.f22476a.getAxisLeft();
        YAxis axisRight = this.f22476a.getAxisRight();
        axisLeft.setDrawAxisLine(true);
        axisLeft.setTextSize(16.0f);
        axisLeft.setLabelCount(5, false);
        axisLeft.setAxisMinimum(0.0f);
        axisRight.setAxisMinimum(0.0f);
        axisRight.setEnabled(false);
        axisLeft.setValueFormatter(new b());
    }

    public void c(List<BarEntry> yValues, String lable, int color, ArrayList<String> xValues) {
        BarDataSet barDataSet = new BarDataSet(yValues, lable);
        barDataSet.setColor(color);
        barDataSet.setValueTextSize(14.0f);
        barDataSet.setDrawValues(true);
        barDataSet.setHighLightAlpha(37);
        barDataSet.setValueFormatter(new c());
        this.f22477b.setValueFormatter(new d(xValues));
        ArrayList arrayList = new ArrayList();
        arrayList.add(barDataSet);
        this.f22476a.setData(new BarData(arrayList));
    }
}
