package com.beizi.p051ad.lance.p062a;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.beizi.ad.lance.a.e */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class BeiZiThreadPool {

    /* renamed from: a */
    private static final int f10801a;

    /* renamed from: b */
    private static final int f10802b;

    /* renamed from: c */
    private static final LinkedBlockingQueue<Runnable> f10803c;

    /* renamed from: d */
    private static final LinkedBlockingQueue<Runnable> f10804d;

    /* renamed from: e */
    private static final ArrayBlockingQueue<Runnable> f10805e;

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f10801a = availableProcessors;
        f10802b = Math.max((availableProcessors / 2) + 1, 4);
        f10803c = new LinkedBlockingQueue<>();
        f10804d = new LinkedBlockingQueue<>();
        f10805e = new ArrayBlockingQueue<>(50);
    }

    /* renamed from: a */
    public static ThreadPoolExecutor m49084a() {
        return new ThreadPoolExecutor(2, f10802b, 5L, TimeUnit.SECONDS, f10803c, new BeiZiThreadFactory(5, "BeiZi-adsdk-adrequest-thread-"), m49081d());
    }

    /* renamed from: b */
    public static ThreadPoolExecutor m49083b() {
        return new ThreadPoolExecutor(0, 2, 5L, TimeUnit.SECONDS, f10804d, new BeiZiThreadFactory(5, "BeiZi-adsdk-heartbeat-thread-"), m49081d());
    }

    /* renamed from: c */
    public static ThreadPoolExecutor m49082c() {
        return new ThreadPoolExecutor(2, 6, 20L, TimeUnit.SECONDS, f10805e, new BeiZiThreadFactory(5, "BeiZi-adsdk-file-log-upload-thread-"), m49081d());
    }

    /* renamed from: d */
    public static RejectedExecutionHandler m49081d() {
        return new RejectedExecutionHandler() { // from class: com.beizi.ad.lance.a.e.1
            @Override // java.util.concurrent.RejectedExecutionHandler
            public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            }
        };
    }
}
