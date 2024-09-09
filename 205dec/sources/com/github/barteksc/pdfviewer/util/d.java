package com.github.barteksc.pdfviewer.util;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* compiled from: MathUtils.java */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private static final int f37311a = 16384;

    /* renamed from: b  reason: collision with root package name */
    private static final double f37312b = 16384.0d;

    /* renamed from: c  reason: collision with root package name */
    private static final double f37313c = 16384.999999999996d;

    private d() {
    }

    public static int a(float f4) {
        double d4;
        Double.isNaN(f4);
        return ((int) (d4 + 16384.999999999996d)) - 16384;
    }

    public static int b(float f4) {
        double d4;
        Double.isNaN(f4);
        return ((int) (d4 + 16384.0d)) - 16384;
    }

    public static float c(float f4, float f5, float f6) {
        return f4 <= f5 ? f5 : f4 >= f6 ? f6 : f4;
    }

    public static int d(int i4, int i5, int i6) {
        return i4 <= i5 ? i5 : i4 >= i6 ? i6 : i4;
    }

    public static float e(float f4, float f5) {
        return f4 > f5 ? f5 : f4;
    }

    public static int f(int i4, int i5) {
        return i4 > i5 ? i5 : i4;
    }

    public static float g(float f4, float f5) {
        return f4 < f5 ? f5 : f4;
    }

    public static int h(int i4, int i5) {
        return i4 < i5 ? i5 : i4;
    }
}
