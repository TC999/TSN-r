package io.netty.handler.codec.compression;

import io.netty.buffer.ByteBuf;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
class Bzip2BitReader {
    private static final int MAX_COUNT_OF_READABLE_BYTES = 268435455;
    private long bitBuffer;
    private int bitCount;

    /* renamed from: in */
    private ByteBuf f40198in;

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean hasReadableBits(int i) {
        if (i >= 0) {
            return this.bitCount >= i || ((this.f40198in.readableBytes() << 3) & Integer.MAX_VALUE) >= i - this.bitCount;
        }
        throw new IllegalArgumentException("count: " + i + " (expected value greater than 0)");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean hasReadableBytes(int i) {
        if (i >= 0 && i <= MAX_COUNT_OF_READABLE_BYTES) {
            return hasReadableBits(i << 3);
        }
        throw new IllegalArgumentException("count: " + i + " (expected: 0-" + MAX_COUNT_OF_READABLE_BYTES + ')');
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isReadable() {
        return this.bitCount > 0 || this.f40198in.isReadable();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int readBits(int i) {
        long readUnsignedByte;
        int i2;
        if (i >= 0 && i <= 32) {
            int i3 = this.bitCount;
            long j = this.bitBuffer;
            if (i3 < i) {
                int readableBytes = this.f40198in.readableBytes();
                if (readableBytes == 1) {
                    readUnsignedByte = this.f40198in.readUnsignedByte();
                    i2 = 8;
                } else if (readableBytes == 2) {
                    readUnsignedByte = this.f40198in.readUnsignedShort();
                    i2 = 16;
                } else if (readableBytes != 3) {
                    readUnsignedByte = this.f40198in.readUnsignedInt();
                    i2 = 32;
                } else {
                    readUnsignedByte = this.f40198in.readUnsignedMedium();
                    i2 = 24;
                }
                j = (j << i2) | readUnsignedByte;
                i3 += i2;
                this.bitBuffer = j;
            }
            int i4 = i3 - i;
            this.bitCount = i4;
            return (int) ((j >>> i4) & (i != 32 ? (1 << i) - 1 : 4294967295L));
        }
        throw new IllegalArgumentException("count: " + i + " (expected: 0-32 )");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean readBoolean() {
        return readBits(1) != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int readInt() {
        return readBits(32);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void refill() {
        this.bitBuffer = (this.bitBuffer << 8) | this.f40198in.readUnsignedByte();
        this.bitCount += 8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setByteBuf(ByteBuf byteBuf) {
        this.f40198in = byteBuf;
    }
}
