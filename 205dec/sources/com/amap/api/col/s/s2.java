package com.amap.api.col.s;

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
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class s2 implements Closeable {

    /* renamed from: f  reason: collision with root package name */
    public static final Charset f10206f = Charset.forName("US-ASCII");

    /* renamed from: a  reason: collision with root package name */
    private final InputStream f10207a;

    /* renamed from: b  reason: collision with root package name */
    private final Charset f10208b;

    /* renamed from: c  reason: collision with root package name */
    private byte[] f10209c;

    /* renamed from: d  reason: collision with root package name */
    private int f10210d;

    /* renamed from: e  reason: collision with root package name */
    private int f10211e;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: StrictLineReader.java */
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
                return new String(((ByteArrayOutputStream) this).buf, 0, i4, s2.this.f10208b.name());
            } catch (UnsupportedEncodingException e4) {
                throw new AssertionError(e4);
            }
        }
    }

    public s2(InputStream inputStream, Charset charset) {
        this(inputStream, charset, (byte) 0);
    }

    private void d() throws IOException {
        InputStream inputStream = this.f10207a;
        byte[] bArr = this.f10209c;
        int read = inputStream.read(bArr, 0, bArr.length);
        if (read != -1) {
            this.f10210d = 0;
            this.f10211e = read;
            return;
        }
        throw new EOFException();
    }

    public final String b() throws IOException {
        int i4;
        byte[] bArr;
        int i5;
        synchronized (this.f10207a) {
            if (this.f10209c != null) {
                if (this.f10210d >= this.f10211e) {
                    d();
                }
                for (int i6 = this.f10210d; i6 != this.f10211e; i6++) {
                    byte[] bArr2 = this.f10209c;
                    if (bArr2[i6] == 10) {
                        int i7 = this.f10210d;
                        if (i6 != i7) {
                            i5 = i6 - 1;
                            if (bArr2[i5] == 13) {
                                String str = new String(bArr2, i7, i5 - i7, this.f10208b.name());
                                this.f10210d = i6 + 1;
                                return str;
                            }
                        }
                        i5 = i6;
                        String str2 = new String(bArr2, i7, i5 - i7, this.f10208b.name());
                        this.f10210d = i6 + 1;
                        return str2;
                    }
                }
                a aVar = new a((this.f10211e - this.f10210d) + 80);
                loop1: while (true) {
                    byte[] bArr3 = this.f10209c;
                    int i8 = this.f10210d;
                    aVar.write(bArr3, i8, this.f10211e - i8);
                    this.f10211e = -1;
                    d();
                    i4 = this.f10210d;
                    while (i4 != this.f10211e) {
                        bArr = this.f10209c;
                        if (bArr[i4] == 10) {
                            break loop1;
                        }
                        i4++;
                    }
                }
                int i9 = this.f10210d;
                if (i4 != i9) {
                    aVar.write(bArr, i9, i4 - i9);
                }
                this.f10210d = i4 + 1;
                return aVar.toString();
            }
            throw new IOException("LineReader is closed");
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        synchronized (this.f10207a) {
            if (this.f10209c != null) {
                this.f10209c = null;
                this.f10207a.close();
            }
        }
    }

    private s2(InputStream inputStream, Charset charset, byte b4) {
        if (inputStream != null && charset != null) {
            if (charset.equals(f10206f)) {
                this.f10207a = inputStream;
                this.f10208b = charset;
                this.f10209c = new byte[8192];
                return;
            }
            throw new IllegalArgumentException("Unsupported encoding");
        }
        throw null;
    }
}
