package com.google.android.material.transition.platform;

import androidx.annotation.RequiresApi;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
@RequiresApi(21)
/* loaded from: E:\TSN-r\205dec\6520572.dex */
class FadeModeResult {
    final int endAlpha;
    final boolean endOnTop;
    final int startAlpha;

    private FadeModeResult(int i4, int i5, boolean z3) {
        this.startAlpha = i4;
        this.endAlpha = i5;
        this.endOnTop = z3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static FadeModeResult endOnTop(int i4, int i5) {
        return new FadeModeResult(i4, i5, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static FadeModeResult startOnTop(int i4, int i5) {
        return new FadeModeResult(i4, i5, false);
    }
}
