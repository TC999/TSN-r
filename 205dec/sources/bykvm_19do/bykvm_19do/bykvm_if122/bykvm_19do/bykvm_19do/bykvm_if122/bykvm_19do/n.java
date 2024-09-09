package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do;

import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RealBufferedSource.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public final class n implements e {

    /* renamed from: a  reason: collision with root package name */
    public final c f825a = new c();

    /* renamed from: b  reason: collision with root package name */
    public final s f826b;

    /* renamed from: c  reason: collision with root package name */
    boolean f827c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(s sVar) {
        if (sVar != null) {
            this.f826b = sVar;
            return;
        }
        throw new NullPointerException("source == null");
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.s
    public long a(c cVar, long j4) throws IOException {
        if (cVar != null) {
            if (j4 >= 0) {
                if (!this.f827c) {
                    c cVar2 = this.f825a;
                    if (cVar2.f798b == 0 && this.f826b.a(cVar2, 8192L) == -1) {
                        return -1L;
                    }
                    return this.f825a.a(cVar, Math.min(j4, this.f825a.f798b));
                }
                throw new IllegalStateException("closed");
            }
            throw new IllegalArgumentException("byteCount < 0: " + j4);
        }
        throw new IllegalArgumentException("sink == null");
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e
    public void c(long j4) throws IOException {
        if (!a(j4)) {
            throw new EOFException();
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.s, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f827c) {
            return;
        }
        this.f827c = true;
        this.f826b.close();
        this.f825a.a();
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e
    public f d(long j4) throws IOException {
        c(j4);
        return this.f825a.d(j4);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e
    public String e(long j4) throws IOException {
        if (j4 >= 0) {
            long j5 = j4 == Long.MAX_VALUE ? Long.MAX_VALUE : j4 + 1;
            long a4 = a((byte) 10, 0L, j5);
            if (a4 != -1) {
                return this.f825a.h(a4);
            }
            if (j5 < Long.MAX_VALUE && a(j5) && this.f825a.a(j5 - 1) == 13 && a(1 + j5) && this.f825a.a(j5) == 10) {
                return this.f825a.h(j5);
            }
            c cVar = new c();
            c cVar2 = this.f825a;
            cVar2.a(cVar, 0L, Math.min(32L, cVar2.f()));
            throw new EOFException("\\n not found: limit=" + Math.min(this.f825a.f(), j4) + " content=" + cVar.d().b() + '\u2026');
        }
        throw new IllegalArgumentException("limit < 0: " + j4);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e
    public byte[] f(long j4) throws IOException {
        c(j4);
        return this.f825a.f(j4);
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.f827c;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.d
    public c o() {
        return this.f825a;
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) throws IOException {
        c cVar = this.f825a;
        if (cVar.f798b == 0 && this.f826b.a(cVar, 8192L) == -1) {
            return -1;
        }
        return this.f825a.read(byteBuffer);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e
    public byte readByte() throws IOException {
        c(1L);
        return this.f825a.readByte();
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e
    public void readFully(byte[] bArr) throws IOException {
        try {
            c(bArr.length);
            this.f825a.readFully(bArr);
        } catch (EOFException e4) {
            int i4 = 0;
            while (true) {
                c cVar = this.f825a;
                long j4 = cVar.f798b;
                if (j4 <= 0) {
                    throw e4;
                }
                int a4 = cVar.a(bArr, i4, (int) j4);
                if (a4 == -1) {
                    throw new AssertionError();
                }
                i4 += a4;
            }
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e
    public int readInt() throws IOException {
        c(4L);
        return this.f825a.readInt();
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e
    public short readShort() throws IOException {
        c(2L);
        return this.f825a.readShort();
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e
    public void skip(long j4) throws IOException {
        if (this.f827c) {
            throw new IllegalStateException("closed");
        }
        while (j4 > 0) {
            c cVar = this.f825a;
            if (cVar.f798b == 0 && this.f826b.a(cVar, 8192L) == -1) {
                throw new EOFException();
            }
            long min = Math.min(j4, this.f825a.f());
            this.f825a.skip(min);
            j4 -= min;
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.s
    public t t() {
        return this.f826b.t();
    }

    public String toString() {
        return "buffer(" + this.f826b + ")";
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e
    public short u() throws IOException {
        c(2L);
        return this.f825a.u();
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e
    public String v() throws IOException {
        return e(Long.MAX_VALUE);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e
    public int w() throws IOException {
        c(4L);
        return this.f825a.w();
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e
    public boolean x() throws IOException {
        if (this.f827c) {
            throw new IllegalStateException("closed");
        }
        return this.f825a.x() && this.f826b.a(this.f825a, 8192L) == -1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0032, code lost:
        if (r1 == 0) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0049, code lost:
        throw new java.lang.NumberFormatException(java.lang.String.format("Expected leading [0-9a-fA-F] character but was %#x", java.lang.Byte.valueOf(r3)));
     */
    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long y() throws java.io.IOException {
        /*
            r6 = this;
            r0 = 1
            r6.c(r0)
            r0 = 0
            r1 = 0
        L7:
            int r2 = r1 + 1
            long r3 = (long) r2
            boolean r3 = r6.a(r3)
            if (r3 == 0) goto L4a
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c r3 = r6.f825a
            long r4 = (long) r1
            byte r3 = r3.a(r4)
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
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c r0 = r6.f825a
            long r0 = r0.y()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.n.y():long");
    }

    public boolean a(long j4) throws IOException {
        c cVar;
        if (j4 >= 0) {
            if (!this.f827c) {
                do {
                    cVar = this.f825a;
                    if (cVar.f798b >= j4) {
                        return true;
                    }
                } while (this.f826b.a(cVar, 8192L) != -1);
                return false;
            }
            throw new IllegalStateException("closed");
        }
        throw new IllegalArgumentException("byteCount < 0: " + j4);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e
    public String a(Charset charset) throws IOException {
        if (charset != null) {
            this.f825a.a(this.f826b);
            return this.f825a.a(charset);
        }
        throw new IllegalArgumentException("charset == null");
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e
    public long a(byte b4) throws IOException {
        return a(b4, 0L, Long.MAX_VALUE);
    }

    public long a(byte b4, long j4, long j5) throws IOException {
        if (this.f827c) {
            throw new IllegalStateException("closed");
        }
        if (j4 < 0 || j5 < j4) {
            throw new IllegalArgumentException(String.format("fromIndex=%s toIndex=%s", Long.valueOf(j4), Long.valueOf(j5)));
        }
        while (j4 < j5) {
            long a4 = this.f825a.a(b4, j4, j5);
            if (a4 == -1) {
                c cVar = this.f825a;
                long j6 = cVar.f798b;
                if (j6 >= j5 || this.f826b.a(cVar, 8192L) == -1) {
                    break;
                }
                j4 = Math.max(j4, j6);
            } else {
                return a4;
            }
        }
        return -1L;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e
    public boolean a(long j4, f fVar) throws IOException {
        return a(j4, fVar, 0, fVar.e());
    }

    public boolean a(long j4, f fVar, int i4, int i5) throws IOException {
        if (!this.f827c) {
            if (j4 < 0 || i4 < 0 || i5 < 0 || fVar.e() - i4 < i5) {
                return false;
            }
            for (int i6 = 0; i6 < i5; i6++) {
                long j5 = i6 + j4;
                if (!a(1 + j5) || this.f825a.a(j5) != fVar.a(i4 + i6)) {
                    return false;
                }
            }
            return true;
        }
        throw new IllegalStateException("closed");
    }
}
