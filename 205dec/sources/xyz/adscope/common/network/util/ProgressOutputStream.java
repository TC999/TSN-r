package xyz.adscope.common.network.util;

import java.io.OutputStream;
import xyz.adscope.common.network.Content;
import xyz.adscope.common.network.ProgressBar;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class ProgressOutputStream<T extends Content> extends OutputStream {

    /* renamed from: a  reason: collision with root package name */
    public OutputStream f65036a;

    /* renamed from: b  reason: collision with root package name */
    public T f65037b;

    /* renamed from: c  reason: collision with root package name */
    public ProgressBar<T> f65038c;

    /* renamed from: d  reason: collision with root package name */
    public long f65039d;

    /* renamed from: e  reason: collision with root package name */
    public long f65040e;

    /* renamed from: f  reason: collision with root package name */
    public int f65041f;

    public ProgressOutputStream(OutputStream outputStream, T t3, ProgressBar<T> progressBar) {
        this.f65036a = outputStream;
        this.f65037b = t3;
        this.f65038c = progressBar;
        this.f65039d = t3.contentLength();
    }

    public final void a() {
        int i4;
        long j4 = this.f65039d;
        if (j4 <= 0 || (i4 = (int) ((this.f65040e * 100) / j4)) <= this.f65041f || i4 % 2 != 0) {
            return;
        }
        this.f65041f = i4;
        this.f65038c.progress(this.f65037b, i4);
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f65036a.close();
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() {
        this.f65036a.flush();
    }

    @Override // java.io.OutputStream
    public void write(int i4) {
        this.f65036a.write(i4);
        this.f65040e++;
        a();
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) {
        this.f65036a.write(bArr);
        this.f65040e += bArr.length;
        a();
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i4, int i5) {
        this.f65036a.write(bArr, i4, i5);
        this.f65040e += i5;
        a();
    }
}
