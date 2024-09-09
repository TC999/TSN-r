package com.google.zxing.qrcode;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.Writer;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.encoder.ByteMatrix;
import com.google.zxing.qrcode.encoder.Encoder;
import com.google.zxing.qrcode.encoder.QRCode;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class QRCodeWriter implements Writer {
    private static final int QUIET_ZONE_SIZE = 4;

    private static BitMatrix renderResult(QRCode qRCode, int i4, int i5, int i6) {
        ByteMatrix matrix = qRCode.getMatrix();
        if (matrix != null) {
            int width = matrix.getWidth();
            int height = matrix.getHeight();
            int i7 = i6 << 1;
            int i8 = width + i7;
            int i9 = i7 + height;
            int max = Math.max(i4, i8);
            int max2 = Math.max(i5, i9);
            int min = Math.min(max / i8, max2 / i9);
            int i10 = (max - (width * min)) / 2;
            int i11 = (max2 - (height * min)) / 2;
            BitMatrix bitMatrix = new BitMatrix(max, max2);
            int i12 = 0;
            while (i12 < height) {
                int i13 = i10;
                int i14 = 0;
                while (i14 < width) {
                    if (matrix.get(i14, i12) == 1) {
                        bitMatrix.setRegion(i13, i11, min, min);
                    }
                    i14++;
                    i13 += min;
                }
                i12++;
                i11 += min;
            }
            return bitMatrix;
        }
        throw new IllegalStateException();
    }

    @Override // com.google.zxing.Writer
    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i4, int i5) throws WriterException {
        return encode(str, barcodeFormat, i4, i5, null);
    }

    @Override // com.google.zxing.Writer
    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i4, int i5, Map<EncodeHintType, ?> map) throws WriterException {
        if (!str.isEmpty()) {
            if (barcodeFormat != BarcodeFormat.QR_CODE) {
                throw new IllegalArgumentException("Can only encode QR_CODE, but got " + barcodeFormat);
            } else if (i4 >= 0 && i5 >= 0) {
                ErrorCorrectionLevel errorCorrectionLevel = ErrorCorrectionLevel.L;
                int i6 = 4;
                if (map != null) {
                    EncodeHintType encodeHintType = EncodeHintType.ERROR_CORRECTION;
                    if (map.containsKey(encodeHintType)) {
                        errorCorrectionLevel = ErrorCorrectionLevel.valueOf(map.get(encodeHintType).toString());
                    }
                    EncodeHintType encodeHintType2 = EncodeHintType.MARGIN;
                    if (map.containsKey(encodeHintType2)) {
                        i6 = Integer.parseInt(map.get(encodeHintType2).toString());
                    }
                }
                return renderResult(Encoder.encode(str, errorCorrectionLevel, map), i4, i5, i6);
            } else {
                throw new IllegalArgumentException("Requested dimensions are too small: " + i4 + 'x' + i5);
            }
        }
        throw new IllegalArgumentException("Found empty contents");
    }
}
