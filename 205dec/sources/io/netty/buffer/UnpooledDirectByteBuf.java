package io.netty.buffer;

import io.netty.util.internal.PlatformDependent;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.FileChannel;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class UnpooledDirectByteBuf extends AbstractReferenceCountedByteBuf {
    private final ByteBufAllocator alloc;
    private ByteBuffer buffer;
    private int capacity;
    private boolean doNotFree;
    private ByteBuffer tmpNioBuf;

    /* JADX INFO: Access modifiers changed from: protected */
    public UnpooledDirectByteBuf(ByteBufAllocator byteBufAllocator, int i4, int i5) {
        super(i5);
        if (byteBufAllocator == null) {
            throw new NullPointerException("alloc");
        }
        if (i4 < 0) {
            throw new IllegalArgumentException("initialCapacity: " + i4);
        } else if (i5 < 0) {
            throw new IllegalArgumentException("maxCapacity: " + i5);
        } else if (i4 <= i5) {
            this.alloc = byteBufAllocator;
            setByteBuffer(ByteBuffer.allocateDirect(i4));
        } else {
            throw new IllegalArgumentException(String.format("initialCapacity(%d) > maxCapacity(%d)", Integer.valueOf(i4), Integer.valueOf(i5)));
        }
    }

    private void setByteBuffer(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2 = this.buffer;
        if (byteBuffer2 != null) {
            if (this.doNotFree) {
                this.doNotFree = false;
            } else {
                freeDirect(byteBuffer2);
            }
        }
        this.buffer = byteBuffer;
        this.tmpNioBuf = null;
        this.capacity = byteBuffer.remaining();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public byte _getByte(int i4) {
        return this.buffer.get(i4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public int _getInt(int i4) {
        return this.buffer.getInt(i4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public int _getIntLE(int i4) {
        return ByteBufUtil.swapInt(this.buffer.getInt(i4));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public long _getLong(int i4) {
        return this.buffer.getLong(i4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public long _getLongLE(int i4) {
        return ByteBufUtil.swapLong(this.buffer.getLong(i4));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public short _getShort(int i4) {
        return this.buffer.getShort(i4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public short _getShortLE(int i4) {
        return ByteBufUtil.swapShort(this.buffer.getShort(i4));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public int _getUnsignedMedium(int i4) {
        return (getByte(i4 + 2) & 255) | ((getByte(i4) & 255) << 16) | ((getByte(i4 + 1) & 255) << 8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public int _getUnsignedMediumLE(int i4) {
        return ((getByte(i4 + 2) & 255) << 16) | (getByte(i4) & 255) | ((getByte(i4 + 1) & 255) << 8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public void _setByte(int i4, int i5) {
        this.buffer.put(i4, (byte) i5);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public void _setInt(int i4, int i5) {
        this.buffer.putInt(i4, i5);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public void _setIntLE(int i4, int i5) {
        this.buffer.putInt(i4, ByteBufUtil.swapInt(i5));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public void _setLong(int i4, long j4) {
        this.buffer.putLong(i4, j4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public void _setLongLE(int i4, long j4) {
        this.buffer.putLong(i4, ByteBufUtil.swapLong(j4));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public void _setMedium(int i4, int i5) {
        setByte(i4, (byte) (i5 >>> 16));
        setByte(i4 + 1, (byte) (i5 >>> 8));
        setByte(i4 + 2, (byte) i5);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public void _setMediumLE(int i4, int i5) {
        setByte(i4, (byte) i5);
        setByte(i4 + 1, (byte) (i5 >>> 8));
        setByte(i4 + 2, (byte) (i5 >>> 16));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public void _setShort(int i4, int i5) {
        this.buffer.putShort(i4, (short) i5);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public void _setShortLE(int i4, int i5) {
        this.buffer.putShort(i4, ByteBufUtil.swapShort((short) i5));
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBufAllocator alloc() {
        return this.alloc;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ByteBuffer allocateDirect(int i4) {
        return ByteBuffer.allocateDirect(i4);
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
    public int capacity() {
        return this.capacity;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf copy(int i4, int i5) {
        ensureAccessible();
        try {
            return alloc().directBuffer(i5, maxCapacity()).writeBytes((ByteBuffer) this.buffer.duplicate().clear().position(i4).limit(i4 + i5));
        } catch (IllegalArgumentException unused) {
            throw new IndexOutOfBoundsException("Too many bytes to read - Need " + (i4 + i5));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractReferenceCountedByteBuf
    public void deallocate() {
        ByteBuffer byteBuffer = this.buffer;
        if (byteBuffer == null) {
            return;
        }
        this.buffer = null;
        if (this.doNotFree) {
            return;
        }
        freeDirect(byteBuffer);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void freeDirect(ByteBuffer byteBuffer) {
        PlatformDependent.freeDirectBuffer(byteBuffer);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public byte getByte(int i4) {
        ensureAccessible();
        return _getByte(i4);
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

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int getInt(int i4) {
        ensureAccessible();
        return _getInt(i4);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public long getLong(int i4) {
        ensureAccessible();
        return _getLong(i4);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public short getShort(int i4) {
        ensureAccessible();
        return _getShort(i4);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int getUnsignedMedium(int i4) {
        ensureAccessible();
        return _getUnsignedMedium(i4);
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
        return (ByteBuffer) internalNioBuffer().clear().position(i4).limit(i4 + i5);
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
        return ((ByteBuffer) this.buffer.duplicate().position(i4).limit(i4 + i5)).slice();
    }

    @Override // io.netty.buffer.ByteBuf
    public int nioBufferCount() {
        return 1;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuffer[] nioBuffers(int i4, int i5) {
        return new ByteBuffer[]{nioBuffer(i4, i5)};
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteOrder order() {
        return ByteOrder.BIG_ENDIAN;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf readBytes(byte[] bArr, int i4, int i5) {
        checkReadableBytes(i5);
        getBytes(this.readerIndex, bArr, i4, i5, true);
        this.readerIndex += i5;
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setByte(int i4, int i5) {
        ensureAccessible();
        _setByte(i4, i5);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i4, ByteBuf byteBuf, int i5, int i6) {
        checkSrcIndex(i4, i6, i5, byteBuf.capacity());
        if (byteBuf.nioBufferCount() > 0) {
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

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setInt(int i4, int i5) {
        ensureAccessible();
        _setInt(i4, i5);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setLong(int i4, long j4) {
        ensureAccessible();
        _setLong(i4, j4);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setMedium(int i4, int i5) {
        ensureAccessible();
        _setMedium(i4, i5);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setShort(int i4, int i5) {
        ensureAccessible();
        _setShort(i4, i5);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf unwrap() {
        return null;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf capacity(int i4) {
        ensureAccessible();
        if (i4 >= 0 && i4 <= maxCapacity()) {
            int readerIndex = readerIndex();
            int writerIndex = writerIndex();
            int i5 = this.capacity;
            if (i4 > i5) {
                ByteBuffer byteBuffer = this.buffer;
                ByteBuffer allocateDirect = allocateDirect(i4);
                byteBuffer.position(0).limit(byteBuffer.capacity());
                allocateDirect.position(0).limit(byteBuffer.capacity());
                allocateDirect.put(byteBuffer);
                allocateDirect.clear();
                setByteBuffer(allocateDirect);
            } else if (i4 < i5) {
                ByteBuffer byteBuffer2 = this.buffer;
                ByteBuffer allocateDirect2 = allocateDirect(i4);
                if (readerIndex < i4) {
                    if (writerIndex > i4) {
                        writerIndex(i4);
                    } else {
                        i4 = writerIndex;
                    }
                    byteBuffer2.position(readerIndex).limit(i4);
                    allocateDirect2.position(readerIndex).limit(i4);
                    allocateDirect2.put(byteBuffer2);
                    allocateDirect2.clear();
                } else {
                    setIndex(i4, i4);
                }
                setByteBuffer(allocateDirect2);
            }
            return this;
        }
        throw new IllegalArgumentException("newCapacity: " + i4);
    }

    private ByteBuffer internalNioBuffer() {
        ByteBuffer byteBuffer = this.tmpNioBuf;
        if (byteBuffer == null) {
            ByteBuffer duplicate = this.buffer.duplicate();
            this.tmpNioBuf = duplicate;
            return duplicate;
        }
        return byteBuffer;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf readBytes(ByteBuffer byteBuffer) {
        int remaining = byteBuffer.remaining();
        checkReadableBytes(remaining);
        getBytes(this.readerIndex, byteBuffer, true);
        this.readerIndex += remaining;
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i4, byte[] bArr, int i5, int i6) {
        checkSrcIndex(i4, i6, i5, bArr.length);
        ByteBuffer internalNioBuffer = internalNioBuffer();
        internalNioBuffer.clear().position(i4).limit(i4 + i6);
        internalNioBuffer.put(bArr, i5, i6);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public UnpooledDirectByteBuf(ByteBufAllocator byteBufAllocator, ByteBuffer byteBuffer, int i4) {
        super(i4);
        if (byteBufAllocator == null) {
            throw new NullPointerException("alloc");
        }
        if (byteBuffer != null) {
            if (byteBuffer.isDirect()) {
                if (!byteBuffer.isReadOnly()) {
                    int remaining = byteBuffer.remaining();
                    if (remaining <= i4) {
                        this.alloc = byteBufAllocator;
                        this.doNotFree = true;
                        setByteBuffer(byteBuffer.slice().order(ByteOrder.BIG_ENDIAN));
                        writerIndex(remaining);
                        return;
                    }
                    throw new IllegalArgumentException(String.format("initialCapacity(%d) > maxCapacity(%d)", Integer.valueOf(remaining), Integer.valueOf(i4)));
                }
                throw new IllegalArgumentException("initialBuffer is a read-only buffer.");
            }
            throw new IllegalArgumentException("initialBuffer is not a direct buffer.");
        }
        throw new NullPointerException("initialBuffer");
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

    private void getBytes(int i4, byte[] bArr, int i5, int i6, boolean z3) {
        ByteBuffer duplicate;
        checkDstIndex(i4, i6, i5, bArr.length);
        if (z3) {
            duplicate = internalNioBuffer();
        } else {
            duplicate = this.buffer.duplicate();
        }
        duplicate.clear().position(i4).limit(i4 + i6);
        duplicate.get(bArr, i5, i6);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int readBytes(GatheringByteChannel gatheringByteChannel, int i4) throws IOException {
        checkReadableBytes(i4);
        int bytes = getBytes(this.readerIndex, gatheringByteChannel, i4, true);
        this.readerIndex += bytes;
        return bytes;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i4, ByteBuffer byteBuffer) {
        ensureAccessible();
        ByteBuffer internalNioBuffer = internalNioBuffer();
        if (byteBuffer == internalNioBuffer) {
            byteBuffer = byteBuffer.duplicate();
        }
        internalNioBuffer.clear().position(i4).limit(i4 + byteBuffer.remaining());
        internalNioBuffer.put(byteBuffer);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int readBytes(FileChannel fileChannel, long j4, int i4) throws IOException {
        checkReadableBytes(i4);
        int bytes = getBytes(this.readerIndex, fileChannel, j4, i4, true);
        this.readerIndex += bytes;
        return bytes;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i4, ByteBuffer byteBuffer) {
        getBytes(i4, byteBuffer, false);
        return this;
    }

    private void getBytes(int i4, ByteBuffer byteBuffer, boolean z3) {
        ByteBuffer duplicate;
        checkIndex(i4);
        if (byteBuffer != null) {
            int min = Math.min(capacity() - i4, byteBuffer.remaining());
            if (z3) {
                duplicate = internalNioBuffer();
            } else {
                duplicate = this.buffer.duplicate();
            }
            duplicate.clear().position(i4).limit(i4 + min);
            byteBuffer.put(duplicate);
            return;
        }
        throw new NullPointerException("dst");
    }

    @Override // io.netty.buffer.ByteBuf
    public int setBytes(int i4, InputStream inputStream, int i5) throws IOException {
        ensureAccessible();
        if (this.buffer.hasArray()) {
            return inputStream.read(this.buffer.array(), this.buffer.arrayOffset() + i4, i5);
        }
        byte[] bArr = new byte[i5];
        int read = inputStream.read(bArr);
        if (read <= 0) {
            return read;
        }
        ByteBuffer internalNioBuffer = internalNioBuffer();
        internalNioBuffer.clear().position(i4);
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
        ensureAccessible();
        if (i5 == 0) {
            return;
        }
        if (this.buffer.hasArray()) {
            outputStream.write(this.buffer.array(), i4 + this.buffer.arrayOffset(), i5);
            return;
        }
        byte[] bArr = new byte[i5];
        if (z3) {
            duplicate = internalNioBuffer();
        } else {
            duplicate = this.buffer.duplicate();
        }
        duplicate.clear().position(i4);
        duplicate.get(bArr);
        outputStream.write(bArr);
    }

    @Override // io.netty.buffer.ByteBuf
    public int setBytes(int i4, ScatteringByteChannel scatteringByteChannel, int i5) throws IOException {
        ensureAccessible();
        internalNioBuffer().clear().position(i4).limit(i4 + i5);
        try {
            return scatteringByteChannel.read(this.tmpNioBuf);
        } catch (ClosedChannelException unused) {
            return -1;
        }
    }

    @Override // io.netty.buffer.ByteBuf
    public int setBytes(int i4, FileChannel fileChannel, long j4, int i5) throws IOException {
        ensureAccessible();
        internalNioBuffer().clear().position(i4).limit(i4 + i5);
        try {
            return fileChannel.read(this.tmpNioBuf, j4);
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
        ensureAccessible();
        if (i5 == 0) {
            return 0;
        }
        if (z3) {
            duplicate = internalNioBuffer();
        } else {
            duplicate = this.buffer.duplicate();
        }
        duplicate.clear().position(i4).limit(i4 + i5);
        return gatheringByteChannel.write(duplicate);
    }

    @Override // io.netty.buffer.ByteBuf
    public int getBytes(int i4, FileChannel fileChannel, long j4, int i5) throws IOException {
        return getBytes(i4, fileChannel, j4, i5, false);
    }

    private int getBytes(int i4, FileChannel fileChannel, long j4, int i5, boolean z3) throws IOException {
        ensureAccessible();
        if (i5 == 0) {
            return 0;
        }
        ByteBuffer internalNioBuffer = z3 ? internalNioBuffer() : this.buffer.duplicate();
        internalNioBuffer.clear().position(i4).limit(i4 + i5);
        return fileChannel.write(internalNioBuffer, j4);
    }
}
