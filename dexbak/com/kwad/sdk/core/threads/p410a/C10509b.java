package com.kwad.sdk.core.threads.p410a;

import android.os.SystemClock;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.kwad.sdk.core.threads.a.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10509b extends ThreadPoolExecutor implements InterfaceC10510c {
    public static volatile boolean aAU;
    private final ConcurrentHashMap<Runnable, Long> aAV;
    private long aAW;
    private int aAX;

    public C10509b(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory) {
        super(i, i2, j, timeUnit, blockingQueue, threadFactory);
        this.aAV = new ConcurrentHashMap<>();
        this.aAW = 0L;
        this.aAX = 0;
    }

    @Override // com.kwad.sdk.core.threads.p410a.InterfaceC10510c
    /* renamed from: FW */
    public final long mo25584FW() {
        return this.aAW;
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    protected final void beforeExecute(Thread thread, Runnable runnable) {
        super.beforeExecute(thread, runnable);
        if (aAU && this.aAV.containsKey(runnable) && this.aAV.get(runnable) != null) {
            long elapsedRealtime = SystemClock.elapsedRealtime() - this.aAV.get(runnable).longValue();
            if (elapsedRealtime >= 0 && elapsedRealtime < 1800000) {
                long j = this.aAW;
                int i = this.aAX;
                this.aAW = ((j * i) + elapsedRealtime) / (i + 1);
                this.aAX = i + 1;
            }
            this.aAV.remove(runnable);
        }
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        if (aAU) {
            this.aAV.put(runnable, Long.valueOf(SystemClock.elapsedRealtime()));
        }
        super.execute(runnable);
    }

    public C10509b(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory, RejectedExecutionHandler rejectedExecutionHandler) {
        super(i, i2, j, timeUnit, blockingQueue, threadFactory, rejectedExecutionHandler);
        this.aAV = new ConcurrentHashMap<>();
        this.aAW = 0L;
        this.aAX = 0;
    }
}
