package com.google.zxing.datamatrix.decoder;

import com.google.zxing.datamatrix.decoder.Version;

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
    public static DataBlock[] getDataBlocks(byte[] bArr, Version version) {
        Version.ECBlocks eCBlocks = version.getECBlocks();
        Version.ECB[] eCBlocks2 = eCBlocks.getECBlocks();
        int i4 = 0;
        for (Version.ECB ecb : eCBlocks2) {
            i4 += ecb.getCount();
        }
        DataBlock[] dataBlockArr = new DataBlock[i4];
        int i5 = 0;
        for (Version.ECB ecb2 : eCBlocks2) {
            int i6 = 0;
            while (i6 < ecb2.getCount()) {
                int dataCodewords = ecb2.getDataCodewords();
                dataBlockArr[i5] = new DataBlock(dataCodewords, new byte[eCBlocks.getECCodewords() + dataCodewords]);
                i6++;
                i5++;
            }
        }
        int length = dataBlockArr[0].codewords.length - eCBlocks.getECCodewords();
        int i7 = length - 1;
        int i8 = 0;
        for (int i9 = 0; i9 < i7; i9++) {
            int i10 = 0;
            while (i10 < i5) {
                dataBlockArr[i10].codewords[i9] = bArr[i8];
                i10++;
                i8++;
            }
        }
        boolean z3 = version.getVersionNumber() == 24;
        int i11 = z3 ? 8 : i5;
        int i12 = 0;
        while (i12 < i11) {
            dataBlockArr[i12].codewords[i7] = bArr[i8];
            i12++;
            i8++;
        }
        int length2 = dataBlockArr[0].codewords.length;
        while (length < length2) {
            int i13 = 0;
            while (i13 < i5) {
                int i14 = z3 ? (i13 + 8) % i5 : i13;
                dataBlockArr[i14].codewords[(!z3 || i14 <= 7) ? length : length - 1] = bArr[i8];
                i13++;
                i8++;
            }
            length++;
        }
        if (i8 == bArr.length) {
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
