package com.umeng.analytics.pro;

import com.umeng.commonsdk.debug.UMRTLog;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: UMExecutor.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class as {

    /* renamed from: a  reason: collision with root package name */
    private static final String f52565a = "UMExecutor";

    /* renamed from: b  reason: collision with root package name */
    private static volatile ScheduledThreadPoolExecutor f52566b;

    /* renamed from: c  reason: collision with root package name */
    private static final ThreadFactory f52567c = new ThreadFactory() { // from class: com.umeng.analytics.pro.as.1

        /* renamed from: a  reason: collision with root package name */
        private final AtomicInteger f52568a = new AtomicInteger(0);

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "ccg-" + this.f52568a.incrementAndGet());
        }
    };

    private static ScheduledThreadPoolExecutor a() {
        if (f52566b == null) {
            synchronized (as.class) {
                if (f52566b == null) {
                    f52566b = new ScheduledThreadPoolExecutor(Math.max(2, Math.min(Runtime.getRuntime().availableProcessors(), 4)), f52567c);
                    f52566b.setKeepAliveTime(3L, TimeUnit.SECONDS);
                    f52566b.allowCoreThreadTimeOut(true);
                }
            }
        }
        return f52566b;
    }

    public static void a(Runnable runnable, long j4, TimeUnit timeUnit) {
        try {
            a().schedule(runnable, j4, timeUnit);
        } catch (Throwable th) {
            UMRTLog.e("MobclickRT", "schedule error:" + th.getMessage());
        }
    }
}
