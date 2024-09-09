package com.github.mikephil.charting.highlight;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public final class Range {
    public float from;
    public float to;

    public Range(float f4, float f5) {
        this.from = f4;
        this.to = f5;
    }

    public boolean contains(float f4) {
        return f4 > this.from && f4 <= this.to;
    }

    public boolean isLarger(float f4) {
        return f4 > this.to;
    }

    public boolean isSmaller(float f4) {
        return f4 < this.from;
    }
}
