package com.amap.api.col.p0463l;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/* renamed from: com.amap.api.col.3l.n6 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class StrictLineReader implements Closeable {

    /* renamed from: f */
    public static final Charset f4751f = Charset.forName("US-ASCII");

    /* renamed from: a */
    private final InputStream f4752a;

    /* renamed from: b */
    private final Charset f4753b;

    /* renamed from: c */
    private byte[] f4754c;

    /* renamed from: d */
    private int f4755d;

    /* renamed from: e */
    private int f4756e;

    /* compiled from: StrictLineReader.java */
    /* renamed from: com.amap.api.col.3l.n6$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    final class C1865a extends ByteArrayOutputStream {
        C1865a(int i) {
            super(i);
        }

        @Override // java.io.ByteArrayOutputStream
        public final String toString() {
            int i = ((ByteArrayOutputStream) this).count;
            if (i > 0 && ((ByteArrayOutputStream) this).buf[i - 1] == 13) {
                i--;
            }
            try {
                return new String(((ByteArrayOutputStream) this).buf, 0, i, StrictLineReader.this.f4753b.name());
            } catch (UnsupportedEncodingException e) {
                throw new AssertionError(e);
            }
        }
    }

    public StrictLineReader(InputStream inputStream, Charset charset) {
        this(inputStream, charset, (byte) 0);
    }

    /* renamed from: c */
    private void m54432c() throws IOException {
        InputStream inputStream = this.f4752a;
        byte[] bArr = this.f4754c;
        int read = inputStream.read(bArr, 0, bArr.length);
        if (read != -1) {
            this.f4755d = 0;
            this.f4756e = read;
            return;
        }
        throw new EOFException();
    }

    /* renamed from: a */
    public final String m54434a() throws IOException {
        int i;
        byte[] bArr;
        int i2;
        synchronized (this.f4752a) {
            if (this.f4754c != null) {
                if (this.f4755d >= this.f4756e) {
                    m54432c();
                }
                for (int i3 = this.f4755d; i3 != this.f4756e; i3++) {
                    byte[] bArr2 = this.f4754c;
                    if (bArr2[i3] == 10) {
                        int i4 = this.f4755d;
                        if (i3 != i4) {
                            i2 = i3 - 1;
                            if (bArr2[i2] == 13) {
                                String str = new String(bArr2, i4, i2 - i4, this.f4753b.name());
                                this.f4755d = i3 + 1;
                                return str;
                            }
                        }
                        i2 = i3;
                        String str2 = new String(bArr2, i4, i2 - i4, this.f4753b.name());
                        this.f4755d = i3 + 1;
                        return str2;
                    }
                }
                C1865a c1865a = new C1865a((this.f4756e - this.f4755d) + 80);
                loop1: while (true) {
                    byte[] bArr3 = this.f4754c;
                    int i5 = this.f4755d;
                    c1865a.write(bArr3, i5, this.f4756e - i5);
                    this.f4756e = -1;
                    m54432c();
                    i = this.f4755d;
                    while (i != this.f4756e) {
                        bArr = this.f4754c;
                        if (bArr[i] == 10) {
                            break loop1;
                        }
                        i++;
                    }
                }
                int i6 = this.f4755d;
                if (i != i6) {
                    c1865a.write(bArr, i6, i - i6);
                }
                this.f4755d = i + 1;
                return c1865a.toString();
            }
            throw new IOException("LineReader is closed");
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        synchronized (this.f4752a) {
            if (this.f4754c != null) {
                this.f4754c = null;
                this.f4752a.close();
            }
        }
    }

    private StrictLineReader(InputStream inputStream, Charset charset, byte b) {
        if (inputStream != null && charset != null) {
            if (charset.equals(f4751f)) {
                this.f4752a = inputStream;
                this.f4753b = charset;
                this.f4754c = new byte[8192];
                return;
            }
            throw new IllegalArgumentException("Unsupported encoding");
        }
        throw null;
    }
}
