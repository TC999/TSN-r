package io.netty.buffer;

import io.netty.util.ByteProcessor;
import io.netty.util.CharsetUtil;
import io.netty.util.internal.MathUtil;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;
import java.nio.charset.Charset;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public abstract class AbstractUnpooledSlicedByteBuf extends AbstractDerivedByteBuf {
    private final int adjustment;
    private final ByteBuf buffer;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractUnpooledSlicedByteBuf(ByteBuf byteBuf, int i, int i2) {
        super(i2);
        checkSliceOutOfBounds(i, i2, byteBuf);
        if (byteBuf instanceof AbstractUnpooledSlicedByteBuf) {
            AbstractUnpooledSlicedByteBuf abstractUnpooledSlicedByteBuf = (AbstractUnpooledSlicedByteBuf) byteBuf;
            this.buffer = abstractUnpooledSlicedByteBuf.buffer;
            this.adjustment = abstractUnpooledSlicedByteBuf.adjustment + i;
        } else if (byteBuf instanceof DuplicatedByteBuf) {
            this.buffer = byteBuf.unwrap();
            this.adjustment = i;
        } else {
            this.buffer = byteBuf;
            this.adjustment = i;
        }
        initLength(i2);
        writerIndex(i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void checkSliceOutOfBounds(int i, int i2, ByteBuf byteBuf) {
        if (MathUtil.isOutOfBounds(i, i2, byteBuf.capacity())) {
            throw new IndexOutOfBoundsException(byteBuf + ".slice(" + i + ", " + i2 + ')');
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public byte _getByte(int i) {
        return unwrap().getByte(idx(i));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public int _getInt(int i) {
        return unwrap().getInt(idx(i));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public int _getIntLE(int i) {
        return unwrap().getIntLE(idx(i));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public long _getLong(int i) {
        return unwrap().getLong(idx(i));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public long _getLongLE(int i) {
        return unwrap().getLongLE(idx(i));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public short _getShort(int i) {
        return unwrap().getShort(idx(i));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public short _getShortLE(int i) {
        return unwrap().getShortLE(idx(i));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public int _getUnsignedMedium(int i) {
        return unwrap().getUnsignedMedium(idx(i));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public int _getUnsignedMediumLE(int i) {
        return unwrap().getUnsignedMediumLE(idx(i));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public void _setByte(int i, int i2) {
        unwrap().setByte(idx(i), i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public void _setInt(int i, int i2) {
        unwrap().setInt(idx(i), i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public void _setIntLE(int i, int i2) {
        unwrap().setIntLE(idx(i), i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public void _setLong(int i, long j) {
        unwrap().setLong(idx(i), j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public void _setLongLE(int i, long j) {
        unwrap().setLongLE(idx(i), j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public void _setMedium(int i, int i2) {
        unwrap().setMedium(idx(i), i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public void _setMediumLE(int i, int i2) {
        unwrap().setMediumLE(idx(i), i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public void _setShort(int i, int i2) {
        unwrap().setShort(idx(i), i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public void _setShortLE(int i, int i2) {
        unwrap().setShortLE(idx(i), i2);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBufAllocator alloc() {
        return unwrap().alloc();
    }

    @Override // io.netty.buffer.ByteBuf
    public byte[] array() {
        return unwrap().array();
    }

    @Override // io.netty.buffer.ByteBuf
    public int arrayOffset() {
        return idx(unwrap().arrayOffset());
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf capacity(int i) {
        throw new UnsupportedOperationException("sliced buffer");
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf copy(int i, int i2) {
        checkIndex0(i, i2);
        return unwrap().copy(idx(i), i2);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf duplicate() {
        ByteBuf slice = unwrap().slice(this.adjustment, length());
        slice.setIndex(readerIndex(), writerIndex());
        return slice;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int forEachByte(int i, int i2, ByteProcessor byteProcessor) {
        checkIndex0(i, i2);
        int forEachByte = unwrap().forEachByte(idx(i), i2, byteProcessor);
        int i3 = this.adjustment;
        if (forEachByte >= i3) {
            return forEachByte - i3;
        }
        return -1;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int forEachByteDesc(int i, int i2, ByteProcessor byteProcessor) {
        checkIndex0(i, i2);
        int forEachByteDesc = unwrap().forEachByteDesc(idx(i), i2, byteProcessor);
        int i3 = this.adjustment;
        if (forEachByteDesc >= i3) {
            return forEachByteDesc - i3;
        }
        return -1;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public byte getByte(int i) {
        checkIndex0(i, 1);
        return unwrap().getByte(idx(i));
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i, ByteBuf byteBuf, int i2, int i3) {
        checkIndex0(i, i3);
        unwrap().getBytes(idx(i), byteBuf, i2, i3);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CharSequence getCharSequence(int i, int i2, Charset charset) {
        checkIndex0(i, i2);
        return this.buffer.getCharSequence(idx(i), i2, charset);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int getInt(int i) {
        checkIndex0(i, 4);
        return unwrap().getInt(idx(i));
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int getIntLE(int i) {
        checkIndex0(i, 4);
        return unwrap().getIntLE(idx(i));
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public long getLong(int i) {
        checkIndex0(i, 8);
        return unwrap().getLong(idx(i));
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public long getLongLE(int i) {
        checkIndex0(i, 8);
        return unwrap().getLongLE(idx(i));
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public short getShort(int i) {
        checkIndex0(i, 2);
        return unwrap().getShort(idx(i));
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public short getShortLE(int i) {
        checkIndex0(i, 2);
        return unwrap().getShortLE(idx(i));
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int getUnsignedMedium(int i) {
        checkIndex0(i, 3);
        return unwrap().getUnsignedMedium(idx(i));
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int getUnsignedMediumLE(int i) {
        checkIndex0(i, 3);
        return unwrap().getUnsignedMediumLE(idx(i));
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean hasArray() {
        return unwrap().hasArray();
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean hasMemoryAddress() {
        return unwrap().hasMemoryAddress();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int idx(int i) {
        return i + this.adjustment;
    }

    void initLength(int i) {
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean isDirect() {
        return unwrap().isDirect();
    }

    int length() {
        return capacity();
    }

    @Override // io.netty.buffer.ByteBuf
    public long memoryAddress() {
        return unwrap().memoryAddress() + this.adjustment;
    }

    @Override // io.netty.buffer.AbstractDerivedByteBuf, io.netty.buffer.ByteBuf
    public ByteBuffer nioBuffer(int i, int i2) {
        checkIndex0(i, i2);
        return unwrap().nioBuffer(idx(i), i2);
    }

    @Override // io.netty.buffer.ByteBuf
    public int nioBufferCount() {
        return unwrap().nioBufferCount();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuffer[] nioBuffers(int i, int i2) {
        checkIndex0(i, i2);
        return unwrap().nioBuffers(idx(i), i2);
    }

    @Override // io.netty.buffer.ByteBuf
    @Deprecated
    public ByteOrder order() {
        return unwrap().order();
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setByte(int i, int i2) {
        checkIndex0(i, 1);
        unwrap().setByte(idx(i), i2);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i, byte[] bArr, int i2, int i3) {
        checkIndex0(i, i3);
        unwrap().setBytes(idx(i), bArr, i2, i3);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int setCharSequence(int i, CharSequence charSequence, Charset charset) {
        if (charset.equals(CharsetUtil.UTF_8)) {
            checkIndex0(i, ByteBufUtil.utf8MaxBytes(charSequence));
            return ByteBufUtil.writeUtf8(this, idx(i), charSequence, charSequence.length());
        } else if (charset.equals(CharsetUtil.US_ASCII)) {
            int length = charSequence.length();
            checkIndex0(i, length);
            return ByteBufUtil.writeAscii(this, idx(i), charSequence, length);
        } else {
            byte[] bytes = charSequence.toString().getBytes(charset);
            checkIndex0(i, bytes.length);
            this.buffer.setBytes(idx(i), bytes);
            return bytes.length;
        }
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setInt(int i, int i2) {
        checkIndex0(i, 4);
        unwrap().setInt(idx(i), i2);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setIntLE(int i, int i2) {
        checkIndex0(i, 4);
        unwrap().setIntLE(idx(i), i2);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setLong(int i, long j) {
        checkIndex0(i, 8);
        unwrap().setLong(idx(i), j);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setLongLE(int i, long j) {
        checkIndex0(i, 8);
        unwrap().setLongLE(idx(i), j);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setMedium(int i, int i2) {
        checkIndex0(i, 3);
        unwrap().setMedium(idx(i), i2);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setMediumLE(int i, int i2) {
        checkIndex0(i, 3);
        unwrap().setMediumLE(idx(i), i2);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setShort(int i, int i2) {
        checkIndex0(i, 2);
        unwrap().setShort(idx(i), i2);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setShortLE(int i, int i2) {
        checkIndex0(i, 2);
        unwrap().setShortLE(idx(i), i2);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf slice(int i, int i2) {
        checkIndex0(i, i2);
        return unwrap().slice(idx(i), i2);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf unwrap() {
        return this.buffer;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i, byte[] bArr, int i2, int i3) {
        checkIndex0(i, i3);
        unwrap().getBytes(idx(i), bArr, i2, i3);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i, ByteBuf byteBuf, int i2, int i3) {
        checkIndex0(i, i3);
        unwrap().setBytes(idx(i), byteBuf, i2, i3);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i, ByteBuffer byteBuffer) {
        checkIndex0(i, byteBuffer.remaining());
        unwrap().getBytes(idx(i), byteBuffer);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i, ByteBuffer byteBuffer) {
        checkIndex0(i, byteBuffer.remaining());
        unwrap().setBytes(idx(i), byteBuffer);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i, OutputStream outputStream, int i2) throws IOException {
        checkIndex0(i, i2);
        unwrap().getBytes(idx(i), outputStream, i2);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public int setBytes(int i, InputStream inputStream, int i2) throws IOException {
        checkIndex0(i, i2);
        return unwrap().setBytes(idx(i), inputStream, i2);
    }

    @Override // io.netty.buffer.ByteBuf
    public int getBytes(int i, GatheringByteChannel gatheringByteChannel, int i2) throws IOException {
        checkIndex0(i, i2);
        return unwrap().getBytes(idx(i), gatheringByteChannel, i2);
    }

    @Override // io.netty.buffer.ByteBuf
    public int setBytes(int i, ScatteringByteChannel scatteringByteChannel, int i2) throws IOException {
        checkIndex0(i, i2);
        return unwrap().setBytes(idx(i), scatteringByteChannel, i2);
    }

    @Override // io.netty.buffer.ByteBuf
    public int getBytes(int i, FileChannel fileChannel, long j, int i2) throws IOException {
        checkIndex0(i, i2);
        return unwrap().getBytes(idx(i), fileChannel, j, i2);
    }

    @Override // io.netty.buffer.ByteBuf
    public int setBytes(int i, FileChannel fileChannel, long j, int i2) throws IOException {
        checkIndex0(i, i2);
        return unwrap().setBytes(idx(i), fileChannel, j, i2);
    }
}
