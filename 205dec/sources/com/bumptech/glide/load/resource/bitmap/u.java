package com.bumptech.glide.load.resource.bitmap;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: RecyclableBufferedInputStream.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class u extends FilterInputStream {

    /* renamed from: a  reason: collision with root package name */
    private volatile byte[] f17473a;

    /* renamed from: b  reason: collision with root package name */
    private int f17474b;

    /* renamed from: c  reason: collision with root package name */
    private int f17475c;

    /* renamed from: d  reason: collision with root package name */
    private int f17476d;

    /* renamed from: e  reason: collision with root package name */
    private int f17477e;

    /* renamed from: f  reason: collision with root package name */
    private final com.bumptech.glide.load.engine.bitmap_recycle.b f17478f;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: RecyclableBufferedInputStream.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    static class a extends IOException {
        private static final long serialVersionUID = -4338378848813561757L;

        a(String str) {
            super(str);
        }
    }

    public u(@NonNull InputStream inputStream, @NonNull com.bumptech.glide.load.engine.bitmap_recycle.b bVar) {
        this(inputStream, bVar, 65536);
    }

    private int a(InputStream inputStream, byte[] bArr) throws IOException {
        int i4 = this.f17476d;
        if (i4 != -1) {
            int i5 = this.f17477e - i4;
            int i6 = this.f17475c;
            if (i5 < i6) {
                if (i4 == 0 && i6 > bArr.length && this.f17474b == bArr.length) {
                    int length = bArr.length * 2;
                    if (length <= i6) {
                        i6 = length;
                    }
                    byte[] bArr2 = (byte[]) this.f17478f.c(i6, byte[].class);
                    System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                    this.f17473a = bArr2;
                    this.f17478f.put(bArr);
                    bArr = bArr2;
                } else if (i4 > 0) {
                    System.arraycopy(bArr, i4, bArr, 0, bArr.length - i4);
                }
                int i7 = this.f17477e - this.f17476d;
                this.f17477e = i7;
                this.f17476d = 0;
                this.f17474b = 0;
                int read = inputStream.read(bArr, i7, bArr.length - i7);
                int i8 = this.f17477e;
                if (read > 0) {
                    i8 += read;
                }
                this.f17474b = i8;
                return read;
            }
        }
        int read2 = inputStream.read(bArr);
        if (read2 > 0) {
            this.f17476d = -1;
            this.f17477e = 0;
            this.f17474b = read2;
        }
        return read2;
    }

    private static IOException d() throws IOException {
        throw new IOException("BufferedInputStream is closed");
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() throws IOException {
        InputStream inputStream;
        inputStream = ((FilterInputStream) this).in;
        if (this.f17473a != null && inputStream != null) {
        } else {
            throw d();
        }
        return (this.f17474b - this.f17477e) + inputStream.available();
    }

    public synchronized void b() {
        this.f17475c = this.f17473a.length;
    }

    public synchronized void c() {
        if (this.f17473a != null) {
            this.f17478f.put(this.f17473a);
            this.f17473a = null;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f17473a != null) {
            this.f17478f.put(this.f17473a);
            this.f17473a = null;
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        ((FilterInputStream) this).in = null;
        if (inputStream != null) {
            inputStream.close();
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i4) {
        this.f17475c = Math.max(this.f17475c, i4);
        this.f17476d = this.f17477e;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return true;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() throws IOException {
        byte[] bArr = this.f17473a;
        InputStream inputStream = ((FilterInputStream) this).in;
        if (bArr != null && inputStream != null) {
            if (this.f17477e < this.f17474b || a(inputStream, bArr) != -1) {
                if (bArr != this.f17473a && (bArr = this.f17473a) == null) {
                    throw d();
                }
                int i4 = this.f17474b;
                int i5 = this.f17477e;
                if (i4 - i5 > 0) {
                    this.f17477e = i5 + 1;
                    return bArr[i5] & 255;
                }
                return -1;
            }
            return -1;
        }
        throw d();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() throws IOException {
        if (this.f17473a != null) {
            int i4 = this.f17476d;
            if (-1 != i4) {
                this.f17477e = i4;
            } else {
                throw new a("Mark has been invalidated, pos: " + this.f17477e + " markLimit: " + this.f17475c);
            }
        } else {
            throw new IOException("Stream is closed");
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized long skip(long j4) throws IOException {
        if (j4 < 1) {
            return 0L;
        }
        byte[] bArr = this.f17473a;
        if (bArr != null) {
            InputStream inputStream = ((FilterInputStream) this).in;
            if (inputStream != null) {
                int i4 = this.f17474b;
                int i5 = this.f17477e;
                if (i4 - i5 >= j4) {
                    this.f17477e = (int) (i5 + j4);
                    return j4;
                }
                long j5 = i4 - i5;
                this.f17477e = i4;
                if (this.f17476d != -1 && j4 <= this.f17475c) {
                    if (a(inputStream, bArr) == -1) {
                        return j5;
                    }
                    int i6 = this.f17474b;
                    int i7 = this.f17477e;
                    if (i6 - i7 >= j4 - j5) {
                        this.f17477e = (int) ((i7 + j4) - j5);
                        return j4;
                    }
                    long j6 = (j5 + i6) - i7;
                    this.f17477e = i6;
                    return j6;
                }
                return j5 + inputStream.skip(j4 - j5);
            }
            throw d();
        }
        throw d();
    }

    @VisibleForTesting
    u(@NonNull InputStream inputStream, @NonNull com.bumptech.glide.load.engine.bitmap_recycle.b bVar, int i4) {
        super(inputStream);
        this.f17476d = -1;
        this.f17478f = bVar;
        this.f17473a = (byte[]) bVar.c(i4, byte[].class);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(@NonNull byte[] bArr, int i4, int i5) throws IOException {
        int i6;
        int i7;
        byte[] bArr2 = this.f17473a;
        if (bArr2 == null) {
            throw d();
        }
        if (i5 == 0) {
            return 0;
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        if (inputStream != null) {
            int i8 = this.f17477e;
            int i9 = this.f17474b;
            if (i8 < i9) {
                int i10 = i9 - i8 >= i5 ? i5 : i9 - i8;
                System.arraycopy(bArr2, i8, bArr, i4, i10);
                this.f17477e += i10;
                if (i10 == i5 || inputStream.available() == 0) {
                    return i10;
                }
                i4 += i10;
                i6 = i5 - i10;
            } else {
                i6 = i5;
            }
            while (true) {
                if (this.f17476d == -1 && i6 >= bArr2.length) {
                    i7 = inputStream.read(bArr, i4, i6);
                    if (i7 == -1) {
                        return i6 != i5 ? i5 - i6 : -1;
                    }
                } else if (a(inputStream, bArr2) == -1) {
                    return i6 != i5 ? i5 - i6 : -1;
                } else {
                    if (bArr2 != this.f17473a && (bArr2 = this.f17473a) == null) {
                        throw d();
                    }
                    int i11 = this.f17474b;
                    int i12 = this.f17477e;
                    i7 = i11 - i12 >= i6 ? i6 : i11 - i12;
                    System.arraycopy(bArr2, i12, bArr, i4, i7);
                    this.f17477e += i7;
                }
                i6 -= i7;
                if (i6 == 0) {
                    return i5;
                }
                if (inputStream.available() == 0) {
                    return i5 - i6;
                }
                i4 += i7;
            }
        } else {
            throw d();
        }
    }
}
