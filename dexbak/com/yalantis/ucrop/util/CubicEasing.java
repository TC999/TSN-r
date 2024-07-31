package com.yalantis.ucrop.util;

/* renamed from: com.yalantis.ucrop.util.b */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class CubicEasing {
    /* renamed from: a */
    public static float m13011a(float f, float f2, float f3, float f4) {
        float f5 = f / f4;
        return (f3 * f5 * f5 * f5) + f2;
    }

    /* renamed from: b */
    public static float m13010b(float f, float f2, float f3, float f4) {
        float f5;
        float f6 = f / (f4 / 2.0f);
        float f7 = f3 / 2.0f;
        if (f6 < 1.0f) {
            f5 = f7 * f6 * f6 * f6;
        } else {
            float f8 = f6 - 2.0f;
            f5 = f7 * ((f8 * f8 * f8) + 2.0f);
        }
        return f5 + f2;
    }

    /* renamed from: c */
    public static float m13009c(float f, float f2, float f3, float f4) {
        float f5 = (f / f4) - 1.0f;
        return (f3 * ((f5 * f5 * f5) + 1.0f)) + f2;
    }
}
