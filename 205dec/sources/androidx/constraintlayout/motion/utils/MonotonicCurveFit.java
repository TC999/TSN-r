package androidx.constraintlayout.motion.utils;

import java.lang.reflect.Array;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class MonotonicCurveFit extends CurveFit {
    private static final String TAG = "MonotonicCurveFit";
    private double[] mT;
    private double[][] mTangent;
    private double[][] mY;

    public MonotonicCurveFit(double[] dArr, double[][] dArr2) {
        int length = dArr.length;
        int length2 = dArr2[0].length;
        int i4 = length - 1;
        double[][] dArr3 = (double[][]) Array.newInstance(double.class, i4, length2);
        double[][] dArr4 = (double[][]) Array.newInstance(double.class, length, length2);
        for (int i5 = 0; i5 < length2; i5++) {
            int i6 = 0;
            while (i6 < i4) {
                int i7 = i6 + 1;
                dArr3[i6][i5] = (dArr2[i7][i5] - dArr2[i6][i5]) / (dArr[i7] - dArr[i6]);
                if (i6 == 0) {
                    dArr4[i6][i5] = dArr3[i6][i5];
                } else {
                    dArr4[i6][i5] = (dArr3[i6 - 1][i5] + dArr3[i6][i5]) * 0.5d;
                }
                i6 = i7;
            }
            dArr4[i4][i5] = dArr3[length - 2][i5];
        }
        for (int i8 = 0; i8 < i4; i8++) {
            for (int i9 = 0; i9 < length2; i9++) {
                if (dArr3[i8][i9] == 0.0d) {
                    dArr4[i8][i9] = 0.0d;
                    dArr4[i8 + 1][i9] = 0.0d;
                } else {
                    double d4 = dArr4[i8][i9] / dArr3[i8][i9];
                    int i10 = i8 + 1;
                    double d5 = dArr4[i10][i9] / dArr3[i8][i9];
                    double hypot = Math.hypot(d4, d5);
                    if (hypot > 9.0d) {
                        double d6 = 3.0d / hypot;
                        dArr4[i8][i9] = d4 * d6 * dArr3[i8][i9];
                        dArr4[i10][i9] = d6 * d5 * dArr3[i8][i9];
                    }
                }
            }
        }
        this.mT = dArr;
        this.mY = dArr2;
        this.mTangent = dArr4;
    }

    private static double diff(double d4, double d5, double d6, double d7, double d8, double d9) {
        double d10 = d5 * d5;
        double d11 = d5 * 6.0d;
        double d12 = 3.0d * d4;
        return ((((((((((-6.0d) * d10) * d7) + (d11 * d7)) + ((6.0d * d10) * d6)) - (d11 * d6)) + ((d12 * d9) * d10)) + ((d12 * d8) * d10)) - (((2.0d * d4) * d9) * d5)) - (((4.0d * d4) * d8) * d5)) + (d4 * d8);
    }

    private static double interpolate(double d4, double d5, double d6, double d7, double d8, double d9) {
        double d10 = d5 * d5;
        double d11 = d10 * d5;
        double d12 = 3.0d * d10;
        double d13 = d4 * d9;
        double d14 = d4 * d8;
        return (((((((((((-2.0d) * d11) * d7) + (d12 * d7)) + ((d11 * 2.0d) * d6)) - (d12 * d6)) + d6) + (d13 * d11)) + (d11 * d14)) - (d13 * d10)) - (((d4 * 2.0d) * d8) * d10)) + (d14 * d5);
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public void getPos(double d4, double[] dArr) {
        double[] dArr2 = this.mT;
        int length = dArr2.length;
        int i4 = 0;
        int length2 = this.mY[0].length;
        if (d4 <= dArr2[0]) {
            for (int i5 = 0; i5 < length2; i5++) {
                dArr[i5] = this.mY[0][i5];
            }
            return;
        }
        int i6 = length - 1;
        if (d4 >= dArr2[i6]) {
            while (i4 < length2) {
                dArr[i4] = this.mY[i6][i4];
                i4++;
            }
            return;
        }
        int i7 = 0;
        while (i7 < i6) {
            if (d4 == this.mT[i7]) {
                for (int i8 = 0; i8 < length2; i8++) {
                    dArr[i8] = this.mY[i7][i8];
                }
            }
            double[] dArr3 = this.mT;
            int i9 = i7 + 1;
            if (d4 < dArr3[i9]) {
                double d5 = dArr3[i9] - dArr3[i7];
                double d6 = (d4 - dArr3[i7]) / d5;
                while (i4 < length2) {
                    double[][] dArr4 = this.mY;
                    double d7 = dArr4[i7][i4];
                    double d8 = dArr4[i9][i4];
                    double[][] dArr5 = this.mTangent;
                    dArr[i4] = interpolate(d5, d6, d7, d8, dArr5[i7][i4], dArr5[i9][i4]);
                    i4++;
                }
                return;
            }
            i7 = i9;
        }
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public void getSlope(double d4, double[] dArr) {
        double d5;
        double[] dArr2 = this.mT;
        int length = dArr2.length;
        int length2 = this.mY[0].length;
        if (d4 <= dArr2[0]) {
            d5 = dArr2[0];
        } else {
            int i4 = length - 1;
            d5 = d4 >= dArr2[i4] ? dArr2[i4] : d4;
        }
        int i5 = 0;
        while (i5 < length - 1) {
            double[] dArr3 = this.mT;
            int i6 = i5 + 1;
            if (d5 <= dArr3[i6]) {
                double d6 = dArr3[i6] - dArr3[i5];
                double d7 = (d5 - dArr3[i5]) / d6;
                for (int i7 = 0; i7 < length2; i7++) {
                    double[][] dArr4 = this.mY;
                    double d8 = dArr4[i5][i7];
                    double d9 = dArr4[i6][i7];
                    double[][] dArr5 = this.mTangent;
                    dArr[i7] = diff(d6, d7, d8, d9, dArr5[i5][i7], dArr5[i6][i7]) / d6;
                }
                return;
            }
            i5 = i6;
        }
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public double[] getTimePoints() {
        return this.mT;
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public double getSlope(double d4, int i4) {
        double d5;
        double[] dArr = this.mT;
        int length = dArr.length;
        int i5 = 0;
        if (d4 < dArr[0]) {
            d5 = dArr[0];
        } else {
            int i6 = length - 1;
            d5 = d4 >= dArr[i6] ? dArr[i6] : d4;
        }
        while (i5 < length - 1) {
            double[] dArr2 = this.mT;
            int i7 = i5 + 1;
            if (d5 <= dArr2[i7]) {
                double d6 = dArr2[i7] - dArr2[i5];
                double[][] dArr3 = this.mY;
                double d7 = dArr3[i5][i4];
                double d8 = dArr3[i7][i4];
                double[][] dArr4 = this.mTangent;
                return diff(d6, (d5 - dArr2[i5]) / d6, d7, d8, dArr4[i5][i4], dArr4[i7][i4]) / d6;
            }
            i5 = i7;
        }
        return 0.0d;
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public void getPos(double d4, float[] fArr) {
        double[] dArr = this.mT;
        int length = dArr.length;
        int i4 = 0;
        int length2 = this.mY[0].length;
        if (d4 <= dArr[0]) {
            for (int i5 = 0; i5 < length2; i5++) {
                fArr[i5] = (float) this.mY[0][i5];
            }
            return;
        }
        int i6 = length - 1;
        if (d4 >= dArr[i6]) {
            while (i4 < length2) {
                fArr[i4] = (float) this.mY[i6][i4];
                i4++;
            }
            return;
        }
        int i7 = 0;
        while (i7 < i6) {
            if (d4 == this.mT[i7]) {
                for (int i8 = 0; i8 < length2; i8++) {
                    fArr[i8] = (float) this.mY[i7][i8];
                }
            }
            double[] dArr2 = this.mT;
            int i9 = i7 + 1;
            if (d4 < dArr2[i9]) {
                double d5 = dArr2[i9] - dArr2[i7];
                double d6 = (d4 - dArr2[i7]) / d5;
                while (i4 < length2) {
                    double[][] dArr3 = this.mY;
                    double d7 = dArr3[i7][i4];
                    double d8 = dArr3[i9][i4];
                    double[][] dArr4 = this.mTangent;
                    fArr[i4] = (float) interpolate(d5, d6, d7, d8, dArr4[i7][i4], dArr4[i9][i4]);
                    i4++;
                }
                return;
            }
            i7 = i9;
        }
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public double getPos(double d4, int i4) {
        double[] dArr = this.mT;
        int length = dArr.length;
        int i5 = 0;
        if (d4 <= dArr[0]) {
            return this.mY[0][i4];
        }
        int i6 = length - 1;
        if (d4 >= dArr[i6]) {
            return this.mY[i6][i4];
        }
        while (i5 < i6) {
            double[] dArr2 = this.mT;
            if (d4 == dArr2[i5]) {
                return this.mY[i5][i4];
            }
            int i7 = i5 + 1;
            if (d4 < dArr2[i7]) {
                double d5 = dArr2[i7] - dArr2[i5];
                double d6 = (d4 - dArr2[i5]) / d5;
                double[][] dArr3 = this.mY;
                double d7 = dArr3[i5][i4];
                double d8 = dArr3[i7][i4];
                double[][] dArr4 = this.mTangent;
                return interpolate(d5, d6, d7, d8, dArr4[i5][i4], dArr4[i7][i4]);
            }
            i5 = i7;
        }
        return 0.0d;
    }
}
