package com.github.mikephil.charting.formatter;

import java.text.DecimalFormat;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class DefaultValueFormatter extends ValueFormatter {
    protected int mDecimalDigits;
    protected DecimalFormat mFormat;

    public DefaultValueFormatter(int i4) {
        setup(i4);
    }

    public int getDecimalDigits() {
        return this.mDecimalDigits;
    }

    @Override // com.github.mikephil.charting.formatter.ValueFormatter
    public String getFormattedValue(float f4) {
        return this.mFormat.format(f4);
    }

    public void setup(int i4) {
        this.mDecimalDigits = i4;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i5 = 0; i5 < i4; i5++) {
            if (i5 == 0) {
                stringBuffer.append(".");
            }
            stringBuffer.append("0");
        }
        this.mFormat = new DecimalFormat("###,###,###,##0" + stringBuffer.toString());
    }
}
