package io.netty.handler.codec.serialization;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.StreamCorruptedException;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class ObjectDecoderInputStream extends InputStream implements ObjectInput {
    private final ClassResolver classResolver;

    /* renamed from: in */
    private final DataInputStream f40242in;
    private final int maxObjectSize;

    public ObjectDecoderInputStream(InputStream inputStream) {
        this(inputStream, (ClassLoader) null);
    }

    @Override // java.io.InputStream, java.io.ObjectInput
    public int available() throws IOException {
        return this.f40242in.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable, java.io.ObjectInput
    public void close() throws IOException {
        this.f40242in.close();
    }

    @Override // java.io.InputStream
    public void mark(int i) {
        this.f40242in.mark(i);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.f40242in.markSupported();
    }

    @Override // java.io.InputStream, java.io.ObjectInput
    public int read() throws IOException {
        return this.f40242in.read();
    }

    @Override // java.io.DataInput
    public final boolean readBoolean() throws IOException {
        return this.f40242in.readBoolean();
    }

    @Override // java.io.DataInput
    public final byte readByte() throws IOException {
        return this.f40242in.readByte();
    }

    @Override // java.io.DataInput
    public final char readChar() throws IOException {
        return this.f40242in.readChar();
    }

    @Override // java.io.DataInput
    public final double readDouble() throws IOException {
        return this.f40242in.readDouble();
    }

    @Override // java.io.DataInput
    public final float readFloat() throws IOException {
        return this.f40242in.readFloat();
    }

    @Override // java.io.DataInput
    public final void readFully(byte[] bArr, int i, int i2) throws IOException {
        this.f40242in.readFully(bArr, i, i2);
    }

    @Override // java.io.DataInput
    public final int readInt() throws IOException {
        return this.f40242in.readInt();
    }

    @Override // java.io.DataInput
    @Deprecated
    public final String readLine() throws IOException {
        return this.f40242in.readLine();
    }

    @Override // java.io.DataInput
    public final long readLong() throws IOException {
        return this.f40242in.readLong();
    }

    @Override // java.io.ObjectInput
    public Object readObject() throws ClassNotFoundException, IOException {
        int readInt = readInt();
        if (readInt > 0) {
            if (readInt <= this.maxObjectSize) {
                return new CompactObjectInputStream(this.f40242in, this.classResolver).readObject();
            }
            throw new StreamCorruptedException("data length too big: " + readInt + " (max: " + this.maxObjectSize + ')');
        }
        throw new StreamCorruptedException("invalid data length: " + readInt);
    }

    @Override // java.io.DataInput
    public final short readShort() throws IOException {
        return this.f40242in.readShort();
    }

    @Override // java.io.DataInput
    public final String readUTF() throws IOException {
        return this.f40242in.readUTF();
    }

    @Override // java.io.DataInput
    public final int readUnsignedByte() throws IOException {
        return this.f40242in.readUnsignedByte();
    }

    @Override // java.io.DataInput
    public final int readUnsignedShort() throws IOException {
        return this.f40242in.readUnsignedShort();
    }

    @Override // java.io.InputStream
    public void reset() throws IOException {
        this.f40242in.reset();
    }

    @Override // java.io.InputStream, java.io.ObjectInput
    public long skip(long j) throws IOException {
        return this.f40242in.skip(j);
    }

    @Override // java.io.DataInput
    public final int skipBytes(int i) throws IOException {
        return this.f40242in.skipBytes(i);
    }

    public ObjectDecoderInputStream(InputStream inputStream, ClassLoader classLoader) {
        this(inputStream, classLoader, 1048576);
    }

    @Override // java.io.InputStream, java.io.ObjectInput
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        return this.f40242in.read(bArr, i, i2);
    }

    @Override // java.io.DataInput
    public final void readFully(byte[] bArr) throws IOException {
        this.f40242in.readFully(bArr);
    }

    public ObjectDecoderInputStream(InputStream inputStream, int i) {
        this(inputStream, null, i);
    }

    @Override // java.io.InputStream, java.io.ObjectInput
    public final int read(byte[] bArr) throws IOException {
        return this.f40242in.read(bArr);
    }

    public ObjectDecoderInputStream(InputStream inputStream, ClassLoader classLoader, int i) {
        if (inputStream == null) {
            throw new NullPointerException("in");
        }
        if (i > 0) {
            if (inputStream instanceof DataInputStream) {
                this.f40242in = (DataInputStream) inputStream;
            } else {
                this.f40242in = new DataInputStream(inputStream);
            }
            this.classResolver = ClassResolvers.weakCachingResolver(classLoader);
            this.maxObjectSize = i;
            return;
        }
        throw new IllegalArgumentException("maxObjectSize: " + i);
    }
}
