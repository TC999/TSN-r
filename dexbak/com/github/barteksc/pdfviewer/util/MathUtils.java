package com.github.barteksc.pdfviewer.util;

/* renamed from: com.github.barteksc.pdfviewer.util.d */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class MathUtils {

    /* renamed from: a */
    private static final int f23742a = 16384;

    /* renamed from: b */
    private static final double f23743b = 16384.0d;

    /* renamed from: c */
    private static final double f23744c = 16384.999999999996d;

    private MathUtils() {
    }

    /* renamed from: a */
    public static int m35309a(float f) {
        double d;
        Double.isNaN(f);
        return ((int) (d + f23744c)) - 16384;
    }

    /* renamed from: b */
    public static int m35308b(float f) {
        double d;
        Double.isNaN(f);
        return ((int) (d + f23743b)) - 16384;
    }

    /* renamed from: c */
    public static float m35307c(float f, float f2, float f3) {
        return f <= f2 ? f2 : f >= f3 ? f3 : f;
    }

    /* renamed from: d */
    public static int m35306d(int i, int i2, int i3) {
        return i <= i2 ? i2 : i >= i3 ? i3 : i;
    }

    /* renamed from: e */
    public static float m35305e(float f, float f2) {
        return f > f2 ? f2 : f;
    }

    /* renamed from: f */
    public static int m35304f(int i, int i2) {
        return i > i2 ? i2 : i;
    }

    /* renamed from: g */
    public static float m35303g(float f, float f2) {
        return f < f2 ? f2 : f;
    }

    /* renamed from: h */
    public static int m35302h(int i, int i2) {
        return i < i2 ? i2 : i;
    }
}
