package com.kwad.sdk.widget;

import android.animation.ValueAnimator;

/* renamed from: com.kwad.sdk.widget.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C11143a {
    public static ValueAnimator ofArgb(int... iArr) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setIntValues(iArr);
        valueAnimator.setEvaluator(C11144b.m23547NR());
        return valueAnimator;
    }
}
