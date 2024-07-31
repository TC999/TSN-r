package com.scwang.smartrefresh.layout.util;

import android.graphics.Color;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.amap.api.maps.model.WeightedLatLng;
import com.github.mikephil.charting.utils.Utils;

/* renamed from: com.scwang.smartrefresh.layout.util.a */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class ColorUtils {

    /* renamed from: a */
    private static final double f33735a = 95.047d;

    /* renamed from: b */
    private static final double f33736b = 100.0d;

    /* renamed from: c */
    private static final double f33737c = 108.883d;

    /* renamed from: d */
    private static final double f33738d = 0.008856d;

    /* renamed from: e */
    private static final double f33739e = 903.3d;

    /* renamed from: f */
    private static final int f33740f = 10;

    /* renamed from: g */
    private static final int f33741g = 1;

    /* renamed from: h */
    private static final ThreadLocal<double[]> f33742h = new ThreadLocal<>();

    private ColorUtils() {
    }

    @ColorInt
    /* renamed from: A */
    public static int m19794A(@ColorInt int i, @IntRange(from = 0, m60035to = 255) int i2) {
        if (i2 < 0 || i2 > 255) {
            throw new IllegalArgumentException("alpha must be between 0 and 255.");
        }
        return (i & 16777215) | (i2 << 24);
    }

    @ColorInt
    /* renamed from: a */
    public static int m19793a(@NonNull float[] fArr) {
        int round;
        int round2;
        int round3;
        float f = fArr[0];
        float f2 = fArr[1];
        float f3 = fArr[2];
        float abs = (1.0f - Math.abs((f3 * 2.0f) - 1.0f)) * f2;
        float f4 = f3 - (0.5f * abs);
        float abs2 = (1.0f - Math.abs(((f / 60.0f) % 2.0f) - 1.0f)) * abs;
        switch (((int) f) / 60) {
            case 0:
                round = Math.round((abs + f4) * 255.0f);
                round2 = Math.round((abs2 + f4) * 255.0f);
                round3 = Math.round(f4 * 255.0f);
                break;
            case 1:
                round = Math.round((abs2 + f4) * 255.0f);
                round2 = Math.round((abs + f4) * 255.0f);
                round3 = Math.round(f4 * 255.0f);
                break;
            case 2:
                round = Math.round(f4 * 255.0f);
                round2 = Math.round((abs + f4) * 255.0f);
                round3 = Math.round((abs2 + f4) * 255.0f);
                break;
            case 3:
                round = Math.round(f4 * 255.0f);
                round2 = Math.round((abs2 + f4) * 255.0f);
                round3 = Math.round((abs + f4) * 255.0f);
                break;
            case 4:
                round = Math.round((abs2 + f4) * 255.0f);
                round2 = Math.round(f4 * 255.0f);
                round3 = Math.round((abs + f4) * 255.0f);
                break;
            case 5:
            case 6:
                round = Math.round((abs + f4) * 255.0f);
                round2 = Math.round(f4 * 255.0f);
                round3 = Math.round((abs2 + f4) * 255.0f);
                break;
            default:
                round3 = 0;
                round = 0;
                round2 = 0;
                break;
        }
        return Color.rgb(m19771w(round, 0, 255), m19771w(round2, 0, 255), m19771w(round3, 0, 255));
    }

    @ColorInt
    /* renamed from: b */
    public static int m19792b(@FloatRange(from = 0.0d, m60036to = 100.0d) double d, @FloatRange(from = -128.0d, m60036to = 127.0d) double d2, @FloatRange(from = -128.0d, m60036to = 127.0d) double d3) {
        double[] m19769y = m19769y();
        m19791c(d, d2, d3, m19769y);
        return m19787g(m19769y[0], m19769y[1], m19769y[2]);
    }

    /* renamed from: c */
    public static void m19791c(@FloatRange(from = 0.0d, m60036to = 100.0d) double d, @FloatRange(from = -128.0d, m60036to = 127.0d) double d2, @FloatRange(from = -128.0d, m60036to = 127.0d) double d3, @NonNull double[] dArr) {
        double d4 = (d + 16.0d) / 116.0d;
        double d5 = (d2 / 500.0d) + d4;
        double d6 = d4 - (d3 / 200.0d);
        double pow = Math.pow(d5, 3.0d);
        if (pow <= f33738d) {
            pow = ((d5 * 116.0d) - 16.0d) / f33739e;
        }
        double pow2 = d > 7.9996247999999985d ? Math.pow(d4, 3.0d) : d / f33739e;
        double pow3 = Math.pow(d6, 3.0d);
        if (pow3 <= f33738d) {
            pow3 = ((d6 * 116.0d) - 16.0d) / f33739e;
        }
        dArr[0] = pow * f33735a;
        dArr[1] = pow2 * f33736b;
        dArr[2] = pow3 * f33737c;
    }

    /* renamed from: d */
    public static void m19790d(@IntRange(from = 0, m60035to = 255) int i, @IntRange(from = 0, m60035to = 255) int i2, @IntRange(from = 0, m60035to = 255) int i3, @NonNull float[] fArr) {
        float f;
        float abs;
        float f2 = i / 255.0f;
        float f3 = i2 / 255.0f;
        float f4 = i3 / 255.0f;
        float max = Math.max(f2, Math.max(f3, f4));
        float min = Math.min(f2, Math.min(f3, f4));
        float f5 = max - min;
        float f6 = (max + min) / 2.0f;
        if (max == min) {
            f = 0.0f;
            abs = 0.0f;
        } else {
            f = max == f2 ? ((f3 - f4) / f5) % 6.0f : max == f3 ? ((f4 - f2) / f5) + 2.0f : 4.0f + ((f2 - f3) / f5);
            abs = f5 / (1.0f - Math.abs((2.0f * f6) - 1.0f));
        }
        float f7 = (f * 60.0f) % 360.0f;
        if (f7 < 0.0f) {
            f7 += 360.0f;
        }
        fArr[0] = m19772v(f7, 0.0f, 360.0f);
        fArr[1] = m19772v(abs, 0.0f, 1.0f);
        fArr[2] = m19772v(f6, 0.0f, 1.0f);
    }

    /* renamed from: e */
    public static void m19789e(@IntRange(from = 0, m60035to = 255) int i, @IntRange(from = 0, m60035to = 255) int i2, @IntRange(from = 0, m60035to = 255) int i3, @NonNull double[] dArr) {
        m19788f(i, i2, i3, dArr);
        m19786h(dArr[0], dArr[1], dArr[2], dArr);
    }

    /* renamed from: f */
    public static void m19788f(@IntRange(from = 0, m60035to = 255) int i, @IntRange(from = 0, m60035to = 255) int i2, @IntRange(from = 0, m60035to = 255) int i3, @NonNull double[] dArr) {
        if (dArr.length == 3) {
            double d = i;
            Double.isNaN(d);
            double d2 = d / 255.0d;
            double pow = d2 < 0.04045d ? d2 / 12.92d : Math.pow((d2 + 0.055d) / 1.055d, 2.4d);
            double d3 = i2;
            Double.isNaN(d3);
            double d4 = d3 / 255.0d;
            double pow2 = d4 < 0.04045d ? d4 / 12.92d : Math.pow((d4 + 0.055d) / 1.055d, 2.4d);
            double d5 = i3;
            Double.isNaN(d5);
            double d6 = d5 / 255.0d;
            double pow3 = d6 < 0.04045d ? d6 / 12.92d : Math.pow((d6 + 0.055d) / 1.055d, 2.4d);
            dArr[0] = ((0.4124d * pow) + (0.3576d * pow2) + (0.1805d * pow3)) * f33736b;
            dArr[1] = ((0.2126d * pow) + (0.7152d * pow2) + (0.0722d * pow3)) * f33736b;
            dArr[2] = ((pow * 0.0193d) + (pow2 * 0.1192d) + (pow3 * 0.9505d)) * f33736b;
            return;
        }
        throw new IllegalArgumentException("outXyz must have a length of 3.");
    }

    @ColorInt
    /* renamed from: g */
    public static int m19787g(@FloatRange(from = 0.0d, m60036to = 95.047d) double d, @FloatRange(from = 0.0d, m60036to = 100.0d) double d2, @FloatRange(from = 0.0d, m60036to = 108.883d) double d3) {
        double d4 = (((3.2406d * d) + ((-1.5372d) * d2)) + ((-0.4986d) * d3)) / f33736b;
        double d5 = ((((-0.9689d) * d) + (1.8758d * d2)) + (0.0415d * d3)) / f33736b;
        double d6 = (((0.0557d * d) + ((-0.204d) * d2)) + (1.057d * d3)) / f33736b;
        return Color.rgb(m19771w((int) Math.round((d4 > 0.0031308d ? (Math.pow(d4, 0.4166666666666667d) * 1.055d) - 0.055d : d4 * 12.92d) * 255.0d), 0, 255), m19771w((int) Math.round((d5 > 0.0031308d ? (Math.pow(d5, 0.4166666666666667d) * 1.055d) - 0.055d : d5 * 12.92d) * 255.0d), 0, 255), m19771w((int) Math.round((d6 > 0.0031308d ? (Math.pow(d6, 0.4166666666666667d) * 1.055d) - 0.055d : d6 * 12.92d) * 255.0d), 0, 255));
    }

    /* renamed from: h */
    public static void m19786h(@FloatRange(from = 0.0d, m60036to = 95.047d) double d, @FloatRange(from = 0.0d, m60036to = 100.0d) double d2, @FloatRange(from = 0.0d, m60036to = 108.883d) double d3, @NonNull double[] dArr) {
        if (dArr.length == 3) {
            double m19768z = m19768z(d / f33735a);
            double m19768z2 = m19768z(d2 / f33736b);
            double m19768z3 = m19768z(d3 / f33737c);
            dArr[0] = Math.max((double) Utils.DOUBLE_EPSILON, (116.0d * m19768z2) - 16.0d);
            dArr[1] = (m19768z - m19768z2) * 500.0d;
            dArr[2] = (m19768z2 - m19768z3) * 200.0d;
            return;
        }
        throw new IllegalArgumentException("outLab must have a length of 3.");
    }

    @ColorInt
    /* renamed from: i */
    public static int m19785i(@ColorInt int i, @ColorInt int i2, @FloatRange(from = 0.0d, m60036to = 1.0d) float f) {
        float f2 = 1.0f - f;
        return Color.argb((int) ((Color.alpha(i) * f2) + (Color.alpha(i2) * f)), (int) ((Color.red(i) * f2) + (Color.red(i2) * f)), (int) ((Color.green(i) * f2) + (Color.green(i2) * f)), (int) ((Color.blue(i) * f2) + (Color.blue(i2) * f)));
    }

    /* renamed from: j */
    public static void m19784j(@NonNull float[] fArr, @NonNull float[] fArr2, @FloatRange(from = 0.0d, m60036to = 1.0d) float f, @NonNull float[] fArr3) {
        if (fArr3.length == 3) {
            float f2 = 1.0f - f;
            fArr3[0] = m19779o(fArr[0], fArr2[0], f);
            fArr3[1] = (fArr[1] * f2) + (fArr2[1] * f);
            fArr3[2] = (fArr[2] * f2) + (fArr2[2] * f);
            return;
        }
        throw new IllegalArgumentException("result must have a length of 3.");
    }

    /* renamed from: k */
    public static void m19783k(@NonNull double[] dArr, @NonNull double[] dArr2, @FloatRange(from = 0.0d, m60036to = 1.0d) double d, @NonNull double[] dArr3) {
        if (dArr3.length == 3) {
            double d2 = 1.0d - d;
            dArr3[0] = (dArr[0] * d2) + (dArr2[0] * d);
            dArr3[1] = (dArr[1] * d2) + (dArr2[1] * d);
            dArr3[2] = (dArr[2] * d2) + (dArr2[2] * d);
            return;
        }
        throw new IllegalArgumentException("outResult must have a length of 3.");
    }

    /* renamed from: l */
    public static double m19782l(@ColorInt int i, @ColorInt int i2) {
        if (Color.alpha(i2) == 255) {
            if (Color.alpha(i) < 255) {
                i = m19774t(i, i2);
            }
            double m19781m = m19781m(i) + 0.05d;
            double m19781m2 = m19781m(i2) + 0.05d;
            return Math.max(m19781m, m19781m2) / Math.min(m19781m, m19781m2);
        }
        throw new IllegalArgumentException("background can not be translucent: #" + Integer.toHexString(i2));
    }

    @FloatRange(from = Utils.DOUBLE_EPSILON, m60036to = WeightedLatLng.DEFAULT_INTENSITY)
    /* renamed from: m */
    public static double m19781m(@ColorInt int i) {
        double[] m19769y = m19769y();
        m19776r(i, m19769y);
        return m19769y[1] / f33736b;
    }

    /* renamed from: n */
    public static int m19780n(@ColorInt int i, @ColorInt int i2, float f) {
        int i3 = 255;
        if (Color.alpha(i2) == 255) {
            double d = f;
            if (m19782l(m19794A(i, 255), i2) < d) {
                return -1;
            }
            int i4 = 0;
            for (int i5 = 0; i5 <= 10 && i3 - i4 > 1; i5++) {
                int i6 = (i4 + i3) / 2;
                if (m19782l(m19794A(i, i6), i2) < d) {
                    i4 = i6;
                } else {
                    i3 = i6;
                }
            }
            return i3;
        }
        throw new IllegalArgumentException("background can not be translucent: #" + Integer.toHexString(i2));
    }

    @VisibleForTesting
    /* renamed from: o */
    static float m19779o(float f, float f2, float f3) {
        if (Math.abs(f2 - f) > 180.0f) {
            if (f2 > f) {
                f += 360.0f;
            } else {
                f2 += 360.0f;
            }
        }
        return (f + ((f2 - f) * f3)) % 360.0f;
    }

    /* renamed from: p */
    public static void m19778p(@ColorInt int i, @NonNull float[] fArr) {
        m19790d(Color.red(i), Color.green(i), Color.blue(i), fArr);
    }

    /* renamed from: q */
    public static void m19777q(@ColorInt int i, @NonNull double[] dArr) {
        m19789e(Color.red(i), Color.green(i), Color.blue(i), dArr);
    }

    /* renamed from: r */
    public static void m19776r(@ColorInt int i, @NonNull double[] dArr) {
        m19788f(Color.red(i), Color.green(i), Color.blue(i), dArr);
    }

    /* renamed from: s */
    private static int m19775s(int i, int i2) {
        return 255 - (((255 - i2) * (255 - i)) / 255);
    }

    /* renamed from: t */
    public static int m19774t(@ColorInt int i, @ColorInt int i2) {
        int alpha = Color.alpha(i2);
        int alpha2 = Color.alpha(i);
        int m19775s = m19775s(alpha2, alpha);
        return Color.argb(m19775s, m19773u(Color.red(i), alpha2, Color.red(i2), alpha, m19775s), m19773u(Color.green(i), alpha2, Color.green(i2), alpha, m19775s), m19773u(Color.blue(i), alpha2, Color.blue(i2), alpha, m19775s));
    }

    /* renamed from: u */
    private static int m19773u(int i, int i2, int i3, int i4, int i5) {
        if (i5 == 0) {
            return 0;
        }
        return (((i * 255) * i2) + ((i3 * i4) * (255 - i2))) / (i5 * 255);
    }

    /* renamed from: v */
    private static float m19772v(float f, float f2, float f3) {
        return f < f2 ? f2 : f > f3 ? f3 : f;
    }

    /* renamed from: w */
    private static int m19771w(int i, int i2, int i3) {
        return i < i2 ? i2 : i > i3 ? i3 : i;
    }

    /* renamed from: x */
    public static double m19770x(@NonNull double[] dArr, @NonNull double[] dArr2) {
        return Math.sqrt(Math.pow(dArr[0] - dArr2[0], 2.0d) + Math.pow(dArr[1] - dArr2[1], 2.0d) + Math.pow(dArr[2] - dArr2[2], 2.0d));
    }

    /* renamed from: y */
    private static double[] m19769y() {
        ThreadLocal<double[]> threadLocal = f33742h;
        double[] dArr = threadLocal.get();
        if (dArr == null) {
            double[] dArr2 = new double[3];
            threadLocal.set(dArr2);
            return dArr2;
        }
        return dArr;
    }

    /* renamed from: z */
    private static double m19768z(double d) {
        return d > f33738d ? Math.pow(d, 0.3333333333333333d) : ((d * f33739e) + 16.0d) / 116.0d;
    }
}
