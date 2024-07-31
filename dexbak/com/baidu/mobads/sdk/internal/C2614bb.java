package com.baidu.mobads.sdk.internal;

import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.baidu.mobads.sdk.internal.bb */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class C2614bb {

    /* renamed from: a */
    private static final String f8643a = "TaskScheduler";

    /* renamed from: d */
    private static volatile C2614bb f8644d;

    /* renamed from: b */
    private ThreadPoolExecutor f8645b;

    /* renamed from: c */
    private ScheduledThreadPoolExecutor f8646c;

    private C2614bb() {
        m50836b();
    }

    /* renamed from: a */
    public static C2614bb m50841a() {
        if (f8644d == null) {
            synchronized (C2614bb.class) {
                if (f8644d == null) {
                    f8644d = new C2614bb();
                }
            }
        }
        return f8644d;
    }

    /* renamed from: b */
    private void m50836b() {
        this.f8645b = C2615bc.m50833a(1, 1);
        this.f8646c = C2615bc.m50834a(1);
    }

    /* renamed from: a */
    public void m50837a(Runnable runnable) {
        ThreadPoolExecutor threadPoolExecutor;
        if (runnable == null || (threadPoolExecutor = this.f8645b) == null || threadPoolExecutor.isShutdown()) {
            return;
        }
        try {
            this.f8645b.submit(runnable);
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    public void m50840a(AbstractRunnableC2710i abstractRunnableC2710i) {
        ThreadPoolExecutor threadPoolExecutor;
        if (abstractRunnableC2710i == null || (threadPoolExecutor = this.f8645b) == null || threadPoolExecutor.isShutdown()) {
            return;
        }
        try {
            abstractRunnableC2710i.m50388a(System.currentTimeMillis());
            FutureTask futureTask = null;
            ThreadPoolExecutor threadPoolExecutor2 = this.f8645b;
            if (threadPoolExecutor2 != null && !threadPoolExecutor2.isShutdown()) {
                futureTask = (FutureTask) this.f8645b.submit(abstractRunnableC2710i);
            }
            abstractRunnableC2710i.m50385a((Future) futureTask);
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    public void m50838a(AbstractRunnableC2710i abstractRunnableC2710i, long j, TimeUnit timeUnit) {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor;
        if (abstractRunnableC2710i == null || (scheduledThreadPoolExecutor = this.f8646c) == null || scheduledThreadPoolExecutor.isShutdown()) {
            return;
        }
        try {
            abstractRunnableC2710i.m50388a(System.currentTimeMillis());
            abstractRunnableC2710i.m50385a((Future) this.f8646c.schedule(abstractRunnableC2710i, j, timeUnit));
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    public void m50839a(AbstractRunnableC2710i abstractRunnableC2710i, long j, long j2, TimeUnit timeUnit) {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor;
        if (abstractRunnableC2710i == null || (scheduledThreadPoolExecutor = this.f8646c) == null || scheduledThreadPoolExecutor.isShutdown()) {
            return;
        }
        try {
            abstractRunnableC2710i.m50388a(System.currentTimeMillis());
            abstractRunnableC2710i.m50385a((Future) this.f8646c.scheduleAtFixedRate(abstractRunnableC2710i, j, j2, timeUnit));
        } catch (Throwable unused) {
        }
    }
}
