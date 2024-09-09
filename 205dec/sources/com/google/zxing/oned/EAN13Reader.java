package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.NotFoundException;
import com.google.zxing.common.BitArray;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class EAN13Reader extends UPCEANReader {
    static final int[] FIRST_DIGIT_ENCODINGS = {0, 11, 13, 14, 19, 25, 28, 21, 22, 26};
    private final int[] decodeMiddleCounters = new int[4];

    private static void determineFirstDigit(StringBuilder sb, int i4) throws NotFoundException {
        for (int i5 = 0; i5 < 10; i5++) {
            if (i4 == FIRST_DIGIT_ENCODINGS[i5]) {
                sb.insert(0, (char) (i5 + 48));
                return;
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    @Override // com.google.zxing.oned.UPCEANReader
    protected int decodeMiddle(BitArray bitArray, int[] iArr, StringBuilder sb) throws NotFoundException {
        int[] iArr2 = this.decodeMiddleCounters;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int size = bitArray.getSize();
        int i4 = iArr[1];
        int i5 = 0;
        for (int i6 = 0; i6 < 6 && i4 < size; i6++) {
            int decodeDigit = UPCEANReader.decodeDigit(bitArray, iArr2, i4, UPCEANReader.L_AND_G_PATTERNS);
            sb.append((char) ((decodeDigit % 10) + 48));
            for (int i7 : iArr2) {
                i4 += i7;
            }
            if (decodeDigit >= 10) {
                i5 |= 1 << (5 - i6);
            }
        }
        determineFirstDigit(sb, i5);
        int i8 = UPCEANReader.findGuardPattern(bitArray, i4, true, UPCEANReader.MIDDLE_PATTERN)[1];
        for (int i9 = 0; i9 < 6 && i8 < size; i9++) {
            sb.append((char) (UPCEANReader.decodeDigit(bitArray, iArr2, i8, UPCEANReader.L_PATTERNS) + 48));
            for (int i10 : iArr2) {
                i8 += i10;
            }
        }
        return i8;
    }

    @Override // com.google.zxing.oned.UPCEANReader
    BarcodeFormat getBarcodeFormat() {
        return BarcodeFormat.EAN_13;
    }
}
