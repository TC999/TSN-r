package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.Writer;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public abstract class OneDimensionalCodeWriter implements Writer {
    /* JADX INFO: Access modifiers changed from: protected */
    public static int appendPattern(boolean[] zArr, int i4, int[] iArr, boolean z3) {
        int i5 = 0;
        for (int i6 : iArr) {
            int i7 = 0;
            while (i7 < i6) {
                zArr[i4] = z3;
                i7++;
                i4++;
            }
            i5 += i6;
            z3 = !z3;
        }
        return i5;
    }

    private static BitMatrix renderResult(boolean[] zArr, int i4, int i5, int i6) {
        int length = zArr.length;
        int i7 = i6 + length;
        int max = Math.max(i4, i7);
        int max2 = Math.max(1, i5);
        int i8 = max / i7;
        int i9 = (max - (length * i8)) / 2;
        BitMatrix bitMatrix = new BitMatrix(max, max2);
        int i10 = 0;
        while (i10 < length) {
            if (zArr[i10]) {
                bitMatrix.setRegion(i9, 0, i8, max2);
            }
            i10++;
            i9 += i8;
        }
        return bitMatrix;
    }

    @Override // com.google.zxing.Writer
    public final BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i4, int i5) throws WriterException {
        return encode(str, barcodeFormat, i4, i5, null);
    }

    public abstract boolean[] encode(String str);

    public int getDefaultMargin() {
        return 10;
    }

    @Override // com.google.zxing.Writer
    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i4, int i5, Map<EncodeHintType, ?> map) throws WriterException {
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Found empty contents");
        }
        if (i4 >= 0 && i5 >= 0) {
            int defaultMargin = getDefaultMargin();
            if (map != null) {
                EncodeHintType encodeHintType = EncodeHintType.MARGIN;
                if (map.containsKey(encodeHintType)) {
                    defaultMargin = Integer.parseInt(map.get(encodeHintType).toString());
                }
            }
            return renderResult(encode(str), i4, i5, defaultMargin);
        }
        throw new IllegalArgumentException("Negative size is not allowed. Input: " + i4 + 'x' + i5);
    }
}
