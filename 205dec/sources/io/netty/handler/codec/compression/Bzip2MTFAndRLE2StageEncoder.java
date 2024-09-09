package io.netty.handler.codec.compression;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
final class Bzip2MTFAndRLE2StageEncoder {
    private int alphabetSize;
    private final int[] bwtBlock;
    private final int bwtLength;
    private final boolean[] bwtValuesPresent;
    private final char[] mtfBlock;
    private int mtfLength;
    private final int[] mtfSymbolFrequencies = new int[MediaPlayer.MEDIA_PLAYER_OPTION_RANGE_MODE];

    /* JADX INFO: Access modifiers changed from: package-private */
    public Bzip2MTFAndRLE2StageEncoder(int[] iArr, int i4, boolean[] zArr) {
        this.bwtBlock = iArr;
        this.bwtLength = i4;
        this.bwtValuesPresent = zArr;
        this.mtfBlock = new char[i4 + 1];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void encode() {
        int i4;
        int i5;
        int i6 = this.bwtLength;
        boolean[] zArr = this.bwtValuesPresent;
        int[] iArr = this.bwtBlock;
        char[] cArr = this.mtfBlock;
        int[] iArr2 = this.mtfSymbolFrequencies;
        byte[] bArr = new byte[256];
        Bzip2MoveToFrontTable bzip2MoveToFrontTable = new Bzip2MoveToFrontTable();
        char c4 = 0;
        int i7 = 0;
        for (int i8 = 0; i8 < 256; i8++) {
            if (zArr[i8]) {
                bArr[i8] = (byte) i7;
                i7++;
            }
        }
        int i9 = i7 + 1;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        while (i10 < i6) {
            int valueToFront = bzip2MoveToFrontTable.valueToFront(bArr[iArr[i10] & 255]);
            if (valueToFront == 0) {
                i11++;
            } else {
                if (i11 > 0) {
                    int i15 = i11 - 1;
                    while (true) {
                        if ((i15 & 1) == 0) {
                            i5 = i12 + 1;
                            cArr[i12] = c4;
                            i13++;
                        } else {
                            i5 = i12 + 1;
                            cArr[i12] = 1;
                            i14++;
                        }
                        i12 = i5;
                        if (i15 <= 1) {
                            break;
                        }
                        i15 = (i15 - 2) >>> 1;
                    }
                    i11 = 0;
                }
                int i16 = valueToFront + 1;
                cArr[i12] = (char) i16;
                iArr2[i16] = iArr2[i16] + 1;
                i12++;
            }
            i10++;
            c4 = 0;
        }
        if (i11 > 0) {
            int i17 = i11 - 1;
            while (true) {
                if ((i17 & 1) == 0) {
                    i4 = i12 + 1;
                    cArr[i12] = 0;
                    i13++;
                } else {
                    i4 = i12 + 1;
                    cArr[i12] = 1;
                    i14++;
                }
                i12 = i4;
                if (i17 <= 1) {
                    break;
                }
                i17 = (i17 - 2) >>> 1;
            }
        }
        cArr[i12] = (char) i9;
        iArr2[i9] = iArr2[i9] + 1;
        iArr2[0] = iArr2[0] + i13;
        iArr2[1] = iArr2[1] + i14;
        this.mtfLength = i12 + 1;
        this.alphabetSize = i9 + 1;
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
