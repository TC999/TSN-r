package com.bxkj.student.run.app.my;

import android.graphics.Matrix;
import android.view.View;
import androidx.core.content.ContextCompat;
import cn.bluemobi.dylan.base.BaseFragment;
import cn.bluemobi.dylan.base.utils.u;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import java.util.ArrayList;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class RunStaticsFragment extends BaseFragment {

    /* renamed from: h  reason: collision with root package name */
    private BarChart f22467h;

    /* renamed from: i  reason: collision with root package name */
    private int f22468i;

    /* renamed from: j  reason: collision with root package name */
    private float[] f22469j;

    /* renamed from: k  reason: collision with root package name */
    private float f22470k = 0.13333334f;

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
            int i4 = (int) value;
            if (RunStaticsFragment.this.f22468i == 1) {
                return u.n(i4);
            }
            if (RunStaticsFragment.this.f22468i == 2) {
                return i4 + "\u65e5";
            } else if (RunStaticsFragment.this.f22468i == 3) {
                return i4 + "\u5468";
            } else {
                return i4 + "";
            }
        }
    }

    private void O() {
        Description description = new Description();
        description.setText("");
        this.f22467h.setDescription(description);
        this.f22467h.setNoDataText("\u6682\u65e0\u6570\u636e");
        this.f22467h.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);
        this.f22467h.getXAxis().setDrawGridLines(false);
        this.f22467h.getAxisRight().setEnabled(false);
        this.f22467h.getAxisLeft().setDrawGridLines(false);
        this.f22467h.getAxisRight().setDrawGridLines(false);
        this.f22467h.getXAxis().setDrawGridLines(false);
        this.f22467h.getLegend().setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        this.f22467h.getLegend().setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
        Matrix matrix = new Matrix();
        matrix.postScale(P(this.f22469j.length), 1.0f);
        this.f22467h.getViewPortHandler().refresh(matrix, this.f22467h, false);
        this.f22467h.setPinchZoom(false);
        this.f22467h.setDoubleTapToZoomEnabled(false);
    }

    private float P(int xCount) {
        return xCount * this.f22470k;
    }

    private void Q() {
        ArrayList arrayList = new ArrayList();
        int i4 = 0;
        while (i4 < this.f22469j.length) {
            int i5 = i4 + 1;
            arrayList.add(new BarEntry(i5, this.f22469j[i4]));
            i4 = i5;
        }
        BarDataSet barDataSet = new BarDataSet(arrayList, "\u91cc\u7a0b(KM)");
        barDataSet.setColor(ContextCompat.getColor(this.f1665e, 2131034489));
        barDataSet.setDrawValues(true);
        barDataSet.setHighLightAlpha(37);
        XAxis xAxis = this.f22467h.getXAxis();
        xAxis.setGranularity(1.0f);
        xAxis.setValueFormatter(new a());
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(barDataSet);
        this.f22467h.setData(new BarData(arrayList2));
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    public void b() {
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    protected void e() {
        if (getArguments().containsKey("type")) {
            this.f22468i = getArguments().getInt("type");
        }
        if (getArguments().containsKey("listData")) {
            this.f22469j = getArguments().getFloatArray("listData");
        }
        O();
        Q();
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    protected void f(View view) {
        this.f22467h = (BarChart) c(2131230846);
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    protected int i() {
        return 2131427644;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
    }
}
