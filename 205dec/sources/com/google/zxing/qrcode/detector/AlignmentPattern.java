package com.google.zxing.qrcode.detector;

import com.google.zxing.ResultPoint;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class AlignmentPattern extends ResultPoint {
    private final float estimatedModuleSize;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AlignmentPattern(float f4, float f5, float f6) {
        super(f4, f5);
        this.estimatedModuleSize = f6;
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
    public AlignmentPattern combineEstimate(float f4, float f5, float f6) {
        return new AlignmentPattern((getX() + f5) / 2.0f, (getY() + f4) / 2.0f, (this.estimatedModuleSize + f6) / 2.0f);
    }
}
