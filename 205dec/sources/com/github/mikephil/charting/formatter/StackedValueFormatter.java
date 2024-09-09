package com.github.mikephil.charting.formatter;

import com.github.mikephil.charting.data.BarEntry;
import java.text.DecimalFormat;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class StackedValueFormatter extends ValueFormatter {
    private boolean mDrawWholeStack;
    private DecimalFormat mFormat;
    private String mSuffix;

    public StackedValueFormatter(boolean z3, String str, int i4) {
        this.mDrawWholeStack = z3;
        this.mSuffix = str;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i5 = 0; i5 < i4; i5++) {
            if (i5 == 0) {
                stringBuffer.append(".");
            }
            stringBuffer.append("0");
        }
        this.mFormat = new DecimalFormat("###,###,###,##0" + stringBuffer.toString());
    }

    @Override // com.github.mikephil.charting.formatter.ValueFormatter
    public String getBarStackedLabel(float f4, BarEntry barEntry) {
        float[] yVals;
        if (!this.mDrawWholeStack && (yVals = barEntry.getYVals()) != null) {
            if (yVals[yVals.length - 1] == f4) {
                return this.mFormat.format(barEntry.getY()) + this.mSuffix;
            }
            return "";
        }
        return this.mFormat.format(f4) + this.mSuffix;
    }
}
