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
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public abstract class AbstractUnpooledSlicedByteBuf extends AbstractDerivedByteBuf {
    private final int adjustment;
    private final ByteBuf buffer;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractUnpooledSlicedByteBuf(ByteBuf byteBuf, int i4, int i5) {
        super(i5);
        checkSliceOutOfBounds(i4, i5, byteBuf);
        if (byteBuf instanceof AbstractUnpooledSlicedByteBuf) {
            AbstractUnpooledSlicedByteBuf abstractUnpooledSlicedByteBuf = (AbstractUnpooledSlicedByteBuf) byteBuf;
            this.buffer = abstractUnpooledSlicedByteBuf.buffer;
            this.adjustment = abstractUnpooledSlicedByteBuf.adjustment + i4;
        } else if (byteBuf instanceof DuplicatedByteBuf) {
            this.buffer = byteBuf.unwrap();
            this.adjustment = i4;
        } else {
            this.buffer = byteBuf;
            this.adjustment = i4;
        }
        initLength(i5);
        writerIndex(i5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void checkSliceOutOfBounds(int i4, int i5, ByteBuf byteBuf) {
        if (MathUtil.isOutOfBounds(i4, i5, byteBuf.capacity())) {
            throw new IndexOutOfBoundsException(byteBuf + ".slice(" + i4 + ", " + i5 + ')');
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public byte _getByte(int i4) {
        return unwrap().getByte(idx(i4));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public int _getInt(int i4) {
        return unwrap().getInt(idx(i4));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public int _getIntLE(int i4) {
        return unwrap().getIntLE(idx(i4));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public long _getLong(int i4) {
        return unwrap().getLong(idx(i4));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public long _getLongLE(int i4) {
        return unwrap().getLongLE(idx(i4));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public short _getShort(int i4) {
        return unwrap().getShort(idx(i4));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public short _getShortLE(int i4) {
        return unwrap().getShortLE(idx(i4));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public int _getUnsignedMedium(int i4) {
        return unwrap().getUnsignedMedium(idx(i4));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public int _getUnsignedMediumLE(int i4) {
        return unwrap().getUnsignedMediumLE(idx(i4));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public void _setByte(int i4, int i5) {
        unwrap().setByte(idx(i4), i5);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public void _setInt(int i4, int i5) {
        unwrap().setInt(idx(i4), i5);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public void _setIntLE(int i4, int i5) {
        unwrap().setIntLE(idx(i4), i5);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public void _setLong(int i4, long j4) {
        unwrap().setLong(idx(i4), j4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public void _setLongLE(int i4, long j4) {
        unwrap().setLongLE(idx(i4), j4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public void _setMedium(int i4, int i5) {
        unwrap().setMedium(idx(i4), i5);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public void _setMediumLE(int i4, int i5) {
        unwrap().setMediumLE(idx(i4), i5);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public void _setShort(int i4, int i5) {
        unwrap().setShort(idx(i4), i5);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public void _setShortLE(int i4, int i5) {
        unwrap().setShortLE(idx(i4), i5);
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
    public ByteBuf capacity(int i4) {
        throw new UnsupportedOperationException("sliced buffer");
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf copy(int i4, int i5) {
        checkIndex0(i4, i5);
        return unwrap().copy(idx(i4), i5);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf duplicate() {
        ByteBuf slice = unwrap().slice(this.adjustment, length());
        slice.setIndex(readerIndex(), writerIndex());
        return slice;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int forEachByte(int i4, int i5, ByteProcessor byteProcessor) {
        checkIndex0(i4, i5);
        int forEachByte = unwrap().forEachByte(idx(i4), i5, byteProcessor);
        int i6 = this.adjustment;
        if (forEachByte >= i6) {
            return forEachByte - i6;
        }
        return -1;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int forEachByteDesc(int i4, int i5, ByteProcessor byteProcessor) {
        checkIndex0(i4, i5);
        int forEachByteDesc = unwrap().forEachByteDesc(idx(i4), i5, byteProcessor);
        int i6 = this.adjustment;
        if (forEachByteDesc >= i6) {
            return forEachByteDesc - i6;
        }
        return -1;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public byte getByte(int i4) {
        checkIndex0(i4, 1);
        return unwrap().getByte(idx(i4));
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i4, ByteBuf byteBuf, int i5, int i6) {
        checkIndex0(i4, i6);
        unwrap().getBytes(idx(i4), byteBuf, i5, i6);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CharSequence getCharSequence(int i4, int i5, Charset charset) {
        checkIndex0(i4, i5);
        return this.buffer.getCharSequence(idx(i4), i5, charset);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int getInt(int i4) {
        checkIndex0(i4, 4);
        return unwrap().getInt(idx(i4));
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int getIntLE(int i4) {
        checkIndex0(i4, 4);
        return unwrap().getIntLE(idx(i4));
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public long getLong(int i4) {
        checkIndex0(i4, 8);
        return unwrap().getLong(idx(i4));
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public long getLongLE(int i4) {
        checkIndex0(i4, 8);
        return unwrap().getLongLE(idx(i4));
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public short getShort(int i4) {
        checkIndex0(i4, 2);
        return unwrap().getShort(idx(i4));
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public short getShortLE(int i4) {
        checkIndex0(i4, 2);
        return unwrap().getShortLE(idx(i4));
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int getUnsignedMedium(int i4) {
        checkIndex0(i4, 3);
        return unwrap().getUnsignedMedium(idx(i4));
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int getUnsignedMediumLE(int i4) {
        checkIndex0(i4, 3);
        return unwrap().getUnsignedMediumLE(idx(i4));
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
    public final int idx(int i4) {
        return i4 + this.adjustment;
    }

    void initLength(int i4) {
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
    public ByteBuffer nioBuffer(int i4, int i5) {
        checkIndex0(i4, i5);
        return unwrap().nioBuffer(idx(i4), i5);
    }

    @Override // io.netty.buffer.ByteBuf
    public int nioBufferCount() {
        return unwrap().nioBufferCount();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuffer[] nioBuffers(int i4, int i5) {
        checkIndex0(i4, i5);
        return unwrap().nioBuffers(idx(i4), i5);
    }

    @Override // io.netty.buffer.ByteBuf
    @Deprecated
    public ByteOrder order() {
        return unwrap().order();
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setByte(int i4, int i5) {
        checkIndex0(i4, 1);
        unwrap().setByte(idx(i4), i5);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i4, byte[] bArr, int i5, int i6) {
        checkIndex0(i4, i6);
        unwrap().setBytes(idx(i4), bArr, i5, i6);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int setCharSequence(int i4, CharSequence charSequence, Charset charset) {
        if (charset.equals(CharsetUtil.UTF_8)) {
            checkIndex0(i4, ByteBufUtil.utf8MaxBytes(charSequence));
            return ByteBufUtil.writeUtf8(this, idx(i4), charSequence, charSequence.length());
        } else if (charset.equals(CharsetUtil.US_ASCII)) {
            int length = charSequence.length();
            checkIndex0(i4, length);
            return ByteBufUtil.writeAscii(this, idx(i4), charSequence, length);
        } else {
            byte[] bytes = charSequence.toString().getBytes(charset);
            checkIndex0(i4, bytes.length);
            this.buffer.setBytes(idx(i4), bytes);
            return bytes.length;
        }
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setInt(int i4, int i5) {
        checkIndex0(i4, 4);
        unwrap().setInt(idx(i4), i5);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setIntLE(int i4, int i5) {
        checkIndex0(i4, 4);
        unwrap().setIntLE(idx(i4), i5);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setLong(int i4, long j4) {
        checkIndex0(i4, 8);
        unwrap().setLong(idx(i4), j4);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setLongLE(int i4, long j4) {
        checkIndex0(i4, 8);
        unwrap().setLongLE(idx(i4), j4);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setMedium(int i4, int i5) {
        checkIndex0(i4, 3);
        unwrap().setMedium(idx(i4), i5);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setMediumLE(int i4, int i5) {
        checkIndex0(i4, 3);
        unwrap().setMediumLE(idx(i4), i5);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setShort(int i4, int i5) {
        checkIndex0(i4, 2);
        unwrap().setShort(idx(i4), i5);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setShortLE(int i4, int i5) {
        checkIndex0(i4, 2);
        unwrap().setShortLE(idx(i4), i5);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf slice(int i4, int i5) {
        checkIndex0(i4, i5);
        return unwrap().slice(idx(i4), i5);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf unwrap() {
        return this.buffer;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i4, byte[] bArr, int i5, int i6) {
        checkIndex0(i4, i6);
        unwrap().getBytes(idx(i4), bArr, i5, i6);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i4, ByteBuf byteBuf, int i5, int i6) {
        checkIndex0(i4, i6);
        unwrap().setBytes(idx(i4), byteBuf, i5, i6);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i4, ByteBuffer byteBuffer) {
        checkIndex0(i4, byteBuffer.remaining());
        unwrap().getBytes(idx(i4), byteBuffer);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i4, ByteBuffer byteBuffer) {
        checkIndex0(i4, byteBuffer.remaining());
        unwrap().setBytes(idx(i4), byteBuffer);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i4, OutputStream outputStream, int i5) throws IOException {
        checkIndex0(i4, i5);
        unwrap().getBytes(idx(i4), outputStream, i5);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public int setBytes(int i4, InputStream inputStream, int i5) throws IOException {
        checkIndex0(i4, i5);
        return unwrap().setBytes(idx(i4), inputStream, i5);
    }

    @Override // io.netty.buffer.ByteBuf
    public int getBytes(int i4, GatheringByteChannel gatheringByteChannel, int i5) throws IOException {
        checkIndex0(i4, i5);
        return unwrap().getBytes(idx(i4), gatheringByteChannel, i5);
    }

    @Override // io.netty.buffer.ByteBuf
    public int setBytes(int i4, ScatteringByteChannel scatteringByteChannel, int i5) throws IOException {
        checkIndex0(i4, i5);
        return unwrap().setBytes(idx(i4), scatteringByteChannel, i5);
    }

    @Override // io.netty.buffer.ByteBuf
    public int getBytes(int i4, FileChannel fileChannel, long j4, int i5) throws IOException {
        checkIndex0(i4, i5);
        return unwrap().getBytes(idx(i4), fileChannel, j4, i5);
    }

    @Override // io.netty.buffer.ByteBuf
    public int setBytes(int i4, FileChannel fileChannel, long j4, int i5) throws IOException {
        checkIndex0(i4, i5);
        return unwrap().setBytes(idx(i4), fileChannel, j4, i5);
    }
}
