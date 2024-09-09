package io.netty.buffer;

import io.netty.util.internal.PlatformDependent;
import java.nio.ByteBuffer;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class UnpooledUnsafeNoCleanerDirectByteBuf extends UnpooledUnsafeDirectByteBuf {
    /* JADX INFO: Access modifiers changed from: package-private */
    public UnpooledUnsafeNoCleanerDirectByteBuf(ByteBufAllocator byteBufAllocator, int i4, int i5) {
        super(byteBufAllocator, i4, i5);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.UnpooledUnsafeDirectByteBuf
    public ByteBuffer allocateDirect(int i4) {
        return PlatformDependent.allocateDirectNoCleaner(i4);
    }

    @Override // io.netty.buffer.UnpooledUnsafeDirectByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf capacity(int i4) {
        ensureAccessible();
        if (i4 >= 0 && i4 <= maxCapacity()) {
            int readerIndex = readerIndex();
            int writerIndex = writerIndex();
            int capacity = capacity();
            if (i4 > capacity) {
                setByteBuffer(PlatformDependent.reallocateDirectNoCleaner(this.buffer, i4), false);
            } else if (i4 < capacity) {
                ByteBuffer byteBuffer = this.buffer;
                ByteBuffer allocateDirect = allocateDirect(i4);
                if (readerIndex < i4) {
                    if (writerIndex > i4) {
                        writerIndex(i4);
                    } else {
                        i4 = writerIndex;
                    }
                    byteBuffer.position(readerIndex).limit(i4);
                    allocateDirect.position(readerIndex).limit(i4);
                    allocateDirect.put(byteBuffer);
                    allocateDirect.clear();
                } else {
                    setIndex(i4, i4);
                }
                setByteBuffer(allocateDirect, true);
            }
            return this;
        }
        throw new IllegalArgumentException("newCapacity: " + i4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.UnpooledUnsafeDirectByteBuf
    public void freeDirect(ByteBuffer byteBuffer) {
        PlatformDependent.freeDirectNoCleaner(byteBuffer);
    }
}
