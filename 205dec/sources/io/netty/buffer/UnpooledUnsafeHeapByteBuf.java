package io.netty.buffer;

import io.netty.util.internal.PlatformDependent;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
final class UnpooledUnsafeHeapByteBuf extends UnpooledHeapByteBuf {
    /* JADX INFO: Access modifiers changed from: package-private */
    public UnpooledUnsafeHeapByteBuf(ByteBufAllocator byteBufAllocator, int i4, int i5) {
        super(byteBufAllocator, i4, i5);
    }

    private void _setZero(int i4, int i5) {
        checkIndex(i4, i5);
        UnsafeByteBufUtil.setZero(this.array, i4, i5);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf
    public byte _getByte(int i4) {
        return UnsafeByteBufUtil.getByte(this.array, i4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf
    public int _getInt(int i4) {
        return UnsafeByteBufUtil.getInt(this.array, i4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf
    public int _getIntLE(int i4) {
        return UnsafeByteBufUtil.getIntLE(this.array, i4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf
    public long _getLong(int i4) {
        return UnsafeByteBufUtil.getLong(this.array, i4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf
    public long _getLongLE(int i4) {
        return UnsafeByteBufUtil.getLongLE(this.array, i4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf
    public short _getShort(int i4) {
        return UnsafeByteBufUtil.getShort(this.array, i4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf
    public short _getShortLE(int i4) {
        return UnsafeByteBufUtil.getShortLE(this.array, i4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf
    public int _getUnsignedMedium(int i4) {
        return UnsafeByteBufUtil.getUnsignedMedium(this.array, i4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf
    public int _getUnsignedMediumLE(int i4) {
        return UnsafeByteBufUtil.getUnsignedMediumLE(this.array, i4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf
    public void _setByte(int i4, int i5) {
        UnsafeByteBufUtil.setByte(this.array, i4, i5);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf
    public void _setInt(int i4, int i5) {
        UnsafeByteBufUtil.setInt(this.array, i4, i5);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf
    public void _setIntLE(int i4, int i5) {
        UnsafeByteBufUtil.setIntLE(this.array, i4, i5);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf
    public void _setLong(int i4, long j4) {
        UnsafeByteBufUtil.setLong(this.array, i4, j4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf
    public void _setLongLE(int i4, long j4) {
        UnsafeByteBufUtil.setLongLE(this.array, i4, j4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf
    public void _setMedium(int i4, int i5) {
        UnsafeByteBufUtil.setMedium(this.array, i4, i5);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf
    public void _setMediumLE(int i4, int i5) {
        UnsafeByteBufUtil.setMediumLE(this.array, i4, i5);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf
    public void _setShort(int i4, int i5) {
        UnsafeByteBufUtil.setShort(this.array, i4, i5);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf
    public void _setShortLE(int i4, int i5) {
        UnsafeByteBufUtil.setShortLE(this.array, i4, i5);
    }

    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public byte getByte(int i4) {
        checkIndex(i4);
        return _getByte(i4);
    }

    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int getInt(int i4) {
        checkIndex(i4, 4);
        return _getInt(i4);
    }

    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int getIntLE(int i4) {
        checkIndex(i4, 4);
        return _getIntLE(i4);
    }

    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public long getLong(int i4) {
        checkIndex(i4, 8);
        return _getLong(i4);
    }

    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public long getLongLE(int i4) {
        checkIndex(i4, 8);
        return _getLongLE(i4);
    }

    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public short getShort(int i4) {
        checkIndex(i4, 2);
        return _getShort(i4);
    }

    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public short getShortLE(int i4) {
        checkIndex(i4, 2);
        return _getShortLE(i4);
    }

    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int getUnsignedMedium(int i4) {
        checkIndex(i4, 3);
        return _getUnsignedMedium(i4);
    }

    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int getUnsignedMediumLE(int i4) {
        checkIndex(i4, 3);
        return _getUnsignedMediumLE(i4);
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

    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setByte(int i4, int i5) {
        checkIndex(i4);
        _setByte(i4, i5);
        return this;
    }

    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setInt(int i4, int i5) {
        checkIndex(i4, 4);
        _setInt(i4, i5);
        return this;
    }

    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setIntLE(int i4, int i5) {
        checkIndex(i4, 4);
        _setIntLE(i4, i5);
        return this;
    }

    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setLong(int i4, long j4) {
        checkIndex(i4, 8);
        _setLong(i4, j4);
        return this;
    }

    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setLongLE(int i4, long j4) {
        checkIndex(i4, 8);
        _setLongLE(i4, j4);
        return this;
    }

    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setMedium(int i4, int i5) {
        checkIndex(i4, 3);
        _setMedium(i4, i5);
        return this;
    }

    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setMediumLE(int i4, int i5) {
        checkIndex(i4, 3);
        _setMediumLE(i4, i5);
        return this;
    }

    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setShort(int i4, int i5) {
        checkIndex(i4, 2);
        _setShort(i4, i5);
        return this;
    }

    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setShortLE(int i4, int i5) {
        checkIndex(i4, 2);
        _setShortLE(i4, i5);
        return this;
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
}
