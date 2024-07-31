package io.netty.buffer;

import io.netty.util.internal.PlatformDependent;
import java.nio.ByteOrder;
import kotlin.UShort;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
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

    protected abstract int _getInt(AbstractByteBuf abstractByteBuf, int i);

    protected abstract long _getLong(AbstractByteBuf abstractByteBuf, int i);

    protected abstract short _getShort(AbstractByteBuf abstractByteBuf, int i);

    protected abstract void _setInt(AbstractByteBuf abstractByteBuf, int i, int i2);

    protected abstract void _setLong(AbstractByteBuf abstractByteBuf, int i, long j);

    protected abstract void _setShort(AbstractByteBuf abstractByteBuf, int i, short s);

    @Override // io.netty.buffer.SwappedByteBuf, io.netty.buffer.ByteBuf
    public final char getChar(int i) {
        return (char) getShort(i);
    }

    @Override // io.netty.buffer.SwappedByteBuf, io.netty.buffer.ByteBuf
    public final double getDouble(int i) {
        return Double.longBitsToDouble(getLong(i));
    }

    @Override // io.netty.buffer.SwappedByteBuf, io.netty.buffer.ByteBuf
    public final float getFloat(int i) {
        return Float.intBitsToFloat(getInt(i));
    }

    @Override // io.netty.buffer.SwappedByteBuf, io.netty.buffer.ByteBuf
    public final int getInt(int i) {
        this.wrapped.checkIndex0(i, 4);
        int _getInt = _getInt(this.wrapped, i);
        return this.nativeByteOrder ? _getInt : Integer.reverseBytes(_getInt);
    }

    @Override // io.netty.buffer.SwappedByteBuf, io.netty.buffer.ByteBuf
    public final long getLong(int i) {
        this.wrapped.checkIndex(i, 8);
        long _getLong = _getLong(this.wrapped, i);
        return this.nativeByteOrder ? _getLong : Long.reverseBytes(_getLong);
    }

    @Override // io.netty.buffer.SwappedByteBuf, io.netty.buffer.ByteBuf
    public final short getShort(int i) {
        this.wrapped.checkIndex0(i, 2);
        short _getShort = _getShort(this.wrapped, i);
        return this.nativeByteOrder ? _getShort : Short.reverseBytes(_getShort);
    }

    @Override // io.netty.buffer.SwappedByteBuf, io.netty.buffer.ByteBuf
    public final long getUnsignedInt(int i) {
        return getInt(i) & 4294967295L;
    }

    @Override // io.netty.buffer.SwappedByteBuf, io.netty.buffer.ByteBuf
    public final int getUnsignedShort(int i) {
        return getShort(i) & UShort.f40820c;
    }

    @Override // io.netty.buffer.SwappedByteBuf, io.netty.buffer.ByteBuf
    public final ByteBuf setChar(int i, int i2) {
        setShort(i, i2);
        return this;
    }

    @Override // io.netty.buffer.SwappedByteBuf, io.netty.buffer.ByteBuf
    public final ByteBuf setDouble(int i, double d) {
        setLong(i, Double.doubleToRawLongBits(d));
        return this;
    }

    @Override // io.netty.buffer.SwappedByteBuf, io.netty.buffer.ByteBuf
    public final ByteBuf setFloat(int i, float f) {
        setInt(i, Float.floatToRawIntBits(f));
        return this;
    }

    @Override // io.netty.buffer.SwappedByteBuf, io.netty.buffer.ByteBuf
    public final ByteBuf setInt(int i, int i2) {
        this.wrapped.checkIndex0(i, 4);
        AbstractByteBuf abstractByteBuf = this.wrapped;
        if (!this.nativeByteOrder) {
            i2 = Integer.reverseBytes(i2);
        }
        _setInt(abstractByteBuf, i, i2);
        return this;
    }

    @Override // io.netty.buffer.SwappedByteBuf, io.netty.buffer.ByteBuf
    public final ByteBuf setLong(int i, long j) {
        this.wrapped.checkIndex(i, 8);
        AbstractByteBuf abstractByteBuf = this.wrapped;
        if (!this.nativeByteOrder) {
            j = Long.reverseBytes(j);
        }
        _setLong(abstractByteBuf, i, j);
        return this;
    }

    @Override // io.netty.buffer.SwappedByteBuf, io.netty.buffer.ByteBuf
    public final ByteBuf setShort(int i, int i2) {
        this.wrapped.checkIndex0(i, 2);
        AbstractByteBuf abstractByteBuf = this.wrapped;
        short s = (short) i2;
        if (!this.nativeByteOrder) {
            s = Short.reverseBytes(s);
        }
        _setShort(abstractByteBuf, i, s);
        return this;
    }

    @Override // io.netty.buffer.SwappedByteBuf, io.netty.buffer.ByteBuf
    public final ByteBuf writeChar(int i) {
        writeShort(i);
        return this;
    }

    @Override // io.netty.buffer.SwappedByteBuf, io.netty.buffer.ByteBuf
    public final ByteBuf writeDouble(double d) {
        writeLong(Double.doubleToRawLongBits(d));
        return this;
    }

    @Override // io.netty.buffer.SwappedByteBuf, io.netty.buffer.ByteBuf
    public final ByteBuf writeFloat(float f) {
        writeInt(Float.floatToRawIntBits(f));
        return this;
    }

    @Override // io.netty.buffer.SwappedByteBuf, io.netty.buffer.ByteBuf
    public final ByteBuf writeInt(int i) {
        this.wrapped.ensureWritable(4);
        AbstractByteBuf abstractByteBuf = this.wrapped;
        int i2 = abstractByteBuf.writerIndex;
        if (!this.nativeByteOrder) {
            i = Integer.reverseBytes(i);
        }
        _setInt(abstractByteBuf, i2, i);
        this.wrapped.writerIndex += 4;
        return this;
    }

    @Override // io.netty.buffer.SwappedByteBuf, io.netty.buffer.ByteBuf
    public final ByteBuf writeLong(long j) {
        this.wrapped.ensureWritable(8);
        AbstractByteBuf abstractByteBuf = this.wrapped;
        int i = abstractByteBuf.writerIndex;
        if (!this.nativeByteOrder) {
            j = Long.reverseBytes(j);
        }
        _setLong(abstractByteBuf, i, j);
        this.wrapped.writerIndex += 8;
        return this;
    }

    @Override // io.netty.buffer.SwappedByteBuf, io.netty.buffer.ByteBuf
    public final ByteBuf writeShort(int i) {
        this.wrapped.ensureWritable(2);
        AbstractByteBuf abstractByteBuf = this.wrapped;
        int i2 = abstractByteBuf.writerIndex;
        short s = (short) i;
        if (!this.nativeByteOrder) {
            s = Short.reverseBytes(s);
        }
        _setShort(abstractByteBuf, i2, s);
        this.wrapped.writerIndex += 2;
        return this;
    }
}
