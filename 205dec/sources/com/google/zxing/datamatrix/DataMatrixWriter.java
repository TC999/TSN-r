package com.google.zxing.datamatrix;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.Dimension;
import com.google.zxing.EncodeHintType;
import com.google.zxing.Writer;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.datamatrix.encoder.DefaultPlacement;
import com.google.zxing.datamatrix.encoder.ErrorCorrection;
import com.google.zxing.datamatrix.encoder.HighLevelEncoder;
import com.google.zxing.datamatrix.encoder.SymbolInfo;
import com.google.zxing.datamatrix.encoder.SymbolShapeHint;
import com.google.zxing.qrcode.encoder.ByteMatrix;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class DataMatrixWriter implements Writer {
    private static BitMatrix convertByteMatrixToBitMatrix(ByteMatrix byteMatrix) {
        int width = byteMatrix.getWidth();
        int height = byteMatrix.getHeight();
        BitMatrix bitMatrix = new BitMatrix(width, height);
        bitMatrix.clear();
        for (int i4 = 0; i4 < width; i4++) {
            for (int i5 = 0; i5 < height; i5++) {
                if (byteMatrix.get(i4, i5) == 1) {
                    bitMatrix.set(i4, i5);
                }
            }
        }
        return bitMatrix;
    }

    private static BitMatrix encodeLowLevel(DefaultPlacement defaultPlacement, SymbolInfo symbolInfo) {
        int symbolDataWidth = symbolInfo.getSymbolDataWidth();
        int symbolDataHeight = symbolInfo.getSymbolDataHeight();
        ByteMatrix byteMatrix = new ByteMatrix(symbolInfo.getSymbolWidth(), symbolInfo.getSymbolHeight());
        int i4 = 0;
        for (int i5 = 0; i5 < symbolDataHeight; i5++) {
            if (i5 % symbolInfo.matrixHeight == 0) {
                int i6 = 0;
                for (int i7 = 0; i7 < symbolInfo.getSymbolWidth(); i7++) {
                    byteMatrix.set(i6, i4, i7 % 2 == 0);
                    i6++;
                }
                i4++;
            }
            int i8 = 0;
            for (int i9 = 0; i9 < symbolDataWidth; i9++) {
                if (i9 % symbolInfo.matrixWidth == 0) {
                    byteMatrix.set(i8, i4, true);
                    i8++;
                }
                byteMatrix.set(i8, i4, defaultPlacement.getBit(i9, i5));
                i8++;
                int i10 = symbolInfo.matrixWidth;
                if (i9 % i10 == i10 - 1) {
                    byteMatrix.set(i8, i4, i5 % 2 == 0);
                    i8++;
                }
            }
            i4++;
            int i11 = symbolInfo.matrixHeight;
            if (i5 % i11 == i11 - 1) {
                int i12 = 0;
                for (int i13 = 0; i13 < symbolInfo.getSymbolWidth(); i13++) {
                    byteMatrix.set(i12, i4, true);
                    i12++;
                }
                i4++;
            }
        }
        return convertByteMatrixToBitMatrix(byteMatrix);
    }

    @Override // com.google.zxing.Writer
    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i4, int i5) {
        return encode(str, barcodeFormat, i4, i5, null);
    }

    @Override // com.google.zxing.Writer
    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i4, int i5, Map<EncodeHintType, ?> map) {
        Dimension dimension;
        if (!str.isEmpty()) {
            if (barcodeFormat != BarcodeFormat.DATA_MATRIX) {
                throw new IllegalArgumentException("Can only encode DATA_MATRIX, but got " + barcodeFormat);
            } else if (i4 >= 0 && i5 >= 0) {
                SymbolShapeHint symbolShapeHint = SymbolShapeHint.FORCE_NONE;
                Dimension dimension2 = null;
                if (map != null) {
                    SymbolShapeHint symbolShapeHint2 = (SymbolShapeHint) map.get(EncodeHintType.DATA_MATRIX_SHAPE);
                    if (symbolShapeHint2 != null) {
                        symbolShapeHint = symbolShapeHint2;
                    }
                    Dimension dimension3 = (Dimension) map.get(EncodeHintType.MIN_SIZE);
                    if (dimension3 == null) {
                        dimension3 = null;
                    }
                    dimension = (Dimension) map.get(EncodeHintType.MAX_SIZE);
                    if (dimension == null) {
                        dimension = null;
                    }
                    dimension2 = dimension3;
                } else {
                    dimension = null;
                }
                String encodeHighLevel = HighLevelEncoder.encodeHighLevel(str, symbolShapeHint, dimension2, dimension);
                SymbolInfo lookup = SymbolInfo.lookup(encodeHighLevel.length(), symbolShapeHint, dimension2, dimension, true);
                DefaultPlacement defaultPlacement = new DefaultPlacement(ErrorCorrection.encodeECC200(encodeHighLevel, lookup), lookup.getSymbolDataWidth(), lookup.getSymbolDataHeight());
                defaultPlacement.place();
                return encodeLowLevel(defaultPlacement, lookup);
            } else {
                throw new IllegalArgumentException("Requested dimensions are too small: " + i4 + 'x' + i5);
            }
        }
        throw new IllegalArgumentException("Found empty contents");
    }
}
