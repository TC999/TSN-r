package io.netty.util.concurrent;

import io.netty.util.internal.ObjectUtil;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/* loaded from: E:\fuckcool\tsn\5406560.dex */
public abstract class AbstractScheduledEventExecutor extends AbstractEventExecutor {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    Queue<ScheduledFutureTask<?>> scheduledTaskQueue;

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractScheduledEventExecutor() {
    }

    private static boolean isNullOrEmpty(Queue<ScheduledFutureTask<?>> queue) {
        return queue == null || queue.isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static long nanoTime() {
        return ScheduledFutureTask.nanoTime();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cancelScheduledTasks() {
        Queue<ScheduledFutureTask<?>> queue = this.scheduledTaskQueue;
        if (isNullOrEmpty(queue)) {
            return;
        }
        for (ScheduledFutureTask scheduledFutureTask : (ScheduledFutureTask[]) queue.toArray(new ScheduledFutureTask[queue.size()])) {
            scheduledFutureTask.cancelWithoutRemove(false);
        }
        queue.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean hasScheduledTasks() {
        Queue<ScheduledFutureTask<?>> queue = this.scheduledTaskQueue;
        ScheduledFutureTask<?> peek = queue == null ? null : queue.peek();
        return peek != null && peek.deadlineNanos() <= nanoTime();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long nextScheduledTaskNano() {
        Queue<ScheduledFutureTask<?>> queue = this.scheduledTaskQueue;
        ScheduledFutureTask<?> peek = queue == null ? null : queue.peek();
        if (peek == null) {
            return -1L;
        }
        return Math.max(0L, peek.deadlineNanos() - nanoTime());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final ScheduledFutureTask<?> peekScheduledTask() {
        Queue<ScheduledFutureTask<?>> queue = this.scheduledTaskQueue;
        if (queue == null) {
            return null;
        }
        return queue.peek();
    }

    protected final Runnable pollScheduledTask() {
        return pollScheduledTask(nanoTime());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void removeScheduled(final ScheduledFutureTask<?> scheduledFutureTask) {
        if (inEventLoop()) {
            scheduledTaskQueue().remove(scheduledFutureTask);
        } else {
            execute(new Runnable() { // from class: io.netty.util.concurrent.AbstractScheduledEventExecutor.2
                @Override // java.lang.Runnable
                public void run() {
                    AbstractScheduledEventExecutor.this.removeScheduled(scheduledFutureTask);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Queue<ScheduledFutureTask<?>> scheduledTaskQueue() {
        if (this.scheduledTaskQueue == null) {
            this.scheduledTaskQueue = new PriorityQueue();
        }
        return this.scheduledTaskQueue;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractScheduledEventExecutor(EventExecutorGroup eventExecutorGroup) {
        super(eventExecutorGroup);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Runnable pollScheduledTask(long j) {
        Queue<ScheduledFutureTask<?>> queue = this.scheduledTaskQueue;
        ScheduledFutureTask<?> peek = queue == null ? null : queue.peek();
        if (peek != null && peek.deadlineNanos() <= j) {
            queue.remove();
            return peek;
        }
        return null;
    }

    @Override // io.netty.util.concurrent.AbstractEventExecutor, java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture<?> scheduleAtFixedRate(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        ObjectUtil.checkNotNull(runnable, "command");
        ObjectUtil.checkNotNull(timeUnit, "unit");
        if (j >= 0) {
            if (j2 > 0) {
                return schedule(new ScheduledFutureTask(this, Executors.callable(runnable, null), ScheduledFutureTask.deadlineNanos(timeUnit.toNanos(j)), timeUnit.toNanos(j2)));
            }
            throw new IllegalArgumentException(String.format("period: %d (expected: > 0)", Long.valueOf(j2)));
        }
        throw new IllegalArgumentException(String.format("initialDelay: %d (expected: >= 0)", Long.valueOf(j)));
    }

    @Override // io.netty.util.concurrent.AbstractEventExecutor, java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture<?> scheduleWithFixedDelay(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        ObjectUtil.checkNotNull(runnable, "command");
        ObjectUtil.checkNotNull(timeUnit, "unit");
        if (j >= 0) {
            if (j2 > 0) {
                return schedule(new ScheduledFutureTask(this, Executors.callable(runnable, null), ScheduledFutureTask.deadlineNanos(timeUnit.toNanos(j)), -timeUnit.toNanos(j2)));
            }
            throw new IllegalArgumentException(String.format("delay: %d (expected: > 0)", Long.valueOf(j2)));
        }
        throw new IllegalArgumentException(String.format("initialDelay: %d (expected: >= 0)", Long.valueOf(j)));
    }

    @Override // io.netty.util.concurrent.AbstractEventExecutor, java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture<?> schedule(Runnable runnable, long j, TimeUnit timeUnit) {
        ObjectUtil.checkNotNull(runnable, "command");
        ObjectUtil.checkNotNull(timeUnit, "unit");
        if (j >= 0) {
            return schedule(new ScheduledFutureTask(this, runnable, (Object) null, ScheduledFutureTask.deadlineNanos(timeUnit.toNanos(j))));
        }
        throw new IllegalArgumentException(String.format("delay: %d (expected: >= 0)", Long.valueOf(j)));
    }

    @Override // io.netty.util.concurrent.AbstractEventExecutor, java.util.concurrent.ScheduledExecutorService
    public <V> ScheduledFuture<V> schedule(Callable<V> callable, long j, TimeUnit timeUnit) {
        ObjectUtil.checkNotNull(callable, "callable");
        ObjectUtil.checkNotNull(timeUnit, "unit");
        if (j >= 0) {
            return schedule(new ScheduledFutureTask<>(this, callable, ScheduledFutureTask.deadlineNanos(timeUnit.toNanos(j))));
        }
        throw new IllegalArgumentException(String.format("delay: %d (expected: >= 0)", Long.valueOf(j)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    <V> ScheduledFuture<V> schedule(final ScheduledFutureTask<V> scheduledFutureTask) {
        if (inEventLoop()) {
            scheduledTaskQueue().add(scheduledFutureTask);
        } else {
            execute(new Runnable() { // from class: io.netty.util.concurrent.AbstractScheduledEventExecutor.1
                @Override // java.lang.Runnable
                public void run() {
                    AbstractScheduledEventExecutor.this.scheduledTaskQueue().add(scheduledFutureTask);
                }
            });
        }
        return scheduledFutureTask;
    }
}
