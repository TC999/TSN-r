package com.scwang.smartrefresh.layout.util;

import android.view.animation.Interpolator;

/* renamed from: com.scwang.smartrefresh.layout.util.e */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class ViscousFluidInterpolator implements Interpolator {

    /* renamed from: a */
    private static final float f33746a = 8.0f;

    /* renamed from: b */
    private static final float f33747b;

    /* renamed from: c */
    private static final float f33748c;

    static {
        float m19755a = 1.0f / m19755a(1.0f);
        f33747b = m19755a;
        f33748c = 1.0f - (m19755a * m19755a(1.0f));
    }

    /* renamed from: a */
    private static float m19755a(float f) {
        float f2 = f * f33746a;
        if (f2 < 1.0f) {
            return f2 - (1.0f - ((float) Math.exp(-f2)));
        }
        return ((1.0f - ((float) Math.exp(1.0f - f2))) * 0.63212055f) + 0.36787945f;
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        float m19755a = f33747b * m19755a(f);
        return m19755a > 0.0f ? m19755a + f33748c : m19755a;
    }
}
