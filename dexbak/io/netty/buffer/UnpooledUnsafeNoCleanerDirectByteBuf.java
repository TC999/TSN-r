package io.netty.buffer;

import io.netty.util.internal.PlatformDependent;
import java.nio.ByteBuffer;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class UnpooledUnsafeNoCleanerDirectByteBuf extends UnpooledUnsafeDirectByteBuf {
    /* JADX INFO: Access modifiers changed from: package-private */
    public UnpooledUnsafeNoCleanerDirectByteBuf(ByteBufAllocator byteBufAllocator, int i, int i2) {
        super(byteBufAllocator, i, i2);
    }

    @Override // io.netty.buffer.UnpooledUnsafeDirectByteBuf
    protected ByteBuffer allocateDirect(int i) {
        return PlatformDependent.allocateDirectNoCleaner(i);
    }

    @Override // io.netty.buffer.UnpooledUnsafeDirectByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf capacity(int i) {
        ensureAccessible();
        if (i >= 0 && i <= maxCapacity()) {
            int readerIndex = readerIndex();
            int writerIndex = writerIndex();
            int capacity = capacity();
            if (i > capacity) {
                setByteBuffer(PlatformDependent.reallocateDirectNoCleaner(this.buffer, i), false);
            } else if (i < capacity) {
                ByteBuffer byteBuffer = this.buffer;
                ByteBuffer allocateDirect = allocateDirect(i);
                if (readerIndex < i) {
                    if (writerIndex > i) {
                        writerIndex(i);
                    } else {
                        i = writerIndex;
                    }
                    byteBuffer.position(readerIndex).limit(i);
                    allocateDirect.position(readerIndex).limit(i);
                    allocateDirect.put(byteBuffer);
                    allocateDirect.clear();
                } else {
                    setIndex(i, i);
                }
                setByteBuffer(allocateDirect, true);
            }
            return this;
        }
        throw new IllegalArgumentException("newCapacity: " + i);
    }

    @Override // io.netty.buffer.UnpooledUnsafeDirectByteBuf
    protected void freeDirect(ByteBuffer byteBuffer) {
        PlatformDependent.freeDirectNoCleaner(byteBuffer);
    }
}
