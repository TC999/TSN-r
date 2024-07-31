package com.kwad.sdk.core.diskcache.p393a;

import com.kwad.sdk.crash.utils.C10737a;
import com.kwad.sdk.crash.utils.C10738b;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/* renamed from: com.kwad.sdk.core.diskcache.a.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10289b implements Closeable {
    private final Charset auf;
    private byte[] buf;
    private int end;

    /* renamed from: in */
    private final InputStream f29543in;
    private int pos;

    public C10289b(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
    }

    /* renamed from: Db */
    private void m26397Db() {
        InputStream inputStream = this.f29543in;
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
        synchronized (this.f29543in) {
            if (this.buf != null) {
                this.buf = null;
                C10738b.closeQuietly(this.f29543in);
            }
        }
    }

    public final String readLine() {
        int i;
        byte[] bArr;
        int i2;
        synchronized (this.f29543in) {
            if (this.buf != null) {
                if (this.pos >= this.end) {
                    m26397Db();
                }
                for (int i3 = this.pos; i3 != this.end; i3++) {
                    byte[] bArr2 = this.buf;
                    if (bArr2[i3] == 10) {
                        int i4 = this.pos;
                        if (i3 != i4) {
                            i2 = i3 - 1;
                            if (bArr2[i2] == 13) {
                                String str = new String(bArr2, i4, i2 - i4, this.auf.name());
                                this.pos = i3 + 1;
                                return str;
                            }
                        }
                        i2 = i3;
                        String str2 = new String(bArr2, i4, i2 - i4, this.auf.name());
                        this.pos = i3 + 1;
                        return str2;
                    }
                }
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream((this.end - this.pos) + 80) { // from class: com.kwad.sdk.core.diskcache.a.b.1
                    @Override // java.io.ByteArrayOutputStream
                    public final String toString() {
                        int i5 = ((ByteArrayOutputStream) this).count;
                        if (i5 > 0 && ((ByteArrayOutputStream) this).buf[i5 - 1] == 13) {
                            i5--;
                        }
                        try {
                            return new String(((ByteArrayOutputStream) this).buf, 0, i5, C10289b.this.auf.name());
                        } catch (UnsupportedEncodingException e) {
                            throw new AssertionError(e);
                        }
                    }
                };
                loop1: while (true) {
                    byte[] bArr3 = this.buf;
                    int i5 = this.pos;
                    byteArrayOutputStream.write(bArr3, i5, this.end - i5);
                    this.end = -1;
                    m26397Db();
                    i = this.pos;
                    while (i != this.end) {
                        bArr = this.buf;
                        if (bArr[i] == 10) {
                            break loop1;
                        }
                        i++;
                    }
                }
                int i6 = this.pos;
                if (i != i6) {
                    byteArrayOutputStream.write(bArr, i6, i - i6);
                }
                this.pos = i + 1;
                return byteArrayOutputStream.toString();
            }
            throw new IOException("LineReader is closed");
        }
    }

    private C10289b(InputStream inputStream, int i, Charset charset) {
        if (inputStream != null && charset != null) {
            if (charset.equals(C10737a.US_ASCII)) {
                this.f29543in = inputStream;
                this.auf = charset;
                this.buf = new byte[8192];
                return;
            }
            throw new IllegalArgumentException("Unsupported encoding");
        }
        throw null;
    }
}
