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
public class UnpooledHeapByteBuf extends AbstractReferenceCountedByteBuf {
    private final ByteBufAllocator alloc;
    byte[] array;
    private ByteBuffer tmpNioBuf;

    /* JADX INFO: Access modifiers changed from: protected */
    public UnpooledHeapByteBuf(ByteBufAllocator byteBufAllocator, int i4, int i5) {
        this(byteBufAllocator, new byte[i4], 0, 0, i5);
    }

    private void setArray(byte[] bArr) {
        this.array = bArr;
        this.tmpNioBuf = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public byte _getByte(int i4) {
        return HeapByteBufUtil.getByte(this.array, i4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public int _getInt(int i4) {
        return HeapByteBufUtil.getInt(this.array, i4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public int _getIntLE(int i4) {
        return HeapByteBufUtil.getIntLE(this.array, i4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public long _getLong(int i4) {
        return HeapByteBufUtil.getLong(this.array, i4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public long _getLongLE(int i4) {
        return HeapByteBufUtil.getLongLE(this.array, i4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public short _getShort(int i4) {
        return HeapByteBufUtil.getShort(this.array, i4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public short _getShortLE(int i4) {
        return HeapByteBufUtil.getShortLE(this.array, i4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public int _getUnsignedMedium(int i4) {
        return HeapByteBufUtil.getUnsignedMedium(this.array, i4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public int _getUnsignedMediumLE(int i4) {
        return HeapByteBufUtil.getUnsignedMediumLE(this.array, i4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public void _setByte(int i4, int i5) {
        HeapByteBufUtil.setByte(this.array, i4, i5);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public void _setInt(int i4, int i5) {
        HeapByteBufUtil.setInt(this.array, i4, i5);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public void _setIntLE(int i4, int i5) {
        HeapByteBufUtil.setIntLE(this.array, i4, i5);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public void _setLong(int i4, long j4) {
        HeapByteBufUtil.setLong(this.array, i4, j4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public void _setLongLE(int i4, long j4) {
        HeapByteBufUtil.setLongLE(this.array, i4, j4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public void _setMedium(int i4, int i5) {
        HeapByteBufUtil.setMedium(this.array, i4, i5);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public void _setMediumLE(int i4, int i5) {
        HeapByteBufUtil.setMediumLE(this.array, i4, i5);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public void _setShort(int i4, int i5) {
        HeapByteBufUtil.setShort(this.array, i4, i5);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public void _setShortLE(int i4, int i5) {
        HeapByteBufUtil.setShortLE(this.array, i4, i5);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBufAllocator alloc() {
        return this.alloc;
    }

    @Override // io.netty.buffer.ByteBuf
    public byte[] array() {
        ensureAccessible();
        return this.array;
    }

    @Override // io.netty.buffer.ByteBuf
    public int arrayOffset() {
        return 0;
    }

    @Override // io.netty.buffer.ByteBuf
    public int capacity() {
        ensureAccessible();
        return this.array.length;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf copy(int i4, int i5) {
        checkIndex(i4, i5);
        byte[] bArr = new byte[i5];
        System.arraycopy(this.array, i4, bArr, 0, i5);
        return new UnpooledHeapByteBuf(alloc(), bArr, maxCapacity());
    }

    @Override // io.netty.buffer.AbstractReferenceCountedByteBuf
    protected void deallocate() {
        this.array = null;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public byte getByte(int i4) {
        ensureAccessible();
        return _getByte(i4);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i4, ByteBuf byteBuf, int i5, int i6) {
        checkDstIndex(i4, i6, i5, byteBuf.capacity());
        if (byteBuf.hasMemoryAddress()) {
            PlatformDependent.copyMemory(this.array, i4, i5 + byteBuf.memoryAddress(), i6);
        } else if (byteBuf.hasArray()) {
            getBytes(i4, byteBuf.array(), byteBuf.arrayOffset() + i5, i6);
        } else {
            byteBuf.setBytes(i5, this.array, i4, i6);
        }
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int getInt(int i4) {
        ensureAccessible();
        return _getInt(i4);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int getIntLE(int i4) {
        ensureAccessible();
        return _getIntLE(i4);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public long getLong(int i4) {
        ensureAccessible();
        return _getLong(i4);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public long getLongLE(int i4) {
        ensureAccessible();
        return _getLongLE(i4);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public short getShort(int i4) {
        ensureAccessible();
        return _getShort(i4);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public short getShortLE(int i4) {
        ensureAccessible();
        return _getShortLE(i4);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int getUnsignedMedium(int i4) {
        ensureAccessible();
        return _getUnsignedMedium(i4);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int getUnsignedMediumLE(int i4) {
        ensureAccessible();
        return _getUnsignedMediumLE(i4);
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean hasArray() {
        return true;
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
        return false;
    }

    @Override // io.netty.buffer.ByteBuf
    public long memoryAddress() {
        throw new UnsupportedOperationException();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuffer nioBuffer(int i4, int i5) {
        ensureAccessible();
        return ByteBuffer.wrap(this.array, i4, i5).slice();
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
    public int readBytes(GatheringByteChannel gatheringByteChannel, int i4) throws IOException {
        checkReadableBytes(i4);
        int bytes = getBytes(this.readerIndex, gatheringByteChannel, i4, true);
        this.readerIndex += bytes;
        return bytes;
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
        if (byteBuf.hasMemoryAddress()) {
            PlatformDependent.copyMemory(byteBuf.memoryAddress() + i5, this.array, i4, i6);
        } else if (byteBuf.hasArray()) {
            setBytes(i4, byteBuf.array(), byteBuf.arrayOffset() + i5, i6);
        } else {
            byteBuf.getBytes(i5, this.array, i4, i6);
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
    public ByteBuf setIntLE(int i4, int i5) {
        ensureAccessible();
        _setIntLE(i4, i5);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setLong(int i4, long j4) {
        ensureAccessible();
        _setLong(i4, j4);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setLongLE(int i4, long j4) {
        ensureAccessible();
        _setLongLE(i4, j4);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setMedium(int i4, int i5) {
        ensureAccessible();
        _setMedium(i4, i5);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setMediumLE(int i4, int i5) {
        ensureAccessible();
        _setMediumLE(i4, i5);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setShort(int i4, int i5) {
        ensureAccessible();
        _setShort(i4, i5);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setShortLE(int i4, int i5) {
        ensureAccessible();
        _setShortLE(i4, i5);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf unwrap() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public UnpooledHeapByteBuf(ByteBufAllocator byteBufAllocator, byte[] bArr, int i4) {
        this(byteBufAllocator, bArr, 0, bArr.length, i4);
    }

    private UnpooledHeapByteBuf(ByteBufAllocator byteBufAllocator, byte[] bArr, int i4, int i5, int i6) {
        super(i6);
        if (byteBufAllocator == null) {
            throw new NullPointerException("alloc");
        }
        if (bArr != null) {
            if (bArr.length <= i6) {
                this.alloc = byteBufAllocator;
                setArray(bArr);
                setIndex(i4, i5);
                return;
            }
            throw new IllegalArgumentException(String.format("initialCapacity(%d) > maxCapacity(%d)", Integer.valueOf(bArr.length), Integer.valueOf(i6)));
        }
        throw new NullPointerException("initialArray");
    }

    private ByteBuffer internalNioBuffer() {
        ByteBuffer byteBuffer = this.tmpNioBuf;
        if (byteBuffer == null) {
            ByteBuffer wrap = ByteBuffer.wrap(this.array);
            this.tmpNioBuf = wrap;
            return wrap;
        }
        return byteBuffer;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf capacity(int i4) {
        ensureAccessible();
        if (i4 >= 0 && i4 <= maxCapacity()) {
            byte[] bArr = this.array;
            int length = bArr.length;
            if (i4 > length) {
                byte[] bArr2 = new byte[i4];
                System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                setArray(bArr2);
            } else if (i4 < length) {
                byte[] bArr3 = new byte[i4];
                int readerIndex = readerIndex();
                if (readerIndex < i4) {
                    int writerIndex = writerIndex();
                    if (writerIndex > i4) {
                        writerIndex(i4);
                    } else {
                        i4 = writerIndex;
                    }
                    System.arraycopy(this.array, readerIndex, bArr3, readerIndex, i4 - readerIndex);
                } else {
                    setIndex(i4, i4);
                }
                setArray(bArr3);
            }
            return this;
        }
        throw new IllegalArgumentException("newCapacity: " + i4);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int readBytes(FileChannel fileChannel, long j4, int i4) throws IOException {
        checkReadableBytes(i4);
        int bytes = getBytes(this.readerIndex, fileChannel, j4, i4, true);
        this.readerIndex += bytes;
        return bytes;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i4, byte[] bArr, int i5, int i6) {
        checkDstIndex(i4, i6, i5, bArr.length);
        System.arraycopy(this.array, i4, bArr, i5, i6);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i4, byte[] bArr, int i5, int i6) {
        checkSrcIndex(i4, i6, i5, bArr.length);
        System.arraycopy(bArr, i5, this.array, i4, i6);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i4, ByteBuffer byteBuffer) {
        ensureAccessible();
        byteBuffer.put(this.array, i4, Math.min(capacity() - i4, byteBuffer.remaining()));
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i4, ByteBuffer byteBuffer) {
        ensureAccessible();
        byteBuffer.get(this.array, i4, byteBuffer.remaining());
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i4, OutputStream outputStream, int i5) throws IOException {
        ensureAccessible();
        outputStream.write(this.array, i4, i5);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public int setBytes(int i4, InputStream inputStream, int i5) throws IOException {
        ensureAccessible();
        return inputStream.read(this.array, i4, i5);
    }

    @Override // io.netty.buffer.ByteBuf
    public int getBytes(int i4, GatheringByteChannel gatheringByteChannel, int i5) throws IOException {
        ensureAccessible();
        return getBytes(i4, gatheringByteChannel, i5, false);
    }

    @Override // io.netty.buffer.ByteBuf
    public int setBytes(int i4, ScatteringByteChannel scatteringByteChannel, int i5) throws IOException {
        ensureAccessible();
        try {
            return scatteringByteChannel.read((ByteBuffer) internalNioBuffer().clear().position(i4).limit(i4 + i5));
        } catch (ClosedChannelException unused) {
            return -1;
        }
    }

    @Override // io.netty.buffer.ByteBuf
    public int getBytes(int i4, FileChannel fileChannel, long j4, int i5) throws IOException {
        ensureAccessible();
        return getBytes(i4, fileChannel, j4, i5, false);
    }

    @Override // io.netty.buffer.ByteBuf
    public int setBytes(int i4, FileChannel fileChannel, long j4, int i5) throws IOException {
        ensureAccessible();
        try {
            return fileChannel.read((ByteBuffer) internalNioBuffer().clear().position(i4).limit(i4 + i5), j4);
        } catch (ClosedChannelException unused) {
            return -1;
        }
    }

    private int getBytes(int i4, GatheringByteChannel gatheringByteChannel, int i5, boolean z3) throws IOException {
        ByteBuffer wrap;
        ensureAccessible();
        if (z3) {
            wrap = internalNioBuffer();
        } else {
            wrap = ByteBuffer.wrap(this.array);
        }
        return gatheringByteChannel.write((ByteBuffer) wrap.clear().position(i4).limit(i4 + i5));
    }

    private int getBytes(int i4, FileChannel fileChannel, long j4, int i5, boolean z3) throws IOException {
        ensureAccessible();
        return fileChannel.write((ByteBuffer) (z3 ? internalNioBuffer() : ByteBuffer.wrap(this.array)).clear().position(i4).limit(i4 + i5), j4);
    }
}
