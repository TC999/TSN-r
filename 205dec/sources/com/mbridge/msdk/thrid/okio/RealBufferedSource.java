package com.mbridge.msdk.thrid.okio;

import androidx.annotation.Nullable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class RealBufferedSource implements BufferedSource {
    public final Buffer buffer = new Buffer();
    boolean closed;
    public final Source source;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RealBufferedSource(Source source) {
        if (source != null) {
            this.source = source;
            return;
        }
        throw new NullPointerException("source == null");
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource, com.mbridge.msdk.thrid.okio.BufferedSink
    public Buffer buffer() {
        return this.buffer;
    }

    @Override // com.mbridge.msdk.thrid.okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.closed) {
            return;
        }
        this.closed = true;
        this.source.close();
        this.buffer.clear();
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public boolean exhausted() throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        return this.buffer.exhausted() && this.source.read(this.buffer, 8192L) == -1;
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public long indexOf(byte b4) throws IOException {
        return indexOf(b4, 0L, Long.MAX_VALUE);
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public long indexOfElement(ByteString byteString) throws IOException {
        return indexOfElement(byteString, 0L);
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public InputStream inputStream() {
        return new InputStream() { // from class: com.mbridge.msdk.thrid.okio.RealBufferedSource.1
            @Override // java.io.InputStream
            public int available() throws IOException {
                RealBufferedSource realBufferedSource = RealBufferedSource.this;
                if (!realBufferedSource.closed) {
                    return (int) Math.min(realBufferedSource.buffer.size, 2147483647L);
                }
                throw new IOException("closed");
            }

            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                RealBufferedSource.this.close();
            }

            @Override // java.io.InputStream
            public int read() throws IOException {
                RealBufferedSource realBufferedSource = RealBufferedSource.this;
                if (!realBufferedSource.closed) {
                    Buffer buffer = realBufferedSource.buffer;
                    if (buffer.size == 0 && realBufferedSource.source.read(buffer, 8192L) == -1) {
                        return -1;
                    }
                    return RealBufferedSource.this.buffer.readByte() & 255;
                }
                throw new IOException("closed");
            }

            public String toString() {
                return RealBufferedSource.this + ".inputStream()";
            }

            @Override // java.io.InputStream
            public int read(byte[] bArr, int i4, int i5) throws IOException {
                if (!RealBufferedSource.this.closed) {
                    Util.checkOffsetAndCount(bArr.length, i4, i5);
                    RealBufferedSource realBufferedSource = RealBufferedSource.this;
                    Buffer buffer = realBufferedSource.buffer;
                    if (buffer.size == 0 && realBufferedSource.source.read(buffer, 8192L) == -1) {
                        return -1;
                    }
                    return RealBufferedSource.this.buffer.read(bArr, i4, i5);
                }
                throw new IOException("closed");
            }
        };
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.closed;
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public boolean rangeEquals(long j4, ByteString byteString) throws IOException {
        return rangeEquals(j4, byteString, 0, byteString.size());
    }

    @Override // com.mbridge.msdk.thrid.okio.Source
    public long read(Buffer buffer, long j4) throws IOException {
        if (buffer != null) {
            if (j4 >= 0) {
                if (!this.closed) {
                    Buffer buffer2 = this.buffer;
                    if (buffer2.size == 0 && this.source.read(buffer2, 8192L) == -1) {
                        return -1L;
                    }
                    return this.buffer.read(buffer, Math.min(j4, this.buffer.size));
                }
                throw new IllegalStateException("closed");
            }
            throw new IllegalArgumentException("byteCount < 0: " + j4);
        }
        throw new IllegalArgumentException("sink == null");
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public long readAll(Sink sink) throws IOException {
        if (sink != null) {
            long j4 = 0;
            while (this.source.read(this.buffer, 8192L) != -1) {
                long completeSegmentByteCount = this.buffer.completeSegmentByteCount();
                if (completeSegmentByteCount > 0) {
                    j4 += completeSegmentByteCount;
                    sink.write(this.buffer, completeSegmentByteCount);
                }
            }
            if (this.buffer.size() > 0) {
                long size = j4 + this.buffer.size();
                Buffer buffer = this.buffer;
                sink.write(buffer, buffer.size());
                return size;
            }
            return j4;
        }
        throw new IllegalArgumentException("sink == null");
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public byte readByte() throws IOException {
        require(1L);
        return this.buffer.readByte();
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public byte[] readByteArray() throws IOException {
        this.buffer.writeAll(this.source);
        return this.buffer.readByteArray();
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public ByteString readByteString() throws IOException {
        this.buffer.writeAll(this.source);
        return this.buffer.readByteString();
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public long readDecimalLong() throws IOException {
        byte b4;
        require(1L);
        int i4 = 0;
        while (true) {
            int i5 = i4 + 1;
            if (!request(i5)) {
                break;
            }
            b4 = this.buffer.getByte(i4);
            if ((b4 < 48 || b4 > 57) && !(i4 == 0 && b4 == 45)) {
                break;
            }
            i4 = i5;
        }
        if (i4 == 0) {
            throw new NumberFormatException(String.format("Expected leading [0-9] or '-' character but was %#x", Byte.valueOf(b4)));
        }
        return this.buffer.readDecimalLong();
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public void readFully(byte[] bArr) throws IOException {
        try {
            require(bArr.length);
            this.buffer.readFully(bArr);
        } catch (EOFException e4) {
            int i4 = 0;
            while (true) {
                Buffer buffer = this.buffer;
                long j4 = buffer.size;
                if (j4 <= 0) {
                    throw e4;
                }
                int read = buffer.read(bArr, i4, (int) j4);
                if (read == -1) {
                    throw new AssertionError();
                }
                i4 += read;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0032, code lost:
        if (r1 == 0) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0049, code lost:
        throw new java.lang.NumberFormatException(java.lang.String.format("Expected leading [0-9a-fA-F] character but was %#x", java.lang.Byte.valueOf(r3)));
     */
    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long readHexadecimalUnsignedLong() throws java.io.IOException {
        /*
            r6 = this;
            r0 = 1
            r6.require(r0)
            r0 = 0
            r1 = 0
        L7:
            int r2 = r1 + 1
            long r3 = (long) r2
            boolean r3 = r6.request(r3)
            if (r3 == 0) goto L4a
            com.mbridge.msdk.thrid.okio.Buffer r3 = r6.buffer
            long r4 = (long) r1
            byte r3 = r3.getByte(r4)
            r4 = 48
            if (r3 < r4) goto L1f
            r4 = 57
            if (r3 <= r4) goto L30
        L1f:
            r4 = 97
            if (r3 < r4) goto L27
            r4 = 102(0x66, float:1.43E-43)
            if (r3 <= r4) goto L30
        L27:
            r4 = 65
            if (r3 < r4) goto L32
            r4 = 70
            if (r3 <= r4) goto L30
            goto L32
        L30:
            r1 = r2
            goto L7
        L32:
            if (r1 == 0) goto L35
            goto L4a
        L35:
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            r2 = 1
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.Byte r3 = java.lang.Byte.valueOf(r3)
            r2[r0] = r3
            java.lang.String r0 = "Expected leading [0-9a-fA-F] character but was %#x"
            java.lang.String r0 = java.lang.String.format(r0, r2)
            r1.<init>(r0)
            throw r1
        L4a:
            com.mbridge.msdk.thrid.okio.Buffer r0 = r6.buffer
            long r0 = r0.readHexadecimalUnsignedLong()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.thrid.okio.RealBufferedSource.readHexadecimalUnsignedLong():long");
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public int readInt() throws IOException {
        require(4L);
        return this.buffer.readInt();
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public int readIntLe() throws IOException {
        require(4L);
        return this.buffer.readIntLe();
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public long readLong() throws IOException {
        require(8L);
        return this.buffer.readLong();
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public long readLongLe() throws IOException {
        require(8L);
        return this.buffer.readLongLe();
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public short readShort() throws IOException {
        require(2L);
        return this.buffer.readShort();
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public short readShortLe() throws IOException {
        require(2L);
        return this.buffer.readShortLe();
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public String readString(Charset charset) throws IOException {
        if (charset != null) {
            this.buffer.writeAll(this.source);
            return this.buffer.readString(charset);
        }
        throw new IllegalArgumentException("charset == null");
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public String readUtf8() throws IOException {
        this.buffer.writeAll(this.source);
        return this.buffer.readUtf8();
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public int readUtf8CodePoint() throws IOException {
        require(1L);
        byte b4 = this.buffer.getByte(0L);
        if ((b4 & 224) == 192) {
            require(2L);
        } else if ((b4 & 240) == 224) {
            require(3L);
        } else if ((b4 & 248) == 240) {
            require(4L);
        }
        return this.buffer.readUtf8CodePoint();
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    @Nullable
    public String readUtf8Line() throws IOException {
        long indexOf = indexOf((byte) 10);
        if (indexOf == -1) {
            long j4 = this.buffer.size;
            if (j4 != 0) {
                return readUtf8(j4);
            }
            return null;
        }
        return this.buffer.readUtf8Line(indexOf);
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public String readUtf8LineStrict() throws IOException {
        return readUtf8LineStrict(Long.MAX_VALUE);
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public boolean request(long j4) throws IOException {
        Buffer buffer;
        if (j4 >= 0) {
            if (!this.closed) {
                do {
                    buffer = this.buffer;
                    if (buffer.size >= j4) {
                        return true;
                    }
                } while (this.source.read(buffer, 8192L) != -1);
                return false;
            }
            throw new IllegalStateException("closed");
        }
        throw new IllegalArgumentException("byteCount < 0: " + j4);
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public void require(long j4) throws IOException {
        if (!request(j4)) {
            throw new EOFException();
        }
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public int select(Options options) throws IOException {
        if (!this.closed) {
            do {
                int selectPrefix = this.buffer.selectPrefix(options, true);
                if (selectPrefix == -1) {
                    return -1;
                }
                if (selectPrefix != -2) {
                    this.buffer.skip(options.byteStrings[selectPrefix].size());
                    return selectPrefix;
                }
            } while (this.source.read(this.buffer, 8192L) != -1);
            return -1;
        }
        throw new IllegalStateException("closed");
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public void skip(long j4) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        while (j4 > 0) {
            Buffer buffer = this.buffer;
            if (buffer.size == 0 && this.source.read(buffer, 8192L) == -1) {
                throw new EOFException();
            }
            long min = Math.min(j4, this.buffer.size());
            this.buffer.skip(min);
            j4 -= min;
        }
    }

    @Override // com.mbridge.msdk.thrid.okio.Source
    public Timeout timeout() {
        return this.source.timeout();
    }

    public String toString() {
        return "buffer(" + this.source + ")";
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public long indexOf(byte b4, long j4) throws IOException {
        return indexOf(b4, j4, Long.MAX_VALUE);
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public long indexOfElement(ByteString byteString, long j4) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        while (true) {
            long indexOfElement = this.buffer.indexOfElement(byteString, j4);
            if (indexOfElement != -1) {
                return indexOfElement;
            }
            Buffer buffer = this.buffer;
            long j5 = buffer.size;
            if (this.source.read(buffer, 8192L) == -1) {
                return -1L;
            }
            j4 = Math.max(j4, j5);
        }
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public boolean rangeEquals(long j4, ByteString byteString, int i4, int i5) throws IOException {
        if (!this.closed) {
            if (j4 < 0 || i4 < 0 || i5 < 0 || byteString.size() - i4 < i5) {
                return false;
            }
            for (int i6 = 0; i6 < i5; i6++) {
                long j5 = i6 + j4;
                if (!request(1 + j5) || this.buffer.getByte(j5) != byteString.getByte(i4 + i6)) {
                    return false;
                }
            }
            return true;
        }
        throw new IllegalStateException("closed");
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public String readUtf8LineStrict(long j4) throws IOException {
        if (j4 >= 0) {
            long j5 = j4 == Long.MAX_VALUE ? Long.MAX_VALUE : j4 + 1;
            long indexOf = indexOf((byte) 10, 0L, j5);
            if (indexOf != -1) {
                return this.buffer.readUtf8Line(indexOf);
            }
            if (j5 < Long.MAX_VALUE && request(j5) && this.buffer.getByte(j5 - 1) == 13 && request(1 + j5) && this.buffer.getByte(j5) == 10) {
                return this.buffer.readUtf8Line(j5);
            }
            Buffer buffer = new Buffer();
            Buffer buffer2 = this.buffer;
            buffer2.copyTo(buffer, 0L, Math.min(32L, buffer2.size()));
            throw new EOFException("\\n not found: limit=" + Math.min(this.buffer.size(), j4) + " content=" + buffer.readByteString().hex() + '\u2026');
        }
        throw new IllegalArgumentException("limit < 0: " + j4);
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public long indexOf(byte b4, long j4, long j5) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        if (j4 < 0 || j5 < j4) {
            throw new IllegalArgumentException(String.format("fromIndex=%s toIndex=%s", Long.valueOf(j4), Long.valueOf(j5)));
        }
        while (j4 < j5) {
            long indexOf = this.buffer.indexOf(b4, j4, j5);
            if (indexOf == -1) {
                Buffer buffer = this.buffer;
                long j6 = buffer.size;
                if (j6 >= j5 || this.source.read(buffer, 8192L) == -1) {
                    break;
                }
                j4 = Math.max(j4, j6);
            } else {
                return indexOf;
            }
        }
        return -1L;
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public byte[] readByteArray(long j4) throws IOException {
        require(j4);
        return this.buffer.readByteArray(j4);
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public ByteString readByteString(long j4) throws IOException {
        require(j4);
        return this.buffer.readByteString(j4);
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public String readUtf8(long j4) throws IOException {
        require(j4);
        return this.buffer.readUtf8(j4);
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public String readString(long j4, Charset charset) throws IOException {
        require(j4);
        if (charset != null) {
            return this.buffer.readString(j4, charset);
        }
        throw new IllegalArgumentException("charset == null");
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public void readFully(Buffer buffer, long j4) throws IOException {
        try {
            require(j4);
            this.buffer.readFully(buffer, j4);
        } catch (EOFException e4) {
            buffer.writeAll(this.buffer);
            throw e4;
        }
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public int read(byte[] bArr, int i4, int i5) throws IOException {
        long j4 = i5;
        Util.checkOffsetAndCount(bArr.length, i4, j4);
        Buffer buffer = this.buffer;
        if (buffer.size == 0 && this.source.read(buffer, 8192L) == -1) {
            return -1;
        }
        return this.buffer.read(bArr, i4, (int) Math.min(j4, this.buffer.size));
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public long indexOf(ByteString byteString) throws IOException {
        return indexOf(byteString, 0L);
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public long indexOf(ByteString byteString, long j4) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        while (true) {
            long indexOf = this.buffer.indexOf(byteString, j4);
            if (indexOf != -1) {
                return indexOf;
            }
            Buffer buffer = this.buffer;
            long j5 = buffer.size;
            if (this.source.read(buffer, 8192L) == -1) {
                return -1L;
            }
            j4 = Math.max(j4, (j5 - byteString.size()) + 1);
        }
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) throws IOException {
        Buffer buffer = this.buffer;
        if (buffer.size == 0 && this.source.read(buffer, 8192L) == -1) {
            return -1;
        }
        return this.buffer.read(byteBuffer);
    }
}