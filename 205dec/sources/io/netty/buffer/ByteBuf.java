package io.netty.buffer;

import io.netty.util.ByteProcessor;
import io.netty.util.ReferenceCounted;
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
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public abstract class ByteBuf implements ReferenceCounted, Comparable<ByteBuf> {
    public abstract ByteBufAllocator alloc();

    public abstract byte[] array();

    public abstract int arrayOffset();

    public abstract ByteBuf asReadOnly();

    public abstract int bytesBefore(byte b4);

    public abstract int bytesBefore(int i4, byte b4);

    public abstract int bytesBefore(int i4, int i5, byte b4);

    public abstract int capacity();

    public abstract ByteBuf capacity(int i4);

    public abstract ByteBuf clear();

    @Override // java.lang.Comparable
    public abstract int compareTo(ByteBuf byteBuf);

    public abstract ByteBuf copy();

    public abstract ByteBuf copy(int i4, int i5);

    public abstract ByteBuf discardReadBytes();

    public abstract ByteBuf discardSomeReadBytes();

    public abstract ByteBuf duplicate();

    public abstract int ensureWritable(int i4, boolean z3);

    public abstract ByteBuf ensureWritable(int i4);

    public abstract boolean equals(Object obj);

    public abstract int forEachByte(int i4, int i5, ByteProcessor byteProcessor);

    public abstract int forEachByte(ByteProcessor byteProcessor);

    public abstract int forEachByteDesc(int i4, int i5, ByteProcessor byteProcessor);

    public abstract int forEachByteDesc(ByteProcessor byteProcessor);

    public abstract boolean getBoolean(int i4);

    public abstract byte getByte(int i4);

    public abstract int getBytes(int i4, FileChannel fileChannel, long j4, int i5) throws IOException;

    public abstract int getBytes(int i4, GatheringByteChannel gatheringByteChannel, int i5) throws IOException;

    public abstract ByteBuf getBytes(int i4, ByteBuf byteBuf);

    public abstract ByteBuf getBytes(int i4, ByteBuf byteBuf, int i5);

    public abstract ByteBuf getBytes(int i4, ByteBuf byteBuf, int i5, int i6);

    public abstract ByteBuf getBytes(int i4, OutputStream outputStream, int i5) throws IOException;

    public abstract ByteBuf getBytes(int i4, ByteBuffer byteBuffer);

    public abstract ByteBuf getBytes(int i4, byte[] bArr);

    public abstract ByteBuf getBytes(int i4, byte[] bArr, int i5, int i6);

    public abstract char getChar(int i4);

    public abstract CharSequence getCharSequence(int i4, int i5, Charset charset);

    public abstract double getDouble(int i4);

    public abstract float getFloat(int i4);

    public abstract int getInt(int i4);

    public abstract int getIntLE(int i4);

    public abstract long getLong(int i4);

    public abstract long getLongLE(int i4);

    public abstract int getMedium(int i4);

    public abstract int getMediumLE(int i4);

    public abstract short getShort(int i4);

    public abstract short getShortLE(int i4);

    public abstract short getUnsignedByte(int i4);

    public abstract long getUnsignedInt(int i4);

    public abstract long getUnsignedIntLE(int i4);

    public abstract int getUnsignedMedium(int i4);

    public abstract int getUnsignedMediumLE(int i4);

    public abstract int getUnsignedShort(int i4);

    public abstract int getUnsignedShortLE(int i4);

    public abstract boolean hasArray();

    public abstract boolean hasMemoryAddress();

    public abstract int hashCode();

    public abstract int indexOf(int i4, int i5, byte b4);

    public abstract ByteBuffer internalNioBuffer(int i4, int i5);

    public abstract boolean isDirect();

    public abstract boolean isReadOnly();

    public abstract boolean isReadable();

    public abstract boolean isReadable(int i4);

    public abstract boolean isWritable();

    public abstract boolean isWritable(int i4);

    public abstract ByteBuf markReaderIndex();

    public abstract ByteBuf markWriterIndex();

    public abstract int maxCapacity();

    public abstract int maxWritableBytes();

    public abstract long memoryAddress();

    public abstract ByteBuffer nioBuffer();

    public abstract ByteBuffer nioBuffer(int i4, int i5);

    public abstract int nioBufferCount();

    public abstract ByteBuffer[] nioBuffers();

    public abstract ByteBuffer[] nioBuffers(int i4, int i5);

    @Deprecated
    public abstract ByteBuf order(ByteOrder byteOrder);

    @Deprecated
    public abstract ByteOrder order();

    public abstract boolean readBoolean();

    public abstract byte readByte();

    public abstract int readBytes(FileChannel fileChannel, long j4, int i4) throws IOException;

    public abstract int readBytes(GatheringByteChannel gatheringByteChannel, int i4) throws IOException;

    public abstract ByteBuf readBytes(int i4);

    public abstract ByteBuf readBytes(ByteBuf byteBuf);

    public abstract ByteBuf readBytes(ByteBuf byteBuf, int i4);

    public abstract ByteBuf readBytes(ByteBuf byteBuf, int i4, int i5);

    public abstract ByteBuf readBytes(OutputStream outputStream, int i4) throws IOException;

    public abstract ByteBuf readBytes(ByteBuffer byteBuffer);

    public abstract ByteBuf readBytes(byte[] bArr);

    public abstract ByteBuf readBytes(byte[] bArr, int i4, int i5);

    public abstract char readChar();

    public abstract CharSequence readCharSequence(int i4, Charset charset);

    public abstract double readDouble();

    public abstract float readFloat();

    public abstract int readInt();

    public abstract int readIntLE();

    public abstract long readLong();

    public abstract long readLongLE();

    public abstract int readMedium();

    public abstract int readMediumLE();

    public abstract ByteBuf readRetainedSlice(int i4);

    public abstract short readShort();

    public abstract short readShortLE();

    public abstract ByteBuf readSlice(int i4);

    public abstract short readUnsignedByte();

    public abstract long readUnsignedInt();

    public abstract long readUnsignedIntLE();

    public abstract int readUnsignedMedium();

    public abstract int readUnsignedMediumLE();

    public abstract int readUnsignedShort();

    public abstract int readUnsignedShortLE();

    public abstract int readableBytes();

    public abstract int readerIndex();

    public abstract ByteBuf readerIndex(int i4);

    public abstract ByteBuf resetReaderIndex();

    public abstract ByteBuf resetWriterIndex();

    @Override // io.netty.util.ReferenceCounted
    public abstract ByteBuf retain();

    @Override // io.netty.util.ReferenceCounted
    public abstract ByteBuf retain(int i4);

    public abstract ByteBuf retainedDuplicate();

    public abstract ByteBuf retainedSlice();

    public abstract ByteBuf retainedSlice(int i4, int i5);

    public abstract ByteBuf setBoolean(int i4, boolean z3);

    public abstract ByteBuf setByte(int i4, int i5);

    public abstract int setBytes(int i4, InputStream inputStream, int i5) throws IOException;

    public abstract int setBytes(int i4, FileChannel fileChannel, long j4, int i5) throws IOException;

    public abstract int setBytes(int i4, ScatteringByteChannel scatteringByteChannel, int i5) throws IOException;

    public abstract ByteBuf setBytes(int i4, ByteBuf byteBuf);

    public abstract ByteBuf setBytes(int i4, ByteBuf byteBuf, int i5);

    public abstract ByteBuf setBytes(int i4, ByteBuf byteBuf, int i5, int i6);

    public abstract ByteBuf setBytes(int i4, ByteBuffer byteBuffer);

    public abstract ByteBuf setBytes(int i4, byte[] bArr);

    public abstract ByteBuf setBytes(int i4, byte[] bArr, int i5, int i6);

    public abstract ByteBuf setChar(int i4, int i5);

    public abstract int setCharSequence(int i4, CharSequence charSequence, Charset charset);

    public abstract ByteBuf setDouble(int i4, double d4);

    public abstract ByteBuf setFloat(int i4, float f4);

    public abstract ByteBuf setIndex(int i4, int i5);

    public abstract ByteBuf setInt(int i4, int i5);

    public abstract ByteBuf setIntLE(int i4, int i5);

    public abstract ByteBuf setLong(int i4, long j4);

    public abstract ByteBuf setLongLE(int i4, long j4);

    public abstract ByteBuf setMedium(int i4, int i5);

    public abstract ByteBuf setMediumLE(int i4, int i5);

    public abstract ByteBuf setShort(int i4, int i5);

    public abstract ByteBuf setShortLE(int i4, int i5);

    public abstract ByteBuf setZero(int i4, int i5);

    public abstract ByteBuf skipBytes(int i4);

    public abstract ByteBuf slice();

    public abstract ByteBuf slice(int i4, int i5);

    public abstract String toString();

    public abstract String toString(int i4, int i5, Charset charset);

    public abstract String toString(Charset charset);

    @Override // io.netty.util.ReferenceCounted
    public abstract ByteBuf touch();

    @Override // io.netty.util.ReferenceCounted
    public abstract ByteBuf touch(Object obj);

    public abstract ByteBuf unwrap();

    public abstract int writableBytes();

    public abstract ByteBuf writeBoolean(boolean z3);

    public abstract ByteBuf writeByte(int i4);

    public abstract int writeBytes(InputStream inputStream, int i4) throws IOException;

    public abstract int writeBytes(FileChannel fileChannel, long j4, int i4) throws IOException;

    public abstract int writeBytes(ScatteringByteChannel scatteringByteChannel, int i4) throws IOException;

    public abstract ByteBuf writeBytes(ByteBuf byteBuf);

    public abstract ByteBuf writeBytes(ByteBuf byteBuf, int i4);

    public abstract ByteBuf writeBytes(ByteBuf byteBuf, int i4, int i5);

    public abstract ByteBuf writeBytes(ByteBuffer byteBuffer);

    public abstract ByteBuf writeBytes(byte[] bArr);

    public abstract ByteBuf writeBytes(byte[] bArr, int i4, int i5);

    public abstract ByteBuf writeChar(int i4);

    public abstract int writeCharSequence(CharSequence charSequence, Charset charset);

    public abstract ByteBuf writeDouble(double d4);

    public abstract ByteBuf writeFloat(float f4);

    public abstract ByteBuf writeInt(int i4);

    public abstract ByteBuf writeIntLE(int i4);

    public abstract ByteBuf writeLong(long j4);

    public abstract ByteBuf writeLongLE(long j4);

    public abstract ByteBuf writeMedium(int i4);

    public abstract ByteBuf writeMediumLE(int i4);

    public abstract ByteBuf writeShort(int i4);

    public abstract ByteBuf writeShortLE(int i4);

    public abstract ByteBuf writeZero(int i4);

    public abstract int writerIndex();

    public abstract ByteBuf writerIndex(int i4);
}
