package com.bxkj.student.run.app.p092my;

import android.util.Log;
import androidx.core.internal.view.SupportMenu;
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

/* renamed from: com.bxkj.student.run.app.my.a */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class BarChartUtils {

    /* renamed from: c */
    private static final String f19238c = "BarChartUtils";

    /* renamed from: a */
    private BarChart f19239a;

    /* renamed from: b */
    private XAxis f19240b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BarChartUtils.java */
    /* renamed from: com.bxkj.student.run.app.my.a$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C5275a implements OnChartValueSelectedListener {
        C5275a() {
        }

        @Override // com.github.mikephil.charting.listener.OnChartValueSelectedListener
        public void onNothingSelected() {
        }

        @Override // com.github.mikephil.charting.listener.OnChartValueSelectedListener
        public void onValueSelected(Entry e, Highlight h) {
            Log.i(BarChartUtils.f19238c, "---" + e.getX());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BarChartUtils.java */
    /* renamed from: com.bxkj.student.run.app.my.a$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C5276b extends ValueFormatter {
        C5276b() {
        }

        @Override // com.github.mikephil.charting.formatter.ValueFormatter, com.github.mikephil.charting.formatter.IAxisValueFormatter
        public String getFormattedValue(float value, AxisBase axis) {
            int i = (int) value;
            if (i == 0) {
                return "";
            }
            return i + "%";
        }
    }

    /* compiled from: BarChartUtils.java */
    /* renamed from: com.bxkj.student.run.app.my.a$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C5277c extends ValueFormatter {
        C5277c() {
        }

        @Override // com.github.mikephil.charting.formatter.ValueFormatter, com.github.mikephil.charting.formatter.IAxisValueFormatter
        public String getFormattedValue(float value, AxisBase axis) {
            int i = (int) value;
            if (i == 0) {
                return "";
            }
            return i + "%";
        }
    }

    /* compiled from: BarChartUtils.java */
    /* renamed from: com.bxkj.student.run.app.my.a$d */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C5278d extends ValueFormatter {

        /* renamed from: a */
        private ArrayList<String> f19244a;

        public C5278d(ArrayList<String> list) {
            this.f19244a = list;
        }

        @Override // com.github.mikephil.charting.formatter.ValueFormatter, com.github.mikephil.charting.formatter.IAxisValueFormatter
        public String getFormattedValue(float value, AxisBase axis) {
            int i = (int) value;
            return i < this.f19244a.size() ? this.f19244a.get(i) : "";
        }
    }

    public BarChartUtils(BarChart chart) {
        this.f19239a = chart;
        m39926a();
        m39925b();
    }

    /* renamed from: a */
    private void m39926a() {
        this.f19239a.setDrawGridBackground(false);
        this.f19239a.setTouchEnabled(true);
        this.f19239a.setDragEnabled(true);
        this.f19239a.setScaleEnabled(true);
        this.f19239a.getDescription().setText("");
        this.f19239a.setDrawBorders(false);
        this.f19239a.setExtraBottomOffset(10.0f);
        this.f19239a.setDrawValueAboveBar(true);
        this.f19239a.setDrawBarShadow(false);
        Legend legend = this.f19239a.getLegend();
        legend.setEnabled(true);
        legend.setForm(Legend.LegendForm.CIRCLE);
        legend.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
        legend.setOrientation(Legend.LegendOrientation.HORIZONTAL);
        legend.setDrawInside(false);
        this.f19239a.setPinchZoom(true);
        this.f19239a.setOnChartValueSelectedListener(new C5275a());
        XAxis xAxis = this.f19239a.getXAxis();
        this.f19240b = xAxis;
        xAxis.setDrawAxisLine(true);
        this.f19240b.setDrawGridLines(false);
        this.f19240b.setGranularity(1.0f);
        this.f19240b.setCenterAxisLabels(true);
        this.f19240b.setPosition(XAxis.XAxisPosition.BOTTOM);
        this.f19240b.setTextColor(SupportMenu.CATEGORY_MASK);
    }

    /* renamed from: b */
    private void m39925b() {
        YAxis axisLeft = this.f19239a.getAxisLeft();
        YAxis axisRight = this.f19239a.getAxisRight();
        axisLeft.setDrawAxisLine(true);
        axisLeft.setTextSize(16.0f);
        axisLeft.setLabelCount(5, false);
        axisLeft.setAxisMinimum(0.0f);
        axisRight.setAxisMinimum(0.0f);
        axisRight.setEnabled(false);
        axisLeft.setValueFormatter(new C5276b());
    }

    /* renamed from: c */
    public void m39924c(List<BarEntry> yValues, String lable, int color, ArrayList<String> xValues) {
        BarDataSet barDataSet = new BarDataSet(yValues, lable);
        barDataSet.setColor(color);
        barDataSet.setValueTextSize(14.0f);
        barDataSet.setDrawValues(true);
        barDataSet.setHighLightAlpha(37);
        barDataSet.setValueFormatter(new C5277c());
        this.f19240b.setValueFormatter(new C5278d(xValues));
        ArrayList arrayList = new ArrayList();
        arrayList.add(barDataSet);
        this.f19239a.setData(new BarData(arrayList));
    }
}
