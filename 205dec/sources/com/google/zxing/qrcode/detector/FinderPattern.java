package com.google.zxing.qrcode.detector;

import com.google.zxing.ResultPoint;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class FinderPattern extends ResultPoint {
    private final int count;
    private final float estimatedModuleSize;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FinderPattern(float f4, float f5, float f6) {
        this(f4, f5, f6, 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean aboutEquals(float f4, float f5, float f6) {
        if (Math.abs(f5 - getY()) > f4 || Math.abs(f6 - getX()) > f4) {
            return false;
        }
        float abs = Math.abs(f4 - this.estimatedModuleSize);
        return abs <= 1.0f || abs <= this.estimatedModuleSize;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FinderPattern combineEstimate(float f4, float f5, float f6) {
        int i4 = this.count;
        int i5 = i4 + 1;
        float x3 = (i4 * getX()) + f5;
        float f7 = i5;
        return new FinderPattern(x3 / f7, ((this.count * getY()) + f4) / f7, ((this.count * this.estimatedModuleSize) + f6) / f7, i5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getCount() {
        return this.count;
    }

    public float getEstimatedModuleSize() {
        return this.estimatedModuleSize;
    }

    private FinderPattern(float f4, float f5, float f6, int i4) {
        super(f4, f5);
        this.estimatedModuleSize = f6;
        this.count = i4;
    }
}
