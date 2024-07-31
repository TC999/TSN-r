package com.beizi.p051ad.internal.p058b;

import com.beizi.p051ad.internal.utilities.HaoboLog;
import java.lang.Thread;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.beizi.ad.internal.b.l */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class ProxyCache {

    /* renamed from: a */
    private final InterfaceC2875o f10052a;

    /* renamed from: b */
    private final InterfaceC2862a f10053b;

    /* renamed from: f */
    private volatile Thread f10057f;

    /* renamed from: g */
    private volatile boolean f10058g;

    /* renamed from: c */
    private final Object f10054c = new Object();

    /* renamed from: d */
    private final Object f10055d = new Object();

    /* renamed from: h */
    private volatile int f10059h = -1;

    /* renamed from: e */
    private final AtomicInteger f10056e = new AtomicInteger();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ProxyCache.java */
    /* renamed from: com.beizi.ad.internal.b.l$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public class RunnableC2874a implements Runnable {
        private RunnableC2874a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ProxyCache.this.m49557e();
        }
    }

    public ProxyCache(InterfaceC2875o interfaceC2875o, InterfaceC2862a interfaceC2862a) {
        this.f10052a = (InterfaceC2875o) Preconditions.m49572a(interfaceC2875o);
        this.f10053b = (InterfaceC2862a) Preconditions.m49572a(interfaceC2862a);
    }

    /* renamed from: b */
    private void m49561b() throws ProxyCacheException {
        int i = this.f10056e.get();
        if (i < 1) {
            return;
        }
        this.f10056e.set(0);
        throw new ProxyCacheException("Error reading source " + i + " times");
    }

    /* renamed from: c */
    private synchronized void m49559c() throws ProxyCacheException {
        boolean z = (this.f10057f == null || this.f10057f.getState() == Thread.State.TERMINATED) ? false : true;
        if (!this.f10058g && !this.f10053b.mo49644d() && !z) {
            RunnableC2874a runnableC2874a = new RunnableC2874a();
            this.f10057f = new Thread(runnableC2874a, "Source reader for " + this.f10052a);
            this.f10057f.start();
        }
    }

    /* renamed from: d */
    private void m49558d() throws ProxyCacheException {
        synchronized (this.f10054c) {
            try {
                try {
                    this.f10054c.wait(1000L);
                } catch (InterruptedException e) {
                    throw new ProxyCacheException("Waiting source data is interrupted!", e);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m49557e() {
        Throwable th;
        int i;
        int i2 = 0;
        try {
            i2 = this.f10053b.mo49650a();
            this.f10052a.mo49544a(i2);
            i = this.f10052a.mo49545a();
            try {
                byte[] bArr = new byte[8192];
                while (true) {
                    int mo49543a = this.f10052a.mo49543a(bArr);
                    if (mo49543a != -1) {
                        synchronized (this.f10055d) {
                            if (m49554h()) {
                                return;
                            }
                            this.f10053b.mo49648a(bArr, mo49543a);
                        }
                        i2 += mo49543a;
                        m49560b(i2, i);
                    } else {
                        m49555g();
                        m49556f();
                        break;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                try {
                    this.f10056e.incrementAndGet();
                    m49563a(th);
                } finally {
                    m49553i();
                    m49560b(i2, i);
                }
            }
        } catch (Throwable th3) {
            th = th3;
            i = -1;
        }
    }

    /* renamed from: f */
    private void m49556f() {
        this.f10059h = 100;
        mo49566a(this.f10059h);
    }

    /* renamed from: g */
    private void m49555g() throws ProxyCacheException {
        synchronized (this.f10055d) {
            if (!m49554h() && this.f10053b.mo49650a() == this.f10052a.mo49545a()) {
                this.f10053b.mo49645c();
            }
        }
    }

    /* renamed from: h */
    private boolean m49554h() {
        return Thread.currentThread().isInterrupted() || this.f10058g;
    }

    /* renamed from: i */
    private void m49553i() {
        try {
            this.f10052a.mo49542b();
        } catch (ProxyCacheException e) {
            m49563a(new ProxyCacheException("Error closing source " + this.f10052a, e));
        }
    }

    /* renamed from: a */
    protected void mo49566a(int i) {
    }

    /* renamed from: a */
    public int m49562a(byte[] bArr, long j, int i) throws ProxyCacheException {
        ProxyCacheUtils.m49549a(bArr, j, i);
        while (!this.f10053b.mo49644d() && this.f10053b.mo49650a() < i + j && !this.f10058g) {
            m49559c();
            m49558d();
            m49561b();
        }
        int mo49647a = this.f10053b.mo49647a(bArr, j, i);
        if (this.f10053b.mo49644d() && this.f10059h != 100) {
            this.f10059h = 100;
            mo49566a(100);
        }
        return mo49647a;
    }

    /* renamed from: b */
    private void m49560b(long j, long j2) {
        m49565a(j, j2);
        synchronized (this.f10054c) {
            this.f10054c.notifyAll();
        }
    }

    /* renamed from: a */
    public void m49567a() {
        synchronized (this.f10055d) {
            String str = HaoboLog.proxyCacheLogTag;
            HaoboLog.m49292d(str, "Shutdown proxy for " + this.f10052a);
            try {
                this.f10058g = true;
                if (this.f10057f != null) {
                    this.f10057f.interrupt();
                }
                this.f10053b.mo49646b();
            } catch (ProxyCacheException e) {
                m49563a(e);
            }
        }
    }

    /* renamed from: a */
    protected void m49565a(long j, long j2) {
        int i = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1)) == 0 ? 100 : (int) ((j * 100) / j2);
        boolean z = i != this.f10059h;
        if ((j2 >= 0) && z) {
            mo49566a(i);
        }
        this.f10059h = i;
    }

    /* renamed from: a */
    protected final void m49563a(Throwable th) {
        if (th instanceof InterruptedProxyCacheException) {
            HaoboLog.m49292d(HaoboLog.proxyCacheLogTag, "ProxyCache is interrupted");
        } else {
            HaoboLog.m49289e(HaoboLog.proxyCacheLogTag, "ProxyCache error", th);
        }
    }
}
