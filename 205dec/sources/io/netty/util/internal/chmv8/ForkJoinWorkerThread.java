package io.netty.util.internal.chmv8;

import io.netty.util.internal.chmv8.ForkJoinPool;

/* loaded from: E:\TSN-r\205dec\5406560.dex */
public class ForkJoinWorkerThread extends Thread {
    final ForkJoinPool pool;
    final ForkJoinPool.WorkQueue workQueue;

    /* JADX INFO: Access modifiers changed from: protected */
    public ForkJoinWorkerThread(ForkJoinPool forkJoinPool) {
        super("aForkJoinWorkerThread");
        this.pool = forkJoinPool;
        this.workQueue = forkJoinPool.registerWorker(this);
    }

    public ForkJoinPool getPool() {
        return this.pool;
    }

    public int getPoolIndex() {
        return this.workQueue.poolIndex >>> 1;
    }

    protected void onStart() {
    }

    protected void onTermination(Throwable th) {
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            onStart();
            this.pool.runWorker(this.workQueue);
            th = null;
            try {
                onTermination(null);
            } catch (Throwable th) {
                th = th;
            }
        } catch (Throwable th2) {
            th = th2;
            try {
                onTermination(th);
            } catch (Throwable unused) {
            }
        }
        this.pool.deregisterWorker(this, th);
    }
}
