package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.common.BitArray;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
abstract class AI01decoder extends AbstractExpandedDecoder {
    static final int GTIN_SIZE = 40;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AI01decoder(BitArray bitArray) {
        super(bitArray);
    }

    private static void appendCheckDigit(StringBuilder sb, int i4) {
        int i5 = 0;
        for (int i6 = 0; i6 < 13; i6++) {
            int charAt = sb.charAt(i6 + i4) - '0';
            if ((i6 & 1) == 0) {
                charAt *= 3;
            }
            i5 += charAt;
        }
        int i7 = 10 - (i5 % 10);
        sb.append(i7 != 10 ? i7 : 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void encodeCompressedGtin(StringBuilder sb, int i4) {
        sb.append("(01)");
        int length = sb.length();
        sb.append('9');
        encodeCompressedGtinWithoutAI(sb, i4, length);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void encodeCompressedGtinWithoutAI(StringBuilder sb, int i4, int i5) {
        for (int i6 = 0; i6 < 4; i6++) {
            int extractNumericValueFromBitArray = getGeneralDecoder().extractNumericValueFromBitArray((i6 * 10) + i4, 10);
            if (extractNumericValueFromBitArray / 100 == 0) {
                sb.append('0');
            }
            if (extractNumericValueFromBitArray / 10 == 0) {
                sb.append('0');
            }
            sb.append(extractNumericValueFromBitArray);
        }
        appendCheckDigit(sb, i5);
    }
}
