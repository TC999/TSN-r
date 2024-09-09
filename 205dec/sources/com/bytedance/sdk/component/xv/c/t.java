package com.bytedance.sdk.component.xv.c;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class t implements ux {

    /* renamed from: c  reason: collision with root package name */
    public final xv f30693c = new xv();

    /* renamed from: w  reason: collision with root package name */
    public final fz f30694w;
    boolean xv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(fz fzVar) {
        if (fzVar != null) {
            this.f30694w = fzVar;
            return;
        }
        throw new NullPointerException("source == null");
    }

    @Override // com.bytedance.sdk.component.xv.c.ux
    public int a() throws IOException {
        c(4L);
        return this.f30693c.a();
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0032, code lost:
        if (r1 == 0) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0049, code lost:
        throw new java.lang.NumberFormatException(java.lang.String.format("Expected leading [0-9a-fA-F] character but was %#x", java.lang.Byte.valueOf(r3)));
     */
    @Override // com.bytedance.sdk.component.xv.c.ux
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long bk() throws java.io.IOException {
        /*
            r6 = this;
            r0 = 1
            r6.c(r0)
            r0 = 0
            r1 = 0
        L7:
            int r2 = r1 + 1
            long r3 = (long) r2
            boolean r3 = r6.w(r3)
            if (r3 == 0) goto L4a
            com.bytedance.sdk.component.xv.c.xv r3 = r6.f30693c
            long r4 = (long) r1
            byte r3 = r3.w(r4)
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
            com.bytedance.sdk.component.xv.c.xv r0 = r6.f30693c
            long r0 = r0.bk()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.xv.c.t.bk():long");
    }

    @Override // com.bytedance.sdk.component.xv.c.fz
    public long c(xv xvVar, long j4) throws IOException {
        if (xvVar != null) {
            if (j4 >= 0) {
                if (!this.xv) {
                    xv xvVar2 = this.f30693c;
                    if (xvVar2.f30701w == 0 && this.f30694w.c(xvVar2, 8192L) == -1) {
                        return -1L;
                    }
                    return this.f30693c.c(xvVar, Math.min(j4, this.f30693c.f30701w));
                }
                throw new IllegalStateException("closed");
            }
            throw new IllegalArgumentException("byteCount < 0: " + j4);
        }
        throw new IllegalArgumentException("sink == null");
    }

    @Override // com.bytedance.sdk.component.xv.c.fz, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.xv) {
            return;
        }
        this.xv = true;
        this.f30694w.close();
        this.f30693c.s();
    }

    @Override // com.bytedance.sdk.component.xv.c.ux
    public byte ev() throws IOException {
        c(1L);
        return this.f30693c.ev();
    }

    @Override // com.bytedance.sdk.component.xv.c.ux
    public InputStream f() {
        return new InputStream() { // from class: com.bytedance.sdk.component.xv.c.t.1
            @Override // java.io.InputStream
            public int available() throws IOException {
                t tVar = t.this;
                if (!tVar.xv) {
                    return (int) Math.min(tVar.f30693c.f30701w, 2147483647L);
                }
                throw new IOException("closed");
            }

            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                t.this.close();
            }

            @Override // java.io.InputStream
            public int read() throws IOException {
                t tVar = t.this;
                if (!tVar.xv) {
                    xv xvVar = tVar.f30693c;
                    if (xvVar.f30701w == 0 && tVar.f30694w.c(xvVar, 8192L) == -1) {
                        return -1;
                    }
                    return t.this.f30693c.ev() & 255;
                }
                throw new IOException("closed");
            }

            public String toString() {
                return t.this + ".inputStream()";
            }

            @Override // java.io.InputStream
            public int read(byte[] bArr, int i4, int i5) throws IOException {
                if (!t.this.xv) {
                    i.c(bArr.length, i4, i5);
                    t tVar = t.this;
                    xv xvVar = tVar.f30693c;
                    if (xvVar.f30701w == 0 && tVar.f30694w.c(xvVar, 8192L) == -1) {
                        return -1;
                    }
                    return t.this.f30693c.c(bArr, i4, i5);
                }
                throw new IOException("closed");
            }
        };
    }

    @Override // com.bytedance.sdk.component.xv.c.ux
    public String fp() throws IOException {
        return ux(Long.MAX_VALUE);
    }

    @Override // com.bytedance.sdk.component.xv.c.ux
    public short gd() throws IOException {
        c(2L);
        return this.f30693c.gd();
    }

    @Override // com.bytedance.sdk.component.xv.c.ux
    public byte[] ia() throws IOException {
        this.f30693c.c(this.f30694w);
        return this.f30693c.ia();
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.xv;
    }

    @Override // com.bytedance.sdk.component.xv.c.ux
    public short k() throws IOException {
        c(2L);
        return this.f30693c.k();
    }

    @Override // com.bytedance.sdk.component.xv.c.ux
    public int p() throws IOException {
        c(4L);
        return this.f30693c.p();
    }

    @Override // com.bytedance.sdk.component.xv.c.ux
    public byte[] r(long j4) throws IOException {
        c(j4);
        return this.f30693c.r(j4);
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) throws IOException {
        xv xvVar = this.f30693c;
        if (xvVar.f30701w == 0 && this.f30694w.c(xvVar, 8192L) == -1) {
            return -1;
        }
        return this.f30693c.read(byteBuffer);
    }

    public String toString() {
        return "buffer(" + this.f30694w + ")";
    }

    @Override // com.bytedance.sdk.component.xv.c.ux
    public boolean ux() throws IOException {
        if (this.xv) {
            throw new IllegalStateException("closed");
        }
        return this.f30693c.ux() && this.f30694w.c(this.f30693c, 8192L) == -1;
    }

    public boolean w(long j4) throws IOException {
        xv xvVar;
        if (j4 >= 0) {
            if (!this.xv) {
                do {
                    xvVar = this.f30693c;
                    if (xvVar.f30701w >= j4) {
                        return true;
                    }
                } while (this.f30694w.c(xvVar, 8192L) != -1);
                return false;
            }
            throw new IllegalStateException("closed");
        }
        throw new IllegalArgumentException("byteCount < 0: " + j4);
    }

    @Override // com.bytedance.sdk.component.xv.c.ux
    public xv xv() {
        return this.f30693c;
    }

    @Override // com.bytedance.sdk.component.xv.c.ux
    public f xv(long j4) throws IOException {
        c(j4);
        return this.f30693c.xv(j4);
    }

    @Override // com.bytedance.sdk.component.xv.c.ux
    public void ev(long j4) throws IOException {
        if (this.xv) {
            throw new IllegalStateException("closed");
        }
        while (j4 > 0) {
            xv xvVar = this.f30693c;
            if (xvVar.f30701w == 0 && this.f30694w.c(xvVar, 8192L) == -1) {
                throw new EOFException();
            }
            long min = Math.min(j4, this.f30693c.w());
            this.f30693c.ev(min);
            j4 -= min;
        }
    }

    @Override // com.bytedance.sdk.component.xv.c.ux
    public String ux(long j4) throws IOException {
        if (j4 >= 0) {
            long j5 = j4 == Long.MAX_VALUE ? Long.MAX_VALUE : j4 + 1;
            long c4 = c((byte) 10, 0L, j5);
            if (c4 != -1) {
                return this.f30693c.f(c4);
            }
            if (j5 < Long.MAX_VALUE && w(j5) && this.f30693c.w(j5 - 1) == 13 && w(1 + j5) && this.f30693c.w(j5) == 10) {
                return this.f30693c.f(j5);
            }
            xv xvVar = new xv();
            xv xvVar2 = this.f30693c;
            xvVar2.c(xvVar, 0L, Math.min(32L, xvVar2.w()));
            throw new EOFException("\\n not found: limit=" + Math.min(this.f30693c.w(), j4) + " content=" + xvVar.t().ux() + '\u2026');
        }
        throw new IllegalArgumentException("limit < 0: " + j4);
    }

    @Override // com.bytedance.sdk.component.xv.c.ux
    public void c(long j4) throws IOException {
        if (!w(j4)) {
            throw new EOFException();
        }
    }

    @Override // com.bytedance.sdk.component.xv.c.ux
    public void c(byte[] bArr) throws IOException {
        try {
            c(bArr.length);
            this.f30693c.c(bArr);
        } catch (EOFException e4) {
            int i4 = 0;
            while (true) {
                xv xvVar = this.f30693c;
                long j4 = xvVar.f30701w;
                if (j4 <= 0) {
                    throw e4;
                }
                int c4 = xvVar.c(bArr, i4, (int) j4);
                if (c4 == -1) {
                    throw new AssertionError();
                }
                i4 += c4;
            }
        }
    }

    @Override // com.bytedance.sdk.component.xv.c.ux
    public String c(Charset charset) throws IOException {
        if (charset != null) {
            this.f30693c.c(this.f30694w);
            return this.f30693c.c(charset);
        }
        throw new IllegalArgumentException("charset == null");
    }

    @Override // com.bytedance.sdk.component.xv.c.ux
    public long c(byte b4) throws IOException {
        return c(b4, 0L, Long.MAX_VALUE);
    }

    public long c(byte b4, long j4, long j5) throws IOException {
        if (this.xv) {
            throw new IllegalStateException("closed");
        }
        if (j4 < 0 || j5 < j4) {
            throw new IllegalArgumentException(String.format("fromIndex=%s toIndex=%s", Long.valueOf(j4), Long.valueOf(j5)));
        }
        while (j4 < j5) {
            long c4 = this.f30693c.c(b4, j4, j5);
            if (c4 == -1) {
                xv xvVar = this.f30693c;
                long j6 = xvVar.f30701w;
                if (j6 >= j5 || this.f30694w.c(xvVar, 8192L) == -1) {
                    break;
                }
                j4 = Math.max(j4, j6);
            } else {
                return c4;
            }
        }
        return -1L;
    }

    @Override // com.bytedance.sdk.component.xv.c.ux
    public boolean c(long j4, f fVar) throws IOException {
        return c(j4, fVar, 0, fVar.r());
    }

    public boolean c(long j4, f fVar, int i4, int i5) throws IOException {
        if (!this.xv) {
            if (j4 < 0 || i4 < 0 || i5 < 0 || fVar.r() - i4 < i5) {
                return false;
            }
            for (int i6 = 0; i6 < i5; i6++) {
                long j5 = i6 + j4;
                if (!w(1 + j5) || this.f30693c.w(j5) != fVar.c(i4 + i6)) {
                    return false;
                }
            }
            return true;
        }
        throw new IllegalStateException("closed");
    }

    @Override // com.bytedance.sdk.component.xv.c.fz
    public u c() {
        return this.f30694w.c();
    }
}
