package io.netty.buffer;

import java.nio.ByteBuffer;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
@Deprecated
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public abstract class AbstractDerivedByteBuf extends AbstractByteBuf {
    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractDerivedByteBuf(int i4) {
        super(i4);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuffer internalNioBuffer(int i4, int i5) {
        return nioBuffer(i4, i5);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public boolean isReadOnly() {
        return unwrap().isReadOnly();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuffer nioBuffer(int i4, int i5) {
        return unwrap().nioBuffer(i4, i5);
    }

    @Override // io.netty.util.ReferenceCounted
    public final int refCnt() {
        return unwrap().refCnt();
    }

    @Override // io.netty.util.ReferenceCounted
    public final boolean release() {
        return unwrap().release();
    }

    @Override // io.netty.util.ReferenceCounted
    public final boolean release(int i4) {
        return unwrap().release(i4);
    }

    @Override // io.netty.buffer.ByteBuf, io.netty.util.ReferenceCounted
    public final ByteBuf retain() {
        unwrap().retain();
        return this;
    }

    @Override // io.netty.buffer.ByteBuf, io.netty.util.ReferenceCounted
    public final ByteBuf touch() {
        unwrap().touch();
        return this;
    }

    @Override // io.netty.buffer.ByteBuf, io.netty.util.ReferenceCounted
    public final ByteBuf retain(int i4) {
        unwrap().retain(i4);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf, io.netty.util.ReferenceCounted
    public final ByteBuf touch(Object obj) {
        unwrap().touch(obj);
        return this;
    }
}
