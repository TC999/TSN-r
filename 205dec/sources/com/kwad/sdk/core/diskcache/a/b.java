package com.kwad.sdk.core.diskcache.a;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class b implements Closeable {
    private final Charset auf;
    private byte[] buf;
    private int end;
    private final InputStream in;
    private int pos;

    public b(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
    }

    private void Db() {
        InputStream inputStream = this.in;
        byte[] bArr = this.buf;
        int read = inputStream.read(bArr, 0, bArr.length);
        if (read != -1) {
            this.pos = 0;
            this.end = read;
            return;
        }
        throw new EOFException();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        synchronized (this.in) {
            if (this.buf != null) {
                this.buf = null;
                com.kwad.sdk.crash.utils.b.closeQuietly(this.in);
            }
        }
    }

    public final String readLine() {
        int i4;
        byte[] bArr;
        int i5;
        synchronized (this.in) {
            if (this.buf != null) {
                if (this.pos >= this.end) {
                    Db();
                }
                for (int i6 = this.pos; i6 != this.end; i6++) {
                    byte[] bArr2 = this.buf;
                    if (bArr2[i6] == 10) {
                        int i7 = this.pos;
                        if (i6 != i7) {
                            i5 = i6 - 1;
                            if (bArr2[i5] == 13) {
                                String str = new String(bArr2, i7, i5 - i7, this.auf.name());
                                this.pos = i6 + 1;
                                return str;
                            }
                        }
                        i5 = i6;
                        String str2 = new String(bArr2, i7, i5 - i7, this.auf.name());
                        this.pos = i6 + 1;
                        return str2;
                    }
                }
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream((this.end - this.pos) + 80) { // from class: com.kwad.sdk.core.diskcache.a.b.1
                    @Override // java.io.ByteArrayOutputStream
                    public final String toString() {
                        int i8 = ((ByteArrayOutputStream) this).count;
                        if (i8 > 0 && ((ByteArrayOutputStream) this).buf[i8 - 1] == 13) {
                            i8--;
                        }
                        try {
                            return new String(((ByteArrayOutputStream) this).buf, 0, i8, b.this.auf.name());
                        } catch (UnsupportedEncodingException e4) {
                            throw new AssertionError(e4);
                        }
                    }
                };
                loop1: while (true) {
                    byte[] bArr3 = this.buf;
                    int i8 = this.pos;
                    byteArrayOutputStream.write(bArr3, i8, this.end - i8);
                    this.end = -1;
                    Db();
                    i4 = this.pos;
                    while (i4 != this.end) {
                        bArr = this.buf;
                        if (bArr[i4] == 10) {
                            break loop1;
                        }
                        i4++;
                    }
                }
                int i9 = this.pos;
                if (i4 != i9) {
                    byteArrayOutputStream.write(bArr, i9, i4 - i9);
                }
                this.pos = i4 + 1;
                return byteArrayOutputStream.toString();
            }
            throw new IOException("LineReader is closed");
        }
    }

    private b(InputStream inputStream, int i4, Charset charset) {
        if (inputStream != null && charset != null) {
            if (charset.equals(com.kwad.sdk.crash.utils.a.US_ASCII)) {
                this.in = inputStream;
                this.auf = charset;
                this.buf = new byte[8192];
                return;
            }
            throw new IllegalArgumentException("Unsupported encoding");
        }
        throw null;
    }
}
