package com.bytedance.sdk.component.gd.sr;

import com.bytedance.sdk.component.gd.a;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.RunnableScheduledFuture;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ux extends ScheduledThreadPoolExecutor {

    /* renamed from: c  reason: collision with root package name */
    private final ConcurrentHashMap f29851c;

    public ux(int i4, ThreadFactory threadFactory) {
        super(i4, new com.bytedance.sdk.component.gd.c.sr(threadFactory, 8));
        this.f29851c = new ConcurrentHashMap();
        c();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void allowCoreThreadTimeOut(boolean z3) {
    }

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor
    protected RunnableScheduledFuture decorateTask(Runnable runnable, RunnableScheduledFuture runnableScheduledFuture) {
        if (a.f29806w.ux()) {
            RunnableScheduledFuture runnableScheduledFuture2 = (RunnableScheduledFuture) this.f29851c.get(runnable);
            if (runnableScheduledFuture2 == null) {
                RunnableScheduledFuture decorateTask = super.decorateTask(runnable, runnableScheduledFuture);
                this.f29851c.put(runnable, decorateTask);
                return decorateTask;
            }
            return runnableScheduledFuture2;
        }
        return super.decorateTask(runnable, runnableScheduledFuture);
    }

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor, java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture schedule(final Runnable runnable, final long j4, final TimeUnit timeUnit) {
        if (a.f29806w.ux()) {
            try {
                ScheduledFuture<?> schedule = super.schedule(runnable, j4, timeUnit);
                this.f29851c.remove(runnable);
                return schedule;
            } catch (OutOfMemoryError unused) {
                com.bytedance.sdk.component.gd.ux.f29863c.c("PThreadScheduledThreadPoolExecutor");
                a aVar = a.f29806w;
                aVar.k().schedule(new Runnable() { // from class: com.bytedance.sdk.component.gd.sr.ux.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ux.super.schedule(runnable, j4, timeUnit);
                        ux.this.f29851c.remove(runnable);
                    }
                }, aVar.sr(), TimeUnit.MILLISECONDS);
                return (ScheduledFuture) this.f29851c.get(runnable);
            }
        }
        return super.schedule(runnable, j4, timeUnit);
    }

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor, java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture scheduleAtFixedRate(final Runnable runnable, final long j4, final long j5, final TimeUnit timeUnit) {
        if (a.f29806w.ux()) {
            try {
                ScheduledFuture<?> scheduleAtFixedRate = super.scheduleAtFixedRate(runnable, j4, j5, timeUnit);
                this.f29851c.remove(runnable);
                return scheduleAtFixedRate;
            } catch (OutOfMemoryError unused) {
                com.bytedance.sdk.component.gd.ux.f29863c.c("PThreadScheduledThreadPoolExecutor");
                a aVar = a.f29806w;
                aVar.k().schedule(new Runnable() { // from class: com.bytedance.sdk.component.gd.sr.ux.2
                    @Override // java.lang.Runnable
                    public void run() {
                        ux.super.scheduleAtFixedRate(runnable, j4, j5, timeUnit);
                        ux.this.f29851c.remove(runnable);
                    }
                }, aVar.sr(), TimeUnit.MILLISECONDS);
                return (ScheduledFuture) this.f29851c.get(runnable);
            }
        }
        return super.scheduleAtFixedRate(runnable, j4, j5, timeUnit);
    }

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor, java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture scheduleWithFixedDelay(final Runnable runnable, final long j4, final long j5, final TimeUnit timeUnit) {
        if (a.f29806w.ux()) {
            try {
                ScheduledFuture<?> scheduleWithFixedDelay = super.scheduleWithFixedDelay(runnable, j4, j5, timeUnit);
                this.f29851c.remove(runnable);
                return scheduleWithFixedDelay;
            } catch (OutOfMemoryError unused) {
                com.bytedance.sdk.component.gd.ux.f29863c.c("PThreadScheduledThreadPoolExecutor");
                a aVar = a.f29806w;
                aVar.k().schedule(new Runnable() { // from class: com.bytedance.sdk.component.gd.sr.ux.3
                    @Override // java.lang.Runnable
                    public void run() {
                        ux.super.scheduleWithFixedDelay(runnable, j4, j5, timeUnit);
                        ux.this.f29851c.remove(runnable);
                    }
                }, aVar.sr(), TimeUnit.MILLISECONDS);
                return (ScheduledFuture) this.f29851c.get(runnable);
            }
        }
        return super.scheduleWithFixedDelay(runnable, j4, j5, timeUnit);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void setKeepAliveTime(long j4, TimeUnit timeUnit) {
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void setThreadFactory(ThreadFactory threadFactory) {
        super.setThreadFactory(new com.bytedance.sdk.component.gd.c.sr(threadFactory, 8));
    }

    private void c() {
        if (!a.f29806w.ux() || allowsCoreThreadTimeOut()) {
            return;
        }
        TimeUnit timeUnit = TimeUnit.SECONDS;
        super.setKeepAliveTime(Math.max(10L, getKeepAliveTime(timeUnit)), timeUnit);
        super.allowCoreThreadTimeOut(true);
    }

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor
    protected RunnableScheduledFuture decorateTask(Callable callable, RunnableScheduledFuture runnableScheduledFuture) {
        if (a.f29806w.ux()) {
            RunnableScheduledFuture runnableScheduledFuture2 = (RunnableScheduledFuture) this.f29851c.get(callable);
            if (runnableScheduledFuture2 == null) {
                RunnableScheduledFuture decorateTask = super.decorateTask(callable, runnableScheduledFuture);
                this.f29851c.put(callable, decorateTask);
                return decorateTask;
            }
            return runnableScheduledFuture2;
        }
        return super.decorateTask(callable, runnableScheduledFuture);
    }

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor, java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture schedule(final Callable callable, final long j4, final TimeUnit timeUnit) {
        if (a.f29806w.ux()) {
            try {
                ScheduledFuture schedule = super.schedule(callable, j4, timeUnit);
                this.f29851c.remove(callable);
                return schedule;
            } catch (OutOfMemoryError unused) {
                com.bytedance.sdk.component.gd.ux.f29863c.c("PThreadScheduledThreadPoolExecutor");
                a aVar = a.f29806w;
                aVar.k().schedule(new Runnable() { // from class: com.bytedance.sdk.component.gd.sr.ux.4
                    @Override // java.lang.Runnable
                    public void run() {
                        ux.super.schedule(callable, j4, timeUnit);
                        ux.this.f29851c.remove(callable);
                    }
                }, aVar.sr(), TimeUnit.MILLISECONDS);
                return (ScheduledFuture) this.f29851c.get(callable);
            }
        }
        return super.schedule(callable, j4, timeUnit);
    }
}
