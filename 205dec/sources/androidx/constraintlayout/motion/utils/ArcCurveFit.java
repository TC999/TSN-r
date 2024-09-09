package androidx.constraintlayout.motion.utils;

import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
class ArcCurveFit extends CurveFit {
    public static final int ARC_START_FLIP = 3;
    public static final int ARC_START_HORIZONTAL = 2;
    public static final int ARC_START_LINEAR = 0;
    public static final int ARC_START_VERTICAL = 1;
    private static final int START_HORIZONTAL = 2;
    private static final int START_LINEAR = 3;
    private static final int START_VERTICAL = 1;
    Arc[] mArcs;
    private final double[] mTime;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    private static class Arc {
        private static final double EPSILON = 0.001d;
        private static final String TAG = "Arc";
        private static double[] ourPercent = new double[91];
        boolean linear;
        double mArcDistance;
        double mArcVelocity;
        double mEllipseA;
        double mEllipseB;
        double mEllipseCenterX;
        double mEllipseCenterY;
        double[] mLut;
        double mOneOverDeltaTime;
        double mTime1;
        double mTime2;
        double mTmpCosAngle;
        double mTmpSinAngle;
        boolean mVertical;
        double mX1;
        double mX2;
        double mY1;
        double mY2;

        Arc(int i4, double d4, double d5, double d6, double d7, double d8, double d9) {
            this.linear = false;
            this.mVertical = i4 == 1;
            this.mTime1 = d4;
            this.mTime2 = d5;
            this.mOneOverDeltaTime = 1.0d / (d5 - d4);
            if (3 == i4) {
                this.linear = true;
            }
            double d10 = d8 - d6;
            double d11 = d9 - d7;
            if (!this.linear && Math.abs(d10) >= 0.001d && Math.abs(d11) >= 0.001d) {
                this.mLut = new double[101];
                boolean z3 = this.mVertical;
                double d12 = z3 ? -1 : 1;
                Double.isNaN(d12);
                this.mEllipseA = d10 * d12;
                double d13 = z3 ? 1 : -1;
                Double.isNaN(d13);
                this.mEllipseB = d11 * d13;
                this.mEllipseCenterX = z3 ? d8 : d6;
                this.mEllipseCenterY = z3 ? d7 : d9;
                buildTable(d6, d7, d8, d9);
                this.mArcVelocity = this.mArcDistance * this.mOneOverDeltaTime;
                return;
            }
            this.linear = true;
            this.mX1 = d6;
            this.mX2 = d8;
            this.mY1 = d7;
            this.mY2 = d9;
            double hypot = Math.hypot(d11, d10);
            this.mArcDistance = hypot;
            this.mArcVelocity = hypot * this.mOneOverDeltaTime;
            double d14 = this.mTime2;
            double d15 = this.mTime1;
            this.mEllipseCenterX = d10 / (d14 - d15);
            this.mEllipseCenterY = d11 / (d14 - d15);
        }

        private void buildTable(double d4, double d5, double d6, double d7) {
            double[] dArr;
            double[] dArr2;
            double d8;
            double d9 = d6 - d4;
            double d10 = d5 - d7;
            int i4 = 0;
            double d11 = 0.0d;
            double d12 = 0.0d;
            double d13 = 0.0d;
            while (true) {
                if (i4 >= ourPercent.length) {
                    break;
                }
                double d14 = i4;
                Double.isNaN(d14);
                double d15 = d11;
                double length = dArr.length - 1;
                Double.isNaN(length);
                double radians = Math.toRadians((d14 * 90.0d) / length);
                double sin = Math.sin(radians) * d9;
                double cos = Math.cos(radians) * d10;
                if (i4 > 0) {
                    d8 = Math.hypot(sin - d12, cos - d13) + d15;
                    ourPercent[i4] = d8;
                } else {
                    d8 = d15;
                }
                i4++;
                d13 = cos;
                d11 = d8;
                d12 = sin;
            }
            double d16 = d11;
            this.mArcDistance = d16;
            int i5 = 0;
            while (true) {
                double[] dArr3 = ourPercent;
                if (i5 >= dArr3.length) {
                    break;
                }
                dArr3[i5] = dArr3[i5] / d16;
                i5++;
            }
            int i6 = 0;
            while (true) {
                if (i6 >= this.mLut.length) {
                    return;
                }
                double d17 = i6;
                double length2 = dArr2.length - 1;
                Double.isNaN(d17);
                Double.isNaN(length2);
                double d18 = d17 / length2;
                int binarySearch = Arrays.binarySearch(ourPercent, d18);
                if (binarySearch >= 0) {
                    this.mLut[i6] = binarySearch / (ourPercent.length - 1);
                } else if (binarySearch == -1) {
                    this.mLut[i6] = 0.0d;
                } else {
                    int i7 = -binarySearch;
                    int i8 = i7 - 2;
                    double d19 = i8;
                    double[] dArr4 = ourPercent;
                    Double.isNaN(d19);
                    double length3 = dArr4.length - 1;
                    Double.isNaN(length3);
                    this.mLut[i6] = (d19 + ((d18 - dArr4[i8]) / (dArr4[i7 - 1] - dArr4[i8]))) / length3;
                }
                i6++;
            }
        }

        double getDX() {
            double d4 = this.mEllipseA * this.mTmpCosAngle;
            double hypot = this.mArcVelocity / Math.hypot(d4, (-this.mEllipseB) * this.mTmpSinAngle);
            if (this.mVertical) {
                d4 = -d4;
            }
            return d4 * hypot;
        }

        double getDY() {
            double d4 = this.mEllipseA * this.mTmpCosAngle;
            double d5 = (-this.mEllipseB) * this.mTmpSinAngle;
            double hypot = this.mArcVelocity / Math.hypot(d4, d5);
            return this.mVertical ? (-d5) * hypot : d5 * hypot;
        }

        public double getLinearDX(double d4) {
            return this.mEllipseCenterX;
        }

        public double getLinearDY(double d4) {
            return this.mEllipseCenterY;
        }

        public double getLinearX(double d4) {
            double d5 = (d4 - this.mTime1) * this.mOneOverDeltaTime;
            double d6 = this.mX1;
            return d6 + (d5 * (this.mX2 - d6));
        }

        public double getLinearY(double d4) {
            double d5 = (d4 - this.mTime1) * this.mOneOverDeltaTime;
            double d6 = this.mY1;
            return d6 + (d5 * (this.mY2 - d6));
        }

        double getX() {
            return this.mEllipseCenterX + (this.mEllipseA * this.mTmpSinAngle);
        }

        double getY() {
            return this.mEllipseCenterY + (this.mEllipseB * this.mTmpCosAngle);
        }

        double lookup(double d4) {
            if (d4 <= 0.0d) {
                return 0.0d;
            }
            if (d4 >= 1.0d) {
                return 1.0d;
            }
            double[] dArr = this.mLut;
            double length = dArr.length - 1;
            Double.isNaN(length);
            double d5 = d4 * length;
            int i4 = (int) d5;
            double d6 = i4;
            Double.isNaN(d6);
            return dArr[i4] + ((d5 - d6) * (dArr[i4 + 1] - dArr[i4]));
        }

        void setPoint(double d4) {
            double lookup = lookup((this.mVertical ? this.mTime2 - d4 : d4 - this.mTime1) * this.mOneOverDeltaTime) * 1.5707963267948966d;
            this.mTmpSinAngle = Math.sin(lookup);
            this.mTmpCosAngle = Math.cos(lookup);
        }
    }

    public ArcCurveFit(int[] iArr, double[] dArr, double[][] dArr2) {
        this.mTime = dArr;
        this.mArcs = new Arc[dArr.length - 1];
        int i4 = 0;
        int i5 = 1;
        int i6 = 1;
        while (true) {
            Arc[] arcArr = this.mArcs;
            if (i4 >= arcArr.length) {
                return;
            }
            int i7 = iArr[i4];
            if (i7 == 0) {
                i6 = 3;
            } else if (i7 == 1) {
                i5 = 1;
                i6 = 1;
            } else if (i7 == 2) {
                i5 = 2;
                i6 = 2;
            } else if (i7 == 3) {
                i5 = i5 == 1 ? 2 : 1;
                i6 = i5;
            }
            int i8 = i4 + 1;
            arcArr[i4] = new Arc(i6, dArr[i4], dArr[i8], dArr2[i4][0], dArr2[i4][1], dArr2[i8][0], dArr2[i8][1]);
            i4 = i8;
        }
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public void getPos(double d4, double[] dArr) {
        Arc[] arcArr = this.mArcs;
        if (d4 < arcArr[0].mTime1) {
            d4 = arcArr[0].mTime1;
        }
        if (d4 > arcArr[arcArr.length - 1].mTime2) {
            d4 = arcArr[arcArr.length - 1].mTime2;
        }
        int i4 = 0;
        while (true) {
            Arc[] arcArr2 = this.mArcs;
            if (i4 >= arcArr2.length) {
                return;
            }
            if (d4 <= arcArr2[i4].mTime2) {
                if (arcArr2[i4].linear) {
                    dArr[0] = arcArr2[i4].getLinearX(d4);
                    dArr[1] = this.mArcs[i4].getLinearY(d4);
                    return;
                }
                arcArr2[i4].setPoint(d4);
                dArr[0] = this.mArcs[i4].getX();
                dArr[1] = this.mArcs[i4].getY();
                return;
            }
            i4++;
        }
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public void getSlope(double d4, double[] dArr) {
        Arc[] arcArr = this.mArcs;
        if (d4 < arcArr[0].mTime1) {
            d4 = arcArr[0].mTime1;
        } else if (d4 > arcArr[arcArr.length - 1].mTime2) {
            d4 = arcArr[arcArr.length - 1].mTime2;
        }
        int i4 = 0;
        while (true) {
            Arc[] arcArr2 = this.mArcs;
            if (i4 >= arcArr2.length) {
                return;
            }
            if (d4 <= arcArr2[i4].mTime2) {
                if (arcArr2[i4].linear) {
                    dArr[0] = arcArr2[i4].getLinearDX(d4);
                    dArr[1] = this.mArcs[i4].getLinearDY(d4);
                    return;
                }
                arcArr2[i4].setPoint(d4);
                dArr[0] = this.mArcs[i4].getDX();
                dArr[1] = this.mArcs[i4].getDY();
                return;
            }
            i4++;
        }
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public double[] getTimePoints() {
        return this.mTime;
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public void getPos(double d4, float[] fArr) {
        Arc[] arcArr = this.mArcs;
        if (d4 < arcArr[0].mTime1) {
            d4 = arcArr[0].mTime1;
        } else if (d4 > arcArr[arcArr.length - 1].mTime2) {
            d4 = arcArr[arcArr.length - 1].mTime2;
        }
        int i4 = 0;
        while (true) {
            Arc[] arcArr2 = this.mArcs;
            if (i4 >= arcArr2.length) {
                return;
            }
            if (d4 <= arcArr2[i4].mTime2) {
                if (arcArr2[i4].linear) {
                    fArr[0] = (float) arcArr2[i4].getLinearX(d4);
                    fArr[1] = (float) this.mArcs[i4].getLinearY(d4);
                    return;
                }
                arcArr2[i4].setPoint(d4);
                fArr[0] = (float) this.mArcs[i4].getX();
                fArr[1] = (float) this.mArcs[i4].getY();
                return;
            }
            i4++;
        }
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public double getSlope(double d4, int i4) {
        Arc[] arcArr = this.mArcs;
        int i5 = 0;
        if (d4 < arcArr[0].mTime1) {
            d4 = arcArr[0].mTime1;
        }
        if (d4 > arcArr[arcArr.length - 1].mTime2) {
            d4 = arcArr[arcArr.length - 1].mTime2;
        }
        while (true) {
            Arc[] arcArr2 = this.mArcs;
            if (i5 >= arcArr2.length) {
                return Double.NaN;
            }
            if (d4 <= arcArr2[i5].mTime2) {
                if (arcArr2[i5].linear) {
                    if (i4 == 0) {
                        return arcArr2[i5].getLinearDX(d4);
                    }
                    return arcArr2[i5].getLinearDY(d4);
                }
                arcArr2[i5].setPoint(d4);
                if (i4 == 0) {
                    return this.mArcs[i5].getDX();
                }
                return this.mArcs[i5].getDY();
            }
            i5++;
        }
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public double getPos(double d4, int i4) {
        Arc[] arcArr = this.mArcs;
        int i5 = 0;
        if (d4 < arcArr[0].mTime1) {
            d4 = arcArr[0].mTime1;
        } else if (d4 > arcArr[arcArr.length - 1].mTime2) {
            d4 = arcArr[arcArr.length - 1].mTime2;
        }
        while (true) {
            Arc[] arcArr2 = this.mArcs;
            if (i5 >= arcArr2.length) {
                return Double.NaN;
            }
            if (d4 <= arcArr2[i5].mTime2) {
                if (arcArr2[i5].linear) {
                    if (i4 == 0) {
                        return arcArr2[i5].getLinearX(d4);
                    }
                    return arcArr2[i5].getLinearY(d4);
                }
                arcArr2[i5].setPoint(d4);
                if (i4 == 0) {
                    return this.mArcs[i5].getX();
                }
                return this.mArcs[i5].getY();
            }
            i5++;
        }
    }
}
