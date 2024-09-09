package androidx.core.graphics;

import android.graphics.Color;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public final class ColorUtils {
    private static final int MIN_ALPHA_SEARCH_MAX_ITERATIONS = 10;
    private static final int MIN_ALPHA_SEARCH_PRECISION = 1;
    private static final ThreadLocal<double[]> TEMP_ARRAY = new ThreadLocal<>();
    private static final double XYZ_EPSILON = 0.008856d;
    private static final double XYZ_KAPPA = 903.3d;
    private static final double XYZ_WHITE_REFERENCE_X = 95.047d;
    private static final double XYZ_WHITE_REFERENCE_Y = 100.0d;
    private static final double XYZ_WHITE_REFERENCE_Z = 108.883d;

    private ColorUtils() {
    }

    @ColorInt
    public static int HSLToColor(@NonNull float[] fArr) {
        int round;
        int round2;
        int round3;
        float f4 = fArr[0];
        float f5 = fArr[1];
        float f6 = fArr[2];
        float abs = (1.0f - Math.abs((f6 * 2.0f) - 1.0f)) * f5;
        float f7 = f6 - (0.5f * abs);
        float abs2 = (1.0f - Math.abs(((f4 / 60.0f) % 2.0f) - 1.0f)) * abs;
        switch (((int) f4) / 60) {
            case 0:
                round = Math.round((abs + f7) * 255.0f);
                round2 = Math.round((abs2 + f7) * 255.0f);
                round3 = Math.round(f7 * 255.0f);
                break;
            case 1:
                round = Math.round((abs2 + f7) * 255.0f);
                round2 = Math.round((abs + f7) * 255.0f);
                round3 = Math.round(f7 * 255.0f);
                break;
            case 2:
                round = Math.round(f7 * 255.0f);
                round2 = Math.round((abs + f7) * 255.0f);
                round3 = Math.round((abs2 + f7) * 255.0f);
                break;
            case 3:
                round = Math.round(f7 * 255.0f);
                round2 = Math.round((abs2 + f7) * 255.0f);
                round3 = Math.round((abs + f7) * 255.0f);
                break;
            case 4:
                round = Math.round((abs2 + f7) * 255.0f);
                round2 = Math.round(f7 * 255.0f);
                round3 = Math.round((abs + f7) * 255.0f);
                break;
            case 5:
            case 6:
                round = Math.round((abs + f7) * 255.0f);
                round2 = Math.round(f7 * 255.0f);
                round3 = Math.round((abs2 + f7) * 255.0f);
                break;
            default:
                round3 = 0;
                round = 0;
                round2 = 0;
                break;
        }
        return Color.rgb(constrain(round, 0, 255), constrain(round2, 0, 255), constrain(round3, 0, 255));
    }

    @ColorInt
    public static int LABToColor(@FloatRange(from = 0.0d, to = 100.0d) double d4, @FloatRange(from = -128.0d, to = 127.0d) double d5, @FloatRange(from = -128.0d, to = 127.0d) double d6) {
        double[] tempDouble3Array = getTempDouble3Array();
        LABToXYZ(d4, d5, d6, tempDouble3Array);
        return XYZToColor(tempDouble3Array[0], tempDouble3Array[1], tempDouble3Array[2]);
    }

    public static void LABToXYZ(@FloatRange(from = 0.0d, to = 100.0d) double d4, @FloatRange(from = -128.0d, to = 127.0d) double d5, @FloatRange(from = -128.0d, to = 127.0d) double d6, @NonNull double[] dArr) {
        double d7 = (d4 + 16.0d) / 116.0d;
        double d8 = (d5 / 500.0d) + d7;
        double d9 = d7 - (d6 / 200.0d);
        double pow = Math.pow(d8, 3.0d);
        if (pow <= 0.008856d) {
            pow = ((d8 * 116.0d) - 16.0d) / 903.3d;
        }
        double pow2 = d4 > 7.9996247999999985d ? Math.pow(d7, 3.0d) : d4 / 903.3d;
        double pow3 = Math.pow(d9, 3.0d);
        if (pow3 <= 0.008856d) {
            pow3 = ((d9 * 116.0d) - 16.0d) / 903.3d;
        }
        dArr[0] = pow * 95.047d;
        dArr[1] = pow2 * 100.0d;
        dArr[2] = pow3 * 108.883d;
    }

    public static void RGBToHSL(@IntRange(from = 0, to = 255) int i4, @IntRange(from = 0, to = 255) int i5, @IntRange(from = 0, to = 255) int i6, @NonNull float[] fArr) {
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
        fArr[0] = constrain(f10, 0.0f, 360.0f);
        fArr[1] = constrain(abs, 0.0f, 1.0f);
        fArr[2] = constrain(f9, 0.0f, 1.0f);
    }

    public static void RGBToLAB(@IntRange(from = 0, to = 255) int i4, @IntRange(from = 0, to = 255) int i5, @IntRange(from = 0, to = 255) int i6, @NonNull double[] dArr) {
        RGBToXYZ(i4, i5, i6, dArr);
        XYZToLAB(dArr[0], dArr[1], dArr[2], dArr);
    }

    public static void RGBToXYZ(@IntRange(from = 0, to = 255) int i4, @IntRange(from = 0, to = 255) int i5, @IntRange(from = 0, to = 255) int i6, @NonNull double[] dArr) {
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

    @ColorInt
    public static int XYZToColor(@FloatRange(from = 0.0d, to = 95.047d) double d4, @FloatRange(from = 0.0d, to = 100.0d) double d5, @FloatRange(from = 0.0d, to = 108.883d) double d6) {
        double d7 = (((3.2406d * d4) + ((-1.5372d) * d5)) + ((-0.4986d) * d6)) / 100.0d;
        double d8 = ((((-0.9689d) * d4) + (1.8758d * d5)) + (0.0415d * d6)) / 100.0d;
        double d9 = (((0.0557d * d4) + ((-0.204d) * d5)) + (1.057d * d6)) / 100.0d;
        return Color.rgb(constrain((int) Math.round((d7 > 0.0031308d ? (Math.pow(d7, 0.4166666666666667d) * 1.055d) - 0.055d : d7 * 12.92d) * 255.0d), 0, 255), constrain((int) Math.round((d8 > 0.0031308d ? (Math.pow(d8, 0.4166666666666667d) * 1.055d) - 0.055d : d8 * 12.92d) * 255.0d), 0, 255), constrain((int) Math.round((d9 > 0.0031308d ? (Math.pow(d9, 0.4166666666666667d) * 1.055d) - 0.055d : d9 * 12.92d) * 255.0d), 0, 255));
    }

    public static void XYZToLAB(@FloatRange(from = 0.0d, to = 95.047d) double d4, @FloatRange(from = 0.0d, to = 100.0d) double d5, @FloatRange(from = 0.0d, to = 108.883d) double d6, @NonNull double[] dArr) {
        if (dArr.length == 3) {
            double pivotXyzComponent = pivotXyzComponent(d4 / 95.047d);
            double pivotXyzComponent2 = pivotXyzComponent(d5 / 100.0d);
            double pivotXyzComponent3 = pivotXyzComponent(d6 / 108.883d);
            dArr[0] = Math.max(0.0d, (116.0d * pivotXyzComponent2) - 16.0d);
            dArr[1] = (pivotXyzComponent - pivotXyzComponent2) * 500.0d;
            dArr[2] = (pivotXyzComponent2 - pivotXyzComponent3) * 200.0d;
            return;
        }
        throw new IllegalArgumentException("outLab must have a length of 3.");
    }

    @ColorInt
    public static int blendARGB(@ColorInt int i4, @ColorInt int i5, @FloatRange(from = 0.0d, to = 1.0d) float f4) {
        float f5 = 1.0f - f4;
        return Color.argb((int) ((Color.alpha(i4) * f5) + (Color.alpha(i5) * f4)), (int) ((Color.red(i4) * f5) + (Color.red(i5) * f4)), (int) ((Color.green(i4) * f5) + (Color.green(i5) * f4)), (int) ((Color.blue(i4) * f5) + (Color.blue(i5) * f4)));
    }

    public static void blendHSL(@NonNull float[] fArr, @NonNull float[] fArr2, @FloatRange(from = 0.0d, to = 1.0d) float f4, @NonNull float[] fArr3) {
        if (fArr3.length == 3) {
            float f5 = 1.0f - f4;
            fArr3[0] = circularInterpolate(fArr[0], fArr2[0], f4);
            fArr3[1] = (fArr[1] * f5) + (fArr2[1] * f4);
            fArr3[2] = (fArr[2] * f5) + (fArr2[2] * f4);
            return;
        }
        throw new IllegalArgumentException("result must have a length of 3.");
    }

    public static void blendLAB(@NonNull double[] dArr, @NonNull double[] dArr2, @FloatRange(from = 0.0d, to = 1.0d) double d4, @NonNull double[] dArr3) {
        if (dArr3.length == 3) {
            double d5 = 1.0d - d4;
            dArr3[0] = (dArr[0] * d5) + (dArr2[0] * d4);
            dArr3[1] = (dArr[1] * d5) + (dArr2[1] * d4);
            dArr3[2] = (dArr[2] * d5) + (dArr2[2] * d4);
            return;
        }
        throw new IllegalArgumentException("outResult must have a length of 3.");
    }

    public static double calculateContrast(@ColorInt int i4, @ColorInt int i5) {
        if (Color.alpha(i5) == 255) {
            if (Color.alpha(i4) < 255) {
                i4 = compositeColors(i4, i5);
            }
            double calculateLuminance = calculateLuminance(i4) + 0.05d;
            double calculateLuminance2 = calculateLuminance(i5) + 0.05d;
            return Math.max(calculateLuminance, calculateLuminance2) / Math.min(calculateLuminance, calculateLuminance2);
        }
        throw new IllegalArgumentException("background can not be translucent: #" + Integer.toHexString(i5));
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public static double calculateLuminance(@ColorInt int i4) {
        double[] tempDouble3Array = getTempDouble3Array();
        colorToXYZ(i4, tempDouble3Array);
        return tempDouble3Array[1] / 100.0d;
    }

    public static int calculateMinimumAlpha(@ColorInt int i4, @ColorInt int i5, float f4) {
        int i6 = 255;
        if (Color.alpha(i5) == 255) {
            double d4 = f4;
            if (calculateContrast(setAlphaComponent(i4, 255), i5) < d4) {
                return -1;
            }
            int i7 = 0;
            for (int i8 = 0; i8 <= 10 && i6 - i7 > 1; i8++) {
                int i9 = (i7 + i6) / 2;
                if (calculateContrast(setAlphaComponent(i4, i9), i5) < d4) {
                    i7 = i9;
                } else {
                    i6 = i9;
                }
            }
            return i6;
        }
        throw new IllegalArgumentException("background can not be translucent: #" + Integer.toHexString(i5));
    }

    @VisibleForTesting
    static float circularInterpolate(float f4, float f5, float f6) {
        if (Math.abs(f5 - f4) > 180.0f) {
            if (f5 > f4) {
                f4 += 360.0f;
            } else {
                f5 += 360.0f;
            }
        }
        return (f4 + ((f5 - f4) * f6)) % 360.0f;
    }

    public static void colorToHSL(@ColorInt int i4, @NonNull float[] fArr) {
        RGBToHSL(Color.red(i4), Color.green(i4), Color.blue(i4), fArr);
    }

    public static void colorToLAB(@ColorInt int i4, @NonNull double[] dArr) {
        RGBToLAB(Color.red(i4), Color.green(i4), Color.blue(i4), dArr);
    }

    public static void colorToXYZ(@ColorInt int i4, @NonNull double[] dArr) {
        RGBToXYZ(Color.red(i4), Color.green(i4), Color.blue(i4), dArr);
    }

    private static int compositeAlpha(int i4, int i5) {
        return 255 - (((255 - i5) * (255 - i4)) / 255);
    }

    public static int compositeColors(@ColorInt int i4, @ColorInt int i5) {
        int alpha = Color.alpha(i5);
        int alpha2 = Color.alpha(i4);
        int compositeAlpha = compositeAlpha(alpha2, alpha);
        return Color.argb(compositeAlpha, compositeComponent(Color.red(i4), alpha2, Color.red(i5), alpha, compositeAlpha), compositeComponent(Color.green(i4), alpha2, Color.green(i5), alpha, compositeAlpha), compositeComponent(Color.blue(i4), alpha2, Color.blue(i5), alpha, compositeAlpha));
    }

    private static int compositeComponent(int i4, int i5, int i6, int i7, int i8) {
        if (i8 == 0) {
            return 0;
        }
        return (((i4 * 255) * i5) + ((i6 * i7) * (255 - i5))) / (i8 * 255);
    }

    private static float constrain(float f4, float f5, float f6) {
        return f4 < f5 ? f5 : f4 > f6 ? f6 : f4;
    }

    private static int constrain(int i4, int i5, int i6) {
        return i4 < i5 ? i5 : i4 > i6 ? i6 : i4;
    }

    public static double distanceEuclidean(@NonNull double[] dArr, @NonNull double[] dArr2) {
        return Math.sqrt(Math.pow(dArr[0] - dArr2[0], 2.0d) + Math.pow(dArr[1] - dArr2[1], 2.0d) + Math.pow(dArr[2] - dArr2[2], 2.0d));
    }

    private static double[] getTempDouble3Array() {
        ThreadLocal<double[]> threadLocal = TEMP_ARRAY;
        double[] dArr = threadLocal.get();
        if (dArr == null) {
            double[] dArr2 = new double[3];
            threadLocal.set(dArr2);
            return dArr2;
        }
        return dArr;
    }

    private static double pivotXyzComponent(double d4) {
        return d4 > 0.008856d ? Math.pow(d4, 0.3333333333333333d) : ((d4 * 903.3d) + 16.0d) / 116.0d;
    }

    @ColorInt
    public static int setAlphaComponent(@ColorInt int i4, @IntRange(from = 0, to = 255) int i5) {
        if (i5 < 0 || i5 > 255) {
            throw new IllegalArgumentException("alpha must be between 0 and 255.");
        }
        return (i4 & 16777215) | (i5 << 24);
    }

    @NonNull
    @RequiresApi(26)
    public static Color compositeColors(@NonNull Color color, @NonNull Color color2) {
        if (a.a(color.getModel(), color2.getModel())) {
            if (!a.a(color2.getColorSpace(), color.getColorSpace())) {
                color = color.convert(color2.getColorSpace());
            }
            float[] components = color.getComponents();
            float[] components2 = color2.getComponents();
            float alpha = color.alpha();
            float alpha2 = color2.alpha() * (1.0f - alpha);
            int componentCount = color2.getComponentCount() - 1;
            components2[componentCount] = alpha + alpha2;
            if (components2[componentCount] > 0.0f) {
                alpha /= components2[componentCount];
                alpha2 /= components2[componentCount];
            }
            for (int i4 = 0; i4 < componentCount; i4++) {
                components2[i4] = (components[i4] * alpha) + (components2[i4] * alpha2);
            }
            return Color.valueOf(components2, color2.getColorSpace());
        }
        throw new IllegalArgumentException("Color models must match (" + color.getModel() + " vs. " + color2.getModel() + ")");
    }
}
