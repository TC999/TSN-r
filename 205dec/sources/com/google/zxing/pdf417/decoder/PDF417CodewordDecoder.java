package com.google.zxing.pdf417.decoder;

import com.google.zxing.common.detector.MathUtils;
import com.google.zxing.pdf417.PDF417Common;
import java.lang.reflect.Array;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
final class PDF417CodewordDecoder {
    private static final float[][] RATIOS_TABLE = (float[][]) Array.newInstance(float.class, PDF417Common.SYMBOL_TABLE.length, 8);

    static {
        int i4;
        int i5 = 0;
        while (true) {
            int[] iArr = PDF417Common.SYMBOL_TABLE;
            if (i5 >= iArr.length) {
                return;
            }
            int i6 = iArr[i5];
            int i7 = i6 & 1;
            int i8 = 0;
            while (i8 < 8) {
                float f4 = 0.0f;
                while (true) {
                    i4 = i6 & 1;
                    if (i4 == i7) {
                        f4 += 1.0f;
                        i6 >>= 1;
                    }
                }
                RATIOS_TABLE[i5][(8 - i8) - 1] = f4 / 17.0f;
                i8++;
                i7 = i4;
            }
            i5++;
        }
    }

    private PDF417CodewordDecoder() {
    }

    private static int getBitValue(int[] iArr) {
        long j4 = 0;
        for (int i4 = 0; i4 < iArr.length; i4++) {
            for (int i5 = 0; i5 < iArr[i4]; i5++) {
                int i6 = 1;
                long j5 = j4 << 1;
                if (i4 % 2 != 0) {
                    i6 = 0;
                }
                j4 = j5 | i6;
            }
        }
        return (int) j4;
    }

    private static int getClosestDecodedValue(int[] iArr) {
        int sum = MathUtils.sum(iArr);
        float[] fArr = new float[8];
        for (int i4 = 0; i4 < 8; i4++) {
            fArr[i4] = iArr[i4] / sum;
        }
        float f4 = Float.MAX_VALUE;
        int i5 = -1;
        int i6 = 0;
        while (true) {
            float[][] fArr2 = RATIOS_TABLE;
            if (i6 >= fArr2.length) {
                return i5;
            }
            float f5 = 0.0f;
            float[] fArr3 = fArr2[i6];
            for (int i7 = 0; i7 < 8; i7++) {
                float f6 = fArr3[i7] - fArr[i7];
                f5 += f6 * f6;
                if (f5 >= f4) {
                    break;
                }
            }
            if (f5 < f4) {
                i5 = PDF417Common.SYMBOL_TABLE[i6];
                f4 = f5;
            }
            i6++;
        }
    }

    private static int getDecodedCodewordValue(int[] iArr) {
        int bitValue = getBitValue(iArr);
        if (PDF417Common.getCodeword(bitValue) == -1) {
            return -1;
        }
        return bitValue;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getDecodedValue(int[] iArr) {
        int decodedCodewordValue = getDecodedCodewordValue(sampleBitCounts(iArr));
        return decodedCodewordValue != -1 ? decodedCodewordValue : getClosestDecodedValue(iArr);
    }

    private static int[] sampleBitCounts(int[] iArr) {
        float sum = MathUtils.sum(iArr);
        int[] iArr2 = new int[8];
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 0; i6 < 17; i6++) {
            if (iArr[i5] + i4 <= (sum / 34.0f) + ((i6 * sum) / 17.0f)) {
                i4 += iArr[i5];
                i5++;
            }
            iArr2[i5] = iArr2[i5] + 1;
        }
        return iArr2;
    }
}
