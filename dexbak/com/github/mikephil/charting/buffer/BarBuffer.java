package com.github.mikephil.charting.buffer;

import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class BarBuffer extends AbstractBuffer<IBarDataSet> {
    protected float mBarWidth;
    protected boolean mContainsStacks;
    protected int mDataSetCount;
    protected int mDataSetIndex;
    protected boolean mInverted;

    public BarBuffer(int i, int i2, boolean z) {
        super(i);
        this.mDataSetIndex = 0;
        this.mInverted = false;
        this.mBarWidth = 1.0f;
        this.mDataSetCount = i2;
        this.mContainsStacks = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void addBar(float f, float f2, float f3, float f4) {
        float[] fArr = this.buffer;
        int i = this.index;
        int i2 = i + 1;
        this.index = i2;
        fArr[i] = f;
        int i3 = i2 + 1;
        this.index = i3;
        fArr[i2] = f2;
        int i4 = i3 + 1;
        this.index = i4;
        fArr[i3] = f3;
        this.index = i4 + 1;
        fArr[i4] = f4;
    }

    public void setBarWidth(float f) {
        this.mBarWidth = f;
    }

    public void setDataSet(int i) {
        this.mDataSetIndex = i;
    }

    public void setInverted(boolean z) {
        this.mInverted = z;
    }

    @Override // com.github.mikephil.charting.buffer.AbstractBuffer
    public void feed(IBarDataSet iBarDataSet) {
        float f;
        float abs;
        float abs2;
        float f2;
        float entryCount = iBarDataSet.getEntryCount() * this.phaseX;
        float f3 = this.mBarWidth / 2.0f;
        for (int i = 0; i < entryCount; i++) {
            BarEntry barEntry = (BarEntry) iBarDataSet.getEntryForIndex(i);
            if (barEntry != null) {
                float x = barEntry.getX();
                float y = barEntry.getY();
                float[] yVals = barEntry.getYVals();
                if (this.mContainsStacks && yVals != null) {
                    float f4 = -barEntry.getNegativeSum();
                    int i2 = 0;
                    float f5 = 0.0f;
                    while (i2 < yVals.length) {
                        float f6 = yVals[i2];
                        if (f6 == 0.0f && (f5 == 0.0f || f4 == 0.0f)) {
                            abs = f6;
                            abs2 = f4;
                            f4 = abs;
                        } else if (f6 >= 0.0f) {
                            abs = f6 + f5;
                            abs2 = f4;
                            f4 = f5;
                            f5 = abs;
                        } else {
                            abs = Math.abs(f6) + f4;
                            abs2 = Math.abs(f6) + f4;
                        }
                        float f7 = x - f3;
                        float f8 = x + f3;
                        if (this.mInverted) {
                            f2 = f4 >= abs ? f4 : abs;
                            if (f4 > abs) {
                                f4 = abs;
                            }
                        } else {
                            float f9 = f4 >= abs ? f4 : abs;
                            if (f4 > abs) {
                                f4 = abs;
                            }
                            float f10 = f4;
                            f4 = f9;
                            f2 = f10;
                        }
                        float f11 = this.phaseY;
                        addBar(f7, f4 * f11, f8, f2 * f11);
                        i2++;
                        f4 = abs2;
                    }
                } else {
                    float f12 = x - f3;
                    float f13 = x + f3;
                    if (this.mInverted) {
                        f = y >= 0.0f ? y : 0.0f;
                        if (y > 0.0f) {
                            y = 0.0f;
                        }
                    } else {
                        float f14 = y >= 0.0f ? y : 0.0f;
                        if (y > 0.0f) {
                            y = 0.0f;
                        }
                        float f15 = y;
                        y = f14;
                        f = f15;
                    }
                    if (y > 0.0f) {
                        y *= this.phaseY;
                    } else {
                        f *= this.phaseY;
                    }
                    addBar(f12, y, f13, f);
                }
            }
        }
        reset();
    }
}
