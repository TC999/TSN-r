package io.netty.buffer;

import io.netty.util.Recycler;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.FileChannel;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class PooledDirectByteBuf extends PooledByteBuf<ByteBuffer> {
    private static final Recycler<PooledDirectByteBuf> RECYCLER = new Recycler<PooledDirectByteBuf>() { // from class: io.netty.buffer.PooledDirectByteBuf.1
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.netty.util.Recycler
        public PooledDirectByteBuf newObject(Recycler.Handle<PooledDirectByteBuf> handle) {
            return new PooledDirectByteBuf(handle, 0);
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    public static PooledDirectByteBuf newInstance(int i4) {
        PooledDirectByteBuf pooledDirectByteBuf = RECYCLER.get();
        pooledDirectByteBuf.reuse(i4);
        return pooledDirectByteBuf;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public byte _getByte(int i4) {
        return ((ByteBuffer) this.memory).get(idx(i4));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public int _getInt(int i4) {
        return ((ByteBuffer) this.memory).getInt(idx(i4));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public int _getIntLE(int i4) {
        return ByteBufUtil.swapInt(_getInt(i4));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public long _getLong(int i4) {
        return ((ByteBuffer) this.memory).getLong(idx(i4));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public long _getLongLE(int i4) {
        return ByteBufUtil.swapLong(_getLong(i4));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public short _getShort(int i4) {
        return ((ByteBuffer) this.memory).getShort(idx(i4));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public short _getShortLE(int i4) {
        return ByteBufUtil.swapShort(_getShort(i4));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public int _getUnsignedMedium(int i4) {
        int idx = idx(i4);
        return (((ByteBuffer) this.memory).get(idx + 2) & 255) | ((((ByteBuffer) this.memory).get(idx) & 255) << 16) | ((((ByteBuffer) this.memory).get(idx + 1) & 255) << 8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public int _getUnsignedMediumLE(int i4) {
        int idx = idx(i4);
        return ((((ByteBuffer) this.memory).get(idx + 2) & 255) << 16) | (((ByteBuffer) this.memory).get(idx) & 255) | ((((ByteBuffer) this.memory).get(idx + 1) & 255) << 8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public void _setByte(int i4, int i5) {
        ((ByteBuffer) this.memory).put(idx(i4), (byte) i5);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public void _setInt(int i4, int i5) {
        ((ByteBuffer) this.memory).putInt(idx(i4), i5);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public void _setIntLE(int i4, int i5) {
        _setInt(i4, ByteBufUtil.swapInt(i5));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public void _setLong(int i4, long j4) {
        ((ByteBuffer) this.memory).putLong(idx(i4), j4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public void _setLongLE(int i4, long j4) {
        _setLong(i4, ByteBufUtil.swapLong(j4));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public void _setMedium(int i4, int i5) {
        int idx = idx(i4);
        ((ByteBuffer) this.memory).put(idx, (byte) (i5 >>> 16));
        ((ByteBuffer) this.memory).put(idx + 1, (byte) (i5 >>> 8));
        ((ByteBuffer) this.memory).put(idx + 2, (byte) i5);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public void _setMediumLE(int i4, int i5) {
        int idx = idx(i4);
        ((ByteBuffer) this.memory).put(idx, (byte) i5);
        ((ByteBuffer) this.memory).put(idx + 1, (byte) (i5 >>> 8));
        ((ByteBuffer) this.memory).put(idx + 2, (byte) (i5 >>> 16));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public void _setShort(int i4, int i5) {
        ((ByteBuffer) this.memory).putShort(idx(i4), (short) i5);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public void _setShortLE(int i4, int i5) {
        _setShort(i4, ByteBufUtil.swapShort((short) i5));
    }

    @Override // io.netty.buffer.ByteBuf
    public byte[] array() {
        throw new UnsupportedOperationException("direct buffer");
    }

    @Override // io.netty.buffer.ByteBuf
    public int arrayOffset() {
        throw new UnsupportedOperationException("direct buffer");
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf copy(int i4, int i5) {
        checkIndex(i4, i5);
        ByteBuf directBuffer = alloc().directBuffer(i5, maxCapacity());
        directBuffer.writeBytes(this, i4, i5);
        return directBuffer;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i4, ByteBuf byteBuf, int i5, int i6) {
        checkDstIndex(i4, i6, i5, byteBuf.capacity());
        if (byteBuf.hasArray()) {
            getBytes(i4, byteBuf.array(), byteBuf.arrayOffset() + i5, i6);
        } else if (byteBuf.nioBufferCount() > 0) {
            ByteBuffer[] nioBuffers = byteBuf.nioBuffers(i5, i6);
            for (ByteBuffer byteBuffer : nioBuffers) {
                int remaining = byteBuffer.remaining();
                getBytes(i4, byteBuffer);
                i4 += remaining;
            }
        } else {
            byteBuf.setBytes(i5, this, i4, i6);
        }
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean hasArray() {
        return false;
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean hasMemoryAddress() {
        return false;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuffer internalNioBuffer(int i4, int i5) {
        checkIndex(i4, i5);
        int idx = idx(i4);
        return (ByteBuffer) internalNioBuffer().clear().position(idx).limit(idx + i5);
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean isDirect() {
        return true;
    }

    @Override // io.netty.buffer.ByteBuf
    public long memoryAddress() {
        throw new UnsupportedOperationException();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuffer nioBuffer(int i4, int i5) {
        checkIndex(i4, i5);
        int idx = idx(i4);
        return ((ByteBuffer) ((ByteBuffer) this.memory).duplicate().position(idx).limit(idx + i5)).slice();
    }

    @Override // io.netty.buffer.ByteBuf
    public int nioBufferCount() {
        return 1;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuffer[] nioBuffers(int i4, int i5) {
        return new ByteBuffer[]{nioBuffer(i4, i5)};
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf readBytes(byte[] bArr, int i4, int i5) {
        checkReadableBytes(i5);
        getBytes(this.readerIndex, bArr, i4, i5, true);
        this.readerIndex += i5;
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i4, ByteBuf byteBuf, int i5, int i6) {
        checkSrcIndex(i4, i6, i5, byteBuf.capacity());
        if (byteBuf.hasArray()) {
            setBytes(i4, byteBuf.array(), byteBuf.arrayOffset() + i5, i6);
        } else if (byteBuf.nioBufferCount() > 0) {
            ByteBuffer[] nioBuffers = byteBuf.nioBuffers(i5, i6);
            for (ByteBuffer byteBuffer : nioBuffers) {
                int remaining = byteBuffer.remaining();
                setBytes(i4, byteBuffer);
                i4 += remaining;
            }
        } else {
            byteBuf.getBytes(i5, this, i4, i6);
        }
        return this;
    }

    private PooledDirectByteBuf(Recycler.Handle<PooledDirectByteBuf> handle, int i4) {
        super(handle, i4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.PooledByteBuf
    public ByteBuffer newInternalNioBuffer(ByteBuffer byteBuffer) {
        return byteBuffer.duplicate();
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf readBytes(ByteBuffer byteBuffer) {
        int remaining = byteBuffer.remaining();
        checkReadableBytes(remaining);
        getBytes(this.readerIndex, byteBuffer, true);
        this.readerIndex += remaining;
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf readBytes(OutputStream outputStream, int i4) throws IOException {
        checkReadableBytes(i4);
        getBytes(this.readerIndex, outputStream, i4, true);
        this.readerIndex += i4;
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i4, byte[] bArr, int i5, int i6) {
        getBytes(i4, bArr, i5, i6, false);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i4, byte[] bArr, int i5, int i6) {
        checkSrcIndex(i4, i6, i5, bArr.length);
        ByteBuffer internalNioBuffer = internalNioBuffer();
        int idx = idx(i4);
        internalNioBuffer.clear().position(idx).limit(idx + i6);
        internalNioBuffer.put(bArr, i5, i6);
        return this;
    }

    private void getBytes(int i4, byte[] bArr, int i5, int i6, boolean z3) {
        ByteBuffer duplicate;
        checkDstIndex(i4, i6, i5, bArr.length);
        if (z3) {
            duplicate = internalNioBuffer();
        } else {
            duplicate = ((ByteBuffer) this.memory).duplicate();
        }
        int idx = idx(i4);
        duplicate.clear().position(idx).limit(idx + i6);
        duplicate.get(bArr, i5, i6);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int readBytes(GatheringByteChannel gatheringByteChannel, int i4) throws IOException {
        checkReadableBytes(i4);
        int bytes = getBytes(this.readerIndex, gatheringByteChannel, i4, true);
        this.readerIndex += bytes;
        return bytes;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int readBytes(FileChannel fileChannel, long j4, int i4) throws IOException {
        checkReadableBytes(i4);
        int bytes = getBytes(this.readerIndex, fileChannel, j4, i4, true);
        this.readerIndex += bytes;
        return bytes;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i4, ByteBuffer byteBuffer) {
        checkIndex(i4, byteBuffer.remaining());
        ByteBuffer internalNioBuffer = internalNioBuffer();
        if (byteBuffer == internalNioBuffer) {
            byteBuffer = byteBuffer.duplicate();
        }
        int idx = idx(i4);
        internalNioBuffer.clear().position(idx).limit(idx + byteBuffer.remaining());
        internalNioBuffer.put(byteBuffer);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i4, ByteBuffer byteBuffer) {
        getBytes(i4, byteBuffer, false);
        return this;
    }

    private void getBytes(int i4, ByteBuffer byteBuffer, boolean z3) {
        ByteBuffer duplicate;
        checkIndex(i4);
        int min = Math.min(capacity() - i4, byteBuffer.remaining());
        if (z3) {
            duplicate = internalNioBuffer();
        } else {
            duplicate = ((ByteBuffer) this.memory).duplicate();
        }
        int idx = idx(i4);
        duplicate.clear().position(idx).limit(idx + min);
        byteBuffer.put(duplicate);
    }

    @Override // io.netty.buffer.ByteBuf
    public int setBytes(int i4, InputStream inputStream, int i5) throws IOException {
        checkIndex(i4, i5);
        byte[] bArr = new byte[i5];
        int read = inputStream.read(bArr);
        if (read <= 0) {
            return read;
        }
        ByteBuffer internalNioBuffer = internalNioBuffer();
        internalNioBuffer.clear().position(idx(i4));
        internalNioBuffer.put(bArr, 0, read);
        return read;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i4, OutputStream outputStream, int i5) throws IOException {
        getBytes(i4, outputStream, i5, false);
        return this;
    }

    private void getBytes(int i4, OutputStream outputStream, int i5, boolean z3) throws IOException {
        ByteBuffer duplicate;
        checkIndex(i4, i5);
        if (i5 == 0) {
            return;
        }
        byte[] bArr = new byte[i5];
        if (z3) {
            duplicate = internalNioBuffer();
        } else {
            duplicate = ((ByteBuffer) this.memory).duplicate();
        }
        duplicate.clear().position(idx(i4));
        duplicate.get(bArr);
        outputStream.write(bArr);
    }

    @Override // io.netty.buffer.ByteBuf
    public int setBytes(int i4, ScatteringByteChannel scatteringByteChannel, int i5) throws IOException {
        checkIndex(i4, i5);
        ByteBuffer internalNioBuffer = internalNioBuffer();
        int idx = idx(i4);
        internalNioBuffer.clear().position(idx).limit(idx + i5);
        try {
            return scatteringByteChannel.read(internalNioBuffer);
        } catch (ClosedChannelException unused) {
            return -1;
        }
    }

    @Override // io.netty.buffer.ByteBuf
    public int setBytes(int i4, FileChannel fileChannel, long j4, int i5) throws IOException {
        checkIndex(i4, i5);
        ByteBuffer internalNioBuffer = internalNioBuffer();
        int idx = idx(i4);
        internalNioBuffer.clear().position(idx).limit(idx + i5);
        try {
            return fileChannel.read(internalNioBuffer, j4);
        } catch (ClosedChannelException unused) {
            return -1;
        }
    }

    @Override // io.netty.buffer.ByteBuf
    public int getBytes(int i4, GatheringByteChannel gatheringByteChannel, int i5) throws IOException {
        return getBytes(i4, gatheringByteChannel, i5, false);
    }

    private int getBytes(int i4, GatheringByteChannel gatheringByteChannel, int i5, boolean z3) throws IOException {
        ByteBuffer duplicate;
        checkIndex(i4, i5);
        if (i5 == 0) {
            return 0;
        }
        if (z3) {
            duplicate = internalNioBuffer();
        } else {
            duplicate = ((ByteBuffer) this.memory).duplicate();
        }
        int idx = idx(i4);
        duplicate.clear().position(idx).limit(idx + i5);
        return gatheringByteChannel.write(duplicate);
    }

    @Override // io.netty.buffer.ByteBuf
    public int getBytes(int i4, FileChannel fileChannel, long j4, int i5) throws IOException {
        return getBytes(i4, fileChannel, j4, i5, false);
    }

    private int getBytes(int i4, FileChannel fileChannel, long j4, int i5, boolean z3) throws IOException {
        checkIndex(i4, i5);
        if (i5 == 0) {
            return 0;
        }
        ByteBuffer internalNioBuffer = z3 ? internalNioBuffer() : ((ByteBuffer) this.memory).duplicate();
        int idx = idx(i4);
        internalNioBuffer.clear().position(idx).limit(idx + i5);
        return fileChannel.write(internalNioBuffer, j4);
    }
}
