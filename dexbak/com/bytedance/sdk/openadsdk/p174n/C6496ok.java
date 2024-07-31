package com.bytedance.sdk.openadsdk.p174n;

import com.bytedance.sdk.openadsdk.api.C6280bl;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.bytedance.sdk.openadsdk.n.ok */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class C6496ok {

    /* renamed from: ok */
    private static volatile C6496ok f22864ok;

    /* renamed from: a */
    private volatile ExecutorService f22865a;

    /* renamed from: bl */
    private volatile ThreadPoolExecutor f22866bl;

    /* renamed from: s */
    private volatile ThreadPoolExecutor f22867s;

    private C6496ok() {
    }

    /* renamed from: bl */
    private ExecutorService m36209bl() {
        if (this.f22867s == null) {
            this.f22867s = new ThreadPoolExecutor(2, 5, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new ThreadFactoryC6498ok());
        }
        return this.f22867s;
    }

    /* renamed from: a */
    private ExecutorService m36214a() {
        if (this.f22866bl == null) {
            this.f22866bl = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new ThreadFactoryC6498ok("init"));
        }
        return this.f22866bl;
    }

    /* renamed from: ok */
    public static C6496ok m36207ok() {
        if (f22864ok == null) {
            synchronized (C6496ok.class) {
                f22864ok = new C6496ok();
            }
        }
        return f22864ok;
    }

    /* renamed from: com.bytedance.sdk.openadsdk.n.ok$ok */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static class ThreadFactoryC6498ok implements ThreadFactory {

        /* renamed from: a */
        private final AtomicInteger f22869a;

        /* renamed from: bl */
        private final String f22870bl;

        /* renamed from: ok */
        private final ThreadGroup f22871ok;

        ThreadFactoryC6498ok() {
            this.f22869a = new AtomicInteger(1);
            this.f22871ok = new ThreadGroup("csj_api");
            this.f22870bl = "csj_api";
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            ThreadGroup threadGroup = this.f22871ok;
            Thread thread = new Thread(threadGroup, runnable, this.f22870bl + "_" + this.f22869a.getAndIncrement(), 0L);
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            if (thread.getPriority() != 10) {
                thread.setPriority(10);
            }
            return thread;
        }

        ThreadFactoryC6498ok(String str) {
            this.f22869a = new AtomicInteger(1);
            this.f22871ok = new ThreadGroup("csj_api");
            this.f22870bl = "csj_api_" + str;
        }
    }

    /* renamed from: a */
    public void m36211a(Runnable runnable) {
        if (runnable != null) {
            try {
                m36201ok(false).execute(runnable);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    private void m36210a(ExecutorService executorService) {
        executorService.execute(new Runnable() { // from class: com.bytedance.sdk.openadsdk.n.ok.1
            @Override // java.lang.Runnable
            public void run() {
                if (C6496ok.this.f22866bl != null) {
                    try {
                        C6496ok c6496ok = C6496ok.this;
                        c6496ok.m36202ok(c6496ok.f22866bl);
                        C6280bl.m36774a("ApiThread", "release init pool!");
                    } catch (Throwable th) {
                        C6280bl.m36764ok("ApiThread", "release mInitExecutor failed", th);
                    }
                    C6496ok.this.f22866bl = null;
                }
                if (C6496ok.this.f22867s != null) {
                    try {
                        C6496ok c6496ok2 = C6496ok.this;
                        c6496ok2.m36202ok(c6496ok2.f22867s);
                        C6280bl.m36774a("ApiThread", "release api pool!");
                    } catch (Throwable th2) {
                        C6280bl.m36764ok("ApiThread", "release mApiExecutor failed", th2);
                    }
                    C6496ok.this.f22867s = null;
                }
            }
        });
    }

    /* renamed from: ok */
    public void m36204ok(Runnable runnable) {
        if (runnable != null) {
            try {
                m36201ok(true).execute(runnable);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* renamed from: ok */
    private ExecutorService m36201ok(boolean z) {
        if (this.f22865a == null) {
            return z ? m36214a() : m36209bl();
        }
        return this.f22865a;
    }

    /* renamed from: ok */
    public void m36203ok(ExecutorService executorService) {
        if (executorService != null) {
            this.f22865a = executorService;
            if (this.f22867s == null && this.f22866bl == null) {
                return;
            }
            m36210a(executorService);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ok */
    public void m36202ok(ThreadPoolExecutor threadPoolExecutor) {
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
