package com.bytedance.sdk.component.gd;

import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public interface w {
    void allowCoreThreadTimeOut(boolean z3);

    boolean allowsCoreThreadTimeOut();

    boolean awaitTermination(long j4, TimeUnit timeUnit) throws InterruptedException;

    void execute(Runnable runnable);

    int getActiveCount();

    long getCompletedTaskCount();

    int getCorePoolSize();

    long getKeepAliveTime(TimeUnit timeUnit);

    int getLargestPoolSize();

    int getMaximumPoolSize();

    int getPoolSize();

    BlockingQueue<Runnable> getQueue();

    RejectedExecutionHandler getRejectedExecutionHandler();

    long getTaskCount();

    ThreadFactory getThreadFactory();

    boolean isShutdown();

    boolean isTerminated();

    boolean isTerminating();

    int prestartAllCoreThreads();

    boolean prestartCoreThread();

    void purge();

    boolean remove(Runnable runnable);

    void setCorePoolSize(int i4);

    void setKeepAliveTime(long j4, TimeUnit timeUnit);

    void setMaximumPoolSize(int i4);

    void setRejectedExecutionHandler(RejectedExecutionHandler rejectedExecutionHandler);

    void setThreadFactory(ThreadFactory threadFactory);

    void shutdown();

    List<Runnable> shutdownNow();

    Future<?> submit(Runnable runnable);

    <T> Future<T> submit(Runnable runnable, T t3);

    <T> Future<T> submit(Callable<T> callable);

    String toString();
}
