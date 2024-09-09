package io.netty.util.concurrent;

import io.netty.util.concurrent.EventExecutorChooserFactory;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class MultithreadEventExecutorGroup extends AbstractEventExecutorGroup {
    private final EventExecutor[] children;
    private final EventExecutorChooserFactory.EventExecutorChooser chooser;
    private final Set<EventExecutor> readonlyChildren;
    private final AtomicInteger terminatedChildren;
    private final Promise<?> terminationFuture;

    /* JADX INFO: Access modifiers changed from: protected */
    public MultithreadEventExecutorGroup(int i4, ThreadFactory threadFactory, Object... objArr) {
        this(i4, threadFactory == null ? null : new ThreadPerTaskExecutor(threadFactory), objArr);
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j4, TimeUnit timeUnit) throws InterruptedException {
        EventExecutor[] eventExecutorArr;
        long nanoTime;
        long nanoTime2 = System.nanoTime() + timeUnit.toNanos(j4);
        loop0: for (EventExecutor eventExecutor : this.children) {
            do {
                nanoTime = nanoTime2 - System.nanoTime();
                if (nanoTime <= 0) {
                    break loop0;
                }
            } while (!eventExecutor.awaitTermination(nanoTime, TimeUnit.NANOSECONDS));
        }
        return isTerminated();
    }

    public final int executorCount() {
        return this.children.length;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        for (EventExecutor eventExecutor : this.children) {
            if (!eventExecutor.isShutdown()) {
                return false;
            }
        }
        return true;
    }

    @Override // io.netty.util.concurrent.EventExecutorGroup
    public boolean isShuttingDown() {
        for (EventExecutor eventExecutor : this.children) {
            if (!eventExecutor.isShuttingDown()) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        for (EventExecutor eventExecutor : this.children) {
            if (!eventExecutor.isTerminated()) {
                return false;
            }
        }
        return true;
    }

    @Override // io.netty.util.concurrent.EventExecutorGroup, java.lang.Iterable
    public Iterator<EventExecutor> iterator() {
        return this.readonlyChildren.iterator();
    }

    protected abstract EventExecutor newChild(Executor executor, Object... objArr) throws Exception;

    protected ThreadFactory newDefaultThreadFactory() {
        return new DefaultThreadFactory(getClass());
    }

    @Override // io.netty.util.concurrent.EventExecutorGroup, io.netty.channel.EventLoopGroup
    public EventExecutor next() {
        return this.chooser.next();
    }

    @Override // io.netty.util.concurrent.AbstractEventExecutorGroup, io.netty.util.concurrent.EventExecutorGroup, java.util.concurrent.ExecutorService
    @Deprecated
    public void shutdown() {
        for (EventExecutor eventExecutor : this.children) {
            eventExecutor.shutdown();
        }
    }

    @Override // io.netty.util.concurrent.EventExecutorGroup
    public Future<?> shutdownGracefully(long j4, long j5, TimeUnit timeUnit) {
        for (EventExecutor eventExecutor : this.children) {
            eventExecutor.shutdownGracefully(j4, j5, timeUnit);
        }
        return terminationFuture();
    }

    @Override // io.netty.util.concurrent.EventExecutorGroup
    public Future<?> terminationFuture() {
        return this.terminationFuture;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public MultithreadEventExecutorGroup(int i4, Executor executor, Object... objArr) {
        this(i4, executor, DefaultEventExecutorChooserFactory.INSTANCE, objArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public MultithreadEventExecutorGroup(int i4, Executor executor, EventExecutorChooserFactory eventExecutorChooserFactory, Object... objArr) {
        this.terminatedChildren = new AtomicInteger();
        this.terminationFuture = new DefaultPromise(GlobalEventExecutor.INSTANCE);
        int i5 = 0;
        if (i4 > 0) {
            executor = executor == null ? new ThreadPerTaskExecutor(newDefaultThreadFactory()) : executor;
            this.children = new EventExecutor[i4];
            for (int i6 = 0; i6 < i4; i6++) {
                try {
                    try {
                        this.children[i6] = newChild(executor, objArr);
                    } catch (Exception e4) {
                        throw new IllegalStateException("failed to create a child event loop", e4);
                    }
                } catch (Throwable th) {
                    for (int i7 = 0; i7 < i6; i7++) {
                        this.children[i7].shutdownGracefully();
                    }
                    while (i5 < i6) {
                        EventExecutor eventExecutor = this.children[i5];
                        while (!eventExecutor.isTerminated()) {
                            try {
                                eventExecutor.awaitTermination(2147483647L, TimeUnit.SECONDS);
                            } catch (InterruptedException unused) {
                                Thread.currentThread().interrupt();
                                throw th;
                            }
                        }
                        i5++;
                    }
                    throw th;
                }
            }
            this.chooser = eventExecutorChooserFactory.newChooser(this.children);
            FutureListener<Object> futureListener = new FutureListener<Object>() { // from class: io.netty.util.concurrent.MultithreadEventExecutorGroup.1
                @Override // io.netty.util.concurrent.GenericFutureListener
                public void operationComplete(Future<Object> future) throws Exception {
                    if (MultithreadEventExecutorGroup.this.terminatedChildren.incrementAndGet() == MultithreadEventExecutorGroup.this.children.length) {
                        MultithreadEventExecutorGroup.this.terminationFuture.setSuccess(null);
                    }
                }
            };
            EventExecutor[] eventExecutorArr = this.children;
            int length = eventExecutorArr.length;
            while (i5 < length) {
                eventExecutorArr[i5].terminationFuture().addListener(futureListener);
                i5++;
            }
            LinkedHashSet linkedHashSet = new LinkedHashSet(this.children.length);
            Collections.addAll(linkedHashSet, this.children);
            this.readonlyChildren = Collections.unmodifiableSet(linkedHashSet);
            return;
        }
        throw new IllegalArgumentException(String.format("nThreads: %d (expected: > 0)", Integer.valueOf(i4)));
    }
}
