package com.bumptech.glide.load.resource.bitmap;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import kotlin.UByte;

/* renamed from: com.bumptech.glide.load.resource.bitmap.u */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class RecyclableBufferedInputStream extends FilterInputStream {

    /* renamed from: a */
    private volatile byte[] f14156a;

    /* renamed from: b */
    private int f14157b;

    /* renamed from: c */
    private int f14158c;

    /* renamed from: d */
    private int f14159d;

    /* renamed from: e */
    private int f14160e;

    /* renamed from: f */
    private final ArrayPool f14161f;

    /* compiled from: RecyclableBufferedInputStream.java */
    /* renamed from: com.bumptech.glide.load.resource.bitmap.u$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    static class C3724a extends IOException {
        private static final long serialVersionUID = -4338378848813561757L;

        C3724a(String str) {
            super(str);
        }
    }

    public RecyclableBufferedInputStream(@NonNull InputStream inputStream, @NonNull ArrayPool arrayPool) {
        this(inputStream, arrayPool, 65536);
    }

    /* renamed from: a */
    private int m44912a(InputStream inputStream, byte[] bArr) throws IOException {
        int i = this.f14159d;
        if (i != -1) {
            int i2 = this.f14160e - i;
            int i3 = this.f14158c;
            if (i2 < i3) {
                if (i == 0 && i3 > bArr.length && this.f14157b == bArr.length) {
                    int length = bArr.length * 2;
                    if (length <= i3) {
                        i3 = length;
                    }
                    byte[] bArr2 = (byte[]) this.f14161f.mo45394c(i3, byte[].class);
                    System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                    this.f14156a = bArr2;
                    this.f14161f.put(bArr);
                    bArr = bArr2;
                } else if (i > 0) {
                    System.arraycopy(bArr, i, bArr, 0, bArr.length - i);
                }
                int i4 = this.f14160e - this.f14159d;
                this.f14160e = i4;
                this.f14159d = 0;
                this.f14157b = 0;
                int read = inputStream.read(bArr, i4, bArr.length - i4);
                int i5 = this.f14160e;
                if (read > 0) {
                    i5 += read;
                }
                this.f14157b = i5;
                return read;
            }
        }
        int read2 = inputStream.read(bArr);
        if (read2 > 0) {
            this.f14159d = -1;
            this.f14160e = 0;
            this.f14157b = read2;
        }
        return read2;
    }

    /* renamed from: d */
    private static IOException m44909d() throws IOException {
        throw new IOException("BufferedInputStream is closed");
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() throws IOException {
        InputStream inputStream;
        inputStream = ((FilterInputStream) this).in;
        if (this.f14156a != null && inputStream != null) {
        } else {
            throw m44909d();
        }
        return (this.f14157b - this.f14160e) + inputStream.available();
    }

    /* renamed from: b */
    public synchronized void m44911b() {
        this.f14158c = this.f14156a.length;
    }

    /* renamed from: c */
    public synchronized void m44910c() {
        if (this.f14156a != null) {
            this.f14161f.put(this.f14156a);
            this.f14156a = null;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f14156a != null) {
            this.f14161f.put(this.f14156a);
            this.f14156a = null;
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        ((FilterInputStream) this).in = null;
        if (inputStream != null) {
            inputStream.close();
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i) {
        this.f14158c = Math.max(this.f14158c, i);
        this.f14159d = this.f14160e;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return true;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() throws IOException {
        byte[] bArr = this.f14156a;
        InputStream inputStream = ((FilterInputStream) this).in;
        if (bArr != null && inputStream != null) {
            if (this.f14160e < this.f14157b || m44912a(inputStream, bArr) != -1) {
                if (bArr != this.f14156a && (bArr = this.f14156a) == null) {
                    throw m44909d();
                }
                int i = this.f14157b;
                int i2 = this.f14160e;
                if (i - i2 > 0) {
                    this.f14160e = i2 + 1;
                    return bArr[i2] & UByte.f41242c;
                }
                return -1;
            }
            return -1;
        }
        throw m44909d();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() throws IOException {
        if (this.f14156a != null) {
            int i = this.f14159d;
            if (-1 != i) {
                this.f14160e = i;
            } else {
                throw new C3724a("Mark has been invalidated, pos: " + this.f14160e + " markLimit: " + this.f14158c);
            }
        } else {
            throw new IOException("Stream is closed");
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized long skip(long j) throws IOException {
        if (j < 1) {
            return 0L;
        }
        byte[] bArr = this.f14156a;
        if (bArr != null) {
            InputStream inputStream = ((FilterInputStream) this).in;
            if (inputStream != null) {
                int i = this.f14157b;
                int i2 = this.f14160e;
                if (i - i2 >= j) {
                    this.f14160e = (int) (i2 + j);
                    return j;
                }
                long j2 = i - i2;
                this.f14160e = i;
                if (this.f14159d != -1 && j <= this.f14158c) {
                    if (m44912a(inputStream, bArr) == -1) {
                        return j2;
                    }
                    int i3 = this.f14157b;
                    int i4 = this.f14160e;
                    if (i3 - i4 >= j - j2) {
                        this.f14160e = (int) ((i4 + j) - j2);
                        return j;
                    }
                    long j3 = (j2 + i3) - i4;
                    this.f14160e = i3;
                    return j3;
                }
                return j2 + inputStream.skip(j - j2);
            }
            throw m44909d();
        }
        throw m44909d();
    }

    @VisibleForTesting
    RecyclableBufferedInputStream(@NonNull InputStream inputStream, @NonNull ArrayPool arrayPool, int i) {
        super(inputStream);
        this.f14159d = -1;
        this.f14161f = arrayPool;
        this.f14156a = (byte[]) arrayPool.mo45394c(i, byte[].class);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(@NonNull byte[] bArr, int i, int i2) throws IOException {
        int i3;
        int i4;
        byte[] bArr2 = this.f14156a;
        if (bArr2 == null) {
            throw m44909d();
        }
        if (i2 == 0) {
            return 0;
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        if (inputStream != null) {
            int i5 = this.f14160e;
            int i6 = this.f14157b;
            if (i5 < i6) {
                int i7 = i6 - i5 >= i2 ? i2 : i6 - i5;
                System.arraycopy(bArr2, i5, bArr, i, i7);
                this.f14160e += i7;
                if (i7 == i2 || inputStream.available() == 0) {
                    return i7;
                }
                i += i7;
                i3 = i2 - i7;
            } else {
                i3 = i2;
            }
            while (true) {
                if (this.f14159d == -1 && i3 >= bArr2.length) {
                    i4 = inputStream.read(bArr, i, i3);
                    if (i4 == -1) {
                        return i3 != i2 ? i2 - i3 : -1;
                    }
                } else if (m44912a(inputStream, bArr2) == -1) {
                    return i3 != i2 ? i2 - i3 : -1;
                } else {
                    if (bArr2 != this.f14156a && (bArr2 = this.f14156a) == null) {
                        throw m44909d();
                    }
                    int i8 = this.f14157b;
                    int i9 = this.f14160e;
                    i4 = i8 - i9 >= i3 ? i3 : i8 - i9;
                    System.arraycopy(bArr2, i9, bArr, i, i4);
                    this.f14160e += i4;
                }
                i3 -= i4;
                if (i3 == 0) {
                    return i2;
                }
                if (inputStream.available() == 0) {
                    return i2 - i3;
                }
                i += i4;
            }
        } else {
            throw m44909d();
        }
    }
}
