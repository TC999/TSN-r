package com.beizi.fusion.p072g;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: BeiZiThreadPool.java */
/* renamed from: com.beizi.fusion.g.l */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class C3156l {

    /* renamed from: a */
    private static final int f11392a;

    /* renamed from: b */
    private static final int f11393b;

    /* renamed from: c */
    private static final LinkedBlockingQueue<Runnable> f11394c;

    /* renamed from: d */
    private static final LinkedBlockingQueue<Runnable> f11395d;

    /* renamed from: e */
    private static final LinkedBlockingQueue<Runnable> f11396e;

    /* renamed from: f */
    private static final ArrayBlockingQueue<Runnable> f11397f;

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f11392a = availableProcessors;
        f11393b = Math.max((availableProcessors / 2) + 1, 4);
        f11394c = new LinkedBlockingQueue<>();
        f11395d = new LinkedBlockingQueue<>();
        f11396e = new LinkedBlockingQueue<>();
        f11397f = new ArrayBlockingQueue<>(200);
    }

    /* renamed from: a */
    public static ThreadPoolExecutor m48242a() {
        return new ThreadPoolExecutor(2, f11393b, 5L, TimeUnit.SECONDS, f11394c, new ThreadFactoryC3155k(5, "afAd-"), m48238e());
    }

    /* renamed from: b */
    public static ThreadPoolExecutor m48241b() {
        return new ThreadPoolExecutor(2, f11393b, 5L, TimeUnit.SECONDS, f11395d, new ThreadFactoryC3155k(5, "afHb-"), m48238e());
    }

    /* renamed from: c */
    public static ThreadPoolExecutor m48240c() {
        return new ThreadPoolExecutor(2, 20, 20L, TimeUnit.SECONDS, f11397f, new ThreadFactoryC3155k(5, "afFu-"), m48238e());
    }

    /* renamed from: d */
    public static ThreadPoolExecutor m48239d() {
        return new ThreadPoolExecutor(2, f11393b, 20L, TimeUnit.SECONDS, f11396e, new ThreadFactoryC3155k(5, "afIt-"), m48238e());
    }

    /* renamed from: e */
    public static RejectedExecutionHandler m48238e() {
        return new RejectedExecutionHandler() { // from class: com.beizi.fusion.g.l.1
            @Override // java.util.concurrent.RejectedExecutionHandler
            public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            }
        };
    }
}
