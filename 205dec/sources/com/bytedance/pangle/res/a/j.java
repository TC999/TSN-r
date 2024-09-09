package com.bytedance.pangle.res.a;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public abstract class j extends FilterInputStream {
    public j(InputStream inputStream) {
        super(inputStream);
    }

    protected void a(int i4) {
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() {
        try {
            return super.available();
        } catch (IOException e4) {
            throw e4;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            ((FilterInputStream) this).in.close();
        } catch (IOException e4) {
            throw e4;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i4) {
        ((FilterInputStream) this).in.mark(i4);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return ((FilterInputStream) this).in.markSupported();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() {
        try {
            int read = ((FilterInputStream) this).in.read();
            a(read != -1 ? 1 : -1);
            return read;
        } catch (IOException e4) {
            throw e4;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() {
        try {
            ((FilterInputStream) this).in.reset();
        } catch (IOException e4) {
            throw e4;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j4) {
        try {
            return ((FilterInputStream) this).in.skip(j4);
        } catch (IOException e4) {
            throw e4;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) {
        try {
            int read = ((FilterInputStream) this).in.read(bArr);
            a(read);
            return read;
        } catch (IOException e4) {
            throw e4;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i4, int i5) {
        try {
            int read = ((FilterInputStream) this).in.read(bArr, i4, i5);
            a(read);
            return read;
        } catch (IOException e4) {
            throw e4;
        }
    }
}
