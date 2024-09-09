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
public class UnpooledUnsafeDirectByteBuf extends AbstractReferenceCountedByteBuf {
    private final ByteBufAllocator alloc;
    ByteBuffer buffer;
    private int capacity;
    private boolean doNotFree;
    long memoryAddress;
    private ByteBuffer tmpNioBuf;

    /* JADX INFO: Access modifiers changed from: protected */
    public UnpooledUnsafeDirectByteBuf(ByteBufAllocator byteBufAllocator, int i4, int i5) {
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
            setByteBuffer(allocateDirect(i4), false);
        } else {
            throw new IllegalArgumentException(String.format("initialCapacity(%d) > maxCapacity(%d)", Integer.valueOf(i4), Integer.valueOf(i5)));
        }
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
        UnsafeByteBufUtil.setByte(addr(i4), i5);
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

    long addr(int i4) {
        return this.memoryAddress + i4;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBufAllocator alloc() {
        return this.alloc;
    }

    protected ByteBuffer allocateDirect(int i4) {
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
        return UnsafeByteBufUtil.copy(this, addr(i4), i4, i5);
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

    protected void freeDirect(ByteBuffer byteBuffer) {
        PlatformDependent.freeDirectBuffer(byteBuffer);
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
    public ByteBuf readBytes(ByteBuffer byteBuffer) {
        int remaining = byteBuffer.remaining();
        checkReadableBytes(remaining);
        getBytes(this.readerIndex, byteBuffer);
        this.readerIndex += remaining;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void setByteBuffer(ByteBuffer byteBuffer, boolean z3) {
        ByteBuffer byteBuffer2;
        if (z3 && (byteBuffer2 = this.buffer) != null) {
            if (this.doNotFree) {
                this.doNotFree = false;
            } else {
                freeDirect(byteBuffer2);
            }
        }
        this.buffer = byteBuffer;
        this.memoryAddress = PlatformDependent.directBufferAddress(byteBuffer);
        this.tmpNioBuf = null;
        this.capacity = byteBuffer.remaining();
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

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf unwrap() {
        return null;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf writeZero(int i4) {
        ensureWritable(i4);
        int i5 = this.writerIndex;
        setZero(i5, i4);
        this.writerIndex = i5 + i4;
        return this;
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
                setByteBuffer(allocateDirect, true);
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
                setByteBuffer(allocateDirect2, true);
            }
            return this;
        }
        throw new IllegalArgumentException("newCapacity: " + i4);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i4, byte[] bArr, int i5, int i6) {
        UnsafeByteBufUtil.getBytes(this, addr(i4), i4, bArr, i5, i6);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i4, byte[] bArr, int i5, int i6) {
        UnsafeByteBufUtil.setBytes(this, addr(i4), i4, bArr, i5, i6);
        return this;
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
        ensureAccessible();
        ByteBuffer internalNioBuffer = internalNioBuffer();
        internalNioBuffer.clear().position(i4).limit(i4 + i5);
        try {
            return scatteringByteChannel.read(internalNioBuffer);
        } catch (ClosedChannelException unused) {
            return -1;
        }
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

    /* JADX INFO: Access modifiers changed from: protected */
    public UnpooledUnsafeDirectByteBuf(ByteBufAllocator byteBufAllocator, ByteBuffer byteBuffer, int i4) {
        this(byteBufAllocator, byteBuffer, i4, true);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int readBytes(FileChannel fileChannel, long j4, int i4) throws IOException {
        checkReadableBytes(i4);
        int bytes = getBytes(this.readerIndex, fileChannel, j4, i4, true);
        this.readerIndex += bytes;
        return bytes;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public UnpooledUnsafeDirectByteBuf(ByteBufAllocator byteBufAllocator, ByteBuffer byteBuffer, int i4, boolean z3) {
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
                        this.doNotFree = !z3;
                        setByteBuffer(byteBuffer.slice().order(ByteOrder.BIG_ENDIAN), false);
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

    @Override // io.netty.buffer.ByteBuf
    public int setBytes(int i4, FileChannel fileChannel, long j4, int i5) throws IOException {
        ensureAccessible();
        ByteBuffer internalNioBuffer = internalNioBuffer();
        internalNioBuffer.clear().position(i4).limit(i4 + i5);
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
        ensureAccessible();
        if (i5 == 0) {
            return 0;
        }
        ByteBuffer internalNioBuffer = z3 ? internalNioBuffer() : this.buffer.duplicate();
        internalNioBuffer.clear().position(i4).limit(i4 + i5);
        return fileChannel.write(internalNioBuffer, j4);
    }
}
