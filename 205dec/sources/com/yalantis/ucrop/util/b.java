package com.yalantis.ucrop.util;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: CubicEasing.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class b {
    public static float a(float f4, float f5, float f6, float f7) {
        float f8 = f4 / f7;
        return (f6 * f8 * f8 * f8) + f5;
    }

    public static float b(float f4, float f5, float f6, float f7) {
        float f8;
        float f9 = f4 / (f7 / 2.0f);
        float f10 = f6 / 2.0f;
        if (f9 < 1.0f) {
            f8 = f10 * f9 * f9 * f9;
        } else {
            float f11 = f9 - 2.0f;
            f8 = f10 * ((f11 * f11 * f11) + 2.0f);
        }
        return f8 + f5;
    }

    public static float c(float f4, float f5, float f6, float f7) {
        float f8 = (f4 / f7) - 1.0f;
        return (f6 * ((f8 * f8 * f8) + 1.0f)) + f5;
    }
}
