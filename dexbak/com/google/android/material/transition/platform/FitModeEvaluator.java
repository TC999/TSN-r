package com.google.android.material.transition.platform;

import android.graphics.RectF;
import androidx.annotation.RequiresApi;

/* JADX INFO: Access modifiers changed from: package-private */
@RequiresApi(21)
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public interface FitModeEvaluator {
    void applyMask(RectF rectF, float f, FitModeResult fitModeResult);

    FitModeResult evaluate(float f, float f2, float f3, float f4, float f5, float f6, float f7);

    boolean shouldMaskStartBounds(FitModeResult fitModeResult);
}
