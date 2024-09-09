package com.google.zxing.common.detector;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class MathUtils {
    private MathUtils() {
    }

    public static float distance(float f4, float f5, float f6, float f7) {
        float f8 = f4 - f6;
        float f9 = f5 - f7;
        return (float) Math.sqrt((f8 * f8) + (f9 * f9));
    }

    public static int round(float f4) {
        return (int) (f4 + (f4 < 0.0f ? -0.5f : 0.5f));
    }

    public static int sum(int[] iArr) {
        int i4 = 0;
        for (int i5 : iArr) {
            i4 += i5;
        }
        return i4;
    }

    public static float distance(int i4, int i5, int i6, int i7) {
        int i8 = i4 - i6;
        int i9 = i5 - i7;
        return (float) Math.sqrt((i8 * i8) + (i9 * i9));
    }
}
