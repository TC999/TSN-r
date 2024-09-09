package com.google.zxing.aztec;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.Writer;
import com.google.zxing.aztec.encoder.AztecCode;
import com.google.zxing.aztec.encoder.Encoder;
import com.google.zxing.common.BitMatrix;
import java.nio.charset.Charset;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class AztecWriter implements Writer {
    private static final Charset DEFAULT_CHARSET = Charset.forName("ISO-8859-1");

    private static BitMatrix renderResult(AztecCode aztecCode, int i4, int i5) {
        BitMatrix matrix = aztecCode.getMatrix();
        if (matrix != null) {
            int width = matrix.getWidth();
            int height = matrix.getHeight();
            int max = Math.max(i4, width);
            int max2 = Math.max(i5, height);
            int min = Math.min(max / width, max2 / height);
            int i6 = (max - (width * min)) / 2;
            int i7 = (max2 - (height * min)) / 2;
            BitMatrix bitMatrix = new BitMatrix(max, max2);
            int i8 = 0;
            while (i8 < height) {
                int i9 = i6;
                int i10 = 0;
                while (i10 < width) {
                    if (matrix.get(i10, i8)) {
                        bitMatrix.setRegion(i9, i7, min, min);
                    }
                    i10++;
                    i9 += min;
                }
                i8++;
                i7 += min;
            }
            return bitMatrix;
        }
        throw new IllegalStateException();
    }

    @Override // com.google.zxing.Writer
    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i4, int i5) {
        return encode(str, barcodeFormat, i4, i5, null);
    }

    @Override // com.google.zxing.Writer
    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i4, int i5, Map<EncodeHintType, ?> map) {
        Charset charset;
        int i6;
        int i7;
        Charset charset2 = DEFAULT_CHARSET;
        if (map != null) {
            EncodeHintType encodeHintType = EncodeHintType.CHARACTER_SET;
            if (map.containsKey(encodeHintType)) {
                charset2 = Charset.forName(map.get(encodeHintType).toString());
            }
            EncodeHintType encodeHintType2 = EncodeHintType.ERROR_CORRECTION;
            int parseInt = map.containsKey(encodeHintType2) ? Integer.parseInt(map.get(encodeHintType2).toString()) : 33;
            EncodeHintType encodeHintType3 = EncodeHintType.AZTEC_LAYERS;
            if (map.containsKey(encodeHintType3)) {
                charset = charset2;
                i6 = parseInt;
                i7 = Integer.parseInt(map.get(encodeHintType3).toString());
                return encode(str, barcodeFormat, i4, i5, charset, i6, i7);
            }
            charset = charset2;
            i6 = parseInt;
        } else {
            charset = charset2;
            i6 = 33;
        }
        i7 = 0;
        return encode(str, barcodeFormat, i4, i5, charset, i6, i7);
    }

    private static BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i4, int i5, Charset charset, int i6, int i7) {
        if (barcodeFormat == BarcodeFormat.AZTEC) {
            return renderResult(Encoder.encode(str.getBytes(charset), i6, i7), i4, i5);
        }
        throw new IllegalArgumentException("Can only encode AZTEC, but got " + barcodeFormat);
    }
}
