package com.github.mikephil.charting.buffer;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public abstract class AbstractBuffer<T> {
    public final float[] buffer;
    protected float phaseX = 1.0f;
    protected float phaseY = 1.0f;
    protected int mFrom = 0;
    protected int mTo = 0;
    protected int index = 0;

    public AbstractBuffer(int i4) {
        this.buffer = new float[i4];
    }

    public abstract void feed(T t3);

    public void limitFrom(int i4) {
        if (i4 < 0) {
            i4 = 0;
        }
        this.mFrom = i4;
    }

    public void limitTo(int i4) {
        if (i4 < 0) {
            i4 = 0;
        }
        this.mTo = i4;
    }

    public void reset() {
        this.index = 0;
    }

    public void setPhases(float f4, float f5) {
        this.phaseX = f4;
        this.phaseY = f5;
    }

    public int size() {
        return this.buffer.length;
    }
}
