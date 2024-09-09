package com.google.zxing.oned.rss;

import com.google.zxing.ResultPoint;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class FinderPattern {
    private final ResultPoint[] resultPoints;
    private final int[] startEnd;
    private final int value;

    public FinderPattern(int i4, int[] iArr, int i5, int i6, int i7) {
        this.value = i4;
        this.startEnd = iArr;
        float f4 = i7;
        this.resultPoints = new ResultPoint[]{new ResultPoint(i5, f4), new ResultPoint(i6, f4)};
    }

    public boolean equals(Object obj) {
        return (obj instanceof FinderPattern) && this.value == ((FinderPattern) obj).value;
    }

    public ResultPoint[] getResultPoints() {
        return this.resultPoints;
    }

    public int[] getStartEnd() {
        return this.startEnd;
    }

    public int getValue() {
        return this.value;
    }

    public int hashCode() {
        return this.value;
    }
}
