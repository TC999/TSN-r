package com.beizi.ad.lance.a;

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
public class e {

    /* renamed from: a  reason: collision with root package name */
    private static final int f14366a;

    /* renamed from: b  reason: collision with root package name */
    private static final int f14367b;

    /* renamed from: c  reason: collision with root package name */
    private static final LinkedBlockingQueue<Runnable> f14368c;

    /* renamed from: d  reason: collision with root package name */
    private static final LinkedBlockingQueue<Runnable> f14369d;

    /* renamed from: e  reason: collision with root package name */
    private static final ArrayBlockingQueue<Runnable> f14370e;

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f14366a = availableProcessors;
        f14367b = Math.max((availableProcessors / 2) + 1, 4);
        f14368c = new LinkedBlockingQueue<>();
        f14369d = new LinkedBlockingQueue<>();
        f14370e = new ArrayBlockingQueue<>(50);
    }

    public static ThreadPoolExecutor a() {
        return new ThreadPoolExecutor(2, f14367b, 5L, TimeUnit.SECONDS, f14368c, new d(5, "BeiZi-adsdk-adrequest-thread-"), d());
    }

    public static ThreadPoolExecutor b() {
        return new ThreadPoolExecutor(0, 2, 5L, TimeUnit.SECONDS, f14369d, new d(5, "BeiZi-adsdk-heartbeat-thread-"), d());
    }

    public static ThreadPoolExecutor c() {
        return new ThreadPoolExecutor(2, 6, 20L, TimeUnit.SECONDS, f14370e, new d(5, "BeiZi-adsdk-file-log-upload-thread-"), d());
    }

    public static RejectedExecutionHandler d() {
        return new RejectedExecutionHandler() { // from class: com.beizi.ad.lance.a.e.1
            @Override // java.util.concurrent.RejectedExecutionHandler
            public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            }
        };
    }
}
