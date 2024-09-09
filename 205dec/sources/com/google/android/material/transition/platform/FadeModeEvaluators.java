package com.google.android.material.transition.platform;

import androidx.annotation.RequiresApi;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
@RequiresApi(21)
/* loaded from: E:\TSN-r\205dec\6520572.dex */
class FadeModeEvaluators {
    private static final FadeModeEvaluator IN = new FadeModeEvaluator() { // from class: com.google.android.material.transition.platform.FadeModeEvaluators.1
        @Override // com.google.android.material.transition.platform.FadeModeEvaluator
        public FadeModeResult evaluate(float f4, float f5, float f6) {
            return FadeModeResult.endOnTop(255, TransitionUtils.lerp(0, 255, f5, f6, f4));
        }
    };
    private static final FadeModeEvaluator OUT = new FadeModeEvaluator() { // from class: com.google.android.material.transition.platform.FadeModeEvaluators.2
        @Override // com.google.android.material.transition.platform.FadeModeEvaluator
        public FadeModeResult evaluate(float f4, float f5, float f6) {
            return FadeModeResult.startOnTop(TransitionUtils.lerp(255, 0, f5, f6, f4), 255);
        }
    };
    private static final FadeModeEvaluator CROSS = new FadeModeEvaluator() { // from class: com.google.android.material.transition.platform.FadeModeEvaluators.3
        @Override // com.google.android.material.transition.platform.FadeModeEvaluator
        public FadeModeResult evaluate(float f4, float f5, float f6) {
            return FadeModeResult.startOnTop(TransitionUtils.lerp(255, 0, f5, f6, f4), TransitionUtils.lerp(0, 255, f5, f6, f4));
        }
    };
    private static final FadeModeEvaluator THROUGH = new FadeModeEvaluator() { // from class: com.google.android.material.transition.platform.FadeModeEvaluators.4
        @Override // com.google.android.material.transition.platform.FadeModeEvaluator
        public FadeModeResult evaluate(float f4, float f5, float f6) {
            float f7 = ((f6 - f5) * 0.35f) + f5;
            return FadeModeResult.startOnTop(TransitionUtils.lerp(255, 0, f5, f7, f4), TransitionUtils.lerp(0, 255, f7, f6, f4));
        }
    };

    private FadeModeEvaluators() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static FadeModeEvaluator get(int i4, boolean z3) {
        if (i4 == 0) {
            return z3 ? IN : OUT;
        } else if (i4 == 1) {
            return z3 ? OUT : IN;
        } else if (i4 != 2) {
            if (i4 == 3) {
                return THROUGH;
            }
            throw new IllegalArgumentException("Invalid fade mode: " + i4);
        } else {
            return CROSS;
        }
    }
}
