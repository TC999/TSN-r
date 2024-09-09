package com.bytedance.msdk.adapter.sr;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class f {

    /* renamed from: c  reason: collision with root package name */
    static final /* synthetic */ boolean f27206c = true;
    private static final int ev;

    /* renamed from: f  reason: collision with root package name */
    private static Handler f27207f;
    private static final ThreadPoolExecutor gd;

    /* renamed from: p  reason: collision with root package name */
    private static final Executor f27208p;

    /* renamed from: r  reason: collision with root package name */
    private static final int f27209r;
    private static Handler sr;
    private static HandlerThread ux;

    /* renamed from: w  reason: collision with root package name */
    private static final Object f27210w = new Object();
    private static boolean xv;

    static {
        c();
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f27209r = availableProcessors;
        ev = Math.min(availableProcessors, 4);
        gd = p();
        f27208p = k();
    }

    public static void c() {
        try {
            HandlerThread handlerThread = new HandlerThread("gm_t_main", -19);
            ux = handlerThread;
            handlerThread.start();
            f27207f = new Handler(ux.getLooper());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static int ev() {
        int i4 = 0;
        for (Thread thread : Thread.getAllStackTraces().keySet()) {
            if (thread != null && thread.getName() != null && thread.getName().contains("gm_t_")) {
                i4++;
                xv.c("TMe", "--==-- thread: " + thread.getName());
            }
        }
        return i4;
    }

    public static Executor f() {
        return gd;
    }

    private static boolean gd() {
        HandlerThread handlerThread = ux;
        return (handlerThread == null || !handlerThread.isAlive() || f27207f == null) ? false : true;
    }

    private static Executor k() {
        return new com.bytedance.sdk.component.gd.sr.sr(2, 2, 0L, TimeUnit.SECONDS, new LinkedBlockingQueue(256), c("gm_t_log_upload:"), new ThreadPoolExecutor.DiscardPolicy());
    }

    private static ThreadPoolExecutor p() {
        int i4 = ev;
        com.bytedance.sdk.component.gd.sr.sr srVar = new com.bytedance.sdk.component.gd.sr.sr(i4, i4, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(1024), c("gm_t_executor:"), new ThreadPoolExecutor.DiscardOldestPolicy() { // from class: com.bytedance.msdk.adapter.sr.f.2
            @Override // java.util.concurrent.ThreadPoolExecutor.DiscardOldestPolicy, java.util.concurrent.RejectedExecutionHandler
            public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
                super.rejectedExecution(runnable, threadPoolExecutor);
                com.bytedance.msdk.ux.xv.c.c().ux();
            }
        });
        try {
            srVar.allowCoreThreadTimeOut(true);
        } catch (Exception e4) {
            Log.e("ThreadHelper", "stackerror:", e4);
        } catch (NoSuchMethodError e5) {
            e5.printStackTrace();
        }
        return srVar;
    }

    public static Executor r() {
        return f27208p;
    }

    public static Handler sr() {
        Handler handler;
        synchronized (f27210w) {
            if (sr == null) {
                if (!xv) {
                    sr = new Handler(Looper.getMainLooper());
                } else {
                    throw new RuntimeException("Did not yet override the UI thread");
                }
            }
            handler = sr;
        }
        return handler;
    }

    public static boolean ux() {
        return sr().getLooper() == Looper.myLooper();
    }

    public static Looper w() {
        if (gd()) {
            return ux.getLooper();
        }
        return null;
    }

    public static boolean xv() {
        return gd() && ux.getLooper() == Looper.myLooper();
    }

    public static void w(Runnable runnable) {
        if (ux()) {
            runnable.run();
            return;
        }
        FutureTask futureTask = new FutureTask(runnable, null);
        c(futureTask);
        try {
            futureTask.get();
        } catch (Exception e4) {
            throw new RuntimeException("Exception occured while waiting for runnable", e4);
        }
    }

    public static void xv(Runnable runnable) {
        if (ux()) {
            runnable.run();
        } else {
            sr().post(runnable);
        }
    }

    public static void c(Runnable runnable) {
        if (gd()) {
            if (xv()) {
                runnable.run();
                return;
            } else {
                f27207f.post(runnable);
                return;
            }
        }
        c();
    }

    public static void sr(Runnable runnable) {
        c(gd, runnable);
    }

    public static void w(Runnable runnable, long j4) {
        sr().postDelayed(runnable, j4);
    }

    public static void c(Runnable runnable, long j4) {
        if (gd()) {
            f27207f.postDelayed(runnable, j4);
        } else {
            c();
        }
    }

    public static ThreadFactory c(final String str) {
        return new ThreadFactory() { // from class: com.bytedance.msdk.adapter.sr.f.1

            /* renamed from: w  reason: collision with root package name */
            private final AtomicInteger f27212w = new AtomicInteger(1);

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                return new com.bytedance.sdk.component.gd.sr.xv(runnable, str + " # " + this.f27212w.getAndIncrement());
            }
        };
    }

    public static <T> FutureTask<T> c(FutureTask<T> futureTask) {
        sr().post(futureTask);
        return futureTask;
    }

    public static ExecutorService c(String str, int i4, RejectedExecutionHandler rejectedExecutionHandler) {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue(i4);
        return new com.bytedance.sdk.component.gd.sr.sr(1, 1, 0L, timeUnit, linkedBlockingQueue, c("gm_t_single_" + str), rejectedExecutionHandler);
    }

    public static <T> Future<T> c(Callable<T> callable) {
        try {
            return gd.submit(callable);
        } catch (Exception e4) {
            Log.e("ThreadHelper", "stackerror:", e4);
            return null;
        }
    }

    private static boolean c(Executor executor, Runnable runnable) {
        try {
            executor.execute(runnable);
            return true;
        } catch (Exception e4) {
            Log.e("ThreadHelper", "stackerror:", e4);
            return false;
        }
    }
}
