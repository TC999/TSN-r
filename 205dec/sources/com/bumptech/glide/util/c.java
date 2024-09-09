package com.bumptech.glide.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: ExceptionCatchingInputStream.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class c extends InputStream {

    /* renamed from: c  reason: collision with root package name */
    private static final Queue<c> f18062c = k.f(0);

    /* renamed from: a  reason: collision with root package name */
    private InputStream f18063a;

    /* renamed from: b  reason: collision with root package name */
    private IOException f18064b;

    c() {
    }

    static void a() {
        while (true) {
            Queue<c> queue = f18062c;
            if (queue.isEmpty()) {
                return;
            }
            queue.remove();
        }
    }

    @NonNull
    public static c c(@NonNull InputStream inputStream) {
        c poll;
        Queue<c> queue = f18062c;
        synchronized (queue) {
            poll = queue.poll();
        }
        if (poll == null) {
            poll = new c();
        }
        poll.e(inputStream);
        return poll;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        return this.f18063a.available();
    }

    @Nullable
    public IOException b() {
        return this.f18064b;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f18063a.close();
    }

    public void d() {
        this.f18064b = null;
        this.f18063a = null;
        Queue<c> queue = f18062c;
        synchronized (queue) {
            queue.offer(this);
        }
    }

    void e(@NonNull InputStream inputStream) {
        this.f18063a = inputStream;
    }

    @Override // java.io.InputStream
    public void mark(int i4) {
        this.f18063a.mark(i4);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.f18063a.markSupported();
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        try {
            return this.f18063a.read(bArr);
        } catch (IOException e4) {
            this.f18064b = e4;
            return -1;
        }
    }

    @Override // java.io.InputStream
    public synchronized void reset() throws IOException {
        this.f18063a.reset();
    }

    @Override // java.io.InputStream
    public long skip(long j4) {
        try {
            return this.f18063a.skip(j4);
        } catch (IOException e4) {
            this.f18064b = e4;
            return 0L;
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i4, int i5) {
        try {
            return this.f18063a.read(bArr, i4, i5);
        } catch (IOException e4) {
            this.f18064b = e4;
            return -1;
        }
    }

    @Override // java.io.InputStream
    public int read() {
        try {
            return this.f18063a.read();
        } catch (IOException e4) {
            this.f18064b = e4;
            return -1;
        }
    }
}
