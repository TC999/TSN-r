package com.scwang.smartrefresh.header.internal;

import android.view.animation.Interpolator;

/* renamed from: com.scwang.smartrefresh.header.internal.b */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
abstract class LookupTableInterpolator implements Interpolator {

    /* renamed from: a */
    private final float[] f33398a;

    /* renamed from: b */
    private final float f33399b;

    public LookupTableInterpolator(float[] fArr) {
        this.f33398a = fArr;
        this.f33399b = 1.0f / (fArr.length - 1);
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        if (f >= 1.0f) {
            return 1.0f;
        }
        if (f <= 0.0f) {
            return 0.0f;
        }
        float[] fArr = this.f33398a;
        int min = Math.min((int) ((fArr.length - 1) * f), fArr.length - 2);
        float f2 = this.f33399b;
        float f3 = (f - (min * f2)) / f2;
        float[] fArr2 = this.f33398a;
        return fArr2[min] + (f3 * (fArr2[min + 1] - fArr2[min]));
    }
}
