package io.netty.buffer;

import io.netty.util.Recycler;
import io.netty.util.internal.PlatformDependent;
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
public final class PooledUnsafeDirectByteBuf extends PooledByteBuf<ByteBuffer> {
    private static final Recycler<PooledUnsafeDirectByteBuf> RECYCLER = new Recycler<PooledUnsafeDirectByteBuf>() { // from class: io.netty.buffer.PooledUnsafeDirectByteBuf.1
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.netty.util.Recycler
        public PooledUnsafeDirectByteBuf newObject(Recycler.Handle<PooledUnsafeDirectByteBuf> handle) {
            return new PooledUnsafeDirectByteBuf(handle, 0);
        }
    };
    private long memoryAddress;

    private long addr(int i4) {
        return this.memoryAddress + i4;
    }

    private void initMemoryAddress() {
        this.memoryAddress = PlatformDependent.directBufferAddress((ByteBuffer) this.memory) + this.offset;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static PooledUnsafeDirectByteBuf newInstance(int i4) {
        PooledUnsafeDirectByteBuf pooledUnsafeDirectByteBuf = RECYCLER.get();
        pooledUnsafeDirectByteBuf.reuse(i4);
        return pooledUnsafeDirectByteBuf;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public byte _getByte(int i4) {
        return UnsafeByteBufUtil.getByte(addr(i4));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public int _getInt(int i4) {
        return UnsafeByteBufUtil.getInt(addr(i4));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public int _getIntLE(int i4) {
        return UnsafeByteBufUtil.getIntLE(addr(i4));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public long _getLong(int i4) {
        return UnsafeByteBufUtil.getLong(addr(i4));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public long _getLongLE(int i4) {
        return UnsafeByteBufUtil.getLongLE(addr(i4));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public short _getShort(int i4) {
        return UnsafeByteBufUtil.getShort(addr(i4));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public short _getShortLE(int i4) {
        return UnsafeByteBufUtil.getShortLE(addr(i4));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public int _getUnsignedMedium(int i4) {
        return UnsafeByteBufUtil.getUnsignedMedium(addr(i4));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public int _getUnsignedMediumLE(int i4) {
        return UnsafeByteBufUtil.getUnsignedMediumLE(addr(i4));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public void _setByte(int i4, int i5) {
        UnsafeByteBufUtil.setByte(addr(i4), (byte) i5);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public void _setInt(int i4, int i5) {
        UnsafeByteBufUtil.setInt(addr(i4), i5);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public void _setIntLE(int i4, int i5) {
        UnsafeByteBufUtil.setIntLE(addr(i4), i5);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public void _setLong(int i4, long j4) {
        UnsafeByteBufUtil.setLong(addr(i4), j4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public void _setLongLE(int i4, long j4) {
        UnsafeByteBufUtil.setLongLE(addr(i4), j4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public void _setMedium(int i4, int i5) {
        UnsafeByteBufUtil.setMedium(addr(i4), i5);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public void _setMediumLE(int i4, int i5) {
        UnsafeByteBufUtil.setMediumLE(addr(i4), i5);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public void _setShort(int i4, int i5) {
        UnsafeByteBufUtil.setShort(addr(i4), i5);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public void _setShortLE(int i4, int i5) {
        UnsafeByteBufUtil.setShortLE(addr(i4), i5);
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
        return UnsafeByteBufUtil.copy(this, addr(i4), i4, i5);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i4, ByteBuf byteBuf, int i5, int i6) {
        UnsafeByteBufUtil.getBytes(this, addr(i4), i4, byteBuf, i5, i6);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean hasArray() {
        return false;
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean hasMemoryAddress() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // io.netty.buffer.PooledByteBuf
    public void init(PoolChunk<ByteBuffer> poolChunk, long j4, int i4, int i5, int i6, PoolThreadCache poolThreadCache) {
        super.init(poolChunk, j4, i4, i5, i6, poolThreadCache);
        initMemoryAddress();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // io.netty.buffer.PooledByteBuf
    public void initUnpooled(PoolChunk<ByteBuffer> poolChunk, int i4) {
        super.initUnpooled(poolChunk, i4);
        initMemoryAddress();
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
        ensureAccessible();
        return this.memoryAddress;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public SwappedByteBuf newSwappedByteBuf() {
        if (PlatformDependent.isUnaligned()) {
            return new UnsafeDirectSwappedByteBuf(this);
        }
        return super.newSwappedByteBuf();
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
    public ByteBuf readBytes(ByteBuffer byteBuffer) {
        int remaining = byteBuffer.remaining();
        checkReadableBytes(remaining);
        getBytes(this.readerIndex, byteBuffer);
        this.readerIndex += remaining;
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i4, ByteBuf byteBuf, int i5, int i6) {
        UnsafeByteBufUtil.setBytes(this, addr(i4), i4, byteBuf, i5, i6);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setZero(int i4, int i5) {
        UnsafeByteBufUtil.setZero(this, addr(i4), i4, i5);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf writeZero(int i4) {
        ensureWritable(i4);
        int i5 = this.writerIndex;
        setZero(i5, i4);
        this.writerIndex = i5 + i4;
        return this;
    }

    private PooledUnsafeDirectByteBuf(Recycler.Handle<PooledUnsafeDirectByteBuf> handle, int i4) {
        super(handle, i4);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i4, byte[] bArr, int i5, int i6) {
        UnsafeByteBufUtil.getBytes(this, addr(i4), i4, bArr, i5, i6);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.PooledByteBuf
    public ByteBuffer newInternalNioBuffer(ByteBuffer byteBuffer) {
        return byteBuffer.duplicate();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i4, byte[] bArr, int i5, int i6) {
        UnsafeByteBufUtil.setBytes(this, addr(i4), i4, bArr, i5, i6);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i4, ByteBuffer byteBuffer) {
        UnsafeByteBufUtil.getBytes(this, addr(i4), i4, byteBuffer);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i4, ByteBuffer byteBuffer) {
        UnsafeByteBufUtil.setBytes(this, addr(i4), i4, byteBuffer);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i4, OutputStream outputStream, int i5) throws IOException {
        UnsafeByteBufUtil.getBytes(this, addr(i4), i4, outputStream, i5);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public int setBytes(int i4, InputStream inputStream, int i5) throws IOException {
        return UnsafeByteBufUtil.setBytes(this, addr(i4), i4, inputStream, i5);
    }

    @Override // io.netty.buffer.ByteBuf
    public int getBytes(int i4, GatheringByteChannel gatheringByteChannel, int i5) throws IOException {
        return getBytes(i4, gatheringByteChannel, i5, false);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int readBytes(GatheringByteChannel gatheringByteChannel, int i4) throws IOException {
        checkReadableBytes(i4);
        int bytes = getBytes(this.readerIndex, gatheringByteChannel, i4, true);
        this.readerIndex += bytes;
        return bytes;
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

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int readBytes(FileChannel fileChannel, long j4, int i4) throws IOException {
        checkReadableBytes(i4);
        int bytes = getBytes(this.readerIndex, fileChannel, j4, i4, true);
        this.readerIndex += bytes;
        return bytes;
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
