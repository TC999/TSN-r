package com.bxkj.student.run.app.p092my;

import android.graphics.Matrix;
import android.view.View;
import androidx.core.content.ContextCompat;
import cn.bluemobi.dylan.base.BaseFragment;
import cn.bluemobi.dylan.base.utils.Tools;
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

/* renamed from: com.bxkj.student.run.app.my.RunStaticsFragment */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class RunStaticsFragment extends BaseFragment {

    /* renamed from: h */
    private BarChart f19230h;

    /* renamed from: i */
    private int f19231i;

    /* renamed from: j */
    private float[] f19232j;

    /* renamed from: k */
    private float f19233k = 0.13333334f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.run.app.my.RunStaticsFragment$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C5273a extends ValueFormatter {
        C5273a() {
        }

        @Override // com.github.mikephil.charting.formatter.ValueFormatter
        public String getFormattedValue(float value) {
            int i = (int) value;
            if (RunStaticsFragment.this.f19231i == 1) {
                return Tools.m57594n(i);
            }
            if (RunStaticsFragment.this.f19231i == 2) {
                return i + "日";
            } else if (RunStaticsFragment.this.f19231i == 3) {
                return i + "周";
            } else {
                return i + "";
            }
        }
    }

    /* renamed from: O */
    private void m39933O() {
        Description description = new Description();
        description.setText("");
        this.f19230h.setDescription(description);
        this.f19230h.setNoDataText("暂无数据");
        this.f19230h.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);
        this.f19230h.getXAxis().setDrawGridLines(false);
        this.f19230h.getAxisRight().setEnabled(false);
        this.f19230h.getAxisLeft().setDrawGridLines(false);
        this.f19230h.getAxisRight().setDrawGridLines(false);
        this.f19230h.getXAxis().setDrawGridLines(false);
        this.f19230h.getLegend().setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        this.f19230h.getLegend().setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
        Matrix matrix = new Matrix();
        matrix.postScale(m39932P(this.f19232j.length), 1.0f);
        this.f19230h.getViewPortHandler().refresh(matrix, this.f19230h, false);
        this.f19230h.setPinchZoom(false);
        this.f19230h.setDoubleTapToZoomEnabled(false);
    }

    /* renamed from: P */
    private float m39932P(int xCount) {
        return xCount * this.f19233k;
    }

    /* renamed from: Q */
    private void m39931Q() {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i < this.f19232j.length) {
            int i2 = i + 1;
            arrayList.add(new BarEntry(i2, this.f19232j[i]));
            i = i2;
        }
        BarDataSet barDataSet = new BarDataSet(arrayList, "里程(KM)");
        barDataSet.setColor(ContextCompat.getColor(this.f1678e, 2131034489));
        barDataSet.setDrawValues(true);
        barDataSet.setHighLightAlpha(37);
        XAxis xAxis = this.f19230h.getXAxis();
        xAxis.setGranularity(1.0f);
        xAxis.setValueFormatter(new C5273a());
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(barDataSet);
        this.f19230h.setData(new BarData(arrayList2));
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    /* renamed from: b */
    public void mo39445b() {
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    /* renamed from: e */
    protected void mo39444e() {
        if (getArguments().containsKey("type")) {
            this.f19231i = getArguments().getInt("type");
        }
        if (getArguments().containsKey("listData")) {
            this.f19232j = getArguments().getFloatArray("listData");
        }
        m39933O();
        m39931Q();
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    /* renamed from: f */
    protected void mo39443f(View view) {
        this.f19230h = (BarChart) m57916c(C4215R.C4219id.barChart);
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    /* renamed from: i */
    protected int mo39442i() {
        return C4215R.C4221layout.fm_statistics;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }
}
