package com.bxkj.student.p094v2.common.view;

import android.content.Context;
import android.util.AttributeSet;
import com.github.mikephil.charting.charts.BarChart;

/* renamed from: com.bxkj.student.v2.common.view.CustomBarChart */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class CustomBarChart extends BarChart {
    public CustomBarChart(Context context) {
        super(context);
    }

    @Override // com.github.mikephil.charting.charts.BarChart, com.github.mikephil.charting.charts.BarLineChartBase, com.github.mikephil.charting.charts.Chart
    protected void init() {
        super.init();
        this.mRenderer = new CustomBarChartRenderer(this, this.mAnimator, this.mViewPortHandler);
    }

    public CustomBarChart(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomBarChart(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }
}
