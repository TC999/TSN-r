package com.bxkj.student.run.app.record;

import android.text.TextUtils;
import android.view.View;
import androidx.core.content.ContextCompat;
import cn.bluemobi.dylan.base.BaseFragment;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.bxkj.student.C4215R;
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

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class StepDetailFragment extends BaseFragment {

    /* renamed from: h */
    private BarChart f19337h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.run.app.record.StepDetailFragment$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C5327a extends ValueFormatter {
        C5327a() {
        }

        @Override // com.github.mikephil.charting.formatter.ValueFormatter
        public String getFormattedValue(float value) {
            return ((int) value) + "分钟";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.run.app.record.StepDetailFragment$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C5328b extends ValueFormatter {
        C5328b() {
        }

        @Override // com.github.mikephil.charting.formatter.ValueFormatter
        public String getFormattedValue(float value) {
            return ((int) value) + "";
        }
    }

    /* renamed from: N */
    private void m39806N() {
        Description description = new Description();
        description.setText("");
        this.f19337h.setDescription(description);
        this.f19337h.setNoDataText("暂无数据");
        this.f19337h.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);
        this.f19337h.getXAxis().setDrawGridLines(false);
        this.f19337h.getXAxis().setTextSize(14.0f);
        this.f19337h.getAxisLeft().setTextSize(14.0f);
        this.f19337h.getAxisRight().setEnabled(false);
        this.f19337h.getAxisLeft().setDrawGridLines(false);
        this.f19337h.getAxisRight().setDrawGridLines(false);
        this.f19337h.getXAxis().setDrawGridLines(false);
        this.f19337h.getLegend().setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        this.f19337h.getLegend().setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
        this.f19337h.getLegend().setTextSize(14.0f);
        this.f19337h.getXAxis().setGranularity(1.0f);
        this.f19337h.setExtraBottomOffset(20.0f);
        this.f19337h.getAxisLeft().setAxisMinimum(0.0f);
    }

    /* renamed from: O */
    private void m39805O() {
        Integer num;
        if (getArguments().containsKey("step")) {
            String string = getArguments().getString("step");
            if (TextUtils.isEmpty(string)) {
                return;
            }
            List arrayList = new ArrayList();
            int i = 0;
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
            int i2 = 0;
            while (i < arrayList.size()) {
                i2 += ((Integer) arrayList.get(i)).intValue();
                i++;
                arrayList2.add(String.valueOf(i));
                arrayList3.add(new BarEntry(i, num.intValue()));
            }
            BarDataSet barDataSet = new BarDataSet(arrayList3, "步数(共" + i2 + ")");
            barDataSet.setColor(ContextCompat.getColor(this.f1678e, 2131034489));
            barDataSet.setDrawValues(true);
            barDataSet.setHighLightAlpha(37);
            XAxis xAxis = this.f19337h.getXAxis();
            xAxis.setGranularity(1.0f);
            xAxis.setValueFormatter(new C5327a());
            barDataSet.setValueFormatter(new C5328b());
            ArrayList arrayList4 = new ArrayList();
            arrayList4.add(barDataSet);
            this.f19337h.setData(new BarData(arrayList4));
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    /* renamed from: b */
    public void mo39445b() {
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    /* renamed from: e */
    protected void mo39444e() {
        m39806N();
        m39805O();
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    /* renamed from: f */
    protected void mo39443f(View view) {
        this.f19337h = (BarChart) m57916c(C4215R.C4219id.chart);
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    /* renamed from: i */
    protected int mo39442i() {
        return C4215R.C4221layout.fm_run_step;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }
}
