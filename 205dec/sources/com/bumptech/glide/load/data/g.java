package com.bumptech.glide.load.data;

import androidx.annotation.NonNull;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: ExifOrientationStream.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public final class g extends FilterInputStream {

    /* renamed from: c  reason: collision with root package name */
    private static final int f16806c = 2;

    /* renamed from: d  reason: collision with root package name */
    private static final byte[] f16807d;

    /* renamed from: e  reason: collision with root package name */
    private static final int f16808e;

    /* renamed from: f  reason: collision with root package name */
    private static final int f16809f;

    /* renamed from: a  reason: collision with root package name */
    private final byte f16810a;

    /* renamed from: b  reason: collision with root package name */
    private int f16811b;

    static {
        byte[] bArr = {-1, -31, 0, 28, 69, 120, 105, 102, 0, 0, 77, 77, 0, 0, 0, 0, 0, 8, 0, 1, 1, 18, 0, 2, 0, 0, 0, 1, 0};
        f16807d = bArr;
        int length = bArr.length;
        f16808e = length;
        f16809f = length + 2;
    }

    public g(InputStream inputStream, int i4) {
        super(inputStream);
        if (i4 >= -1 && i4 <= 8) {
            this.f16810a = (byte) i4;
            return;
        }
        throw new IllegalArgumentException("Cannot add invalid orientation: " + i4);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void mark(int i4) {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int read;
        int i4;
        int i5 = this.f16811b;
        if (i5 < 2 || i5 > (i4 = f16809f)) {
            read = super.read();
        } else if (i5 == i4) {
            read = this.f16810a;
        } else {
            read = f16807d[i5 - 2] & 255;
        }
        if (read != -1) {
            this.f16811b++;
        }
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void reset() throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j4) throws IOException {
        long skip = super.skip(j4);
        if (skip > 0) {
            this.f16811b = (int) (this.f16811b + skip);
        }
        return skip;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(@NonNull byte[] bArr, int i4, int i5) throws IOException {
        int i6;
        int i7 = this.f16811b;
        int i8 = f16809f;
        if (i7 > i8) {
            i6 = super.read(bArr, i4, i5);
        } else if (i7 == i8) {
            bArr[i4] = this.f16810a;
            i6 = 1;
        } else if (i7 < 2) {
            i6 = super.read(bArr, i4, 2 - i7);
        } else {
            int min = Math.min(i8 - i7, i5);
            System.arraycopy(f16807d, this.f16811b - 2, bArr, i4, min);
            i6 = min;
        }
        if (i6 > 0) {
            this.f16811b += i6;
        }
        return i6;
    }
}
