package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import java.util.Map;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class EAN13Writer extends UPCEANWriter {
    private static final int CODE_WIDTH = 95;

    @Override // com.google.zxing.oned.OneDimensionalCodeWriter, com.google.zxing.Writer
    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<EncodeHintType, ?> map) throws WriterException {
        if (barcodeFormat == BarcodeFormat.EAN_13) {
            return super.encode(str, barcodeFormat, i, i2, map);
        }
        throw new IllegalArgumentException("Can only encode EAN_13, but got " + barcodeFormat);
    }

    @Override // com.google.zxing.oned.OneDimensionalCodeWriter
    public boolean[] encode(String str) {
        if (str.length() == 13) {
            try {
                if (UPCEANReader.checkStandardUPCEANChecksum(str)) {
                    int i = EAN13Reader.FIRST_DIGIT_ENCODINGS[Integer.parseInt(str.substring(0, 1))];
                    boolean[] zArr = new boolean[95];
                    int appendPattern = OneDimensionalCodeWriter.appendPattern(zArr, 0, UPCEANReader.START_END_PATTERN, true) + 0;
                    int i2 = 1;
                    while (i2 <= 6) {
                        int i3 = i2 + 1;
                        int parseInt = Integer.parseInt(str.substring(i2, i3));
                        if (((i >> (6 - i2)) & 1) == 1) {
                            parseInt += 10;
                        }
                        appendPattern += OneDimensionalCodeWriter.appendPattern(zArr, appendPattern, UPCEANReader.L_AND_G_PATTERNS[parseInt], false);
                        i2 = i3;
                    }
                    int appendPattern2 = appendPattern + OneDimensionalCodeWriter.appendPattern(zArr, appendPattern, UPCEANReader.MIDDLE_PATTERN, false);
                    int i4 = 7;
                    while (i4 <= 12) {
                        int i5 = i4 + 1;
                        appendPattern2 += OneDimensionalCodeWriter.appendPattern(zArr, appendPattern2, UPCEANReader.L_PATTERNS[Integer.parseInt(str.substring(i4, i5))], true);
                        i4 = i5;
                    }
                    OneDimensionalCodeWriter.appendPattern(zArr, appendPattern2, UPCEANReader.START_END_PATTERN, true);
                    return zArr;
                }
                throw new IllegalArgumentException("Contents do not pass checksum");
            } catch (FormatException unused) {
                throw new IllegalArgumentException("Illegal contents");
            }
        }
        throw new IllegalArgumentException("Requested contents should be 13 digits long, but got " + str.length());
    }
}
