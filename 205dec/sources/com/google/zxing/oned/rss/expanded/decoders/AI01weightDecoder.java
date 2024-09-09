package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.common.BitArray;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
abstract class AI01weightDecoder extends AI01decoder {
    /* JADX INFO: Access modifiers changed from: package-private */
    public AI01weightDecoder(BitArray bitArray) {
        super(bitArray);
    }

    protected abstract void addWeightCode(StringBuilder sb, int i4);

    protected abstract int checkWeight(int i4);

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void encodeCompressedWeight(StringBuilder sb, int i4, int i5) {
        int extractNumericValueFromBitArray = getGeneralDecoder().extractNumericValueFromBitArray(i4, i5);
        addWeightCode(sb, extractNumericValueFromBitArray);
        int checkWeight = checkWeight(extractNumericValueFromBitArray);
        int i6 = 100000;
        for (int i7 = 0; i7 < 5; i7++) {
            if (checkWeight / i6 == 0) {
                sb.append('0');
            }
            i6 /= 10;
        }
        sb.append(checkWeight);
    }
}
