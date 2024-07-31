package com.amap.api.col.p047s;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/* compiled from: StrictLineReader.java */
/* renamed from: com.amap.api.col.s.s2 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class C2140s2 implements Closeable {

    /* renamed from: f */
    public static final Charset f6478f = Charset.forName("US-ASCII");

    /* renamed from: a */
    private final InputStream f6479a;

    /* renamed from: b */
    private final Charset f6480b;

    /* renamed from: c */
    private byte[] f6481c;

    /* renamed from: d */
    private int f6482d;

    /* renamed from: e */
    private int f6483e;

    /* compiled from: StrictLineReader.java */
    /* renamed from: com.amap.api.col.s.s2$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    final class C2141a extends ByteArrayOutputStream {
        C2141a(int i) {
            super(i);
        }

        @Override // java.io.ByteArrayOutputStream
        public final String toString() {
            int i = ((ByteArrayOutputStream) this).count;
            if (i > 0 && ((ByteArrayOutputStream) this).buf[i - 1] == 13) {
                i--;
            }
            try {
                return new String(((ByteArrayOutputStream) this).buf, 0, i, C2140s2.this.f6480b.name());
            } catch (UnsupportedEncodingException e) {
                throw new AssertionError(e);
            }
        }
    }

    public C2140s2(InputStream inputStream, Charset charset) {
        this(inputStream, charset, (byte) 0);
    }

    /* renamed from: c */
    private void m52465c() throws IOException {
        InputStream inputStream = this.f6479a;
        byte[] bArr = this.f6481c;
        int read = inputStream.read(bArr, 0, bArr.length);
        if (read != -1) {
            this.f6482d = 0;
            this.f6483e = read;
            return;
        }
        throw new EOFException();
    }

    /* renamed from: a */
    public final String m52467a() throws IOException {
        int i;
        byte[] bArr;
        int i2;
        synchronized (this.f6479a) {
            if (this.f6481c != null) {
                if (this.f6482d >= this.f6483e) {
                    m52465c();
                }
                for (int i3 = this.f6482d; i3 != this.f6483e; i3++) {
                    byte[] bArr2 = this.f6481c;
                    if (bArr2[i3] == 10) {
                        int i4 = this.f6482d;
                        if (i3 != i4) {
                            i2 = i3 - 1;
                            if (bArr2[i2] == 13) {
                                String str = new String(bArr2, i4, i2 - i4, this.f6480b.name());
                                this.f6482d = i3 + 1;
                                return str;
                            }
                        }
                        i2 = i3;
                        String str2 = new String(bArr2, i4, i2 - i4, this.f6480b.name());
                        this.f6482d = i3 + 1;
                        return str2;
                    }
                }
                C2141a c2141a = new C2141a((this.f6483e - this.f6482d) + 80);
                loop1: while (true) {
                    byte[] bArr3 = this.f6481c;
                    int i5 = this.f6482d;
                    c2141a.write(bArr3, i5, this.f6483e - i5);
                    this.f6483e = -1;
                    m52465c();
                    i = this.f6482d;
                    while (i != this.f6483e) {
                        bArr = this.f6481c;
                        if (bArr[i] == 10) {
                            break loop1;
                        }
                        i++;
                    }
                }
                int i6 = this.f6482d;
                if (i != i6) {
                    c2141a.write(bArr, i6, i - i6);
                }
                this.f6482d = i + 1;
                return c2141a.toString();
            }
            throw new IOException("LineReader is closed");
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        synchronized (this.f6479a) {
            if (this.f6481c != null) {
                this.f6481c = null;
                this.f6479a.close();
            }
        }
    }

    private C2140s2(InputStream inputStream, Charset charset, byte b) {
        if (inputStream != null && charset != null) {
            if (charset.equals(f6478f)) {
                this.f6479a = inputStream;
                this.f6480b = charset;
                this.f6481c = new byte[8192];
                return;
            }
            throw new IllegalArgumentException("Unsupported encoding");
        }
        throw null;
    }
}
