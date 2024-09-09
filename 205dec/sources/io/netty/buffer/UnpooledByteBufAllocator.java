package io.netty.buffer;

import io.netty.util.internal.LongCounter;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.StringUtil;
import java.nio.ByteBuffer;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class UnpooledByteBufAllocator extends AbstractByteBufAllocator {
    public static final UnpooledByteBufAllocator DEFAULT = new UnpooledByteBufAllocator(PlatformDependent.directBufferPreferred());
    private final boolean disableLeakDetector;

    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    private static final class InstrumentedUnpooledDirectByteBuf extends UnpooledDirectByteBuf {
        InstrumentedUnpooledDirectByteBuf(UnpooledByteBufAllocator unpooledByteBufAllocator, int i4, int i5) {
            super(unpooledByteBufAllocator, i4, i5);
        }

        @Override // io.netty.buffer.UnpooledDirectByteBuf
        protected ByteBuffer allocateDirect(int i4) {
            ByteBuffer allocateDirect = super.allocateDirect(i4);
            ((UnpooledByteBufAllocator) alloc()).incrementDirect(allocateDirect.capacity());
            return allocateDirect;
        }

        @Override // io.netty.buffer.UnpooledDirectByteBuf
        protected void freeDirect(ByteBuffer byteBuffer) {
            int capacity = byteBuffer.capacity();
            super.freeDirect(byteBuffer);
            ((UnpooledByteBufAllocator) alloc()).decrementDirect(capacity);
        }
    }

    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    private static final class InstrumentedUnpooledHeapByteBuf extends UnpooledHeapByteBuf {
        InstrumentedUnpooledHeapByteBuf(UnpooledByteBufAllocator unpooledByteBufAllocator, int i4, int i5) {
            super(unpooledByteBufAllocator, i4, i5);
        }

        protected byte[] allocateArray(int i4) {
            byte[] allocateArray = super.allocateArray(i4);
            ((UnpooledByteBufAllocator) alloc()).incrementHeap(allocateArray.length);
            return allocateArray;
        }

        protected void freeArray(byte[] bArr) {
            int length = bArr.length;
            super.freeArray(bArr);
            ((UnpooledByteBufAllocator) alloc()).decrementHeap(length);
        }
    }

    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    private static final class InstrumentedUnpooledUnsafeDirectByteBuf extends UnpooledUnsafeDirectByteBuf {
        InstrumentedUnpooledUnsafeDirectByteBuf(UnpooledByteBufAllocator unpooledByteBufAllocator, int i4, int i5) {
            super(unpooledByteBufAllocator, i4, i5);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.netty.buffer.UnpooledUnsafeDirectByteBuf
        protected ByteBuffer allocateDirect(int i4) {
            ByteBuffer allocateDirect = super/*io.netty.buffer.UnpooledDirectByteBuf*/.allocateDirect(i4);
            ((UnpooledByteBufAllocator) alloc()).incrementDirect(allocateDirect.capacity());
            return allocateDirect;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.netty.buffer.UnpooledUnsafeDirectByteBuf
        protected void freeDirect(ByteBuffer byteBuffer) {
            int capacity = byteBuffer.capacity();
            super/*io.netty.buffer.UnpooledDirectByteBuf*/.freeDirect(byteBuffer);
            ((UnpooledByteBufAllocator) alloc()).decrementDirect(capacity);
        }
    }

    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    private static final class InstrumentedUnpooledUnsafeHeapByteBuf extends UnpooledUnsafeHeapByteBuf {
        InstrumentedUnpooledUnsafeHeapByteBuf(UnpooledByteBufAllocator unpooledByteBufAllocator, int i4, int i5) {
            super(unpooledByteBufAllocator, i4, i5);
        }

        protected byte[] allocateArray(int i4) {
            byte[] allocateArray = super.allocateArray(i4);
            ((UnpooledByteBufAllocator) alloc()).incrementHeap(allocateArray.length);
            return allocateArray;
        }

        protected void freeArray(byte[] bArr) {
            int length = bArr.length;
            super.freeArray(bArr);
            ((UnpooledByteBufAllocator) alloc()).decrementHeap(length);
        }
    }

    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    private static final class InstrumentedUnpooledUnsafeNoCleanerDirectByteBuf extends UnpooledUnsafeNoCleanerDirectByteBuf {
        InstrumentedUnpooledUnsafeNoCleanerDirectByteBuf(UnpooledByteBufAllocator unpooledByteBufAllocator, int i4, int i5) {
            super(unpooledByteBufAllocator, i4, i5);
        }

        @Override // io.netty.buffer.UnpooledUnsafeNoCleanerDirectByteBuf, io.netty.buffer.UnpooledUnsafeDirectByteBuf
        protected ByteBuffer allocateDirect(int i4) {
            ByteBuffer allocateDirect = super.allocateDirect(i4);
            ((UnpooledByteBufAllocator) alloc()).incrementDirect(allocateDirect.capacity());
            return allocateDirect;
        }

        @Override // io.netty.buffer.UnpooledUnsafeNoCleanerDirectByteBuf, io.netty.buffer.UnpooledUnsafeDirectByteBuf
        protected void freeDirect(ByteBuffer byteBuffer) {
            int capacity = byteBuffer.capacity();
            super.freeDirect(byteBuffer);
            ((UnpooledByteBufAllocator) alloc()).decrementDirect(capacity);
        }

        ByteBuffer reallocateDirect(ByteBuffer byteBuffer, int i4) {
            int capacity = byteBuffer.capacity();
            ByteBuffer reallocateDirect = super.reallocateDirect(byteBuffer, i4);
            ((UnpooledByteBufAllocator) alloc()).incrementDirect(reallocateDirect.capacity() - capacity);
            return reallocateDirect;
        }
    }

    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    private static final class UnpooledByteBufAllocatorMetric implements ByteBufAllocatorMetric {
        final LongCounter directCounter;
        final LongCounter heapCounter;

        private UnpooledByteBufAllocatorMetric() {
            this.directCounter = PlatformDependent.newLongCounter();
            this.heapCounter = PlatformDependent.newLongCounter();
        }

        public String toString() {
            return StringUtil.simpleClassName(this) + "(usedHeapMemory: " + usedHeapMemory() + "; usedDirectMemory: " + usedDirectMemory() + ')';
        }

        @Override // io.netty.buffer.ByteBufAllocatorMetric
        public long usedDirectMemory() {
            return this.directCounter.value();
        }

        @Override // io.netty.buffer.ByteBufAllocatorMetric
        public long usedHeapMemory() {
            return this.heapCounter.value();
        }
    }

    public UnpooledByteBufAllocator(boolean z3) {
        this(z3, false);
    }

    @Override // io.netty.buffer.AbstractByteBufAllocator, io.netty.buffer.ByteBufAllocator
    public CompositeByteBuf compositeDirectBuffer(int i4) {
        CompositeByteBuf compositeByteBuf = new CompositeByteBuf(this, true, i4);
        return this.disableLeakDetector ? compositeByteBuf : AbstractByteBufAllocator.toLeakAwareBuffer(compositeByteBuf);
    }

    @Override // io.netty.buffer.AbstractByteBufAllocator, io.netty.buffer.ByteBufAllocator
    public CompositeByteBuf compositeHeapBuffer(int i4) {
        CompositeByteBuf compositeByteBuf = new CompositeByteBuf(this, false, i4);
        return this.disableLeakDetector ? compositeByteBuf : AbstractByteBufAllocator.toLeakAwareBuffer(compositeByteBuf);
    }

    @Override // io.netty.buffer.ByteBufAllocator
    public boolean isDirectBufferPooled() {
        return false;
    }

    @Override // io.netty.buffer.AbstractByteBufAllocator
    protected ByteBuf newDirectBuffer(int i4, int i5) {
        ByteBuf newUnsafeDirectByteBuf = PlatformDependent.hasUnsafe() ? UnsafeByteBufUtil.newUnsafeDirectByteBuf(this, i4, i5) : new UnpooledDirectByteBuf(this, i4, i5);
        return this.disableLeakDetector ? newUnsafeDirectByteBuf : AbstractByteBufAllocator.toLeakAwareBuffer(newUnsafeDirectByteBuf);
    }

    @Override // io.netty.buffer.AbstractByteBufAllocator
    protected ByteBuf newHeapBuffer(int i4, int i5) {
        return PlatformDependent.hasUnsafe() ? new UnpooledUnsafeHeapByteBuf(this, i4, i5) : new UnpooledHeapByteBuf(this, i4, i5);
    }

    public UnpooledByteBufAllocator(boolean z3, boolean z4) {
        super(z3);
        this.disableLeakDetector = z4;
    }
}
