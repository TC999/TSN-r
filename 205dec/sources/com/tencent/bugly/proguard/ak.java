package com.tencent.bugly.proguard;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: BUGLY */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class ak {

    /* renamed from: a  reason: collision with root package name */
    private static final AtomicInteger f50915a = new AtomicInteger(1);

    /* renamed from: b  reason: collision with root package name */
    private static ak f50916b;

    /* renamed from: c  reason: collision with root package name */
    private ScheduledExecutorService f50917c;

    protected ak() {
        this.f50917c = null;
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(3, new ThreadFactory() { // from class: com.tencent.bugly.proguard.ak.1
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable);
                thread.setName("BuglyThread-" + ak.f50915a.getAndIncrement());
                return thread;
            }
        });
        this.f50917c = newScheduledThreadPool;
        if (newScheduledThreadPool == null || newScheduledThreadPool.isShutdown()) {
            al.d("[AsyncTaskHandler] ScheduledExecutorService is not valiable!", new Object[0]);
        }
    }

    public static synchronized ak a() {
        ak akVar;
        synchronized (ak.class) {
            if (f50916b == null) {
                f50916b = new ak();
            }
            akVar = f50916b;
        }
        return akVar;
    }

    public final synchronized void b() {
        ScheduledExecutorService scheduledExecutorService = this.f50917c;
        if (scheduledExecutorService != null && !scheduledExecutorService.isShutdown()) {
            al.c("[AsyncTaskHandler] Close async handler.", new Object[0]);
            this.f50917c.shutdownNow();
        }
    }

    public final synchronized boolean c() {
        boolean z3;
        ScheduledExecutorService scheduledExecutorService = this.f50917c;
        if (scheduledExecutorService != null) {
            z3 = scheduledExecutorService.isShutdown() ? false : true;
        }
        return z3;
    }

    public final synchronized boolean a(Runnable runnable, long j4) {
        if (!c()) {
            al.d("[AsyncTaskHandler] Async handler was closed, should not post task.", new Object[0]);
            return false;
        }
        if (j4 <= 0) {
            j4 = 0;
        }
        al.c("[AsyncTaskHandler] Post a delay(time: %dms) task: %s", Long.valueOf(j4), runnable.getClass().getName());
        this.f50917c.schedule(runnable, j4, TimeUnit.MILLISECONDS);
        return true;
    }

    public final synchronized boolean a(Runnable runnable) {
        if (!c()) {
            al.d("[AsyncTaskHandler] Async handler was closed, should not post task.", new Object[0]);
            return false;
        } else if (runnable == null) {
            al.d("[AsyncTaskHandler] Task input is null.", new Object[0]);
            return false;
        } else {
            al.c("[AsyncTaskHandler] Post a normal task: %s", runnable.getClass().getName());
            this.f50917c.execute(runnable);
            return true;
        }
    }
}
