package com.scwang.smartrefresh.header.internal;

import android.view.animation.Interpolator;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: LookupTableInterpolator.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
abstract class b implements Interpolator {

    /* renamed from: a  reason: collision with root package name */
    private final float[] f47783a;

    /* renamed from: b  reason: collision with root package name */
    private final float f47784b;

    public b(float[] fArr) {
        this.f47783a = fArr;
        this.f47784b = 1.0f / (fArr.length - 1);
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f4) {
        if (f4 >= 1.0f) {
            return 1.0f;
        }
        if (f4 <= 0.0f) {
            return 0.0f;
        }
        float[] fArr = this.f47783a;
        int min = Math.min((int) ((fArr.length - 1) * f4), fArr.length - 2);
        float f5 = this.f47784b;
        float f6 = (f4 - (min * f5)) / f5;
        float[] fArr2 = this.f47783a;
        return fArr2[min] + (f6 * (fArr2[min + 1] - fArr2[min]));
    }
}
