package com.github.mikephil.charting.components;

import android.graphics.DashPathEffect;
import com.github.mikephil.charting.components.Legend;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class LegendEntry {
    public Legend.LegendForm form;
    public int formColor;
    public DashPathEffect formLineDashEffect;
    public float formLineWidth;
    public float formSize;
    public String label;

    public LegendEntry() {
        this.form = Legend.LegendForm.DEFAULT;
        this.formSize = Float.NaN;
        this.formLineWidth = Float.NaN;
        this.formLineDashEffect = null;
        this.formColor = 1122867;
    }

    public LegendEntry(String str, Legend.LegendForm legendForm, float f4, float f5, DashPathEffect dashPathEffect, int i4) {
        Legend.LegendForm legendForm2 = Legend.LegendForm.DEFAULT;
        this.label = str;
        this.form = legendForm;
        this.formSize = f4;
        this.formLineWidth = f5;
        this.formLineDashEffect = dashPathEffect;
        this.formColor = i4;
    }
}
