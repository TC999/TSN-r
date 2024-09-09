package androidx.constraintlayout.motion.utils;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public abstract class CurveFit {
    public static final int CONSTANT = 2;
    public static final int LINEAR = 1;
    public static final int SPLINE = 0;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    static class Constant extends CurveFit {
        double mTime;
        double[] mValue;

        Constant(double d4, double[] dArr) {
            this.mTime = d4;
            this.mValue = dArr;
        }

        @Override // androidx.constraintlayout.motion.utils.CurveFit
        public void getPos(double d4, double[] dArr) {
            double[] dArr2 = this.mValue;
            System.arraycopy(dArr2, 0, dArr, 0, dArr2.length);
        }

        @Override // androidx.constraintlayout.motion.utils.CurveFit
        public double getSlope(double d4, int i4) {
            return 0.0d;
        }

        @Override // androidx.constraintlayout.motion.utils.CurveFit
        public void getSlope(double d4, double[] dArr) {
            for (int i4 = 0; i4 < this.mValue.length; i4++) {
                dArr[i4] = 0.0d;
            }
        }

        @Override // androidx.constraintlayout.motion.utils.CurveFit
        public double[] getTimePoints() {
            return new double[]{this.mTime};
        }

        @Override // androidx.constraintlayout.motion.utils.CurveFit
        public void getPos(double d4, float[] fArr) {
            int i4 = 0;
            while (true) {
                double[] dArr = this.mValue;
                if (i4 >= dArr.length) {
                    return;
                }
                fArr[i4] = (float) dArr[i4];
                i4++;
            }
        }

        @Override // androidx.constraintlayout.motion.utils.CurveFit
        public double getPos(double d4, int i4) {
            return this.mValue[i4];
        }
    }

    public static CurveFit get(int i4, double[] dArr, double[][] dArr2) {
        if (dArr.length == 1) {
            i4 = 2;
        }
        if (i4 != 0) {
            if (i4 != 2) {
                return new LinearCurveFit(dArr, dArr2);
            }
            return new Constant(dArr[0], dArr2[0]);
        }
        return new MonotonicCurveFit(dArr, dArr2);
    }

    public static CurveFit getArc(int[] iArr, double[] dArr, double[][] dArr2) {
        return new ArcCurveFit(iArr, dArr, dArr2);
    }

    public abstract double getPos(double d4, int i4);

    public abstract void getPos(double d4, double[] dArr);

    public abstract void getPos(double d4, float[] fArr);

    public abstract double getSlope(double d4, int i4);

    public abstract void getSlope(double d4, double[] dArr);

    public abstract double[] getTimePoints();
}
