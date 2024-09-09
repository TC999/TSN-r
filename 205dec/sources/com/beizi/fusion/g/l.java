package com.beizi.fusion.g;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: BeiZiThreadPool.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    private static final int f14947a;

    /* renamed from: b  reason: collision with root package name */
    private static final int f14948b;

    /* renamed from: c  reason: collision with root package name */
    private static final LinkedBlockingQueue<Runnable> f14949c;

    /* renamed from: d  reason: collision with root package name */
    private static final LinkedBlockingQueue<Runnable> f14950d;

    /* renamed from: e  reason: collision with root package name */
    private static final LinkedBlockingQueue<Runnable> f14951e;

    /* renamed from: f  reason: collision with root package name */
    private static final ArrayBlockingQueue<Runnable> f14952f;

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f14947a = availableProcessors;
        f14948b = Math.max((availableProcessors / 2) + 1, 4);
        f14949c = new LinkedBlockingQueue<>();
        f14950d = new LinkedBlockingQueue<>();
        f14951e = new LinkedBlockingQueue<>();
        f14952f = new ArrayBlockingQueue<>(200);
    }

    public static ThreadPoolExecutor a() {
        return new ThreadPoolExecutor(2, f14948b, 5L, TimeUnit.SECONDS, f14949c, new k(5, "afAd-"), e());
    }

    public static ThreadPoolExecutor b() {
        return new ThreadPoolExecutor(2, f14948b, 5L, TimeUnit.SECONDS, f14950d, new k(5, "afHb-"), e());
    }

    public static ThreadPoolExecutor c() {
        return new ThreadPoolExecutor(2, 20, 20L, TimeUnit.SECONDS, f14952f, new k(5, "afFu-"), e());
    }

    public static ThreadPoolExecutor d() {
        return new ThreadPoolExecutor(2, f14948b, 20L, TimeUnit.SECONDS, f14951e, new k(5, "afIt-"), e());
    }

    public static RejectedExecutionHandler e() {
        return new RejectedExecutionHandler() { // from class: com.beizi.fusion.g.l.1
            @Override // java.util.concurrent.RejectedExecutionHandler
            public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            }
        };
    }
}
