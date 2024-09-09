package androidx.constraintlayout.motion.utils;

import android.util.Log;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class Easing {
    private static final String ACCELERATE = "cubic(0.4, 0.05, 0.8, 0.7)";
    private static final String ACCELERATE_NAME = "accelerate";
    private static final String DECELERATE = "cubic(0.0, 0.0, 0.2, 0.95)";
    private static final String DECELERATE_NAME = "decelerate";
    private static final String LINEAR = "cubic(1, 1, 0, 0)";
    private static final String LINEAR_NAME = "linear";
    private static final String STANDARD = "cubic(0.4, 0.0, 0.2, 1)";
    private static final String STANDARD_NAME = "standard";
    String str = "identity";
    static Easing sDefault = new Easing();
    public static String[] NAMED_EASING = {"standard", "accelerate", "decelerate", "linear"};

    public static Easing getInterpolator(String str) {
        if (str == null) {
            return null;
        }
        if (str.startsWith("cubic")) {
            return new CubicEasing(str);
        }
        char c4 = '\uffff';
        switch (str.hashCode()) {
            case -1354466595:
                if (str.equals("accelerate")) {
                    c4 = 0;
                    break;
                }
                break;
            case -1263948740:
                if (str.equals("decelerate")) {
                    c4 = 1;
                    break;
                }
                break;
            case -1102672091:
                if (str.equals("linear")) {
                    c4 = 2;
                    break;
                }
                break;
            case 1312628413:
                if (str.equals("standard")) {
                    c4 = 3;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                return new CubicEasing("cubic(0.4, 0.05, 0.8, 0.7)");
            case 1:
                return new CubicEasing("cubic(0.0, 0.0, 0.2, 0.95)");
            case 2:
                return new CubicEasing("cubic(1, 1, 0, 0)");
            case 3:
                return new CubicEasing("cubic(0.4, 0.0, 0.2, 1)");
            default:
                Log.e("ConstraintSet", "transitionEasing syntax error syntax:transitionEasing=\"cubic(1.0,0.5,0.0,0.6)\" or " + Arrays.toString(NAMED_EASING));
                return sDefault;
        }
    }

    public double get(double d4) {
        return d4;
    }

    public double getDiff(double d4) {
        return 1.0d;
    }

    public String toString() {
        return this.str;
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    static class CubicEasing extends Easing {
        private static double d_error = 1.0E-4d;
        private static double error = 0.01d;

        /* renamed from: x1  reason: collision with root package name */
        double f135x1;

        /* renamed from: x2  reason: collision with root package name */
        double f136x2;

        /* renamed from: y1  reason: collision with root package name */
        double f137y1;

        /* renamed from: y2  reason: collision with root package name */
        double f138y2;

        CubicEasing(String str) {
            this.str = str;
            int indexOf = str.indexOf(40);
            int indexOf2 = str.indexOf(44, indexOf);
            this.f135x1 = Double.parseDouble(str.substring(indexOf + 1, indexOf2).trim());
            int i4 = indexOf2 + 1;
            int indexOf3 = str.indexOf(44, i4);
            this.f137y1 = Double.parseDouble(str.substring(i4, indexOf3).trim());
            int i5 = indexOf3 + 1;
            int indexOf4 = str.indexOf(44, i5);
            this.f136x2 = Double.parseDouble(str.substring(i5, indexOf4).trim());
            int i6 = indexOf4 + 1;
            this.f138y2 = Double.parseDouble(str.substring(i6, str.indexOf(41, i6)).trim());
        }

        private double getDiffX(double d4) {
            double d5 = 1.0d - d4;
            double d6 = this.f135x1;
            double d7 = this.f136x2;
            return (d5 * 3.0d * d5 * d6) + (d5 * 6.0d * d4 * (d7 - d6)) + (3.0d * d4 * d4 * (1.0d - d7));
        }

        private double getDiffY(double d4) {
            double d5 = 1.0d - d4;
            double d6 = this.f137y1;
            double d7 = this.f138y2;
            return (d5 * 3.0d * d5 * d6) + (d5 * 6.0d * d4 * (d7 - d6)) + (3.0d * d4 * d4 * (1.0d - d7));
        }

        private double getX(double d4) {
            double d5 = 1.0d - d4;
            double d6 = 3.0d * d5;
            return (this.f135x1 * d5 * d6 * d4) + (this.f136x2 * d6 * d4 * d4) + (d4 * d4 * d4);
        }

        private double getY(double d4) {
            double d5 = 1.0d - d4;
            double d6 = 3.0d * d5;
            return (this.f137y1 * d5 * d6 * d4) + (this.f138y2 * d6 * d4 * d4) + (d4 * d4 * d4);
        }

        @Override // androidx.constraintlayout.motion.utils.Easing
        public double get(double d4) {
            if (d4 <= 0.0d) {
                return 0.0d;
            }
            if (d4 >= 1.0d) {
                return 1.0d;
            }
            double d5 = 0.5d;
            double d6 = 0.5d;
            while (d5 > error) {
                d5 *= 0.5d;
                d6 = getX(d6) < d4 ? d6 + d5 : d6 - d5;
            }
            double d7 = d6 - d5;
            double x3 = getX(d7);
            double d8 = d6 + d5;
            double x4 = getX(d8);
            double y3 = getY(d7);
            return (((getY(d8) - y3) * (d4 - x3)) / (x4 - x3)) + y3;
        }

        @Override // androidx.constraintlayout.motion.utils.Easing
        public double getDiff(double d4) {
            double d5 = 0.5d;
            double d6 = 0.5d;
            while (d5 > d_error) {
                d5 *= 0.5d;
                d6 = getX(d6) < d4 ? d6 + d5 : d6 - d5;
            }
            double d7 = d6 - d5;
            double d8 = d6 + d5;
            return (getY(d8) - getY(d7)) / (getX(d8) - getX(d7));
        }

        void setup(double d4, double d5, double d6, double d7) {
            this.f135x1 = d4;
            this.f137y1 = d5;
            this.f136x2 = d6;
            this.f138y2 = d7;
        }

        public CubicEasing(double d4, double d5, double d6, double d7) {
            setup(d4, d5, d6, d7);
        }
    }
}
