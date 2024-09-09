package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.NotFoundException;
import com.google.zxing.common.BitArray;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class EAN8Reader extends UPCEANReader {
    private final int[] decodeMiddleCounters = new int[4];

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.zxing.oned.UPCEANReader
    public int decodeMiddle(BitArray bitArray, int[] iArr, StringBuilder sb) throws NotFoundException {
        int[] iArr2 = this.decodeMiddleCounters;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int size = bitArray.getSize();
        int i4 = iArr[1];
        for (int i5 = 0; i5 < 4 && i4 < size; i5++) {
            sb.append((char) (UPCEANReader.decodeDigit(bitArray, iArr2, i4, UPCEANReader.L_PATTERNS) + 48));
            for (int i6 : iArr2) {
                i4 += i6;
            }
        }
        int i7 = UPCEANReader.findGuardPattern(bitArray, i4, true, UPCEANReader.MIDDLE_PATTERN)[1];
        for (int i8 = 0; i8 < 4 && i7 < size; i8++) {
            sb.append((char) (UPCEANReader.decodeDigit(bitArray, iArr2, i7, UPCEANReader.L_PATTERNS) + 48));
            for (int i9 : iArr2) {
                i7 += i9;
            }
        }
        return i7;
    }

    @Override // com.google.zxing.oned.UPCEANReader
    BarcodeFormat getBarcodeFormat() {
        return BarcodeFormat.EAN_8;
    }
}
