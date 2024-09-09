package com.bytedance.sdk.component.gd.xv;

import com.bytedance.sdk.component.gd.a;
import com.bytedance.sdk.component.gd.ev;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public abstract class c extends ThreadPoolExecutor {
    public c(int i4, int i5, long j4, TimeUnit timeUnit, BlockingQueue blockingQueue, ThreadFactory threadFactory) {
        this(i4, i5, j4, timeUnit, blockingQueue, threadFactory, com.bytedance.sdk.component.gd.sr.c.f29848c);
    }

    private void w(Runnable runnable) {
        try {
            a aVar = a.f29806w;
            if (aVar.t()) {
                com.bytedance.sdk.component.utils.a.sr("BaseThreadPool", "crashing drop task :" + runnable);
                aVar.k().submit(runnable);
            } else if (runnable instanceof com.bytedance.sdk.component.gd.c.xv) {
                super.execute(runnable);
            } else {
                super.execute(new com.bytedance.sdk.component.gd.c.xv(runnable));
            }
        } catch (OutOfMemoryError e4) {
            a aVar2 = a.f29806w;
            if (aVar2.w()) {
                ev.c(false);
            }
            c(runnable, e4);
            com.bytedance.sdk.component.gd.xv bk = aVar2.bk();
            if (bk != null) {
                bk.c(e4);
            }
        }
    }

    public void c(Runnable runnable) {
        w(runnable);
    }

    protected abstract void c(Runnable runnable, OutOfMemoryError outOfMemoryError);

    public boolean c() {
        return false;
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        w(runnable);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void setCorePoolSize(int i4) {
        try {
            super.setCorePoolSize(i4);
        } catch (Exception e4) {
            com.bytedance.sdk.component.utils.a.xv("BaseThreadPool", e4.getMessage());
        } catch (OutOfMemoryError e5) {
            c(null, e5);
        }
    }

    public c(int i4, int i5, long j4, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory, RejectedExecutionHandler rejectedExecutionHandler) {
        super(i4, i5, j4, timeUnit, blockingQueue, threadFactory, rejectedExecutionHandler);
    }
}
