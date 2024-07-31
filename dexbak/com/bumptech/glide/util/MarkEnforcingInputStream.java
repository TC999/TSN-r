package com.bumptech.glide.util;

import androidx.annotation.NonNull;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.bumptech.glide.util.h */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class MarkEnforcingInputStream extends FilterInputStream {

    /* renamed from: b */
    private static final int f14556b = Integer.MIN_VALUE;

    /* renamed from: c */
    private static final int f14557c = -1;

    /* renamed from: a */
    private int f14558a;

    public MarkEnforcingInputStream(@NonNull InputStream inputStream) {
        super(inputStream);
        this.f14558a = Integer.MIN_VALUE;
    }

    /* renamed from: a */
    private long m44399a(long j) {
        int i = this.f14558a;
        if (i == 0) {
            return -1L;
        }
        return (i == Integer.MIN_VALUE || j <= ((long) i)) ? j : i;
    }

    /* renamed from: b */
    private void m44398b(long j) {
        int i = this.f14558a;
        if (i == Integer.MIN_VALUE || j == -1) {
            return;
        }
        this.f14558a = (int) (i - j);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() throws IOException {
        int i = this.f14558a;
        return i == Integer.MIN_VALUE ? super.available() : Math.min(i, super.available());
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i) {
        super.mark(i);
        this.f14558a = i;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        if (m44399a(1L) == -1) {
            return -1;
        }
        int read = super.read();
        m44398b(1L);
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() throws IOException {
        super.reset();
        this.f14558a = Integer.MIN_VALUE;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j) throws IOException {
        long m44399a = m44399a(j);
        if (m44399a == -1) {
            return 0L;
        }
        long skip = super.skip(m44399a);
        m44398b(skip);
        return skip;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(@NonNull byte[] bArr, int i, int i2) throws IOException {
        int m44399a = (int) m44399a(i2);
        if (m44399a == -1) {
            return -1;
        }
        int read = super.read(bArr, i, m44399a);
        m44398b(read);
        return read;
    }
}
