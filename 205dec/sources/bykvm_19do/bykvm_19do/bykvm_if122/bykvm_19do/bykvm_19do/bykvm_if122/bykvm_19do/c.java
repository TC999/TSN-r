package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do;

import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;

/* compiled from: Buffer.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public final class c implements e, d, Cloneable, ByteChannel {

    /* renamed from: c  reason: collision with root package name */
    private static final byte[] f796c = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};

    /* renamed from: a  reason: collision with root package name */
    o f797a;

    /* renamed from: b  reason: collision with root package name */
    long f798b;

    public final c a(c cVar, long j4, long j5) {
        if (cVar != null) {
            u.a(this.f798b, j4, j5);
            if (j5 == 0) {
                return this;
            }
            cVar.f798b += j5;
            o oVar = this.f797a;
            while (true) {
                long j6 = oVar.f830c - oVar.f829b;
                if (j4 < j6) {
                    break;
                }
                j4 -= j6;
                oVar = oVar.f833f;
            }
            while (j5 > 0) {
                o c4 = oVar.c();
                int i4 = (int) (c4.f829b + j4);
                c4.f829b = i4;
                c4.f830c = Math.min(i4 + ((int) j5), c4.f830c);
                o oVar2 = cVar.f797a;
                if (oVar2 == null) {
                    c4.f834g = c4;
                    c4.f833f = c4;
                    cVar.f797a = c4;
                } else {
                    oVar2.f834g.a(c4);
                }
                j5 -= c4.f830c - c4.f829b;
                oVar = oVar.f833f;
                j4 = 0;
            }
            return this;
        }
        throw new IllegalArgumentException("out == null");
    }

    public final long b() {
        long j4 = this.f798b;
        if (j4 == 0) {
            return 0L;
        }
        o oVar = this.f797a.f834g;
        int i4 = oVar.f830c;
        return (i4 >= 8192 || !oVar.f832e) ? j4 : j4 - (i4 - oVar.f829b);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e
    public void c(long j4) throws EOFException {
        if (this.f798b < j4) {
            throw new EOFException();
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.s, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    public String e() {
        try {
            return a(this.f798b, u.f843a);
        } catch (EOFException e4) {
            throw new AssertionError(e4);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof c) {
            c cVar = (c) obj;
            long j4 = this.f798b;
            if (j4 != cVar.f798b) {
                return false;
            }
            long j5 = 0;
            if (j4 == 0) {
                return true;
            }
            o oVar = this.f797a;
            o oVar2 = cVar.f797a;
            int i4 = oVar.f829b;
            int i5 = oVar2.f829b;
            while (j5 < this.f798b) {
                long min = Math.min(oVar.f830c - i4, oVar2.f830c - i5);
                int i6 = 0;
                while (i6 < min) {
                    int i7 = i4 + 1;
                    int i8 = i5 + 1;
                    if (oVar.f828a[i4] != oVar2.f828a[i5]) {
                        return false;
                    }
                    i6++;
                    i4 = i7;
                    i5 = i8;
                }
                if (i4 == oVar.f830c) {
                    oVar = oVar.f833f;
                    i4 = oVar.f829b;
                }
                if (i5 == oVar2.f830c) {
                    oVar2 = oVar2.f833f;
                    i5 = oVar2.f829b;
                }
                j5 += min;
            }
            return true;
        }
        return false;
    }

    public final long f() {
        return this.f798b;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.d, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.r, java.io.Flushable
    public void flush() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String h(long j4) throws EOFException {
        if (j4 > 0) {
            long j5 = j4 - 1;
            if (a(j5) == 13) {
                String b4 = b(j5);
                skip(2L);
                return b4;
            }
        }
        String b5 = b(j4);
        skip(1L);
        return b5;
    }

    public int hashCode() {
        o oVar = this.f797a;
        if (oVar == null) {
            return 0;
        }
        int i4 = 1;
        do {
            int i5 = oVar.f830c;
            for (int i6 = oVar.f829b; i6 < i5; i6++) {
                i4 = (i4 * 31) + oVar.f828a[i6];
            }
            oVar = oVar.f833f;
        } while (oVar != this.f797a);
        return i4;
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return true;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.d
    public c o() {
        return this;
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) throws IOException {
        o oVar = this.f797a;
        if (oVar == null) {
            return -1;
        }
        int min = Math.min(byteBuffer.remaining(), oVar.f830c - oVar.f829b);
        byteBuffer.put(oVar.f828a, oVar.f829b, min);
        int i4 = oVar.f829b + min;
        oVar.f829b = i4;
        this.f798b -= min;
        if (i4 == oVar.f830c) {
            this.f797a = oVar.b();
            p.a(oVar);
        }
        return min;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e
    public byte readByte() {
        long j4 = this.f798b;
        if (j4 != 0) {
            o oVar = this.f797a;
            int i4 = oVar.f829b;
            int i5 = oVar.f830c;
            int i6 = i4 + 1;
            byte b4 = oVar.f828a[i4];
            this.f798b = j4 - 1;
            if (i6 == i5) {
                this.f797a = oVar.b();
                p.a(oVar);
            } else {
                oVar.f829b = i6;
            }
            return b4;
        }
        throw new IllegalStateException("size == 0");
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e
    public void readFully(byte[] bArr) throws EOFException {
        int i4 = 0;
        while (i4 < bArr.length) {
            int a4 = a(bArr, i4, bArr.length - i4);
            if (a4 == -1) {
                throw new EOFException();
            }
            i4 += a4;
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e
    public int readInt() {
        long j4 = this.f798b;
        if (j4 >= 4) {
            o oVar = this.f797a;
            int i4 = oVar.f829b;
            int i5 = oVar.f830c;
            if (i5 - i4 < 4) {
                return ((readByte() & 255) << 24) | ((readByte() & 255) << 16) | ((readByte() & 255) << 8) | (readByte() & 255);
            }
            byte[] bArr = oVar.f828a;
            int i6 = i4 + 1;
            int i7 = i6 + 1;
            int i8 = ((bArr[i4] & 255) << 24) | ((bArr[i6] & 255) << 16);
            int i9 = i7 + 1;
            int i10 = i8 | ((bArr[i7] & 255) << 8);
            int i11 = i9 + 1;
            int i12 = i10 | (bArr[i9] & 255);
            this.f798b = j4 - 4;
            if (i11 == i5) {
                this.f797a = oVar.b();
                p.a(oVar);
            } else {
                oVar.f829b = i11;
            }
            return i12;
        }
        throw new IllegalStateException("size < 4: " + this.f798b);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e
    public short readShort() {
        long j4 = this.f798b;
        if (j4 >= 2) {
            o oVar = this.f797a;
            int i4 = oVar.f829b;
            int i5 = oVar.f830c;
            if (i5 - i4 < 2) {
                return (short) (((readByte() & 255) << 8) | (readByte() & 255));
            }
            byte[] bArr = oVar.f828a;
            int i6 = i4 + 1;
            int i7 = i6 + 1;
            int i8 = ((bArr[i4] & 255) << 8) | (bArr[i6] & 255);
            this.f798b = j4 - 2;
            if (i7 == i5) {
                this.f797a = oVar.b();
                p.a(oVar);
            } else {
                oVar.f829b = i7;
            }
            return (short) i8;
        }
        throw new IllegalStateException("size < 2: " + this.f798b);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e
    public void skip(long j4) throws EOFException {
        o oVar;
        while (j4 > 0) {
            if (this.f797a != null) {
                int min = (int) Math.min(j4, oVar.f830c - oVar.f829b);
                long j5 = min;
                this.f798b -= j5;
                j4 -= j5;
                o oVar2 = this.f797a;
                int i4 = oVar2.f829b + min;
                oVar2.f829b = i4;
                if (i4 == oVar2.f830c) {
                    this.f797a = oVar2.b();
                    p.a(oVar2);
                }
            } else {
                throw new EOFException();
            }
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.s
    public t t() {
        return t.f839d;
    }

    public String toString() {
        return g().toString();
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e
    public short u() {
        return u.a(readShort());
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e
    public String v() throws EOFException {
        return e(Long.MAX_VALUE);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e
    public int w() {
        return u.a(readInt());
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e
    public boolean x() {
        return this.f798b == 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00a5 A[EDGE_INSN: B:43:0x00a5->B:38:0x00a5 ?: BREAK  , SYNTHETIC] */
    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long y() {
        /*
            r15 = this;
            long r0 = r15.f798b
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto Lac
            r0 = 0
            r4 = r2
            r1 = 0
        Lb:
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.o r6 = r15.f797a
            byte[] r7 = r6.f828a
            int r8 = r6.f829b
            int r9 = r6.f830c
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
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c r0 = r0.g(r4)
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c r0 = r0.writeByte(r10)
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Number too large: "
            r2.append(r3)
            java.lang.String r0 = r0.e()
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
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.o r7 = r6.b()
            r15.f797a = r7
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.p.a(r6)
            goto L9f
        L9d:
            r6.f829b = r8
        L9f:
            if (r1 != 0) goto La5
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.o r6 = r15.f797a
            if (r6 != 0) goto Lb
        La5:
            long r1 = r15.f798b
            long r6 = (long) r0
            long r1 = r1 - r6
            r15.f798b = r1
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
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c.y():long");
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.d
    public c z() {
        return this;
    }

    public byte[] c() {
        try {
            return f(this.f798b);
        } catch (EOFException e4) {
            throw new AssertionError(e4);
        }
    }

    /* renamed from: clone */
    public c m7clone() {
        c cVar = new c();
        if (this.f798b == 0) {
            return cVar;
        }
        o c4 = this.f797a.c();
        cVar.f797a = c4;
        c4.f834g = c4;
        c4.f833f = c4;
        for (o oVar = this.f797a.f833f; oVar != this.f797a; oVar = oVar.f833f) {
            cVar.f797a.f834g.a(oVar.c());
        }
        cVar.f798b = this.f798b;
        return cVar;
    }

    public f d() {
        return new f(c());
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e
    public byte[] f(long j4) throws EOFException {
        u.a(this.f798b, 0L, j4);
        if (j4 <= 2147483647L) {
            byte[] bArr = new byte[(int) j4];
            readFully(bArr);
            return bArr;
        }
        throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j4);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.d
    public c g(long j4) {
        if (j4 == 0) {
            return writeByte(48);
        }
        int numberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j4)) / 4) + 1;
        o b4 = b(numberOfTrailingZeros);
        byte[] bArr = b4.f828a;
        int i4 = b4.f830c;
        for (int i5 = (i4 + numberOfTrailingZeros) - 1; i5 >= i4; i5--) {
            bArr[i5] = f796c[(int) (15 & j4)];
            j4 >>>= 4;
        }
        b4.f830c += numberOfTrailingZeros;
        this.f798b += numberOfTrailingZeros;
        return this;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.d
    public c writeByte(int i4) {
        o b4 = b(1);
        byte[] bArr = b4.f828a;
        int i5 = b4.f830c;
        b4.f830c = i5 + 1;
        bArr[i5] = (byte) i4;
        this.f798b++;
        return this;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.d
    public c writeInt(int i4) {
        o b4 = b(4);
        byte[] bArr = b4.f828a;
        int i5 = b4.f830c;
        int i6 = i5 + 1;
        bArr[i5] = (byte) ((i4 >>> 24) & 255);
        int i7 = i6 + 1;
        bArr[i6] = (byte) ((i4 >>> 16) & 255);
        int i8 = i7 + 1;
        bArr[i7] = (byte) ((i4 >>> 8) & 255);
        bArr[i8] = (byte) (i4 & 255);
        b4.f830c = i8 + 1;
        this.f798b += 4;
        return this;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.d
    public c writeShort(int i4) {
        o b4 = b(2);
        byte[] bArr = b4.f828a;
        int i5 = b4.f830c;
        int i6 = i5 + 1;
        bArr[i5] = (byte) ((i4 >>> 8) & 255);
        bArr[i6] = (byte) (i4 & 255);
        b4.f830c = i6 + 1;
        this.f798b += 2;
        return this;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e
    public f d(long j4) throws EOFException {
        return new f(f(j4));
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e
    public String e(long j4) throws EOFException {
        if (j4 >= 0) {
            long j5 = j4 != Long.MAX_VALUE ? j4 + 1 : Long.MAX_VALUE;
            long a4 = a((byte) 10, 0L, j5);
            if (a4 != -1) {
                return h(a4);
            }
            if (j5 < f() && a(j5 - 1) == 13 && a(j5) == 10) {
                return h(j5);
            }
            c cVar = new c();
            a(cVar, 0L, Math.min(32L, f()));
            throw new EOFException("\\n not found: limit=" + Math.min(f(), j4) + " content=" + cVar.d().b() + '\u2026');
        }
        throw new IllegalArgumentException("limit < 0: " + j4);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.d
    public c write(byte[] bArr) {
        if (bArr != null) {
            return write(bArr, 0, bArr.length);
        }
        throw new IllegalArgumentException("source == null");
    }

    public c c(int i4) {
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

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.d
    public c d(String str) {
        return a(str, 0, str.length());
    }

    public String b(long j4) throws EOFException {
        return a(j4, u.f843a);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.d
    public c write(byte[] bArr, int i4, int i5) {
        if (bArr != null) {
            long j4 = i5;
            u.a(bArr.length, i4, j4);
            int i6 = i5 + i4;
            while (i4 < i6) {
                o b4 = b(1);
                int min = Math.min(i6 - i4, 8192 - b4.f830c);
                System.arraycopy(bArr, i4, b4.f828a, b4.f830c, min);
                i4 += min;
                b4.f830c += min;
            }
            this.f798b += j4;
            return this;
        }
        throw new IllegalArgumentException("source == null");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public o b(int i4) {
        if (i4 >= 1 && i4 <= 8192) {
            o oVar = this.f797a;
            if (oVar == null) {
                o a4 = p.a();
                this.f797a = a4;
                a4.f834g = a4;
                a4.f833f = a4;
                return a4;
            }
            o oVar2 = oVar.f834g;
            return (oVar2.f830c + i4 > 8192 || !oVar2.f832e) ? oVar2.a(p.a()) : oVar2;
        }
        throw new IllegalArgumentException();
    }

    public final f g() {
        long j4 = this.f798b;
        if (j4 <= 2147483647L) {
            return a((int) j4);
        }
        throw new IllegalArgumentException("size > Integer.MAX_VALUE: " + this.f798b);
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer != null) {
            int remaining = byteBuffer.remaining();
            int i4 = remaining;
            while (i4 > 0) {
                o b4 = b(1);
                int min = Math.min(i4, 8192 - b4.f830c);
                byteBuffer.get(b4.f828a, b4.f830c, min);
                i4 -= min;
                b4.f830c += min;
            }
            this.f798b += remaining;
            return remaining;
        }
        throw new IllegalArgumentException("source == null");
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.r
    public void b(c cVar, long j4) {
        if (cVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (cVar != this) {
            u.a(cVar.f798b, 0L, j4);
            while (j4 > 0) {
                o oVar = cVar.f797a;
                if (j4 < oVar.f830c - oVar.f829b) {
                    o oVar2 = this.f797a;
                    o oVar3 = oVar2 != null ? oVar2.f834g : null;
                    if (oVar3 != null && oVar3.f832e) {
                        if ((oVar3.f830c + j4) - (oVar3.f831d ? 0 : oVar3.f829b) <= 8192) {
                            oVar.a(oVar3, (int) j4);
                            cVar.f798b -= j4;
                            this.f798b += j4;
                            return;
                        }
                    }
                    cVar.f797a = oVar.a((int) j4);
                }
                o oVar4 = cVar.f797a;
                long j5 = oVar4.f830c - oVar4.f829b;
                cVar.f797a = oVar4.b();
                o oVar5 = this.f797a;
                if (oVar5 == null) {
                    this.f797a = oVar4;
                    oVar4.f834g = oVar4;
                    oVar4.f833f = oVar4;
                } else {
                    oVar5.f834g.a(oVar4).a();
                }
                cVar.f798b -= j5;
                this.f798b += j5;
                j4 -= j5;
            }
            return;
        }
        throw new IllegalArgumentException("source == this");
    }

    public final byte a(long j4) {
        u.a(this.f798b, j4, 1L);
        long j5 = this.f798b;
        if (j5 - j4 > j4) {
            o oVar = this.f797a;
            while (true) {
                int i4 = oVar.f830c;
                int i5 = oVar.f829b;
                long j6 = i4 - i5;
                if (j4 < j6) {
                    return oVar.f828a[i5 + ((int) j4)];
                }
                j4 -= j6;
                oVar = oVar.f833f;
            }
        } else {
            long j7 = j4 - j5;
            o oVar2 = this.f797a.f834g;
            while (true) {
                int i6 = oVar2.f830c;
                int i7 = oVar2.f829b;
                j7 += i6 - i7;
                if (j7 >= 0) {
                    return oVar2.f828a[i7 + ((int) j7)];
                }
                oVar2 = oVar2.f834g;
            }
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e
    public String a(Charset charset) {
        try {
            return a(this.f798b, charset);
        } catch (EOFException e4) {
            throw new AssertionError(e4);
        }
    }

    public String a(long j4, Charset charset) throws EOFException {
        u.a(this.f798b, 0L, j4);
        if (charset != null) {
            if (j4 > 2147483647L) {
                throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j4);
            } else if (j4 == 0) {
                return "";
            } else {
                o oVar = this.f797a;
                int i4 = oVar.f829b;
                if (i4 + j4 > oVar.f830c) {
                    return new String(f(j4), charset);
                }
                String str = new String(oVar.f828a, i4, (int) j4, charset);
                int i5 = (int) (oVar.f829b + j4);
                oVar.f829b = i5;
                this.f798b -= j4;
                if (i5 == oVar.f830c) {
                    this.f797a = oVar.b();
                    p.a(oVar);
                }
                return str;
            }
        }
        throw new IllegalArgumentException("charset == null");
    }

    public int a(byte[] bArr, int i4, int i5) {
        u.a(bArr.length, i4, i5);
        o oVar = this.f797a;
        if (oVar == null) {
            return -1;
        }
        int min = Math.min(i5, oVar.f830c - oVar.f829b);
        System.arraycopy(oVar.f828a, oVar.f829b, bArr, i4, min);
        int i6 = oVar.f829b + min;
        oVar.f829b = i6;
        this.f798b -= min;
        if (i6 == oVar.f830c) {
            this.f797a = oVar.b();
            p.a(oVar);
        }
        return min;
    }

    public final void a() {
        try {
            skip(this.f798b);
        } catch (EOFException e4) {
            throw new AssertionError(e4);
        }
    }

    public c a(f fVar) {
        if (fVar != null) {
            fVar.a(this);
            return this;
        }
        throw new IllegalArgumentException("byteString == null");
    }

    public c a(String str, int i4, int i5) {
        char charAt;
        if (str != null) {
            if (i4 < 0) {
                throw new IllegalArgumentException("beginIndex < 0: " + i4);
            } else if (i5 >= i4) {
                if (i5 > str.length()) {
                    throw new IllegalArgumentException("endIndex > string.length: " + i5 + " > " + str.length());
                }
                while (i4 < i5) {
                    char charAt2 = str.charAt(i4);
                    if (charAt2 < '\u0080') {
                        o b4 = b(1);
                        byte[] bArr = b4.f828a;
                        int i6 = b4.f830c - i4;
                        int min = Math.min(i5, 8192 - i6);
                        int i7 = i4 + 1;
                        bArr[i4 + i6] = (byte) charAt2;
                        while (true) {
                            i4 = i7;
                            if (i4 >= min || (charAt = str.charAt(i4)) >= '\u0080') {
                                break;
                            }
                            i7 = i4 + 1;
                            bArr[i4 + i6] = (byte) charAt;
                        }
                        int i8 = b4.f830c;
                        int i9 = (i6 + i4) - i8;
                        b4.f830c = i8 + i9;
                        this.f798b += i9;
                    } else {
                        if (charAt2 < '\u0800') {
                            writeByte((charAt2 >> 6) | 192);
                            writeByte((charAt2 & '?') | 128);
                        } else if (charAt2 >= '\ud800' && charAt2 <= '\udfff') {
                            int i10 = i4 + 1;
                            char charAt3 = i10 < i5 ? str.charAt(i10) : (char) 0;
                            if (charAt2 <= '\udbff' && charAt3 >= '\udc00' && charAt3 <= '\udfff') {
                                int i11 = (((charAt2 & '\u27ff') << 10) | ('\u23ff' & charAt3)) + 65536;
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
                            writeByte((charAt2 >> '\f') | 224);
                            writeByte(((charAt2 >> 6) & 63) | 128);
                            writeByte((charAt2 & '?') | 128);
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

    public c a(String str, int i4, int i5, Charset charset) {
        if (str != null) {
            if (i4 < 0) {
                throw new IllegalAccessError("beginIndex < 0: " + i4);
            } else if (i5 >= i4) {
                if (i5 <= str.length()) {
                    if (charset != null) {
                        if (charset.equals(u.f843a)) {
                            return a(str, i4, i5);
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

    public long a(s sVar) throws IOException {
        if (sVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j4 = 0;
        while (true) {
            long a4 = sVar.a(this, 8192L);
            if (a4 == -1) {
                return j4;
            }
            j4 += a4;
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.s
    public long a(c cVar, long j4) {
        if (cVar != null) {
            if (j4 >= 0) {
                long j5 = this.f798b;
                if (j5 == 0) {
                    return -1L;
                }
                if (j4 > j5) {
                    j4 = j5;
                }
                cVar.b(this, j4);
                return j4;
            }
            throw new IllegalArgumentException("byteCount < 0: " + j4);
        }
        throw new IllegalArgumentException("sink == null");
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e
    public long a(byte b4) {
        return a(b4, 0L, Long.MAX_VALUE);
    }

    public long a(byte b4, long j4, long j5) {
        o oVar;
        long j6 = 0;
        if (j4 >= 0 && j5 >= j4) {
            long j7 = this.f798b;
            long j8 = j5 > j7 ? j7 : j5;
            if (j4 == j8 || (oVar = this.f797a) == null) {
                return -1L;
            }
            if (j7 - j4 < j4) {
                while (j7 > j4) {
                    oVar = oVar.f834g;
                    j7 -= oVar.f830c - oVar.f829b;
                }
            } else {
                while (true) {
                    long j9 = (oVar.f830c - oVar.f829b) + j6;
                    if (j9 >= j4) {
                        break;
                    }
                    oVar = oVar.f833f;
                    j6 = j9;
                }
                j7 = j6;
            }
            long j10 = j4;
            while (j7 < j8) {
                byte[] bArr = oVar.f828a;
                int min = (int) Math.min(oVar.f830c, (oVar.f829b + j8) - j7);
                for (int i4 = (int) ((oVar.f829b + j10) - j7); i4 < min; i4++) {
                    if (bArr[i4] == b4) {
                        return (i4 - oVar.f829b) + j7;
                    }
                }
                j7 += oVar.f830c - oVar.f829b;
                oVar = oVar.f833f;
                j10 = j7;
            }
            return -1L;
        }
        throw new IllegalArgumentException(String.format("size=%s fromIndex=%s toIndex=%s", Long.valueOf(this.f798b), Long.valueOf(j4), Long.valueOf(j5)));
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e
    public boolean a(long j4, f fVar) {
        return a(j4, fVar, 0, fVar.e());
    }

    public boolean a(long j4, f fVar, int i4, int i5) {
        if (j4 < 0 || i4 < 0 || i5 < 0 || this.f798b - j4 < i5 || fVar.e() - i4 < i5) {
            return false;
        }
        for (int i6 = 0; i6 < i5; i6++) {
            if (a(i6 + j4) != fVar.a(i4 + i6)) {
                return false;
            }
        }
        return true;
    }

    public final f a(int i4) {
        if (i4 == 0) {
            return f.f800e;
        }
        return new q(this, i4);
    }
}
