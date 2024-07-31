package com.kwad.sdk.core.threads.p410a;

import android.os.SystemClock;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;

/* renamed from: com.kwad.sdk.core.threads.a.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10508a extends ScheduledThreadPoolExecutor implements InterfaceC10510c {
    public static volatile boolean aAU;
    private final ConcurrentHashMap<Runnable, Long> aAV;
    private long aAW;
    private int aAX;

    public C10508a(int i, ThreadFactory threadFactory) {
        super(1, threadFactory);
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

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor, java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        if (aAU) {
            this.aAV.put(runnable, Long.valueOf(SystemClock.elapsedRealtime()));
        }
        super.execute(runnable);
    }
}
