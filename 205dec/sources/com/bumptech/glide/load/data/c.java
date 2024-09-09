package com.bumptech.glide.load.data;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import java.io.IOException;
import java.io.OutputStream;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: BufferedOutputStream.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public final class c extends OutputStream {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final OutputStream f16799a;

    /* renamed from: b  reason: collision with root package name */
    private byte[] f16800b;

    /* renamed from: c  reason: collision with root package name */
    private com.bumptech.glide.load.engine.bitmap_recycle.b f16801c;

    /* renamed from: d  reason: collision with root package name */
    private int f16802d;

    public c(@NonNull OutputStream outputStream, @NonNull com.bumptech.glide.load.engine.bitmap_recycle.b bVar) {
        this(outputStream, bVar, 65536);
    }

    private void a() throws IOException {
        int i4 = this.f16802d;
        if (i4 > 0) {
            this.f16799a.write(this.f16800b, 0, i4);
            this.f16802d = 0;
        }
    }

    private void b() throws IOException {
        if (this.f16802d == this.f16800b.length) {
            a();
        }
    }

    private void c() {
        byte[] bArr = this.f16800b;
        if (bArr != null) {
            this.f16801c.put(bArr);
            this.f16800b = null;
        }
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        try {
            flush();
            this.f16799a.close();
            c();
        } catch (Throwable th) {
            this.f16799a.close();
            throw th;
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        a();
        this.f16799a.flush();
    }

    @Override // java.io.OutputStream
    public void write(int i4) throws IOException {
        byte[] bArr = this.f16800b;
        int i5 = this.f16802d;
        this.f16802d = i5 + 1;
        bArr[i5] = (byte) i4;
        b();
    }

    @VisibleForTesting
    c(@NonNull OutputStream outputStream, com.bumptech.glide.load.engine.bitmap_recycle.b bVar, int i4) {
        this.f16799a = outputStream;
        this.f16801c = bVar;
        this.f16800b = (byte[]) bVar.c(i4, byte[].class);
    }

    @Override // java.io.OutputStream
    public void write(@NonNull byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public void write(@NonNull byte[] bArr, int i4, int i5) throws IOException {
        int i6 = 0;
        do {
            int i7 = i5 - i6;
            int i8 = i4 + i6;
            int i9 = this.f16802d;
            if (i9 == 0 && i7 >= this.f16800b.length) {
                this.f16799a.write(bArr, i8, i7);
                return;
            }
            int min = Math.min(i7, this.f16800b.length - i9);
            System.arraycopy(bArr, i8, this.f16800b, this.f16802d, min);
            this.f16802d += min;
            i6 += min;
            b();
        } while (i6 < i5);
    }
}
