package com.kwad.sdk.core.threads.a;

import android.os.SystemClock;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class a extends ScheduledThreadPoolExecutor implements c {
    public static volatile boolean aAU;
    private final ConcurrentHashMap<Runnable, Long> aAV;
    private long aAW;
    private int aAX;

    public a(int i4, ThreadFactory threadFactory) {
        super(1, threadFactory);
        this.aAV = new ConcurrentHashMap<>();
        this.aAW = 0L;
        this.aAX = 0;
    }

    @Override // com.kwad.sdk.core.threads.a.c
    public final long FW() {
        return this.aAW;
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    protected final void beforeExecute(Thread thread, Runnable runnable) {
        super.beforeExecute(thread, runnable);
        if (aAU && this.aAV.containsKey(runnable) && this.aAV.get(runnable) != null) {
            long elapsedRealtime = SystemClock.elapsedRealtime() - this.aAV.get(runnable).longValue();
            if (elapsedRealtime >= 0 && elapsedRealtime < 1800000) {
                long j4 = this.aAW;
                int i4 = this.aAX;
                this.aAW = ((j4 * i4) + elapsedRealtime) / (i4 + 1);
                this.aAX = i4 + 1;
            }
            this.aAV.remove(runnable);
        }
    }

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor, java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        if (aAU) {
            this.aAV.put(runnable, Long.valueOf(SystemClock.elapsedRealtime()));
        }
        super.execute(runnable);
    }
}
