package com.mbridge.msdk.thrid.okio;

import androidx.annotation.Nullable;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bykv.vk.component.ttvideo.player.C;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class Buffer implements BufferedSource, BufferedSink, Cloneable, ByteChannel {
    private static final byte[] DIGITS = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};
    static final int REPLACEMENT_CHARACTER = 65533;
    @Nullable
    Segment head;
    long size;

    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static final class UnsafeCursor implements Closeable {
        public Buffer buffer;
        public byte[] data;
        public boolean readWrite;
        private Segment segment;
        public long offset = -1;
        public int start = -1;
        public int end = -1;

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.buffer != null) {
                this.buffer = null;
                this.segment = null;
                this.offset = -1L;
                this.data = null;
                this.start = -1;
                this.end = -1;
                return;
            }
            throw new IllegalStateException("not attached to a buffer");
        }

        public final long expandBuffer(int i4) {
            if (i4 <= 0) {
                throw new IllegalArgumentException("minByteCount <= 0: " + i4);
            } else if (i4 <= 8192) {
                Buffer buffer = this.buffer;
                if (buffer != null) {
                    if (this.readWrite) {
                        long j4 = buffer.size;
                        Segment writableSegment = buffer.writableSegment(i4);
                        int i5 = 8192 - writableSegment.limit;
                        writableSegment.limit = 8192;
                        long j5 = i5;
                        this.buffer.size = j4 + j5;
                        this.segment = writableSegment;
                        this.offset = j4;
                        this.data = writableSegment.data;
                        this.start = 8192 - i5;
                        this.end = 8192;
                        return j5;
                    }
                    throw new IllegalStateException("expandBuffer() only permitted for read/write buffers");
                }
                throw new IllegalStateException("not attached to a buffer");
            } else {
                throw new IllegalArgumentException("minByteCount > Segment.SIZE: " + i4);
            }
        }

        public final int next() {
            long j4 = this.offset;
            if (j4 != this.buffer.size) {
                if (j4 == -1) {
                    return seek(0L);
                }
                return seek(j4 + (this.end - this.start));
            }
            throw new IllegalStateException();
        }

        public final long resizeBuffer(long j4) {
            Buffer buffer = this.buffer;
            if (buffer != null) {
                if (this.readWrite) {
                    long j5 = buffer.size;
                    if (j4 <= j5) {
                        if (j4 >= 0) {
                            long j6 = j5 - j4;
                            while (true) {
                                if (j6 <= 0) {
                                    break;
                                }
                                Buffer buffer2 = this.buffer;
                                Segment segment = buffer2.head.prev;
                                int i4 = segment.limit;
                                long j7 = i4 - segment.pos;
                                if (j7 <= j6) {
                                    buffer2.head = segment.pop();
                                    SegmentPool.recycle(segment);
                                    j6 -= j7;
                                } else {
                                    segment.limit = (int) (i4 - j6);
                                    break;
                                }
                            }
                            this.segment = null;
                            this.offset = j4;
                            this.data = null;
                            this.start = -1;
                            this.end = -1;
                        } else {
                            throw new IllegalArgumentException("newSize < 0: " + j4);
                        }
                    } else if (j4 > j5) {
                        long j8 = j4 - j5;
                        boolean z3 = true;
                        while (j8 > 0) {
                            Segment writableSegment = this.buffer.writableSegment(1);
                            int min = (int) Math.min(j8, 8192 - writableSegment.limit);
                            int i5 = writableSegment.limit + min;
                            writableSegment.limit = i5;
                            j8 -= min;
                            if (z3) {
                                this.segment = writableSegment;
                                this.offset = j5;
                                this.data = writableSegment.data;
                                this.start = i5 - min;
                                this.end = i5;
                                z3 = false;
                            }
                        }
                    }
                    this.buffer.size = j4;
                    return j5;
                }
                throw new IllegalStateException("resizeBuffer() only permitted for read/write buffers");
            }
            throw new IllegalStateException("not attached to a buffer");
        }

        public final int seek(long j4) {
            if (j4 >= -1) {
                Buffer buffer = this.buffer;
                long j5 = buffer.size;
                if (j4 <= j5) {
                    if (j4 != -1 && j4 != j5) {
                        long j6 = 0;
                        Segment segment = buffer.head;
                        Segment segment2 = this.segment;
                        if (segment2 != null) {
                            long j7 = this.offset - (this.start - segment2.pos);
                            if (j7 > j4) {
                                j5 = j7;
                                segment2 = segment;
                                segment = segment2;
                            } else {
                                j6 = j7;
                            }
                        } else {
                            segment2 = segment;
                        }
                        if (j5 - j4 > j4 - j6) {
                            while (true) {
                                int i4 = segment2.limit;
                                int i5 = segment2.pos;
                                if (j4 < (i4 - i5) + j6) {
                                    break;
                                }
                                j6 += i4 - i5;
                                segment2 = segment2.next;
                            }
                        } else {
                            while (j5 > j4) {
                                segment = segment.prev;
                                j5 -= segment.limit - segment.pos;
                            }
                            segment2 = segment;
                            j6 = j5;
                        }
                        if (this.readWrite && segment2.shared) {
                            Segment unsharedCopy = segment2.unsharedCopy();
                            Buffer buffer2 = this.buffer;
                            if (buffer2.head == segment2) {
                                buffer2.head = unsharedCopy;
                            }
                            segment2 = segment2.push(unsharedCopy);
                            segment2.prev.pop();
                        }
                        this.segment = segment2;
                        this.offset = j4;
                        this.data = segment2.data;
                        int i6 = segment2.pos + ((int) (j4 - j6));
                        this.start = i6;
                        int i7 = segment2.limit;
                        this.end = i7;
                        return i7 - i6;
                    }
                    this.segment = null;
                    this.offset = j4;
                    this.data = null;
                    this.start = -1;
                    this.end = -1;
                    return -1;
                }
            }
            throw new ArrayIndexOutOfBoundsException(String.format("offset=%s > size=%s", Long.valueOf(j4), Long.valueOf(this.buffer.size)));
        }
    }

    private ByteString digest(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(str);
            Segment segment = this.head;
            if (segment != null) {
                byte[] bArr = segment.data;
                int i4 = segment.pos;
                messageDigest.update(bArr, i4, segment.limit - i4);
                Segment segment2 = this.head;
                while (true) {
                    segment2 = segment2.next;
                    if (segment2 == this.head) {
                        break;
                    }
                    byte[] bArr2 = segment2.data;
                    int i5 = segment2.pos;
                    messageDigest.update(bArr2, i5, segment2.limit - i5);
                }
            }
            return ByteString.of(messageDigest.digest());
        } catch (NoSuchAlgorithmException unused) {
            throw new AssertionError();
        }
    }

    private ByteString hmac(String str, ByteString byteString) {
        try {
            Mac mac = Mac.getInstance(str);
            mac.init(new SecretKeySpec(byteString.toByteArray(), str));
            Segment segment = this.head;
            if (segment != null) {
                byte[] bArr = segment.data;
                int i4 = segment.pos;
                mac.update(bArr, i4, segment.limit - i4);
                Segment segment2 = this.head;
                while (true) {
                    segment2 = segment2.next;
                    if (segment2 == this.head) {
                        break;
                    }
                    byte[] bArr2 = segment2.data;
                    int i5 = segment2.pos;
                    mac.update(bArr2, i5, segment2.limit - i5);
                }
            }
            return ByteString.of(mac.doFinal());
        } catch (InvalidKeyException e4) {
            throw new IllegalArgumentException(e4);
        } catch (NoSuchAlgorithmException unused) {
            throw new AssertionError();
        }
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource, com.mbridge.msdk.thrid.okio.BufferedSink
    public Buffer buffer() {
        return this;
    }

    public final void clear() {
        try {
            skip(this.size);
        } catch (EOFException e4) {
            throw new AssertionError(e4);
        }
    }

    @Override // com.mbridge.msdk.thrid.okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    public final long completeSegmentByteCount() {
        long j4 = this.size;
        if (j4 == 0) {
            return 0L;
        }
        Segment segment = this.head.prev;
        int i4 = segment.limit;
        return (i4 >= 8192 || !segment.owner) ? j4 : j4 - (i4 - segment.pos);
    }

    public final Buffer copyTo(OutputStream outputStream) throws IOException {
        return copyTo(outputStream, 0L, this.size);
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSink
    public BufferedSink emit() {
        return this;
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSink
    public Buffer emitCompleteSegments() {
        return this;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Buffer) {
            Buffer buffer = (Buffer) obj;
            long j4 = this.size;
            if (j4 != buffer.size) {
                return false;
            }
            long j5 = 0;
            if (j4 == 0) {
                return true;
            }
            Segment segment = this.head;
            Segment segment2 = buffer.head;
            int i4 = segment.pos;
            int i5 = segment2.pos;
            while (j5 < this.size) {
                long min = Math.min(segment.limit - i4, segment2.limit - i5);
                int i6 = 0;
                while (i6 < min) {
                    int i7 = i4 + 1;
                    int i8 = i5 + 1;
                    if (segment.data[i4] != segment2.data[i5]) {
                        return false;
                    }
                    i6++;
                    i4 = i7;
                    i5 = i8;
                }
                if (i4 == segment.limit) {
                    segment = segment.next;
                    i4 = segment.pos;
                }
                if (i5 == segment2.limit) {
                    segment2 = segment2.next;
                    i5 = segment2.pos;
                }
                j5 += min;
            }
            return true;
        }
        return false;
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public boolean exhausted() {
        return this.size == 0;
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSink, com.mbridge.msdk.thrid.okio.Sink, java.io.Flushable
    public void flush() {
    }

    public final byte getByte(long j4) {
        int i4;
        Util.checkOffsetAndCount(this.size, j4, 1L);
        long j5 = this.size;
        if (j5 - j4 > j4) {
            Segment segment = this.head;
            while (true) {
                int i5 = segment.limit;
                int i6 = segment.pos;
                long j6 = i5 - i6;
                if (j4 < j6) {
                    return segment.data[i6 + ((int) j4)];
                }
                j4 -= j6;
                segment = segment.next;
            }
        } else {
            long j7 = j4 - j5;
            Segment segment2 = this.head;
            do {
                segment2 = segment2.prev;
                int i7 = segment2.limit;
                i4 = segment2.pos;
                j7 += i7 - i4;
            } while (j7 < 0);
            return segment2.data[i4 + ((int) j7)];
        }
    }

    public int hashCode() {
        Segment segment = this.head;
        if (segment == null) {
            return 0;
        }
        int i4 = 1;
        do {
            int i5 = segment.limit;
            for (int i6 = segment.pos; i6 < i5; i6++) {
                i4 = (i4 * 31) + segment.data[i6];
            }
            segment = segment.next;
        } while (segment != this.head);
        return i4;
    }

    public final ByteString hmacSha1(ByteString byteString) {
        return hmac("HmacSHA1", byteString);
    }

    public final ByteString hmacSha256(ByteString byteString) {
        return hmac("HmacSHA256", byteString);
    }

    public final ByteString hmacSha512(ByteString byteString) {
        return hmac("HmacSHA512", byteString);
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public long indexOf(byte b4) {
        return indexOf(b4, 0L, Long.MAX_VALUE);
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public long indexOfElement(ByteString byteString) {
        return indexOfElement(byteString, 0L);
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public InputStream inputStream() {
        return new InputStream() { // from class: com.mbridge.msdk.thrid.okio.Buffer.2
            @Override // java.io.InputStream
            public int available() {
                return (int) Math.min(Buffer.this.size, 2147483647L);
            }

            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }

            @Override // java.io.InputStream
            public int read() {
                Buffer buffer = Buffer.this;
                if (buffer.size > 0) {
                    return buffer.readByte() & 255;
                }
                return -1;
            }

            public String toString() {
                return Buffer.this + ".inputStream()";
            }

            @Override // java.io.InputStream
            public int read(byte[] bArr, int i4, int i5) {
                return Buffer.this.read(bArr, i4, i5);
            }
        };
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return true;
    }

    public final ByteString md5() {
        return digest("MD5");
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSink
    public OutputStream outputStream() {
        return new OutputStream() { // from class: com.mbridge.msdk.thrid.okio.Buffer.1
            @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }

            @Override // java.io.OutputStream, java.io.Flushable
            public void flush() {
            }

            public String toString() {
                return Buffer.this + ".outputStream()";
            }

            @Override // java.io.OutputStream
            public void write(int i4) {
                Buffer.this.writeByte((int) ((byte) i4));
            }

            @Override // java.io.OutputStream
            public void write(byte[] bArr, int i4, int i5) {
                Buffer.this.write(bArr, i4, i5);
            }
        };
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public boolean rangeEquals(long j4, ByteString byteString) {
        return rangeEquals(j4, byteString, 0, byteString.size());
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public long readAll(Sink sink) throws IOException {
        long j4 = this.size;
        if (j4 > 0) {
            sink.write(this, j4);
        }
        return j4;
    }

    public final UnsafeCursor readAndWriteUnsafe() {
        return readAndWriteUnsafe(new UnsafeCursor());
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public byte readByte() {
        long j4 = this.size;
        if (j4 != 0) {
            Segment segment = this.head;
            int i4 = segment.pos;
            int i5 = segment.limit;
            int i6 = i4 + 1;
            byte b4 = segment.data[i4];
            this.size = j4 - 1;
            if (i6 == i5) {
                this.head = segment.pop();
                SegmentPool.recycle(segment);
            } else {
                segment.pos = i6;
            }
            return b4;
        }
        throw new IllegalStateException("size == 0");
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public byte[] readByteArray() {
        try {
            return readByteArray(this.size);
        } catch (EOFException e4) {
            throw new AssertionError(e4);
        }
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public ByteString readByteString() {
        return new ByteString(readByteArray());
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x00bb, code lost:
        r17.size -= r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00c1, code lost:
        if (r8 == false) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00c5, code lost:
        return -r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:?, code lost:
        return r3;
     */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00ab  */
    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long readDecimalLong() {
        /*
            r17 = this;
            r0 = r17
            long r1 = r0.size
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto Lc6
            r1 = -922337203685477580(0xf333333333333334, double:-8.390303882365713E246)
            r5 = -7
            r7 = 0
            r8 = 0
            r9 = 0
        L14:
            com.mbridge.msdk.thrid.okio.Segment r10 = r0.head
            byte[] r11 = r10.data
            int r12 = r10.pos
            int r13 = r10.limit
        L1c:
            if (r12 >= r13) goto L9f
            r15 = r11[r12]
            r14 = 48
            if (r15 < r14) goto L6c
            r14 = 57
            if (r15 > r14) goto L6c
            int r14 = 48 - r15
            int r16 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r16 < 0) goto L3f
            int r16 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r16 != 0) goto L38
            long r1 = (long) r14
            int r16 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r16 >= 0) goto L38
            goto L3f
        L38:
            r1 = 10
            long r3 = r3 * r1
            long r1 = (long) r14
            long r3 = r3 + r1
            goto L76
        L3f:
            com.mbridge.msdk.thrid.okio.Buffer r1 = new com.mbridge.msdk.thrid.okio.Buffer
            r1.<init>()
            com.mbridge.msdk.thrid.okio.Buffer r1 = r1.writeDecimalLong(r3)
            com.mbridge.msdk.thrid.okio.Buffer r1 = r1.writeByte(r15)
            if (r8 != 0) goto L51
            r1.readByte()
        L51:
            java.lang.NumberFormatException r2 = new java.lang.NumberFormatException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Number too large: "
            r3.append(r4)
            java.lang.String r1 = r1.readUtf8()
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r2.<init>(r1)
            throw r2
        L6c:
            r1 = 45
            if (r15 != r1) goto L80
            if (r7 != 0) goto L80
            r1 = 1
            long r5 = r5 - r1
            r8 = 1
        L76:
            int r12 = r12 + 1
            int r7 = r7 + 1
            r1 = -922337203685477580(0xf333333333333334, double:-8.390303882365713E246)
            goto L1c
        L80:
            if (r7 == 0) goto L84
            r9 = 1
            goto L9f
        L84:
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Expected leading [0-9] or '-' character but was 0x"
            r2.append(r3)
            java.lang.String r3 = java.lang.Integer.toHexString(r15)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L9f:
            if (r12 != r13) goto Lab
            com.mbridge.msdk.thrid.okio.Segment r1 = r10.pop()
            r0.head = r1
            com.mbridge.msdk.thrid.okio.SegmentPool.recycle(r10)
            goto Lad
        Lab:
            r10.pos = r12
        Lad:
            if (r9 != 0) goto Lbb
            com.mbridge.msdk.thrid.okio.Segment r1 = r0.head
            if (r1 != 0) goto Lb4
            goto Lbb
        Lb4:
            r1 = -922337203685477580(0xf333333333333334, double:-8.390303882365713E246)
            goto L14
        Lbb:
            long r1 = r0.size
            long r5 = (long) r7
            long r1 = r1 - r5
            r0.size = r1
            if (r8 == 0) goto Lc4
            goto Lc5
        Lc4:
            long r3 = -r3
        Lc5:
            return r3
        Lc6:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "size == 0"
            r1.<init>(r2)
            goto Lcf
        Lce:
            throw r1
        Lcf:
            goto Lce
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.thrid.okio.Buffer.readDecimalLong():long");
    }

    public final Buffer readFrom(InputStream inputStream) throws IOException {
        readFrom(inputStream, Long.MAX_VALUE, true);
        return this;
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public void readFully(Buffer buffer, long j4) throws EOFException {
        long j5 = this.size;
        if (j5 >= j4) {
            buffer.write(this, j4);
        } else {
            buffer.write(this, j5);
            throw new EOFException();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00a5 A[EDGE_INSN: B:43:0x00a5->B:38:0x00a5 ?: BREAK  , SYNTHETIC] */
    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long readHexadecimalUnsignedLong() {
        /*
            r15 = this;
            long r0 = r15.size
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto Lac
            r0 = 0
            r4 = r2
            r1 = 0
        Lb:
            com.mbridge.msdk.thrid.okio.Segment r6 = r15.head
            byte[] r7 = r6.data
            int r8 = r6.pos
            int r9 = r6.limit
        L13:
            if (r8 >= r9) goto L91
            r10 = r7[r8]
            r11 = 48
            if (r10 < r11) goto L22
            r11 = 57
            if (r10 > r11) goto L22
            int r11 = r10 + (-48)
            goto L3a
        L22:
            r11 = 97
            if (r10 < r11) goto L2f
            r11 = 102(0x66, float:1.43E-43)
            if (r10 > r11) goto L2f
            int r11 = r10 + (-97)
        L2c:
            int r11 = r11 + 10
            goto L3a
        L2f:
            r11 = 65
            if (r10 < r11) goto L72
            r11 = 70
            if (r10 > r11) goto L72
            int r11 = r10 + (-65)
            goto L2c
        L3a:
            r12 = -1152921504606846976(0xf000000000000000, double:-3.105036184601418E231)
            long r12 = r12 & r4
            int r14 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r14 != 0) goto L4a
            r10 = 4
            long r4 = r4 << r10
            long r10 = (long) r11
            long r4 = r4 | r10
            int r8 = r8 + 1
            int r0 = r0 + 1
            goto L13
        L4a:
            com.mbridge.msdk.thrid.okio.Buffer r0 = new com.mbridge.msdk.thrid.okio.Buffer
            r0.<init>()
            com.mbridge.msdk.thrid.okio.Buffer r0 = r0.writeHexadecimalUnsignedLong(r4)
            com.mbridge.msdk.thrid.okio.Buffer r0 = r0.writeByte(r10)
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Number too large: "
            r2.append(r3)
            java.lang.String r0 = r0.readUtf8()
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        L72:
            if (r0 == 0) goto L76
            r1 = 1
            goto L91
        L76:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Expected leading [0-9a-fA-F] character but was 0x"
            r1.append(r2)
            java.lang.String r2 = java.lang.Integer.toHexString(r10)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L91:
            if (r8 != r9) goto L9d
            com.mbridge.msdk.thrid.okio.Segment r7 = r6.pop()
            r15.head = r7
            com.mbridge.msdk.thrid.okio.SegmentPool.recycle(r6)
            goto L9f
        L9d:
            r6.pos = r8
        L9f:
            if (r1 != 0) goto La5
            com.mbridge.msdk.thrid.okio.Segment r6 = r15.head
            if (r6 != 0) goto Lb
        La5:
            long r1 = r15.size
            long r6 = (long) r0
            long r1 = r1 - r6
            r15.size = r1
            return r4
        Lac:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "size == 0"
            r0.<init>(r1)
            goto Lb5
        Lb4:
            throw r0
        Lb5:
            goto Lb4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.thrid.okio.Buffer.readHexadecimalUnsignedLong():long");
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public int readInt() {
        long j4 = this.size;
        if (j4 >= 4) {
            Segment segment = this.head;
            int i4 = segment.pos;
            int i5 = segment.limit;
            if (i5 - i4 < 4) {
                return ((readByte() & 255) << 24) | ((readByte() & 255) << 16) | ((readByte() & 255) << 8) | (readByte() & 255);
            }
            byte[] bArr = segment.data;
            int i6 = i4 + 1;
            int i7 = i6 + 1;
            int i8 = ((bArr[i4] & 255) << 24) | ((bArr[i6] & 255) << 16);
            int i9 = i7 + 1;
            int i10 = i8 | ((bArr[i7] & 255) << 8);
            int i11 = i9 + 1;
            int i12 = i10 | (bArr[i9] & 255);
            this.size = j4 - 4;
            if (i11 == i5) {
                this.head = segment.pop();
                SegmentPool.recycle(segment);
            } else {
                segment.pos = i11;
            }
            return i12;
        }
        throw new IllegalStateException("size < 4: " + this.size);
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public int readIntLe() {
        return Util.reverseBytesInt(readInt());
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public long readLong() {
        long j4 = this.size;
        if (j4 >= 8) {
            Segment segment = this.head;
            int i4 = segment.pos;
            int i5 = segment.limit;
            if (i5 - i4 < 8) {
                return ((readInt() & 4294967295L) << 32) | (4294967295L & readInt());
            }
            byte[] bArr = segment.data;
            int i6 = i4 + 1;
            int i7 = i6 + 1;
            long j5 = (bArr[i6] & 255) << 48;
            int i8 = i7 + 1;
            int i9 = i8 + 1;
            int i10 = i9 + 1;
            int i11 = i10 + 1;
            int i12 = i11 + 1;
            int i13 = i12 + 1;
            long j6 = j5 | ((bArr[i4] & 255) << 56) | ((bArr[i7] & 255) << 40) | ((bArr[i8] & 255) << 32) | ((bArr[i9] & 255) << 24) | ((bArr[i10] & 255) << 16) | ((bArr[i11] & 255) << 8) | (bArr[i12] & 255);
            this.size = j4 - 8;
            if (i13 == i5) {
                this.head = segment.pop();
                SegmentPool.recycle(segment);
            } else {
                segment.pos = i13;
            }
            return j6;
        }
        throw new IllegalStateException("size < 8: " + this.size);
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public long readLongLe() {
        return Util.reverseBytesLong(readLong());
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public short readShort() {
        long j4 = this.size;
        if (j4 >= 2) {
            Segment segment = this.head;
            int i4 = segment.pos;
            int i5 = segment.limit;
            if (i5 - i4 < 2) {
                return (short) (((readByte() & 255) << 8) | (readByte() & 255));
            }
            byte[] bArr = segment.data;
            int i6 = i4 + 1;
            int i7 = i6 + 1;
            int i8 = ((bArr[i4] & 255) << 8) | (bArr[i6] & 255);
            this.size = j4 - 2;
            if (i7 == i5) {
                this.head = segment.pop();
                SegmentPool.recycle(segment);
            } else {
                segment.pos = i7;
            }
            return (short) i8;
        }
        throw new IllegalStateException("size < 2: " + this.size);
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public short readShortLe() {
        return Util.reverseBytesShort(readShort());
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public String readString(Charset charset) {
        try {
            return readString(this.size, charset);
        } catch (EOFException e4) {
            throw new AssertionError(e4);
        }
    }

    public final UnsafeCursor readUnsafe() {
        return readUnsafe(new UnsafeCursor());
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public String readUtf8() {
        try {
            return readString(this.size, Util.UTF_8);
        } catch (EOFException e4) {
            throw new AssertionError(e4);
        }
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public int readUtf8CodePoint() throws EOFException {
        int i4;
        int i5;
        int i6;
        if (this.size != 0) {
            byte b4 = getByte(0L);
            if ((b4 & 128) == 0) {
                i4 = b4 & Byte.MAX_VALUE;
                i5 = 1;
                i6 = 0;
            } else if ((b4 & 224) == 192) {
                i4 = b4 & 31;
                i5 = 2;
                i6 = 128;
            } else if ((b4 & 240) == 224) {
                i4 = b4 & 15;
                i5 = 3;
                i6 = 2048;
            } else if ((b4 & 248) != 240) {
                skip(1L);
                return 65533;
            } else {
                i4 = b4 & 7;
                i5 = 4;
                i6 = 65536;
            }
            long j4 = i5;
            if (this.size >= j4) {
                for (int i7 = 1; i7 < i5; i7++) {
                    long j5 = i7;
                    byte b5 = getByte(j5);
                    if ((b5 & 192) != 128) {
                        skip(j5);
                        return 65533;
                    }
                    i4 = (i4 << 6) | (b5 & 63);
                }
                skip(j4);
                if (i4 > 1114111) {
                    return 65533;
                }
                if ((i4 < 55296 || i4 > 57343) && i4 >= i6) {
                    return i4;
                }
                return 65533;
            }
            throw new EOFException("size < " + i5 + ": " + this.size + " (to read code point prefixed 0x" + Integer.toHexString(b4) + ")");
        }
        throw new EOFException();
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    @Nullable
    public String readUtf8Line() throws EOFException {
        long indexOf = indexOf((byte) 10);
        if (indexOf == -1) {
            long j4 = this.size;
            if (j4 != 0) {
                return readUtf8(j4);
            }
            return null;
        }
        return readUtf8Line(indexOf);
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public String readUtf8LineStrict() throws EOFException {
        return readUtf8LineStrict(Long.MAX_VALUE);
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public boolean request(long j4) {
        return this.size >= j4;
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public void require(long j4) throws EOFException {
        if (this.size < j4) {
            throw new EOFException();
        }
    }

    List<Integer> segmentSizes() {
        if (this.head == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        Segment segment = this.head;
        arrayList.add(Integer.valueOf(segment.limit - segment.pos));
        Segment segment2 = this.head;
        while (true) {
            segment2 = segment2.next;
            if (segment2 == this.head) {
                return arrayList;
            }
            arrayList.add(Integer.valueOf(segment2.limit - segment2.pos));
        }
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public int select(Options options) {
        int selectPrefix = selectPrefix(options, false);
        if (selectPrefix == -1) {
            return -1;
        }
        try {
            skip(options.byteStrings[selectPrefix].size());
            return selectPrefix;
        } catch (EOFException unused) {
            throw new AssertionError();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0055, code lost:
        if (r19 == false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0057, code lost:
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0058, code lost:
        return r11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int selectPrefix(com.mbridge.msdk.thrid.okio.Options r18, boolean r19) {
        /*
            Method dump skipped, instructions count: 161
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.thrid.okio.Buffer.selectPrefix(com.mbridge.msdk.thrid.okio.Options, boolean):int");
    }

    public final ByteString sha1() {
        return digest("SHA-1");
    }

    public final ByteString sha256() {
        return digest("SHA-256");
    }

    public final ByteString sha512() {
        return digest("SHA-512");
    }

    public final long size() {
        return this.size;
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public void skip(long j4) throws EOFException {
        Segment segment;
        while (j4 > 0) {
            if (this.head != null) {
                int min = (int) Math.min(j4, segment.limit - segment.pos);
                long j5 = min;
                this.size -= j5;
                j4 -= j5;
                Segment segment2 = this.head;
                int i4 = segment2.pos + min;
                segment2.pos = i4;
                if (i4 == segment2.limit) {
                    this.head = segment2.pop();
                    SegmentPool.recycle(segment2);
                }
            } else {
                throw new EOFException();
            }
        }
    }

    public final ByteString snapshot() {
        long j4 = this.size;
        if (j4 <= 2147483647L) {
            return snapshot((int) j4);
        }
        throw new IllegalArgumentException("size > Integer.MAX_VALUE: " + this.size);
    }

    @Override // com.mbridge.msdk.thrid.okio.Source
    public Timeout timeout() {
        return Timeout.NONE;
    }

    public String toString() {
        return snapshot().toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Segment writableSegment(int i4) {
        if (i4 >= 1 && i4 <= 8192) {
            Segment segment = this.head;
            if (segment == null) {
                Segment take = SegmentPool.take();
                this.head = take;
                take.prev = take;
                take.next = take;
                return take;
            }
            Segment segment2 = segment.prev;
            return (segment2.limit + i4 > 8192 || !segment2.owner) ? segment2.push(SegmentPool.take()) : segment2;
        }
        throw new IllegalArgumentException();
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSink
    public long writeAll(Source source) throws IOException {
        if (source == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j4 = 0;
        while (true) {
            long read = source.read(this, 8192L);
            if (read == -1) {
                return j4;
            }
            j4 += read;
        }
    }

    public final Buffer writeTo(OutputStream outputStream) throws IOException {
        return writeTo(outputStream, this.size);
    }

    /* renamed from: clone */
    public Buffer m99clone() {
        Buffer buffer = new Buffer();
        if (this.size == 0) {
            return buffer;
        }
        Segment sharedCopy = this.head.sharedCopy();
        buffer.head = sharedCopy;
        sharedCopy.prev = sharedCopy;
        sharedCopy.next = sharedCopy;
        Segment segment = this.head;
        while (true) {
            segment = segment.next;
            if (segment != this.head) {
                buffer.head.prev.push(segment.sharedCopy());
            } else {
                buffer.size = this.size;
                return buffer;
            }
        }
    }

    public final Buffer copyTo(OutputStream outputStream, long j4, long j5) throws IOException {
        int i4;
        if (outputStream != null) {
            Util.checkOffsetAndCount(this.size, j4, j5);
            if (j5 == 0) {
                return this;
            }
            Segment segment = this.head;
            while (true) {
                int i5 = segment.limit;
                int i6 = segment.pos;
                if (j4 < i5 - i6) {
                    break;
                }
                j4 -= i5 - i6;
                segment = segment.next;
            }
            while (j5 > 0) {
                int min = (int) Math.min(segment.limit - i4, j5);
                outputStream.write(segment.data, (int) (segment.pos + j4), min);
                j5 -= min;
                segment = segment.next;
                j4 = 0;
            }
            return this;
        }
        throw new IllegalArgumentException("out == null");
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public long indexOf(byte b4, long j4) {
        return indexOf(b4, j4, Long.MAX_VALUE);
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public long indexOfElement(ByteString byteString, long j4) {
        int i4;
        int i5;
        long j5 = 0;
        if (j4 >= 0) {
            Segment segment = this.head;
            if (segment == null) {
                return -1L;
            }
            long j6 = this.size;
            if (j6 - j4 < j4) {
                while (j6 > j4) {
                    segment = segment.prev;
                    j6 -= segment.limit - segment.pos;
                }
            } else {
                while (true) {
                    long j7 = (segment.limit - segment.pos) + j5;
                    if (j7 >= j4) {
                        break;
                    }
                    segment = segment.next;
                    j5 = j7;
                }
                j6 = j5;
            }
            if (byteString.size() == 2) {
                byte b4 = byteString.getByte(0);
                byte b5 = byteString.getByte(1);
                while (j6 < this.size) {
                    byte[] bArr = segment.data;
                    i4 = (int) ((segment.pos + j4) - j6);
                    int i6 = segment.limit;
                    while (i4 < i6) {
                        byte b6 = bArr[i4];
                        if (b6 == b4 || b6 == b5) {
                            i5 = segment.pos;
                            return (i4 - i5) + j6;
                        }
                        i4++;
                    }
                    j6 += segment.limit - segment.pos;
                    segment = segment.next;
                    j4 = j6;
                }
                return -1L;
            }
            byte[] internalArray = byteString.internalArray();
            while (j6 < this.size) {
                byte[] bArr2 = segment.data;
                i4 = (int) ((segment.pos + j4) - j6);
                int i7 = segment.limit;
                while (i4 < i7) {
                    byte b7 = bArr2[i4];
                    for (byte b8 : internalArray) {
                        if (b7 == b8) {
                            i5 = segment.pos;
                            return (i4 - i5) + j6;
                        }
                    }
                    i4++;
                }
                j6 += segment.limit - segment.pos;
                segment = segment.next;
                j4 = j6;
            }
            return -1L;
        }
        throw new IllegalArgumentException("fromIndex < 0");
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public boolean rangeEquals(long j4, ByteString byteString, int i4, int i5) {
        if (j4 < 0 || i4 < 0 || i5 < 0 || this.size - j4 < i5 || byteString.size() - i4 < i5) {
            return false;
        }
        for (int i6 = 0; i6 < i5; i6++) {
            if (getByte(i6 + j4) != byteString.getByte(i4 + i6)) {
                return false;
            }
        }
        return true;
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public int read(byte[] bArr, int i4, int i5) {
        Util.checkOffsetAndCount(bArr.length, i4, i5);
        Segment segment = this.head;
        if (segment == null) {
            return -1;
        }
        int min = Math.min(i5, segment.limit - segment.pos);
        System.arraycopy(segment.data, segment.pos, bArr, i4, min);
        int i6 = segment.pos + min;
        segment.pos = i6;
        this.size -= min;
        if (i6 == segment.limit) {
            this.head = segment.pop();
            SegmentPool.recycle(segment);
        }
        return min;
    }

    public final UnsafeCursor readAndWriteUnsafe(UnsafeCursor unsafeCursor) {
        if (unsafeCursor.buffer == null) {
            unsafeCursor.buffer = this;
            unsafeCursor.readWrite = true;
            return unsafeCursor;
        }
        throw new IllegalStateException("already attached to a buffer");
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public ByteString readByteString(long j4) throws EOFException {
        return new ByteString(readByteArray(j4));
    }

    public final Buffer readFrom(InputStream inputStream, long j4) throws IOException {
        if (j4 >= 0) {
            readFrom(inputStream, j4, false);
            return this;
        }
        throw new IllegalArgumentException("byteCount < 0: " + j4);
    }

    public final UnsafeCursor readUnsafe(UnsafeCursor unsafeCursor) {
        if (unsafeCursor.buffer == null) {
            unsafeCursor.buffer = this;
            unsafeCursor.readWrite = false;
            return unsafeCursor;
        }
        throw new IllegalStateException("already attached to a buffer");
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public String readUtf8LineStrict(long j4) throws EOFException {
        if (j4 >= 0) {
            long j5 = j4 != Long.MAX_VALUE ? j4 + 1 : Long.MAX_VALUE;
            long indexOf = indexOf((byte) 10, 0L, j5);
            if (indexOf != -1) {
                return readUtf8Line(indexOf);
            }
            if (j5 < size() && getByte(j5 - 1) == 13 && getByte(j5) == 10) {
                return readUtf8Line(j5);
            }
            Buffer buffer = new Buffer();
            copyTo(buffer, 0L, Math.min(32L, size()));
            throw new EOFException("\\n not found: limit=" + Math.min(size(), j4) + " content=" + buffer.readByteString().hex() + '\u2026');
        }
        throw new IllegalArgumentException("limit < 0: " + j4);
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSink
    public Buffer writeByte(int i4) {
        Segment writableSegment = writableSegment(1);
        byte[] bArr = writableSegment.data;
        int i5 = writableSegment.limit;
        writableSegment.limit = i5 + 1;
        bArr[i5] = (byte) i4;
        this.size++;
        return this;
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSink
    public Buffer writeDecimalLong(long j4) {
        if (j4 == 0) {
            return writeByte(48);
        }
        boolean z3 = false;
        int i4 = 1;
        if (j4 < 0) {
            j4 = -j4;
            if (j4 < 0) {
                return writeUtf8("-9223372036854775808");
            }
            z3 = true;
        }
        if (j4 >= 100000000) {
            i4 = j4 < 1000000000000L ? j4 < 10000000000L ? j4 < C.NANOS_PER_SECOND ? 9 : 10 : j4 < 100000000000L ? 11 : 12 : j4 < 1000000000000000L ? j4 < 10000000000000L ? 13 : j4 < 100000000000000L ? 14 : 15 : j4 < 100000000000000000L ? j4 < 10000000000000000L ? 16 : 17 : j4 < 1000000000000000000L ? 18 : 19;
        } else if (j4 >= ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT) {
            i4 = j4 < C.MICROS_PER_SECOND ? j4 < 100000 ? 5 : 6 : j4 < 10000000 ? 7 : 8;
        } else if (j4 >= 100) {
            i4 = j4 < 1000 ? 3 : 4;
        } else if (j4 >= 10) {
            i4 = 2;
        }
        if (z3) {
            i4++;
        }
        Segment writableSegment = writableSegment(i4);
        byte[] bArr = writableSegment.data;
        int i5 = writableSegment.limit + i4;
        while (j4 != 0) {
            i5--;
            bArr[i5] = DIGITS[(int) (j4 % 10)];
            j4 /= 10;
        }
        if (z3) {
            bArr[i5 - 1] = 45;
        }
        writableSegment.limit += i4;
        this.size += i4;
        return this;
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSink
    public Buffer writeHexadecimalUnsignedLong(long j4) {
        if (j4 == 0) {
            return writeByte(48);
        }
        int numberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j4)) / 4) + 1;
        Segment writableSegment = writableSegment(numberOfTrailingZeros);
        byte[] bArr = writableSegment.data;
        int i4 = writableSegment.limit;
        for (int i5 = (i4 + numberOfTrailingZeros) - 1; i5 >= i4; i5--) {
            bArr[i5] = DIGITS[(int) (15 & j4)];
            j4 >>>= 4;
        }
        writableSegment.limit += numberOfTrailingZeros;
        this.size += numberOfTrailingZeros;
        return this;
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSink
    public Buffer writeInt(int i4) {
        Segment writableSegment = writableSegment(4);
        byte[] bArr = writableSegment.data;
        int i5 = writableSegment.limit;
        int i6 = i5 + 1;
        bArr[i5] = (byte) ((i4 >>> 24) & 255);
        int i7 = i6 + 1;
        bArr[i6] = (byte) ((i4 >>> 16) & 255);
        int i8 = i7 + 1;
        bArr[i7] = (byte) ((i4 >>> 8) & 255);
        bArr[i8] = (byte) (i4 & 255);
        writableSegment.limit = i8 + 1;
        this.size += 4;
        return this;
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSink
    public Buffer writeIntLe(int i4) {
        return writeInt(Util.reverseBytesInt(i4));
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSink
    public Buffer writeLong(long j4) {
        Segment writableSegment = writableSegment(8);
        byte[] bArr = writableSegment.data;
        int i4 = writableSegment.limit;
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((j4 >>> 56) & 255);
        int i6 = i5 + 1;
        bArr[i5] = (byte) ((j4 >>> 48) & 255);
        int i7 = i6 + 1;
        bArr[i6] = (byte) ((j4 >>> 40) & 255);
        int i8 = i7 + 1;
        bArr[i7] = (byte) ((j4 >>> 32) & 255);
        int i9 = i8 + 1;
        bArr[i8] = (byte) ((j4 >>> 24) & 255);
        int i10 = i9 + 1;
        bArr[i9] = (byte) ((j4 >>> 16) & 255);
        int i11 = i10 + 1;
        bArr[i10] = (byte) ((j4 >>> 8) & 255);
        bArr[i11] = (byte) (j4 & 255);
        writableSegment.limit = i11 + 1;
        this.size += 8;
        return this;
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSink
    public Buffer writeLongLe(long j4) {
        return writeLong(Util.reverseBytesLong(j4));
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSink
    public Buffer writeShort(int i4) {
        Segment writableSegment = writableSegment(2);
        byte[] bArr = writableSegment.data;
        int i5 = writableSegment.limit;
        int i6 = i5 + 1;
        bArr[i5] = (byte) ((i4 >>> 8) & 255);
        bArr[i6] = (byte) (i4 & 255);
        writableSegment.limit = i6 + 1;
        this.size += 2;
        return this;
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSink
    public Buffer writeShortLe(int i4) {
        return writeShort((int) Util.reverseBytesShort((short) i4));
    }

    public final Buffer writeTo(OutputStream outputStream, long j4) throws IOException {
        if (outputStream != null) {
            Util.checkOffsetAndCount(this.size, 0L, j4);
            Segment segment = this.head;
            while (j4 > 0) {
                int min = (int) Math.min(j4, segment.limit - segment.pos);
                outputStream.write(segment.data, segment.pos, min);
                int i4 = segment.pos + min;
                segment.pos = i4;
                long j5 = min;
                this.size -= j5;
                j4 -= j5;
                if (i4 == segment.limit) {
                    Segment pop = segment.pop();
                    this.head = pop;
                    SegmentPool.recycle(segment);
                    segment = pop;
                }
            }
            return this;
        }
        throw new IllegalArgumentException("out == null");
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSink
    public Buffer writeUtf8CodePoint(int i4) {
        if (i4 < 128) {
            writeByte(i4);
        } else if (i4 < 2048) {
            writeByte((i4 >> 6) | 192);
            writeByte((i4 & 63) | 128);
        } else if (i4 < 65536) {
            if (i4 >= 55296 && i4 <= 57343) {
                writeByte(63);
            } else {
                writeByte((i4 >> 12) | 224);
                writeByte(((i4 >> 6) & 63) | 128);
                writeByte((i4 & 63) | 128);
            }
        } else if (i4 <= 1114111) {
            writeByte((i4 >> 18) | 240);
            writeByte(((i4 >> 12) & 63) | 128);
            writeByte(((i4 >> 6) & 63) | 128);
            writeByte((i4 & 63) | 128);
        } else {
            throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i4));
        }
        return this;
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public long indexOf(byte b4, long j4, long j5) {
        Segment segment;
        long j6 = 0;
        if (j4 >= 0 && j5 >= j4) {
            long j7 = this.size;
            long j8 = j5 > j7 ? j7 : j5;
            if (j4 == j8 || (segment = this.head) == null) {
                return -1L;
            }
            if (j7 - j4 < j4) {
                while (j7 > j4) {
                    segment = segment.prev;
                    j7 -= segment.limit - segment.pos;
                }
            } else {
                while (true) {
                    long j9 = (segment.limit - segment.pos) + j6;
                    if (j9 >= j4) {
                        break;
                    }
                    segment = segment.next;
                    j6 = j9;
                }
                j7 = j6;
            }
            long j10 = j4;
            while (j7 < j8) {
                byte[] bArr = segment.data;
                int min = (int) Math.min(segment.limit, (segment.pos + j8) - j7);
                for (int i4 = (int) ((segment.pos + j10) - j7); i4 < min; i4++) {
                    if (bArr[i4] == b4) {
                        return (i4 - segment.pos) + j7;
                    }
                }
                j7 += segment.limit - segment.pos;
                segment = segment.next;
                j10 = j7;
            }
            return -1L;
        }
        throw new IllegalArgumentException(String.format("size=%s fromIndex=%s toIndex=%s", Long.valueOf(this.size), Long.valueOf(j4), Long.valueOf(j5)));
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public byte[] readByteArray(long j4) throws EOFException {
        Util.checkOffsetAndCount(this.size, 0L, j4);
        if (j4 <= 2147483647L) {
            byte[] bArr = new byte[(int) j4];
            readFully(bArr);
            return bArr;
        }
        throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j4);
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public String readString(long j4, Charset charset) throws EOFException {
        Util.checkOffsetAndCount(this.size, 0L, j4);
        if (charset != null) {
            if (j4 > 2147483647L) {
                throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j4);
            } else if (j4 == 0) {
                return "";
            } else {
                Segment segment = this.head;
                int i4 = segment.pos;
                if (i4 + j4 > segment.limit) {
                    return new String(readByteArray(j4), charset);
                }
                String str = new String(segment.data, i4, (int) j4, charset);
                int i5 = (int) (segment.pos + j4);
                segment.pos = i5;
                this.size -= j4;
                if (i5 == segment.limit) {
                    this.head = segment.pop();
                    SegmentPool.recycle(segment);
                }
                return str;
            }
        }
        throw new IllegalArgumentException("charset == null");
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public String readUtf8(long j4) throws EOFException {
        return readString(j4, Util.UTF_8);
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSink
    public Buffer writeString(String str, Charset charset) {
        return writeString(str, 0, str.length(), charset);
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSink
    public Buffer writeUtf8(String str) {
        return writeUtf8(str, 0, str.length());
    }

    private void readFrom(InputStream inputStream, long j4, boolean z3) throws IOException {
        if (inputStream == null) {
            throw new IllegalArgumentException("in == null");
        }
        while (true) {
            if (j4 <= 0 && !z3) {
                return;
            }
            Segment writableSegment = writableSegment(1);
            int read = inputStream.read(writableSegment.data, writableSegment.limit, (int) Math.min(j4, 8192 - writableSegment.limit));
            if (read == -1) {
                if (!z3) {
                    throw new EOFException();
                }
                return;
            }
            writableSegment.limit += read;
            long j5 = read;
            this.size += j5;
            j4 -= j5;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String readUtf8Line(long j4) throws EOFException {
        if (j4 > 0) {
            long j5 = j4 - 1;
            if (getByte(j5) == 13) {
                String readUtf8 = readUtf8(j5);
                skip(2L);
                return readUtf8;
            }
        }
        String readUtf82 = readUtf8(j4);
        skip(1L);
        return readUtf82;
    }

    public final ByteString snapshot(int i4) {
        if (i4 == 0) {
            return ByteString.EMPTY;
        }
        return new SegmentedByteString(this, i4);
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSink
    public Buffer write(ByteString byteString) {
        if (byteString != null) {
            byteString.write(this);
            return this;
        }
        throw new IllegalArgumentException("byteString == null");
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSink
    public Buffer writeString(String str, int i4, int i5, Charset charset) {
        if (str != null) {
            if (i4 < 0) {
                throw new IllegalAccessError("beginIndex < 0: " + i4);
            } else if (i5 >= i4) {
                if (i5 <= str.length()) {
                    if (charset != null) {
                        if (charset.equals(Util.UTF_8)) {
                            return writeUtf8(str, i4, i5);
                        }
                        byte[] bytes = str.substring(i4, i5).getBytes(charset);
                        return write(bytes, 0, bytes.length);
                    }
                    throw new IllegalArgumentException("charset == null");
                }
                throw new IllegalArgumentException("endIndex > string.length: " + i5 + " > " + str.length());
            } else {
                throw new IllegalArgumentException("endIndex < beginIndex: " + i5 + " < " + i4);
            }
        }
        throw new IllegalArgumentException("string == null");
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSink
    public Buffer writeUtf8(String str, int i4, int i5) {
        if (str != null) {
            if (i4 < 0) {
                throw new IllegalArgumentException("beginIndex < 0: " + i4);
            } else if (i5 >= i4) {
                if (i5 > str.length()) {
                    throw new IllegalArgumentException("endIndex > string.length: " + i5 + " > " + str.length());
                }
                while (i4 < i5) {
                    char charAt = str.charAt(i4);
                    if (charAt < '\u0080') {
                        Segment writableSegment = writableSegment(1);
                        byte[] bArr = writableSegment.data;
                        int i6 = writableSegment.limit - i4;
                        int min = Math.min(i5, 8192 - i6);
                        int i7 = i4 + 1;
                        bArr[i4 + i6] = (byte) charAt;
                        while (i7 < min) {
                            char charAt2 = str.charAt(i7);
                            if (charAt2 >= '\u0080') {
                                break;
                            }
                            bArr[i7 + i6] = (byte) charAt2;
                            i7++;
                        }
                        int i8 = writableSegment.limit;
                        int i9 = (i6 + i7) - i8;
                        writableSegment.limit = i8 + i9;
                        this.size += i9;
                        i4 = i7;
                    } else {
                        if (charAt < '\u0800') {
                            writeByte((charAt >> 6) | 192);
                            writeByte((charAt & '?') | 128);
                        } else if (charAt >= '\ud800' && charAt <= '\udfff') {
                            int i10 = i4 + 1;
                            char charAt3 = i10 < i5 ? str.charAt(i10) : (char) 0;
                            if (charAt <= '\udbff' && charAt3 >= '\udc00' && charAt3 <= '\udfff') {
                                int i11 = (((charAt & '\u27ff') << 10) | ('\u23ff' & charAt3)) + 65536;
                                writeByte((i11 >> 18) | 240);
                                writeByte(((i11 >> 12) & 63) | 128);
                                writeByte(((i11 >> 6) & 63) | 128);
                                writeByte((i11 & 63) | 128);
                                i4 += 2;
                            } else {
                                writeByte(63);
                                i4 = i10;
                            }
                        } else {
                            writeByte((charAt >> '\f') | 224);
                            writeByte(((charAt >> 6) & 63) | 128);
                            writeByte((charAt & '?') | 128);
                        }
                        i4++;
                    }
                }
                return this;
            } else {
                throw new IllegalArgumentException("endIndex < beginIndex: " + i5 + " < " + i4);
            }
        }
        throw new IllegalArgumentException("string == null");
    }

    private boolean rangeEquals(Segment segment, int i4, ByteString byteString, int i5, int i6) {
        int i7 = segment.limit;
        byte[] bArr = segment.data;
        while (i5 < i6) {
            if (i4 == i7) {
                segment = segment.next;
                byte[] bArr2 = segment.data;
                bArr = bArr2;
                i4 = segment.pos;
                i7 = segment.limit;
            }
            if (bArr[i4] != byteString.getByte(i5)) {
                return false;
            }
            i4++;
            i5++;
        }
        return true;
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public void readFully(byte[] bArr) throws EOFException {
        int i4 = 0;
        while (i4 < bArr.length) {
            int read = read(bArr, i4, bArr.length - i4);
            if (read == -1) {
                throw new EOFException();
            }
            i4 += read;
        }
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSink
    public Buffer write(byte[] bArr) {
        if (bArr != null) {
            return write(bArr, 0, bArr.length);
        }
        throw new IllegalArgumentException("source == null");
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSink
    public Buffer write(byte[] bArr, int i4, int i5) {
        if (bArr != null) {
            long j4 = i5;
            Util.checkOffsetAndCount(bArr.length, i4, j4);
            int i6 = i5 + i4;
            while (i4 < i6) {
                Segment writableSegment = writableSegment(1);
                int min = Math.min(i6 - i4, 8192 - writableSegment.limit);
                System.arraycopy(bArr, i4, writableSegment.data, writableSegment.limit, min);
                i4 += min;
                writableSegment.limit += min;
            }
            this.size += j4;
            return this;
        }
        throw new IllegalArgumentException("source == null");
    }

    public final Buffer copyTo(Buffer buffer, long j4, long j5) {
        if (buffer != null) {
            Util.checkOffsetAndCount(this.size, j4, j5);
            if (j5 == 0) {
                return this;
            }
            buffer.size += j5;
            Segment segment = this.head;
            while (true) {
                int i4 = segment.limit;
                int i5 = segment.pos;
                if (j4 < i4 - i5) {
                    break;
                }
                j4 -= i4 - i5;
                segment = segment.next;
            }
            while (j5 > 0) {
                Segment sharedCopy = segment.sharedCopy();
                int i6 = (int) (sharedCopy.pos + j4);
                sharedCopy.pos = i6;
                sharedCopy.limit = Math.min(i6 + ((int) j5), sharedCopy.limit);
                Segment segment2 = buffer.head;
                if (segment2 == null) {
                    sharedCopy.prev = sharedCopy;
                    sharedCopy.next = sharedCopy;
                    buffer.head = sharedCopy;
                } else {
                    segment2.prev.push(sharedCopy);
                }
                j5 -= sharedCopy.limit - sharedCopy.pos;
                segment = segment.next;
                j4 = 0;
            }
            return this;
        }
        throw new IllegalArgumentException("out == null");
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) throws IOException {
        Segment segment = this.head;
        if (segment == null) {
            return -1;
        }
        int min = Math.min(byteBuffer.remaining(), segment.limit - segment.pos);
        byteBuffer.put(segment.data, segment.pos, min);
        int i4 = segment.pos + min;
        segment.pos = i4;
        this.size -= min;
        if (i4 == segment.limit) {
            this.head = segment.pop();
            SegmentPool.recycle(segment);
        }
        return min;
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer != null) {
            int remaining = byteBuffer.remaining();
            int i4 = remaining;
            while (i4 > 0) {
                Segment writableSegment = writableSegment(1);
                int min = Math.min(i4, 8192 - writableSegment.limit);
                byteBuffer.get(writableSegment.data, writableSegment.limit, min);
                i4 -= min;
                writableSegment.limit += min;
            }
            this.size += remaining;
            return remaining;
        }
        throw new IllegalArgumentException("source == null");
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public long indexOf(ByteString byteString) throws IOException {
        return indexOf(byteString, 0L);
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSource
    public long indexOf(ByteString byteString, long j4) throws IOException {
        byte[] bArr;
        if (byteString.size() != 0) {
            long j5 = 0;
            if (j4 >= 0) {
                Segment segment = this.head;
                long j6 = -1;
                if (segment == null) {
                    return -1L;
                }
                long j7 = this.size;
                if (j7 - j4 < j4) {
                    while (j7 > j4) {
                        segment = segment.prev;
                        j7 -= segment.limit - segment.pos;
                    }
                } else {
                    while (true) {
                        long j8 = (segment.limit - segment.pos) + j5;
                        if (j8 >= j4) {
                            break;
                        }
                        segment = segment.next;
                        j5 = j8;
                    }
                    j7 = j5;
                }
                byte b4 = byteString.getByte(0);
                int size = byteString.size();
                long j9 = 1 + (this.size - size);
                long j10 = j4;
                Segment segment2 = segment;
                long j11 = j7;
                while (j11 < j9) {
                    byte[] bArr2 = segment2.data;
                    int min = (int) Math.min(segment2.limit, (segment2.pos + j9) - j11);
                    int i4 = (int) ((segment2.pos + j10) - j11);
                    while (i4 < min) {
                        if (bArr2[i4] == b4) {
                            bArr = bArr2;
                            if (rangeEquals(segment2, i4 + 1, byteString, 1, size)) {
                                return (i4 - segment2.pos) + j11;
                            }
                        } else {
                            bArr = bArr2;
                        }
                        i4++;
                        bArr2 = bArr;
                    }
                    j11 += segment2.limit - segment2.pos;
                    segment2 = segment2.next;
                    j10 = j11;
                    j6 = -1;
                }
                return j6;
            }
            throw new IllegalArgumentException("fromIndex < 0");
        }
        throw new IllegalArgumentException("bytes is empty");
    }

    @Override // com.mbridge.msdk.thrid.okio.Source
    public long read(Buffer buffer, long j4) {
        if (buffer != null) {
            if (j4 >= 0) {
                long j5 = this.size;
                if (j5 == 0) {
                    return -1L;
                }
                if (j4 > j5) {
                    j4 = j5;
                }
                buffer.write(this, j4);
                return j4;
            }
            throw new IllegalArgumentException("byteCount < 0: " + j4);
        }
        throw new IllegalArgumentException("sink == null");
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSink
    public BufferedSink write(Source source, long j4) throws IOException {
        while (j4 > 0) {
            long read = source.read(this, j4);
            if (read == -1) {
                throw new EOFException();
            }
            j4 -= read;
        }
        return this;
    }

    @Override // com.mbridge.msdk.thrid.okio.Sink
    public void write(Buffer buffer, long j4) {
        if (buffer == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (buffer != this) {
            Util.checkOffsetAndCount(buffer.size, 0L, j4);
            while (j4 > 0) {
                Segment segment = buffer.head;
                if (j4 < segment.limit - segment.pos) {
                    Segment segment2 = this.head;
                    Segment segment3 = segment2 != null ? segment2.prev : null;
                    if (segment3 != null && segment3.owner) {
                        if ((segment3.limit + j4) - (segment3.shared ? 0 : segment3.pos) <= 8192) {
                            segment.writeTo(segment3, (int) j4);
                            buffer.size -= j4;
                            this.size += j4;
                            return;
                        }
                    }
                    buffer.head = segment.split((int) j4);
                }
                Segment segment4 = buffer.head;
                long j5 = segment4.limit - segment4.pos;
                buffer.head = segment4.pop();
                Segment segment5 = this.head;
                if (segment5 == null) {
                    this.head = segment4;
                    segment4.prev = segment4;
                    segment4.next = segment4;
                } else {
                    segment5.prev.push(segment4).compact();
                }
                buffer.size -= j5;
                this.size += j5;
                j4 -= j5;
            }
            return;
        }
        throw new IllegalArgumentException("source == this");
    }
}
