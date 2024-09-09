package com.bytedance.sdk.component.w.c.w;

import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class c implements w, xv, Cloneable, ByteChannel {
    private static final byte[] xv = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};

    /* renamed from: c  reason: collision with root package name */
    f f30436c;

    /* renamed from: w  reason: collision with root package name */
    long f30437w;

    public boolean c() {
        return this.f30437w == 0;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
    public void close() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof c) {
            c cVar = (c) obj;
            long j4 = this.f30437w;
            if (j4 != cVar.f30437w) {
                return false;
            }
            long j5 = 0;
            if (j4 == 0) {
                return true;
            }
            f fVar = this.f30436c;
            f fVar2 = cVar.f30436c;
            int i4 = fVar.f30442w;
            int i5 = fVar2.f30442w;
            while (j5 < this.f30437w) {
                long min = Math.min(fVar.xv - i4, fVar2.xv - i5);
                int i6 = 0;
                while (i6 < min) {
                    int i7 = i4 + 1;
                    int i8 = i5 + 1;
                    if (fVar.f30439c[i4] != fVar2.f30439c[i5]) {
                        return false;
                    }
                    i6++;
                    i4 = i7;
                    i5 = i8;
                }
                if (i4 == fVar.xv) {
                    fVar = fVar.f30440f;
                    i4 = fVar.f30442w;
                }
                if (i5 == fVar2.xv) {
                    fVar2 = fVar2.f30440f;
                    i5 = fVar2.f30442w;
                }
                j5 += min;
            }
            return true;
        }
        return false;
    }

    @Override // java.io.Flushable
    public void flush() {
    }

    public int hashCode() {
        f fVar = this.f30436c;
        if (fVar == null) {
            return 0;
        }
        int i4 = 1;
        do {
            int i5 = fVar.xv;
            for (int i6 = fVar.f30442w; i6 < i5; i6++) {
                i4 = (i4 * 31) + fVar.f30439c[i6];
            }
            fVar = fVar.f30440f;
        } while (fVar != this.f30436c);
        return i4;
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return true;
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) throws IOException {
        f fVar = this.f30436c;
        if (fVar == null) {
            return -1;
        }
        int min = Math.min(byteBuffer.remaining(), fVar.xv - fVar.f30442w);
        byteBuffer.put(fVar.f30439c, fVar.f30442w, min);
        int i4 = fVar.f30442w + min;
        fVar.f30442w = i4;
        this.f30437w -= min;
        if (i4 == fVar.xv) {
            this.f30436c = fVar.w();
            r.c(fVar);
        }
        return min;
    }

    /* renamed from: sr */
    public c clone() {
        c cVar = new c();
        if (this.f30437w == 0) {
            return cVar;
        }
        f c4 = this.f30436c.c();
        cVar.f30436c = c4;
        c4.f30441r = c4;
        c4.f30440f = c4;
        f fVar = this.f30436c;
        while (true) {
            fVar = fVar.f30440f;
            if (fVar != this.f30436c) {
                cVar.f30436c.f30441r.c(fVar.c());
            } else {
                cVar.f30437w = this.f30437w;
                return cVar;
            }
        }
    }

    public String toString() {
        return ux().toString();
    }

    public final sr ux() {
        long j4 = this.f30437w;
        if (j4 <= 2147483647L) {
            return sr((int) j4);
        }
        throw new IllegalArgumentException("size > Integer.MAX_VALUE: " + this.f30437w);
    }

    public byte w() {
        long j4 = this.f30437w;
        if (j4 != 0) {
            f fVar = this.f30436c;
            int i4 = fVar.f30442w;
            int i5 = fVar.xv;
            int i6 = i4 + 1;
            byte b4 = fVar.f30439c[i4];
            this.f30437w = j4 - 1;
            if (i6 == i5) {
                this.f30436c = fVar.w();
                r.c(fVar);
            } else {
                fVar.f30442w = i6;
            }
            return b4;
        }
        throw new IllegalStateException("size == 0");
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer != null) {
            int remaining = byteBuffer.remaining();
            int i4 = remaining;
            while (i4 > 0) {
                f xv2 = xv(1);
                int min = Math.min(i4, 8192 - xv2.xv);
                byteBuffer.get(xv2.f30439c, xv2.xv, min);
                i4 -= min;
                xv2.xv += min;
            }
            this.f30437w += remaining;
            return remaining;
        }
        throw new IllegalArgumentException("source == null");
    }

    public String xv() {
        try {
            return c(this.f30437w, p.f30443c);
        } catch (EOFException e4) {
            throw new AssertionError(e4);
        }
    }

    public String c(long j4, Charset charset) throws EOFException {
        p.c(this.f30437w, 0L, j4);
        if (charset != null) {
            if (j4 > 2147483647L) {
                throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j4);
            } else if (j4 == 0) {
                return "";
            } else {
                f fVar = this.f30436c;
                int i4 = fVar.f30442w;
                if (i4 + j4 > fVar.xv) {
                    return new String(c(j4), charset);
                }
                String str = new String(fVar.f30439c, i4, (int) j4, charset);
                int i5 = (int) (fVar.f30442w + j4);
                fVar.f30442w = i5;
                this.f30437w -= j4;
                if (i5 == fVar.xv) {
                    this.f30436c = fVar.w();
                    r.c(fVar);
                }
                return str;
            }
        }
        throw new IllegalArgumentException("charset == null");
    }

    f xv(int i4) {
        if (i4 >= 1 && i4 <= 8192) {
            f fVar = this.f30436c;
            if (fVar == null) {
                f c4 = r.c();
                this.f30436c = c4;
                c4.f30441r = c4;
                c4.f30440f = c4;
                return c4;
            }
            f fVar2 = fVar.f30441r;
            return (fVar2.xv + i4 > 8192 || !fVar2.ux) ? fVar2.c(r.c()) : fVar2;
        }
        throw new IllegalArgumentException();
    }

    public final sr sr(int i4) {
        if (i4 == 0) {
            return sr.xv;
        }
        return new ev(this, i4);
    }

    public c w(byte[] bArr, int i4, int i5) {
        if (bArr != null) {
            long j4 = i5;
            p.c(bArr.length, i4, j4);
            int i6 = i5 + i4;
            while (i4 < i6) {
                f xv2 = xv(1);
                int min = Math.min(i6 - i4, 8192 - xv2.xv);
                System.arraycopy(bArr, i4, xv2.f30439c, xv2.xv, min);
                i4 += min;
                xv2.xv += min;
            }
            this.f30437w += j4;
            return this;
        }
        throw new IllegalArgumentException("source == null");
    }

    public byte[] c(long j4) throws EOFException {
        p.c(this.f30437w, 0L, j4);
        if (j4 <= 2147483647L) {
            byte[] bArr = new byte[(int) j4];
            c(bArr);
            return bArr;
        }
        throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j4);
    }

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

    public c w(int i4) {
        f xv2 = xv(1);
        byte[] bArr = xv2.f30439c;
        int i5 = xv2.xv;
        xv2.xv = i5 + 1;
        bArr[i5] = (byte) i4;
        this.f30437w++;
        return this;
    }

    public int c(byte[] bArr, int i4, int i5) {
        p.c(bArr.length, i4, i5);
        f fVar = this.f30436c;
        if (fVar == null) {
            return -1;
        }
        int min = Math.min(i5, fVar.xv - fVar.f30442w);
        System.arraycopy(fVar.f30439c, fVar.f30442w, bArr, i4, min);
        int i6 = fVar.f30442w + min;
        fVar.f30442w = i6;
        this.f30437w -= min;
        if (i6 == fVar.xv) {
            this.f30436c = fVar.w();
            r.c(fVar);
        }
        return min;
    }

    public c w(long j4) {
        if (j4 == 0) {
            return w(48);
        }
        int numberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j4)) / 4) + 1;
        f xv2 = xv(numberOfTrailingZeros);
        byte[] bArr = xv2.f30439c;
        int i4 = xv2.xv;
        for (int i5 = (i4 + numberOfTrailingZeros) - 1; i5 >= i4; i5--) {
            bArr[i5] = xv[(int) (15 & j4)];
            j4 >>>= 4;
        }
        xv2.xv += numberOfTrailingZeros;
        this.f30437w += numberOfTrailingZeros;
        return this;
    }

    public c c(String str) {
        return c(str, 0, str.length());
    }

    public c c(String str, int i4, int i5) {
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
                        f xv2 = xv(1);
                        byte[] bArr = xv2.f30439c;
                        int i6 = xv2.xv - i4;
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
                        int i8 = xv2.xv;
                        int i9 = (i6 + i7) - i8;
                        xv2.xv = i8 + i9;
                        this.f30437w += i9;
                        i4 = i7;
                    } else {
                        if (charAt < '\u0800') {
                            w((charAt >> 6) | 192);
                            w((charAt & '?') | 128);
                        } else if (charAt >= '\ud800' && charAt <= '\udfff') {
                            int i10 = i4 + 1;
                            char charAt3 = i10 < i5 ? str.charAt(i10) : (char) 0;
                            if (charAt <= '\udbff' && charAt3 >= '\udc00' && charAt3 <= '\udfff') {
                                int i11 = (((charAt & '\u27ff') << 10) | ('\u23ff' & charAt3)) + 65536;
                                w((i11 >> 18) | 240);
                                w(((i11 >> 12) & 63) | 128);
                                w(((i11 >> 6) & 63) | 128);
                                w((i11 & 63) | 128);
                                i4 += 2;
                            } else {
                                w(63);
                                i4 = i10;
                            }
                        } else {
                            w((charAt >> '\f') | 224);
                            w(((charAt >> 6) & 63) | 128);
                            w((charAt & '?') | 128);
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

    public c c(int i4) {
        if (i4 < 128) {
            w(i4);
        } else if (i4 < 2048) {
            w((i4 >> 6) | 192);
            w((i4 & 63) | 128);
        } else if (i4 < 65536) {
            if (i4 >= 55296 && i4 <= 57343) {
                w(63);
            } else {
                w((i4 >> 12) | 224);
                w(((i4 >> 6) & 63) | 128);
                w((i4 & 63) | 128);
            }
        } else if (i4 <= 1114111) {
            w((i4 >> 18) | 240);
            w(((i4 >> 12) & 63) | 128);
            w(((i4 >> 6) & 63) | 128);
            w((i4 & 63) | 128);
        } else {
            throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i4));
        }
        return this;
    }

    public c c(String str, int i4, int i5, Charset charset) {
        if (str != null) {
            if (i4 < 0) {
                throw new IllegalAccessError("beginIndex < 0: " + i4);
            } else if (i5 >= i4) {
                if (i5 <= str.length()) {
                    if (charset != null) {
                        if (charset.equals(p.f30443c)) {
                            return c(str, i4, i5);
                        }
                        byte[] bytes = str.substring(i4, i5).getBytes(charset);
                        return w(bytes, 0, bytes.length);
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
}
