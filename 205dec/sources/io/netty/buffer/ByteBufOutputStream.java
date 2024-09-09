package io.netty.buffer;

import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class ByteBufOutputStream extends OutputStream implements DataOutput {
    private final ByteBuf buffer;
    private final int startIndex;
    private final DataOutputStream utf8out = new DataOutputStream(this);

    public ByteBufOutputStream(ByteBuf byteBuf) {
        if (byteBuf != null) {
            this.buffer = byteBuf;
            this.startIndex = byteBuf.writerIndex();
            return;
        }
        throw new NullPointerException("buffer");
    }

    public ByteBuf buffer() {
        return this.buffer;
    }

    @Override // java.io.OutputStream, java.io.DataOutput
    public void write(byte[] bArr, int i4, int i5) throws IOException {
        if (i5 == 0) {
            return;
        }
        this.buffer.writeBytes(bArr, i4, i5);
    }

    @Override // java.io.DataOutput
    public void writeBoolean(boolean z3) throws IOException {
        write(z3 ? 1 : 0);
    }

    @Override // java.io.DataOutput
    public void writeByte(int i4) throws IOException {
        write(i4);
    }

    @Override // java.io.DataOutput
    public void writeBytes(String str) throws IOException {
        int length = str.length();
        for (int i4 = 0; i4 < length; i4++) {
            write((byte) str.charAt(i4));
        }
    }

    @Override // java.io.DataOutput
    public void writeChar(int i4) throws IOException {
        writeShort((short) i4);
    }

    @Override // java.io.DataOutput
    public void writeChars(String str) throws IOException {
        int length = str.length();
        for (int i4 = 0; i4 < length; i4++) {
            writeChar(str.charAt(i4));
        }
    }

    @Override // java.io.DataOutput
    public void writeDouble(double d4) throws IOException {
        writeLong(Double.doubleToLongBits(d4));
    }

    @Override // java.io.DataOutput
    public void writeFloat(float f4) throws IOException {
        writeInt(Float.floatToIntBits(f4));
    }

    @Override // java.io.DataOutput
    public void writeInt(int i4) throws IOException {
        this.buffer.writeInt(i4);
    }

    @Override // java.io.DataOutput
    public void writeLong(long j4) throws IOException {
        this.buffer.writeLong(j4);
    }

    @Override // java.io.DataOutput
    public void writeShort(int i4) throws IOException {
        this.buffer.writeShort((short) i4);
    }

    @Override // java.io.DataOutput
    public void writeUTF(String str) throws IOException {
        this.utf8out.writeUTF(str);
    }

    public int writtenBytes() {
        return this.buffer.writerIndex() - this.startIndex;
    }

    @Override // java.io.OutputStream, java.io.DataOutput
    public void write(byte[] bArr) throws IOException {
        this.buffer.writeBytes(bArr);
    }

    @Override // java.io.OutputStream, java.io.DataOutput
    public void write(int i4) throws IOException {
        this.buffer.writeByte((byte) i4);
    }
}
