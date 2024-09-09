package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class ITFWriter extends OneDimensionalCodeWriter {
    private static final int[] START_PATTERN = {1, 1, 1, 1};
    private static final int[] END_PATTERN = {3, 1, 1};

    @Override // com.google.zxing.oned.OneDimensionalCodeWriter, com.google.zxing.Writer
    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i4, int i5, Map<EncodeHintType, ?> map) throws WriterException {
        if (barcodeFormat == BarcodeFormat.ITF) {
            return super.encode(str, barcodeFormat, i4, i5, map);
        }
        throw new IllegalArgumentException("Can only encode ITF, but got " + barcodeFormat);
    }

    @Override // com.google.zxing.oned.OneDimensionalCodeWriter
    public boolean[] encode(String str) {
        int length = str.length();
        if (length % 2 == 0) {
            if (length <= 80) {
                boolean[] zArr = new boolean[(length * 9) + 9];
                int appendPattern = OneDimensionalCodeWriter.appendPattern(zArr, 0, START_PATTERN, true);
                for (int i4 = 0; i4 < length; i4 += 2) {
                    int digit = Character.digit(str.charAt(i4), 10);
                    int digit2 = Character.digit(str.charAt(i4 + 1), 10);
                    int[] iArr = new int[18];
                    for (int i5 = 0; i5 < 5; i5++) {
                        int i6 = i5 * 2;
                        int[][] iArr2 = ITFReader.PATTERNS;
                        iArr[i6] = iArr2[digit][i5];
                        iArr[i6 + 1] = iArr2[digit2][i5];
                    }
                    appendPattern += OneDimensionalCodeWriter.appendPattern(zArr, appendPattern, iArr, true);
                }
                OneDimensionalCodeWriter.appendPattern(zArr, appendPattern, END_PATTERN, true);
                return zArr;
            }
            throw new IllegalArgumentException("Requested contents should be less than 80 digits long, but got " + length);
        }
        throw new IllegalArgumentException("The length of the input should be even");
    }
}
