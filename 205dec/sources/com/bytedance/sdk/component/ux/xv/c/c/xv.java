package com.bytedance.sdk.component.ux.xv.c.c;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
class xv implements Closeable {

    /* renamed from: c  reason: collision with root package name */
    private final InputStream f30279c;
    private int sr;
    private int ux;

    /* renamed from: w  reason: collision with root package name */
    private final Charset f30280w;
    private byte[] xv;

    public xv(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
    }

    private void xv() throws IOException {
        InputStream inputStream = this.f30279c;
        byte[] bArr = this.xv;
        int read = inputStream.read(bArr, 0, bArr.length);
        if (read != -1) {
            this.sr = 0;
            this.ux = read;
            return;
        }
        throw new EOFException();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        synchronized (this.f30279c) {
            if (this.xv != null) {
                this.xv = null;
                this.f30279c.close();
            }
        }
    }

    public boolean w() {
        return this.ux == -1;
    }

    public xv(InputStream inputStream, int i4, Charset charset) {
        if (inputStream == null || charset == null) {
            throw null;
        }
        if (i4 >= 0) {
            if (charset.equals(sr.f30275c)) {
                this.f30279c = inputStream;
                this.f30280w = charset;
                this.xv = new byte[i4];
                return;
            }
            throw new IllegalArgumentException("Unsupported encoding");
        }
        throw new IllegalArgumentException("capacity <= 0");
    }

    public String c() throws IOException {
        int i4;
        byte[] bArr;
        int i5;
        synchronized (this.f30279c) {
            if (this.xv != null) {
                if (this.sr >= this.ux) {
                    xv();
                }
                for (int i6 = this.sr; i6 != this.ux; i6++) {
                    byte[] bArr2 = this.xv;
                    if (bArr2[i6] == 10) {
                        int i7 = this.sr;
                        if (i6 != i7) {
                            i5 = i6 - 1;
                            if (bArr2[i5] == 13) {
                                String str = new String(bArr2, i7, i5 - i7, this.f30280w.name());
                                this.sr = i6 + 1;
                                return str;
                            }
                        }
                        i5 = i6;
                        String str2 = new String(bArr2, i7, i5 - i7, this.f30280w.name());
                        this.sr = i6 + 1;
                        return str2;
                    }
                }
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream((this.ux - this.sr) + 80) { // from class: com.bytedance.sdk.component.ux.xv.c.c.xv.1
                    @Override // java.io.ByteArrayOutputStream
                    public String toString() {
                        int i8 = ((ByteArrayOutputStream) this).count;
                        if (i8 > 0 && ((ByteArrayOutputStream) this).buf[i8 - 1] == 13) {
                            i8--;
                        }
                        try {
                            return new String(((ByteArrayOutputStream) this).buf, 0, i8, xv.this.f30280w.name());
                        } catch (UnsupportedEncodingException e4) {
                            throw new AssertionError(e4);
                        }
                    }
                };
                loop1: while (true) {
                    byte[] bArr3 = this.xv;
                    int i8 = this.sr;
                    byteArrayOutputStream.write(bArr3, i8, this.ux - i8);
                    this.ux = -1;
                    xv();
                    i4 = this.sr;
                    while (i4 != this.ux) {
                        bArr = this.xv;
                        if (bArr[i4] == 10) {
                            break loop1;
                        }
                        i4++;
                    }
                }
                int i9 = this.sr;
                if (i4 != i9) {
                    byteArrayOutputStream.write(bArr, i9, i4 - i9);
                }
                this.sr = i4 + 1;
                return byteArrayOutputStream.toString();
            }
            throw new IOException("LineReader is closed");
        }
    }
}
