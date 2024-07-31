package com.tencent.bugly.proguard;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.ak */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class C12818ak {

    /* renamed from: a */
    private static final AtomicInteger f36541a = new AtomicInteger(1);

    /* renamed from: b */
    private static C12818ak f36542b;

    /* renamed from: c */
    private ScheduledExecutorService f36543c;

    protected C12818ak() {
        this.f36543c = null;
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(3, new ThreadFactory() { // from class: com.tencent.bugly.proguard.ak.1
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable);
                thread.setName("BuglyThread-" + C12818ak.f36541a.getAndIncrement());
                return thread;
            }
        });
        this.f36543c = newScheduledThreadPool;
        if (newScheduledThreadPool == null || newScheduledThreadPool.isShutdown()) {
            C12820al.m15873d("[AsyncTaskHandler] ScheduledExecutorService is not valiable!", new Object[0]);
        }
    }

    /* renamed from: a */
    public static synchronized C12818ak m15887a() {
        C12818ak c12818ak;
        synchronized (C12818ak.class) {
            if (f36542b == null) {
                f36542b = new C12818ak();
            }
            c12818ak = f36542b;
        }
        return c12818ak;
    }

    /* renamed from: b */
    public final synchronized void m15884b() {
        ScheduledExecutorService scheduledExecutorService = this.f36543c;
        if (scheduledExecutorService != null && !scheduledExecutorService.isShutdown()) {
            C12820al.m15874c("[AsyncTaskHandler] Close async handler.", new Object[0]);
            this.f36543c.shutdownNow();
        }
    }

    /* renamed from: c */
    public final synchronized boolean m15883c() {
        boolean z;
        ScheduledExecutorService scheduledExecutorService = this.f36543c;
        if (scheduledExecutorService != null) {
            z = scheduledExecutorService.isShutdown() ? false : true;
        }
        return z;
    }

    /* renamed from: a */
    public final synchronized boolean m15885a(Runnable runnable, long j) {
        if (!m15883c()) {
            C12820al.m15873d("[AsyncTaskHandler] Async handler was closed, should not post task.", new Object[0]);
            return false;
        }
        if (j <= 0) {
            j = 0;
        }
        C12820al.m15874c("[AsyncTaskHandler] Post a delay(time: %dms) task: %s", Long.valueOf(j), runnable.getClass().getName());
        this.f36543c.schedule(runnable, j, TimeUnit.MILLISECONDS);
        return true;
    }

    /* renamed from: a */
    public final synchronized boolean m15886a(Runnable runnable) {
        if (!m15883c()) {
            C12820al.m15873d("[AsyncTaskHandler] Async handler was closed, should not post task.", new Object[0]);
            return false;
        } else if (runnable == null) {
            C12820al.m15873d("[AsyncTaskHandler] Task input is null.", new Object[0]);
            return false;
        } else {
            C12820al.m15874c("[AsyncTaskHandler] Post a normal task: %s", runnable.getClass().getName());
            this.f36543c.execute(runnable);
            return true;
        }
    }
}
