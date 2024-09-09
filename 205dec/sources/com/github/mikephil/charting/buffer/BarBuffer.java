package com.github.mikephil.charting.buffer;

import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class BarBuffer extends AbstractBuffer<IBarDataSet> {
    protected float mBarWidth;
    protected boolean mContainsStacks;
    protected int mDataSetCount;
    protected int mDataSetIndex;
    protected boolean mInverted;

    public BarBuffer(int i4, int i5, boolean z3) {
        super(i4);
        this.mDataSetIndex = 0;
        this.mInverted = false;
        this.mBarWidth = 1.0f;
        this.mDataSetCount = i5;
        this.mContainsStacks = z3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void addBar(float f4, float f5, float f6, float f7) {
        float[] fArr = this.buffer;
        int i4 = this.index;
        int i5 = i4 + 1;
        this.index = i5;
        fArr[i4] = f4;
        int i6 = i5 + 1;
        this.index = i6;
        fArr[i5] = f5;
        int i7 = i6 + 1;
        this.index = i7;
        fArr[i6] = f6;
        this.index = i7 + 1;
        fArr[i7] = f7;
    }

    public void setBarWidth(float f4) {
        this.mBarWidth = f4;
    }

    public void setDataSet(int i4) {
        this.mDataSetIndex = i4;
    }

    public void setInverted(boolean z3) {
        this.mInverted = z3;
    }

    @Override // com.github.mikephil.charting.buffer.AbstractBuffer
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
                        if (f9 == 0.0f && (f8 == 0.0f || f7 == 0.0f)) {
                            abs = f9;
                            abs2 = f7;
                            f7 = abs;
                        } else if (f9 >= 0.0f) {
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
                        addBar(f10, f7 * f14, f11, f5 * f14);
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
                    addBar(f15, y3, f16, f4);
                }
            }
        }
        reset();
    }
}
