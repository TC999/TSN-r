package com.bytedance.pangle.p119d;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.bytedance.pangle.d.e */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class C6083e {

    /* renamed from: a */
    private static Executor f21922a = Executors.newCachedThreadPool(new ThreadFactory() { // from class: com.bytedance.pangle.d.e.1

        /* renamed from: a */
        private final AtomicInteger f21925a = new AtomicInteger(1);

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            return new Thread(runnable, "pangle-Fast-" + this.f21925a.getAndIncrement());
        }
    });

    /* renamed from: b */
    private static final Object f21923b = new Object();

    /* renamed from: c */
    private static Handler f21924c = null;

    /* renamed from: a */
    public static void m37212a(Runnable runnable) {
        f21922a.execute(runnable);
    }

    /* renamed from: b */
    public static void m37211b(Runnable runnable) {
        if (m37214a().getLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            m37214a().post(runnable);
        }
    }

    /* renamed from: a */
    public static ExecutorService m37213a(int i) {
        return Executors.newFixedThreadPool(i, new ThreadFactory() { // from class: com.bytedance.pangle.d.e.2

            /* renamed from: a */
            private final AtomicInteger f21926a = new AtomicInteger(1);

            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return new Thread(runnable, "pangle-Install-" + this.f21926a.getAndIncrement());
            }
        });
    }

    /* renamed from: a */
    private static Handler m37214a() {
        Handler handler;
        synchronized (f21923b) {
            if (f21924c == null) {
                f21924c = new Handler(Looper.getMainLooper());
            }
            handler = f21924c;
        }
        return handler;
    }
}
