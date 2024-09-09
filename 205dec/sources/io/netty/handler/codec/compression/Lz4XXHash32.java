package io.netty.handler.codec.compression;

import io.netty.buffer.ByteBuf;
import net.jpountz.xxhash.XXHash32;
import net.jpountz.xxhash.XXHashFactory;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public final class Lz4XXHash32 extends ByteBufChecksum {
    private static final XXHash32 XXHASH32 = XXHashFactory.fastestInstance().hash32();
    private final int seed;
    private boolean used;
    private int value;

    public Lz4XXHash32(int i4) {
        this.seed = i4;
    }

    @Override // java.util.zip.Checksum
    public long getValue() {
        if (this.used) {
            return this.value & 268435455;
        }
        throw new IllegalStateException();
    }

    @Override // java.util.zip.Checksum
    public void reset() {
        this.used = false;
    }

    @Override // java.util.zip.Checksum
    public void update(int i4) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.zip.Checksum
    public void update(byte[] bArr, int i4, int i5) {
        if (!this.used) {
            this.value = XXHASH32.hash(bArr, i4, i5, this.seed);
            this.used = true;
            return;
        }
        throw new IllegalStateException();
    }

    @Override // io.netty.handler.codec.compression.ByteBufChecksum
    public void update(ByteBuf byteBuf, int i4, int i5) {
        if (!this.used) {
            if (byteBuf.hasArray()) {
                this.value = XXHASH32.hash(byteBuf.array(), byteBuf.arrayOffset() + i4, i5, this.seed);
            } else {
                this.value = XXHASH32.hash(CompressionUtil.safeNioBuffer(byteBuf, i4, i5), this.seed);
            }
            this.used = true;
            return;
        }
        throw new IllegalStateException();
    }
}
