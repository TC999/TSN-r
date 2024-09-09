package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.NotFoundException;
import com.google.zxing.common.BitArray;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class AI013x0x1xDecoder extends AI01weightDecoder {
    private static final int DATE_SIZE = 16;
    private static final int HEADER_SIZE = 8;
    private static final int WEIGHT_SIZE = 20;
    private final String dateCode;
    private final String firstAIdigits;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AI013x0x1xDecoder(BitArray bitArray, String str, String str2) {
        super(bitArray);
        this.dateCode = str2;
        this.firstAIdigits = str;
    }

    private void encodeCompressedDate(StringBuilder sb, int i4) {
        int extractNumericValueFromBitArray = getGeneralDecoder().extractNumericValueFromBitArray(i4, 16);
        if (extractNumericValueFromBitArray == 38400) {
            return;
        }
        sb.append('(');
        sb.append(this.dateCode);
        sb.append(')');
        int i5 = extractNumericValueFromBitArray % 32;
        int i6 = extractNumericValueFromBitArray / 32;
        int i7 = (i6 % 12) + 1;
        int i8 = i6 / 12;
        if (i8 / 10 == 0) {
            sb.append('0');
        }
        sb.append(i8);
        if (i7 / 10 == 0) {
            sb.append('0');
        }
        sb.append(i7);
        if (i5 / 10 == 0) {
            sb.append('0');
        }
        sb.append(i5);
    }

    @Override // com.google.zxing.oned.rss.expanded.decoders.AI01weightDecoder
    protected void addWeightCode(StringBuilder sb, int i4) {
        sb.append('(');
        sb.append(this.firstAIdigits);
        sb.append(i4 / 100000);
        sb.append(')');
    }

    @Override // com.google.zxing.oned.rss.expanded.decoders.AI01weightDecoder
    protected int checkWeight(int i4) {
        return i4 % 100000;
    }

    @Override // com.google.zxing.oned.rss.expanded.decoders.AbstractExpandedDecoder
    public String parseInformation() throws NotFoundException {
        if (getInformation().getSize() == 84) {
            StringBuilder sb = new StringBuilder();
            encodeCompressedGtin(sb, 8);
            encodeCompressedWeight(sb, 48, 20);
            encodeCompressedDate(sb, 68);
            return sb.toString();
        }
        throw NotFoundException.getNotFoundInstance();
    }
}
