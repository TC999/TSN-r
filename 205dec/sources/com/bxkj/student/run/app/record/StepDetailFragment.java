package com.bxkj.student.run.app.record;

import android.text.TextUtils;
import android.view.View;
import androidx.core.content.ContextCompat;
import cn.bluemobi.dylan.base.BaseFragment;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class StepDetailFragment extends BaseFragment {

    /* renamed from: h  reason: collision with root package name */
    private BarChart f22569h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class a extends ValueFormatter {
        a() {
        }

        @Override // com.github.mikephil.charting.formatter.ValueFormatter
        public String getFormattedValue(float value) {
            return ((int) value) + "\u5206\u949f";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class b extends ValueFormatter {
        b() {
        }

        @Override // com.github.mikephil.charting.formatter.ValueFormatter
        public String getFormattedValue(float value) {
            return ((int) value) + "";
        }
    }

    private void N() {
        Description description = new Description();
        description.setText("");
        this.f22569h.setDescription(description);
        this.f22569h.setNoDataText("\u6682\u65e0\u6570\u636e");
        this.f22569h.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);
        this.f22569h.getXAxis().setDrawGridLines(false);
        this.f22569h.getXAxis().setTextSize(14.0f);
        this.f22569h.getAxisLeft().setTextSize(14.0f);
        this.f22569h.getAxisRight().setEnabled(false);
        this.f22569h.getAxisLeft().setDrawGridLines(false);
        this.f22569h.getAxisRight().setDrawGridLines(false);
        this.f22569h.getXAxis().setDrawGridLines(false);
        this.f22569h.getLegend().setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        this.f22569h.getLegend().setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
        this.f22569h.getLegend().setTextSize(14.0f);
        this.f22569h.getXAxis().setGranularity(1.0f);
        this.f22569h.setExtraBottomOffset(20.0f);
        this.f22569h.getAxisLeft().setAxisMinimum(0.0f);
    }

    private void O() {
        Integer num;
        if (getArguments().containsKey("step")) {
            String string = getArguments().getString("step");
            if (TextUtils.isEmpty(string)) {
                return;
            }
            List arrayList = new ArrayList();
            int i4 = 0;
            try {
                if (JSON.parse(string) instanceof JSONArray) {
                    arrayList = JSON.parseArray(string, Integer.class);
                } else {
                    String[] split = string.split(",");
                    if (split.length > 0) {
                        for (String str : split) {
                            arrayList.add(Integer.valueOf(Integer.parseInt(str)));
                        }
                    }
                }
            } catch (Exception unused) {
                String[] split2 = string.split(",");
                if (split2.length > 0) {
                    for (String str2 : split2) {
                        arrayList.add(Integer.valueOf(Integer.parseInt(str2)));
                    }
                }
            }
            if (arrayList == null || arrayList.size() == 0) {
                return;
            }
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            int i5 = 0;
            while (i4 < arrayList.size()) {
                i5 += ((Integer) arrayList.get(i4)).intValue();
                i4++;
                arrayList2.add(String.valueOf(i4));
                arrayList3.add(new BarEntry(i4, num.intValue()));
            }
            BarDataSet barDataSet = new BarDataSet(arrayList3, "\u6b65\u6570(\u5171" + i5 + ")");
            barDataSet.setColor(ContextCompat.getColor(this.f1665e, 2131034489));
            barDataSet.setDrawValues(true);
            barDataSet.setHighLightAlpha(37);
            XAxis xAxis = this.f22569h.getXAxis();
            xAxis.setGranularity(1.0f);
            xAxis.setValueFormatter(new a());
            barDataSet.setValueFormatter(new b());
            ArrayList arrayList4 = new ArrayList();
            arrayList4.add(barDataSet);
            this.f22569h.setData(new BarData(arrayList4));
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    public void b() {
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    protected void e() {
        N();
        O();
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    protected void f(View view) {
        this.f22569h = (BarChart) c(2131231102);
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    protected int i() {
        return 2131427642;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
    }
}
