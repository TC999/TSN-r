package io.netty.buffer;

import io.netty.util.ByteProcessor;
import java.io.IOException;
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
@Deprecated
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class SwappedByteBuf extends ByteBuf {
    private final ByteBuf buf;
    private final ByteOrder order;

    public SwappedByteBuf(ByteBuf byteBuf) {
        if (byteBuf != null) {
            this.buf = byteBuf;
            ByteOrder order = byteBuf.order();
            ByteOrder byteOrder = ByteOrder.BIG_ENDIAN;
            if (order == byteOrder) {
                this.order = ByteOrder.LITTLE_ENDIAN;
                return;
            } else {
                this.order = byteOrder;
                return;
            }
        }
        throw new NullPointerException("buf");
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBufAllocator alloc() {
        return this.buf.alloc();
    }

    @Override // io.netty.buffer.ByteBuf
    public byte[] array() {
        return this.buf.array();
    }

    @Override // io.netty.buffer.ByteBuf
    public int arrayOffset() {
        return this.buf.arrayOffset();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf asReadOnly() {
        return Unpooled.unmodifiableBuffer(this);
    }

    @Override // io.netty.buffer.ByteBuf
    public int bytesBefore(byte b4) {
        return this.buf.bytesBefore(b4);
    }

    @Override // io.netty.buffer.ByteBuf
    public int capacity() {
        return this.buf.capacity();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf clear() {
        this.buf.clear();
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf copy() {
        return this.buf.copy().order(this.order);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf discardReadBytes() {
        this.buf.discardReadBytes();
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf discardSomeReadBytes() {
        this.buf.discardSomeReadBytes();
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf duplicate() {
        return this.buf.duplicate().order(this.order);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf ensureWritable(int i4) {
        this.buf.ensureWritable(i4);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ByteBuf) {
            return ByteBufUtil.equals(this, (ByteBuf) obj);
        }
        return false;
    }

    @Override // io.netty.buffer.ByteBuf
    public int forEachByte(ByteProcessor byteProcessor) {
        return this.buf.forEachByte(byteProcessor);
    }

    @Override // io.netty.buffer.ByteBuf
    public int forEachByteDesc(ByteProcessor byteProcessor) {
        return this.buf.forEachByteDesc(byteProcessor);
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean getBoolean(int i4) {
        return this.buf.getBoolean(i4);
    }

    @Override // io.netty.buffer.ByteBuf
    public byte getByte(int i4) {
        return this.buf.getByte(i4);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i4, ByteBuf byteBuf) {
        this.buf.getBytes(i4, byteBuf);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public char getChar(int i4) {
        return (char) getShort(i4);
    }

    @Override // io.netty.buffer.ByteBuf
    public CharSequence getCharSequence(int i4, int i5, Charset charset) {
        return this.buf.getCharSequence(i4, i5, charset);
    }

    @Override // io.netty.buffer.ByteBuf
    public double getDouble(int i4) {
        return Double.longBitsToDouble(getLong(i4));
    }

    @Override // io.netty.buffer.ByteBuf
    public float getFloat(int i4) {
        return Float.intBitsToFloat(getInt(i4));
    }

    @Override // io.netty.buffer.ByteBuf
    public int getInt(int i4) {
        return ByteBufUtil.swapInt(this.buf.getInt(i4));
    }

    @Override // io.netty.buffer.ByteBuf
    public int getIntLE(int i4) {
        return this.buf.getInt(i4);
    }

    @Override // io.netty.buffer.ByteBuf
    public long getLong(int i4) {
        return ByteBufUtil.swapLong(this.buf.getLong(i4));
    }

    @Override // io.netty.buffer.ByteBuf
    public long getLongLE(int i4) {
        return this.buf.getLong(i4);
    }

    @Override // io.netty.buffer.ByteBuf
    public int getMedium(int i4) {
        return ByteBufUtil.swapMedium(this.buf.getMedium(i4));
    }

    @Override // io.netty.buffer.ByteBuf
    public int getMediumLE(int i4) {
        return this.buf.getMedium(i4);
    }

    @Override // io.netty.buffer.ByteBuf
    public short getShort(int i4) {
        return ByteBufUtil.swapShort(this.buf.getShort(i4));
    }

    @Override // io.netty.buffer.ByteBuf
    public short getShortLE(int i4) {
        return this.buf.getShort(i4);
    }

    @Override // io.netty.buffer.ByteBuf
    public short getUnsignedByte(int i4) {
        return this.buf.getUnsignedByte(i4);
    }

    @Override // io.netty.buffer.ByteBuf
    public long getUnsignedInt(int i4) {
        return getInt(i4) & 4294967295L;
    }

    @Override // io.netty.buffer.ByteBuf
    public long getUnsignedIntLE(int i4) {
        return getIntLE(i4) & 4294967295L;
    }

    @Override // io.netty.buffer.ByteBuf
    public int getUnsignedMedium(int i4) {
        return getMedium(i4) & 16777215;
    }

    @Override // io.netty.buffer.ByteBuf
    public int getUnsignedMediumLE(int i4) {
        return getMediumLE(i4) & 16777215;
    }

    @Override // io.netty.buffer.ByteBuf
    public int getUnsignedShort(int i4) {
        return getShort(i4) & 65535;
    }

    @Override // io.netty.buffer.ByteBuf
    public int getUnsignedShortLE(int i4) {
        return getShortLE(i4) & 65535;
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean hasArray() {
        return this.buf.hasArray();
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean hasMemoryAddress() {
        return this.buf.hasMemoryAddress();
    }

    @Override // io.netty.buffer.ByteBuf
    public int hashCode() {
        return this.buf.hashCode();
    }

    @Override // io.netty.buffer.ByteBuf
    public int indexOf(int i4, int i5, byte b4) {
        return this.buf.indexOf(i4, i5, b4);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuffer internalNioBuffer(int i4, int i5) {
        return nioBuffer(i4, i5);
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean isDirect() {
        return this.buf.isDirect();
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean isReadOnly() {
        return this.buf.isReadOnly();
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean isReadable() {
        return this.buf.isReadable();
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean isWritable() {
        return this.buf.isWritable();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf markReaderIndex() {
        this.buf.markReaderIndex();
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf markWriterIndex() {
        this.buf.markWriterIndex();
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public int maxCapacity() {
        return this.buf.maxCapacity();
    }

    @Override // io.netty.buffer.ByteBuf
    public int maxWritableBytes() {
        return this.buf.maxWritableBytes();
    }

    @Override // io.netty.buffer.ByteBuf
    public long memoryAddress() {
        return this.buf.memoryAddress();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuffer nioBuffer() {
        return this.buf.nioBuffer().order(this.order);
    }

    @Override // io.netty.buffer.ByteBuf
    public int nioBufferCount() {
        return this.buf.nioBufferCount();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuffer[] nioBuffers() {
        ByteBuffer[] nioBuffers = this.buf.nioBuffers();
        for (int i4 = 0; i4 < nioBuffers.length; i4++) {
            nioBuffers[i4] = nioBuffers[i4].order(this.order);
        }
        return nioBuffers;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteOrder order() {
        return this.order;
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean readBoolean() {
        return this.buf.readBoolean();
    }

    @Override // io.netty.buffer.ByteBuf
    public byte readByte() {
        return this.buf.readByte();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf readBytes(int i4) {
        return this.buf.readBytes(i4).order(order());
    }

    @Override // io.netty.buffer.ByteBuf
    public char readChar() {
        return (char) readShort();
    }

    @Override // io.netty.buffer.ByteBuf
    public CharSequence readCharSequence(int i4, Charset charset) {
        return this.buf.readCharSequence(i4, charset);
    }

    @Override // io.netty.buffer.ByteBuf
    public double readDouble() {
        return Double.longBitsToDouble(readLong());
    }

    @Override // io.netty.buffer.ByteBuf
    public float readFloat() {
        return Float.intBitsToFloat(readInt());
    }

    @Override // io.netty.buffer.ByteBuf
    public int readInt() {
        return ByteBufUtil.swapInt(this.buf.readInt());
    }

    @Override // io.netty.buffer.ByteBuf
    public int readIntLE() {
        return this.buf.readInt();
    }

    @Override // io.netty.buffer.ByteBuf
    public long readLong() {
        return ByteBufUtil.swapLong(this.buf.readLong());
    }

    @Override // io.netty.buffer.ByteBuf
    public long readLongLE() {
        return this.buf.readLong();
    }

    @Override // io.netty.buffer.ByteBuf
    public int readMedium() {
        return ByteBufUtil.swapMedium(this.buf.readMedium());
    }

    @Override // io.netty.buffer.ByteBuf
    public int readMediumLE() {
        return this.buf.readMedium();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf readRetainedSlice(int i4) {
        return this.buf.readRetainedSlice(i4).order(this.order);
    }

    @Override // io.netty.buffer.ByteBuf
    public short readShort() {
        return ByteBufUtil.swapShort(this.buf.readShort());
    }

    @Override // io.netty.buffer.ByteBuf
    public short readShortLE() {
        return this.buf.readShort();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf readSlice(int i4) {
        return this.buf.readSlice(i4).order(this.order);
    }

    @Override // io.netty.buffer.ByteBuf
    public short readUnsignedByte() {
        return this.buf.readUnsignedByte();
    }

    @Override // io.netty.buffer.ByteBuf
    public long readUnsignedInt() {
        return readInt() & 4294967295L;
    }

    @Override // io.netty.buffer.ByteBuf
    public long readUnsignedIntLE() {
        return readIntLE() & 4294967295L;
    }

    @Override // io.netty.buffer.ByteBuf
    public int readUnsignedMedium() {
        return readMedium() & 16777215;
    }

    @Override // io.netty.buffer.ByteBuf
    public int readUnsignedMediumLE() {
        return readMediumLE() & 16777215;
    }

    @Override // io.netty.buffer.ByteBuf
    public int readUnsignedShort() {
        return readShort() & 65535;
    }

    @Override // io.netty.buffer.ByteBuf
    public int readUnsignedShortLE() {
        return readShortLE() & 65535;
    }

    @Override // io.netty.buffer.ByteBuf
    public int readableBytes() {
        return this.buf.readableBytes();
    }

    @Override // io.netty.buffer.ByteBuf
    public int readerIndex() {
        return this.buf.readerIndex();
    }

    @Override // io.netty.util.ReferenceCounted
    public int refCnt() {
        return this.buf.refCnt();
    }

    @Override // io.netty.util.ReferenceCounted
    public boolean release() {
        return this.buf.release();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf resetReaderIndex() {
        this.buf.resetReaderIndex();
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf resetWriterIndex() {
        this.buf.resetWriterIndex();
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf retainedDuplicate() {
        return this.buf.retainedDuplicate().order(this.order);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf retainedSlice() {
        return this.buf.retainedSlice().order(this.order);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBoolean(int i4, boolean z3) {
        this.buf.setBoolean(i4, z3);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setByte(int i4, int i5) {
        this.buf.setByte(i4, i5);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i4, ByteBuf byteBuf) {
        this.buf.setBytes(i4, byteBuf);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setChar(int i4, int i5) {
        setShort(i4, i5);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public int setCharSequence(int i4, CharSequence charSequence, Charset charset) {
        return this.buf.setCharSequence(i4, charSequence, charset);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setDouble(int i4, double d4) {
        setLong(i4, Double.doubleToRawLongBits(d4));
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setFloat(int i4, float f4) {
        setInt(i4, Float.floatToRawIntBits(f4));
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setIndex(int i4, int i5) {
        this.buf.setIndex(i4, i5);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setInt(int i4, int i5) {
        this.buf.setInt(i4, ByteBufUtil.swapInt(i5));
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setIntLE(int i4, int i5) {
        this.buf.setInt(i4, i5);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setLong(int i4, long j4) {
        this.buf.setLong(i4, ByteBufUtil.swapLong(j4));
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setLongLE(int i4, long j4) {
        this.buf.setLong(i4, j4);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setMedium(int i4, int i5) {
        this.buf.setMedium(i4, ByteBufUtil.swapMedium(i5));
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setMediumLE(int i4, int i5) {
        this.buf.setMedium(i4, i5);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setShort(int i4, int i5) {
        this.buf.setShort(i4, ByteBufUtil.swapShort((short) i5));
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setShortLE(int i4, int i5) {
        this.buf.setShort(i4, (short) i5);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setZero(int i4, int i5) {
        this.buf.setZero(i4, i5);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf skipBytes(int i4) {
        this.buf.skipBytes(i4);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf slice() {
        return this.buf.slice().order(this.order);
    }

    @Override // io.netty.buffer.ByteBuf
    public String toString(Charset charset) {
        return this.buf.toString(charset);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf unwrap() {
        return this.buf.unwrap();
    }

    @Override // io.netty.buffer.ByteBuf
    public int writableBytes() {
        return this.buf.writableBytes();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeBoolean(boolean z3) {
        this.buf.writeBoolean(z3);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeByte(int i4) {
        this.buf.writeByte(i4);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeBytes(ByteBuf byteBuf) {
        this.buf.writeBytes(byteBuf);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeChar(int i4) {
        writeShort(i4);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public int writeCharSequence(CharSequence charSequence, Charset charset) {
        return this.buf.writeCharSequence(charSequence, charset);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeDouble(double d4) {
        writeLong(Double.doubleToRawLongBits(d4));
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeFloat(float f4) {
        writeInt(Float.floatToRawIntBits(f4));
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeInt(int i4) {
        this.buf.writeInt(ByteBufUtil.swapInt(i4));
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeIntLE(int i4) {
        this.buf.writeInt(i4);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeLong(long j4) {
        this.buf.writeLong(ByteBufUtil.swapLong(j4));
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeLongLE(long j4) {
        this.buf.writeLong(j4);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeMedium(int i4) {
        this.buf.writeMedium(ByteBufUtil.swapMedium(i4));
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeMediumLE(int i4) {
        this.buf.writeMedium(i4);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeShort(int i4) {
        this.buf.writeShort(ByteBufUtil.swapShort((short) i4));
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeShortLE(int i4) {
        this.buf.writeShort((short) i4);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeZero(int i4) {
        this.buf.writeZero(i4);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public int writerIndex() {
        return this.buf.writerIndex();
    }

    @Override // io.netty.buffer.ByteBuf
    public int bytesBefore(int i4, byte b4) {
        return this.buf.bytesBefore(i4, b4);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf capacity(int i4) {
        this.buf.capacity(i4);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf, java.lang.Comparable
    public int compareTo(ByteBuf byteBuf) {
        return ByteBufUtil.compare(this, byteBuf);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf copy(int i4, int i5) {
        return this.buf.copy(i4, i5).order(this.order);
    }

    @Override // io.netty.buffer.ByteBuf
    public int ensureWritable(int i4, boolean z3) {
        return this.buf.ensureWritable(i4, z3);
    }

    @Override // io.netty.buffer.ByteBuf
    public int forEachByte(int i4, int i5, ByteProcessor byteProcessor) {
        return this.buf.forEachByte(i4, i5, byteProcessor);
    }

    @Override // io.netty.buffer.ByteBuf
    public int forEachByteDesc(int i4, int i5, ByteProcessor byteProcessor) {
        return this.buf.forEachByteDesc(i4, i5, byteProcessor);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i4, ByteBuf byteBuf, int i5) {
        this.buf.getBytes(i4, byteBuf, i5);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean isReadable(int i4) {
        return this.buf.isReadable(i4);
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean isWritable(int i4) {
        return this.buf.isWritable(i4);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuffer nioBuffer(int i4, int i5) {
        return this.buf.nioBuffer(i4, i5).order(this.order);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf order(ByteOrder byteOrder) {
        if (byteOrder != null) {
            return byteOrder == this.order ? this : this.buf;
        }
        throw new NullPointerException("endianness");
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf readBytes(ByteBuf byteBuf) {
        this.buf.readBytes(byteBuf);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf readerIndex(int i4) {
        this.buf.readerIndex(i4);
        return this;
    }

    @Override // io.netty.util.ReferenceCounted
    public boolean release(int i4) {
        return this.buf.release(i4);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf retainedSlice(int i4, int i5) {
        return this.buf.retainedSlice(i4, i5).order(this.order);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i4, ByteBuf byteBuf, int i5) {
        this.buf.setBytes(i4, byteBuf, i5);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf slice(int i4, int i5) {
        return this.buf.slice(i4, i5).order(this.order);
    }

    @Override // io.netty.buffer.ByteBuf
    public String toString(int i4, int i5, Charset charset) {
        return this.buf.toString(i4, i5, charset);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeBytes(ByteBuf byteBuf, int i4) {
        this.buf.writeBytes(byteBuf, i4);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writerIndex(int i4) {
        this.buf.writerIndex(i4);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public int bytesBefore(int i4, int i5, byte b4) {
        return this.buf.bytesBefore(i4, i5, b4);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i4, ByteBuf byteBuf, int i5, int i6) {
        this.buf.getBytes(i4, byteBuf, i5, i6);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf readBytes(ByteBuf byteBuf, int i4) {
        this.buf.readBytes(byteBuf, i4);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf, io.netty.util.ReferenceCounted
    public ByteBuf retain() {
        this.buf.retain();
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i4, ByteBuf byteBuf, int i5, int i6) {
        this.buf.setBytes(i4, byteBuf, i5, i6);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public String toString() {
        return "Swapped(" + this.buf + ')';
    }

    @Override // io.netty.buffer.ByteBuf, io.netty.util.ReferenceCounted
    public ByteBuf touch() {
        this.buf.touch();
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeBytes(ByteBuf byteBuf, int i4, int i5) {
        this.buf.writeBytes(byteBuf, i4, i5);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i4, byte[] bArr) {
        this.buf.getBytes(i4, bArr);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuffer[] nioBuffers(int i4, int i5) {
        ByteBuffer[] nioBuffers = this.buf.nioBuffers(i4, i5);
        for (int i6 = 0; i6 < nioBuffers.length; i6++) {
            nioBuffers[i6] = nioBuffers[i6].order(this.order);
        }
        return nioBuffers;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf readBytes(ByteBuf byteBuf, int i4, int i5) {
        this.buf.readBytes(byteBuf, i4, i5);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf, io.netty.util.ReferenceCounted
    public ByteBuf retain(int i4) {
        this.buf.retain(i4);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i4, byte[] bArr) {
        this.buf.setBytes(i4, bArr);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf, io.netty.util.ReferenceCounted
    public ByteBuf touch(Object obj) {
        this.buf.touch(obj);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeBytes(byte[] bArr) {
        this.buf.writeBytes(bArr);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i4, byte[] bArr, int i5, int i6) {
        this.buf.getBytes(i4, bArr, i5, i6);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf readBytes(byte[] bArr) {
        this.buf.readBytes(bArr);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i4, byte[] bArr, int i5, int i6) {
        this.buf.setBytes(i4, bArr, i5, i6);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeBytes(byte[] bArr, int i4, int i5) {
        this.buf.writeBytes(bArr, i4, i5);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i4, ByteBuffer byteBuffer) {
        this.buf.getBytes(i4, byteBuffer);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf readBytes(byte[] bArr, int i4, int i5) {
        this.buf.readBytes(bArr, i4, i5);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i4, ByteBuffer byteBuffer) {
        this.buf.setBytes(i4, byteBuffer);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeBytes(ByteBuffer byteBuffer) {
        this.buf.writeBytes(byteBuffer);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i4, OutputStream outputStream, int i5) throws IOException {
        this.buf.getBytes(i4, outputStream, i5);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf readBytes(ByteBuffer byteBuffer) {
        this.buf.readBytes(byteBuffer);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public int setBytes(int i4, InputStream inputStream, int i5) throws IOException {
        return this.buf.setBytes(i4, inputStream, i5);
    }

    @Override // io.netty.buffer.ByteBuf
    public int writeBytes(InputStream inputStream, int i4) throws IOException {
        return this.buf.writeBytes(inputStream, i4);
    }

    @Override // io.netty.buffer.ByteBuf
    public int getBytes(int i4, GatheringByteChannel gatheringByteChannel, int i5) throws IOException {
        return this.buf.getBytes(i4, gatheringByteChannel, i5);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf readBytes(OutputStream outputStream, int i4) throws IOException {
        this.buf.readBytes(outputStream, i4);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public int setBytes(int i4, ScatteringByteChannel scatteringByteChannel, int i5) throws IOException {
        return this.buf.setBytes(i4, scatteringByteChannel, i5);
    }

    @Override // io.netty.buffer.ByteBuf
    public int writeBytes(ScatteringByteChannel scatteringByteChannel, int i4) throws IOException {
        return this.buf.writeBytes(scatteringByteChannel, i4);
    }

    @Override // io.netty.buffer.ByteBuf
    public int getBytes(int i4, FileChannel fileChannel, long j4, int i5) throws IOException {
        return this.buf.getBytes(i4, fileChannel, j4, i5);
    }

    @Override // io.netty.buffer.ByteBuf
    public int readBytes(GatheringByteChannel gatheringByteChannel, int i4) throws IOException {
        return this.buf.readBytes(gatheringByteChannel, i4);
    }

    @Override // io.netty.buffer.ByteBuf
    public int setBytes(int i4, FileChannel fileChannel, long j4, int i5) throws IOException {
        return this.buf.setBytes(i4, fileChannel, j4, i5);
    }

    @Override // io.netty.buffer.ByteBuf
    public int writeBytes(FileChannel fileChannel, long j4, int i4) throws IOException {
        return this.buf.writeBytes(fileChannel, j4, i4);
    }

    @Override // io.netty.buffer.ByteBuf
    public int readBytes(FileChannel fileChannel, long j4, int i4) throws IOException {
        return this.buf.readBytes(fileChannel, j4, i4);
    }
}
