package com.kwad.sdk.core.videocache;

import com.kwad.sdk.utils.ap;
import java.lang.Thread;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class k {
    private final m aCp;
    private final com.kwad.sdk.core.videocache.a aCq;
    private volatile Thread aCu;
    private volatile boolean kI;
    private final Object aCr = new Object();
    private final Object aCs = new Object();
    private volatile int aCv = -1;
    private final AtomicInteger aCt = new AtomicInteger();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public class a implements Runnable {
        private a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            k.this.GD();
        }

        /* synthetic */ a(k kVar, byte b4) {
            this();
        }
    }

    public k(m mVar, com.kwad.sdk.core.videocache.a aVar) {
        this.aCp = (m) ap.checkNotNull(mVar);
        this.aCq = (com.kwad.sdk.core.videocache.a) ap.checkNotNull(aVar);
    }

    private void GA() {
        int i4 = this.aCt.get();
        if (i4 <= 0) {
            return;
        }
        this.aCt.set(0);
        throw new ProxyCacheException("Error reading source " + i4 + " times");
    }

    private synchronized void GB() {
        boolean z3 = (this.aCu == null || this.aCu.getState() == Thread.State.TERMINATED) ? false : true;
        if (!this.kI && !this.aCq.isCompleted() && !z3) {
            a aVar = new a(this, (byte) 0);
            this.aCu = new Thread(aVar, "Source reader for " + this.aCp);
            this.aCu.start();
        }
    }

    private void GC() {
        synchronized (this.aCr) {
            try {
                try {
                    this.aCr.wait(1000L);
                } catch (InterruptedException e4) {
                    throw new ProxyCacheException("Waiting source data is interrupted!", e4);
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
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void GD() {
        /*
            r8 = this;
            r0 = -1
            r2 = 0
            com.kwad.sdk.core.videocache.a r4 = r8.aCq     // Catch: java.lang.Throwable -> L49
            long r2 = r4.Go()     // Catch: java.lang.Throwable -> L49
            com.kwad.sdk.core.videocache.m r4 = r8.aCp     // Catch: java.lang.Throwable -> L49
            r4.at(r2)     // Catch: java.lang.Throwable -> L49
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
            r8.GF()
            r8.j(r2, r0)
            return
        L33:
            com.kwad.sdk.core.videocache.a r7 = r8.aCq     // Catch: java.lang.Throwable -> L3f
            r7.d(r4, r5)     // Catch: java.lang.Throwable -> L3f
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L3f
            long r5 = (long) r5
            long r2 = r2 + r5
            r8.j(r2, r0)     // Catch: java.lang.Throwable -> L49
            goto L19
        L3f:
            r4 = move-exception
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L3f
            throw r4     // Catch: java.lang.Throwable -> L49
        L42:
            r8.tryComplete()     // Catch: java.lang.Throwable -> L49
            r8.GE()     // Catch: java.lang.Throwable -> L49
            goto L2c
        L49:
            r4 = move-exception
            java.util.concurrent.atomic.AtomicInteger r5 = r8.aCt     // Catch: java.lang.Throwable -> L53
            r5.incrementAndGet()     // Catch: java.lang.Throwable -> L53
            onError(r4)     // Catch: java.lang.Throwable -> L53
            goto L2c
        L53:
            r4 = move-exception
            r8.GF()
            r8.j(r2, r0)
            goto L5c
        L5b:
            throw r4
        L5c:
            goto L5b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.core.videocache.k.GD():void");
    }

    private void GE() {
        this.aCv = 100;
        dr(this.aCv);
    }

    private void GF() {
        try {
            this.aCp.close();
        } catch (ProxyCacheException e4) {
            onError(new ProxyCacheException("Error closing source " + this.aCp, e4));
        }
    }

    private boolean isStopped() {
        return Thread.currentThread().isInterrupted() || this.kI;
    }

    private void j(long j4, long j5) {
        k(j4, j5);
        synchronized (this.aCr) {
            this.aCr.notifyAll();
        }
    }

    private void k(long j4, long j5) {
        int i4 = (j5 > 0L ? 1 : (j5 == 0L ? 0 : -1)) == 0 ? 100 : (int) ((((float) j4) / ((float) j5)) * 100.0f);
        boolean z3 = i4 != this.aCv;
        if ((j5 >= 0) && z3) {
            dr(i4);
        }
        this.aCv = i4;
    }

    private static void onError(Throwable th) {
        if (th instanceof InterruptedProxyCacheException) {
            com.kwad.sdk.core.e.c.d("ProxyCache", "ProxyCache is interrupted");
        } else {
            com.kwad.sdk.core.e.c.e("ProxyCache", "ProxyCache error");
        }
    }

    private void tryComplete() {
        synchronized (this.aCs) {
            if (!isStopped() && this.aCq.Go() == this.aCp.length()) {
                this.aCq.complete();
            }
        }
    }

    protected void dr(int i4) {
    }

    public final void shutdown() {
        synchronized (this.aCs) {
            com.kwad.sdk.core.e.c.d("ProxyCache", "Shutdown proxy for " + this.aCp);
            try {
                this.kI = true;
                if (this.aCu != null) {
                    this.aCu.interrupt();
                }
                this.aCq.close();
            } catch (ProxyCacheException e4) {
                onError(e4);
            }
        }
    }

    public final int a(byte[] bArr, long j4, int i4) {
        l.b(bArr, j4, 1024);
        while (!this.aCq.isCompleted() && this.aCq.Go() < 1024 + j4 && !this.kI) {
            GB();
            GC();
            GA();
        }
        int a4 = this.aCq.a(bArr, j4, 1024);
        if (this.aCq.isCompleted() && this.aCv != 100) {
            this.aCv = 100;
            dr(100);
        }
        return a4;
    }
}
