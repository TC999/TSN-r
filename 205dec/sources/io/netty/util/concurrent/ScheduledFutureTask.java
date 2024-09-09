package io.netty.util.concurrent;

import io.netty.util.internal.DefaultPriorityQueue;
import io.netty.util.internal.PriorityQueueNode;
import java.util.concurrent.Callable;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class ScheduledFutureTask<V> extends PromiseTask<V> implements ScheduledFuture<V>, PriorityQueueNode {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private long deadlineNanos;
    private final long id;
    private final long periodNanos;
    private int queueIndex;
    private static final AtomicLong nextTaskId = new AtomicLong();
    private static final long START_TIME = System.nanoTime();

    /* JADX INFO: Access modifiers changed from: package-private */
    public ScheduledFutureTask(AbstractScheduledEventExecutor abstractScheduledEventExecutor, Runnable runnable, V v3, long j4) {
        this(abstractScheduledEventExecutor, PromiseTask.toCallable(runnable, v3), j4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long deadlineNanos(long j4) {
        long nanoTime = nanoTime() + j4;
        if (nanoTime < 0) {
            return Long.MAX_VALUE;
        }
        return nanoTime;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long nanoTime() {
        return System.nanoTime() - START_TIME;
    }

    @Override // io.netty.util.concurrent.DefaultPromise, io.netty.util.concurrent.Future, java.util.concurrent.Future
    public boolean cancel(boolean z3) {
        boolean cancel = super.cancel(z3);
        if (cancel) {
            ((AbstractScheduledEventExecutor) executor()).removeScheduled(this);
        }
        return cancel;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean cancelWithoutRemove(boolean z3) {
        return super.cancel(z3);
    }

    public long delayNanos() {
        return Math.max(0L, deadlineNanos() - nanoTime());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.util.concurrent.DefaultPromise
    public EventExecutor executor() {
        return super.executor();
    }

    @Override // java.util.concurrent.Delayed
    public long getDelay(TimeUnit timeUnit) {
        return timeUnit.convert(delayNanos(), TimeUnit.NANOSECONDS);
    }

    @Override // io.netty.util.internal.PriorityQueueNode
    public int priorityQueueIndex(DefaultPriorityQueue<?> defaultPriorityQueue) {
        return this.queueIndex;
    }

    @Override // io.netty.util.concurrent.PromiseTask, java.util.concurrent.RunnableFuture, java.lang.Runnable
    public void run() {
        try {
            if (this.periodNanos == 0) {
                if (setUncancellableInternal()) {
                    setSuccessInternal(this.task.call());
                }
            } else if (isCancelled()) {
            } else {
                this.task.call();
                if (executor().isShutdown()) {
                    return;
                }
                long j4 = this.periodNanos;
                if (j4 > 0) {
                    this.deadlineNanos += j4;
                } else {
                    this.deadlineNanos = nanoTime() - j4;
                }
                if (isCancelled()) {
                    return;
                }
                ((AbstractScheduledEventExecutor) executor()).scheduledTaskQueue.add(this);
            }
        } catch (Throwable th) {
            setFailureInternal(th);
        }
    }

    @Override // io.netty.util.concurrent.PromiseTask, io.netty.util.concurrent.DefaultPromise
    protected StringBuilder toStringBuilder() {
        StringBuilder stringBuilder = super.toStringBuilder();
        stringBuilder.setCharAt(stringBuilder.length() - 1, ',');
        stringBuilder.append(" id: ");
        stringBuilder.append(this.id);
        stringBuilder.append(", deadline: ");
        stringBuilder.append(this.deadlineNanos);
        stringBuilder.append(", period: ");
        stringBuilder.append(this.periodNanos);
        stringBuilder.append(')');
        return stringBuilder;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ScheduledFutureTask(AbstractScheduledEventExecutor abstractScheduledEventExecutor, Callable<V> callable, long j4, long j5) {
        super(abstractScheduledEventExecutor, callable);
        this.id = nextTaskId.getAndIncrement();
        this.queueIndex = -1;
        if (j5 != 0) {
            this.deadlineNanos = j4;
            this.periodNanos = j5;
            return;
        }
        throw new IllegalArgumentException("period: 0 (expected: != 0)");
    }

    @Override // java.lang.Comparable
    public int compareTo(Delayed delayed) {
        if (this == delayed) {
            return 0;
        }
        ScheduledFutureTask scheduledFutureTask = (ScheduledFutureTask) delayed;
        long deadlineNanos = deadlineNanos() - scheduledFutureTask.deadlineNanos();
        if (deadlineNanos < 0) {
            return -1;
        }
        if (deadlineNanos > 0) {
            return 1;
        }
        long j4 = this.id;
        long j5 = scheduledFutureTask.id;
        if (j4 < j5) {
            return -1;
        }
        if (j4 != j5) {
            return 1;
        }
        throw new Error();
    }

    public long deadlineNanos() {
        return this.deadlineNanos;
    }

    public long delayNanos(long j4) {
        return Math.max(0L, deadlineNanos() - (j4 - START_TIME));
    }

    @Override // io.netty.util.internal.PriorityQueueNode
    public void priorityQueueIndex(DefaultPriorityQueue<?> defaultPriorityQueue, int i4) {
        this.queueIndex = i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ScheduledFutureTask(AbstractScheduledEventExecutor abstractScheduledEventExecutor, Callable<V> callable, long j4) {
        super(abstractScheduledEventExecutor, callable);
        this.id = nextTaskId.getAndIncrement();
        this.queueIndex = -1;
        this.deadlineNanos = j4;
        this.periodNanos = 0L;
    }
}
