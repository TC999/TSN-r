package com.google.zxing.pdf417.detector;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class Detector {
    private static final int BARCODE_MIN_HEIGHT = 10;
    private static final float MAX_AVG_VARIANCE = 0.42f;
    private static final float MAX_INDIVIDUAL_VARIANCE = 0.8f;
    private static final int MAX_PATTERN_DRIFT = 5;
    private static final int MAX_PIXEL_DRIFT = 3;
    private static final int ROW_STEP = 5;
    private static final int SKIPPED_ROW_COUNT_MAX = 25;
    private static final int[] INDEXES_START_PATTERN = {0, 4, 1, 5};
    private static final int[] INDEXES_STOP_PATTERN = {6, 2, 7, 3};
    private static final int[] START_PATTERN = {8, 1, 1, 1, 1, 1, 1, 3};
    private static final int[] STOP_PATTERN = {7, 1, 1, 3, 1, 1, 1, 2, 1};

    private Detector() {
    }

    private static void copyToResult(ResultPoint[] resultPointArr, ResultPoint[] resultPointArr2, int[] iArr) {
        for (int i4 = 0; i4 < iArr.length; i4++) {
            resultPointArr[iArr[i4]] = resultPointArr2[i4];
        }
    }

    public static PDF417DetectorResult detect(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map, boolean z3) throws NotFoundException {
        BitMatrix blackMatrix = binaryBitmap.getBlackMatrix();
        List<ResultPoint[]> detect = detect(z3, blackMatrix);
        if (detect.isEmpty()) {
            blackMatrix = blackMatrix.m88clone();
            blackMatrix.rotate180();
            detect = detect(z3, blackMatrix);
        }
        return new PDF417DetectorResult(blackMatrix, detect);
    }

    private static int[] findGuardPattern(BitMatrix bitMatrix, int i4, int i5, int i6, boolean z3, int[] iArr, int[] iArr2) {
        Arrays.fill(iArr2, 0, iArr2.length, 0);
        int i7 = 0;
        while (bitMatrix.get(i4, i5) && i4 > 0) {
            int i8 = i7 + 1;
            if (i7 >= 3) {
                break;
            }
            i4--;
            i7 = i8;
        }
        int length = iArr.length;
        boolean z4 = z3;
        int i9 = 0;
        int i10 = i4;
        while (i4 < i6) {
            if (bitMatrix.get(i4, i5) ^ z4) {
                iArr2[i9] = iArr2[i9] + 1;
            } else {
                int i11 = length - 1;
                if (i9 != i11) {
                    i9++;
                } else if (patternMatchVariance(iArr2, iArr, 0.8f) < 0.42f) {
                    return new int[]{i10, i4};
                } else {
                    i10 += iArr2[0] + iArr2[1];
                    int i12 = length - 2;
                    System.arraycopy(iArr2, 2, iArr2, 0, i12);
                    iArr2[i12] = 0;
                    iArr2[i11] = 0;
                    i9--;
                }
                iArr2[i9] = 1;
                z4 = !z4;
            }
            i4++;
        }
        if (i9 != length - 1 || patternMatchVariance(iArr2, iArr, 0.8f) >= 0.42f) {
            return null;
        }
        return new int[]{i10, i4 - 1};
    }

    private static ResultPoint[] findRowsWithPattern(BitMatrix bitMatrix, int i4, int i5, int i6, int i7, int[] iArr) {
        int i8;
        boolean z3;
        int i9;
        int i10;
        int i11;
        ResultPoint[] resultPointArr = new ResultPoint[4];
        int[] iArr2 = new int[iArr.length];
        int i12 = i6;
        while (true) {
            if (i12 >= i4) {
                z3 = false;
                break;
            }
            int[] findGuardPattern = findGuardPattern(bitMatrix, i7, i12, i5, false, iArr, iArr2);
            if (findGuardPattern != null) {
                int i13 = i12;
                int[] iArr3 = findGuardPattern;
                int i14 = i13;
                while (true) {
                    if (i14 <= 0) {
                        i11 = i14;
                        break;
                    }
                    int i15 = i14 - 1;
                    int[] findGuardPattern2 = findGuardPattern(bitMatrix, i7, i15, i5, false, iArr, iArr2);
                    if (findGuardPattern2 == null) {
                        i11 = i15 + 1;
                        break;
                    }
                    iArr3 = findGuardPattern2;
                    i14 = i15;
                }
                float f4 = i11;
                resultPointArr[0] = new ResultPoint(iArr3[0], f4);
                resultPointArr[1] = new ResultPoint(iArr3[1], f4);
                i12 = i11;
                z3 = true;
            } else {
                i12 += 5;
            }
        }
        int i16 = i12 + 1;
        if (z3) {
            int[] iArr4 = {(int) resultPointArr[0].getX(), (int) resultPointArr[1].getX()};
            int i17 = i16;
            int i18 = 0;
            while (true) {
                if (i17 >= i4) {
                    i9 = i18;
                    i10 = i17;
                    break;
                }
                i9 = i18;
                i10 = i17;
                int[] findGuardPattern3 = findGuardPattern(bitMatrix, iArr4[0], i17, i5, false, iArr, iArr2);
                if (findGuardPattern3 != null && Math.abs(iArr4[0] - findGuardPattern3[0]) < 5 && Math.abs(iArr4[1] - findGuardPattern3[1]) < 5) {
                    iArr4 = findGuardPattern3;
                    i18 = 0;
                } else if (i9 > 25) {
                    break;
                } else {
                    i18 = i9 + 1;
                }
                i17 = i10 + 1;
            }
            i16 = i10 - (i9 + 1);
            float f5 = i16;
            resultPointArr[2] = new ResultPoint(iArr4[0], f5);
            resultPointArr[3] = new ResultPoint(iArr4[1], f5);
        }
        if (i16 - i12 < 10) {
            for (i8 = 0; i8 < 4; i8++) {
                resultPointArr[i8] = null;
            }
        }
        return resultPointArr;
    }

    private static ResultPoint[] findVertices(BitMatrix bitMatrix, int i4, int i5) {
        int height = bitMatrix.getHeight();
        int width = bitMatrix.getWidth();
        ResultPoint[] resultPointArr = new ResultPoint[8];
        copyToResult(resultPointArr, findRowsWithPattern(bitMatrix, height, width, i4, i5, START_PATTERN), INDEXES_START_PATTERN);
        if (resultPointArr[4] != null) {
            i5 = (int) resultPointArr[4].getX();
            i4 = (int) resultPointArr[4].getY();
        }
        copyToResult(resultPointArr, findRowsWithPattern(bitMatrix, height, width, i4, i5, STOP_PATTERN), INDEXES_STOP_PATTERN);
        return resultPointArr;
    }

    private static float patternMatchVariance(int[] iArr, int[] iArr2, float f4) {
        int length = iArr.length;
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 0; i6 < length; i6++) {
            i4 += iArr[i6];
            i5 += iArr2[i6];
        }
        if (i4 < i5) {
            return Float.POSITIVE_INFINITY;
        }
        float f5 = i4;
        float f6 = f5 / i5;
        float f7 = f4 * f6;
        float f8 = 0.0f;
        for (int i7 = 0; i7 < length; i7++) {
            float f9 = iArr2[i7] * f6;
            float f10 = iArr[i7];
            float f11 = f10 > f9 ? f10 - f9 : f9 - f10;
            if (f11 > f7) {
                return Float.POSITIVE_INFINITY;
            }
            f8 += f11;
        }
        return f8 / f5;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001d, code lost:
        if (r5 == false) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x001f, code lost:
        r4 = r0.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0027, code lost:
        if (r4.hasNext() == false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0029, code lost:
        r5 = (com.google.zxing.ResultPoint[]) r4.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0031, code lost:
        if (r5[1] == null) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0033, code lost:
        r3 = (int) java.lang.Math.max(r3, r5[1].getY());
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0041, code lost:
        if (r5[3] == null) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0043, code lost:
        r3 = java.lang.Math.max(r3, (int) r5[3].getY());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.util.List<com.google.zxing.ResultPoint[]> detect(boolean r8, com.google.zxing.common.BitMatrix r9) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 1
            r2 = 0
            r3 = 0
        L8:
            r4 = 0
            r5 = 0
        La:
            int r6 = r9.getHeight()
            if (r3 >= r6) goto L7c
            com.google.zxing.ResultPoint[] r4 = findVertices(r9, r3, r4)
            r6 = r4[r2]
            if (r6 != 0) goto L52
            r6 = 3
            r7 = r4[r6]
            if (r7 != 0) goto L52
            if (r5 == 0) goto L7c
            java.util.Iterator r4 = r0.iterator()
        L23:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L4f
            java.lang.Object r5 = r4.next()
            com.google.zxing.ResultPoint[] r5 = (com.google.zxing.ResultPoint[]) r5
            r7 = r5[r1]
            if (r7 == 0) goto L3f
            float r3 = (float) r3
            r7 = r5[r1]
            float r7 = r7.getY()
            float r3 = java.lang.Math.max(r3, r7)
            int r3 = (int) r3
        L3f:
            r7 = r5[r6]
            if (r7 == 0) goto L23
            r5 = r5[r6]
            float r5 = r5.getY()
            int r5 = (int) r5
            int r3 = java.lang.Math.max(r3, r5)
            goto L23
        L4f:
            int r3 = r3 + 5
            goto L8
        L52:
            r0.add(r4)
            if (r8 == 0) goto L7c
            r3 = 2
            r5 = r4[r3]
            if (r5 == 0) goto L6a
            r5 = r4[r3]
            float r5 = r5.getX()
            int r5 = (int) r5
            r3 = r4[r3]
            float r3 = r3.getY()
            goto L78
        L6a:
            r3 = 4
            r5 = r4[r3]
            float r5 = r5.getX()
            int r5 = (int) r5
            r3 = r4[r3]
            float r3 = r3.getY()
        L78:
            int r3 = (int) r3
            r4 = r5
            r5 = 1
            goto La
        L7c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.pdf417.detector.Detector.detect(boolean, com.google.zxing.common.BitMatrix):java.util.List");
    }
}
