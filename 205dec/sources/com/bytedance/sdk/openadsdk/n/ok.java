package com.bytedance.sdk.openadsdk.n;

import com.bytedance.sdk.openadsdk.api.bl;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: E:\TSN-r\205dec\5141176.dex */
public final class ok {
    private static volatile ok ok;

    /* renamed from: a  reason: collision with root package name */
    private volatile ExecutorService f36246a;
    private volatile ThreadPoolExecutor bl;

    /* renamed from: s  reason: collision with root package name */
    private volatile ThreadPoolExecutor f36247s;

    private ok() {
    }

    private ExecutorService bl() {
        if (this.f36247s == null) {
            this.f36247s = new ThreadPoolExecutor(2, 5, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new ThreadFactoryC0530ok());
        }
        return this.f36247s;
    }

    private ExecutorService a() {
        if (this.bl == null) {
            this.bl = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new ThreadFactoryC0530ok("init"));
        }
        return this.bl;
    }

    public static ok ok() {
        if (ok == null) {
            synchronized (ok.class) {
                ok = new ok();
            }
        }
        return ok;
    }

    /* renamed from: com.bytedance.sdk.openadsdk.n.ok$ok  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static class ThreadFactoryC0530ok implements ThreadFactory {

        /* renamed from: a  reason: collision with root package name */
        private final AtomicInteger f36248a;
        private final String bl;
        private final ThreadGroup ok;

        ThreadFactoryC0530ok() {
            this.f36248a = new AtomicInteger(1);
            this.ok = new ThreadGroup("csj_api");
            this.bl = "csj_api";
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            ThreadGroup threadGroup = this.ok;
            Thread thread = new Thread(threadGroup, runnable, this.bl + "_" + this.f36248a.getAndIncrement(), 0L);
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            if (thread.getPriority() != 10) {
                thread.setPriority(10);
            }
            return thread;
        }

        ThreadFactoryC0530ok(String str) {
            this.f36248a = new AtomicInteger(1);
            this.ok = new ThreadGroup("csj_api");
            this.bl = "csj_api_" + str;
        }
    }

    public void a(Runnable runnable) {
        if (runnable != null) {
            try {
                ok(false).execute(runnable);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private void a(ExecutorService executorService) {
        executorService.execute(new Runnable() { // from class: com.bytedance.sdk.openadsdk.n.ok.1
            @Override // java.lang.Runnable
            public void run() {
                if (ok.this.bl != null) {
                    try {
                        ok okVar = ok.this;
                        okVar.ok(okVar.bl);
                        bl.a("ApiThread", "release init pool!");
                    } catch (Throwable th) {
                        bl.ok("ApiThread", "release mInitExecutor failed", th);
                    }
                    ok.this.bl = null;
                }
                if (ok.this.f36247s != null) {
                    try {
                        ok okVar2 = ok.this;
                        okVar2.ok(okVar2.f36247s);
                        bl.a("ApiThread", "release api pool!");
                    } catch (Throwable th2) {
                        bl.ok("ApiThread", "release mApiExecutor failed", th2);
                    }
                    ok.this.f36247s = null;
                }
            }
        });
    }

    public void ok(Runnable runnable) {
        if (runnable != null) {
            try {
                ok(true).execute(runnable);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private ExecutorService ok(boolean z3) {
        if (this.f36246a == null) {
            return z3 ? a() : bl();
        }
        return this.f36246a;
    }

    public void ok(ExecutorService executorService) {
        if (executorService != null) {
            this.f36246a = executorService;
            if (this.f36247s == null && this.bl == null) {
                return;
            }
            a(executorService);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ok(ThreadPoolExecutor threadPoolExecutor) {
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
