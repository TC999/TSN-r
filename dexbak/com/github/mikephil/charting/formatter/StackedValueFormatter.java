package com.github.mikephil.charting.formatter;

import com.github.mikephil.charting.data.BarEntry;
import java.text.DecimalFormat;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class StackedValueFormatter extends ValueFormatter {
    private boolean mDrawWholeStack;
    private DecimalFormat mFormat;
    private String mSuffix;

    public StackedValueFormatter(boolean z, String str, int i) {
        this.mDrawWholeStack = z;
        this.mSuffix = str;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < i; i2++) {
            if (i2 == 0) {
                stringBuffer.append(".");
            }
            stringBuffer.append("0");
        }
        this.mFormat = new DecimalFormat("###,###,###,##0" + stringBuffer.toString());
    }

    @Override // com.github.mikephil.charting.formatter.ValueFormatter
    public String getBarStackedLabel(float f, BarEntry barEntry) {
        float[] yVals;
        if (!this.mDrawWholeStack && (yVals = barEntry.getYVals()) != null) {
            if (yVals[yVals.length - 1] == f) {
                return this.mFormat.format(barEntry.getY()) + this.mSuffix;
            }
            return "";
        }
        return this.mFormat.format(f) + this.mSuffix;
    }
}
