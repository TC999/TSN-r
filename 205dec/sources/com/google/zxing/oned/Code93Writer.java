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
public class Code93Writer extends OneDimensionalCodeWriter {
    protected static int appendPattern(boolean[] zArr, int i4, int[] iArr, boolean z3) {
        int length = iArr.length;
        int i5 = 0;
        while (i5 < length) {
            int i6 = i4 + 1;
            zArr[i4] = iArr[i5] != 0;
            i5++;
            i4 = i6;
        }
        return 9;
    }

    private static int computeChecksumIndex(String str, int i4) {
        int i5 = 0;
        int i6 = 1;
        for (int length = str.length() - 1; length >= 0; length--) {
            i5 += "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".indexOf(str.charAt(length)) * i6;
            i6++;
            if (i6 > i4) {
                i6 = 1;
            }
        }
        return i5 % 47;
    }

    private static void toIntArray(int i4, int[] iArr) {
        for (int i5 = 0; i5 < 9; i5++) {
            int i6 = 1;
            if (((1 << (8 - i5)) & i4) == 0) {
                i6 = 0;
            }
            iArr[i5] = i6;
        }
    }

    @Override // com.google.zxing.oned.OneDimensionalCodeWriter, com.google.zxing.Writer
    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i4, int i5, Map<EncodeHintType, ?> map) throws WriterException {
        if (barcodeFormat == BarcodeFormat.CODE_93) {
            return super.encode(str, barcodeFormat, i4, i5, map);
        }
        throw new IllegalArgumentException("Can only encode CODE_93, but got " + barcodeFormat);
    }

    @Override // com.google.zxing.oned.OneDimensionalCodeWriter
    public boolean[] encode(String str) {
        int length = str.length();
        if (length <= 80) {
            int[] iArr = new int[9];
            boolean[] zArr = new boolean[((str.length() + 2 + 2) * 9) + 1];
            toIntArray(Code93Reader.CHARACTER_ENCODINGS[47], iArr);
            int appendPattern = appendPattern(zArr, 0, iArr, true);
            for (int i4 = 0; i4 < length; i4++) {
                toIntArray(Code93Reader.CHARACTER_ENCODINGS["0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".indexOf(str.charAt(i4))], iArr);
                appendPattern += appendPattern(zArr, appendPattern, iArr, true);
            }
            int computeChecksumIndex = computeChecksumIndex(str, 20);
            int[] iArr2 = Code93Reader.CHARACTER_ENCODINGS;
            toIntArray(iArr2[computeChecksumIndex], iArr);
            int appendPattern2 = appendPattern + appendPattern(zArr, appendPattern, iArr, true);
            toIntArray(iArr2[computeChecksumIndex(str + "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".charAt(computeChecksumIndex), 15)], iArr);
            int appendPattern3 = appendPattern2 + appendPattern(zArr, appendPattern2, iArr, true);
            toIntArray(iArr2[47], iArr);
            zArr[appendPattern3 + appendPattern(zArr, appendPattern3, iArr, true)] = true;
            return zArr;
        }
        throw new IllegalArgumentException("Requested contents should be less than 80 digits long, but got " + length);
    }
}
