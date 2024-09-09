package com.google.zxing.common.detector;

import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class WhiteRectangleDetector {
    private static final int CORR = 1;
    private static final int INIT_SIZE = 10;
    private final int downInit;
    private final int height;
    private final BitMatrix image;
    private final int leftInit;
    private final int rightInit;
    private final int upInit;
    private final int width;

    public WhiteRectangleDetector(BitMatrix bitMatrix) throws NotFoundException {
        this(bitMatrix, 10, bitMatrix.getWidth() / 2, bitMatrix.getHeight() / 2);
    }

    private ResultPoint[] centerEdges(ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3, ResultPoint resultPoint4) {
        float x3 = resultPoint.getX();
        float y3 = resultPoint.getY();
        float x4 = resultPoint2.getX();
        float y4 = resultPoint2.getY();
        float x5 = resultPoint3.getX();
        float y5 = resultPoint3.getY();
        float x6 = resultPoint4.getX();
        float y6 = resultPoint4.getY();
        return x3 < ((float) this.width) / 2.0f ? new ResultPoint[]{new ResultPoint(x6 - 1.0f, y6 + 1.0f), new ResultPoint(x4 + 1.0f, y4 + 1.0f), new ResultPoint(x5 - 1.0f, y5 - 1.0f), new ResultPoint(x3 + 1.0f, y3 - 1.0f)} : new ResultPoint[]{new ResultPoint(x6 + 1.0f, y6 + 1.0f), new ResultPoint(x4 + 1.0f, y4 - 1.0f), new ResultPoint(x5 - 1.0f, y5 + 1.0f), new ResultPoint(x3 - 1.0f, y3 - 1.0f)};
    }

    private boolean containsBlackPoint(int i4, int i5, int i6, boolean z3) {
        if (z3) {
            while (i4 <= i5) {
                if (this.image.get(i4, i6)) {
                    return true;
                }
                i4++;
            }
            return false;
        }
        while (i4 <= i5) {
            if (this.image.get(i6, i4)) {
                return true;
            }
            i4++;
        }
        return false;
    }

    private ResultPoint getBlackPointOnSegment(float f4, float f5, float f6, float f7) {
        int round = MathUtils.round(MathUtils.distance(f4, f5, f6, f7));
        float f8 = round;
        float f9 = (f6 - f4) / f8;
        float f10 = (f7 - f5) / f8;
        for (int i4 = 0; i4 < round; i4++) {
            float f11 = i4;
            int round2 = MathUtils.round((f11 * f9) + f4);
            int round3 = MathUtils.round((f11 * f10) + f5);
            if (this.image.get(round2, round3)) {
                return new ResultPoint(round2, round3);
            }
        }
        return null;
    }

    public ResultPoint[] detect() throws NotFoundException {
        int i4 = this.leftInit;
        int i5 = this.rightInit;
        int i6 = this.upInit;
        int i7 = this.downInit;
        boolean z3 = false;
        boolean z4 = true;
        boolean z5 = false;
        boolean z6 = false;
        boolean z7 = false;
        boolean z8 = false;
        boolean z9 = false;
        while (z4) {
            boolean z10 = true;
            boolean z11 = false;
            while (true) {
                if ((z10 || !z5) && i5 < this.width) {
                    z10 = containsBlackPoint(i6, i7, i5, false);
                    if (z10) {
                        i5++;
                        z5 = true;
                        z11 = true;
                    } else if (!z5) {
                        i5++;
                    }
                }
            }
            if (i5 < this.width) {
                boolean z12 = true;
                while (true) {
                    if ((z12 || !z6) && i7 < this.height) {
                        z12 = containsBlackPoint(i4, i5, i7, true);
                        if (z12) {
                            i7++;
                            z6 = true;
                            z11 = true;
                        } else if (!z6) {
                            i7++;
                        }
                    }
                }
                if (i7 < this.height) {
                    boolean z13 = true;
                    while (true) {
                        if ((z13 || !z7) && i4 >= 0) {
                            z13 = containsBlackPoint(i6, i7, i4, false);
                            if (z13) {
                                i4--;
                                z7 = true;
                                z11 = true;
                            } else if (!z7) {
                                i4--;
                            }
                        }
                    }
                    if (i4 >= 0) {
                        z4 = z11;
                        boolean z14 = true;
                        while (true) {
                            if ((z14 || !z9) && i6 >= 0) {
                                z14 = containsBlackPoint(i4, i5, i6, true);
                                if (z14) {
                                    i6--;
                                    z4 = true;
                                    z9 = true;
                                } else if (!z9) {
                                    i6--;
                                }
                            }
                        }
                        if (i6 >= 0) {
                            if (z4) {
                                z8 = true;
                            }
                        }
                    }
                }
            }
            z3 = true;
            break;
        }
        if (z3 || !z8) {
            throw NotFoundException.getNotFoundInstance();
        }
        int i8 = i5 - i4;
        ResultPoint resultPoint = null;
        ResultPoint resultPoint2 = null;
        for (int i9 = 1; resultPoint2 == null && i9 < i8; i9++) {
            resultPoint2 = getBlackPointOnSegment(i4, i7 - i9, i4 + i9, i7);
        }
        if (resultPoint2 != null) {
            ResultPoint resultPoint3 = null;
            for (int i10 = 1; resultPoint3 == null && i10 < i8; i10++) {
                resultPoint3 = getBlackPointOnSegment(i4, i6 + i10, i4 + i10, i6);
            }
            if (resultPoint3 != null) {
                ResultPoint resultPoint4 = null;
                for (int i11 = 1; resultPoint4 == null && i11 < i8; i11++) {
                    resultPoint4 = getBlackPointOnSegment(i5, i6 + i11, i5 - i11, i6);
                }
                if (resultPoint4 != null) {
                    for (int i12 = 1; resultPoint == null && i12 < i8; i12++) {
                        resultPoint = getBlackPointOnSegment(i5, i7 - i12, i5 - i12, i7);
                    }
                    if (resultPoint != null) {
                        return centerEdges(resultPoint, resultPoint2, resultPoint4, resultPoint3);
                    }
                    throw NotFoundException.getNotFoundInstance();
                }
                throw NotFoundException.getNotFoundInstance();
            }
            throw NotFoundException.getNotFoundInstance();
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public WhiteRectangleDetector(BitMatrix bitMatrix, int i4, int i5, int i6) throws NotFoundException {
        this.image = bitMatrix;
        int height = bitMatrix.getHeight();
        this.height = height;
        int width = bitMatrix.getWidth();
        this.width = width;
        int i7 = i4 / 2;
        int i8 = i5 - i7;
        this.leftInit = i8;
        int i9 = i5 + i7;
        this.rightInit = i9;
        int i10 = i6 - i7;
        this.upInit = i10;
        int i11 = i6 + i7;
        this.downInit = i11;
        if (i10 < 0 || i8 < 0 || i11 >= height || i9 >= width) {
            throw NotFoundException.getNotFoundInstance();
        }
    }
}
