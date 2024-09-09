package io.netty.util.concurrent;

import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class NonStickyEventExecutorGroup implements EventExecutorGroup {
    private final EventExecutorGroup group;
    private final int maxTaskExecutePerRun;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class NonStickyOrderedEventExecutor extends AbstractEventExecutor implements Runnable, OrderedEventExecutor {
        private static final int NONE = 0;
        private static final int RUNNING = 2;
        private static final int SUBMITTED = 1;
        private final EventExecutor executor;
        private final int maxTaskExecutePerRun;
        private final AtomicInteger state;
        private final Queue<Runnable> tasks;

        NonStickyOrderedEventExecutor(EventExecutor eventExecutor, int i4) {
            super(eventExecutor);
            this.tasks = PlatformDependent.newMpscQueue();
            this.state = new AtomicInteger();
            this.executor = eventExecutor;
            this.maxTaskExecutePerRun = i4;
        }

        @Override // java.util.concurrent.ExecutorService
        public boolean awaitTermination(long j4, TimeUnit timeUnit) throws InterruptedException {
            return this.executor.awaitTermination(j4, timeUnit);
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            if (this.tasks.offer(runnable)) {
                if (this.state.compareAndSet(0, 1)) {
                    try {
                        this.executor.execute(this);
                        return;
                    } catch (Throwable th) {
                        this.tasks.remove(runnable);
                        PlatformDependent.throwException(th);
                        return;
                    }
                }
                return;
            }
            throw new RejectedExecutionException();
        }

        @Override // io.netty.util.concurrent.AbstractEventExecutor, io.netty.util.concurrent.EventExecutor
        public boolean inEventLoop() {
            return false;
        }

        @Override // io.netty.util.concurrent.EventExecutor
        public boolean inEventLoop(Thread thread) {
            return false;
        }

        @Override // java.util.concurrent.ExecutorService
        public boolean isShutdown() {
            return this.executor.isShutdown();
        }

        @Override // io.netty.util.concurrent.EventExecutorGroup
        public boolean isShuttingDown() {
            return this.executor.isShutdown();
        }

        @Override // java.util.concurrent.ExecutorService
        public boolean isTerminated() {
            return this.executor.isTerminated();
        }

        @Override // java.lang.Runnable
        public void run() {
            Runnable poll;
            if (!this.state.compareAndSet(1, 2)) {
                return;
            }
            while (true) {
                int i4 = 0;
                while (i4 < this.maxTaskExecutePerRun && (poll = this.tasks.poll()) != null) {
                    try {
                        AbstractEventExecutor.safeExecute(poll);
                        i4++;
                    } catch (Throwable th) {
                        if (i4 == this.maxTaskExecutePerRun) {
                            try {
                                this.state.set(1);
                                this.executor.execute(this);
                                return;
                            } catch (Throwable unused) {
                                this.state.set(2);
                                throw th;
                            }
                        }
                        this.state.set(0);
                        if (this.tasks.peek() == null || !this.state.compareAndSet(0, 2)) {
                            return;
                        }
                        throw th;
                    }
                }
                if (i4 == this.maxTaskExecutePerRun) {
                    try {
                        this.state.set(1);
                        this.executor.execute(this);
                        return;
                    } catch (Throwable unused2) {
                        this.state.set(2);
                    }
                } else {
                    this.state.set(0);
                    if (this.tasks.peek() == null || !this.state.compareAndSet(0, 2)) {
                        return;
                    }
                }
            }
        }

        @Override // io.netty.util.concurrent.AbstractEventExecutor, java.util.concurrent.ExecutorService, io.netty.util.concurrent.EventExecutorGroup
        public void shutdown() {
            this.executor.shutdown();
        }

        @Override // io.netty.util.concurrent.EventExecutorGroup
        public Future<?> shutdownGracefully(long j4, long j5, TimeUnit timeUnit) {
            return this.executor.shutdownGracefully(j4, j5, timeUnit);
        }

        @Override // io.netty.util.concurrent.EventExecutorGroup
        public Future<?> terminationFuture() {
            return this.executor.terminationFuture();
        }
    }

    public NonStickyEventExecutorGroup(EventExecutorGroup eventExecutorGroup) {
        this(eventExecutorGroup, 1024);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public NonStickyOrderedEventExecutor newExecutor(EventExecutor eventExecutor) {
        return new NonStickyOrderedEventExecutor(eventExecutor, this.maxTaskExecutePerRun);
    }

    private static EventExecutorGroup verify(EventExecutorGroup eventExecutorGroup) {
        for (EventExecutor eventExecutor : (EventExecutorGroup) ObjectUtil.checkNotNull(eventExecutorGroup, "group")) {
            if (eventExecutor instanceof OrderedEventExecutor) {
                throw new IllegalArgumentException("EventExecutorGroup " + eventExecutorGroup + " contains OrderedEventExecutors: " + eventExecutor);
            }
        }
        return eventExecutorGroup;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j4, TimeUnit timeUnit) throws InterruptedException {
        return this.group.awaitTermination(j4, timeUnit);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.group.execute(runnable);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> List<java.util.concurrent.Future<T>> invokeAll(Collection<? extends Callable<T>> collection) throws InterruptedException {
        return this.group.invokeAll(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> T invokeAny(Collection<? extends Callable<T>> collection) throws InterruptedException, ExecutionException {
        return (T) this.group.invokeAny(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        return this.group.isShutdown();
    }

    @Override // io.netty.util.concurrent.EventExecutorGroup
    public boolean isShuttingDown() {
        return this.group.isShuttingDown();
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        return this.group.isTerminated();
    }

    @Override // io.netty.util.concurrent.EventExecutorGroup, java.lang.Iterable
    public Iterator<EventExecutor> iterator() {
        final Iterator<EventExecutor> it = this.group.iterator();
        return new Iterator<EventExecutor>() { // from class: io.netty.util.concurrent.NonStickyEventExecutorGroup.1
            @Override // java.util.Iterator
            public boolean hasNext() {
                return it.hasNext();
            }

            @Override // java.util.Iterator
            public void remove() {
                it.remove();
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.Iterator
            public EventExecutor next() {
                return NonStickyEventExecutorGroup.this.newExecutor((EventExecutor) it.next());
            }
        };
    }

    @Override // io.netty.util.concurrent.EventExecutorGroup, io.netty.channel.EventLoopGroup
    public EventExecutor next() {
        return newExecutor(this.group.next());
    }

    @Override // io.netty.util.concurrent.EventExecutorGroup, java.util.concurrent.ExecutorService
    public void shutdown() {
        this.group.shutdown();
    }

    @Override // io.netty.util.concurrent.EventExecutorGroup
    public Future<?> shutdownGracefully() {
        return this.group.shutdownGracefully();
    }

    @Override // io.netty.util.concurrent.EventExecutorGroup
    public List<Runnable> shutdownNow() {
        return this.group.shutdownNow();
    }

    @Override // io.netty.util.concurrent.EventExecutorGroup
    public Future<?> terminationFuture() {
        return this.group.terminationFuture();
    }

    public NonStickyEventExecutorGroup(EventExecutorGroup eventExecutorGroup, int i4) {
        this.group = verify(eventExecutorGroup);
        this.maxTaskExecutePerRun = ObjectUtil.checkPositive(i4, "maxTaskExecutePerRun");
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> List<java.util.concurrent.Future<T>> invokeAll(Collection<? extends Callable<T>> collection, long j4, TimeUnit timeUnit) throws InterruptedException {
        return this.group.invokeAll(collection, j4, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> T invokeAny(Collection<? extends Callable<T>> collection, long j4, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return (T) this.group.invokeAny(collection, j4, timeUnit);
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture<?> scheduleAtFixedRate(Runnable runnable, long j4, long j5, TimeUnit timeUnit) {
        return this.group.scheduleAtFixedRate(runnable, j4, j5, timeUnit);
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture<?> scheduleWithFixedDelay(Runnable runnable, long j4, long j5, TimeUnit timeUnit) {
        return this.group.scheduleWithFixedDelay(runnable, j4, j5, timeUnit);
    }

    @Override // io.netty.util.concurrent.EventExecutorGroup
    public Future<?> shutdownGracefully(long j4, long j5, TimeUnit timeUnit) {
        return this.group.shutdownGracefully(j4, j5, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    public /* bridge */ /* synthetic */ java.util.concurrent.Future submit(Runnable runnable, Object obj) {
        return submit(runnable, (Runnable) obj);
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture<?> schedule(Runnable runnable, long j4, TimeUnit timeUnit) {
        return this.group.schedule(runnable, j4, timeUnit);
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public <V> ScheduledFuture<V> schedule(Callable<V> callable, long j4, TimeUnit timeUnit) {
        return this.group.schedule((Callable) callable, j4, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    public Future<?> submit(Runnable runnable) {
        return this.group.submit(runnable);
    }

    @Override // io.netty.util.concurrent.EventExecutorGroup, java.util.concurrent.ExecutorService
    public <T> Future<T> submit(Runnable runnable, T t3) {
        return this.group.submit(runnable, (Runnable) t3);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> Future<T> submit(Callable<T> callable) {
        return this.group.submit((Callable) callable);
    }
}
