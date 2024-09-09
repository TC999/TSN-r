package com.google.zxing.pdf417;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.Writer;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.pdf417.encoder.Compaction;
import com.google.zxing.pdf417.encoder.Dimensions;
import com.google.zxing.pdf417.encoder.PDF417;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class PDF417Writer implements Writer {
    static final int DEFAULT_ERROR_CORRECTION_LEVEL = 2;
    static final int WHITE_SPACE = 30;

    private static BitMatrix bitMatrixFromEncoder(PDF417 pdf417, String str, int i4, int i5, int i6, int i7) throws WriterException {
        boolean z3;
        pdf417.generateBarcodeLogic(str, i4);
        byte[][] scaledMatrix = pdf417.getBarcodeMatrix().getScaledMatrix(1, 4);
        if ((i6 > i5) ^ (scaledMatrix[0].length < scaledMatrix.length)) {
            scaledMatrix = rotateArray(scaledMatrix);
            z3 = true;
        } else {
            z3 = false;
        }
        int length = i5 / scaledMatrix[0].length;
        int length2 = i6 / scaledMatrix.length;
        if (length >= length2) {
            length = length2;
        }
        if (length > 1) {
            byte[][] scaledMatrix2 = pdf417.getBarcodeMatrix().getScaledMatrix(length, length << 2);
            if (z3) {
                scaledMatrix2 = rotateArray(scaledMatrix2);
            }
            return bitMatrixFrombitArray(scaledMatrix2, i7);
        }
        return bitMatrixFrombitArray(scaledMatrix, i7);
    }

    private static BitMatrix bitMatrixFrombitArray(byte[][] bArr, int i4) {
        int i5 = i4 * 2;
        BitMatrix bitMatrix = new BitMatrix(bArr[0].length + i5, bArr.length + i5);
        bitMatrix.clear();
        int height = (bitMatrix.getHeight() - i4) - 1;
        int i6 = 0;
        while (i6 < bArr.length) {
            for (int i7 = 0; i7 < bArr[0].length; i7++) {
                if (bArr[i6][i7] == 1) {
                    bitMatrix.set(i7 + i4, height);
                }
            }
            i6++;
            height--;
        }
        return bitMatrix;
    }

    private static byte[][] rotateArray(byte[][] bArr) {
        byte[][] bArr2 = (byte[][]) Array.newInstance(byte.class, bArr[0].length, bArr.length);
        for (int i4 = 0; i4 < bArr.length; i4++) {
            int length = (bArr.length - i4) - 1;
            for (int i5 = 0; i5 < bArr[0].length; i5++) {
                bArr2[i5][length] = bArr[i4][i5];
            }
        }
        return bArr2;
    }

    @Override // com.google.zxing.Writer
    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i4, int i5, Map<EncodeHintType, ?> map) throws WriterException {
        int i6;
        int i7;
        if (barcodeFormat == BarcodeFormat.PDF_417) {
            PDF417 pdf417 = new PDF417();
            if (map != null) {
                EncodeHintType encodeHintType = EncodeHintType.PDF417_COMPACT;
                if (map.containsKey(encodeHintType)) {
                    pdf417.setCompact(Boolean.valueOf(map.get(encodeHintType).toString()).booleanValue());
                }
                EncodeHintType encodeHintType2 = EncodeHintType.PDF417_COMPACTION;
                if (map.containsKey(encodeHintType2)) {
                    pdf417.setCompaction(Compaction.valueOf(map.get(encodeHintType2).toString()));
                }
                EncodeHintType encodeHintType3 = EncodeHintType.PDF417_DIMENSIONS;
                if (map.containsKey(encodeHintType3)) {
                    Dimensions dimensions = (Dimensions) map.get(encodeHintType3);
                    pdf417.setDimensions(dimensions.getMaxCols(), dimensions.getMinCols(), dimensions.getMaxRows(), dimensions.getMinRows());
                }
                EncodeHintType encodeHintType4 = EncodeHintType.MARGIN;
                int parseInt = map.containsKey(encodeHintType4) ? Integer.parseInt(map.get(encodeHintType4).toString()) : 30;
                EncodeHintType encodeHintType5 = EncodeHintType.ERROR_CORRECTION;
                int parseInt2 = map.containsKey(encodeHintType5) ? Integer.parseInt(map.get(encodeHintType5).toString()) : 2;
                EncodeHintType encodeHintType6 = EncodeHintType.CHARACTER_SET;
                if (map.containsKey(encodeHintType6)) {
                    pdf417.setEncoding(Charset.forName(map.get(encodeHintType6).toString()));
                }
                i7 = parseInt;
                i6 = parseInt2;
            } else {
                i6 = 2;
                i7 = 30;
            }
            return bitMatrixFromEncoder(pdf417, str, i6, i4, i5, i7);
        }
        throw new IllegalArgumentException("Can only encode PDF_417, but got " + barcodeFormat);
    }

    @Override // com.google.zxing.Writer
    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i4, int i5) throws WriterException {
        return encode(str, barcodeFormat, i4, i5, null);
    }
}
