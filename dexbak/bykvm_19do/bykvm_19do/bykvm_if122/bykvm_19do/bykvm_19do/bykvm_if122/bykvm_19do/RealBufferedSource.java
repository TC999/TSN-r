package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do;

import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import kotlin.text.Typography;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.n */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class RealBufferedSource implements BufferedSource {

    /* renamed from: a */
    public final Buffer f832a = new Buffer();

    /* renamed from: b */
    public final Source f833b;

    /* renamed from: c */
    boolean f834c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RealBufferedSource(Source source) {
        if (source != null) {
            this.f833b = source;
            return;
        }
        throw new NullPointerException("source == null");
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.Source
    /* renamed from: a */
    public long mo58558a(Buffer buffer, long j) throws IOException {
        if (buffer != null) {
            if (j >= 0) {
                if (!this.f834c) {
                    Buffer buffer2 = this.f832a;
                    if (buffer2.f805b == 0 && this.f833b.mo58558a(buffer2, 8192L) == -1) {
                        return -1L;
                    }
                    return this.f832a.mo58558a(buffer, Math.min(j, this.f832a.f805b));
                }
                throw new IllegalStateException("closed");
            }
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }
        throw new IllegalArgumentException("sink == null");
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.BufferedSource
    /* renamed from: c */
    public void mo58909c(long j) throws IOException {
        if (!m58913a(j)) {
            throw new EOFException();
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f834c) {
            return;
        }
        this.f834c = true;
        this.f833b.close();
        this.f832a.m58966a();
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.BufferedSource
    /* renamed from: d */
    public ByteString mo58908d(long j) throws IOException {
        mo58909c(j);
        return this.f832a.mo58908d(j);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.BufferedSource
    /* renamed from: e */
    public String mo58907e(long j) throws IOException {
        if (j >= 0) {
            long j2 = j == Long.MAX_VALUE ? Long.MAX_VALUE : j + 1;
            long m58914a = m58914a((byte) 10, 0L, j2);
            if (m58914a != -1) {
                return this.f832a.m58945h(m58914a);
            }
            if (j2 < Long.MAX_VALUE && m58913a(j2) && this.f832a.m58963a(j2 - 1) == 13 && m58913a(1 + j2) && this.f832a.m58963a(j2) == 10) {
                return this.f832a.m58945h(j2);
            }
            Buffer buffer = new Buffer();
            Buffer buffer2 = this.f832a;
            buffer2.m58960a(buffer, 0L, Math.min(32L, buffer2.m58947f()));
            throw new EOFException("\\n not found: limit=" + Math.min(this.f832a.m58947f(), j) + " content=" + buffer.m58949d().mo58885b() + Typography.f41555E);
        }
        throw new IllegalArgumentException("limit < 0: " + j);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.BufferedSource
    /* renamed from: f */
    public byte[] mo58906f(long j) throws IOException {
        mo58909c(j);
        return this.f832a.mo58906f(j);
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.f834c;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.BufferedSource, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.BufferedSink
    /* renamed from: o */
    public Buffer mo58905o() {
        return this.f832a;
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) throws IOException {
        Buffer buffer = this.f832a;
        if (buffer.f805b == 0 && this.f833b.mo58558a(buffer, 8192L) == -1) {
            return -1;
        }
        return this.f832a.read(byteBuffer);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.BufferedSource
    public byte readByte() throws IOException {
        mo58909c(1L);
        return this.f832a.readByte();
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.BufferedSource
    public void readFully(byte[] bArr) throws IOException {
        try {
            mo58909c(bArr.length);
            this.f832a.readFully(bArr);
        } catch (EOFException e) {
            int i = 0;
            while (true) {
                Buffer buffer = this.f832a;
                long j = buffer.f805b;
                if (j <= 0) {
                    throw e;
                }
                int m58955a = buffer.m58955a(bArr, i, (int) j);
                if (m58955a == -1) {
                    throw new AssertionError();
                }
                i += m58955a;
            }
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.BufferedSource
    public int readInt() throws IOException {
        mo58909c(4L);
        return this.f832a.readInt();
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.BufferedSource
    public short readShort() throws IOException {
        mo58909c(2L);
        return this.f832a.readShort();
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.BufferedSource
    public void skip(long j) throws IOException {
        if (this.f834c) {
            throw new IllegalStateException("closed");
        }
        while (j > 0) {
            Buffer buffer = this.f832a;
            if (buffer.f805b == 0 && this.f833b.mo58558a(buffer, 8192L) == -1) {
                throw new EOFException();
            }
            long min = Math.min(j, this.f832a.m58947f());
            this.f832a.skip(min);
            j -= min;
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.Source
    /* renamed from: t */
    public Timeout mo58555t() {
        return this.f833b.mo58555t();
    }

    public String toString() {
        return "buffer(" + this.f833b + ")";
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.BufferedSource
    /* renamed from: u */
    public short mo58904u() throws IOException {
        mo58909c(2L);
        return this.f832a.mo58904u();
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.BufferedSource
    /* renamed from: v */
    public String mo58903v() throws IOException {
        return mo58907e(Long.MAX_VALUE);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.BufferedSource
    /* renamed from: w */
    public int mo58902w() throws IOException {
        mo58909c(4L);
        return this.f832a.mo58902w();
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.BufferedSource
    /* renamed from: x */
    public boolean mo58901x() throws IOException {
        if (this.f834c) {
            throw new IllegalStateException("closed");
        }
        return this.f832a.mo58901x() && this.f833b.mo58558a(this.f832a, 8192L) == -1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0032, code lost:
        if (r1 == 0) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0049, code lost:
        throw new java.lang.NumberFormatException(java.lang.String.format("Expected leading [0-9a-fA-F] character but was %#x", java.lang.Byte.valueOf(r3)));
     */
    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.BufferedSource
    /* renamed from: y */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long mo58900y() throws java.io.IOException {
        /*
            r6 = this;
            r0 = 1
            r6.mo58909c(r0)
            r0 = 0
            r1 = 0
        L7:
            int r2 = r1 + 1
            long r3 = (long) r2
            boolean r3 = r6.m58913a(r3)
            if (r3 == 0) goto L4a
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c r3 = r6.f832a
            long r4 = (long) r1
            byte r3 = r3.m58963a(r4)
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
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c r0 = r6.f832a
            long r0 = r0.mo58900y()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.RealBufferedSource.mo58900y():long");
    }

    /* renamed from: a */
    public boolean m58913a(long j) throws IOException {
        Buffer buffer;
        if (j >= 0) {
            if (!this.f834c) {
                do {
                    buffer = this.f832a;
                    if (buffer.f805b >= j) {
                        return true;
                    }
                } while (this.f833b.mo58558a(buffer, 8192L) != -1);
                return false;
            }
            throw new IllegalStateException("closed");
        }
        throw new IllegalArgumentException("byteCount < 0: " + j);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.BufferedSource
    /* renamed from: a */
    public String mo58910a(Charset charset) throws IOException {
        if (charset != null) {
            this.f832a.m58958a(this.f833b);
            return this.f832a.mo58910a(charset);
        }
        throw new IllegalArgumentException("charset == null");
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.BufferedSource
    /* renamed from: a */
    public long mo58915a(byte b) throws IOException {
        return m58914a(b, 0L, Long.MAX_VALUE);
    }

    /* renamed from: a */
    public long m58914a(byte b, long j, long j2) throws IOException {
        if (this.f834c) {
            throw new IllegalStateException("closed");
        }
        if (j < 0 || j2 < j) {
            throw new IllegalArgumentException(String.format("fromIndex=%s toIndex=%s", Long.valueOf(j), Long.valueOf(j2)));
        }
        while (j < j2) {
            long m58965a = this.f832a.m58965a(b, j, j2);
            if (m58965a == -1) {
                Buffer buffer = this.f832a;
                long j3 = buffer.f805b;
                if (j3 >= j2 || this.f833b.mo58558a(buffer, 8192L) == -1) {
                    break;
                }
                j = Math.max(j, j3);
            } else {
                return m58965a;
            }
        }
        return -1L;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.BufferedSource
    /* renamed from: a */
    public boolean mo58912a(long j, ByteString byteString) throws IOException {
        return m58911a(j, byteString, 0, byteString.mo58881e());
    }

    /* renamed from: a */
    public boolean m58911a(long j, ByteString byteString, int i, int i2) throws IOException {
        if (!this.f834c) {
            if (j < 0 || i < 0 || i2 < 0 || byteString.mo58881e() - i < i2) {
                return false;
            }
            for (int i3 = 0; i3 < i2; i3++) {
                long j2 = i3 + j;
                if (!m58913a(1 + j2) || this.f832a.m58963a(j2) != byteString.mo58890a(i + i3)) {
                    return false;
                }
            }
            return true;
        }
        throw new IllegalStateException("closed");
    }
}
