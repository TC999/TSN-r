package io.netty.handler.codec.compression;

import io.netty.buffer.ByteBuf;
import io.netty.util.ByteProcessor;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
final class Bzip2BlockCompressor {
    private final byte[] block;
    private int blockLength;
    private final int blockLengthLimit;
    private final int[] bwtBlock;
    private int rleLength;
    private final Bzip2BitWriter writer;
    private final ByteProcessor writeProcessor = new ByteProcessor() { // from class: io.netty.handler.codec.compression.Bzip2BlockCompressor.1
        @Override // io.netty.util.ByteProcessor
        public boolean process(byte b) throws Exception {
            return Bzip2BlockCompressor.this.write(b);
        }
    };
    private final Crc32 crc = new Crc32();
    private final boolean[] blockValuesPresent = new boolean[256];
    private int rleCurrentValue = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Bzip2BlockCompressor(Bzip2BitWriter bzip2BitWriter, int i) {
        this.writer = bzip2BitWriter;
        int i2 = i + 1;
        this.block = new byte[i2];
        this.bwtBlock = new int[i2];
        this.blockLengthLimit = i - 6;
    }

    private void writeRun(int i, int i2) {
        int i3 = this.blockLength;
        byte[] bArr = this.block;
        this.blockValuesPresent[i] = true;
        this.crc.updateCRC(i, i2);
        byte b = (byte) i;
        if (i2 == 1) {
            bArr[i3] = b;
            this.blockLength = i3 + 1;
        } else if (i2 == 2) {
            bArr[i3] = b;
            bArr[i3 + 1] = b;
            this.blockLength = i3 + 2;
        } else if (i2 != 3) {
            int i4 = i2 - 4;
            this.blockValuesPresent[i4] = true;
            bArr[i3] = b;
            bArr[i3 + 1] = b;
            bArr[i3 + 2] = b;
            bArr[i3 + 3] = b;
            bArr[i3 + 4] = (byte) i4;
            this.blockLength = i3 + 5;
        } else {
            bArr[i3] = b;
            bArr[i3 + 1] = b;
            bArr[i3 + 2] = b;
            this.blockLength = i3 + 3;
        }
    }

    private void writeSymbolMap(ByteBuf byteBuf) {
        Bzip2BitWriter bzip2BitWriter = this.writer;
        boolean[] zArr = this.blockValuesPresent;
        boolean[] zArr2 = new boolean[16];
        for (int i = 0; i < 16; i++) {
            int i2 = i << 4;
            int i3 = 0;
            while (i3 < 16) {
                if (zArr[i2]) {
                    zArr2[i] = true;
                }
                i3++;
                i2++;
            }
        }
        for (int i4 = 0; i4 < 16; i4++) {
            bzip2BitWriter.writeBoolean(byteBuf, zArr2[i4]);
        }
        for (int i5 = 0; i5 < 16; i5++) {
            if (zArr2[i5]) {
                int i6 = i5 << 4;
                int i7 = 0;
                while (i7 < 16) {
                    bzip2BitWriter.writeBoolean(byteBuf, zArr[i6]);
                    i7++;
                    i6++;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int availableSize() {
        int i = this.blockLength;
        if (i == 0) {
            return this.blockLengthLimit + 2;
        }
        return (this.blockLengthLimit - i) + 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void close(ByteBuf byteBuf) {
        int i = this.rleLength;
        if (i > 0) {
            writeRun(this.rleCurrentValue & 255, i);
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

    boolean write(int i) {
        if (this.blockLength > this.blockLengthLimit) {
            return false;
        }
        int i2 = this.rleCurrentValue;
        int i3 = this.rleLength;
        if (i3 == 0) {
            this.rleCurrentValue = i;
            this.rleLength = 1;
        } else if (i2 != i) {
            writeRun(i2 & 255, i3);
            this.rleCurrentValue = i;
            this.rleLength = 1;
        } else if (i3 == 254) {
            writeRun(i2 & 255, 255);
            this.rleLength = 0;
        } else {
            this.rleLength = i3 + 1;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int write(ByteBuf byteBuf, int i, int i2) {
        int forEachByte = byteBuf.forEachByte(i, i2, this.writeProcessor);
        return forEachByte == -1 ? i2 : forEachByte - i;
    }
}
