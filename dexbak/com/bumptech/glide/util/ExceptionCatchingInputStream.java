package com.bumptech.glide.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;

/* renamed from: com.bumptech.glide.util.c */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class ExceptionCatchingInputStream extends InputStream {

    /* renamed from: c */
    private static final Queue<ExceptionCatchingInputStream> f14544c = C3771k.m44385f(0);

    /* renamed from: a */
    private InputStream f14545a;

    /* renamed from: b */
    private IOException f14546b;

    ExceptionCatchingInputStream() {
    }

    /* renamed from: a */
    static void m44420a() {
        while (true) {
            Queue<ExceptionCatchingInputStream> queue = f14544c;
            if (queue.isEmpty()) {
                return;
            }
            queue.remove();
        }
    }

    @NonNull
    /* renamed from: c */
    public static ExceptionCatchingInputStream m44418c(@NonNull InputStream inputStream) {
        ExceptionCatchingInputStream poll;
        Queue<ExceptionCatchingInputStream> queue = f14544c;
        synchronized (queue) {
            poll = queue.poll();
        }
        if (poll == null) {
            poll = new ExceptionCatchingInputStream();
        }
        poll.m44416e(inputStream);
        return poll;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        return this.f14545a.available();
    }

    @Nullable
    /* renamed from: b */
    public IOException m44419b() {
        return this.f14546b;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f14545a.close();
    }

    /* renamed from: d */
    public void m44417d() {
        this.f14546b = null;
        this.f14545a = null;
        Queue<ExceptionCatchingInputStream> queue = f14544c;
        synchronized (queue) {
            queue.offer(this);
        }
    }

    /* renamed from: e */
    void m44416e(@NonNull InputStream inputStream) {
        this.f14545a = inputStream;
    }

    @Override // java.io.InputStream
    public void mark(int i) {
        this.f14545a.mark(i);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.f14545a.markSupported();
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        try {
            return this.f14545a.read(bArr);
        } catch (IOException e) {
            this.f14546b = e;
            return -1;
        }
    }

    @Override // java.io.InputStream
    public synchronized void reset() throws IOException {
        this.f14545a.reset();
    }

    @Override // java.io.InputStream
    public long skip(long j) {
        try {
            return this.f14545a.skip(j);
        } catch (IOException e) {
            this.f14546b = e;
            return 0L;
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        try {
            return this.f14545a.read(bArr, i, i2);
        } catch (IOException e) {
            this.f14546b = e;
            return -1;
        }
    }

    @Override // java.io.InputStream
    public int read() {
        try {
            return this.f14545a.read();
        } catch (IOException e) {
            this.f14546b = e;
            return -1;
        }
    }
}
