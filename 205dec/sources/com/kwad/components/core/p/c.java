package com.kwad.components.core.p;

import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import java.io.InputStream;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class c extends InputStream {
    private InputStream Sm;
    private int Sn;
    private volatile float Sp;
    private volatile long Sq;
    private int Sj = -1;
    private int Sk = 10000;
    private long Sl = -1;
    private long So = -1;
    private int Sr = 20480;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(@NonNull InputStream inputStream, int i4) {
        i4 = i4 < 20480 ? 20480 : i4;
        this.Sm = inputStream;
        this.Sp = i4 / 1000.0f;
    }

    @WorkerThread
    private static void H(long j4) {
        try {
            Thread.sleep(j4);
        } catch (InterruptedException e4) {
            e4.printStackTrace();
        }
    }

    private static long g(long j4, long j5) {
        if (j4 <= 0) {
            return 0L;
        }
        if (j5 <= 0) {
            return -1L;
        }
        return j4 / j5;
    }

    private void qF() {
        this.Sj = 0;
        this.Sl = System.currentTimeMillis();
    }

    private void qG() {
        if (this.Sj < this.Sk) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j4 = currentTimeMillis - this.Sl;
        float f4 = this.Sj / this.Sp;
        this.Sq = g(this.Sn, currentTimeMillis - this.So);
        float f5 = (float) j4;
        if (f4 > f5) {
            H(f4 - f5);
        }
        qF();
    }

    @Override // java.io.InputStream
    public final int available() {
        return this.Sm.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.Sm.close();
        b.a(this);
        this.So = -1L;
    }

    @Override // java.io.InputStream
    public final synchronized void mark(int i4) {
        this.Sm.mark(i4);
    }

    @Override // java.io.InputStream
    public final boolean markSupported() {
        return this.Sm.markSupported();
    }

    public final long qE() {
        return this.Sq;
    }

    @Override // java.io.InputStream
    public final int read() {
        if (this.So <= 0) {
            this.So = System.currentTimeMillis();
        }
        this.Sn++;
        if (!(b.Sh && b.Sg)) {
            return this.Sm.read();
        }
        if (this.Sj < 0) {
            qF();
        }
        int read = this.Sm.read();
        this.Sj++;
        qG();
        return read;
    }

    @Override // java.io.InputStream
    public final synchronized void reset() {
        this.Sm.reset();
    }

    @Override // java.io.InputStream
    public final long skip(long j4) {
        return this.Sm.skip(j4);
    }
}
