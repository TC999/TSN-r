package com.bytedance.sdk.component.w.c.c.w;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ux extends InputStream {

    /* renamed from: c  reason: collision with root package name */
    InputStream f30401c;

    /* renamed from: w  reason: collision with root package name */
    HttpURLConnection f30402w;

    public ux(InputStream inputStream, HttpURLConnection httpURLConnection) {
        this.f30401c = inputStream;
        this.f30402w = httpURLConnection;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        InputStream inputStream = this.f30401c;
        if (inputStream != null) {
            return inputStream.available();
        }
        return 0;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        InputStream inputStream = this.f30401c;
        if (inputStream != null) {
            inputStream.close();
            this.f30401c = null;
        }
        HttpURLConnection httpURLConnection = this.f30402w;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
            this.f30402w = null;
        }
    }

    @Override // java.io.InputStream
    public synchronized void mark(int i4) {
        InputStream inputStream = this.f30401c;
        if (inputStream != null) {
            inputStream.mark(i4);
        }
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        InputStream inputStream = this.f30401c;
        if (inputStream != null) {
            return inputStream.markSupported();
        }
        return false;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        InputStream inputStream = this.f30401c;
        if (inputStream != null) {
            return inputStream.read();
        }
        return 0;
    }

    @Override // java.io.InputStream
    public void reset() throws IOException {
        InputStream inputStream = this.f30401c;
        if (inputStream != null) {
            inputStream.reset();
        }
    }

    @Override // java.io.InputStream
    public long skip(long j4) throws IOException {
        InputStream inputStream = this.f30401c;
        if (inputStream != null) {
            return inputStream.skip(j4);
        }
        return 0L;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        InputStream inputStream = this.f30401c;
        if (inputStream != null) {
            return inputStream.read(bArr);
        }
        return 0;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i4, int i5) throws IOException {
        InputStream inputStream = this.f30401c;
        if (inputStream != null) {
            return inputStream.read(bArr, i4, i5);
        }
        return 0;
    }
}
