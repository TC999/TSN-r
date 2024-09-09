package io.netty.handler.codec.compression;

import io.netty.buffer.ByteBuf;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
final class Bzip2BitWriter {
    private long bitBuffer;
    private int bitCount;

    /* JADX INFO: Access modifiers changed from: package-private */
    public void flush(ByteBuf byteBuf) {
        int i4 = this.bitCount;
        if (i4 > 0) {
            long j4 = this.bitBuffer;
            int i5 = 64 - i4;
            if (i4 <= 8) {
                byteBuf.writeByte((int) ((j4 >>> i5) << (8 - i4)));
            } else if (i4 <= 16) {
                byteBuf.writeShort((int) ((j4 >>> i5) << (16 - i4)));
            } else if (i4 <= 24) {
                byteBuf.writeMedium((int) ((j4 >>> i5) << (24 - i4)));
            } else {
                byteBuf.writeInt((int) ((j4 >>> i5) << (32 - i4)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void writeBits(ByteBuf byteBuf, int i4, long j4) {
        if (i4 >= 0 && i4 <= 32) {
            int i5 = this.bitCount;
            long j5 = ((j4 << (64 - i4)) >>> i5) | this.bitBuffer;
            int i6 = i5 + i4;
            if (i6 >= 32) {
                byteBuf.writeInt((int) (j5 >>> 32));
                j5 <<= 32;
                i6 -= 32;
            }
            this.bitBuffer = j5;
            this.bitCount = i6;
            return;
        }
        throw new IllegalArgumentException("count: " + i4 + " (expected: 0-32)");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void writeBoolean(ByteBuf byteBuf, boolean z3) {
        int i4 = this.bitCount + 1;
        long j4 = 0;
        long j5 = this.bitBuffer | (z3 ? 1 << (64 - i4) : 0L);
        if (i4 == 32) {
            byteBuf.writeInt((int) (j5 >>> 32));
            i4 = 0;
        } else {
            j4 = j5;
        }
        this.bitBuffer = j4;
        this.bitCount = i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void writeInt(ByteBuf byteBuf, int i4) {
        writeBits(byteBuf, 32, i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void writeUnary(ByteBuf byteBuf, int i4) {
        if (i4 < 0) {
            throw new IllegalArgumentException("value: " + i4 + " (expected 0 or more)");
        }
        while (true) {
            int i5 = i4 - 1;
            if (i4 > 0) {
                writeBoolean(byteBuf, true);
                i4 = i5;
            } else {
                writeBoolean(byteBuf, false);
                return;
            }
        }
    }
}
