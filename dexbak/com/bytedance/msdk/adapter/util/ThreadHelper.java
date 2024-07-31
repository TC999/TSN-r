package com.bytedance.msdk.adapter.util;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class ThreadHelper {

    /* renamed from: a */
    private static final Object f21516a = new Object();

    /* renamed from: b */
    private static boolean f21517b = false;

    /* renamed from: c */
    private static Handler f21518c = null;

    /* renamed from: d */
    private static HandlerThread f21519d = null;

    /* renamed from: e */
    private static Handler f21520e = null;

    /* renamed from: f */
    static final /* synthetic */ boolean f21521f = true;

    static {
        m37536a();
    }

    /* renamed from: a */
    private static void m37536a() {
        try {
            HandlerThread handlerThread = new HandlerThread("tt-msdk-thread", -19);
            f21519d = handlerThread;
            handlerThread.start();
            f21520e = new Handler(f21519d.getLooper());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void assertOnUiThread() {
        if (!f21521f && !runningOnUiThread()) {
            throw new AssertionError();
        }
    }

    /* renamed from: b */
    private static boolean m37535b() {
        HandlerThread handlerThread = f21519d;
        return (handlerThread == null || !handlerThread.isAlive() || f21520e == null) ? false : true;
    }

    public static ThreadFactory createNamedThreadFactory(final String str) {
        return new ThreadFactory() { // from class: com.bytedance.msdk.adapter.util.ThreadHelper.1

            /* renamed from: a */
            private final AtomicInteger f21522a = new AtomicInteger(1);

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                return new Thread(runnable, str + " # " + this.f21522a.getAndIncrement());
            }
        };
    }

    public static Looper getMSDKThreadLooper() {
        if (m37535b()) {
            return f21519d.getLooper();
        }
        return null;
    }

    public static Handler getUiThreadHandler() {
        Handler handler;
        synchronized (f21516a) {
            if (f21518c == null) {
                if (!f21517b) {
                    f21518c = new Handler(Looper.getMainLooper());
                } else {
                    throw new RuntimeException("Did not yet override the UI thread");
                }
            }
            handler = f21518c;
        }
        return handler;
    }

    public static void postDelayOnMSDKThread(Runnable runnable, long j) {
        if (m37535b()) {
            f21520e.postDelayed(runnable, j);
        } else {
            m37536a();
        }
    }

    public static <T> FutureTask<T> postOnUiThread(FutureTask<T> futureTask) {
        getUiThreadHandler().post(futureTask);
        return futureTask;
    }

    public static void postOnUiThreadDelayed(Runnable runnable, long j) {
        getUiThreadHandler().postDelayed(runnable, j);
    }

    public static void revokeOnUiThread(Runnable runnable) {
        getUiThreadHandler().removeCallbacks(runnable);
    }

    public static void runOnMSDKThread(Runnable runnable) {
        if (m37535b()) {
            if (runningOnMSDKThread()) {
                runnable.run();
                return;
            } else {
                f21520e.post(runnable);
                return;
            }
        }
        m37536a();
    }

    public static <T> FutureTask<T> runOnUiThread(FutureTask<T> futureTask) {
        if (runningOnUiThread()) {
            futureTask.run();
        } else {
            postOnUiThread((FutureTask) futureTask);
        }
        return futureTask;
    }

    public static void runOnUiThreadBlocking(Runnable runnable) {
        if (runningOnUiThread()) {
            runnable.run();
            return;
        }
        FutureTask futureTask = new FutureTask(runnable, null);
        postOnUiThread(futureTask);
        try {
            futureTask.get();
        } catch (Exception e) {
            throw new RuntimeException("Exception occured while waiting for runnable", e);
        }
    }

    public static <T> T runOnUiThreadBlockingNoException(Callable<T> callable) {
        try {
            return (T) runOnUiThreadBlocking(callable);
        } catch (ExecutionException e) {
            throw new RuntimeException("Error occured waiting for callable", e);
        }
    }

    public static boolean runningOnMSDKThread() {
        return m37535b() && f21519d.getLooper() == Looper.myLooper();
    }

    public static boolean runningOnUiThread() {
        return getUiThreadHandler().getLooper() == Looper.myLooper();
    }

    public static void postOnUiThread(Runnable runnable) {
        getUiThreadHandler().post(runnable);
    }

    public static void runOnUiThread(Runnable runnable) {
        if (runningOnUiThread()) {
            runnable.run();
        } else {
            getUiThreadHandler().post(runnable);
        }
    }

    public static <T> T runOnUiThreadBlocking(Callable<T> callable) throws ExecutionException {
        FutureTask futureTask = new FutureTask(callable);
        runOnUiThread(futureTask);
        try {
            return (T) futureTask.get();
        } catch (InterruptedException e) {
            throw new RuntimeException("Interrupted waiting for callable", e);
        }
    }
}
