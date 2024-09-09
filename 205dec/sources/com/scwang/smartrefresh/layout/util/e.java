package com.scwang.smartrefresh.layout.util;

import android.view.animation.Interpolator;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: ViscousFluidInterpolator.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class e implements Interpolator {

    /* renamed from: a  reason: collision with root package name */
    private static final float f48080a = 8.0f;

    /* renamed from: b  reason: collision with root package name */
    private static final float f48081b;

    /* renamed from: c  reason: collision with root package name */
    private static final float f48082c;

    static {
        float a4 = 1.0f / a(1.0f);
        f48081b = a4;
        f48082c = 1.0f - (a4 * a(1.0f));
    }

    private static float a(float f4) {
        float f5 = f4 * 8.0f;
        if (f5 < 1.0f) {
            return f5 - (1.0f - ((float) Math.exp(-f5)));
        }
        return ((1.0f - ((float) Math.exp(1.0f - f5))) * 0.63212055f) + 0.36787945f;
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f4) {
        float a4 = f48081b * a(f4);
        return a4 > 0.0f ? a4 + f48082c : a4;
    }
}
