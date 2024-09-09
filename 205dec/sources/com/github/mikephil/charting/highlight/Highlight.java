package com.github.mikephil.charting.highlight;

import com.github.mikephil.charting.components.YAxis;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class Highlight {
    private YAxis.AxisDependency axis;
    private int mDataIndex;
    private int mDataSetIndex;
    private float mDrawX;
    private float mDrawY;
    private int mStackIndex;
    private float mX;
    private float mXPx;
    private float mY;
    private float mYPx;

    public Highlight(float f4, float f5, int i4) {
        this.mDataIndex = -1;
        this.mStackIndex = -1;
        this.mX = f4;
        this.mY = f5;
        this.mDataSetIndex = i4;
    }

    public boolean equalTo(Highlight highlight) {
        return highlight != null && this.mDataSetIndex == highlight.mDataSetIndex && this.mX == highlight.mX && this.mStackIndex == highlight.mStackIndex && this.mDataIndex == highlight.mDataIndex;
    }

    public YAxis.AxisDependency getAxis() {
        return this.axis;
    }

    public int getDataIndex() {
        return this.mDataIndex;
    }

    public int getDataSetIndex() {
        return this.mDataSetIndex;
    }

    public float getDrawX() {
        return this.mDrawX;
    }

    public float getDrawY() {
        return this.mDrawY;
    }

    public int getStackIndex() {
        return this.mStackIndex;
    }

    public float getX() {
        return this.mX;
    }

    public float getXPx() {
        return this.mXPx;
    }

    public float getY() {
        return this.mY;
    }

    public float getYPx() {
        return this.mYPx;
    }

    public boolean isStacked() {
        return this.mStackIndex >= 0;
    }

    public void setDataIndex(int i4) {
        this.mDataIndex = i4;
    }

    public void setDraw(float f4, float f5) {
        this.mDrawX = f4;
        this.mDrawY = f5;
    }

    public String toString() {
        return "Highlight, x: " + this.mX + ", y: " + this.mY + ", dataSetIndex: " + this.mDataSetIndex + ", stackIndex (only stacked barentry): " + this.mStackIndex;
    }

    public Highlight(float f4, int i4, int i5) {
        this(f4, Float.NaN, i4);
        this.mStackIndex = i5;
    }

    public Highlight(float f4, float f5, float f6, float f7, int i4, YAxis.AxisDependency axisDependency) {
        this.mDataIndex = -1;
        this.mStackIndex = -1;
        this.mX = f4;
        this.mY = f5;
        this.mXPx = f6;
        this.mYPx = f7;
        this.mDataSetIndex = i4;
        this.axis = axisDependency;
    }

    public Highlight(float f4, float f5, float f6, float f7, int i4, int i5, YAxis.AxisDependency axisDependency) {
        this(f4, f5, f6, f7, i4, axisDependency);
        this.mStackIndex = i5;
    }
}
