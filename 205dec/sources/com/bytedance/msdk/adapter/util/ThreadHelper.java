package com.bytedance.msdk.adapter.util;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class ThreadHelper {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f27234a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private static boolean f27235b = false;

    /* renamed from: c  reason: collision with root package name */
    private static Handler f27236c = null;

    /* renamed from: d  reason: collision with root package name */
    private static HandlerThread f27237d = null;

    /* renamed from: e  reason: collision with root package name */
    private static Handler f27238e = null;

    /* renamed from: f  reason: collision with root package name */
    static final /* synthetic */ boolean f27239f = true;

    static {
        a();
    }

    private static void a() {
        try {
            HandlerThread handlerThread = new HandlerThread("tt-msdk-thread", -19);
            f27237d = handlerThread;
            handlerThread.start();
            f27238e = new Handler(f27237d.getLooper());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void assertOnUiThread() {
        if (!f27239f && !runningOnUiThread()) {
            throw new AssertionError();
        }
    }

    private static boolean b() {
        HandlerThread handlerThread = f27237d;
        return (handlerThread == null || !handlerThread.isAlive() || f27238e == null) ? false : true;
    }

    public static ThreadFactory createNamedThreadFactory(final String str) {
        return new ThreadFactory() { // from class: com.bytedance.msdk.adapter.util.ThreadHelper.1

            /* renamed from: a  reason: collision with root package name */
            private final AtomicInteger f27240a = new AtomicInteger(1);

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                return new Thread(runnable, str + " # " + this.f27240a.getAndIncrement());
            }
        };
    }

    public static Looper getMSDKThreadLooper() {
        if (b()) {
            return f27237d.getLooper();
        }
        return null;
    }

    public static Handler getUiThreadHandler() {
        Handler handler;
        synchronized (f27234a) {
            if (f27236c == null) {
                if (!f27235b) {
                    f27236c = new Handler(Looper.getMainLooper());
                } else {
                    throw new RuntimeException("Did not yet override the UI thread");
                }
            }
            handler = f27236c;
        }
        return handler;
    }

    public static void postDelayOnMSDKThread(Runnable runnable, long j4) {
        if (b()) {
            f27238e.postDelayed(runnable, j4);
        } else {
            a();
        }
    }

    public static <T> FutureTask<T> postOnUiThread(FutureTask<T> futureTask) {
        getUiThreadHandler().post(futureTask);
        return futureTask;
    }

    public static void postOnUiThreadDelayed(Runnable runnable, long j4) {
        getUiThreadHandler().postDelayed(runnable, j4);
    }

    public static void revokeOnUiThread(Runnable runnable) {
        getUiThreadHandler().removeCallbacks(runnable);
    }

    public static void runOnMSDKThread(Runnable runnable) {
        if (b()) {
            if (runningOnMSDKThread()) {
                runnable.run();
                return;
            } else {
                f27238e.post(runnable);
                return;
            }
        }
        a();
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
        } catch (Exception e4) {
            throw new RuntimeException("Exception occured while waiting for runnable", e4);
        }
    }

    public static <T> T runOnUiThreadBlockingNoException(Callable<T> callable) {
        try {
            return (T) runOnUiThreadBlocking(callable);
        } catch (ExecutionException e4) {
            throw new RuntimeException("Error occured waiting for callable", e4);
        }
    }

    public static boolean runningOnMSDKThread() {
        return b() && f27237d.getLooper() == Looper.myLooper();
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
        } catch (InterruptedException e4) {
            throw new RuntimeException("Interrupted waiting for callable", e4);
        }
    }
}
