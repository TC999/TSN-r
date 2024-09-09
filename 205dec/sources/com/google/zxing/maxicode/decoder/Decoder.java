package com.google.zxing.maxicode.decoder;

import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.common.reedsolomon.GenericGF;
import com.google.zxing.common.reedsolomon.ReedSolomonDecoder;
import com.google.zxing.common.reedsolomon.ReedSolomonException;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class Decoder {
    private static final int ALL = 0;
    private static final int EVEN = 1;
    private static final int ODD = 2;
    private final ReedSolomonDecoder rsDecoder = new ReedSolomonDecoder(GenericGF.MAXICODE_FIELD_64);

    private void correctErrors(byte[] bArr, int i4, int i5, int i6, int i7) throws ChecksumException {
        int i8 = i5 + i6;
        int i9 = i7 == 0 ? 1 : 2;
        int[] iArr = new int[i8 / i9];
        for (int i10 = 0; i10 < i8; i10++) {
            if (i7 == 0 || i10 % 2 == i7 - 1) {
                iArr[i10 / i9] = bArr[i10 + i4] & 255;
            }
        }
        try {
            this.rsDecoder.decode(iArr, i6 / i9);
            for (int i11 = 0; i11 < i5; i11++) {
                if (i7 == 0 || i11 % 2 == i7 - 1) {
                    bArr[i11 + i4] = (byte) iArr[i11 / i9];
                }
            }
        } catch (ReedSolomonException unused) {
            throw ChecksumException.getChecksumInstance();
        }
    }

    public DecoderResult decode(BitMatrix bitMatrix) throws ChecksumException, FormatException {
        return decode(bitMatrix, null);
    }

    public DecoderResult decode(BitMatrix bitMatrix, Map<DecodeHintType, ?> map) throws FormatException, ChecksumException {
        byte[] bArr;
        byte[] readCodewords = new BitMatrixParser(bitMatrix).readCodewords();
        correctErrors(readCodewords, 0, 10, 10, 0);
        int i4 = readCodewords[0] & 15;
        if (i4 == 2 || i4 == 3 || i4 == 4) {
            correctErrors(readCodewords, 20, 84, 40, 1);
            correctErrors(readCodewords, 20, 84, 40, 2);
            bArr = new byte[94];
        } else if (i4 == 5) {
            correctErrors(readCodewords, 20, 68, 56, 1);
            correctErrors(readCodewords, 20, 68, 56, 2);
            bArr = new byte[78];
        } else {
            throw FormatException.getFormatInstance();
        }
        System.arraycopy(readCodewords, 0, bArr, 0, 10);
        System.arraycopy(readCodewords, 20, bArr, 10, bArr.length - 10);
        return DecodedBitStreamParser.decode(bArr, i4);
    }
}
