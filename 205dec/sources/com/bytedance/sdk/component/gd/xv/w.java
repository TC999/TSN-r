package com.bytedance.sdk.component.gd.xv;

import com.bytedance.sdk.component.gd.a;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w extends c {
    public w(int i4, int i5, long j4, TimeUnit timeUnit, ThreadFactory threadFactory) {
        super(i4, i5, j4, timeUnit, new SynchronousQueue(), threadFactory);
        try {
            allowCoreThreadTimeOut(true);
        } catch (Throwable unused) {
        }
    }

    private boolean w(Runnable runnable) {
        ThreadPoolExecutor gd = a.f29806w.gd();
        if (gd.getQueue().size() != 0 || gd.getActiveCount() >= gd.getCorePoolSize() - 1) {
            return false;
        }
        gd.execute(new xv(runnable));
        return true;
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    protected void afterExecute(Runnable runnable, Throwable th) {
        Runnable poll;
        super.afterExecute(runnable, th);
        BlockingQueue<Runnable> queue = a.f29806w.gd().getQueue();
        if (queue.size() == 0) {
            return;
        }
        int activeCount = getActiveCount();
        int maximumPoolSize = getMaximumPoolSize();
        if ((activeCount < maximumPoolSize && activeCount >= maximumPoolSize - getCorePoolSize()) || isShutdown() || isTerminated() || isTerminating() || (poll = queue.poll()) == null) {
            return;
        }
        c(poll);
    }

    @Override // com.bytedance.sdk.component.gd.xv.c
    public void c(Runnable runnable) {
        if (runnable instanceof com.bytedance.sdk.component.gd.c.xv) {
            ((com.bytedance.sdk.component.gd.c.xv) runnable).w(false);
        }
        super.c(runnable);
    }

    @Override // com.bytedance.sdk.component.gd.xv.c, java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        if (runnable instanceof xv) {
            super.execute(runnable);
        } else if (w(runnable)) {
        } else {
            if (c()) {
                a.f29806w.gd().execute(new xv(runnable));
            } else {
                super.execute(runnable);
            }
        }
    }

    @Override // com.bytedance.sdk.component.gd.xv.c
    protected void c(Runnable runnable, OutOfMemoryError outOfMemoryError) {
        if (runnable != null) {
            a.f29806w.gd().execute(new xv(runnable));
        }
        try {
            allowCoreThreadTimeOut(false);
        } catch (Exception e4) {
            com.bytedance.sdk.component.utils.a.sr("BigThreadPool", e4);
        }
    }

    @Override // com.bytedance.sdk.component.gd.xv.c
    public boolean c() {
        return getActiveCount() >= getMaximumPoolSize();
    }
}
