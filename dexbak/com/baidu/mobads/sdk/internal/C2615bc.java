package com.baidu.mobads.sdk.internal;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.baidu.mobads.sdk.internal.bc */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class C2615bc {

    /* renamed from: a */
    private static final String f8647a = "ThreadPoolFactory";

    /* renamed from: b */
    private static final int f8648b = 2;

    /* renamed from: c */
    private static final int f8649c = 60;

    /* renamed from: d */
    private static ThreadPoolExecutor f8650d;

    /* renamed from: e */
    private static LinkedBlockingQueue<Runnable> f8651e;

    /* renamed from: f */
    private static final ThreadFactory f8652f = new ThreadFactoryC2616bd();

    /* renamed from: g */
    private static final RejectedExecutionHandler f8653g = new RejectedExecutionHandlerC2618bf();

    /* renamed from: a */
    public static ThreadPoolExecutor m50833a(int i, int i2) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i, i2, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), f8652f);
        threadPoolExecutor.setRejectedExecutionHandler(f8653g);
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }

    /* renamed from: a */
    public static ScheduledThreadPoolExecutor m50834a(int i) {
        return new ScheduledThreadPoolExecutor(i, f8652f);
    }
}
