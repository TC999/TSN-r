package com.kwad.sdk.core.imageloader.core.assist;

import java.io.InputStream;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class ContentLengthInputStream extends InputStream {
    private final int length;
    private final InputStream stream;

    public ContentLengthInputStream(InputStream inputStream, int i4) {
        this.stream = inputStream;
        this.length = i4;
    }

    @Override // java.io.InputStream
    public int available() {
        return this.length;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.stream.close();
    }

    @Override // java.io.InputStream
    public void mark(int i4) {
        this.stream.mark(i4);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.stream.markSupported();
    }

    @Override // java.io.InputStream
    public int read() {
        return this.stream.read();
    }

    @Override // java.io.InputStream
    public void reset() {
        this.stream.reset();
    }

    @Override // java.io.InputStream
    public long skip(long j4) {
        return this.stream.skip(j4);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        return this.stream.read(bArr);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i4, int i5) {
        return this.stream.read(bArr, i4, i5);
    }
}
