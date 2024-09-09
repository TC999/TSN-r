package com.bytedance.sdk.component.gd.c;

import com.bytedance.sdk.component.gd.a;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class f implements com.bytedance.sdk.component.gd.w {

    /* renamed from: a  reason: collision with root package name */
    private volatile int f29824a;
    private ThreadPoolExecutor bk;

    /* renamed from: c  reason: collision with root package name */
    private final AtomicInteger f29825c = new AtomicInteger(c(-536870912, 0));
    private volatile long ev;

    /* renamed from: f  reason: collision with root package name */
    private volatile ThreadFactory f29826f;
    private volatile int gd;

    /* renamed from: k  reason: collision with root package name */
    private boolean f29827k;

    /* renamed from: p  reason: collision with root package name */
    private final ThreadPoolExecutor f29828p;

    /* renamed from: r  reason: collision with root package name */
    private volatile RejectedExecutionHandler f29829r;
    private final Condition sr;
    private int ux;

    /* renamed from: w  reason: collision with root package name */
    private final BlockingQueue<Runnable> f29830w;
    private final ReentrantLock xv;

    public f(int i4, int i5, long j4, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory, RejectedExecutionHandler rejectedExecutionHandler, ThreadPoolExecutor threadPoolExecutor) {
        ReentrantLock reentrantLock = new ReentrantLock();
        this.xv = reentrantLock;
        this.sr = reentrantLock.newCondition();
        if (i4 < 0 || i5 <= 0 || i5 < i4 || j4 < 0) {
            throw new IllegalArgumentException();
        }
        if (blockingQueue != null && threadFactory != null && rejectedExecutionHandler != null) {
            this.gd = i4;
            this.f29824a = i5;
            this.f29830w = blockingQueue;
            this.ev = timeUnit.toNanos(j4);
            this.f29826f = threadFactory;
            this.f29829r = rejectedExecutionHandler;
            this.f29828p = threadPoolExecutor;
            return;
        }
        throw null;
    }

    private static int c(int i4) {
        return i4 & (-536870912);
    }

    private static int c(int i4, int i5) {
        return i4 | i5;
    }

    private void c(boolean z3) {
    }

    private List<Runnable> ev() {
        Runnable[] runnableArr;
        BlockingQueue<Runnable> blockingQueue = this.f29830w;
        ArrayList arrayList = new ArrayList();
        blockingQueue.drainTo(arrayList);
        if (!blockingQueue.isEmpty()) {
            for (Runnable runnable : (Runnable[]) blockingQueue.toArray(new Runnable[0])) {
                if (blockingQueue.remove(runnable)) {
                    if (runnable instanceof xv) {
                        arrayList.add(((xv) runnable).f29836c);
                    } else {
                        arrayList.add(runnable);
                    }
                }
            }
        }
        return arrayList;
    }

    private void f() {
        do {
        } while (!ux(this.f29825c.get()));
    }

    private void gd() {
        ReentrantLock reentrantLock = this.xv;
        reentrantLock.lock();
        try {
            f();
            w();
        } finally {
            reentrantLock.unlock();
        }
    }

    private void r() {
        c(false);
    }

    private boolean sr(int i4) {
        return this.f29825c.compareAndSet(i4, i4 + 1);
    }

    private boolean ux(int i4) {
        return this.f29825c.compareAndSet(i4, i4 - 1);
    }

    private static int w(int i4) {
        return i4 & 536870911;
    }

    private static boolean w(int i4, int i5) {
        return i4 < i5;
    }

    private static boolean xv(int i4) {
        return i4 < 0;
    }

    private static boolean xv(int i4, int i5) {
        return i4 >= i5;
    }

    @Override // com.bytedance.sdk.component.gd.w
    public void allowCoreThreadTimeOut(boolean z3) {
        this.f29827k = true;
    }

    @Override // com.bytedance.sdk.component.gd.w
    public boolean allowsCoreThreadTimeOut() {
        return this.f29827k;
    }

    @Override // com.bytedance.sdk.component.gd.w
    public boolean awaitTermination(long j4, TimeUnit timeUnit) throws InterruptedException {
        boolean z3;
        long nanos = timeUnit.toNanos(j4);
        ReentrantLock reentrantLock = this.xv;
        reentrantLock.lock();
        while (true) {
            try {
                if (xv(this.f29825c.get(), 1610612736)) {
                    z3 = true;
                    break;
                } else if (nanos <= 0) {
                    z3 = false;
                    break;
                } else {
                    nanos = this.sr.awaitNanos(nanos);
                }
            } finally {
                reentrantLock.unlock();
            }
        }
        return z3;
    }

    public ThreadPoolExecutor c() {
        if (this.bk == null) {
            this.bk = a.f29806w.p();
        }
        return this.bk;
    }

    @Override // com.bytedance.sdk.component.gd.w
    public void execute(Runnable runnable) {
        runnable.getClass();
        if (runnable instanceof xv) {
            ((xv) runnable).c(this);
        } else {
            runnable = new xv(runnable, this);
        }
        c((xv) runnable);
    }

    protected void finalize() {
        shutdown();
    }

    @Override // com.bytedance.sdk.component.gd.w
    public int getActiveCount() {
        return w(this.f29825c.get());
    }

    @Override // com.bytedance.sdk.component.gd.w
    public long getCompletedTaskCount() {
        return 0L;
    }

    @Override // com.bytedance.sdk.component.gd.w
    public int getCorePoolSize() {
        return this.gd;
    }

    @Override // com.bytedance.sdk.component.gd.w
    public long getKeepAliveTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.ev, TimeUnit.NANOSECONDS);
    }

    @Override // com.bytedance.sdk.component.gd.w
    public int getLargestPoolSize() {
        return 0;
    }

    @Override // com.bytedance.sdk.component.gd.w
    public int getMaximumPoolSize() {
        return this.f29824a;
    }

    @Override // com.bytedance.sdk.component.gd.w
    public int getPoolSize() {
        if (xv(this.f29825c.get(), 1073741824)) {
            return 0;
        }
        return w(this.f29825c.get());
    }

    @Override // com.bytedance.sdk.component.gd.w
    public BlockingQueue<Runnable> getQueue() {
        return this.f29830w;
    }

    @Override // com.bytedance.sdk.component.gd.w
    public RejectedExecutionHandler getRejectedExecutionHandler() {
        return this.f29829r;
    }

    @Override // com.bytedance.sdk.component.gd.w
    public long getTaskCount() {
        return 0L;
    }

    @Override // com.bytedance.sdk.component.gd.w
    public ThreadFactory getThreadFactory() {
        return this.f29826f;
    }

    @Override // com.bytedance.sdk.component.gd.w
    public boolean isShutdown() {
        return !xv(this.f29825c.get());
    }

    @Override // com.bytedance.sdk.component.gd.w
    public boolean isTerminated() {
        return xv(this.f29825c.get(), 1610612736);
    }

    @Override // com.bytedance.sdk.component.gd.w
    public boolean isTerminating() {
        int i4 = this.f29825c.get();
        return !xv(i4) && w(i4, 1610612736);
    }

    @Override // com.bytedance.sdk.component.gd.w
    public int prestartAllCoreThreads() {
        return 0;
    }

    @Override // com.bytedance.sdk.component.gd.w
    public boolean prestartCoreThread() {
        return false;
    }

    @Override // com.bytedance.sdk.component.gd.w
    public void purge() {
        Object[] array;
        BlockingQueue<Runnable> blockingQueue = this.f29830w;
        try {
            Iterator it = blockingQueue.iterator();
            while (it.hasNext()) {
                Runnable runnable = (Runnable) it.next();
                if ((runnable instanceof Future) && ((Future) runnable).isCancelled()) {
                    it.remove();
                }
            }
        } catch (ConcurrentModificationException unused) {
            for (Object obj : blockingQueue.toArray()) {
                if ((obj instanceof Future) && ((Future) obj).isCancelled()) {
                    blockingQueue.remove(obj);
                }
            }
        }
        w();
    }

    @Override // com.bytedance.sdk.component.gd.w
    public boolean remove(Runnable runnable) {
        boolean remove = this.f29830w.remove(runnable);
        w();
        return remove;
    }

    @Override // com.bytedance.sdk.component.gd.w
    public void setCorePoolSize(int i4) {
    }

    @Override // com.bytedance.sdk.component.gd.w
    public void setKeepAliveTime(long j4, TimeUnit timeUnit) {
        if (j4 >= 0) {
            if (j4 == 0 && allowsCoreThreadTimeOut()) {
                throw new IllegalArgumentException("Core threads must have nonzero keep alive times");
            }
            long nanos = timeUnit.toNanos(j4);
            this.ev = nanos;
            if (nanos - this.ev < 0) {
                r();
                return;
            }
            return;
        }
        throw new IllegalArgumentException();
    }

    @Override // com.bytedance.sdk.component.gd.w
    public void setMaximumPoolSize(int i4) {
        if (i4 > 0 && i4 >= this.gd) {
            this.f29824a = i4;
            if (w(this.f29825c.get()) > i4) {
                r();
                return;
            }
            return;
        }
        throw new IllegalArgumentException();
    }

    @Override // com.bytedance.sdk.component.gd.w
    public void setRejectedExecutionHandler(RejectedExecutionHandler rejectedExecutionHandler) {
        rejectedExecutionHandler.getClass();
        this.f29829r = rejectedExecutionHandler;
    }

    @Override // com.bytedance.sdk.component.gd.w
    public void setThreadFactory(ThreadFactory threadFactory) {
        threadFactory.getClass();
        this.f29826f = threadFactory;
    }

    @Override // com.bytedance.sdk.component.gd.w
    public void shutdown() {
        ReentrantLock reentrantLock = this.xv;
        reentrantLock.lock();
        try {
            f(0);
            xv();
            reentrantLock.unlock();
            w();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // com.bytedance.sdk.component.gd.w
    public List<Runnable> shutdownNow() {
        ReentrantLock reentrantLock = this.xv;
        reentrantLock.lock();
        try {
            f(536870912);
            List<Runnable> ev = ev();
            reentrantLock.unlock();
            w();
            return ev;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // com.bytedance.sdk.component.gd.w
    public Future<?> submit(Runnable runnable) {
        if (runnable == null) {
            return null;
        }
        FutureTask futureTask = new FutureTask(runnable, null);
        execute(futureTask);
        return futureTask;
    }

    @Override // com.bytedance.sdk.component.gd.w
    public String toString() {
        String str;
        int i4 = this.f29825c.get();
        if (w(i4, 0)) {
            str = "Running";
        } else {
            str = xv(i4, 1610612736) ? "Terminated" : "Shutting down";
        }
        return getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + "[" + str + ", runnable name = , core size = " + this.gd + ", max size = " + this.f29824a + ", worker count = " + w(i4) + ", queued tasks = " + this.f29830w.size() + "]";
    }

    protected void ux() {
    }

    final void w() {
        while (true) {
            int i4 = this.f29825c.get();
            if (xv(i4) || xv(i4, 1073741824)) {
                return;
            }
            if (c(i4) == 0 && !this.f29830w.isEmpty()) {
                return;
            }
            if (w(i4) != 0) {
                c(true);
                return;
            }
            ReentrantLock reentrantLock = this.xv;
            reentrantLock.lock();
            try {
                if (this.f29825c.compareAndSet(i4, c(1073741824, 0))) {
                    ux();
                    this.f29825c.set(c(1610612736, 0));
                    this.sr.signalAll();
                    return;
                }
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    void xv() {
    }

    private void f(int i4) {
        int i5;
        do {
            i5 = this.f29825c.get();
            if (xv(i5, i4)) {
                return;
            }
        } while (!this.f29825c.compareAndSet(i5, c(i4, w(i5))));
    }

    protected Runnable sr() {
        return this.f29830w.poll();
    }

    @Override // com.bytedance.sdk.component.gd.w
    public <T> Future<T> submit(Callable<T> callable) {
        if (callable == null) {
            return null;
        }
        FutureTask futureTask = new FutureTask(callable);
        execute(futureTask);
        return futureTask;
    }

    final void c(Runnable runnable) {
        this.f29829r.rejectedExecution(runnable, this.f29828p);
    }

    private void c(xv xvVar) {
        int i4 = this.f29825c.get();
        if (w(i4) < this.gd) {
            if (w((Runnable) xvVar, true)) {
                a.f29806w.r().c(xvVar.c(), 1001);
                return;
            }
            i4 = this.f29825c.get();
        }
        if (w(i4) == 0) {
            if (w((Runnable) xvVar, false)) {
                a.f29806w.r().c(xvVar.c(), 1003);
                return;
            }
            i4 = this.f29825c.get();
        }
        if (xv(i4) && this.f29830w.offer(xvVar)) {
            if (!xv(this.f29825c.get()) && remove(xvVar)) {
                c(xvVar.c());
                a.f29806w.r().c(xvVar.c(), 1004);
                return;
            }
            a.f29806w.r().c(xvVar.c(), 1002);
        } else if (w(i4) < this.f29824a && w((Runnable) xvVar, false)) {
            a.f29806w.r().c(xvVar.c(), 1003);
        } else {
            c(xvVar.c());
            a.f29806w.r().c(xvVar.c(), 1004);
        }
    }

    @Override // com.bytedance.sdk.component.gd.w
    public <T> Future<T> submit(Runnable runnable, T t3) {
        if (runnable == null) {
            return null;
        }
        FutureTask futureTask = new FutureTask(runnable, t3);
        execute(futureTask);
        return futureTask;
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x0080, code lost:
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean w(java.lang.Runnable r6, boolean r7) {
        /*
            r5 = this;
        L0:
            java.util.concurrent.atomic.AtomicInteger r0 = r5.f29825c
            int r0 = r0.get()
            int r1 = c(r0)
            r2 = 0
            if (r1 < 0) goto L1a
            if (r1 != 0) goto L19
            if (r6 != 0) goto L19
            java.util.concurrent.BlockingQueue<java.lang.Runnable> r3 = r5.f29830w
            boolean r3 = r3.isEmpty()
            if (r3 == 0) goto L1a
        L19:
            return r2
        L1a:
            int r3 = w(r0)
            r4 = 536870911(0x1fffffff, float:1.0842021E-19)
            if (r3 >= r4) goto L80
            if (r7 == 0) goto L28
            int r4 = r5.gd
            goto L2a
        L28:
            int r4 = r5.f29824a
        L2a:
            if (r3 < r4) goto L2d
            goto L80
        L2d:
            boolean r0 = r5.sr(r0)
            if (r0 == 0) goto L73
            java.util.concurrent.locks.ReentrantLock r7 = r5.xv     // Catch: java.lang.Throwable -> L6e
            r7.lock()     // Catch: java.lang.Throwable -> L6e
            java.util.concurrent.atomic.AtomicInteger r0 = r5.f29825c     // Catch: java.lang.Throwable -> L69
            int r0 = r0.get()     // Catch: java.lang.Throwable -> L69
            int r0 = c(r0)     // Catch: java.lang.Throwable -> L69
            if (r0 < 0) goto L48
            if (r0 != 0) goto L60
            if (r6 != 0) goto L60
        L48:
            java.util.concurrent.ThreadPoolExecutor r0 = r5.c()     // Catch: java.lang.Throwable -> L69
            r0.execute(r6)     // Catch: java.lang.Throwable -> L69
            java.util.concurrent.atomic.AtomicInteger r6 = r5.f29825c     // Catch: java.lang.Throwable -> L69
            int r6 = r6.get()     // Catch: java.lang.Throwable -> L69
            int r6 = w(r6)     // Catch: java.lang.Throwable -> L69
            int r0 = r5.ux     // Catch: java.lang.Throwable -> L69
            if (r6 <= r0) goto L5f
            r5.ux = r6     // Catch: java.lang.Throwable -> L69
        L5f:
            r2 = 1
        L60:
            r7.unlock()     // Catch: java.lang.Throwable -> L6e
            if (r2 != 0) goto L68
            r5.gd()
        L68:
            return r2
        L69:
            r6 = move-exception
            r7.unlock()     // Catch: java.lang.Throwable -> L6e
            throw r6     // Catch: java.lang.Throwable -> L6e
        L6e:
            r6 = move-exception
            r5.gd()
            throw r6
        L73:
            java.util.concurrent.atomic.AtomicInteger r0 = r5.f29825c
            int r0 = r0.get()
            int r3 = c(r0)
            if (r3 == r1) goto L1a
            goto L0
        L80:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.gd.c.f.w(java.lang.Runnable, boolean):boolean");
    }

    public void c(Runnable runnable, boolean z3) {
        if (w(this.f29825c.get(), 536870912)) {
            Runnable sr = sr();
            if (sr != null) {
                c().execute(sr);
                return;
            } else {
                w(sr);
                return;
            }
        }
        w();
    }

    protected void w(Runnable runnable) {
        f();
    }
}
