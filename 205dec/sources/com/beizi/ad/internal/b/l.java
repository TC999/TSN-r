package com.beizi.ad.internal.b;

import com.beizi.ad.internal.utilities.HaoboLog;
import java.lang.Thread;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: ProxyCache.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    private final o f13729a;

    /* renamed from: b  reason: collision with root package name */
    private final com.beizi.ad.internal.b.a f13730b;

    /* renamed from: f  reason: collision with root package name */
    private volatile Thread f13734f;

    /* renamed from: g  reason: collision with root package name */
    private volatile boolean f13735g;

    /* renamed from: c  reason: collision with root package name */
    private final Object f13731c = new Object();

    /* renamed from: d  reason: collision with root package name */
    private final Object f13732d = new Object();

    /* renamed from: h  reason: collision with root package name */
    private volatile int f13736h = -1;

    /* renamed from: e  reason: collision with root package name */
    private final AtomicInteger f13733e = new AtomicInteger();

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: ProxyCache.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public class a implements Runnable {
        private a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            l.this.e();
        }
    }

    public l(o oVar, com.beizi.ad.internal.b.a aVar) {
        this.f13729a = (o) k.a(oVar);
        this.f13730b = (com.beizi.ad.internal.b.a) k.a(aVar);
    }

    private void b() throws m {
        int i4 = this.f13733e.get();
        if (i4 < 1) {
            return;
        }
        this.f13733e.set(0);
        throw new m("Error reading source " + i4 + " times");
    }

    private synchronized void c() throws m {
        boolean z3 = (this.f13734f == null || this.f13734f.getState() == Thread.State.TERMINATED) ? false : true;
        if (!this.f13735g && !this.f13730b.d() && !z3) {
            a aVar = new a();
            this.f13734f = new Thread(aVar, "Source reader for " + this.f13729a);
            this.f13734f.start();
        }
    }

    private void d() throws m {
        synchronized (this.f13731c) {
            try {
                try {
                    this.f13731c.wait(1000L);
                } catch (InterruptedException e4) {
                    throw new m("Waiting source data is interrupted!", e4);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        Throwable th;
        int i4;
        int i5 = 0;
        try {
            i5 = this.f13730b.a();
            this.f13729a.a(i5);
            i4 = this.f13729a.a();
            try {
                byte[] bArr = new byte[8192];
                while (true) {
                    int a4 = this.f13729a.a(bArr);
                    if (a4 != -1) {
                        synchronized (this.f13732d) {
                            if (h()) {
                                return;
                            }
                            this.f13730b.a(bArr, a4);
                        }
                        i5 += a4;
                        b(i5, i4);
                    } else {
                        g();
                        f();
                        break;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                try {
                    this.f13733e.incrementAndGet();
                    a(th);
                } finally {
                    i();
                    b(i5, i4);
                }
            }
        } catch (Throwable th3) {
            th = th3;
            i4 = -1;
        }
    }

    private void f() {
        this.f13736h = 100;
        a(this.f13736h);
    }

    private void g() throws m {
        synchronized (this.f13732d) {
            if (!h() && this.f13730b.a() == this.f13729a.a()) {
                this.f13730b.c();
            }
        }
    }

    private boolean h() {
        return Thread.currentThread().isInterrupted() || this.f13735g;
    }

    private void i() {
        try {
            this.f13729a.b();
        } catch (m e4) {
            a(new m("Error closing source " + this.f13729a, e4));
        }
    }

    protected void a(int i4) {
    }

    public int a(byte[] bArr, long j4, int i4) throws m {
        n.a(bArr, j4, i4);
        while (!this.f13730b.d() && this.f13730b.a() < i4 + j4 && !this.f13735g) {
            c();
            d();
            b();
        }
        int a4 = this.f13730b.a(bArr, j4, i4);
        if (this.f13730b.d() && this.f13736h != 100) {
            this.f13736h = 100;
            a(100);
        }
        return a4;
    }

    private void b(long j4, long j5) {
        a(j4, j5);
        synchronized (this.f13731c) {
            this.f13731c.notifyAll();
        }
    }

    public void a() {
        synchronized (this.f13732d) {
            String str = HaoboLog.proxyCacheLogTag;
            HaoboLog.d(str, "Shutdown proxy for " + this.f13729a);
            try {
                this.f13735g = true;
                if (this.f13734f != null) {
                    this.f13734f.interrupt();
                }
                this.f13730b.b();
            } catch (m e4) {
                a(e4);
            }
        }
    }

    protected void a(long j4, long j5) {
        int i4 = (j5 > 0L ? 1 : (j5 == 0L ? 0 : -1)) == 0 ? 100 : (int) ((j4 * 100) / j5);
        boolean z3 = i4 != this.f13736h;
        if ((j5 >= 0) && z3) {
            a(i4);
        }
        this.f13736h = i4;
    }

    protected final void a(Throwable th) {
        if (th instanceof i) {
            HaoboLog.d(HaoboLog.proxyCacheLogTag, "ProxyCache is interrupted");
        } else {
            HaoboLog.e(HaoboLog.proxyCacheLogTag, "ProxyCache error", th);
        }
    }
}
