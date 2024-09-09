package com.google.zxing.qrcode.decoder;

import com.google.zxing.FormatException;
import com.google.zxing.common.BitMatrix;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
final class BitMatrixParser {
    private final BitMatrix bitMatrix;
    private boolean mirror;
    private FormatInformation parsedFormatInfo;
    private Version parsedVersion;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BitMatrixParser(BitMatrix bitMatrix) throws FormatException {
        int height = bitMatrix.getHeight();
        if (height >= 21 && (height & 3) == 1) {
            this.bitMatrix = bitMatrix;
            return;
        }
        throw FormatException.getFormatInstance();
    }

    private int copyBit(int i4, int i5, int i6) {
        return this.mirror ? this.bitMatrix.get(i5, i4) : this.bitMatrix.get(i4, i5) ? (i6 << 1) | 1 : i6 << 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void mirror() {
        int i4 = 0;
        while (i4 < this.bitMatrix.getWidth()) {
            int i5 = i4 + 1;
            for (int i6 = i5; i6 < this.bitMatrix.getHeight(); i6++) {
                if (this.bitMatrix.get(i4, i6) != this.bitMatrix.get(i6, i4)) {
                    this.bitMatrix.flip(i6, i4);
                    this.bitMatrix.flip(i4, i6);
                }
            }
            i4 = i5;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] readCodewords() throws FormatException {
        FormatInformation readFormatInformation = readFormatInformation();
        Version readVersion = readVersion();
        DataMask dataMask = DataMask.values()[readFormatInformation.getDataMask()];
        int height = this.bitMatrix.getHeight();
        dataMask.unmaskBitMatrix(this.bitMatrix, height);
        BitMatrix buildFunctionPattern = readVersion.buildFunctionPattern();
        byte[] bArr = new byte[readVersion.getTotalCodewords()];
        int i4 = height - 1;
        boolean z3 = true;
        int i5 = i4;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        while (i5 > 0) {
            if (i5 == 6) {
                i5--;
            }
            for (int i9 = 0; i9 < height; i9++) {
                int i10 = z3 ? i4 - i9 : i9;
                for (int i11 = 0; i11 < 2; i11++) {
                    int i12 = i5 - i11;
                    if (!buildFunctionPattern.get(i12, i10)) {
                        i7++;
                        i8 <<= 1;
                        if (this.bitMatrix.get(i12, i10)) {
                            i8 |= 1;
                        }
                        if (i7 == 8) {
                            bArr[i6] = (byte) i8;
                            i6++;
                            i7 = 0;
                            i8 = 0;
                        }
                    }
                }
            }
            z3 = !z3;
            i5 -= 2;
        }
        if (i6 == readVersion.getTotalCodewords()) {
            return bArr;
        }
        throw FormatException.getFormatInstance();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FormatInformation readFormatInformation() throws FormatException {
        FormatInformation formatInformation = this.parsedFormatInfo;
        if (formatInformation != null) {
            return formatInformation;
        }
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 0; i6 < 6; i6++) {
            i5 = copyBit(i6, 8, i5);
        }
        int copyBit = copyBit(8, 7, copyBit(8, 8, copyBit(7, 8, i5)));
        for (int i7 = 5; i7 >= 0; i7--) {
            copyBit = copyBit(8, i7, copyBit);
        }
        int height = this.bitMatrix.getHeight();
        int i8 = height - 7;
        for (int i9 = height - 1; i9 >= i8; i9--) {
            i4 = copyBit(8, i9, i4);
        }
        for (int i10 = height - 8; i10 < height; i10++) {
            i4 = copyBit(i10, 8, i4);
        }
        FormatInformation decodeFormatInformation = FormatInformation.decodeFormatInformation(copyBit, i4);
        this.parsedFormatInfo = decodeFormatInformation;
        if (decodeFormatInformation != null) {
            return decodeFormatInformation;
        }
        throw FormatException.getFormatInstance();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Version readVersion() throws FormatException {
        Version version = this.parsedVersion;
        if (version != null) {
            return version;
        }
        int height = this.bitMatrix.getHeight();
        int i4 = (height - 17) / 4;
        if (i4 <= 6) {
            return Version.getVersionForNumber(i4);
        }
        int i5 = height - 11;
        int i6 = 0;
        int i7 = 0;
        for (int i8 = 5; i8 >= 0; i8--) {
            for (int i9 = height - 9; i9 >= i5; i9--) {
                i7 = copyBit(i9, i8, i7);
            }
        }
        Version decodeVersionInformation = Version.decodeVersionInformation(i7);
        if (decodeVersionInformation != null && decodeVersionInformation.getDimensionForVersion() == height) {
            this.parsedVersion = decodeVersionInformation;
            return decodeVersionInformation;
        }
        for (int i10 = 5; i10 >= 0; i10--) {
            for (int i11 = height - 9; i11 >= i5; i11--) {
                i6 = copyBit(i10, i11, i6);
            }
        }
        Version decodeVersionInformation2 = Version.decodeVersionInformation(i6);
        if (decodeVersionInformation2 != null && decodeVersionInformation2.getDimensionForVersion() == height) {
            this.parsedVersion = decodeVersionInformation2;
            return decodeVersionInformation2;
        }
        throw FormatException.getFormatInstance();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void remask() {
        if (this.parsedFormatInfo == null) {
            return;
        }
        DataMask.values()[this.parsedFormatInfo.getDataMask()].unmaskBitMatrix(this.bitMatrix, this.bitMatrix.getHeight());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMirror(boolean z3) {
        this.parsedVersion = null;
        this.parsedFormatInfo = null;
        this.mirror = z3;
    }
}
