package io.netty.buffer;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class ByteBufInputStream extends InputStream implements DataInput {
    private final ByteBuf buffer;
    private final int endIndex;
    private final StringBuilder lineBuf;
    private final int startIndex;

    public ByteBufInputStream(ByteBuf byteBuf) {
        this(byteBuf, byteBuf.readableBytes());
    }

    private void checkAvailable(int i4) throws IOException {
        if (i4 >= 0) {
            if (i4 <= available()) {
                return;
            }
            throw new EOFException("fieldSize is too long! Length is " + i4 + ", but maximum is " + available());
        }
        throw new IndexOutOfBoundsException("fieldSize cannot be a negative number");
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        return this.endIndex - this.buffer.readerIndex();
    }

    @Override // java.io.InputStream
    public void mark(int i4) {
        this.buffer.markReaderIndex();
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return true;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (this.buffer.isReadable()) {
            return this.buffer.readByte() & 255;
        }
        return -1;
    }

    @Override // java.io.DataInput
    public boolean readBoolean() throws IOException {
        checkAvailable(1);
        return read() != 0;
    }

    @Override // java.io.DataInput
    public byte readByte() throws IOException {
        if (this.buffer.isReadable()) {
            return this.buffer.readByte();
        }
        throw new EOFException();
    }

    public int readBytes() {
        return this.buffer.readerIndex() - this.startIndex;
    }

    @Override // java.io.DataInput
    public char readChar() throws IOException {
        return (char) readShort();
    }

    @Override // java.io.DataInput
    public double readDouble() throws IOException {
        return Double.longBitsToDouble(readLong());
    }

    @Override // java.io.DataInput
    public float readFloat() throws IOException {
        return Float.intBitsToFloat(readInt());
    }

    @Override // java.io.DataInput
    public void readFully(byte[] bArr) throws IOException {
        readFully(bArr, 0, bArr.length);
    }

    @Override // java.io.DataInput
    public int readInt() throws IOException {
        checkAvailable(4);
        return this.buffer.readInt();
    }

    @Override // java.io.DataInput
    public String readLine() throws IOException {
        this.lineBuf.setLength(0);
        while (this.buffer.isReadable()) {
            short readUnsignedByte = this.buffer.readUnsignedByte();
            if (readUnsignedByte != 10) {
                if (readUnsignedByte != 13) {
                    this.lineBuf.append((char) readUnsignedByte);
                } else if (this.buffer.isReadable()) {
                    ByteBuf byteBuf = this.buffer;
                    if (((char) byteBuf.getUnsignedByte(byteBuf.readerIndex())) == '\n') {
                        this.buffer.skipBytes(1);
                    }
                }
            }
            return this.lineBuf.toString();
        }
        if (this.lineBuf.length() > 0) {
            return this.lineBuf.toString();
        }
        return null;
    }

    @Override // java.io.DataInput
    public long readLong() throws IOException {
        checkAvailable(8);
        return this.buffer.readLong();
    }

    @Override // java.io.DataInput
    public short readShort() throws IOException {
        checkAvailable(2);
        return this.buffer.readShort();
    }

    @Override // java.io.DataInput
    public String readUTF() throws IOException {
        return DataInputStream.readUTF(this);
    }

    @Override // java.io.DataInput
    public int readUnsignedByte() throws IOException {
        return readByte() & 255;
    }

    @Override // java.io.DataInput
    public int readUnsignedShort() throws IOException {
        return readShort() & 65535;
    }

    @Override // java.io.InputStream
    public void reset() throws IOException {
        this.buffer.resetReaderIndex();
    }

    @Override // java.io.InputStream
    public long skip(long j4) throws IOException {
        int skipBytes;
        if (j4 > 2147483647L) {
            skipBytes = skipBytes(Integer.MAX_VALUE);
        } else {
            skipBytes = skipBytes((int) j4);
        }
        return skipBytes;
    }

    @Override // java.io.DataInput
    public int skipBytes(int i4) throws IOException {
        int min = Math.min(available(), i4);
        this.buffer.skipBytes(min);
        return min;
    }

    public ByteBufInputStream(ByteBuf byteBuf, int i4) {
        this.lineBuf = new StringBuilder();
        if (byteBuf == null) {
            throw new NullPointerException("buffer");
        }
        if (i4 >= 0) {
            if (i4 <= byteBuf.readableBytes()) {
                this.buffer = byteBuf;
                int readerIndex = byteBuf.readerIndex();
                this.startIndex = readerIndex;
                this.endIndex = readerIndex + i4;
                byteBuf.markReaderIndex();
                return;
            }
            throw new IndexOutOfBoundsException("Too many bytes to be read - Needs " + i4 + ", maximum is " + byteBuf.readableBytes());
        }
        throw new IllegalArgumentException("length: " + i4);
    }

    @Override // java.io.DataInput
    public void readFully(byte[] bArr, int i4, int i5) throws IOException {
        checkAvailable(i5);
        this.buffer.readBytes(bArr, i4, i5);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i4, int i5) throws IOException {
        int available = available();
        if (available == 0) {
            return -1;
        }
        int min = Math.min(available, i5);
        this.buffer.readBytes(bArr, i4, min);
        return min;
    }
}
