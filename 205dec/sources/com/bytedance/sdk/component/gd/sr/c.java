package com.bytedance.sdk.component.gd.sr;

import com.bytedance.sdk.component.gd.a;
import com.bytedance.sdk.component.gd.c.f;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c extends ThreadPoolExecutor implements com.bytedance.sdk.component.gd.w {

    /* renamed from: c  reason: collision with root package name */
    public static final RejectedExecutionHandler f29848c = new RejectedExecutionHandler() { // from class: com.bytedance.sdk.component.gd.sr.c.1
        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            if (threadPoolExecutor != null && (threadPoolExecutor instanceof ScheduledThreadPoolExecutor) && threadPoolExecutor.getCorePoolSize() == 1) {
                a aVar = a.f29806w;
                ScheduledExecutorService k4 = aVar.k();
                if (!k4.isShutdown() && !k4.isTerminated()) {
                    k4.execute(runnable);
                } else {
                    aVar.gd().execute(runnable);
                }
            } else {
                a.f29806w.gd().execute(runnable);
            }
            a.f29806w.r().c(runnable, threadPoolExecutor);
        }
    };

    /* renamed from: w  reason: collision with root package name */
    private com.bytedance.sdk.component.gd.w f29849w;

    public c(int i4, int i5, long j4, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory) {
        this(i4, i5, j4, timeUnit, blockingQueue, threadFactory, f29848c);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.gd.w
    public void allowCoreThreadTimeOut(boolean z3) {
        this.f29849w.allowCoreThreadTimeOut(z3);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.gd.w
    public boolean allowsCoreThreadTimeOut() {
        return this.f29849w.allowsCoreThreadTimeOut();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService, com.bytedance.sdk.component.gd.w
    public boolean awaitTermination(long j4, TimeUnit timeUnit) throws InterruptedException {
        return this.f29849w.awaitTermination(j4, timeUnit);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor, com.bytedance.sdk.component.gd.w
    public void execute(Runnable runnable) {
        this.f29849w.execute(runnable);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.gd.w
    public int getActiveCount() {
        return this.f29849w.getActiveCount();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.gd.w
    public long getCompletedTaskCount() {
        return this.f29849w.getCompletedTaskCount();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.gd.w
    public int getCorePoolSize() {
        return this.f29849w.getCorePoolSize();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.gd.w
    public long getKeepAliveTime(TimeUnit timeUnit) {
        return this.f29849w.getKeepAliveTime(timeUnit);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.gd.w
    public int getLargestPoolSize() {
        return this.f29849w.getLargestPoolSize();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.gd.w
    public int getMaximumPoolSize() {
        return this.f29849w.getMaximumPoolSize();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.gd.w
    public int getPoolSize() {
        return this.f29849w.getPoolSize();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.gd.w
    public BlockingQueue<Runnable> getQueue() {
        return this.f29849w.getQueue();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.gd.w
    public RejectedExecutionHandler getRejectedExecutionHandler() {
        return this.f29849w.getRejectedExecutionHandler();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.gd.w
    public long getTaskCount() {
        return this.f29849w.getTaskCount();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.gd.w
    public ThreadFactory getThreadFactory() {
        return this.f29849w.getThreadFactory();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService, com.bytedance.sdk.component.gd.w
    public boolean isShutdown() {
        return this.f29849w.isShutdown();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService, com.bytedance.sdk.component.gd.w
    public boolean isTerminated() {
        return this.f29849w.isTerminated();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.gd.w
    public boolean isTerminating() {
        return this.f29849w.isTerminating();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.gd.w
    public int prestartAllCoreThreads() {
        return this.f29849w.prestartAllCoreThreads();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.gd.w
    public boolean prestartCoreThread() {
        return this.f29849w.prestartCoreThread();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.gd.w
    public void purge() {
        this.f29849w.purge();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.gd.w
    public boolean remove(Runnable runnable) {
        return this.f29849w.remove(runnable);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.gd.w
    public void setCorePoolSize(int i4) {
        this.f29849w.setCorePoolSize(i4);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.gd.w
    public void setKeepAliveTime(long j4, TimeUnit timeUnit) {
        this.f29849w.setKeepAliveTime(j4, timeUnit);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.gd.w
    public void setMaximumPoolSize(int i4) {
        this.f29849w.setMaximumPoolSize(i4);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.gd.w
    public void setRejectedExecutionHandler(RejectedExecutionHandler rejectedExecutionHandler) {
        this.f29849w.setRejectedExecutionHandler(rejectedExecutionHandler);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.gd.w
    public void setThreadFactory(ThreadFactory threadFactory) {
        threadFactory.getClass();
        this.f29849w.setThreadFactory(threadFactory);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService, com.bytedance.sdk.component.gd.w
    public void shutdown() {
        this.f29849w.shutdown();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService, com.bytedance.sdk.component.gd.w
    public List<Runnable> shutdownNow() {
        return this.f29849w.shutdownNow();
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService, com.bytedance.sdk.component.gd.w
    public Future<?> submit(Runnable runnable) {
        return this.f29849w.submit(runnable);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.gd.w
    public String toString() {
        return this.f29849w.toString();
    }

    public c(int i4, int i5, long j4, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory, RejectedExecutionHandler rejectedExecutionHandler) {
        super(i4, i5, j4, timeUnit, blockingQueue, threadFactory, rejectedExecutionHandler);
        this.f29849w = new f(i4, i5, j4, timeUnit, blockingQueue, threadFactory, rejectedExecutionHandler, this);
        a.f29806w.r().c(this);
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService, com.bytedance.sdk.component.gd.w
    public <T> Future<T> submit(Callable<T> callable) {
        return this.f29849w.submit(callable);
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService, com.bytedance.sdk.component.gd.w
    public <T> Future<T> submit(Runnable runnable, T t3) {
        return this.f29849w.submit(runnable, t3);
    }
}
