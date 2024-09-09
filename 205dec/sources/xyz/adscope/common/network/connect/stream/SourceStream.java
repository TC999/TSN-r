package xyz.adscope.common.network.connect.stream;

import java.io.InputStream;
import xyz.adscope.common.network.connect.Connection;
import xyz.adscope.common.network.util.IOUtils;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class SourceStream extends InputStream {

    /* renamed from: a  reason: collision with root package name */
    public final Connection f64892a;

    /* renamed from: b  reason: collision with root package name */
    public final InputStream f64893b;

    public SourceStream(Connection connection, InputStream inputStream) {
        this.f64892a = connection;
        this.f64893b = inputStream;
    }

    @Override // java.io.InputStream
    public int available() {
        return this.f64893b.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        IOUtils.closeQuietly(this.f64893b);
        IOUtils.closeQuietly(this.f64892a);
    }

    @Override // java.io.InputStream
    public synchronized void mark(int i4) {
        this.f64893b.mark(i4);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.f64893b.markSupported();
    }

    @Override // java.io.InputStream
    public int read() {
        return this.f64893b.read();
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        return this.f64893b.read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i4, int i5) {
        return this.f64893b.read(bArr, i4, i5);
    }

    @Override // java.io.InputStream
    public void reset() {
        this.f64893b.reset();
    }

    @Override // java.io.InputStream
    public long skip(long j4) {
        return this.f64893b.skip(j4);
    }
}
