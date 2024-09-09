package io.netty.buffer;

import io.netty.util.Recycler;
import io.netty.util.ReferenceCounted;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public abstract class AbstractPooledDerivedByteBuf extends AbstractReferenceCountedByteBuf {
    private AbstractByteBuf buffer;
    private final Recycler.Handle<AbstractPooledDerivedByteBuf> recyclerHandle;

    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    private static final class PooledNonRetainedDuplicateByteBuf extends UnpooledDuplicatedByteBuf {
        private final ReferenceCounted referenceCountDelegate;

        PooledNonRetainedDuplicateByteBuf(ReferenceCounted referenceCounted, AbstractByteBuf abstractByteBuf) {
            super(abstractByteBuf);
            this.referenceCountDelegate = referenceCounted;
        }

        @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
        public ByteBuf duplicate() {
            ensureAccessible();
            return new PooledNonRetainedDuplicateByteBuf(this.referenceCountDelegate, this);
        }

        int refCnt0() {
            return this.referenceCountDelegate.refCnt();
        }

        boolean release0() {
            return this.referenceCountDelegate.release();
        }

        ByteBuf retain0() {
            this.referenceCountDelegate.retain();
            return this;
        }

        @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
        public ByteBuf retainedDuplicate() {
            return PooledDuplicatedByteBuf.newInstance(unwrap(), this, readerIndex(), writerIndex());
        }

        @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
        public ByteBuf retainedSlice() {
            return retainedSlice(readerIndex(), capacity());
        }

        @Override // io.netty.buffer.DuplicatedByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
        public ByteBuf slice(int i4, int i5) {
            checkIndex(i4, i5);
            return new PooledNonRetainedSlicedByteBuf(this.referenceCountDelegate, unwrap(), i4, i5);
        }

        ByteBuf touch0() {
            this.referenceCountDelegate.touch();
            return this;
        }

        boolean release0(int i4) {
            return this.referenceCountDelegate.release(i4);
        }

        ByteBuf retain0(int i4) {
            this.referenceCountDelegate.retain(i4);
            return this;
        }

        @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
        public ByteBuf retainedSlice(int i4, int i5) {
            return PooledSlicedByteBuf.newInstance(unwrap(), this, i4, i5);
        }

        ByteBuf touch0(Object obj) {
            this.referenceCountDelegate.touch(obj);
            return this;
        }
    }

    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    private static final class PooledNonRetainedSlicedByteBuf extends UnpooledSlicedByteBuf {
        private final ReferenceCounted referenceCountDelegate;

        PooledNonRetainedSlicedByteBuf(ReferenceCounted referenceCounted, AbstractByteBuf abstractByteBuf, int i4, int i5) {
            super(abstractByteBuf, i4, i5);
            this.referenceCountDelegate = referenceCounted;
        }

        @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
        public ByteBuf duplicate() {
            ensureAccessible();
            return new PooledNonRetainedDuplicateByteBuf(this.referenceCountDelegate, unwrap()).setIndex(idx(readerIndex()), idx(writerIndex()));
        }

        int refCnt0() {
            return this.referenceCountDelegate.refCnt();
        }

        boolean release0() {
            return this.referenceCountDelegate.release();
        }

        ByteBuf retain0() {
            this.referenceCountDelegate.retain();
            return this;
        }

        @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
        public ByteBuf retainedDuplicate() {
            return PooledDuplicatedByteBuf.newInstance(unwrap(), this, idx(readerIndex()), idx(writerIndex()));
        }

        @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
        public ByteBuf retainedSlice() {
            return retainedSlice(0, capacity());
        }

        @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
        public ByteBuf slice(int i4, int i5) {
            checkIndex(i4, i5);
            return new PooledNonRetainedSlicedByteBuf(this.referenceCountDelegate, unwrap(), idx(i4), i5);
        }

        ByteBuf touch0() {
            this.referenceCountDelegate.touch();
            return this;
        }

        boolean release0(int i4) {
            return this.referenceCountDelegate.release(i4);
        }

        ByteBuf retain0(int i4) {
            this.referenceCountDelegate.retain(i4);
            return this;
        }

        @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
        public ByteBuf retainedSlice(int i4, int i5) {
            return PooledSlicedByteBuf.newInstance(unwrap(), this, idx(i4), i5);
        }

        ByteBuf touch0(Object obj) {
            this.referenceCountDelegate.touch(obj);
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public AbstractPooledDerivedByteBuf(Recycler.Handle<? extends AbstractPooledDerivedByteBuf> handle) {
        super(0);
        this.recyclerHandle = handle;
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBufAllocator alloc() {
        return unwrap().alloc();
    }

    @Override // io.netty.buffer.ByteBuf
    public byte[] array() {
        return unwrap().array();
    }

    @Override // io.netty.buffer.AbstractReferenceCountedByteBuf
    protected final void deallocate() {
        AbstractByteBuf unwrap = unwrap();
        this.recyclerHandle.recycle(this);
        unwrap.release();
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean hasArray() {
        return unwrap().hasArray();
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean hasMemoryAddress() {
        return unwrap().hasMemoryAddress();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public final <U extends AbstractPooledDerivedByteBuf> U init(AbstractByteBuf abstractByteBuf, ByteBuf byteBuf, int i4, int i5, int i6) {
        byteBuf.retain();
        this.buffer = abstractByteBuf;
        try {
            maxCapacity(i6);
            setIndex0(i4, i5);
            setRefCnt(1);
            return this;
        } catch (Throwable th) {
            this.buffer = null;
            byteBuf.release();
            throw th;
        }
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuffer internalNioBuffer(int i4, int i5) {
        return nioBuffer(i4, i5);
    }

    @Override // io.netty.buffer.ByteBuf
    public final boolean isDirect() {
        return unwrap().isDirect();
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public boolean isReadOnly() {
        return unwrap().isReadOnly();
    }

    @Override // io.netty.buffer.ByteBuf
    public final int nioBufferCount() {
        return unwrap().nioBufferCount();
    }

    @Override // io.netty.buffer.ByteBuf
    @Deprecated
    public final ByteOrder order() {
        return unwrap().order();
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public final ByteBuf retainedSlice() {
        int readerIndex = readerIndex();
        return retainedSlice(readerIndex, writerIndex() - readerIndex);
    }

    @Override // io.netty.buffer.ByteBuf
    public final AbstractByteBuf unwrap() {
        return this.buffer;
    }
}
