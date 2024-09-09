package com.amap.api.col.p0003l;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: StrictLineReader.java */
/* renamed from: com.amap.api.col.3l.o6  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class o6 implements Closeable {

    /* renamed from: f  reason: collision with root package name */
    public static final Charset f8462f = Charset.forName("US-ASCII");

    /* renamed from: a  reason: collision with root package name */
    private final InputStream f8463a;

    /* renamed from: b  reason: collision with root package name */
    private final Charset f8464b;

    /* renamed from: c  reason: collision with root package name */
    private byte[] f8465c;

    /* renamed from: d  reason: collision with root package name */
    private int f8466d;

    /* renamed from: e  reason: collision with root package name */
    private int f8467e;

    /* compiled from: StrictLineReader.java */
    /* renamed from: com.amap.api.col.3l.o6$a */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    final class a extends ByteArrayOutputStream {
        a(int i4) {
            super(i4);
        }

        @Override // java.io.ByteArrayOutputStream
        public final String toString() {
            int i4 = ((ByteArrayOutputStream) this).count;
            if (i4 > 0 && ((ByteArrayOutputStream) this).buf[i4 - 1] == 13) {
                i4--;
            }
            try {
                return new String(((ByteArrayOutputStream) this).buf, 0, i4, o6.this.f8464b.name());
            } catch (UnsupportedEncodingException e4) {
                throw new AssertionError(e4);
            }
        }
    }

    public o6(InputStream inputStream, Charset charset) {
        this(inputStream, charset, (byte) 0);
    }

    private void d() throws IOException {
        InputStream inputStream = this.f8463a;
        byte[] bArr = this.f8465c;
        int read = inputStream.read(bArr, 0, bArr.length);
        if (read != -1) {
            this.f8466d = 0;
            this.f8467e = read;
            return;
        }
        throw new EOFException();
    }

    public final String b() throws IOException {
        int i4;
        byte[] bArr;
        int i5;
        synchronized (this.f8463a) {
            if (this.f8465c != null) {
                if (this.f8466d >= this.f8467e) {
                    d();
                }
                for (int i6 = this.f8466d; i6 != this.f8467e; i6++) {
                    byte[] bArr2 = this.f8465c;
                    if (bArr2[i6] == 10) {
                        int i7 = this.f8466d;
                        if (i6 != i7) {
                            i5 = i6 - 1;
                            if (bArr2[i5] == 13) {
                                String str = new String(bArr2, i7, i5 - i7, this.f8464b.name());
                                this.f8466d = i6 + 1;
                                return str;
                            }
                        }
                        i5 = i6;
                        String str2 = new String(bArr2, i7, i5 - i7, this.f8464b.name());
                        this.f8466d = i6 + 1;
                        return str2;
                    }
                }
                a aVar = new a((this.f8467e - this.f8466d) + 80);
                loop1: while (true) {
                    byte[] bArr3 = this.f8465c;
                    int i8 = this.f8466d;
                    aVar.write(bArr3, i8, this.f8467e - i8);
                    this.f8467e = -1;
                    d();
                    i4 = this.f8466d;
                    while (i4 != this.f8467e) {
                        bArr = this.f8465c;
                        if (bArr[i4] == 10) {
                            break loop1;
                        }
                        i4++;
                    }
                }
                int i9 = this.f8466d;
                if (i4 != i9) {
                    aVar.write(bArr, i9, i4 - i9);
                }
                this.f8466d = i4 + 1;
                return aVar.toString();
            }
            throw new IOException("LineReader is closed");
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        synchronized (this.f8463a) {
            if (this.f8465c != null) {
                this.f8465c = null;
                this.f8463a.close();
            }
        }
    }

    private o6(InputStream inputStream, Charset charset, byte b4) {
        if (inputStream != null && charset != null) {
            if (charset.equals(f8462f)) {
                this.f8463a = inputStream;
                this.f8464b = charset;
                this.f8465c = new byte[8192];
                return;
            }
            throw new IllegalArgumentException("Unsupported encoding");
        }
        throw null;
    }
}
