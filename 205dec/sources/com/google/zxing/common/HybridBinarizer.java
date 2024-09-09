package com.google.zxing.common;

import com.google.zxing.Binarizer;
import com.google.zxing.LuminanceSource;
import com.google.zxing.NotFoundException;
import java.lang.reflect.Array;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class HybridBinarizer extends GlobalHistogramBinarizer {
    private static final int BLOCK_SIZE = 8;
    private static final int BLOCK_SIZE_MASK = 7;
    private static final int BLOCK_SIZE_POWER = 3;
    private static final int MINIMUM_DIMENSION = 40;
    private static final int MIN_DYNAMIC_RANGE = 24;
    private BitMatrix matrix;

    public HybridBinarizer(LuminanceSource luminanceSource) {
        super(luminanceSource);
    }

    private static int[][] calculateBlackPoints(byte[] bArr, int i4, int i5, int i6, int i7) {
        int[][] iArr = (int[][]) Array.newInstance(int.class, i5, i4);
        for (int i8 = 0; i8 < i5; i8++) {
            int i9 = i8 << 3;
            int i10 = i7 - 8;
            if (i9 > i10) {
                i9 = i10;
            }
            for (int i11 = 0; i11 < i4; i11++) {
                int i12 = i11 << 3;
                int i13 = i6 - 8;
                if (i12 > i13) {
                    i12 = i13;
                }
                int i14 = (i9 * i6) + i12;
                int i15 = 0;
                int i16 = 0;
                int i17 = 0;
                int i18 = 255;
                while (i15 < 8) {
                    for (int i19 = 0; i19 < 8; i19++) {
                        int i20 = bArr[i14 + i19] & 255;
                        i16 += i20;
                        if (i20 < i18) {
                            i18 = i20;
                        }
                        if (i20 > i17) {
                            i17 = i20;
                        }
                    }
                    if (i17 - i18 <= 24) {
                        i15++;
                        i14 += i6;
                    }
                    while (true) {
                        i15++;
                        i14 += i6;
                        if (i15 < 8) {
                            for (int i21 = 0; i21 < 8; i21++) {
                                i16 += bArr[i14 + i21] & 255;
                            }
                        }
                    }
                    i15++;
                    i14 += i6;
                }
                int i22 = i16 >> 6;
                if (i17 - i18 <= 24) {
                    i22 = i18 / 2;
                    if (i8 > 0 && i11 > 0) {
                        int i23 = i8 - 1;
                        int i24 = i11 - 1;
                        int i25 = ((iArr[i23][i11] + (iArr[i8][i24] * 2)) + iArr[i23][i24]) / 4;
                        if (i18 < i25) {
                            i22 = i25;
                        }
                        iArr[i8][i11] = i22;
                    }
                }
                iArr[i8][i11] = i22;
            }
        }
        return iArr;
    }

    private static void calculateThresholdForBlock(byte[] bArr, int i4, int i5, int i6, int i7, int[][] iArr, BitMatrix bitMatrix) {
        for (int i8 = 0; i8 < i5; i8++) {
            int i9 = i8 << 3;
            int i10 = i7 - 8;
            if (i9 > i10) {
                i9 = i10;
            }
            for (int i11 = 0; i11 < i4; i11++) {
                int i12 = i11 << 3;
                int i13 = i6 - 8;
                if (i12 <= i13) {
                    i13 = i12;
                }
                int cap = cap(i11, 2, i4 - 3);
                int cap2 = cap(i8, 2, i5 - 3);
                int i14 = 0;
                for (int i15 = -2; i15 <= 2; i15++) {
                    int[] iArr2 = iArr[cap2 + i15];
                    i14 += iArr2[cap - 2] + iArr2[cap - 1] + iArr2[cap] + iArr2[cap + 1] + iArr2[cap + 2];
                }
                thresholdBlock(bArr, i13, i9, i14 / 25, i6, bitMatrix);
            }
        }
    }

    private static int cap(int i4, int i5, int i6) {
        return i4 < i5 ? i5 : i4 > i6 ? i6 : i4;
    }

    private static void thresholdBlock(byte[] bArr, int i4, int i5, int i6, int i7, BitMatrix bitMatrix) {
        int i8 = (i5 * i7) + i4;
        int i9 = 0;
        while (i9 < 8) {
            for (int i10 = 0; i10 < 8; i10++) {
                if ((bArr[i8 + i10] & 255) <= i6) {
                    bitMatrix.set(i4 + i10, i5 + i9);
                }
            }
            i9++;
            i8 += i7;
        }
    }

    @Override // com.google.zxing.common.GlobalHistogramBinarizer, com.google.zxing.Binarizer
    public Binarizer createBinarizer(LuminanceSource luminanceSource) {
        return new HybridBinarizer(luminanceSource);
    }

    @Override // com.google.zxing.common.GlobalHistogramBinarizer, com.google.zxing.Binarizer
    public BitMatrix getBlackMatrix() throws NotFoundException {
        BitMatrix bitMatrix = this.matrix;
        if (bitMatrix != null) {
            return bitMatrix;
        }
        LuminanceSource luminanceSource = getLuminanceSource();
        int width = luminanceSource.getWidth();
        int height = luminanceSource.getHeight();
        if (width >= 40 && height >= 40) {
            byte[] matrix = luminanceSource.getMatrix();
            int i4 = width >> 3;
            if ((width & 7) != 0) {
                i4++;
            }
            int i5 = i4;
            int i6 = height >> 3;
            if ((height & 7) != 0) {
                i6++;
            }
            int i7 = i6;
            int[][] calculateBlackPoints = calculateBlackPoints(matrix, i5, i7, width, height);
            BitMatrix bitMatrix2 = new BitMatrix(width, height);
            calculateThresholdForBlock(matrix, i5, i7, width, height, calculateBlackPoints, bitMatrix2);
            this.matrix = bitMatrix2;
        } else {
            this.matrix = super.getBlackMatrix();
        }
        return this.matrix;
    }
}
