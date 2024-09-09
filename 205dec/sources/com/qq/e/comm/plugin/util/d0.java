package com.qq.e.comm.plugin.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class d0 {

    /* renamed from: a  reason: collision with root package name */
    private static final ExecutorService f46405a;

    /* renamed from: b  reason: collision with root package name */
    public static final ExecutorService f46406b;

    /* renamed from: c  reason: collision with root package name */
    public static final ExecutorService f46407c;

    /* renamed from: d  reason: collision with root package name */
    public static final ExecutorService f46408d;

    /* renamed from: e  reason: collision with root package name */
    private static final ScheduledExecutorService f46409e;

    /* renamed from: f  reason: collision with root package name */
    public static final ScheduledExecutorService f46410f;

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    static class a implements ThreadFactory {
        a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "GDT_IO_THREAD");
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    static class b implements ThreadFactory {
        b() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "GDT_SINGLE_THREAD");
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    static class c implements ThreadFactory {
        c() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "GDT_LOAD_AD_THREAD");
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    static class d implements ThreadFactory {
        d() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "GDT_SCHEDULER_THREAD");
        }
    }

    static {
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool(new a());
        f46405a = newCachedThreadPool;
        f46406b = newCachedThreadPool;
        f46407c = Executors.newSingleThreadExecutor(new b());
        f46408d = Executors.newSingleThreadExecutor(new c());
        ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor(new d());
        f46409e = newSingleThreadScheduledExecutor;
        f46410f = newSingleThreadScheduledExecutor;
    }
}
