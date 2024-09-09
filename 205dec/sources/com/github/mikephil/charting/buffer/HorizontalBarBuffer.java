package com.github.mikephil.charting.buffer;

import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class HorizontalBarBuffer extends BarBuffer {
    public HorizontalBarBuffer(int i4, int i5, boolean z3) {
        super(i4, i5, z3);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.github.mikephil.charting.buffer.BarBuffer, com.github.mikephil.charting.buffer.AbstractBuffer
    public void feed(IBarDataSet iBarDataSet) {
        float f4;
        float abs;
        float abs2;
        float f5;
        float entryCount = iBarDataSet.getEntryCount() * this.phaseX;
        float f6 = this.mBarWidth / 2.0f;
        for (int i4 = 0; i4 < entryCount; i4++) {
            BarEntry barEntry = (BarEntry) iBarDataSet.getEntryForIndex(i4);
            if (barEntry != null) {
                float x3 = barEntry.getX();
                float y3 = barEntry.getY();
                float[] yVals = barEntry.getYVals();
                if (this.mContainsStacks && yVals != null) {
                    float f7 = -barEntry.getNegativeSum();
                    int i5 = 0;
                    float f8 = 0.0f;
                    while (i5 < yVals.length) {
                        float f9 = yVals[i5];
                        if (f9 >= 0.0f) {
                            abs = f9 + f8;
                            abs2 = f7;
                            f7 = f8;
                            f8 = abs;
                        } else {
                            abs = Math.abs(f9) + f7;
                            abs2 = Math.abs(f9) + f7;
                        }
                        float f10 = x3 - f6;
                        float f11 = x3 + f6;
                        if (this.mInverted) {
                            f5 = f7 >= abs ? f7 : abs;
                            if (f7 > abs) {
                                f7 = abs;
                            }
                        } else {
                            float f12 = f7 >= abs ? f7 : abs;
                            if (f7 > abs) {
                                f7 = abs;
                            }
                            float f13 = f7;
                            f7 = f12;
                            f5 = f13;
                        }
                        float f14 = this.phaseY;
                        addBar(f5 * f14, f11, f7 * f14, f10);
                        i5++;
                        f7 = abs2;
                    }
                } else {
                    float f15 = x3 - f6;
                    float f16 = x3 + f6;
                    if (this.mInverted) {
                        f4 = y3 >= 0.0f ? y3 : 0.0f;
                        if (y3 > 0.0f) {
                            y3 = 0.0f;
                        }
                    } else {
                        float f17 = y3 >= 0.0f ? y3 : 0.0f;
                        if (y3 > 0.0f) {
                            y3 = 0.0f;
                        }
                        float f18 = y3;
                        y3 = f17;
                        f4 = f18;
                    }
                    if (y3 > 0.0f) {
                        y3 *= this.phaseY;
                    } else {
                        f4 *= this.phaseY;
                    }
                    addBar(f4, f16, y3, f15);
                }
            }
        }
        reset();
    }
}
