package com.danikula.videocache;

import java.lang.Thread;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* compiled from: ProxyCache.java */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class o {

    /* renamed from: i  reason: collision with root package name */
    private static final org.slf4j.c f36801i = org.slf4j.d.j("ProxyCache");

    /* renamed from: j  reason: collision with root package name */
    private static final int f36802j = 1;

    /* renamed from: a  reason: collision with root package name */
    private final q f36803a;

    /* renamed from: b  reason: collision with root package name */
    private final d f36804b;

    /* renamed from: f  reason: collision with root package name */
    private volatile Thread f36808f;

    /* renamed from: g  reason: collision with root package name */
    private volatile boolean f36809g;

    /* renamed from: c  reason: collision with root package name */
    private final Object f36805c = new Object();

    /* renamed from: d  reason: collision with root package name */
    private final Object f36806d = new Object();

    /* renamed from: h  reason: collision with root package name */
    private volatile int f36810h = -1;

    /* renamed from: e  reason: collision with root package name */
    private final AtomicInteger f36807e = new AtomicInteger();

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: ProxyCache.java */
    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    public class b implements Runnable {
        private b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            o.this.k();
        }
    }

    public o(q qVar, d dVar) {
        this.f36803a = (q) n.d(qVar);
        this.f36804b = (d) n.d(dVar);
    }

    private void b() throws ProxyCacheException {
        int i4 = this.f36807e.get();
        if (i4 < 1) {
            return;
        }
        this.f36807e.set(0);
        throw new ProxyCacheException("Error reading source " + i4 + " times");
    }

    private void c() {
        try {
            this.f36803a.close();
        } catch (ProxyCacheException e4) {
            h(new ProxyCacheException("Error closing source " + this.f36803a, e4));
        }
    }

    private boolean d() {
        return Thread.currentThread().isInterrupted() || this.f36809g;
    }

    private void e(long j4, long j5) {
        f(j4, j5);
        synchronized (this.f36805c) {
            this.f36805c.notifyAll();
        }
    }

    private void i() {
        this.f36810h = 100;
        g(this.f36810h);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        long j4 = -1;
        long j5 = 0;
        try {
            j5 = this.f36804b.available();
            this.f36803a.a(j5);
            j4 = this.f36803a.length();
            byte[] bArr = new byte[8192];
            while (true) {
                int read = this.f36803a.read(bArr);
                if (read != -1) {
                    synchronized (this.f36806d) {
                        if (d()) {
                            return;
                        }
                        this.f36804b.a(bArr, read);
                    }
                    j5 += read;
                    e(j5, j4);
                } else {
                    n();
                    i();
                    break;
                }
            }
        } finally {
            try {
            } finally {
            }
        }
    }

    private synchronized void l() throws ProxyCacheException {
        boolean z3 = (this.f36808f == null || this.f36808f.getState() == Thread.State.TERMINATED) ? false : true;
        if (!this.f36809g && !this.f36804b.isCompleted() && !z3) {
            b bVar = new b();
            this.f36808f = new Thread(bVar, "Source reader for " + this.f36803a);
            this.f36808f.start();
        }
    }

    private void n() throws ProxyCacheException {
        synchronized (this.f36806d) {
            if (!d() && this.f36804b.available() == this.f36803a.length()) {
                this.f36804b.complete();
            }
        }
    }

    private void o() throws ProxyCacheException {
        synchronized (this.f36805c) {
            try {
                try {
                    this.f36805c.wait(1000L);
                } catch (InterruptedException e4) {
                    throw new ProxyCacheException("Waiting source data is interrupted!", e4);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    protected void f(long j4, long j5) {
        int i4 = (j5 > 0L ? 1 : (j5 == 0L ? 0 : -1)) == 0 ? 100 : (int) ((((float) j4) / ((float) j5)) * 100.0f);
        boolean z3 = i4 != this.f36810h;
        if ((j5 >= 0) && z3) {
            g(i4);
        }
        this.f36810h = i4;
    }

    protected void g(int i4) {
    }

    protected final void h(Throwable th) {
        if (th instanceof InterruptedProxyCacheException) {
            f36801i.debug("ProxyCache is interrupted");
        } else {
            f36801i.error("ProxyCache error", th);
        }
    }

    public int j(byte[] bArr, long j4, int i4) throws ProxyCacheException {
        p.a(bArr, j4, i4);
        while (!this.f36804b.isCompleted() && this.f36804b.available() < i4 + j4 && !this.f36809g) {
            l();
            o();
            b();
        }
        int b4 = this.f36804b.b(bArr, j4, i4);
        if (this.f36804b.isCompleted() && this.f36810h != 100) {
            this.f36810h = 100;
            g(100);
        }
        return b4;
    }

    public void m() {
        synchronized (this.f36806d) {
            org.slf4j.c cVar = f36801i;
            cVar.debug("Shutdown proxy for " + this.f36803a);
            try {
                this.f36809g = true;
                if (this.f36808f != null) {
                    this.f36808f.interrupt();
                }
                this.f36804b.close();
            } catch (ProxyCacheException e4) {
                h(e4);
            }
        }
    }
}
