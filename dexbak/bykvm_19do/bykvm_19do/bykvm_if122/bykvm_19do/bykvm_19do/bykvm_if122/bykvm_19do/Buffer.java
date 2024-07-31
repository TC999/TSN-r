package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do;

import com.alibaba.fastjson.asm.Opcodes;
import com.autonavi.amap.mapcore.tools.GlMapUtil;
import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import kotlin.UByte;
import kotlin.text.Typography;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class Buffer implements BufferedSource, BufferedSink, Cloneable, ByteChannel {

    /* renamed from: c */
    private static final byte[] f803c = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};

    /* renamed from: a */
    Segment f804a;

    /* renamed from: b */
    long f805b;

    /* renamed from: a */
    public final Buffer m58960a(Buffer buffer, long j, long j2) {
        if (buffer != null) {
            Util.m58867a(this.f805b, j, j2);
            if (j2 == 0) {
                return this;
            }
            buffer.f805b += j2;
            Segment segment = this.f804a;
            while (true) {
                long j3 = segment.f837c - segment.f836b;
                if (j < j3) {
                    break;
                }
                j -= j3;
                segment = segment.f840f;
            }
            while (j2 > 0) {
                Segment m58894c = segment.m58894c();
                int i = (int) (m58894c.f836b + j);
                m58894c.f836b = i;
                m58894c.f837c = Math.min(i + ((int) j2), m58894c.f837c);
                Segment segment2 = buffer.f804a;
                if (segment2 == null) {
                    m58894c.f841g = m58894c;
                    m58894c.f840f = m58894c;
                    buffer.f804a = m58894c;
                } else {
                    segment2.f841g.m58897a(m58894c);
                }
                j2 -= m58894c.f837c - m58894c.f836b;
                segment = segment.f840f;
                j = 0;
            }
            return this;
        }
        throw new IllegalArgumentException("out == null");
    }

    /* renamed from: b */
    public final long m58954b() {
        long j = this.f805b;
        if (j == 0) {
            return 0L;
        }
        Segment segment = this.f804a.f841g;
        int i = segment.f837c;
        return (i >= 8192 || !segment.f839e) ? j : j - (i - segment.f836b);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.BufferedSource
    /* renamed from: c */
    public void mo58909c(long j) throws EOFException {
        if (this.f805b < j) {
            throw new EOFException();
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    /* renamed from: e */
    public String m58948e() {
        try {
            return m58961a(this.f805b, Util.f850a);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Buffer) {
            Buffer buffer = (Buffer) obj;
            long j = this.f805b;
            if (j != buffer.f805b) {
                return false;
            }
            long j2 = 0;
            if (j == 0) {
                return true;
            }
            Segment segment = this.f804a;
            Segment segment2 = buffer.f804a;
            int i = segment.f836b;
            int i2 = segment2.f836b;
            while (j2 < this.f805b) {
                long min = Math.min(segment.f837c - i, segment2.f837c - i2);
                int i3 = 0;
                while (i3 < min) {
                    int i4 = i + 1;
                    int i5 = i2 + 1;
                    if (segment.f835a[i] != segment2.f835a[i2]) {
                        return false;
                    }
                    i3++;
                    i = i4;
                    i2 = i5;
                }
                if (i == segment.f837c) {
                    segment = segment.f840f;
                    i = segment.f836b;
                }
                if (i2 == segment2.f837c) {
                    segment2 = segment2.f840f;
                    i2 = segment2.f836b;
                }
                j2 += min;
            }
            return true;
        }
        return false;
    }

    /* renamed from: f */
    public final long m58947f() {
        return this.f805b;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.BufferedSink, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.Sink, java.io.Flushable
    public void flush() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: h */
    public String m58945h(long j) throws EOFException {
        if (j > 0) {
            long j2 = j - 1;
            if (m58963a(j2) == 13) {
                String m58952b = m58952b(j2);
                skip(2L);
                return m58952b;
            }
        }
        String m58952b2 = m58952b(j);
        skip(1L);
        return m58952b2;
    }

    public int hashCode() {
        Segment segment = this.f804a;
        if (segment == null) {
            return 0;
        }
        int i = 1;
        do {
            int i2 = segment.f837c;
            for (int i3 = segment.f836b; i3 < i2; i3++) {
                i = (i * 31) + segment.f835a[i3];
            }
            segment = segment.f840f;
        } while (segment != this.f804a);
        return i;
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return true;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.BufferedSource, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.BufferedSink
    /* renamed from: o */
    public Buffer mo58905o() {
        return this;
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) throws IOException {
        Segment segment = this.f804a;
        if (segment == null) {
            return -1;
        }
        int min = Math.min(byteBuffer.remaining(), segment.f837c - segment.f836b);
        byteBuffer.put(segment.f835a, segment.f836b, min);
        int i = segment.f836b + min;
        segment.f836b = i;
        this.f805b -= min;
        if (i == segment.f837c) {
            this.f804a = segment.m58895b();
            SegmentPool.m58892a(segment);
        }
        return min;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.BufferedSource
    public byte readByte() {
        long j = this.f805b;
        if (j != 0) {
            Segment segment = this.f804a;
            int i = segment.f836b;
            int i2 = segment.f837c;
            int i3 = i + 1;
            byte b = segment.f835a[i];
            this.f805b = j - 1;
            if (i3 == i2) {
                this.f804a = segment.m58895b();
                SegmentPool.m58892a(segment);
            } else {
                segment.f836b = i3;
            }
            return b;
        }
        throw new IllegalStateException("size == 0");
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.BufferedSource
    public void readFully(byte[] bArr) throws EOFException {
        int i = 0;
        while (i < bArr.length) {
            int m58955a = m58955a(bArr, i, bArr.length - i);
            if (m58955a == -1) {
                throw new EOFException();
            }
            i += m58955a;
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.BufferedSource
    public int readInt() {
        long j = this.f805b;
        if (j >= 4) {
            Segment segment = this.f804a;
            int i = segment.f836b;
            int i2 = segment.f837c;
            if (i2 - i < 4) {
                return ((readByte() & UByte.f41242c) << 24) | ((readByte() & UByte.f41242c) << 16) | ((readByte() & UByte.f41242c) << 8) | (readByte() & UByte.f41242c);
            }
            byte[] bArr = segment.f835a;
            int i3 = i + 1;
            int i4 = i3 + 1;
            int i5 = ((bArr[i] & UByte.f41242c) << 24) | ((bArr[i3] & UByte.f41242c) << 16);
            int i6 = i4 + 1;
            int i7 = i5 | ((bArr[i4] & UByte.f41242c) << 8);
            int i8 = i6 + 1;
            int i9 = i7 | (bArr[i6] & UByte.f41242c);
            this.f805b = j - 4;
            if (i8 == i2) {
                this.f804a = segment.m58895b();
                SegmentPool.m58892a(segment);
            } else {
                segment.f836b = i8;
            }
            return i9;
        }
        throw new IllegalStateException("size < 4: " + this.f805b);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.BufferedSource
    public short readShort() {
        long j = this.f805b;
        if (j >= 2) {
            Segment segment = this.f804a;
            int i = segment.f836b;
            int i2 = segment.f837c;
            if (i2 - i < 2) {
                return (short) (((readByte() & UByte.f41242c) << 8) | (readByte() & UByte.f41242c));
            }
            byte[] bArr = segment.f835a;
            int i3 = i + 1;
            int i4 = i3 + 1;
            int i5 = ((bArr[i] & UByte.f41242c) << 8) | (bArr[i3] & UByte.f41242c);
            this.f805b = j - 2;
            if (i4 == i2) {
                this.f804a = segment.m58895b();
                SegmentPool.m58892a(segment);
            } else {
                segment.f836b = i4;
            }
            return (short) i5;
        }
        throw new IllegalStateException("size < 2: " + this.f805b);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.BufferedSource
    public void skip(long j) throws EOFException {
        Segment segment;
        while (j > 0) {
            if (this.f804a != null) {
                int min = (int) Math.min(j, segment.f837c - segment.f836b);
                long j2 = min;
                this.f805b -= j2;
                j -= j2;
                Segment segment2 = this.f804a;
                int i = segment2.f836b + min;
                segment2.f836b = i;
                if (i == segment2.f837c) {
                    this.f804a = segment2.m58895b();
                    SegmentPool.m58892a(segment2);
                }
            } else {
                throw new EOFException();
            }
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.Source
    /* renamed from: t */
    public Timeout mo58555t() {
        return Timeout.f846d;
    }

    public String toString() {
        return m58946g().toString();
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.BufferedSource
    /* renamed from: u */
    public short mo58904u() {
        return Util.m58865a(readShort());
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.BufferedSource
    /* renamed from: v */
    public String mo58903v() throws EOFException {
        return mo58907e(Long.MAX_VALUE);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.BufferedSource
    /* renamed from: w */
    public int mo58902w() {
        return Util.m58868a(readInt());
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.BufferedSource
    /* renamed from: x */
    public boolean mo58901x() {
        return this.f805b == 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00a5 A[EDGE_INSN: B:43:0x00a5->B:38:0x00a5 ?: BREAK  , SYNTHETIC] */
    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.BufferedSource
    /* renamed from: y */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long mo58900y() {
        /*
            r15 = this;
            long r0 = r15.f805b
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto Lac
            r0 = 0
            r4 = r2
            r1 = 0
        Lb:
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.o r6 = r15.f804a
            byte[] r7 = r6.f835a
            int r8 = r6.f836b
            int r9 = r6.f837c
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
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c r0 = new bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c
            r0.<init>()
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c r0 = r0.mo58917g(r4)
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c r0 = r0.writeByte(r10)
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Number too large: "
            r2.append(r3)
            java.lang.String r0 = r0.m58948e()
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
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.o r7 = r6.m58895b()
            r15.f804a = r7
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.SegmentPool.m58892a(r6)
            goto L9f
        L9d:
            r6.f836b = r8
        L9f:
            if (r1 != 0) goto La5
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.o r6 = r15.f804a
            if (r6 != 0) goto Lb
        La5:
            long r1 = r15.f805b
            long r6 = (long) r0
            long r1 = r1 - r6
            r15.f805b = r1
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
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.Buffer.mo58900y():long");
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.BufferedSink
    /* renamed from: z */
    public Buffer mo58916z() {
        return this;
    }

    /* renamed from: c */
    public byte[] m58951c() {
        try {
            return mo58906f(this.f805b);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    /* renamed from: clone */
    public Buffer m60086clone() {
        Buffer buffer = new Buffer();
        if (this.f805b == 0) {
            return buffer;
        }
        Segment m58894c = this.f804a.m58894c();
        buffer.f804a = m58894c;
        m58894c.f841g = m58894c;
        m58894c.f840f = m58894c;
        for (Segment segment = this.f804a.f840f; segment != this.f804a; segment = segment.f840f) {
            buffer.f804a.f841g.m58897a(segment.m58894c());
        }
        buffer.f805b = this.f805b;
        return buffer;
    }

    /* renamed from: d */
    public ByteString m58949d() {
        return new ByteString(m58951c());
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.BufferedSource
    /* renamed from: f */
    public byte[] mo58906f(long j) throws EOFException {
        Util.m58867a(this.f805b, 0L, j);
        if (j <= 2147483647L) {
            byte[] bArr = new byte[(int) j];
            readFully(bArr);
            return bArr;
        }
        throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.BufferedSink
    /* renamed from: g */
    public Buffer mo58917g(long j) {
        if (j == 0) {
            return writeByte(48);
        }
        int numberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j)) / 4) + 1;
        Segment m58953b = m58953b(numberOfTrailingZeros);
        byte[] bArr = m58953b.f835a;
        int i = m58953b.f837c;
        for (int i2 = (i + numberOfTrailingZeros) - 1; i2 >= i; i2--) {
            bArr[i2] = f803c[(int) (15 & j)];
            j >>>= 4;
        }
        m58953b.f837c += numberOfTrailingZeros;
        this.f805b += numberOfTrailingZeros;
        return this;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.BufferedSink
    public Buffer writeByte(int i) {
        Segment m58953b = m58953b(1);
        byte[] bArr = m58953b.f835a;
        int i2 = m58953b.f837c;
        m58953b.f837c = i2 + 1;
        bArr[i2] = (byte) i;
        this.f805b++;
        return this;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.BufferedSink
    public Buffer writeInt(int i) {
        Segment m58953b = m58953b(4);
        byte[] bArr = m58953b.f835a;
        int i2 = m58953b.f837c;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 24) & 255);
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((i >>> 16) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((i >>> 8) & 255);
        bArr[i5] = (byte) (i & 255);
        m58953b.f837c = i5 + 1;
        this.f805b += 4;
        return this;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.BufferedSink
    public Buffer writeShort(int i) {
        Segment m58953b = m58953b(2);
        byte[] bArr = m58953b.f835a;
        int i2 = m58953b.f837c;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 8) & 255);
        bArr[i3] = (byte) (i & 255);
        m58953b.f837c = i3 + 1;
        this.f805b += 2;
        return this;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.BufferedSource
    /* renamed from: d */
    public ByteString mo58908d(long j) throws EOFException {
        return new ByteString(mo58906f(j));
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.BufferedSource
    /* renamed from: e */
    public String mo58907e(long j) throws EOFException {
        if (j >= 0) {
            long j2 = j != Long.MAX_VALUE ? j + 1 : Long.MAX_VALUE;
            long m58965a = m58965a((byte) 10, 0L, j2);
            if (m58965a != -1) {
                return m58945h(m58965a);
            }
            if (j2 < m58947f() && m58963a(j2 - 1) == 13 && m58963a(j2) == 10) {
                return m58945h(j2);
            }
            Buffer buffer = new Buffer();
            m58960a(buffer, 0L, Math.min(32L, m58947f()));
            throw new EOFException("\\n not found: limit=" + Math.min(m58947f(), j) + " content=" + buffer.m58949d().mo58885b() + Typography.f41555E);
        }
        throw new IllegalArgumentException("limit < 0: " + j);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.BufferedSink
    public Buffer write(byte[] bArr) {
        if (bArr != null) {
            return write(bArr, 0, bArr.length);
        }
        throw new IllegalArgumentException("source == null");
    }

    /* renamed from: c */
    public Buffer m58950c(int i) {
        if (i < 128) {
            writeByte(i);
        } else if (i < 2048) {
            writeByte((i >> 6) | Opcodes.CHECKCAST);
            writeByte((i & 63) | 128);
        } else if (i < 65536) {
            if (i >= 55296 && i <= 57343) {
                writeByte(63);
            } else {
                writeByte((i >> 12) | 224);
                writeByte(((i >> 6) & 63) | 128);
                writeByte((i & 63) | 128);
            }
        } else if (i <= 1114111) {
            writeByte((i >> 18) | GlMapUtil.DEVICE_DISPLAY_DPI_MEDIAN);
            writeByte(((i >> 12) & 63) | 128);
            writeByte(((i >> 6) & 63) | 128);
            writeByte((i & 63) | 128);
        } else {
            throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i));
        }
        return this;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.BufferedSink
    /* renamed from: d */
    public Buffer mo58918d(String str) {
        return m58957a(str, 0, str.length());
    }

    /* renamed from: b */
    public String m58952b(long j) throws EOFException {
        return m58961a(j, Util.f850a);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.BufferedSink
    public Buffer write(byte[] bArr, int i, int i2) {
        if (bArr != null) {
            long j = i2;
            Util.m58867a(bArr.length, i, j);
            int i3 = i2 + i;
            while (i < i3) {
                Segment m58953b = m58953b(1);
                int min = Math.min(i3 - i, 8192 - m58953b.f837c);
                System.arraycopy(bArr, i, m58953b.f835a, m58953b.f837c, min);
                i += min;
                m58953b.f837c += min;
            }
            this.f805b += j;
            return this;
        }
        throw new IllegalArgumentException("source == null");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public Segment m58953b(int i) {
        if (i >= 1 && i <= 8192) {
            Segment segment = this.f804a;
            if (segment == null) {
                Segment m58893a = SegmentPool.m58893a();
                this.f804a = m58893a;
                m58893a.f841g = m58893a;
                m58893a.f840f = m58893a;
                return m58893a;
            }
            Segment segment2 = segment.f841g;
            return (segment2.f837c + i > 8192 || !segment2.f839e) ? segment2.m58897a(SegmentPool.m58893a()) : segment2;
        }
        throw new IllegalArgumentException();
    }

    /* renamed from: g */
    public final ByteString m58946g() {
        long j = this.f805b;
        if (j <= 2147483647L) {
            return m58964a((int) j);
        }
        throw new IllegalArgumentException("size > Integer.MAX_VALUE: " + this.f805b);
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer != null) {
            int remaining = byteBuffer.remaining();
            int i = remaining;
            while (i > 0) {
                Segment m58953b = m58953b(1);
                int min = Math.min(i, 8192 - m58953b.f837c);
                byteBuffer.get(m58953b.f835a, m58953b.f837c, min);
                i -= min;
                m58953b.f837c += min;
            }
            this.f805b += remaining;
            return remaining;
        }
        throw new IllegalArgumentException("source == null");
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.Sink
    /* renamed from: b */
    public void mo58561b(Buffer buffer, long j) {
        if (buffer == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (buffer != this) {
            Util.m58867a(buffer.f805b, 0L, j);
            while (j > 0) {
                Segment segment = buffer.f804a;
                if (j < segment.f837c - segment.f836b) {
                    Segment segment2 = this.f804a;
                    Segment segment3 = segment2 != null ? segment2.f841g : null;
                    if (segment3 != null && segment3.f839e) {
                        if ((segment3.f837c + j) - (segment3.f838d ? 0 : segment3.f836b) <= 8192) {
                            segment.m58896a(segment3, (int) j);
                            buffer.f805b -= j;
                            this.f805b += j;
                            return;
                        }
                    }
                    buffer.f804a = segment.m58898a((int) j);
                }
                Segment segment4 = buffer.f804a;
                long j2 = segment4.f837c - segment4.f836b;
                buffer.f804a = segment4.m58895b();
                Segment segment5 = this.f804a;
                if (segment5 == null) {
                    this.f804a = segment4;
                    segment4.f841g = segment4;
                    segment4.f840f = segment4;
                } else {
                    segment5.f841g.m58897a(segment4).m58899a();
                }
                buffer.f805b -= j2;
                this.f805b += j2;
                j -= j2;
            }
            return;
        }
        throw new IllegalArgumentException("source == this");
    }

    /* renamed from: a */
    public final byte m58963a(long j) {
        Util.m58867a(this.f805b, j, 1L);
        long j2 = this.f805b;
        if (j2 - j > j) {
            Segment segment = this.f804a;
            while (true) {
                int i = segment.f837c;
                int i2 = segment.f836b;
                long j3 = i - i2;
                if (j < j3) {
                    return segment.f835a[i2 + ((int) j)];
                }
                j -= j3;
                segment = segment.f840f;
            }
        } else {
            long j4 = j - j2;
            Segment segment2 = this.f804a.f841g;
            while (true) {
                int i3 = segment2.f837c;
                int i4 = segment2.f836b;
                j4 += i3 - i4;
                if (j4 >= 0) {
                    return segment2.f835a[i4 + ((int) j4)];
                }
                segment2 = segment2.f841g;
            }
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.BufferedSource
    /* renamed from: a */
    public String mo58910a(Charset charset) {
        try {
            return m58961a(this.f805b, charset);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    /* renamed from: a */
    public String m58961a(long j, Charset charset) throws EOFException {
        Util.m58867a(this.f805b, 0L, j);
        if (charset != null) {
            if (j > 2147483647L) {
                throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
            } else if (j == 0) {
                return "";
            } else {
                Segment segment = this.f804a;
                int i = segment.f836b;
                if (i + j > segment.f837c) {
                    return new String(mo58906f(j), charset);
                }
                String str = new String(segment.f835a, i, (int) j, charset);
                int i2 = (int) (segment.f836b + j);
                segment.f836b = i2;
                this.f805b -= j;
                if (i2 == segment.f837c) {
                    this.f804a = segment.m58895b();
                    SegmentPool.m58892a(segment);
                }
                return str;
            }
        }
        throw new IllegalArgumentException("charset == null");
    }

    /* renamed from: a */
    public int m58955a(byte[] bArr, int i, int i2) {
        Util.m58867a(bArr.length, i, i2);
        Segment segment = this.f804a;
        if (segment == null) {
            return -1;
        }
        int min = Math.min(i2, segment.f837c - segment.f836b);
        System.arraycopy(segment.f835a, segment.f836b, bArr, i, min);
        int i3 = segment.f836b + min;
        segment.f836b = i3;
        this.f805b -= min;
        if (i3 == segment.f837c) {
            this.f804a = segment.m58895b();
            SegmentPool.m58892a(segment);
        }
        return min;
    }

    /* renamed from: a */
    public final void m58966a() {
        try {
            skip(this.f805b);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    /* renamed from: a */
    public Buffer m58959a(ByteString byteString) {
        if (byteString != null) {
            byteString.mo58886a(this);
            return this;
        }
        throw new IllegalArgumentException("byteString == null");
    }

    /* renamed from: a */
    public Buffer m58957a(String str, int i, int i2) {
        char charAt;
        if (str != null) {
            if (i < 0) {
                throw new IllegalArgumentException("beginIndex < 0: " + i);
            } else if (i2 >= i) {
                if (i2 > str.length()) {
                    throw new IllegalArgumentException("endIndex > string.length: " + i2 + " > " + str.length());
                }
                while (i < i2) {
                    char charAt2 = str.charAt(i);
                    if (charAt2 < 128) {
                        Segment m58953b = m58953b(1);
                        byte[] bArr = m58953b.f835a;
                        int i3 = m58953b.f837c - i;
                        int min = Math.min(i2, 8192 - i3);
                        int i4 = i + 1;
                        bArr[i + i3] = (byte) charAt2;
                        while (true) {
                            i = i4;
                            if (i >= min || (charAt = str.charAt(i)) >= 128) {
                                break;
                            }
                            i4 = i + 1;
                            bArr[i + i3] = (byte) charAt;
                        }
                        int i5 = m58953b.f837c;
                        int i6 = (i3 + i) - i5;
                        m58953b.f837c = i5 + i6;
                        this.f805b += i6;
                    } else {
                        if (charAt2 < 2048) {
                            writeByte((charAt2 >> 6) | Opcodes.CHECKCAST);
                            writeByte((charAt2 & '?') | 128);
                        } else if (charAt2 >= 55296 && charAt2 <= 57343) {
                            int i7 = i + 1;
                            char charAt3 = i7 < i2 ? str.charAt(i7) : (char) 0;
                            if (charAt2 <= 56319 && charAt3 >= 56320 && charAt3 <= 57343) {
                                int i8 = (((charAt2 & 10239) << 10) | (9215 & charAt3)) + 65536;
                                writeByte((i8 >> 18) | GlMapUtil.DEVICE_DISPLAY_DPI_MEDIAN);
                                writeByte(((i8 >> 12) & 63) | 128);
                                writeByte(((i8 >> 6) & 63) | 128);
                                writeByte((i8 & 63) | 128);
                                i += 2;
                            } else {
                                writeByte(63);
                                i = i7;
                            }
                        } else {
                            writeByte((charAt2 >> '\f') | 224);
                            writeByte(((charAt2 >> 6) & 63) | 128);
                            writeByte((charAt2 & '?') | 128);
                        }
                        i++;
                    }
                }
                return this;
            } else {
                throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
            }
        }
        throw new IllegalArgumentException("string == null");
    }

    /* renamed from: a */
    public Buffer m58956a(String str, int i, int i2, Charset charset) {
        if (str != null) {
            if (i < 0) {
                throw new IllegalAccessError("beginIndex < 0: " + i);
            } else if (i2 >= i) {
                if (i2 <= str.length()) {
                    if (charset != null) {
                        if (charset.equals(Util.f850a)) {
                            return m58957a(str, i, i2);
                        }
                        byte[] bytes = str.substring(i, i2).getBytes(charset);
                        return write(bytes, 0, bytes.length);
                    }
                    throw new IllegalArgumentException("charset == null");
                }
                throw new IllegalArgumentException("endIndex > string.length: " + i2 + " > " + str.length());
            } else {
                throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
            }
        }
        throw new IllegalArgumentException("string == null");
    }

    /* renamed from: a */
    public long m58958a(Source source) throws IOException {
        if (source == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = 0;
        while (true) {
            long mo58558a = source.mo58558a(this, 8192L);
            if (mo58558a == -1) {
                return j;
            }
            j += mo58558a;
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.Source
    /* renamed from: a */
    public long mo58558a(Buffer buffer, long j) {
        if (buffer != null) {
            if (j >= 0) {
                long j2 = this.f805b;
                if (j2 == 0) {
                    return -1L;
                }
                if (j > j2) {
                    j = j2;
                }
                buffer.mo58561b(this, j);
                return j;
            }
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }
        throw new IllegalArgumentException("sink == null");
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.BufferedSource
    /* renamed from: a */
    public long mo58915a(byte b) {
        return m58965a(b, 0L, Long.MAX_VALUE);
    }

    /* renamed from: a */
    public long m58965a(byte b, long j, long j2) {
        Segment segment;
        long j3 = 0;
        if (j >= 0 && j2 >= j) {
            long j4 = this.f805b;
            long j5 = j2 > j4 ? j4 : j2;
            if (j == j5 || (segment = this.f804a) == null) {
                return -1L;
            }
            if (j4 - j < j) {
                while (j4 > j) {
                    segment = segment.f841g;
                    j4 -= segment.f837c - segment.f836b;
                }
            } else {
                while (true) {
                    long j6 = (segment.f837c - segment.f836b) + j3;
                    if (j6 >= j) {
                        break;
                    }
                    segment = segment.f840f;
                    j3 = j6;
                }
                j4 = j3;
            }
            long j7 = j;
            while (j4 < j5) {
                byte[] bArr = segment.f835a;
                int min = (int) Math.min(segment.f837c, (segment.f836b + j5) - j4);
                for (int i = (int) ((segment.f836b + j7) - j4); i < min; i++) {
                    if (bArr[i] == b) {
                        return (i - segment.f836b) + j4;
                    }
                }
                j4 += segment.f837c - segment.f836b;
                segment = segment.f840f;
                j7 = j4;
            }
            return -1L;
        }
        throw new IllegalArgumentException(String.format("size=%s fromIndex=%s toIndex=%s", Long.valueOf(this.f805b), Long.valueOf(j), Long.valueOf(j2)));
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.BufferedSource
    /* renamed from: a */
    public boolean mo58912a(long j, ByteString byteString) {
        return m58962a(j, byteString, 0, byteString.mo58881e());
    }

    /* renamed from: a */
    public boolean m58962a(long j, ByteString byteString, int i, int i2) {
        if (j < 0 || i < 0 || i2 < 0 || this.f805b - j < i2 || byteString.mo58881e() - i < i2) {
            return false;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            if (m58963a(i3 + j) != byteString.mo58890a(i + i3)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    public final ByteString m58964a(int i) {
        if (i == 0) {
            return ByteString.f807e;
        }
        return new SegmentedByteString(this, i);
    }
}
