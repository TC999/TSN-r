package com.bumptech.glide.load.data;

import androidx.annotation.NonNull;
import io.netty.handler.codec.memcache.binary.BinaryMemcacheOpcodes;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import kotlin.UByte;

/* renamed from: com.bumptech.glide.load.data.g */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class ExifOrientationStream extends FilterInputStream {

    /* renamed from: c */
    private static final int f13483c = 2;

    /* renamed from: d */
    private static final byte[] f13484d;

    /* renamed from: e */
    private static final int f13485e;

    /* renamed from: f */
    private static final int f13486f;

    /* renamed from: a */
    private final byte f13487a;

    /* renamed from: b */
    private int f13488b;

    static {
        byte[] bArr = {-1, -31, 0, BinaryMemcacheOpcodes.TOUCH, 69, 120, 105, 102, 0, 0, 77, 77, 0, 0, 0, 0, 0, 8, 0, 1, 1, BinaryMemcacheOpcodes.ADDQ, 0, 2, 0, 0, 0, 1, 0};
        f13484d = bArr;
        int length = bArr.length;
        f13485e = length;
        f13486f = length + 2;
    }

    public ExifOrientationStream(InputStream inputStream, int i) {
        super(inputStream);
        if (i >= -1 && i <= 8) {
            this.f13487a = (byte) i;
            return;
        }
        throw new IllegalArgumentException("Cannot add invalid orientation: " + i);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void mark(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int read;
        int i;
        int i2 = this.f13488b;
        if (i2 < 2 || i2 > (i = f13486f)) {
            read = super.read();
        } else if (i2 == i) {
            read = this.f13487a;
        } else {
            read = f13484d[i2 - 2] & UByte.f41242c;
        }
        if (read != -1) {
            this.f13488b++;
        }
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void reset() throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j) throws IOException {
        long skip = super.skip(j);
        if (skip > 0) {
            this.f13488b = (int) (this.f13488b + skip);
        }
        return skip;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(@NonNull byte[] bArr, int i, int i2) throws IOException {
        int i3;
        int i4 = this.f13488b;
        int i5 = f13486f;
        if (i4 > i5) {
            i3 = super.read(bArr, i, i2);
        } else if (i4 == i5) {
            bArr[i] = this.f13487a;
            i3 = 1;
        } else if (i4 < 2) {
            i3 = super.read(bArr, i, 2 - i4);
        } else {
            int min = Math.min(i5 - i4, i2);
            System.arraycopy(f13484d, this.f13488b - 2, bArr, i, min);
            i3 = min;
        }
        if (i3 > 0) {
            this.f13488b += i3;
        }
        return i3;
    }
}
