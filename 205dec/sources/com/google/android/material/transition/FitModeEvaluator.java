package com.google.android.material.transition;

import android.graphics.RectF;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public interface FitModeEvaluator {
    void applyMask(RectF rectF, float f4, FitModeResult fitModeResult);

    FitModeResult evaluate(float f4, float f5, float f6, float f7, float f8, float f9, float f10);

    boolean shouldMaskStartBounds(FitModeResult fitModeResult);
}
