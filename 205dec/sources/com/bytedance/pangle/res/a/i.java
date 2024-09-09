package com.bytedance.pangle.res.a;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FilterInputStream;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class i extends FilterInputStream implements DataInput {
    public i(e eVar) {
        super(eVar);
    }

    private static int a(byte b4, byte b5, byte b6, byte b7) {
        return (b4 << 24) | ((b5 & 255) << 16) | ((b6 & 255) << 8) | (b7 & 255);
    }

    private byte b() {
        int read = ((FilterInputStream) this).in.read();
        if (-1 != read) {
            return (byte) read;
        }
        throw new EOFException();
    }

    public final e a() {
        return (e) ((FilterInputStream) this).in;
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
    public final void readFully(byte[] bArr, int i4, int i5) {
        d.a(this, bArr, i4, i5);
    }

    @Override // java.io.DataInput
    public final int readInt() {
        byte b4 = b();
        byte b5 = b();
        return a(b(), b(), b5, b4);
    }

    @Override // java.io.DataInput
    public final String readLine() {
        throw new UnsupportedOperationException("readLine is not supported");
    }

    @Override // java.io.DataInput
    public final long readLong() {
        byte b4 = b();
        byte b5 = b();
        byte b6 = b();
        byte b7 = b();
        byte b8 = b();
        byte b9 = b();
        return ((b5 & 255) << 8) | ((b7 & 255) << 24) | ((b9 & 255) << 40) | ((b() & 255) << 56) | ((b() & 255) << 48) | ((b8 & 255) << 32) | ((b6 & 255) << 16) | (b4 & 255);
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
        return a((byte) 0, (byte) 0, b(), b());
    }

    @Override // java.io.DataInput
    public final int skipBytes(int i4) {
        return (int) ((FilterInputStream) this).in.skip(i4);
    }

    @Override // java.io.DataInput
    public final void readFully(byte[] bArr) {
        d.a(this, bArr, 0, bArr.length);
    }
}
