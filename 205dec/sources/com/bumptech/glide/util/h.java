package com.bumptech.glide.util;

import androidx.annotation.NonNull;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: MarkEnforcingInputStream.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class h extends FilterInputStream {

    /* renamed from: b  reason: collision with root package name */
    private static final int f18074b = Integer.MIN_VALUE;

    /* renamed from: c  reason: collision with root package name */
    private static final int f18075c = -1;

    /* renamed from: a  reason: collision with root package name */
    private int f18076a;

    public h(@NonNull InputStream inputStream) {
        super(inputStream);
        this.f18076a = Integer.MIN_VALUE;
    }

    private long a(long j4) {
        int i4 = this.f18076a;
        if (i4 == 0) {
            return -1L;
        }
        return (i4 == Integer.MIN_VALUE || j4 <= ((long) i4)) ? j4 : i4;
    }

    private void b(long j4) {
        int i4 = this.f18076a;
        if (i4 == Integer.MIN_VALUE || j4 == -1) {
            return;
        }
        this.f18076a = (int) (i4 - j4);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() throws IOException {
        int i4 = this.f18076a;
        return i4 == Integer.MIN_VALUE ? super.available() : Math.min(i4, super.available());
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i4) {
        super.mark(i4);
        this.f18076a = i4;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        if (a(1L) == -1) {
            return -1;
        }
        int read = super.read();
        b(1L);
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() throws IOException {
        super.reset();
        this.f18076a = Integer.MIN_VALUE;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j4) throws IOException {
        long a4 = a(j4);
        if (a4 == -1) {
            return 0L;
        }
        long skip = super.skip(a4);
        b(skip);
        return skip;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(@NonNull byte[] bArr, int i4, int i5) throws IOException {
        int a4 = (int) a(i5);
        if (a4 == -1) {
            return -1;
        }
        int read = super.read(bArr, i4, a4);
        b(read);
        return read;
    }
}
