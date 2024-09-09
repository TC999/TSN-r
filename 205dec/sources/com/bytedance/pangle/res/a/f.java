package com.bytedance.pangle.res.a;

import java.io.DataInput;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public abstract class f implements DataInput {

    /* renamed from: a  reason: collision with root package name */
    public final i f28934a;

    public f(i iVar) {
        this.f28934a = iVar;
    }

    @Override // java.io.DataInput
    public boolean readBoolean() {
        return this.f28934a.readBoolean();
    }

    @Override // java.io.DataInput
    public byte readByte() {
        return this.f28934a.readByte();
    }

    @Override // java.io.DataInput
    public char readChar() {
        return this.f28934a.readChar();
    }

    @Override // java.io.DataInput
    public double readDouble() {
        return this.f28934a.readDouble();
    }

    @Override // java.io.DataInput
    public float readFloat() {
        return this.f28934a.readFloat();
    }

    @Override // java.io.DataInput
    public void readFully(byte[] bArr, int i4, int i5) {
        this.f28934a.readFully(bArr, i4, i5);
    }

    @Override // java.io.DataInput
    public int readInt() {
        return this.f28934a.readInt();
    }

    @Override // java.io.DataInput
    public String readLine() {
        return this.f28934a.readLine();
    }

    @Override // java.io.DataInput
    public long readLong() {
        return this.f28934a.readLong();
    }

    @Override // java.io.DataInput
    public short readShort() {
        return this.f28934a.readShort();
    }

    @Override // java.io.DataInput
    public String readUTF() {
        return this.f28934a.readUTF();
    }

    @Override // java.io.DataInput
    public int readUnsignedByte() {
        return this.f28934a.readUnsignedByte();
    }

    @Override // java.io.DataInput
    public int readUnsignedShort() {
        return this.f28934a.readUnsignedShort();
    }

    @Override // java.io.DataInput
    public int skipBytes(int i4) {
        return this.f28934a.skipBytes(i4);
    }

    @Override // java.io.DataInput
    public void readFully(byte[] bArr) {
        this.f28934a.readFully(bArr);
    }
}
