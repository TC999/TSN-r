package androidx.constraintlayout.motion.utils;

import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class Oscillator {
    public static final int BOUNCE = 6;
    public static final int COS_WAVE = 5;
    public static final int REVERSE_SAW_WAVE = 4;
    public static final int SAW_WAVE = 3;
    public static final int SIN_WAVE = 0;
    public static final int SQUARE_WAVE = 1;
    public static String TAG = "Oscillator";
    public static final int TRIANGLE_WAVE = 2;
    double[] mArea;
    int mType;
    float[] mPeriod = new float[0];
    double[] mPosition = new double[0];
    double PI2 = 6.283185307179586d;
    private boolean mNormalized = false;

    public void addPoint(double d4, float f4) {
        int length = this.mPeriod.length + 1;
        int binarySearch = Arrays.binarySearch(this.mPosition, d4);
        if (binarySearch < 0) {
            binarySearch = (-binarySearch) - 1;
        }
        this.mPosition = Arrays.copyOf(this.mPosition, length);
        this.mPeriod = Arrays.copyOf(this.mPeriod, length);
        this.mArea = new double[length];
        double[] dArr = this.mPosition;
        System.arraycopy(dArr, binarySearch, dArr, binarySearch + 1, (length - binarySearch) - 1);
        this.mPosition[binarySearch] = d4;
        this.mPeriod[binarySearch] = f4;
        this.mNormalized = false;
    }

    double getDP(double d4) {
        if (d4 <= 0.0d) {
            d4 = 1.0E-5d;
        } else if (d4 >= 1.0d) {
            d4 = 0.999999d;
        }
        int binarySearch = Arrays.binarySearch(this.mPosition, d4);
        if (binarySearch <= 0 && binarySearch != 0) {
            int i4 = (-binarySearch) - 1;
            float[] fArr = this.mPeriod;
            int i5 = i4 - 1;
            double d5 = fArr[i4] - fArr[i5];
            double[] dArr = this.mPosition;
            Double.isNaN(d5);
            double d6 = d5 / (dArr[i4] - dArr[i5]);
            double d7 = d4 * d6;
            double d8 = fArr[i5];
            Double.isNaN(d8);
            return (d8 - (d6 * dArr[i5])) + d7;
        }
        return 0.0d;
    }

    double getP(double d4) {
        if (d4 < 0.0d) {
            d4 = 0.0d;
        } else if (d4 > 1.0d) {
            d4 = 1.0d;
        }
        int binarySearch = Arrays.binarySearch(this.mPosition, d4);
        if (binarySearch > 0) {
            return 1.0d;
        }
        if (binarySearch != 0) {
            int i4 = (-binarySearch) - 1;
            float[] fArr = this.mPeriod;
            int i5 = i4 - 1;
            double d5 = fArr[i4] - fArr[i5];
            double[] dArr = this.mPosition;
            Double.isNaN(d5);
            double d6 = d5 / (dArr[i4] - dArr[i5]);
            double d7 = this.mArea[i5];
            double d8 = fArr[i5];
            Double.isNaN(d8);
            return d7 + ((d8 - (dArr[i5] * d6)) * (d4 - dArr[i5])) + ((d6 * ((d4 * d4) - (dArr[i5] * dArr[i5]))) / 2.0d);
        }
        return 0.0d;
    }

    public double getSlope(double d4) {
        double dp;
        double signum;
        double dp2;
        double dp3;
        double sin;
        switch (this.mType) {
            case 1:
                return 0.0d;
            case 2:
                dp = getDP(d4) * 4.0d;
                signum = Math.signum((((getP(d4) * 4.0d) + 3.0d) % 4.0d) - 2.0d);
                return dp * signum;
            case 3:
                dp2 = getDP(d4);
                return dp2 * 2.0d;
            case 4:
                dp2 = -getDP(d4);
                return dp2 * 2.0d;
            case 5:
                dp3 = (-this.PI2) * getDP(d4);
                sin = Math.sin(this.PI2 * getP(d4));
                return dp3 * sin;
            case 6:
                dp = getDP(d4) * 4.0d;
                signum = (((getP(d4) * 4.0d) + 2.0d) % 4.0d) - 2.0d;
                return dp * signum;
            default:
                dp3 = this.PI2 * getDP(d4);
                sin = Math.cos(this.PI2 * getP(d4));
                return dp3 * sin;
        }
    }

    public double getValue(double d4) {
        double abs;
        switch (this.mType) {
            case 1:
                return Math.signum(0.5d - (getP(d4) % 1.0d));
            case 2:
                abs = Math.abs((((getP(d4) * 4.0d) + 1.0d) % 4.0d) - 2.0d);
                break;
            case 3:
                return (((getP(d4) * 2.0d) + 1.0d) % 2.0d) - 1.0d;
            case 4:
                abs = ((getP(d4) * 2.0d) + 1.0d) % 2.0d;
                break;
            case 5:
                return Math.cos(this.PI2 * getP(d4));
            case 6:
                double abs2 = 1.0d - Math.abs(((getP(d4) * 4.0d) % 4.0d) - 2.0d);
                abs = abs2 * abs2;
                break;
            default:
                return Math.sin(this.PI2 * getP(d4));
        }
        return 1.0d - abs;
    }

    public void normalize() {
        double d4 = 0.0d;
        int i4 = 0;
        while (true) {
            float[] fArr = this.mPeriod;
            if (i4 >= fArr.length) {
                break;
            }
            double d5 = fArr[i4];
            Double.isNaN(d5);
            d4 += d5;
            i4++;
        }
        double d6 = 0.0d;
        int i5 = 1;
        while (true) {
            float[] fArr2 = this.mPeriod;
            if (i5 >= fArr2.length) {
                break;
            }
            int i6 = i5 - 1;
            double[] dArr = this.mPosition;
            double d7 = (fArr2[i6] + fArr2[i5]) / 2.0f;
            Double.isNaN(d7);
            d6 += (dArr[i5] - dArr[i6]) * d7;
            i5++;
        }
        int i7 = 0;
        while (true) {
            float[] fArr3 = this.mPeriod;
            if (i7 >= fArr3.length) {
                break;
            }
            double d8 = fArr3[i7];
            Double.isNaN(d8);
            fArr3[i7] = (float) (d8 * (d4 / d6));
            i7++;
        }
        this.mArea[0] = 0.0d;
        int i8 = 1;
        while (true) {
            float[] fArr4 = this.mPeriod;
            if (i8 < fArr4.length) {
                int i9 = i8 - 1;
                double[] dArr2 = this.mPosition;
                double d9 = dArr2[i8] - dArr2[i9];
                double[] dArr3 = this.mArea;
                double d10 = dArr3[i9];
                double d11 = (fArr4[i9] + fArr4[i8]) / 2.0f;
                Double.isNaN(d11);
                dArr3[i8] = d10 + (d9 * d11);
                i8++;
            } else {
                this.mNormalized = true;
                return;
            }
        }
    }

    public void setType(int i4) {
        this.mType = i4;
    }

    public String toString() {
        return "pos =" + Arrays.toString(this.mPosition) + " period=" + Arrays.toString(this.mPeriod);
    }
}
