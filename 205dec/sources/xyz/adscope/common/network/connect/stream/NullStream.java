package xyz.adscope.common.network.connect.stream;

import java.io.InputStream;
import xyz.adscope.common.network.connect.Connection;
import xyz.adscope.common.network.util.IOUtils;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class NullStream extends InputStream {

    /* renamed from: a  reason: collision with root package name */
    public final Connection f64891a;

    public NullStream(Connection connection) {
        this.f64891a = connection;
    }

    @Override // java.io.InputStream
    public int available() {
        return 0;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        IOUtils.closeQuietly(this.f64891a);
    }

    @Override // java.io.InputStream
    public void mark(int i4) {
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.InputStream
    public int read() {
        return 0;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        return 0;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i4, int i5) {
        return 0;
    }

    @Override // java.io.InputStream
    public void reset() {
    }

    @Override // java.io.InputStream
    public long skip(long j4) {
        return 0L;
    }
}
