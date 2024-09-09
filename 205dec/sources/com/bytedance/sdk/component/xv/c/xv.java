package com.bytedance.sdk.component.xv.c;

import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bykv.vk.component.ttvideo.player.C;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class xv implements sr, ux, Cloneable, ByteChannel {
    private static final byte[] xv = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};

    /* renamed from: c  reason: collision with root package name */
    ys f30700c;

    /* renamed from: w  reason: collision with root package name */
    long f30701w;

    @Override // com.bytedance.sdk.component.xv.c.s
    public void a_(xv xvVar, long j4) {
        ys ysVar;
        if (xvVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (xvVar != this) {
            i.c(xvVar.f30701w, 0L, j4);
            while (j4 > 0 && (ysVar = xvVar.f30700c) != null) {
                if (j4 < ysVar.xv - ysVar.f30706w) {
                    ys ysVar2 = this.f30700c;
                    ys ysVar3 = ysVar2 != null ? ysVar2.f30705r : null;
                    if (ysVar3 != null && ysVar3.ux) {
                        if ((ysVar3.xv + j4) - (ysVar3.sr ? 0 : ysVar3.f30706w) <= 8192) {
                            ysVar.c(ysVar3, (int) j4);
                            xvVar.f30701w -= j4;
                            this.f30701w += j4;
                            return;
                        }
                    }
                    xvVar.f30700c = ysVar.c((int) j4);
                }
                ys ysVar4 = xvVar.f30700c;
                long j5 = ysVar4.xv - ysVar4.f30706w;
                xvVar.f30700c = ysVar4.w();
                ys ysVar5 = this.f30700c;
                if (ysVar5 == null) {
                    this.f30700c = ysVar4;
                    ysVar4.f30705r = ysVar4;
                    ysVar4.f30704f = ysVar4;
                } else {
                    ysVar5.f30705r.c(ysVar4).xv();
                }
                xvVar.f30701w -= j5;
                this.f30701w += j5;
                j4 -= j5;
            }
            return;
        }
        throw new IllegalArgumentException("source == this");
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00a5 A[EDGE_INSN: B:43:0x00a5->B:38:0x00a5 ?: BREAK  , SYNTHETIC] */
    @Override // com.bytedance.sdk.component.xv.c.ux
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long bk() {
        /*
            r15 = this;
            long r0 = r15.f30701w
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto Lac
            r0 = 0
            r4 = r2
            r1 = 0
        Lb:
            com.bytedance.sdk.component.xv.c.ys r6 = r15.f30700c
            byte[] r7 = r6.f30703c
            int r8 = r6.f30706w
            int r9 = r6.xv
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
            com.bytedance.sdk.component.xv.c.xv r0 = new com.bytedance.sdk.component.xv.c.xv
            r0.<init>()
            com.bytedance.sdk.component.xv.c.xv r0 = r0.k(r4)
            com.bytedance.sdk.component.xv.c.xv r0 = r0.gd(r10)
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Number too large: "
            r2.append(r3)
            java.lang.String r0 = r0.ys()
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
            com.bytedance.sdk.component.xv.c.ys r7 = r6.w()
            r15.f30700c = r7
            com.bytedance.sdk.component.xv.c.fp.c(r6)
            goto L9f
        L9d:
            r6.f30706w = r8
        L9f:
            if (r1 != 0) goto La5
            com.bytedance.sdk.component.xv.c.ys r6 = r15.f30700c
            if (r6 != 0) goto Lb
        La5:
            long r1 = r15.f30701w
            long r6 = (long) r0
            long r1 = r1 - r6
            r15.f30701w = r1
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
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.xv.c.xv.bk():long");
    }

    @Override // com.bytedance.sdk.component.xv.c.ux
    public void c(long j4) throws EOFException {
        if (this.f30701w < j4) {
            throw new EOFException();
        }
    }

    @Override // com.bytedance.sdk.component.xv.c.s, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof xv) {
            xv xvVar = (xv) obj;
            long j4 = this.f30701w;
            if (j4 != xvVar.f30701w) {
                return false;
            }
            long j5 = 0;
            if (j4 == 0) {
                return true;
            }
            ys ysVar = this.f30700c;
            ys ysVar2 = xvVar.f30700c;
            int i4 = ysVar.f30706w;
            int i5 = ysVar2.f30706w;
            while (j5 < this.f30701w) {
                long min = Math.min(ysVar.xv - i4, ysVar2.xv - i5);
                int i6 = 0;
                while (i6 < min) {
                    int i7 = i4 + 1;
                    int i8 = i5 + 1;
                    if (ysVar.f30703c[i4] != ysVar2.f30703c[i5]) {
                        return false;
                    }
                    i6++;
                    i4 = i7;
                    i5 = i8;
                }
                if (i4 == ysVar.xv) {
                    ysVar = ysVar.f30704f;
                    i4 = ysVar.f30706w;
                }
                if (i5 == ysVar2.xv) {
                    ysVar2 = ysVar2.f30704f;
                    i5 = ysVar2.f30706w;
                }
                j5 += min;
            }
            return true;
        }
        return false;
    }

    @Override // com.bytedance.sdk.component.xv.c.ux
    public InputStream f() {
        return new InputStream() { // from class: com.bytedance.sdk.component.xv.c.xv.1
            @Override // java.io.InputStream
            public int available() {
                return (int) Math.min(xv.this.f30701w, 2147483647L);
            }

            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }

            @Override // java.io.InputStream
            public int read() {
                xv xvVar = xv.this;
                if (xvVar.f30701w > 0) {
                    return xvVar.ev() & 255;
                }
                return -1;
            }

            public String toString() {
                return xv.this + ".inputStream()";
            }

            @Override // java.io.InputStream
            public int read(byte[] bArr, int i4, int i5) {
                return xv.this.c(bArr, i4, i5);
            }
        };
    }

    @Override // com.bytedance.sdk.component.xv.c.sr, com.bytedance.sdk.component.xv.c.s, java.io.Flushable
    public void flush() {
    }

    @Override // com.bytedance.sdk.component.xv.c.ux
    public String fp() throws EOFException {
        return ux(Long.MAX_VALUE);
    }

    /* renamed from: fz */
    public xv clone() {
        xv xvVar = new xv();
        if (this.f30701w == 0) {
            return xvVar;
        }
        ys c4 = this.f30700c.c();
        xvVar.f30700c = c4;
        c4.f30705r = c4;
        c4.f30704f = c4;
        ys ysVar = this.f30700c;
        while (true) {
            ysVar = ysVar.f30704f;
            if (ysVar != this.f30700c) {
                xvVar.f30700c.f30705r.c(ysVar.c());
            } else {
                xvVar.f30701w = this.f30701w;
                return xvVar;
            }
        }
    }

    public int hashCode() {
        ys ysVar = this.f30700c;
        if (ysVar == null) {
            return 0;
        }
        int i4 = 1;
        do {
            int i5 = ysVar.xv;
            for (int i6 = ysVar.f30706w; i6 < i5; i6++) {
                i4 = (i4 * 31) + ysVar.f30703c[i6];
            }
            ysVar = ysVar.f30704f;
        } while (ysVar != this.f30700c);
        return i4;
    }

    @Override // com.bytedance.sdk.component.xv.c.ux
    public byte[] ia() throws EOFException {
        try {
            return r(this.f30701w);
        } catch (EOFException e4) {
            throw e4;
        }
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return true;
    }

    @Override // com.bytedance.sdk.component.xv.c.ux
    public int p() {
        long j4 = this.f30701w;
        if (j4 >= 4) {
            ys ysVar = this.f30700c;
            int i4 = ysVar.f30706w;
            int i5 = ysVar.xv;
            if (i5 - i4 < 4) {
                return ((ev() & 255) << 24) | ((ev() & 255) << 16) | ((ev() & 255) << 8) | (ev() & 255);
            }
            byte[] bArr = ysVar.f30703c;
            int i6 = i4 + 1;
            int i7 = i6 + 1;
            int i8 = ((bArr[i4] & 255) << 24) | ((bArr[i6] & 255) << 16);
            int i9 = i7 + 1;
            int i10 = i8 | ((bArr[i7] & 255) << 8);
            int i11 = i9 + 1;
            int i12 = i10 | (bArr[i9] & 255);
            this.f30701w = j4 - 4;
            if (i11 == i5) {
                this.f30700c = ysVar.w();
                fp.c(ysVar);
            } else {
                ysVar.f30706w = i11;
            }
            return i12;
        }
        throw new IllegalStateException("size < 4: " + this.f30701w);
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) throws IOException {
        ys ysVar = this.f30700c;
        if (ysVar == null) {
            return -1;
        }
        int min = Math.min(byteBuffer.remaining(), ysVar.xv - ysVar.f30706w);
        byteBuffer.put(ysVar.f30703c, ysVar.f30706w, min);
        int i4 = ysVar.f30706w + min;
        ysVar.f30706w = i4;
        this.f30701w -= min;
        if (i4 == ysVar.xv) {
            this.f30700c = ysVar.w();
            fp.c(ysVar);
        }
        return min;
    }

    public final void s() {
        try {
            ev(this.f30701w);
        } catch (EOFException e4) {
            throw new AssertionError(e4);
        }
    }

    @Override // com.bytedance.sdk.component.xv.c.sr
    /* renamed from: sr */
    public xv i() {
        return this;
    }

    public String sr(long j4) throws EOFException {
        return c(j4, i.f30685c);
    }

    public f t() throws EOFException {
        return new f(ia());
    }

    public String toString() {
        return u().toString();
    }

    public final f u() {
        long j4 = this.f30701w;
        if (j4 <= 2147483647L) {
            return f((int) j4);
        }
        throw new IllegalArgumentException("size > Integer.MAX_VALUE: " + this.f30701w);
    }

    @Override // com.bytedance.sdk.component.xv.c.ux
    public boolean ux() {
        return this.f30701w == 0;
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer != null) {
            int remaining = byteBuffer.remaining();
            int i4 = remaining;
            while (i4 > 0) {
                ys ux = ux(1);
                int min = Math.min(i4, 8192 - ux.xv);
                byteBuffer.get(ux.f30703c, ux.xv, min);
                i4 -= min;
                ux.xv += min;
            }
            this.f30701w += remaining;
            return remaining;
        }
        throw new IllegalArgumentException("source == null");
    }

    @Override // com.bytedance.sdk.component.xv.c.sr
    public xv xv() {
        return this;
    }

    public String ys() {
        try {
            return c(this.f30701w, i.f30685c);
        } catch (EOFException e4) {
            throw new AssertionError(e4);
        }
    }

    @Override // com.bytedance.sdk.component.xv.c.ux
    public int a() {
        return i.c(p());
    }

    public final xv c(xv xvVar, long j4, long j5) {
        if (xvVar != null) {
            i.c(this.f30701w, j4, j5);
            if (j5 == 0) {
                return this;
            }
            xvVar.f30701w += j5;
            ys ysVar = this.f30700c;
            while (true) {
                int i4 = ysVar.xv;
                int i5 = ysVar.f30706w;
                if (j4 < i4 - i5) {
                    break;
                }
                j4 -= i4 - i5;
                ysVar = ysVar.f30704f;
            }
            while (j5 > 0) {
                ys c4 = ysVar.c();
                int i6 = (int) (c4.f30706w + j4);
                c4.f30706w = i6;
                c4.xv = Math.min(i6 + ((int) j5), c4.xv);
                ys ysVar2 = xvVar.f30700c;
                if (ysVar2 == null) {
                    c4.f30705r = c4;
                    c4.f30704f = c4;
                    xvVar.f30700c = c4;
                } else {
                    ysVar2.f30705r.c(c4);
                }
                j5 -= c4.xv - c4.f30706w;
                ysVar = ysVar.f30704f;
                j4 = 0;
            }
            return this;
        }
        throw new IllegalArgumentException("out == null");
    }

    @Override // com.bytedance.sdk.component.xv.c.ux
    public byte ev() {
        long j4 = this.f30701w;
        if (j4 != 0) {
            ys ysVar = this.f30700c;
            int i4 = ysVar.f30706w;
            int i5 = ysVar.xv;
            int i6 = i4 + 1;
            byte b4 = ysVar.f30703c[i4];
            this.f30701w = j4 - 1;
            if (i6 == i5) {
                this.f30700c = ysVar.w();
                fp.c(ysVar);
            } else {
                ysVar.f30706w = i6;
            }
            return b4;
        }
        throw new IllegalStateException("size == 0");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String f(long j4) throws EOFException {
        if (j4 > 0) {
            long j5 = j4 - 1;
            if (w(j5) == 13) {
                String sr = sr(j5);
                ev(2L);
                return sr;
            }
        }
        String sr2 = sr(j4);
        ev(1L);
        return sr2;
    }

    @Override // com.bytedance.sdk.component.xv.c.ux
    public short gd() {
        long j4 = this.f30701w;
        if (j4 >= 2) {
            ys ysVar = this.f30700c;
            int i4 = ysVar.f30706w;
            int i5 = ysVar.xv;
            if (i5 - i4 < 2) {
                return (short) (((ev() & 255) << 8) | (ev() & 255));
            }
            byte[] bArr = ysVar.f30703c;
            int i6 = i4 + 1;
            int i7 = i6 + 1;
            int i8 = ((bArr[i4] & 255) << 8) | (bArr[i6] & 255);
            this.f30701w = j4 - 2;
            if (i7 == i5) {
                this.f30700c = ysVar.w();
                fp.c(ysVar);
            } else {
                ysVar.f30706w = i7;
            }
            return (short) i8;
        }
        throw new IllegalStateException("size < 2: " + this.f30701w);
    }

    @Override // com.bytedance.sdk.component.xv.c.ux
    public short k() {
        return i.c(gd());
    }

    public final long r() {
        long j4 = this.f30701w;
        if (j4 == 0) {
            return 0L;
        }
        ys ysVar = this.f30700c.f30705r;
        int i4 = ysVar.xv;
        return (i4 >= 8192 || !ysVar.ux) ? j4 : j4 - (i4 - ysVar.f30706w);
    }

    @Override // com.bytedance.sdk.component.xv.c.sr
    /* renamed from: sr */
    public xv r(int i4) {
        ys ux = ux(4);
        byte[] bArr = ux.f30703c;
        int i5 = ux.xv;
        int i6 = i5 + 1;
        bArr[i5] = (byte) ((i4 >>> 24) & 255);
        int i7 = i6 + 1;
        bArr[i6] = (byte) ((i4 >>> 16) & 255);
        int i8 = i7 + 1;
        bArr[i7] = (byte) ((i4 >>> 8) & 255);
        bArr[i8] = (byte) (i4 & 255);
        ux.xv = i8 + 1;
        this.f30701w += 4;
        return this;
    }

    @Override // com.bytedance.sdk.component.xv.c.ux
    public String ux(long j4) throws EOFException {
        if (j4 >= 0) {
            long j5 = j4 != Long.MAX_VALUE ? j4 + 1 : Long.MAX_VALUE;
            long c4 = c((byte) 10, 0L, j5);
            if (c4 != -1) {
                return f(c4);
            }
            if (j5 < w() && w(j5 - 1) == 13 && w(j5) == 10) {
                return f(j5);
            }
            xv xvVar = new xv();
            c(xvVar, 0L, Math.min(32L, w()));
            throw new EOFException("\\n not found: limit=" + Math.min(w(), j4) + " content=" + xvVar.t().ux() + '\u2026');
        }
        throw new IllegalArgumentException("limit < 0: " + j4);
    }

    public final long w() {
        return this.f30701w;
    }

    @Override // com.bytedance.sdk.component.xv.c.ux
    public f xv(long j4) throws EOFException {
        return new f(r(j4));
    }

    public final byte w(long j4) {
        int i4;
        i.c(this.f30701w, j4, 1L);
        long j5 = this.f30701w;
        if (j5 - j4 > j4) {
            ys ysVar = this.f30700c;
            while (true) {
                int i5 = ysVar.xv;
                int i6 = ysVar.f30706w;
                long j6 = i5 - i6;
                if (j4 < j6) {
                    return ysVar.f30703c[i6 + ((int) j4)];
                }
                j4 -= j6;
                ysVar = ysVar.f30704f;
            }
        } else {
            long j7 = j4 - j5;
            try {
                ys ysVar2 = this.f30700c;
                do {
                    ysVar2 = ysVar2.f30705r;
                    int i7 = ysVar2.xv;
                    i4 = ysVar2.f30706w;
                    j7 += i7 - i4;
                } while (j7 < 0);
                return ysVar2.f30703c[i4 + ((int) j7)];
            } catch (NullPointerException unused) {
                return (byte) 0;
            }
        }
    }

    @Override // com.bytedance.sdk.component.xv.c.sr
    /* renamed from: xv */
    public xv ev(int i4) {
        ys ux = ux(2);
        byte[] bArr = ux.f30703c;
        int i5 = ux.xv;
        int i6 = i5 + 1;
        bArr[i5] = (byte) ((i4 >>> 8) & 255);
        bArr[i6] = (byte) (i4 & 255);
        ux.xv = i6 + 1;
        this.f30701w += 2;
        return this;
    }

    @Override // com.bytedance.sdk.component.xv.c.ux
    public byte[] r(long j4) throws EOFException {
        i.c(this.f30701w, 0L, j4);
        if (j4 <= 2147483647L) {
            byte[] bArr = new byte[(int) j4];
            c(bArr);
            return bArr;
        }
        throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j4);
    }

    public final f f(int i4) {
        if (i4 == 0) {
            return f.f30681w;
        }
        return new ia(this, i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ys ux(int i4) {
        if (i4 >= 1 && i4 <= 8192) {
            ys ysVar = this.f30700c;
            if (ysVar == null) {
                ys c4 = fp.c();
                this.f30700c = c4;
                c4.f30705r = c4;
                c4.f30704f = c4;
                return c4;
            }
            ys ysVar2 = ysVar.f30705r;
            return (ysVar2.xv + i4 > 8192 || !ysVar2.ux) ? ysVar2.c(fp.c()) : ysVar2;
        }
        throw new IllegalArgumentException();
    }

    @Override // com.bytedance.sdk.component.xv.c.ux
    public void ev(long j4) throws EOFException {
        ys ysVar;
        while (j4 > 0 && (ysVar = this.f30700c) != null) {
            int min = (int) Math.min(j4, ysVar.xv - ysVar.f30706w);
            long j5 = min;
            this.f30701w -= j5;
            j4 -= j5;
            ys ysVar2 = this.f30700c;
            int i4 = ysVar2.f30706w + min;
            ysVar2.f30706w = i4;
            if (i4 == ysVar2.xv) {
                this.f30700c = ysVar2.w();
                fp.c(ysVar2);
            }
        }
    }

    @Override // com.bytedance.sdk.component.xv.c.sr
    /* renamed from: w */
    public xv xv(byte[] bArr) {
        if (bArr != null) {
            return xv(bArr, 0, bArr.length);
        }
        throw new IllegalArgumentException("source == null");
    }

    @Override // com.bytedance.sdk.component.xv.c.ux
    public String c(Charset charset) {
        try {
            return c(this.f30701w, charset);
        } catch (EOFException e4) {
            throw new AssertionError(e4);
        }
    }

    @Override // com.bytedance.sdk.component.xv.c.sr
    /* renamed from: gd */
    public xv a(long j4) {
        if (j4 == 0) {
            return gd(48);
        }
        boolean z3 = false;
        int i4 = 1;
        if (j4 < 0) {
            j4 = -j4;
            if (j4 < 0) {
                return w("-9223372036854775808");
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
        ys ux = ux(i4);
        byte[] bArr = ux.f30703c;
        int i5 = ux.xv + i4;
        while (j4 != 0) {
            i5--;
            bArr[i5] = xv[(int) (j4 % 10)];
            j4 /= 10;
        }
        if (z3) {
            bArr[i5 - 1] = 45;
        }
        ux.xv += i4;
        this.f30701w += i4;
        return this;
    }

    @Override // com.bytedance.sdk.component.xv.c.sr
    /* renamed from: w */
    public xv xv(byte[] bArr, int i4, int i5) {
        if (bArr != null) {
            long j4 = i5;
            i.c(bArr.length, i4, j4);
            int i6 = i5 + i4;
            while (i4 < i6) {
                ys ux = ux(1);
                int min = Math.min(i6 - i4, 8192 - ux.xv);
                System.arraycopy(bArr, i4, ux.f30703c, ux.xv, min);
                i4 += min;
                ux.xv += min;
            }
            this.f30701w += j4;
            return this;
        }
        throw new IllegalArgumentException("source == null");
    }

    @Override // com.bytedance.sdk.component.xv.c.sr
    /* renamed from: p */
    public xv k(long j4) {
        if (j4 == 0) {
            return gd(48);
        }
        int numberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j4)) / 4) + 1;
        ys ux = ux(numberOfTrailingZeros);
        byte[] bArr = ux.f30703c;
        int i4 = ux.xv;
        for (int i5 = (i4 + numberOfTrailingZeros) - 1; i5 >= i4; i5--) {
            bArr[i5] = xv[(int) (15 & j4)];
            j4 >>>= 4;
        }
        ux.xv += numberOfTrailingZeros;
        this.f30701w += numberOfTrailingZeros;
        return this;
    }

    public String c(long j4, Charset charset) throws EOFException {
        i.c(this.f30701w, 0L, j4);
        if (charset != null) {
            if (j4 > 2147483647L) {
                throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j4);
            } else if (j4 == 0) {
                return "";
            } else {
                ys ysVar = this.f30700c;
                int i4 = ysVar.f30706w;
                if (i4 + j4 > ysVar.xv) {
                    return new String(r(j4), charset);
                }
                String str = new String(ysVar.f30703c, i4, (int) j4, charset);
                int i5 = (int) (ysVar.f30706w + j4);
                ysVar.f30706w = i5;
                this.f30701w -= j4;
                if (i5 == ysVar.xv) {
                    this.f30700c = ysVar.w();
                    fp.c(ysVar);
                }
                return str;
            }
        }
        throw new IllegalArgumentException("charset == null");
    }

    @Override // com.bytedance.sdk.component.xv.c.sr
    /* renamed from: w */
    public xv gd(int i4) {
        ys ux = ux(1);
        byte[] bArr = ux.f30703c;
        int i5 = ux.xv;
        ux.xv = i5 + 1;
        bArr[i5] = (byte) i4;
        this.f30701w++;
        return this;
    }

    @Override // com.bytedance.sdk.component.xv.c.ux
    public void c(byte[] bArr) throws EOFException {
        int i4 = 0;
        while (i4 < bArr.length) {
            int c4 = c(bArr, i4, bArr.length - i4);
            if (c4 == -1) {
                throw new EOFException();
            }
            i4 += c4;
        }
    }

    public int c(byte[] bArr, int i4, int i5) {
        i.c(bArr.length, i4, i5);
        ys ysVar = this.f30700c;
        if (ysVar == null) {
            return -1;
        }
        int min = Math.min(i5, ysVar.xv - ysVar.f30706w);
        System.arraycopy(ysVar.f30703c, ysVar.f30706w, bArr, i4, min);
        int i6 = ysVar.f30706w + min;
        ysVar.f30706w = i6;
        this.f30701w -= min;
        if (i6 == ysVar.xv) {
            this.f30700c = ysVar.w();
            fp.c(ysVar);
        }
        return min;
    }

    @Override // com.bytedance.sdk.component.xv.c.sr
    /* renamed from: c */
    public xv w(f fVar) {
        if (fVar != null) {
            fVar.c(this);
            return this;
        }
        throw new IllegalArgumentException("byteString == null");
    }

    @Override // com.bytedance.sdk.component.xv.c.sr
    /* renamed from: c */
    public xv w(String str) {
        return c(str, 0, str.length());
    }

    public xv c(String str, int i4, int i5) {
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
                        ys ux = ux(1);
                        byte[] bArr = ux.f30703c;
                        int i6 = ux.xv - i4;
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
                        int i8 = ux.xv;
                        int i9 = (i6 + i7) - i8;
                        ux.xv = i8 + i9;
                        this.f30701w += i9;
                        i4 = i7;
                    } else {
                        if (charAt < '\u0800') {
                            gd((charAt >> 6) | 192);
                            gd((charAt & '?') | 128);
                        } else if (charAt >= '\ud800' && charAt <= '\udfff') {
                            int i10 = i4 + 1;
                            char charAt3 = i10 < i5 ? str.charAt(i10) : (char) 0;
                            if (charAt <= '\udbff' && charAt3 >= '\udc00' && charAt3 <= '\udfff') {
                                int i11 = (((charAt & '\u27ff') << 10) | ('\u23ff' & charAt3)) + 65536;
                                gd((i11 >> 18) | 240);
                                gd(((i11 >> 12) & 63) | 128);
                                gd(((i11 >> 6) & 63) | 128);
                                gd((i11 & 63) | 128);
                                i4 += 2;
                            } else {
                                gd(63);
                                i4 = i10;
                            }
                        } else {
                            gd((charAt >> '\f') | 224);
                            gd(((charAt >> 6) & 63) | 128);
                            gd((charAt & '?') | 128);
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

    public xv c(int i4) {
        if (i4 < 128) {
            gd(i4);
        } else if (i4 < 2048) {
            gd((i4 >> 6) | 192);
            gd((i4 & 63) | 128);
        } else if (i4 < 65536) {
            if (i4 >= 55296 && i4 <= 57343) {
                gd(63);
            } else {
                gd((i4 >> 12) | 224);
                gd(((i4 >> 6) & 63) | 128);
                gd((i4 & 63) | 128);
            }
        } else if (i4 <= 1114111) {
            gd((i4 >> 18) | 240);
            gd(((i4 >> 12) & 63) | 128);
            gd(((i4 >> 6) & 63) | 128);
            gd((i4 & 63) | 128);
        } else {
            throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i4));
        }
        return this;
    }

    public xv c(String str, int i4, int i5, Charset charset) {
        if (str != null) {
            if (i4 < 0) {
                throw new IllegalAccessError("beginIndex < 0: " + i4);
            } else if (i5 >= i4) {
                if (i5 <= str.length()) {
                    if (charset != null) {
                        if (charset.equals(i.f30685c)) {
                            return c(str, i4, i5);
                        }
                        byte[] bytes = str.substring(i4, i5).getBytes(charset);
                        return xv(bytes, 0, bytes.length);
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

    public long c(fz fzVar) throws IOException {
        if (fzVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j4 = 0;
        while (true) {
            long c4 = fzVar.c(this, 8192L);
            if (c4 == -1) {
                return j4;
            }
            j4 += c4;
        }
    }

    @Override // com.bytedance.sdk.component.xv.c.fz
    public long c(xv xvVar, long j4) {
        if (xvVar != null) {
            if (j4 >= 0) {
                long j5 = this.f30701w;
                if (j5 == 0) {
                    return -1L;
                }
                if (j4 > j5) {
                    j4 = j5;
                }
                xvVar.a_(this, j4);
                return j4;
            }
            throw new IllegalArgumentException("byteCount < 0: " + j4);
        }
        throw new IllegalArgumentException("sink == null");
    }

    @Override // com.bytedance.sdk.component.xv.c.ux
    public long c(byte b4) {
        return c(b4, 0L, Long.MAX_VALUE);
    }

    public long c(byte b4, long j4, long j5) {
        ys ysVar;
        long j6 = 0;
        if (j4 >= 0 && j5 >= j4) {
            long j7 = this.f30701w;
            long j8 = j5 > j7 ? j7 : j5;
            if (j4 == j8 || (ysVar = this.f30700c) == null) {
                return -1L;
            }
            if (j7 - j4 < j4) {
                while (j7 > j4) {
                    ysVar = ysVar.f30705r;
                    j7 -= ysVar.xv - ysVar.f30706w;
                }
            } else {
                while (true) {
                    long j9 = (ysVar.xv - ysVar.f30706w) + j6;
                    if (j9 >= j4) {
                        break;
                    }
                    ysVar = ysVar.f30704f;
                    j6 = j9;
                }
                j7 = j6;
            }
            long j10 = j4;
            while (j7 < j8) {
                byte[] bArr = ysVar.f30703c;
                int min = (int) Math.min(ysVar.xv, (ysVar.f30706w + j8) - j7);
                for (int i4 = (int) ((ysVar.f30706w + j10) - j7); i4 < min; i4++) {
                    if (bArr[i4] == b4) {
                        return (i4 - ysVar.f30706w) + j7;
                    }
                }
                j7 += ysVar.xv - ysVar.f30706w;
                ysVar = ysVar.f30704f;
                j10 = j7;
            }
            return -1L;
        }
        throw new IllegalArgumentException(String.format("size=%s fromIndex=%s toIndex=%s", Long.valueOf(this.f30701w), Long.valueOf(j4), Long.valueOf(j5)));
    }

    @Override // com.bytedance.sdk.component.xv.c.ux
    public boolean c(long j4, f fVar) {
        return c(j4, fVar, 0, fVar.r());
    }

    public boolean c(long j4, f fVar, int i4, int i5) {
        if (j4 < 0 || i4 < 0 || i5 < 0 || this.f30701w - j4 < i5 || fVar.r() - i4 < i5) {
            return false;
        }
        for (int i6 = 0; i6 < i5; i6++) {
            if (w(i6 + j4) != fVar.c(i4 + i6)) {
                return false;
            }
        }
        return true;
    }

    @Override // com.bytedance.sdk.component.xv.c.s
    public u c() {
        return u.xv;
    }
}
