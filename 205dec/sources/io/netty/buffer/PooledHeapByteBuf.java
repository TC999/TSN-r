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
public class PooledHeapByteBuf extends PooledByteBuf<byte[]> {
    private static final Recycler<PooledHeapByteBuf> RECYCLER = new Recycler<PooledHeapByteBuf>() { // from class: io.netty.buffer.PooledHeapByteBuf.1
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.netty.util.Recycler
        public PooledHeapByteBuf newObject(Recycler.Handle<PooledHeapByteBuf> handle) {
            return new PooledHeapByteBuf(handle, 0);
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    public PooledHeapByteBuf(Recycler.Handle<? extends PooledHeapByteBuf> handle, int i4) {
        super(handle, i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static PooledHeapByteBuf newInstance(int i4) {
        PooledHeapByteBuf pooledHeapByteBuf = RECYCLER.get();
        pooledHeapByteBuf.reuse(i4);
        return pooledHeapByteBuf;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public byte _getByte(int i4) {
        return HeapByteBufUtil.getByte((byte[]) this.memory, idx(i4));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public int _getInt(int i4) {
        return HeapByteBufUtil.getInt((byte[]) this.memory, idx(i4));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public int _getIntLE(int i4) {
        return HeapByteBufUtil.getIntLE((byte[]) this.memory, idx(i4));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public long _getLong(int i4) {
        return HeapByteBufUtil.getLong((byte[]) this.memory, idx(i4));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public long _getLongLE(int i4) {
        return HeapByteBufUtil.getLongLE((byte[]) this.memory, idx(i4));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public short _getShort(int i4) {
        return HeapByteBufUtil.getShort((byte[]) this.memory, idx(i4));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public short _getShortLE(int i4) {
        return HeapByteBufUtil.getShortLE((byte[]) this.memory, idx(i4));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public int _getUnsignedMedium(int i4) {
        return HeapByteBufUtil.getUnsignedMedium((byte[]) this.memory, idx(i4));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public int _getUnsignedMediumLE(int i4) {
        return HeapByteBufUtil.getUnsignedMediumLE((byte[]) this.memory, idx(i4));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public void _setByte(int i4, int i5) {
        HeapByteBufUtil.setByte((byte[]) this.memory, idx(i4), i5);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public void _setInt(int i4, int i5) {
        HeapByteBufUtil.setInt((byte[]) this.memory, idx(i4), i5);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public void _setIntLE(int i4, int i5) {
        HeapByteBufUtil.setIntLE((byte[]) this.memory, idx(i4), i5);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public void _setLong(int i4, long j4) {
        HeapByteBufUtil.setLong((byte[]) this.memory, idx(i4), j4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public void _setLongLE(int i4, long j4) {
        HeapByteBufUtil.setLongLE((byte[]) this.memory, idx(i4), j4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public void _setMedium(int i4, int i5) {
        HeapByteBufUtil.setMedium((byte[]) this.memory, idx(i4), i5);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public void _setMediumLE(int i4, int i5) {
        HeapByteBufUtil.setMediumLE((byte[]) this.memory, idx(i4), i5);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public void _setShort(int i4, int i5) {
        HeapByteBufUtil.setShort((byte[]) this.memory, idx(i4), i5);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public void _setShortLE(int i4, int i5) {
        HeapByteBufUtil.setShortLE((byte[]) this.memory, idx(i4), i5);
    }

    @Override // io.netty.buffer.ByteBuf
    public final byte[] array() {
        ensureAccessible();
        return (byte[]) this.memory;
    }

    @Override // io.netty.buffer.ByteBuf
    public final int arrayOffset() {
        return this.offset;
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf copy(int i4, int i5) {
        checkIndex(i4, i5);
        ByteBuf heapBuffer = alloc().heapBuffer(i5, maxCapacity());
        heapBuffer.writeBytes((byte[]) this.memory, idx(i4), i5);
        return heapBuffer;
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf getBytes(int i4, ByteBuf byteBuf, int i5, int i6) {
        checkDstIndex(i4, i6, i5, byteBuf.capacity());
        if (byteBuf.hasMemoryAddress()) {
            PlatformDependent.copyMemory((byte[]) this.memory, idx(i4), i5 + byteBuf.memoryAddress(), i6);
        } else if (byteBuf.hasArray()) {
            getBytes(i4, byteBuf.array(), byteBuf.arrayOffset() + i5, i6);
        } else {
            byteBuf.setBytes(i5, (byte[]) this.memory, idx(i4), i6);
        }
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public final boolean hasArray() {
        return true;
    }

    @Override // io.netty.buffer.ByteBuf
    public final boolean hasMemoryAddress() {
        return false;
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuffer internalNioBuffer(int i4, int i5) {
        checkIndex(i4, i5);
        int idx = idx(i4);
        return (ByteBuffer) internalNioBuffer().clear().position(idx).limit(idx + i5);
    }

    @Override // io.netty.buffer.ByteBuf
    public final boolean isDirect() {
        return false;
    }

    @Override // io.netty.buffer.ByteBuf
    public final long memoryAddress() {
        throw new UnsupportedOperationException();
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuffer nioBuffer(int i4, int i5) {
        checkIndex(i4, i5);
        return ByteBuffer.wrap((byte[]) this.memory, idx(i4), i5).slice();
    }

    @Override // io.netty.buffer.ByteBuf
    public final int nioBufferCount() {
        return 1;
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuffer[] nioBuffers(int i4, int i5) {
        return new ByteBuffer[]{nioBuffer(i4, i5)};
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public final int readBytes(GatheringByteChannel gatheringByteChannel, int i4) throws IOException {
        checkReadableBytes(i4);
        int bytes = getBytes(this.readerIndex, gatheringByteChannel, i4, true);
        this.readerIndex += bytes;
        return bytes;
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf setBytes(int i4, ByteBuf byteBuf, int i5, int i6) {
        checkSrcIndex(i4, i6, i5, byteBuf.capacity());
        if (byteBuf.hasMemoryAddress()) {
            PlatformDependent.copyMemory(byteBuf.memoryAddress() + i5, (byte[]) this.memory, idx(i4), i6);
        } else if (byteBuf.hasArray()) {
            setBytes(i4, byteBuf.array(), byteBuf.arrayOffset() + i5, i6);
        } else {
            byteBuf.getBytes(i5, (byte[]) this.memory, idx(i4), i6);
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.PooledByteBuf
    public final ByteBuffer newInternalNioBuffer(byte[] bArr) {
        return ByteBuffer.wrap(bArr);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public final int readBytes(FileChannel fileChannel, long j4, int i4) throws IOException {
        checkReadableBytes(i4);
        int bytes = getBytes(this.readerIndex, fileChannel, j4, i4, true);
        this.readerIndex += bytes;
        return bytes;
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf getBytes(int i4, byte[] bArr, int i5, int i6) {
        checkDstIndex(i4, i6, i5, bArr.length);
        System.arraycopy(this.memory, idx(i4), bArr, i5, i6);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf setBytes(int i4, byte[] bArr, int i5, int i6) {
        checkSrcIndex(i4, i6, i5, bArr.length);
        System.arraycopy(bArr, i5, this.memory, idx(i4), i6);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf getBytes(int i4, ByteBuffer byteBuffer) {
        checkIndex(i4);
        byteBuffer.put((byte[]) this.memory, idx(i4), Math.min(capacity() - i4, byteBuffer.remaining()));
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf setBytes(int i4, ByteBuffer byteBuffer) {
        int remaining = byteBuffer.remaining();
        checkIndex(i4, remaining);
        byteBuffer.get((byte[]) this.memory, idx(i4), remaining);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf getBytes(int i4, OutputStream outputStream, int i5) throws IOException {
        checkIndex(i4, i5);
        outputStream.write((byte[]) this.memory, idx(i4), i5);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public final int setBytes(int i4, InputStream inputStream, int i5) throws IOException {
        checkIndex(i4, i5);
        return inputStream.read((byte[]) this.memory, idx(i4), i5);
    }

    @Override // io.netty.buffer.ByteBuf
    public final int getBytes(int i4, GatheringByteChannel gatheringByteChannel, int i5) throws IOException {
        return getBytes(i4, gatheringByteChannel, i5, false);
    }

    private int getBytes(int i4, GatheringByteChannel gatheringByteChannel, int i5, boolean z3) throws IOException {
        ByteBuffer wrap;
        checkIndex(i4, i5);
        int idx = idx(i4);
        if (z3) {
            wrap = internalNioBuffer();
        } else {
            wrap = ByteBuffer.wrap((byte[]) this.memory);
        }
        return gatheringByteChannel.write((ByteBuffer) wrap.clear().position(idx).limit(idx + i5));
    }

    @Override // io.netty.buffer.ByteBuf
    public final int setBytes(int i4, ScatteringByteChannel scatteringByteChannel, int i5) throws IOException {
        checkIndex(i4, i5);
        int idx = idx(i4);
        try {
            return scatteringByteChannel.read((ByteBuffer) internalNioBuffer().clear().position(idx).limit(idx + i5));
        } catch (ClosedChannelException unused) {
            return -1;
        }
    }

    @Override // io.netty.buffer.ByteBuf
    public final int setBytes(int i4, FileChannel fileChannel, long j4, int i5) throws IOException {
        checkIndex(i4, i5);
        int idx = idx(i4);
        try {
            return fileChannel.read((ByteBuffer) internalNioBuffer().clear().position(idx).limit(idx + i5), j4);
        } catch (ClosedChannelException unused) {
            return -1;
        }
    }

    @Override // io.netty.buffer.ByteBuf
    public final int getBytes(int i4, FileChannel fileChannel, long j4, int i5) throws IOException {
        return getBytes(i4, fileChannel, j4, i5, false);
    }

    private int getBytes(int i4, FileChannel fileChannel, long j4, int i5, boolean z3) throws IOException {
        checkIndex(i4, i5);
        int idx = idx(i4);
        return fileChannel.write((ByteBuffer) (z3 ? internalNioBuffer() : ByteBuffer.wrap((byte[]) this.memory)).clear().position(idx).limit(idx + i5), j4);
    }
}
