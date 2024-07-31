package com.kwad.sdk.core.videocache;

import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.utils.C11023ap;
import java.lang.Thread;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.kwad.sdk.core.videocache.k */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C10578k {
    private final InterfaceC10581m aCp;
    private final InterfaceC10548a aCq;
    private volatile Thread aCu;

    /* renamed from: kI */
    private volatile boolean f29613kI;
    private final Object aCr = new Object();
    private final Object aCs = new Object();
    private volatile int aCv = -1;
    private final AtomicInteger aCt = new AtomicInteger();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwad.sdk.core.videocache.k$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public class RunnableC10579a implements Runnable {
        private RunnableC10579a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            C10578k.this.m25405GD();
        }

        /* synthetic */ RunnableC10579a(C10578k c10578k, byte b) {
            this();
        }
    }

    public C10578k(InterfaceC10581m interfaceC10581m, InterfaceC10548a interfaceC10548a) {
        this.aCp = (InterfaceC10581m) C11023ap.checkNotNull(interfaceC10581m);
        this.aCq = (InterfaceC10548a) C11023ap.checkNotNull(interfaceC10548a);
    }

    /* renamed from: GA */
    private void m25408GA() {
        int i = this.aCt.get();
        if (i <= 0) {
            return;
        }
        this.aCt.set(0);
        throw new ProxyCacheException("Error reading source " + i + " times");
    }

    /* renamed from: GB */
    private synchronized void m25407GB() {
        boolean z = (this.aCu == null || this.aCu.getState() == Thread.State.TERMINATED) ? false : true;
        if (!this.f29613kI && !this.aCq.isCompleted() && !z) {
            RunnableC10579a runnableC10579a = new RunnableC10579a(this, (byte) 0);
            this.aCu = new Thread(runnableC10579a, "Source reader for " + this.aCp);
            this.aCu.start();
        }
    }

    /* renamed from: GC */
    private void m25406GC() {
        synchronized (this.aCr) {
            try {
                try {
                    this.aCr.wait(1000L);
                } catch (InterruptedException e) {
                    throw new ProxyCacheException("Waiting source data is interrupted!", e);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0039, code lost:
        r2 = r2 + r5;
     */
    /* renamed from: GD */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m25405GD() {
        /*
            r8 = this;
            r0 = -1
            r2 = 0
            com.kwad.sdk.core.videocache.a r4 = r8.aCq     // Catch: java.lang.Throwable -> L49
            long r2 = r4.mo25489Go()     // Catch: java.lang.Throwable -> L49
            com.kwad.sdk.core.videocache.m r4 = r8.aCp     // Catch: java.lang.Throwable -> L49
            r4.mo25395at(r2)     // Catch: java.lang.Throwable -> L49
            com.kwad.sdk.core.videocache.m r4 = r8.aCp     // Catch: java.lang.Throwable -> L49
            long r0 = r4.length()     // Catch: java.lang.Throwable -> L49
            r4 = 1024(0x400, float:1.435E-42)
            byte[] r4 = new byte[r4]     // Catch: java.lang.Throwable -> L49
        L19:
            com.kwad.sdk.core.videocache.m r5 = r8.aCp     // Catch: java.lang.Throwable -> L49
            int r5 = r5.read(r4)     // Catch: java.lang.Throwable -> L49
            r6 = -1
            if (r5 == r6) goto L42
            java.lang.Object r6 = r8.aCs     // Catch: java.lang.Throwable -> L49
            monitor-enter(r6)     // Catch: java.lang.Throwable -> L49
            boolean r7 = r8.isStopped()     // Catch: java.lang.Throwable -> L3f
            if (r7 == 0) goto L33
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L3f
        L2c:
            r8.m25403GF()
            r8.m25399j(r2, r0)
            return
        L33:
            com.kwad.sdk.core.videocache.a r7 = r8.aCq     // Catch: java.lang.Throwable -> L3f
            r7.mo25487d(r4, r5)     // Catch: java.lang.Throwable -> L3f
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L3f
            long r5 = (long) r5
            long r2 = r2 + r5
            r8.m25399j(r2, r0)     // Catch: java.lang.Throwable -> L49
            goto L19
        L3f:
            r4 = move-exception
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L3f
            throw r4     // Catch: java.lang.Throwable -> L49
        L42:
            r8.tryComplete()     // Catch: java.lang.Throwable -> L49
            r8.m25404GE()     // Catch: java.lang.Throwable -> L49
            goto L2c
        L49:
            r4 = move-exception
            java.util.concurrent.atomic.AtomicInteger r5 = r8.aCt     // Catch: java.lang.Throwable -> L53
            r5.incrementAndGet()     // Catch: java.lang.Throwable -> L53
            onError(r4)     // Catch: java.lang.Throwable -> L53
            goto L2c
        L53:
            r4 = move-exception
            r8.m25403GF()
            r8.m25399j(r2, r0)
            goto L5c
        L5b:
            throw r4
        L5c:
            goto L5b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.core.videocache.C10578k.m25405GD():void");
    }

    /* renamed from: GE */
    private void m25404GE() {
        this.aCv = 100;
        mo25400dr(this.aCv);
    }

    /* renamed from: GF */
    private void m25403GF() {
        try {
            this.aCp.close();
        } catch (ProxyCacheException e) {
            onError(new ProxyCacheException("Error closing source " + this.aCp, e));
        }
    }

    private boolean isStopped() {
        return Thread.currentThread().isInterrupted() || this.f29613kI;
    }

    /* renamed from: j */
    private void m25399j(long j, long j2) {
        m25398k(j, j2);
        synchronized (this.aCr) {
            this.aCr.notifyAll();
        }
    }

    /* renamed from: k */
    private void m25398k(long j, long j2) {
        int i = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1)) == 0 ? 100 : (int) ((((float) j) / ((float) j2)) * 100.0f);
        boolean z = i != this.aCv;
        if ((j2 >= 0) && z) {
            mo25400dr(i);
        }
        this.aCv = i;
    }

    private static void onError(Throwable th) {
        if (th instanceof InterruptedProxyCacheException) {
            C10331c.m26254d("ProxyCache", "ProxyCache is interrupted");
        } else {
            C10331c.m26250e("ProxyCache", "ProxyCache error");
        }
    }

    private void tryComplete() {
        synchronized (this.aCs) {
            if (!isStopped() && this.aCq.mo25489Go() == this.aCp.length()) {
                this.aCq.complete();
            }
        }
    }

    /* renamed from: dr */
    protected void mo25400dr(int i) {
    }

    public final void shutdown() {
        synchronized (this.aCs) {
            C10331c.m26254d("ProxyCache", "Shutdown proxy for " + this.aCp);
            try {
                this.f29613kI = true;
                if (this.aCu != null) {
                    this.aCu.interrupt();
                }
                this.aCq.close();
            } catch (ProxyCacheException e) {
                onError(e);
            }
        }
    }

    /* renamed from: a */
    public final int m25401a(byte[] bArr, long j, int i) {
        C10580l.m25397b(bArr, j, 1024);
        while (!this.aCq.isCompleted() && this.aCq.mo25489Go() < 1024 + j && !this.f29613kI) {
            m25407GB();
            m25406GC();
            m25408GA();
        }
        int mo25488a = this.aCq.mo25488a(bArr, j, 1024);
        if (this.aCq.isCompleted() && this.aCv != 100) {
            this.aCv = 100;
            mo25400dr(100);
        }
        return mo25488a;
    }
}
