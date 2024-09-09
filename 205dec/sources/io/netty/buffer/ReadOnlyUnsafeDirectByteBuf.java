package io.netty.buffer;

import io.netty.util.internal.PlatformDependent;
import java.nio.ByteBuffer;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class ReadOnlyUnsafeDirectByteBuf extends ReadOnlyByteBufferBuf {
    private final long memoryAddress;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ReadOnlyUnsafeDirectByteBuf(ByteBufAllocator byteBufAllocator, ByteBuffer byteBuffer) {
        super(byteBufAllocator, byteBuffer);
        this.memoryAddress = PlatformDependent.directBufferAddress(byteBuffer);
    }

    private long addr(int i4) {
        return this.memoryAddress + i4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.ReadOnlyByteBufferBuf, io.netty.buffer.AbstractByteBuf
    public byte _getByte(int i4) {
        return UnsafeByteBufUtil.getByte(addr(i4));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.ReadOnlyByteBufferBuf, io.netty.buffer.AbstractByteBuf
    public int _getInt(int i4) {
        return UnsafeByteBufUtil.getInt(addr(i4));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.ReadOnlyByteBufferBuf, io.netty.buffer.AbstractByteBuf
    public long _getLong(int i4) {
        return UnsafeByteBufUtil.getLong(addr(i4));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.ReadOnlyByteBufferBuf, io.netty.buffer.AbstractByteBuf
    public short _getShort(int i4) {
        return UnsafeByteBufUtil.getShort(addr(i4));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.ReadOnlyByteBufferBuf, io.netty.buffer.AbstractByteBuf
    public int _getUnsignedMedium(int i4) {
        return UnsafeByteBufUtil.getUnsignedMedium(addr(i4));
    }

    @Override // io.netty.buffer.ReadOnlyByteBufferBuf, io.netty.buffer.ByteBuf
    public ByteBuf copy(int i4, int i5) {
        checkIndex(i4, i5);
        ByteBuf directBuffer = alloc().directBuffer(i5, maxCapacity());
        if (i5 != 0) {
            if (directBuffer.hasMemoryAddress()) {
                PlatformDependent.copyMemory(addr(i4), directBuffer.memoryAddress(), i5);
                directBuffer.setIndex(0, i5);
            } else {
                directBuffer.writeBytes(this, i4, i5);
            }
        }
        return directBuffer;
    }

    @Override // io.netty.buffer.ReadOnlyByteBufferBuf, io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i4, ByteBuf byteBuf, int i5, int i6) {
        checkIndex(i4, i6);
        if (byteBuf != null) {
            if (i5 >= 0 && i5 <= byteBuf.capacity() - i6) {
                if (byteBuf.hasMemoryAddress()) {
                    PlatformDependent.copyMemory(addr(i4), i5 + byteBuf.memoryAddress(), i6);
                } else if (byteBuf.hasArray()) {
                    PlatformDependent.copyMemory(addr(i4), byteBuf.array(), byteBuf.arrayOffset() + i5, i6);
                } else {
                    byteBuf.setBytes(i5, this, i4, i6);
                }
                return this;
            }
            throw new IndexOutOfBoundsException("dstIndex: " + i5);
        }
        throw new NullPointerException("dst");
    }

    @Override // io.netty.buffer.ReadOnlyByteBufferBuf, io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i4, byte[] bArr, int i5, int i6) {
        checkIndex(i4, i6);
        if (bArr != null) {
            if (i5 < 0 || i5 > bArr.length - i6) {
                throw new IndexOutOfBoundsException(String.format("dstIndex: %d, length: %d (expected: range(0, %d))", Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(bArr.length)));
            }
            if (i6 != 0) {
                PlatformDependent.copyMemory(addr(i4), bArr, i5, i6);
            }
            return this;
        }
        throw new NullPointerException("dst");
    }

    @Override // io.netty.buffer.ReadOnlyByteBufferBuf, io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i4, ByteBuffer byteBuffer) {
        checkIndex(i4);
        if (byteBuffer != null) {
            int min = Math.min(capacity() - i4, byteBuffer.remaining());
            ByteBuffer internalNioBuffer = internalNioBuffer();
            internalNioBuffer.clear().position(i4).limit(i4 + min);
            byteBuffer.put(internalNioBuffer);
            return this;
        }
        throw new NullPointerException("dst");
    }
}
