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

/* compiled from: ProGuard */
/* renamed from: com.tencent.open.utils.l */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class C13067l {

    /* renamed from: c */
    private static Handler f37444c;

    /* renamed from: d */
    private static HandlerThread f37445d;

    /* renamed from: b */
    private static Object f37443b = new Object();

    /* renamed from: a */
    public static final Executor f37442a = m14973c();

    /* compiled from: ProGuard */
    /* renamed from: com.tencent.open.utils.l$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    private static class ExecutorC13069a implements Executor {

        /* renamed from: a */
        final Queue<Runnable> f37446a;

        /* renamed from: b */
        Runnable f37447b;

        private ExecutorC13069a() {
            this.f37446a = new LinkedList();
        }

        /* renamed from: a */
        protected synchronized void m14972a() {
            Runnable poll = this.f37446a.poll();
            this.f37447b = poll;
            if (poll != null) {
                C13067l.f37442a.execute(poll);
            }
        }

        @Override // java.util.concurrent.Executor
        public synchronized void execute(final Runnable runnable) {
            this.f37446a.offer(new Runnable() { // from class: com.tencent.open.utils.l.a.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        runnable.run();
                    } finally {
                        ExecutorC13069a.this.m14972a();
                    }
                }
            });
            if (this.f37447b == null) {
                m14972a();
            }
        }
    }

    /* renamed from: a */
    public static void m14976a(Runnable runnable) {
        try {
            f37442a.execute(runnable);
        } catch (RejectedExecutionException unused) {
        }
    }

    /* renamed from: b */
    public static void m14974b(Runnable runnable) {
        m14977a().post(runnable);
    }

    /* renamed from: c */
    private static Executor m14973c() {
        return new ThreadPoolExecutor(0, 3, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue());
    }

    /* renamed from: a */
    public static Handler m14977a() {
        if (f37444c == null) {
            synchronized (C13067l.class) {
                HandlerThread handlerThread = new HandlerThread("SDK_SUB");
                f37445d = handlerThread;
                handlerThread.start();
                f37444c = new Handler(f37445d.getLooper());
            }
        }
        return f37444c;
    }

    /* renamed from: b */
    public static Executor m14975b() {
        return new ExecutorC13069a();
    }
}
