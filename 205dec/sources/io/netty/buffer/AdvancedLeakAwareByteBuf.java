package io.netty.buffer;

import io.netty.util.ByteProcessor;
import io.netty.util.ResourceLeak;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
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
public final class AdvancedLeakAwareByteBuf extends WrappedByteBuf {
    private static final boolean ACQUIRE_AND_RELEASE_ONLY;
    private static final String PROP_ACQUIRE_AND_RELEASE_ONLY = "io.netty.leakDetection.acquireAndReleaseOnly";
    private static final InternalLogger logger;
    private final ResourceLeak leak;

    static {
        InternalLogger internalLoggerFactory = InternalLoggerFactory.getInstance(AdvancedLeakAwareByteBuf.class);
        logger = internalLoggerFactory;
        boolean z3 = SystemPropertyUtil.getBoolean("io.netty.leakDetection.acquireAndReleaseOnly", false);
        ACQUIRE_AND_RELEASE_ONLY = z3;
        if (internalLoggerFactory.isDebugEnabled()) {
            internalLoggerFactory.debug("-D{}: {}", "io.netty.leakDetection.acquireAndReleaseOnly", Boolean.valueOf(z3));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AdvancedLeakAwareByteBuf(ByteBuf byteBuf, ResourceLeak resourceLeak) {
        super(byteBuf);
        this.leak = resourceLeak;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void recordLeakNonRefCountingOperation(ResourceLeak resourceLeak) {
        if (ACQUIRE_AND_RELEASE_ONLY) {
            return;
        }
        resourceLeak.record();
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf asReadOnly() {
        recordLeakNonRefCountingOperation(this.leak);
        return new AdvancedLeakAwareByteBuf(super.asReadOnly(), this.leak);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public int bytesBefore(byte b4) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.bytesBefore(b4);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf capacity(int i4) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.capacity(i4);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf copy() {
        recordLeakNonRefCountingOperation(this.leak);
        return super.copy();
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf discardReadBytes() {
        recordLeakNonRefCountingOperation(this.leak);
        return super.discardReadBytes();
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf discardSomeReadBytes() {
        recordLeakNonRefCountingOperation(this.leak);
        return super.discardSomeReadBytes();
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf duplicate() {
        recordLeakNonRefCountingOperation(this.leak);
        return new AdvancedLeakAwareByteBuf(super.duplicate(), this.leak);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf ensureWritable(int i4) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.ensureWritable(i4);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public int forEachByte(ByteProcessor byteProcessor) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.forEachByte(byteProcessor);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public int forEachByteDesc(ByteProcessor byteProcessor) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.forEachByteDesc(byteProcessor);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public boolean getBoolean(int i4) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.getBoolean(i4);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public byte getByte(int i4) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.getByte(i4);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i4, ByteBuf byteBuf) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.getBytes(i4, byteBuf);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public char getChar(int i4) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.getChar(i4);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public CharSequence getCharSequence(int i4, int i5, Charset charset) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.getCharSequence(i4, i5, charset);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public double getDouble(int i4) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.getDouble(i4);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public float getFloat(int i4) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.getFloat(i4);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public int getInt(int i4) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.getInt(i4);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public int getIntLE(int i4) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.getIntLE(i4);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public long getLong(int i4) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.getLong(i4);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public long getLongLE(int i4) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.getLongLE(i4);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public int getMedium(int i4) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.getMedium(i4);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public int getMediumLE(int i4) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.getMediumLE(i4);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public short getShort(int i4) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.getShort(i4);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public short getShortLE(int i4) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.getShortLE(i4);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public short getUnsignedByte(int i4) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.getUnsignedByte(i4);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public long getUnsignedInt(int i4) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.getUnsignedInt(i4);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public long getUnsignedIntLE(int i4) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.getUnsignedIntLE(i4);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public int getUnsignedMedium(int i4) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.getUnsignedMedium(i4);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public int getUnsignedMediumLE(int i4) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.getUnsignedMediumLE(i4);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public int getUnsignedShort(int i4) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.getUnsignedShort(i4);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public int getUnsignedShortLE(int i4) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.getUnsignedShortLE(i4);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public int indexOf(int i4, int i5, byte b4) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.indexOf(i4, i5, b4);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public ByteBuffer internalNioBuffer(int i4, int i5) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.internalNioBuffer(i4, i5);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public ByteBuffer nioBuffer() {
        recordLeakNonRefCountingOperation(this.leak);
        return super.nioBuffer();
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public int nioBufferCount() {
        recordLeakNonRefCountingOperation(this.leak);
        return super.nioBufferCount();
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public ByteBuffer[] nioBuffers() {
        recordLeakNonRefCountingOperation(this.leak);
        return super.nioBuffers();
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf order(ByteOrder byteOrder) {
        recordLeakNonRefCountingOperation(this.leak);
        return order() == byteOrder ? this : new AdvancedLeakAwareByteBuf(super.order(byteOrder), this.leak);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public boolean readBoolean() {
        recordLeakNonRefCountingOperation(this.leak);
        return super.readBoolean();
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public byte readByte() {
        recordLeakNonRefCountingOperation(this.leak);
        return super.readByte();
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf readBytes(int i4) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.readBytes(i4);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public char readChar() {
        recordLeakNonRefCountingOperation(this.leak);
        return super.readChar();
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public CharSequence readCharSequence(int i4, Charset charset) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.readCharSequence(i4, charset);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public double readDouble() {
        recordLeakNonRefCountingOperation(this.leak);
        return super.readDouble();
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public float readFloat() {
        recordLeakNonRefCountingOperation(this.leak);
        return super.readFloat();
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public int readInt() {
        recordLeakNonRefCountingOperation(this.leak);
        return super.readInt();
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public int readIntLE() {
        recordLeakNonRefCountingOperation(this.leak);
        return super.readIntLE();
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public long readLong() {
        recordLeakNonRefCountingOperation(this.leak);
        return super.readLong();
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public long readLongLE() {
        recordLeakNonRefCountingOperation(this.leak);
        return super.readLongLE();
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public int readMedium() {
        recordLeakNonRefCountingOperation(this.leak);
        return super.readMedium();
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public int readMediumLE() {
        recordLeakNonRefCountingOperation(this.leak);
        return super.readMediumLE();
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf readRetainedSlice(int i4) {
        recordLeakNonRefCountingOperation(this.leak);
        return new AdvancedLeakAwareByteBuf(super.readRetainedSlice(i4), this.leak);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public short readShort() {
        recordLeakNonRefCountingOperation(this.leak);
        return super.readShort();
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public short readShortLE() {
        recordLeakNonRefCountingOperation(this.leak);
        return super.readShortLE();
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf readSlice(int i4) {
        recordLeakNonRefCountingOperation(this.leak);
        return new AdvancedLeakAwareByteBuf(super.readSlice(i4), this.leak);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public short readUnsignedByte() {
        recordLeakNonRefCountingOperation(this.leak);
        return super.readUnsignedByte();
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public long readUnsignedInt() {
        recordLeakNonRefCountingOperation(this.leak);
        return super.readUnsignedInt();
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public long readUnsignedIntLE() {
        recordLeakNonRefCountingOperation(this.leak);
        return super.readUnsignedIntLE();
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public int readUnsignedMedium() {
        recordLeakNonRefCountingOperation(this.leak);
        return super.readUnsignedMedium();
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public int readUnsignedMediumLE() {
        recordLeakNonRefCountingOperation(this.leak);
        return super.readUnsignedMediumLE();
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public int readUnsignedShort() {
        recordLeakNonRefCountingOperation(this.leak);
        return super.readUnsignedShort();
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public int readUnsignedShortLE() {
        recordLeakNonRefCountingOperation(this.leak);
        return super.readUnsignedShortLE();
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.util.ReferenceCounted
    public boolean release() {
        boolean release = super.release();
        if (release) {
            this.leak.close();
        } else {
            this.leak.record();
        }
        return release;
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf retainedDuplicate() {
        recordLeakNonRefCountingOperation(this.leak);
        return new AdvancedLeakAwareByteBuf(super.retainedDuplicate(), this.leak);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf retainedSlice() {
        recordLeakNonRefCountingOperation(this.leak);
        return new AdvancedLeakAwareByteBuf(super.retainedSlice(), this.leak);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setBoolean(int i4, boolean z3) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.setBoolean(i4, z3);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setByte(int i4, int i5) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.setByte(i4, i5);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i4, ByteBuf byteBuf) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.setBytes(i4, byteBuf);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setChar(int i4, int i5) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.setChar(i4, i5);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public int setCharSequence(int i4, CharSequence charSequence, Charset charset) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.setCharSequence(i4, charSequence, charset);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setDouble(int i4, double d4) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.setDouble(i4, d4);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setFloat(int i4, float f4) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.setFloat(i4, f4);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setInt(int i4, int i5) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.setInt(i4, i5);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setIntLE(int i4, int i5) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.setIntLE(i4, i5);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setLong(int i4, long j4) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.setLong(i4, j4);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setLongLE(int i4, long j4) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.setLongLE(i4, j4);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setMedium(int i4, int i5) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.setMedium(i4, i5);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setMediumLE(int i4, int i5) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.setMediumLE(i4, i5);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setShort(int i4, int i5) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.setShort(i4, i5);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setShortLE(int i4, int i5) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.setShortLE(i4, i5);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setZero(int i4, int i5) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.setZero(i4, i5);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf skipBytes(int i4) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.skipBytes(i4);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf slice() {
        recordLeakNonRefCountingOperation(this.leak);
        return new AdvancedLeakAwareByteBuf(super.slice(), this.leak);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public String toString(Charset charset) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.toString(charset);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf writeBoolean(boolean z3) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.writeBoolean(z3);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf writeByte(int i4) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.writeByte(i4);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf writeBytes(ByteBuf byteBuf) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.writeBytes(byteBuf);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf writeChar(int i4) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.writeChar(i4);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public int writeCharSequence(CharSequence charSequence, Charset charset) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.writeCharSequence(charSequence, charset);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf writeDouble(double d4) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.writeDouble(d4);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf writeFloat(float f4) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.writeFloat(f4);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf writeInt(int i4) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.writeInt(i4);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf writeIntLE(int i4) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.writeIntLE(i4);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf writeLong(long j4) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.writeLong(j4);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf writeLongLE(long j4) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.writeLongLE(j4);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf writeMedium(int i4) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.writeMedium(i4);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf writeMediumLE(int i4) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.writeMediumLE(i4);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf writeShort(int i4) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.writeShort(i4);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf writeShortLE(int i4) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.writeShortLE(i4);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf writeZero(int i4) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.writeZero(i4);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public int bytesBefore(int i4, byte b4) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.bytesBefore(i4, b4);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf copy(int i4, int i5) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.copy(i4, i5);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public int ensureWritable(int i4, boolean z3) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.ensureWritable(i4, z3);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public int forEachByte(int i4, int i5, ByteProcessor byteProcessor) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.forEachByte(i4, i5, byteProcessor);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public int forEachByteDesc(int i4, int i5, ByteProcessor byteProcessor) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.forEachByteDesc(i4, i5, byteProcessor);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i4, ByteBuf byteBuf, int i5) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.getBytes(i4, byteBuf, i5);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public ByteBuffer nioBuffer(int i4, int i5) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.nioBuffer(i4, i5);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public ByteBuffer[] nioBuffers(int i4, int i5) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.nioBuffers(i4, i5);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf readBytes(ByteBuf byteBuf) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.readBytes(byteBuf);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf, io.netty.util.ReferenceCounted
    public ByteBuf retain() {
        this.leak.record();
        return super.retain();
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf retainedSlice(int i4, int i5) {
        recordLeakNonRefCountingOperation(this.leak);
        return new AdvancedLeakAwareByteBuf(super.retainedSlice(i4, i5), this.leak);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i4, ByteBuf byteBuf, int i5) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.setBytes(i4, byteBuf, i5);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf slice(int i4, int i5) {
        recordLeakNonRefCountingOperation(this.leak);
        return new AdvancedLeakAwareByteBuf(super.slice(i4, i5), this.leak);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public String toString(int i4, int i5, Charset charset) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.toString(i4, i5, charset);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf, io.netty.util.ReferenceCounted
    public ByteBuf touch() {
        this.leak.record();
        return this;
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf writeBytes(ByteBuf byteBuf, int i4) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.writeBytes(byteBuf, i4);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.util.ReferenceCounted
    public boolean release(int i4) {
        boolean release = super.release(i4);
        if (release) {
            this.leak.close();
        } else {
            this.leak.record();
        }
        return release;
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf, io.netty.util.ReferenceCounted
    public ByteBuf touch(Object obj) {
        this.leak.record(obj);
        return this;
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public int bytesBefore(int i4, int i5, byte b4) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.bytesBefore(i4, i5, b4);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i4, ByteBuf byteBuf, int i5, int i6) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.getBytes(i4, byteBuf, i5, i6);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf readBytes(ByteBuf byteBuf, int i4) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.readBytes(byteBuf, i4);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf, io.netty.util.ReferenceCounted
    public ByteBuf retain(int i4) {
        this.leak.record();
        return super.retain(i4);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i4, ByteBuf byteBuf, int i5, int i6) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.setBytes(i4, byteBuf, i5, i6);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf writeBytes(ByteBuf byteBuf, int i4, int i5) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.writeBytes(byteBuf, i4, i5);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i4, byte[] bArr) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.getBytes(i4, bArr);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf readBytes(ByteBuf byteBuf, int i4, int i5) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.readBytes(byteBuf, i4, i5);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i4, byte[] bArr) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.setBytes(i4, bArr);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf writeBytes(byte[] bArr) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.writeBytes(bArr);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i4, byte[] bArr, int i5, int i6) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.getBytes(i4, bArr, i5, i6);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf readBytes(byte[] bArr) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.readBytes(bArr);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i4, byte[] bArr, int i5, int i6) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.setBytes(i4, bArr, i5, i6);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf writeBytes(byte[] bArr, int i4, int i5) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.writeBytes(bArr, i4, i5);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i4, ByteBuffer byteBuffer) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.getBytes(i4, byteBuffer);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf readBytes(byte[] bArr, int i4, int i5) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.readBytes(bArr, i4, i5);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i4, ByteBuffer byteBuffer) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.setBytes(i4, byteBuffer);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf writeBytes(ByteBuffer byteBuffer) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.writeBytes(byteBuffer);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i4, OutputStream outputStream, int i5) throws IOException {
        recordLeakNonRefCountingOperation(this.leak);
        return super.getBytes(i4, outputStream, i5);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf readBytes(ByteBuffer byteBuffer) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.readBytes(byteBuffer);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public int setBytes(int i4, InputStream inputStream, int i5) throws IOException {
        recordLeakNonRefCountingOperation(this.leak);
        return super.setBytes(i4, inputStream, i5);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public int writeBytes(InputStream inputStream, int i4) throws IOException {
        recordLeakNonRefCountingOperation(this.leak);
        return super.writeBytes(inputStream, i4);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public int getBytes(int i4, GatheringByteChannel gatheringByteChannel, int i5) throws IOException {
        recordLeakNonRefCountingOperation(this.leak);
        return super.getBytes(i4, gatheringByteChannel, i5);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf readBytes(OutputStream outputStream, int i4) throws IOException {
        recordLeakNonRefCountingOperation(this.leak);
        return super.readBytes(outputStream, i4);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public int setBytes(int i4, ScatteringByteChannel scatteringByteChannel, int i5) throws IOException {
        recordLeakNonRefCountingOperation(this.leak);
        return super.setBytes(i4, scatteringByteChannel, i5);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public int writeBytes(ScatteringByteChannel scatteringByteChannel, int i4) throws IOException {
        recordLeakNonRefCountingOperation(this.leak);
        return super.writeBytes(scatteringByteChannel, i4);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public int getBytes(int i4, FileChannel fileChannel, long j4, int i5) throws IOException {
        recordLeakNonRefCountingOperation(this.leak);
        return super.getBytes(i4, fileChannel, j4, i5);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public int readBytes(GatheringByteChannel gatheringByteChannel, int i4) throws IOException {
        recordLeakNonRefCountingOperation(this.leak);
        return super.readBytes(gatheringByteChannel, i4);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public int setBytes(int i4, FileChannel fileChannel, long j4, int i5) throws IOException {
        recordLeakNonRefCountingOperation(this.leak);
        return super.setBytes(i4, fileChannel, j4, i5);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public int writeBytes(FileChannel fileChannel, long j4, int i4) throws IOException {
        recordLeakNonRefCountingOperation(this.leak);
        return super.writeBytes(fileChannel, j4, i4);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public int readBytes(FileChannel fileChannel, long j4, int i4) throws IOException {
        recordLeakNonRefCountingOperation(this.leak);
        return super.readBytes(fileChannel, j4, i4);
    }
}
