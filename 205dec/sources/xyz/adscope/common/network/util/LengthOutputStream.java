package xyz.adscope.common.network.util;

import java.io.OutputStream;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class LengthOutputStream extends OutputStream {

    /* renamed from: a  reason: collision with root package name */
    public final AtomicLong f65033a = new AtomicLong(0);

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() {
    }

    public long getLength() {
        return this.f65033a.get();
    }

    @Override // java.io.OutputStream
    public void write(int i4) {
        this.f65033a.addAndGet(1L);
    }

    public void write(long j4) {
        this.f65033a.addAndGet(j4);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) {
        this.f65033a.addAndGet(bArr.length);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i4, int i5) {
        this.f65033a.addAndGet(i5);
    }
}
