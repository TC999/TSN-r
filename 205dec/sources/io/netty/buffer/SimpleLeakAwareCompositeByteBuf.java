package io.netty.buffer;

import io.netty.util.ResourceLeak;
import java.nio.ByteOrder;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class SimpleLeakAwareCompositeByteBuf extends WrappedCompositeByteBuf {
    private final ResourceLeak leak;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SimpleLeakAwareCompositeByteBuf(CompositeByteBuf compositeByteBuf, ResourceLeak resourceLeak) {
        super(compositeByteBuf);
        this.leak = resourceLeak;
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf asReadOnly() {
        return new SimpleLeakAwareByteBuf(super.asReadOnly(), this.leak);
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf duplicate() {
        return new SimpleLeakAwareByteBuf(super.duplicate(), this.leak);
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf order(ByteOrder byteOrder) {
        this.leak.record();
        return order() == byteOrder ? this : new SimpleLeakAwareByteBuf(super.order(byteOrder), this.leak);
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf readRetainedSlice(int i4) {
        return new SimpleLeakAwareByteBuf(super.readRetainedSlice(i4), this.leak);
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf readSlice(int i4) {
        return new SimpleLeakAwareByteBuf(super.readSlice(i4), this.leak);
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.AbstractReferenceCountedByteBuf, io.netty.util.ReferenceCounted
    public boolean release() {
        boolean release = super.release();
        if (release) {
            this.leak.close();
        }
        return release;
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf retainedDuplicate() {
        return new SimpleLeakAwareByteBuf(super.retainedDuplicate(), this.leak);
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf retainedSlice() {
        return new SimpleLeakAwareByteBuf(super.retainedSlice(), this.leak);
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf slice() {
        return new SimpleLeakAwareByteBuf(super.slice(), this.leak);
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf retainedSlice(int i4, int i5) {
        return new SimpleLeakAwareByteBuf(super.retainedSlice(i4, i5), this.leak);
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf slice(int i4, int i5) {
        return new SimpleLeakAwareByteBuf(super.slice(i4, i5), this.leak);
    }

    @Override // io.netty.buffer.WrappedCompositeByteBuf, io.netty.buffer.AbstractReferenceCountedByteBuf, io.netty.util.ReferenceCounted
    public boolean release(int i4) {
        boolean release = super.release(i4);
        if (release) {
            this.leak.close();
        }
        return release;
    }
}
