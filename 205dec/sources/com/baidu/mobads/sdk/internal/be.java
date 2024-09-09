package com.baidu.mobads.sdk.internal;

import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class be {

    /* renamed from: a  reason: collision with root package name */
    private static final String f12460a = "TaskScheduler";

    /* renamed from: d  reason: collision with root package name */
    private static volatile be f12461d;

    /* renamed from: b  reason: collision with root package name */
    private ThreadPoolExecutor f12462b;

    /* renamed from: c  reason: collision with root package name */
    private ScheduledThreadPoolExecutor f12463c;

    private be() {
        b();
    }

    public static be a() {
        if (f12461d == null) {
            synchronized (be.class) {
                if (f12461d == null) {
                    f12461d = new be();
                }
            }
        }
        return f12461d;
    }

    private void b() {
        this.f12462b = bf.a(1, 1);
        this.f12463c = bf.a(1);
    }

    public void a(Runnable runnable) {
        ThreadPoolExecutor threadPoolExecutor;
        if (runnable == null || (threadPoolExecutor = this.f12462b) == null || threadPoolExecutor.isShutdown()) {
            return;
        }
        try {
            this.f12462b.submit(runnable);
        } catch (Throwable unused) {
        }
    }

    public void a(i iVar) {
        ThreadPoolExecutor threadPoolExecutor;
        if (iVar == null || (threadPoolExecutor = this.f12462b) == null || threadPoolExecutor.isShutdown()) {
            return;
        }
        try {
            iVar.a(System.currentTimeMillis());
            FutureTask futureTask = null;
            ThreadPoolExecutor threadPoolExecutor2 = this.f12462b;
            if (threadPoolExecutor2 != null && !threadPoolExecutor2.isShutdown()) {
                futureTask = (FutureTask) this.f12462b.submit(iVar);
            }
            iVar.a((Future) futureTask);
        } catch (Throwable unused) {
        }
    }

    public void a(i iVar, long j4, TimeUnit timeUnit) {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor;
        if (iVar == null || (scheduledThreadPoolExecutor = this.f12463c) == null || scheduledThreadPoolExecutor.isShutdown()) {
            return;
        }
        try {
            iVar.a(System.currentTimeMillis());
            iVar.a((Future) this.f12463c.schedule(iVar, j4, timeUnit));
        } catch (Throwable unused) {
        }
    }

    public void a(i iVar, long j4, long j5, TimeUnit timeUnit) {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor;
        if (iVar == null || (scheduledThreadPoolExecutor = this.f12463c) == null || scheduledThreadPoolExecutor.isShutdown()) {
            return;
        }
        try {
            iVar.a(System.currentTimeMillis());
            iVar.a((Future) this.f12463c.scheduleAtFixedRate(iVar, j4, j5, timeUnit));
        } catch (Throwable unused) {
        }
    }
}
