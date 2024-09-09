package com.qq.e.lib.c;

import android.graphics.Color;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final ThreadLocal<double[]> f47365a = new ThreadLocal<>();

    private static float a(float f4, float f5, float f6) {
        return f4 < f5 ? f5 : f4 > f6 ? f6 : f4;
    }

    private static int a(int i4, int i5, int i6, int i7, int i8) {
        if (i8 == 0) {
            return 0;
        }
        return (((i4 * 255) * i5) + ((i6 * i7) * (255 - i5))) / (i8 * 255);
    }

    private static int b(int i4, int i5) {
        return 255 - (((255 - i5) * (255 - i4)) / 255);
    }

    public static int c(int i4, int i5) {
        int alpha = Color.alpha(i5);
        int alpha2 = Color.alpha(i4);
        int b4 = b(alpha2, alpha);
        return Color.argb(b4, a(Color.red(i4), alpha2, Color.red(i5), alpha, b4), a(Color.green(i4), alpha2, Color.green(i5), alpha, b4), a(Color.blue(i4), alpha2, Color.blue(i5), alpha, b4));
    }

    public static int d(int i4, int i5) {
        if (i5 < 0 || i5 > 255) {
            throw new IllegalArgumentException("alpha must be between 0 and 255.");
        }
        return (i4 & 16777215) | (i5 << 24);
    }

    public static double a(int i4) {
        double[] a4 = a();
        a(i4, a4);
        return a4[1] / 100.0d;
    }

    public static double a(int i4, int i5) {
        if (Color.alpha(i5) == 255) {
            if (Color.alpha(i4) < 255) {
                i4 = c(i4, i5);
            }
            double a4 = a(i4) + 0.05d;
            double a5 = a(i5) + 0.05d;
            return Math.max(a4, a5) / Math.min(a4, a5);
        }
        throw new IllegalArgumentException("background can not be translucent: #" + Integer.toHexString(i5));
    }

    public static int a(int i4, int i5, float f4) {
        int i6 = 255;
        if (Color.alpha(i5) == 255) {
            double d4 = f4;
            if (a(d(i4, 255), i5) < d4) {
                return -1;
            }
            int i7 = 0;
            for (int i8 = 0; i8 <= 10 && i6 - i7 > 1; i8++) {
                int i9 = (i7 + i6) / 2;
                if (a(d(i4, i9), i5) < d4) {
                    i7 = i9;
                } else {
                    i6 = i9;
                }
            }
            return i6;
        }
        throw new IllegalArgumentException("background can not be translucent: #" + Integer.toHexString(i5));
    }

    public static void a(int i4, int i5, int i6, float[] fArr) {
        float f4;
        float abs;
        float f5 = i4 / 255.0f;
        float f6 = i5 / 255.0f;
        float f7 = i6 / 255.0f;
        float max = Math.max(f5, Math.max(f6, f7));
        float min = Math.min(f5, Math.min(f6, f7));
        float f8 = max - min;
        float f9 = (max + min) / 2.0f;
        if (max == min) {
            f4 = 0.0f;
            abs = 0.0f;
        } else {
            f4 = max == f5 ? ((f6 - f7) / f8) % 6.0f : max == f6 ? ((f7 - f5) / f8) + 2.0f : 4.0f + ((f5 - f6) / f8);
            abs = f8 / (1.0f - Math.abs((2.0f * f9) - 1.0f));
        }
        float f10 = (f4 * 60.0f) % 360.0f;
        if (f10 < 0.0f) {
            f10 += 360.0f;
        }
        fArr[0] = a(f10, 0.0f, 360.0f);
        fArr[1] = a(abs, 0.0f, 1.0f);
        fArr[2] = a(f9, 0.0f, 1.0f);
    }

    public static void a(int i4, float[] fArr) {
        a(Color.red(i4), Color.green(i4), Color.blue(i4), fArr);
    }

    public static void a(int i4, double[] dArr) {
        a(Color.red(i4), Color.green(i4), Color.blue(i4), dArr);
    }

    public static void a(int i4, int i5, int i6, double[] dArr) {
        if (dArr.length == 3) {
            double d4 = i4;
            Double.isNaN(d4);
            double d5 = d4 / 255.0d;
            double pow = d5 < 0.04045d ? d5 / 12.92d : Math.pow((d5 + 0.055d) / 1.055d, 2.4d);
            double d6 = i5;
            Double.isNaN(d6);
            double d7 = d6 / 255.0d;
            double pow2 = d7 < 0.04045d ? d7 / 12.92d : Math.pow((d7 + 0.055d) / 1.055d, 2.4d);
            double d8 = i6;
            Double.isNaN(d8);
            double d9 = d8 / 255.0d;
            double pow3 = d9 < 0.04045d ? d9 / 12.92d : Math.pow((d9 + 0.055d) / 1.055d, 2.4d);
            dArr[0] = ((0.4124d * pow) + (0.3576d * pow2) + (0.1805d * pow3)) * 100.0d;
            dArr[1] = ((0.2126d * pow) + (0.7152d * pow2) + (0.0722d * pow3)) * 100.0d;
            dArr[2] = ((pow * 0.0193d) + (pow2 * 0.1192d) + (pow3 * 0.9505d)) * 100.0d;
            return;
        }
        throw new IllegalArgumentException("outXyz must have a length of 3.");
    }

    private static double[] a() {
        double[] dArr = f47365a.get();
        if (dArr == null) {
            double[] dArr2 = new double[3];
            f47365a.set(dArr2);
            return dArr2;
        }
        return dArr;
    }
}
