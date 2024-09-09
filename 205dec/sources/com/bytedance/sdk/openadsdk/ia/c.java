package com.bytedance.sdk.openadsdk.ia;

import com.bytedance.sdk.openadsdk.api.xv;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class c {

    /* renamed from: c  reason: collision with root package name */
    private static volatile c f35901c;
    private volatile ThreadPoolExecutor sr;

    /* renamed from: w  reason: collision with root package name */
    private volatile ExecutorService f35902w;
    private volatile ThreadPoolExecutor xv;

    private c() {
    }

    private ExecutorService xv() {
        if (this.sr == null) {
            this.sr = new ThreadPoolExecutor(2, 5, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new ThreadFactoryC0528c());
        }
        return this.sr;
    }

    public static c c() {
        if (f35901c == null) {
            synchronized (c.class) {
                f35901c = new c();
            }
        }
        return f35901c;
    }

    private ExecutorService w() {
        if (this.xv == null) {
            this.xv = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new ThreadFactoryC0528c("init"));
        }
        return this.xv;
    }

    /* renamed from: com.bytedance.sdk.openadsdk.ia.c$c  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class ThreadFactoryC0528c implements ThreadFactory {

        /* renamed from: c  reason: collision with root package name */
        private final ThreadGroup f35904c;

        /* renamed from: w  reason: collision with root package name */
        private final AtomicInteger f35905w;
        private final String xv;

        ThreadFactoryC0528c() {
            this.f35905w = new AtomicInteger(1);
            this.f35904c = new ThreadGroup("csj_api");
            this.xv = "csj_api";
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            ThreadGroup threadGroup = this.f35904c;
            Thread thread = new Thread(threadGroup, runnable, this.xv + "_" + this.f35905w.getAndIncrement(), 0L);
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            if (thread.getPriority() != 10) {
                thread.setPriority(10);
            }
            return thread;
        }

        ThreadFactoryC0528c(String str) {
            this.f35905w = new AtomicInteger(1);
            this.f35904c = new ThreadGroup("csj_api");
            this.xv = "csj_api_" + str;
        }
    }

    public void w(Runnable runnable) {
        if (runnable != null) {
            try {
                c(false).execute(runnable);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private void w(ExecutorService executorService) {
        executorService.execute(new Runnable() { // from class: com.bytedance.sdk.openadsdk.ia.c.1
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.xv != null) {
                    try {
                        c cVar = c.this;
                        cVar.c(cVar.xv);
                        xv.w("ApiThread", "release init pool!");
                    } catch (Throwable th) {
                        xv.c("ApiThread", "release mInitExecutor failed", th);
                    }
                    c.this.xv = null;
                }
                if (c.this.sr != null) {
                    try {
                        c cVar2 = c.this;
                        cVar2.c(cVar2.sr);
                        xv.w("ApiThread", "release api pool!");
                    } catch (Throwable th2) {
                        xv.c("ApiThread", "release mApiExecutor failed", th2);
                    }
                    c.this.sr = null;
                }
            }
        });
    }

    public void c(Runnable runnable) {
        if (runnable != null) {
            try {
                c(true).execute(runnable);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private ExecutorService c(boolean z3) {
        if (this.f35902w == null) {
            return z3 ? w() : xv();
        }
        return this.f35902w;
    }

    public void c(ExecutorService executorService) {
        if (executorService != null) {
            this.f35902w = executorService;
            if (this.sr == null && this.xv == null) {
                return;
            }
            w(executorService);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ThreadPoolExecutor threadPoolExecutor) {
        threadPoolExecutor.setKeepAliveTime(1L, TimeUnit.MILLISECONDS);
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        while (true) {
            try {
                Thread.sleep(100L);
            } catch (InterruptedException unused) {
            }
            if (threadPoolExecutor.getQueue().size() <= 0 && threadPoolExecutor.getActiveCount() == 0) {
                threadPoolExecutor.shutdown();
                return;
            }
        }
    }
}
