package com.umeng.socialize.a;

import android.os.AsyncTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: UMExecutor.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    private static final String f53913a = "UMExecutor";

    /* renamed from: b  reason: collision with root package name */
    private static volatile ScheduledThreadPoolExecutor f53914b;

    /* renamed from: c  reason: collision with root package name */
    private static volatile ExecutorService f53915c;

    /* renamed from: d  reason: collision with root package name */
    private static final ThreadFactory f53916d = new ThreadFactory() { // from class: com.umeng.socialize.a.j.1

        /* renamed from: a  reason: collision with root package name */
        private final AtomicInteger f53917a = new AtomicInteger(0);

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "Azx-" + this.f53917a.incrementAndGet());
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: UMExecutor.java */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final Runnable f53918a;

        public a(Runnable runnable) {
            this.f53918a = runnable;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                Runnable runnable = this.f53918a;
                if (runnable != null) {
                    runnable.run();
                }
            } catch (Throwable th) {
                m.d("UMExecutor", "error:", th.getMessage());
            }
        }
    }

    private static ScheduledThreadPoolExecutor a() {
        if (f53914b == null) {
            synchronized (j.class) {
                if (f53914b == null) {
                    f53914b = new ScheduledThreadPoolExecutor(Math.max(2, Math.min(Runtime.getRuntime().availableProcessors(), 4)), f53916d);
                    f53914b.setKeepAliveTime(3L, TimeUnit.SECONDS);
                    f53914b.allowCoreThreadTimeOut(true);
                }
            }
        }
        return f53914b;
    }

    private static ExecutorService b() {
        if (f53915c == null) {
            synchronized (j.class) {
                if (f53915c == null) {
                    f53915c = Executors.newSingleThreadExecutor(f53916d);
                }
            }
        }
        return f53915c;
    }

    public static Future<?> c(Runnable runnable) {
        try {
            return a().submit(d(runnable));
        } catch (Throwable th) {
            m.d("UMExecutor", "submit error:", th.getMessage());
            return null;
        }
    }

    private static Runnable d(Runnable runnable) {
        return new a(runnable);
    }

    public static void b(Runnable runnable) {
        try {
            a().execute(d(runnable));
        } catch (Throwable th) {
            m.d("UMExecutor", "execute error:", th.getMessage());
        }
    }

    @SafeVarargs
    public static <Params, Progress, Result> void a(AsyncTask<Params, Progress, Result> asyncTask, Params... paramsArr) {
        if (asyncTask == null) {
            return;
        }
        try {
            asyncTask.executeOnExecutor(a(), paramsArr);
        } catch (Throwable th) {
            m.d("UMExecutor", "executeOnExecutor error:", th.getMessage());
        }
    }

    public static Future<?> a(Runnable runnable) {
        try {
            return b().submit(d(runnable));
        } catch (Throwable th) {
            m.d("UMExecutor", "submitSingleTask error:", th.getMessage());
            return null;
        }
    }

    public static void a(Runnable runnable, long j4, TimeUnit timeUnit) {
        try {
            a().schedule(runnable, j4, timeUnit);
        } catch (Throwable th) {
            m.d("UMExecutor", "schedule error:", th.getMessage());
        }
    }
}
