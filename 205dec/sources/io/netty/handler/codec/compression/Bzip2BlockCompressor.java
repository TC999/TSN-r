package io.netty.handler.codec.compression;

import io.netty.buffer.ByteBuf;
import io.netty.util.ByteProcessor;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
final class Bzip2BlockCompressor {
    private final byte[] block;
    private int blockLength;
    private final int blockLengthLimit;
    private final int[] bwtBlock;
    private int rleLength;
    private final Bzip2BitWriter writer;
    private final ByteProcessor writeProcessor = new ByteProcessor() { // from class: io.netty.handler.codec.compression.Bzip2BlockCompressor.1
        @Override // io.netty.util.ByteProcessor
        public boolean process(byte b4) throws Exception {
            return Bzip2BlockCompressor.this.write(b4);
        }
    };
    private final Crc32 crc = new Crc32();
    private final boolean[] blockValuesPresent = new boolean[256];
    private int rleCurrentValue = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Bzip2BlockCompressor(Bzip2BitWriter bzip2BitWriter, int i4) {
        this.writer = bzip2BitWriter;
        int i5 = i4 + 1;
        this.block = new byte[i5];
        this.bwtBlock = new int[i5];
        this.blockLengthLimit = i4 - 6;
    }

    private void writeRun(int i4, int i5) {
        int i6 = this.blockLength;
        byte[] bArr = this.block;
        this.blockValuesPresent[i4] = true;
        this.crc.updateCRC(i4, i5);
        byte b4 = (byte) i4;
        if (i5 == 1) {
            bArr[i6] = b4;
            this.blockLength = i6 + 1;
        } else if (i5 == 2) {
            bArr[i6] = b4;
            bArr[i6 + 1] = b4;
            this.blockLength = i6 + 2;
        } else if (i5 != 3) {
            int i7 = i5 - 4;
            this.blockValuesPresent[i7] = true;
            bArr[i6] = b4;
            bArr[i6 + 1] = b4;
            bArr[i6 + 2] = b4;
            bArr[i6 + 3] = b4;
            bArr[i6 + 4] = (byte) i7;
            this.blockLength = i6 + 5;
        } else {
            bArr[i6] = b4;
            bArr[i6 + 1] = b4;
            bArr[i6 + 2] = b4;
            this.blockLength = i6 + 3;
        }
    }

    private void writeSymbolMap(ByteBuf byteBuf) {
        Bzip2BitWriter bzip2BitWriter = this.writer;
        boolean[] zArr = this.blockValuesPresent;
        boolean[] zArr2 = new boolean[16];
        for (int i4 = 0; i4 < 16; i4++) {
            int i5 = i4 << 4;
            int i6 = 0;
            while (i6 < 16) {
                if (zArr[i5]) {
                    zArr2[i4] = true;
                }
                i6++;
                i5++;
            }
        }
        for (int i7 = 0; i7 < 16; i7++) {
            bzip2BitWriter.writeBoolean(byteBuf, zArr2[i7]);
        }
        for (int i8 = 0; i8 < 16; i8++) {
            if (zArr2[i8]) {
                int i9 = i8 << 4;
                int i10 = 0;
                while (i10 < 16) {
                    bzip2BitWriter.writeBoolean(byteBuf, zArr[i9]);
                    i10++;
                    i9++;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int availableSize() {
        int i4 = this.blockLength;
        if (i4 == 0) {
            return this.blockLengthLimit + 2;
        }
        return (this.blockLengthLimit - i4) + 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void close(ByteBuf byteBuf) {
        int i4 = this.rleLength;
        if (i4 > 0) {
            writeRun(this.rleCurrentValue & 255, i4);
        }
        byte[] bArr = this.block;
        bArr[this.blockLength] = bArr[0];
        int bwt = new Bzip2DivSufSort(this.block, this.bwtBlock, this.blockLength).bwt();
        Bzip2BitWriter bzip2BitWriter = this.writer;
        bzip2BitWriter.writeBits(byteBuf, 24, 3227993L);
        bzip2BitWriter.writeBits(byteBuf, 24, 2511705L);
        bzip2BitWriter.writeInt(byteBuf, this.crc.getCRC());
        bzip2BitWriter.writeBoolean(byteBuf, false);
        bzip2BitWriter.writeBits(byteBuf, 24, bwt);
        writeSymbolMap(byteBuf);
        Bzip2MTFAndRLE2StageEncoder bzip2MTFAndRLE2StageEncoder = new Bzip2MTFAndRLE2StageEncoder(this.bwtBlock, this.blockLength, this.blockValuesPresent);
        bzip2MTFAndRLE2StageEncoder.encode();
        new Bzip2HuffmanStageEncoder(bzip2BitWriter, bzip2MTFAndRLE2StageEncoder.mtfBlock(), bzip2MTFAndRLE2StageEncoder.mtfLength(), bzip2MTFAndRLE2StageEncoder.mtfAlphabetSize(), bzip2MTFAndRLE2StageEncoder.mtfSymbolFrequencies()).encode(byteBuf);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int crc() {
        return this.crc.getCRC();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isEmpty() {
        return this.blockLength == 0 && this.rleLength == 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isFull() {
        return this.blockLength > this.blockLengthLimit;
    }

    boolean write(int i4) {
        if (this.blockLength > this.blockLengthLimit) {
            return false;
        }
        int i5 = this.rleCurrentValue;
        int i6 = this.rleLength;
        if (i6 == 0) {
            this.rleCurrentValue = i4;
            this.rleLength = 1;
        } else if (i5 != i4) {
            writeRun(i5 & 255, i6);
            this.rleCurrentValue = i4;
            this.rleLength = 1;
        } else if (i6 == 254) {
            writeRun(i5 & 255, 255);
            this.rleLength = 0;
        } else {
            this.rleLength = i6 + 1;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int write(ByteBuf byteBuf, int i4, int i5) {
        int forEachByte = byteBuf.forEachByte(i4, i5, this.writeProcessor);
        return forEachByte == -1 ? i5 : forEachByte - i4;
    }
}
