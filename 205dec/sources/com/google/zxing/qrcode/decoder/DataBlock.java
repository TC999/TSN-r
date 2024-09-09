package com.google.zxing.qrcode.decoder;

import com.google.zxing.qrcode.decoder.Version;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
final class DataBlock {
    private final byte[] codewords;
    private final int numDataCodewords;

    private DataBlock(int i4, byte[] bArr) {
        this.numDataCodewords = i4;
        this.codewords = bArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static DataBlock[] getDataBlocks(byte[] bArr, Version version, ErrorCorrectionLevel errorCorrectionLevel) {
        if (bArr.length == version.getTotalCodewords()) {
            Version.ECBlocks eCBlocksForLevel = version.getECBlocksForLevel(errorCorrectionLevel);
            Version.ECB[] eCBlocks = eCBlocksForLevel.getECBlocks();
            int i4 = 0;
            for (Version.ECB ecb : eCBlocks) {
                i4 += ecb.getCount();
            }
            DataBlock[] dataBlockArr = new DataBlock[i4];
            int i5 = 0;
            for (Version.ECB ecb2 : eCBlocks) {
                int i6 = 0;
                while (i6 < ecb2.getCount()) {
                    int dataCodewords = ecb2.getDataCodewords();
                    dataBlockArr[i5] = new DataBlock(dataCodewords, new byte[eCBlocksForLevel.getECCodewordsPerBlock() + dataCodewords]);
                    i6++;
                    i5++;
                }
            }
            int length = dataBlockArr[0].codewords.length;
            int i7 = i4 - 1;
            while (i7 >= 0 && dataBlockArr[i7].codewords.length != length) {
                i7--;
            }
            int i8 = i7 + 1;
            int eCCodewordsPerBlock = length - eCBlocksForLevel.getECCodewordsPerBlock();
            int i9 = 0;
            for (int i10 = 0; i10 < eCCodewordsPerBlock; i10++) {
                int i11 = 0;
                while (i11 < i5) {
                    dataBlockArr[i11].codewords[i10] = bArr[i9];
                    i11++;
                    i9++;
                }
            }
            int i12 = i8;
            while (i12 < i5) {
                dataBlockArr[i12].codewords[eCCodewordsPerBlock] = bArr[i9];
                i12++;
                i9++;
            }
            int length2 = dataBlockArr[0].codewords.length;
            while (eCCodewordsPerBlock < length2) {
                int i13 = 0;
                while (i13 < i5) {
                    dataBlockArr[i13].codewords[i13 < i8 ? eCCodewordsPerBlock : eCCodewordsPerBlock + 1] = bArr[i9];
                    i13++;
                    i9++;
                }
                eCCodewordsPerBlock++;
            }
            return dataBlockArr;
        }
        throw new IllegalArgumentException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] getCodewords() {
        return this.codewords;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getNumDataCodewords() {
        return this.numDataCodewords;
    }
}
