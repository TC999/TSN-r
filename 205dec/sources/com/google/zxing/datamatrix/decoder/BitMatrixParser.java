package com.google.zxing.datamatrix.decoder;

import com.google.zxing.FormatException;
import com.google.zxing.common.BitMatrix;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
final class BitMatrixParser {
    private final BitMatrix mappingBitMatrix;
    private final BitMatrix readMappingMatrix;
    private final Version version;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BitMatrixParser(BitMatrix bitMatrix) throws FormatException {
        int height = bitMatrix.getHeight();
        if (height >= 8 && height <= 144 && (height & 1) == 0) {
            this.version = readVersion(bitMatrix);
            BitMatrix extractDataRegion = extractDataRegion(bitMatrix);
            this.mappingBitMatrix = extractDataRegion;
            this.readMappingMatrix = new BitMatrix(extractDataRegion.getWidth(), extractDataRegion.getHeight());
            return;
        }
        throw FormatException.getFormatInstance();
    }

    private BitMatrix extractDataRegion(BitMatrix bitMatrix) {
        int symbolSizeRows = this.version.getSymbolSizeRows();
        int symbolSizeColumns = this.version.getSymbolSizeColumns();
        if (bitMatrix.getHeight() == symbolSizeRows) {
            int dataRegionSizeRows = this.version.getDataRegionSizeRows();
            int dataRegionSizeColumns = this.version.getDataRegionSizeColumns();
            int i4 = symbolSizeRows / dataRegionSizeRows;
            int i5 = symbolSizeColumns / dataRegionSizeColumns;
            BitMatrix bitMatrix2 = new BitMatrix(i5 * dataRegionSizeColumns, i4 * dataRegionSizeRows);
            for (int i6 = 0; i6 < i4; i6++) {
                int i7 = i6 * dataRegionSizeRows;
                for (int i8 = 0; i8 < i5; i8++) {
                    int i9 = i8 * dataRegionSizeColumns;
                    for (int i10 = 0; i10 < dataRegionSizeRows; i10++) {
                        int i11 = ((dataRegionSizeRows + 2) * i6) + 1 + i10;
                        int i12 = i7 + i10;
                        for (int i13 = 0; i13 < dataRegionSizeColumns; i13++) {
                            if (bitMatrix.get(((dataRegionSizeColumns + 2) * i8) + 1 + i13, i11)) {
                                bitMatrix2.set(i9 + i13, i12);
                            }
                        }
                    }
                }
            }
            return bitMatrix2;
        }
        throw new IllegalArgumentException("Dimension of bitMarix must match the version size");
    }

    private int readCorner1(int i4, int i5) {
        int i6 = i4 - 1;
        int i7 = (readModule(i6, 0, i4, i5) ? 1 : 0) << 1;
        if (readModule(i6, 1, i4, i5)) {
            i7 |= 1;
        }
        int i8 = i7 << 1;
        if (readModule(i6, 2, i4, i5)) {
            i8 |= 1;
        }
        int i9 = i8 << 1;
        if (readModule(0, i5 - 2, i4, i5)) {
            i9 |= 1;
        }
        int i10 = i9 << 1;
        int i11 = i5 - 1;
        if (readModule(0, i11, i4, i5)) {
            i10 |= 1;
        }
        int i12 = i10 << 1;
        if (readModule(1, i11, i4, i5)) {
            i12 |= 1;
        }
        int i13 = i12 << 1;
        if (readModule(2, i11, i4, i5)) {
            i13 |= 1;
        }
        int i14 = i13 << 1;
        return readModule(3, i11, i4, i5) ? i14 | 1 : i14;
    }

    private int readCorner2(int i4, int i5) {
        int i6 = (readModule(i4 + (-3), 0, i4, i5) ? 1 : 0) << 1;
        if (readModule(i4 - 2, 0, i4, i5)) {
            i6 |= 1;
        }
        int i7 = i6 << 1;
        if (readModule(i4 - 1, 0, i4, i5)) {
            i7 |= 1;
        }
        int i8 = i7 << 1;
        if (readModule(0, i5 - 4, i4, i5)) {
            i8 |= 1;
        }
        int i9 = i8 << 1;
        if (readModule(0, i5 - 3, i4, i5)) {
            i9 |= 1;
        }
        int i10 = i9 << 1;
        if (readModule(0, i5 - 2, i4, i5)) {
            i10 |= 1;
        }
        int i11 = i10 << 1;
        int i12 = i5 - 1;
        if (readModule(0, i12, i4, i5)) {
            i11 |= 1;
        }
        int i13 = i11 << 1;
        return readModule(1, i12, i4, i5) ? i13 | 1 : i13;
    }

    private int readCorner3(int i4, int i5) {
        int i6 = i4 - 1;
        int i7 = (readModule(i6, 0, i4, i5) ? 1 : 0) << 1;
        int i8 = i5 - 1;
        if (readModule(i6, i8, i4, i5)) {
            i7 |= 1;
        }
        int i9 = i7 << 1;
        int i10 = i5 - 3;
        if (readModule(0, i10, i4, i5)) {
            i9 |= 1;
        }
        int i11 = i9 << 1;
        int i12 = i5 - 2;
        if (readModule(0, i12, i4, i5)) {
            i11 |= 1;
        }
        int i13 = i11 << 1;
        if (readModule(0, i8, i4, i5)) {
            i13 |= 1;
        }
        int i14 = i13 << 1;
        if (readModule(1, i10, i4, i5)) {
            i14 |= 1;
        }
        int i15 = i14 << 1;
        if (readModule(1, i12, i4, i5)) {
            i15 |= 1;
        }
        int i16 = i15 << 1;
        return readModule(1, i8, i4, i5) ? i16 | 1 : i16;
    }

    private int readCorner4(int i4, int i5) {
        int i6 = (readModule(i4 + (-3), 0, i4, i5) ? 1 : 0) << 1;
        if (readModule(i4 - 2, 0, i4, i5)) {
            i6 |= 1;
        }
        int i7 = i6 << 1;
        if (readModule(i4 - 1, 0, i4, i5)) {
            i7 |= 1;
        }
        int i8 = i7 << 1;
        if (readModule(0, i5 - 2, i4, i5)) {
            i8 |= 1;
        }
        int i9 = i8 << 1;
        int i10 = i5 - 1;
        if (readModule(0, i10, i4, i5)) {
            i9 |= 1;
        }
        int i11 = i9 << 1;
        if (readModule(1, i10, i4, i5)) {
            i11 |= 1;
        }
        int i12 = i11 << 1;
        if (readModule(2, i10, i4, i5)) {
            i12 |= 1;
        }
        int i13 = i12 << 1;
        return readModule(3, i10, i4, i5) ? i13 | 1 : i13;
    }

    private boolean readModule(int i4, int i5, int i6, int i7) {
        if (i4 < 0) {
            i4 += i6;
            i5 += 4 - ((i6 + 4) & 7);
        }
        if (i5 < 0) {
            i5 += i7;
            i4 += 4 - ((i7 + 4) & 7);
        }
        this.readMappingMatrix.set(i5, i4);
        return this.mappingBitMatrix.get(i5, i4);
    }

    private int readUtah(int i4, int i5, int i6, int i7) {
        int i8 = i4 - 2;
        int i9 = i5 - 2;
        int i10 = (readModule(i8, i9, i6, i7) ? 1 : 0) << 1;
        int i11 = i5 - 1;
        if (readModule(i8, i11, i6, i7)) {
            i10 |= 1;
        }
        int i12 = i10 << 1;
        int i13 = i4 - 1;
        if (readModule(i13, i9, i6, i7)) {
            i12 |= 1;
        }
        int i14 = i12 << 1;
        if (readModule(i13, i11, i6, i7)) {
            i14 |= 1;
        }
        int i15 = i14 << 1;
        if (readModule(i13, i5, i6, i7)) {
            i15 |= 1;
        }
        int i16 = i15 << 1;
        if (readModule(i4, i9, i6, i7)) {
            i16 |= 1;
        }
        int i17 = i16 << 1;
        if (readModule(i4, i11, i6, i7)) {
            i17 |= 1;
        }
        int i18 = i17 << 1;
        return readModule(i4, i5, i6, i7) ? i18 | 1 : i18;
    }

    private static Version readVersion(BitMatrix bitMatrix) throws FormatException {
        return Version.getVersionForDimensions(bitMatrix.getHeight(), bitMatrix.getWidth());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Version getVersion() {
        return this.version;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] readCodewords() throws FormatException {
        byte[] bArr = new byte[this.version.getTotalCodewords()];
        int height = this.mappingBitMatrix.getHeight();
        int width = this.mappingBitMatrix.getWidth();
        int i4 = 0;
        boolean z3 = false;
        int i5 = 0;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        int i6 = 4;
        while (true) {
            if (i6 == height && i4 == 0 && !z3) {
                bArr[i5] = (byte) readCorner1(height, width);
                i6 -= 2;
                i4 += 2;
                i5++;
                z3 = true;
            } else {
                int i7 = height - 2;
                if (i6 == i7 && i4 == 0 && (width & 3) != 0 && !z4) {
                    bArr[i5] = (byte) readCorner2(height, width);
                    i6 -= 2;
                    i4 += 2;
                    i5++;
                    z4 = true;
                } else if (i6 == height + 4 && i4 == 2 && (width & 7) == 0 && !z5) {
                    bArr[i5] = (byte) readCorner3(height, width);
                    i6 -= 2;
                    i4 += 2;
                    i5++;
                    z5 = true;
                } else if (i6 == i7 && i4 == 0 && (width & 7) == 4 && !z6) {
                    bArr[i5] = (byte) readCorner4(height, width);
                    i6 -= 2;
                    i4 += 2;
                    i5++;
                    z6 = true;
                } else {
                    do {
                        if (i6 < height && i4 >= 0 && !this.readMappingMatrix.get(i4, i6)) {
                            bArr[i5] = (byte) readUtah(i6, i4, height, width);
                            i5++;
                        }
                        i6 -= 2;
                        i4 += 2;
                        if (i6 < 0) {
                            break;
                        }
                    } while (i4 < width);
                    int i8 = i6 + 1;
                    int i9 = i4 + 3;
                    do {
                        if (i8 >= 0 && i9 < width && !this.readMappingMatrix.get(i9, i8)) {
                            bArr[i5] = (byte) readUtah(i8, i9, height, width);
                            i5++;
                        }
                        i8 += 2;
                        i9 -= 2;
                        if (i8 >= height) {
                            break;
                        }
                    } while (i9 >= 0);
                    i6 = i8 + 3;
                    i4 = i9 + 1;
                }
            }
            if (i6 >= height && i4 >= width) {
                break;
            }
        }
        if (i5 == this.version.getTotalCodewords()) {
            return bArr;
        }
        throw FormatException.getFormatInstance();
    }
}
