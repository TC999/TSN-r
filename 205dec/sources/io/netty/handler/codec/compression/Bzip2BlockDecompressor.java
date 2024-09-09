package io.netty.handler.codec.compression;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
final class Bzip2BlockDecompressor {
    private final int blockCRC;
    private final boolean blockRandomised;
    private final byte[] bwtBlock;
    private int bwtBlockLength;
    private int bwtBytesDecoded;
    private int bwtCurrentMergedPointer;
    private int[] bwtMergedPointers;
    private final int bwtStartPointer;
    int huffmanEndOfBlockSymbol;
    int huffmanInUse16;
    private int mtfValue;
    private int randomIndex;
    private final Bzip2BitReader reader;
    private int repeatCount;
    private int rleAccumulator;
    private int rleRepeat;
    private final Crc32 crc = new Crc32();
    final byte[] huffmanSymbolMap = new byte[256];
    private final int[] bwtByteCounts = new int[256];
    private int rleLastDecodedByte = -1;
    private int randomCount = Bzip2Rand.rNums(0) - 1;
    private final Bzip2MoveToFrontTable symbolMTF = new Bzip2MoveToFrontTable();
    private int repeatIncrement = 1;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Bzip2BlockDecompressor(int i4, int i5, boolean z3, int i6, Bzip2BitReader bzip2BitReader) {
        this.bwtBlock = new byte[i4];
        this.blockCRC = i5;
        this.blockRandomised = z3;
        this.bwtStartPointer = i6;
        this.reader = bzip2BitReader;
    }

    private int decodeNextBWTByte() {
        int i4 = this.bwtCurrentMergedPointer;
        int i5 = i4 & 255;
        this.bwtCurrentMergedPointer = this.bwtMergedPointers[i4 >>> 8];
        if (this.blockRandomised) {
            int i6 = this.randomCount - 1;
            this.randomCount = i6;
            if (i6 == 0) {
                i5 ^= 1;
                int i7 = (this.randomIndex + 1) % 512;
                this.randomIndex = i7;
                this.randomCount = Bzip2Rand.rNums(i7);
            }
        }
        this.bwtBytesDecoded++;
        return i5;
    }

    private void initialiseInverseBWT() {
        int i4 = this.bwtStartPointer;
        byte[] bArr = this.bwtBlock;
        int i5 = this.bwtBlockLength;
        int[] iArr = new int[i5];
        int[] iArr2 = new int[256];
        if (i4 >= 0 && i4 < i5) {
            System.arraycopy(this.bwtByteCounts, 0, iArr2, 1, 255);
            for (int i6 = 2; i6 <= 255; i6++) {
                iArr2[i6] = iArr2[i6] + iArr2[i6 - 1];
            }
            for (int i7 = 0; i7 < this.bwtBlockLength; i7++) {
                int i8 = bArr[i7] & 255;
                int i9 = iArr2[i8];
                iArr2[i8] = i9 + 1;
                iArr[i9] = (i7 << 8) + i8;
            }
            this.bwtMergedPointers = iArr;
            this.bwtCurrentMergedPointer = iArr[i4];
            return;
        }
        throw new DecompressionException("start pointer invalid");
    }

    public int blockLength() {
        return this.bwtBlockLength;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int checkCRC() {
        int crc = this.crc.getCRC();
        if (this.blockCRC == crc) {
            return crc;
        }
        throw new DecompressionException("block CRC error");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean decodeHuffmanData(Bzip2HuffmanStageDecoder bzip2HuffmanStageDecoder) {
        Bzip2BitReader bzip2BitReader = this.reader;
        byte[] bArr = this.bwtBlock;
        byte[] bArr2 = this.huffmanSymbolMap;
        int length = bArr.length;
        int i4 = this.huffmanEndOfBlockSymbol;
        int[] iArr = this.bwtByteCounts;
        Bzip2MoveToFrontTable bzip2MoveToFrontTable = this.symbolMTF;
        int i5 = this.bwtBlockLength;
        int i6 = this.repeatCount;
        int i7 = this.repeatIncrement;
        int i8 = this.mtfValue;
        while (bzip2BitReader.hasReadableBits(23)) {
            int nextSymbol = bzip2HuffmanStageDecoder.nextSymbol();
            if (nextSymbol == 0) {
                i6 += i7;
                i7 <<= 1;
            } else if (nextSymbol == 1) {
                i7 <<= 1;
                i6 += i7;
            } else {
                if (i6 > 0) {
                    if (i5 + i6 <= length) {
                        byte b4 = bArr2[i8];
                        int i9 = b4 & 255;
                        iArr[i9] = iArr[i9] + i6;
                        while (true) {
                            i6--;
                            if (i6 < 0) {
                                break;
                            }
                            bArr[i5] = b4;
                            i5++;
                        }
                        i6 = 0;
                        i7 = 1;
                    } else {
                        throw new DecompressionException("block exceeds declared block size");
                    }
                }
                if (nextSymbol == i4) {
                    this.bwtBlockLength = i5;
                    initialiseInverseBWT();
                    return true;
                } else if (i5 < length) {
                    i8 = bzip2MoveToFrontTable.indexToFront(nextSymbol - 1) & 255;
                    byte b5 = bArr2[i8];
                    int i10 = b5 & 255;
                    iArr[i10] = iArr[i10] + 1;
                    bArr[i5] = b5;
                    i5++;
                } else {
                    throw new DecompressionException("block exceeds declared block size");
                }
            }
        }
        this.bwtBlockLength = i5;
        this.repeatCount = i6;
        this.repeatIncrement = i7;
        this.mtfValue = i8;
        return false;
    }

    public int read() {
        while (true) {
            int i4 = this.rleRepeat;
            if (i4 < 1) {
                if (this.bwtBytesDecoded == this.bwtBlockLength) {
                    return -1;
                }
                int decodeNextBWTByte = decodeNextBWTByte();
                if (decodeNextBWTByte != this.rleLastDecodedByte) {
                    this.rleLastDecodedByte = decodeNextBWTByte;
                    this.rleRepeat = 1;
                    this.rleAccumulator = 1;
                    this.crc.updateCRC(decodeNextBWTByte);
                } else {
                    int i5 = this.rleAccumulator + 1;
                    this.rleAccumulator = i5;
                    if (i5 == 4) {
                        int decodeNextBWTByte2 = decodeNextBWTByte() + 1;
                        this.rleRepeat = decodeNextBWTByte2;
                        this.rleAccumulator = 0;
                        this.crc.updateCRC(decodeNextBWTByte, decodeNextBWTByte2);
                    } else {
                        this.rleRepeat = 1;
                        this.crc.updateCRC(decodeNextBWTByte);
                    }
                }
            } else {
                this.rleRepeat = i4 - 1;
                return this.rleLastDecodedByte;
            }
        }
    }
}
