package io.netty.buffer;

import io.netty.util.Recycler;
import io.netty.util.internal.PlatformDependent;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class PooledUnsafeHeapByteBuf extends PooledHeapByteBuf {
    private static final Recycler<PooledUnsafeHeapByteBuf> RECYCLER = new Recycler<PooledUnsafeHeapByteBuf>() { // from class: io.netty.buffer.PooledUnsafeHeapByteBuf.1
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.netty.util.Recycler
        public PooledUnsafeHeapByteBuf newObject(Recycler.Handle<PooledUnsafeHeapByteBuf> handle) {
            return new PooledUnsafeHeapByteBuf(handle, 0);
        }
    };

    private void _setZero(int i4, int i5) {
        checkIndex(i4, i5);
        UnsafeByteBufUtil.setZero((byte[]) this.memory, idx(i4), i5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static PooledUnsafeHeapByteBuf newUnsafeInstance(int i4) {
        PooledUnsafeHeapByteBuf pooledUnsafeHeapByteBuf = RECYCLER.get();
        pooledUnsafeHeapByteBuf.reuse(i4);
        return pooledUnsafeHeapByteBuf;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.PooledHeapByteBuf, io.netty.buffer.AbstractByteBuf
    public byte _getByte(int i4) {
        return UnsafeByteBufUtil.getByte((byte[]) this.memory, idx(i4));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.PooledHeapByteBuf, io.netty.buffer.AbstractByteBuf
    public int _getInt(int i4) {
        return UnsafeByteBufUtil.getInt((byte[]) this.memory, idx(i4));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.PooledHeapByteBuf, io.netty.buffer.AbstractByteBuf
    public int _getIntLE(int i4) {
        return UnsafeByteBufUtil.getIntLE((byte[]) this.memory, idx(i4));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.PooledHeapByteBuf, io.netty.buffer.AbstractByteBuf
    public long _getLong(int i4) {
        return UnsafeByteBufUtil.getLong((byte[]) this.memory, idx(i4));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.PooledHeapByteBuf, io.netty.buffer.AbstractByteBuf
    public long _getLongLE(int i4) {
        return UnsafeByteBufUtil.getLongLE((byte[]) this.memory, idx(i4));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.PooledHeapByteBuf, io.netty.buffer.AbstractByteBuf
    public short _getShort(int i4) {
        return UnsafeByteBufUtil.getShort((byte[]) this.memory, idx(i4));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.PooledHeapByteBuf, io.netty.buffer.AbstractByteBuf
    public short _getShortLE(int i4) {
        return UnsafeByteBufUtil.getShortLE((byte[]) this.memory, idx(i4));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.PooledHeapByteBuf, io.netty.buffer.AbstractByteBuf
    public int _getUnsignedMedium(int i4) {
        return UnsafeByteBufUtil.getUnsignedMedium((byte[]) this.memory, idx(i4));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.PooledHeapByteBuf, io.netty.buffer.AbstractByteBuf
    public int _getUnsignedMediumLE(int i4) {
        return UnsafeByteBufUtil.getUnsignedMediumLE((byte[]) this.memory, idx(i4));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.PooledHeapByteBuf, io.netty.buffer.AbstractByteBuf
    public void _setByte(int i4, int i5) {
        UnsafeByteBufUtil.setByte((byte[]) this.memory, idx(i4), i5);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.PooledHeapByteBuf, io.netty.buffer.AbstractByteBuf
    public void _setInt(int i4, int i5) {
        UnsafeByteBufUtil.setInt((byte[]) this.memory, idx(i4), i5);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.PooledHeapByteBuf, io.netty.buffer.AbstractByteBuf
    public void _setIntLE(int i4, int i5) {
        UnsafeByteBufUtil.setIntLE((byte[]) this.memory, idx(i4), i5);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.PooledHeapByteBuf, io.netty.buffer.AbstractByteBuf
    public void _setLong(int i4, long j4) {
        UnsafeByteBufUtil.setLong((byte[]) this.memory, idx(i4), j4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.PooledHeapByteBuf, io.netty.buffer.AbstractByteBuf
    public void _setLongLE(int i4, long j4) {
        UnsafeByteBufUtil.setLongLE((byte[]) this.memory, idx(i4), j4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.PooledHeapByteBuf, io.netty.buffer.AbstractByteBuf
    public void _setMedium(int i4, int i5) {
        UnsafeByteBufUtil.setMedium((byte[]) this.memory, idx(i4), i5);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.PooledHeapByteBuf, io.netty.buffer.AbstractByteBuf
    public void _setMediumLE(int i4, int i5) {
        UnsafeByteBufUtil.setMediumLE((byte[]) this.memory, idx(i4), i5);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.PooledHeapByteBuf, io.netty.buffer.AbstractByteBuf
    public void _setShort(int i4, int i5) {
        UnsafeByteBufUtil.setShort((byte[]) this.memory, idx(i4), i5);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.PooledHeapByteBuf, io.netty.buffer.AbstractByteBuf
    public void _setShortLE(int i4, int i5) {
        UnsafeByteBufUtil.setShortLE((byte[]) this.memory, idx(i4), i5);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    @Deprecated
    public SwappedByteBuf newSwappedByteBuf() {
        if (PlatformDependent.isUnaligned()) {
            return new UnsafeHeapSwappedByteBuf(this);
        }
        return super.newSwappedByteBuf();
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setZero(int i4, int i5) {
        if (PlatformDependent.javaVersion() >= 7) {
            _setZero(i4, i5);
            return this;
        }
        return super.setZero(i4, i5);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf writeZero(int i4) {
        if (PlatformDependent.javaVersion() >= 7) {
            ensureWritable(i4);
            int i5 = this.writerIndex;
            _setZero(i5, i4);
            this.writerIndex = i5 + i4;
            return this;
        }
        return super.writeZero(i4);
    }

    private PooledUnsafeHeapByteBuf(Recycler.Handle<PooledUnsafeHeapByteBuf> handle, int i4) {
        super(handle, i4);
    }
}
