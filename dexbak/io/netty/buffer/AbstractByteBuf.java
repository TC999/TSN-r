package io.netty.buffer;

import androidx.core.view.ViewCompat;
import io.netty.util.ByteProcessor;
import io.netty.util.CharsetUtil;
import io.netty.util.IllegalReferenceCountException;
import io.netty.util.ResourceLeakDetector;
import io.netty.util.ResourceLeakDetectorFactory;
import io.netty.util.internal.MathUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.StringUtil;
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
import kotlin.UByte;
import kotlin.UShort;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public abstract class AbstractByteBuf extends ByteBuf {
    private static final String PROP_MODE = "io.netty.buffer.bytebuf.checkAccessible";
    private static final boolean checkAccessible;
    static final ResourceLeakDetector<ByteBuf> leakDetector;
    private static final InternalLogger logger;
    private int markedReaderIndex;
    private int markedWriterIndex;
    private int maxCapacity;
    int readerIndex;
    int writerIndex;

    static {
        InternalLogger internalLoggerFactory = InternalLoggerFactory.getInstance(AbstractByteBuf.class);
        logger = internalLoggerFactory;
        boolean z = SystemPropertyUtil.getBoolean(PROP_MODE, true);
        checkAccessible = z;
        if (internalLoggerFactory.isDebugEnabled()) {
            internalLoggerFactory.debug("-D{}: {}", PROP_MODE, Boolean.valueOf(z));
        }
        leakDetector = ResourceLeakDetectorFactory.instance().newResourceLeakDetector(ByteBuf.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractByteBuf(int i) {
        if (i >= 0) {
            this.maxCapacity = i;
            return;
        }
        throw new IllegalArgumentException("maxCapacity: " + i + " (expected: >= 0)");
    }

    private void checkReadableBytes0(int i) {
        ensureAccessible();
        if (this.readerIndex > this.writerIndex - i) {
            throw new IndexOutOfBoundsException(String.format("readerIndex(%d) + length(%d) exceeds writerIndex(%d): %s", Integer.valueOf(this.readerIndex), Integer.valueOf(i), Integer.valueOf(this.writerIndex), this));
        }
    }

    private void ensureWritable0(int i) {
        if (i <= writableBytes()) {
            return;
        }
        if (i <= this.maxCapacity - this.writerIndex) {
            capacity(alloc().calculateNewCapacity(this.writerIndex + i, this.maxCapacity));
            return;
        }
        throw new IndexOutOfBoundsException(String.format("writerIndex(%d) + minWritableBytes(%d) exceeds maxCapacity(%d): %s", Integer.valueOf(this.writerIndex), Integer.valueOf(i), Integer.valueOf(this.maxCapacity), this));
    }

    private int forEachByteAsc0(int i, int i2, ByteProcessor byteProcessor) throws Exception {
        while (i < i2) {
            if (!byteProcessor.process(_getByte(i))) {
                return i;
            }
            i++;
        }
        return -1;
    }

    private int forEachByteDesc0(int i, int i2, ByteProcessor byteProcessor) throws Exception {
        while (i >= i2) {
            if (!byteProcessor.process(_getByte(i))) {
                return i;
            }
            i--;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract byte _getByte(int i);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract int _getInt(int i);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract int _getIntLE(int i);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract long _getLong(int i);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract long _getLongLE(int i);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract short _getShort(int i);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract short _getShortLE(int i);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract int _getUnsignedMedium(int i);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract int _getUnsignedMediumLE(int i);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void _setByte(int i, int i2);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void _setInt(int i, int i2);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void _setIntLE(int i, int i2);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void _setLong(int i, long j);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void _setLongLE(int i, long j);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void _setMedium(int i, int i2);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void _setMediumLE(int i, int i2);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void _setShort(int i, int i2);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void _setShortLE(int i, int i2);

    /* JADX INFO: Access modifiers changed from: protected */
    public final void adjustMarkers(int i) {
        int i2 = this.markedReaderIndex;
        if (i2 <= i) {
            this.markedReaderIndex = 0;
            int i3 = this.markedWriterIndex;
            if (i3 <= i) {
                this.markedWriterIndex = 0;
                return;
            } else {
                this.markedWriterIndex = i3 - i;
                return;
            }
        }
        this.markedReaderIndex = i2 - i;
        this.markedWriterIndex -= i;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf asReadOnly() {
        return isReadOnly() ? this : Unpooled.unmodifiableBuffer(this);
    }

    @Override // io.netty.buffer.ByteBuf
    public int bytesBefore(byte b) {
        return bytesBefore(readerIndex(), readableBytes(), b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void checkDstIndex(int i, int i2, int i3, int i4) {
        checkIndex(i, i2);
        if (MathUtil.isOutOfBounds(i3, i2, i4)) {
            throw new IndexOutOfBoundsException(String.format("dstIndex: %d, length: %d (expected: range(0, %d))", Integer.valueOf(i3), Integer.valueOf(i2), Integer.valueOf(i4)));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void checkIndex(int i) {
        checkIndex(i, 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void checkIndex0(int i, int i2) {
        if (MathUtil.isOutOfBounds(i, i2, capacity())) {
            throw new IndexOutOfBoundsException(String.format("index: %d, length: %d (expected: range(0, %d))", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(capacity())));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void checkReadableBytes(int i) {
        if (i >= 0) {
            checkReadableBytes0(i);
            return;
        }
        throw new IllegalArgumentException("minimumReadableBytes: " + i + " (expected: >= 0)");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void checkSrcIndex(int i, int i2, int i3, int i4) {
        checkIndex(i, i2);
        if (MathUtil.isOutOfBounds(i3, i2, i4)) {
            throw new IndexOutOfBoundsException(String.format("srcIndex: %d, length: %d (expected: range(0, %d))", Integer.valueOf(i3), Integer.valueOf(i2), Integer.valueOf(i4)));
        }
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf clear() {
        this.writerIndex = 0;
        this.readerIndex = 0;
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf copy() {
        return copy(this.readerIndex, readableBytes());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void discardMarks() {
        this.markedWriterIndex = 0;
        this.markedReaderIndex = 0;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf discardReadBytes() {
        ensureAccessible();
        int i = this.readerIndex;
        if (i == 0) {
            return this;
        }
        int i2 = this.writerIndex;
        if (i != i2) {
            setBytes(0, this, i, i2 - i);
            int i3 = this.writerIndex;
            int i4 = this.readerIndex;
            this.writerIndex = i3 - i4;
            adjustMarkers(i4);
            this.readerIndex = 0;
        } else {
            adjustMarkers(i);
            this.readerIndex = 0;
            this.writerIndex = 0;
        }
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf discardSomeReadBytes() {
        ensureAccessible();
        int i = this.readerIndex;
        if (i == 0) {
            return this;
        }
        if (i == this.writerIndex) {
            adjustMarkers(i);
            this.readerIndex = 0;
            this.writerIndex = 0;
            return this;
        }
        if (i >= (capacity() >>> 1)) {
            int i2 = this.readerIndex;
            setBytes(0, this, i2, this.writerIndex - i2);
            int i3 = this.writerIndex;
            int i4 = this.readerIndex;
            this.writerIndex = i3 - i4;
            adjustMarkers(i4);
            this.readerIndex = 0;
        }
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf duplicate() {
        return new UnpooledDuplicatedByteBuf(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void ensureAccessible() {
        if (checkAccessible && refCnt() == 0) {
            throw new IllegalReferenceCountException(0);
        }
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf ensureWritable(int i) {
        if (i >= 0) {
            ensureWritable0(i);
            return this;
        }
        throw new IllegalArgumentException(String.format("minWritableBytes: %d (expected: >= 0)", Integer.valueOf(i)));
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
        ensureAccessible();
        try {
            return forEachByteAsc0(this.readerIndex, this.writerIndex, byteProcessor);
        } catch (Exception e) {
            PlatformDependent.throwException(e);
            return -1;
        }
    }

    @Override // io.netty.buffer.ByteBuf
    public int forEachByteDesc(ByteProcessor byteProcessor) {
        ensureAccessible();
        try {
            return forEachByteDesc0(this.writerIndex, this.readerIndex, byteProcessor);
        } catch (Exception e) {
            PlatformDependent.throwException(e);
            return -1;
        }
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean getBoolean(int i) {
        return getByte(i) != 0;
    }

    @Override // io.netty.buffer.ByteBuf
    public byte getByte(int i) {
        checkIndex(i);
        return _getByte(i);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i, byte[] bArr) {
        getBytes(i, bArr, 0, bArr.length);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public char getChar(int i) {
        return (char) getShort(i);
    }

    @Override // io.netty.buffer.ByteBuf
    public CharSequence getCharSequence(int i, int i2, Charset charset) {
        return toString(i, i2, charset);
    }

    @Override // io.netty.buffer.ByteBuf
    public double getDouble(int i) {
        return Double.longBitsToDouble(getLong(i));
    }

    @Override // io.netty.buffer.ByteBuf
    public float getFloat(int i) {
        return Float.intBitsToFloat(getInt(i));
    }

    @Override // io.netty.buffer.ByteBuf
    public int getInt(int i) {
        checkIndex(i, 4);
        return _getInt(i);
    }

    @Override // io.netty.buffer.ByteBuf
    public int getIntLE(int i) {
        checkIndex(i, 4);
        return _getIntLE(i);
    }

    @Override // io.netty.buffer.ByteBuf
    public long getLong(int i) {
        checkIndex(i, 8);
        return _getLong(i);
    }

    @Override // io.netty.buffer.ByteBuf
    public long getLongLE(int i) {
        checkIndex(i, 8);
        return _getLongLE(i);
    }

    @Override // io.netty.buffer.ByteBuf
    public int getMedium(int i) {
        int unsignedMedium = getUnsignedMedium(i);
        return (8388608 & unsignedMedium) != 0 ? unsignedMedium | ViewCompat.MEASURED_STATE_MASK : unsignedMedium;
    }

    @Override // io.netty.buffer.ByteBuf
    public int getMediumLE(int i) {
        int unsignedMediumLE = getUnsignedMediumLE(i);
        return (8388608 & unsignedMediumLE) != 0 ? unsignedMediumLE | ViewCompat.MEASURED_STATE_MASK : unsignedMediumLE;
    }

    @Override // io.netty.buffer.ByteBuf
    public short getShort(int i) {
        checkIndex(i, 2);
        return _getShort(i);
    }

    @Override // io.netty.buffer.ByteBuf
    public short getShortLE(int i) {
        checkIndex(i, 2);
        return _getShortLE(i);
    }

    @Override // io.netty.buffer.ByteBuf
    public short getUnsignedByte(int i) {
        return (short) (getByte(i) & UByte.f41242c);
    }

    @Override // io.netty.buffer.ByteBuf
    public long getUnsignedInt(int i) {
        return getInt(i) & 4294967295L;
    }

    @Override // io.netty.buffer.ByteBuf
    public long getUnsignedIntLE(int i) {
        return getIntLE(i) & 4294967295L;
    }

    @Override // io.netty.buffer.ByteBuf
    public int getUnsignedMedium(int i) {
        checkIndex(i, 3);
        return _getUnsignedMedium(i);
    }

    @Override // io.netty.buffer.ByteBuf
    public int getUnsignedMediumLE(int i) {
        checkIndex(i, 3);
        return _getUnsignedMediumLE(i);
    }

    @Override // io.netty.buffer.ByteBuf
    public int getUnsignedShort(int i) {
        return getShort(i) & UShort.f40820c;
    }

    @Override // io.netty.buffer.ByteBuf
    public int getUnsignedShortLE(int i) {
        return getShortLE(i) & UShort.f40820c;
    }

    @Override // io.netty.buffer.ByteBuf
    public int hashCode() {
        return ByteBufUtil.hashCode(this);
    }

    @Override // io.netty.buffer.ByteBuf
    public int indexOf(int i, int i2, byte b) {
        return ByteBufUtil.indexOf(this, i, i2, b);
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean isReadOnly() {
        return false;
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean isReadable() {
        return this.writerIndex > this.readerIndex;
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean isWritable() {
        return capacity() > this.writerIndex;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf markReaderIndex() {
        this.markedReaderIndex = this.readerIndex;
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf markWriterIndex() {
        this.markedWriterIndex = this.writerIndex;
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public int maxCapacity() {
        return this.maxCapacity;
    }

    @Override // io.netty.buffer.ByteBuf
    public int maxWritableBytes() {
        return maxCapacity() - this.writerIndex;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public SwappedByteBuf newSwappedByteBuf() {
        return new SwappedByteBuf(this);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuffer nioBuffer() {
        return nioBuffer(this.readerIndex, readableBytes());
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuffer[] nioBuffers() {
        return nioBuffers(this.readerIndex, readableBytes());
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf order(ByteOrder byteOrder) {
        if (byteOrder != null) {
            return byteOrder == order() ? this : newSwappedByteBuf();
        }
        throw new NullPointerException("endianness");
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean readBoolean() {
        return readByte() != 0;
    }

    @Override // io.netty.buffer.ByteBuf
    public byte readByte() {
        checkReadableBytes0(1);
        int i = this.readerIndex;
        byte _getByte = _getByte(i);
        this.readerIndex = i + 1;
        return _getByte;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf readBytes(int i) {
        checkReadableBytes(i);
        if (i == 0) {
            return Unpooled.EMPTY_BUFFER;
        }
        ByteBuf buffer = alloc().buffer(i, this.maxCapacity);
        buffer.writeBytes(this, this.readerIndex, i);
        this.readerIndex += i;
        return buffer;
    }

    @Override // io.netty.buffer.ByteBuf
    public char readChar() {
        return (char) readShort();
    }

    @Override // io.netty.buffer.ByteBuf
    public CharSequence readCharSequence(int i, Charset charset) {
        CharSequence charSequence = getCharSequence(this.readerIndex, i, charset);
        this.readerIndex += i;
        return charSequence;
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
        checkReadableBytes0(4);
        int _getInt = _getInt(this.readerIndex);
        this.readerIndex += 4;
        return _getInt;
    }

    @Override // io.netty.buffer.ByteBuf
    public int readIntLE() {
        checkReadableBytes0(4);
        int _getIntLE = _getIntLE(this.readerIndex);
        this.readerIndex += 4;
        return _getIntLE;
    }

    @Override // io.netty.buffer.ByteBuf
    public long readLong() {
        checkReadableBytes0(8);
        long _getLong = _getLong(this.readerIndex);
        this.readerIndex += 8;
        return _getLong;
    }

    @Override // io.netty.buffer.ByteBuf
    public long readLongLE() {
        checkReadableBytes0(8);
        long _getLongLE = _getLongLE(this.readerIndex);
        this.readerIndex += 8;
        return _getLongLE;
    }

    @Override // io.netty.buffer.ByteBuf
    public int readMedium() {
        int readUnsignedMedium = readUnsignedMedium();
        return (8388608 & readUnsignedMedium) != 0 ? readUnsignedMedium | ViewCompat.MEASURED_STATE_MASK : readUnsignedMedium;
    }

    @Override // io.netty.buffer.ByteBuf
    public int readMediumLE() {
        int readUnsignedMediumLE = readUnsignedMediumLE();
        return (8388608 & readUnsignedMediumLE) != 0 ? readUnsignedMediumLE | ViewCompat.MEASURED_STATE_MASK : readUnsignedMediumLE;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf readRetainedSlice(int i) {
        ByteBuf retainedSlice = retainedSlice(this.readerIndex, i);
        this.readerIndex += i;
        return retainedSlice;
    }

    @Override // io.netty.buffer.ByteBuf
    public short readShort() {
        checkReadableBytes0(2);
        short _getShort = _getShort(this.readerIndex);
        this.readerIndex += 2;
        return _getShort;
    }

    @Override // io.netty.buffer.ByteBuf
    public short readShortLE() {
        checkReadableBytes0(2);
        short _getShortLE = _getShortLE(this.readerIndex);
        this.readerIndex += 2;
        return _getShortLE;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf readSlice(int i) {
        ByteBuf slice = slice(this.readerIndex, i);
        this.readerIndex += i;
        return slice;
    }

    @Override // io.netty.buffer.ByteBuf
    public short readUnsignedByte() {
        return (short) (readByte() & UByte.f41242c);
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
        checkReadableBytes0(3);
        int _getUnsignedMedium = _getUnsignedMedium(this.readerIndex);
        this.readerIndex += 3;
        return _getUnsignedMedium;
    }

    @Override // io.netty.buffer.ByteBuf
    public int readUnsignedMediumLE() {
        checkReadableBytes0(3);
        int _getUnsignedMediumLE = _getUnsignedMediumLE(this.readerIndex);
        this.readerIndex += 3;
        return _getUnsignedMediumLE;
    }

    @Override // io.netty.buffer.ByteBuf
    public int readUnsignedShort() {
        return readShort() & UShort.f40820c;
    }

    @Override // io.netty.buffer.ByteBuf
    public int readUnsignedShortLE() {
        return readShortLE() & UShort.f40820c;
    }

    @Override // io.netty.buffer.ByteBuf
    public int readableBytes() {
        return this.writerIndex - this.readerIndex;
    }

    @Override // io.netty.buffer.ByteBuf
    public int readerIndex() {
        return this.readerIndex;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf resetReaderIndex() {
        readerIndex(this.markedReaderIndex);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf resetWriterIndex() {
        this.writerIndex = this.markedWriterIndex;
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf retainedDuplicate() {
        return duplicate().retain();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf retainedSlice() {
        return slice().retain();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBoolean(int i, boolean z) {
        setByte(i, z ? 1 : 0);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setByte(int i, int i2) {
        checkIndex(i);
        _setByte(i, i2);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i, byte[] bArr) {
        setBytes(i, bArr, 0, bArr.length);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setChar(int i, int i2) {
        setShort(i, i2);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public int setCharSequence(int i, CharSequence charSequence, Charset charset) {
        if (charset.equals(CharsetUtil.UTF_8)) {
            ensureWritable(ByteBufUtil.utf8MaxBytes(charSequence));
            return ByteBufUtil.writeUtf8(this, i, charSequence, charSequence.length());
        } else if (charset.equals(CharsetUtil.US_ASCII)) {
            int length = charSequence.length();
            ensureWritable(length);
            return ByteBufUtil.writeAscii(this, i, charSequence, length);
        } else {
            byte[] bytes = charSequence.toString().getBytes(charset);
            ensureWritable(bytes.length);
            setBytes(i, bytes);
            return bytes.length;
        }
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setDouble(int i, double d) {
        setLong(i, Double.doubleToRawLongBits(d));
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setFloat(int i, float f) {
        setInt(i, Float.floatToRawIntBits(f));
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setIndex(int i, int i2) {
        if (i >= 0 && i <= i2 && i2 <= capacity()) {
            setIndex0(i, i2);
            return this;
        }
        throw new IndexOutOfBoundsException(String.format("readerIndex: %d, writerIndex: %d (expected: 0 <= readerIndex <= writerIndex <= capacity(%d))", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(capacity())));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void setIndex0(int i, int i2) {
        this.readerIndex = i;
        this.writerIndex = i2;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setInt(int i, int i2) {
        checkIndex(i, 4);
        _setInt(i, i2);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setIntLE(int i, int i2) {
        checkIndex(i, 4);
        _setIntLE(i, i2);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setLong(int i, long j) {
        checkIndex(i, 8);
        _setLong(i, j);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setLongLE(int i, long j) {
        checkIndex(i, 8);
        _setLongLE(i, j);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setMedium(int i, int i2) {
        checkIndex(i, 3);
        _setMedium(i, i2);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setMediumLE(int i, int i2) {
        checkIndex(i, 3);
        _setMediumLE(i, i2);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setShort(int i, int i2) {
        checkIndex(i, 2);
        _setShort(i, i2);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setShortLE(int i, int i2) {
        checkIndex(i, 2);
        _setShortLE(i, i2);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setZero(int i, int i2) {
        if (i2 == 0) {
            return this;
        }
        checkIndex(i, i2);
        int i3 = i2 & 7;
        for (int i4 = i2 >>> 3; i4 > 0; i4--) {
            _setLong(i, 0L);
            i += 8;
        }
        if (i3 == 4) {
            _setInt(i, 0);
        } else if (i3 < 4) {
            while (i3 > 0) {
                _setByte(i, 0);
                i++;
                i3--;
            }
        } else {
            _setInt(i, 0);
            int i5 = i + 4;
            for (int i6 = i3 - 4; i6 > 0; i6--) {
                _setByte(i5, 0);
                i5++;
            }
        }
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf skipBytes(int i) {
        checkReadableBytes(i);
        this.readerIndex += i;
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf slice() {
        return slice(this.readerIndex, readableBytes());
    }

    @Override // io.netty.buffer.ByteBuf
    public String toString(Charset charset) {
        return toString(this.readerIndex, readableBytes(), charset);
    }

    @Override // io.netty.buffer.ByteBuf
    public int writableBytes() {
        return capacity() - this.writerIndex;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeBoolean(boolean z) {
        writeByte(z ? 1 : 0);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeByte(int i) {
        ensureAccessible();
        ensureWritable0(1);
        int i2 = this.writerIndex;
        this.writerIndex = i2 + 1;
        _setByte(i2, i);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeBytes(byte[] bArr, int i, int i2) {
        ensureAccessible();
        ensureWritable(i2);
        setBytes(this.writerIndex, bArr, i, i2);
        this.writerIndex += i2;
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeChar(int i) {
        writeShort(i);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public int writeCharSequence(CharSequence charSequence, Charset charset) {
        int charSequence2 = setCharSequence(this.writerIndex, charSequence, charset);
        this.writerIndex += charSequence2;
        return charSequence2;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeDouble(double d) {
        writeLong(Double.doubleToRawLongBits(d));
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeFloat(float f) {
        writeInt(Float.floatToRawIntBits(f));
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeInt(int i) {
        ensureAccessible();
        ensureWritable0(4);
        _setInt(this.writerIndex, i);
        this.writerIndex += 4;
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeIntLE(int i) {
        ensureAccessible();
        ensureWritable0(4);
        _setIntLE(this.writerIndex, i);
        this.writerIndex += 4;
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeLong(long j) {
        ensureAccessible();
        ensureWritable0(8);
        _setLong(this.writerIndex, j);
        this.writerIndex += 8;
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeLongLE(long j) {
        ensureAccessible();
        ensureWritable0(8);
        _setLongLE(this.writerIndex, j);
        this.writerIndex += 8;
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeMedium(int i) {
        ensureAccessible();
        ensureWritable0(3);
        _setMedium(this.writerIndex, i);
        this.writerIndex += 3;
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeMediumLE(int i) {
        ensureAccessible();
        ensureWritable0(3);
        _setMediumLE(this.writerIndex, i);
        this.writerIndex += 3;
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeShort(int i) {
        ensureAccessible();
        ensureWritable0(2);
        _setShort(this.writerIndex, i);
        this.writerIndex += 2;
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeShortLE(int i) {
        ensureAccessible();
        ensureWritable0(2);
        _setShortLE(this.writerIndex, i);
        this.writerIndex += 2;
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeZero(int i) {
        if (i == 0) {
            return this;
        }
        ensureWritable(i);
        int i2 = this.writerIndex;
        checkIndex(i2, i);
        int i3 = i & 7;
        for (int i4 = i >>> 3; i4 > 0; i4--) {
            _setLong(i2, 0L);
            i2 += 8;
        }
        if (i3 == 4) {
            _setInt(i2, 0);
            i2 += 4;
        } else if (i3 < 4) {
            while (i3 > 0) {
                _setByte(i2, 0);
                i2++;
                i3--;
            }
        } else {
            _setInt(i2, 0);
            i2 += 4;
            for (int i5 = i3 - 4; i5 > 0; i5--) {
                _setByte(i2, 0);
                i2++;
            }
        }
        this.writerIndex = i2;
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public int writerIndex() {
        return this.writerIndex;
    }

    @Override // io.netty.buffer.ByteBuf
    public int bytesBefore(int i, byte b) {
        checkReadableBytes(i);
        return bytesBefore(readerIndex(), i, b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void checkIndex(int i, int i2) {
        ensureAccessible();
        checkIndex0(i, i2);
    }

    @Override // io.netty.buffer.ByteBuf, java.lang.Comparable
    public int compareTo(ByteBuf byteBuf) {
        return ByteBufUtil.compare(this, byteBuf);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i, ByteBuf byteBuf) {
        getBytes(i, byteBuf, byteBuf.writableBytes());
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean isReadable(int i) {
        return this.writerIndex - this.readerIndex >= i;
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean isWritable(int i) {
        return capacity() - this.writerIndex >= i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void maxCapacity(int i) {
        this.maxCapacity = i;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf readerIndex(int i) {
        if (i >= 0 && i <= this.writerIndex) {
            this.readerIndex = i;
            return this;
        }
        throw new IndexOutOfBoundsException(String.format("readerIndex: %d (expected: 0 <= readerIndex <= writerIndex(%d))", Integer.valueOf(i), Integer.valueOf(this.writerIndex)));
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf retainedSlice(int i, int i2) {
        return slice(i, i2).retain();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i, ByteBuf byteBuf) {
        setBytes(i, byteBuf, byteBuf.readableBytes());
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf slice(int i, int i2) {
        return new UnpooledSlicedByteBuf(this, i, i2);
    }

    @Override // io.netty.buffer.ByteBuf
    public String toString(int i, int i2, Charset charset) {
        return ByteBufUtil.decodeString(this, i, i2, charset);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writerIndex(int i) {
        if (i >= this.readerIndex && i <= capacity()) {
            this.writerIndex = i;
            return this;
        }
        throw new IndexOutOfBoundsException(String.format("writerIndex: %d (expected: readerIndex(%d) <= writerIndex <= capacity(%d))", Integer.valueOf(i), Integer.valueOf(this.readerIndex), Integer.valueOf(capacity())));
    }

    @Override // io.netty.buffer.ByteBuf
    public int ensureWritable(int i, boolean z) {
        if (i >= 0) {
            if (i <= writableBytes()) {
                return 0;
            }
            if (i > this.maxCapacity - this.writerIndex && z) {
                if (capacity() == maxCapacity()) {
                    return 1;
                }
                capacity(maxCapacity());
                return 3;
            }
            capacity(alloc().calculateNewCapacity(this.writerIndex + i, this.maxCapacity));
            return 2;
        }
        throw new IllegalArgumentException(String.format("minWritableBytes: %d (expected: >= 0)", Integer.valueOf(i)));
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i, ByteBuf byteBuf, int i2) {
        getBytes(i, byteBuf, byteBuf.writerIndex(), i2);
        byteBuf.writerIndex(byteBuf.writerIndex() + i2);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i, ByteBuf byteBuf, int i2) {
        checkIndex(i, i2);
        if (byteBuf != null) {
            if (i2 <= byteBuf.readableBytes()) {
                setBytes(i, byteBuf, byteBuf.readerIndex(), i2);
                byteBuf.readerIndex(byteBuf.readerIndex() + i2);
                return this;
            }
            throw new IndexOutOfBoundsException(String.format("length(%d) exceeds src.readableBytes(%d) where src is: %s", Integer.valueOf(i2), Integer.valueOf(byteBuf.readableBytes()), byteBuf));
        }
        throw new NullPointerException("src");
    }

    @Override // io.netty.buffer.ByteBuf
    public String toString() {
        if (refCnt() == 0) {
            return StringUtil.simpleClassName(this) + "(freed)";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(StringUtil.simpleClassName(this));
        sb.append("(ridx: ");
        sb.append(this.readerIndex);
        sb.append(", widx: ");
        sb.append(this.writerIndex);
        sb.append(", cap: ");
        sb.append(capacity());
        if (this.maxCapacity != Integer.MAX_VALUE) {
            sb.append('/');
            sb.append(this.maxCapacity);
        }
        ByteBuf unwrap = unwrap();
        if (unwrap != null) {
            sb.append(", unwrapped: ");
            sb.append(unwrap);
        }
        sb.append(')');
        return sb.toString();
    }

    @Override // io.netty.buffer.ByteBuf
    public int bytesBefore(int i, int i2, byte b) {
        int indexOf = indexOf(i, i2 + i, b);
        if (indexOf < 0) {
            return -1;
        }
        return indexOf - i;
    }

    @Override // io.netty.buffer.ByteBuf
    public int forEachByte(int i, int i2, ByteProcessor byteProcessor) {
        checkIndex(i, i2);
        try {
            return forEachByteAsc0(i, i2 + i, byteProcessor);
        } catch (Exception e) {
            PlatformDependent.throwException(e);
            return -1;
        }
    }

    @Override // io.netty.buffer.ByteBuf
    public int forEachByteDesc(int i, int i2, ByteProcessor byteProcessor) {
        checkIndex(i, i2);
        try {
            return forEachByteDesc0((i2 + i) - 1, i, byteProcessor);
        } catch (Exception e) {
            PlatformDependent.throwException(e);
            return -1;
        }
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeBytes(byte[] bArr) {
        writeBytes(bArr, 0, bArr.length);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf readBytes(byte[] bArr, int i, int i2) {
        checkReadableBytes(i2);
        getBytes(this.readerIndex, bArr, i, i2);
        this.readerIndex += i2;
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeBytes(ByteBuf byteBuf) {
        writeBytes(byteBuf, byteBuf.readableBytes());
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeBytes(ByteBuf byteBuf, int i) {
        if (i <= byteBuf.readableBytes()) {
            writeBytes(byteBuf, byteBuf.readerIndex(), i);
            byteBuf.readerIndex(byteBuf.readerIndex() + i);
            return this;
        }
        throw new IndexOutOfBoundsException(String.format("length(%d) exceeds src.readableBytes(%d) where src is: %s", Integer.valueOf(i), Integer.valueOf(byteBuf.readableBytes()), byteBuf));
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf readBytes(byte[] bArr) {
        readBytes(bArr, 0, bArr.length);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf readBytes(ByteBuf byteBuf) {
        readBytes(byteBuf, byteBuf.writableBytes());
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf readBytes(ByteBuf byteBuf, int i) {
        if (i <= byteBuf.writableBytes()) {
            readBytes(byteBuf, byteBuf.writerIndex(), i);
            byteBuf.writerIndex(byteBuf.writerIndex() + i);
            return this;
        }
        throw new IndexOutOfBoundsException(String.format("length(%d) exceeds dst.writableBytes(%d) where dst is: %s", Integer.valueOf(i), Integer.valueOf(byteBuf.writableBytes()), byteBuf));
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeBytes(ByteBuf byteBuf, int i, int i2) {
        ensureAccessible();
        ensureWritable(i2);
        setBytes(this.writerIndex, byteBuf, i, i2);
        this.writerIndex += i2;
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf readBytes(ByteBuf byteBuf, int i, int i2) {
        checkReadableBytes(i2);
        getBytes(this.readerIndex, byteBuf, i, i2);
        this.readerIndex += i2;
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeBytes(ByteBuffer byteBuffer) {
        ensureAccessible();
        int remaining = byteBuffer.remaining();
        ensureWritable(remaining);
        setBytes(this.writerIndex, byteBuffer);
        this.writerIndex += remaining;
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf readBytes(ByteBuffer byteBuffer) {
        int remaining = byteBuffer.remaining();
        checkReadableBytes(remaining);
        getBytes(this.readerIndex, byteBuffer);
        this.readerIndex += remaining;
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public int writeBytes(InputStream inputStream, int i) throws IOException {
        ensureAccessible();
        ensureWritable(i);
        int bytes = setBytes(this.writerIndex, inputStream, i);
        if (bytes > 0) {
            this.writerIndex += bytes;
        }
        return bytes;
    }

    @Override // io.netty.buffer.ByteBuf
    public int readBytes(GatheringByteChannel gatheringByteChannel, int i) throws IOException {
        checkReadableBytes(i);
        int bytes = getBytes(this.readerIndex, gatheringByteChannel, i);
        this.readerIndex += bytes;
        return bytes;
    }

    @Override // io.netty.buffer.ByteBuf
    public int writeBytes(ScatteringByteChannel scatteringByteChannel, int i) throws IOException {
        ensureAccessible();
        ensureWritable(i);
        int bytes = setBytes(this.writerIndex, scatteringByteChannel, i);
        if (bytes > 0) {
            this.writerIndex += bytes;
        }
        return bytes;
    }

    @Override // io.netty.buffer.ByteBuf
    public int readBytes(FileChannel fileChannel, long j, int i) throws IOException {
        checkReadableBytes(i);
        int bytes = getBytes(this.readerIndex, fileChannel, j, i);
        this.readerIndex += bytes;
        return bytes;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf readBytes(OutputStream outputStream, int i) throws IOException {
        checkReadableBytes(i);
        getBytes(this.readerIndex, outputStream, i);
        this.readerIndex += i;
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public int writeBytes(FileChannel fileChannel, long j, int i) throws IOException {
        ensureAccessible();
        ensureWritable(i);
        int bytes = setBytes(this.writerIndex, fileChannel, j, i);
        if (bytes > 0) {
            this.writerIndex += bytes;
        }
        return bytes;
    }
}
