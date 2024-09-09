package com.bumptech.glide.disklrucache;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: StrictLineReader.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
class b implements Closeable {

    /* renamed from: f  reason: collision with root package name */
    private static final byte f16633f = 13;

    /* renamed from: g  reason: collision with root package name */
    private static final byte f16634g = 10;

    /* renamed from: a  reason: collision with root package name */
    private final InputStream f16635a;

    /* renamed from: b  reason: collision with root package name */
    private final Charset f16636b;

    /* renamed from: c  reason: collision with root package name */
    private byte[] f16637c;

    /* renamed from: d  reason: collision with root package name */
    private int f16638d;

    /* renamed from: e  reason: collision with root package name */
    private int f16639e;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: StrictLineReader.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    class a extends ByteArrayOutputStream {
        a(int i4) {
            super(i4);
        }

        @Override // java.io.ByteArrayOutputStream
        public String toString() {
            int i4 = ((ByteArrayOutputStream) this).count;
            if (i4 > 0 && ((ByteArrayOutputStream) this).buf[i4 - 1] == 13) {
                i4--;
            }
            try {
                return new String(((ByteArrayOutputStream) this).buf, 0, i4, b.this.f16636b.name());
            } catch (UnsupportedEncodingException e4) {
                throw new AssertionError(e4);
            }
        }
    }

    public b(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
    }

    private void b() throws IOException {
        InputStream inputStream = this.f16635a;
        byte[] bArr = this.f16637c;
        int read = inputStream.read(bArr, 0, bArr.length);
        if (read != -1) {
            this.f16638d = 0;
            this.f16639e = read;
            return;
        }
        throw new EOFException();
    }

    public boolean c() {
        return this.f16639e == -1;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        synchronized (this.f16635a) {
            if (this.f16637c != null) {
                this.f16637c = null;
                this.f16635a.close();
            }
        }
    }

    public String d() throws IOException {
        int i4;
        byte[] bArr;
        int i5;
        synchronized (this.f16635a) {
            if (this.f16637c != null) {
                if (this.f16638d >= this.f16639e) {
                    b();
                }
                for (int i6 = this.f16638d; i6 != this.f16639e; i6++) {
                    byte[] bArr2 = this.f16637c;
                    if (bArr2[i6] == 10) {
                        int i7 = this.f16638d;
                        if (i6 != i7) {
                            i5 = i6 - 1;
                            if (bArr2[i5] == 13) {
                                String str = new String(bArr2, i7, i5 - i7, this.f16636b.name());
                                this.f16638d = i6 + 1;
                                return str;
                            }
                        }
                        i5 = i6;
                        String str2 = new String(bArr2, i7, i5 - i7, this.f16636b.name());
                        this.f16638d = i6 + 1;
                        return str2;
                    }
                }
                a aVar = new a((this.f16639e - this.f16638d) + 80);
                loop1: while (true) {
                    byte[] bArr3 = this.f16637c;
                    int i8 = this.f16638d;
                    aVar.write(bArr3, i8, this.f16639e - i8);
                    this.f16639e = -1;
                    b();
                    i4 = this.f16638d;
                    while (i4 != this.f16639e) {
                        bArr = this.f16637c;
                        if (bArr[i4] == 10) {
                            break loop1;
                        }
                        i4++;
                    }
                }
                int i9 = this.f16638d;
                if (i4 != i9) {
                    aVar.write(bArr, i9, i4 - i9);
                }
                this.f16638d = i4 + 1;
                return aVar.toString();
            }
            throw new IOException("LineReader is closed");
        }
    }

    public b(InputStream inputStream, int i4, Charset charset) {
        if (inputStream == null || charset == null) {
            throw null;
        }
        if (i4 >= 0) {
            if (charset.equals(c.f16641a)) {
                this.f16635a = inputStream;
                this.f16636b = charset;
                this.f16637c = new byte[i4];
                return;
            }
            throw new IllegalArgumentException("Unsupported encoding");
        }
        throw new IllegalArgumentException("capacity <= 0");
    }
}
