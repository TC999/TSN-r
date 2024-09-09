package com.github.mikephil.charting.data;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import com.github.mikephil.charting.highlight.Range;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
@SuppressLint({"ParcelCreator"})
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class BarEntry extends Entry {
    private float mNegativeSum;
    private float mPositiveSum;
    private Range[] mRanges;
    private float[] mYVals;

    public BarEntry(float f4, float f5) {
        super(f4, f5);
    }

    private void calcPosNegSum() {
        float[] fArr = this.mYVals;
        if (fArr == null) {
            this.mNegativeSum = 0.0f;
            this.mPositiveSum = 0.0f;
            return;
        }
        float f4 = 0.0f;
        float f5 = 0.0f;
        for (float f6 : fArr) {
            if (f6 <= 0.0f) {
                f4 += Math.abs(f6);
            } else {
                f5 += f6;
            }
        }
        this.mNegativeSum = f4;
        this.mPositiveSum = f5;
    }

    private static float calcSum(float[] fArr) {
        float f4 = 0.0f;
        if (fArr == null) {
            return 0.0f;
        }
        for (float f5 : fArr) {
            f4 += f5;
        }
        return f4;
    }

    protected void calcRanges() {
        float[] yVals = getYVals();
        if (yVals == null || yVals.length == 0) {
            return;
        }
        this.mRanges = new Range[yVals.length];
        float f4 = -getNegativeSum();
        int i4 = 0;
        float f5 = 0.0f;
        while (true) {
            Range[] rangeArr = this.mRanges;
            if (i4 >= rangeArr.length) {
                return;
            }
            float f6 = yVals[i4];
            if (f6 < 0.0f) {
                float f7 = f4 - f6;
                rangeArr[i4] = new Range(f4, f7);
                f4 = f7;
            } else {
                float f8 = f6 + f5;
                rangeArr[i4] = new Range(f5, f8);
                f5 = f8;
            }
            i4++;
        }
    }

    @Deprecated
    public float getBelowSum(int i4) {
        return getSumBelow(i4);
    }

    public float getNegativeSum() {
        return this.mNegativeSum;
    }

    public float getPositiveSum() {
        return this.mPositiveSum;
    }

    public Range[] getRanges() {
        return this.mRanges;
    }

    public float getSumBelow(int i4) {
        float[] fArr = this.mYVals;
        float f4 = 0.0f;
        if (fArr == null) {
            return 0.0f;
        }
        for (int length = fArr.length - 1; length > i4 && length >= 0; length--) {
            f4 += this.mYVals[length];
        }
        return f4;
    }

    @Override // com.github.mikephil.charting.data.BaseEntry
    public float getY() {
        return super.getY();
    }

    public float[] getYVals() {
        return this.mYVals;
    }

    public boolean isStacked() {
        return this.mYVals != null;
    }

    public void setVals(float[] fArr) {
        setY(calcSum(fArr));
        this.mYVals = fArr;
        calcPosNegSum();
        calcRanges();
    }

    public BarEntry(float f4, float f5, Object obj) {
        super(f4, f5, obj);
    }

    @Override // com.github.mikephil.charting.data.Entry
    public BarEntry copy() {
        BarEntry barEntry = new BarEntry(getX(), getY(), getData());
        barEntry.setVals(this.mYVals);
        return barEntry;
    }

    public BarEntry(float f4, float f5, Drawable drawable) {
        super(f4, f5, drawable);
    }

    public BarEntry(float f4, float f5, Drawable drawable, Object obj) {
        super(f4, f5, drawable, obj);
    }

    public BarEntry(float f4, float[] fArr) {
        super(f4, calcSum(fArr));
        this.mYVals = fArr;
        calcPosNegSum();
        calcRanges();
    }

    public BarEntry(float f4, float[] fArr, Object obj) {
        super(f4, calcSum(fArr), obj);
        this.mYVals = fArr;
        calcPosNegSum();
        calcRanges();
    }

    public BarEntry(float f4, float[] fArr, Drawable drawable) {
        super(f4, calcSum(fArr), drawable);
        this.mYVals = fArr;
        calcPosNegSum();
        calcRanges();
    }

    public BarEntry(float f4, float[] fArr, Drawable drawable, Object obj) {
        super(f4, calcSum(fArr), drawable, obj);
        this.mYVals = fArr;
        calcPosNegSum();
        calcRanges();
    }
}
