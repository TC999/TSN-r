package io.netty.buffer;

import io.netty.util.internal.PlatformDependent;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
final class UnsafeHeapSwappedByteBuf extends AbstractUnsafeSwappedByteBuf {
    /* JADX INFO: Access modifiers changed from: package-private */
    public UnsafeHeapSwappedByteBuf(AbstractByteBuf abstractByteBuf) {
        super(abstractByteBuf);
    }

    private static int idx(ByteBuf byteBuf, int i4) {
        return byteBuf.arrayOffset() + i4;
    }

    @Override // io.netty.buffer.AbstractUnsafeSwappedByteBuf
    protected int _getInt(AbstractByteBuf abstractByteBuf, int i4) {
        return PlatformDependent.getInt(abstractByteBuf.array(), idx(abstractByteBuf, i4));
    }

    @Override // io.netty.buffer.AbstractUnsafeSwappedByteBuf
    protected long _getLong(AbstractByteBuf abstractByteBuf, int i4) {
        return PlatformDependent.getLong(abstractByteBuf.array(), idx(abstractByteBuf, i4));
    }

    @Override // io.netty.buffer.AbstractUnsafeSwappedByteBuf
    protected short _getShort(AbstractByteBuf abstractByteBuf, int i4) {
        return PlatformDependent.getShort(abstractByteBuf.array(), idx(abstractByteBuf, i4));
    }

    @Override // io.netty.buffer.AbstractUnsafeSwappedByteBuf
    protected void _setInt(AbstractByteBuf abstractByteBuf, int i4, int i5) {
        PlatformDependent.putInt(abstractByteBuf.array(), idx(abstractByteBuf, i4), i5);
    }

    @Override // io.netty.buffer.AbstractUnsafeSwappedByteBuf
    protected void _setLong(AbstractByteBuf abstractByteBuf, int i4, long j4) {
        PlatformDependent.putLong(abstractByteBuf.array(), idx(abstractByteBuf, i4), j4);
    }

    @Override // io.netty.buffer.AbstractUnsafeSwappedByteBuf
    protected void _setShort(AbstractByteBuf abstractByteBuf, int i4, short s3) {
        PlatformDependent.putShort(abstractByteBuf.array(), idx(abstractByteBuf, i4), s3);
    }
}
