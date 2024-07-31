package com.danikula.videocache;

import java.lang.Thread;
import java.util.concurrent.atomic.AtomicInteger;
import org.slf4j.InterfaceC15424c;
import org.slf4j.LoggerFactory;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProxyCache.java */
/* renamed from: com.danikula.videocache.o */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class C6568o {

    /* renamed from: i */
    private static final InterfaceC15424c f23134i = LoggerFactory.m2655j("ProxyCache");

    /* renamed from: j */
    private static final int f23135j = 1;

    /* renamed from: a */
    private final InterfaceC6572q f23136a;

    /* renamed from: b */
    private final InterfaceC6541d f23137b;

    /* renamed from: f */
    private volatile Thread f23141f;

    /* renamed from: g */
    private volatile boolean f23142g;

    /* renamed from: c */
    private final Object f23138c = new Object();

    /* renamed from: d */
    private final Object f23139d = new Object();

    /* renamed from: h */
    private volatile int f23143h = -1;

    /* renamed from: e */
    private final AtomicInteger f23140e = new AtomicInteger();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ProxyCache.java */
    /* renamed from: com.danikula.videocache.o$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class RunnableC6570b implements Runnable {
        private RunnableC6570b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C6568o.this.m35846k();
        }
    }

    public C6568o(InterfaceC6572q interfaceC6572q, InterfaceC6541d interfaceC6541d) {
        this.f23136a = (InterfaceC6572q) C6567n.m35858d(interfaceC6572q);
        this.f23137b = (InterfaceC6541d) C6567n.m35858d(interfaceC6541d);
    }

    /* renamed from: b */
    private void m35855b() throws ProxyCacheException {
        int i = this.f23140e.get();
        if (i < 1) {
            return;
        }
        this.f23140e.set(0);
        throw new ProxyCacheException("Error reading source " + i + " times");
    }

    /* renamed from: c */
    private void m35854c() {
        try {
            this.f23136a.close();
        } catch (ProxyCacheException e) {
            m35849h(new ProxyCacheException("Error closing source " + this.f23136a, e));
        }
    }

    /* renamed from: d */
    private boolean m35853d() {
        return Thread.currentThread().isInterrupted() || this.f23142g;
    }

    /* renamed from: e */
    private void m35852e(long j, long j2) {
        m35851f(j, j2);
        synchronized (this.f23138c) {
            this.f23138c.notifyAll();
        }
    }

    /* renamed from: i */
    private void m35848i() {
        this.f23143h = 100;
        mo35850g(this.f23143h);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public void m35846k() {
        long j = -1;
        long j2 = 0;
        try {
            j2 = this.f23137b.available();
            this.f23136a.mo35833a(j2);
            j = this.f23136a.length();
            byte[] bArr = new byte[8192];
            while (true) {
                int read = this.f23136a.read(bArr);
                if (read != -1) {
                    synchronized (this.f23139d) {
                        if (m35853d()) {
                            return;
                        }
                        this.f23137b.mo35942a(bArr, read);
                    }
                    j2 += read;
                    m35852e(j2, j);
                } else {
                    m35843n();
                    m35848i();
                    break;
                }
            }
        } finally {
            try {
            } finally {
            }
        }
    }

    /* renamed from: l */
    private synchronized void m35845l() throws ProxyCacheException {
        boolean z = (this.f23141f == null || this.f23141f.getState() == Thread.State.TERMINATED) ? false : true;
        if (!this.f23142g && !this.f23137b.isCompleted() && !z) {
            RunnableC6570b runnableC6570b = new RunnableC6570b();
            this.f23141f = new Thread(runnableC6570b, "Source reader for " + this.f23136a);
            this.f23141f.start();
        }
    }

    /* renamed from: n */
    private void m35843n() throws ProxyCacheException {
        synchronized (this.f23139d) {
            if (!m35853d() && this.f23137b.available() == this.f23136a.length()) {
                this.f23137b.complete();
            }
        }
    }

    /* renamed from: o */
    private void m35842o() throws ProxyCacheException {
        synchronized (this.f23138c) {
            try {
                try {
                    this.f23138c.wait(1000L);
                } catch (InterruptedException e) {
                    throw new ProxyCacheException("Waiting source data is interrupted!", e);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* renamed from: f */
    protected void m35851f(long j, long j2) {
        int i = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1)) == 0 ? 100 : (int) ((((float) j) / ((float) j2)) * 100.0f);
        boolean z = i != this.f23143h;
        if ((j2 >= 0) && z) {
            mo35850g(i);
        }
        this.f23143h = i;
    }

    /* renamed from: g */
    protected void mo35850g(int i) {
    }

    /* renamed from: h */
    protected final void m35849h(Throwable th) {
        if (th instanceof InterruptedProxyCacheException) {
            f23134i.debug("ProxyCache is interrupted");
        } else {
            f23134i.error("ProxyCache error", th);
        }
    }

    /* renamed from: j */
    public int m35847j(byte[] bArr, long j, int i) throws ProxyCacheException {
        C6571p.m35841a(bArr, j, i);
        while (!this.f23137b.isCompleted() && this.f23137b.available() < i + j && !this.f23142g) {
            m35845l();
            m35842o();
            m35855b();
        }
        int mo35941b = this.f23137b.mo35941b(bArr, j, i);
        if (this.f23137b.isCompleted() && this.f23143h != 100) {
            this.f23143h = 100;
            mo35850g(100);
        }
        return mo35941b;
    }

    /* renamed from: m */
    public void m35844m() {
        synchronized (this.f23139d) {
            InterfaceC15424c interfaceC15424c = f23134i;
            interfaceC15424c.debug("Shutdown proxy for " + this.f23136a);
            try {
                this.f23142g = true;
                if (this.f23141f != null) {
                    this.f23141f.interrupt();
                }
                this.f23137b.close();
            } catch (ProxyCacheException e) {
                m35849h(e);
            }
        }
    }
}
