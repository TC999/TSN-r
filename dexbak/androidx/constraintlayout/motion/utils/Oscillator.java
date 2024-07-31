package androidx.constraintlayout.motion.utils;

import com.github.mikephil.charting.utils.Utils;
import java.util.Arrays;

/* loaded from: E:\fuckcool\tsn\6276784.dex */
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

    public void addPoint(double d, float f) {
        int length = this.mPeriod.length + 1;
        int binarySearch = Arrays.binarySearch(this.mPosition, d);
        if (binarySearch < 0) {
            binarySearch = (-binarySearch) - 1;
        }
        this.mPosition = Arrays.copyOf(this.mPosition, length);
        this.mPeriod = Arrays.copyOf(this.mPeriod, length);
        this.mArea = new double[length];
        double[] dArr = this.mPosition;
        System.arraycopy(dArr, binarySearch, dArr, binarySearch + 1, (length - binarySearch) - 1);
        this.mPosition[binarySearch] = d;
        this.mPeriod[binarySearch] = f;
        this.mNormalized = false;
    }

    double getDP(double d) {
        if (d <= Utils.DOUBLE_EPSILON) {
            d = 1.0E-5d;
        } else if (d >= 1.0d) {
            d = 0.999999d;
        }
        int binarySearch = Arrays.binarySearch(this.mPosition, d);
        if (binarySearch <= 0 && binarySearch != 0) {
            int i = (-binarySearch) - 1;
            float[] fArr = this.mPeriod;
            int i2 = i - 1;
            double d2 = fArr[i] - fArr[i2];
            double[] dArr = this.mPosition;
            Double.isNaN(d2);
            double d3 = d2 / (dArr[i] - dArr[i2]);
            double d4 = d * d3;
            double d5 = fArr[i2];
            Double.isNaN(d5);
            return (d5 - (d3 * dArr[i2])) + d4;
        }
        return Utils.DOUBLE_EPSILON;
    }

    double getP(double d) {
        if (d < Utils.DOUBLE_EPSILON) {
            d = 0.0d;
        } else if (d > 1.0d) {
            d = 1.0d;
        }
        int binarySearch = Arrays.binarySearch(this.mPosition, d);
        if (binarySearch > 0) {
            return 1.0d;
        }
        if (binarySearch != 0) {
            int i = (-binarySearch) - 1;
            float[] fArr = this.mPeriod;
            int i2 = i - 1;
            double d2 = fArr[i] - fArr[i2];
            double[] dArr = this.mPosition;
            Double.isNaN(d2);
            double d3 = d2 / (dArr[i] - dArr[i2]);
            double d4 = this.mArea[i2];
            double d5 = fArr[i2];
            Double.isNaN(d5);
            return d4 + ((d5 - (dArr[i2] * d3)) * (d - dArr[i2])) + ((d3 * ((d * d) - (dArr[i2] * dArr[i2]))) / 2.0d);
        }
        return Utils.DOUBLE_EPSILON;
    }

    public double getSlope(double d) {
        double dp;
        double signum;
        double dp2;
        double dp3;
        double sin;
        switch (this.mType) {
            case 1:
                return Utils.DOUBLE_EPSILON;
            case 2:
                dp = getDP(d) * 4.0d;
                signum = Math.signum((((getP(d) * 4.0d) + 3.0d) % 4.0d) - 2.0d);
                return dp * signum;
            case 3:
                dp2 = getDP(d);
                return dp2 * 2.0d;
            case 4:
                dp2 = -getDP(d);
                return dp2 * 2.0d;
            case 5:
                dp3 = (-this.PI2) * getDP(d);
                sin = Math.sin(this.PI2 * getP(d));
                return dp3 * sin;
            case 6:
                dp = getDP(d) * 4.0d;
                signum = (((getP(d) * 4.0d) + 2.0d) % 4.0d) - 2.0d;
                return dp * signum;
            default:
                dp3 = this.PI2 * getDP(d);
                sin = Math.cos(this.PI2 * getP(d));
                return dp3 * sin;
        }
    }

    public double getValue(double d) {
        double abs;
        switch (this.mType) {
            case 1:
                return Math.signum(0.5d - (getP(d) % 1.0d));
            case 2:
                abs = Math.abs((((getP(d) * 4.0d) + 1.0d) % 4.0d) - 2.0d);
                break;
            case 3:
                return (((getP(d) * 2.0d) + 1.0d) % 2.0d) - 1.0d;
            case 4:
                abs = ((getP(d) * 2.0d) + 1.0d) % 2.0d;
                break;
            case 5:
                return Math.cos(this.PI2 * getP(d));
            case 6:
                double abs2 = 1.0d - Math.abs(((getP(d) * 4.0d) % 4.0d) - 2.0d);
                abs = abs2 * abs2;
                break;
            default:
                return Math.sin(this.PI2 * getP(d));
        }
        return 1.0d - abs;
    }

    public void normalize() {
        double d = 0.0d;
        int i = 0;
        while (true) {
            float[] fArr = this.mPeriod;
            if (i >= fArr.length) {
                break;
            }
            double d2 = fArr[i];
            Double.isNaN(d2);
            d += d2;
            i++;
        }
        double d3 = 0.0d;
        int i2 = 1;
        while (true) {
            float[] fArr2 = this.mPeriod;
            if (i2 >= fArr2.length) {
                break;
            }
            int i3 = i2 - 1;
            double[] dArr = this.mPosition;
            double d4 = (fArr2[i3] + fArr2[i2]) / 2.0f;
            Double.isNaN(d4);
            d3 += (dArr[i2] - dArr[i3]) * d4;
            i2++;
        }
        int i4 = 0;
        while (true) {
            float[] fArr3 = this.mPeriod;
            if (i4 >= fArr3.length) {
                break;
            }
            double d5 = fArr3[i4];
            Double.isNaN(d5);
            fArr3[i4] = (float) (d5 * (d / d3));
            i4++;
        }
        this.mArea[0] = 0.0d;
        int i5 = 1;
        while (true) {
            float[] fArr4 = this.mPeriod;
            if (i5 < fArr4.length) {
                int i6 = i5 - 1;
                double[] dArr2 = this.mPosition;
                double d6 = dArr2[i5] - dArr2[i6];
                double[] dArr3 = this.mArea;
                double d7 = dArr3[i6];
                double d8 = (fArr4[i6] + fArr4[i5]) / 2.0f;
                Double.isNaN(d8);
                dArr3[i5] = d7 + (d6 * d8);
                i5++;
            } else {
                this.mNormalized = true;
                return;
            }
        }
    }

    public void setType(int i) {
        this.mType = i;
    }

    public String toString() {
        return "pos =" + Arrays.toString(this.mPosition) + " period=" + Arrays.toString(this.mPeriod);
    }
}
