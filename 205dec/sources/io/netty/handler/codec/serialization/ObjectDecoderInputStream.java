package io.netty.handler.codec.serialization;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.StreamCorruptedException;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class ObjectDecoderInputStream extends InputStream implements ObjectInput {
    private final ClassResolver classResolver;
    private final DataInputStream in;
    private final int maxObjectSize;

    public ObjectDecoderInputStream(InputStream inputStream) {
        this(inputStream, (ClassLoader) null);
    }

    @Override // java.io.InputStream, java.io.ObjectInput
    public int available() throws IOException {
        return this.in.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable, java.io.ObjectInput
    public void close() throws IOException {
        this.in.close();
    }

    @Override // java.io.InputStream
    public void mark(int i4) {
        this.in.mark(i4);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.in.markSupported();
    }

    @Override // java.io.InputStream, java.io.ObjectInput
    public int read() throws IOException {
        return this.in.read();
    }

    @Override // java.io.DataInput
    public final boolean readBoolean() throws IOException {
        return this.in.readBoolean();
    }

    @Override // java.io.DataInput
    public final byte readByte() throws IOException {
        return this.in.readByte();
    }

    @Override // java.io.DataInput
    public final char readChar() throws IOException {
        return this.in.readChar();
    }

    @Override // java.io.DataInput
    public final double readDouble() throws IOException {
        return this.in.readDouble();
    }

    @Override // java.io.DataInput
    public final float readFloat() throws IOException {
        return this.in.readFloat();
    }

    @Override // java.io.DataInput
    public final void readFully(byte[] bArr, int i4, int i5) throws IOException {
        this.in.readFully(bArr, i4, i5);
    }

    @Override // java.io.DataInput
    public final int readInt() throws IOException {
        return this.in.readInt();
    }

    @Override // java.io.DataInput
    @Deprecated
    public final String readLine() throws IOException {
        return this.in.readLine();
    }

    @Override // java.io.DataInput
    public final long readLong() throws IOException {
        return this.in.readLong();
    }

    @Override // java.io.ObjectInput
    public Object readObject() throws ClassNotFoundException, IOException {
        int readInt = readInt();
        if (readInt > 0) {
            if (readInt <= this.maxObjectSize) {
                return new CompactObjectInputStream(this.in, this.classResolver).readObject();
            }
            throw new StreamCorruptedException("data length too big: " + readInt + " (max: " + this.maxObjectSize + ')');
        }
        throw new StreamCorruptedException("invalid data length: " + readInt);
    }

    @Override // java.io.DataInput
    public final short readShort() throws IOException {
        return this.in.readShort();
    }

    @Override // java.io.DataInput
    public final String readUTF() throws IOException {
        return this.in.readUTF();
    }

    @Override // java.io.DataInput
    public final int readUnsignedByte() throws IOException {
        return this.in.readUnsignedByte();
    }

    @Override // java.io.DataInput
    public final int readUnsignedShort() throws IOException {
        return this.in.readUnsignedShort();
    }

    @Override // java.io.InputStream
    public void reset() throws IOException {
        this.in.reset();
    }

    @Override // java.io.InputStream, java.io.ObjectInput
    public long skip(long j4) throws IOException {
        return this.in.skip(j4);
    }

    @Override // java.io.DataInput
    public final int skipBytes(int i4) throws IOException {
        return this.in.skipBytes(i4);
    }

    public ObjectDecoderInputStream(InputStream inputStream, ClassLoader classLoader) {
        this(inputStream, classLoader, 1048576);
    }

    @Override // java.io.InputStream, java.io.ObjectInput
    public final int read(byte[] bArr, int i4, int i5) throws IOException {
        return this.in.read(bArr, i4, i5);
    }

    @Override // java.io.DataInput
    public final void readFully(byte[] bArr) throws IOException {
        this.in.readFully(bArr);
    }

    public ObjectDecoderInputStream(InputStream inputStream, int i4) {
        this(inputStream, null, i4);
    }

    @Override // java.io.InputStream, java.io.ObjectInput
    public final int read(byte[] bArr) throws IOException {
        return this.in.read(bArr);
    }

    public ObjectDecoderInputStream(InputStream inputStream, ClassLoader classLoader, int i4) {
        if (inputStream == null) {
            throw new NullPointerException("in");
        }
        if (i4 > 0) {
            if (inputStream instanceof DataInputStream) {
                this.in = (DataInputStream) inputStream;
            } else {
                this.in = new DataInputStream(inputStream);
            }
            this.classResolver = ClassResolvers.weakCachingResolver(classLoader);
            this.maxObjectSize = i4;
            return;
        }
        throw new IllegalArgumentException("maxObjectSize: " + i4);
    }
}
