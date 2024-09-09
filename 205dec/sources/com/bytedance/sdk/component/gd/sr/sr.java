package com.bytedance.sdk.component.gd.sr;

import com.bytedance.sdk.component.gd.a;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class sr extends c {
    public sr(int i4, int i5, long j4, TimeUnit timeUnit, BlockingQueue blockingQueue, ThreadFactory threadFactory) {
        super(i4, i5, j4, timeUnit, new com.bytedance.sdk.component.gd.c.c(blockingQueue), new com.bytedance.sdk.component.gd.c.sr(threadFactory, 2));
        c();
    }

    private void c() {
        if (a.f29806w.ux()) {
            if (!allowsCoreThreadTimeOut()) {
                setKeepAliveTime(c(20L), TimeUnit.SECONDS);
                try {
                    super.allowCoreThreadTimeOut(true);
                } catch (Throwable unused) {
                }
            }
            com.bytedance.sdk.component.gd.ux.f29863c.c(this);
        }
    }

    private ExecutorService w() {
        com.bytedance.sdk.component.gd.ux uxVar = com.bytedance.sdk.component.gd.ux.f29863c;
        return uxVar.c("PThreadPoolExecutor", uxVar.c(getQueue()));
    }

    @Override // com.bytedance.sdk.component.gd.sr.c, java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.gd.w
    public void allowCoreThreadTimeOut(boolean z3) {
    }

    @Override // com.bytedance.sdk.component.gd.sr.c, java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor, com.bytedance.sdk.component.gd.w
    public void execute(Runnable runnable) {
        if (a.f29806w.ux()) {
            try {
                super.execute(runnable);
                return;
            } catch (OutOfMemoryError e4) {
                ExecutorService w3 = w();
                if (w3 != null) {
                    w3.execute(runnable);
                    return;
                }
                throw e4;
            }
        }
        super.execute(runnable);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    protected void finalize() {
        super.finalize();
        shutdown();
        com.bytedance.sdk.component.gd.ux.f29863c.w(this);
    }

    @Override // com.bytedance.sdk.component.gd.sr.c, java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.gd.w
    public void setThreadFactory(ThreadFactory threadFactory) {
        super.setThreadFactory(new com.bytedance.sdk.component.gd.c.sr(threadFactory, 2));
    }

    @Override // com.bytedance.sdk.component.gd.sr.c, java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService, com.bytedance.sdk.component.gd.w
    public void shutdown() {
        super.shutdown();
        com.bytedance.sdk.component.gd.ux.f29863c.w(this);
    }

    @Override // com.bytedance.sdk.component.gd.sr.c, java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService, com.bytedance.sdk.component.gd.w
    public List shutdownNow() {
        com.bytedance.sdk.component.gd.ux.f29863c.w(this);
        return super.shutdownNow();
    }

    @Override // com.bytedance.sdk.component.gd.sr.c, java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService, com.bytedance.sdk.component.gd.w
    public <T> Future<T> submit(Callable<T> callable) {
        if (a.f29806w.ux()) {
            try {
                return super.submit(callable);
            } catch (OutOfMemoryError e4) {
                ExecutorService w3 = w();
                if (w3 != null) {
                    return w3.submit(callable);
                }
                throw e4;
            }
        }
        return super.submit(callable);
    }

    public sr(int i4, int i5, long j4, TimeUnit timeUnit, BlockingQueue blockingQueue, ThreadFactory threadFactory, RejectedExecutionHandler rejectedExecutionHandler) {
        super(i4, i5, j4, timeUnit, new com.bytedance.sdk.component.gd.c.c(blockingQueue), new com.bytedance.sdk.component.gd.c.sr(threadFactory, 2), rejectedExecutionHandler);
        c();
    }

    private long c(long j4) {
        long min = Math.min(j4, getKeepAliveTime(TimeUnit.SECONDS));
        if (min > 1) {
            return min;
        }
        return 1L;
    }

    @Override // com.bytedance.sdk.component.gd.sr.c, java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService, com.bytedance.sdk.component.gd.w
    public <T> Future<T> submit(Runnable runnable, T t3) {
        if (a.f29806w.ux()) {
            try {
                return super.submit(runnable, t3);
            } catch (OutOfMemoryError e4) {
                ExecutorService w3 = w();
                if (w3 != null) {
                    return w3.submit(runnable, t3);
                }
                throw e4;
            }
        }
        return super.submit(runnable, t3);
    }

    @Override // com.bytedance.sdk.component.gd.sr.c, java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService, com.bytedance.sdk.component.gd.w
    public Future submit(Runnable runnable) {
        if (a.f29806w.ux()) {
            try {
                return super.submit(runnable);
            } catch (OutOfMemoryError e4) {
                ExecutorService w3 = w();
                if (w3 != null) {
                    return w3.submit(runnable);
                }
                throw e4;
            }
        }
        return super.submit(runnable);
    }
}
