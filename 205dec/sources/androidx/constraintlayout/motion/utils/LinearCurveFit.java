package androidx.constraintlayout.motion.utils;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class LinearCurveFit extends CurveFit {
    private static final String TAG = "LinearCurveFit";
    private double[] mT;
    private double mTotalLength;
    private double[][] mY;

    public LinearCurveFit(double[] dArr, double[][] dArr2) {
        this.mTotalLength = Double.NaN;
        int length = dArr.length;
        int length2 = dArr2[0].length;
        this.mT = dArr;
        this.mY = dArr2;
        if (length2 > 2) {
            double d4 = 0.0d;
            double d5 = 0.0d;
            int i4 = 0;
            while (i4 < dArr.length) {
                double d6 = dArr2[i4][0];
                double d7 = dArr2[i4][0];
                if (i4 > 0) {
                    Math.hypot(d6 - d4, d7 - d5);
                }
                i4++;
                d4 = d6;
                d5 = d7;
            }
            this.mTotalLength = 0.0d;
        }
    }

    private double getLength2D(double d4) {
        if (Double.isNaN(this.mTotalLength)) {
            return 0.0d;
        }
        double[] dArr = this.mT;
        int length = dArr.length;
        if (d4 <= dArr[0]) {
            return 0.0d;
        }
        int i4 = length - 1;
        if (d4 >= dArr[i4]) {
            return this.mTotalLength;
        }
        double d5 = 0.0d;
        double d6 = 0.0d;
        double d7 = 0.0d;
        int i5 = 0;
        while (i5 < i4) {
            double[][] dArr2 = this.mY;
            double d8 = dArr2[i5][0];
            double d9 = dArr2[i5][1];
            if (i5 > 0) {
                d5 += Math.hypot(d8 - d6, d9 - d7);
            }
            double[] dArr3 = this.mT;
            if (d4 == dArr3[i5]) {
                return d5;
            }
            int i6 = i5 + 1;
            if (d4 < dArr3[i6]) {
                double d10 = (d4 - dArr3[i5]) / (dArr3[i6] - dArr3[i5]);
                double[][] dArr4 = this.mY;
                double d11 = 1.0d - d10;
                return d5 + Math.hypot(d9 - ((dArr4[i5][1] * d11) + (dArr4[i6][1] * d10)), d8 - ((dArr4[i5][0] * d11) + (dArr4[i6][0] * d10)));
            }
            i5 = i6;
            d6 = d8;
            d7 = d9;
        }
        return 0.0d;
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
                double d5 = (d4 - dArr3[i7]) / (dArr3[i9] - dArr3[i7]);
                while (i4 < length2) {
                    double[][] dArr4 = this.mY;
                    dArr[i4] = (dArr4[i7][i4] * (1.0d - d5)) + (dArr4[i9][i4] * d5);
                    i4++;
                }
                return;
            }
            i7 = i9;
        }
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public void getSlope(double d4, double[] dArr) {
        double[] dArr2 = this.mT;
        int length = dArr2.length;
        int length2 = this.mY[0].length;
        if (d4 <= dArr2[0]) {
            d4 = dArr2[0];
        } else {
            int i4 = length - 1;
            if (d4 >= dArr2[i4]) {
                d4 = dArr2[i4];
            }
        }
        int i5 = 0;
        while (i5 < length - 1) {
            double[] dArr3 = this.mT;
            int i6 = i5 + 1;
            if (d4 <= dArr3[i6]) {
                double d5 = dArr3[i6] - dArr3[i5];
                double d6 = dArr3[i5];
                for (int i7 = 0; i7 < length2; i7++) {
                    double[][] dArr4 = this.mY;
                    dArr[i7] = (dArr4[i6][i7] - dArr4[i5][i7]) / d5;
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
        double[] dArr = this.mT;
        int length = dArr.length;
        int i5 = 0;
        if (d4 < dArr[0]) {
            d4 = dArr[0];
        } else {
            int i6 = length - 1;
            if (d4 >= dArr[i6]) {
                d4 = dArr[i6];
            }
        }
        while (i5 < length - 1) {
            double[] dArr2 = this.mT;
            int i7 = i5 + 1;
            if (d4 <= dArr2[i7]) {
                double d5 = dArr2[i7] - dArr2[i5];
                double d6 = dArr2[i5];
                double[][] dArr3 = this.mY;
                return (dArr3[i7][i4] - dArr3[i5][i4]) / d5;
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
                double d5 = (d4 - dArr2[i7]) / (dArr2[i9] - dArr2[i7]);
                while (i4 < length2) {
                    double[][] dArr3 = this.mY;
                    fArr[i4] = (float) ((dArr3[i7][i4] * (1.0d - d5)) + (dArr3[i9][i4] * d5));
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
                double d5 = (d4 - dArr2[i5]) / (dArr2[i7] - dArr2[i5]);
                double[][] dArr3 = this.mY;
                return (dArr3[i5][i4] * (1.0d - d5)) + (dArr3[i7][i4] * d5);
            }
            i5 = i7;
        }
        return 0.0d;
    }
}
