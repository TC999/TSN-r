package io.netty.handler.codec.compression;

import kotlin.UByte;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
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
    public Bzip2BlockDecompressor(int i, int i2, boolean z, int i3, Bzip2BitReader bzip2BitReader) {
        this.bwtBlock = new byte[i];
        this.blockCRC = i2;
        this.blockRandomised = z;
        this.bwtStartPointer = i3;
        this.reader = bzip2BitReader;
    }

    private int decodeNextBWTByte() {
        int i = this.bwtCurrentMergedPointer;
        int i2 = i & 255;
        this.bwtCurrentMergedPointer = this.bwtMergedPointers[i >>> 8];
        if (this.blockRandomised) {
            int i3 = this.randomCount - 1;
            this.randomCount = i3;
            if (i3 == 0) {
                i2 ^= 1;
                int i4 = (this.randomIndex + 1) % 512;
                this.randomIndex = i4;
                this.randomCount = Bzip2Rand.rNums(i4);
            }
        }
        this.bwtBytesDecoded++;
        return i2;
    }

    private void initialiseInverseBWT() {
        int i = this.bwtStartPointer;
        byte[] bArr = this.bwtBlock;
        int i2 = this.bwtBlockLength;
        int[] iArr = new int[i2];
        int[] iArr2 = new int[256];
        if (i >= 0 && i < i2) {
            System.arraycopy(this.bwtByteCounts, 0, iArr2, 1, 255);
            for (int i3 = 2; i3 <= 255; i3++) {
                iArr2[i3] = iArr2[i3] + iArr2[i3 - 1];
            }
            for (int i4 = 0; i4 < this.bwtBlockLength; i4++) {
                int i5 = bArr[i4] & UByte.f41242c;
                int i6 = iArr2[i5];
                iArr2[i5] = i6 + 1;
                iArr[i6] = (i4 << 8) + i5;
            }
            this.bwtMergedPointers = iArr;
            this.bwtCurrentMergedPointer = iArr[i];
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
        int i = this.huffmanEndOfBlockSymbol;
        int[] iArr = this.bwtByteCounts;
        Bzip2MoveToFrontTable bzip2MoveToFrontTable = this.symbolMTF;
        int i2 = this.bwtBlockLength;
        int i3 = this.repeatCount;
        int i4 = this.repeatIncrement;
        int i5 = this.mtfValue;
        while (bzip2BitReader.hasReadableBits(23)) {
            int nextSymbol = bzip2HuffmanStageDecoder.nextSymbol();
            if (nextSymbol == 0) {
                i3 += i4;
                i4 <<= 1;
            } else if (nextSymbol == 1) {
                i4 <<= 1;
                i3 += i4;
            } else {
                if (i3 > 0) {
                    if (i2 + i3 <= length) {
                        byte b = bArr2[i5];
                        int i6 = b & UByte.f41242c;
                        iArr[i6] = iArr[i6] + i3;
                        while (true) {
                            i3--;
                            if (i3 < 0) {
                                break;
                            }
                            bArr[i2] = b;
                            i2++;
                        }
                        i3 = 0;
                        i4 = 1;
                    } else {
                        throw new DecompressionException("block exceeds declared block size");
                    }
                }
                if (nextSymbol == i) {
                    this.bwtBlockLength = i2;
                    initialiseInverseBWT();
                    return true;
                } else if (i2 < length) {
                    i5 = bzip2MoveToFrontTable.indexToFront(nextSymbol - 1) & UByte.f41242c;
                    byte b2 = bArr2[i5];
                    int i7 = b2 & UByte.f41242c;
                    iArr[i7] = iArr[i7] + 1;
                    bArr[i2] = b2;
                    i2++;
                } else {
                    throw new DecompressionException("block exceeds declared block size");
                }
            }
        }
        this.bwtBlockLength = i2;
        this.repeatCount = i3;
        this.repeatIncrement = i4;
        this.mtfValue = i5;
        return false;
    }

    public int read() {
        while (true) {
            int i = this.rleRepeat;
            if (i < 1) {
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
                    int i2 = this.rleAccumulator + 1;
                    this.rleAccumulator = i2;
                    if (i2 == 4) {
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
                this.rleRepeat = i - 1;
                return this.rleLastDecodedByte;
            }
        }
    }
}
