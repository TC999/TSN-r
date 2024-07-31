package io.netty.buffer;

import io.netty.util.Recycler;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
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
    public PooledByteBuf(Recycler.Handle<? extends PooledByteBuf<T>> handle, int i) {
        super(i);
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
        long j = this.handle;
        if (j >= 0) {
            this.handle = -1L;
            this.memory = null;
            PoolChunk<T> poolChunk = this.chunk;
            poolChunk.arena.free(poolChunk, j, this.maxLength, this.cache);
            recycle();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int idx(int i) {
        return this.offset + i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void init(PoolChunk<T> poolChunk, long j, int i, int i2, int i3, PoolThreadCache poolThreadCache) {
        this.chunk = poolChunk;
        this.handle = j;
        this.memory = poolChunk.memory;
        this.offset = i;
        this.length = i2;
        this.maxLength = i3;
        this.tmpNioBuf = null;
        this.cache = poolThreadCache;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void initUnpooled(PoolChunk<T> poolChunk, int i) {
        this.chunk = poolChunk;
        this.handle = 0L;
        this.memory = poolChunk.memory;
        this.offset = 0;
        this.maxLength = i;
        this.length = i;
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

    protected abstract ByteBuffer newInternalNioBuffer(T t);

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
    public final void reuse(int i) {
        maxCapacity(i);
        setRefCnt(1);
        setIndex0(0, 0);
        discardMarks();
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf unwrap() {
        return null;
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf capacity(int i) {
        ensureAccessible();
        PoolChunk<T> poolChunk = this.chunk;
        if (poolChunk.unpooled) {
            if (i == this.length) {
                return this;
            }
        } else {
            int i2 = this.length;
            if (i <= i2) {
                if (i < i2) {
                    int i3 = this.maxLength;
                    if (i > (i3 >>> 1)) {
                        if (i3 > 512) {
                            this.length = i;
                            setIndex(Math.min(readerIndex(), i), Math.min(writerIndex(), i));
                            return this;
                        } else if (i > i3 - 16) {
                            this.length = i;
                            setIndex(Math.min(readerIndex(), i), Math.min(writerIndex(), i));
                            return this;
                        }
                    }
                }
                return this;
            } else if (i <= this.maxLength) {
                this.length = i;
                return this;
            }
        }
        poolChunk.arena.reallocate(this, i, true);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public final ByteBuf retainedSlice(int i, int i2) {
        return PooledSlicedByteBuf.newInstance(this, this, i, i2);
    }
}
