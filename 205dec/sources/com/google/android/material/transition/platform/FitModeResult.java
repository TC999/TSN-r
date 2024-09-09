package com.google.android.material.transition.platform;

import androidx.annotation.RequiresApi;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
@RequiresApi(21)
/* loaded from: E:\TSN-r\205dec\6520572.dex */
class FitModeResult {
    final float currentEndHeight;
    final float currentEndWidth;
    final float currentStartHeight;
    final float currentStartWidth;
    final float endScale;
    final float startScale;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FitModeResult(float f4, float f5, float f6, float f7, float f8, float f9) {
        this.startScale = f4;
        this.endScale = f5;
        this.currentStartWidth = f6;
        this.currentStartHeight = f7;
        this.currentEndWidth = f8;
        this.currentEndHeight = f9;
    }
}
