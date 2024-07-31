package com.bumptech.glide.load.data;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import java.io.IOException;
import java.io.OutputStream;

/* renamed from: com.bumptech.glide.load.data.c */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class BufferedOutputStream extends OutputStream {
    @NonNull

    /* renamed from: a */
    private final OutputStream f13476a;

    /* renamed from: b */
    private byte[] f13477b;

    /* renamed from: c */
    private ArrayPool f13478c;

    /* renamed from: d */
    private int f13479d;

    public BufferedOutputStream(@NonNull OutputStream outputStream, @NonNull ArrayPool arrayPool) {
        this(outputStream, arrayPool, 65536);
    }

    /* renamed from: a */
    private void m45479a() throws IOException {
        int i = this.f13479d;
        if (i > 0) {
            this.f13476a.write(this.f13477b, 0, i);
            this.f13479d = 0;
        }
    }

    /* renamed from: b */
    private void m45478b() throws IOException {
        if (this.f13479d == this.f13477b.length) {
            m45479a();
        }
    }

    /* renamed from: c */
    private void m45477c() {
        byte[] bArr = this.f13477b;
        if (bArr != null) {
            this.f13478c.put(bArr);
            this.f13477b = null;
        }
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        try {
            flush();
            this.f13476a.close();
            m45477c();
        } catch (Throwable th) {
            this.f13476a.close();
            throw th;
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        m45479a();
        this.f13476a.flush();
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        byte[] bArr = this.f13477b;
        int i2 = this.f13479d;
        this.f13479d = i2 + 1;
        bArr[i2] = (byte) i;
        m45478b();
    }

    @VisibleForTesting
    BufferedOutputStream(@NonNull OutputStream outputStream, ArrayPool arrayPool, int i) {
        this.f13476a = outputStream;
        this.f13478c = arrayPool;
        this.f13477b = (byte[]) arrayPool.mo45394c(i, byte[].class);
    }

    @Override // java.io.OutputStream
    public void write(@NonNull byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public void write(@NonNull byte[] bArr, int i, int i2) throws IOException {
        int i3 = 0;
        do {
            int i4 = i2 - i3;
            int i5 = i + i3;
            int i6 = this.f13479d;
            if (i6 == 0 && i4 >= this.f13477b.length) {
                this.f13476a.write(bArr, i5, i4);
                return;
            }
            int min = Math.min(i4, this.f13477b.length - i6);
            System.arraycopy(bArr, i5, this.f13477b, this.f13479d, min);
            this.f13479d += min;
            i3 += min;
            m45478b();
        } while (i3 < i2);
    }
}
