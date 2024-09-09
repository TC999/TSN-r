package io.netty.handler.codec.compression;

import io.netty.buffer.ByteBuf;
import java.lang.reflect.Array;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
final class Bzip2HuffmanStageEncoder {
    private static final int HUFFMAN_HIGH_SYMBOL_COST = 15;
    private final int[][] huffmanCodeLengths;
    private final int[][] huffmanMergedCodeSymbols;
    private final int mtfAlphabetSize;
    private final char[] mtfBlock;
    private final int mtfLength;
    private final int[] mtfSymbolFrequencies;
    private final byte[] selectors;
    private final Bzip2BitWriter writer;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Bzip2HuffmanStageEncoder(Bzip2BitWriter bzip2BitWriter, char[] cArr, int i4, int i5, int[] iArr) {
        this.writer = bzip2BitWriter;
        this.mtfBlock = cArr;
        this.mtfLength = i4;
        this.mtfAlphabetSize = i5;
        this.mtfSymbolFrequencies = iArr;
        int selectTableCount = selectTableCount(i4);
        this.huffmanCodeLengths = (int[][]) Array.newInstance(int.class, selectTableCount, i5);
        this.huffmanMergedCodeSymbols = (int[][]) Array.newInstance(int.class, selectTableCount, i5);
        this.selectors = new byte[((i4 + 50) - 1) / 50];
    }

    private void assignHuffmanCodeSymbols() {
        int[][] iArr = this.huffmanMergedCodeSymbols;
        int[][] iArr2 = this.huffmanCodeLengths;
        int i4 = this.mtfAlphabetSize;
        int length = iArr2.length;
        for (int i5 = 0; i5 < length; i5++) {
            int[] iArr3 = iArr2[i5];
            int i6 = 32;
            int i7 = 0;
            for (int i8 = 0; i8 < i4; i8++) {
                int i9 = iArr3[i8];
                if (i9 > i7) {
                    i7 = i9;
                }
                if (i9 < i6) {
                    i6 = i9;
                }
            }
            int i10 = 0;
            while (i6 <= i7) {
                for (int i11 = 0; i11 < i4; i11++) {
                    if ((iArr2[i5][i11] & 255) == i6) {
                        iArr[i5][i11] = (i6 << 24) | i10;
                        i10++;
                    }
                }
                i10 <<= 1;
                i6++;
            }
        }
    }

    private static void generateHuffmanCodeLengths(int i4, int[] iArr, int[] iArr2) {
        int[] iArr3 = new int[i4];
        int[] iArr4 = new int[i4];
        for (int i5 = 0; i5 < i4; i5++) {
            iArr3[i5] = (iArr[i5] << 9) | i5;
        }
        Arrays.sort(iArr3);
        for (int i6 = 0; i6 < i4; i6++) {
            iArr4[i6] = iArr3[i6] >>> 9;
        }
        Bzip2HuffmanAllocator.allocateHuffmanCodeLengths(iArr4, 20);
        for (int i7 = 0; i7 < i4; i7++) {
            iArr2[iArr3[i7] & 511] = iArr4[i7];
        }
    }

    private void generateHuffmanOptimisationSeeds() {
        int[][] iArr = this.huffmanCodeLengths;
        int[] iArr2 = this.mtfSymbolFrequencies;
        int i4 = this.mtfAlphabetSize;
        int length = iArr.length;
        int i5 = this.mtfLength;
        int i6 = -1;
        for (int i7 = 0; i7 < length; i7++) {
            int i8 = length - i7;
            int i9 = i5 / i8;
            int i10 = i6 + 1;
            int i11 = 0;
            while (i11 < i9 && i6 < i4 - 1) {
                i6++;
                i11 += iArr2[i6];
            }
            if (i6 > i10 && i7 != 0 && i7 != length - 1 && (i8 & 1) == 0) {
                i11 -= iArr2[i6];
                i6--;
            }
            int[] iArr3 = iArr[i7];
            for (int i12 = 0; i12 < i4; i12++) {
                if (i12 < i10 || i12 > i6) {
                    iArr3[i12] = 15;
                }
            }
            i5 -= i11;
        }
    }

    private void optimiseSelectorsAndHuffmanTables(boolean z3) {
        char[] cArr = this.mtfBlock;
        byte[] bArr = this.selectors;
        int[][] iArr = this.huffmanCodeLengths;
        int i4 = this.mtfLength;
        int i5 = this.mtfAlphabetSize;
        int length = iArr.length;
        int i6 = 1;
        int[][] iArr2 = (int[][]) Array.newInstance(int.class, length, i5);
        int i7 = 0;
        int i8 = 0;
        while (i7 < i4) {
            int min = Math.min(i7 + 50, i4) - i6;
            short[] sArr = new short[length];
            for (int i9 = i7; i9 <= min; i9++) {
                char c4 = cArr[i9];
                for (int i10 = 0; i10 < length; i10++) {
                    sArr[i10] = (short) (sArr[i10] + iArr[i10][c4]);
                }
            }
            short s3 = sArr[0];
            byte b4 = 0;
            for (byte b5 = 1; b5 < length; b5 = (byte) (b5 + 1)) {
                short s4 = sArr[b5];
                if (s4 < s3) {
                    s3 = s4;
                    b4 = b5;
                }
            }
            int[] iArr3 = iArr2[b4];
            while (i7 <= min) {
                char c5 = cArr[i7];
                iArr3[c5] = iArr3[c5] + 1;
                i7++;
            }
            if (z3) {
                bArr[i8] = b4;
                i8++;
            }
            i7 = min + 1;
            i6 = 1;
        }
        for (int i11 = 0; i11 < length; i11++) {
            generateHuffmanCodeLengths(i5, iArr2[i11], iArr[i11]);
        }
    }

    private static int selectTableCount(int i4) {
        if (i4 >= 2400) {
            return 6;
        }
        if (i4 >= 1200) {
            return 5;
        }
        if (i4 >= 600) {
            return 4;
        }
        return i4 >= 200 ? 3 : 2;
    }

    private void writeBlockData(ByteBuf byteBuf) {
        Bzip2BitWriter bzip2BitWriter = this.writer;
        int[][] iArr = this.huffmanMergedCodeSymbols;
        byte[] bArr = this.selectors;
        char[] cArr = this.mtfBlock;
        int i4 = this.mtfLength;
        int i5 = 0;
        int i6 = 0;
        while (i5 < i4) {
            int min = Math.min(i5 + 50, i4) - 1;
            int i7 = i6 + 1;
            int[] iArr2 = iArr[bArr[i6]];
            while (i5 <= min) {
                int i8 = i5 + 1;
                int i9 = iArr2[cArr[i5]];
                bzip2BitWriter.writeBits(byteBuf, i9 >>> 24, i9);
                i5 = i8;
            }
            i6 = i7;
        }
    }

    private void writeSelectorsAndHuffmanTables(ByteBuf byteBuf) {
        Bzip2BitWriter bzip2BitWriter = this.writer;
        byte[] bArr = this.selectors;
        int length = bArr.length;
        int[][] iArr = this.huffmanCodeLengths;
        int length2 = iArr.length;
        int i4 = this.mtfAlphabetSize;
        bzip2BitWriter.writeBits(byteBuf, 3, length2);
        bzip2BitWriter.writeBits(byteBuf, 15, length);
        Bzip2MoveToFrontTable bzip2MoveToFrontTable = new Bzip2MoveToFrontTable();
        for (byte b4 : bArr) {
            bzip2BitWriter.writeUnary(byteBuf, bzip2MoveToFrontTable.valueToFront(b4));
        }
        for (int[] iArr2 : iArr) {
            int i5 = iArr2[0];
            bzip2BitWriter.writeBits(byteBuf, 5, i5);
            int i6 = 0;
            while (i6 < i4) {
                int i7 = iArr2[i6];
                int i8 = i5 < i7 ? 2 : 3;
                int abs = Math.abs(i7 - i5);
                while (true) {
                    int i9 = abs - 1;
                    if (abs > 0) {
                        bzip2BitWriter.writeBits(byteBuf, 2, i8);
                        i4 = i4;
                        abs = i9;
                    }
                }
                bzip2BitWriter.writeBoolean(byteBuf, false);
                i6++;
                i5 = i7;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void encode(ByteBuf byteBuf) {
        generateHuffmanOptimisationSeeds();
        int i4 = 3;
        while (i4 >= 0) {
            optimiseSelectorsAndHuffmanTables(i4 == 0);
            i4--;
        }
        assignHuffmanCodeSymbols();
        writeSelectorsAndHuffmanTables(byteBuf);
        writeBlockData(byteBuf);
    }
}
