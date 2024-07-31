package com.amap.api.col.p047s;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.amap.api.col.s.y */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class ThreadPoolExecutorUtil {

    /* renamed from: c */
    private static volatile ThreadPoolExecutorUtil f6744c;

    /* renamed from: a */
    private BlockingQueue<Runnable> f6745a = new LinkedBlockingQueue();

    /* renamed from: b */
    private ExecutorService f6746b;

    private ThreadPoolExecutorUtil() {
        this.f6746b = null;
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        this.f6746b = new ThreadPoolExecutor(availableProcessors, availableProcessors * 2, 1L, TimeUnit.SECONDS, this.f6745a, new ThreadPoolExecutor.AbortPolicy());
    }

    /* renamed from: a */
    public static ThreadPoolExecutorUtil m52255a() {
        if (f6744c == null) {
            synchronized (ThreadPoolExecutorUtil.class) {
                if (f6744c == null) {
                    f6744c = new ThreadPoolExecutorUtil();
                }
            }
        }
        return f6744c;
    }

    /* renamed from: c */
    public static void m52253c() {
        if (f6744c != null) {
            synchronized (ThreadPoolExecutorUtil.class) {
                if (f6744c != null) {
                    f6744c.f6746b.shutdownNow();
                    f6744c.f6746b = null;
                    f6744c = null;
                }
            }
        }
    }

    /* renamed from: b */
    public final void m52254b(Runnable runnable) {
        ExecutorService executorService = this.f6746b;
        if (executorService != null) {
            executorService.execute(runnable);
        }
    }
}
