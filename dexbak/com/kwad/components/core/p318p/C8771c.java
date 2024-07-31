package com.kwad.components.core.p318p;

import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.clj.fastble.BleManager;
import java.io.InputStream;

/* renamed from: com.kwad.components.core.p.c */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8771c extends InputStream {

    /* renamed from: Sm */
    private InputStream f28485Sm;

    /* renamed from: Sn */
    private int f28486Sn;

    /* renamed from: Sp */
    private volatile float f28488Sp;

    /* renamed from: Sq */
    private volatile long f28489Sq;

    /* renamed from: Sj */
    private int f28482Sj = -1;

    /* renamed from: Sk */
    private int f28483Sk = BleManager.f22896l;

    /* renamed from: Sl */
    private long f28484Sl = -1;

    /* renamed from: So */
    private long f28487So = -1;

    /* renamed from: Sr */
    private int f28490Sr = 20480;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C8771c(@NonNull InputStream inputStream, int i) {
        i = i < 20480 ? 20480 : i;
        this.f28485Sm = inputStream;
        this.f28488Sp = i / 1000.0f;
    }

    @WorkerThread
    /* renamed from: H */
    private static void m29877H(long j) {
        try {
            Thread.sleep(j);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: g */
    private static long m29876g(long j, long j2) {
        if (j <= 0) {
            return 0L;
        }
        if (j2 <= 0) {
            return -1L;
        }
        return j / j2;
    }

    /* renamed from: qF */
    private void m29874qF() {
        this.f28482Sj = 0;
        this.f28484Sl = System.currentTimeMillis();
    }

    /* renamed from: qG */
    private void m29873qG() {
        if (this.f28482Sj < this.f28483Sk) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j = currentTimeMillis - this.f28484Sl;
        float f = this.f28482Sj / this.f28488Sp;
        this.f28489Sq = m29876g(this.f28486Sn, currentTimeMillis - this.f28487So);
        float f2 = (float) j;
        if (f > f2) {
            m29877H(f - f2);
        }
        m29874qF();
    }

    @Override // java.io.InputStream
    public final int available() {
        return this.f28485Sm.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f28485Sm.close();
        C8770b.m29883a(this);
        this.f28487So = -1L;
    }

    @Override // java.io.InputStream
    public final synchronized void mark(int i) {
        this.f28485Sm.mark(i);
    }

    @Override // java.io.InputStream
    public final boolean markSupported() {
        return this.f28485Sm.markSupported();
    }

    /* renamed from: qE */
    public final long m29875qE() {
        return this.f28489Sq;
    }

    @Override // java.io.InputStream
    public final int read() {
        if (this.f28487So <= 0) {
            this.f28487So = System.currentTimeMillis();
        }
        this.f28486Sn++;
        if (!(C8770b.f28480Sh && C8770b.f28479Sg)) {
            return this.f28485Sm.read();
        }
        if (this.f28482Sj < 0) {
            m29874qF();
        }
        int read = this.f28485Sm.read();
        this.f28482Sj++;
        m29873qG();
        return read;
    }

    @Override // java.io.InputStream
    public final synchronized void reset() {
        this.f28485Sm.reset();
    }

    @Override // java.io.InputStream
    public final long skip(long j) {
        return this.f28485Sm.skip(j);
    }
}
