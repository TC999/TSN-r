package com.bytedance.sdk.component.gd;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class sr {

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    protected static class c extends AbstractExecutorService {

        /* renamed from: c  reason: collision with root package name */
        private final ExecutorService f29850c;

        c(ExecutorService executorService) {
            this.f29850c = executorService;
        }

        @Override // java.util.concurrent.ExecutorService
        public boolean awaitTermination(long j4, TimeUnit timeUnit) throws InterruptedException {
            return this.f29850c.awaitTermination(j4, timeUnit);
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            this.f29850c.execute(runnable);
        }

        @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
        public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection) throws InterruptedException {
            return this.f29850c.invokeAll(collection);
        }

        @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
        public <T> T invokeAny(Collection<? extends Callable<T>> collection) throws InterruptedException, ExecutionException {
            return (T) this.f29850c.invokeAny(collection);
        }

        @Override // java.util.concurrent.ExecutorService
        public boolean isShutdown() {
            return this.f29850c.isShutdown();
        }

        @Override // java.util.concurrent.ExecutorService
        public boolean isTerminated() {
            return this.f29850c.isTerminated();
        }

        @Override // java.util.concurrent.ExecutorService
        public void shutdown() {
            this.f29850c.shutdown();
        }

        @Override // java.util.concurrent.ExecutorService
        public List<Runnable> shutdownNow() {
            return this.f29850c.shutdownNow();
        }

        @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
        public Future<?> submit(Runnable runnable) {
            return this.f29850c.submit(runnable);
        }

        @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
        public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection, long j4, TimeUnit timeUnit) throws InterruptedException {
            return this.f29850c.invokeAll(collection, j4, timeUnit);
        }

        @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
        public <T> T invokeAny(Collection<? extends Callable<T>> collection, long j4, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
            return (T) this.f29850c.invokeAny(collection, j4, timeUnit);
        }

        @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
        public <T> Future<T> submit(Callable<T> callable) {
            return this.f29850c.submit(callable);
        }

        @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
        public <T> Future<T> submit(Runnable runnable, T t3) {
            return this.f29850c.submit(runnable, t3);
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    protected static class w extends c implements ScheduledExecutorService {

        /* renamed from: c  reason: collision with root package name */
        private final ScheduledExecutorService f29860c;

        w(ScheduledExecutorService scheduledExecutorService) {
            super(scheduledExecutorService);
            this.f29860c = scheduledExecutorService;
        }

        @Override // java.util.concurrent.ScheduledExecutorService
        public ScheduledFuture<?> schedule(Runnable runnable, long j4, TimeUnit timeUnit) {
            return this.f29860c.schedule(runnable, j4, timeUnit);
        }

        @Override // java.util.concurrent.ScheduledExecutorService
        public ScheduledFuture<?> scheduleAtFixedRate(Runnable runnable, long j4, long j5, TimeUnit timeUnit) {
            return this.f29860c.scheduleAtFixedRate(runnable, j4, j5, timeUnit);
        }

        @Override // java.util.concurrent.ScheduledExecutorService
        public ScheduledFuture<?> scheduleWithFixedDelay(Runnable runnable, long j4, long j5, TimeUnit timeUnit) {
            return this.f29860c.scheduleWithFixedDelay(runnable, j4, j5, timeUnit);
        }

        @Override // java.util.concurrent.ScheduledExecutorService
        public <V> ScheduledFuture<V> schedule(Callable<V> callable, long j4, TimeUnit timeUnit) {
            return this.f29860c.schedule(callable, j4, timeUnit);
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    protected static class xv extends c {
        xv(ExecutorService executorService) {
            super(executorService);
        }

        protected void finalize() {
            super.shutdown();
        }
    }

    public static ExecutorService c(int i4, ThreadFactory threadFactory) {
        return new com.bytedance.sdk.component.gd.sr.sr(i4, i4, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), threadFactory);
    }

    public static ExecutorService w(ThreadFactory threadFactory) {
        return new com.bytedance.sdk.component.gd.sr.sr(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), threadFactory);
    }

    public static ScheduledExecutorService xv(ThreadFactory threadFactory) {
        return new w(new ScheduledThreadPoolExecutor(1, threadFactory));
    }

    public static ExecutorService c(ThreadFactory threadFactory) {
        return new xv(new com.bytedance.sdk.component.gd.sr.sr(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), threadFactory));
    }

    public static ScheduledExecutorService w(int i4, ThreadFactory threadFactory) {
        return new com.bytedance.sdk.component.gd.sr.ux(i4, threadFactory);
    }
}
