package io.netty.handler.codec.compression;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.reflect.Array;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
final class Bzip2HuffmanStageDecoder {
    final int alphabetSize;
    private final int[][] codeBases;
    private final int[][] codeLimits;
    private final int[][] codeSymbols;
    int currentAlpha;
    int currentGroup;
    int currentSelector;
    private int currentTable;
    private final int[] minimumLengths;
    boolean modifyLength;
    private final Bzip2BitReader reader;
    byte[] selectors;
    final byte[][] tableCodeLengths;
    final int totalTables;
    private int groupIndex = -1;
    private int groupPosition = -1;
    final Bzip2MoveToFrontTable tableMTF = new Bzip2MoveToFrontTable();
    int currentLength = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Bzip2HuffmanStageDecoder(Bzip2BitReader bzip2BitReader, int i4, int i5) {
        this.reader = bzip2BitReader;
        this.totalTables = i4;
        this.alphabetSize = i5;
        this.minimumLengths = new int[i4];
        this.codeBases = (int[][]) Array.newInstance(int.class, i4, 25);
        this.codeLimits = (int[][]) Array.newInstance(int.class, i4, 24);
        this.codeSymbols = (int[][]) Array.newInstance(int.class, i4, MediaPlayer.MEDIA_PLAYER_OPTION_RANGE_MODE);
        this.tableCodeLengths = (byte[][]) Array.newInstance(byte.class, i4, MediaPlayer.MEDIA_PLAYER_OPTION_RANGE_MODE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void createHuffmanDecodingTables() {
        int i4 = this.alphabetSize;
        int i5 = 0;
        while (true) {
            byte[][] bArr = this.tableCodeLengths;
            if (i5 < bArr.length) {
                int[] iArr = this.codeBases[i5];
                int[] iArr2 = this.codeLimits[i5];
                int[] iArr3 = this.codeSymbols[i5];
                byte[] bArr2 = bArr[i5];
                int i6 = 23;
                int i7 = 0;
                for (int i8 = 0; i8 < i4; i8++) {
                    byte b4 = bArr2[i8];
                    i7 = Math.max((int) b4, i7);
                    i6 = Math.min((int) b4, i6);
                }
                this.minimumLengths[i5] = i6;
                for (int i9 = 0; i9 < i4; i9++) {
                    int i10 = bArr2[i9] + 1;
                    iArr[i10] = iArr[i10] + 1;
                }
                int i11 = iArr[0];
                for (int i12 = 1; i12 < 25; i12++) {
                    i11 += iArr[i12];
                    iArr[i12] = i11;
                }
                int i13 = i6;
                int i14 = 0;
                while (i13 <= i7) {
                    int i15 = i13 + 1;
                    int i16 = (iArr[i15] - iArr[i13]) + i14;
                    iArr[i13] = i14 - iArr[i13];
                    iArr2[i13] = i16 - 1;
                    i14 = i16 << 1;
                    i13 = i15;
                }
                int i17 = 0;
                while (i6 <= i7) {
                    for (int i18 = 0; i18 < i4; i18++) {
                        if (bArr2[i18] == i6) {
                            iArr3[i17] = i18;
                            i17++;
                        }
                    }
                    i6++;
                }
                i5++;
            } else {
                this.currentTable = this.selectors[0];
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int nextSymbol() {
        int i4 = this.groupPosition + 1;
        this.groupPosition = i4;
        if (i4 % 50 == 0) {
            int i5 = this.groupIndex + 1;
            this.groupIndex = i5;
            byte[] bArr = this.selectors;
            if (i5 != bArr.length) {
                this.currentTable = bArr[i5] & 255;
            } else {
                throw new DecompressionException("error decoding block");
            }
        }
        Bzip2BitReader bzip2BitReader = this.reader;
        int i6 = this.currentTable;
        int[] iArr = this.codeLimits[i6];
        int[] iArr2 = this.codeBases[i6];
        int[] iArr3 = this.codeSymbols[i6];
        int i7 = this.minimumLengths[i6];
        int readBits = bzip2BitReader.readBits(i7);
        while (i7 <= 23) {
            if (readBits <= iArr[i7]) {
                return iArr3[readBits - iArr2[i7]];
            }
            readBits = (readBits << 1) | bzip2BitReader.readBits(1);
            i7++;
        }
        throw new DecompressionException("a valid code was not recognised");
    }
}
