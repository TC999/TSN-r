package io.netty.handler.codec;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.SwappedByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.util.ByteProcessor;
import io.netty.util.Signal;
import io.netty.util.internal.StringUtil;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;
import java.nio.charset.Charset;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
final class ReplayingDecoderByteBuf extends ByteBuf {
    static final ReplayingDecoderByteBuf EMPTY_BUFFER;
    private static final Signal REPLAY = ReplayingDecoder.REPLAY;
    private ByteBuf buffer;
    private SwappedByteBuf swapped;
    private boolean terminated;

    static {
        ReplayingDecoderByteBuf replayingDecoderByteBuf = new ReplayingDecoderByteBuf(Unpooled.EMPTY_BUFFER);
        EMPTY_BUFFER = replayingDecoderByteBuf;
        replayingDecoderByteBuf.terminate();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ReplayingDecoderByteBuf() {
    }

    private void checkIndex(int i4, int i5) {
        if (i4 + i5 > this.buffer.writerIndex()) {
            throw REPLAY;
        }
    }

    private void checkReadableBytes(int i4) {
        if (this.buffer.readableBytes() < i4) {
            throw REPLAY;
        }
    }

    private static UnsupportedOperationException reject() {
        return new UnsupportedOperationException("not a replayable operation");
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBufAllocator alloc() {
        return this.buffer.alloc();
    }

    @Override // io.netty.buffer.ByteBuf
    public byte[] array() {
        throw new UnsupportedOperationException();
    }

    @Override // io.netty.buffer.ByteBuf
    public int arrayOffset() {
        throw new UnsupportedOperationException();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf asReadOnly() {
        return Unpooled.unmodifiableBuffer(this);
    }

    @Override // io.netty.buffer.ByteBuf
    public int bytesBefore(byte b4) {
        int bytesBefore = this.buffer.bytesBefore(b4);
        if (bytesBefore >= 0) {
            return bytesBefore;
        }
        throw REPLAY;
    }

    @Override // io.netty.buffer.ByteBuf
    public int capacity() {
        if (this.terminated) {
            return this.buffer.capacity();
        }
        return Integer.MAX_VALUE;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf clear() {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf copy() {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf discardReadBytes() {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf discardSomeReadBytes() {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf duplicate() {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf ensureWritable(int i4) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean equals(Object obj) {
        return this == obj;
    }

    @Override // io.netty.buffer.ByteBuf
    public int forEachByte(ByteProcessor byteProcessor) {
        int forEachByte = this.buffer.forEachByte(byteProcessor);
        if (forEachByte >= 0) {
            return forEachByte;
        }
        throw REPLAY;
    }

    @Override // io.netty.buffer.ByteBuf
    public int forEachByteDesc(ByteProcessor byteProcessor) {
        if (this.terminated) {
            return this.buffer.forEachByteDesc(byteProcessor);
        }
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean getBoolean(int i4) {
        checkIndex(i4, 1);
        return this.buffer.getBoolean(i4);
    }

    @Override // io.netty.buffer.ByteBuf
    public byte getByte(int i4) {
        checkIndex(i4, 1);
        return this.buffer.getByte(i4);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i4, byte[] bArr, int i5, int i6) {
        checkIndex(i4, i6);
        this.buffer.getBytes(i4, bArr, i5, i6);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public char getChar(int i4) {
        checkIndex(i4, 2);
        return this.buffer.getChar(i4);
    }

    @Override // io.netty.buffer.ByteBuf
    public CharSequence getCharSequence(int i4, int i5, Charset charset) {
        checkIndex(i4, i5);
        return this.buffer.getCharSequence(i4, i5, charset);
    }

    @Override // io.netty.buffer.ByteBuf
    public double getDouble(int i4) {
        checkIndex(i4, 8);
        return this.buffer.getDouble(i4);
    }

    @Override // io.netty.buffer.ByteBuf
    public float getFloat(int i4) {
        checkIndex(i4, 4);
        return this.buffer.getFloat(i4);
    }

    @Override // io.netty.buffer.ByteBuf
    public int getInt(int i4) {
        checkIndex(i4, 4);
        return this.buffer.getInt(i4);
    }

    @Override // io.netty.buffer.ByteBuf
    public int getIntLE(int i4) {
        checkIndex(i4, 4);
        return this.buffer.getIntLE(i4);
    }

    @Override // io.netty.buffer.ByteBuf
    public long getLong(int i4) {
        checkIndex(i4, 8);
        return this.buffer.getLong(i4);
    }

    @Override // io.netty.buffer.ByteBuf
    public long getLongLE(int i4) {
        checkIndex(i4, 8);
        return this.buffer.getLongLE(i4);
    }

    @Override // io.netty.buffer.ByteBuf
    public int getMedium(int i4) {
        checkIndex(i4, 3);
        return this.buffer.getMedium(i4);
    }

    @Override // io.netty.buffer.ByteBuf
    public int getMediumLE(int i4) {
        checkIndex(i4, 3);
        return this.buffer.getMediumLE(i4);
    }

    @Override // io.netty.buffer.ByteBuf
    public short getShort(int i4) {
        checkIndex(i4, 2);
        return this.buffer.getShort(i4);
    }

    @Override // io.netty.buffer.ByteBuf
    public short getShortLE(int i4) {
        checkIndex(i4, 2);
        return this.buffer.getShortLE(i4);
    }

    @Override // io.netty.buffer.ByteBuf
    public short getUnsignedByte(int i4) {
        checkIndex(i4, 1);
        return this.buffer.getUnsignedByte(i4);
    }

    @Override // io.netty.buffer.ByteBuf
    public long getUnsignedInt(int i4) {
        checkIndex(i4, 4);
        return this.buffer.getUnsignedInt(i4);
    }

    @Override // io.netty.buffer.ByteBuf
    public long getUnsignedIntLE(int i4) {
        checkIndex(i4, 4);
        return this.buffer.getUnsignedIntLE(i4);
    }

    @Override // io.netty.buffer.ByteBuf
    public int getUnsignedMedium(int i4) {
        checkIndex(i4, 3);
        return this.buffer.getUnsignedMedium(i4);
    }

    @Override // io.netty.buffer.ByteBuf
    public int getUnsignedMediumLE(int i4) {
        checkIndex(i4, 3);
        return this.buffer.getUnsignedMediumLE(i4);
    }

    @Override // io.netty.buffer.ByteBuf
    public int getUnsignedShort(int i4) {
        checkIndex(i4, 2);
        return this.buffer.getUnsignedShort(i4);
    }

    @Override // io.netty.buffer.ByteBuf
    public int getUnsignedShortLE(int i4) {
        checkIndex(i4, 2);
        return this.buffer.getUnsignedShortLE(i4);
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
    public int hashCode() {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public int indexOf(int i4, int i5, byte b4) {
        if (i4 == i5) {
            return -1;
        }
        if (Math.max(i4, i5) <= this.buffer.writerIndex()) {
            return this.buffer.indexOf(i4, i5, b4);
        }
        throw REPLAY;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuffer internalNioBuffer(int i4, int i5) {
        checkIndex(i4, i5);
        return this.buffer.internalNioBuffer(i4, i5);
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean isDirect() {
        return this.buffer.isDirect();
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean isReadOnly() {
        return false;
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean isReadable() {
        if (this.terminated) {
            return this.buffer.isReadable();
        }
        return true;
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean isWritable() {
        return false;
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean isWritable(int i4) {
        return false;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf markReaderIndex() {
        this.buffer.markReaderIndex();
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf markWriterIndex() {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public int maxCapacity() {
        return capacity();
    }

    @Override // io.netty.buffer.ByteBuf
    public int maxWritableBytes() {
        return 0;
    }

    @Override // io.netty.buffer.ByteBuf
    public long memoryAddress() {
        throw new UnsupportedOperationException();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuffer nioBuffer() {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public int nioBufferCount() {
        return this.buffer.nioBufferCount();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuffer[] nioBuffers() {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteOrder order() {
        return this.buffer.order();
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean readBoolean() {
        checkReadableBytes(1);
        return this.buffer.readBoolean();
    }

    @Override // io.netty.buffer.ByteBuf
    public byte readByte() {
        checkReadableBytes(1);
        return this.buffer.readByte();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf readBytes(byte[] bArr, int i4, int i5) {
        checkReadableBytes(i5);
        this.buffer.readBytes(bArr, i4, i5);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public char readChar() {
        checkReadableBytes(2);
        return this.buffer.readChar();
    }

    @Override // io.netty.buffer.ByteBuf
    public CharSequence readCharSequence(int i4, Charset charset) {
        checkReadableBytes(i4);
        return this.buffer.readCharSequence(i4, charset);
    }

    @Override // io.netty.buffer.ByteBuf
    public double readDouble() {
        checkReadableBytes(8);
        return this.buffer.readDouble();
    }

    @Override // io.netty.buffer.ByteBuf
    public float readFloat() {
        checkReadableBytes(4);
        return this.buffer.readFloat();
    }

    @Override // io.netty.buffer.ByteBuf
    public int readInt() {
        checkReadableBytes(4);
        return this.buffer.readInt();
    }

    @Override // io.netty.buffer.ByteBuf
    public int readIntLE() {
        checkReadableBytes(4);
        return this.buffer.readIntLE();
    }

    @Override // io.netty.buffer.ByteBuf
    public long readLong() {
        checkReadableBytes(8);
        return this.buffer.readLong();
    }

    @Override // io.netty.buffer.ByteBuf
    public long readLongLE() {
        checkReadableBytes(8);
        return this.buffer.readLongLE();
    }

    @Override // io.netty.buffer.ByteBuf
    public int readMedium() {
        checkReadableBytes(3);
        return this.buffer.readMedium();
    }

    @Override // io.netty.buffer.ByteBuf
    public int readMediumLE() {
        checkReadableBytes(3);
        return this.buffer.readMediumLE();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf readRetainedSlice(int i4) {
        checkReadableBytes(i4);
        return this.buffer.readRetainedSlice(i4);
    }

    @Override // io.netty.buffer.ByteBuf
    public short readShort() {
        checkReadableBytes(2);
        return this.buffer.readShort();
    }

    @Override // io.netty.buffer.ByteBuf
    public short readShortLE() {
        checkReadableBytes(2);
        return this.buffer.readShortLE();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf readSlice(int i4) {
        checkReadableBytes(i4);
        return this.buffer.readSlice(i4);
    }

    @Override // io.netty.buffer.ByteBuf
    public short readUnsignedByte() {
        checkReadableBytes(1);
        return this.buffer.readUnsignedByte();
    }

    @Override // io.netty.buffer.ByteBuf
    public long readUnsignedInt() {
        checkReadableBytes(4);
        return this.buffer.readUnsignedInt();
    }

    @Override // io.netty.buffer.ByteBuf
    public long readUnsignedIntLE() {
        checkReadableBytes(4);
        return this.buffer.readUnsignedIntLE();
    }

    @Override // io.netty.buffer.ByteBuf
    public int readUnsignedMedium() {
        checkReadableBytes(3);
        return this.buffer.readUnsignedMedium();
    }

    @Override // io.netty.buffer.ByteBuf
    public int readUnsignedMediumLE() {
        checkReadableBytes(3);
        return this.buffer.readUnsignedMediumLE();
    }

    @Override // io.netty.buffer.ByteBuf
    public int readUnsignedShort() {
        checkReadableBytes(2);
        return this.buffer.readUnsignedShort();
    }

    @Override // io.netty.buffer.ByteBuf
    public int readUnsignedShortLE() {
        checkReadableBytes(2);
        return this.buffer.readUnsignedShortLE();
    }

    @Override // io.netty.buffer.ByteBuf
    public int readableBytes() {
        if (this.terminated) {
            return this.buffer.readableBytes();
        }
        return Integer.MAX_VALUE - this.buffer.readerIndex();
    }

    @Override // io.netty.buffer.ByteBuf
    public int readerIndex() {
        return this.buffer.readerIndex();
    }

    @Override // io.netty.util.ReferenceCounted
    public int refCnt() {
        return this.buffer.refCnt();
    }

    @Override // io.netty.util.ReferenceCounted
    public boolean release() {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf resetReaderIndex() {
        this.buffer.resetReaderIndex();
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf resetWriterIndex() {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf retainedDuplicate() {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf retainedSlice() {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBoolean(int i4, boolean z3) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setByte(int i4, int i5) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i4, byte[] bArr, int i5, int i6) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setChar(int i4, int i5) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public int setCharSequence(int i4, CharSequence charSequence, Charset charset) {
        throw reject();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setCumulation(ByteBuf byteBuf) {
        this.buffer = byteBuf;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setDouble(int i4, double d4) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setFloat(int i4, float f4) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setIndex(int i4, int i5) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setInt(int i4, int i5) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setIntLE(int i4, int i5) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setLong(int i4, long j4) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setLongLE(int i4, long j4) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setMedium(int i4, int i5) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setMediumLE(int i4, int i5) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setShort(int i4, int i5) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setShortLE(int i4, int i5) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setZero(int i4, int i5) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf skipBytes(int i4) {
        checkReadableBytes(i4);
        this.buffer.skipBytes(i4);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf slice() {
        throw reject();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void terminate() {
        this.terminated = true;
    }

    @Override // io.netty.buffer.ByteBuf
    public String toString(int i4, int i5, Charset charset) {
        checkIndex(i4, i5);
        return this.buffer.toString(i4, i5, charset);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf unwrap() {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public int writableBytes() {
        return 0;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeBoolean(boolean z3) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeByte(int i4) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeBytes(byte[] bArr, int i4, int i5) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeChar(int i4) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public int writeCharSequence(CharSequence charSequence, Charset charset) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeDouble(double d4) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeFloat(float f4) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeInt(int i4) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeIntLE(int i4) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeLong(long j4) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeLongLE(long j4) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeMedium(int i4) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeMediumLE(int i4) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeShort(int i4) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeShortLE(int i4) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeZero(int i4) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public int writerIndex() {
        return this.buffer.writerIndex();
    }

    ReplayingDecoderByteBuf(ByteBuf byteBuf) {
        setCumulation(byteBuf);
    }

    @Override // io.netty.buffer.ByteBuf, java.lang.Comparable
    public int compareTo(ByteBuf byteBuf) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf copy(int i4, int i5) {
        checkIndex(i4, i5);
        return this.buffer.copy(i4, i5);
    }

    @Override // io.netty.buffer.ByteBuf
    public int ensureWritable(int i4, boolean z3) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean isReadable(int i4) {
        if (this.terminated) {
            return this.buffer.isReadable(i4);
        }
        return true;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuffer nioBuffer(int i4, int i5) {
        checkIndex(i4, i5);
        return this.buffer.nioBuffer(i4, i5);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuffer[] nioBuffers(int i4, int i5) {
        checkIndex(i4, i5);
        return this.buffer.nioBuffers(i4, i5);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf order(ByteOrder byteOrder) {
        if (byteOrder != null) {
            if (byteOrder == order()) {
                return this;
            }
            SwappedByteBuf swappedByteBuf = this.swapped;
            if (swappedByteBuf == null) {
                SwappedByteBuf swappedByteBuf2 = new SwappedByteBuf(this);
                this.swapped = swappedByteBuf2;
                return swappedByteBuf2;
            }
            return swappedByteBuf;
        }
        throw new NullPointerException("endianness");
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf readerIndex(int i4) {
        this.buffer.readerIndex(i4);
        return this;
    }

    @Override // io.netty.util.ReferenceCounted
    public boolean release(int i4) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf retainedSlice(int i4, int i5) {
        checkIndex(i4, i5);
        return this.buffer.slice(i4, i5);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i4, byte[] bArr) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf slice(int i4, int i5) {
        checkIndex(i4, i5);
        return this.buffer.slice(i4, i5);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeBytes(byte[] bArr) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writerIndex(int i4) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public int bytesBefore(int i4, byte b4) {
        return bytesBefore(this.buffer.readerIndex(), i4, b4);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf capacity(int i4) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public int forEachByte(int i4, int i5, ByteProcessor byteProcessor) {
        int writerIndex = this.buffer.writerIndex();
        if (i4 < writerIndex) {
            if (i4 <= writerIndex - i5) {
                return this.buffer.forEachByte(i4, i5, byteProcessor);
            }
            int forEachByte = this.buffer.forEachByte(i4, writerIndex - i4, byteProcessor);
            if (forEachByte >= 0) {
                return forEachByte;
            }
            throw REPLAY;
        }
        throw REPLAY;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i4, byte[] bArr) {
        checkIndex(i4, bArr.length);
        this.buffer.getBytes(i4, bArr);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf readBytes(byte[] bArr) {
        checkReadableBytes(bArr.length);
        this.buffer.readBytes(bArr);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf, io.netty.util.ReferenceCounted
    public ByteBuf retain() {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i4, ByteBuffer byteBuffer) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public String toString(Charset charset) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf, io.netty.util.ReferenceCounted
    public ByteBuf touch() {
        this.buffer.touch();
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeBytes(ByteBuffer byteBuffer) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public int bytesBefore(int i4, int i5, byte b4) {
        int writerIndex = this.buffer.writerIndex();
        if (i4 < writerIndex) {
            if (i4 <= writerIndex - i5) {
                return this.buffer.bytesBefore(i4, i5, b4);
            }
            int bytesBefore = this.buffer.bytesBefore(i4, writerIndex - i4, b4);
            if (bytesBefore >= 0) {
                return bytesBefore;
            }
            throw REPLAY;
        }
        throw REPLAY;
    }

    @Override // io.netty.buffer.ByteBuf
    public int forEachByteDesc(int i4, int i5, ByteProcessor byteProcessor) {
        if (i4 + i5 <= this.buffer.writerIndex()) {
            return this.buffer.forEachByteDesc(i4, i5, byteProcessor);
        }
        throw REPLAY;
    }

    @Override // io.netty.buffer.ByteBuf, io.netty.util.ReferenceCounted
    public ByteBuf retain(int i4) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i4, ByteBuf byteBuf, int i5, int i6) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public String toString() {
        return StringUtil.simpleClassName(this) + "(ridx=" + readerIndex() + ", widx=" + writerIndex() + ')';
    }

    @Override // io.netty.buffer.ByteBuf, io.netty.util.ReferenceCounted
    public ByteBuf touch(Object obj) {
        this.buffer.touch(obj);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeBytes(ByteBuf byteBuf, int i4, int i5) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i4, ByteBuffer byteBuffer) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf readBytes(ByteBuffer byteBuffer) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i4, ByteBuf byteBuf, int i5) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeBytes(ByteBuf byteBuf, int i4) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i4, ByteBuf byteBuf, int i5, int i6) {
        checkIndex(i4, i6);
        this.buffer.getBytes(i4, byteBuf, i5, i6);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf readBytes(ByteBuf byteBuf, int i4, int i5) {
        checkReadableBytes(i5);
        this.buffer.readBytes(byteBuf, i4, i5);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i4, ByteBuf byteBuf) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeBytes(ByteBuf byteBuf) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public int setBytes(int i4, InputStream inputStream, int i5) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public int writeBytes(InputStream inputStream, int i4) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i4, ByteBuf byteBuf, int i5) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf readBytes(ByteBuf byteBuf, int i4) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public int setBytes(int i4, ScatteringByteChannel scatteringByteChannel, int i5) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public int writeBytes(ScatteringByteChannel scatteringByteChannel, int i4) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i4, ByteBuf byteBuf) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf readBytes(ByteBuf byteBuf) {
        checkReadableBytes(byteBuf.writableBytes());
        this.buffer.readBytes(byteBuf);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public int setBytes(int i4, FileChannel fileChannel, long j4, int i5) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public int writeBytes(FileChannel fileChannel, long j4, int i4) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public int getBytes(int i4, GatheringByteChannel gatheringByteChannel, int i5) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public int getBytes(int i4, FileChannel fileChannel, long j4, int i5) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public int readBytes(GatheringByteChannel gatheringByteChannel, int i4) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i4, OutputStream outputStream, int i5) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public int readBytes(FileChannel fileChannel, long j4, int i4) {
        throw reject();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf readBytes(int i4) {
        checkReadableBytes(i4);
        return this.buffer.readBytes(i4);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf readBytes(OutputStream outputStream, int i4) {
        throw reject();
    }
}
