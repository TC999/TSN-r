package com.google.zxing.pdf417.decoder;

import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.common.detector.MathUtils;
import com.google.zxing.pdf417.PDF417Common;
import com.google.zxing.pdf417.decoder.ec.ErrorCorrection;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Formatter;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class PDF417ScanningDecoder {
    private static final int CODEWORD_SKEW_SIZE = 2;
    private static final int MAX_EC_CODEWORDS = 512;
    private static final int MAX_ERRORS = 3;
    private static final ErrorCorrection errorCorrection = new ErrorCorrection();

    private PDF417ScanningDecoder() {
    }

    private static BoundingBox adjustBoundingBox(DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn) throws NotFoundException {
        int[] rowHeights;
        if (detectionResultRowIndicatorColumn == null || (rowHeights = detectionResultRowIndicatorColumn.getRowHeights()) == null) {
            return null;
        }
        int max = getMax(rowHeights);
        int i4 = 0;
        int i5 = 0;
        for (int i6 : rowHeights) {
            i5 += max - i6;
            if (i6 > 0) {
                break;
            }
        }
        Codeword[] codewords = detectionResultRowIndicatorColumn.getCodewords();
        for (int i7 = 0; i5 > 0 && codewords[i7] == null; i7++) {
            i5--;
        }
        for (int length = rowHeights.length - 1; length >= 0; length--) {
            i4 += max - rowHeights[length];
            if (rowHeights[length] > 0) {
                break;
            }
        }
        for (int length2 = codewords.length - 1; i4 > 0 && codewords[length2] == null; length2--) {
            i4--;
        }
        return detectionResultRowIndicatorColumn.getBoundingBox().addMissingRows(i5, i4, detectionResultRowIndicatorColumn.isLeft());
    }

    private static void adjustCodewordCount(DetectionResult detectionResult, BarcodeValue[][] barcodeValueArr) throws NotFoundException {
        int[] value = barcodeValueArr[0][1].getValue();
        int barcodeColumnCount = (detectionResult.getBarcodeColumnCount() * detectionResult.getBarcodeRowCount()) - getNumberOfECCodeWords(detectionResult.getBarcodeECLevel());
        if (value.length != 0) {
            if (value[0] != barcodeColumnCount) {
                barcodeValueArr[0][1].setValue(barcodeColumnCount);
            }
        } else if (barcodeColumnCount > 0 && barcodeColumnCount <= 928) {
            barcodeValueArr[0][1].setValue(barcodeColumnCount);
        } else {
            throw NotFoundException.getNotFoundInstance();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0022, code lost:
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0022, code lost:
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0022, code lost:
        continue;
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int adjustCodewordStartColumn(com.google.zxing.common.BitMatrix r5, int r6, int r7, boolean r8, int r9, int r10) {
        /*
            if (r8 == 0) goto L4
            r0 = -1
            goto L5
        L4:
            r0 = 1
        L5:
            r1 = 0
            r2 = r9
        L7:
            r3 = 2
            if (r1 >= r3) goto L28
        La:
            if (r8 == 0) goto Lf
            if (r2 < r6) goto L22
            goto L11
        Lf:
            if (r2 >= r7) goto L22
        L11:
            boolean r4 = r5.get(r2, r10)
            if (r8 != r4) goto L22
            int r4 = r9 - r2
            int r4 = java.lang.Math.abs(r4)
            if (r4 <= r3) goto L20
            return r9
        L20:
            int r2 = r2 + r0
            goto La
        L22:
            int r0 = -r0
            r8 = r8 ^ 1
            int r1 = r1 + 1
            goto L7
        L28:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.pdf417.decoder.PDF417ScanningDecoder.adjustCodewordStartColumn(com.google.zxing.common.BitMatrix, int, int, boolean, int, int):int");
    }

    private static boolean checkCodewordSkew(int i4, int i5, int i6) {
        return i5 + (-2) <= i4 && i4 <= i6 + 2;
    }

    private static int correctErrors(int[] iArr, int[] iArr2, int i4) throws ChecksumException {
        if ((iArr2 == null || iArr2.length <= (i4 / 2) + 3) && i4 >= 0 && i4 <= 512) {
            return errorCorrection.decode(iArr, i4, iArr2);
        }
        throw ChecksumException.getChecksumInstance();
    }

    private static BarcodeValue[][] createBarcodeMatrix(DetectionResult detectionResult) {
        DetectionResultColumn[] detectionResultColumns;
        Codeword[] codewords;
        int rowNumber;
        BarcodeValue[][] barcodeValueArr = (BarcodeValue[][]) Array.newInstance(BarcodeValue.class, detectionResult.getBarcodeRowCount(), detectionResult.getBarcodeColumnCount() + 2);
        for (int i4 = 0; i4 < barcodeValueArr.length; i4++) {
            for (int i5 = 0; i5 < barcodeValueArr[i4].length; i5++) {
                barcodeValueArr[i4][i5] = new BarcodeValue();
            }
        }
        int i6 = 0;
        for (DetectionResultColumn detectionResultColumn : detectionResult.getDetectionResultColumns()) {
            if (detectionResultColumn != null) {
                for (Codeword codeword : detectionResultColumn.getCodewords()) {
                    if (codeword != null && (rowNumber = codeword.getRowNumber()) >= 0 && rowNumber < barcodeValueArr.length) {
                        barcodeValueArr[rowNumber][i6].setValue(codeword.getValue());
                    }
                }
            }
            i6++;
        }
        return barcodeValueArr;
    }

    private static DecoderResult createDecoderResult(DetectionResult detectionResult) throws FormatException, ChecksumException, NotFoundException {
        BarcodeValue[][] createBarcodeMatrix = createBarcodeMatrix(detectionResult);
        adjustCodewordCount(detectionResult, createBarcodeMatrix);
        ArrayList arrayList = new ArrayList();
        int[] iArr = new int[detectionResult.getBarcodeRowCount() * detectionResult.getBarcodeColumnCount()];
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (int i4 = 0; i4 < detectionResult.getBarcodeRowCount(); i4++) {
            int i5 = 0;
            while (i5 < detectionResult.getBarcodeColumnCount()) {
                int i6 = i5 + 1;
                int[] value = createBarcodeMatrix[i4][i6].getValue();
                int barcodeColumnCount = (detectionResult.getBarcodeColumnCount() * i4) + i5;
                if (value.length == 0) {
                    arrayList.add(Integer.valueOf(barcodeColumnCount));
                } else if (value.length == 1) {
                    iArr[barcodeColumnCount] = value[0];
                } else {
                    arrayList3.add(Integer.valueOf(barcodeColumnCount));
                    arrayList2.add(value);
                }
                i5 = i6;
            }
        }
        int size = arrayList2.size();
        int[][] iArr2 = new int[size];
        for (int i7 = 0; i7 < size; i7++) {
            iArr2[i7] = (int[]) arrayList2.get(i7);
        }
        return createDecoderResultFromAmbiguousValues(detectionResult.getBarcodeECLevel(), iArr, PDF417Common.toIntArray(arrayList), PDF417Common.toIntArray(arrayList3), iArr2);
    }

    private static DecoderResult createDecoderResultFromAmbiguousValues(int i4, int[] iArr, int[] iArr2, int[] iArr3, int[][] iArr4) throws FormatException, ChecksumException {
        int length = iArr3.length;
        int[] iArr5 = new int[length];
        int i5 = 100;
        while (true) {
            int i6 = i5 - 1;
            if (i5 > 0) {
                for (int i7 = 0; i7 < length; i7++) {
                    iArr[iArr3[i7]] = iArr4[i7][iArr5[i7]];
                }
                try {
                    return decodeCodewords(iArr, i4, iArr2);
                } catch (ChecksumException unused) {
                    if (length == 0) {
                        throw ChecksumException.getChecksumInstance();
                    }
                    int i8 = 0;
                    while (true) {
                        if (i8 >= length) {
                            break;
                        } else if (iArr5[i8] < iArr4[i8].length - 1) {
                            iArr5[i8] = iArr5[i8] + 1;
                            break;
                        } else {
                            iArr5[i8] = 0;
                            if (i8 == length - 1) {
                                throw ChecksumException.getChecksumInstance();
                            }
                            i8++;
                        }
                    }
                    i5 = i6;
                }
            } else {
                throw ChecksumException.getChecksumInstance();
            }
        }
    }

    public static DecoderResult decode(BitMatrix bitMatrix, ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3, ResultPoint resultPoint4, int i4, int i5) throws NotFoundException, FormatException, ChecksumException {
        DetectionResultColumn detectionResultRowIndicatorColumn;
        int i6;
        int i7;
        int i8;
        DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn2 = null;
        DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn3 = null;
        DetectionResult detectionResult = null;
        BoundingBox boundingBox = new BoundingBox(bitMatrix, resultPoint, resultPoint2, resultPoint3, resultPoint4);
        for (int i9 = 0; i9 < 2; i9++) {
            if (resultPoint != null) {
                detectionResultRowIndicatorColumn2 = getRowIndicatorColumn(bitMatrix, boundingBox, resultPoint, true, i4, i5);
            }
            if (resultPoint3 != null) {
                detectionResultRowIndicatorColumn3 = getRowIndicatorColumn(bitMatrix, boundingBox, resultPoint3, false, i4, i5);
            }
            detectionResult = merge(detectionResultRowIndicatorColumn2, detectionResultRowIndicatorColumn3);
            if (detectionResult != null) {
                if (i9 == 0 && detectionResult.getBoundingBox() != null && (detectionResult.getBoundingBox().getMinY() < boundingBox.getMinY() || detectionResult.getBoundingBox().getMaxY() > boundingBox.getMaxY())) {
                    boundingBox = detectionResult.getBoundingBox();
                } else {
                    detectionResult.setBoundingBox(boundingBox);
                    break;
                }
            } else {
                throw NotFoundException.getNotFoundInstance();
            }
        }
        int barcodeColumnCount = detectionResult.getBarcodeColumnCount() + 1;
        detectionResult.setDetectionResultColumn(0, detectionResultRowIndicatorColumn2);
        detectionResult.setDetectionResultColumn(barcodeColumnCount, detectionResultRowIndicatorColumn3);
        boolean z3 = detectionResultRowIndicatorColumn2 != null;
        int i10 = i4;
        int i11 = i5;
        for (int i12 = 1; i12 <= barcodeColumnCount; i12++) {
            int i13 = z3 ? i12 : barcodeColumnCount - i12;
            if (detectionResult.getDetectionResultColumn(i13) == null) {
                if (i13 != 0 && i13 != barcodeColumnCount) {
                    detectionResultRowIndicatorColumn = new DetectionResultColumn(boundingBox);
                } else {
                    detectionResultRowIndicatorColumn = new DetectionResultRowIndicatorColumn(boundingBox, i13 == 0);
                }
                detectionResult.setDetectionResultColumn(i13, detectionResultRowIndicatorColumn);
                int i14 = -1;
                int minY = boundingBox.getMinY();
                int i15 = -1;
                while (minY <= boundingBox.getMaxY()) {
                    int startColumn = getStartColumn(detectionResult, i13, minY, z3);
                    if (startColumn >= 0 && startColumn <= boundingBox.getMaxX()) {
                        i8 = startColumn;
                    } else if (i15 != i14) {
                        i8 = i15;
                    } else {
                        i6 = i15;
                        i7 = minY;
                        i15 = i6;
                        minY = i7 + 1;
                        i14 = -1;
                    }
                    i6 = i15;
                    int i16 = minY;
                    Codeword detectCodeword = detectCodeword(bitMatrix, boundingBox.getMinX(), boundingBox.getMaxX(), z3, i8, i16, i10, i11);
                    i7 = i16;
                    if (detectCodeword != null) {
                        detectionResultRowIndicatorColumn.setCodeword(i7, detectCodeword);
                        i10 = Math.min(i10, detectCodeword.getWidth());
                        i11 = Math.max(i11, detectCodeword.getWidth());
                        i15 = i8;
                        minY = i7 + 1;
                        i14 = -1;
                    }
                    i15 = i6;
                    minY = i7 + 1;
                    i14 = -1;
                }
            }
        }
        return createDecoderResult(detectionResult);
    }

    private static DecoderResult decodeCodewords(int[] iArr, int i4, int[] iArr2) throws FormatException, ChecksumException {
        if (iArr.length != 0) {
            int i5 = 1 << (i4 + 1);
            int correctErrors = correctErrors(iArr, iArr2, i5);
            verifyCodewordCount(iArr, i5);
            DecoderResult decode = DecodedBitStreamParser.decode(iArr, String.valueOf(i4));
            decode.setErrorsCorrected(Integer.valueOf(correctErrors));
            decode.setErasures(Integer.valueOf(iArr2.length));
            return decode;
        }
        throw FormatException.getFormatInstance();
    }

    private static Codeword detectCodeword(BitMatrix bitMatrix, int i4, int i5, boolean z3, int i6, int i7, int i8, int i9) {
        int i10;
        int decodedValue;
        int codeword;
        int adjustCodewordStartColumn = adjustCodewordStartColumn(bitMatrix, i4, i5, z3, i6, i7);
        int[] moduleBitCount = getModuleBitCount(bitMatrix, i4, i5, z3, adjustCodewordStartColumn, i7);
        if (moduleBitCount == null) {
            return null;
        }
        int sum = MathUtils.sum(moduleBitCount);
        if (z3) {
            i10 = adjustCodewordStartColumn + sum;
        } else {
            for (int i11 = 0; i11 < moduleBitCount.length / 2; i11++) {
                int i12 = moduleBitCount[i11];
                moduleBitCount[i11] = moduleBitCount[(moduleBitCount.length - 1) - i11];
                moduleBitCount[(moduleBitCount.length - 1) - i11] = i12;
            }
            adjustCodewordStartColumn -= sum;
            i10 = adjustCodewordStartColumn;
        }
        if (checkCodewordSkew(sum, i8, i9) && (codeword = PDF417Common.getCodeword((decodedValue = PDF417CodewordDecoder.getDecodedValue(moduleBitCount)))) != -1) {
            return new Codeword(adjustCodewordStartColumn, i10, getCodewordBucketNumber(decodedValue), codeword);
        }
        return null;
    }

    private static BarcodeMetadata getBarcodeMetadata(DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn, DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn2) {
        BarcodeMetadata barcodeMetadata;
        BarcodeMetadata barcodeMetadata2;
        if (detectionResultRowIndicatorColumn == null || (barcodeMetadata = detectionResultRowIndicatorColumn.getBarcodeMetadata()) == null) {
            if (detectionResultRowIndicatorColumn2 == null) {
                return null;
            }
            return detectionResultRowIndicatorColumn2.getBarcodeMetadata();
        } else if (detectionResultRowIndicatorColumn2 == null || (barcodeMetadata2 = detectionResultRowIndicatorColumn2.getBarcodeMetadata()) == null || barcodeMetadata.getColumnCount() == barcodeMetadata2.getColumnCount() || barcodeMetadata.getErrorCorrectionLevel() == barcodeMetadata2.getErrorCorrectionLevel() || barcodeMetadata.getRowCount() == barcodeMetadata2.getRowCount()) {
            return barcodeMetadata;
        } else {
            return null;
        }
    }

    private static int[] getBitCountForCodeword(int i4) {
        int[] iArr = new int[8];
        int i5 = 0;
        int i6 = 7;
        while (true) {
            int i7 = i4 & 1;
            if (i7 != i5) {
                i6--;
                if (i6 < 0) {
                    return iArr;
                }
                i5 = i7;
            }
            iArr[i6] = iArr[i6] + 1;
            i4 >>= 1;
        }
    }

    private static int getCodewordBucketNumber(int i4) {
        return getCodewordBucketNumber(getBitCountForCodeword(i4));
    }

    private static int getMax(int[] iArr) {
        int i4 = -1;
        for (int i5 : iArr) {
            i4 = Math.max(i4, i5);
        }
        return i4;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0015  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0027 A[EDGE_INSN: B:27:0x0027->B:16:0x0027 ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int[] getModuleBitCount(com.google.zxing.common.BitMatrix r7, int r8, int r9, boolean r10, int r11, int r12) {
        /*
            r0 = 8
            int[] r1 = new int[r0]
            r2 = 1
            if (r10 == 0) goto L9
            r3 = 1
            goto La
        L9:
            r3 = -1
        La:
            r4 = 0
            r5 = r10
        Lc:
            if (r10 == 0) goto L11
            if (r11 >= r9) goto L27
            goto L13
        L11:
            if (r11 < r8) goto L27
        L13:
            if (r4 >= r0) goto L27
            boolean r6 = r7.get(r11, r12)
            if (r6 != r5) goto L22
            r6 = r1[r4]
            int r6 = r6 + r2
            r1[r4] = r6
            int r11 = r11 + r3
            goto Lc
        L22:
            int r4 = r4 + 1
            r5 = r5 ^ 1
            goto Lc
        L27:
            if (r4 == r0) goto L34
            if (r10 == 0) goto L2c
            r8 = r9
        L2c:
            if (r11 != r8) goto L32
            r7 = 7
            if (r4 != r7) goto L32
            goto L34
        L32:
            r7 = 0
            return r7
        L34:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.pdf417.decoder.PDF417ScanningDecoder.getModuleBitCount(com.google.zxing.common.BitMatrix, int, int, boolean, int, int):int[]");
    }

    private static int getNumberOfECCodeWords(int i4) {
        return 2 << i4;
    }

    private static DetectionResultRowIndicatorColumn getRowIndicatorColumn(BitMatrix bitMatrix, BoundingBox boundingBox, ResultPoint resultPoint, boolean z3, int i4, int i5) {
        int endX;
        DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn = new DetectionResultRowIndicatorColumn(boundingBox, z3);
        int i6 = 0;
        while (i6 < 2) {
            int i7 = i6 == 0 ? 1 : -1;
            int x3 = (int) resultPoint.getX();
            for (int y3 = (int) resultPoint.getY(); y3 <= boundingBox.getMaxY() && y3 >= boundingBox.getMinY(); y3 += i7) {
                Codeword detectCodeword = detectCodeword(bitMatrix, 0, bitMatrix.getWidth(), z3, x3, y3, i4, i5);
                if (detectCodeword != null) {
                    detectionResultRowIndicatorColumn.setCodeword(y3, detectCodeword);
                    if (z3) {
                        endX = detectCodeword.getStartX();
                    } else {
                        endX = detectCodeword.getEndX();
                    }
                    x3 = endX;
                }
            }
            i6++;
        }
        return detectionResultRowIndicatorColumn;
    }

    private static int getStartColumn(DetectionResult detectionResult, int i4, int i5, boolean z3) {
        Codeword[] codewords;
        int i6 = z3 ? 1 : -1;
        int i7 = i4 - i6;
        Codeword codeword = isValidBarcodeColumn(detectionResult, i7) ? detectionResult.getDetectionResultColumn(i7).getCodeword(i5) : null;
        if (codeword != null) {
            return z3 ? codeword.getEndX() : codeword.getStartX();
        }
        Codeword codewordNearby = detectionResult.getDetectionResultColumn(i4).getCodewordNearby(i5);
        if (codewordNearby != null) {
            return z3 ? codewordNearby.getStartX() : codewordNearby.getEndX();
        }
        if (isValidBarcodeColumn(detectionResult, i7)) {
            codewordNearby = detectionResult.getDetectionResultColumn(i7).getCodewordNearby(i5);
        }
        if (codewordNearby != null) {
            return z3 ? codewordNearby.getEndX() : codewordNearby.getStartX();
        }
        int i8 = 0;
        while (true) {
            i4 -= i6;
            if (isValidBarcodeColumn(detectionResult, i4)) {
                for (Codeword codeword2 : detectionResult.getDetectionResultColumn(i4).getCodewords()) {
                    if (codeword2 != null) {
                        return (z3 ? codeword2.getEndX() : codeword2.getStartX()) + (i6 * i8 * (codeword2.getEndX() - codeword2.getStartX()));
                    }
                }
                i8++;
            } else {
                BoundingBox boundingBox = detectionResult.getBoundingBox();
                return z3 ? boundingBox.getMinX() : boundingBox.getMaxX();
            }
        }
    }

    private static boolean isValidBarcodeColumn(DetectionResult detectionResult, int i4) {
        return i4 >= 0 && i4 <= detectionResult.getBarcodeColumnCount() + 1;
    }

    private static DetectionResult merge(DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn, DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn2) throws NotFoundException {
        BarcodeMetadata barcodeMetadata;
        if ((detectionResultRowIndicatorColumn == null && detectionResultRowIndicatorColumn2 == null) || (barcodeMetadata = getBarcodeMetadata(detectionResultRowIndicatorColumn, detectionResultRowIndicatorColumn2)) == null) {
            return null;
        }
        return new DetectionResult(barcodeMetadata, BoundingBox.merge(adjustBoundingBox(detectionResultRowIndicatorColumn), adjustBoundingBox(detectionResultRowIndicatorColumn2)));
    }

    public static String toString(BarcodeValue[][] barcodeValueArr) {
        Formatter formatter = new Formatter();
        for (int i4 = 0; i4 < barcodeValueArr.length; i4++) {
            formatter.format("Row %2d: ", Integer.valueOf(i4));
            for (int i5 = 0; i5 < barcodeValueArr[i4].length; i5++) {
                BarcodeValue barcodeValue = barcodeValueArr[i4][i5];
                if (barcodeValue.getValue().length == 0) {
                    formatter.format("        ", null);
                } else {
                    formatter.format("%4d(%2d)", Integer.valueOf(barcodeValue.getValue()[0]), barcodeValue.getConfidence(barcodeValue.getValue()[0]));
                }
            }
            formatter.format("%n", new Object[0]);
        }
        String formatter2 = formatter.toString();
        formatter.close();
        return formatter2;
    }

    private static void verifyCodewordCount(int[] iArr, int i4) throws FormatException {
        if (iArr.length >= 4) {
            int i5 = iArr[0];
            if (i5 > iArr.length) {
                throw FormatException.getFormatInstance();
            }
            if (i5 == 0) {
                if (i4 < iArr.length) {
                    iArr[0] = iArr.length - i4;
                    return;
                }
                throw FormatException.getFormatInstance();
            }
            return;
        }
        throw FormatException.getFormatInstance();
    }

    private static int getCodewordBucketNumber(int[] iArr) {
        return ((((iArr[0] - iArr[2]) + iArr[4]) - iArr[6]) + 9) % 9;
    }
}
