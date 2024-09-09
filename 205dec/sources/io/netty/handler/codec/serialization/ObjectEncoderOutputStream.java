package io.netty.handler.codec.serialization;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufOutputStream;
import io.netty.buffer.Unpooled;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.OutputStream;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class ObjectEncoderOutputStream extends OutputStream implements ObjectOutput {
    private final int estimatedLength;
    private final DataOutputStream out;

    public ObjectEncoderOutputStream(OutputStream outputStream) {
        this(outputStream, 512);
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable, java.io.ObjectOutput
    public void close() throws IOException {
        this.out.close();
    }

    @Override // java.io.OutputStream, java.io.Flushable, java.io.ObjectOutput
    public void flush() throws IOException {
        this.out.flush();
    }

    public final int size() {
        return this.out.size();
    }

    @Override // java.io.OutputStream, java.io.ObjectOutput, java.io.DataOutput
    public void write(int i4) throws IOException {
        this.out.write(i4);
    }

    @Override // java.io.DataOutput
    public final void writeBoolean(boolean z3) throws IOException {
        this.out.writeBoolean(z3);
    }

    @Override // java.io.DataOutput
    public final void writeByte(int i4) throws IOException {
        this.out.writeByte(i4);
    }

    @Override // java.io.DataOutput
    public final void writeBytes(String str) throws IOException {
        this.out.writeBytes(str);
    }

    @Override // java.io.DataOutput
    public final void writeChar(int i4) throws IOException {
        this.out.writeChar(i4);
    }

    @Override // java.io.DataOutput
    public final void writeChars(String str) throws IOException {
        this.out.writeChars(str);
    }

    @Override // java.io.DataOutput
    public final void writeDouble(double d4) throws IOException {
        this.out.writeDouble(d4);
    }

    @Override // java.io.DataOutput
    public final void writeFloat(float f4) throws IOException {
        this.out.writeFloat(f4);
    }

    @Override // java.io.DataOutput
    public final void writeInt(int i4) throws IOException {
        this.out.writeInt(i4);
    }

    @Override // java.io.DataOutput
    public final void writeLong(long j4) throws IOException {
        this.out.writeLong(j4);
    }

    @Override // java.io.ObjectOutput
    public void writeObject(Object obj) throws IOException {
        ByteBufOutputStream byteBufOutputStream = new ByteBufOutputStream(Unpooled.buffer(this.estimatedLength));
        CompactObjectOutputStream compactObjectOutputStream = new CompactObjectOutputStream(byteBufOutputStream);
        compactObjectOutputStream.writeObject(obj);
        compactObjectOutputStream.flush();
        compactObjectOutputStream.close();
        ByteBuf buffer = byteBufOutputStream.buffer();
        int readableBytes = buffer.readableBytes();
        writeInt(readableBytes);
        buffer.getBytes(0, this, readableBytes);
    }

    @Override // java.io.DataOutput
    public final void writeShort(int i4) throws IOException {
        this.out.writeShort(i4);
    }

    @Override // java.io.DataOutput
    public final void writeUTF(String str) throws IOException {
        this.out.writeUTF(str);
    }

    public ObjectEncoderOutputStream(OutputStream outputStream, int i4) {
        if (outputStream == null) {
            throw new NullPointerException("out");
        }
        if (i4 >= 0) {
            if (outputStream instanceof DataOutputStream) {
                this.out = (DataOutputStream) outputStream;
            } else {
                this.out = new DataOutputStream(outputStream);
            }
            this.estimatedLength = i4;
            return;
        }
        throw new IllegalArgumentException("estimatedLength: " + i4);
    }

    @Override // java.io.OutputStream, java.io.ObjectOutput, java.io.DataOutput
    public void write(byte[] bArr, int i4, int i5) throws IOException {
        this.out.write(bArr, i4, i5);
    }

    @Override // java.io.OutputStream, java.io.ObjectOutput, java.io.DataOutput
    public void write(byte[] bArr) throws IOException {
        this.out.write(bArr);
    }
}
