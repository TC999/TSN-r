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

/* loaded from: E:\fuckcool\tsn\5406560.dex */
public abstract class MultithreadEventExecutorGroup extends AbstractEventExecutorGroup {
    private final EventExecutor[] children;
    private final EventExecutorChooserFactory.EventExecutorChooser chooser;
    private final Set<EventExecutor> readonlyChildren;
    private final AtomicInteger terminatedChildren;
    private final Promise<?> terminationFuture;

    /* JADX INFO: Access modifiers changed from: protected */
    public MultithreadEventExecutorGroup(int i, ThreadFactory threadFactory, Object... objArr) {
        this(i, threadFactory == null ? null : new ThreadPerTaskExecutor(threadFactory), objArr);
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j, TimeUnit timeUnit) throws InterruptedException {
        EventExecutor[] eventExecutorArr;
        long nanoTime;
        long nanoTime2 = System.nanoTime() + timeUnit.toNanos(j);
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
    public Future<?> shutdownGracefully(long j, long j2, TimeUnit timeUnit) {
        for (EventExecutor eventExecutor : this.children) {
            eventExecutor.shutdownGracefully(j, j2, timeUnit);
        }
        return terminationFuture();
    }

    @Override // io.netty.util.concurrent.EventExecutorGroup
    public Future<?> terminationFuture() {
        return this.terminationFuture;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public MultithreadEventExecutorGroup(int i, Executor executor, Object... objArr) {
        this(i, executor, DefaultEventExecutorChooserFactory.INSTANCE, objArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public MultithreadEventExecutorGroup(int i, Executor executor, EventExecutorChooserFactory eventExecutorChooserFactory, Object... objArr) {
        this.terminatedChildren = new AtomicInteger();
        this.terminationFuture = new DefaultPromise(GlobalEventExecutor.INSTANCE);
        int i2 = 0;
        if (i > 0) {
            executor = executor == null ? new ThreadPerTaskExecutor(newDefaultThreadFactory()) : executor;
            this.children = new EventExecutor[i];
            for (int i3 = 0; i3 < i; i3++) {
                try {
                    try {
                        this.children[i3] = newChild(executor, objArr);
                    } catch (Exception e) {
                        throw new IllegalStateException("failed to create a child event loop", e);
                    }
                } catch (Throwable th) {
                    for (int i4 = 0; i4 < i3; i4++) {
                        this.children[i4].shutdownGracefully();
                    }
                    while (i2 < i3) {
                        EventExecutor eventExecutor = this.children[i2];
                        while (!eventExecutor.isTerminated()) {
                            try {
                                eventExecutor.awaitTermination(2147483647L, TimeUnit.SECONDS);
                            } catch (InterruptedException unused) {
                                Thread.currentThread().interrupt();
                                throw th;
                            }
                        }
                        i2++;
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
            while (i2 < length) {
                eventExecutorArr[i2].terminationFuture().addListener(futureListener);
                i2++;
            }
            LinkedHashSet linkedHashSet = new LinkedHashSet(this.children.length);
            Collections.addAll(linkedHashSet, this.children);
            this.readonlyChildren = Collections.unmodifiableSet(linkedHashSet);
            return;
        }
        throw new IllegalArgumentException(String.format("nThreads: %d (expected: > 0)", Integer.valueOf(i)));
    }
}
