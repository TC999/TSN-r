package com.bytedance.pangle.res.p124a;

import io.netty.handler.codec.memcache.binary.BinaryMemcacheOpcodes;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FilterInputStream;
import kotlin.UByte;

/* renamed from: com.bytedance.pangle.res.a.i */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class C6211i extends FilterInputStream implements DataInput {
    public C6211i(C6207e c6207e) {
        super(c6207e);
    }

    /* renamed from: a */
    private static int m36974a(byte b, byte b2, byte b3, byte b4) {
        return (b << BinaryMemcacheOpcodes.FLUSHQ) | ((b2 & UByte.f41242c) << 16) | ((b3 & UByte.f41242c) << 8) | (b4 & UByte.f41242c);
    }

    /* renamed from: b */
    private byte m36973b() {
        int read = ((FilterInputStream) this).in.read();
        if (-1 != read) {
            return (byte) read;
        }
        throw new EOFException();
    }

    /* renamed from: a */
    public final C6207e m36975a() {
        return (C6207e) ((FilterInputStream) this).in;
    }

    @Override // java.io.DataInput
    public final boolean readBoolean() {
        return readUnsignedByte() != 0;
    }

    @Override // java.io.DataInput
    public final byte readByte() {
        return (byte) readUnsignedByte();
    }

    @Override // java.io.DataInput
    public final char readChar() {
        return (char) readUnsignedShort();
    }

    @Override // java.io.DataInput
    public final double readDouble() {
        return Double.longBitsToDouble(readLong());
    }

    @Override // java.io.DataInput
    public final float readFloat() {
        return Float.intBitsToFloat(readInt());
    }

    @Override // java.io.DataInput
    public final void readFully(byte[] bArr, int i, int i2) {
        C6206d.m36985a(this, bArr, i, i2);
    }

    @Override // java.io.DataInput
    public final int readInt() {
        byte m36973b = m36973b();
        byte m36973b2 = m36973b();
        return m36974a(m36973b(), m36973b(), m36973b2, m36973b);
    }

    @Override // java.io.DataInput
    public final String readLine() {
        throw new UnsupportedOperationException("readLine is not supported");
    }

    @Override // java.io.DataInput
    public final long readLong() {
        byte m36973b = m36973b();
        byte m36973b2 = m36973b();
        byte m36973b3 = m36973b();
        byte m36973b4 = m36973b();
        byte m36973b5 = m36973b();
        byte m36973b6 = m36973b();
        return ((m36973b2 & 255) << 8) | ((m36973b4 & 255) << 24) | ((m36973b6 & 255) << 40) | ((m36973b() & 255) << 56) | ((m36973b() & 255) << 48) | ((m36973b5 & 255) << 32) | ((m36973b3 & 255) << 16) | (m36973b & 255);
    }

    @Override // java.io.DataInput
    public final short readShort() {
        return (short) readUnsignedShort();
    }

    @Override // java.io.DataInput
    public final String readUTF() {
        return new DataInputStream(((FilterInputStream) this).in).readUTF();
    }

    @Override // java.io.DataInput
    public final int readUnsignedByte() {
        int read = ((FilterInputStream) this).in.read();
        if (read >= 0) {
            return read;
        }
        throw new EOFException();
    }

    @Override // java.io.DataInput
    public final int readUnsignedShort() {
        return m36974a((byte) 0, (byte) 0, m36973b(), m36973b());
    }

    @Override // java.io.DataInput
    public final int skipBytes(int i) {
        return (int) ((FilterInputStream) this).in.skip(i);
    }

    @Override // java.io.DataInput
    public final void readFully(byte[] bArr) {
        C6206d.m36985a(this, bArr, 0, bArr.length);
    }
}
