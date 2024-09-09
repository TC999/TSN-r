package io.netty.buffer;

import io.netty.util.internal.PlatformDependent;
import java.nio.ByteOrder;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public abstract class AbstractUnsafeSwappedByteBuf extends SwappedByteBuf {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final boolean nativeByteOrder;
    private final AbstractByteBuf wrapped;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractUnsafeSwappedByteBuf(AbstractByteBuf abstractByteBuf) {
        super(abstractByteBuf);
        this.wrapped = abstractByteBuf;
        this.nativeByteOrder = PlatformDependent.BIG_ENDIAN_NATIVE_ORDER == (order() == ByteOrder.BIG_ENDIAN);
    }

    protected abstract int _getInt(AbstractByteBuf abstractByteBuf, int i4);

    protected abstract long _getLong(AbstractByteBuf abstractByteBuf, int i4);

    protected abstract short _getShort(AbstractByteBuf abstractByteBuf, int i4);

    protected abstract void _setInt(AbstractByteBuf abstractByteBuf, int i4, int i5);

    protected abstract void _setLong(AbstractByteBuf abstractByteBuf, int i4, long j4);

    protected abstract void _setShort(AbstractByteBuf abstractByteBuf, int i4, short s3);

    @Override // io.netty.buffer.SwappedByteBuf, io.netty.buffer.ByteBuf
    public final char getChar(int i4) {
        return (char) getShort(i4);
    }

    @Override // io.netty.buffer.SwappedByteBuf, io.netty.buffer.ByteBuf
    public final double getDouble(int i4) {
        return Double.longBitsToDouble(getLong(i4));
    }

    @Override // io.netty.buffer.SwappedByteBuf, io.netty.buffer.ByteBuf
    public final float getFloat(int i4) {
        return Float.intBitsToFloat(getInt(i4));
    }

    @Override // io.netty.buffer.SwappedByteBuf, io.netty.buffer.ByteBuf
    public final int getInt(int i4) {
        this.wrapped.checkIndex0(i4, 4);
        int _getInt = _getInt(this.wrapped, i4);
        return this.nativeByteOrder ? _getInt : Integer.reverseBytes(_getInt);
    }

    @Override // io.netty.buffer.SwappedByteBuf, io.netty.buffer.ByteBuf
    public final long getLong(int i4) {
        this.wrapped.checkIndex(i4, 8);
        long _getLong = _getLong(this.wrapped, i4);
        return this.nativeByteOrder ? _getLong : Long.reverseBytes(_getLong);
    }

    @Override // io.netty.buffer.SwappedByteBuf, io.netty.buffer.ByteBuf
    public final short getShort(int i4) {
        this.wrapped.checkIndex0(i4, 2);
        short _getShort = _getShort(this.wrapped, i4);
        return this.nativeByteOrder ? _getShort : Short.reverseBytes(_getShort);
    }

    @Override // io.netty.buffer.SwappedByteBuf, io.netty.buffer.ByteBuf
    public final long getUnsignedInt(int i4) {
        return getInt(i4) & 4294967295L;
    }

    @Override // io.netty.buffer.SwappedByteBuf, io.netty.buffer.ByteBuf
    public final int getUnsignedShort(int i4) {
        return getShort(i4) & 65535;
    }

    @Override // io.netty.buffer.SwappedByteBuf, io.netty.buffer.ByteBuf
    public final ByteBuf setChar(int i4, int i5) {
        setShort(i4, i5);
        return this;
    }

    @Override // io.netty.buffer.SwappedByteBuf, io.netty.buffer.ByteBuf
    public final ByteBuf setDouble(int i4, double d4) {
        setLong(i4, Double.doubleToRawLongBits(d4));
        return this;
    }

    @Override // io.netty.buffer.SwappedByteBuf, io.netty.buffer.ByteBuf
    public final ByteBuf setFloat(int i4, float f4) {
        setInt(i4, Float.floatToRawIntBits(f4));
        return this;
    }

    @Override // io.netty.buffer.SwappedByteBuf, io.netty.buffer.ByteBuf
    public final ByteBuf setInt(int i4, int i5) {
        this.wrapped.checkIndex0(i4, 4);
        AbstractByteBuf abstractByteBuf = this.wrapped;
        if (!this.nativeByteOrder) {
            i5 = Integer.reverseBytes(i5);
        }
        _setInt(abstractByteBuf, i4, i5);
        return this;
    }

    @Override // io.netty.buffer.SwappedByteBuf, io.netty.buffer.ByteBuf
    public final ByteBuf setLong(int i4, long j4) {
        this.wrapped.checkIndex(i4, 8);
        AbstractByteBuf abstractByteBuf = this.wrapped;
        if (!this.nativeByteOrder) {
            j4 = Long.reverseBytes(j4);
        }
        _setLong(abstractByteBuf, i4, j4);
        return this;
    }

    @Override // io.netty.buffer.SwappedByteBuf, io.netty.buffer.ByteBuf
    public final ByteBuf setShort(int i4, int i5) {
        this.wrapped.checkIndex0(i4, 2);
        AbstractByteBuf abstractByteBuf = this.wrapped;
        short s3 = (short) i5;
        if (!this.nativeByteOrder) {
            s3 = Short.reverseBytes(s3);
        }
        _setShort(abstractByteBuf, i4, s3);
        return this;
    }

    @Override // io.netty.buffer.SwappedByteBuf, io.netty.buffer.ByteBuf
    public final ByteBuf writeChar(int i4) {
        writeShort(i4);
        return this;
    }

    @Override // io.netty.buffer.SwappedByteBuf, io.netty.buffer.ByteBuf
    public final ByteBuf writeDouble(double d4) {
        writeLong(Double.doubleToRawLongBits(d4));
        return this;
    }

    @Override // io.netty.buffer.SwappedByteBuf, io.netty.buffer.ByteBuf
    public final ByteBuf writeFloat(float f4) {
        writeInt(Float.floatToRawIntBits(f4));
        return this;
    }

    @Override // io.netty.buffer.SwappedByteBuf, io.netty.buffer.ByteBuf
    public final ByteBuf writeInt(int i4) {
        this.wrapped.ensureWritable(4);
        AbstractByteBuf abstractByteBuf = this.wrapped;
        int i5 = abstractByteBuf.writerIndex;
        if (!this.nativeByteOrder) {
            i4 = Integer.reverseBytes(i4);
        }
        _setInt(abstractByteBuf, i5, i4);
        this.wrapped.writerIndex += 4;
        return this;
    }

    @Override // io.netty.buffer.SwappedByteBuf, io.netty.buffer.ByteBuf
    public final ByteBuf writeLong(long j4) {
        this.wrapped.ensureWritable(8);
        AbstractByteBuf abstractByteBuf = this.wrapped;
        int i4 = abstractByteBuf.writerIndex;
        if (!this.nativeByteOrder) {
            j4 = Long.reverseBytes(j4);
        }
        _setLong(abstractByteBuf, i4, j4);
        this.wrapped.writerIndex += 8;
        return this;
    }

    @Override // io.netty.buffer.SwappedByteBuf, io.netty.buffer.ByteBuf
    public final ByteBuf writeShort(int i4) {
        this.wrapped.ensureWritable(2);
        AbstractByteBuf abstractByteBuf = this.wrapped;
        int i5 = abstractByteBuf.writerIndex;
        short s3 = (short) i4;
        if (!this.nativeByteOrder) {
            s3 = Short.reverseBytes(s3);
        }
        _setShort(abstractByteBuf, i5, s3);
        this.wrapped.writerIndex += 2;
        return this;
    }
}
