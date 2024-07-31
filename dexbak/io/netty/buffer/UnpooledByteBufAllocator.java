package io.netty.buffer;

import io.netty.util.internal.PlatformDependent;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class UnpooledByteBufAllocator extends AbstractByteBufAllocator {
    public static final UnpooledByteBufAllocator DEFAULT = new UnpooledByteBufAllocator(PlatformDependent.directBufferPreferred());
    private final boolean disableLeakDetector;

    public UnpooledByteBufAllocator(boolean z) {
        this(z, false);
    }

    @Override // io.netty.buffer.AbstractByteBufAllocator, io.netty.buffer.ByteBufAllocator
    public CompositeByteBuf compositeDirectBuffer(int i) {
        CompositeByteBuf compositeByteBuf = new CompositeByteBuf(this, true, i);
        return this.disableLeakDetector ? compositeByteBuf : AbstractByteBufAllocator.toLeakAwareBuffer(compositeByteBuf);
    }

    @Override // io.netty.buffer.AbstractByteBufAllocator, io.netty.buffer.ByteBufAllocator
    public CompositeByteBuf compositeHeapBuffer(int i) {
        CompositeByteBuf compositeByteBuf = new CompositeByteBuf(this, false, i);
        return this.disableLeakDetector ? compositeByteBuf : AbstractByteBufAllocator.toLeakAwareBuffer(compositeByteBuf);
    }

    @Override // io.netty.buffer.ByteBufAllocator
    public boolean isDirectBufferPooled() {
        return false;
    }

    @Override // io.netty.buffer.AbstractByteBufAllocator
    protected ByteBuf newDirectBuffer(int i, int i2) {
        ByteBuf newUnsafeDirectByteBuf = PlatformDependent.hasUnsafe() ? UnsafeByteBufUtil.newUnsafeDirectByteBuf(this, i, i2) : new UnpooledDirectByteBuf(this, i, i2);
        return this.disableLeakDetector ? newUnsafeDirectByteBuf : AbstractByteBufAllocator.toLeakAwareBuffer(newUnsafeDirectByteBuf);
    }

    @Override // io.netty.buffer.AbstractByteBufAllocator
    protected ByteBuf newHeapBuffer(int i, int i2) {
        return PlatformDependent.hasUnsafe() ? new UnpooledUnsafeHeapByteBuf(this, i, i2) : new UnpooledHeapByteBuf(this, i, i2);
    }

    public UnpooledByteBufAllocator(boolean z, boolean z2) {
        super(z);
        this.disableLeakDetector = z2;
    }
}
