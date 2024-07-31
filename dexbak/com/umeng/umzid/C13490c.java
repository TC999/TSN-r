package com.umeng.umzid;

import android.util.Log;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.umeng.umzid.c */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C13490c {

    /* renamed from: a */
    public static volatile ScheduledThreadPoolExecutor f39669a;

    /* renamed from: b */
    public static ThreadFactory f39670b = new ThreadFactoryC13491a();

    /* renamed from: com.umeng.umzid.c$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static class ThreadFactoryC13491a implements ThreadFactory {

        /* renamed from: a */
        public AtomicInteger f39671a = new AtomicInteger(0);

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName("ZIDThreadPoolExecutor" + this.f39671a.addAndGet(1));
            return thread;
        }
    }

    /* renamed from: a */
    public static ScheduledThreadPoolExecutor m13193a() {
        if (f39669a == null) {
            synchronized (C13490c.class) {
                if (f39669a == null) {
                    f39669a = new ScheduledThreadPoolExecutor(Runtime.getRuntime().availableProcessors() * 4, f39670b);
                }
            }
        }
        return f39669a;
    }

    /* renamed from: a */
    public static void m13192a(Runnable runnable) {
        try {
            m13193a().execute(runnable);
        } catch (Throwable unused) {
            Log.e("com.umeng.umzid.c", "UmengThreadPoolExecutorFactory execute exception");
        }
    }
}
