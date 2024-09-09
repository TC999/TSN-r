package com.tencent.open.utils;

import android.os.Handler;
import android.os.HandlerThread;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: ProGuard */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class l {

    /* renamed from: c  reason: collision with root package name */
    private static Handler f51844c;

    /* renamed from: d  reason: collision with root package name */
    private static HandlerThread f51845d;

    /* renamed from: b  reason: collision with root package name */
    private static Object f51843b = new Object();

    /* renamed from: a  reason: collision with root package name */
    public static final Executor f51842a = c();

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: ProGuard */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    private static class a implements Executor {

        /* renamed from: a  reason: collision with root package name */
        final Queue<Runnable> f51846a;

        /* renamed from: b  reason: collision with root package name */
        Runnable f51847b;

        private a() {
            this.f51846a = new LinkedList();
        }

        protected synchronized void a() {
            Runnable poll = this.f51846a.poll();
            this.f51847b = poll;
            if (poll != null) {
                l.f51842a.execute(poll);
            }
        }

        @Override // java.util.concurrent.Executor
        public synchronized void execute(final Runnable runnable) {
            this.f51846a.offer(new Runnable() { // from class: com.tencent.open.utils.l.a.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        runnable.run();
                    } finally {
                        a.this.a();
                    }
                }
            });
            if (this.f51847b == null) {
                a();
            }
        }
    }

    public static void a(Runnable runnable) {
        try {
            f51842a.execute(runnable);
        } catch (RejectedExecutionException unused) {
        }
    }

    public static void b(Runnable runnable) {
        a().post(runnable);
    }

    private static Executor c() {
        return new ThreadPoolExecutor(0, 3, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue());
    }

    public static Handler a() {
        if (f51844c == null) {
            synchronized (l.class) {
                HandlerThread handlerThread = new HandlerThread("SDK_SUB");
                f51845d = handlerThread;
                handlerThread.start();
                f51844c = new Handler(f51845d.getLooper());
            }
        }
        return f51844c;
    }

    public static Executor b() {
        return new a();
    }
}
