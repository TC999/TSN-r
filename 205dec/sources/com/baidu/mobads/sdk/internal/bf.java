package com.baidu.mobads.sdk.internal;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class bf {

    /* renamed from: a  reason: collision with root package name */
    private static final String f12464a = "ThreadPoolFactory";

    /* renamed from: b  reason: collision with root package name */
    private static final int f12465b = 2;

    /* renamed from: c  reason: collision with root package name */
    private static final int f12466c = 60;

    /* renamed from: d  reason: collision with root package name */
    private static ThreadPoolExecutor f12467d;

    /* renamed from: e  reason: collision with root package name */
    private static LinkedBlockingQueue<Runnable> f12468e;

    /* renamed from: f  reason: collision with root package name */
    private static final ThreadFactory f12469f = new bg();

    /* renamed from: g  reason: collision with root package name */
    private static final RejectedExecutionHandler f12470g = new bi();

    public static ThreadPoolExecutor a(int i4, int i5) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i4, i5, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), f12469f);
        threadPoolExecutor.setRejectedExecutionHandler(f12470g);
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }

    public static ScheduledThreadPoolExecutor a(int i4) {
        return new ScheduledThreadPoolExecutor(i4, f12469f);
    }
}
