package com.bytedance.pangle.res.p124a;

import java.io.DataInput;

/* renamed from: com.bytedance.pangle.res.a.f */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public abstract class AbstractC6208f implements DataInput {

    /* renamed from: a */
    public final C6211i f22173a;

    public AbstractC6208f(C6211i c6211i) {
        this.f22173a = c6211i;
    }

    @Override // java.io.DataInput
    public boolean readBoolean() {
        return this.f22173a.readBoolean();
    }

    @Override // java.io.DataInput
    public byte readByte() {
        return this.f22173a.readByte();
    }

    @Override // java.io.DataInput
    public char readChar() {
        return this.f22173a.readChar();
    }

    @Override // java.io.DataInput
    public double readDouble() {
        return this.f22173a.readDouble();
    }

    @Override // java.io.DataInput
    public float readFloat() {
        return this.f22173a.readFloat();
    }

    @Override // java.io.DataInput
    public void readFully(byte[] bArr, int i, int i2) {
        this.f22173a.readFully(bArr, i, i2);
    }

    @Override // java.io.DataInput
    public int readInt() {
        return this.f22173a.readInt();
    }

    @Override // java.io.DataInput
    public String readLine() {
        return this.f22173a.readLine();
    }

    @Override // java.io.DataInput
    public long readLong() {
        return this.f22173a.readLong();
    }

    @Override // java.io.DataInput
    public short readShort() {
        return this.f22173a.readShort();
    }

    @Override // java.io.DataInput
    public String readUTF() {
        return this.f22173a.readUTF();
    }

    @Override // java.io.DataInput
    public int readUnsignedByte() {
        return this.f22173a.readUnsignedByte();
    }

    @Override // java.io.DataInput
    public int readUnsignedShort() {
        return this.f22173a.readUnsignedShort();
    }

    @Override // java.io.DataInput
    public int skipBytes(int i) {
        return this.f22173a.skipBytes(i);
    }

    @Override // java.io.DataInput
    public void readFully(byte[] bArr) {
        this.f22173a.readFully(bArr);
    }
}
