package io.netty.handler.codec.compression;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
final class Bzip2MTFAndRLE2StageEncoder {
    private int alphabetSize;
    private final int[] bwtBlock;
    private final int bwtLength;
    private final boolean[] bwtValuesPresent;
    private final char[] mtfBlock;
    private int mtfLength;
    private final int[] mtfSymbolFrequencies = new int[258];

    /* JADX INFO: Access modifiers changed from: package-private */
    public Bzip2MTFAndRLE2StageEncoder(int[] iArr, int i, boolean[] zArr) {
        this.bwtBlock = iArr;
        this.bwtLength = i;
        this.bwtValuesPresent = zArr;
        this.mtfBlock = new char[i + 1];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void encode() {
        int i;
        int i2;
        int i3 = this.bwtLength;
        boolean[] zArr = this.bwtValuesPresent;
        int[] iArr = this.bwtBlock;
        char[] cArr = this.mtfBlock;
        int[] iArr2 = this.mtfSymbolFrequencies;
        byte[] bArr = new byte[256];
        Bzip2MoveToFrontTable bzip2MoveToFrontTable = new Bzip2MoveToFrontTable();
        char c = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < 256; i5++) {
            if (zArr[i5]) {
                bArr[i5] = (byte) i4;
                i4++;
            }
        }
        int i6 = i4 + 1;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        while (i7 < i3) {
            int valueToFront = bzip2MoveToFrontTable.valueToFront(bArr[iArr[i7] & 255]);
            if (valueToFront == 0) {
                i8++;
            } else {
                if (i8 > 0) {
                    int i12 = i8 - 1;
                    while (true) {
                        if ((i12 & 1) == 0) {
                            i2 = i9 + 1;
                            cArr[i9] = c;
                            i10++;
                        } else {
                            i2 = i9 + 1;
                            cArr[i9] = 1;
                            i11++;
                        }
                        i9 = i2;
                        if (i12 <= 1) {
                            break;
                        }
                        i12 = (i12 - 2) >>> 1;
                    }
                    i8 = 0;
                }
                int i13 = valueToFront + 1;
                cArr[i9] = (char) i13;
                iArr2[i13] = iArr2[i13] + 1;
                i9++;
            }
            i7++;
            c = 0;
        }
        if (i8 > 0) {
            int i14 = i8 - 1;
            while (true) {
                if ((i14 & 1) == 0) {
                    i = i9 + 1;
                    cArr[i9] = 0;
                    i10++;
                } else {
                    i = i9 + 1;
                    cArr[i9] = 1;
                    i11++;
                }
                i9 = i;
                if (i14 <= 1) {
                    break;
                }
                i14 = (i14 - 2) >>> 1;
            }
        }
        cArr[i9] = (char) i6;
        iArr2[i6] = iArr2[i6] + 1;
        iArr2[0] = iArr2[0] + i10;
        iArr2[1] = iArr2[1] + i11;
        this.mtfLength = i9 + 1;
        this.alphabetSize = i6 + 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int mtfAlphabetSize() {
        return this.alphabetSize;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public char[] mtfBlock() {
        return this.mtfBlock;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int mtfLength() {
        return this.mtfLength;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int[] mtfSymbolFrequencies() {
        return this.mtfSymbolFrequencies;
    }
}
