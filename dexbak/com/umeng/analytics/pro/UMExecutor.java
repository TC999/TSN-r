package com.umeng.analytics.pro;

import com.umeng.commonsdk.debug.UMRTLog;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.umeng.analytics.pro.as */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class UMExecutor {

    /* renamed from: a */
    private static final String f37673a = "UMExecutor";

    /* renamed from: b */
    private static volatile ScheduledThreadPoolExecutor f37674b;

    /* renamed from: c */
    private static final ThreadFactory f37675c = new ThreadFactory() { // from class: com.umeng.analytics.pro.as.1

        /* renamed from: a */
        private final AtomicInteger f37676a = new AtomicInteger(0);

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "ccg-" + this.f37676a.incrementAndGet());
        }
    };

    /* renamed from: a */
    private static ScheduledThreadPoolExecutor m14702a() {
        if (f37674b == null) {
            synchronized (UMExecutor.class) {
                if (f37674b == null) {
                    f37674b = new ScheduledThreadPoolExecutor(Math.max(2, Math.min(Runtime.getRuntime().availableProcessors(), 4)), f37675c);
                    f37674b.setKeepAliveTime(3L, TimeUnit.SECONDS);
                    f37674b.allowCoreThreadTimeOut(true);
                }
            }
        }
        return f37674b;
    }

    /* renamed from: a */
    public static void m14701a(Runnable runnable, long j, TimeUnit timeUnit) {
        try {
            m14702a().schedule(runnable, j, timeUnit);
        } catch (Throwable th) {
            UMRTLog.m14009e(UMRTLog.RTLOG_TAG, "schedule error:" + th.getMessage());
        }
    }
}
