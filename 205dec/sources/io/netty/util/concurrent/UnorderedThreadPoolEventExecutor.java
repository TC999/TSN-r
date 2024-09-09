package io.netty.util.concurrent;

import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Delayed;
import java.util.concurrent.RunnableScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class UnorderedThreadPoolEventExecutor extends ScheduledThreadPoolExecutor implements EventExecutor {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(UnorderedThreadPoolEventExecutor.class);
    private final Set<EventExecutor> executorSet;
    private final Promise<?> terminationFuture;

    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    private static final class NonNotifyRunnable implements Runnable {
        private final Runnable task;

        NonNotifyRunnable(Runnable runnable) {
            this.task = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.task.run();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    private static final class RunnableScheduledFutureTask<V> extends PromiseTask<V> implements RunnableScheduledFuture<V>, ScheduledFuture<V> {
        private final RunnableScheduledFuture<V> future;

        RunnableScheduledFutureTask(EventExecutor eventExecutor, Runnable runnable, RunnableScheduledFuture<V> runnableScheduledFuture) {
            super(eventExecutor, runnable, null);
            this.future = runnableScheduledFuture;
        }

        @Override // java.util.concurrent.Delayed
        public long getDelay(TimeUnit timeUnit) {
            return this.future.getDelay(timeUnit);
        }

        @Override // java.util.concurrent.RunnableScheduledFuture
        public boolean isPeriodic() {
            return this.future.isPeriodic();
        }

        @Override // io.netty.util.concurrent.PromiseTask, java.util.concurrent.RunnableFuture, java.lang.Runnable
        public void run() {
            if (!isPeriodic()) {
                super.run();
            } else if (isDone()) {
            } else {
                try {
                    this.task.call();
                } catch (Throwable th) {
                    if (tryFailureInternal(th)) {
                        return;
                    }
                    UnorderedThreadPoolEventExecutor.logger.warn("Failure during execution of task", th);
                }
            }
        }

        @Override // java.lang.Comparable
        public int compareTo(Delayed delayed) {
            return this.future.compareTo(delayed);
        }

        RunnableScheduledFutureTask(EventExecutor eventExecutor, Callable<V> callable, RunnableScheduledFuture<V> runnableScheduledFuture) {
            super(eventExecutor, callable);
            this.future = runnableScheduledFuture;
        }
    }

    public UnorderedThreadPoolEventExecutor(int i4) {
        this(i4, new DefaultThreadFactory(UnorderedThreadPoolEventExecutor.class));
    }

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor
    protected <V> RunnableScheduledFuture<V> decorateTask(Runnable runnable, RunnableScheduledFuture<V> runnableScheduledFuture) {
        return runnable instanceof NonNotifyRunnable ? runnableScheduledFuture : new RunnableScheduledFutureTask(this, runnable, runnableScheduledFuture);
    }

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor, java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        super.schedule((Runnable) new NonNotifyRunnable(runnable), 0L, TimeUnit.NANOSECONDS);
    }

    @Override // io.netty.util.concurrent.EventExecutor
    public boolean inEventLoop() {
        return false;
    }

    @Override // io.netty.util.concurrent.EventExecutor
    public boolean inEventLoop(Thread thread) {
        return false;
    }

    @Override // io.netty.util.concurrent.EventExecutorGroup
    public boolean isShuttingDown() {
        return isShutdown();
    }

    @Override // io.netty.util.concurrent.EventExecutorGroup, java.lang.Iterable
    public Iterator<EventExecutor> iterator() {
        return this.executorSet.iterator();
    }

    @Override // io.netty.util.concurrent.EventExecutor
    public <V> Future<V> newFailedFuture(Throwable th) {
        return new FailedFuture(this, th);
    }

    @Override // io.netty.util.concurrent.EventExecutor
    public <V> ProgressivePromise<V> newProgressivePromise() {
        return new DefaultProgressivePromise(this);
    }

    @Override // io.netty.util.concurrent.EventExecutor
    public <V> Promise<V> newPromise() {
        return new DefaultPromise(this);
    }

    @Override // io.netty.util.concurrent.EventExecutor
    public <V> Future<V> newSucceededFuture(V v3) {
        return new SucceededFuture(this, v3);
    }

    @Override // io.netty.util.concurrent.EventExecutor, io.netty.util.concurrent.EventExecutorGroup, io.netty.channel.EventLoopGroup
    public EventExecutor next() {
        return this;
    }

    @Override // io.netty.util.concurrent.EventExecutor, io.netty.channel.EventLoop
    public EventExecutorGroup parent() {
        return this;
    }

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor, java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService, io.netty.util.concurrent.EventExecutorGroup
    public void shutdown() {
        super.shutdown();
        this.terminationFuture.trySuccess(null);
    }

    @Override // io.netty.util.concurrent.EventExecutorGroup
    public Future<?> shutdownGracefully() {
        return shutdownGracefully(2L, 15L, TimeUnit.SECONDS);
    }

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor, java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService, io.netty.util.concurrent.EventExecutorGroup
    public List<Runnable> shutdownNow() {
        List<Runnable> shutdownNow = super.shutdownNow();
        this.terminationFuture.trySuccess(null);
        return shutdownNow;
    }

    @Override // io.netty.util.concurrent.EventExecutorGroup
    public Future<?> terminationFuture() {
        return this.terminationFuture;
    }

    public UnorderedThreadPoolEventExecutor(int i4, ThreadFactory threadFactory) {
        super(i4, threadFactory);
        this.terminationFuture = GlobalEventExecutor.INSTANCE.newPromise();
        this.executorSet = Collections.singleton(this);
    }

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor
    protected <V> RunnableScheduledFuture<V> decorateTask(Callable<V> callable, RunnableScheduledFuture<V> runnableScheduledFuture) {
        return new RunnableScheduledFutureTask(this, callable, runnableScheduledFuture);
    }

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor, java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture<?> scheduleAtFixedRate(Runnable runnable, long j4, long j5, TimeUnit timeUnit) {
        return (ScheduledFuture) super.scheduleAtFixedRate(runnable, j4, j5, timeUnit);
    }

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor, java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture<?> scheduleWithFixedDelay(Runnable runnable, long j4, long j5, TimeUnit timeUnit) {
        return (ScheduledFuture) super.scheduleWithFixedDelay(runnable, j4, j5, timeUnit);
    }

    @Override // io.netty.util.concurrent.EventExecutorGroup
    public Future<?> shutdownGracefully(long j4, long j5, TimeUnit timeUnit) {
        shutdown();
        return terminationFuture();
    }

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor, java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public /* bridge */ /* synthetic */ java.util.concurrent.Future submit(Runnable runnable, Object obj) {
        return submit(runnable, (Runnable) obj);
    }

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor, java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture<?> schedule(Runnable runnable, long j4, TimeUnit timeUnit) {
        return (ScheduledFuture) super.schedule(runnable, j4, timeUnit);
    }

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor, java.util.concurrent.ScheduledExecutorService
    public <V> ScheduledFuture<V> schedule(Callable<V> callable, long j4, TimeUnit timeUnit) {
        return (ScheduledFuture) super.schedule((Callable) callable, j4, timeUnit);
    }

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor, java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public Future<?> submit(Runnable runnable) {
        return (Future) super.submit(runnable);
    }

    public UnorderedThreadPoolEventExecutor(int i4, java.util.concurrent.RejectedExecutionHandler rejectedExecutionHandler) {
        this(i4, new DefaultThreadFactory(UnorderedThreadPoolEventExecutor.class), rejectedExecutionHandler);
    }

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor, java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService, io.netty.util.concurrent.EventExecutorGroup
    public <T> Future<T> submit(Runnable runnable, T t3) {
        return (Future) super.submit(runnable, (Runnable) t3);
    }

    public UnorderedThreadPoolEventExecutor(int i4, ThreadFactory threadFactory, java.util.concurrent.RejectedExecutionHandler rejectedExecutionHandler) {
        super(i4, threadFactory, rejectedExecutionHandler);
        this.terminationFuture = GlobalEventExecutor.INSTANCE.newPromise();
        this.executorSet = Collections.singleton(this);
    }

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor, java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public <T> Future<T> submit(Callable<T> callable) {
        return (Future) super.submit((Callable) callable);
    }
}
