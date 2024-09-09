package com.amap.api.col.s;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: ThreadPoolExecutorUtil.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class y {

    /* renamed from: c  reason: collision with root package name */
    private static volatile y f10472c;

    /* renamed from: a  reason: collision with root package name */
    private BlockingQueue<Runnable> f10473a = new LinkedBlockingQueue();

    /* renamed from: b  reason: collision with root package name */
    private ExecutorService f10474b;

    private y() {
        this.f10474b = null;
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        this.f10474b = new ThreadPoolExecutor(availableProcessors, availableProcessors * 2, 1L, TimeUnit.SECONDS, this.f10473a, new ThreadPoolExecutor.AbortPolicy());
    }

    public static y a() {
        if (f10472c == null) {
            synchronized (y.class) {
                if (f10472c == null) {
                    f10472c = new y();
                }
            }
        }
        return f10472c;
    }

    public static void c() {
        if (f10472c != null) {
            synchronized (y.class) {
                if (f10472c != null) {
                    f10472c.f10474b.shutdownNow();
                    f10472c.f10474b = null;
                    f10472c = null;
                }
            }
        }
    }

    public final void b(Runnable runnable) {
        ExecutorService executorService = this.f10474b;
        if (executorService != null) {
            executorService.execute(runnable);
        }
    }
}
