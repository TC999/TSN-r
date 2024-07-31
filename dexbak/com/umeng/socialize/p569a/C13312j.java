package com.umeng.socialize.p569a;

import android.os.AsyncTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: UMExecutor.java */
/* renamed from: com.umeng.socialize.a.j */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C13312j {

    /* renamed from: a */
    private static final String f39324a = "UMExecutor";

    /* renamed from: b */
    private static volatile ScheduledThreadPoolExecutor f39325b;

    /* renamed from: c */
    private static volatile ExecutorService f39326c;

    /* renamed from: d */
    private static final ThreadFactory f39327d = new ThreadFactory() { // from class: com.umeng.socialize.a.j.1

        /* renamed from: a */
        private final AtomicInteger f39328a = new AtomicInteger(0);

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "Azx-" + this.f39328a.incrementAndGet());
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: UMExecutor.java */
    /* renamed from: com.umeng.socialize.a.j$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static class RunnableC13314a implements Runnable {

        /* renamed from: a */
        private final Runnable f39329a;

        public RunnableC13314a(Runnable runnable) {
            this.f39329a = runnable;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                Runnable runnable = this.f39329a;
                if (runnable != null) {
                    runnable.run();
                }
            } catch (Throwable th) {
                UPLog.m13359d(C13312j.f39324a, "error:", th.getMessage());
            }
        }
    }

    /* renamed from: a */
    private static ScheduledThreadPoolExecutor m13387a() {
        if (f39325b == null) {
            synchronized (C13312j.class) {
                if (f39325b == null) {
                    f39325b = new ScheduledThreadPoolExecutor(Math.max(2, Math.min(Runtime.getRuntime().availableProcessors(), 4)), f39327d);
                    f39325b.setKeepAliveTime(3L, TimeUnit.SECONDS);
                    f39325b.allowCoreThreadTimeOut(true);
                }
            }
        }
        return f39325b;
    }

    /* renamed from: b */
    private static ExecutorService m13383b() {
        if (f39326c == null) {
            synchronized (C13312j.class) {
                if (f39326c == null) {
                    f39326c = Executors.newSingleThreadExecutor(f39327d);
                }
            }
        }
        return f39326c;
    }

    /* renamed from: c */
    public static Future<?> m13381c(Runnable runnable) {
        try {
            return m13387a().submit(m13380d(runnable));
        } catch (Throwable th) {
            UPLog.m13359d(f39324a, "submit error:", th.getMessage());
            return null;
        }
    }

    /* renamed from: d */
    private static Runnable m13380d(Runnable runnable) {
        return new RunnableC13314a(runnable);
    }

    /* renamed from: b */
    public static void m13382b(Runnable runnable) {
        try {
            m13387a().execute(m13380d(runnable));
        } catch (Throwable th) {
            UPLog.m13359d(f39324a, "execute error:", th.getMessage());
        }
    }

    @SafeVarargs
    /* renamed from: a */
    public static <Params, Progress, Result> void m13386a(AsyncTask<Params, Progress, Result> asyncTask, Params... paramsArr) {
        if (asyncTask == null) {
            return;
        }
        try {
            asyncTask.executeOnExecutor(m13387a(), paramsArr);
        } catch (Throwable th) {
            UPLog.m13359d(f39324a, "executeOnExecutor error:", th.getMessage());
        }
    }

    /* renamed from: a */
    public static Future<?> m13385a(Runnable runnable) {
        try {
            return m13383b().submit(m13380d(runnable));
        } catch (Throwable th) {
            UPLog.m13359d(f39324a, "submitSingleTask error:", th.getMessage());
            return null;
        }
    }

    /* renamed from: a */
    public static void m13384a(Runnable runnable, long j, TimeUnit timeUnit) {
        try {
            m13387a().schedule(runnable, j, timeUnit);
        } catch (Throwable th) {
            UPLog.m13359d(f39324a, "schedule error:", th.getMessage());
        }
    }
}
