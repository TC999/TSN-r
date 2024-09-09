package io.netty.buffer;

import io.netty.util.Recycler;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public abstract class PooledByteBuf<T> extends AbstractReferenceCountedByteBuf {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    PoolThreadCache cache;
    protected PoolChunk<T> chunk;
    protected long handle;
    protected int length;
    int maxLength;
    protected T memory;
    protected int offset;
    private final Recycler.Handle<PooledByteBuf<T>> recyclerHandle;
    private ByteBuffer tmpNioBuf;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public PooledByteBuf(Recycler.Handle<? extends PooledByteBuf<T>> handle, int i4) {
        super(i4);
        this.recyclerHandle = handle;
    }

    private void recycle() {
        this.recyclerHandle.recycle(this);
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBufAllocator alloc() {
        return this.chunk.arena.parent;
    }

    @Override // io.netty.buffer.ByteBuf
    public final int capacity() {
        return this.length;
    }

    @Override // io.netty.buffer.AbstractReferenceCountedByteBuf
    protected final void deallocate() {
        long j4 = this.handle;
        if (j4 >= 0) {
            this.handle = -1L;
            this.memory = null;
            PoolChunk<T> poolChunk = this.chunk;
            poolChunk.arena.free(poolChunk, j4, this.maxLength, this.cache);
            recycle();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int idx(int i4) {
        return this.offset + i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void init(PoolChunk<T> poolChunk, long j4, int i4, int i5, int i6, PoolThreadCache poolThreadCache) {
        this.chunk = poolChunk;
        this.handle = j4;
        this.memory = poolChunk.memory;
        this.offset = i4;
        this.length = i5;
        this.maxLength = i6;
        this.tmpNioBuf = null;
        this.cache = poolThreadCache;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void initUnpooled(PoolChunk<T> poolChunk, int i4) {
        this.chunk = poolChunk;
        this.handle = 0L;
        this.memory = poolChunk.memory;
        this.offset = 0;
        this.maxLength = i4;
        this.length = i4;
        this.tmpNioBuf = null;
        this.cache = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final ByteBuffer internalNioBuffer() {
        ByteBuffer byteBuffer = this.tmpNioBuf;
        if (byteBuffer == null) {
            ByteBuffer newInternalNioBuffer = newInternalNioBuffer(this.memory);
            this.tmpNioBuf = newInternalNioBuffer;
            return newInternalNioBuffer;
        }
        return byteBuffer;
    }

    protected abstract ByteBuffer newInternalNioBuffer(T t3);

    @Override // io.netty.buffer.ByteBuf
    public final ByteOrder order() {
        return ByteOrder.BIG_ENDIAN;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public final ByteBuf retainedDuplicate() {
        return PooledDuplicatedByteBuf.newInstance(this, this, readerIndex(), writerIndex());
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public final ByteBuf retainedSlice() {
        int readerIndex = readerIndex();
        return retainedSlice(readerIndex, writerIndex() - readerIndex);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void reuse(int i4) {
        maxCapacity(i4);
        setRefCnt(1);
        setIndex0(0, 0);
        discardMarks();
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf unwrap() {
        return null;
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf capacity(int i4) {
        ensureAccessible();
        PoolChunk<T> poolChunk = this.chunk;
        if (poolChunk.unpooled) {
            if (i4 == this.length) {
                return this;
            }
        } else {
            int i5 = this.length;
            if (i4 <= i5) {
                if (i4 < i5) {
                    int i6 = this.maxLength;
                    if (i4 > (i6 >>> 1)) {
                        if (i6 > 512) {
                            this.length = i4;
                            setIndex(Math.min(readerIndex(), i4), Math.min(writerIndex(), i4));
                            return this;
                        } else if (i4 > i6 - 16) {
                            this.length = i4;
                            setIndex(Math.min(readerIndex(), i4), Math.min(writerIndex(), i4));
                            return this;
                        }
                    }
                }
                return this;
            } else if (i4 <= this.maxLength) {
                this.length = i4;
                return this;
            }
        }
        poolChunk.arena.reallocate(this, i4, true);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public final ByteBuf retainedSlice(int i4, int i5) {
        return PooledSlicedByteBuf.newInstance(this, this, i4, i5);
    }
}
