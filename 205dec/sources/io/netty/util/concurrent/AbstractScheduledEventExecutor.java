package io.netty.util.concurrent;

import io.netty.util.internal.DefaultPriorityQueue;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PriorityQueue;
import java.util.Comparator;
import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.Delayed;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class AbstractScheduledEventExecutor extends AbstractEventExecutor {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Comparator<ScheduledFutureTask<?>> SCHEDULED_FUTURE_TASK_COMPARATOR = new Comparator<ScheduledFutureTask<?>>() { // from class: io.netty.util.concurrent.AbstractScheduledEventExecutor.1
        @Override // java.util.Comparator
        public int compare(ScheduledFutureTask<?> scheduledFutureTask, ScheduledFutureTask<?> scheduledFutureTask2) {
            return scheduledFutureTask.compareTo((Delayed) scheduledFutureTask2);
        }
    };
    PriorityQueue<ScheduledFutureTask<?>> scheduledTaskQueue;

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

    private void validateScheduled0(long j4, TimeUnit timeUnit) {
        validateScheduled(j4, timeUnit);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cancelScheduledTasks() {
        PriorityQueue<ScheduledFutureTask<?>> priorityQueue = this.scheduledTaskQueue;
        if (isNullOrEmpty(priorityQueue)) {
            return;
        }
        for (ScheduledFutureTask scheduledFutureTask : (ScheduledFutureTask[]) priorityQueue.toArray(new ScheduledFutureTask[0])) {
            scheduledFutureTask.cancelWithoutRemove(false);
        }
        priorityQueue.clearIgnoringIndexes();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean hasScheduledTasks() {
        PriorityQueue<ScheduledFutureTask<?>> priorityQueue = this.scheduledTaskQueue;
        ScheduledFutureTask<?> peek = priorityQueue == null ? null : priorityQueue.peek();
        return peek != null && peek.deadlineNanos() <= nanoTime();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long nextScheduledTaskNano() {
        PriorityQueue<ScheduledFutureTask<?>> priorityQueue = this.scheduledTaskQueue;
        ScheduledFutureTask<?> peek = priorityQueue == null ? null : priorityQueue.peek();
        if (peek == null) {
            return -1L;
        }
        return Math.max(0L, peek.deadlineNanos() - nanoTime());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final ScheduledFutureTask<?> peekScheduledTask() {
        PriorityQueue<ScheduledFutureTask<?>> priorityQueue = this.scheduledTaskQueue;
        if (priorityQueue == null) {
            return null;
        }
        return priorityQueue.peek();
    }

    protected final Runnable pollScheduledTask() {
        return pollScheduledTask(nanoTime());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void removeScheduled(final ScheduledFutureTask<?> scheduledFutureTask) {
        if (inEventLoop()) {
            scheduledTaskQueue().removeTyped(scheduledFutureTask);
        } else {
            execute(new Runnable() { // from class: io.netty.util.concurrent.AbstractScheduledEventExecutor.3
                @Override // java.lang.Runnable
                public void run() {
                    AbstractScheduledEventExecutor.this.removeScheduled(scheduledFutureTask);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PriorityQueue<ScheduledFutureTask<?>> scheduledTaskQueue() {
        if (this.scheduledTaskQueue == null) {
            this.scheduledTaskQueue = new DefaultPriorityQueue(SCHEDULED_FUTURE_TASK_COMPARATOR, 11);
        }
        return this.scheduledTaskQueue;
    }

    @Deprecated
    protected void validateScheduled(long j4, TimeUnit timeUnit) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractScheduledEventExecutor(EventExecutorGroup eventExecutorGroup) {
        super(eventExecutorGroup);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Runnable pollScheduledTask(long j4) {
        PriorityQueue<ScheduledFutureTask<?>> priorityQueue = this.scheduledTaskQueue;
        ScheduledFutureTask<?> peek = priorityQueue == null ? null : priorityQueue.peek();
        if (peek != null && peek.deadlineNanos() <= j4) {
            priorityQueue.remove();
            return peek;
        }
        return null;
    }

    @Override // io.netty.util.concurrent.AbstractEventExecutor, java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture<?> scheduleAtFixedRate(Runnable runnable, long j4, long j5, TimeUnit timeUnit) {
        ObjectUtil.checkNotNull(runnable, "command");
        ObjectUtil.checkNotNull(timeUnit, "unit");
        if (j4 >= 0) {
            if (j5 > 0) {
                validateScheduled0(j4, timeUnit);
                validateScheduled0(j5, timeUnit);
                return schedule(new ScheduledFutureTask(this, Executors.callable(runnable, null), ScheduledFutureTask.deadlineNanos(timeUnit.toNanos(j4)), timeUnit.toNanos(j5)));
            }
            throw new IllegalArgumentException(String.format("period: %d (expected: > 0)", Long.valueOf(j5)));
        }
        throw new IllegalArgumentException(String.format("initialDelay: %d (expected: >= 0)", Long.valueOf(j4)));
    }

    @Override // io.netty.util.concurrent.AbstractEventExecutor, java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture<?> scheduleWithFixedDelay(Runnable runnable, long j4, long j5, TimeUnit timeUnit) {
        ObjectUtil.checkNotNull(runnable, "command");
        ObjectUtil.checkNotNull(timeUnit, "unit");
        if (j4 >= 0) {
            if (j5 > 0) {
                validateScheduled0(j4, timeUnit);
                validateScheduled0(j5, timeUnit);
                return schedule(new ScheduledFutureTask(this, Executors.callable(runnable, null), ScheduledFutureTask.deadlineNanos(timeUnit.toNanos(j4)), -timeUnit.toNanos(j5)));
            }
            throw new IllegalArgumentException(String.format("delay: %d (expected: > 0)", Long.valueOf(j5)));
        }
        throw new IllegalArgumentException(String.format("initialDelay: %d (expected: >= 0)", Long.valueOf(j4)));
    }

    @Override // io.netty.util.concurrent.AbstractEventExecutor, java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture<?> schedule(Runnable runnable, long j4, TimeUnit timeUnit) {
        ObjectUtil.checkNotNull(runnable, "command");
        ObjectUtil.checkNotNull(timeUnit, "unit");
        if (j4 < 0) {
            j4 = 0;
        }
        validateScheduled0(j4, timeUnit);
        return schedule(new ScheduledFutureTask(this, runnable, (Object) null, ScheduledFutureTask.deadlineNanos(timeUnit.toNanos(j4))));
    }

    @Override // io.netty.util.concurrent.AbstractEventExecutor, java.util.concurrent.ScheduledExecutorService
    public <V> ScheduledFuture<V> schedule(Callable<V> callable, long j4, TimeUnit timeUnit) {
        ObjectUtil.checkNotNull(callable, "callable");
        ObjectUtil.checkNotNull(timeUnit, "unit");
        if (j4 < 0) {
            j4 = 0;
        }
        validateScheduled0(j4, timeUnit);
        return schedule(new ScheduledFutureTask<>(this, callable, ScheduledFutureTask.deadlineNanos(timeUnit.toNanos(j4))));
    }

    <V> ScheduledFuture<V> schedule(final ScheduledFutureTask<V> scheduledFutureTask) {
        if (inEventLoop()) {
            scheduledTaskQueue().add(scheduledFutureTask);
        } else {
            execute(new Runnable() { // from class: io.netty.util.concurrent.AbstractScheduledEventExecutor.2
                @Override // java.lang.Runnable
                public void run() {
                    AbstractScheduledEventExecutor.this.scheduledTaskQueue().add(scheduledFutureTask);
                }
            });
        }
        return scheduledFutureTask;
    }
}
